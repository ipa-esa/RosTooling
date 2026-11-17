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
                  artifacts:
                    planners_lib:
                      plugins:
                        StraightLine:
                          implements: "nav2_core::GlobalPlanner"
                          loader: pluginlib
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
                "{\"implements\":\"nav2_core::GlobalPlanner\",\"loader\":\"pluginlib\"}", null));
        String updated = RosAstNodeModelSerializer.computeAndCommit(s.state).newText;
        assertTrue(updated.contains("ThetaStar:"), "Expected ThetaStar plugin:\n" + updated);

        Files.writeString(pkgFile, updated);
        Session reopened = open(pkgFile, "phase1-pkg-2");
        AmentPackage pkg = (AmentPackage) reopened.state.getSemanticModel();
        assertEquals(2, pkg.getArtifact().get(0).getPlugins().size());
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
                        leaf_libraries:
                          type: Array [ String ]
                """);

        Session s = open(pkgFile, "phase1-slot-format");
        exec(s, new EditRosPropertyOperation("orch_node", "addPluginSlot", "leaves",
                "{\"base\":\"custom_core::LeafBase\",\"parameter\":\"leaf_libraries\",\"format\":\"library\"}", null));

        String updated = RosAstNodeModelSerializer.computeAndCommit(s.state).newText;
        assertTrue(updated.contains("format: library"), "Expected format: library in .ros2:\n" + updated);

        Files.writeString(pkgFile, updated);
        Session reopened = open(pkgFile, "phase1-slot-format-2");
        GModelElement card = findNodesByName(reopened.state.getRoot(), RosModelTypes.ROS_NODE).get(0);
        String slotsJson = String.valueOf(card.getArgs().get("pluginSlotsJson"));
        assertTrue(slotsJson.contains("\"format\":\"library\""), "Expected format in pluginSlotsJson: " + slotsJson);
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

        Path hostFile = tempDir.resolve("host_pkg.ros2");
        Files.writeString(hostFile, """
                host_pkg:
                  artifacts:
                    host_bin:
                      node: host_node
                      parameters:
                        active_plugin:
                          type: String
                      pluginslots:
                        planner:
                          base: "nav2_core::GlobalPlanner"
                          parameter: active_plugin
                """);

        Path pluginFile = tempDir.resolve("plugin_pkg.ros2");
        Files.writeString(pluginFile, """
                plugin_pkg:
                  artifacts:
                    planner_lib:
                      plugins:
                        MyPlanner:
                          implements: "nav2_core::GlobalPlanner"
                          loader: pluginlib
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
                      plugins: ["plugin_pkg.MyPlanner"]
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
        assertTrue(saved.contains("plugins: [\"plugin_pkg.MyPlanner\"]"), saved);
        assertTrue(saved.contains("host_inst::plugin_debug"), saved);
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
