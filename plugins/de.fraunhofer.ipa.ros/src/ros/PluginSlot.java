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
	 * Returns the value of the '<em><b>Base</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base</em>' attribute.
	 * @see #setBase(String)
	 * @see ros.RosPackage#getPluginSlot_Base()
	 * @model required="true"
	 * @generated
	 */
	String getBase();

	/**
	 * Sets the value of the '{@link ros.PluginSlot#getBase <em>Base</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base</em>' attribute.
	 * @see #getBase()
	 * @generated
	 */
	void setBase(String value);

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
	 * Returns the value of the '<em><b>Default Plugin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Plugin</em>' attribute.
	 * @see #setDefaultPlugin(String)
	 * @see ros.RosPackage#getPluginSlot_DefaultPlugin()
	 * @model
	 * @generated
	 */
	String getDefaultPlugin();

	/**
	 * Sets the value of the '{@link ros.PluginSlot#getDefaultPlugin <em>Default Plugin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Plugin</em>' attribute.
	 * @see #getDefaultPlugin()
	 * @generated
	 */
	void setDefaultPlugin(String value);

} // PluginSlot
