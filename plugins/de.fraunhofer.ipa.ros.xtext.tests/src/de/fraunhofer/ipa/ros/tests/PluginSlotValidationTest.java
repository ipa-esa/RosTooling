package de.fraunhofer.ipa.ros.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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

import com.google.inject.Guice;
import com.google.inject.Injector;

import de.fraunhofer.ipa.ros.plugin.spi.PluginRegistry;
import de.fraunhofer.ipa.ros.validation.RosValidator;
import de.fraunhofer.ipa.ros2.Ros2RuntimeModule;
import de.fraunhofer.ipa.ros2.Ros2StandaloneSetup;
import de.fraunhofer.ipa.ros2.generator.Ros2Generator;
import de.fraunhofer.ipa.rossystem.RosSystemRuntimeModule;
import de.fraunhofer.ipa.rossystem.RosSystemStandaloneSetup;
import de.fraunhofer.ipa.rossystem.validation.RosSystemValidator;

/**
 * Plugin slot rules (Phase 4 step 2), each with a model that passes and one that fails:
 * a slot owns its parameter, a default implements the slot's base, a slot without
 * {@code multiple} takes one plugin, a plugin is attached to a slot once, a slot is attached
 * once per node, and a Python node with a pluginlib slot gets a generation notice.
 */
public class PluginSlotValidationTest {

    private Injector ros2Injector;
    private Injector rosSystemInjector;

    @Before
    public void setUp() {
        PluginRegistry.INSTANCE.clearRegistered();
        ros2Injector = new Ros2StandaloneSetup() {
            @Override
            public Injector createInjector() {
                return Guice.createInjector(new Ros2RuntimeModule() {
                    @Override
                    public ClassLoader bindClassLoaderToInstance() {
                        return PluginSlotValidationTest.class.getClassLoader();
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
                        return PluginSlotValidationTest.class.getClassLoader();
                    }
                });
            }
        }.createInjectorAndDoEMFRegistration();
    }

    /** Two bases, a plugin of each, and a host whose slot body is {@code slots}. */
    private static String model(final String hostBody) {
        return """
                core:
                  pluginbases:
                    Planner:
                      class: "core::Planner"
                      header: "core/planner.hpp"
                      loader: pluginlib
                    Critic:
                      class: "core::Critic"
                      header: "core/critic.hpp"
                      loader: other_loader
                  artifacts:
                    planners:
                      plugins:
                        Straight:
                          implements: core.Planner
                        Smooth:
                          implements: core.Planner
                    critics:
                      plugins:
                        Align:
                          implements: core.Critic
                    host:
                      node: host
                """ + hostBody.indent(6);
    }

    private static final String PLANNER_SLOT = """
            pluginslots:
              planner:
                base: core.Planner
                parameter: planner_plugin
            """;

    private static final String PLANNER_SLOTS_MULTIPLE = """
            pluginslots:
              planner:
                base: core.Planner
                parameter: planner_plugins
                multiple: true
            """;

    @Test
    public void slotParameterMustNotBeANodeParameter() throws Exception {
        assertNoErrors(ros2(model(PLANNER_SLOT)));
        assertHasCode(ros2(model("""
                parameters:
                  planner_plugin:
                    type: String
                """ + PLANNER_SLOT)), RosValidator.SLOT_PARAM_CONFLICT);
    }

    @Test
    public void slotParameterMustNotBeAnotherSlotsParameter() throws Exception {
        assertNoErrors(ros2(model("""
                pluginslots:
                  planner:
                    base: core.Planner
                    parameter: planner_plugin
                  critics:
                    base: core.Critic
                    parameter: critic_plugins
                    multiple: true
                """)));
        assertHasCode(ros2(model("""
                pluginslots:
                  planner:
                    base: core.Planner
                    parameter: shared
                  critics:
                    base: core.Critic
                    parameter: shared
                """)), RosValidator.SLOT_PARAM_CONFLICT);
    }

    @Test
    public void defaultMustImplementTheSlotsBase() throws Exception {
        assertNoErrors(ros2(model("""
                pluginslots:
                  planner:
                    base: core.Planner
                    parameter: planner_plugin
                    default: core.Straight
                """)));
        assertHasCode(ros2(model("""
                pluginslots:
                  planner:
                    base: core.Planner
                    parameter: planner_plugin
                    default: core.Align
                """)), RosValidator.SLOT_DEFAULT_WRONG_BASE);
    }

    @Test
    public void slotWithoutMultipleTakesOnePlugin() throws Exception {
        assertNoErrors(system(model(PLANNER_SLOT), """
                planner: [core.Straight]
                """));
        assertHasCode(system(model(PLANNER_SLOT), """
                planner: [core.Straight, core.Smooth]
                """), RosSystemValidator.SLOT_TOO_MANY_PLUGINS);
        assertNoErrors(system(model(PLANNER_SLOTS_MULTIPLE), """
                planner: [core.Straight, core.Smooth]
                """));
    }

    @Test
    public void pluginIsAttachedToASlotOnce() throws Exception {
        assertHasCode(system(model(PLANNER_SLOTS_MULTIPLE), """
                planner: [core.Straight, core.Straight]
                """), RosSystemValidator.SLOT_DUPLICATE_PLUGIN);
    }

    @Test
    public void slotIsAttachedOncePerNode() throws Exception {
        assertHasCode(system(model(PLANNER_SLOTS_MULTIPLE), """
                planner: [core.Straight]
                planner: [core.Smooth]
                """), RosSystemValidator.SLOT_ATTACHED_TWICE);
    }

    @Test
    public void pluginMustImplementTheSlotsBase() throws Exception {
        assertHasCode(system(model(PLANNER_SLOT), """
                planner: [core.Align]
                """), RosSystemValidator.INCOMPATIBLE_PLUGIN);
    }

    @Test
    public void pythonNodeWithPluginlibSlotGetsANotice() throws Exception {
        String pluginlibSlot = model(PLANNER_SLOT);
        String otherLoaderSlot = model("""
                pluginslots:
                  critics:
                    base: core.Critic
                    parameter: critic_plugins
                """);
        assertTrue(notices(pluginlibSlot, "python").stream().anyMatch(n -> n.contains("pluginlib")));
        assertFalse(notices(pluginlibSlot, "cpp").stream().anyMatch(n -> n.contains("pluginlib")));
        assertFalse(notices(otherLoaderSlot, "python").stream().anyMatch(n -> n.contains("pluginlib")));
    }

    private List<String> notices(final String ros2Model, final String language) throws Exception {
        XtextResourceSet rs = ros2Injector.getInstance(XtextResourceSet.class);
        Resource res = load(rs, "inmemory:/core.ros2", ros2Model);
        EcoreUtil.resolveAll(rs);
        Ros2Generator gen = ros2Injector.getInstance(Ros2Generator.class);
        return gen.generateTargetedWithPlugins(res, new InMemoryFileSystemAccess(), List.of("host"), language, "jazzy",
                List.of()).notices;
    }

    private List<Issue> ros2(final String ros2Model) throws Exception {
        XtextResourceSet rs = ros2Injector.getInstance(XtextResourceSet.class);
        Resource res = load(rs, "inmemory:/core.ros2", ros2Model);
        EcoreUtil.resolveAll(rs);
        return validate(ros2Injector, res);
    }

    private List<Issue> system(final String ros2Model, final String slots) throws Exception {
        XtextResourceSet rs = rosSystemInjector.getInstance(XtextResourceSet.class);
        load(rs, "inmemory:/core.ros2", ros2Model);
        Resource res = load(rs, "inmemory:/sys.rossystem", """
                sys:
                  nodes:
                    host_inst:
                      from: "core.host"
                      slots:
                """ + slots.indent(8));
        EcoreUtil.resolveAll(rs);
        return validate(rosSystemInjector, res);
    }

    private static Resource load(final XtextResourceSet rs, final String uri, final String content) throws Exception {
        Resource res = rs.createResource(URI.createURI(uri));
        res.load(new ByteArrayInputStream(content.getBytes(StandardCharsets.UTF_8)), null);
        return res;
    }

    private static List<Issue> validate(final Injector injector, final Resource res) {
        return injector.getInstance(IResourceValidator.class).validate(res, CheckMode.ALL, CancelIndicator.NullImpl);
    }

    private static void assertNoErrors(final List<Issue> issues) {
        List<Issue> errors = issues.stream().filter(i -> i.getSeverity() == Severity.ERROR).toList();
        assertTrue("Unexpected errors: " + errors, errors.isEmpty());
    }

    private static void assertHasCode(final List<Issue> issues, final String code) {
        assertTrue("Expected an error " + code + " in: " + issues, issues.stream()
                .anyMatch(i -> i.getSeverity() == Severity.ERROR && code.equals(i.getCode())));
    }
}
