package de.fraunhofer.ipa.ros.glsp.handlers;

import com.google.inject.Inject;
import de.fraunhofer.ipa.ros.glsp.model.RosModelState;
import de.fraunhofer.ipa.ros.glsp.operations.ToggleSubSystemOperation;
import java.util.Optional;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.edit.command.ChangeCommand;
import org.eclipse.glsp.server.emf.EMFOperationHandler;

/**
 * Handles ToggleSubSystemOperation to expand or collapse a SubSystem container.
 */
public class ToggleSubSystemOperationHandler extends EMFOperationHandler<ToggleSubSystemOperation> {

    @Inject
    protected RosModelState rosModelState;

    @Override
    public Optional<Command> createCommand(final ToggleSubSystemOperation operation) {
        if (operation.getElementId() == null || operation.getElementId().isBlank()) {
            return doNothing();
        }
        return Optional.of(new ChangeCommand(rosModelState.getSemanticResource()) {
            @Override
            protected void doExecute() {
                if (operation.getCollapsed() != null) {
                    rosModelState.setSubSystemCollapsed(operation.getElementId(), operation.getCollapsed());
                } else {
                    rosModelState.toggleSubSystemCollapsed(operation.getElementId());
                }
            }
        });
    }
}
