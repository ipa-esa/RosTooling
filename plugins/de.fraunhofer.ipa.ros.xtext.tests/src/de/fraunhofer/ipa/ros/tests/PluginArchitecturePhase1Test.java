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
import de.fraunhofer.ipa.ros2.distro.Ros2Distro;
import de.fraunhofer.ipa.ros2.distro.Ros2Distros;
import de.fraunhofer.ipa.ros2.distro.dialect.Ros2Target;
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
import ros.PluginBase;
import ros.PluginSlotValueFormat;

/**
 * Core ROS 2 plugin model: plugin bases ({@code pluginbases:}), {@code pluginlib} and
 * language-plugin loaders, {@code pluginslots:} on host nodes, plugin-only artifacts, and
 * {@code slots:} attachments in {@code .rossystem}, with validation and launch/CMake generation.
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
                std_srvs:
                  srvs:
                    Trigger
                      request
                      response
                        bool success
                        string message
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

    private static String navCoreModel() {
        return """
                nav2_core:
                  pluginbases:
                    GlobalPlanner:
                      class: "nav2_core::GlobalPlanner"
                      header: "nav2_core/global_planner.hpp"
                      loader: pluginlib
                """;
    }

    private static String customCoreModel() {
        return """
                custom_core:
                  pluginbases:
                    ActionBase:
                      class: "custom_core::ActionBase"
                      header: "custom_core/action_base.hpp"
                      loader: custom_loader
                    StrategyBase:
                      class: "custom_core::StrategyBase"
                      header: "custom_core/strategy_base.hpp"
                      loader: custom_loader
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
                          base: nav2_core.GlobalPlanner
                          parameter: planner_plugin
                          default: planner_plugins_pkg.StraightLine
                """;
    }

    private static String validPluginlibPkgModel() {
        return """
                planner_plugins_pkg:
                  artifacts:
                    straight_line_planner:
                      plugins:
                        StraightLine:
                          implements: nav2_core.GlobalPlanner
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
        Resource coreRes = loadFromString(rs, "inmemory:/nav2_core.ros2", navCoreModel());
        Resource hostRes = loadFromString(rs, "inmemory:/planner_host.ros2", hostPkgModel());
        Resource plugRes = loadFromString(rs, "inmemory:/planner_plugins.ros2", validPluginlibPkgModel());
        EcoreUtil.resolveAll(rs);

        List<Issue> coreErrors = validate(ros2Injector, coreRes).stream()
                .filter(i -> i.getSeverity() == Severity.ERROR).toList();
        assertTrue("Base package validation errors: " + coreErrors, coreErrors.isEmpty());
        PluginBase base = ((AmentPackage) coreRes.getContents().get(0)).getPluginBases().get(0);
        assertEquals("nav2_core::GlobalPlanner", base.getClassName());
        assertEquals("nav2_core/global_planner.hpp", base.getHeader());
        assertEquals("pluginlib", base.getLoader());

        List<Issue> hostErrors = validate(ros2Injector, hostRes).stream()
                .filter(i -> i.getSeverity() == Severity.ERROR).toList();
        List<Issue> plugErrors = validate(ros2Injector, plugRes).stream()
                .filter(i -> i.getSeverity() == Severity.ERROR).toList();
        assertTrue("Host validation errors: " + hostErrors, hostErrors.isEmpty());
        assertTrue("Plugin validation errors: " + plugErrors, plugErrors.isEmpty());

        AmentPackage hostPkg = (AmentPackage) hostRes.getContents().get(0);
        ros.PluginSlot slot = hostPkg.getArtifact().get(0).getNode().getPluginSlots().get(0);
        assertEquals(PluginSlotValueFormat.CLASS, slot.getValueFormat());
        assertEquals(base, slot.getBase());
        assertFalse(slot.isMultiple());

        AmentPackage pkg = (AmentPackage) plugRes.getContents().get(0);
        assertEquals(1, pkg.getArtifact().size());
        assertEquals(null, pkg.getArtifact().get(0).getNode());
        assertEquals(1, pkg.getArtifact().get(0).getPlugins().size());
        assertEquals(base, pkg.getArtifact().get(0).getPlugins().get(0).getImplements());
        assertEquals(pkg.getArtifact().get(0).getPlugins().get(0), slot.getDefaultPlugin());
    }

    @Test
    public void artifactHoldsNodeOrPluginsAndReferencesAreChecked() throws Exception {
        XtextResourceSet rs = ros2Injector.getInstance(XtextResourceSet.class);
        loadFromString(rs, "inmemory:/nav2_core.ros2", navCoreModel());
        Resource both = loadFromString(rs, "inmemory:/both.ros2", """
                both_pkg:
                  artifacts:
                    mixed:
                      node: mixed
                      plugins:
                        P:
                          implements: nav2_core.GlobalPlanner
                """);
        Resource noImplements = loadFromString(rs, "inmemory:/no_impl.ros2", """
                no_impl_pkg:
                  artifacts:
                    lib:
                      plugins:
                        P:
                          publishers:
                            out:
                              type: "std_msgs/msg/String"
                """);
        Resource unknownBase = loadFromString(rs, "inmemory:/unknown_base.ros2", """
                unknown_base_pkg:
                  artifacts:
                    lib:
                      plugins:
                        P:
                          implements: nav2_core.NoSuchBase
                """);
        Resource exponentLike = loadFromString(rs, "inmemory:/exponent_like.ros2", """
                exp_pkg:
                  pluginbases:
                    ExtBase:
                      class: "exp_pkg::ExtBase"
                      header: "exp_pkg/ext_base.hpp"
                      loader: pluginlib
                    e2e:
                      class: "exp_pkg::E2e"
                      header: "exp_pkg/e2e.hpp"
                      loader: pluginlib
                  artifacts:
                    lib:
                      plugins:
                        A:
                          implements: exp_pkg.ExtBase
                        B:
                          implements: exp_pkg.e2e
                """);
        Resource quoted = loadFromString(rs, "inmemory:/quoted.ros2", """
                quoted_pkg:
                  artifacts:
                    lib:
                      plugins:
                        P:
                          implements: "nav2_core.GlobalPlanner"
                    host:
                      node: host
                      parameters:
                        planners:
                          type: Array [ String ]
                      pluginslots:
                        planners:
                          base: nav2_core.GlobalPlanner
                          parameter: planners
                          multiple: true
                """);
        EcoreUtil.resolveAll(rs);

        assertFalse("node: and plugins: in one artifact must not parse", both.getErrors().isEmpty());
        assertFalse("a plugin without implements: must not parse", noImplements.getErrors().isEmpty());
        assertTrue(validate(ros2Injector, unknownBase).stream().anyMatch(i ->
                i.getSeverity() == Severity.ERROR && i.getMessage().contains("nav2_core.NoSuchBase")));

        List<Issue> exponentErrors = validate(ros2Injector, exponentLike).stream()
                .filter(i -> i.getSeverity() == Severity.ERROR).toList();
        assertTrue("Segments starting with E or e must link: " + exponentErrors, exponentErrors.isEmpty());
        AmentPackage expPkg = (AmentPackage) exponentLike.getContents().get(0);
        assertEquals("ExtBase", expPkg.getArtifact().get(0).getPlugins().get(0).getImplements().getName());
        assertEquals("e2e", expPkg.getArtifact().get(0).getPlugins().get(1).getImplements().getName());

        List<Issue> quotedErrors = validate(ros2Injector, quoted).stream()
                .filter(i -> i.getSeverity() == Severity.ERROR).toList();
        assertTrue("Quoted reference and multiple: errors: " + quotedErrors, quotedErrors.isEmpty());
        AmentPackage pkg = (AmentPackage) quoted.getContents().get(0);
        assertEquals("GlobalPlanner", pkg.getArtifact().get(0).getPlugins().get(0).getImplements().getName());
        assertTrue(pkg.getArtifact().get(1).getNode().getPluginSlots().get(0).isMultiple());
    }

    @Test
    public void validateRejectsInvalidBasesSlotsAndAttachments() throws Exception {
        XtextResourceSet rs = ros2Injector.getInstance(XtextResourceSet.class);
        loadFromString(rs, "inmemory:/std_msgs.ros", stdMsgsSpec());
        loadFromString(rs, "inmemory:/nav2_core.ros2", navCoreModel());
        Resource badBaseRes = loadFromString(rs, "inmemory:/bad_base.ros2", """
                bad_base_pkg:
                  pluginbases:
                    NoNamespace:
                      class: "NoNamespaceBase"
                      header: "bad_base_pkg/no_namespace.hpp"
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
                          base: nav2_core.GlobalPlanner
                          parameter: missing_param
                        s2:
                          base: nav2_core.GlobalPlanner
                          parameter: count
                """);
        EcoreUtil.resolveAll(rs);

        List<Issue> baseIssues = validate(ros2Injector, badBaseRes);
        assertTrue(baseIssues.stream().anyMatch(i ->
                i.getSeverity() == Severity.ERROR && RosValidator.PLUGIN_INVALID_IMPLEMENTS.equals(i.getCode())));

        List<Issue> slotIssues = validate(ros2Injector, badSlotRes);
        assertTrue(slotIssues.stream().anyMatch(i -> RosValidator.SLOT_MISSING_PARAM.equals(i.getCode())));
        assertTrue(slotIssues.stream().anyMatch(i -> RosValidator.SLOT_INVALID_PARAM_TYPE.equals(i.getCode())));

        // In .rossystem, a plugin must implement the base of the slot it is attached to, and the
        // slot must exist on the host node.
        XtextResourceSet sysRs = rosSystemInjector.getInstance(XtextResourceSet.class);
        loadFromString(sysRs, "inmemory:/std_msgs.ros", stdMsgsSpec());
        loadFromString(sysRs, "inmemory:/nav2_core.ros2", navCoreModel());
        loadFromString(sysRs, "inmemory:/custom_core.ros2", customCoreModel());
        loadFromString(sysRs, "inmemory:/host_for_val.ros2", hostPkgModel());
        loadFromString(sysRs, "inmemory:/planner_plugins.ros2", validPluginlibPkgModel());
        loadFromString(sysRs, "inmemory:/other_plugins.ros2", """
                other_plugins_pkg:
                  artifacts:
                    other_lib:
                      plugins:
                        WrongBase:
                          implements: custom_core.ActionBase
                """);
        Resource mismatchSys = loadFromString(sysRs, "inmemory:/mismatch.rossystem", """
                mismatch:
                  nodes:
                    planner_inst:
                      from: "planner_host_pkg.planner_server"
                      slots:
                        global_planner: [other_plugins_pkg.WrongBase]
                """);
        Resource unknownSlotSys = loadFromString(sysRs, "inmemory:/unknown_slot.rossystem", """
                unknown_slot:
                  nodes:
                    planner_inst:
                      from: "planner_host_pkg.planner_server"
                      slots:
                        no_such_slot: [planner_plugins_pkg.StraightLine]
                """);
        EcoreUtil.resolveAll(sysRs);

        List<Issue> mismatchIssues = validate(rosSystemInjector, mismatchSys);
        assertTrue("Expected INCOMPATIBLE_PLUGIN for a plugin of another base: " + mismatchIssues,
                mismatchIssues.stream().anyMatch(i ->
                        i.getSeverity() == Severity.ERROR
                                && RosSystemValidator.INCOMPATIBLE_PLUGIN.equals(i.getCode())));
        List<Issue> unknownSlotIssues = validate(rosSystemInjector, unknownSlotSys);
        assertTrue("Expected a linking error for an unknown slot: " + unknownSlotIssues,
                unknownSlotIssues.stream().anyMatch(i ->
                        i.getSeverity() == Severity.ERROR && i.getMessage().contains("no_such_slot")));
    }

    @Test
    public void generatePluginlibArtifactsAndRespectDomainLogicShield() throws Exception {
        XtextResourceSet rs = ros2Injector.getInstance(XtextResourceSet.class);
        loadFromString(rs, "inmemory:/std_msgs.ros", stdMsgsSpec());
        loadFromString(rs, "inmemory:/nav2_core.ros2", navCoreModel());
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
    public void generatePluginlibAcrossDistroMatrixConformsToDialects() throws Exception {
        XtextResourceSet rs = ros2Injector.getInstance(XtextResourceSet.class);
        loadFromString(rs, "inmemory:/std_msgs.ros", stdMsgsSpec());
        loadFromString(rs, "inmemory:/nav2_core.ros2", navCoreModel());
        Resource plugRes = loadFromString(rs, "inmemory:/srv_plugins.ros2", """
                srv_plugins_pkg:
                  artifacts:
                    srv_plugin_lib:
                      plugins:
                        ServicePlugin:
                          implements: nav2_core.GlobalPlanner
                          serviceservers:
                            reset_plan:
                              type: "std_srvs/srv/Trigger"
                          serviceclients:
                            clear_costmap:
                              type: "std_srvs/srv/Trigger"
                """);
        EcoreUtil.resolveAll(rs);

        Ros2Generator gen = ros2Injector.getInstance(Ros2Generator.class);
        String wrapperKey = "DEFAULT_OUTPUTsrv_plugins_pkg/include/srv_plugins_pkg/service_plugin_plugin_wrapper.hpp";
        String cmakeKey = "DEFAULT_OUTPUTsrv_plugins_pkg/CMakeLists.txt";

        for (Ros2Distro distro : Ros2Distros.all()) {
            Ros2Target target = Ros2Target.of(distro);
            InMemoryFileSystemAccess fsa = new InMemoryFileSystemAccess();
            gen.generateTargeted(plugRes, fsa, null, "cpp", distro.name(), List.of());

            String wrapperHpp = fsa.getTextFiles().get(wrapperKey).toString();
            String cmake = fsa.getTextFiles().get(cmakeKey).toString();

            assertTrue("Distro " + distro.name() + " CMake min version",
                    cmake.contains(target.getCmake().minimumRequired()));
            assertTrue("Distro " + distro.name() + " C++ standard",
                    cmake.contains(target.getCmake().cxxStandard()));
            assertTrue("Distro " + distro.name() + " service QoS dialect in plugin wrapper",
                    wrapperHpp.contains(target.getCpp().serviceQos()));
            assertTrue("Distro " + distro.name() + " reentrant callback group in plugin wrapper",
                    wrapperHpp.contains("client_cb_group_ = node->create_callback_group(rclcpp::CallbackGroupType::Reentrant);"));
        }
    }

    @Test
    public void generateExternalPluginEmitsNoClassOrPluginlibExport() throws Exception {
        XtextResourceSet rs = ros2Injector.getInstance(XtextResourceSet.class);
        loadFromString(rs, "inmemory:/std_msgs.ros", stdMsgsSpec());
        loadFromString(rs, "inmemory:/custom_core.ros2", customCoreModel());
        Resource extRes = loadFromString(rs, "inmemory:/ext_plugins.ros2", """
                ext_plugins_pkg:
                  artifacts:
                    ext_lib:
                      plugins:
                        MyExtPlugin:
                          implements: custom_core.ActionBase
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
        loadFromString(rs, "inmemory:/nav2_core.ros2", navCoreModel());
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
                      slots:
                        global_planner: [planner_plugins_pkg.StraightLine]
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

        // Negative test: a host without slots has no slot to attach to.
        Resource badSysRes = loadFromString(rs, "inmemory:/bad_nav_sys.rossystem", """
                bad_nav_sys:
                  nodes:
                    consumer_inst:
                      from: "consumer_pkg.consumer_node"
                      slots:
                        global_planner: [planner_plugins_pkg.StraightLine]
                """);
        EcoreUtil.resolveAll(rs);
        List<Issue> badIssues = validate(rosSystemInjector, badSysRes);
        assertTrue(badIssues.stream().anyMatch(i ->
                i.getSeverity() == Severity.ERROR && i.getMessage().contains("global_planner")));

        // With no attachment the slot falls back to its default plugin.
        Resource defaultSysRes = loadFromString(rs, "inmemory:/default_nav_sys.rossystem", """
                default_nav_sys:
                  nodes:
                    planner_inst:
                      from: "planner_host_pkg.planner_server"
                """);
        EcoreUtil.resolveAll(rs);
        InMemoryFileSystemAccess defaultFsa = new InMemoryFileSystemAccess();
        sysGen.generateSystemTargeted(defaultSysRes, defaultFsa, List.of());
        String defaultLaunch = defaultFsa.getTextFiles().get("DEFAULT_OUTPUTdefault_nav_sys/launch/default_nav_sys.launch.py").toString();
        assertTrue("Launch should emit the slot default: " + defaultLaunch,
                defaultLaunch.contains("\"planner_plugin\": ParameterValue(\"planner_plugins_pkg::StraightLine\", value_type=str)"));
    }

    @Test
    public void parseAndGenerateExternalLoaderPluginAndSlot() throws Exception {
        String orchestratorPkg = """
                custom_host_pkg:
                  artifacts:
                    host_orchestrator:
                      node: host_orchestrator
                      parameters:
                        leaf_libraries:
                          type: Array [ String ]
                        strategy_plugin:
                          type: String
                        extra_cfg:
                          type: Struct [ mode String ]
                      pluginslots:
                        leaves_slot:
                          base: custom_core.ActionBase
                          parameter: leaf_libraries
                          format: library
                          multiple: true
                        strategy_slot:
                          base: custom_core.StrategyBase
                          parameter: strategy_plugin
                          format: class
                """;
        String leavesPkg = """
                custom_leaves_pkg:
                  artifacts:
                    leaves_lib:
                      plugins:
                        ActionLeafA:
                          implements: custom_core.ActionBase
                          publishers:
                            leaf_status:
                              type: "std_msgs/msg/String"
                        ActionLeafB:
                          implements: custom_core.ActionBase
                    extra_leaves_lib:
                      plugins:
                        ActionLeafC:
                          implements: custom_core.ActionBase
                    strategy_lib:
                      plugins:
                        FastStrategy:
                          implements: custom_core.StrategyBase
                """;

        XtextResourceSet rs = ros2Injector.getInstance(XtextResourceSet.class);
        loadFromString(rs, "inmemory:/std_msgs.ros", stdMsgsSpec());
        loadFromString(rs, "inmemory:/custom_core.ros2", customCoreModel());
        Resource hostRes = loadFromString(rs, "inmemory:/custom_host.ros2", orchestratorPkg);
        Resource leavesRes = loadFromString(rs, "inmemory:/custom_leaves.ros2", leavesPkg);
        EcoreUtil.resolveAll(rs);

        List<Issue> hostErrors = validate(ros2Injector, hostRes).stream()
                .filter(i -> i.getSeverity() == Severity.ERROR).toList();
        List<Issue> leavesErrors = validate(ros2Injector, leavesRes).stream()
                .filter(i -> i.getSeverity() == Severity.ERROR).toList();
        assertTrue("Host validation errors: " + hostErrors, hostErrors.isEmpty());
        assertTrue("Leaves validation errors: " + leavesErrors, leavesErrors.isEmpty());

        AmentPackage hostPkg = (AmentPackage) hostRes.getContents().get(0);
        assertEquals(PluginSlotValueFormat.LIBRARY,
                hostPkg.getArtifact().get(0).getNode().getPluginSlots().get(0).getValueFormat());
        assertEquals(PluginSlotValueFormat.CLASS,
                hostPkg.getArtifact().get(0).getNode().getPluginSlots().get(1).getValueFormat());

        // System wiring (inline launch params AND yaml config): two plugins from leaves_lib plus one
        // from extra_leaves_lib go to the library-format slot, one plugin to the class-format slot
        // (the loader does not dictate the format).
        XtextResourceSet sysRs = rosSystemInjector.getInstance(XtextResourceSet.class);
        loadFromString(sysRs, "inmemory:/std_msgs.ros", stdMsgsSpec());
        loadFromString(sysRs, "inmemory:/custom_core.ros2", customCoreModel());
        loadFromString(sysRs, "inmemory:/custom_host.ros2", orchestratorPkg);
        loadFromString(sysRs, "inmemory:/custom_leaves.ros2", leavesPkg);

        Resource inlineSys = loadFromString(sysRs, "inmemory:/ext_sys.rossystem", """
                ext_sys:
                  nodes:
                    orch:
                      from: "custom_host_pkg.host_orchestrator"
                      slots:
                        leaves_slot: [custom_leaves_pkg.ActionLeafA, custom_leaves_pkg.ActionLeafB, custom_leaves_pkg.ActionLeafC]
                        strategy_slot: [custom_leaves_pkg.FastStrategy]
                """);
        EcoreUtil.resolveAll(sysRs);

        List<Issue> inlineErrors = validate(rosSystemInjector, inlineSys).stream()
                .filter(i -> i.getSeverity() == Severity.ERROR).toList();
        assertTrue("Unexpected system validation errors: " + inlineErrors, inlineErrors.isEmpty());

        RosSystemGenerator sysGen = rosSystemInjector.getInstance(RosSystemGenerator.class);
        InMemoryFileSystemAccess inlineFsa = new InMemoryFileSystemAccess();
        sysGen.generateSystemTargeted(inlineSys, inlineFsa, List.of());

        String launch = inlineFsa.getTextFiles().get("DEFAULT_OUTPUText_sys/launch/ext_sys.launch.py").toString();
        assertTrue("Expected deduplicated library names in launch: " + launch,
                launch.contains("\"leaf_libraries\": [\"leaves_lib\", \"extra_leaves_lib\"]"));
        assertTrue("Expected pkg::Class for external plugin bound to format:class slot: " + launch,
                launch.contains("\"strategy_plugin\": ParameterValue(\"custom_leaves_pkg::FastStrategy\", value_type=str)"));

        // Also check YAML emission when a struct parameter triggers config/*.yaml generation.
        Resource yamlSys = loadFromString(sysRs, "inmemory:/ext_yaml_sys.rossystem", """
                ext_yaml_sys:
                  nodes:
                    orch:
                      from: "custom_host_pkg.host_orchestrator"
                      slots:
                        leaves_slot: [custom_leaves_pkg.ActionLeafA, custom_leaves_pkg.ActionLeafB, custom_leaves_pkg.ActionLeafC]
                        strategy_slot: [custom_leaves_pkg.FastStrategy]
                      parameters:
                        - extra_cfg: "custom_host_pkg.host_orchestrator.extra_cfg"
                          value: [
                            mode: "fast"
                          ]
                """);
        EcoreUtil.resolveAll(sysRs);
        InMemoryFileSystemAccess yamlFsa = new InMemoryFileSystemAccess();
        sysGen.generateSystemTargeted(yamlSys, yamlFsa, List.of());

        String yaml = yamlFsa.getTextFiles().get("DEFAULT_OUTPUText_yaml_sys/config/orch.yaml").toString();
        assertTrue("Expected deduplicated library names in YAML: " + yaml,
                yaml.contains("leaf_libraries: [\"leaves_lib\", \"extra_leaves_lib\"]"));
        assertTrue("Expected pkg::Class in YAML for format:class slot: " + yaml,
                yaml.contains("strategy_plugin: \"custom_leaves_pkg::FastStrategy\""));
    }
}
