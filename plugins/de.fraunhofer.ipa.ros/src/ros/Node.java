/**
 */
package ros;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link ros.Node#isIsLifecycle <em>Is Lifecycle</em>}</li>
 *   <li>{@link ros.Node#getPluginSlots <em>Plugin Slots</em>}</li>
 * </ul>
 *
 * @see ros.RosPackage#getNode()
 * @model
 * @generated
 */
public interface Node extends InterfaceHolder {
	/**
	 * Returns the value of the '<em><b>Is Lifecycle</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Lifecycle</em>' attribute.
	 * @see #setIsLifecycle(boolean)
	 * @see ros.RosPackage#getNode_IsLifecycle()
	 * @model default="false"
	 * @generated
	 */
	boolean isIsLifecycle();

	/**
	 * Sets the value of the '{@link ros.Node#isIsLifecycle <em>Is Lifecycle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Lifecycle</em>' attribute.
	 * @see #isIsLifecycle()
	 * @generated
	 */
	void setIsLifecycle(boolean value);

	/**
	 * Returns the value of the '<em><b>Plugin Slots</b></em>' containment reference list.
	 * The list contents are of type {@link ros.PluginSlot}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Plugin Slots</em>' containment reference list.
	 * @see ros.RosPackage#getNode_PluginSlots()
	 * @model containment="true"
	 * @generated
	 */
	EList<PluginSlot> getPluginSlots();

} // Node
