package de.fraunhofer.ipa.ros.glsp.actions;

import org.eclipse.glsp.server.actions.RequestAction;

/**
 * Asks the server to turn all pending (unsaved) AST mutations of this session into surgical text
 * edits. The server commits them to its in-memory resource but does NOT write the file: the
 * VS Code extension applies the returned edits to the open document as an undoable WorkspaceEdit.
 */
public class RequestRosTextEditsAction extends RequestAction<SetRosTextEditsAction> {

    public static final String KIND = "requestRosTextEdits";

    public RequestRosTextEditsAction() {
        super(KIND);
    }
}
