package de.fraunhofer.ipa.ros.glsp.handlers;

import com.google.inject.Inject;
import de.fraunhofer.ipa.ros.glsp.model.RosAutoConnector;
import de.fraunhofer.ipa.ros.glsp.model.RosAutoConnector.Candidate;
import de.fraunhofer.ipa.ros.glsp.model.RosAutoConnector.Endpoint;
import de.fraunhofer.ipa.ros.glsp.model.RosModelState;
import de.fraunhofer.ipa.ros.glsp.operations.ApplyRosAutoConnectOperation;
import java.util.List;
import java.util.Optional;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.edit.command.ChangeCommand;
import org.eclipse.glsp.server.emf.EMFIdGenerator;
import org.eclipse.glsp.server.emf.EMFOperationHandler;
import system.RosInterface;
import system.RosSystemConnection;
import system.RossystemFactory;

/**
 * Adds the selected auto-connect candidates as one command (one undo step / one WorkspaceEdit).
 * The candidates are recomputed here and the selection is judged by
 * {@link RosAutoConnector#validateSelection}: unknown or stale ids are ignored, a service/action
 * client with more than one selected server gets none, a topic subscriber gets every selected
 * publisher. The operation returns nothing; clients re-run the dry run to show the result.
 */
public class ApplyRosAutoConnectOperationHandler extends EMFOperationHandler<ApplyRosAutoConnectOperation> {

    @Inject
    protected RosModelState rosModelState;

    @Inject
    protected EMFIdGenerator idGenerator;

    @Override
    public Optional<Command> createCommand(final ApplyRosAutoConnectOperation operation) {
        Optional<system.System> sysOpt = rosModelState.getRosSystem();
        if (sysOpt.isEmpty() || operation.getSelected() == null || operation.getSelected().isEmpty()) {
            return doNothing();
        }
        system.System sys = sysOpt.get();
        List<Candidate> chosen = RosAutoConnector.validateSelection(RosAutoConnector.propose(sys, List.of(),
                RequestRosAutoConnectActionHandler.elementIds(idGenerator), id -> false),
                operation.getSelected()).accepted;
        if (chosen.isEmpty()) {
            return doNothing();
        }
        return Optional.of(new ChangeCommand(rosModelState.getSemanticResource()) {
            @Override
            protected void doExecute() {
                for (Candidate c : chosen) {
                    RosInterface from = interfaceFor(c.emitter);
                    RosInterface to = interfaceFor(c.receiver);
                    if (from == null || to == null) {
                        continue;
                    }
                    RosSystemConnection conn = RossystemFactory.eINSTANCE.createRosSystemConnection();
                    conn.setFrom(from);
                    conn.setTo(to);
                    sys.getConnections().add(conn);
                }
            }
        });
    }

    /** Existing interface, or a root node's inherited port promoted to an explicit interface. */
    private static RosInterface interfaceFor(final Endpoint ep) {
        if (ep.explicit != null) {
            return ep.explicit;
        }
        return RosElementResolver.getOrCreateInterfaceOnNode(ep.node, ep.name, ep.originName, ep.portType);
    }

    @Override
    public String getLabel() {
        return "Auto-connect";
    }
}
