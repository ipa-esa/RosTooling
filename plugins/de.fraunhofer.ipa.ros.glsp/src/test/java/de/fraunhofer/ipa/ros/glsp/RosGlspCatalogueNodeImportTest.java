package de.fraunhofer.ipa.ros.glsp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.google.inject.Guice;
import com.google.inject.Injector;
import de.fraunhofer.ipa.ros.glsp.model.RosModelState;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.eclipse.glsp.server.di.ServerModule;
import org.eclipse.glsp.server.features.core.model.GModelFactory;
import org.eclipse.glsp.server.features.core.model.RequestModelAction;
import org.eclipse.glsp.server.features.core.model.SourceModelStorage;
import org.eclipse.glsp.server.operations.CreateNodeOperation;
import org.eclipse.glsp.server.operations.OperationHandlerRegistry;
import org.eclipse.glsp.server.protocol.InitializeClientSessionParameters;
import org.eclipse.glsp.server.session.ClientSession;
import org.eclipse.glsp.server.session.ClientSessionManager;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

/** Creating a system node whose {@code from} names a node that only exists in the model catalogue. */
class RosGlspCatalogueNodeImportTest {

    @TempDir
    Path tempDir;

    @Test
    void createNodeResolvesFromAgainstCatalogue() throws Exception {
        Path catalogue = tempDir.resolve("catalogue/RosModelsCatalog/navigation");
        Files.createDirectories(catalogue);
        Files.writeString(catalogue.resolve("amcl.ros2"), String.join("\n",
                "amcl:",
                "  artifacts:",
                "    amcl:",
                "      node: amcl",
                ""));

        Path ws = tempDir.resolve("ws");
        Files.createDirectories(ws);
        Path system = ws.resolve("demo.rossystem");
        Files.writeString(system, String.join("\n", "demo:", "  nodes:", ""));

        String previous = System.getProperty("rostooling.catalogue.path");
        System.setProperty("rostooling.catalogue.path", tempDir.resolve("catalogue").toString());
        try {
            Injector server = Guice.createInjector(new ServerModule().configureDiagramModule(new RosGlspModule()));
            ClientSession session = server.getInstance(ClientSessionManager.class).getOrCreateClientSession(
                    new InitializeClientSessionParameters("cat_node", RosModelTypes.DIAGRAM_TYPE,
                            Collections.emptyList()));
            Injector inj = session.getInjector();
            inj.getInstance(SourceModelStorage.class)
                    .loadSourceModel(new RequestModelAction(Map.of("sourceUri", system.toUri().toString())));
            inj.getInstance(GModelFactory.class).createGModel();
            RosModelState state = inj.getInstance(RosModelState.class);

            Map<String, String> args = new HashMap<>();
            args.put("nodeName", "amcl");
            args.put("from", "amcl.amcl");
            CreateNodeOperation op = new CreateNodeOperation(RosModelTypes.ROS_NODE, null, null, args);
            org.eclipse.glsp.server.operations.OperationHandler handler =
                    inj.getInstance(OperationHandlerRegistry.class).getOperationHandler(op).orElseThrow();
            java.util.Optional<org.eclipse.emf.common.command.Command> cmd = handler.createCommand(op);
            state.execute(cmd.orElseThrow());

            var components = state.getRosSystem().orElseThrow().getComponents();
            assertEquals(1, components.size(), "catalogue node must be created");
            var node = (system.RosNode) components.get(0);
            assertEquals("amcl", node.getFrom().getName());
            assertTrue(!node.getFrom().eIsProxy());
        } finally {
            if (previous == null) {
                System.clearProperty("rostooling.catalogue.path");
            } else {
                System.setProperty("rostooling.catalogue.path", previous);
            }
        }
    }
}
