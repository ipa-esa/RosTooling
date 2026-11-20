package de.fraunhofer.ipa.ros.glsp.handlers;

import de.fraunhofer.ipa.ros.glsp.model.SlotAttachments;
import de.fraunhofer.ipa.ros.glsp.RosModelTypes;
import de.fraunhofer.ipa.ros.glsp.model.RosModelState;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import ros.ActionClient;
import ros.ActionServer;
import ros.Artifact;
import ros.InterfaceHolder;
import ros.InterfaceType;
import ros.Node;
import ros.Package;
import ros.Parameter;
import ros.Plugin;
import ros.Publisher;
import ros.ServiceClient;
import ros.ServiceServer;
import ros.SpecBase;
import ros.Subscriber;
import system.Component;
import system.Connection;
import system.InterfaceReference;
import system.RosActionClientReference;
import system.RosActionServerReference;
import system.RosInterface;
import system.RosNode;
import system.RosPublisherReference;
import system.RosServiceClientReference;
import system.RosServiceServerReference;
import system.RosSubscriberReference;
import system.RosSystemConnection;
import system.RossystemFactory;

/**
 * Shared EMF element resolution and interface port creation helper for GLSP OperationHandlers.
 */
public final class RosElementResolver {

    private RosElementResolver() {}

    public static Optional<EObject> findByIdOrName(final RosModelState modelState, final String idOrName) {
        if (idOrName == null || idOrName.isBlank()) {
            return Optional.empty();
        }
        Resource res = modelState.getSemanticResource();
        int scopeIdx = idOrName.indexOf(de.fraunhofer.ipa.ros.glsp.model.RosGModelFactory.SCOPE_SEPARATOR + "//");
        if (res != null && scopeIdx > 0) {
            // "<subsystem element id>::<fragment in the subsystem's resource>"
            try {
                EObject scope = res.getEObject(idOrName.substring(0, scopeIdx));
                if (scope instanceof system.SubSystem sub && sub.getSystem() != null && sub.getSystem().eResource() != null) {
                    EObject inner = sub.getSystem().eResource().getEObject(idOrName.substring(scopeIdx + 2));
                    if (inner != null) {
                        return Optional.of(inner);
                    }
                }
            } catch (Exception ignored) {
                // fall through
            }
        }
        if (res != null) {
            try {
                EObject byFragment = res.getEObject(idOrName);
                if (byFragment != null) {
                    return Optional.of(byFragment);
                }
            } catch (Exception ignored) {
                // Not a valid EMF URI fragment; fall through to semantic name lookup
            }
        }
        EObject root = modelState.getSemanticModel();
        if (root == null) {
            return Optional.empty();
        }
        if (root instanceof system.System sys) {
            if (idOrName.equals(sys.getName()) || "root".equals(idOrName)) {
                return Optional.of(sys);
            }
            for (Component comp : sys.getComponents()) {
                if (comp instanceof RosNode rn) {
                    if (idOrName.equals(rn.getName())) {
                        return Optional.of(rn);
                    }
                    for (RosInterface ri : rn.getRosinterfaces()) {
                        if (idOrName.equals(ri.getName())
                                || idOrName.equals(rn.getName() + "." + ri.getName())
                                || idOrName.equals(rn.getName() + "/" + ri.getName())) {
                            return Optional.of(ri);
                        }
                    }
                }
            }
            for (system.Process proc : sys.getProcesses()) {
                if (idOrName.equals(proc.getName())) {
                    return Optional.of(proc);
                }
            }
            for (Component comp : sys.getComponents()) {
                if (comp instanceof system.SubSystem sub && sub.getSystem() != null
                        && idOrName.equals(sub.getSystem().getName())) {
                    return Optional.of(sub);
                }
            }
            for (Connection conn : sys.getConnections()) {
                if (conn instanceof RosSystemConnection sc) {
                    String fromName = sc.getFrom() != null ? sc.getFrom().getName() : "";
                    String toName = sc.getTo() != null ? sc.getTo().getName() : "";
                    if (idOrName.equals(fromName + "->" + toName)) {
                        return Optional.of(sc);
                    }
                }
            }
        }
        if (modelState.isPackageModel()) {
            if ("root".equals(idOrName)) {
                if (root instanceof ros.Package) {
                    return Optional.of(root);
                }
                List<ros.Package> pkgs = modelState.getPackageModelPackages();
                if (!pkgs.isEmpty()) {
                    return Optional.of(pkgs.get(0));
                }
            }
            Optional<EObject> byName = findInPackages(modelState.getPackageModelPackages(), idOrName);
            if (byName.isPresent()) {
                return byName;
            }
        }
        TreeIterator<EObject> it = root.eAllContents();
        while (it.hasNext()) {
            EObject obj = it.next();
            String frag = EcoreUtil.getURI(obj).fragment();
            if (idOrName.equals(frag)) {
                return Optional.of(obj);
            }
        }
        return Optional.empty();
    }

    /**
     * Semantic name lookup inside .ros2/.ros1/.ros models: package name, artifact name, node name,
     * {@code <artifact|node>.<interface|parameter>}, spec name or full name, and
     * {@code <spec>.<field>}.
     */
    private static Optional<EObject> findInPackages(final List<ros.Package> packages, final String idOrName) {
        String head = idOrName;
        String tail = null;
        int sep = Math.max(idOrName.lastIndexOf('.'), idOrName.lastIndexOf('/'));
        if (sep > 0 && sep < idOrName.length() - 1) {
            head = idOrName.substring(0, sep);
            tail = idOrName.substring(sep + 1);
        }
        for (ros.Package pkg : packages) {
            if (idOrName.equals(pkg.getName())) {
                return Optional.of(pkg);
            }
            for (ros.Artifact art : pkg.getArtifact()) {
                ros.Node node = art.getNode();
                boolean artMatch = idOrName.equals(art.getName());
                boolean nodeMatch = node != null && idOrName.equals(node.getName());
                if (artMatch) {
                    return Optional.of(art);
                }
                if (nodeMatch) {
                    return Optional.of(node);
                }
                if (tail != null && node != null && (head.equals(art.getName()) || head.equals(node.getName()))) {
                    for (ros.InterfaceType iface : RosPackageSetEditor.allInterfaces(node)) {
                        if (tail.equals(iface.getName())) {
                            return Optional.of(iface);
                        }
                    }
                    for (ros.Parameter p : node.getParameter()) {
                        if (tail.equals(p.getName())) {
                            return Optional.of(p);
                        }
                    }
                }
                for (Plugin pl : art.getPlugins()) {
                    if (idOrName.equals(pl.getName())) {
                        return Optional.of(pl);
                    }
                    if (tail != null && (head.equals(art.getName()) || head.equals(pl.getName()))) {
                        for (ros.InterfaceType iface : RosPackageSetEditor.allInterfaces(pl)) {
                            if (tail.equals(iface.getName())) {
                                return Optional.of(iface);
                            }
                        }
                        for (ros.Parameter p : pl.getParameter()) {
                            if (tail.equals(p.getName())) {
                                return Optional.of(p);
                            }
                        }
                    }
                }
            }
            for (ros.SpecBase spec : pkg.getSpec()) {
                if (idOrName.equals(spec.getName())
                        || idOrName.equals(de.fraunhofer.ipa.ros.glsp.model.RosDslText.specFullName(spec))) {
                    return Optional.of(spec);
                }
                if (tail != null && head.equals(spec.getName())) {
                    var it = spec.eAllContents();
                    while (it.hasNext()) {
                        EObject obj = it.next();
                        if (obj instanceof primitives.MessagePart part && tail.equals(part.getData())) {
                            return Optional.of(part);
                        }
                    }
                }
            }
        }
        return Optional.empty();
    }

    public static Optional<RosNode> findRosNode(final system.System sys, final Resource res, final String idOrName) {
        if (sys == null || idOrName == null) {
            return Optional.empty();
        }
        if (res != null) {
            try {
                EObject obj = res.getEObject(idOrName);
                if (obj instanceof RosNode rn) {
                    return Optional.of(rn);
                }
            } catch (Exception ignored) {
                // Fall through
            }
        }
        for (Component comp : sys.getComponents()) {
            if (comp instanceof RosNode rn && idOrName.equals(rn.getName())) {
                return Optional.of(rn);
            }
        }
        return Optional.empty();
    }

    /**
     * Resolves a catalog/workspace ros.Node from a qualified name ("pkg.artifact.node" or "pkg.node" or "node").
     */
    public static Optional<Node> resolveOriginNode(final ResourceSet resourceSet, final String fromSpec) {
        if (resourceSet == null || fromSpec == null || fromSpec.isBlank()) {
            return Optional.empty();
        }
        String clean = fromSpec.trim().replace("\"", "");
        for (Resource res : resourceSet.getResources()) {
            TreeIterator<EObject> it = res.getAllContents();
            while (it.hasNext()) {
                EObject obj = it.next();
                if (obj instanceof Node node && node.getName() != null) {
                    String artName = (node.eContainer() instanceof Artifact art) ? art.getName() : "";
                    String pkgName = (node.eContainer() != null && node.eContainer().eContainer() instanceof Package pkg)
                            ? pkg.getName()
                            : "";
                    String fullQualified = (!pkgName.isEmpty() && !artName.isEmpty())
                            ? pkgName + "." + artName + "." + node.getName()
                            : "";
                    String shortQualified = (!pkgName.isEmpty())
                            ? pkgName + "." + node.getName()
                            : "";
                    if (clean.equals(fullQualified)
                            || clean.equals(shortQualified)
                            || clean.equals(artName + "::" + node.getName())
                            || clean.equals(node.getName())) {
                        return Optional.of(node);
                    }
                }
            }
        }
        return Optional.empty();
    }

    /**
     * Resolves a catalog/workspace {@link Plugin} from a qualified name ("pkg.plugin" or "plugin").
     */
    public static Optional<Plugin> resolveOriginPlugin(final ResourceSet resourceSet, final String pluginSpec) {
        if (resourceSet == null || pluginSpec == null || pluginSpec.isBlank()) {
            return Optional.empty();
        }
        String clean = pluginSpec.trim().replace("\"", "");
        for (Resource res : resourceSet.getResources()) {
            TreeIterator<EObject> it = res.getAllContents();
            while (it.hasNext()) {
                EObject obj = it.next();
                if (obj instanceof Plugin pl && pl.getName() != null) {
                    String artName = (pl.eContainer() instanceof Artifact art) ? art.getName() : "";
                    String pkgName = (pl.eContainer() != null && pl.eContainer().eContainer() instanceof Package pkg)
                            ? pkg.getName()
                            : "";
                    String fullQualified = (!pkgName.isEmpty() && !artName.isEmpty())
                            ? pkgName + "." + artName + "." + pl.getName()
                            : "";
                    String shortQualified = (!pkgName.isEmpty())
                            ? pkgName + "." + pl.getName()
                            : "";
                    if (clean.equals(fullQualified)
                            || clean.equals(shortQualified)
                            || clean.equals(artName + "::" + pl.getName())
                            || clean.equals(pl.getName())) {
                        return Optional.of(pl);
                    }
                }
            }
        }
        return Optional.empty();
    }

    /**
     * Resolves an existing RosInterface or promotes an inherited port on a RosNode into an explicit RosInterface.
     * Supports:
     * 1. EMF fragment ID of an existing RosInterface (e.g. "//@components.0/@rosinterfaces.0")
     * 2. Synthetic inherited port ID ("<nodeId>__port__<pub|sub|ss|sc|as|ac>__<originName>")
     * 3. Semantic "nodeName.interfaceName", "nodeName/interfaceName", or "interfaceName"
     */
    public static Optional<RosInterface> resolveOrCreateRosInterface(
            final RosModelState modelState,
            final system.System sys,
            final String portIdentifier) {
        if (sys == null || portIdentifier == null || portIdentifier.isBlank()) {
            return Optional.empty();
        }
        Resource res = modelState.getSemanticResource();

        // Case 0a: scoped diagram id of an element inside a subsystem ("<subsystem id>::<fragment>").
        // Interfaces of other files are only resolved, never created: an inherited port there would
        // need an edit of the subsystem's own file.
        if (portIdentifier.contains(de.fraunhofer.ipa.ros.glsp.model.RosGModelFactory.SCOPE_SEPARATOR + "/")) {
            if (portIdentifier.contains("__port__")) {
                return Optional.empty();
            }
            return findByIdOrName(modelState, portIdentifier)
                    .filter(RosInterface.class::isInstance)
                    .map(RosInterface.class::cast);
        }

        // Case 0b: qualified path "node::iface" or "sub::[...::]node::iface" (RosSystemScopeProvider names)
        if (portIdentifier.contains("::")) {
            return resolveQualifiedInterface(sys, res, portIdentifier);
        }

        // Case 1: Synthetic inherited port ID "<nodeId>__port__<kind>__<originName>"
        int markerIdx = portIdentifier.indexOf("__port__");
        if (markerIdx > 0) {
            String nodeId = portIdentifier.substring(0, markerIdx);
            String rest = portIdentifier.substring(markerIdx + "__port__".length());
            int sepIdx = rest.indexOf("__");
            if (sepIdx > 0) {
                String kindShort = rest.substring(0, sepIdx);
                String originName = rest.substring(sepIdx + 2);
                Optional<RosNode> nodeOpt = findRosNode(sys, res, nodeId);
                if (nodeOpt.isPresent()) {
                    return Optional.ofNullable(getOrCreateInterfaceOnNode(nodeOpt.get(), originName, originName, kindShort));
                }
            }
        }

        // Case 2: Direct EMF fragment lookup
        if (res != null) {
            try {
                EObject obj = res.getEObject(portIdentifier);
                if (obj instanceof RosInterface ri) {
                    return Optional.of(ri);
                }
            } catch (Exception ignored) {
                // Fall through
            }
        }

        // Case 3: Semantic "nodeName.portName" or "nodeName/portName"
        String nodePart = null;
        String portPart = portIdentifier;
        int dotIdx = portIdentifier.indexOf('.');
        int slashIdx = portIdentifier.indexOf('/');
        if (dotIdx > 0) {
            nodePart = portIdentifier.substring(0, dotIdx);
            portPart = portIdentifier.substring(dotIdx + 1);
        } else if (slashIdx > 0 && !portIdentifier.startsWith("//@")) {
            nodePart = portIdentifier.substring(0, slashIdx);
            portPart = portIdentifier.substring(slashIdx + 1);
        }

        for (Component comp : sys.getComponents()) {
            if (comp instanceof RosNode rn) {
                if (nodePart != null && !nodePart.equals(rn.getName())) {
                    continue;
                }
                for (RosInterface ri : rn.getRosinterfaces()) {
                    if (portPart.equals(ri.getName())) {
                        return Optional.of(ri);
                    }
                }
                RosInterface created = getOrCreateInterfaceOnNode(rn, portPart, portPart, null);
                if (created != null) {
                    return Optional.of(created);
                }
            }
        }
        return Optional.empty();
    }

    /**
     * Resolves {@code node::iface} on the system's own nodes (promoting an inherited port if needed)
     * or {@code sub::[...::]node::iface} inside subsystems (existing interfaces only).
     */
    static Optional<RosInterface> resolveQualifiedInterface(final system.System sys, final Resource res,
            final String qualified) {
        String[] parts = qualified.replace("\"", "").split("::");
        if (parts.length < 2) {
            return Optional.empty();
        }
        String ifaceName = parts[parts.length - 1];
        String nodeName = parts[parts.length - 2];
        if (parts.length == 2) {
            Optional<RosNode> rn = findRosNode(sys, res, nodeName);
            if (rn.isEmpty()) {
                return Optional.empty();
            }
            for (RosInterface ri : rn.get().getRosinterfaces()) {
                if (ifaceName.equals(ri.getName())) {
                    return Optional.of(ri);
                }
            }
            return Optional.ofNullable(getOrCreateInterfaceOnNode(rn.get(), ifaceName, ifaceName, null));
        }
        system.System current = sys;
        for (int i = 0; i < parts.length - 2 && current != null; i++) {
            system.System next = null;
            for (Component comp : current.getComponents()) {
                if (comp instanceof system.SubSystem sub) {
                    system.System ref = referencedSystem(sub, sys);
                    if (ref != null && parts[i].equals(ref.getName())) {
                        next = ref;
                        break;
                    }
                }
            }
            current = next;
        }
        if (current == null) {
            return Optional.empty();
        }
        for (Component comp : current.getComponents()) {
            if (comp instanceof RosNode rn && nodeName.equals(rn.getName())) {
                for (RosInterface ri : rn.getRosinterfaces()) {
                    if (ifaceName.equals(ri.getName())) {
                        return Optional.of(ri);
                    }
                }
            }
        }
        return Optional.empty();
    }

    /** The system a SubSystem component references, resolved against {@code context}. */
    public static system.System referencedSystem(final system.SubSystem sub, final EObject context) {
        system.System ref = sub.getSystem();
        if (ref != null && ref.eIsProxy()) {
            EObject resolved = EcoreUtil.resolve(ref, context);
            ref = resolved instanceof system.System s ? s : null;
        }
        return ref == null || ref.eIsProxy() ? null : ref;
    }

    /**
     * Names of the subsystems from {@code root} down to {@code target} (the referenced systems'
     * names, as RosSystemScopeProvider uses them), or null when {@code target} is not reachable.
     */
    public static List<String> subsystemPath(final system.System root, final system.System target) {
        return subsystemPath(root, target, new java.util.HashSet<>());
    }

    private static List<String> subsystemPath(final system.System current, final system.System target,
            final java.util.Set<system.System> visited) {
        if (current == null || !visited.add(current)) {
            return null;
        }
        for (Component comp : current.getComponents()) {
            if (comp instanceof system.SubSystem sub) {
                system.System ref = referencedSystem(sub, current);
                if (ref == null) {
                    continue;
                }
                if (ref == target) {
                    return new java.util.ArrayList<>(List.of(String.valueOf(ref.getName())));
                }
                List<String> rest = subsystemPath(ref, target, visited);
                if (rest != null) {
                    rest.add(0, String.valueOf(ref.getName()));
                    return rest;
                }
            }
        }
        return null;
    }

    /**
     * Reference to {@code ri} from connections of {@code root}: {@code node::iface} for the root's
     * own nodes, {@code sub::[...::]node::iface} for nodes inside subsystems.
     */
    public static String qualifiedRef(final system.System root, final RosInterface ri) {
        if (ri == null) {
            return "";
        }
        if (!(ri.eContainer() instanceof RosNode rn) || rn.getName() == null) {
            return String.valueOf(ri.getName());
        }
        String local = rn.getName() + "::" + ri.getName();
        if (root == null || !(rn.eContainer() instanceof system.System owner) || owner == root) {
            return local;
        }
        List<String> path = subsystemPath(root, owner);
        return path == null ? local : String.join("::", path) + "::" + local;
    }

    public static RosInterface getOrCreateInterfaceOnNode(
            final RosNode rn,
            final String exposedName,
            final String originName,
            final String kindHint) {
        for (RosInterface existing : rn.getRosinterfaces()) {
            if (exposedName.equals(existing.getName())) {
                return existing;
            }
        }
        List<InterfaceHolder> holders = new ArrayList<>();
        Node origin = rn.getFrom();
        if (origin != null && !origin.eIsProxy()) {
            holders.add(origin);
        }
        for (Plugin pl : SlotAttachments.plugins(rn)) {
            Plugin resolved = pl;
            if (resolved != null && resolved.eIsProxy()) {
                resolved = (Plugin) EcoreUtil.resolve(resolved, rn);
            }
            if (resolved != null && !resolved.eIsProxy()) {
                holders.add(resolved);
            }
        }
        for (InterfaceHolder holder : holders) {
            if (kindHint == null || "pub".equals(kindHint) || RosModelTypes.PORT_PUB.equals(kindHint)) {
                for (Publisher pub : holder.getPublisher()) {
                    if (originName.equals(pub.getName())) {
                        RosInterface ri = RossystemFactory.eINSTANCE.createRosInterface();
                        ri.setName(exposedName);
                        RosPublisherReference ref = RossystemFactory.eINSTANCE.createRosPublisherReference();
                        ref.setFrom(pub);
                        ri.setReference(ref);
                        rn.getRosinterfaces().add(ri);
                        return ri;
                    }
                }
            }
            if (kindHint == null || "sub".equals(kindHint) || RosModelTypes.PORT_SUB.equals(kindHint)) {
                for (Subscriber sub : holder.getSubscriber()) {
                    if (originName.equals(sub.getName())) {
                        RosInterface ri = RossystemFactory.eINSTANCE.createRosInterface();
                        ri.setName(exposedName);
                        RosSubscriberReference ref = RossystemFactory.eINSTANCE.createRosSubscriberReference();
                        ref.setFrom(sub);
                        ri.setReference(ref);
                        rn.getRosinterfaces().add(ri);
                        return ri;
                    }
                }
            }
            if (kindHint == null || "ss".equals(kindHint) || RosModelTypes.PORT_SS.equals(kindHint)) {
                for (ServiceServer ss : holder.getServiceserver()) {
                    if (originName.equals(ss.getName())) {
                        RosInterface ri = RossystemFactory.eINSTANCE.createRosInterface();
                        ri.setName(exposedName);
                        RosServiceServerReference ref = RossystemFactory.eINSTANCE.createRosServiceServerReference();
                        ref.setFrom(ss);
                        ri.setReference(ref);
                        rn.getRosinterfaces().add(ri);
                        return ri;
                    }
                }
            }
            if (kindHint == null || "sc".equals(kindHint) || RosModelTypes.PORT_SC.equals(kindHint)) {
                for (ServiceClient sc : holder.getServiceclient()) {
                    if (originName.equals(sc.getName())) {
                        RosInterface ri = RossystemFactory.eINSTANCE.createRosInterface();
                        ri.setName(exposedName);
                        RosServiceClientReference ref = RossystemFactory.eINSTANCE.createRosServiceClientReference();
                        ref.setFrom(sc);
                        ri.setReference(ref);
                        rn.getRosinterfaces().add(ri);
                        return ri;
                    }
                }
            }
            if (kindHint == null || "as".equals(kindHint) || RosModelTypes.PORT_AS.equals(kindHint)) {
                for (ActionServer as : holder.getActionserver()) {
                    if (originName.equals(as.getName())) {
                        RosInterface ri = RossystemFactory.eINSTANCE.createRosInterface();
                        ri.setName(exposedName);
                        RosActionServerReference ref = RossystemFactory.eINSTANCE.createRosActionServerReference();
                        ref.setFrom(as);
                        ri.setReference(ref);
                        rn.getRosinterfaces().add(ri);
                        return ri;
                    }
                }
            }
            if (kindHint == null || "ac".equals(kindHint) || RosModelTypes.PORT_AC.equals(kindHint)) {
                for (ActionClient ac : holder.getActionclient()) {
                    if (originName.equals(ac.getName())) {
                        RosInterface ri = RossystemFactory.eINSTANCE.createRosInterface();
                        ri.setName(exposedName);
                        RosActionClientReference ref = RossystemFactory.eINSTANCE.createRosActionClientReference();
                        ref.setFrom(ac);
                        ri.setReference(ref);
                        rn.getRosinterfaces().add(ri);
                        return ri;
                    }
                }
            }
        }
        return null;
    }

    public static String getPortType(final RosInterface ri) {
        if (ri == null || ri.getReference() == null) {
            return null;
        }
        InterfaceReference ref = ri.getReference();
        if (ref instanceof RosPublisherReference) return RosModelTypes.PORT_PUB;
        if (ref instanceof RosSubscriberReference) return RosModelTypes.PORT_SUB;
        if (ref instanceof RosServiceServerReference) return RosModelTypes.PORT_SS;
        if (ref instanceof RosServiceClientReference) return RosModelTypes.PORT_SC;
        if (ref instanceof RosActionServerReference) return RosModelTypes.PORT_AS;
        if (ref instanceof RosActionClientReference) return RosModelTypes.PORT_AC;
        return null;
    }

    public static SpecBase getSpecBase(final RosInterface ri) {
        if (ri == null || ri.getReference() == null) {
            return null;
        }
        InterfaceReference ref = ri.getReference();
        if (ref instanceof RosPublisherReference pubRef && pubRef.getFrom() != null && !pubRef.getFrom().eIsProxy()) {
            return pubRef.getFrom().getMessage();
        }
        if (ref instanceof RosSubscriberReference subRef && subRef.getFrom() != null && !subRef.getFrom().eIsProxy()) {
            return subRef.getFrom().getMessage();
        }
        if (ref instanceof RosServiceServerReference ssRef && ssRef.getFrom() != null && !ssRef.getFrom().eIsProxy()) {
            return ssRef.getFrom().getService();
        }
        if (ref instanceof RosServiceClientReference scRef && scRef.getFrom() != null && !scRef.getFrom().eIsProxy()) {
            return scRef.getFrom().getService();
        }
        if (ref instanceof RosActionServerReference asRef && asRef.getFrom() != null && !asRef.getFrom().eIsProxy()) {
            return asRef.getFrom().getAction();
        }
        if (ref instanceof RosActionClientReference acRef && acRef.getFrom() != null && !acRef.getFrom().eIsProxy()) {
            return acRef.getFrom().getAction();
        }
        return null;
    }

    /** The message/service/action spec of an origin interface (ros.Publisher, ros.ServiceServer, ...). */
    public static SpecBase getOriginSpec(final EObject origin) {
        if (origin == null || origin.eIsProxy()) {
            return null;
        }
        if (origin instanceof Publisher p) return p.getMessage();
        if (origin instanceof Subscriber s) return s.getMessage();
        if (origin instanceof ServiceServer ss) return ss.getService();
        if (origin instanceof ServiceClient sc) return sc.getService();
        if (origin instanceof ActionServer as) return as.getAction();
        if (origin instanceof ActionClient ac) return ac.getAction();
        return null;
    }

    /** The origin interface a RosInterface refers to (ros.Publisher, ros.ServiceServer, ...), or null. */
    public static EObject getOriginInterface(final RosInterface ri) {
        InterfaceReference ref = ri == null ? null : ri.getReference();
        if (ref instanceof RosPublisherReference r) return r.getFrom();
        if (ref instanceof RosSubscriberReference r) return r.getFrom();
        if (ref instanceof RosServiceServerReference r) return r.getFrom();
        if (ref instanceof RosServiceClientReference r) return r.getFrom();
        if (ref instanceof RosActionServerReference r) return r.getFrom();
        if (ref instanceof RosActionClientReference r) return r.getFrom();
        return null;
    }

    public static boolean areCompatibleInterfaces(final RosInterface first, final RosInterface second) {
        return areCompatible(getPortType(first), getSpecBase(first), getPortType(second), getSpecBase(second));
    }

    /**
     * Port compatibility on kinds and specs, usable for interfaces that are only inherited from the
     * origin node (no RosInterface yet): complementary kinds and, when both are resolved, the same spec.
     */
    public static boolean areCompatible(final String t1, final SpecBase s1, final String t2, final SpecBase s2) {
        if (t1 == null || t2 == null) {
            return false;
        }
        String expectedComplement = RosModelTypes.getComplementPortType(t1);
        if (!t2.equals(expectedComplement)) {
            return false;
        }
        if (s1 != null && !s1.eIsProxy() && s2 != null && !s2.eIsProxy()) {
            String f1 = s1.getFullname();
            String f2 = s2.getFullname();
            if (f1 != null && !f1.isEmpty() && f2 != null && !f2.isEmpty() && !f1.equals(f2)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Normalizes (first, second) so index 0 is always the source/server (PUB, SS, AS)
     * and index 1 is always the target/client (SUB, SC, AC).
     */
    public static RosInterface[] normalizeDirection(final RosInterface first, final RosInterface second) {
        String t1 = getPortType(first);
        if (RosModelTypes.isTargetPort(t1)) {
            return new RosInterface[] {second, first};
        }
        return new RosInterface[] {first, second};
    }

    public static Optional<Parameter> findOriginParameter(final RosNode rn, final String paramName) {
        if (rn == null || paramName == null) {
            return Optional.empty();
        }
        if (rn.getFrom() != null && !rn.getFrom().eIsProxy()) {
            for (Parameter p : rn.getFrom().getParameter()) {
                if (paramName.equals(p.getName())) {
                    return Optional.of(p);
                }
            }
        }
        for (Plugin pl : SlotAttachments.plugins(rn)) {
            Plugin resolved = pl;
            if (resolved != null && resolved.eIsProxy()) {
                resolved = (Plugin) EcoreUtil.resolve(resolved, rn);
            }
            if (resolved != null && !resolved.eIsProxy()) {
                for (Parameter p : resolved.getParameter()) {
                    if (paramName.equals(p.getName())) {
                        return Optional.of(p);
                    }
                }
            }
        }
        return Optional.empty();
    }
}
