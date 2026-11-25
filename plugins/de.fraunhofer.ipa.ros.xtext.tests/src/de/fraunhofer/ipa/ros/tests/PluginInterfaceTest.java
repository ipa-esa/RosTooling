package de.fraunhofer.ipa.ros.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;
import java.util.stream.Collectors;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.generator.InMemoryFileSystemAccess;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import com.google.inject.Guice;
import com.google.inject.Injector;

import de.fraunhofer.ipa.ros.documentation.RosExtensionDocumentationProvider;
import de.fraunhofer.ipa.ros.ide.contentassist.RosExtensionIdeContentProposalProvider;
import de.fraunhofer.ipa.ros.plugin.model.PluginBases;
import de.fraunhofer.ipa.ros.plugin.spi.BlockDescriptor;
import de.fraunhofer.ipa.ros.plugin.spi.ExtensionSchemaMapper;
import de.fraunhofer.ipa.ros.plugin.spi.GenerationContext;
import de.fraunhofer.ipa.ros.plugin.spi.HookLocation;
import de.fraunhofer.ipa.ros.plugin.spi.LoaderDescriptor;
import de.fraunhofer.ipa.ros.plugin.spi.MergeStrategy;
import de.fraunhofer.ipa.ros.plugin.spi.PackageBuild;
import de.fraunhofer.ipa.ros.plugin.spi.PackageGenerationContext;
import de.fraunhofer.ipa.ros.plugin.spi.PluginRegistry;
import de.fraunhofer.ipa.ros.plugin.spi.PluginToolDescriptor;
import de.fraunhofer.ipa.ros.plugin.spi.RosToolingPlugin;
import de.fraunhofer.ipa.ros.plugin.spi.SchemaHints;
import de.fraunhofer.ipa.ros.plugin.spi.StartupClaim;
import de.fraunhofer.ipa.ros.plugin.spi.SystemGenerationContext;
import de.fraunhofer.ipa.ros.plugin.spi.ToolExecutionContext;
import de.fraunhofer.ipa.ros.plugin.spi.ToolResult;
import de.fraunhofer.ipa.ros.plugin.spi.ValidationContext;
import de.fraunhofer.ipa.ros.plugin.spi.ValidationIssue;
import de.fraunhofer.ipa.ros.validation.RosValidator;
import de.fraunhofer.ipa.ros2.Ros2RuntimeModule;
import de.fraunhofer.ipa.ros2.Ros2StandaloneSetup;
import de.fraunhofer.ipa.ros2.distro.Ros2Distro;
import de.fraunhofer.ipa.ros2.generator.Ros2Generator;

/**
 * The plugin interface (Phase 4 step 4): named loaders, schema hints and the plugin interface
 * version. Everything plugin-facing runs through {@code ExternalProbePlugin}, compiled here into a
 * separate JAR and loaded through an approval file like any installed plugin, so core tests never
 * use a real plugin.
 */
public class PluginInterfaceTest {

    /** The types of the plugin interface, as listed in the {@code spi} package documentation. */
    private static final List<Class<?>> INTERFACE_TYPES = List.of(
            RosToolingPlugin.class, StartupClaim.class, BlockDescriptor.class, LoaderDescriptor.class, PluginToolDescriptor.class,
            HookLocation.class, MergeStrategy.class, SchemaHints.class, GenerationContext.class,
            PackageGenerationContext.class, SystemGenerationContext.class, PackageBuild.class,
            ValidationContext.class, ValidationIssue.class, ToolExecutionContext.class, ToolResult.class,
            PluginBases.class);

    /** Types plugins construct themselves; for the others the constructors are core's own. */
    private static final Set<Class<?>> CONSTRUCTED_BY_PLUGINS = Set.of(
            BlockDescriptor.class, LoaderDescriptor.class, PluginToolDescriptor.class, ToolResult.class,
            ValidationIssue.class);

    private static final Path SNAPSHOT = Paths.get("resources", "plugin-api", "plugin-api-snapshot.txt");

    private static final String PROBE_SOURCE = """
            package de.example.probe;

            import de.fraunhofer.ipa.ros.plugin.spi.*;
            import java.util.EnumSet;
            import java.util.List;
            import org.eclipse.emf.ecore.*;
            import ros.Plugin;

            /** Neutral test plugin: a probe loader and a hinted block. */
            public final class ExternalProbePlugin implements RosToolingPlugin {
                private static final EClass SCHEMA = schema();

                private static EClass schema() {
                    EcoreFactory f = EcoreFactory.eINSTANCE;
                    EPackage pkg = f.createEPackage();
                    pkg.setName("probe");
                    pkg.setNsPrefix("probe");
                    pkg.setNsURI("http://example.org/probe");
                    EClass cls = f.createEClass();
                    cls.setName("ProbeConfig");
                    SchemaHints.set(cls, SchemaHints.LABEL, "Probe");
                    SchemaHints.set(cls, SchemaHints.HELP, "Settings of the probe.");
                    EAttribute mode = f.createEAttribute();
                    mode.setName("mode");
                    mode.setEType(EcorePackage.Literals.ESTRING);
                    SchemaHints.set(mode, SchemaHints.LABEL, "Mode");
                    SchemaHints.set(mode, SchemaHints.HELP, "How often the probe runs.");
                    SchemaHints.set(mode, SchemaHints.ORDER, "2");
                    SchemaHints.set(mode, SchemaHints.CHOICES, "once, always");
                    EAttribute rate = f.createEAttribute();
                    rate.setName("rate");
                    rate.setEType(EcorePackage.Literals.EINT);
                    SchemaHints.set(rate, SchemaHints.LABEL, "Rate");
                    SchemaHints.set(rate, SchemaHints.ORDER, "1");
                    cls.getEStructuralFeatures().add(mode);
                    cls.getEStructuralFeatures().add(rate);
                    pkg.getEClassifiers().add(cls);
                    return cls;
                }

                @Override public String id() { return "de.example.probe"; }
                @Override public String version() { return "1.0.0"; }
                @Override public List<BlockDescriptor> blocks() {
                    return List.of(new BlockDescriptor("probe", SCHEMA, EnumSet.of(HookLocation.NODE)));
                }
                @Override public List<LoaderDescriptor> loaders() {
                    return List.of(new LoaderDescriptor("probe", "Loads probe plugins at start-up"));
                }
                @Override public void validate(ValidationContext context) { }
                @Override public void generatePackage(PackageGenerationContext context) {
                    for (Plugin plugin : context.loaderPlugins()) {
                        context.writeFile("probe/" + plugin.getName() + ".txt", "probe registers " + plugin.getName() + "\\n");
                    }
                }
            }
            """;

    private static final String PROBE_MODEL = """
            probe_pkg:
              pluginbases:
                Sensor:
                  class: "probe_pkg::Sensor"
                  header: "probe_pkg/sensor.hpp"
                  loader: probe
              artifacts:
                sensors:
                  plugins:
                    Thermo:
                      implements: probe_pkg.Sensor
                host:
                  node: host
                  @probe:
                    rate: 5
                    mode: once
            """;

    private Injector ros2Injector;
    private Path tempRoot;
    private PluginRegistry isolated;

    @Before
    public void setUp() throws Exception {
        PluginRegistry.INSTANCE.clearRegistered();
        ros2Injector = new Ros2StandaloneSetup() {
            @Override
            public Injector createInjector() {
                return Guice.createInjector(new Ros2RuntimeModule() {
                    @Override
                    public ClassLoader bindClassLoaderToInstance() {
                        return PluginInterfaceTest.class.getClassLoader();
                    }
                });
            }
        }.createInjectorAndDoEMFRegistration();
        tempRoot = Files.createTempDirectory("rostooling-plugin-interface-");
    }

    @After
    public void tearDown() throws Exception {
        PluginRegistry.INSTANCE.clearRegistered();
        if (isolated != null) {
            isolated.dispose();
        }
        try (var walk = Files.walk(tempRoot)) {
            walk.sorted((a, b) -> b.compareTo(a)).forEach(p -> p.toFile().delete());
        }
    }

    // ---------------------------------------------------------------- versioning

    /**
     * The public methods of the plugin interface match the stored snapshot. A change needs a
     * version bump (minor for additions, major for removals or changes) and a new snapshot; set
     * {@code ROSTOOLING_UPDATE_API_SNAPSHOT=1} to write it once the version is bumped.
     */
    @Test
    public void interfaceMatchesSnapshotForItsVersion() throws Exception {
        List<String> current = interfaceSignatures();
        String version = PluginRegistry.PLUGIN_API_VERSION;
        boolean update = "1".equals(System.getenv("ROSTOOLING_UPDATE_API_SNAPSHOT"));
        if (!Files.exists(SNAPSHOT)) {
            if (update) {
                writeSnapshot(version, current);
                return;
            }
            fail("Missing " + SNAPSHOT + "; run with ROSTOOLING_UPDATE_API_SNAPSHOT=1 to create it");
        }
        List<String> lines = Files.readAllLines(SNAPSHOT, StandardCharsets.UTF_8);
        String storedVersion = lines.get(0).replaceFirst("^version=", "").trim();
        List<String> stored = lines.subList(1, lines.size()).stream().filter(l -> !l.isBlank()).toList();

        Set<String> removed = new TreeSet<>(stored);
        removed.removeAll(current);
        Set<String> added = new TreeSet<>(current);
        added.removeAll(stored);
        if (removed.isEmpty() && added.isEmpty()) {
            assertEquals("The interface did not change; PLUGIN_API_VERSION must stay at the snapshot's version",
                    storedVersion, version);
            return;
        }
        int[] was = parse(storedVersion);
        int[] now = parse(version);
        String diff = "\nRemoved or changed:\n  " + String.join("\n  ", removed) + "\nAdded:\n  " + String.join("\n  ", added);
        if (!removed.isEmpty() && now[0] <= was[0]) {
            fail("The plugin interface lost or changed members: bump the major version of PLUGIN_API_VERSION ("
                    + version + ")." + diff);
        }
        if (removed.isEmpty() && compare(now, was) <= 0) {
            fail("The plugin interface gained members: bump the minor version of PLUGIN_API_VERSION ("
                    + version + ")." + diff);
        }
        if (update) {
            writeSnapshot(version, current);
            return;
        }
        fail("PLUGIN_API_VERSION is bumped to " + version + "; run with ROSTOOLING_UPDATE_API_SNAPSHOT=1 to store the new snapshot." + diff);
    }

    @Test
    public void jarDeclaringAnotherInterfaceVersionIsRefused() throws Exception {
        JavaCompiler compiler = requireCompiler();
        Path jar = buildProbeJar(compiler, "probe-future", "[2.0.0,3.0.0)", "");
        isolated = isolatedRegistry(jar);
        isolated.loadFromPaths(List.of(jar), Set.of("de.example.probe"));
        assertTrue("A JAR built for plugin interface 2 must not load", isolated.activePlugins().isEmpty());
        String errors = String.join("\n", isolated.loadErrors());
        assertTrue(errors, errors.contains("needs plugin interface [2.0.0,3.0.0)"));
        assertTrue(errors, errors.contains("this core offers " + PluginRegistry.PLUGIN_API_VERSION));
    }

    @Test
    public void jarWithoutInterfaceRangeIsRefusedAndCoreRangeIsOptional() throws Exception {
        JavaCompiler compiler = requireCompiler();
        Path missing = buildProbeJar(compiler, "probe-norange", null, "");
        isolated = isolatedRegistry(missing);
        isolated.loadFromPaths(List.of(missing), Set.of("de.example.probe"));
        assertTrue(isolated.activePlugins().isEmpty());
        assertTrue(isolated.discoveredPlugins().get(0).loadError(),
                isolated.discoveredPlugins().get(0).loadError().contains("pluginApiVersionRange"));
        isolated.dispose();

        Path ok = buildProbeJar(compiler, "probe-nocore", "[1.0.0,2.0.0)", "");
        isolated = isolatedRegistry(ok);
        isolated.loadFromPaths(List.of(ok), Set.of("de.example.probe"));
        assertEquals("No core range means any core: " + isolated.loadErrors(), 1, isolated.activePlugins().size());
    }

    // ---------------------------------------------------------------- loaders

    @Test
    public void baseLoaderMustBePluginlibOrRegistered() throws Exception {
        assertHasCode(validate(PROBE_MODEL), RosValidator.PLUGIN_UNKNOWN_LOADER);
        assertNoCode(validate(PROBE_MODEL.replace("loader: probe", "loader: pluginlib")), RosValidator.PLUGIN_UNKNOWN_LOADER);

        activateProbe();
        assertNoErrors(validate(PROBE_MODEL));
        assertHasCode(validate(PROBE_MODEL.replace("loader: probe", "loader: nobody")), RosValidator.PLUGIN_UNKNOWN_LOADER);
    }

    @Test
    public void loaderRegisteredTwiceHasNoOwner() throws Exception {
        activateProbe();
        PluginRegistry.INSTANCE.register(new RosToolingPlugin() {
            @Override public String id() { return "test.second_probe"; }
            @Override public List<BlockDescriptor> blocks() { return List.of(); }
            @Override public List<LoaderDescriptor> loaders() { return List.of(new LoaderDescriptor("probe", "")); }
            @Override public void validate(final ValidationContext context) { }
        });
        assertNull(PluginRegistry.INSTANCE.loaderOwner("probe"));
        List<Issue> issues = validate(PROBE_MODEL);
        assertTrue(issues.toString(), issues.stream().anyMatch(i -> RosValidator.PLUGIN_UNKNOWN_LOADER.equals(i.getCode())
                && i.getMessage().contains("de.example.probe") && i.getMessage().contains("test.second_probe")));
        assertTrue(PluginRegistry.INSTANCE.loaderErrors().toString(),
                PluginRegistry.INSTANCE.loaderErrors().stream().anyMatch(e -> e.contains("probe")));
    }

    @Test
    public void pluginlibCannotBeRegistered() {
        PluginRegistry.INSTANCE.register(new RosToolingPlugin() {
            @Override public String id() { return "test.pluginlib_thief"; }
            @Override public List<BlockDescriptor> blocks() { return List.of(); }
            @Override public List<LoaderDescriptor> loaders() { return List.of(new LoaderDescriptor("pluginlib", "")); }
            @Override public void validate(final ValidationContext context) { }
        });
        assertNull(PluginRegistry.INSTANCE.loaderOwner("pluginlib"));
        assertTrue(PluginRegistry.INSTANCE.loaderErrors().stream().anyMatch(e -> e.contains("built into core")));
    }

    @Test
    public void pluginsOfARegisteredLoaderAreRoutedToItsPlugin() throws Exception {
        XtextResourceSet rs = ros2Injector.getInstance(XtextResourceSet.class);
        Resource res = load(rs, PROBE_MODEL);
        Ros2Generator gen = ros2Injector.getInstance(Ros2Generator.class);

        Ros2Generator.PluginGenerationOutcome without =
                gen.generateTargetedWithPlugins(res, new InMemoryFileSystemAccess(), null, "cpp", "jazzy", List.of());
        assertTrue(without.errors.toString(), without.errors.stream()
                .anyMatch(e -> e.contains("Thermo") && e.contains("'probe'") && e.contains("no enabled plugin")));

        activateProbe();
        InMemoryFileSystemAccess fsa = new InMemoryFileSystemAccess();
        Ros2Generator.PluginGenerationOutcome with =
                gen.generateTargetedWithPlugins(res, fsa, null, "cpp", "jazzy", List.of());
        assertTrue(with.errors.toString(), with.errors.isEmpty());
        assertEquals("probe registers Thermo\n", with.pluginFiles.get("probe_pkg/probe/Thermo.txt"));
        String cmake = fsa.getTextFiles().get("DEFAULT_OUTPUTprobe_pkg/CMakeLists.txt").toString();
        assertTrue("Core still builds the plugin library", cmake.contains("sensors"));
        assertFalse("Core generates no pluginlib registration for another loader",
                fsa.getTextFiles().containsKey("DEFAULT_OUTPUTprobe_pkg/plugins.xml"));
    }

    @Test
    public void loaderHoverShowsItsSummary() throws Exception {
        activateProbe();
        XtextResourceSet rs = ros2Injector.getInstance(XtextResourceSet.class);
        Resource res = load(rs, PROBE_MODEL);
        ros.Package pkg = (ros.Package) res.getContents().get(0);
        String hover = ros2Injector.getInstance(RosExtensionDocumentationProvider.class)
                .getDocumentation(pkg.getPluginBases().get(0));
        assertTrue(hover, hover.contains("de.example.probe") && hover.contains("Loads probe plugins at start-up"));
    }

    // ---------------------------------------------------------------- schema hints

    @Test
    public void schemaHintsDriveHoverCompletionAndToolSchema() throws Exception {
        activateProbe();
        BlockDescriptor block = PluginRegistry.INSTANCE.blockDescriptor("probe");
        assertNotNull(block);
        EClass schema = block.schemaClass();

        List<String> order = SchemaHints.orderedFeatures(schema).stream().map(EStructuralFeature::getName).toList();
        assertEquals("The order hint wins over declaration order", List.of("rate", "mode"), order);
        assertEquals(List.of("once", "always"), SchemaHints.choices(schema.getEStructuralFeature("mode")));

        @SuppressWarnings("unchecked")
        Map<String, Object> props = (Map<String, Object>) ((Map<String, Object>) ExtensionSchemaMapper
                .schemaToJsonMap(block).get("schema")).get("properties");
        assertEquals(List.of("rate", "mode"), new ArrayList<>(props.keySet()));
        @SuppressWarnings("unchecked")
        Map<String, Object> mode = (Map<String, Object>) props.get("mode");
        assertEquals("Mode", mode.get("title"));
        assertEquals("How often the probe runs.", mode.get("description"));
        assertEquals(List.of("once", "always"), mode.get("x-choices"));
        assertEquals(2, mode.get("x-order"));

        XtextResourceSet rs = ros2Injector.getInstance(XtextResourceSet.class);
        Resource res = load(rs, PROBE_MODEL);
        ros.Package pkg = (ros.Package) res.getContents().get(0);
        ros.Node node = pkg.getArtifact().stream().filter(a -> a.getNode() != null).findFirst().orElseThrow().getNode();
        ros.ExtensionBlock probe = node.getExtensions().get(0);
        String blockHover = ros2Injector.getInstance(RosExtensionDocumentationProvider.class).getDocumentation(probe);
        assertTrue(blockHover, blockHover.indexOf("`rate` (Rate)") < blockHover.indexOf("`mode` (Mode)"));
        assertTrue(blockHover, blockHover.contains("How often the probe runs."));

        EObject modeEntry = probe.getEntries().stream().filter(e -> "mode".equals(e.getKey())).findFirst().orElseThrow();
        String entryHover = ros2Injector.getInstance(RosExtensionDocumentationProvider.class).getDocumentation(modeEntry);
        assertTrue(entryHover, entryHover.contains("**Mode**") && entryHover.contains("`once`, `always`"));

        List<String> keys = RosExtensionIdeContentProposalProvider.entryKeyProposalsFor(probe, false).stream()
                .map(RosExtensionIdeContentProposalProvider.ExtensionCompletionCandidate::label).toList();
        assertEquals(List.of("rate", "mode"), keys);
        List<String> values = RosExtensionIdeContentProposalProvider.entryValueProposalsFor(modeEntry).stream()
                .map(RosExtensionIdeContentProposalProvider.ExtensionCompletionCandidate::text).toList();
        assertEquals(List.of("once", "always"), values);
    }

    @Test
    public void choicesAreHintsNotRules() throws Exception {
        activateProbe();
        assertNoErrors(validate(PROBE_MODEL.replace("mode: once", "mode: sometimes")));
    }

    // ---------------------------------------------------------------- helpers

    private void activateProbe() throws Exception {
        Path jar = buildProbeJar(requireCompiler(), "probe", "[1.0.0,2.0.0)", "[3.6.0,4.0.0)");
        isolated = isolatedRegistry(jar);
        isolated.loadFromPaths(List.of(jar), Set.of("de.example.probe"));
        assertEquals("Probe plugin must load: " + isolated.loadErrors(), 1, isolated.activePlugins().size());
        PluginRegistry.INSTANCE.register(isolated.activePlugins().get(0));
    }

    private PluginRegistry isolatedRegistry(final Path jar) throws Exception {
        Path trust = tempRoot.resolve("trust-" + jar.getFileName() + ".json");
        Files.writeString(trust, "{\"version\":1,\"approved\":[{\"sha256\":\"" + sha256(jar) + "\",\"fileName\":\""
                + jar.getFileName() + "\",\"id\":\"de.example.probe\",\"approvedAt\":\"2026-11-21T00:00:00Z\"}]}",
                StandardCharsets.UTF_8);
        return new PluginRegistry(trust);
    }

    private Path buildProbeJar(final JavaCompiler compiler, final String tag, final String apiRange, final String coreRange)
            throws Exception {
        Path work = tempRoot.resolve("build-" + tag);
        Path src = work.resolve("src/de/example/probe/ExternalProbePlugin.java");
        Path cls = work.resolve("cls");
        Files.createDirectories(src.getParent());
        Files.createDirectories(cls);
        Files.writeString(src, PROBE_SOURCE, StandardCharsets.UTF_8);
        Set<String> cp = new LinkedHashSet<>();
        for (Class<?> c : List.of(RosToolingPlugin.class, EObject.class, ros.Package.class, Ros2Distro.class,
                org.eclipse.emf.common.util.EList.class)) {
            String loc = locationOf(c);
            if (loc != null) {
                cp.add(loc);
            }
        }
        assertEquals("Compiling ExternalProbePlugin failed", 0, compiler.run(null, null, null,
                "-cp", String.join(File.pathSeparator, cp), "-d", cls.toString(), src.toString()));

        StringBuilder props = new StringBuilder("id=de.example.probe\nversion=1.0.0\nsummary=Probe loader and hinted block\n");
        if (apiRange != null) {
            props.append("pluginApiVersionRange=").append(apiRange).append('\n');
        }
        if (coreRange != null && !coreRange.isEmpty()) {
            props.append("supportedCoreVersionRange=").append(coreRange).append('\n');
        }
        Path jar = tempRoot.resolve(tag + "-1.0.0.jar");
        try (JarOutputStream jos = new JarOutputStream(Files.newOutputStream(jar))) {
            try (var classes = Files.walk(cls)) {
                for (Path f : classes.filter(Files::isRegularFile).sorted().toList()) {
                    jos.putNextEntry(new JarEntry(cls.relativize(f).toString().replace(File.separatorChar, '/')));
                    jos.write(Files.readAllBytes(f));
                    jos.closeEntry();
                }
            }
            jos.putNextEntry(new JarEntry("META-INF/services/" + RosToolingPlugin.class.getName()));
            jos.write("de.example.probe.ExternalProbePlugin\n".getBytes(StandardCharsets.UTF_8));
            jos.closeEntry();
            jos.putNextEntry(new JarEntry(PluginRegistry.METADATA_ENTRY));
            jos.write(props.toString().getBytes(StandardCharsets.UTF_8));
            jos.closeEntry();
        }
        return jar;
    }

    private static JavaCompiler requireCompiler() {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        assertNotNull("JDK compiler must be available", compiler);
        return compiler;
    }

    private static String locationOf(final Class<?> clazz) throws Exception {
        Bundle b = FrameworkUtil.getBundle(clazz);
        if (b != null) {
            String loc = b.getLocation();
            if (loc != null && loc.startsWith("reference:")) {
                loc = loc.substring("reference:".length());
            }
            if (loc != null && loc.startsWith("file:")) {
                return Path.of(java.net.URI.create(loc)).toString();
            }
        }
        var cs = clazz.getProtectionDomain() != null ? clazz.getProtectionDomain().getCodeSource() : null;
        return cs != null && cs.getLocation() != null ? Path.of(cs.getLocation().toURI()).toString() : null;
    }

    private static String sha256(final Path file) throws Exception {
        byte[] digest = MessageDigest.getInstance("SHA-256").digest(Files.readAllBytes(file));
        StringBuilder sb = new StringBuilder();
        for (byte b : digest) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    private Resource load(final XtextResourceSet rs, final String content) throws Exception {
        Resource res = rs.createResource(URI.createURI("inmemory:/probe_pkg.ros2"));
        res.load(new ByteArrayInputStream(content.getBytes(StandardCharsets.UTF_8)), null);
        EcoreUtil.resolveAll(rs);
        return res;
    }

    private List<Issue> validate(final String content) throws Exception {
        Resource res = load(ros2Injector.getInstance(XtextResourceSet.class), content);
        return ros2Injector.getInstance(IResourceValidator.class).validate(res, CheckMode.ALL, CancelIndicator.NullImpl);
    }

    private static void assertNoErrors(final List<Issue> issues) {
        List<Issue> errors = issues.stream().filter(i -> i.getSeverity() == Severity.ERROR).toList();
        assertTrue("Unexpected errors: " + errors, errors.isEmpty());
    }

    private static void assertHasCode(final List<Issue> issues, final String code) {
        assertTrue("Expected " + code + " in " + issues, issues.stream().anyMatch(i -> code.equals(i.getCode())));
    }

    private static void assertNoCode(final List<Issue> issues, final String code) {
        assertFalse("Unexpected " + code + " in " + issues, issues.stream().anyMatch(i -> code.equals(i.getCode())));
    }

    /** One line per public member of the plugin interface, sorted. */
    static List<String> interfaceSignatures() {
        TreeSet<String> out = new TreeSet<>();
        java.util.ArrayDeque<Class<?>> queue = new java.util.ArrayDeque<>(INTERFACE_TYPES);
        while (!queue.isEmpty()) {
            Class<?> type = queue.poll();
            String owner = type.getName().substring(type.getPackageName().length() + 1).replace('$', '.');
            boolean constructed = CONSTRUCTED_BY_PLUGINS.contains(type)
                    || (type.getEnclosingClass() != null && (type.isRecord() || CONSTRUCTED_BY_PLUGINS.contains(type.getEnclosingClass())));
            for (Method m : type.getDeclaredMethods()) {
                if (Modifier.isPublic(m.getModifiers()) && !m.isSynthetic()) {
                    out.add(owner + (Modifier.isStatic(m.getModifiers()) ? " static " : " ")
                            + m.getGenericReturnType().getTypeName() + " " + m.getName() + "("
                            + Arrays.stream(m.getGenericParameterTypes()).map(t -> t.getTypeName())
                                    .collect(Collectors.joining(", ")) + ")"
                            + (m.isDefault() ? " default" : ""));
                }
            }
            for (Field f : type.getDeclaredFields()) {
                if (Modifier.isPublic(f.getModifiers()) && !f.isSynthetic()) {
                    out.add(owner + " field " + f.getGenericType().getTypeName() + " " + f.getName());
                }
            }
            if (constructed) {
                for (Constructor<?> c : type.getDeclaredConstructors()) {
                    if (Modifier.isPublic(c.getModifiers())) {
                        out.add(owner + " new(" + Arrays.stream(c.getGenericParameterTypes()).map(t -> t.getTypeName())
                                .collect(Collectors.joining(", ")) + ")");
                    }
                }
            }
            for (Class<?> nested : type.getDeclaredClasses()) {
                if (Modifier.isPublic(nested.getModifiers())) {
                    out.add(owner + " type " + nested.getSimpleName());
                    queue.add(nested);
                }
            }
        }
        return new ArrayList<>(out);
    }

    private static void writeSnapshot(final String version, final List<String> signatures) throws Exception {
        Files.createDirectories(SNAPSHOT.getParent());
        Files.writeString(SNAPSHOT, "version=" + version + "\n" + String.join("\n", signatures) + "\n", StandardCharsets.UTF_8);
    }

    private static int[] parse(final String version) {
        String[] parts = version.split("\\.");
        int[] out = new int[3];
        for (int i = 0; i < 3 && i < parts.length; i++) {
            out[i] = Integer.parseInt(parts[i].replaceAll("[^0-9].*", ""));
        }
        return out;
    }

    private static int compare(final int[] a, final int[] b) {
        for (int i = 0; i < 3; i++) {
            if (a[i] != b[i]) {
                return Integer.compare(a[i], b[i]);
            }
        }
        return 0;
    }
}
