package de.fraunhofer.ipa.ros.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.generator.InMemoryFileSystemAccess;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.junit.Before;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;

import de.fraunhofer.ipa.ros.plugin.spi.BlockDescriptor;
import de.fraunhofer.ipa.ros.plugin.spi.LoaderDescriptor;
import de.fraunhofer.ipa.ros.plugin.spi.PluginRegistry;
import de.fraunhofer.ipa.ros.plugin.spi.RosToolingPlugin;
import de.fraunhofer.ipa.ros.plugin.spi.ValidationContext;
import de.fraunhofer.ipa.ros2.Ros2RuntimeModule;
import de.fraunhofer.ipa.ros2.Ros2StandaloneSetup;
import de.fraunhofer.ipa.ros2.generator.Ros2Generator;

/**
 * Host side of plugin slots (Phase 4 step 3): each slot declares its parameter with its default,
 * pluginlib slots of class format load their plugins with a ClassLoader in the wrapper and hand
 * them to the domain logic, which never includes pluginlib. Slots of other loaders or of library
 * format only declare the parameter.
 */
public class PluginHostGenerationTest {

    private static final String CORE = """
            core:
              pluginbases:
                Planner:
                  class: "core::Planner"
                  header: "core/planner.hpp"
                  loader: pluginlib
                Critic:
                  class: "core::Critic"
                  header: "core/critic.hpp"
                  loader: pluginlib
                Behavior:
                  class: "core::Behavior"
                  header: "core/behavior.hpp"
                  loader: other_loader
              artifacts:
                planners:
                  plugins:
                    Straight:
                      implements: core.Planner
            """;

    private static final String HOST = """
            host_pkg:
              artifacts:
                server:
                  node: server
                  pluginslots:
                    planner:
                      base: core.Planner
                      parameter: planner_plugin
                      default: core.Straight
                    critics:
                      base: core.Critic
                      parameter: critic_plugins
                      multiple: true
                    critic_libs:
                      base: core.Critic
                      parameter: critic_libraries
                      format: library
                      multiple: true
                    behaviors:
                      base: core.Behavior
                      parameter: behavior_plugins
                      multiple: true
            """;

    /** Registers {@code other_loader}, so bases using it validate. */
    private static final RosToolingPlugin OTHER_LOADER_PLUGIN = new RosToolingPlugin() {
        @Override public String id() { return "test.other_loader"; }
        @Override public List<BlockDescriptor> blocks() { return List.of(); }
        @Override public List<LoaderDescriptor> loaders() { return List.of(new LoaderDescriptor("other_loader", "")); }
        @Override public void validate(final ValidationContext context) { }
    };

    private Injector ros2Injector;

    @Before
    public void setUp() {
        PluginRegistry.INSTANCE.clearRegistered();
        PluginRegistry.INSTANCE.register(OTHER_LOADER_PLUGIN);
        ros2Injector = new Ros2StandaloneSetup() {
            @Override
            public Injector createInjector() {
                return Guice.createInjector(new Ros2RuntimeModule() {
                    @Override
                    public ClassLoader bindClassLoaderToInstance() {
                        return PluginHostGenerationTest.class.getClassLoader();
                    }
                });
            }
        }.createInjectorAndDoEMFRegistration();
    }

    private InMemoryFileSystemAccess generate(final String language) throws Exception {
        XtextResourceSet rs = ros2Injector.getInstance(XtextResourceSet.class);
        load(rs, "inmemory:/core.ros2", CORE);
        Resource host = load(rs, "inmemory:/host_pkg.ros2", HOST);
        EcoreUtil.resolveAll(rs);
        InMemoryFileSystemAccess fsa = new InMemoryFileSystemAccess();
        ros2Injector.getInstance(Ros2Generator.class).generateTargeted(host, fsa, null, language, "jazzy", List.of());
        return fsa;
    }

    private static String file(final InMemoryFileSystemAccess fsa, final String path) {
        CharSequence text = fsa.getTextFiles().get("DEFAULT_OUTPUT" + path);
        assertNotNull("Missing " + path + " in " + fsa.getTextFiles().keySet(), text);
        return text.toString();
    }

    @Test
    public void cppWrapperDeclaresSlotParametersAndLoadsPluginlibSlots() throws Exception {
        InMemoryFileSystemAccess fsa = generate("cpp");
        String hpp = file(fsa, "host_pkg/include/host_pkg/ServerWrapper.hpp");
        String cpp = file(fsa, "host_pkg/src/ServerWrapper.cpp");

        assertTrue(hpp.contains("#include \"pluginlib/class_loader.hpp\""));
        assertTrue(hpp.contains("#include \"core/planner.hpp\""));
        assertTrue(hpp.contains("#include \"core/critic.hpp\""));
        assertFalse("Other loaders are not loaded by core", hpp.contains("core/behavior.hpp"));

        // Every slot declares its parameter, read-only, with its default.
        assertTrue(cpp.contains("declare_parameter<std::string>(\"planner_plugin\", std::string(\"core::Straight\"), desc)"));
        assertTrue(cpp.contains("declare_parameter<std::vector<std::string>>(\"critic_plugins\", std::vector<std::string>{}, desc)"));
        assertTrue(cpp.contains("declare_parameter<std::vector<std::string>>(\"critic_libraries\", std::vector<std::string>{}, desc)"));
        assertTrue(cpp.contains("declare_parameter<std::vector<std::string>>(\"behavior_plugins\", std::vector<std::string>{}, desc)"));
        assertTrue(cpp.contains("desc.read_only = true;"));

        // Only pluginlib slots of class format get a ClassLoader.
        assertTrue(cpp.contains("pluginlib::ClassLoader<core::Planner>>(\n        \"core\", \"core::Planner\")"));
        assertTrue(cpp.contains("slot_critics_loader_"));
        assertFalse(cpp.contains("slot_critic_libs_loader_"));
        assertFalse(cpp.contains("slot_behaviors_loader_"));
        assertTrue(hpp.contains("std::shared_ptr<core::Planner> get_planner_plugin() const"));
        assertTrue(hpp.contains("const std::vector<std::shared_ptr<core::Critic>> & get_critics_plugins() const"));
    }

    @Test
    public void domainLogicReceivesPluginsWithoutIncludingPluginlib() throws Exception {
        InMemoryFileSystemAccess fsa = generate("cpp");
        String algorithm = file(fsa, "host_pkg/include/host_pkg/ServerAlgorithm.hpp");
        String node = file(fsa, "host_pkg/include/host_pkg/ServerNode.hpp");

        assertFalse("The logic file never includes pluginlib", algorithm.contains("pluginlib"));
        assertTrue(algorithm.contains("#include \"core/planner.hpp\""));
        assertTrue(algorithm.contains("void set_planner_plugin(std::shared_ptr<core::Planner> plugin)"));
        assertTrue(algorithm.contains("std::shared_ptr<core::Planner> planner_plugin() const"));
        assertTrue(algorithm.contains("const std::vector<std::shared_ptr<core::Critic>> & critics_plugins() const"));
        assertTrue(node.contains("algorithm_->set_planner_plugin(this->get_planner_plugin());"));
        assertTrue(node.contains("algorithm_->set_critics_plugins(this->get_critics_plugins());"));
        assertTrue(node.contains("algorithm_->set_parameter(\"behavior_plugins\", this->get_param_behavior_plugins());"));
    }

    @Test
    public void hostBuildDependsOnPluginlibAndBasePackages() throws Exception {
        InMemoryFileSystemAccess fsa = generate("cpp");
        String cmake = file(fsa, "host_pkg/CMakeLists.txt");
        String pkgXml = file(fsa, "host_pkg/package.xml");

        assertTrue(cmake.contains("find_package(pluginlib REQUIRED)"));
        assertTrue(cmake.contains("find_package(core REQUIRED)"));
        assertTrue("Header-only base packages export no targets: " + cmake,
                cmake.contains("target_include_directories(Server_component PUBLIC ${core_INCLUDE_DIRS})"));
        assertTrue(pkgXml.contains("<depend>pluginlib</depend>"));
        assertTrue(pkgXml.contains("<depend>core</depend>"));
    }

    @Test
    public void pythonWrapperDeclaresSlotParameters() throws Exception {
        InMemoryFileSystemAccess fsa = generate("python");
        String wrapper = fsa.getTextFiles().entrySet().stream()
                .filter(e -> e.getKey().endsWith("server_wrapper.py"))
                .map(e -> e.getValue().toString())
                .findFirst().orElseThrow();
        assertTrue(wrapper.contains("self.declare_parameter(\"planner_plugin\", 'core::Straight', descriptor=desc_planner_plugin)"));
        assertTrue(wrapper.contains(
                "self.declare_parameter(\"critic_plugins\", rclpy.Parameter.Type.STRING_ARRAY, descriptor=desc_critic_plugins)"));
        assertTrue(wrapper.contains("self._param_critic_plugins = list(self.get_parameter_or("));
        assertTrue(wrapper.contains("read_only=True"));
        assertFalse(wrapper.contains("pluginlib"));
    }

    private static Resource load(final XtextResourceSet rs, final String uri, final String content) throws Exception {
        Resource res = rs.createResource(URI.createURI(uri));
        res.load(new ByteArrayInputStream(content.getBytes(StandardCharsets.UTF_8)), null);
        return res;
    }
}
