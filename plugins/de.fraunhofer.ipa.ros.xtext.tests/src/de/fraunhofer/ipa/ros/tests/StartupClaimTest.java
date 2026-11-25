package de.fraunhofer.ipa.ros.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.google.inject.Guice;
import com.google.inject.Injector;
import de.fraunhofer.ipa.ros.BasicsStandaloneSetup;
import de.fraunhofer.ipa.ros.RosStandaloneSetup;
import de.fraunhofer.ipa.ros.plugin.spi.BlockDescriptor;
import de.fraunhofer.ipa.ros.plugin.spi.PluginRegistry;
import de.fraunhofer.ipa.ros.plugin.spi.RosToolingPlugin;
import de.fraunhofer.ipa.ros.plugin.spi.StartupClaim;
import de.fraunhofer.ipa.ros.plugin.spi.SystemGenerationContext;
import de.fraunhofer.ipa.ros.plugin.spi.ValidationContext;
import de.fraunhofer.ipa.ros2.Ros2RuntimeModule;
import de.fraunhofer.ipa.ros2.Ros2StandaloneSetup;
import de.fraunhofer.ipa.rossystem.RosSystemRuntimeModule;
import de.fraunhofer.ipa.rossystem.RosSystemStandaloneSetup;
import de.fraunhofer.ipa.rossystem.generator.RosSystemGenerator;
import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.generator.InMemoryFileSystemAccess;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/** Plugin startup claims: a plugin starts a node or subsystem itself, core switches it by a launch argument. */
public class StartupClaimTest {

    private Injector rosSystemInjector;

    @Before
    public void setUp() {
        PluginRegistry.INSTANCE.clearRegistered();
        BasicsStandaloneSetup.doSetup();
        RosStandaloneSetup.doSetup();
        new Ros2StandaloneSetup() {
            @Override
            public Injector createInjector() {
                return Guice.createInjector(new Ros2RuntimeModule());
            }
        }.createInjectorAndDoEMFRegistration();
        rosSystemInjector = new RosSystemStandaloneSetup() {
            @Override
            public Injector createInjector() {
                return Guice.createInjector(new RosSystemRuntimeModule());
            }
        }.createInjectorAndDoEMFRegistration();
    }

    @After
    public void tearDown() {
        PluginRegistry.INSTANCE.clearRegistered();
    }

    private Resource load(final String body) throws Exception {
        XtextResourceSet rs = rosSystemInjector.getInstance(XtextResourceSet.class);
        res(rs, "inmemory:/claim_type.ros2", """
                claim_type:
                  artifacts:
                    cam_art:
                      node: cam_node
                    lid_art:
                      node: lid_node
                """);
        res(rs, "inmemory:/inner_sys.rossystem", """
                inner_sys:
                  nodes:
                    inner_cam:
                      from: "claim_type.cam_node"
                """);
        res(rs, "inmemory:/mid_sys.rossystem", """
                mid_sys:
                  nodes:
                    mid_cam:
                      from: "claim_type.cam_node"
                  subSystems:
                    inner_sys
                """);
        Resource sys = res(rs, "inmemory:/claim_sys.rossystem", body);
        EcoreUtil.resolveAll(rs);
        return sys;
    }

    private static Resource res(final XtextResourceSet rs, final String uri, final String content) throws Exception {
        Resource r = rs.createResource(URI.createURI(uri));
        r.load(new ByteArrayInputStream(content.getBytes(StandardCharsets.UTF_8)), null);
        return r;
    }

    private static final String SYSTEM = """
            claim_sys:
              nodes:
                camera:
                  from: "claim_type.cam_node"
                lidar:
                  from: "claim_type.lid_node"
              subSystems:
                inner_sys
            """;

    private static final String SYSTEM_PROCESS = """
            claim_sys:
              processes:
                box:
                  nodes: [ camera ]
                  threads: 1
              nodes:
                camera:
                  from: "claim_type.cam_node"
                lidar:
                  from: "claim_type.lid_node"
            """;

    private static RosToolingPlugin plugin(final String id, final List<StartupClaim> claims,
            final Function<SystemGenerationContext, Void> gen) {
        return new RosToolingPlugin() {
            @Override public String id() { return id; }
            @Override public List<BlockDescriptor> blocks() { return List.of(); }
            @Override public void validate(final ValidationContext context) {}
            @Override public List<StartupClaim> startupClaims(final SystemGenerationContext c) { return claims; }
            @Override public void generateSystem(final SystemGenerationContext c) { if (gen != null) gen.apply(c); }
        };
    }

    private RosSystemGenerator.SystemGenerationOutcome run(final Resource r, final InMemoryFileSystemAccess fsa) {
        return rosSystemInjector.getInstance(RosSystemGenerator.class)
                .generateSystemWithPlugins(r, fsa, List.of(), "jazzy");
    }

    private static String launch(final InMemoryFileSystemAccess fsa) {
        return launch(fsa, "claim_sys");
    }

    private static String launch(final InMemoryFileSystemAccess fsa, final String system) {
        return fsa.getTextFiles().get("DEFAULT_OUTPUT" + system + "/launch/" + system + ".launch.py").toString();
    }

    private static final String SWITCH = "run_claimed_natively";

    /** Default of a claim argument: false when the switch is true, else the model default. */
    private static String defaultOf(final String arg, final boolean modelDefault) {
        return "\"" + arg + "\",\n    default_value=PythonExpression([\"'false' if '\", LaunchConfiguration(\"" + SWITCH
                + "\"), \"'.lower() == 'true' else '" + modelDefault + "'\"]),";
    }

    private static String readme(final InMemoryFileSystemAccess fsa) {
        return fsa.getTextFiles().get("DEFAULT_OUTPUTclaim_sys/README.md").toString();
    }

    private static String actionBlock(final String launch, final String var) {
        java.util.regex.Matcher m = java.util.regex.Pattern.compile("(?m)^  " + var + " ?= ").matcher(launch);
        int start = m.find() ? m.start() : -1;
        assertTrue(var + " defined in\n" + launch, start >= 0);
        return launch.substring(start, launch.indexOf("\n  )\n", start));
    }

    @Test
    public void claimedNodeDefaultTrue() throws Exception {
        PluginRegistry.INSTANCE.register(plugin("de.example.runner", List.of(new StartupClaim("camera", true)), null));
        InMemoryFileSystemAccess fsa = new InMemoryFileSystemAccess();
        var out = run(load(SYSTEM), fsa);
        assertTrue(out.errors.toString(), out.errors.isEmpty());
        String l = launch(fsa);
        assertTrue(l, l.contains("from launch.conditions import UnlessCondition"));
        assertTrue(l, l.contains(defaultOf("camera_in_runner", true)));
        assertTrue(l, l.contains("\"run_claimed_natively\", default_value=\"false\""));
        assertTrue(l, l.contains("description=\"Start every element claimed by a plugin natively, including those inside subsystems\""));
        assertTrue("switch declared before the claim", l.indexOf("run_claimed_natively_arg = ") < l.indexOf("camera_in_runner_arg = "));
        assertEquals("switch declared once", 1, l.split("run_claimed_natively_arg = ", -1).length - 1);
        assertTrue(l, l.contains("DeclareLaunchArgument("));
        assertTrue(actionBlock(l, "camera"),
                actionBlock(l, "camera").contains("condition=UnlessCondition(LaunchConfiguration('camera_in_runner'))"));
        assertFalse(actionBlock(l, "lidar").contains("UnlessCondition"));
        assertEquals("only one condition", 1, l.split("condition=UnlessCondition", -1).length - 1);
        String r = readme(fsa);
        assertTrue(r, r.contains("## Elements started by plugins"));
        assertTrue(r, r.contains("`camera`: argument `camera_in_runner` (default `true`, started by plugin `de.example.runner`)"));
        assertTrue(r, r.contains("camera_in_runner:=false"));
        assertTrue(r, r.contains("run_claimed_natively:=true"));
    }

    @Test
    public void claimedNodeDefaultFalse() throws Exception {
        PluginRegistry.INSTANCE.register(plugin("de.example.runner", List.of(new StartupClaim("lidar", false)), null));
        InMemoryFileSystemAccess fsa = new InMemoryFileSystemAccess();
        var out = run(load(SYSTEM), fsa);
        assertTrue(out.errors.toString(), out.errors.isEmpty());
        String l = launch(fsa);
        assertTrue(l, l.contains(defaultOf("lidar_in_runner", false)));
        assertTrue(actionBlock(l, "lidar").contains("UnlessCondition(LaunchConfiguration('lidar_in_runner'))"));
        assertFalse(actionBlock(l, "camera").contains("UnlessCondition"));
        assertTrue(readme(fsa), readme(fsa).contains("(default `false`"));
    }

    @Test
    public void claimedSubsystem() throws Exception {
        PluginRegistry.INSTANCE.register(plugin("de.example.runner", List.of(new StartupClaim("inner_sys", true)), null));
        InMemoryFileSystemAccess fsa = new InMemoryFileSystemAccess();
        var out = run(load(SYSTEM), fsa);
        assertTrue(out.errors.toString(), out.errors.isEmpty());
        String l = launch(fsa);
        assertTrue(l, l.contains(defaultOf("inner_sys_in_runner", true)));
        String inc = actionBlock(l, "include_inner_sys_native");
        assertTrue(inc, inc.contains("launch_arguments={\n      'run_claimed_natively': 'true',\n    }.items()"));
        assertTrue(inc, inc.contains("IncludeLaunchDescription("));
        assertFalse("the condition sits on the group", inc.contains("condition"));
        assertEquals("  include_inner_sys = GroupAction(\n    actions=[include_inner_sys_native],\n    scoped=True,\n"
                + "    condition=UnlessCondition(LaunchConfiguration('inner_sys_in_runner'))", actionBlock(l, "include_inner_sys"));
        assertTrue(l, l.contains("from launch.actions import GroupAction, IncludeLaunchDescription"));
        assertTrue(l, l.contains("ld.add_action(include_inner_sys)"));
        assertFalse(actionBlock(l, "camera").contains("UnlessCondition"));
        assertTrue(readme(fsa), readme(fsa).contains("`inner_sys`: argument `inner_sys_in_runner`"));
    }

    @Test
    public void unclaimedSubsystemIncludeIsUnchanged() throws Exception {
        PluginRegistry.INSTANCE.register(plugin("de.example.runner", List.of(new StartupClaim("camera", true)), null));
        InMemoryFileSystemAccess fsa = new InMemoryFileSystemAccess();
        var out = run(load(SYSTEM), fsa);
        assertTrue(out.errors.toString(), out.errors.isEmpty());
        String inc = actionBlock(launch(fsa), "include_inner_sys");
        assertFalse(inc, inc.contains(SWITCH));
        assertFalse(inc, inc.contains("launch_arguments"));
        assertFalse(inc, inc.contains("condition"));
        InMemoryFileSystemAccess plain = new InMemoryFileSystemAccess();
        PluginRegistry.INSTANCE.clearRegistered();
        run(load(SYSTEM), plain);
        assertEquals(actionBlock(launch(plain), "include_inner_sys"), inc);
    }

    /** The claimed native include is scoped, so the switch it sets does not reach the sibling includes after it. */
    @Test
    public void claimedSubsystemDoesNotLeakTheSwitchIntoItsSiblings() throws Exception {
        String two = """
                claim_sys:
                  nodes:
                    camera:
                      from: "claim_type.cam_node"
                  subSystems:
                    inner_sys
                    mid_sys
                """;
        InMemoryFileSystemAccess plain = new InMemoryFileSystemAccess();
        run(load(two), plain);
        PluginRegistry.INSTANCE.register(plugin("de.example.runner", List.of(new StartupClaim("inner_sys", true)), null));
        InMemoryFileSystemAccess fsa = new InMemoryFileSystemAccess();
        var out = run(load(two), fsa);
        assertTrue(out.errors.toString(), out.errors.isEmpty());
        String l = launch(fsa);
        assertTrue(l, l.contains("scoped=True"));
        assertEquals("only the claimed include carries the switch", 1, l.split("'run_claimed_natively': 'true'", -1).length - 1);
        assertEquals("sibling include unchanged", actionBlock(launch(plain), "include_mid_sys"), actionBlock(l, "include_mid_sys"));
        assertFalse(actionBlock(l, "include_mid_sys").contains("GroupAction"));
        assertTrue("claimed group is added before the sibling",
                l.indexOf("ld.add_action(include_inner_sys)") < l.indexOf("ld.add_action(include_mid_sys)"));
    }

    @Test
    public void claimedSubsystemWithParametersMergesSwitchAfterThem() throws Exception {
        PluginRegistry.INSTANCE.register(plugin("de.example.runner", List.of(new StartupClaim("inner_sys", true)), null));
        InMemoryFileSystemAccess fsa = new InMemoryFileSystemAccess();
        String body = SYSTEM.replace("claim_sys:\n", "claim_sys:\n  parameters:\n    speed:\n      type: Integer\n      value: 1\n");
        var out = run(loadWithInnerParameter(body), fsa);
        assertTrue(out.errors.toString(), out.errors.isEmpty());
        String inc = actionBlock(launch(fsa), "include_inner_sys_native");
        int p = inc.indexOf("'speed': LaunchConfiguration('speed')");
        int sw = inc.indexOf("'run_claimed_natively': 'true'");
        assertTrue(inc, p >= 0 && sw > p);
        assertEquals("only the matching parameter and the switch", 2, inc.split("': ", -1).length - 1);
    }

    private Resource loadWithInnerParameter(final String body) throws Exception {
        XtextResourceSet rs = rosSystemInjector.getInstance(XtextResourceSet.class);
        res(rs, "inmemory:/claim_type.ros2", """
                claim_type:
                  artifacts:
                    cam_art:
                      node: cam_node
                      parameters:
                        speed:
                          type: Integer
                    lid_art:
                      node: lid_node
                """);
        res(rs, "inmemory:/inner_sys.rossystem", """
                inner_sys:
                  nodes:
                    inner_cam:
                      from: "claim_type.cam_node"
                """);
        Resource sys = res(rs, "inmemory:/claim_sys.rossystem", body);
        EcoreUtil.resolveAll(rs);
        return sys;
    }

    /** A plugin claiming the subsystem of every system and the camera node of the generated one. */
    private static RosToolingPlugin nestedPlugin(final java.util.concurrent.atomic.AtomicInteger calls) {
        return new RosToolingPlugin() {
            @Override public String id() { return "de.example.runner"; }
            @Override public List<BlockDescriptor> blocks() { return List.of(); }
            @Override public void validate(final ValidationContext context) {}
            @Override public List<StartupClaim> startupClaims(final SystemGenerationContext c) {
                calls.incrementAndGet();
                String name = ((system.System) c.systemModel()).getName();
                return switch (name) {
                    case "claim_sys" -> List.of(new StartupClaim("mid_sys", true));
                    case "mid_sys" -> List.of(new StartupClaim("inner_sys", true), new StartupClaim("mid_cam", true));
                    default -> List.of();
                };
            }
        };
    }

    @Test
    public void nestedClaimedSubsystemsEachPassTheSwitchOn() throws Exception {
        var calls = new java.util.concurrent.atomic.AtomicInteger();
        PluginRegistry.INSTANCE.register(nestedPlugin(calls));
        String top = """
                claim_sys:
                  nodes:
                    camera:
                      from: "claim_type.cam_node"
                  subSystems:
                    mid_sys
                """;
        InMemoryFileSystemAccess fsa = new InMemoryFileSystemAccess();
        var out = run(load(top), fsa);
        assertTrue(out.errors.toString(), out.errors.isEmpty());
        assertEquals("startupClaims called once per system", 1, calls.get());
        String l = launch(fsa);
        assertTrue(actionBlock(l, "include_mid_sys_native").contains("'run_claimed_natively': 'true'"));

        // the claimed subsystem is generated on its own: it declares the switch itself and passes it on
        calls.set(0);
        InMemoryFileSystemAccess midFsa = new InMemoryFileSystemAccess();
        Resource mid = loadMid();
        var midOut = run(mid, midFsa);
        assertTrue(midOut.errors.toString(), midOut.errors.isEmpty());
        assertEquals(1, calls.get());
        String m = launch(midFsa, "mid_sys");
        assertTrue(m, m.contains("run_claimed_natively_arg = "));
        assertTrue(m, m.contains(defaultOf("inner_sys_in_runner", true)));
        assertTrue(m, m.contains(defaultOf("mid_cam_in_runner", true)));
        assertTrue(actionBlock(m, "include_inner_sys_native").contains("'run_claimed_natively': 'true'"));
        assertTrue(actionBlock(m, "mid_cam").contains("UnlessCondition(LaunchConfiguration('mid_cam_in_runner'))"));
    }

    private Resource loadMid() throws Exception {
        XtextResourceSet rs = rosSystemInjector.getInstance(XtextResourceSet.class);
        res(rs, "inmemory:/claim_type.ros2", """
                claim_type:
                  artifacts:
                    cam_art:
                      node: cam_node
                """);
        res(rs, "inmemory:/inner_sys.rossystem", """
                inner_sys:
                  nodes:
                    inner_cam:
                      from: "claim_type.cam_node"
                """);
        Resource mid = res(rs, "inmemory:/mid_sys.rossystem", """
                mid_sys:
                  nodes:
                    mid_cam:
                      from: "claim_type.cam_node"
                  subSystems:
                    inner_sys
                """);
        EcoreUtil.resolveAll(rs);
        return mid;
    }

    @Test
    public void startupClaimsIsCalledOncePerSystem() throws Exception {
        var calls = new java.util.concurrent.atomic.AtomicInteger();
        PluginRegistry.INSTANCE.register(new RosToolingPlugin() {
            @Override public String id() { return "de.example.runner"; }
            @Override public List<BlockDescriptor> blocks() { return List.of(); }
            @Override public void validate(final ValidationContext context) {}
            @Override public List<StartupClaim> startupClaims(final SystemGenerationContext c) {
                calls.incrementAndGet();
                return List.of(new StartupClaim("inner_sys", true));
            }
        });
        var out = run(load(SYSTEM), new InMemoryFileSystemAccess());
        assertTrue(out.errors.toString(), out.errors.isEmpty());
        assertEquals(1, calls.get());
    }

    @Test
    public void parameterNamedLikeTheSwitchIsAnError() throws Exception {
        PluginRegistry.INSTANCE.register(plugin("de.example.runner", List.of(new StartupClaim("camera", true)), null));
        String body = SYSTEM.replace("claim_sys:\n", "claim_sys:\n  parameters:\n    run_claimed_natively:\n      type: Boolean\n      value: true\n");
        var out = run(load(body), new InMemoryFileSystemAccess());
        assertTrue(out.errors.toString(), out.errors.stream().anyMatch(e ->
                e.contains("run_claimed_natively") && e.contains("claim_sys")));
        assertFalse(out.pluginConflictErrors.isEmpty());
    }

    @Test
    public void parameterNamedLikeTheSwitchIsFineWithoutClaims() throws Exception {
        PluginRegistry.INSTANCE.register(plugin("de.example.runner", List.of(), null));
        String body = SYSTEM.replace("claim_sys:\n", "claim_sys:\n  parameters:\n    run_claimed_natively:\n      type: Boolean\n      value: true\n");
        var out = run(load(body), new InMemoryFileSystemAccess());
        assertTrue(out.errors.toString(), out.errors.isEmpty());
    }

    @Test
    public void argumentNameClashMentionsTheNamingScheme() throws Exception {
        PluginRegistry.INSTANCE.register(plugin("de.example.runner", List.of(new StartupClaim("camera", true)), null));
        String body = SYSTEM.replace("claim_sys:\n", "claim_sys:\n  parameters:\n    camera_in_runner:\n      type: Integer\n      value: 1\n");
        var out = run(load(body), new InMemoryFileSystemAccess());
        assertTrue(out.errors.toString(), out.errors.stream().anyMatch(e ->
                e.contains("camera_in_runner") && e.contains("last segment of the plugin id")));
    }

    @Test
    public void claimConflictFailsTheRunLikeOtherPluginConflicts() throws Exception {
        PluginRegistry.INSTANCE.register(plugin("de.example.one.runner", List.of(new StartupClaim("camera", true)), null));
        PluginRegistry.INSTANCE.register(plugin("de.example.two.runner", List.of(new StartupClaim("camera", true)), null));
        var out = run(load(SYSTEM), new InMemoryFileSystemAccess());
        assertFalse(out.errors.isEmpty());
        assertEquals(out.errors, out.pluginConflictErrors);
    }

    @Test
    public void claimContextExposesArgumentsAndSwitch() throws Exception {
        PluginRegistry.INSTANCE.register(plugin("de.example.runner", List.of(new StartupClaim("camera", true)), c -> {
            assertTrue(c.declaredSystemLaunchArguments().contains("camera_in_runner"));
            assertTrue(c.declaredSystemLaunchArguments().contains(StartupClaim.NATIVE_SWITCH_ARGUMENT));
            assertEquals(null, c.startupClaimArgument("lidar"));
            return null;
        }));
        var out = run(load(SYSTEM), new InMemoryFileSystemAccess());
        assertTrue(out.errors.toString(), out.errors.isEmpty());
    }

    @Test
    public void pluginForwardsClaimArgumentIntoItsInclude() throws Exception {
        PluginRegistry.INSTANCE.register(plugin("de.example.fwd.box_runner", List.of(new StartupClaim("camera", true)), c -> {
            String arg = c.startupClaimArgument("camera");
            assertEquals("camera_in_box_runner", arg);
            assertTrue(c.declaredSystemLaunchArguments().contains(arg));
            c.writeFile("launch/" + c.pluginFolder() + "/run.launch.py", "# run");
            c.addLaunchInclude("launch/" + c.pluginFolder() + "/run.launch.py", List.of(
                    new SystemGenerationContext.LaunchArgument("enabled",
                            SystemGenerationContext.LaunchArgumentValue.systemLaunchArgument(arg))));
            return null;
        }));
        InMemoryFileSystemAccess fsa = new InMemoryFileSystemAccess();
        var out = run(load(SYSTEM), fsa);
        assertTrue(out.errors.toString(), out.errors.isEmpty());
        String l = launch(fsa);
        assertTrue(l, l.contains("'enabled': LaunchConfiguration('camera_in_box_runner')"));
        assertTrue(l, l.contains("scoped=True"));
        assertFalse(out.pluginFiles.isEmpty());
    }

    @Test
    public void unknownElementIsAnError() throws Exception {
        PluginRegistry.INSTANCE.register(plugin("de.example.runner", List.of(new StartupClaim("ghost", true)), null));
        var out = run(load(SYSTEM), new InMemoryFileSystemAccess());
        assertTrue(out.errors.toString(), out.errors.stream().anyMatch(e ->
                e.contains("de.example.runner") && e.contains("unknown element 'ghost'")));
    }

    @Test
    public void twoPluginsClaimingOneElementIsAnError() throws Exception {
        PluginRegistry.INSTANCE.register(plugin("de.example.one", List.of(new StartupClaim("camera", true)), null));
        PluginRegistry.INSTANCE.register(plugin("de.example.two", List.of(new StartupClaim("camera", false)), null));
        InMemoryFileSystemAccess fsa = new InMemoryFileSystemAccess();
        var out = run(load(SYSTEM), fsa);
        assertTrue(out.errors.toString(), out.errors.stream().anyMatch(e ->
                e.contains("de.example.one") && e.contains("de.example.two") && e.contains("'camera'")));
        assertFalse("conflicted claims are not rendered", launch(fsa).contains("UnlessCondition"));
    }

    @Test
    public void duplicateClaimFromOnePluginIsAnError() throws Exception {
        PluginRegistry.INSTANCE.register(plugin("de.example.runner",
                List.of(new StartupClaim("camera", true), new StartupClaim("camera", true)), null));
        var out = run(load(SYSTEM), new InMemoryFileSystemAccess());
        assertTrue(out.errors.toString(), out.errors.stream().anyMatch(e ->
                e.contains("de.example.runner") && e.contains("more than once")));
    }

    @Test
    public void nodeInsideProcessIsAnError() throws Exception {
        PluginRegistry.INSTANCE.register(plugin("de.example.runner", List.of(new StartupClaim("camera", true)), null));
        var out = run(load(SYSTEM_PROCESS), new InMemoryFileSystemAccess());
        assertTrue(out.errors.toString(), out.errors.stream().anyMatch(e ->
                e.contains("'camera'") && e.contains("processes:")));
    }

    @Test
    public void noClaimsOutputEqualsNoPluginOutput() throws Exception {
        InMemoryFileSystemAccess plain = new InMemoryFileSystemAccess();
        run(load(SYSTEM), plain);
        PluginRegistry.INSTANCE.register(plugin("de.example.runner", List.of(), null));
        InMemoryFileSystemAccess withPlugin = new InMemoryFileSystemAccess();
        var out = run(load(SYSTEM), withPlugin);
        assertTrue(out.errors.toString(), out.errors.isEmpty());
        assertEquals(plain.getTextFiles(), withPlugin.getTextFiles());
        assertFalse(launch(withPlugin).contains("UnlessCondition"));
        assertFalse(launch(withPlugin).contains(SWITCH));
        assertFalse(readme(withPlugin).contains(SWITCH));
        assertFalse(readme(withPlugin).contains("Elements started by plugins"));
        String dump = System.getenv("STARTUP_CLAIM_DUMP");
        if (dump != null) {
            PluginRegistry.INSTANCE.clearRegistered();
            PluginRegistry.INSTANCE.register(plugin("de.example.runner",
                    List.of(new StartupClaim("camera", true), new StartupClaim("inner_sys", false)), null));
            InMemoryFileSystemAccess f = new InMemoryFileSystemAccess();
            run(load(SYSTEM), f);
            Path p = Path.of(dump);
            Files.createDirectories(p);
            Files.writeString(p.resolve("claim_sys.launch.py"), launch(f));
            Files.writeString(p.resolve("README.md"), readme(f));
        }
    }
}
