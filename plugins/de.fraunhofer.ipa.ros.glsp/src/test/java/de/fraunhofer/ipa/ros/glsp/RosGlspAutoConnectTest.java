package de.fraunhofer.ipa.ros.glsp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.google.inject.Guice;
import com.google.inject.Injector;
import de.fraunhofer.ipa.ros.glsp.actions.RequestRosAutoConnectAction;
import de.fraunhofer.ipa.ros.glsp.actions.SetRosAutoConnectAction;
import de.fraunhofer.ipa.ros.glsp.actions.SetRosAutoConnectAction.Candidate;
import de.fraunhofer.ipa.ros.glsp.actions.SetRosAutoConnectAction.Receiver;
import de.fraunhofer.ipa.ros.glsp.handlers.RequestRosAutoConnectActionHandler;
import de.fraunhofer.ipa.ros.glsp.model.RosAstNodeModelSerializer;
import de.fraunhofer.ipa.ros.glsp.model.RosModelState;
import de.fraunhofer.ipa.ros.glsp.operations.ApplyRosAutoConnectOperation;
import de.fraunhofer.ipa.ros.glsp.operations.ToggleSubSystemOperation;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import org.eclipse.emf.common.command.Command;
import org.eclipse.glsp.graph.GModelElement;
import org.eclipse.glsp.graph.GNode;
import org.eclipse.glsp.server.actions.Action;
import org.eclipse.glsp.server.di.ServerModule;
import org.eclipse.glsp.server.features.core.model.GModelFactory;
import org.eclipse.glsp.server.features.core.model.RequestModelAction;
import org.eclipse.glsp.server.features.core.model.SourceModelStorage;
import org.eclipse.glsp.server.features.validation.Marker;
import org.eclipse.glsp.server.features.validation.MarkerKind;
import org.eclipse.glsp.server.features.validation.MarkersReason;
import org.eclipse.glsp.server.features.validation.ModelValidator;
import org.eclipse.glsp.server.operations.CreateEdgeOperation;
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
 * Auto-connect over GLSP with the receiver port as the only decision point: requestRosAutoConnect
 * lists each receiver's ranked candidate emitters (at most one preselected); applyRosAutoConnect
 * adds a selection as one command, validated per receiver.
 */
class RosGlspAutoConnectTest {

    @TempDir
    Path tempDir;

    private Injector injector;
    private RosModelState state;

    // ------------------------------------------------------------------ fixtures

    private static final String MSGS = String.join("\n",
            "demo_msgs:",
            "  msgs:",
            "    Scan", "      message", "        float32[] ranges",
            "    Twist", "      message", "        float64 linear",
            "    Image", "      message", "        uint8[] data",
            "    Cloud", "      message", "        float32[] points",
            "    Imu", "      message", "        float64 yaw",
            "  srvs:",
            "    SetMode", "      request", "        string mode", "      response", "        bool ok",
            "");

    private static String artifact(final String art, final String node, final String... sections) {
        StringBuilder sb = new StringBuilder("    " + art + ":\n      node: " + node + "\n");
        for (String s : sections) {
            sb.append(s);
        }
        return sb.toString();
    }

    private static String section(final String kind, final String name, final String type) {
        return "      " + kind + ":\n        " + name + ":\n          type: \"" + type + "\"\n";
    }

    private static final String PKG = "demo_pkg:\n  artifacts:\n"
            + artifact("lidar_drv", "lidar_node", section("publishers", "scan", "demo_msgs/msg/Scan"))
            + artifact("planner_art", "planner_node",
                    section("subscribers", "scan", "demo_msgs/msg/Scan"),
                    section("publishers", "cmd", "demo_msgs/msg/Twist"),
                    section("serviceclients", "set_mode", "demo_msgs/srv/SetMode"))
            + artifact("base_art", "base_node",
                    section("subscribers", "cmd_vel", "demo_msgs/msg/Twist"),
                    section("serviceservers", "mode", "demo_msgs/srv/SetMode"))
            + artifact("base2_art", "base2_node", section("serviceservers", "mode2", "demo_msgs/srv/SetMode"))
            + artifact("mapper_art", "mapper_node", section("subscribers", "scan_raw", "demo_msgs/msg/Scan"))
            + artifact("cam_art", "cam_node", section("publishers", "image_out", "demo_msgs/msg/Image"))
            + artifact("cam2_art", "cam2_node", section("publishers", "snapshot", "demo_msgs/msg/Image"))
            + artifact("viewer_art", "viewer_node", section("subscribers", "Image_In", "demo_msgs/msg/Image"))
            + artifact("cloud_src_art", "cloud_src_node", section("publishers", "points", "demo_msgs/msg/Cloud"))
            + artifact("cloud_sink_art", "cloud_sink_node", section("subscribers", "data", "demo_msgs/msg/Cloud"))
            + artifact("hub_art", "hub_node", section("subscribers", "scan", "demo_msgs/msg/Scan"))
            + artifact("ghost_art", "ghost_node", section("publishers", "ghost_scan", "demo_msgs/msg/Missing"))
            + artifact("imu_art", "imu_node", section("publishers", "imu_data", "demo_msgs/msg/Imu"))
            + artifact("fusion_art", "fusion_node", section("subscribers", "imu_data", "demo_msgs/msg/Imu"));

    private static String node(final String name, final String from, final String... interfaces) {
        StringBuilder sb = new StringBuilder("    " + name + ":\n      from: \"demo_pkg." + from + "\"\n");
        if (interfaces.length > 0) {
            sb.append("      interfaces:\n");
            for (String i : interfaces) {
                sb.append("        - ").append(i).append("\n");
            }
        }
        return sb.toString();
    }

    private void writeCommon() throws Exception {
        Files.writeString(tempDir.resolve("demo_msgs.ros"), MSGS);
        Files.writeString(tempDir.resolve("demo_pkg.ros2"), PKG);
    }

    /** One flat system exercising every tier. */
    private Path writeTierSystem(final boolean withGuards) throws Exception {
        writeCommon();
        String text = "demo_system:\n  nodes:\n"
                + node("lidar", "lidar_node")
                + node("planner", "planner_node",
                        "cmd_vel: pub-> \"planner_art::cmd\"", "mode_srv: sc-> \"planner_art::set_mode\"")
                + node("base", "base_node", "mode_srv: ss-> \"base_art::mode\"")
                + node("base2", "base2_node")
                + node("mapper", "mapper_node", "scan: sub-> \"mapper_art::scan_raw\"")
                + node("cam", "cam_node")
                + node("cam2", "cam2_node")
                + node("viewer", "viewer_node")
                + node("cloud_src", "cloud_src_node")
                + node("cloud_sink", "cloud_sink_node")
                + node("hub", "hub_node")
                + (withGuards
                        ? node("ghost", "ghost_node") + node("dyn", "lidar_node", "\"{robot}_scan\": pub-> \"lidar_drv::scan\"")
                        : "");
        Path sys = tempDir.resolve("demo_system.rossystem");
        Files.writeString(sys, text);
        return sys;
    }

    /** robot -> sensor_sub -> deep_sub. */
    private Path writeSubsystemSystem() throws Exception {
        writeCommon();
        Files.writeString(tempDir.resolve("deep_sub.rossystem"), "deep_sub:\n  nodes:\n"
                + node("deep_cam", "cam_node", "image_out: pub-> \"cam_art::image_out\""));
        Files.writeString(tempDir.resolve("sensor_sub.rossystem"), "sensor_sub:\n  subSystems:\n    deep_sub\n  nodes:\n"
                + node("front_lidar", "lidar_node", "front_scan: pub-> \"lidar_drv::scan\"")
                + node("inner_listener", "mapper_node", "front_scan: sub-> \"mapper_art::scan_raw\"")
                + node("imu", "imu_node"));
        Path robot = tempDir.resolve("robot.rossystem");
        Files.writeString(robot, "robot:\n  subSystems:\n    sensor_sub\n  nodes:\n"
                + node("planner", "planner_node", "front_scan: sub-> \"planner_art::scan\"")
                + node("monitor", "viewer_node")
                + node("fusion", "fusion_node"));
        return robot;
    }

    // ------------------------------------------------------------------ harness

    private void open(final Path file) {
        Injector serverInjector = Guice.createInjector(
                new ServerModule().configureDiagramModule(new RosGlspModule()));
        ClientSession session = serverInjector.getInstance(ClientSessionManager.class).getOrCreateClientSession(
                new InitializeClientSessionParameters("autoconnect", RosModelTypes.DIAGRAM_TYPE, Collections.emptyList()));
        injector = session.getInjector();
        state = injector.getInstance(RosModelState.class);
        Map<String, String> opts = new HashMap<>();
        opts.put("sourceUri", file.toUri().toString());
        injector.getInstance(SourceModelStorage.class).loadSourceModel(new RequestModelAction(opts));
        injector.getInstance(GModelFactory.class).createGModel();
    }

    private SetRosAutoConnectAction dryRun(final List<String> selected, final String... nodes) {
        RequestRosAutoConnectAction request = new RequestRosAutoConnectAction();
        request.setNodes(List.of(nodes));
        request.setSelected(selected);
        List<Action> out = injector.getInstance(RequestRosAutoConnectActionHandler.class).execute(request);
        assertEquals(1, out.size());
        return (SetRosAutoConnectAction) out.get(0);
    }

    private SetRosAutoConnectAction dryRun(final String... nodes) {
        return dryRun(null, nodes);
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    private Optional<Command> command(final Operation op) {
        OperationHandler handler = injector.getInstance(OperationHandlerRegistry.class).getOperationHandler(op).orElseThrow();
        return handler.createCommand(op);
    }

    private void exec(final Operation op) {
        state.execute(command(op).orElseThrow(() -> new AssertionError("Empty command")));
    }

    private String commit() throws Exception {
        RosAstNodeModelSerializer.TextChange change = RosAstNodeModelSerializer.computeAndCommit(state);
        XtextResource res = state.getXtextResource().orElseThrow();
        assertFalse(res.getParseResult().hasSyntaxErrors(), change.newText);
        return change.newText;
    }

    private List<String> validationErrors() {
        injector.getInstance(GModelFactory.class).createGModel();
        List<Marker> markers = injector.getInstance(ModelValidator.class)
                .validate(List.of(state.getRoot()), MarkersReason.LIVE);
        return markers.stream().filter(m -> MarkerKind.ERROR.equals(m.getType()))
                .map(Marker::getDescription).collect(Collectors.toList());
    }

    private static Receiver receiver(final SetRosAutoConnectAction res, final String ref) {
        return res.getReceivers().stream().filter(r -> r.ref.equals(ref)).findFirst()
                .orElseThrow(() -> new AssertionError("no receiver " + ref + " in "
                        + res.getReceivers().stream().map(r -> r.ref).toList()));
    }

    /** "emitter tier [*]" per candidate, best first; * = preselected. */
    private static List<String> ranked(final Receiver r) {
        return r.candidates.stream().map(c -> c.emitterRef + " " + c.tier + (c.preselected ? " *" : ""))
                .collect(Collectors.toList());
    }

    private static List<String> allIds(final SetRosAutoConnectAction res) {
        return res.getReceivers().stream().flatMap(r -> r.candidates.stream()).map(c -> c.id).toList();
    }

    private static List<String> preselectedIds(final SetRosAutoConnectAction res) {
        return res.getReceivers().stream().flatMap(r -> r.candidates.stream())
                .filter(c -> c.preselected).map(c -> c.id).toList();
    }

    private long connectionsFrom(final String emitterRef) {
        system.System root = state.getRosSystem().orElseThrow();
        return root.getConnections().stream()
                .map(c -> (system.RosSystemConnection) c)
                .filter(c -> de.fraunhofer.ipa.ros.glsp.handlers.RosElementResolver.qualifiedRef(root, c.getFrom()).equals(emitterRef))
                .count();
    }

    // ------------------------------------------------------------------ tiers, ranking, receiver contract

    @Test
    void receiversListRankedCandidatesWithAtMostOnePreselection() throws Exception {
        open(writeTierSystem(false));
        SetRosAutoConnectAction res = dryRun();

        assertEquals(List.of("base::mode_srv remap *", "base2::mode2 type-ambiguous"),
                ranked(receiver(res, "planner::mode_srv")));
        assertEquals(List.of("planner::cmd_vel directed-remap *"), ranked(receiver(res, "base::cmd_vel")));
        assertEquals(List.of("lidar::scan directed-remap *"), ranked(receiver(res, "mapper::scan")));
        assertEquals(List.of("lidar::scan contract *"), ranked(receiver(res, "planner::scan")));
        // Fuzzy (case and an "_in"/"_out" suffix) outranks a type-only match but is never preselected.
        assertEquals(List.of("cam::image_out fuzzy", "cam2::snapshot type-ambiguous"),
                ranked(receiver(res, "viewer::Image_In")));
        // The only emitter of a type is type-unique, not preselected either.
        assertEquals(List.of("cloud_src::points type-unique"), ranked(receiver(res, "cloud_sink::data")));

        Candidate fuzzy = receiver(res, "viewer::Image_In").candidates.get(0);
        assertTrue(fuzzy.evidence.contains("'image_out' ~ 'Image_In'"), fuzzy.evidence);
        assertTrue(fuzzy.score > 60 && fuzzy.score <= 75, String.valueOf(fuzzy.score));

        // Receiver contract: only receivers decide, at most one preselection each.
        for (Receiver r : res.getReceivers()) {
            assertTrue(List.of("sub", "sc", "ac").contains(r.kind), r.ref);
            assertEquals(r.ref, r.receiverId);
            assertEquals("sub".equals(r.kind), r.multiAllowed, r.ref);
            assertTrue(r.candidates.stream().filter(c -> c.preselected).count() <= 1, r.ref);
            assertNotNull(r.portId, r.ref);
            assertTrue(state.getIndex().get(r.portId).isPresent(), r.portId);
            for (Candidate c : r.candidates) {
                assertTrue(List.of("pub", "ss", "as").contains(c.emitterKind), c.id);
                assertEquals(c.emitterRef + "->" + r.ref, c.id);
                assertTrue(state.getIndex().get(c.emitterPortId).isPresent(), c.emitterPortId);
                assertFalse(c.emitterNode.equals(r.node), "no self connection " + c.id);
            }
        }
        Receiver planner = receiver(res, "planner::scan");
        assertEquals("sub", planner.kind);
        assertEquals("demo_msgs/Scan", planner.type.replace("/msg/", "/"));
        assertEquals(0, state.getRosSystem().orElseThrow().getConnections().size(), "a dry run modifies nothing");
    }

    @Test
    void twoEquallyStrongEmittersLeaveTheReceiverWithoutPreselection() throws Exception {
        writeCommon();
        Path sys = tempDir.resolve("twin_system.rossystem");
        Files.writeString(sys, "twin_system:\n  nodes:\n"
                + node("lidar_a", "lidar_node") + node("lidar_b", "lidar_node") + node("planner", "planner_node"));
        open(sys);
        assertEquals(List.of("lidar_a::scan contract", "lidar_b::scan contract"),
                ranked(receiver(dryRun(), "planner::scan")));
    }

    @Test
    void runtimeNamesAndUnresolvedTypesAreSkippedWithReasons() throws Exception {
        open(writeTierSystem(true));
        SetRosAutoConnectAction res = dryRun();
        assertTrue(res.getSkipped().contains("dyn::{robot}_scan: the name has a runtime {...} part"), res.getSkipped().toString());
        assertTrue(res.getSkipped().contains("ghost::ghost_scan: the message/service/action type is not resolved"),
                res.getSkipped().toString());
        assertFalse(allIds(res).stream().anyMatch(id -> id.startsWith("dyn::") || id.startsWith("ghost::")));
    }

    @Test
    void focusModeKeepsOnlyCandidatesTouchingTheGivenNodes() throws Exception {
        open(writeTierSystem(false));
        SetRosAutoConnectAction res = dryRun("base");
        assertEquals(List.of("base::cmd_vel", "planner::mode_srv"),
                res.getReceivers().stream().map(r -> r.ref).sorted().toList());
        assertEquals(List.of("base::mode_srv remap *"), ranked(receiver(res, "planner::mode_srv")));
    }

    // ------------------------------------------------------------------ apply: per-receiver validity

    @Test
    void aClientWithTwoSelectedServersGetsNeitherAndTheReasonIsReported() throws Exception {
        open(writeTierSystem(false));
        List<String> selection = List.of(
                "base::mode_srv->planner::mode_srv",
                "base2::mode2->planner::mode_srv",
                "lidar::scan->planner::scan",
                "ghost::out->nobody::in");

        SetRosAutoConnectAction verdict = dryRun(selection);
        assertEquals(List.of("lidar::scan->planner::scan"), verdict.getSelection().accepted);
        Map<String, String> rejected = verdict.getSelection().rejected.stream()
                .collect(Collectors.toMap(r -> r.id, r -> r.reason));
        assertEquals(3, rejected.size(), rejected.toString());
        assertTrue(rejected.get("base2::mode2->planner::mode_srv")
                .startsWith("service client planner::mode_srv takes exactly one server; 2 were selected"), rejected.toString());
        assertEquals(rejected.get("base2::mode2->planner::mode_srv"), rejected.get("base::mode_srv->planner::mode_srv"));
        assertTrue(rejected.get("ghost::out->nobody::in").startsWith("not a current candidate"));

        exec(new ApplyRosAutoConnectOperation(selection));
        String text = commit();
        assertTrue(text.contains("    - [ \"lidar::scan\" , \"planner::scan\" ]\n"), text);
        assertFalse(text.contains("mode_srv\" ]"), "the client stays unconnected:\n" + text);
        assertFalse(text.contains("base2::mode2"), text);
        assertFalse(text.contains("base2_art::mode2"), text);
        assertEquals(1, state.getRosSystem().orElseThrow().getConnections().size());
        // The client is still open for a single choice.
        assertEquals(2, receiver(dryRun(), "planner::mode_srv").candidates.size());
    }

    @Test
    void aSubscriberTakesEveryExplicitlySelectedPublisher() throws Exception {
        open(writeTierSystem(false));
        List<String> both = List.of("cam::image_out->viewer::Image_In", "cam2::snapshot->viewer::Image_In");
        assertEquals(both, dryRun(both).getSelection().accepted);
        exec(new ApplyRosAutoConnectOperation(both));
        String text = commit();
        assertTrue(text.contains("    - [ \"cam::image_out\" , \"viewer::Image_In\" ]\n"), text);
        assertTrue(text.contains("    - [ \"cam2::snapshot\" , \"viewer::Image_In\" ]\n"), text);
        assertTrue(dryRun().getAlreadyConnected().stream()
                .anyMatch(cr -> cr.receiverId.equals("viewer::Image_In") && cr.from.size() == 2));
        assertEquals(List.of(), validationErrors());
    }

    @Test
    void applyingThePreselectionMatchesTheEmitterSummaryAndIsOneUndoableCommand() throws Exception {
        Path sys = writeTierSystem(false);
        String ros2Before = Files.readString(tempDir.resolve("demo_pkg.ros2"));
        open(sys);
        SetRosAutoConnectAction before = dryRun();
        List<String> pre = preselectedIds(before);
        assertEquals(5, pre.size(), pre.toString());

        exec(new ApplyRosAutoConnectOperation(pre));
        system.System model = state.getRosSystem().orElseThrow();
        assertEquals(5, model.getConnections().size());
        // The read-only fan-out predicted exactly what was applied.
        for (SetRosAutoConnectAction.EmitterSummary s : before.getEmitterSummary()) {
            assertEquals(s.preselectedReceivers, connectionsFrom(s.emitterRef), s.emitterRef);
        }
        SetRosAutoConnectAction.EmitterSummary lidar = before.getEmitterSummary().stream()
                .filter(s -> s.emitterRef.equals("lidar::scan")).findFirst().orElseThrow();
        assertEquals(3, lidar.candidateReceivers);
        assertEquals(3, lidar.preselectedReceivers);

        // One command: a single undo removes every connection and promoted interface; redo restores.
        state.getEditingDomain().getCommandStack().undo();
        assertEquals(0, model.getConnections().size());
        assertTrue(model.getComponents().stream().filter(c -> c instanceof system.RosNode rn && "hub".equals(rn.getName())).findFirst()
                .map(c -> ((system.RosNode) c).getRosinterfaces().isEmpty()).orElseThrow());
        state.getEditingDomain().getCommandStack().redo();
        assertEquals(5, model.getConnections().size());

        String text = commit();
        assertEquals(1, text.split("- scan: pub-> \"lidar_drv::scan\"", -1).length - 1, "promoted once:\n" + text);
        assertFalse(text.contains("base2_art::mode2"), text);
        assertFalse(text.contains("cloud_src_art"), text);
        assertEquals(ros2Before, Files.readString(tempDir.resolve("demo_pkg.ros2")), "components are never edited");
        assertEquals(List.of(), validationErrors());
        // After apply the emitter's existing connections are reported.
        assertTrue(dryRun().getAlreadyConnected().stream().anyMatch(cr -> cr.receiverId.equals("planner::mode_srv")));
    }

    @Test
    void severalNewInterfacesAndConnectionsOnOneNodeSerializeTogether() throws Exception {
        writeCommon();
        Path sys = tempDir.resolve("batch_system.rossystem");
        Files.writeString(sys, "batch_system:\n  nodes:\n"
                + node("lidar", "lidar_node") + node("planner", "planner_node") + node("base", "base_node"));
        open(sys);
        exec(new ApplyRosAutoConnectOperation(List.of("lidar::scan->planner::scan", "base::mode->planner::set_mode")));
        String text = commit();
        assertTrue(text.contains("    planner:\n      from: \"demo_pkg.planner_node\"\n      interfaces:\n"
                + "        - scan: sub-> \"planner_art::scan\"\n"
                + "        - set_mode: sc-> \"planner_art::set_mode\"\n"), text);
        assertTrue(text.contains("  connections:\n    - [ \"lidar::scan\" , \"planner::scan\" ]\n"
                + "    - [ \"base::mode\" , \"planner::set_mode\" ]\n"), text);
        assertEquals(List.of(), validationErrors());
    }

    @Test
    void applyWithNothingValidSelectedIsANoOp() throws Exception {
        open(writeTierSystem(false));
        assertTrue(command(new ApplyRosAutoConnectOperation(List.of())).isEmpty());
        assertTrue(command(new ApplyRosAutoConnectOperation(List.of("nobody::x->none::y"))).isEmpty());
        assertTrue(command(new ApplyRosAutoConnectOperation(List.of(
                "base::mode_srv->planner::mode_srv", "base2::mode2->planner::mode_srv"))).isEmpty());
    }

    // ------------------------------------------------------------------ subsystems

    @Test
    void subsystemInterfacesAreEndpointsWithQualifiedRefs() throws Exception {
        open(writeSubsystemSystem());
        SetRosAutoConnectAction res = dryRun();

        Receiver planner = receiver(res, "planner::front_scan");
        assertEquals(List.of("sensor_sub::front_lidar::front_scan remap *"), ranked(planner));
        Candidate fromSub = planner.candidates.get(0);
        assertEquals("sensor_sub::front_lidar::front_scan->planner::front_scan", fromSub.id);
        assertEquals("sensor_sub::front_lidar", fromSub.emitterNode);
        assertNotNull(fromSub.emitterPortId, "expanded subsystem: the port is drawn");
        assertTrue(fromSub.emitterPortId.contains("::"), fromSub.emitterPortId);
        assertTrue(state.getIndex().get(fromSub.emitterPortId).isPresent());

        // Nested subsystem: full path; not drawn, highlighted via the subsystem card.
        Candidate nested = receiver(res, "monitor::Image_In").candidates.get(0);
        assertEquals("sensor_sub::deep_sub::deep_cam::image_out", nested.emitterRef);
        assertNull(nested.emitterPortId);
        assertEquals(subsystemCard().getId(), nested.emitterElementId);

        assertFalse(allIds(res).contains("sensor_sub::front_lidar::front_scan->sensor_sub::inner_listener::front_scan"),
                "same-subsystem pairs are never proposed: " + allIds(res));
        assertTrue(res.getSkipped().stream().anyMatch(s -> s.startsWith("sensor_sub::imu::imu_data: not exposed by subsystem sensor_sub")),
                res.getSkipped().toString());
        assertFalse(allIds(res).stream().anyMatch(id -> id.contains("imu::imu_data")));
    }

    @Test
    void collapsedSubsystemEndpointsPointAtTheSubsystemCard() throws Exception {
        open(writeSubsystemSystem());
        GNode card = subsystemCard();
        exec(new ToggleSubSystemOperation(card.getId(), true));
        injector.getInstance(GModelFactory.class).createGModel();
        Candidate c = receiver(dryRun(), "planner::front_scan").candidates.get(0);
        assertNull(c.emitterPortId, "not yet a boundary port: nothing crosses the collapsed subsystem");
        assertEquals(card.getId(), c.emitterElementId);

        exec(new ApplyRosAutoConnectOperation(List.of(c.id)));
        injector.getInstance(GModelFactory.class).createGModel();
        system.RosInterface from = ((system.RosSystemConnection) state.getRosSystem().orElseThrow()
                .getConnections().get(0)).getFrom();
        String boundaryPort = card.getId() + "::" + from.eResource().getURIFragment(from);
        assertTrue(state.getIndex().get(boundaryPort).isPresent(), "the connected interface became a boundary port");
    }

    @Test
    void applyAcrossSubsystemsWritesQualifiedRefsAndKeepsSubsystemFilesUntouched() throws Exception {
        Path robot = writeSubsystemSystem();
        String sensorBefore = Files.readString(tempDir.resolve("sensor_sub.rossystem"));
        String deepBefore = Files.readString(tempDir.resolve("deep_sub.rossystem"));
        open(robot);
        exec(new ApplyRosAutoConnectOperation(List.of(
                "sensor_sub::front_lidar::front_scan->planner::front_scan",
                "sensor_sub::deep_sub::deep_cam::image_out->monitor::Image_In")));
        String text = commit();
        assertTrue(text.contains("    - [ \"sensor_sub::front_lidar::front_scan\" , \"planner::front_scan\" ]\n"), text);
        assertTrue(text.contains("    - [ \"sensor_sub::deep_sub::deep_cam::image_out\" , \"monitor::Image_In\" ]\n"), text);
        assertTrue(text.contains("        - Image_In: sub-> \"viewer_art::Image_In\""), text);
        assertFalse(text.contains("imu"), text);
        assertEquals(sensorBefore, Files.readString(tempDir.resolve("sensor_sub.rossystem")));
        assertEquals(deepBefore, Files.readString(tempDir.resolve("deep_sub.rossystem")));
        for (system.Connection conn : state.getRosSystem().orElseThrow().getConnections()) {
            system.RosSystemConnection sc = (system.RosSystemConnection) conn;
            assertFalse(sc.getFrom().eIsProxy(), "from links");
            assertTrue(sc.getFrom().eResource() != state.getSemanticResource(), "from is the subsystem's interface");
        }
        assertEquals(List.of(), validationErrors());
    }

    @Test
    void manualWiringIntoASubsystemUsesTheQualifiedRef() throws Exception {
        open(writeSubsystemSystem());
        Candidate c = receiver(dryRun(), "planner::front_scan").candidates.get(0);
        exec(new CreateEdgeOperation(RosModelTypes.EDGE_CONNECTION, c.emitterPortId, "planner::front_scan"));
        String text = commit();
        assertTrue(text.contains("    - [ \"sensor_sub::front_lidar::front_scan\" , \"planner::front_scan\" ]\n"), text);
        assertEquals(List.of(), validationErrors());
    }

    private GNode subsystemCard() {
        for (GModelElement el : state.getRoot().getChildren()) {
            if (RosModelTypes.SUBSYSTEM_NODE.equals(el.getType())) {
                return (GNode) el;
            }
        }
        throw new AssertionError("no subsystem card");
    }
}
