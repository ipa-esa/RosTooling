package de.fraunhofer.ipa.ros.glsp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.google.inject.Guice;
import com.google.inject.Injector;
import de.fraunhofer.ipa.ros.glsp.actions.RequestRosAutoConnectAction;
import de.fraunhofer.ipa.ros.glsp.actions.SetRosAutoConnectAction;
import de.fraunhofer.ipa.ros.glsp.handlers.RequestRosAutoConnectActionHandler;
import de.fraunhofer.ipa.ros.glsp.model.RosAstNodeModelSerializer;
import de.fraunhofer.ipa.ros.glsp.model.RosModelState;
import de.fraunhofer.ipa.ros.glsp.operations.ApplyRosAutoConnectOperation;
import de.fraunhofer.ipa.ros.glsp.operations.EditRosPropertyOperation;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.eclipse.emf.common.command.Command;
import org.eclipse.glsp.graph.GModelElement;
import org.eclipse.glsp.graph.GModelRoot;
import org.eclipse.glsp.server.actions.Action;
import org.eclipse.glsp.server.di.ServerModule;
import org.eclipse.glsp.server.features.core.model.GModelFactory;
import org.eclipse.glsp.server.features.core.model.RequestModelAction;
import org.eclipse.glsp.server.features.core.model.SourceModelStorage;
import org.eclipse.glsp.server.operations.CreateNodeOperation;
import org.eclipse.glsp.server.operations.Operation;
import org.eclipse.glsp.server.operations.OperationHandler;
import org.eclipse.glsp.server.operations.OperationHandlerRegistry;
import org.eclipse.glsp.server.protocol.InitializeClientSessionParameters;
import org.eclipse.glsp.server.session.ClientSession;
import org.eclipse.glsp.server.session.ClientSessionManager;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import ros.AmentPackage;

/**
 * Phase 1 GLSP tests covering node-less plugin artifacts, {@code addPlugin} / {@code addPluginSlot},
 * host node plugin badges/ports in the diagram, and {@code RosAutoConnector} over plugin interfaces.
 */
class RosGlspPhase1PluginsTest {

    @TempDir
    Path tempDir;

    private static final class Session {
        Injector injector;
        SourceModelStorage storage;
        GModelFactory gModelFactory;
        RosModelState state;
        OperationHandlerRegistry registry;
    }

    private Session open(final Path file, final String sessionId) {
        Injector serverInjector = Guice.createInjector(
                new ServerModule().configureDiagramModule(new RosGlspModule()));
        ClientSessionManager sessionManager = serverInjector.getInstance(ClientSessionManager.class);
        ClientSession session = sessionManager.getOrCreateClientSession(
                new InitializeClientSessionParameters(sessionId, RosModelTypes.DIAGRAM_TYPE, Collections.emptyList()));
        Injector inj = session.getInjector();
        Session s = new Session();
        s.injector = inj;
        s.storage = inj.getInstance(SourceModelStorage.class);
        s.gModelFactory = inj.getInstance(GModelFactory.class);
        s.state = inj.getInstance(RosModelState.class);
        s.registry = inj.getInstance(OperationHandlerRegistry.class);
        Map<String, String> opts = new HashMap<>();
        opts.put("sourceUri", file.toUri().toString());
        s.storage.loadSourceModel(new RequestModelAction(opts));
        s.gModelFactory.createGModel();
        return s;
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    private static void exec(final Session s, final Operation op) {
        OperationHandler handler = s.registry.getOperationHandler(op).orElseThrow(
                () -> new AssertionError("No handler for " + op.getClass().getName()));
        Optional<Command> opt = handler.createCommand(op);
        Command cmd = opt.orElseThrow(
                () -> new AssertionError("Empty command for " + op.getClass().getName()));
        s.state.execute(cmd);
    }

    private static List<GModelElement> findNodesByName(final GModelElement el, final String type) {
        List<GModelElement> out = new java.util.ArrayList<>();
        if (type.equals(el.getType())) {
            out.add(el);
        }
        for (GModelElement child : el.getChildren()) {
            out.addAll(findNodesByName(child, type));
        }
        return out;
    }

    @Test
    void nodeLessPluginArtifactOpensEditsAndSerializesCleanly() throws Exception {
        Path rosFile = tempDir.resolve("std_msgs.ros");
        Files.writeString(rosFile, """
                std_msgs:
                  msgs:
                    String
                      message
                        string data
                """);

        Path pkgFile = tempDir.resolve("my_plugins.ros2");
        Files.writeString(pkgFile, """
                my_plugins:
                  pluginbases:
                    GlobalPlanner:
                      class: "my_plugins::GlobalPlanner"
                      header: "my_plugins/global_planner.hpp"
                      loader: pluginlib
                  artifacts:
                    planners_lib:
                      plugins:
                        StraightLine:
                          implements: my_plugins.GlobalPlanner
                          publishers:
                            path_out:
                              type: "std_msgs/msg/String"
                """);

        Session s = open(pkgFile, "phase1-pkg");
        s.gModelFactory.createGModel();
        GModelRoot root = s.state.getRoot();
        List<GModelElement> cards = findNodesByName(root, RosModelTypes.ROS_NODE);
        assertEquals(1, cards.size());
        assertEquals(true, cards.get(0).getArgs().get("isPlugin"));
        assertEquals("StraightLine", cards.get(0).getArgs().get("nodeName"));

        // Add a second plugin to the same library artifact via GLSP edit operation
        exec(s, new EditRosPropertyOperation("planners_lib", "addPlugin", "ThetaStar",
                "{\"implements\":\"my_plugins.GlobalPlanner\"}", null));
        String updated = RosAstNodeModelSerializer.computeAndCommit(s.state).newText;
        assertTrue(updated.contains("ThetaStar:"), "Expected ThetaStar plugin:\n" + updated);
        assertTrue(updated.contains("implements: my_plugins.GlobalPlanner"), updated);


        Files.writeString(pkgFile, updated);
        Session reopened = open(pkgFile, "phase1-pkg-2");
        AmentPackage pkg = (AmentPackage) reopened.state.getSemanticModel();
        assertEquals(2, pkg.getArtifact().get(0).getPlugins().size());

        // A new section on an existing plugin goes below its "implements:" line.
        exec(reopened, new EditRosPropertyOperation("StraightLine", "addInterface", "status", "std_msgs/msg/String", "sub"));
        String withSub = RosAstNodeModelSerializer.computeAndCommit(reopened.state).newText;
        assertTrue(withSub.contains("StraightLine:\n          implements: my_plugins.GlobalPlanner\n"), withSub);
        assertTrue(withSub.contains("subscribers:"), withSub);
        assertTrue(withSub.indexOf("subscribers:") > withSub.indexOf("implements: my_plugins.GlobalPlanner"), withSub);
    }

    @Test
    void addPluginSlotWithLibraryFormatSerializesAndExposesFormatInGModel() throws Exception {
        Path pkgFile = tempDir.resolve("host_slot.ros2");
        Files.writeString(pkgFile, """
                host_slot:
                  artifacts:
                    orch_bin:
                      node: orch_node
                      parameters:
                        rate:
                          type: Double
                """);

        Session s = open(pkgFile, "phase1-slot-format");
        exec(s, new EditRosPropertyOperation("orch_node", "addPluginSlot", "leaves",
                "{\"base\":\"custom_core.LeafBase\",\"parameter\":\"leaf_libraries\",\"format\":\"library\",\"multiple\":true}", null));

        String updated = RosAstNodeModelSerializer.computeAndCommit(s.state).newText;
        assertTrue(updated.contains("format: library"), "Expected format: library in .ros2:\n" + updated);
        assertTrue(updated.contains("base: custom_core.LeafBase"), updated);
        assertTrue(updated.contains("multiple: true"), updated);

        Files.writeString(pkgFile, updated);
        Session reopened = open(pkgFile, "phase1-slot-format-2");
        GModelElement card = findNodesByName(reopened.state.getRoot(), RosModelTypes.ROS_NODE).get(0);
        String slotsJson = String.valueOf(card.getArgs().get("pluginSlotsJson"));
        assertTrue(slotsJson.contains("\"format\":\"library\""), "Expected format in pluginSlotsJson: " + slotsJson);
        assertTrue(slotsJson.contains("\"multiple\":true"), slotsJson);

        // Editing an existing slot rewrites that slot only.
        exec(reopened, new EditRosPropertyOperation("orch_bin.leaves", "format", "class"));
        exec(reopened, new EditRosPropertyOperation("orch_bin.leaves", "parameter", "leaf_plugins"));
        String edited = RosAstNodeModelSerializer.computeAndCommit(reopened.state).newText;
        assertFalse(edited.contains("format: library"), edited);
        assertTrue(edited.contains("parameter: leaf_plugins"), edited);
        assertTrue(edited.contains("multiple: true"), edited);
        assertTrue(edited.contains("rate:\n          type: Double"), edited);
    }

    @Test
    void hostNodeWithPluginSlotsAndAutoConnectWorksEndToEnd() throws Exception {
        Path rosFile = tempDir.resolve("std_msgs.ros");
        Files.writeString(rosFile, """
                std_msgs:
                  msgs:
                    String
                      message
                        string data
                """);

        Path coreFile = tempDir.resolve("nav2_core.ros2");
        Files.writeString(coreFile, """
                nav2_core:
                  pluginbases:
                    GlobalPlanner:
                      class: "nav2_core::GlobalPlanner"
                      header: "nav2_core/global_planner.hpp"
                      loader: pluginlib
                """);

        Path hostFile = tempDir.resolve("host_pkg.ros2");
        Files.writeString(hostFile, """
                host_pkg:
                  artifacts:
                    host_bin:
                      node: host_node
                      pluginslots:
                        planner:
                          base: nav2_core.GlobalPlanner
                          parameter: active_plugin
                """);

        Path pluginFile = tempDir.resolve("plugin_pkg.ros2");
        Files.writeString(pluginFile, """
                plugin_pkg:
                  artifacts:
                    planner_lib:
                      plugins:
                        MyPlanner:
                          implements: nav2_core.GlobalPlanner
                          publishers:
                            plugin_debug:
                              type: "std_msgs/msg/String"
                """);

        Path consumerFile = tempDir.resolve("consumer_pkg.ros2");
        Files.writeString(consumerFile, """
                consumer_pkg:
                  artifacts:
                    consumer_bin:
                      node: consumer_node
                      subscribers:
                        plugin_debug:
                          type: "std_msgs/msg/String"
                """);

        Path sysFile = tempDir.resolve("robot.rossystem");
        Files.writeString(sysFile, """
                robot:
                  nodes:
                    host_inst:
                      from: "host_pkg.host_node"
                      slots:
                        planner: [plugin_pkg.MyPlanner]
                    consumer_inst:
                      from: "consumer_pkg.consumer_node"
                """);

        Session s = open(sysFile, "phase1-sys");
        s.gModelFactory.createGModel();
        GModelRoot gmodel = s.state.getRoot();
        List<GModelElement> nodes = findNodesByName(gmodel, RosModelTypes.ROS_NODE);
        GModelElement hostCard = nodes.stream()
                .filter(n -> "host_inst".equals(n.getArgs().get("nodeName")))
                .findFirst().orElseThrow();

        assertEquals(1, hostCard.getArgs().get("pluginsCount"));
        assertEquals("MyPlanner", hostCard.getArgs().get("plugins"));
        assertTrue(findNodesByName(hostCard, RosModelTypes.PORT_PUB).stream()
                .anyMatch(p -> "plugin_debug".equals(p.getArgs().get("interfaceName"))));

        // Auto-connect should propose host_inst::plugin_debug -> consumer_inst::plugin_debug
        RequestRosAutoConnectActionHandler acHandler =
                s.injector.getInstance(RequestRosAutoConnectActionHandler.class);
        List<Action> responses = acHandler.execute(new RequestRosAutoConnectAction());
        SetRosAutoConnectAction res = (SetRosAutoConnectAction) responses.get(0);
        assertFalse(res.getReceivers().isEmpty());
        String wantedId = res.getReceivers().get(0).candidates.get(0).id;
        assertEquals("host_inst::plugin_debug->consumer_inst::plugin_debug", wantedId);

        exec(s, new ApplyRosAutoConnectOperation(List.of(wantedId)));
        String saved = RosAstNodeModelSerializer.computeAndCommit(s.state).newText;
        assertTrue(saved.contains("planner: [plugin_pkg.MyPlanner]"), saved);
        assertTrue(saved.contains("host_inst::plugin_debug"), saved);
    }

    @Test
    void addPluginBaseAndEditItsFields() throws Exception {
        Path pkgFile = tempDir.resolve("my_core.ros2");
        Files.writeString(pkgFile, """
                my_core:
                  artifacts:
                    tool_bin:
                      node: tool_node
                """);

        Session s = open(pkgFile, "phase4-base");
        exec(s, new EditRosPropertyOperation("root", "addPluginBase", "Planner",
                "{\"class\":\"my_core::Planner\",\"header\":\"my_core/planner.hpp\"}", null));
        exec(s, new EditRosPropertyOperation("root", "addPluginBase", "Critic",
                "{\"class\":\"my_core::Critic\",\"loader\":\"other_loader\"}", null));
        exec(s, new EditRosPropertyOperation("Critic", "header", "my_core/critic.hpp"));
        exec(s, new EditRosPropertyOperation("my_core.Critic", "loader", "pluginlib"));
        String updated = RosAstNodeModelSerializer.computeAndCommit(s.state).newText;
        assertTrue(updated.contains("pluginbases:"), updated);
        assertTrue(updated.contains("Planner:\n      class: \"my_core::Planner\"\n      header: \"my_core/planner.hpp\"\n      loader: pluginlib"), updated);
        assertTrue(updated.contains("Critic:\n      class: \"my_core::Critic\"\n      header: \"my_core/critic.hpp\"\n      loader: pluginlib"), updated);
        assertTrue(updated.contains("tool_node"), updated);

        Files.writeString(pkgFile, updated);
        Session reopened = open(pkgFile, "phase4-base-2");
        AmentPackage pkg = (AmentPackage) reopened.state.getSemanticModel();
        assertEquals(2, pkg.getPluginBases().size());
        GModelElement pkgCard = findNodesByName(reopened.state.getRoot(), RosModelTypes.PACKAGE_NODE).get(0);
        String basesJson = String.valueOf(pkgCard.getArgs().get("pluginBasesJson"));
        assertTrue(basesJson.contains("\"ref\":\"my_core.Planner\""), basesJson);
        assertTrue(basesJson.contains("\"loader\":\"pluginlib\""), basesJson);
    }

    @Test
    void slotEditSetsAndClearsTheAttachedPlugins() throws Exception {
        Files.writeString(tempDir.resolve("core.ros2"), """
                core:
                  pluginbases:
                    Critic:
                      class: "core::Critic"
                      header: "core/critic.hpp"
                      loader: pluginlib
                    Planner:
                      class: "core::Planner"
                      header: "core/planner.hpp"
                      loader: pluginlib
                  artifacts:
                    critics:
                      plugins:
                        Goal:
                          implements: core.Critic
                        Align:
                          implements: core.Critic
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
                          base: core.Critic
                          parameter: critic_plugins
                          multiple: true
                """);
        Path sysFile = tempDir.resolve("sys.rossystem");
        Files.writeString(sysFile, """
                sys:
                  nodes:
                    host_inst:
                      from: "core.host"
                      slots:
                        planner: [core.Straight]
                """);

        Session s = open(sysFile, "phase4-slots");
        GModelElement card = findNodesByName(s.state.getRoot(), RosModelTypes.ROS_NODE).get(0);
        String slotsJson = String.valueOf(card.getArgs().get("slotsJson"));
        assertTrue(slotsJson.contains("{\"slot\":\"planner\",\"base\":\"core.Planner\",\"multiple\":false,\"plugins\":[\"core.Straight\"]}"), slotsJson);
        assertTrue(slotsJson.contains("{\"slot\":\"critics\",\"base\":\"core.Critic\",\"multiple\":true,\"plugins\":[]}"), slotsJson);

        exec(s, new EditRosPropertyOperation("host_inst", "slot", "critics", "core.Align, core.Goal", null));
        String updated = RosAstNodeModelSerializer.computeAndCommit(s.state).newText;
        assertTrue(updated.contains("planner: [core.Straight]"), updated);
        assertTrue(updated.contains("critics: [core.Align, core.Goal]"), updated);

        Files.writeString(sysFile, updated);
        Session reopened = open(sysFile, "phase4-slots-2");
        exec(reopened, new EditRosPropertyOperation("host_inst", "slot", "critics", "core.Goal", null));
        exec(reopened, new EditRosPropertyOperation("host_inst", "slot", "planner", "", null));
        String cleared = RosAstNodeModelSerializer.computeAndCommit(reopened.state).newText;
        assertTrue(cleared.contains("critics: [core.Goal]"), cleared);
        assertFalse(cleared.contains("planner: ["), cleared);
    }

    @Test
    void extensionBlockSetRemoveAndSerializeInGlsp() throws Exception {
        Path pkgFile = tempDir.resolve("ext_pkg.ros2");
        Files.writeString(pkgFile, """
                ext_pkg:
                  artifacts:
                    app_bin:
                      node: app_node
                """);

        Session s = open(pkgFile, "phase2-ext-pkg");
        exec(s, new EditRosPropertyOperation("app_node", "setExtensionBlock", "meta",
                "{\"mode\":\"fast\",\"retries\":3,\"tags\":[\"a\",\"b\"]}", null));
        String updated = RosAstNodeModelSerializer.computeAndCommit(s.state).newText;
        assertTrue(updated.contains("@meta:"), updated);
        assertTrue(updated.contains("retries: 3"), updated);

        Files.writeString(pkgFile, updated);
        Session reopened = open(pkgFile, "phase2-ext-pkg-2");
        GModelElement nodeCard = findNodesByName(reopened.state.getRoot(), RosModelTypes.ROS_NODE).get(0);
        String extsJson = String.valueOf(nodeCard.getArgs().get("extensionsJson"));
        assertTrue(extsJson.contains("\"name\":\"meta\""), extsJson);
        assertTrue(extsJson.contains("\"mode\":\"fast\""), extsJson);

        exec(reopened, new EditRosPropertyOperation("app_node", "removeExtensionBlock", "meta", "", null));
        String removed = RosAstNodeModelSerializer.computeAndCommit(reopened.state).newText;
        assertFalse(removed.contains("@meta:"), removed);
    }
}
