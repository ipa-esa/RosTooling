package de.fraunhofer.ipa.ros.glsp.handlers;

import com.google.inject.Inject;
import de.fraunhofer.ipa.ros.glsp.model.RosModelState;
import java.util.Optional;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.ChangeCommand;
import org.eclipse.glsp.server.emf.EMFOperationHandler;
import org.eclipse.glsp.server.operations.ReconnectEdgeOperation;
import system.RosInterface;
import system.RosSystemConnection;

/**
 * Handles ReconnectEdgeOperation to re-wire an existing RosSystemConnection to new ports.
 */
public class ReconnectConnectionOperationHandler extends EMFOperationHandler<ReconnectEdgeOperation> {

    @Inject
    protected RosModelState rosModelState;

    @Override
    public Optional<Command> createCommand(final ReconnectEdgeOperation operation) {
        Optional<system.System> sysOpt = rosModelState.getRosSystem();
        if (sysOpt.isEmpty()) {
            return doNothing();
        }
        system.System sys = sysOpt.get();

        return Optional.of(new ChangeCommand(rosModelState.getSemanticResource()) {
            @Override
            protected void doExecute() {
                Optional<EObject> edgeOpt = RosElementResolver.findByIdOrName(
                        rosModelState, operation.getEdgeElementId());
                if (edgeOpt.isEmpty() || !(edgeOpt.get() instanceof RosSystemConnection conn)) {
                    return;
                }
                Optional<RosInterface> sourceOpt = RosElementResolver.resolveOrCreateRosInterface(
                        rosModelState, sys, operation.getSourceElementId());
                Optional<RosInterface> targetOpt = RosElementResolver.resolveOrCreateRosInterface(
                        rosModelState, sys, operation.getTargetElementId());
                if (sourceOpt.isEmpty() || targetOpt.isEmpty()) {
                    return;
                }
                RosInterface first = sourceOpt.get();
                RosInterface second = targetOpt.get();
                if (!RosElementResolver.areCompatibleInterfaces(first, second)) {
                    return;
                }
                RosInterface[] ordered = RosElementResolver.normalizeDirection(first, second);
                conn.setFrom(ordered[0]);
                conn.setTo(ordered[1]);
            }
        });
    }
}
