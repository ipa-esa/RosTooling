/**
 */
package ros.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import ros.Plugin;
import ros.PluginBase;
import ros.PluginSlot;
import ros.PluginSlotValueFormat;
import ros.RosPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Plugin Slot</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link ros.impl.PluginSlotImpl#getName <em>Name</em>}</li>
 *   <li>{@link ros.impl.PluginSlotImpl#getBase <em>Base</em>}</li>
 *   <li>{@link ros.impl.PluginSlotImpl#getParameter <em>Parameter</em>}</li>
 *   <li>{@link ros.impl.PluginSlotImpl#getDefaultPlugin <em>Default Plugin</em>}</li>
 *   <li>{@link ros.impl.PluginSlotImpl#isMultiple <em>Multiple</em>}</li>
 *   <li>{@link ros.impl.PluginSlotImpl#getValueFormat <em>Value Format</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PluginSlotImpl extends MinimalEObjectImpl.Container implements PluginSlot {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getBase() <em>Base</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase()
	 * @generated
	 * @ordered
	 */
	protected PluginBase base;

	/**
	 * The default value of the '{@link #getParameter() <em>Parameter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameter()
	 * @generated
	 * @ordered
	 */
	protected static final String PARAMETER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getParameter() <em>Parameter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameter()
	 * @generated
	 * @ordered
	 */
	protected String parameter = PARAMETER_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDefaultPlugin() <em>Default Plugin</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultPlugin()
	 * @generated
	 * @ordered
	 */
	protected Plugin defaultPlugin;

	/**
	 * The default value of the '{@link #isMultiple() <em>Multiple</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMultiple()
	 * @generated
	 * @ordered
	 */
	protected static final boolean MULTIPLE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isMultiple() <em>Multiple</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMultiple()
	 * @generated
	 * @ordered
	 */
	protected boolean multiple = MULTIPLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getValueFormat() <em>Value Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValueFormat()
	 * @generated
	 * @ordered
	 */
	protected static final PluginSlotValueFormat VALUE_FORMAT_EDEFAULT = PluginSlotValueFormat.CLASS;

	/**
	 * The cached value of the '{@link #getValueFormat() <em>Value Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValueFormat()
	 * @generated
	 * @ordered
	 */
	protected PluginSlotValueFormat valueFormat = VALUE_FORMAT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PluginSlotImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RosPackage.Literals.PLUGIN_SLOT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RosPackage.PLUGIN_SLOT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PluginBase getBase() {
		if (base != null && base.eIsProxy()) {
			InternalEObject oldBase = (InternalEObject)base;
			base = (PluginBase)eResolveProxy(oldBase);
			if (base != oldBase) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RosPackage.PLUGIN_SLOT__BASE, oldBase, base));
			}
		}
		return base;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PluginBase basicGetBase() {
		return base;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBase(PluginBase newBase) {
		PluginBase oldBase = base;
		base = newBase;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RosPackage.PLUGIN_SLOT__BASE, oldBase, base));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getParameter() {
		return parameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setParameter(String newParameter) {
		String oldParameter = parameter;
		parameter = newParameter;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RosPackage.PLUGIN_SLOT__PARAMETER, oldParameter, parameter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Plugin getDefaultPlugin() {
		if (defaultPlugin != null && defaultPlugin.eIsProxy()) {
			InternalEObject oldDefaultPlugin = (InternalEObject)defaultPlugin;
			defaultPlugin = (Plugin)eResolveProxy(oldDefaultPlugin);
			if (defaultPlugin != oldDefaultPlugin) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RosPackage.PLUGIN_SLOT__DEFAULT_PLUGIN, oldDefaultPlugin, defaultPlugin));
			}
		}
		return defaultPlugin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Plugin basicGetDefaultPlugin() {
		return defaultPlugin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDefaultPlugin(Plugin newDefaultPlugin) {
		Plugin oldDefaultPlugin = defaultPlugin;
		defaultPlugin = newDefaultPlugin;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RosPackage.PLUGIN_SLOT__DEFAULT_PLUGIN, oldDefaultPlugin, defaultPlugin));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isMultiple() {
		return multiple;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMultiple(boolean newMultiple) {
		boolean oldMultiple = multiple;
		multiple = newMultiple;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RosPackage.PLUGIN_SLOT__MULTIPLE, oldMultiple, multiple));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PluginSlotValueFormat getValueFormat() {
		return valueFormat;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setValueFormat(PluginSlotValueFormat newValueFormat) {
		PluginSlotValueFormat oldValueFormat = valueFormat;
		valueFormat = newValueFormat == null ? VALUE_FORMAT_EDEFAULT : newValueFormat;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RosPackage.PLUGIN_SLOT__VALUE_FORMAT, oldValueFormat, valueFormat));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RosPackage.PLUGIN_SLOT__NAME:
				return getName();
			case RosPackage.PLUGIN_SLOT__BASE:
				if (resolve) return getBase();
				return basicGetBase();
			case RosPackage.PLUGIN_SLOT__PARAMETER:
				return getParameter();
			case RosPackage.PLUGIN_SLOT__DEFAULT_PLUGIN:
				if (resolve) return getDefaultPlugin();
				return basicGetDefaultPlugin();
			case RosPackage.PLUGIN_SLOT__MULTIPLE:
				return isMultiple();
			case RosPackage.PLUGIN_SLOT__VALUE_FORMAT:
				return getValueFormat();
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
			case RosPackage.PLUGIN_SLOT__NAME:
				setName((String)newValue);
				return;
			case RosPackage.PLUGIN_SLOT__BASE:
				setBase((PluginBase)newValue);
				return;
			case RosPackage.PLUGIN_SLOT__PARAMETER:
				setParameter((String)newValue);
				return;
			case RosPackage.PLUGIN_SLOT__DEFAULT_PLUGIN:
				setDefaultPlugin((Plugin)newValue);
				return;
			case RosPackage.PLUGIN_SLOT__MULTIPLE:
				setMultiple((Boolean)newValue);
				return;
			case RosPackage.PLUGIN_SLOT__VALUE_FORMAT:
				setValueFormat((PluginSlotValueFormat)newValue);
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
			case RosPackage.PLUGIN_SLOT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case RosPackage.PLUGIN_SLOT__BASE:
				setBase((PluginBase)null);
				return;
			case RosPackage.PLUGIN_SLOT__PARAMETER:
				setParameter(PARAMETER_EDEFAULT);
				return;
			case RosPackage.PLUGIN_SLOT__DEFAULT_PLUGIN:
				setDefaultPlugin((Plugin)null);
				return;
			case RosPackage.PLUGIN_SLOT__MULTIPLE:
				setMultiple(MULTIPLE_EDEFAULT);
				return;
			case RosPackage.PLUGIN_SLOT__VALUE_FORMAT:
				setValueFormat(VALUE_FORMAT_EDEFAULT);
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
			case RosPackage.PLUGIN_SLOT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case RosPackage.PLUGIN_SLOT__BASE:
				return base != null;
			case RosPackage.PLUGIN_SLOT__PARAMETER:
				return PARAMETER_EDEFAULT == null ? parameter != null : !PARAMETER_EDEFAULT.equals(parameter);
			case RosPackage.PLUGIN_SLOT__DEFAULT_PLUGIN:
				return defaultPlugin != null;
			case RosPackage.PLUGIN_SLOT__MULTIPLE:
				return multiple != MULTIPLE_EDEFAULT;
			case RosPackage.PLUGIN_SLOT__VALUE_FORMAT:
				return valueFormat != VALUE_FORMAT_EDEFAULT;
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
		result.append(" (name: ");
		result.append(name);
		result.append(", parameter: ");
		result.append(parameter);
		result.append(", multiple: ");
		result.append(multiple);
		result.append(", valueFormat: ");
		result.append(valueFormat);
		result.append(')');
		return result.toString();
	}

} //PluginSlotImpl
