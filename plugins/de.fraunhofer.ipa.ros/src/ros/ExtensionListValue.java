/**
 */
package ros;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Extension List Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link ros.ExtensionListValue#getItems <em>Items</em>}</li>
 * </ul>
 *
 * @see ros.RosPackage#getExtensionListValue()
 * @model
 * @generated
 */
public interface ExtensionListValue extends ExtensionValue {
	/**
	 * Returns the value of the '<em><b>Items</b></em>' containment reference list.
	 * The list contents are of type {@link ros.ExtensionValue}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Items</em>' containment reference list.
	 * @see ros.RosPackage#getExtensionListValue_Items()
	 * @model containment="true"
	 * @generated
	 */
	EList<ExtensionValue> getItems();

} // ExtensionListValue
