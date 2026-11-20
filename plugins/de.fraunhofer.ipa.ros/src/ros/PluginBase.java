/**
 */
package ros;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Plugin Base</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link ros.PluginBase#getName <em>Name</em>}</li>
 *   <li>{@link ros.PluginBase#getClassName <em>Class Name</em>}</li>
 *   <li>{@link ros.PluginBase#getHeader <em>Header</em>}</li>
 *   <li>{@link ros.PluginBase#getLoader <em>Loader</em>}</li>
 * </ul>
 *
 * @see ros.RosPackage#getPluginBase()
 * @model
 * @generated
 */
public interface PluginBase extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see ros.RosPackage#getPluginBase_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link ros.PluginBase#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Class Name</em>' attribute.
	 * @see #setClassName(String)
	 * @see ros.RosPackage#getPluginBase_ClassName()
	 * @model required="true"
	 * @generated
	 */
	String getClassName();

	/**
	 * Sets the value of the '{@link ros.PluginBase#getClassName <em>Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Class Name</em>' attribute.
	 * @see #getClassName()
	 * @generated
	 */
	void setClassName(String value);

	/**
	 * Returns the value of the '<em><b>Header</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Header</em>' attribute.
	 * @see #setHeader(String)
	 * @see ros.RosPackage#getPluginBase_Header()
	 * @model required="true"
	 * @generated
	 */
	String getHeader();

	/**
	 * Sets the value of the '{@link ros.PluginBase#getHeader <em>Header</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Header</em>' attribute.
	 * @see #getHeader()
	 * @generated
	 */
	void setHeader(String value);

	/**
	 * Returns the value of the '<em><b>Loader</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Loader</em>' attribute.
	 * @see #setLoader(String)
	 * @see ros.RosPackage#getPluginBase_Loader()
	 * @model required="true"
	 * @generated
	 */
	String getLoader();

	/**
	 * Sets the value of the '{@link ros.PluginBase#getLoader <em>Loader</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Loader</em>' attribute.
	 * @see #getLoader()
	 * @generated
	 */
	void setLoader(String value);

} // PluginBase
