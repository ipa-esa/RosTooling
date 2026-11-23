/**
 */
package ros.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import ros.Node;
import ros.PluginSlot;
import ros.RosPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link ros.impl.NodeImpl#isIsLifecycle <em>Is Lifecycle</em>}</li>
 *   <li>{@link ros.impl.NodeImpl#getPluginSlots <em>Plugin Slots</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NodeImpl extends InterfaceHolderImpl implements Node {
	/**
	 * The default value of the '{@link #isIsLifecycle() <em>Is Lifecycle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsLifecycle()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_LIFECYCLE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsLifecycle() <em>Is Lifecycle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsLifecycle()
	 * @generated
	 * @ordered
	 */
	protected boolean isLifecycle = IS_LIFECYCLE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPluginSlots() <em>Plugin Slots</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPluginSlots()
	 * @generated
	 * @ordered
	 */
	protected EList<PluginSlot> pluginSlots;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RosPackage.Literals.NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsLifecycle() {
		return isLifecycle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsLifecycle(boolean newIsLifecycle) {
		boolean oldIsLifecycle = isLifecycle;
		isLifecycle = newIsLifecycle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RosPackage.NODE__IS_LIFECYCLE, oldIsLifecycle, isLifecycle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<PluginSlot> getPluginSlots() {
		if (pluginSlots == null) {
			pluginSlots = new EObjectContainmentEList<PluginSlot>(PluginSlot.class, this, RosPackage.NODE__PLUGIN_SLOTS);
		}
		return pluginSlots;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RosPackage.NODE__PLUGIN_SLOTS:
				return ((InternalEList<?>)getPluginSlots()).basicRemove(otherEnd, msgs);
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
			case RosPackage.NODE__IS_LIFECYCLE:
				return isIsLifecycle();
			case RosPackage.NODE__PLUGIN_SLOTS:
				return getPluginSlots();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case RosPackage.NODE__IS_LIFECYCLE:
				setIsLifecycle((Boolean)newValue);
				return;
			case RosPackage.NODE__PLUGIN_SLOTS:
				getPluginSlots().clear();
				getPluginSlots().addAll((Collection<? extends PluginSlot>)newValue);
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
			case RosPackage.NODE__IS_LIFECYCLE:
				setIsLifecycle(IS_LIFECYCLE_EDEFAULT);
				return;
			case RosPackage.NODE__PLUGIN_SLOTS:
				getPluginSlots().clear();
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
			case RosPackage.NODE__IS_LIFECYCLE:
				return isLifecycle != IS_LIFECYCLE_EDEFAULT;
			case RosPackage.NODE__PLUGIN_SLOTS:
				return pluginSlots != null && !pluginSlots.isEmpty();
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
		result.append(" (isLifecycle: ");
		result.append(isLifecycle);
		result.append(')');
		return result.toString();
	}

} //NodeImpl
