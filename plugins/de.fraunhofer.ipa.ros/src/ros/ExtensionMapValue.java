/**
 */
package ros;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Extension Map Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link ros.ExtensionMapValue#getEntries <em>Entries</em>}</li>
 * </ul>
 *
 * @see ros.RosPackage#getExtensionMapValue()
 * @model
 * @generated
 */
public interface ExtensionMapValue extends ExtensionValue {
	/**
	 * Returns the value of the '<em><b>Entries</b></em>' containment reference list.
	 * The list contents are of type {@link ros.ExtensionEntry}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Entries</em>' containment reference list.
	 * @see ros.RosPackage#getExtensionMapValue_Entries()
	 * @model containment="true"
	 * @generated
	 */
	EList<ExtensionEntry> getEntries();

} // ExtensionMapValue
