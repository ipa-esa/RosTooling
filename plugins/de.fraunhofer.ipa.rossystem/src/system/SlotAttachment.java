/**
 */
package system;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import ros.Plugin;
import ros.PluginSlot;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Slot Attachment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link system.SlotAttachment#getSlot <em>Slot</em>}</li>
 *   <li>{@link system.SlotAttachment#getPlugins <em>Plugins</em>}</li>
 * </ul>
 *
 * @see system.RossystemPackage#getSlotAttachment()
 * @model
 * @generated
 */
public interface SlotAttachment extends EObject {
	/**
	 * Returns the value of the '<em><b>Slot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Slot</em>' reference.
	 * @see #setSlot(PluginSlot)
	 * @see system.RossystemPackage#getSlotAttachment_Slot()
	 * @model required="true"
	 * @generated
	 */
	PluginSlot getSlot();

	/**
	 * Sets the value of the '{@link system.SlotAttachment#getSlot <em>Slot</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Slot</em>' reference.
	 * @see #getSlot()
	 * @generated
	 */
	void setSlot(PluginSlot value);

	/**
	 * Returns the value of the '<em><b>Plugins</b></em>' reference list.
	 * The list contents are of type {@link ros.Plugin}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Plugins</em>' reference list.
	 * @see system.RossystemPackage#getSlotAttachment_Plugins()
	 * @model
	 * @generated
	 */
	EList<Plugin> getPlugins();

} // SlotAttachment
