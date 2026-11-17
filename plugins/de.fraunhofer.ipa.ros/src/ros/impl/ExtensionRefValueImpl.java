/**
 */
package ros.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import ros.ExtensionRefValue;
import ros.RosPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Extension Ref Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link ros.impl.ExtensionRefValueImpl#getRefKind <em>Ref Kind</em>}</li>
 *   <li>{@link ros.impl.ExtensionRefValueImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link ros.impl.ExtensionRefValueImpl#getRawTarget <em>Raw Target</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ExtensionRefValueImpl extends ExtensionValueImpl implements ExtensionRefValue {
	/**
	 * The default value of the '{@link #getRefKind() <em>Ref Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRefKind()
	 * @generated
	 * @ordered
	 */
	protected static final String REF_KIND_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRefKind() <em>Ref Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRefKind()
	 * @generated
	 * @ordered
	 */
	protected String refKind = REF_KIND_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected EObject target;

	/**
	 * The default value of the '{@link #getRawTarget() <em>Raw Target</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRawTarget()
	 * @generated
	 * @ordered
	 */
	protected static final String RAW_TARGET_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRawTarget() <em>Raw Target</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRawTarget()
	 * @generated
	 * @ordered
	 */
	protected String rawTarget = RAW_TARGET_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExtensionRefValueImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RosPackage.Literals.EXTENSION_REF_VALUE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getRefKind() {
		return refKind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRefKind(String newRefKind) {
		String oldRefKind = refKind;
		refKind = newRefKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RosPackage.EXTENSION_REF_VALUE__REF_KIND, oldRefKind, refKind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject getTarget() {
		if (target != null && target.eIsProxy()) {
			InternalEObject oldTarget = (InternalEObject)target;
			target = eResolveProxy(oldTarget);
			if (target != oldTarget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RosPackage.EXTENSION_REF_VALUE__TARGET, oldTarget, target));
			}
		}
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTarget(EObject newTarget) {
		EObject oldTarget = target;
		target = newTarget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RosPackage.EXTENSION_REF_VALUE__TARGET, oldTarget, target));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getRawTarget() {
		return rawTarget;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRawTarget(String newRawTarget) {
		String oldRawTarget = rawTarget;
		rawTarget = newRawTarget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RosPackage.EXTENSION_REF_VALUE__RAW_TARGET, oldRawTarget, rawTarget));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RosPackage.EXTENSION_REF_VALUE__REF_KIND:
				return getRefKind();
			case RosPackage.EXTENSION_REF_VALUE__TARGET:
				if (resolve) return getTarget();
				return basicGetTarget();
			case RosPackage.EXTENSION_REF_VALUE__RAW_TARGET:
				return getRawTarget();
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
			case RosPackage.EXTENSION_REF_VALUE__REF_KIND:
				setRefKind((String)newValue);
				return;
			case RosPackage.EXTENSION_REF_VALUE__TARGET:
				setTarget((EObject)newValue);
				return;
			case RosPackage.EXTENSION_REF_VALUE__RAW_TARGET:
				setRawTarget((String)newValue);
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
			case RosPackage.EXTENSION_REF_VALUE__REF_KIND:
				setRefKind(REF_KIND_EDEFAULT);
				return;
			case RosPackage.EXTENSION_REF_VALUE__TARGET:
				setTarget((EObject)null);
				return;
			case RosPackage.EXTENSION_REF_VALUE__RAW_TARGET:
				setRawTarget(RAW_TARGET_EDEFAULT);
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
			case RosPackage.EXTENSION_REF_VALUE__REF_KIND:
				return REF_KIND_EDEFAULT == null ? refKind != null : !REF_KIND_EDEFAULT.equals(refKind);
			case RosPackage.EXTENSION_REF_VALUE__TARGET:
				return target != null;
			case RosPackage.EXTENSION_REF_VALUE__RAW_TARGET:
				return RAW_TARGET_EDEFAULT == null ? rawTarget != null : !RAW_TARGET_EDEFAULT.equals(rawTarget);
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
		result.append(" (refKind: ");
		result.append(refKind);
		result.append(", rawTarget: ");
		result.append(rawTarget);
		result.append(')');
		return result.toString();
	}

} //ExtensionRefValueImpl
