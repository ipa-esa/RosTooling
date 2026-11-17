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
 *   <li>{@link ros.Plugin#getLoader <em>Loader</em>}</li>
 * </ul>
 *
 * @see ros.RosPackage#getPlugin()
 * @model
 * @generated
 */
public interface Plugin extends InterfaceHolder {
	/**
	 * Returns the value of the '<em><b>Implements</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Implements</em>' attribute.
	 * @see #setImplements(String)
	 * @see ros.RosPackage#getPlugin_Implements()
	 * @model
	 * @generated
	 */
	String getImplements();

	/**
	 * Sets the value of the '{@link ros.Plugin#getImplements <em>Implements</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Implements</em>' attribute.
	 * @see #getImplements()
	 * @generated
	 */
	void setImplements(String value);

	/**
	 * Returns the value of the '<em><b>Loader</b></em>' attribute.
	 * The default value is <code>"pluginlib"</code>.
	 * The literals are from the enumeration {@link ros.PluginLoader}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Loader</em>' attribute.
	 * @see ros.PluginLoader
	 * @see #setLoader(PluginLoader)
	 * @see ros.RosPackage#getPlugin_Loader()
	 * @model default="pluginlib"
	 * @generated
	 */
	PluginLoader getLoader();

	/**
	 * Sets the value of the '{@link ros.Plugin#getLoader <em>Loader</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Loader</em>' attribute.
	 * @see ros.PluginLoader
	 * @see #getLoader()
	 * @generated
	 */
	void setLoader(PluginLoader value);

} // Plugin
