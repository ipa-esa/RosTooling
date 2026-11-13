package de.fraunhofer.ipa.ros.glsp.handlers;

import com.google.inject.Inject;
import de.fraunhofer.ipa.ros.glsp.model.RosModelState;
import de.fraunhofer.ipa.ros.glsp.operations.EditRosPropertyOperation;
import java.util.Optional;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.ChangeCommand;
import org.eclipse.glsp.server.emf.EMFOperationHandler;
import ros.Artifact;
import ros.InterfaceType;
import ros.Node;
import ros.Package;
import ros.Parameter;
import ros.ParameterBoolean;
import ros.ParameterBooleanType;
import ros.ParameterDouble;
import ros.ParameterDoubleType;
import ros.ParameterInteger;
import ros.ParameterIntegerType;
import ros.ParameterString;
import ros.ParameterType;
import ros.ParameterValue;
import ros.RosFactory;
import system.RosInterface;
import system.RosNode;
import system.RosParameter;
import system.RossystemFactory;

/**
 * Handles EditRosPropertyOperation to mutate RosNode names, namespaces, parameter overrides,
 * interface remappings, and .ros2/.ros Package/Node/Parameter/Interface properties.
 */
public class EditRosPropertyOperationHandler extends EMFOperationHandler<EditRosPropertyOperation> {

    @Inject
    protected RosModelState rosModelState;

    @Override
    public Optional<Command> createCommand(final EditRosPropertyOperation operation) {
        if (operation.getElementId() == null || operation.getProperty() == null) {
            return doNothing();
        }
        return Optional.of(new ChangeCommand(rosModelState.getSemanticResource()) {
            @Override
            protected void doExecute() {
                Optional<EObject> targetOpt = RosElementResolver.findByIdOrName(
                        rosModelState, operation.getElementId());
                if (targetOpt.isEmpty()) {
                    return;
                }
                EObject target = targetOpt.get();
                String prop = operation.getProperty().trim();
                String key = operation.getKey() != null ? operation.getKey().trim() : null;
                String val = operation.getValue() != null ? operation.getValue() : "";
                String valType = operation.getValueType();

                if (rosModelState.isPackageModel()
                        && RosPackageSetEditor.apply(rosModelState, target, prop, key, val, valType)) {
                    return;
                }

                if (target instanceof system.System sys) {
                    if ("name".equalsIgnoreCase(prop) || "systemName".equalsIgnoreCase(prop)) {
                        sys.setName(val);
                    } else if ("fromFile".equalsIgnoreCase(prop)) {
                        sys.setFromFile(val);
                    }
                } else if (target instanceof system.Process proc) {
                    applyProcessEdit(proc, prop, key, val);
                } else if (target instanceof RosNode rn) {
                    applyRosNodeEdit(rn, prop, key, val, valType);
                } else if (target instanceof RosInterface ri) {
                    if ("name".equalsIgnoreCase(prop) || "interfaceName".equalsIgnoreCase(prop)) {
                        ri.setName(val);
                    }
                } else if (target instanceof RosParameter rp) {
                    if ("name".equalsIgnoreCase(prop)) {
                        rp.setName(val);
                    } else if ("value".equalsIgnoreCase(prop)) {
                        ParameterType pt = (rp.getFrom() != null && !rp.getFrom().eIsProxy())
                                ? rp.getFrom().getType()
                                : null;
                        rp.setValue(createTypedParameterValue(val, valType, pt));
                    }
                } else if (target instanceof Package pkg) {
                    if ("name".equalsIgnoreCase(prop) || "packageName".equalsIgnoreCase(prop)) {
                        pkg.setName(val);
                    } else if ("fromGitRepo".equalsIgnoreCase(prop)) {
                        pkg.setFromGitRepo(val);
                    }
                } else if (target instanceof Artifact art) {
                    if ("name".equalsIgnoreCase(prop) || "artifactName".equalsIgnoreCase(prop)) {
                        art.setName(val);
                    }
                } else if (target instanceof Node node) {
                    if ("name".equalsIgnoreCase(prop) || "nodeName".equalsIgnoreCase(prop)) {
                        node.setName(val);
                    } else if ("isLifecycle".equalsIgnoreCase(prop)) {
                        node.setIsLifecycle(Boolean.parseBoolean(val));
                    } else if ("parameter".equalsIgnoreCase(prop) && key != null) {
                        for (Parameter p : node.getParameter()) {
                            if (key.equals(p.getName())) {
                                p.setValue(createTypedParameterValue(val, valType, p.getType()));
                                break;
                            }
                        }
                    }
                } else if (target instanceof Parameter param) {
                    if ("name".equalsIgnoreCase(prop)) {
                        param.setName(val);
                    } else if ("value".equalsIgnoreCase(prop)) {
                        param.setValue(createTypedParameterValue(val, valType, param.getType()));
                    }
                } else if (target instanceof InterfaceType ifType) {
                    if ("name".equalsIgnoreCase(prop)) {
                        ifType.setName(val);
                    }
                }
            }
        });
    }

    /**
     * Process (composable node container) properties: {@code name}, {@code threads},
     * {@code nodes} (comma-separated member names/ids, replaces the list), {@code addNode} and
     * {@code removeNode} (value = member name or id).
     */
    protected void applyProcessEdit(final system.Process proc, final String prop, final String key, final String val) {
        system.System sys = rosModelState.getRosSystem().orElse(null);
        if ("name".equalsIgnoreCase(prop) || "processName".equalsIgnoreCase(prop)) {
            proc.setName(val.trim());
        } else if ("threads".equalsIgnoreCase(prop)) {
            try {
                proc.setThreads(Math.max(1, Integer.parseInt(val.trim())));
            } catch (NumberFormatException ignored) {
                // leave unchanged
            }
        } else if (sys != null && "nodes".equalsIgnoreCase(prop)) {
            proc.getComponents().clear();
            for (String member : val.split(",")) {
                if (!member.isBlank()) {
                    RosElementResolver.findRosNode(sys, rosModelState.getSemanticResource(), member.trim())
                            .filter(rn -> !proc.getComponents().contains(rn))
                            .ifPresent(proc.getComponents()::add);
                }
            }
        } else if (sys != null && "addNode".equalsIgnoreCase(prop)) {
            RosElementResolver.findRosNode(sys, rosModelState.getSemanticResource(), nonNull(key, val).trim())
                    .filter(rn -> !proc.getComponents().contains(rn))
                    .ifPresent(proc.getComponents()::add);
        } else if (sys != null && "removeNode".equalsIgnoreCase(prop)) {
            RosElementResolver.findRosNode(sys, rosModelState.getSemanticResource(), nonNull(key, val).trim())
                    .ifPresent(proc.getComponents()::remove);
        }
    }

    private static String nonNull(final String a, final String b) {
        return a != null && !a.isBlank() ? a : b;
    }

    protected void applyRosNodeEdit(
            final RosNode rn,
            final String prop,
            final String key,
            final String val,
            final String valType) {
        if ("name".equalsIgnoreCase(prop) || "nodeName".equalsIgnoreCase(prop)) {
            rn.setName(val);
        } else if ("namespace".equalsIgnoreCase(prop)) {
            rn.setNamespace(val);
        } else if ("from".equalsIgnoreCase(prop) && rosModelState.getSemanticResource() != null) {
            RosElementResolver.resolveOriginNode(
                    rosModelState.getSemanticResource().getResourceSet(), val)
                    .ifPresent(rn::setFrom);
        } else if ("parameter".equalsIgnoreCase(prop) && key != null && !key.isEmpty()) {
            RosParameter targetParam = null;
            for (RosParameter existing : rn.getRosparameters()) {
                if (key.equals(existing.getName())) {
                    targetParam = existing;
                    break;
                }
            }
            Optional<Parameter> originParamOpt = RosElementResolver.findOriginParameter(rn, key);
            if (targetParam == null) {
                targetParam = RossystemFactory.eINSTANCE.createRosParameter();
                targetParam.setName(key);
                originParamOpt.ifPresent(targetParam::setFrom);
                rn.getRosparameters().add(targetParam);
            }
            ParameterType pt = originParamOpt.map(Parameter::getType).orElse(null);
            targetParam.setValue(createTypedParameterValue(val, valType, pt));
        } else if (("interfaceName".equalsIgnoreCase(prop) || "remap".equalsIgnoreCase(prop))
                && key != null && !key.isEmpty()) {
            for (RosInterface ri : rn.getRosinterfaces()) {
                if (key.equals(ri.getName())) {
                    ri.setName(val);
                    return;
                }
            }
            RosElementResolver.getOrCreateInterfaceOnNode(rn, val, key, null);
        }
    }

    public static ParameterValue createTypedParameterValue(
            final String rawVal,
            final String explicitType,
            final ParameterType originType) {
        String typeHint = explicitType != null ? explicitType.trim().toLowerCase() : "";
        if (typeHint.isEmpty() && originType != null) {
            if (originType instanceof ParameterIntegerType) {
                typeHint = "integer";
            } else if (originType instanceof ParameterDoubleType) {
                typeHint = "double";
            } else if (originType instanceof ParameterBooleanType) {
                typeHint = "boolean";
            } else {
                typeHint = "string";
            }
        }

        if ("integer".equals(typeHint) || "int".equals(typeHint)) {
            try {
                ParameterInteger pi = RosFactory.eINSTANCE.createParameterInteger();
                pi.setValue(Integer.parseInt(rawVal.trim()));
                return pi;
            } catch (NumberFormatException ignored) {
                // Fall through to string
            }
        } else if ("double".equals(typeHint) || "float".equals(typeHint)) {
            try {
                ParameterDouble pd = RosFactory.eINSTANCE.createParameterDouble();
                pd.setValue(Double.parseDouble(rawVal.trim()));
                return pd;
            } catch (NumberFormatException ignored) {
                // Fall through to string
            }
        } else if ("boolean".equals(typeHint) || "bool".equals(typeHint)) {
            ParameterBoolean pb = RosFactory.eINSTANCE.createParameterBoolean();
            pb.setValue(Boolean.parseBoolean(rawVal.trim()));
            return pb;
        }

        // Auto-infer if no typeHint was provided
        if (typeHint.isEmpty()) {
            String trimmed = rawVal.trim();
            if ("true".equalsIgnoreCase(trimmed) || "false".equalsIgnoreCase(trimmed)) {
                ParameterBoolean pb = RosFactory.eINSTANCE.createParameterBoolean();
                pb.setValue(Boolean.parseBoolean(trimmed));
                return pb;
            }
            try {
                if (trimmed.matches("-?\\d+")) {
                    ParameterInteger pi = RosFactory.eINSTANCE.createParameterInteger();
                    pi.setValue(Integer.parseInt(trimmed));
                    return pi;
                }
                if (trimmed.matches("-?\\d+\\.\\d+")) {
                    ParameterDouble pd = RosFactory.eINSTANCE.createParameterDouble();
                    pd.setValue(Double.parseDouble(trimmed));
                    return pd;
                }
            } catch (NumberFormatException ignored) {
                // Fall through
            }
        }

        ParameterString ps = RosFactory.eINSTANCE.createParameterString();
        ps.setValue(rawVal);
        return ps;
    }
}
