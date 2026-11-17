package de.fraunhofer.ipa.ros.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.google.inject.Guice;
import com.google.inject.Injector;
import de.fraunhofer.ipa.ros.BasicsStandaloneSetup;
import de.fraunhofer.ipa.ros.RosStandaloneSetup;
import de.fraunhofer.ipa.ros.plugin.spi.PluginRegistry;
import de.fraunhofer.ipa.ros.validation.RosValidator;
import de.fraunhofer.ipa.ros2.Ros2RuntimeModule;
import de.fraunhofer.ipa.ros2.Ros2StandaloneSetup;
import de.fraunhofer.ipa.ros2.generator.Ros2Generator;
import de.fraunhofer.ipa.rossystem.RosSystemRuntimeModule;
import de.fraunhofer.ipa.rossystem.RosSystemStandaloneSetup;
import de.fraunhofer.ipa.rossystem.generator.RosSystemGenerator;
import de.fraunhofer.ipa.rossystem.validation.RosSystemValidator;
import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.generator.InMemoryFileSystemAccess;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
import org.junit.Before;
import org.junit.Test;
import ros.AmentPackage;
import ros.PluginLoader;

/**
 * Phase 1 verification tests: core ROS 2 {@code pluginlib} and {@code external} plugins,
 * {@code pluginslots:} on host nodes, node-less plugin artifacts, and {@code RosNode.plugins}
 * host-rule wiring, validation, and launch/CMake generation.
 */
public class PluginArchitecturePhase1Test {

    private Injector ros2Injector;
    private Injector rosSystemInjector;

    @Before
    public void setUp() {
        PluginRegistry.INSTANCE.clearRegistered();
        BasicsStandaloneSetup.doSetup();
        RosStandaloneSetup.doSetup();
        ros2Injector = new Ros2StandaloneSetup() {
            @Override
            public Injector createInjector() {
                return Guice.createInjector(new Ros2RuntimeModule() {
                    @Override
                    public ClassLoader bindClassLoaderToInstance() {
                        return PluginArchitecturePhase1Test.class.getClassLoader();
                    }
                });
            }
        }.createInjectorAndDoEMFRegistration();
        rosSystemInjector = new RosSystemStandaloneSetup() {
            @Override
            public Injector createInjector() {
                return Guice.createInjector(new RosSystemRuntimeModule() {
                    @Override
                    public ClassLoader bindClassLoaderToInstance() {
                        return PluginArchitecturePhase1Test.class.getClassLoader();
                    }
                });
            }
        }.createInjectorAndDoEMFRegistration();
    }

    private static Resource loadFromString(
            final XtextResourceSet rs, final String uriStr, final String content) throws Exception {
        Resource res = rs.createResource(URI.createURI(uriStr));
        res.load(new ByteArrayInputStream(content.getBytes(StandardCharsets.UTF_8)), null);
        return res;
    }

    private List<Issue> validate(final Injector inj, final Resource res) {
        return inj.getInstance(IResourceValidator.class)
                .validate(res, CheckMode.ALL, CancelIndicator.NullImpl);
    }

    private static String stdMsgsSpec() {
        return """
                std_msgs:
                  msgs:
                    String
                      message
                        string data
                example_interfaces:
                  actions:
                    ComputePath
                      goal
                        string target
                      result
                        bool ok
                      feedback
                        float32 progress
                """;
    }

    private static String hostPkgModel() {
        return """
                planner_host_pkg:
                  artifacts:
                    planner_server:
                      node: planner_server
                      publishers:
                        status:
                          type: "std_msgs/msg/String"
                      parameters:
                        planner_plugin:
                          type: String
                        extra_plugins:
                          type: Array [ String ]
                      pluginslots:
                        global_planner:
                          base: "nav2_core::GlobalPlanner"
                          parameter: planner_plugin
                          default: "planner_plugins_pkg::StraightLine"
                """;
    }

    private static String validPluginlibPkgModel() {
        return """
                planner_plugins_pkg:
                  artifacts:
                    straight_line_planner:
                      plugins:
                        StraightLine:
                          implements: "nav2_core::GlobalPlanner"
                          loader: pluginlib
                          publishers:
                            plan_debug:
                              type: "std_msgs/msg/String"
                          parameters:
                            step_size:
                              type: Double
                              default: 0.1
                """;
    }

    @Test
    public void parseAndValidatePluginlibAndPluginSlot() throws Exception {
        XtextResourceSet rs = ros2Injector.getInstance(XtextResourceSet.class);
        loadFromString(rs, "inmemory:/std_msgs.ros", stdMsgsSpec());
        Resource hostRes = loadFromString(rs, "inmemory:/planner_host.ros2", hostPkgModel());
        Resource plugRes = loadFromString(rs, "inmemory:/planner_plugins.ros2", validPluginlibPkgModel());
        EcoreUtil.resolveAll(rs);

        List<Issue> hostErrors = validate(ros2Injector, hostRes).stream()
                .filter(i -> i.getSeverity() == Severity.ERROR).toList();
        List<Issue> plugErrors = validate(ros2Injector, plugRes).stream()
                .filter(i -> i.getSeverity() == Severity.ERROR).toList();
        assertTrue("Host validation errors: " + hostErrors, hostErrors.isEmpty());
        assertTrue("Plugin validation errors: " + plugErrors, plugErrors.isEmpty());

        AmentPackage pkg = (AmentPackage) plugRes.getContents().get(0);
        assertEquals(1, pkg.getArtifact().size());
        assertEquals(null, pkg.getArtifact().get(0).getNode());
        assertEquals(1, pkg.getArtifact().get(0).getPlugins().size());
        assertEquals(PluginLoader.PLUGINLIB, pkg.getArtifact().get(0).getPlugins().get(0).getLoader());
    }

    @Test
    public void validateRejectsMissingImplementsAndInvalidSlots() throws Exception {
        XtextResourceSet rs = ros2Injector.getInstance(XtextResourceSet.class);
        loadFromString(rs, "inmemory:/std_msgs.ros", stdMsgsSpec());
        Resource badPlugRes = loadFromString(rs, "inmemory:/bad_plug.ros2", """
                bad_plug_pkg:
                  artifacts:
                    bad_lib:
                      plugins:
                        BrokenPlugin:
                          loader: pluginlib
                """);
        Resource badSlotRes = loadFromString(rs, "inmemory:/bad_slot.ros2", """
                bad_slot_pkg:
                  artifacts:
                    host:
                      node: host
                      parameters:
                        count:
                          type: Integer
                      pluginslots:
                        s1:
                          base: "NoNamespaceBase"
                          parameter: missing_param
                        s2:
                          base: "pkg::GoodBase"
                          parameter: count
                """);
        EcoreUtil.resolveAll(rs);

        List<Issue> plugIssues = validate(ros2Injector, badPlugRes);
        assertTrue(plugIssues.stream().anyMatch(i ->
                i.getSeverity() == Severity.ERROR
                        && RosValidator.PLUGIN_MISSING_IMPLEMENTS.equals(i.getCode())));

        List<Issue> slotIssues = validate(ros2Injector, badSlotRes);
        assertTrue(slotIssues.stream().anyMatch(i -> RosValidator.SLOT_INVALID_BASE.equals(i.getCode())));
        assertTrue(slotIssues.stream().anyMatch(i -> RosValidator.SLOT_MISSING_PARAM.equals(i.getCode())));
        assertTrue(slotIssues.stream().anyMatch(i -> RosValidator.SLOT_INVALID_PARAM_TYPE.equals(i.getCode())));
    }

    @Test
    public void generatePluginlibArtifactsAndRespectDomainLogicShield() throws Exception {
        XtextResourceSet rs = ros2Injector.getInstance(XtextResourceSet.class);
        loadFromString(rs, "inmemory:/std_msgs.ros", stdMsgsSpec());
        Resource plugRes = loadFromString(rs, "inmemory:/planner_plugins.ros2", validPluginlibPkgModel());
        EcoreUtil.resolveAll(rs);

        Ros2Generator gen = ros2Injector.getInstance(Ros2Generator.class);
        InMemoryFileSystemAccess fsa = new InMemoryFileSystemAccess();
        gen.generateTargeted(plugRes, fsa, null, "cpp", "jazzy", List.of());

        String wrapperKey = "DEFAULT_OUTPUTplanner_plugins_pkg/include/planner_plugins_pkg/straight_line_plugin_wrapper.hpp";
        String userKey = "DEFAULT_OUTPUTplanner_plugins_pkg/include/planner_plugins_pkg/straight_line_plugin.hpp";
        String cppKey = "DEFAULT_OUTPUTplanner_plugins_pkg/src/straight_line_plugin.cpp";
        String xmlKey = "DEFAULT_OUTPUTplanner_plugins_pkg/plugins.xml";
        String cmakeKey = "DEFAULT_OUTPUTplanner_plugins_pkg/CMakeLists.txt";
        String pkgXmlKey = "DEFAULT_OUTPUTplanner_plugins_pkg/package.xml";

        assertTrue(fsa.getTextFiles().containsKey(wrapperKey));
        assertTrue(fsa.getTextFiles().containsKey(userKey));
        assertTrue(fsa.getTextFiles().containsKey(cppKey));
        assertTrue(fsa.getTextFiles().containsKey(xmlKey));
        assertTrue(fsa.getTextFiles().containsKey(cmakeKey));
        assertTrue(fsa.getTextFiles().containsKey(pkgXmlKey));

        String userHpp = fsa.getTextFiles().get(userKey).toString();
        assertTrue(userHpp.contains("#include \"nav2_core/global_planner.hpp\""));
        assertTrue(userHpp.contains("class StraightLine : public nav2_core::GlobalPlanner"));

        String cpp = fsa.getTextFiles().get(cppKey).toString();
        assertTrue(cpp.contains("PLUGINLIB_EXPORT_CLASS(planner_plugins_pkg::StraightLine, nav2_core::GlobalPlanner)"));

        String pluginsXml = fsa.getTextFiles().get(xmlKey).toString();
        assertTrue(pluginsXml.contains("<library path=\"straight_line_planner\">"));
        assertTrue(pluginsXml.contains("name=\"planner_plugins_pkg::StraightLine\""));
        assertTrue(pluginsXml.contains("base_class_type=\"nav2_core::GlobalPlanner\""));

        String cmake = fsa.getTextFiles().get(cmakeKey).toString();
        assertTrue(cmake.contains("find_package(pluginlib REQUIRED)"));
        assertTrue(cmake.contains("find_package(nav2_core REQUIRED)"));
        assertTrue(cmake.contains("add_library(straight_line_planner SHARED"));
        assertTrue(cmake.contains("pluginlib_export_plugin_description_file(nav2_core plugins.xml)"));

        String pkgXml = fsa.getTextFiles().get(pkgXmlKey).toString();
        assertTrue(pkgXml.contains("<depend>pluginlib</depend>"));
        assertTrue(pkgXml.contains("<depend>nav2_core</depend>"));
        assertTrue(pkgXml.contains("<depend>std_msgs</depend>"));

        // Second generation pass with existing user skeleton header MUST NOT overwrite it (Rule 7).
        InMemoryFileSystemAccess fsaSecond = new InMemoryFileSystemAccess();
        gen.generateTargeted(
                plugRes,
                fsaSecond,
                null,
                "cpp",
                "jazzy",
                List.of("planner_plugins_pkg/include/planner_plugins_pkg/straight_line_plugin.hpp"));
        assertFalse(fsaSecond.getTextFiles().containsKey(userKey));
        assertTrue(fsaSecond.getTextFiles().containsKey(wrapperKey));
    }

    @Test
    public void generateExternalPluginEmitsNoClassOrPluginlibExport() throws Exception {
        XtextResourceSet rs = ros2Injector.getInstance(XtextResourceSet.class);
        loadFromString(rs, "inmemory:/std_msgs.ros", stdMsgsSpec());
        Resource extRes = loadFromString(rs, "inmemory:/ext_plugins.ros2", """
                ext_plugins_pkg:
                  artifacts:
                    ext_lib:
                      plugins:
                        MyExtPlugin:
                          loader: external
                          publishers:
                            out_topic:
                              type: "std_msgs/msg/String"
                """);
        EcoreUtil.resolveAll(rs);

        Ros2Generator gen = ros2Injector.getInstance(Ros2Generator.class);
        InMemoryFileSystemAccess fsa = new InMemoryFileSystemAccess();
        gen.generateTargeted(extRes, fsa, null, "cpp", "jazzy", List.of());

        String cmake = fsa.getTextFiles().get("DEFAULT_OUTPUText_plugins_pkg/CMakeLists.txt").toString();
        String pkgXml = fsa.getTextFiles().get("DEFAULT_OUTPUText_plugins_pkg/package.xml").toString();
        assertNotNull(cmake);
        assertNotNull(pkgXml);
        assertTrue(pkgXml.contains("<depend>std_msgs</depend>"));
        assertFalse(pkgXml.contains("<depend>pluginlib</depend>"));
        assertFalse(cmake.contains("pluginlib_export_plugin_description_file"));
        assertFalse(fsa.getTextFiles().keySet().stream().anyMatch(k -> k.endsWith("plugins.xml") || k.endsWith(".cpp") || k.endsWith(".hpp")));
    }

    @Test
    public void systemHostRuleExposesPluginInterfacesConnectsAndEmitsSlotParameter() throws Exception {
        XtextResourceSet rs = rosSystemInjector.getInstance(XtextResourceSet.class);
        loadFromString(rs, "inmemory:/std_msgs.ros", stdMsgsSpec());
        loadFromString(rs, "inmemory:/planner_host.ros2", hostPkgModel());
        loadFromString(rs, "inmemory:/planner_plugins.ros2", validPluginlibPkgModel());
        loadFromString(rs, "inmemory:/consumer.ros2", """
                consumer_pkg:
                  artifacts:
                    consumer_node:
                      node: consumer_node
                      subscribers:
                        plan_debug:
                          type: "std_msgs/msg/String"
                """);
        Resource sysRes = loadFromString(rs, "inmemory:/nav_sys.rossystem", """
                nav_sys:
                  nodes:
                    planner_inst:
                      from: "planner_host_pkg.planner_server"
                      plugins: ["planner_plugins_pkg.StraightLine"]
                    consumer_inst:
                      from: "consumer_pkg.consumer_node"
                  connections:
                    - [ "planner_inst::plan_debug" , "consumer_inst::plan_debug" ]
                """);
        EcoreUtil.resolveAll(rs);

        List<Issue> sysErrors = validate(rosSystemInjector, sysRes).stream()
                .filter(i -> i.getSeverity() == Severity.ERROR).toList();
        assertTrue("Unexpected system validation errors: " + sysErrors, sysErrors.isEmpty());

        RosSystemGenerator sysGen = rosSystemInjector.getInstance(RosSystemGenerator.class);
        InMemoryFileSystemAccess fsa = new InMemoryFileSystemAccess();
        sysGen.generateSystemTargeted(sysRes, fsa, List.of());

        String launch = fsa.getTextFiles().get("DEFAULT_OUTPUTnav_sys/launch/nav_sys.launch.py").toString();
        String pkgXml = fsa.getTextFiles().get("DEFAULT_OUTPUTnav_sys/package.xml").toString();
        assertTrue("Launch should emit selecting slot parameter: " + launch,
                launch.contains("\"planner_plugin\": ParameterValue(\"planner_plugins_pkg::StraightLine\", value_type=str)"));
        assertTrue("package.xml should depend on plugin package: " + pkgXml,
                pkgXml.contains("<exec_depend>planner_plugins_pkg</exec_depend>"));

        // Negative test: attaching pluginlib plugin to a host with NO matching slot produces error.
        Resource badSysRes = loadFromString(rs, "inmemory:/bad_nav_sys.rossystem", """
                bad_nav_sys:
                  nodes:
                    consumer_inst:
                      from: "consumer_pkg.consumer_node"
                      plugins: ["planner_plugins_pkg.StraightLine"]
                """);
        EcoreUtil.resolveAll(rs);
        List<Issue> badIssues = validate(rosSystemInjector, badSysRes);
        assertTrue(badIssues.stream().anyMatch(i ->
                i.getSeverity() == Severity.ERROR
                        && RosSystemValidator.INCOMPATIBLE_PLUGIN.equals(i.getCode())));
    }
}
