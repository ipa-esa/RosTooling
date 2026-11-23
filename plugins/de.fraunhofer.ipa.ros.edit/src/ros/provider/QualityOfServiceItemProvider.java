/**
 */
package ros.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

import ros.QualityOfService;
import ros.RosPackage;

/**
 * This is the item provider adapter for a {@link ros.QualityOfService} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class QualityOfServiceItemProvider
    extends ItemProviderAdapter
    implements
        IEditingDomainItemProvider,
        IStructuredItemContentProvider,
        ITreeItemContentProvider,
        IItemLabelProvider,
        IItemPropertySource {
    /**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public QualityOfServiceItemProvider(AdapterFactory adapterFactory) {
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

			addQoSProfilePropertyDescriptor(object);
			addHistoryPropertyDescriptor(object);
			addDepthPropertyDescriptor(object);
			addReliabilityPropertyDescriptor(object);
			addDurabilityPropertyDescriptor(object);
			addLivelinessPropertyDescriptor(object);
			addLeaseDurationPropertyDescriptor(object);
			addLifespanPropertyDescriptor(object);
			addDeadlinePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

    /**
	 * This adds a property descriptor for the Qo SProfile feature.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected void addQoSProfilePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_QualityOfService_QoSProfile_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_QualityOfService_QoSProfile_feature", "_UI_QualityOfService_type"),
				 RosPackage.Literals.QUALITY_OF_SERVICE__QO_SPROFILE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

    /**
	 * This adds a property descriptor for the History feature.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected void addHistoryPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_QualityOfService_History_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_QualityOfService_History_feature", "_UI_QualityOfService_type"),
				 RosPackage.Literals.QUALITY_OF_SERVICE__HISTORY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

    /**
	 * This adds a property descriptor for the Depth feature.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected void addDepthPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_QualityOfService_Depth_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_QualityOfService_Depth_feature", "_UI_QualityOfService_type"),
				 RosPackage.Literals.QUALITY_OF_SERVICE__DEPTH,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

    /**
	 * This adds a property descriptor for the Reliability feature.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected void addReliabilityPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_QualityOfService_Reliability_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_QualityOfService_Reliability_feature", "_UI_QualityOfService_type"),
				 RosPackage.Literals.QUALITY_OF_SERVICE__RELIABILITY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

    /**
	 * This adds a property descriptor for the Durability feature.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected void addDurabilityPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_QualityOfService_Durability_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_QualityOfService_Durability_feature", "_UI_QualityOfService_type"),
				 RosPackage.Literals.QUALITY_OF_SERVICE__DURABILITY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

    /**
	 * This adds a property descriptor for the Liveliness feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLivelinessPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_QualityOfService_Liveliness_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_QualityOfService_Liveliness_feature", "_UI_QualityOfService_type"),
				 RosPackage.Literals.QUALITY_OF_SERVICE__LIVELINESS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

				/**
	 * This adds a property descriptor for the Lease Duration feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLeaseDurationPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_QualityOfService_LeaseDuration_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_QualityOfService_LeaseDuration_feature", "_UI_QualityOfService_type"),
				 RosPackage.Literals.QUALITY_OF_SERVICE__LEASE_DURATION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

				/**
	 * This adds a property descriptor for the Lifespan feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLifespanPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_QualityOfService_Lifespan_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_QualityOfService_Lifespan_feature", "_UI_QualityOfService_type"),
				 RosPackage.Literals.QUALITY_OF_SERVICE__LIFESPAN,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

				/**
	 * This adds a property descriptor for the Deadline feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDeadlinePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_QualityOfService_Deadline_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_QualityOfService_Deadline_feature", "_UI_QualityOfService_type"),
				 RosPackage.Literals.QUALITY_OF_SERVICE__DEADLINE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

				/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public String getText(Object object) {
		String label = ((QualityOfService)object).getQoSProfile();
		return label == null || label.length() == 0 ?
			getString("_UI_QualityOfService_type") :
			getString("_UI_QualityOfService_type") + " " + label;
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

		switch (notification.getFeatureID(QualityOfService.class)) {
			case RosPackage.QUALITY_OF_SERVICE__QO_SPROFILE:
			case RosPackage.QUALITY_OF_SERVICE__HISTORY:
			case RosPackage.QUALITY_OF_SERVICE__DEPTH:
			case RosPackage.QUALITY_OF_SERVICE__RELIABILITY:
			case RosPackage.QUALITY_OF_SERVICE__DURABILITY:
			case RosPackage.QUALITY_OF_SERVICE__LIVELINESS:
			case RosPackage.QUALITY_OF_SERVICE__LEASE_DURATION:
			case RosPackage.QUALITY_OF_SERVICE__LIFESPAN:
			case RosPackage.QUALITY_OF_SERVICE__DEADLINE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
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
	}

    /**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public ResourceLocator getResourceLocator() {
		return RosEditPlugin.INSTANCE;
	}

}
