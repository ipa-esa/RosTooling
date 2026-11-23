/**
 */
package ros.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import ros.InterfaceHolder;
import ros.RosFactory;
import ros.RosPackage;

/**
 * This is the item provider adapter for a {@link ros.InterfaceHolder} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class InterfaceHolderItemProvider extends ExtensibleItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InterfaceHolderItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addNamePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_InterfaceHolder_name_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_InterfaceHolder_name_feature", "_UI_InterfaceHolder_type"),
				 RosPackage.Literals.INTERFACE_HOLDER__NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(RosPackage.Literals.INTERFACE_HOLDER__SERVICESERVER);
			childrenFeatures.add(RosPackage.Literals.INTERFACE_HOLDER__PUBLISHER);
			childrenFeatures.add(RosPackage.Literals.INTERFACE_HOLDER__SUBSCRIBER);
			childrenFeatures.add(RosPackage.Literals.INTERFACE_HOLDER__SERVICECLIENT);
			childrenFeatures.add(RosPackage.Literals.INTERFACE_HOLDER__ACTIONSERVER);
			childrenFeatures.add(RosPackage.Literals.INTERFACE_HOLDER__ACTIONCLIENT);
			childrenFeatures.add(RosPackage.Literals.INTERFACE_HOLDER__PARAMETER);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((InterfaceHolder)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_InterfaceHolder_type") :
			getString("_UI_InterfaceHolder_type") + " " + label;
	}


	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(InterfaceHolder.class)) {
			case RosPackage.INTERFACE_HOLDER__NAME:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case RosPackage.INTERFACE_HOLDER__SERVICESERVER:
			case RosPackage.INTERFACE_HOLDER__PUBLISHER:
			case RosPackage.INTERFACE_HOLDER__SUBSCRIBER:
			case RosPackage.INTERFACE_HOLDER__SERVICECLIENT:
			case RosPackage.INTERFACE_HOLDER__ACTIONSERVER:
			case RosPackage.INTERFACE_HOLDER__ACTIONCLIENT:
			case RosPackage.INTERFACE_HOLDER__PARAMETER:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(RosPackage.Literals.INTERFACE_HOLDER__SERVICESERVER,
				 RosFactory.eINSTANCE.createServiceServer()));

		newChildDescriptors.add
			(createChildParameter
				(RosPackage.Literals.INTERFACE_HOLDER__PUBLISHER,
				 RosFactory.eINSTANCE.createPublisher()));

		newChildDescriptors.add
			(createChildParameter
				(RosPackage.Literals.INTERFACE_HOLDER__SUBSCRIBER,
				 RosFactory.eINSTANCE.createSubscriber()));

		newChildDescriptors.add
			(createChildParameter
				(RosPackage.Literals.INTERFACE_HOLDER__SERVICECLIENT,
				 RosFactory.eINSTANCE.createServiceClient()));

		newChildDescriptors.add
			(createChildParameter
				(RosPackage.Literals.INTERFACE_HOLDER__ACTIONSERVER,
				 RosFactory.eINSTANCE.createActionServer()));

		newChildDescriptors.add
			(createChildParameter
				(RosPackage.Literals.INTERFACE_HOLDER__ACTIONCLIENT,
				 RosFactory.eINSTANCE.createActionClient()));

		newChildDescriptors.add
			(createChildParameter
				(RosPackage.Literals.INTERFACE_HOLDER__PARAMETER,
				 RosFactory.eINSTANCE.createParameter()));
	}

}
