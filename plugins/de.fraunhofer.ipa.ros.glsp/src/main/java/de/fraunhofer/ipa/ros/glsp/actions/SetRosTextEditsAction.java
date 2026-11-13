package de.fraunhofer.ipa.ros.glsp.actions;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.glsp.server.actions.ResponseAction;

/** Response to {@link RequestRosTextEditsAction}. Offsets refer to {@code baseText}. */
public class SetRosTextEditsAction extends ResponseAction {

    public static final String KIND = "setRosTextEdits";

    /** A single replacement of {@code length} characters at {@code offset} by {@code text}. */
    public static class RosTextEdit {
        public int offset;
        public int length;
        public String text;

        public RosTextEdit() {}

        public RosTextEdit(final int offset, final int length, final String text) {
            this.offset = offset;
            this.length = length;
            this.text = text;
        }
    }

    private String sourceUri;
    private String baseText;
    private String newText;
    private List<RosTextEdit> edits = new ArrayList<>();

    public SetRosTextEditsAction() {
        super(KIND);
    }

    public SetRosTextEditsAction(final String sourceUri, final String baseText, final String newText, final List<RosTextEdit> edits) {
        super(KIND);
        this.sourceUri = sourceUri;
        this.baseText = baseText;
        this.newText = newText;
        this.edits = edits;
    }

    public String getSourceUri() { return sourceUri; }
    public void setSourceUri(final String sourceUri) { this.sourceUri = sourceUri; }
    public String getBaseText() { return baseText; }
    public void setBaseText(final String baseText) { this.baseText = baseText; }
    public String getNewText() { return newText; }
    public void setNewText(final String newText) { this.newText = newText; }
    public List<RosTextEdit> getEdits() { return edits; }
    public void setEdits(final List<RosTextEdit> edits) { this.edits = edits; }
}
