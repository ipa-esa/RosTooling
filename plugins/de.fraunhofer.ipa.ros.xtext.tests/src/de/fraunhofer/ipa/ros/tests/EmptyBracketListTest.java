package de.fraunhofer.ipa.ros.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.junit.Before;
import org.junit.Test;

import com.google.inject.Injector;

import de.fraunhofer.ipa.ros.plugin.spi.PluginRegistry;
import de.fraunhofer.ipa.ros2.Ros2StandaloneSetup;
import de.fraunhofer.ipa.rossystem.RosSystemStandaloneSetup;
import ros.AmentPackage;
import ros.ExtensionListValue;
import ros.Node;
import system.RosNode;

/**
 * An empty list written "[]" parses like "[ ]". The brackets are always two tokens, so the list
 * rules need no special case for the empty list; this pins that down for slot attachments and
 * extension block lists.
 */
public class EmptyBracketListTest {

    private static final String CORE = """
            core:
              pluginbases:
                Planner:
                  class: "core::Planner"
                  header: "core/planner.hpp"
                  loader: pluginlib
              artifacts:
                planners:
                  plugins:
                    Straight:
                      implements: core.Planner
                host:
                  node: host
                  pluginslots:
                    planner:
                      base: core.Planner
                      parameter: planner_plugin
                    critics:
                      base: core.Planner
                      parameter: critic_plugins
                      multiple: true
                  @meta:
                    tags: %s
                    level: 1
            """;

    private Injector rosSystemInjector;

    @Before
    public void setUp() {
        PluginRegistry.INSTANCE.clearRegistered();
        new Ros2StandaloneSetup().createInjectorAndDoEMFRegistration();
        rosSystemInjector = new RosSystemStandaloneSetup().createInjectorAndDoEMFRegistration();
    }

    private Resource load(final XtextResourceSet rs, final String uri, final String text) throws Exception {
        Resource res = rs.createResource(URI.createURI(uri));
        res.load(new ByteArrayInputStream(text.getBytes(StandardCharsets.UTF_8)), null);
        return res;
    }

    private void assertEmptyListsParse(final String brackets) throws Exception {
        XtextResourceSet rs = rosSystemInjector.getInstance(XtextResourceSet.class);
        Resource core = load(rs, "inmemory:/core.ros2", CORE.formatted(brackets));
        Resource sys = load(rs, "inmemory:/sys.rossystem", """
                sys:
                  nodes:
                    host_inst:
                      from: "core.host"
                      slots:
                        planner: [core.Straight]
                        critics: %s
                """.formatted(brackets));
        EcoreUtil.resolveAll(rs);
        assertTrue("core.ros2 with " + brackets + ": " + core.getErrors(), core.getErrors().isEmpty());
        assertTrue("sys.rossystem with " + brackets + ": " + sys.getErrors(), sys.getErrors().isEmpty());

        RosNode node = (RosNode) ((system.System) sys.getContents().get(0)).getComponents().get(0);
        assertEquals(2, node.getSlots().size());
        assertEquals(1, node.getSlots().get(0).getPlugins().size());
        assertEquals("critics", node.getSlots().get(1).getSlot().getName());
        assertTrue(node.getSlots().get(1).getPlugins().isEmpty());

        Node host = ((AmentPackage) core.getContents().get(0)).getArtifact().get(1).getNode();
        ExtensionListValue tags = (ExtensionListValue) host.getExtensions().get(0).getEntries().get(0).getValue();
        assertTrue(tags.getItems().isEmpty());
        assertEquals("level", host.getExtensions().get(0).getEntries().get(1).getKey());
    }

    @Test
    public void emptyListWithSpaceParses() throws Exception {
        assertEmptyListsParse("[ ]");
    }

    @Test
    public void emptyListWithoutSpaceParses() throws Exception {
        assertEmptyListsParse("[]");
    }
}
