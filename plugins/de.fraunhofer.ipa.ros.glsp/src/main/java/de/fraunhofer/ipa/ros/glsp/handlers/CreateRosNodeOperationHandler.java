package de.fraunhofer.ipa.ros.glsp.handlers;

import com.google.inject.Inject;
import de.fraunhofer.ipa.ros.glsp.RosModelTypes;
import de.fraunhofer.ipa.ros.glsp.model.RosModelState;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.edit.command.ChangeCommand;
import org.eclipse.glsp.graph.util.GraphUtil;
import org.eclipse.glsp.server.emf.EMFCreateOperationHandler;
import org.eclipse.glsp.server.operations.CreateNodeOperation;
import ros.Node;
import system.Process;
import system.RosNode;
import system.RossystemFactory;
import system.SubSystem;

/**
 * Handles CreateNodeOperation to add a system.RosNode, system.SubSystem, or system.Process
 * to the live Ecore AST via a TransactionalEditingDomain RecordingCommand.
 */
public class CreateRosNodeOperationHandler extends EMFCreateOperationHandler<CreateNodeOperation> {

    @Inject
    protected RosModelState rosModelState;

    public CreateRosNodeOperationHandler() {
        super(List.of(
                RosModelTypes.ROS_NODE,
                RosModelTypes.SUBSYSTEM_NODE,
                RosModelTypes.PROCESS_NODE));
    }

    @Override
    public Optional<Command> createCommand(final CreateNodeOperation operation) {
        Optional<system.System> sysOpt = rosModelState.getRosSystem();
        if (sysOpt.isEmpty()) {
            return doNothing();
        }
        system.System sys = sysOpt.get();
        Map<String, String> args = operation.getArgs();

        return Optional.of(new ChangeCommand(rosModelState.getSemanticResource()) {
            @Override
            protected void doExecute() {
                String typeId = operation.getElementTypeId();
                if (RosModelTypes.ROS_NODE.equals(typeId)) {
                    String nodeName = args != null && args.containsKey("nodeName")
                            ? args.get("nodeName")
                            : "new_node_" + (sys.getComponents().size() + 1);
                    String fromSpec = args != null ? args.get("from") : null;
                    String namespace = args != null ? args.get("namespace") : null;

                    RosNode newNode = RossystemFactory.eINSTANCE.createRosNode();
                    newNode.setName(nodeName);
                    if (namespace != null && !namespace.isBlank()) {
                        newNode.setNamespace(namespace.trim());
                    }
                    if (fromSpec != null && !fromSpec.isBlank() && rosModelState.getSemanticResource() != null) {
                        Optional<Node> originOpt = RosElementResolver.resolveOriginNode(
                                rosModelState.getSemanticResource().getResourceSet(),
                                fromSpec);
                        originOpt.ifPresent(newNode::setFrom);
                    }
                    sys.getComponents().add(newNode);

                    if (args != null && "true".equalsIgnoreCase(args.get("pinLocation"))
                            && operation.getLocation().isPresent()) {
                        rosModelState.setPinnedPosition(
                                nodeName,
                                GraphUtil.point(
                                        operation.getLocation().get().getX(),
                                        operation.getLocation().get().getY()));
                    }
                } else if (RosModelTypes.PROCESS_NODE.equals(typeId)) {
                    String procName = args != null && args.containsKey("processName")
                            ? args.get("processName")
                            : "process_" + (sys.getProcesses().size() + 1);
                    int threads = 1;
                    if (args != null && args.containsKey("threads")) {
                        try {
                            threads = Integer.parseInt(args.get("threads"));
                        } catch (NumberFormatException ignored) {
                            threads = 1;
                        }
                    }
                    Process proc = RossystemFactory.eINSTANCE.createProcess();
                    proc.setName(procName);
                    proc.setThreads(threads);
                    if (args != null && args.get("nodes") != null) {
                        for (String member : args.get("nodes").split(",")) {
                            RosElementResolver.findRosNode(sys, rosModelState.getSemanticResource(), member.trim())
                                    .filter(rn -> !proc.getComponents().contains(rn))
                                    .ifPresent(proc.getComponents()::add);
                        }
                    }
                    sys.getProcesses().add(proc);
                } else if (RosModelTypes.SUBSYSTEM_NODE.equals(typeId)) {
                    String sysName = args != null ? args.getOrDefault("system", args.get("subSystemName")) : null;
                    if (sysName == null || sysName.isBlank()) {
                        return;
                    }
                    SubSystem sub = RossystemFactory.eINSTANCE.createSubSystem();
                    if (rosModelState.getSemanticResource() != null) {
                        for (var res : new java.util.ArrayList<>(rosModelState.getSemanticResource().getResourceSet().getResources())) {
                            for (var root : res.getContents()) {
                                if (root instanceof system.System other && other != sys && sysName.equals(other.getName())) {
                                    sub.setSystem(other);
                                }
                            }
                        }
                    }
                    rosModelState.setRefTextHint(sub, sysName.trim());
                    sys.getComponents().add(sub);
                }
            }
        });
    }

    @Override
    public String getLabel() {
        return "Create ROS Component";
    }
}
