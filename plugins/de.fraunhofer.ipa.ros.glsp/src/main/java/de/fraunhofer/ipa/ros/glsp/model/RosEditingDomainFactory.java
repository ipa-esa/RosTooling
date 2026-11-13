package de.fraunhofer.ipa.ros.glsp.model;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.glsp.server.emf.DefaultEditingDomainFactory;
import org.eclipse.xtext.resource.XtextResourceSet;

/**
 * EditingDomainFactory backed by an XtextResourceSet so EMF commands operate
 * directly on Xtext AST/Node-Model resources.
 */
public class RosEditingDomainFactory extends DefaultEditingDomainFactory {

    @Override
    protected ResourceSet createResourceSet() {
        RosXtextModelStorage.ensureXtextInitialized();
        XtextResourceSet resourceSet = new XtextResourceSet();
        resourceSet.addLoadOption(org.eclipse.xtext.resource.XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);
        return resourceSet;
    }
}
