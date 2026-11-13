package de.fraunhofer.ipa.ros.glsp.handlers;

import com.google.inject.Inject;
import de.fraunhofer.ipa.ros.glsp.RosModelTypes;
import de.fraunhofer.ipa.ros.glsp.model.RosModelState;
import java.util.Optional;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.edit.command.ChangeCommand;
import org.eclipse.glsp.server.emf.EMFCreateOperationHandler;
import org.eclipse.glsp.server.operations.CreateEdgeOperation;
import system.RosInterface;
import system.RosSystemConnection;
import system.RossystemFactory;

/**
 * Handles CreateEdgeOperation to validate port compatibility and create a system.RosSystemConnection.
 * Automatically promotes inherited ports on a RosNode to explicit RosInterfaces if needed.
 */
public class CreateConnectionOperationHandler extends EMFCreateOperationHandler<CreateEdgeOperation> {

    @Inject
    protected RosModelState rosModelState;

    public CreateConnectionOperationHandler() {
        super(RosModelTypes.EDGE_CONNECTION);
    }

    @Override
    public Optional<Command> createCommand(final CreateEdgeOperation operation) {
        Optional<system.System> sysOpt = rosModelState.getRosSystem();
        if (sysOpt.isEmpty()) {
            return doNothing();
        }
        system.System sys = sysOpt.get();
        String sourceId = operation.getSourceElementId();
        String targetId = operation.getTargetElementId();
        if (sourceId == null || targetId == null || sourceId.equals(targetId)) {
            return doNothing();
        }

        return Optional.of(new ChangeCommand(rosModelState.getSemanticResource()) {
            @Override
            protected void doExecute() {
                Optional<RosInterface> firstOpt = RosElementResolver.resolveOrCreateRosInterface(
                        rosModelState, sys, sourceId);
                Optional<RosInterface> secondOpt = RosElementResolver.resolveOrCreateRosInterface(
                        rosModelState, sys, targetId);
                if (firstOpt.isEmpty() || secondOpt.isEmpty()) {
                    return;
                }
                RosInterface first = firstOpt.get();
                RosInterface second = secondOpt.get();
                if (!RosElementResolver.areCompatibleInterfaces(first, second)) {
                    return;
                }
                RosInterface[] ordered = RosElementResolver.normalizeDirection(first, second);
                RosSystemConnection conn = RossystemFactory.eINSTANCE.createRosSystemConnection();
                conn.setFrom(ordered[0]);
                conn.setTo(ordered[1]);
                sys.getConnections().add(conn);
            }
        });
    }

    @Override
    public String getLabel() {
        return "Connect ROS Interfaces";
    }
}
