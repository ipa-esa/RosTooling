package de.fraunhofer.ipa.ros.glsp.handlers;

import com.google.inject.Inject;
import de.fraunhofer.ipa.ros.glsp.model.RosModelState;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.edit.command.ChangeCommand;
import org.eclipse.glsp.graph.GGraph;
import org.eclipse.glsp.graph.GModelElement;
import org.eclipse.glsp.graph.GNode;
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

    private static final double MIN_MOVE_DELTA = 0.5;

    @Inject
    protected RosModelState rosModelState;

    @Override
    public Optional<Command> createCommand(final ChangeBoundsOperation operation) {
        if (operation.getNewBounds() == null || operation.getNewBounds().isEmpty()) {
            return doNothing();
        }
        List<ElementAndBounds> effective = new ArrayList<>();
        GGraph root = rosModelState.getRoot() instanceof GGraph g ? g : null;
        for (ElementAndBounds eb : operation.getNewBounds()) {
            GPoint pos = eb.getNewPosition();
            if (eb.getElementId() == null || pos == null) {
                continue;
            }
            GPoint ref = rosModelState.getPinnedPositions().containsKey(eb.getElementId())
                    ? rosModelState.getPinnedPositions().get(eb.getElementId())
                    : findNodePosition(root, eb.getElementId());
            if (ref != null
                    && Math.abs(ref.getX() - pos.getX()) < MIN_MOVE_DELTA
                    && Math.abs(ref.getY() - pos.getY()) < MIN_MOVE_DELTA) {
                continue;
            }
            effective.add(eb);
        }
        if (effective.isEmpty()) {
            return doNothing();
        }
        return Optional.of(new ChangeCommand(rosModelState.getSemanticResource()) {
            @Override
            protected void doExecute() {
                for (ElementAndBounds eb : effective) {
                    GPoint pos = eb.getNewPosition();
                    rosModelState.setPinnedPosition(
                            eb.getElementId(),
                            GraphUtil.point(pos.getX(), pos.getY()));
                }
            }
        });
    }

    private static GPoint findNodePosition(final GModelElement container, final String elementId) {
        if (container == null) {
            return null;
        }
        for (GModelElement child : container.getChildren()) {
            if (child instanceof GNode node) {
                if (elementId.equals(node.getId())) {
                    return node.getPosition();
                }
                GPoint nested = findNodePosition(node, elementId);
                if (nested != null) {
                    return nested;
                }
            }
        }
        return null;
    }
}
