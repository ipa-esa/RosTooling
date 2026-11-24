/**
 */
package primitives.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import primitives.PrimitivesFactory;
import primitives.PrimitivesPackage;
import primitives.SizedArray;

import ros.RosFactory;

/**
 * This is the item provider adapter for a {@link primitives.SizedArray} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class SizedArrayItemProvider extends AbstractTypeItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SizedArrayItemProvider(AdapterFactory adapterFactory) {
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

			addSizePropertyDescriptor(object);
			addBoundedPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Size feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSizePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SizedArray_size_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SizedArray_size_feature", "_UI_SizedArray_type"),
				 PrimitivesPackage.Literals.SIZED_ARRAY__SIZE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Bounded feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addBoundedPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SizedArray_bounded_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SizedArray_bounded_feature", "_UI_SizedArray_type"),
				 PrimitivesPackage.Literals.SIZED_ARRAY__BOUNDED,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
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
			childrenFeatures.add(PrimitivesPackage.Literals.SIZED_ARRAY__ELEMENT);
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
	 * This returns SizedArray.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/SizedArray"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		SizedArray sizedArray = (SizedArray)object;
		return getString("_UI_SizedArray_type") + " " + sizedArray.getSize();
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

		switch (notification.getFeatureID(SizedArray.class)) {
			case PrimitivesPackage.SIZED_ARRAY__SIZE:
			case PrimitivesPackage.SIZED_ARRAY__BOUNDED:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case PrimitivesPackage.SIZED_ARRAY__ELEMENT:
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
				(PrimitivesPackage.Literals.SIZED_ARRAY__ELEMENT,
				 PrimitivesFactory.eINSTANCE.createbool()));

		newChildDescriptors.add
			(createChildParameter
				(PrimitivesPackage.Literals.SIZED_ARRAY__ELEMENT,
				 PrimitivesFactory.eINSTANCE.createint8()));

		newChildDescriptors.add
			(createChildParameter
				(PrimitivesPackage.Literals.SIZED_ARRAY__ELEMENT,
				 PrimitivesFactory.eINSTANCE.createuint8()));

		newChildDescriptors.add
			(createChildParameter
				(PrimitivesPackage.Literals.SIZED_ARRAY__ELEMENT,
				 PrimitivesFactory.eINSTANCE.createint16()));

		newChildDescriptors.add
			(createChildParameter
				(PrimitivesPackage.Literals.SIZED_ARRAY__ELEMENT,
				 PrimitivesFactory.eINSTANCE.createuint16()));

		newChildDescriptors.add
			(createChildParameter
				(PrimitivesPackage.Literals.SIZED_ARRAY__ELEMENT,
				 PrimitivesFactory.eINSTANCE.createint32()));

		newChildDescriptors.add
			(createChildParameter
				(PrimitivesPackage.Literals.SIZED_ARRAY__ELEMENT,
				 PrimitivesFactory.eINSTANCE.createuint32()));

		newChildDescriptors.add
			(createChildParameter
				(PrimitivesPackage.Literals.SIZED_ARRAY__ELEMENT,
				 PrimitivesFactory.eINSTANCE.createint64()));

		newChildDescriptors.add
			(createChildParameter
				(PrimitivesPackage.Literals.SIZED_ARRAY__ELEMENT,
				 PrimitivesFactory.eINSTANCE.createuint64()));

		newChildDescriptors.add
			(createChildParameter
				(PrimitivesPackage.Literals.SIZED_ARRAY__ELEMENT,
				 PrimitivesFactory.eINSTANCE.createfloat32()));

		newChildDescriptors.add
			(createChildParameter
				(PrimitivesPackage.Literals.SIZED_ARRAY__ELEMENT,
				 PrimitivesFactory.eINSTANCE.createfloat64()));

		newChildDescriptors.add
			(createChildParameter
				(PrimitivesPackage.Literals.SIZED_ARRAY__ELEMENT,
				 PrimitivesFactory.eINSTANCE.createstring()));

		newChildDescriptors.add
			(createChildParameter
				(PrimitivesPackage.Literals.SIZED_ARRAY__ELEMENT,
				 PrimitivesFactory.eINSTANCE.createtime()));

		newChildDescriptors.add
			(createChildParameter
				(PrimitivesPackage.Literals.SIZED_ARRAY__ELEMENT,
				 PrimitivesFactory.eINSTANCE.createduration()));

		newChildDescriptors.add
			(createChildParameter
				(PrimitivesPackage.Literals.SIZED_ARRAY__ELEMENT,
				 PrimitivesFactory.eINSTANCE.createboolArray()));

		newChildDescriptors.add
			(createChildParameter
				(PrimitivesPackage.Literals.SIZED_ARRAY__ELEMENT,
				 PrimitivesFactory.eINSTANCE.createint8Array()));

		newChildDescriptors.add
			(createChildParameter
				(PrimitivesPackage.Literals.SIZED_ARRAY__ELEMENT,
				 PrimitivesFactory.eINSTANCE.createuint8Array()));

		newChildDescriptors.add
			(createChildParameter
				(PrimitivesPackage.Literals.SIZED_ARRAY__ELEMENT,
				 PrimitivesFactory.eINSTANCE.createint16Array()));

		newChildDescriptors.add
			(createChildParameter
				(PrimitivesPackage.Literals.SIZED_ARRAY__ELEMENT,
				 PrimitivesFactory.eINSTANCE.createuint16Array()));

		newChildDescriptors.add
			(createChildParameter
				(PrimitivesPackage.Literals.SIZED_ARRAY__ELEMENT,
				 PrimitivesFactory.eINSTANCE.createint32Array()));

		newChildDescriptors.add
			(createChildParameter
				(PrimitivesPackage.Literals.SIZED_ARRAY__ELEMENT,
				 PrimitivesFactory.eINSTANCE.createuint32Array()));

		newChildDescriptors.add
			(createChildParameter
				(PrimitivesPackage.Literals.SIZED_ARRAY__ELEMENT,
				 PrimitivesFactory.eINSTANCE.createint64Array()));

		newChildDescriptors.add
			(createChildParameter
				(PrimitivesPackage.Literals.SIZED_ARRAY__ELEMENT,
				 PrimitivesFactory.eINSTANCE.createuint64Array()));

		newChildDescriptors.add
			(createChildParameter
				(PrimitivesPackage.Literals.SIZED_ARRAY__ELEMENT,
				 PrimitivesFactory.eINSTANCE.createfloat32Array()));

		newChildDescriptors.add
			(createChildParameter
				(PrimitivesPackage.Literals.SIZED_ARRAY__ELEMENT,
				 PrimitivesFactory.eINSTANCE.createfloat64Array()));

		newChildDescriptors.add
			(createChildParameter
				(PrimitivesPackage.Literals.SIZED_ARRAY__ELEMENT,
				 PrimitivesFactory.eINSTANCE.createstringArray()));

		newChildDescriptors.add
			(createChildParameter
				(PrimitivesPackage.Literals.SIZED_ARRAY__ELEMENT,
				 PrimitivesFactory.eINSTANCE.createHeader()));

		newChildDescriptors.add
			(createChildParameter
				(PrimitivesPackage.Literals.SIZED_ARRAY__ELEMENT,
				 PrimitivesFactory.eINSTANCE.createByte()));

		newChildDescriptors.add
			(createChildParameter
				(PrimitivesPackage.Literals.SIZED_ARRAY__ELEMENT,
				 PrimitivesFactory.eINSTANCE.createByteArray()));

		newChildDescriptors.add
			(createChildParameter
				(PrimitivesPackage.Literals.SIZED_ARRAY__ELEMENT,
				 PrimitivesFactory.eINSTANCE.createchar0()));

		newChildDescriptors.add
			(createChildParameter
				(PrimitivesPackage.Literals.SIZED_ARRAY__ELEMENT,
				 PrimitivesFactory.eINSTANCE.createcharArray()));

		newChildDescriptors.add
			(createChildParameter
				(PrimitivesPackage.Literals.SIZED_ARRAY__ELEMENT,
				 PrimitivesFactory.eINSTANCE.createSizedArray()));

		newChildDescriptors.add
			(createChildParameter
				(PrimitivesPackage.Literals.SIZED_ARRAY__ELEMENT,
				 RosFactory.eINSTANCE.createTopicSpecMsgRef()));

		newChildDescriptors.add
			(createChildParameter
				(PrimitivesPackage.Literals.SIZED_ARRAY__ELEMENT,
				 RosFactory.eINSTANCE.createArrayTopicSpecMsgRef()));
	}

}
