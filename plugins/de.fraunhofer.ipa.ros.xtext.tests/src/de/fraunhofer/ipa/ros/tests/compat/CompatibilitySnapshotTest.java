package de.fraunhofer.ipa.ros.tests.compat;

import static org.junit.Assume.assumeTrue;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HexFormat;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.generator.InMemoryFileSystemAccess;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.Issue;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;

import de.fraunhofer.ipa.ros.RosStandaloneSetup;
import de.fraunhofer.ipa.ros.plugin.spi.PluginRegistry;
import de.fraunhofer.ipa.ros.tests.Ros1InjectorProvider;
import de.fraunhofer.ipa.ros.tests.Ros2InjectorProvider;
import de.fraunhofer.ipa.ros2.distro.Ros2Distros;
import de.fraunhofer.ipa.ros2.generator.Ros2Generator;
import de.fraunhofer.ipa.rossystem.RosSystemRuntimeModule;
import de.fraunhofer.ipa.rossystem.RosSystemStandaloneSetup;
import de.fraunhofer.ipa.rossystem.generator.RosSystemGenerator;

/**
 * Writes a snapshot of how core treats existing models, so that two commits can be compared
 * (design policy rule 6). Run through {@code tools/compat/snapshot.sh}; skipped in normal builds.
 *
 * <p>{@code ROSTOOLING_COMPAT_UNITS} names a file with one unit per line,
 * {@code name|subject-dir|library-dir,library-dir}. All model files under the subject and
 * library directories are loaded into one resource set; only subject files are reported.
 * For each subject file the snapshot holds its SHA-256, its validation issues and a dump of the
 * parsed model tree ({@code model.txt}: every object with its set attributes and the names of the
 * objects it refers to, in document order); {@code .ros2}
 * and {@code .rossystem} files also get their generated output ({@code .ros2}: C++ and Python in
 * separate runs, newest LTS distro, so the result does not depend on {@code $ROS_DISTRO}). Generator
 * exceptions are recorded instead of failing the run. {@code ROSTOOLING_COMPAT_OUT} is the
 * directory the snapshot is written to; it is replaced.
 */
public class CompatibilitySnapshotTest {

    private static final List<String> EXTENSIONS = List.of(".ros", ".ros1", ".ros2", ".rossystem");
    private static final List<String> LANGUAGES = List.of("cpp", "python");

    @Test
    public void writeSnapshot() throws IOException {
        String unitsFile = System.getenv("ROSTOOLING_COMPAT_UNITS");
        String outDir = System.getenv("ROSTOOLING_COMPAT_OUT");
        assumeTrue("compatibility snapshot not requested", unitsFile != null && outDir != null);

        PluginRegistry.INSTANCE.clearRegistered();
        new Ros1InjectorProvider().getInjector();
        Injector ros2Injector = new Ros2InjectorProvider().getInjector();
        new RosStandaloneSetup().createInjectorAndDoEMFRegistration();
        Injector systemInjector = rosSystemInjector();
        Ros2Generator ros2Generator = ros2Injector.getInstance(Ros2Generator.class);
        RosSystemGenerator systemGenerator = systemInjector.getInstance(RosSystemGenerator.class);
        String distro = Ros2Distros.defaultDistro().name();

        Path out = Paths.get(outDir);
        deleteTree(out);
        Files.createDirectories(out);
        List<String> summary = new ArrayList<>();
        summary.add("distro " + distro);

        for (String line : Files.readAllLines(Paths.get(unitsFile), StandardCharsets.UTF_8)) {
            String trimmed = line.trim();
            if (trimmed.isEmpty() || trimmed.startsWith("#")) {
                continue;
            }
            String[] parts = trimmed.split("\\|", -1);
            String name = parts[0];
            Path subject = Paths.get(parts[1]);
            List<Path> libraries = parts.length > 2 && !parts[2].isBlank()
                    ? Stream.of(parts[2].split(",")).map(Paths::get).collect(Collectors.toList())
                    : List.of();
            summary.add(snapshotUnit(name, subject, libraries, systemInjector, ros2Generator, systemGenerator,
                    distro, out.resolve(name)));
        }
        Files.write(out.resolve("SUMMARY.txt"), summary, StandardCharsets.UTF_8);
    }

    private String snapshotUnit(String name, Path subject, List<Path> libraries, Injector injector,
            Ros2Generator ros2Generator, RosSystemGenerator systemGenerator, String distro, Path out)
            throws IOException {
        XtextResourceSet resourceSet = injector.getInstance(XtextResourceSet.class);
        List<Path> subjects = modelFiles(subject);
        for (Path library : libraries) {
            for (Path file : modelFiles(library)) {
                load(resourceSet, file);
            }
        }
        Map<Path, Resource> loaded = new TreeMap<>();
        for (Path file : subjects) {
            loaded.put(file, load(resourceSet, file));
        }
        EcoreUtil.resolveAll(resourceSet);

        int errors = 0;
        for (Map.Entry<Path, Resource> entry : loaded.entrySet()) {
            Path file = entry.getKey();
            Resource resource = entry.getValue();
            Path fileOut = out.resolve(subject.relativize(file).toString());
            Files.createDirectories(fileOut);

            List<String> report = new ArrayList<>();
            report.add("sha256 " + sha256(Files.readAllBytes(file)));
            List<String> issues = issues(resource);
            errors += issues.stream().filter(i -> i.startsWith("ERROR")).count();
            report.add("issues " + issues.size());
            report.addAll(issues);

            Files.write(fileOut.resolve("model.txt"), modelDump(resource), StandardCharsets.UTF_8);

            String fileName = file.getFileName().toString();
            if (fileName.endsWith(".ros2")) {
                // One run per language: with "both" the Python pass replaces the C++ output.
                for (String language : LANGUAGES) {
                    InMemoryFileSystemAccess fsa = new InMemoryFileSystemAccess();
                    report.add(generate(language, () -> ros2Generator.generateTargeted(resource, fsa, null, language,
                            distro, List.of())));
                    writeGenerated(fileOut.resolve("generated").resolve(language), fsa);
                }
            } else if (fileName.endsWith(".rossystem")) {
                InMemoryFileSystemAccess fsa = new InMemoryFileSystemAccess();
                report.add(generate("system", () -> systemGenerator.generateSystemTargeted(resource, fsa, List.of())));
                writeGenerated(fileOut.resolve("generated"), fsa);
            }
            Files.write(fileOut.resolve("report.txt"), report, StandardCharsets.UTF_8);
        }
        return name + ": " + loaded.size() + " file(s), " + errors + " error(s)";
    }

    /** One line per object: class, set attributes, referenced objects; indented by containment depth. */
    private static List<String> modelDump(Resource resource) {
        List<String> lines = new ArrayList<>();
        for (EObject root : resource.getContents()) {
            dump(root, 0, lines);
        }
        return lines;
    }

    private static void dump(EObject object, int depth, List<String> lines) {
        StringBuilder line = new StringBuilder("  ".repeat(depth))
                .append(object.eClass().getEPackage().getName()).append('.').append(object.eClass().getName());
        for (EStructuralFeature feature : object.eClass().getEAllStructuralFeatures()) {
            if (feature.isTransient() || feature.isDerived() || feature.isVolatile() || !object.eIsSet(feature)) {
                continue;
            }
            if (feature instanceof EAttribute) {
                line.append(' ').append(feature.getName()).append('=')
                        .append(String.valueOf(object.eGet(feature)).replace("\n", "\\n"));
            } else if (feature instanceof EReference reference && !reference.isContainment()
                    && !reference.isContainer()) {
                Object value = object.eGet(feature, false);
                List<?> targets = value instanceof List<?> list ? list : List.of(value);
                line.append(' ').append(feature.getName()).append("->[");
                for (Object target : targets) {
                    line.append(describe((EObject) target)).append(';');
                }
                line.append(']');
            }
        }
        lines.add(line.toString());
        for (EObject child : object.eContents()) {
            dump(child, depth + 1, lines);
        }
    }

    private static String describe(EObject target) {
        if (target.eIsProxy()) {
            return "unresolved:" + ((org.eclipse.emf.ecore.InternalEObject) target).eProxyURI().fragment();
        }
        EStructuralFeature name = target.eClass().getEStructuralFeature("name");
        return target.eClass().getName() + (name != null && target.eGet(name) != null ? " " + target.eGet(name) : "");
    }

    private static String generate(String label, Runnable generation) {
        try {
            generation.run();
            return "generation " + label + " ok";
        } catch (RuntimeException e) {
            return "generation " + label + " failed " + e.getClass().getName() + ": " + firstLine(e.getMessage());
        }
    }

    private static Resource load(XtextResourceSet resourceSet, Path file) {
        return resourceSet.getResource(URI.createFileURI(file.toAbsolutePath().normalize().toString()), true);
    }

    private static List<String> issues(Resource resource) {
        if (!(resource instanceof XtextResource)) {
            return List.of("ERROR not an Xtext resource");
        }
        XtextResource xtext = (XtextResource) resource;
        List<Issue> found = xtext.getResourceServiceProvider().getResourceValidator()
                .validate(xtext, CheckMode.ALL, CancelIndicator.NullImpl);
        List<String> lines = new ArrayList<>();
        for (Issue issue : found) {
            lines.add(issue.getSeverity() + " line " + issue.getLineNumber() + " col " + issue.getColumn()
                    + " [" + issue.getCode() + "] " + firstLine(issue.getMessage()));
        }
        Collections.sort(lines);
        return lines;
    }

    private static void writeGenerated(Path root, InMemoryFileSystemAccess fsa) throws IOException {
        Map<String, String> files = new TreeMap<>();
        fsa.getTextFiles().forEach((key, content) -> files.put(key.replaceFirst("^DEFAULT_OUTPUT/?", ""),
                content.toString()));
        for (Map.Entry<String, String> file : files.entrySet()) {
            Path target = root.resolve(file.getKey());
            Files.createDirectories(target.getParent());
            Files.write(target, file.getValue().getBytes(StandardCharsets.UTF_8));
        }
    }

    private static List<Path> modelFiles(Path dir) throws IOException {
        try (Stream<Path> walk = Files.walk(dir)) {
            return walk.filter(Files::isRegularFile)
                    .filter(p -> EXTENSIONS.stream().anyMatch(ext -> p.getFileName().toString().endsWith(ext)))
                    .map(p -> p.toAbsolutePath().normalize())
                    .sorted()
                    .collect(Collectors.toList());
        }
    }

    private static Injector rosSystemInjector() {
        return new RosSystemStandaloneSetup() {
            @Override
            public Injector createInjector() {
                // Same Tycho/OSGi class loader workaround as Ros2InjectorProvider.
                return Guice.createInjector(new RosSystemRuntimeModule() {
                    @Override
                    public ClassLoader bindClassLoaderToInstance() {
                        return CompatibilitySnapshotTest.class.getClassLoader();
                    }
                });
            }
        }.createInjectorAndDoEMFRegistration();
    }

    private static String firstLine(String text) {
        if (text == null) {
            return "";
        }
        int newline = text.indexOf('\n');
        return newline < 0 ? text : text.substring(0, newline);
    }

    private static String sha256(byte[] bytes) {
        try {
            return HexFormat.of().formatHex(MessageDigest.getInstance("SHA-256").digest(bytes));
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException(e);
        }
    }

    private static void deleteTree(Path root) throws IOException {
        if (!Files.exists(root)) {
            return;
        }
        try (Stream<Path> walk = Files.walk(root)) {
            for (Path p : walk.sorted(Collections.reverseOrder()).collect(Collectors.toList())) {
                Files.delete(p);
            }
        }
    }
}
