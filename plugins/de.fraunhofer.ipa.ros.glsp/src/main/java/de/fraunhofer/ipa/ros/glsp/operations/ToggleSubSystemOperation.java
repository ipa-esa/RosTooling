package de.fraunhofer.ipa.ros.glsp.operations;

import org.eclipse.glsp.server.operations.Operation;

/**
 * Custom GLSP Operation to expand or collapse a SubSystem container node.
 */
public class ToggleSubSystemOperation extends Operation {

    public static final String KIND = "toggleSubSystem";

    private String elementId;
    private Boolean collapsed;

    public ToggleSubSystemOperation() {
        super(KIND);
    }

    public ToggleSubSystemOperation(final String elementId, final Boolean collapsed) {
        super(KIND);
        this.elementId = elementId;
        this.collapsed = collapsed;
    }

    public String getElementId() {
        return elementId;
    }

    public void setElementId(final String elementId) {
        this.elementId = elementId;
    }

    public Boolean getCollapsed() {
        return collapsed;
    }

    public void setCollapsed(final Boolean collapsed) {
        this.collapsed = collapsed;
    }
}
