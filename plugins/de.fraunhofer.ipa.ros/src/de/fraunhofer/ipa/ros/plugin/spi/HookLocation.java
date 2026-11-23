package de.fraunhofer.ipa.ros.plugin.spi;

import org.eclipse.emf.ecore.EObject;
import ros.Node;
import ros.Plugin;

/**
 * Metamodel hook locations where {@code @name:} extension blocks may appear.
 */
public enum HookLocation {
    SYSTEM("System"),
    ROS_NODE("RosNode"),
    NODE("Node"),
    PLUGIN("Plugin"),
    ROS_INTERFACE("RosInterface");

    private final String label;

    HookLocation(final String label) {
        this.label = label;
    }

    public String label() {
        return label;
    }

    /**
     * Resolves the hook location of a semantic container {@link EObject}, or {@code null} if the
     * object is not one of the supported hook locations.
     */
    public static HookLocation fromElement(final EObject element) {
        if (element == null) {
            return null;
        }
        if (element instanceof Node) {
            return NODE;
        }
        if (element instanceof Plugin) {
            return PLUGIN;
        }
        String className = element.eClass().getName();
        if ("System".equals(className) || "Rossystem".equals(className)) {
            return SYSTEM;
        }
        if ("RosNode".equals(className)) {
            return ROS_NODE;
        }
        if ("RosInterface".equals(className)) {
            return ROS_INTERFACE;
        }
        return null;
    }
}
