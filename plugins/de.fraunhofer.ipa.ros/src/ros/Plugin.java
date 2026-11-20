/**
 */
package ros;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Plugin</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link ros.Plugin#getImplements <em>Implements</em>}</li>
 * </ul>
 *
 * @see ros.RosPackage#getPlugin()
 * @model
 * @generated
 */
public interface Plugin extends InterfaceHolder {
	/**
	 * Returns the value of the '<em><b>Implements</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Implements</em>' reference.
	 * @see #setImplements(PluginBase)
	 * @see ros.RosPackage#getPlugin_Implements()
	 * @model required="true"
	 * @generated
	 */
	PluginBase getImplements();

	/**
	 * Sets the value of the '{@link ros.Plugin#getImplements <em>Implements</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Implements</em>' reference.
	 * @see #getImplements()
	 * @generated
	 */
	void setImplements(PluginBase value);

} // Plugin
