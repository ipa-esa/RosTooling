/**
 */
package primitives;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sized Array</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link primitives.SizedArray#getElement <em>Element</em>}</li>
 *   <li>{@link primitives.SizedArray#getSize <em>Size</em>}</li>
 *   <li>{@link primitives.SizedArray#isBounded <em>Bounded</em>}</li>
 * </ul>
 *
 * @see primitives.PrimitivesPackage#getSizedArray()
 * @model
 * @generated
 */
public interface SizedArray extends AbstractType {
	/**
	 * Returns the value of the '<em><b>Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element</em>' containment reference.
	 * @see #setElement(AbstractType)
	 * @see primitives.PrimitivesPackage#getSizedArray_Element()
	 * @model containment="true" required="true"
	 * @generated
	 */
	AbstractType getElement();

	/**
	 * Sets the value of the '{@link primitives.SizedArray#getElement <em>Element</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Element</em>' containment reference.
	 * @see #getElement()
	 * @generated
	 */
	void setElement(AbstractType value);

	/**
	 * Returns the value of the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Size</em>' attribute.
	 * @see #setSize(int)
	 * @see primitives.PrimitivesPackage#getSizedArray_Size()
	 * @model required="true"
	 * @generated
	 */
	int getSize();

	/**
	 * Sets the value of the '{@link primitives.SizedArray#getSize <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Size</em>' attribute.
	 * @see #getSize()
	 * @generated
	 */
	void setSize(int value);

	/**
	 * Returns the value of the '<em><b>Bounded</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bounded</em>' attribute.
	 * @see #setBounded(boolean)
	 * @see primitives.PrimitivesPackage#getSizedArray_Bounded()
	 * @model
	 * @generated
	 */
	boolean isBounded();

	/**
	 * Sets the value of the '{@link primitives.SizedArray#isBounded <em>Bounded</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bounded</em>' attribute.
	 * @see #isBounded()
	 * @generated
	 */
	void setBounded(boolean value);

} // SizedArray
