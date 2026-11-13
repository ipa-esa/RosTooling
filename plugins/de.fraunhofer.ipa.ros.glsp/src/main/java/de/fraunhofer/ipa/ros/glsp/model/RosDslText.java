package de.fraunhofer.ipa.ros.glsp.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import primitives.AbstractType;
import primitives.PrimitivesPackage;
import ros.ActionClient;
import ros.ActionServer;
import ros.ActionSpec;
import ros.ArrayTopicSpecMsgRef;
import ros.InterfaceType;
import ros.Parameter;
import ros.ParameterArrayType;
import ros.ParameterBase64Type;
import ros.ParameterBoolean;
import ros.ParameterBooleanType;
import ros.ParameterDouble;
import ros.ParameterDoubleType;
import ros.ParameterInteger;
import ros.ParameterIntegerType;
import ros.ParameterListType;
import ros.ParameterString;
import ros.ParameterStringType;
import ros.ParameterStructType;
import ros.ParameterType;
import ros.ParameterValue;
import ros.Publisher;
import ros.RosFactory;
import ros.ServiceClient;
import ros.ServiceServer;
import ros.ServiceSpec;
import ros.SpecBase;
import ros.Subscriber;
import ros.TopicSpec;
import ros.TopicSpecMsgRef;

/**
 * Canonical DSL text helpers shared by the GLSP operation handlers, the GModel factory and the
 * surgical serializer. This is NOT a parser: it only renders/creates the small token sequences
 * (type keywords, spec references, parameter literals) that the Xtext grammar defines, so the
 * Java server stays the single authority over .ros / .ros2 syntax.
 */
public final class RosDslText {

    private RosDslText() {}

    // ---------------------------------------------------------------------------------------
    // Interface kinds
    // ---------------------------------------------------------------------------------------

    /** Short kind code used by the webview/MCP (pub, sub, ss, sc, as, ac) or "param". */
    public static String kindCode(final EObject iface) {
        if (iface instanceof Publisher) return "pub";
        if (iface instanceof Subscriber) return "sub";
        if (iface instanceof ServiceServer) return "ss";
        if (iface instanceof ServiceClient) return "sc";
        if (iface instanceof ActionServer) return "as";
        if (iface instanceof ActionClient) return "ac";
        if (iface instanceof Parameter) return "param";
        return "";
    }

    /** The grammar section keyword that holds elements of the given kind. */
    public static String sectionKeyword(final EObject element) {
        if (element instanceof Publisher) return "publishers:";
        if (element instanceof Subscriber) return "subscribers:";
        if (element instanceof ServiceServer) return "serviceservers:";
        if (element instanceof ServiceClient) return "serviceclients:";
        if (element instanceof ActionServer) return "actionservers:";
        if (element instanceof ActionClient) return "actionclients:";
        if (element instanceof Parameter) return "parameters:";
        if (element instanceof ros.Artifact) return "artifacts:";
        if (element instanceof TopicSpec) return "msgs:";
        if (element instanceof ServiceSpec) return "srvs:";
        if (element instanceof ActionSpec) return "actions:";
        return null;
    }

    public static InterfaceType createInterface(final String kind) {
        switch (kind == null ? "" : kind.trim().toLowerCase()) {
            case "pub": case "publisher": return RosFactory.eINSTANCE.createPublisher();
            case "sub": case "subscriber": return RosFactory.eINSTANCE.createSubscriber();
            case "ss": case "serviceserver": return RosFactory.eINSTANCE.createServiceServer();
            case "sc": case "serviceclient": return RosFactory.eINSTANCE.createServiceClient();
            case "as": case "actionserver": return RosFactory.eINSTANCE.createActionServer();
            case "ac": case "actionclient": return RosFactory.eINSTANCE.createActionClient();
            default: return null;
        }
    }

    /** The cross-reference feature carrying an interface's spec ({@code type:} in the DSL). */
    public static EReference specFeature(final EObject iface) {
        if (iface == null) {
            return null;
        }
        for (String name : new String[] {"message", "service", "action"}) {
            EStructuralFeature f = iface.eClass().getEStructuralFeature(name);
            if (f instanceof EReference ref && !ref.isContainment()) {
                return ref;
            }
        }
        return null;
    }

    // ---------------------------------------------------------------------------------------
    // Spec references
    // ---------------------------------------------------------------------------------------

    public static String specCategory(final SpecBase spec) {
        if (spec instanceof ServiceSpec) return "srv";
        if (spec instanceof ActionSpec) return "action";
        return "msg";
    }

    public static String specFullName(final SpecBase spec) {
        if (spec == null || spec.eIsProxy()) {
            return "";
        }
        // Canonical ROS 2 form used by .ros2 'type:' references: <pkg>/<msg|srv|action>/<Name>.
        String pkg = spec.eContainer() instanceof ros.Package p ? p.getName() : null;
        if (pkg != null && spec.getName() != null) {
            return pkg + "/" + specCategory(spec) + "/" + spec.getName();
        }
        String full = spec.getFullname();
        return full != null && !full.isEmpty() ? full : nullToEmpty(spec.getName());
    }

    /**
     * Text of a (possibly unresolved or freshly created) cross-reference, unquoted:
     * hint -> resolved target name -> original source token text.
     */
    public static String refText(final RosModelState state, final EObject holder, final EReference feature) {
        String hint = state != null ? state.getRefTextHint(holder) : null;
        if (hint != null) {
            return hint;
        }
        if (holder == null || feature == null) {
            return "";
        }
        Object val = holder.eGet(feature, false);
        if (val instanceof EObject target && !target.eIsProxy()) {
            if (target instanceof SpecBase spec) {
                return specFullName(spec);
            }
        }
        List<INode> nodes = NodeModelUtils.findNodesForFeature(holder, feature);
        if (!nodes.isEmpty()) {
            return unquote(NodeModelUtils.getTokenText(nodes.get(0)).trim());
        }
        if (val instanceof EObject target && target instanceof SpecBase spec) {
            return specFullName(spec);
        }
        return "";
    }

    /** Looks up a spec in every loaded resource by full name ("pkg/msg/Name") or simple name. */
    public static Optional<SpecBase> findSpec(final ResourceSet rs, final String name, final Class<? extends SpecBase> kind) {
        if (rs == null || name == null || name.isBlank()) {
            return Optional.empty();
        }
        String wanted = unquote(name.trim());
        String simple = wanted.contains("/") ? wanted.substring(wanted.lastIndexOf('/') + 1) : wanted;
        SpecBase simpleMatch = null;
        for (Resource res : new ArrayList<>(rs.getResources())) {
            for (EObject root : res.getContents()) {
                var it = root.eAllContents();
                while (it.hasNext()) {
                    EObject obj = it.next();
                    if (obj instanceof SpecBase spec && (kind == null || kind.isInstance(spec))) {
                        if (wanted.equals(specFullName(spec))) {
                            return Optional.of(spec);
                        }
                        if (simpleMatch == null && simple.equals(spec.getName())
                                && (!wanted.contains("/") || wanted.startsWith(packageName(spec) + "/"))) {
                            simpleMatch = spec;
                        }
                    }
                }
            }
        }
        return Optional.ofNullable(simpleMatch);
    }

    public static Class<? extends SpecBase> specClassFor(final EObject iface) {
        if (iface instanceof Publisher || iface instanceof Subscriber) return TopicSpec.class;
        if (iface instanceof ServiceServer || iface instanceof ServiceClient) return ServiceSpec.class;
        if (iface instanceof ActionServer || iface instanceof ActionClient) return ActionSpec.class;
        return SpecBase.class;
    }

    private static String packageName(final SpecBase spec) {
        return spec.eContainer() instanceof ros.Package p ? nullToEmpty(p.getName()) : "";
    }

    // ---------------------------------------------------------------------------------------
    // Parameter types & values
    // ---------------------------------------------------------------------------------------

    /** DSL keyword for a parameter type (String, Integer, Double, Boolean, Base64, Array, List, Struct, Any). */
    public static String parameterTypeKeyword(final ParameterType pt) {
        if (pt == null) return "";
        if (pt instanceof ParameterStringType) return "String";
        if (pt instanceof ParameterIntegerType) return "Integer";
        if (pt instanceof ParameterDoubleType) return "Double";
        if (pt instanceof ParameterBooleanType) return "Boolean";
        if (pt instanceof ParameterBase64Type) return "Base64";
        if (pt instanceof ParameterArrayType) return "Array";
        if (pt instanceof ParameterListType) return "List";
        if (pt instanceof ParameterStructType) return "Struct";
        return pt.eClass().getName().replace("Parameter", "").replace("Type", "");
    }

    /** The {@code default:} value of a simple parameter type, or null. */
    public static ParameterValue parameterTypeDefault(final ParameterType pt) {
        if (pt == null) return null;
        EStructuralFeature f = pt.eClass().getEStructuralFeature("default");
        if (f == null) return null;
        Object v = pt.eGet(f);
        return v instanceof ParameterValue pv ? pv : null;
    }

    /**
     * Creates a simple parameter type with an optional default. Returns null for types that
     * cannot be created without further structure (Struct, List) or for unknown keywords.
     */
    public static ParameterType createParameterType(final String keyword, final String defaultRaw) {
        String kw = keyword == null ? "" : keyword.trim();
        String def = defaultRaw == null ? null : defaultRaw.trim();
        boolean hasDefault = def != null && !def.isEmpty();
        switch (kw.toLowerCase()) {
            case "string": {
                ParameterStringType t = RosFactory.eINSTANCE.createParameterStringType();
                if (hasDefault) {
                    ParameterString v = RosFactory.eINSTANCE.createParameterString();
                    v.setValue(unquote(defaultRaw.trim()));
                    t.setDefault(v);
                }
                return t;
            }
            case "integer": case "int": {
                ParameterIntegerType t = RosFactory.eINSTANCE.createParameterIntegerType();
                if (hasDefault) {
                    try {
                        ParameterInteger v = RosFactory.eINSTANCE.createParameterInteger();
                        v.setValue((int) Math.round(Double.parseDouble(def)));
                        t.setDefault(v);
                    } catch (NumberFormatException ignored) {
                        // keep without default
                    }
                }
                return t;
            }
            case "double": case "float": {
                ParameterDoubleType t = RosFactory.eINSTANCE.createParameterDoubleType();
                if (hasDefault) {
                    try {
                        ParameterDouble v = RosFactory.eINSTANCE.createParameterDouble();
                        v.setValue(Double.parseDouble(def));
                        t.setDefault(v);
                    } catch (NumberFormatException ignored) {
                        // keep without default
                    }
                }
                return t;
            }
            case "boolean": case "bool": {
                ParameterBooleanType t = RosFactory.eINSTANCE.createParameterBooleanType();
                if (hasDefault) {
                    ParameterBoolean v = RosFactory.eINSTANCE.createParameterBoolean();
                    v.setValue(Boolean.parseBoolean(def));
                    t.setDefault(v);
                }
                return t;
            }
            case "base64": case "byte":
                return RosFactory.eINSTANCE.createParameterBase64Type();
            case "array": {
                ParameterArrayType t = RosFactory.eINSTANCE.createParameterArrayType();
                t.setType(RosFactory.eINSTANCE.createParameterStringType());
                return t;
            }
            default:
                return null;
        }
    }

    /**
     * Renders a parameter type the way the grammar expects it. Multi-line output uses
     * {@code continuationIndent} for the {@code default:} line (same column as {@code type:}).
     * Returns null when the type is too complex to render (caller keeps the source text).
     */
    public static String renderParameterType(final ParameterType pt, final String continuationIndent) {
        if (pt == null) return null;
        if (pt instanceof ParameterStructType || pt instanceof ParameterListType) {
            return null;
        }
        if (pt instanceof ParameterArrayType arr) {
            String inner = renderParameterType(arr.getType(), continuationIndent);
            if (inner == null || inner.contains("\n")) return null;
            return "Array [ " + inner + " ]";
        }
        String kw = parameterTypeKeyword(pt);
        ParameterValue def = parameterTypeDefault(pt);
        if (def == null) {
            return kw;
        }
        return kw + "\n" + continuationIndent + "default: " + RosAstNodeModelSerializer.formatDslParameterValue(def);
    }

    // ---------------------------------------------------------------------------------------
    // Message field types (.ros MessagePart)
    // ---------------------------------------------------------------------------------------

    /** DSL text for a message field type: int32, string[], Header, 'pkg/msg/Pose', 'pkg/msg/Pose'[]. */
    public static String messagePartTypeText(final RosModelState state, final AbstractType type) {
        if (type == null) return "";
        String hint = state != null ? state.getRefTextHint(type) : null;
        if (hint != null) {
            return hint;
        }
        ICompositeNode node = NodeModelUtils.findActualNodeFor(type);
        if (node != null) {
            String raw = NodeModelUtils.getTokenText(node).trim();
            if (!raw.isEmpty()) {
                return raw;
            }
        }
        if (type instanceof TopicSpecMsgRef ref) {
            return "'" + specFullName(ref.getReference()) + "'";
        }
        if (type instanceof ArrayTopicSpecMsgRef ref) {
            return "'" + specFullName(ref.getReference()) + "'[]";
        }
        String cls = type.eClass().getName();
        switch (cls) {
            case "char0": return "char";
            case "Byte": return "byte";
            case "ByteArray": return "byte[]";
            case "Header": return "Header";
            default:
                return cls.endsWith("Array") ? cls.substring(0, cls.length() - "Array".length()) + "[]" : cls;
        }
    }

    /** Creates the EMF type object for a message field type string; unknown names become spec refs. */
    public static AbstractType createMessagePartType(final RosModelState state, final ResourceSet rs, final String typeText) {
        String raw = typeText == null ? "" : typeText.trim();
        boolean isArray = raw.endsWith("[]");
        String base = unquote(isArray ? raw.substring(0, raw.length() - 2).trim() : raw);
        String clsName;
        switch (base) {
            case "char": clsName = isArray ? "charArray" : "char0"; break;
            case "byte": clsName = isArray ? "ByteArray" : "Byte"; break;
            case "Header": clsName = isArray ? null : "Header"; break;
            default: clsName = isArray ? base + "Array" : base;
        }
        if (clsName != null && !base.contains("/")) {
            EClassifier cls = PrimitivesPackage.eINSTANCE.getEClassifier(clsName);
            if (cls instanceof EClass ec && !ec.isAbstract()
                    && PrimitivesPackage.Literals.ABSTRACT_TYPE.isSuperTypeOf(ec)) {
                return (AbstractType) EcoreUtil.create(ec);
            }
        }
        Optional<SpecBase> spec = findSpec(rs, base, TopicSpec.class);
        AbstractType created;
        if (isArray) {
            ArrayTopicSpecMsgRef ref = RosFactory.eINSTANCE.createArrayTopicSpecMsgRef();
            spec.ifPresent(s -> ref.setReference((TopicSpec) s));
            created = ref;
        } else {
            TopicSpecMsgRef ref = RosFactory.eINSTANCE.createTopicSpecMsgRef();
            spec.ifPresent(s -> ref.setReference((TopicSpec) s));
            created = ref;
        }
        if (state != null) {
            String refName = spec.map(RosDslText::specFullName).filter(n -> !n.isEmpty()).orElse(base);
            state.setRefTextHint(created, "'" + refName + "'" + (isArray ? "[]" : ""));
        }
        return created;
    }

    // ---------------------------------------------------------------------------------------
    // Namespaces (InterfaceType.namespace: Global/Relative/PrivateNamespace with GraphName parts)
    // ---------------------------------------------------------------------------------------

    /** DSL text of a namespace, e.g. {@code GlobalNamespace} or {@code RelativeNamespace [ GraphName ]}. */
    public static String renderNamespace(final ros.Namespace ns) {
        if (ns == null) {
            return "";
        }
        String kind = ns instanceof ros.GlobalNamespace ? "GlobalNamespace"
                : ns instanceof ros.PrivateNamespace ? "PrivateNamespace" : "RelativeNamespace";
        return ns.getParts().isEmpty() ? kind : kind + " [ " + String.join(" , ", ns.getParts()) + " ]";
    }

    /**
     * Creates the namespace EObject for a kind (Global/Relative/Private, case-insensitive, with or
     * without the "Namespace" suffix); keeps the parts of {@code previous}. Returns null to clear.
     */
    public static ros.Namespace createNamespace(final String kind, final ros.Namespace previous) {
        String k = kind == null ? "" : kind.trim().toLowerCase().replace("namespace", "");
        ros.Namespace ns;
        switch (k) {
            case "global": ns = RosFactory.eINSTANCE.createGlobalNamespace(); break;
            case "relative": ns = RosFactory.eINSTANCE.createRelativeNamespace(); break;
            case "private": ns = RosFactory.eINSTANCE.createPrivateNamespace(); break;
            default: return null;
        }
        if (previous != null) {
            ns.getParts().addAll(previous.getParts());
        }
        return ns;
    }

    // ---------------------------------------------------------------------------------------
    // Misc
    // ---------------------------------------------------------------------------------------

    public static String unquote(final String raw) {
        if (raw == null) return "";
        if (raw.length() >= 2
                && ((raw.startsWith("\"") && raw.endsWith("\"")) || (raw.startsWith("'") && raw.endsWith("'")))) {
            return raw.substring(1, raw.length() - 1);
        }
        return raw;
    }

    public static String nullToEmpty(final String s) {
        return s == null ? "" : s;
    }

    /** Quotes a DSL string literal with double quotes, escaping embedded quotes. */
    public static String quote(final String s) {
        return "\"" + nullToEmpty(s).replace("\\", "\\\\").replace("\"", "\\\"") + "\"";
    }
}
