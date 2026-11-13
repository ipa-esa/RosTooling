package de.fraunhofer.ipa.ros.glsp.handlers;

import com.google.inject.Inject;
import de.fraunhofer.ipa.ros.glsp.model.RosModelState;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.ChangeCommand;
import org.eclipse.glsp.server.emf.EMFOperationHandler;
import org.eclipse.glsp.server.operations.DeleteOperation;
import system.Connection;
import system.Process;
import system.RosInterface;
import system.RosNode;
import system.RosParameter;
import system.RosSystemConnection;

/**
 * Handles DeleteOperation to cleanly remove RosNodes, RosInterfaces, RosParameters,
 * or RosSystemConnections from the live Ecore AST along with any dangling connections.
 */
public class DeleteRosElementOperationHandler extends EMFOperationHandler<DeleteOperation> {

    @Inject
    protected RosModelState rosModelState;

    @Override
    public Optional<Command> createCommand(final DeleteOperation operation) {
        if (operation.getElementIds() == null || operation.getElementIds().isEmpty()) {
            return doNothing();
        }
        if (rosModelState.isPackageModel()) {
            return Optional.of(new ChangeCommand(rosModelState.getSemanticResource()) {
                @Override
                protected void doExecute() {
                    for (String elementId : operation.getElementIds()) {
                        RosElementResolver.findByIdOrName(rosModelState, elementId).ifPresent(target -> {
                            EObject removable = target;
                            // Deleting a node contract removes its whole artifact block.
                            if (target instanceof ros.Node node && node.eContainer() instanceof ros.Artifact art) {
                                removable = art;
                            }
                            if (removable == rosModelState.getSemanticModel()) {
                                return; // never delete the file's root element
                            }
                            if (removable instanceof ros.Package
                                    || removable instanceof ros.Artifact
                                    || removable instanceof ros.InterfaceType
                                    || removable instanceof ros.Parameter
                                    || removable instanceof ros.SpecBase
                                    || removable instanceof primitives.MessagePart) {
                                EcoreUtil.remove(removable);
                            }
                        });
                    }
                }
            });
        }
        Optional<system.System> sysOpt = rosModelState.getRosSystem();
        if (sysOpt.isEmpty()) {
            return doNothing();
        }
        system.System sys = sysOpt.get();

        return Optional.of(new ChangeCommand(rosModelState.getSemanticResource()) {
            @Override
            protected void doExecute() {
                for (String elementId : operation.getElementIds()) {
                    Optional<EObject> targetOpt = RosElementResolver.findByIdOrName(rosModelState, elementId);
                    if (targetOpt.isEmpty()) {
                        continue;
                    }
                    EObject target = targetOpt.get();
                    if (target instanceof RosNode rn) {
                        List<Connection> dangling = new ArrayList<>();
                        for (Connection conn : sys.getConnections()) {
                            if (conn instanceof RosSystemConnection sc) {
                                if ((sc.getFrom() != null && sc.getFrom().eContainer() == rn)
                                        || (sc.getTo() != null && sc.getTo().eContainer() == rn)) {
                                    dangling.add(sc);
                                }
                            }
                        }
                        sys.getConnections().removeAll(dangling);
                        for (Process proc : sys.getProcesses()) {
                            proc.getComponents().remove(rn);
                        }
                        sys.getComponents().remove(rn);
                    } else if (target instanceof RosSystemConnection sc) {
                        sys.getConnections().remove(sc);
                    } else if (target instanceof RosInterface ri) {
                        List<Connection> dangling = new ArrayList<>();
                        for (Connection conn : sys.getConnections()) {
                            if (conn instanceof RosSystemConnection sc
                                    && (sc.getFrom() == ri || sc.getTo() == ri)) {
                                dangling.add(sc);
                            }
                        }
                        sys.getConnections().removeAll(dangling);
                        if (ri.eContainer() instanceof RosNode owner) {
                            owner.getRosinterfaces().remove(ri);
                        }
                    } else if (target instanceof RosParameter rp) {
                        if (rp.eContainer() instanceof RosNode owner) {
                            owner.getRosparameters().remove(rp);
                        }
                    } else if (target instanceof Process proc) {
                        sys.getProcesses().remove(proc);
                    } else if (target instanceof system.SubSystem subSys) {
                        sys.getComponents().remove(subSys);
                    }
                }
            }
        });
    }
}
