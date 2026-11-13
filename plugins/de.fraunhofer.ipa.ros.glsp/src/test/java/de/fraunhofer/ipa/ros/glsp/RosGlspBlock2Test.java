package de.fraunhofer.ipa.ros.glsp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.google.inject.Guice;
import com.google.inject.Injector;
import de.fraunhofer.ipa.ros.glsp.model.RosModelState;
import de.fraunhofer.ipa.ros.glsp.operations.EditRosPropertyOperation;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.eclipse.emf.common.command.Command;
import org.eclipse.glsp.server.actions.SaveModelAction;
import org.eclipse.glsp.server.di.ServerModule;
import org.eclipse.glsp.server.features.core.model.GModelFactory;
import org.eclipse.glsp.server.features.core.model.RequestModelAction;
import org.eclipse.glsp.server.features.core.model.SourceModelStorage;
import org.eclipse.glsp.server.features.validation.Marker;
import org.eclipse.glsp.server.features.validation.MarkerKind;
import org.eclipse.glsp.server.features.validation.ModelValidator;
import org.eclipse.glsp.server.operations.CreateEdgeOperation;
import org.eclipse.glsp.server.operations.CreateNodeOperation;
import org.eclipse.glsp.server.operations.DeleteOperation;
import org.eclipse.glsp.server.operations.Operation;
import org.eclipse.glsp.server.operations.OperationHandler;
import org.eclipse.glsp.server.operations.OperationHandlerRegistry;
import org.eclipse.glsp.server.protocol.InitializeClientSessionParameters;
import org.eclipse.glsp.server.session.ClientSession;
import org.eclipse.glsp.server.session.ClientSessionManager;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

/**
 * Verification Gate for Block 2:
 * Tests CreateRosNodeOperationHandler, CreateConnectionOperationHandler,
 * EditRosPropertyOperationHandler, DeleteRosElementOperationHandler,
 * RosModelValidator, and surgical node-model save with 100% comment preservation.
 */
class RosGlspBlock2Test {

    @TempDir
    Path tempDir;

    @SuppressWarnings({"unchecked", "rawtypes"})
    private void executeOperation(
            final OperationHandlerRegistry registry,
            final RosModelState modelState,
            final Operation operation) {
        OperationHandler handler = registry.getOperationHandler(operation).orElseThrow(
                () -> new AssertionError("No OperationHandler registered for " + operation.getClass().getName()));
        java.util.Optional<Command> cmdOpt = handler.createCommand(operation);
        Command cmd = cmdOpt.orElseThrow(
                () -> new AssertionError("Handler returned empty command for " + operation.getClass().getName()));
        modelState.execute(cmd);
    }

    @Test
    void testMutateModelAndSaveWithZeroCommentRegression() throws Exception {
        // 1. Create .ros message specs
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

        // 2. Create .ros2 package with 3 node artifacts
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
                "    safety_monitor:",
                "      node: monitor_node",
                "      subscribers:",
                "        scan_emergency:",
                "          type: \"nav_msgs/msg/LaserScan\"",
                "      parameters:",
                "        stop_distance:",
                "          type: Double",
                "          value: 0.5"));

        // 3. Create initial .rossystem with header, section, and trailing inline comments
        Path rossystemFile = tempDir.resolve("nav_system.rossystem");
        Files.writeString(rossystemFile, String.join("\n",
                "# Main Navigation System - DO NOT REMOVE HEADER COMMENT",
                "nav_system:",
                "  nodes:",
                "    # Primary Lidar sensor driver",
                "    lidar:",
                "      from: \"nav_pkg.lidar_node\"",
                "      interfaces:",
                "        - scan: pub-> \"lidar_driver::scan\"",
                "      parameters:",
                "        - frame_id: \"lidar_driver::frame_id\"",
                "          value: \"base_laser\" # keep this inline calibration comment!",
                "    planner:",
                "      from: \"nav_pkg.planner_node\"",
                "      interfaces:",
                "        - scan_in: sub-> \"local_planner::scan_in\"",
                "  # Core topic connections",
                "  connections:",
                "    - [ scan , scan_in ] # primary lidar to planner wire"));

        // 4. Initialize GLSP Server & Session
        Injector serverInjector = Guice.createInjector(
                new ServerModule().configureDiagramModule(new RosGlspModule()));
        ClientSessionManager sessionManager = serverInjector.getInstance(ClientSessionManager.class);
        ClientSession session = sessionManager.getOrCreateClientSession(
                new InitializeClientSessionParameters(
                        "block2-session",
                        RosModelTypes.DIAGRAM_TYPE,
                        Collections.emptyList()));
        Injector sessionInjector = session.getInjector();

        SourceModelStorage storage = sessionInjector.getInstance(SourceModelStorage.class);
        GModelFactory gModelFactory = sessionInjector.getInstance(GModelFactory.class);
        RosModelState modelState = sessionInjector.getInstance(RosModelState.class);
        OperationHandlerRegistry opRegistry = sessionInjector.getInstance(OperationHandlerRegistry.class);
        ModelValidator validator = sessionInjector.getInstance(ModelValidator.class);

        Map<String, String> loadOptions = new HashMap<>();
        loadOptions.put("sourceUri", rossystemFile.toUri().toString());
        storage.loadSourceModel(new RequestModelAction(loadOptions));
        gModelFactory.createGModel();

        // 5. Execute CreateNodeOperation to add safety_monitor node
        Map<String, String> createArgs = new HashMap<>();
        createArgs.put("nodeName", "safety_monitor");
        createArgs.put("from", "nav_pkg.safety_monitor.monitor_node");
        createArgs.put("namespace", "safety");
        CreateNodeOperation createNodeOp = new CreateNodeOperation(
                RosModelTypes.ROS_NODE, null, null, createArgs);
        executeOperation(opRegistry, modelState, createNodeOp);

        assertEquals(3, modelState.getRosSystem().get().getComponents().size());

        // 6. Execute CreateEdgeOperation to wire lidar.scan -> safety_monitor.scan_emergency
        CreateEdgeOperation createEdgeOp = new CreateEdgeOperation(
                RosModelTypes.EDGE_CONNECTION,
                "lidar.scan",
                "safety_monitor.scan_emergency");
        executeOperation(opRegistry, modelState, createEdgeOp);

        assertEquals(2, modelState.getRosSystem().get().getConnections().size());

        // 7. Execute EditRosPropertyOperation on lidar's frame_id (which has an inline trailing comment!)
        EditRosPropertyOperation editLidarParamOp = new EditRosPropertyOperation(
                "lidar", "parameter", "frame_id", "front_lidar_link", "String");
        executeOperation(opRegistry, modelState, editLidarParamOp);

        // 8. Execute EditRosPropertyOperation on safety_monitor to override stop_distance = 0.75
        EditRosPropertyOperation editSafetyParamOp = new EditRosPropertyOperation(
                "safety_monitor", "parameter", "stop_distance", "0.75", "Double");
        executeOperation(opRegistry, modelState, editSafetyParamOp);

        // 9. Validate in-memory model with RosModelValidator
        gModelFactory.createGModel();
        List<Marker> markers = validator.validate(List.of(modelState.getRoot()), "live");
        List<Marker> errorMarkers = markers.stream()
                .filter(m -> MarkerKind.ERROR.equals(m.getType()))
                .toList();
        assertTrue(
                errorMarkers.isEmpty(),
                "Expected zero ERROR markers after valid mutations, but got: "
                        + errorMarkers.stream().map(Marker::getDescription).toList());

        // 10. Save model to disk and verify exact syntax and comment preservation
        storage.saveSourceModel(new SaveModelAction());
        String savedText = Files.readString(rossystemFile);

        assertTrue(
                savedText.contains("# Main Navigation System - DO NOT REMOVE HEADER COMMENT"),
                "Header comment must be preserved");
        assertTrue(
                savedText.contains("# Primary Lidar sensor driver"),
                "Node comment must be preserved");
        assertTrue(
                savedText.contains("value: \"front_lidar_link\" # keep this inline calibration comment!"),
                "Updated value must preserve trailing inline comment on the exact same line! Actual:\n" + savedText);
        assertTrue(
                savedText.contains("# primary lidar to planner wire"),
                "Connection inline comment must be preserved");
        assertTrue(
                savedText.contains("safety_monitor:"),
                "Newly added safety_monitor node must be serialized");
        assertTrue(
                savedText.contains("namespace: \"safety\""),
                "Newly added safety_monitor namespace must be serialized");
        assertTrue(
                savedText.contains("value: 0.75"),
                "Newly added Double parameter override must be serialized");
        assertTrue(
                savedText.contains("- [ scan , scan_emergency ]"),
                "Newly added connection must be serialized");

        // 11. Test DeleteOperation removing safety_monitor and cleaning up its connection
        DeleteOperation deleteOp = new DeleteOperation(List.of("safety_monitor"));
        executeOperation(opRegistry, modelState, deleteOp);
        storage.saveSourceModel(new SaveModelAction());

        String textAfterDelete = Files.readString(rossystemFile);
        assertFalse(textAfterDelete.contains("safety_monitor:"), "Deleted node should be removed from file");
        assertFalse(
                textAfterDelete.contains("- [ scan , scan_emergency ]"),
                "Dangling connection to deleted node should be removed from file");
        assertTrue(
                textAfterDelete.contains("value: \"front_lidar_link\" # keep this inline calibration comment!"),
                "Inline comment on remaining node must still be intact after deletion");
    }
}
