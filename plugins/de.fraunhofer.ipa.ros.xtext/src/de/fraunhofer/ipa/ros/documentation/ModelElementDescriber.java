package de.fraunhofer.ipa.ros.documentation;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import primitives.AbstractType;
import primitives.MessagePart;
import primitives.SizedArray;
import ros.ActionSpec;
import ros.Artifact;
import ros.InterfaceType;
import ros.MessageDefinition;
import ros.Node;
import ros.Package;
import ros.Parameter;
import ros.ServiceSpec;
import ros.SpecBase;
import ros.TopicSpec;

/**
 * Markdown descriptions of model elements for hover. Specific descriptions for the elements users
 * hover most (interface types, message/service/action specs, nodes, artifacts, parameters,
 * packages); every other named element gets a reflective summary of its set attributes and
 * references, so that no element answers with an empty hover.
 */
final class ModelElementDescriber {

    private static final int MAX_FIELDS = 25;

    private ModelElementDescriber() {
    }

    static String describe(final EObject o) {
        if (o == null || o.eIsProxy()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        if (o instanceof SpecBase spec) {
            describeSpec(spec, sb);
        } else if (o instanceof Artifact artifact) {
            sb.append("**Artifact** `").append(artifact.getName()).append("`");
            if (artifact.getNode() != null) {
                sb.append("\n\nRuns node `").append(artifact.getNode().getName()).append("`.");
                counts(artifact.getNode(), sb);
            }
        } else if (o instanceof Node node) {
            sb.append("**Node** `").append(node.getName()).append("`");
            if (node.isIsLifecycle()) {
                sb.append(" (lifecycle)");
            }
            counts(node, sb);
        } else if (o instanceof Package pkg) {
            sb.append("**Package** `").append(pkg.getName()).append("`");
            sb.append("\n\n").append(pkg.getArtifact().size()).append(" artifact(s), ")
                    .append(pkg.getSpec().size()).append(" interface definition(s).");
        } else if (o instanceof Parameter parameter) {
            sb.append("**Parameter** `").append(parameter.getName()).append("`");
            if (parameter.getType() != null) {
                sb.append("\n\nType: `").append(parameter.getType().eClass().getName()
                        .replace("Parameter", "").replace("Type", "")).append("`");
            }
        } else if (o instanceof InterfaceType iface) {
            describeInterface(iface, sb);
        } else {
            reflective(o, sb);
        }
        return sb.length() == 0 ? null : sb.toString();
    }

    private static void describeInterface(final InterfaceType iface, final StringBuilder sb) {
        sb.append("**").append(readable(iface.eClass().getName())).append("** `")
                .append(iface.getName()).append("`");
        for (EReference ref : iface.eClass().getEAllReferences()) {
            if (ref.isContainment() || ref.isMany()) {
                continue;
            }
            Object target = iface.eGet(ref);
            if (target instanceof SpecBase spec) {
                sb.append("\n\n").append(specKind(spec)).append(" type: `")
                        .append(reference(spec)).append("`");
                String fields = specFields(spec);
                if (!fields.isEmpty()) {
                    sb.append("\n\n").append(fields);
                }
            }
        }
    }

    private static void describeSpec(final SpecBase spec, final StringBuilder sb) {
        sb.append("**").append(specKind(spec)).append("** `").append(reference(spec)).append("`");
        String fields = specFields(spec);
        if (!fields.isEmpty()) {
            sb.append("\n\n").append(fields);
        }
    }

    /** The name used to reference the spec: {@code pkg/msg/Name}, {@code pkg/srv/Name} or {@code pkg/action/Name}. */
    static String reference(final SpecBase spec) {
        String kind = spec instanceof ServiceSpec ? "srv" : spec instanceof ActionSpec ? "action" : "msg";
        String pkg = spec.getPackage() != null ? spec.getPackage().getName() : null;
        return pkg == null ? spec.getName() : pkg + "/" + kind + "/" + spec.getName();
    }

    private static String specKind(final SpecBase spec) {
        if (spec instanceof ServiceSpec) {
            return "Service";
        }
        if (spec instanceof ActionSpec) {
            return "Action";
        }
        return "Message";
    }

    private static String specFields(final SpecBase spec) {
        StringBuilder sb = new StringBuilder();
        if (spec instanceof TopicSpec topic) {
            appendDefinition(null, topic.getMessage(), sb);
        } else if (spec instanceof ServiceSpec service) {
            appendDefinition("Request", service.getRequest(), sb);
            appendDefinition("Response", service.getResponse(), sb);
        } else if (spec instanceof ActionSpec action) {
            appendDefinition("Goal", action.getGoal(), sb);
            appendDefinition("Result", action.getResult(), sb);
            appendDefinition("Feedback", action.getFeedback(), sb);
        }
        return sb.toString().trim();
    }

    private static void appendDefinition(final String title, final MessageDefinition def, final StringBuilder sb) {
        if (def == null || def.getMessagePart().isEmpty()) {
            return;
        }
        if (title != null) {
            sb.append("\n**").append(title).append("**\n\n");
        }
        sb.append("```\n");
        EList<MessagePart> parts = def.getMessagePart();
        int shown = 0;
        for (MessagePart part : parts) {
            if (shown++ == MAX_FIELDS) {
                sb.append("... ").append(parts.size() - MAX_FIELDS).append(" more\n");
                break;
            }
            sb.append(typeName(part.getType())).append(' ').append(part.getData()).append('\n');
        }
        sb.append("```\n");
    }

    static String typeName(final AbstractType type) {
        if (type == null) {
            return "?";
        }
        if (type instanceof SizedArray array) {
            return typeName(array.getElement()) + (array.isBounded() ? "[<=" : "[") + array.getSize() + "]";
        }
        String name = type.eClass().getName();
        return name.endsWith("Array") && name.length() > 5
                ? name.substring(0, name.length() - 5) + "[]"
                : name;
    }

    private static void counts(final Node node, final StringBuilder sb) {
        List<String> parts = new ArrayList<>();
        count(parts, node.getPublisher().size(), "publisher");
        count(parts, node.getSubscriber().size(), "subscriber");
        count(parts, node.getServiceserver().size(), "service server");
        count(parts, node.getServiceclient().size(), "service client");
        count(parts, node.getActionserver().size(), "action server");
        count(parts, node.getActionclient().size(), "action client");
        count(parts, node.getParameter().size(), "parameter");
        if (!parts.isEmpty()) {
            sb.append("\n\n").append(String.join(", ", parts)).append(".");
        }
    }

    private static void count(final List<String> parts, final int n, final String what) {
        if (n > 0) {
            parts.add(n + " " + what + (n > 1 ? "s" : ""));
        }
    }

    /** Fallback: class name, name, set attributes and single-valued references. */
    private static void reflective(final EObject o, final StringBuilder sb) {
        EClass eClass = o.eClass();
        EStructuralFeature nameFeature = eClass.getEStructuralFeature("name");
        Object name = nameFeature != null && nameFeature.getEType().getInstanceClass() == String.class
                ? o.eGet(nameFeature) : null;
        if (name == null && eClass.getEAllAttributes().isEmpty() && eClass.getEAllReferences().isEmpty()) {
            return;
        }
        sb.append("**").append(readable(eClass.getName())).append("**");
        if (name != null) {
            sb.append(" `").append(name).append("`");
        }
        StringBuilder details = new StringBuilder();
        for (EAttribute attr : eClass.getEAllAttributes()) {
            if (attr == nameFeature || attr.isMany() || !o.eIsSet(attr)) {
                continue;
            }
            Object value = o.eGet(attr);
            if (value != null && !value.toString().isBlank()) {
                details.append("- ").append(attr.getName()).append(": `").append(value).append("`\n");
            }
        }
        for (EReference ref : eClass.getEAllReferences()) {
            if (ref.isContainment() || ref.isMany() || ref.isContainer() || !o.eIsSet(ref)) {
                continue;
            }
            Object target = o.eGet(ref, false);
            if (target instanceof EObject eo && !eo.eIsProxy()) {
                EStructuralFeature n = eo.eClass().getEStructuralFeature("name");
                Object tn = n != null ? eo.eGet(n) : null;
                if (eo instanceof SpecBase spec) {
                    tn = reference(spec);
                } else if (eo instanceof Node node && node.eContainer() instanceof Artifact
                        && node.eContainer().eContainer() instanceof Package pkg) {
                    tn = pkg.getName() + "." + node.getName();
                }
                if (tn != null) {
                    details.append("- ").append(ref.getName()).append(": `").append(tn).append("`\n");
                }
            }
        }
        if (details.length() > 0) {
            sb.append("\n\n").append(details.toString().trim());
        }
    }

    private static String readable(final String className) {
        String s = className.replaceFirst("^Ros(?=[A-Z])", "").replaceAll("([a-z])([A-Z])", "$1 $2");
        return s.isEmpty() ? s : Character.toUpperCase(s.charAt(0)) + s.substring(1);
    }
}
