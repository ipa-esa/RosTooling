package de.fraunhofer.ipa.ros.glsp.handlers;

import com.google.inject.Inject;
import de.fraunhofer.ipa.ros.glsp.model.RosModelState;
import java.util.Optional;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.edit.command.ChangeCommand;
import org.eclipse.glsp.graph.GPoint;
import org.eclipse.glsp.graph.util.GraphUtil;
import org.eclipse.glsp.server.emf.EMFOperationHandler;
import org.eclipse.glsp.server.operations.ChangeBoundsOperation;
import org.eclipse.glsp.server.types.ElementAndBounds;

/**
 * Handles ChangeBoundsOperation when a user manually drags nodes to custom positions.
 * Pinned coordinates are held in RosModelState and only written to an optional .layout sidecar on save.
 */
public class ChangeBoundsOperationHandler extends EMFOperationHandler<ChangeBoundsOperation> {

    @Inject
    protected RosModelState rosModelState;

    @Override
    public Optional<Command> createCommand(final ChangeBoundsOperation operation) {
        if (operation.getNewBounds() == null || operation.getNewBounds().isEmpty()) {
            return doNothing();
        }
        return Optional.of(new ChangeCommand(rosModelState.getSemanticResource()) {
            @Override
            protected void doExecute() {
                for (ElementAndBounds eb : operation.getNewBounds()) {
                    GPoint pos = eb.getNewPosition();
                    if (eb.getElementId() != null && pos != null) {
                        rosModelState.setPinnedPosition(
                                eb.getElementId(),
                                GraphUtil.point(pos.getX(), pos.getY()));
                    }
                }
            }
        });
    }
}
