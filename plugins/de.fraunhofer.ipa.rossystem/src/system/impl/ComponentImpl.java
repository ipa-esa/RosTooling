/**
 */
package system.impl;

import org.eclipse.emf.ecore.EClass;
import ros.impl.ExtensibleImpl;
import system.Component;
import system.RossystemPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Component</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class ComponentImpl extends ExtensibleImpl implements Component {
    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected ComponentImpl() {
		super();
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    protected EClass eStaticClass() {
		return RossystemPackage.Literals.COMPONENT;
	}

} //ComponentImpl
