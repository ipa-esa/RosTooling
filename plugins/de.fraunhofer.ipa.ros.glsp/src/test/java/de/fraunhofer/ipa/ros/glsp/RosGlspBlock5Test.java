package de.fraunhofer.ipa.ros.glsp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.google.inject.Guice;
import com.google.inject.Injector;
import de.fraunhofer.ipa.ros.glsp.model.RosAstNodeModelSerializer;
import de.fraunhofer.ipa.ros.glsp.model.RosModelState;
import de.fraunhofer.ipa.ros.glsp.operations.EditRosPropertyOperation;
import de.fraunhofer.ipa.ros.glsp.operations.ToggleSubSystemOperation;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.eclipse.emf.common.command.Command;
import org.eclipse.glsp.server.di.ServerModule;
import org.eclipse.glsp.server.features.core.model.GModelFactory;
import org.eclipse.glsp.server.features.core.model.RequestModelAction;
import org.eclipse.glsp.server.features.core.model.SourceModelStorage;
import org.eclipse.glsp.server.operations.CreateEdgeOperation;
import org.eclipse.glsp.server.operations.CreateNodeOperation;
import org.eclipse.glsp.server.operations.DeleteOperation;
import org.eclipse.glsp.server.operations.Operation;
import org.eclipse.glsp.server.operations.OperationHandler;
import org.eclipse.glsp.server.operations.OperationHandlerRegistry;
import org.eclipse.glsp.server.protocol.InitializeClientSessionParameters;
import org.eclipse.glsp.server.session.ClientSession;
import org.eclipse.glsp.server.session.ClientSessionManager;
import org.eclipse.xtext.resource.XtextResource;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

/**
 * Block 5 (server side): the coordinate-free MCP tools start from a .rossystem that does not
 * exist yet. The storage opens it as an empty Ecore System, the first commit produces the file
 * text, and every following operation is a surgical span edit.
 */
class RosGlspBlock5Test {

    @TempDir
    Path tempDir;

    private RosModelState state;
    private Injector injector;
    private OperationHandlerRegistry registry;

    private void open(final Path file, final String sourceText) {
        Injector serverInjector = Guice.createInjector(
                new ServerModule().configureDiagramModule(new RosGlspModule()));
        ClientSession session = serverInjector.getInstance(ClientSessionManager.class).getOrCreateClientSession(
                new InitializeClientSessionParameters("block5", RosModelTypes.DIAGRAM_TYPE, Collections.emptyList()));
        Injector inj = session.getInjector();
        injector = inj;
        state = inj.getInstance(RosModelState.class);
        registry = inj.getInstance(OperationHandlerRegistry.class);
        Map<String, String> opts = new HashMap<>();
        opts.put("sourceUri", file.toUri().toString());
        if (sourceText != null) {
            opts.put("sourceText", sourceText);
        }
        inj.getInstance(SourceModelStorage.class).loadSourceModel(new RequestModelAction(opts));
        inj.getInstance(GModelFactory.class).createGModel();
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    private void exec(final Operation op) {
        OperationHandler handler = registry.getOperationHandler(op).orElseThrow();
        java.util.Optional<Command> cmdOpt = handler.createCommand(op);
        Command cmd = cmdOpt.orElseThrow(
                () -> new AssertionError("Empty command for " + op.getClass().getSimpleName()));
        state.execute(cmd);
    }

    private RosAstNodeModelSerializer.TextChange commit() throws Exception {
        RosAstNodeModelSerializer.TextChange change = RosAstNodeModelSerializer.computeAndCommit(state);
        XtextResource res = state.getXtextResource().orElseThrow();
        assertFalse(res.getParseResult().hasSyntaxErrors(),
                change.newText + "\n" + res.getParseResult().getSyntaxErrors());
        return change;
    }

    private void writeCompanions() throws Exception {
        Files.writeString(tempDir.resolve("nav_msgs.ros"), String.join("\n",
                "nav_msgs:", "  msgs:", "    LaserScan", "      message", "        float32[] ranges", ""));
        Files.writeString(tempDir.resolve("nav_pkg.ros2"), String.join("\n",
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
                "    local_planner:",
                "      node: planner_node",
                "      subscribers:",
                "        scan_in:",
                "          type: \"nav_msgs/msg/LaserScan\"",
                ""));
    }

    private void addNode(final String name, final String from) {
        Map<String, String> args = new HashMap<>();
        args.put("nodeName", name);
        args.put("from", from);
        exec(new CreateNodeOperation(RosModelTypes.ROS_NODE, null, null, args));
    }

    @Test
    void systemIsBuiltFromAMissingFileWithoutCoordinates() throws Exception {
        writeCompanions();
        Path sysFile = tempDir.resolve("nav_system.rossystem");
        open(sysFile, null);
        system.System sys = state.getRosSystem().orElseThrow();
        assertEquals("nav_system", sys.getName());

        addNode("lidar", "nav_pkg.lidar_node");
        RosAstNodeModelSerializer.TextChange first = commit();
        assertEquals("", first.baseText);
        assertEquals(1, first.edits.size());
        assertTrue(first.newText.startsWith("nav_system:\n  nodes:\n    lidar:\n      from: \"nav_pkg.lidar_node\"\n"),
                first.newText);

        addNode("planner", "nav_pkg.planner_node");
        exec(new CreateEdgeOperation(RosModelTypes.EDGE_CONNECTION, "lidar.scan", "planner.scan_in"));
        exec(new EditRosPropertyOperation("lidar", "parameter", "frame_id", "laser_link", "String"));
        Map<String, String> proc = new HashMap<>();
        proc.put("processName", "nav_container");
        proc.put("nodes", "lidar,planner");
        exec(new CreateNodeOperation(RosModelTypes.PROCESS_NODE, null, null, proc));
        RosAstNodeModelSerializer.TextChange second = commit();
        assertTrue(second.newText.startsWith("nav_system:\n  processes:\n    nav_container:\n"), second.newText);
        assertTrue(second.newText.contains(first.newText.substring(first.newText.indexOf("    lidar:"))), second.newText);
        assertTrue(second.newText.contains("    - [ \"lidar::scan\" , \"planner::scan_in\" ]\n"), second.newText);
        assertTrue(second.newText.contains("nodes: [ lidar , planner ]"), second.newText);
        assertTrue(second.newText.contains("laser_link"), second.newText);

        sys = state.getRosSystem().orElseThrow();
        assertEquals(2, sys.getComponents().size());
        assertEquals(1, sys.getConnections().size());
        assertEquals(2, sys.getProcesses().get(0).getComponents().size());

        // Processes and connections can be removed by their semantic names.
        exec(new DeleteOperation(List.of("nav_container")));
        String text = commit().newText;
        assertFalse(text.contains("nav_container"), text);
    }

    @Test
    void validationDoesNotConsumePendingEdits() throws Exception {
        writeCompanions();
        Path sysFile = tempDir.resolve("val_system.rossystem");
        String disk = String.join("\n",
                "val_system:",
                "  nodes:",
                "    lidar:",
                "      from: \"nav_pkg.lidar_node\"",
                "    planner:",
                "      from: \"nav_pkg.planner_node\"",
                "");
        Files.writeString(sysFile, disk);
        open(sysFile, null);
        assertTrue(injector.getInstance(org.eclipse.glsp.server.features.core.model.ModelSubmissionHandler.class)
                instanceof de.fraunhofer.ipa.ros.glsp.model.RosModelSubmissionHandler,
                "live validation must run on the dispatcher thread, not a debounce timer");
        exec(new CreateEdgeOperation(RosModelTypes.EDGE_CONNECTION, "lidar.scan", "planner.scan_in"));
        // Live validation (e.g. a client's requestMarkers) between an operation and the commit.
        java.util.List<org.eclipse.glsp.server.features.validation.Marker> markers =
                injector.getInstance(org.eclipse.glsp.server.features.validation.ModelValidator.class)
                        .validate(List.of(), "live");
        assertTrue(markers.stream().noneMatch(m -> "error".equals(m.getType())), markers.toString());
        RosAstNodeModelSerializer.TextChange change = commit();
        assertEquals(disk, change.baseText, "validation must not commit pending mutations");
        assertTrue(change.newText.contains("- [ \"lidar::scan\" , \"planner::scan_in\" ]"), change.newText);
        assertFalse(change.edits.isEmpty());
    }

    @Test
    void connectionEndpointsKeepTheirStyleAndSecondInstancesStayUnambiguous() throws Exception {
        writeCompanions();
        Path sysFile = tempDir.resolve("dup_system.rossystem");
        Files.writeString(sysFile, String.join("\n",
                "dup_system:",
                "  nodes:",
                "    lidar:",
                "      from: \"nav_pkg.lidar_node\"",
                "    planner:",
                "      from: \"nav_pkg.planner_node\"",
                "  connections:",
                "    - [\"lidar::scan\", \"planner::scan_in\"] # qualified, hand-written",
                ""));
        open(sysFile, null);
        // A second instance of the planner type: same interface names as 'planner'.
        addNode("planner_b", "nav_pkg.planner_node");
        exec(new CreateEdgeOperation(RosModelTypes.EDGE_CONNECTION, "lidar.scan", "planner_b.scan_in"));
        // Unknown node types are rejected (no dangling 'from:' is written).
        addNode("ghost", "nav_pkg.no_such_node");
        // Undeclared parameters are rejected (no dangling RosParameter is written).
        exec(new EditRosPropertyOperation("planner", "parameter", "not_declared", "1", null));
        String text = commit().newText;
        assertTrue(text.contains("    - [\"lidar::scan\", \"planner::scan_in\"] # qualified, hand-written\n"), text);
        assertTrue(text.contains("    - [ \"lidar::scan\" , \"planner_b::scan_in\" ]"), text);
        assertFalse(text.contains("not_declared"), text);
        assertFalse(text.contains("ghost"), text);
        system.System sys = state.getRosSystem().orElseThrow();
        assertEquals(2, sys.getConnections().size());
        for (var c : sys.getConnections()) {
            var sc = (system.RosSystemConnection) c;
            assertFalse(sc.getFrom().eIsProxy() || sc.getTo().eIsProxy(), "connection endpoints must link");
        }

        // Renaming a node updates qualified endpoints in place, keeping their style.
        exec(new EditRosPropertyOperation("planner", "name", null, "planner_a", null));
        text = commit().newText;
        assertTrue(text.contains("    - [\"lidar::scan\", \"planner_a::scan_in\"] # qualified, hand-written\n"), text);
    }

    @Test
    void catalogueTypesResolveLikeInTheLanguageServer() throws Exception {
        // A catalogue outside the model's package (like ~/.rostooling/catalogue_repos).
        Path catalogue = Files.createDirectories(tempDir.resolve("catalogue/RosCommonObjects/basic_msgs"));
        Files.writeString(catalogue.resolve("sensor_msgs.ros"), String.join("\n",
                "sensor_msgs:", "  msgs:", "    Image", "      message", "        uint32 height", ""));
        Path pkg = Files.createDirectories(tempDir.resolve("ws/vision_pkg"));
        Files.writeString(pkg.resolve("package.xml"), "<package/>\n");
        Files.writeString(pkg.resolve("vision_pkg.ros2"), String.join("\n",
                "vision_pkg:",
                "  artifacts:",
                "    camera:",
                "      node: camera",
                "      publishers:",
                "        image:",
                "          type: \"sensor_msgs/msg/Image\"",
                "    detector:",
                "      node: detector",
                "      subscribers:",
                "        image_in:",
                "          type: \"sensor_msgs/msg/Image\"",
                ""));
        Path sysFile = pkg.resolve("vision.rossystem");
        Files.writeString(sysFile, String.join("\n",
                "vision:",
                "  nodes:",
                "    camera:",
                "      from: \"vision_pkg.camera\"",
                "      interfaces:",
                "        - image: pub-> \"camera::image\"",
                "    detector:",
                "      from: \"vision_pkg.detector\"",
                "      interfaces:",
                "        - image_in: sub-> \"detector::image_in\"",
                "  connections:",
                "    - [ image , image_in ]",
                ""));
        String previous = System.getProperty("rostooling.catalogue.path");
        System.setProperty("rostooling.catalogue.path", tempDir.resolve("catalogue").toString());
        try {
            open(sysFile, null);
            java.util.List<org.eclipse.glsp.server.features.validation.Marker> markers =
                    injector.getInstance(org.eclipse.glsp.server.features.validation.ModelValidator.class)
                            .validate(List.of(), "live");
            assertTrue(markers.stream().noneMatch(m -> "error".equals(m.getType())),
                    markers.stream().map(m -> m.getElementId() + ": " + m.getDescription()).toList().toString());
            ros.Publisher pub = (ros.Publisher) ((system.RosPublisherReference) ((system.RosNode) state.getRosSystem()
                    .orElseThrow().getComponents().get(0)).getRosinterfaces().get(0).getReference()).getFrom();
            assertFalse(pub.getMessage().eIsProxy(), "catalogue message type must resolve");
        } finally {
            if (previous == null) {
                System.clearProperty("rostooling.catalogue.path");
            } else {
                System.setProperty("rostooling.catalogue.path", previous);
            }
        }
    }

    @Test
    void movedNodesKeepElkOrthogonalRoutes() throws Exception {
        writeCompanions();
        Path sysFile = tempDir.resolve("layout_system.rossystem");
        Files.writeString(sysFile, String.join("\n",
                "layout_system:",
                "  nodes:",
                "    lidar:",
                "      from: \"nav_pkg.lidar_node\"",
                "    planner:",
                "      from: \"nav_pkg.planner_node\"",
                "    planner_b:",
                "      from: \"nav_pkg.planner_node\"",
                "  connections:",
                "    - [ \"lidar::scan\" , \"planner::scan_in\" ]",
                "    - [ \"lidar::scan\" , \"planner_b::scan_in\" ]",
                ""));
        open(sysFile, null);
        org.eclipse.glsp.server.layout.LayoutEngine engine =
                injector.getInstance(org.eclipse.glsp.server.layout.LayoutEngine.class);
        org.eclipse.glsp.graph.GGraph graph = (org.eclipse.glsp.graph.GGraph) state.getRoot();
        java.util.function.Function<String, org.eclipse.glsp.graph.GNode> node = name -> graph.getChildren().stream()
                .filter(c -> c instanceof org.eclipse.glsp.graph.GNode n && name.equals(n.getArgs().get("nodeName")))
                .map(c -> (org.eclipse.glsp.graph.GNode) c).findFirst().orElseThrow();
        engine.layout();
        double lidarY = node.apply("lidar").getPosition().getY();

        // Drag planner_b far below everything else.
        state.setPinnedPosition(node.apply("planner_b").getId(),
                org.eclipse.glsp.graph.util.GraphUtil.point(node.apply("planner").getPosition().getX(), lidarY + 900));
        engine.layout();

        assertTrue(node.apply("planner_b").getPosition().getY() > node.apply("planner").getPosition().getY() + 200,
                "the moved node keeps its place (as an ELK interactive hint)");
        for (var child : graph.getChildren()) {
            if (child instanceof org.eclipse.glsp.graph.GEdge edge) {
                var pts = edge.getRoutingPoints();
                assertFalse(pts.isEmpty(), "every wire keeps an ELK route: " + edge.getId());
                for (int i = 1; i < pts.size(); i++) {
                    boolean axisAligned = Math.abs(pts.get(i).getX() - pts.get(i - 1).getX()) < 0.5
                            || Math.abs(pts.get(i).getY() - pts.get(i - 1).getY()) < 0.5;
                    assertTrue(axisAligned, "orthogonal ELK route expected for " + edge.getId() + ": " + pts);
                }
            }
        }
    }

    @Test
    void nodeCardsFitTheirLabelsAndWrapLongOnes() throws Exception {
        Files.writeString(tempDir.resolve("nav_msgs.ros"), String.join("\n",
                "nav_msgs:", "  msgs:", "    LaserScan", "      message", "        float32[] ranges", ""));
        Files.writeString(tempDir.resolve("wide_pkg.ros2"), String.join("\n",
                "wide_pkg:",
                "  artifacts:",
                "    wide:",
                "      node: wide_node",
                "      publishers:",
                "        '/scaled_joint_trajectory_controller/follow_joint_trajectory_feedback_and_status':",
                "          type: \"nav_msgs/msg/LaserScan\"",
                "        scan:",
                "          type: \"nav_msgs/msg/LaserScan\"",
                "      subscribers:",
                "        '/camera/camera_3/aligned_depth_to_color/image_raw':",
                "          type: \"nav_msgs/msg/LaserScan\"",
                ""));
        Path sysFile = tempDir.resolve("wide_system.rossystem");
        Files.writeString(sysFile, String.join("\n",
                "wide_system:", "  nodes:", "    wide:", "      from: \"wide_pkg.wide_node\"", ""));
        open(sysFile, null);
        org.eclipse.glsp.graph.GGraph graph = (org.eclipse.glsp.graph.GGraph) state.getRoot();
        org.eclipse.glsp.graph.GNode node = (org.eclipse.glsp.graph.GNode) graph.getChildren().stream()
                .filter(c -> RosModelTypes.ROS_NODE.equals(c.getType())).findFirst().orElseThrow();
        double width = node.getSize().getWidth();
        assertTrue(width > de.fraunhofer.ipa.ros.glsp.model.RosGModelFactory.NODE_WIDTH
                && width <= de.fraunhofer.ipa.ros.glsp.model.RosGModelFactory.MAX_NODE_WIDTH, "width " + width);
        java.util.List<org.eclipse.glsp.graph.GPort> east = node.getChildren().stream()
                .filter(c -> c instanceof org.eclipse.glsp.graph.GPort p && p.getPosition().getX() > 0)
                .map(c -> (org.eclipse.glsp.graph.GPort) c).toList();
        assertEquals(2, east.size());
        String longLines = (String) east.get(0).getArgs().get("labelLines");
        assertTrue(longLines.contains("\n"), "long label wraps: " + longLines);
        assertEquals("/scaled_joint_trajectory_controller/follow_joint_trajectory_feedback_and_status : LaserScan",
                longLines.replace("\n", " ").replace("/ ", "/").replace("_ ", "_").replace(": ", ": "),
                "wrapping keeps the whole label");
        assertEquals(width, east.get(0).getPosition().getX(), 0.01, "east ports sit on the card edge");
        int lineCount = longLines.split("\n").length;
        double gap = east.get(1).getPosition().getY() - east.get(0).getPosition().getY();
        assertEquals(de.fraunhofer.ipa.ros.glsp.model.RosGModelFactory.PORT_ROW_HEIGHT
                + (lineCount - 1) * de.fraunhofer.ipa.ros.glsp.model.RosGModelFactory.PORT_LABEL_LINE_HEIGHT, gap, 0.01,
                "the wrapped row is as tall as its lines");
        assertTrue(node.getSize().getHeight() >= east.get(1).getPosition().getY() + 12, "card holds all rows");
    }

    @Test
    void blankSourceTextIsTreatedAsANewSystem() throws Exception {
        writeCompanions();
        Path sysFile = tempDir.resolve("fresh-sys.rossystem");
        Files.writeString(sysFile, "\n");
        open(sysFile, "");
        assertEquals("fresh_sys", state.getRosSystem().orElseThrow().getName());
        addNode("planner", "nav_pkg.planner_node");
        assertTrue(commit().newText.startsWith("fresh_sys:\n  nodes:\n    planner:"));
    }

    @Test
    void collapsedSubSystemShiftsExternalConnectionsToBoundaryPorts() throws Exception {
        writeCompanions();
        Path subFile = tempDir.resolve("sensor_sub.rossystem");
        Files.writeString(subFile, String.join("\n",
                "sensor_sub:",
                "  nodes:",
                "    lidar:",
                "      from: \"nav_pkg.lidar_node\"",
                "      interfaces:",
                "        - \"scan_out\": pub-> \"lidar_node::scan\"",
                "        - \"scan_loop\": pub-> \"lidar_node::scan\"",
                "    internal_checker:",
                "      from: \"nav_pkg.planner_node\"",
                "      interfaces:",
                "        - \"internal_scan\": sub-> \"planner_node::scan_in\"",
                ""));

        Path outerFile = tempDir.resolve("robot_app.rossystem");
        String outerText = String.join("\n",
                "robot_app:",
                "  subSystems:",
                "    sensor_sub",
                "  nodes:",
                "    planner:",
                "      from: \"nav_pkg.planner_node\"",
                "      interfaces:",
                "        - \"planner_scan\": sub-> \"planner_node::scan_in\"",
                "  connections:",
                "    - [\"scan_out\", \"planner_scan\"]",
                "    - [\"scan_loop\", \"internal_scan\"]",
                "");
        Files.writeString(outerFile, outerText);
        open(outerFile, outerText);

        GModelFactory factory = injector.getInstance(GModelFactory.class);
        org.eclipse.glsp.graph.GGraph expanded = (org.eclipse.glsp.graph.GGraph) state.getRoot();
        long expandedEdges = expanded.getChildren().stream()
                .filter(c -> c instanceof org.eclipse.glsp.graph.GEdge).count();
        assertEquals(2, expandedEdges, "expanded graph renders both external and internal connections");

        org.eclipse.glsp.graph.GNode subNode = (org.eclipse.glsp.graph.GNode) expanded.getChildren().stream()
                .filter(c -> RosModelTypes.SUBSYSTEM_NODE.equals(c.getType()))
                .findFirst().orElseThrow();
        assertEquals(2, subNode.getChildren().stream()
                .filter(c -> RosModelTypes.ROS_NODE.equals(c.getType())).count());

        exec(new ToggleSubSystemOperation(subNode.getId(), true));
        factory.createGModel();
        org.eclipse.glsp.graph.GGraph collapsed = (org.eclipse.glsp.graph.GGraph) state.getRoot();
        org.eclipse.glsp.graph.GNode collapsedSub = (org.eclipse.glsp.graph.GNode) collapsed.getChildren().stream()
                .filter(c -> subNode.getId().equals(c.getId())).findFirst().orElseThrow();
        assertEquals(Boolean.TRUE, collapsedSub.getArgs().get("collapsed"));
        assertEquals(0, collapsedSub.getChildren().stream()
                .filter(c -> RosModelTypes.ROS_NODE.equals(c.getType())).count(),
                "child nodes are hidden while collapsed");

        java.util.List<org.eclipse.glsp.graph.GPort> boundaryPorts = collapsedSub.getChildren().stream()
                .filter(c -> c instanceof org.eclipse.glsp.graph.GPort)
                .map(c -> (org.eclipse.glsp.graph.GPort) c)
                .toList();
        assertEquals(1, boundaryPorts.size(), "only external crossing interface becomes a boundary port");
        org.eclipse.glsp.graph.GPort boundary = boundaryPorts.get(0);
        assertEquals("scan_out", boundary.getArgs().get("interfaceName"));
        assertEquals(collapsedSub.getSize().getWidth(), boundary.getPosition().getX(), 0.01,
                "east boundary port sits on collapsed subsystem edge");
        assertTrue(boundary.getPosition().getY() >= de.fraunhofer.ipa.ros.glsp.model.RosGModelFactory.SUBSYSTEM_COLLAPSED_HEADER_HEIGHT,
                "boundary port starts below subsystem header");

        java.util.List<org.eclipse.glsp.graph.GEdge> edges = collapsed.getChildren().stream()
                .filter(c -> c instanceof org.eclipse.glsp.graph.GEdge)
                .map(c -> (org.eclipse.glsp.graph.GEdge) c)
                .toList();
        assertEquals(1, edges.size(), "internal edge is hidden; external edge remains wired");
        org.eclipse.glsp.graph.GEdge extEdge = edges.get(0);
        assertEquals(boundary.getId(), extEdge.getSourceId(), "edge source shifts to collapsed boundary port");
        assertFalse(extEdge.getRoutingPoints().isEmpty(), "ELK computes orthogonal routing points for collapsed edge");

        exec(new ToggleSubSystemOperation(subNode.getId(), false));
        factory.createGModel();
        org.eclipse.glsp.graph.GGraph reopened = (org.eclipse.glsp.graph.GGraph) state.getRoot();
        assertEquals(2, reopened.getChildren().stream()
                .filter(c -> c instanceof org.eclipse.glsp.graph.GEdge).count(),
                "expanding restores both connections");
    }

    @Test
    void unchangedChangeBoundsDoesNotPinOrDriftLayout() throws Exception {
        writeCompanions();
        Path sysFile = tempDir.resolve("pan_guard.rossystem");
        String text = String.join("\n",
                "pan_guard:",
                "  nodes:",
                "    lidar:",
                "      from: \"nav_pkg.lidar_node\"",
                "");
        Files.writeString(sysFile, text);
        open(sysFile, text);

        org.eclipse.glsp.graph.GGraph graph = (org.eclipse.glsp.graph.GGraph) state.getRoot();
        org.eclipse.glsp.graph.GNode node = (org.eclipse.glsp.graph.GNode) graph.getChildren().stream()
                .filter(c -> RosModelTypes.ROS_NODE.equals(c.getType()))
                .findFirst().orElseThrow();

        org.eclipse.glsp.server.types.ElementAndBounds unchanged =
                new org.eclipse.glsp.server.types.ElementAndBounds();
        unchanged.setElementId(node.getId());
        unchanged.setNewPosition(org.eclipse.glsp.graph.util.GraphUtil.point(
                node.getPosition().getX(), node.getPosition().getY()));
        unchanged.setNewSize(org.eclipse.glsp.graph.util.GraphUtil.dimension(
                node.getSize().getWidth(), node.getSize().getHeight()));

        org.eclipse.glsp.server.operations.ChangeBoundsOperation noopOp =
                new org.eclipse.glsp.server.operations.ChangeBoundsOperation(List.of(unchanged));
        @SuppressWarnings("rawtypes")
        OperationHandler cbHandler = registry.getOperationHandler(noopOp).orElseThrow();
        @SuppressWarnings("unchecked")
        java.util.Optional<Command> noopCmd = cbHandler.createCommand(noopOp);
        assertTrue(noopCmd.isEmpty(),
                "unchanged ChangeBoundsOperation should be a no-op");
        assertTrue(state.getPinnedPositions().isEmpty());

        org.eclipse.glsp.server.types.ElementAndBounds moved =
                new org.eclipse.glsp.server.types.ElementAndBounds();
        moved.setElementId(node.getId());
        moved.setNewPosition(org.eclipse.glsp.graph.util.GraphUtil.point(
                node.getPosition().getX() + 120.0, node.getPosition().getY() + 80.0));
        exec(new org.eclipse.glsp.server.operations.ChangeBoundsOperation(List.of(moved)));
        assertTrue(state.getPinnedPositions().containsKey(node.getId()));
    }
}
