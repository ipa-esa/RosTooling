package de.fraunhofer.ipa.ros.glsp.model;

import com.google.inject.Singleton;
import java.util.List;
import org.eclipse.glsp.graph.GModelElement;
import org.eclipse.glsp.server.actions.Action;
import org.eclipse.glsp.server.features.core.model.ModelSubmissionHandler;
import org.eclipse.glsp.server.features.validation.MarkersReason;
import org.eclipse.glsp.server.features.validation.ModelValidator;
import org.eclipse.glsp.server.features.validation.SetMarkersAction;

/**
 * Runs live validation synchronously, on the action dispatcher thread, as part of each model
 * submission. GLSP's default debounces it onto a timer thread, which then reads the EMF/Xtext
 * model concurrently with operations, reloads (all resources unloaded, so every reference looks
 * unresolved) and text commits - producing spurious markers and racing with model mutations.
 */
@Singleton
public class RosModelSubmissionHandler extends ModelSubmissionHandler {

    @Override
    protected List<Action> validateModel(final ModelValidator validator) {
        Object root = modelState.getRoot();
        if (!(root instanceof GModelElement element)) {
            return List.of();
        }
        return List.of(new SetMarkersAction(validator.validate(List.of(element), MarkersReason.LIVE), MarkersReason.LIVE));
    }
}
