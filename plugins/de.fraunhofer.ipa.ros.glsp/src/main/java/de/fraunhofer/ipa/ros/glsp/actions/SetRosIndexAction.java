package de.fraunhofer.ipa.ros.glsp.actions;

import org.eclipse.glsp.server.actions.ResponseAction;

/** Response to {@link RequestRosIndexAction}: {@code indexJson} is {@code {"files": [...]}}. */
public class SetRosIndexAction extends ResponseAction {

    public static final String KIND = "setRosIndex";

    private String indexJson;

    public SetRosIndexAction() {
        super(KIND);
    }

    public SetRosIndexAction(final String indexJson) {
        super(KIND);
        this.indexJson = indexJson;
    }

    public String getIndexJson() {
        return indexJson;
    }

    public void setIndexJson(final String indexJson) {
        this.indexJson = indexJson;
    }
}
