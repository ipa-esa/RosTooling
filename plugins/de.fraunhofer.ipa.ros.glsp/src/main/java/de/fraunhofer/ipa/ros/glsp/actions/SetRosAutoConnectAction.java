package de.fraunhofer.ipa.ros.glsp.actions;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.glsp.server.actions.ResponseAction;

/**
 * Response to {@link RequestRosAutoConnectAction}. The receiver port (subscriber, service client,
 * action client) is the only decision point: each receiver lists its ranked candidate emitters,
 * at most one of them preselected. Emitters are never a choice; {@link #getEmitterSummary()} is
 * their read-only fan-out. When the request carried a selection, {@link #getSelection()} says
 * which ids applyRosAutoConnect would add and which it would reject (and why).
 */
public class SetRosAutoConnectAction extends ResponseAction {

    public static final String KIND = "setRosAutoConnect";

    public static class Candidate {
        /** Stable id "emitterRef->receiverRef"; pass it to applyRosAutoConnect. */
        public String id;
        /** "node::iface" or "sub::[...::]node::iface". */
        public String emitterRef;
        public String emitterNode;
        /** pub, ss or as. */
        public String emitterKind;
        /** Diagram port id, or null when not drawn (collapsed or nested subsystem). */
        public String emitterPortId;
        /** A drawn element to highlight: the port, else its node or subsystem card. */
        public String emitterElementId;
        /** remap, directed-remap, contract, fuzzy, type-unique, type-ambiguous. */
        public String tier;
        public int score;
        public String evidence;
        /** At most one per receiver: a unique remap/directed-remap/contract match. */
        public boolean preselected;
    }

    public static class Receiver {
        /** Stable receiver id (= ref). */
        public String receiverId;
        public String ref;
        /** "node" or "sub::[...::]node". */
        public String node;
        public String iface;
        /** sub, sc or ac. */
        public String kind;
        public String type;
        public String portId;
        public String elementId;
        /** Top-level subsystem name (null for the system's own nodes). */
        public String subsystem;
        /** True only for topic subscribers: further publishers may be added explicitly. */
        public boolean multiAllowed;
        /** Best first. */
        public List<Candidate> candidates = new ArrayList<>();
    }

    /** Read-only fan-out of one emitter. */
    public static class EmitterSummary {
        public String emitterRef;
        public String node;
        public String kind;
        public String type;
        public String portId;
        public String elementId;
        public int existingConnections;
        public int candidateReceivers;
        public int preselectedReceivers;
    }

    public static class ConnectedReceiver {
        public String receiverId;
        public String kind;
        /** Emitter refs already connected to it. */
        public List<String> from = new ArrayList<>();
    }

    public static class Rejection {
        public String id;
        public String reason;

        public Rejection() {}

        public Rejection(final String id, final String reason) {
            this.id = id;
            this.reason = reason;
        }
    }

    /** Verdict on a proposed selection (only when the request carried {@code selected}). */
    public static class Selection {
        public List<String> accepted = new ArrayList<>();
        public List<Rejection> rejected = new ArrayList<>();
    }

    private List<Receiver> receivers = new ArrayList<>();
    private List<EmitterSummary> emitterSummary = new ArrayList<>();
    private List<ConnectedReceiver> alreadyConnected = new ArrayList<>();
    private List<String> skipped = new ArrayList<>();
    private Selection selection;

    public SetRosAutoConnectAction() {
        super(KIND);
    }

    public List<Receiver> getReceivers() {
        return receivers;
    }

    public void setReceivers(final List<Receiver> receivers) {
        this.receivers = receivers;
    }

    public List<EmitterSummary> getEmitterSummary() {
        return emitterSummary;
    }

    public void setEmitterSummary(final List<EmitterSummary> emitterSummary) {
        this.emitterSummary = emitterSummary;
    }

    public List<ConnectedReceiver> getAlreadyConnected() {
        return alreadyConnected;
    }

    public void setAlreadyConnected(final List<ConnectedReceiver> alreadyConnected) {
        this.alreadyConnected = alreadyConnected;
    }

    public List<String> getSkipped() {
        return skipped;
    }

    public void setSkipped(final List<String> skipped) {
        this.skipped = skipped;
    }

    public Selection getSelection() {
        return selection;
    }

    public void setSelection(final Selection selection) {
        this.selection = selection;
    }
}
