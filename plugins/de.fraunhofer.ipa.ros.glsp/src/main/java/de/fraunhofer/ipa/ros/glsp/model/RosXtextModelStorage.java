package de.fraunhofer.ipa.ros.glsp.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.inject.Inject;
import de.fraunhofer.ipa.ros.ide.BasicsIdeSetup;
import de.fraunhofer.ipa.ros.ide.RosIdeSetup;
import de.fraunhofer.ipa.ros1.ide.Ros1IdeSetup;
import de.fraunhofer.ipa.ros2.ide.Ros2IdeSetup;
import de.fraunhofer.ipa.rossystem.ide.RosSystemIdeSetup;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Stream;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.glsp.graph.GPoint;
import org.eclipse.glsp.graph.util.GraphUtil;
import org.eclipse.glsp.server.actions.SaveModelAction;
import org.eclipse.glsp.server.emf.EMFSourceModelStorage;
import org.eclipse.glsp.server.features.core.model.RequestModelAction;
import org.eclipse.glsp.server.types.GLSPServerException;
import org.eclipse.glsp.server.utils.ClientOptionsUtil;
import org.eclipse.xtext.resource.SaveOptions;
import primitives.PrimitivesPackage;
import ros.RosPackage;
import system.RossystemPackage;

/**
 * Xtext-backed EMFSourceModelStorage for RosTooling (.rossystem, .ros2, .ros1, .ros).
 * Loads models into an XtextResourceSet with companion cross-reference resolution and
 * saves modifications via Xtext's node-model-aware ISerializer so comments are preserved.
 */
public class RosXtextModelStorage extends EMFSourceModelStorage {

    private static final AtomicBoolean INITIALIZED = new AtomicBoolean(false);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    @Inject
    protected RosModelState rosModelState;

    public static synchronized void ensureXtextInitialized() {
        if (INITIALIZED.compareAndSet(false, true)) {
            EcorePackage.eINSTANCE.eClass();
            if (!EPackage.Registry.INSTANCE.containsKey(PrimitivesPackage.eNS_URI)) {
                EPackage.Registry.INSTANCE.put(PrimitivesPackage.eNS_URI, PrimitivesPackage.eINSTANCE);
            }
            if (!EPackage.Registry.INSTANCE.containsKey(RosPackage.eNS_URI)) {
                EPackage.Registry.INSTANCE.put(RosPackage.eNS_URI, RosPackage.eINSTANCE);
            }
            if (!EPackage.Registry.INSTANCE.containsKey(RossystemPackage.eNS_URI)) {
                EPackage.Registry.INSTANCE.put(RossystemPackage.eNS_URI, RossystemPackage.eINSTANCE);
            }
            new BasicsIdeSetup().createInjectorAndDoEMFRegistration();
            new RosIdeSetup().createInjectorAndDoEMFRegistration();
            new Ros1IdeSetup().createInjectorAndDoEMFRegistration();
            new Ros2IdeSetup().createInjectorAndDoEMFRegistration();
            new RosSystemIdeSetup().createInjectorAndDoEMFRegistration();
        }
    }

    @Override
    protected ResourceSet setupResourceSet(final ResourceSet resourceSet) {
        ensureXtextInitialized();
        // Do NOT call super.setupResourceSet(resourceSet) because EMFSourceModelStorage
        // registers UUIDXMIResourceFactory for "*", which would shadow Xtext's IResourceFactory.
        return resourceSet;
    }

    @Override
    public void loadSourceModel(final RequestModelAction action) {
        ensureXtextInitialized();
        String rawUri = ClientOptionsUtil.getSourceUri(action.getOptions())
                .orElseThrow(() -> new GLSPServerException("No sourceUri option provided in RequestModelAction"));
        URI fileUri = toEmfFileUri(rawUri);
        EditingDomain editingDomain = getOrCreateEditingDomain();
        doLoadSourceModel(editingDomain.getResourceSet(), fileUri, action);
    }

    @Override
    protected void doLoadSourceModel(
            final ResourceSet resourceSet,
            final URI sourceUri,
            final RequestModelAction action) {
        // Every (re)load reads fresh state: external text edits and companion file changes must be
        // visible, and EMF commands recorded against the previous AST can no longer be undone.
        for (Resource stale : new ArrayList<>(resourceSet.getResources())) {
            stale.unload();
        }
        resourceSet.getResources().clear();
        if (getOrCreateEditingDomain().getCommandStack() != null) {
            getOrCreateEditingDomain().getCommandStack().flush();
        }
        rosModelState.clearTextEditState();

        loadCompanionModels(resourceSet, sourceUri, action.getOptions());

        // The editor may hold unsaved text; parse that instead of the on-disk content.
        String sourceText = action.getOptions() != null ? action.getOptions().get("sourceText") : null;
        Resource mainResource;
        if (isNewSystemFile(sourceUri, sourceText)) {
            mainResource = createEmptySystemResource(resourceSet, sourceUri);
        } else if (isNewPackageFile(sourceUri, sourceText)) {
            mainResource = createEmptyPackageResource(resourceSet, sourceUri);
        } else {
            mainResource = resourceSet.getResource(sourceUri, true);
        }
        if (sourceText != null && !sourceText.isBlank()
                && mainResource instanceof org.eclipse.xtext.resource.XtextResource xtextRes) {
            try {
                xtextRes.reparse(sourceText);
                EcoreUtil.resolveAll(resourceSet);
            } catch (IOException e) {
                throw new GLSPServerException("Failed to parse editor text for " + sourceUri, e);
            }
        }
        if (mainResource == null || mainResource.getContents().isEmpty()) {
            throw new GLSPServerException("Failed to load RosTooling model from URI: " + sourceUri);
        }

        // References into the shared catalogue (as the language server sees it), then resolveAll.
        RosCatalogueResolver.resolveFromCatalogue(resourceSet);

        EObject rootObject = mainResource.getContents().get(0);
        rosModelState.setSourceUri(sourceUri);
        rosModelState.setSemanticResource(mainResource);
        rosModelState.setSemanticModel(rootObject);

        loadOptionalLayoutSidecar(sourceUri);
    }

    /** A .rossystem that does not exist yet (or is empty) is created from an empty Ecore System. */
    protected boolean isNewSystemFile(final URI sourceUri, final String sourceText) {
        return "rossystem".equals(sourceUri.fileExtension()) && isBlankSource(sourceUri, sourceText);
    }

    /** A .ros2 / .ros1 / .ros file that does not exist yet (or is empty) starts from an empty Package. */
    protected boolean isNewPackageFile(final URI sourceUri, final String sourceText) {
        String ext = sourceUri.fileExtension();
        return ("ros2".equals(ext) || "ros1".equals(ext) || "ros".equals(ext))
                && isBlankSource(sourceUri, sourceText);
    }

    private static boolean isBlankSource(final URI sourceUri, final String sourceText) {
        if (sourceText != null) {
            return sourceText.isBlank();
        }
        String localPath = sourceUri.toFileString();
        if (localPath == null) {
            return false;
        }
        File file = new File(localPath);
        try {
            return !file.exists() || Files.readString(file.toPath(), StandardCharsets.UTF_8).isBlank();
        } catch (IOException e) {
            return false;
        }
    }

    /**
     * New system: an Xtext resource holding an empty {@code system.System} named after the file.
     * Its text is produced by the serializer on the first save (RosAstNodeModelSerializer).
     */
    protected Resource createEmptySystemResource(final ResourceSet resourceSet, final URI sourceUri) {
        Resource res = resourceSet.createResource(sourceUri);
        system.System sys = system.RossystemFactory.eINSTANCE.createSystem();
        String base = sourceUri.lastSegment() == null ? "system" : sourceUri.trimFileExtension().lastSegment();
        sys.setName(base.replaceAll("[^A-Za-z0-9_]", "_"));
        res.getContents().add(sys);
        return res;
    }

    /**
     * New package model: an Xtext resource holding an empty {@code AmentPackage} (.ros2),
     * {@code CatkinPackage} (.ros1), or {@code PackageSet} (.ros) named after the file.
     */
    protected Resource createEmptyPackageResource(final ResourceSet resourceSet, final URI sourceUri) {
        Resource res = resourceSet.createResource(sourceUri);
        String base = sourceUri.lastSegment() == null ? "ros_pkg" : sourceUri.trimFileExtension().lastSegment();
        String pkgName = base.toLowerCase(Locale.ROOT).replaceAll("[^a-z0-9_]", "_");
        if (pkgName.isBlank()) {
            pkgName = "ros_pkg";
        }
        String ext = sourceUri.fileExtension();
        if ("ros".equals(ext)) {
            ros.PackageSet pkgSet = ros.RosFactory.eINSTANCE.createPackageSet();
            ros.Package pkg = ros.RosFactory.eINSTANCE.createPackage();
            pkg.setName(pkgName);
            pkgSet.getPackage().add(pkg);
            res.getContents().add(pkgSet);
        } else {
            ros.Package pkg = "ros1".equals(ext)
                    ? ros.RosFactory.eINSTANCE.createCatkinPackage()
                    : ros.RosFactory.eINSTANCE.createAmentPackage();
            pkg.setName(pkgName);
            res.getContents().add(pkg);
        }
        return res;
    }

    protected void loadCompanionModels(
            final ResourceSet resourceSet,
            final URI sourceUri,
            final Map<String, String> options) {
        String localPath = sourceUri.toFileString();
        if (localPath == null) {
            return;
        }
        File mainFile = new File(localPath);
        File scanRoot = resolveWorkspaceScanRoot(mainFile, options);
        if (scanRoot == null || !scanRoot.isDirectory()) {
            return;
        }

        List<Path> companionFiles = new ArrayList<>();
        try (Stream<Path> walk = Files.walk(scanRoot.toPath(), 5)) {
            walk.filter(Files::isRegularFile)
                .filter(p -> {
                    String name = p.getFileName().toString();
                    return name.endsWith(".ros")
                        || name.endsWith(".ros1")
                        || name.endsWith(".ros2")
                        || name.endsWith(".rossystem");
                })
                .filter(p -> !p.toFile().equals(mainFile))
                // Load .ros first, then .ros1/.ros2, then .rossystem
                .sorted(Comparator.comparingInt(RosXtextModelStorage::extensionLoadOrder))
                .forEach(companionFiles::add);
        } catch (IOException e) {
            LOGGER.warn("Could not scan companion models under " + scanRoot, e);
        }

        for (Path companion : companionFiles) {
            try {
                URI companionUri = URI.createFileURI(companion.toAbsolutePath().toString());
                resourceSet.getResource(companionUri, true);
            } catch (Exception e) {
                LOGGER.debug("Skipping companion model " + companion + ": " + e.getMessage());
            }
        }
    }

    private static int extensionLoadOrder(final Path path) {
        String name = path.getFileName().toString();
        if (name.endsWith(".ros")) return 0;
        if (name.endsWith(".ros1") || name.endsWith(".ros2")) return 1;
        return 2;
    }

    private File resolveWorkspaceScanRoot(final File mainFile, final Map<String, String> options) {
        if (options != null) {
            String wsRoot = options.get("workspaceRoot");
            if (wsRoot != null && !wsRoot.isBlank()) {
                File explicit = new File(wsRoot);
                if (explicit.isDirectory()) {
                    return explicit;
                }
            }
        }
        File current = mainFile.getParentFile();
        File fallback = current;
        int depth = 0;
        while (current != null && depth < 4) {
            if (new File(current, "package.xml").isFile()
                    || new File(current, "CMakeLists.txt").isFile()
                    || new File(current, ".git").exists()) {
                return current;
            }
            current = current.getParentFile();
            depth++;
        }
        return fallback;
    }

    protected void loadOptionalLayoutSidecar(final URI sourceUri) {
        rosModelState.clearPinnedPositions();
        File sidecar = getLayoutSidecarFile(sourceUri);
        if (sidecar == null || !sidecar.isFile()) {
            return;
        }
        try {
            String content = Files.readString(sidecar.toPath(), StandardCharsets.UTF_8);
            JsonObject root = GSON.fromJson(content, JsonObject.class);
            if (root != null && root.has("nodes") && root.get("nodes").isJsonObject()) {
                JsonObject nodesObj = root.getAsJsonObject("nodes");
                for (Map.Entry<String, JsonElement> entry : nodesObj.entrySet()) {
                    if (entry.getValue().isJsonObject()) {
                        JsonObject pos = entry.getValue().getAsJsonObject();
                        if (pos.has("x") && pos.has("y")) {
                            double x = pos.get("x").getAsDouble();
                            double y = pos.get("y").getAsDouble();
                            rosModelState.setPinnedPosition(entry.getKey(), GraphUtil.point(x, y));
                        }
                    }
                }
            }
        } catch (Exception e) {
            LOGGER.warn("Could not read optional layout sidecar " + sidecar, e);
        }
    }

    public void saveOptionalLayoutSidecar() {
        Map<String, GPoint> pinned = rosModelState.getPinnedPositions();
        if (pinned.isEmpty()) {
            return;
        }
        File sidecar = getLayoutSidecarFile(rosModelState.getSourceUri());
        if (sidecar == null) {
            return;
        }
        try {
            JsonObject root = new JsonObject();
            JsonObject nodesObj = new JsonObject();
            for (Map.Entry<String, GPoint> entry : pinned.entrySet()) {
                JsonObject pt = new JsonObject();
                pt.addProperty("x", Math.round(entry.getValue().getX()));
                pt.addProperty("y", Math.round(entry.getValue().getY()));
                nodesObj.add(entry.getKey(), pt);
            }
            root.add("nodes", nodesObj);
            Files.writeString(sidecar.toPath(), GSON.toJson(root), StandardCharsets.UTF_8);
        } catch (IOException e) {
            LOGGER.warn("Failed to write layout sidecar " + sidecar, e);
        }
    }

    public static File getLayoutSidecarFile(final URI sourceUri) {
        if (sourceUri == null || sourceUri.toFileString() == null) {
            return null;
        }
        return new File(sourceUri.toFileString() + ".layout");
    }

    @Override
    public void saveSourceModel(final SaveModelAction action) {
        Resource resource = rosModelState.getSemanticResource();
        if (resource == null) {
            throw new GLSPServerException("No primary semantic resource loaded to save.");
        }
        URI targetUri = resource.getURI();
        if (action.getFileUri().isPresent() && !action.getFileUri().get().isBlank()) {
            targetUri = toEmfFileUri(action.getFileUri().get());
            resource.setURI(targetUri);
        }
        try {
            if (targetUri != null && targetUri.toFileString() != null) {
                RosAstNodeModelSerializer.saveToFile(rosModelState, Path.of(targetUri.toFileString()));
            } else {
                Map<Object, Object> saveOptions = SaveOptions.newBuilder().getOptions().toOptionsMap();
                resource.save(saveOptions);
            }
            saveOptionalLayoutSidecar();
        } catch (IOException e) {
            LOGGER.error("Could not save RosTooling model to " + targetUri, e);
            throw new GLSPServerException("Could not save model to " + targetUri, e);
        }
    }

    public static URI toEmfFileUri(final String rawUri) {
        String trimmed = rawUri.trim();
        if (trimmed.startsWith("file:")) {
            URI parsed = URI.createURI(trimmed);
            if (parsed.toFileString() != null) {
                return URI.createFileURI(parsed.toFileString());
            }
            return parsed;
        }
        return URI.createFileURI(new File(trimmed).getAbsolutePath());
    }
}
