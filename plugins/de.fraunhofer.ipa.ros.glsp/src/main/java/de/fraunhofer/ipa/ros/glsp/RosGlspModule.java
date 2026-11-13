package de.fraunhofer.ipa.ros.glsp;

import de.fraunhofer.ipa.ros.glsp.handlers.ChangeBoundsOperationHandler;
import de.fraunhofer.ipa.ros.glsp.handlers.CreateConnectionOperationHandler;
import de.fraunhofer.ipa.ros.glsp.handlers.CreateRosNodeOperationHandler;
import de.fraunhofer.ipa.ros.glsp.handlers.DeleteRosElementOperationHandler;
import de.fraunhofer.ipa.ros.glsp.handlers.RequestRosIndexActionHandler;
import de.fraunhofer.ipa.ros.glsp.handlers.IgnoreRoutingPointsOperationHandler;
import de.fraunhofer.ipa.ros.glsp.handlers.RequestRosTextEditsActionHandler;
import org.eclipse.glsp.server.actions.ActionHandler;
import de.fraunhofer.ipa.ros.glsp.handlers.EditRosPropertyOperationHandler;
import de.fraunhofer.ipa.ros.glsp.handlers.ReconnectConnectionOperationHandler;
import de.fraunhofer.ipa.ros.glsp.handlers.ToggleSubSystemOperationHandler;
import de.fraunhofer.ipa.ros.glsp.layout.RosLayoutEngine;
import de.fraunhofer.ipa.ros.glsp.model.RosEditingDomainFactory;
import de.fraunhofer.ipa.ros.glsp.model.RosGModelFactory;
import de.fraunhofer.ipa.ros.glsp.model.RosModelState;
import de.fraunhofer.ipa.ros.glsp.model.RosXtextModelStorage;
import de.fraunhofer.ipa.ros.glsp.validation.RosModelValidator;
import org.eclipse.glsp.server.di.MultiBinding;
import org.eclipse.glsp.server.diagram.DiagramConfiguration;
import org.eclipse.glsp.server.emf.EMFDiagramModule;
import org.eclipse.glsp.server.emf.EMFEditingDomainFactory;
import org.eclipse.glsp.server.emf.EMFIdGenerator;
import org.eclipse.glsp.server.emf.EMFModelState;
import org.eclipse.glsp.server.emf.EMFSourceModelStorage;
import org.eclipse.glsp.server.emf.idgen.FragmentIdGenerator;
import org.eclipse.glsp.server.features.core.model.GModelFactory;
import org.eclipse.glsp.server.features.validation.ModelValidator;
import org.eclipse.glsp.server.layout.LayoutEngine;
import org.eclipse.glsp.server.operations.OperationHandler;

/**
 * Guice dependency injection module for the RosTooling GLSP diagram server.
 * Wires the live Xtext/EMF resource set, GGraph factory, server-side ELK layout engine,
 * EMF OperationHandlers, and live Xtext ModelValidator.
 */
public class RosGlspModule extends EMFDiagramModule {

    @Override
    protected Class<? extends DiagramConfiguration> bindDiagramConfiguration() {
        return RosDiagramConfiguration.class;
    }

    @Override
    protected Class<? extends EMFEditingDomainFactory> bindEMFEditingDomainFactory() {
        return RosEditingDomainFactory.class;
    }

    @Override
    protected Class<? extends EMFSourceModelStorage> bindSourceModelStorage() {
        return RosXtextModelStorage.class;
    }

    @Override
    public Class<? extends GModelFactory> bindGModelFactory() {
        return RosGModelFactory.class;
    }

    @Override
    protected Class<? extends EMFModelState> bindGModelState() {
        return RosModelState.class;
    }

    @Override
    protected Class<? extends EMFIdGenerator> bindEMFIdGenerator() {
        return FragmentIdGenerator.class;
    }

    @Override
    protected Class<? extends LayoutEngine> bindLayoutEngine() {
        return RosLayoutEngine.class;
    }

    @Override
    protected Class<? extends ModelValidator> bindModelValidator() {
        return RosModelValidator.class;
    }

    @Override
    protected void configureAdditionals() {
        super.configureAdditionals();
        // Live validation on the dispatcher thread (see RosModelSubmissionHandler).
        bind(org.eclipse.glsp.server.features.core.model.ModelSubmissionHandler.class)
                .to(de.fraunhofer.ipa.ros.glsp.model.RosModelSubmissionHandler.class);
    }

    @Override
    protected void configureActionHandlers(final MultiBinding<ActionHandler> binding) {
        super.configureActionHandlers(binding);
        binding.add(RequestRosIndexActionHandler.class);
        binding.add(RequestRosTextEditsActionHandler.class);
    }

    @Override
    protected void configureOperationHandlers(final MultiBinding<OperationHandler<?>> binding) {
        super.configureOperationHandlers(binding);
        binding.add(CreateRosNodeOperationHandler.class);
        binding.add(CreateConnectionOperationHandler.class);
        binding.add(DeleteRosElementOperationHandler.class);
        binding.add(ReconnectConnectionOperationHandler.class);
        binding.add(EditRosPropertyOperationHandler.class);
        binding.add(ToggleSubSystemOperationHandler.class);
        binding.add(ChangeBoundsOperationHandler.class);
        binding.add(IgnoreRoutingPointsOperationHandler.class);
    }

    @Override
    public String getDiagramType() {
        return RosModelTypes.DIAGRAM_TYPE;
    }
}
