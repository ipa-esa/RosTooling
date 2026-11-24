/**
 */
package primitives.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import primitives.AbstractType;
import primitives.PrimitivesPackage;
import primitives.SizedArray;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sized Array</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link primitives.impl.SizedArrayImpl#getElement <em>Element</em>}</li>
 *   <li>{@link primitives.impl.SizedArrayImpl#getSize <em>Size</em>}</li>
 *   <li>{@link primitives.impl.SizedArrayImpl#isBounded <em>Bounded</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SizedArrayImpl extends AbstractTypeImpl implements SizedArray {
	/**
	 * The cached value of the '{@link #getElement() <em>Element</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElement()
	 * @generated
	 * @ordered
	 */
	protected AbstractType element;

	/**
	 * The default value of the '{@link #getSize() <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSize()
	 * @generated
	 * @ordered
	 */
	protected static final int SIZE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getSize() <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSize()
	 * @generated
	 * @ordered
	 */
	protected int size = SIZE_EDEFAULT;

	/**
	 * The default value of the '{@link #isBounded() <em>Bounded</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isBounded()
	 * @generated
	 * @ordered
	 */
	protected static final boolean BOUNDED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isBounded() <em>Bounded</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isBounded()
	 * @generated
	 * @ordered
	 */
	protected boolean bounded = BOUNDED_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SizedArrayImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PrimitivesPackage.Literals.SIZED_ARRAY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AbstractType getElement() {
		return element;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetElement(AbstractType newElement, NotificationChain msgs) {
		AbstractType oldElement = element;
		element = newElement;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PrimitivesPackage.SIZED_ARRAY__ELEMENT, oldElement, newElement);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setElement(AbstractType newElement) {
		if (newElement != element) {
			NotificationChain msgs = null;
			if (element != null)
				msgs = ((InternalEObject)element).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PrimitivesPackage.SIZED_ARRAY__ELEMENT, null, msgs);
			if (newElement != null)
				msgs = ((InternalEObject)newElement).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PrimitivesPackage.SIZED_ARRAY__ELEMENT, null, msgs);
			msgs = basicSetElement(newElement, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PrimitivesPackage.SIZED_ARRAY__ELEMENT, newElement, newElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getSize() {
		return size;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSize(int newSize) {
		int oldSize = size;
		size = newSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PrimitivesPackage.SIZED_ARRAY__SIZE, oldSize, size));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isBounded() {
		return bounded;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBounded(boolean newBounded) {
		boolean oldBounded = bounded;
		bounded = newBounded;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PrimitivesPackage.SIZED_ARRAY__BOUNDED, oldBounded, bounded));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PrimitivesPackage.SIZED_ARRAY__ELEMENT:
				return basicSetElement(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PrimitivesPackage.SIZED_ARRAY__ELEMENT:
				return getElement();
			case PrimitivesPackage.SIZED_ARRAY__SIZE:
				return getSize();
			case PrimitivesPackage.SIZED_ARRAY__BOUNDED:
				return isBounded();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case PrimitivesPackage.SIZED_ARRAY__ELEMENT:
				setElement((AbstractType)newValue);
				return;
			case PrimitivesPackage.SIZED_ARRAY__SIZE:
				setSize((Integer)newValue);
				return;
			case PrimitivesPackage.SIZED_ARRAY__BOUNDED:
				setBounded((Boolean)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case PrimitivesPackage.SIZED_ARRAY__ELEMENT:
				setElement((AbstractType)null);
				return;
			case PrimitivesPackage.SIZED_ARRAY__SIZE:
				setSize(SIZE_EDEFAULT);
				return;
			case PrimitivesPackage.SIZED_ARRAY__BOUNDED:
				setBounded(BOUNDED_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case PrimitivesPackage.SIZED_ARRAY__ELEMENT:
				return element != null;
			case PrimitivesPackage.SIZED_ARRAY__SIZE:
				return size != SIZE_EDEFAULT;
			case PrimitivesPackage.SIZED_ARRAY__BOUNDED:
				return bounded != BOUNDED_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (size: ");
		result.append(size);
		result.append(", bounded: ");
		result.append(bounded);
		result.append(')');
		return result.toString();
	}

} //SizedArrayImpl
