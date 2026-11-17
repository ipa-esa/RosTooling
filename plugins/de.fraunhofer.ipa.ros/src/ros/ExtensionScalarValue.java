/**
 */
package ros;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Extension Scalar Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link ros.ExtensionScalarValue#getValue <em>Value</em>}</li>
 *   <li>{@link ros.ExtensionScalarValue#getRawKind <em>Raw Kind</em>}</li>
 * </ul>
 *
 * @see ros.RosPackage#getExtensionScalarValue()
 * @model
 * @generated
 */
public interface ExtensionScalarValue extends ExtensionValue {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see ros.RosPackage#getExtensionScalarValue_Value()
	 * @model
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link ros.ExtensionScalarValue#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

	/**
	 * Returns the value of the '<em><b>Raw Kind</b></em>' attribute.
	 * The default value is <code>"string"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Raw Kind</em>' attribute.
	 * @see #setRawKind(String)
	 * @see ros.RosPackage#getExtensionScalarValue_RawKind()
	 * @model default="string"
	 * @generated
	 */
	String getRawKind();

	/**
	 * Sets the value of the '{@link ros.ExtensionScalarValue#getRawKind <em>Raw Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Raw Kind</em>' attribute.
	 * @see #getRawKind()
	 * @generated
	 */
	void setRawKind(String value);

} // ExtensionScalarValue
