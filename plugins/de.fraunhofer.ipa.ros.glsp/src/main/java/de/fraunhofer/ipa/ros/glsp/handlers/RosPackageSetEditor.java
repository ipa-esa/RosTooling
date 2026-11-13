package de.fraunhofer.ipa.ros.glsp.handlers;

import de.fraunhofer.ipa.ros.glsp.model.RosDslText;
import de.fraunhofer.ipa.ros.glsp.model.RosModelState;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import primitives.AbstractType;
import primitives.MessagePart;
import primitives.PrimitivesFactory;
import ros.ActionSpec;
import ros.Artifact;
import ros.InterfaceType;
import ros.LifecycleState;
import ros.MessageDefinition;
import ros.Node;
import ros.Package;
import ros.Parameter;
import ros.ParameterType;
import ros.ParameterValue;
import ros.QualityOfService;
import ros.RosFactory;
import ros.ServiceSpec;
import ros.SpecBase;
import ros.TopicSpec;

/**
 * Applies {@code editRosProperty} operations to .ros2 / .ros1 / .ros {@code PackageSet} models.
 *
 * <p>All edits mutate the EMF AST only. Text is produced later by
 * {@link de.fraunhofer.ipa.ros.glsp.model.RosAstNodeModelSerializer}, which splices the affected
 * spans and leaves every other line (and its comments) untouched.
 *
 * <p>Supported properties per target element:
 * <ul>
 *   <li>Package: {@code name}, {@code fromGitRepo}, {@code addArtifact} (key=artifact name,
 *       value=node name), {@code duplicateArtifact} (key=artifact id/name, value=new name),
 *       {@code addSpec} (key=spec name, value=msg|srv|action)</li>
 *   <li>Artifact: {@code artifactName}/{@code name}; every Node property is forwarded to its node</li>
 *   <li>Node: {@code name}/{@code nodeName}, {@code isLifecycle}, {@code addInterface} (key=name,
 *       value=type, valueType=pub|sub|ss|sc|as|ac), {@code addParameter} (key=name, value=default,
 *       valueType=String|Integer|Double|Boolean|Base64|Array), {@code parameter} (key=name, value)</li>
 *   <li>Publisher/Subscriber/ServiceServer/...: {@code name}, {@code type}, {@code kind},
 *       {@code qos} (key=profile|history|depth|reliability|durability|liveliness|lease_duration|
 *       lifespan|deadline, empty value clears), {@code activeStates} (value=comma separated)</li>
 *   <li>Parameter: {@code name}, {@code type} (value or valueType), {@code default}, {@code value}</li>
 *   <li>Spec: {@code name}, {@code addField} (key=field name, value=field type,
 *       valueType=message|request|response|goal|result|feedback)</li>
 *   <li>MessagePart: {@code name}/{@code data}, {@code type}</li>
 * </ul>
 */
public final class RosPackageSetEditor {

    private RosPackageSetEditor() {}

    /** Returns true when the target belongs to a PackageSet model and the edit was handled. */
    public static boolean apply(
            final RosModelState state,
            final EObject target,
            final String prop,
            final String key,
            final String val,
            final String valType) {
        if (target instanceof Package pkg) {
            return applyPackage(state, pkg, prop, key, val);
        }
        if (target instanceof Artifact art) {
            if (is(prop, "name", "artifactName")) {
                art.setName(val);
                return true;
            }
            if (art.getNode() != null) {
                return applyNode(state, art.getNode(), prop, key, val, valType);
            }
            return false;
        }
        if (target instanceof Node node) {
            return applyNode(state, node, prop, key, val, valType);
        }
        if (target instanceof Parameter param) {
            return applyParameter(state, param, prop, val, valType);
        }
        if (target instanceof InterfaceType iface) {
            return applyInterface(state, iface, prop, key, val);
        }
        if (target instanceof SpecBase spec) {
            return applySpec(state, spec, prop, key, val, valType);
        }
        if (target instanceof MessagePart part) {
            return applyMessagePart(state, part, prop, val);
        }
        return false;
    }

    // ---------------------------------------------------------------------------------------

    private static boolean applyPackage(
            final RosModelState state, final Package pkg, final String prop, final String key, final String val) {
        if (is(prop, "name", "packageName")) {
            pkg.setName(val);
        } else if (is(prop, "fromGitRepo")) {
            pkg.setFromGitRepo(val == null || val.isBlank() ? null : val.trim());
            state.markDirty(pkg, "fromGitRepo");
        } else if (is(prop, "addArtifact")) {
            String artName = nonBlank(key, uniqueName(namesOf(pkg.getArtifact()), "node"));
            Artifact art = RosFactory.eINSTANCE.createArtifact();
            art.setName(artName);
            Node node = RosFactory.eINSTANCE.createNode();
            node.setName(nonBlank(val, artName));
            art.setNode(node);
            pkg.getArtifact().add(art);
        } else if (is(prop, "duplicateArtifact")) {
            Artifact source = findArtifact(state, pkg, key);
            if (source == null) {
                return true;
            }
            Artifact copy = EcoreUtil.copy(source);
            String newName = nonBlank(val, uniqueName(namesOf(pkg.getArtifact()), source.getName() + "_copy"));
            copy.setName(newName);
            if (copy.getNode() != null) {
                copy.getNode().setName(newName);
            }
            carryReferenceHints(state, source, copy);
            pkg.getArtifact().add(copy);
        } else if (is(prop, "addSpec")) {
            String kind = val == null ? "msg" : val.trim().toLowerCase();
            SpecBase spec = "srv".equals(kind) || "service".equals(kind)
                    ? RosFactory.eINSTANCE.createServiceSpec()
                    : "action".equals(kind)
                            ? RosFactory.eINSTANCE.createActionSpec()
                            : RosFactory.eINSTANCE.createTopicSpec();
            List<String> existing = new ArrayList<>();
            for (SpecBase s : pkg.getSpec()) {
                existing.add(s.getName());
            }
            spec.setName(nonBlank(key, uniqueName(existing, "NewSpec")));
            pkg.getSpec().add(spec);
        } else {
            return false;
        }
        return true;
    }

    private static boolean applyNode(
            final RosModelState state,
            final Node node,
            final String prop,
            final String key,
            final String val,
            final String valType) {
        if (is(prop, "name", "nodeName")) {
            node.setName(val);
        } else if (is(prop, "isLifecycle", "lifecycle")) {
            boolean lc = Boolean.parseBoolean(val == null ? "" : val.trim());
            node.setIsLifecycle(lc);
            state.markDirty(node, "isLifecycle");
            if (!lc) {
                for (InterfaceType iface : allInterfaces(node)) {
                    if (!iface.getActiveStates().isEmpty()) {
                        iface.getActiveStates().clear();
                        state.markDirty(iface, "activeStates");
                    }
                }
            }
        } else if (is(prop, "addInterface")) {
            InterfaceType iface = RosDslText.createInterface(valType);
            if (iface == null) {
                return true;
            }
            List<String> existing = new ArrayList<>();
            for (InterfaceType i : allInterfaces(node)) {
                existing.add(i.getName());
            }
            String prefix = iface instanceof ros.Publisher || iface instanceof ros.Subscriber
                    ? "topic"
                    : RosDslText.specClassFor(iface) == ServiceSpec.class ? "service" : "action";
            iface.setName(nonBlank(key, uniqueName(existing, prefix)));
            listFor(node, iface).add(iface);
            setInterfaceType(state, iface, nonBlank(val, defaultTypeFor(iface)));
        } else if (is(prop, "addParameter")) {
            List<String> existing = namesOfParams(node);
            Parameter param = RosFactory.eINSTANCE.createParameter();
            param.setName(nonBlank(key, uniqueName(existing, "param")));
            ParameterType pt = RosDslText.createParameterType(nonBlank(valType, "String"), val);
            param.setType(pt != null ? pt : RosDslText.createParameterType("String", val));
            node.getParameter().add(param);
        } else if (is(prop, "parameter") && key != null) {
            for (Parameter p : node.getParameter()) {
                if (key.equals(p.getName())) {
                    p.setValue(de.fraunhofer.ipa.ros.glsp.handlers.EditRosPropertyOperationHandler
                            .createTypedParameterValue(val, valType, p.getType()));
                    break;
                }
            }
        } else {
            return false;
        }
        return true;
    }

    private static boolean applyInterface(
            final RosModelState state, final InterfaceType iface, final String prop, final String key, final String val) {
        if (is(prop, "name", "interfaceName")) {
            iface.setName(val);
        } else if (is(prop, "type", "spec", "message", "service", "action")) {
            setInterfaceType(state, iface, val);
            state.markDirty(iface, "type");
        } else if (is(prop, "namespace", "ns")) {
            iface.setNamespace(RosDslText.createNamespace(val, iface.getNamespace()));
            state.markDirty(iface, "namespace");
        } else if (is(prop, "kind")) {
            changeInterfaceKind(state, iface, val);
        } else if (is(prop, "qos")) {
            applyQos(state, iface, key, val);
            state.markDirty(iface, "qos");
        } else if (is(prop, "activeStates", "active_in")) {
            iface.getActiveStates().clear();
            if (val != null) {
                for (String part : val.split("[,\\s\\[\\]]+")) {
                    LifecycleState st = lifecycleState(part);
                    if (st != null && !iface.getActiveStates().contains(st)) {
                        iface.getActiveStates().add(st);
                    }
                }
            }
            state.markDirty(iface, "activeStates");
        } else {
            return false;
        }
        return true;
    }

    private static boolean applyParameter(
            final RosModelState state, final Parameter param, final String prop, final String val, final String valType) {
        if (is(prop, "name")) {
            param.setName(val);
        } else if (is(prop, "type", "ptype")) {
            String keyword = nonBlank(valType, val);
            ParameterValue oldDefault = RosDslText.parameterTypeDefault(param.getType());
            String oldDefaultText = oldDefault == null ? null
                    : de.fraunhofer.ipa.ros.glsp.model.RosGModelFactory.formatParameterValue(oldDefault);
            ParameterType pt = RosDslText.createParameterType(keyword, oldDefaultText);
            if (pt != null) {
                param.setType(pt);
                state.markDirty(param, "type");
            }
        } else if (is(prop, "default")) {
            String keyword = RosDslText.parameterTypeKeyword(param.getType());
            ParameterType pt = RosDslText.createParameterType(keyword.isEmpty() ? "String" : keyword, val);
            if (pt != null) {
                param.setType(pt);
                state.markDirty(param, "type");
            }
        } else if (is(prop, "namespace", "ns")) {
            param.setNamespace(RosDslText.createNamespace(val, param.getNamespace()));
            state.markDirty(param, "namespace");
        } else if (is(prop, "value")) {
            param.setValue(EditRosPropertyOperationHandler.createTypedParameterValue(val, valType, param.getType()));
        } else {
            return false;
        }
        return true;
    }

    private static boolean applySpec(
            final RosModelState state,
            final SpecBase spec,
            final String prop,
            final String key,
            final String val,
            final String valType) {
        if (is(prop, "name")) {
            spec.setName(val);
        } else if (is(prop, "addField")) {
            MessageDefinition def = getOrCreateSection(spec, valType);
            if (def == null) {
                return true;
            }
            MessagePart part = PrimitivesFactory.eINSTANCE.createMessagePart();
            List<String> existing = new ArrayList<>();
            for (MessagePart p : def.getMessagePart()) {
                existing.add(p.getData());
            }
            part.setData(nonBlank(key, uniqueName(existing, "field")));
            part.setType(RosDslText.createMessagePartType(state, resourceSet(state), nonBlank(val, "string")));
            def.getMessagePart().add(part);
        } else {
            return false;
        }
        return true;
    }

    private static boolean applyMessagePart(
            final RosModelState state, final MessagePart part, final String prop, final String val) {
        if (is(prop, "name", "data")) {
            part.setData(val);
        } else if (is(prop, "type")) {
            AbstractType t = RosDslText.createMessagePartType(state, resourceSet(state), nonBlank(val, "string"));
            part.setType(t);
            state.markDirty(part, "type");
        } else {
            return false;
        }
        return true;
    }

    // ---------------------------------------------------------------------------------------

    /** Section names: TopicSpec=message; ServiceSpec=request|response; ActionSpec=goal|result|feedback. */
    public static MessageDefinition getOrCreateSection(final SpecBase spec, final String section) {
        String s = section == null ? "" : section.trim().toLowerCase();
        EStructuralFeature f;
        if (spec instanceof TopicSpec) {
            f = spec.eClass().getEStructuralFeature("message");
        } else if (spec instanceof ServiceSpec) {
            f = spec.eClass().getEStructuralFeature("response".equals(s) ? "response" : "request");
        } else if (spec instanceof ActionSpec) {
            f = spec.eClass().getEStructuralFeature(
                    "result".equals(s) ? "result" : "feedback".equals(s) ? "feedback" : "goal");
        } else {
            return null;
        }
        Object current = spec.eGet(f);
        if (current instanceof MessageDefinition def) {
            return def;
        }
        MessageDefinition def = RosFactory.eINSTANCE.createMessageDefinition();
        spec.eSet(f, def);
        return def;
    }

    private static void setInterfaceType(final RosModelState state, final InterfaceType iface, final String typeName) {
        EReference ref = RosDslText.specFeature(iface);
        if (ref == null) {
            return;
        }
        String name = RosDslText.unquote(typeName == null ? "" : typeName.trim());
        Optional<SpecBase> spec = RosDslText.findSpec(resourceSet(state), name, RosDslText.specClassFor(iface));
        if (spec.isPresent() && ref.getEReferenceType().isInstance(spec.get())) {
            iface.eSet(ref, spec.get());
        }
        state.setRefTextHint(iface, name);
    }

    private static void changeInterfaceKind(final RosModelState state, final InterfaceType iface, final String kind) {
        InterfaceType replacement = RosDslText.createInterface(kind);
        if (replacement == null || replacement.eClass() == iface.eClass() || !(iface.eContainer() instanceof Node node)) {
            return;
        }
        String typeText = RosDslText.refText(state, iface, RosDslText.specFeature(iface));
        replacement.setName(iface.getName());
        if (iface.getNamespace() != null) {
            replacement.setNamespace(EcoreUtil.copy(iface.getNamespace()));
        }
        if (iface.getQos() != null) {
            replacement.setQos(EcoreUtil.copy(iface.getQos()));
        }
        replacement.getActiveStates().addAll(iface.getActiveStates());
        EList<? extends InterfaceType> oldList = listFor(node, iface);
        oldList.remove(iface);
        listFor(node, replacement).add(replacement);
        boolean sameFamily = RosDslText.specClassFor(iface) == RosDslText.specClassFor(replacement);
        setInterfaceType(state, replacement, sameFamily ? typeText : defaultTypeFor(replacement));
    }

    /** DSL key -> EMF attribute name of {@code QualityOfService}, in grammar order. */
    public static final String[][] QOS_FIELDS = {
        {"profile", "QoSProfile"}, {"history", "History"}, {"depth", "Depth"}, {"reliability", "Reliability"},
        {"durability", "Durability"}, {"lease_duration", "LeaseDuration"}, {"liveliness", "Liveliness"},
        {"lifespan", "Lifespan"}, {"deadline", "Deadline"},
    };

    private static EStructuralFeature qosFeature(final String dslKey) {
        String k = dslKey == null ? "" : dslKey.trim().toLowerCase();
        if ("qosprofile".equals(k)) k = "profile";
        if ("leaseduration".equals(k)) k = "lease_duration";
        for (String[] f : QOS_FIELDS) {
            if (f[0].equals(k)) {
                return ros.RosPackage.Literals.QUALITY_OF_SERVICE.getEStructuralFeature(f[1]);
            }
        }
        return null;
    }

    /**
     * Value of an explicitly specified QoS field as DSL text, or null. Several QoS attributes have
     * ecore default values (e.g. reliability=reliable), and EMF reports a field holding its default
     * as "not set" - so a field also counts as specified when it is written in the source text or
     * was explicitly chosen in memory since the last save.
     */
    public static String qosValue(final RosModelState state, final QualityOfService q, final String dslKey) {
        EStructuralFeature f = qosFeature(dslKey);
        if (q == null || f == null) {
            return null;
        }
        String key = f.getName();
        if (state != null && state.isDirty(q, "unset:" + key)) {
            return null;
        }
        boolean specified = q.eIsSet(f)
                || (state != null && state.isDirty(q, "set:" + key))
                || !org.eclipse.xtext.nodemodel.util.NodeModelUtils.findNodesForFeature(q, f).isEmpty();
        if (!specified) {
            return null;
        }
        Object v = q.eGet(f);
        return v == null ? null : String.valueOf(v);
    }

    private static void applyQos(
            final RosModelState state, final InterfaceType iface, final String field, final String rawValue) {
        EStructuralFeature f = qosFeature(field);
        if (f == null) {
            return;
        }
        String v = rawValue == null ? "" : rawValue.trim();
        QualityOfService qos = iface.getQos();
        if (qos == null) {
            if (v.isEmpty()) {
                return;
            }
            qos = RosFactory.eINSTANCE.createQualityOfService();
            iface.setQos(qos);
        }
        if (v.isEmpty()) {
            qos.eUnset(f);
            state.clearDirty(qos, "set:" + f.getName());
            state.markDirty(qos, "unset:" + f.getName());
        } else {
            state.clearDirty(qos, "unset:" + f.getName());
            state.markDirty(qos, "set:" + f.getName());
        }
        if (v.isEmpty()) {
            // already unset above
        } else if (f.getEType().getInstanceClass() == int.class || f.getEType().getInstanceClass() == Integer.class) {
            try {
                qos.eSet(f, Integer.parseInt(v));
            } catch (NumberFormatException ignored) {
                // leave unchanged
            }
        } else {
            qos.eSet(f, v);
        }
        if (isEmpty(state, qos)) {
            iface.setQos(null);
        }
    }

    public static boolean isEmpty(final RosModelState state, final QualityOfService q) {
        if (q == null) {
            return true;
        }
        for (String[] f : QOS_FIELDS) {
            if (qosValue(state, q, f[0]) != null) {
                return false;
            }
        }
        return true;
    }

    private static LifecycleState lifecycleState(final String raw) {
        if (raw == null || raw.isBlank()) {
            return null;
        }
        for (LifecycleState st : LifecycleState.VALUES) {
            if (st.getLiteral().equalsIgnoreCase(raw.trim()) || st.getName().equalsIgnoreCase(raw.trim())) {
                return st;
            }
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public static EList<InterfaceType> listFor(final Node node, final EObject iface) {
        EStructuralFeature f;
        if (iface instanceof ros.Publisher) f = ros.RosPackage.Literals.NODE__PUBLISHER;
        else if (iface instanceof ros.Subscriber) f = ros.RosPackage.Literals.NODE__SUBSCRIBER;
        else if (iface instanceof ros.ServiceServer) f = ros.RosPackage.Literals.NODE__SERVICESERVER;
        else if (iface instanceof ros.ServiceClient) f = ros.RosPackage.Literals.NODE__SERVICECLIENT;
        else if (iface instanceof ros.ActionServer) f = ros.RosPackage.Literals.NODE__ACTIONSERVER;
        else if (iface instanceof ros.ActionClient) f = ros.RosPackage.Literals.NODE__ACTIONCLIENT;
        else f = ros.RosPackage.Literals.NODE__PARAMETER;
        return (EList<InterfaceType>) node.eGet(f);
    }

    public static List<InterfaceType> allInterfaces(final Node node) {
        List<InterfaceType> all = new ArrayList<>();
        all.addAll(node.getPublisher());
        all.addAll(node.getSubscriber());
        all.addAll(node.getServiceserver());
        all.addAll(node.getServiceclient());
        all.addAll(node.getActionserver());
        all.addAll(node.getActionclient());
        return all;
    }

    private static String defaultTypeFor(final InterfaceType iface) {
        Class<?> cls = RosDslText.specClassFor(iface);
        if (cls == ServiceSpec.class) return "std_srvs/srv/Trigger";
        if (cls == ActionSpec.class) return "action_tutorials_interfaces/action/Fibonacci";
        return "std_msgs/msg/String";
    }

    private static Artifact findArtifact(final RosModelState state, final Package pkg, final String idOrName) {
        if (idOrName == null) {
            return null;
        }
        Optional<EObject> byId = RosElementResolver.findByIdOrName(state, idOrName);
        if (byId.isPresent()) {
            EObject obj = byId.get();
            if (obj instanceof Artifact a) return a;
            if (obj instanceof Node n && n.eContainer() instanceof Artifact a) return a;
        }
        for (Artifact a : pkg.getArtifact()) {
            if (idOrName.equals(a.getName()) || (a.getNode() != null && idOrName.equals(a.getNode().getName()))) {
                return a;
            }
        }
        return null;
    }

    /** Copies reference text (from hints or the source node model) onto a deep copy's elements. */
    private static void carryReferenceHints(final RosModelState state, final EObject source, final EObject copy) {
        Iterator<EObject> srcIt = source.eAllContents();
        Iterator<EObject> cpyIt = copy.eAllContents();
        while (srcIt.hasNext() && cpyIt.hasNext()) {
            EObject s = srcIt.next();
            EObject c = cpyIt.next();
            EReference ref = RosDslText.specFeature(s);
            if (ref != null) {
                state.setRefTextHint(c, RosDslText.refText(state, s, ref));
            }
        }
    }

    private static ResourceSet resourceSet(final RosModelState state) {
        return state.getSemanticResource() != null ? state.getSemanticResource().getResourceSet() : null;
    }

    private static List<String> namesOf(final List<Artifact> artifacts) {
        List<String> names = new ArrayList<>();
        for (Artifact a : artifacts) {
            names.add(a.getName());
        }
        return names;
    }

    private static List<String> namesOfParams(final Node node) {
        List<String> names = new ArrayList<>();
        for (Parameter p : node.getParameter()) {
            names.add(p.getName());
        }
        return names;
    }

    private static String uniqueName(final List<String> existing, final String prefix) {
        if (!existing.contains(prefix) && !prefix.endsWith("_")) {
            // Use the prefix itself only when it is a full name (e.g. "<artifact>_copy").
            if (prefix.contains("_")) {
                return prefix;
            }
        }
        int idx = existing.size() + 1;
        String candidate = prefix + "_" + idx;
        while (existing.contains(candidate)) {
            idx++;
            candidate = prefix + "_" + idx;
        }
        return candidate;
    }

    private static boolean is(final String prop, final String... names) {
        for (String n : names) {
            if (n.equalsIgnoreCase(prop)) {
                return true;
            }
        }
        return false;
    }

    private static String nonBlank(final String v, final String fallback) {
        return v == null || v.isBlank() ? fallback : v.trim();
    }

    private static boolean blank(final String s) {
        return s == null || s.isBlank();
    }
}
