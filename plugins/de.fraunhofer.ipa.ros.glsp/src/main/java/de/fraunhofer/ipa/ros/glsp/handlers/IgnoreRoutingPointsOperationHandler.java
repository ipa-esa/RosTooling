package de.fraunhofer.ipa.ros.glsp.handlers;

import java.util.Optional;
import org.eclipse.emf.common.command.Command;
import org.eclipse.glsp.server.emf.EMFOperationHandler;
import org.eclipse.glsp.server.operations.ChangeRoutingPointsOperation;

/**
 * Wire routing is owned by the server-side ELK layout (RosLayoutEngine), so manual routing-point
 * edits from the diagram are accepted but intentionally not persisted; the next model update
 * re-applies the ELK orthogonal route.
 */
public class IgnoreRoutingPointsOperationHandler extends EMFOperationHandler<ChangeRoutingPointsOperation> {

    @Override
    public Optional<Command> createCommand(final ChangeRoutingPointsOperation operation) {
        return doNothing();
    }
}
