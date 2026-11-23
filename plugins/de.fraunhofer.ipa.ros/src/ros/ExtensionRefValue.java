/**
 */
package ros;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Extension Ref Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link ros.ExtensionRefValue#getRefKind <em>Ref Kind</em>}</li>
 *   <li>{@link ros.ExtensionRefValue#getTarget <em>Target</em>}</li>
 *   <li>{@link ros.ExtensionRefValue#getRawTarget <em>Raw Target</em>}</li>
 * </ul>
 *
 * @see ros.RosPackage#getExtensionRefValue()
 * @model
 * @generated
 */
public interface ExtensionRefValue extends ExtensionValue {
	/**
	 * Returns the value of the '<em><b>Ref Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ref Kind</em>' attribute.
	 * @see #setRefKind(String)
	 * @see ros.RosPackage#getExtensionRefValue_RefKind()
	 * @model
	 * @generated
	 */
	String getRefKind();

	/**
	 * Sets the value of the '{@link ros.ExtensionRefValue#getRefKind <em>Ref Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ref Kind</em>' attribute.
	 * @see #getRefKind()
	 * @generated
	 */
	void setRefKind(String value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(EObject)
	 * @see ros.RosPackage#getExtensionRefValue_Target()
	 * @model
	 * @generated
	 */
	EObject getTarget();

	/**
	 * Sets the value of the '{@link ros.ExtensionRefValue#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(EObject value);

	/**
	 * Returns the value of the '<em><b>Raw Target</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Raw Target</em>' attribute.
	 * @see #setRawTarget(String)
	 * @see ros.RosPackage#getExtensionRefValue_RawTarget()
	 * @model
	 * @generated
	 */
	String getRawTarget();

	/**
	 * Sets the value of the '{@link ros.ExtensionRefValue#getRawTarget <em>Raw Target</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Raw Target</em>' attribute.
	 * @see #getRawTarget()
	 * @generated
	 */
	void setRawTarget(String value);

} // ExtensionRefValue
