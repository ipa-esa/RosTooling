package de.fraunhofer.ipa.ros.glsp.handlers;

import com.google.inject.Inject;
import de.fraunhofer.ipa.ros.glsp.actions.RequestRosTextEditsAction;
import de.fraunhofer.ipa.ros.glsp.actions.SetRosTextEditsAction;
import de.fraunhofer.ipa.ros.glsp.actions.SetRosTextEditsAction.RosTextEdit;
import de.fraunhofer.ipa.ros.glsp.model.RosAstNodeModelSerializer;
import de.fraunhofer.ipa.ros.glsp.model.RosAstNodeModelSerializer.SpanEdit;
import de.fraunhofer.ipa.ros.glsp.model.RosModelState;
import de.fraunhofer.ipa.ros.glsp.model.RosXtextModelStorage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.glsp.server.actions.AbstractActionHandler;
import org.eclipse.glsp.server.actions.Action;
import org.eclipse.glsp.server.actions.ResponseAction;
import org.eclipse.glsp.server.features.core.model.ModelSubmissionHandler;
import org.eclipse.glsp.server.features.core.model.SourceModelStorage;
import org.eclipse.glsp.server.types.GLSPServerException;

/**
 * Commits pending AST mutations as surgical span edits and returns them instead of writing the
 * file, then resubmits the (re-linked) model to the client.
 */
public class RequestRosTextEditsActionHandler extends AbstractActionHandler<RequestRosTextEditsAction> {

    @Inject
    protected RosModelState rosModelState;

    @Inject
    protected SourceModelStorage sourceModelStorage;

    @Inject
    protected ModelSubmissionHandler modelSubmissionHandler;

    @Override
    protected List<Action> executeAction(final RequestRosTextEditsAction action) {
        RosAstNodeModelSerializer.TextChange change;
        try {
            change = RosAstNodeModelSerializer.computeAndCommit(rosModelState);
        } catch (IOException e) {
            throw new GLSPServerException("Could not compute RosTooling text edits", e);
        }
        if (sourceModelStorage instanceof RosXtextModelStorage storage) {
            storage.saveOptionalLayoutSidecar();
        }
        List<RosTextEdit> edits = new ArrayList<>();
        for (SpanEdit e : change.edits) {
            edits.add(new RosTextEdit(e.offset, e.length, e.replacement));
        }
        String uri = rosModelState.getSourceUri() != null ? rosModelState.getSourceUri().toString() : "";
        List<Action> result = new ArrayList<>();
        result.add(ResponseAction.respond(action, new SetRosTextEditsAction(uri, change.baseText, change.newText, edits)));
        result.addAll(modelSubmissionHandler.submitModel());
        return result;
    }
}
