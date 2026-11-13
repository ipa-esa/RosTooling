package de.fraunhofer.ipa.ros.glsp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.google.inject.Guice;
import com.google.inject.Injector;
import de.fraunhofer.ipa.ros.glsp.model.RosModelState;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.eclipse.glsp.graph.GEdge;
import org.eclipse.glsp.graph.GGraph;
import org.eclipse.glsp.graph.GModelRoot;
import org.eclipse.glsp.graph.GNode;
import org.eclipse.glsp.graph.GPoint;
import org.eclipse.glsp.graph.GPort;
import org.eclipse.glsp.server.di.ServerModule;
import org.eclipse.glsp.server.features.core.model.GModelFactory;
import org.eclipse.glsp.server.features.core.model.RequestModelAction;
import org.eclipse.glsp.server.features.core.model.SourceModelStorage;
import org.eclipse.glsp.server.protocol.InitializeClientSessionParameters;
import org.eclipse.glsp.server.session.ClientSession;
import org.eclipse.glsp.server.session.ClientSessionManager;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

/**
 * Verification Gate for Block 1:
 * Verifies Xtext/EMF resource loading, RosGModelFactory transformation,
 * and server-side ELK layered & orthogonal edge layout.
 */
class RosGlspBlock1Test {

    @TempDir
    Path tempDir;

    @Test
    void testLoadRosSystemAndGenerateLayoutedGGraph() throws Exception {
        // 1. Write sample .ros message definitions
        Path msgsFile = tempDir.resolve("nav_msgs.ros");
        Files.writeString(msgsFile, String.join("\n",
                "nav_msgs:",
                "  msgs:",
                "    LaserScan",
                "      message",
                "        float32[] ranges",
                "    Twist",
                "      message",
                "        float64 linear_x"));

        // 2. Write companion .ros2 package defining 3 nodes
        Path ros2File = tempDir.resolve("nav_pkg.ros2");
        Files.writeString(ros2File, String.join("\n",
                "nav_pkg:",
                "  artifacts:",
                "    lidar_driver:",
                "      node: lidar_node",
                "      publishers:",
                "        scan:",
                "          type: \"nav_msgs/msg/LaserScan\"",
                "      parameters:",
                "        frame_id:",
                "          type: String",
                "          value: \"laser_frame\"",
                "    local_planner:",
                "      node: planner_node",
                "      subscribers:",
                "        scan_in:",
                "          type: \"nav_msgs/msg/LaserScan\"",
                "      publishers:",
                "        cmd_vel:",
                "          type: \"nav_msgs/msg/Twist\"",
                "    base_controller:",
                "      node: controller_node",
                "      subscribers:",
                "        cmd_in:",
                "          type: \"nav_msgs/msg/Twist\""));

        // 3. Write .rossystem file wiring the 3 nodes together
        Path rossystemFile = tempDir.resolve("nav_system.rossystem");
        Files.writeString(rossystemFile, String.join("\n",
                "# Navigation system architecture",
                "nav_system:",
                "  nodes:",
                "    lidar:",
                "      from: \"nav_pkg.lidar_node\"",
                "      interfaces:",
                "        - scan: pub-> \"lidar_driver::scan\"",
                "      parameters:",
                "        - frame_id: \"lidar_driver::frame_id\"",
                "          value: \"base_laser\"",
                "    planner:",
                "      from: \"nav_pkg.planner_node\"",
                "      interfaces:",
                "        - scan_in: sub-> \"local_planner::scan_in\"",
                "        - cmd_vel: pub-> \"local_planner::cmd_vel\"",
                "    controller:",
                "      from: \"nav_pkg.controller_node\"",
                "      interfaces:",
                "        - cmd_in: sub-> \"base_controller::cmd_in\"",
                "  connections:",
                "    - [ scan , scan_in ]",
                "    - [ cmd_vel , cmd_in ]"));

        // 4. Create GLSP Server & Client Session via RosGlspModule
        Injector serverInjector = Guice.createInjector(
                new ServerModule().configureDiagramModule(new RosGlspModule()));
        ClientSessionManager sessionManager = serverInjector.getInstance(ClientSessionManager.class);
        ClientSession session = sessionManager.getOrCreateClientSession(
                new InitializeClientSessionParameters(
                        "block1-session",
                        RosModelTypes.DIAGRAM_TYPE,
                        Collections.emptyList()));
        Injector sessionInjector = session.getInjector();

        SourceModelStorage storage = sessionInjector.getInstance(SourceModelStorage.class);
        GModelFactory gModelFactory = sessionInjector.getInstance(GModelFactory.class);
        RosModelState modelState = sessionInjector.getInstance(RosModelState.class);

        Map<String, String> options = new HashMap<>();
        options.put("sourceUri", rossystemFile.toUri().toString());
        storage.loadSourceModel(new RequestModelAction(options));

        assertTrue(modelState.getRosSystem().isPresent(), "Expected system.System root EObject to be loaded");
        assertEquals("nav_system", modelState.getRosSystem().get().getName());

        // 5. Generate GGraph and run ELK layout
        gModelFactory.createGModel();
        GModelRoot root = modelState.getRoot();
        assertNotNull(root);
        assertTrue(root instanceof GGraph);
        GGraph ggraph = (GGraph) root;

        List<GNode> nodes = ggraph.getChildren().stream()
                .filter(GNode.class::isInstance)
                .map(GNode.class::cast)
                .filter(n -> RosModelTypes.ROS_NODE.equals(n.getType()))
                .collect(Collectors.toList());
        assertEquals(3, nodes.size(), "Expected 3 RosNode GNodes in GGraph");

        Map<String, GNode> nodeByName = nodes.stream()
                .collect(Collectors.toMap(n -> String.valueOf(n.getArgs().get("nodeName")), n -> n));
        assertTrue(nodeByName.containsKey("lidar"));
        assertTrue(nodeByName.containsKey("planner"));
        assertTrue(nodeByName.containsKey("controller"));

        // Verify ports on planner (1 target port scan_in on West, 1 source port cmd_vel on East)
        GNode plannerNode = nodeByName.get("planner");
        List<GPort> plannerPorts = plannerNode.getChildren().stream()
                .filter(GPort.class::isInstance)
                .map(GPort.class::cast)
                .collect(Collectors.toList());
        assertEquals(2, plannerPorts.size(), "Expected 2 GPorts on planner node");

        // Verify ELK layout assigned non-overlapping (x, y) coordinates in LEFT -> RIGHT order
        GPoint lidarPos = nodeByName.get("lidar").getPosition();
        GPoint plannerPos = nodeByName.get("planner").getPosition();
        GPoint controllerPos = nodeByName.get("controller").getPosition();
        assertNotNull(lidarPos);
        assertNotNull(plannerPos);
        assertNotNull(controllerPos);
        assertTrue(
                lidarPos.getX() < plannerPos.getX(),
                "Expected ELK LEFT->RIGHT layout: lidar.x (" + lidarPos.getX() + ") < planner.x (" + plannerPos.getX() + ")");
        assertTrue(
                plannerPos.getX() < controllerPos.getX(),
                "Expected ELK LEFT->RIGHT layout: planner.x (" + plannerPos.getX() + ") < controller.x (" + controllerPos.getX() + ")");

        // Verify Connections are GEdges with orthogonal routing points
        List<GEdge> edges = ggraph.getChildren().stream()
                .filter(GEdge.class::isInstance)
                .map(GEdge.class::cast)
                .collect(Collectors.toList());
        assertEquals(2, edges.size(), "Expected 2 connection GEdges");

        for (GEdge edge : edges) {
            List<GPoint> routingPoints = edge.getRoutingPoints();
            assertFalse(
                    routingPoints.isEmpty(),
                    "Expected ELK orthogonal edge routing to populate routingPoints for edge " + edge.getId());
            assertTrue(
                    routingPoints.size() >= 2,
                    "Expected at least start and end points in routingPoints for edge " + edge.getId());

            // Check that each consecutive segment is orthogonal (dx == 0 or dy == 0 within epsilon)
            for (int i = 0; i < routingPoints.size() - 1; i++) {
                GPoint p1 = routingPoints.get(i);
                GPoint p2 = routingPoints.get(i + 1);
                double dx = Math.abs(p1.getX() - p2.getX());
                double dy = Math.abs(p1.getY() - p2.getY());
                assertTrue(
                        dx < 1e-3 || dy < 1e-3,
                        String.format(
                                "Non-orthogonal segment on edge %s: (%.2f, %.2f) -> (%.2f, %.2f)",
                                edge.getId(), p1.getX(), p1.getY(), p2.getX(), p2.getY()));
            }
        }
    }
}
