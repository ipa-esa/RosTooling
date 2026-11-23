/**
 */
package ros;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Plugin Slot</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link ros.PluginSlot#getName <em>Name</em>}</li>
 *   <li>{@link ros.PluginSlot#getBase <em>Base</em>}</li>
 *   <li>{@link ros.PluginSlot#getParameter <em>Parameter</em>}</li>
 *   <li>{@link ros.PluginSlot#getDefaultPlugin <em>Default Plugin</em>}</li>
 *   <li>{@link ros.PluginSlot#isMultiple <em>Multiple</em>}</li>
 *   <li>{@link ros.PluginSlot#getValueFormat <em>Value Format</em>}</li>
 * </ul>
 *
 * @see ros.RosPackage#getPluginSlot()
 * @model
 * @generated
 */
public interface PluginSlot extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see ros.RosPackage#getPluginSlot_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link ros.PluginSlot#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Base</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base</em>' reference.
	 * @see #setBase(PluginBase)
	 * @see ros.RosPackage#getPluginSlot_Base()
	 * @model required="true"
	 * @generated
	 */
	PluginBase getBase();

	/**
	 * Sets the value of the '{@link ros.PluginSlot#getBase <em>Base</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base</em>' reference.
	 * @see #getBase()
	 * @generated
	 */
	void setBase(PluginBase value);

	/**
	 * Returns the value of the '<em><b>Parameter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter</em>' attribute.
	 * @see #setParameter(String)
	 * @see ros.RosPackage#getPluginSlot_Parameter()
	 * @model required="true"
	 * @generated
	 */
	String getParameter();

	/**
	 * Sets the value of the '{@link ros.PluginSlot#getParameter <em>Parameter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parameter</em>' attribute.
	 * @see #getParameter()
	 * @generated
	 */
	void setParameter(String value);

	/**
	 * Returns the value of the '<em><b>Default Plugin</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Plugin</em>' reference.
	 * @see #setDefaultPlugin(Plugin)
	 * @see ros.RosPackage#getPluginSlot_DefaultPlugin()
	 * @model
	 * @generated
	 */
	Plugin getDefaultPlugin();

	/**
	 * Sets the value of the '{@link ros.PluginSlot#getDefaultPlugin <em>Default Plugin</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Plugin</em>' reference.
	 * @see #getDefaultPlugin()
	 * @generated
	 */
	void setDefaultPlugin(Plugin value);

	/**
	 * Returns the value of the '<em><b>Multiple</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Multiple</em>' attribute.
	 * @see #setMultiple(boolean)
	 * @see ros.RosPackage#getPluginSlot_Multiple()
	 * @model default="false"
	 * @generated
	 */
	boolean isMultiple();

	/**
	 * Sets the value of the '{@link ros.PluginSlot#isMultiple <em>Multiple</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Multiple</em>' attribute.
	 * @see #isMultiple()
	 * @generated
	 */
	void setMultiple(boolean value);

	/**
	 * Returns the value of the '<em><b>Value Format</b></em>' attribute.
	 * The default value is <code>"class"</code>.
	 * The literals are from the enumeration {@link ros.PluginSlotValueFormat}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value Format</em>' attribute.
	 * @see ros.PluginSlotValueFormat
	 * @see #setValueFormat(PluginSlotValueFormat)
	 * @see ros.RosPackage#getPluginSlot_ValueFormat()
	 * @model default="class"
	 * @generated
	 */
	PluginSlotValueFormat getValueFormat();

	/**
	 * Sets the value of the '{@link ros.PluginSlot#getValueFormat <em>Value Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value Format</em>' attribute.
	 * @see ros.PluginSlotValueFormat
	 * @see #getValueFormat()
	 * @generated
	 */
	void setValueFormat(PluginSlotValueFormat value);

} // PluginSlot
