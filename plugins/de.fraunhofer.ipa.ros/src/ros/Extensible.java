/**
 */
package ros;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Extensible</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link ros.Extensible#getExtensions <em>Extensions</em>}</li>
 * </ul>
 *
 * @see ros.RosPackage#getExtensible()
 * @model abstract="true"
 * @generated
 */
public interface Extensible extends EObject {
	/**
	 * Returns the value of the '<em><b>Extensions</b></em>' containment reference list.
	 * The list contents are of type {@link ros.ExtensionBlock}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extensions</em>' containment reference list.
	 * @see ros.RosPackage#getExtensible_Extensions()
	 * @model containment="true"
	 * @generated
	 */
	EList<ExtensionBlock> getExtensions();

} // Extensible
