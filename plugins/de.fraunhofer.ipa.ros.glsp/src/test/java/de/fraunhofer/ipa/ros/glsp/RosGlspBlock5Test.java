package de.fraunhofer.ipa.ros.glsp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.google.inject.Guice;
import com.google.inject.Injector;
import de.fraunhofer.ipa.ros.glsp.model.RosAstNodeModelSerializer;
import de.fraunhofer.ipa.ros.glsp.model.RosModelState;
import de.fraunhofer.ipa.ros.glsp.operations.EditRosPropertyOperation;
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
    void blankSourceTextIsTreatedAsANewSystem() throws Exception {
        writeCompanions();
        Path sysFile = tempDir.resolve("fresh-sys.rossystem");
        Files.writeString(sysFile, "\n");
        open(sysFile, "");
        assertEquals("fresh_sys", state.getRosSystem().orElseThrow().getName());
        addNode("planner", "nav_pkg.planner_node");
        assertTrue(commit().newText.startsWith("fresh_sys:\n  nodes:\n    planner:"));
    }
}
