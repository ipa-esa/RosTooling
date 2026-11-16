package de.fraunhofer.ipa.ros.glsp.operations;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.glsp.server.operations.Operation;

/**
 * Adds the selected auto-connect candidates (ids from {@code setRosAutoConnect}) in one undoable
 * command. The server recomputes the candidates: unknown or stale ids are ignored, a service or
 * action client gets at most one server (the best ranked selected one), a topic subscriber gets
 * every selected publisher.
 */
public class ApplyRosAutoConnectOperation extends Operation {

    public static final String KIND = "applyRosAutoConnect";

    private List<String> selected = new ArrayList<>();

    public ApplyRosAutoConnectOperation() {
        super(KIND);
    }

    public ApplyRosAutoConnectOperation(final List<String> selected) {
        super(KIND);
        this.selected = selected;
    }

    public List<String> getSelected() {
        return selected;
    }

    public void setSelected(final List<String> selected) {
        this.selected = selected;
    }
}
