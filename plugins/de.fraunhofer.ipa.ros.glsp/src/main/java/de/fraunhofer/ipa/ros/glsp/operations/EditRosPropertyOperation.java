package de.fraunhofer.ipa.ros.glsp.operations;

import org.eclipse.glsp.server.operations.Operation;

/**
 * Custom GLSP Operation to edit properties of RosTooling Ecore elements
 * (RosNode name/namespace, parameter override values, interface remappings,
 * or .ros2/.ros package/node/interface/spec properties).
 */
public class EditRosPropertyOperation extends Operation {

    public static final String KIND = "editRosProperty";

    private String elementId;
    private String property;
    private String key;
    private String value;
    private String valueType;

    public EditRosPropertyOperation() {
        super(KIND);
    }

    public EditRosPropertyOperation(
            final String elementId,
            final String property,
            final String value) {
        this(elementId, property, null, value, null);
    }

    public EditRosPropertyOperation(
            final String elementId,
            final String property,
            final String key,
            final String value,
            final String valueType) {
        super(KIND);
        this.elementId = elementId;
        this.property = property;
        this.key = key;
        this.value = value;
        this.valueType = valueType;
    }

    public String getElementId() {
        return elementId;
    }

    public void setElementId(final String elementId) {
        this.elementId = elementId;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(final String property) {
        this.property = property;
    }

    public String getKey() {
        return key;
    }

    public void setKey(final String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(final String value) {
        this.value = value;
    }

    public String getValueType() {
        return valueType;
    }

    public void setValueType(final String valueType) {
        this.valueType = valueType;
    }
}
