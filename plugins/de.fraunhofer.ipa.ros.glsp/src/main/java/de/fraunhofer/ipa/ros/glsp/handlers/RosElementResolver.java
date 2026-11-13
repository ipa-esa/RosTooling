package de.fraunhofer.ipa.ros.glsp.handlers;

import de.fraunhofer.ipa.ros.glsp.RosModelTypes;
import de.fraunhofer.ipa.ros.glsp.model.RosModelState;
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
import ros.InterfaceType;
import ros.Node;
import ros.Package;
import ros.Parameter;
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
        Node origin = rn.getFrom();
        if (origin == null || origin.eIsProxy()) {
            return null;
        }
        if (kindHint == null || "pub".equals(kindHint) || RosModelTypes.PORT_PUB.equals(kindHint)) {
            for (Publisher pub : origin.getPublisher()) {
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
            for (Subscriber sub : origin.getSubscriber()) {
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
            for (ServiceServer ss : origin.getServiceserver()) {
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
            for (ServiceClient sc : origin.getServiceclient()) {
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
            for (ActionServer as : origin.getActionserver()) {
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
            for (ActionClient ac : origin.getActionclient()) {
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

    public static boolean areCompatibleInterfaces(final RosInterface first, final RosInterface second) {
        String t1 = getPortType(first);
        String t2 = getPortType(second);
        if (t1 == null || t2 == null) {
            return false;
        }
        String expectedComplement = RosModelTypes.getComplementPortType(t1);
        if (!t2.equals(expectedComplement)) {
            return false;
        }
        SpecBase s1 = getSpecBase(first);
        SpecBase s2 = getSpecBase(second);
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
        if (rn == null || paramName == null || rn.getFrom() == null || rn.getFrom().eIsProxy()) {
            return Optional.empty();
        }
        for (Parameter p : rn.getFrom().getParameter()) {
            if (paramName.equals(p.getName())) {
                return Optional.of(p);
            }
        }
        return Optional.empty();
    }
}
