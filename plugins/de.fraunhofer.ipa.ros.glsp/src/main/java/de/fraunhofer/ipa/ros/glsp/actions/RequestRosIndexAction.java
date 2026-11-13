package de.fraunhofer.ipa.ros.glsp.actions;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.glsp.server.actions.RequestAction;

/**
 * Asks the server to parse a set of RosTooling model files (.ros, .ros2, .ros1, .rossystem) with
 * the Xtext grammars and return a compact JSON description of their packages, nodes, interfaces,
 * parameters, specs and systems. Used by the VS Code catalogue, wrapper generation and the MCP
 * server so that no TypeScript code ever parses the DSL.
 */
public class RequestRosIndexAction extends RequestAction<SetRosIndexAction> {

    public static final String KIND = "requestRosIndex";

    private List<String> files = new ArrayList<>();

    public RequestRosIndexAction() {
        super(KIND);
    }

    public RequestRosIndexAction(final List<String> files) {
        super(KIND);
        this.files = files;
    }

    public List<String> getFiles() {
        return files;
    }

    public void setFiles(final List<String> files) {
        this.files = files;
    }
}
