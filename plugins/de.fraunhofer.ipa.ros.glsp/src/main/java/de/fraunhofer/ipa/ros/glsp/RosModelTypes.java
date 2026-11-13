package de.fraunhofer.ipa.ros.glsp;

import org.eclipse.glsp.graph.DefaultTypes;

/**
 * Element type identifiers for RosTooling GLSP diagrams (.rossystem, .ros2, .ros1, .ros).
 */
public final class RosModelTypes {

    private RosModelTypes() {}

    public static final String DIAGRAM_TYPE = "ros-system-diagram";

    public static final String GRAPH = DefaultTypes.GRAPH;
    public static final String ROS_NODE = "node:ros-node";
    public static final String SUBSYSTEM_NODE = "node:subsystem";
    public static final String PROCESS_NODE = "node:process";
    public static final String PACKAGE_NODE = "node:ros-package";

    public static final String PORT_PUB = "port:pub";
    public static final String PORT_SUB = "port:sub";
    public static final String PORT_SS = "port:ss";
    public static final String PORT_SC = "port:sc";
    public static final String PORT_AS = "port:as";
    public static final String PORT_AC = "port:ac";

    public static final String EDGE_CONNECTION = "edge:ros-connection";

    public static final String COMPARTMENT_HEADER = "comp:header";
    public static final String COMPARTMENT_PORTS = "comp:ports";
    public static final String COMPARTMENT_PARAMS = "comp:params";

    public static final String LABEL_NAME = "label:name";
    public static final String LABEL_SUBTITLE = "label:subtitle";
    public static final String LABEL_TYPE = "label:type";
    public static final String LABEL_BADGE = "label:badge";

    public static boolean isSourcePort(final String portType) {
        return PORT_PUB.equals(portType) || PORT_SS.equals(portType) || PORT_AS.equals(portType);
    }

    public static boolean isTargetPort(final String portType) {
        return PORT_SUB.equals(portType) || PORT_SC.equals(portType) || PORT_AC.equals(portType);
    }

    public static String getComplementPortType(final String portType) {
        if (PORT_PUB.equals(portType)) return PORT_SUB;
        if (PORT_SUB.equals(portType)) return PORT_PUB;
        if (PORT_SS.equals(portType)) return PORT_SC;
        if (PORT_SC.equals(portType)) return PORT_SS;
        if (PORT_AS.equals(portType)) return PORT_AC;
        if (PORT_AC.equals(portType)) return PORT_AS;
        return null;
    }
}
