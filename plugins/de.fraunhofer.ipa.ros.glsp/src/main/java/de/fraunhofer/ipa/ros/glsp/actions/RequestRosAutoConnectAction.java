package de.fraunhofer.ipa.ros.glsp.actions;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.glsp.server.actions.RequestAction;

/**
 * Dry run of auto-connect: asks the server which connections the session's current model could
 * get (see {@code RosAutoConnector}). Nothing is modified; apply chosen candidate ids with
 * {@code applyRosAutoConnect}.
 */
public class RequestRosAutoConnectAction extends RequestAction<SetRosAutoConnectAction> {

    public static final String KIND = "requestRosAutoConnect";

    /** Optional focus: only candidates touching one of these nodes ("node" or "sub::node"). */
    private List<String> nodes = new ArrayList<>();

    public RequestRosAutoConnectAction() {
        super(KIND);
    }

    /** Optional: candidate ids to judge (accepted/rejected) without applying them. */
    private List<String> selected;

    public List<String> getSelected() {
        return selected;
    }

    public void setSelected(final List<String> selected) {
        this.selected = selected;
    }

    public List<String> getNodes() {
        return nodes;
    }

    public void setNodes(final List<String> nodes) {
        this.nodes = nodes;
    }
}
