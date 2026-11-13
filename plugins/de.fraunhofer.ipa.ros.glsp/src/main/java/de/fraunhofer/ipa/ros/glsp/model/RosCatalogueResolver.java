package de.fraunhofer.ipa.ros.glsp.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.linking.lazy.LazyLinkingResource;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.util.Triple;

/**
 * Makes the shared model catalogue visible to a GLSP session the way the language server sees it.
 * The language server adds the catalogue folder ({@code rostooling.catalogue.path}, default
 * {@code ~/.rostooling/catalogue_repos}, plus {@code catalogue_config.json} custom folders) to its
 * workspace; a GLSP session only loads the model's own package. Without this, references into the
 * catalogue (e.g. {@code sensor_msgs/msg/Image}) stay unresolved proxies, and validators that compare
 * resolved objects (RosSystemValidator.MatchPortMsgs) report spurious errors.
 *
 * <p>Loads on demand: after the workspace models are loaded, every unresolved cross-reference's link
 * text names a package ({@code pkg/msg/T}, {@code "pkg.node"}, {@code "system"}); only catalogue files
 * declaring one of those packages are loaded, repeated until nothing new is needed.
 */
public final class RosCatalogueResolver {

    private static final Logger LOGGER = Logger.getLogger(RosCatalogueResolver.class);
    private static final int MAX_ROUNDS = 8;
    private static final Pattern CUSTOM_PATH = Pattern.compile("\"path\"\\s*:\\s*\"([^\"]+)\"");

    /** File -> declared package/system name, keyed with the file's mtime. */
    private static final Map<Path, Map.Entry<Long, String>> DECLARED = new ConcurrentHashMap<>();

    private RosCatalogueResolver() {}

    /** Catalogue roots, resolved exactly like RosMultiRootWorkspaceConfigFactory does for the LSP. */
    public static List<File> catalogueRoots() {
        String path = System.getProperty("rostooling.catalogue.path");
        if (path == null || path.isBlank()) {
            path = System.getenv("ROSMODEL_CATALOGUE_DIR");
        }
        if (path == null || path.isBlank()) {
            path = System.getProperty("user.home") + File.separator + ".rostooling" + File.separator + "catalogue_repos";
        }
        List<File> roots = new ArrayList<>();
        File main = new File(path);
        if (!main.isDirectory()) {
            return roots;
        }
        roots.add(main);
        File config = new File(main, "catalogue_config.json");
        if (config.isFile()) {
            try {
                Matcher m = CUSTOM_PATH.matcher(Files.readString(config.toPath(), StandardCharsets.UTF_8));
                while (m.find()) {
                    File custom = new File(m.group(1));
                    if (custom.isDirectory()) {
                        roots.add(custom);
                    }
                }
            } catch (IOException e) {
                LOGGER.debug("Unreadable catalogue_config.json: " + e.getMessage());
            }
        }
        return roots;
    }

    /** Loads the catalogue models the resource set's unresolved references need, then resolves all. */
    public static void resolveFromCatalogue(final ResourceSet resourceSet) {
        List<File> roots = catalogueRoots();
        if (roots.isEmpty()) {
            return;
        }
        Map<String, List<Path>> byName = null;
        Set<String> attempted = new HashSet<>();
        for (int round = 0; round < MAX_ROUNDS; round++) {
            Set<String> wanted = unresolvedNames(resourceSet);
            wanted.removeAll(attempted);
            if (wanted.isEmpty()) {
                break;
            }
            attempted.addAll(wanted);
            if (byName == null) {
                byName = index(roots);
            }
            boolean loaded = false;
            for (String name : wanted) {
                for (Path file : byName.getOrDefault(name, List.of())) {
                    URI uri = URI.createFileURI(file.toAbsolutePath().toString());
                    if (resourceSet.getResource(uri, false) == null) {
                        try {
                            resourceSet.getResource(uri, true);
                            loaded = true;
                        } catch (RuntimeException e) {
                            LOGGER.debug("Skipping catalogue model " + file + ": " + e.getMessage());
                        }
                    }
                }
            }
            if (!loaded) {
                break;
            }
            forgetFailedLinks(resourceSet);
        }
        EcoreUtil.resolveAll(resourceSet);
    }

    /**
     * First name segment of every cross-reference that does not resolve with the resources loaded
     * now: {@code sensor_msgs/msg/Image} -> sensor_msgs, {@code amcl.amcl} -> amcl,
     * {@code artifact::iface} -> artifact, {@code turtlebot} -> turtlebot.
     */
    static Set<String> unresolvedNames(final ResourceSet resourceSet) {
        Set<String> names = new LinkedHashSet<>();
        for (Resource res : new ArrayList<>(resourceSet.getResources())) {
            if (!(res instanceof LazyLinkingResource lazy)) {
                continue;
            }
            for (var it = res.getAllContents(); it.hasNext();) {
                EObject obj = it.next();
                for (EReference ref : obj.eClass().getEAllReferences()) {
                    if (ref.isContainment() || ref.isContainer() || ref.isDerived() || ref.isTransient()
                            || !obj.eIsSet(ref)) {
                        continue;
                    }
                    Object value = obj.eGet(ref, false);
                    List<?> values = value instanceof List<?> l ? l : List.of(value);
                    for (Object v : values) {
                        if (v instanceof InternalEObject proxy && proxy.eIsProxy()
                                && EcoreUtil.resolve(proxy, obj).eIsProxy()) {
                            String text = linkText(lazy, proxy.eProxyURI());
                            String name = firstSegment(text);
                            if (!name.isEmpty()) {
                                names.add(name);
                            }
                        }
                    }
                }
            }
        }
        return names;
    }

    /**
     * LazyLinkingResource caches links that failed to resolve (resource scope cache key
     * UNRESOLVEABLE_PROXIES_KEY); after new models were loaded those links must be retried.
     */
    private static void forgetFailedLinks(final ResourceSet resourceSet) {
        for (Resource res : new ArrayList<>(resourceSet.getResources())) {
            if (res instanceof org.eclipse.xtext.resource.XtextResource xtext && xtext.getCache() != null) {
                xtext.getCache().clear(xtext);
            }
        }
    }

    private static String linkText(final LazyLinkingResource res, final URI proxyUri) {
        if (proxyUri == null || proxyUri.fragment() == null
                || !res.getEncoder().isCrossLinkFragment(res, proxyUri.fragment())) {
            return "";
        }
        try {
            Triple<EObject, EReference, INode> link = res.getEncoder().decode(res, proxyUri.fragment());
            return link.getThird() == null ? "" : NodeModelUtils.getTokenText(link.getThird());
        } catch (RuntimeException e) {
            return "";
        }
    }

    static String firstSegment(final String linkText) {
        String t = linkText == null ? "" : linkText.trim();
        if (t.length() >= 2 && (t.charAt(0) == '"' || t.charAt(0) == '\'')) {
            t = t.substring(1, t.length() - 1).trim();
        }
        int end = t.length();
        for (String sep : new String[] {"/", "::", "."}) {
            int i = t.indexOf(sep);
            if (i >= 0 && i < end) {
                end = i;
            }
        }
        return t.substring(0, end).trim();
    }

    /** Declared package (or system) name -> catalogue files declaring it. */
    private static Map<String, List<Path>> index(final List<File> roots) {
        Map<String, List<Path>> byName = new LinkedHashMap<>();
        for (File root : roots) {
            try (Stream<Path> walk = Files.walk(root.toPath(), 12, FileVisitOption.FOLLOW_LINKS)) {
                walk.filter(Files::isRegularFile)
                    .filter(p -> {
                        String n = p.getFileName().toString();
                        return n.endsWith(".ros") || n.endsWith(".ros2") || n.endsWith(".rossystem");
                    })
                    .forEach(p -> {
                        String name = declaredName(p);
                        if (!name.isEmpty()) {
                            byName.computeIfAbsent(name, k -> new ArrayList<>()).add(p);
                        }
                    });
            } catch (IOException | RuntimeException e) {
                LOGGER.debug("Could not index catalogue " + root + ": " + e.getMessage());
            }
        }
        return byName;
    }

    /** The model's root name: the first non-comment line's token before ':'. Cached per mtime. */
    private static String declaredName(final Path file) {
        long mtime = file.toFile().lastModified();
        Map.Entry<Long, String> cached = DECLARED.get(file);
        if (cached != null && cached.getKey() == mtime) {
            return cached.getValue();
        }
        String name = "";
        try (BufferedReader r = Files.newBufferedReader(file, StandardCharsets.UTF_8)) {
            String line;
            while ((line = r.readLine()) != null) {
                String t = line.trim();
                if (t.isEmpty() || t.startsWith("#")) {
                    continue;
                }
                int colon = t.indexOf(':');
                name = (colon > 0 ? t.substring(0, colon) : t).replace("\"", "").replace("'", "").trim();
                break;
            }
        } catch (IOException | RuntimeException e) {
            name = "";
        }
        DECLARED.put(file, Map.entry(mtime, name));
        return name;
    }
}
