package de.fraunhofer.ipa.ros.glsp.model;

import com.google.inject.Inject;
import de.fraunhofer.ipa.ros.glsp.RosModelTypes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.glsp.graph.DefaultTypes;
import org.eclipse.glsp.graph.GEdge;
import org.eclipse.glsp.graph.GGraph;
import org.eclipse.glsp.graph.GModelElement;
import org.eclipse.glsp.graph.GModelRoot;
import org.eclipse.glsp.graph.GNode;
import org.eclipse.glsp.graph.GPoint;
import org.eclipse.glsp.graph.GPort;
import org.eclipse.glsp.graph.builder.impl.GEdgeBuilder;
import org.eclipse.glsp.graph.builder.impl.GEdgePlacementBuilder;
import org.eclipse.glsp.graph.builder.impl.GGraphBuilder;
import org.eclipse.glsp.graph.builder.impl.GLabelBuilder;
import org.eclipse.glsp.graph.builder.impl.GNodeBuilder;
import org.eclipse.glsp.graph.builder.impl.GPortBuilder;
import org.eclipse.glsp.graph.util.GraphUtil;
import org.eclipse.glsp.server.emf.EMFGModelFactory;
import org.eclipse.glsp.server.emf.EMFIdGenerator;
import org.eclipse.glsp.server.layout.LayoutEngine;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import ros.ActionClient;
import ros.ActionServer;
import ros.AmentPackage;
import ros.Artifact;
import ros.Node;
import ros.Package;
import de.fraunhofer.ipa.ros.glsp.handlers.RosPackageSetEditor;
import primitives.MessagePart;
import ros.ActionSpec;
import ros.InterfaceType;
import ros.LifecycleState;
import ros.MessageDefinition;
import ros.ServiceSpec;
import ros.PackageSet;
import ros.Parameter;
import ros.ParameterAny;
import ros.ParameterBoolean;
import ros.ParameterDouble;
import ros.ParameterInteger;
import ros.ParameterSequence;
import ros.ParameterString;
import ros.ParameterStruct;
import ros.ParameterStructMember;
import ros.ParameterType;
import ros.ParameterValue;
import ros.Publisher;
import ros.QualityOfService;
import ros.RosPackage;
import ros.ServiceClient;
import ros.ServiceServer;
import ros.SpecBase;
import ros.Subscriber;
import system.Component;
import system.Connection;
import system.InterfaceReference;
import system.Process;
import system.RosActionClientReference;
import system.RosActionServerReference;
import system.RosInterface;
import system.RosNode;
import system.RosParameter;
import system.RosPublisherReference;
import system.RosServiceClientReference;
import system.RosServiceServerReference;
import system.RosSubscriberReference;
import system.RosSystemConnection;
import system.RossystemPackage;
import system.SubSystem;

/**
 * Transforms live Ecore ASTs (system.System, ros.PackageSet) into GLSP GGraph models
 * and invokes server-side ELK layout for .rossystem architecture diagrams.
 */
public class RosGModelFactory extends EMFGModelFactory {

    public static final double NODE_WIDTH = 280.0;
    public static final double NODE_HEADER_HEIGHT = 68.0;
    public static final double SUBSYSTEM_COLLAPSED_HEADER_HEIGHT = 44.0;
    public static final double PORT_ROW_HEIGHT = 28.0;
    public static final double NODE_BOTTOM_PADDING = 16.0;
    public static final double PORT_SIZE = 12.0;
    /**
     * Upper bound for a node card's width. Longer port labels wrap onto further lines (the row
     * grows); title and 'from' are truncated beyond it (full text on hover).
     */
    public static final double MAX_NODE_WIDTH = 440.0;
    /** Line height of a wrapped port label (10.5px font). */
    public static final double PORT_LABEL_LINE_HEIGHT = 13.0;
    /** Never wrap a label column narrower than this many characters. */
    static final int MIN_LABEL_CHARS = 12;
    // Average glyph widths of the card fonts (webview studio.css): port labels 10.5px sans,
    // title 700 13px sans, 'from' subtitle 10.5px mono. Slightly generous so text fits.
    static final double PORT_CHAR_WIDTH = 6.2;
    static final double TITLE_CHAR_WIDTH = 8.0;
    static final double SUBTITLE_CHAR_WIDTH = 6.5;
    static final double CARD_MARGIN = 12.0;
    static final double PORT_LABEL_INSET = 20.0;
    static final double PORT_LABEL_GAP = 24.0;

    @Inject
    protected RosModelState rosModelState;

    @Inject
    protected Optional<LayoutEngine> layoutEngine;

    @Override
    protected void fillRootElement(final GModelRoot newRoot) {
        if (!(newRoot instanceof GGraph ggraph)) {
            return;
        }
        EObject semanticModel = rosModelState.getSemanticModel();
        // Editor value sets derived from the Ecore metamodel (see RosMetamodelVocabulary).
        ggraph.getArgs().put("metamodelJson", RosMetamodelVocabulary.json());
        if (semanticModel instanceof system.System rosSystem) {
            fillSystemGraph(rosSystem, ggraph);
        } else if (rosModelState.isPackageModel()) {
            fillPackageSetGraph(rosModelState.getPackageModelPackages(), ggraph);
        }
    }

    @Override
    public void createGModel() {
        GGraph ggraph = new GGraphBuilder(DefaultTypes.GRAPH)
                .id("root")
                .build();
        rosModelState.updateRoot(ggraph);
        fillRootElement(ggraph);
    }

    protected void fillSystemGraph(final system.System rosSystem, final GGraph ggraph) {
        ggraph.getArgs().put("modelKind", "rossystem");
        ggraph.getArgs().put("systemName", nullToEmpty(rosSystem.getName()));
        ggraph.getArgs().put("fromFile", nullToEmpty(rosSystem.getFromFile()));

        Map<RosInterface, String> interfaceToPortId = new HashMap<>();
        Map<RosInterface, String> collapsedInterfaceToSubId = new HashMap<>();

        // 1. Transform components (RosNode, SubSystem)
        for (Component comp : rosSystem.getComponents()) {
            if (comp instanceof RosNode rosNode) {
                GNode nodeElement = createRosNodeElement(rosNode, interfaceToPortId);
                ggraph.getChildren().add(nodeElement);
            } else if (comp instanceof SubSystem subSystem) {
                GNode subNodeElement = createSubSystemElement(
                        rosSystem, subSystem, interfaceToPortId, collapsedInterfaceToSubId);
                ggraph.getChildren().add(subNodeElement);
            }
        }

        // 2. Transform processes
        for (Process proc : rosSystem.getProcesses()) {
            GNode procNode = createProcessElement(proc);
            ggraph.getChildren().add(procNode);
        }

        // 3. Transform connections into port-to-port GEdges
        for (Connection conn : rosSystem.getConnections()) {
            if (conn instanceof RosSystemConnection sysConn) {
                createConnectionEdge(sysConn, interfaceToPortId, collapsedInterfaceToSubId)
                        .ifPresent(edge -> ggraph.getChildren().add(edge));
            }
        }

        // 4. Run server-side ELK layout
        if (layoutEngine != null && layoutEngine.isPresent()) {
            layoutEngine.get().layout();
        }

        // 5. Apply any user-pinned node positions on top of ELK layout
        Map<String, GPoint> pinned = rosModelState.getPinnedPositions();
        if (!pinned.isEmpty()) {
            for (GModelElement child : ggraph.getChildren()) {
                if (child instanceof GNode gnode && pinned.containsKey(gnode.getId())) {
                    GPoint pos = pinned.get(gnode.getId());
                    gnode.setPosition(GraphUtil.point(pos.getX(), pos.getY()));
                }
            }
        }
    }

    protected GNode createRosNodeElement(
            final RosNode rosNode,
            final Map<RosInterface, String> interfaceToPortId) {
        String nodeId = getElementId(rosNode);
        String nodeName = nullToEmpty(rosNode.getName());
        String namespace = nullToEmpty(rosNode.getNamespace());
        String fromRef = resolveNodeFromString(rosNode);

        Node originNode = rosNode.getFrom();
        boolean isResolvedOrigin = originNode != null && !originNode.eIsProxy();
        boolean isLifecycle = isResolvedOrigin && originNode.isIsLifecycle();

        List<PortDescriptor> targetPorts = new ArrayList<>();
        List<PortDescriptor> sourcePorts = new ArrayList<>();

        // Collect explicit RosInterfaces first
        Map<EObject, RosInterface> explicitByOrigin = new HashMap<>();
        for (RosInterface ri : rosNode.getRosinterfaces()) {
            PortDescriptor desc = createExplicitPortDescriptor(nodeId, ri);
            if (desc != null) {
                interfaceToPortId.put(ri, desc.portId);
                if (desc.originElement != null) {
                    explicitByOrigin.put(desc.originElement, ri);
                }
                if (RosModelTypes.isTargetPort(desc.portType)) {
                    targetPorts.add(desc);
                } else {
                    sourcePorts.add(desc);
                }
            }
        }

        // Also include inherited interfaces from origin ros.Node not yet wrapped in RosInterface
        if (isResolvedOrigin) {
            for (Subscriber sub : originNode.getSubscriber()) {
                if (!explicitByOrigin.containsKey(sub)) {
                    String spec = resolveSpecName(sub, RosPackage.Literals.SUBSCRIBER__MESSAGE, sub.getMessage());
                    targetPorts.add(new PortDescriptor(
                            nodeId + "__port__sub__" + sub.getName(),
                            RosModelTypes.PORT_SUB,
                            sub.getName(),
                            sub.getName(),
                            spec,
                            false,
                            sub));
                }
            }
            for (ServiceClient sc : originNode.getServiceclient()) {
                if (!explicitByOrigin.containsKey(sc)) {
                    String spec = resolveSpecName(sc, RosPackage.Literals.SERVICE_CLIENT__SERVICE, sc.getService());
                    targetPorts.add(new PortDescriptor(
                            nodeId + "__port__sc__" + sc.getName(),
                            RosModelTypes.PORT_SC,
                            sc.getName(),
                            sc.getName(),
                            spec,
                            false,
                            sc));
                }
            }
            for (ActionClient ac : originNode.getActionclient()) {
                if (!explicitByOrigin.containsKey(ac)) {
                    String spec = resolveSpecName(ac, RosPackage.Literals.ACTION_CLIENT__ACTION, ac.getAction());
                    targetPorts.add(new PortDescriptor(
                            nodeId + "__port__ac__" + ac.getName(),
                            RosModelTypes.PORT_AC,
                            ac.getName(),
                            ac.getName(),
                            spec,
                            false,
                            ac));
                }
            }
            for (Publisher pub : originNode.getPublisher()) {
                if (!explicitByOrigin.containsKey(pub)) {
                    String spec = resolveSpecName(pub, RosPackage.Literals.PUBLISHER__MESSAGE, pub.getMessage());
                    sourcePorts.add(new PortDescriptor(
                            nodeId + "__port__pub__" + pub.getName(),
                            RosModelTypes.PORT_PUB,
                            pub.getName(),
                            pub.getName(),
                            spec,
                            false,
                            pub));
                }
            }
            for (ServiceServer ss : originNode.getServiceserver()) {
                if (!explicitByOrigin.containsKey(ss)) {
                    String spec = resolveSpecName(ss, RosPackage.Literals.SERVICE_SERVER__SERVICE, ss.getService());
                    sourcePorts.add(new PortDescriptor(
                            nodeId + "__port__ss__" + ss.getName(),
                            RosModelTypes.PORT_SS,
                            ss.getName(),
                            ss.getName(),
                            spec,
                            false,
                            ss));
                }
            }
            for (ActionServer as : originNode.getActionserver()) {
                if (!explicitByOrigin.containsKey(as)) {
                    String spec = resolveSpecName(as, RosPackage.Literals.ACTION_SERVER__ACTION, as.getAction());
                    sourcePorts.add(new PortDescriptor(
                            nodeId + "__port__as__" + as.getName(),
                            RosModelTypes.PORT_AS,
                            as.getName(),
                            as.getName(),
                            spec,
                            false,
                            as));
                }
            }
        }

        int activeParams = rosNode.getRosparameters().size();
        int totalParams = isResolvedOrigin ? Math.max(activeParams, originNode.getParameter().size()) : activeParams;

        // Card width follows its texts (title + badges, 'from', west + east port labels), so
        // interface names are not cut off; the client truncates only beyond MAX_NODE_WIDTH.
        String title = namespace.isEmpty() ? nodeName : namespace.replaceAll("/$", "") + "/" + nodeName;
        double badges = 86.0 + (isLifecycle ? 30.0 : 0.0);
        double headerMinWidth = Math.max(
                2 * CARD_MARGIN + title.length() * TITLE_CHAR_WIDTH + badges,
                2 * CARD_MARGIN + fromRef.length() * SUBTITLE_CHAR_WIDTH);
        double nodeWidth = computeCardWidth(NODE_WIDTH, headerMinWidth, targetPorts, sourcePorts);

        // A long 'from' wraps too; the header grows by one line per extra line.
        int fromMaxChars = (int) Math.floor((nodeWidth - 2 * CARD_MARGIN) / SUBTITLE_CHAR_WIDTH);
        List<String> fromLines = wrapLabel(fromRef, fromMaxChars);
        double headerHeight = NODE_HEADER_HEIGHT + (fromLines.size() - 1) * PORT_LABEL_LINE_HEIGHT;

        GNodeBuilder builder = new GNodeBuilder(RosModelTypes.ROS_NODE)
                .id(nodeId)
                .addArgument("titleMaxChars", (int) Math.floor((nodeWidth - 2 * CARD_MARGIN - badges) / TITLE_CHAR_WIDTH))
                .addArgument("fromLines", String.join("\n", fromLines))
                .addArgument("headerHeight", headerHeight)
                .addArgument("nodeName", nodeName)
                .addArgument("namespace", namespace)
                .addArgument("from", fromRef)
                .addArgument("isLifecycle", isLifecycle)
                .addArgument("activeParams", activeParams)
                .addArgument("totalParams", totalParams)
                .addArgument("parametersJson", serializeRosParameters(rosNode, originNode));

        // Header labels
        builder.add(new GLabelBuilder(RosModelTypes.LABEL_NAME)
                .id(nodeId + "_label_name")
                .text(namespace.isEmpty() ? nodeName : namespace + "/" + nodeName)
                .build());
        builder.add(new GLabelBuilder(RosModelTypes.LABEL_SUBTITLE)
                .id(nodeId + "_label_from")
                .text(fromRef)
                .build());
        builder.add(new GLabelBuilder(RosModelTypes.LABEL_BADGE)
                .id(nodeId + "_label_params")
                .text(activeParams + "/" + totalParams + " params")
                .build());

        double nodeHeight = layoutAndAddPorts(builder, nodeId, nodeWidth, headerHeight, targetPorts, sourcePorts);
        builder.size(nodeWidth, nodeHeight);

        return builder.build();
    }

    /**
     * Computes card width in 10px steps within [minWidth, MAX_NODE_WIDTH] from header text and
     * widest west/east port labels so names avoid truncation where possible.
     */
    protected static double computeCardWidth(
            final double minWidth,
            final double headerMinWidth,
            final List<PortDescriptor> targetPorts,
            final List<PortDescriptor> sourcePorts) {
        int westChars = targetPorts.stream().mapToInt(pd -> portLabel(pd).length()).max().orElse(0);
        int eastChars = sourcePorts.stream().mapToInt(pd -> portLabel(pd).length()).max().orElse(0);
        double westText = westChars * PORT_CHAR_WIDTH;
        double eastText = eastChars * PORT_CHAR_WIDTH;
        double portsWidth = 2 * PORT_LABEL_INSET + westText + eastText
                + (westChars > 0 && eastChars > 0 ? PORT_LABEL_GAP : 0);
        double raw = Math.max(minWidth, Math.max(portsWidth, headerMinWidth));
        return Math.min(MAX_NODE_WIDTH, Math.ceil(raw / 10.0) * 10.0);
    }

    /**
     * Wraps port labels to fit {@code cardWidth}, attaches West/East {@link GPort} elements to
     * {@code builder}, and returns the resulting total card height.
     */
    protected double layoutAndAddPorts(
            final GNodeBuilder builder,
            final String ownerId,
            final double cardWidth,
            final double headerHeight,
            final List<PortDescriptor> targetPorts,
            final List<PortDescriptor> sourcePorts) {
        int westChars = targetPorts.stream().mapToInt(pd -> portLabel(pd).length()).max().orElse(0);
        int eastChars = sourcePorts.stream().mapToInt(pd -> portLabel(pd).length()).max().orElse(0);
        double westText = westChars * PORT_CHAR_WIDTH;
        double labelSpace = cardWidth - 2 * PORT_LABEL_INSET - (westChars > 0 && eastChars > 0 ? PORT_LABEL_GAP : 0);
        double westShare = westChars + eastChars == 0 ? 0 : labelSpace * westText / (westText + eastChars * PORT_CHAR_WIDTH);
        int westMaxChars = Math.max(MIN_LABEL_CHARS, (int) Math.floor(westShare / PORT_CHAR_WIDTH));
        int eastMaxChars = Math.max(MIN_LABEL_CHARS, (int) Math.floor((labelSpace - westShare) / PORT_CHAR_WIDTH));

        List<List<String>> westLines = new ArrayList<>();
        for (PortDescriptor pd : targetPorts) {
            westLines.add(wrapLabel(portLabel(pd), westMaxChars));
        }
        List<List<String>> eastLines = new ArrayList<>();
        for (PortDescriptor pd : sourcePorts) {
            eastLines.add(wrapLabel(portLabel(pd), eastMaxChars));
        }

        double westY = headerHeight;
        for (int i = 0; i < targetPorts.size(); i++) {
            PortDescriptor pd = targetPorts.get(i);
            GPort port = buildGPort(pd, ownerId, 0.0, westY + (PORT_ROW_HEIGHT - PORT_SIZE) / 2.0);
            port.getArgs().put("labelLines", String.join("\n", westLines.get(i)));
            builder.add(port);
            westY += rowHeight(westLines.get(i));
        }

        double eastY = headerHeight;
        for (int i = 0; i < sourcePorts.size(); i++) {
            PortDescriptor pd = sourcePorts.get(i);
            GPort port = buildGPort(pd, ownerId, cardWidth, eastY + (PORT_ROW_HEIGHT - PORT_SIZE) / 2.0);
            port.getArgs().put("labelLines", String.join("\n", eastLines.get(i)));
            builder.add(port);
            eastY += rowHeight(eastLines.get(i));
        }

        return headerHeight + Math.max(rowsHeight(westLines), rowsHeight(eastLines)) + NODE_BOTTOM_PADDING;
    }

    static double rowHeight(final List<String> lines) {
        return PORT_ROW_HEIGHT + Math.max(0, lines.size() - 1) * PORT_LABEL_LINE_HEIGHT;
    }

    static double rowsHeight(final List<List<String>> rows) {
        return rows.stream().mapToDouble(RosGModelFactory::rowHeight).sum();
    }

    /**
     * Wraps a port label to lines of at most {@code maxChars}, preferring to break after
     * '/', '_', ':', '.' or a space (the separator stays on the earlier line).
     */
    static List<String> wrapLabel(final String label, final int maxChars) {
        List<String> lines = new ArrayList<>();
        String rest = label.trim();
        int max = Math.max(1, maxChars);
        while (rest.length() > max) {
            int cut = -1;
            for (int i = max; i >= max / 2; i--) {
                char c = rest.charAt(i - 1);
                if (c == '/' || c == '_' || c == ':' || c == ' ' || c == '.') {
                    cut = i;
                    break;
                }
            }
            if (cut < 0) {
                cut = max;
            }
            lines.add(rest.substring(0, cut).trim());
            rest = rest.substring(cut).trim();
        }
        if (!rest.isEmpty() || lines.isEmpty()) {
            lines.add(rest);
        }
        return lines;
    }

    /** The label a port shows next to its box: "name : Type". */
    static String portLabel(final PortDescriptor pd) {
        String spec = pd.specName == null ? "" : pd.specName;
        return pd.name + (spec.isEmpty() ? "" : " : " + spec.substring(spec.lastIndexOf('/') + 1));
    }

    protected GPort buildGPort(
            final PortDescriptor pd,
            final String nodeId,
            final double x,
            final double y) {
        GPortBuilder portBuilder = new GPortBuilder(pd.portType)
                .id(pd.portId)
                .position(x, y)
                .size(PORT_SIZE, PORT_SIZE)
                .addArgument("interfaceName", pd.name)
                .addArgument("originName", pd.originName)
                .addArgument("specName", pd.specName)
                .addArgument("isExplicit", pd.isExplicit)
                .addArgument("rosNodeId", nodeId);
        if (pd.originElement != null && !pd.originElement.eIsProxy()) {
            portBuilder.addArgument("originUri", EcoreUtil.getURI(pd.originElement).toString());
        }
        return portBuilder.build();
    }

    protected PortDescriptor createExplicitPortDescriptor(final String nodeId, final RosInterface ri) {
        String portId = getElementId(ri);
        String name = nullToEmpty(ri.getName());
        InterfaceReference ref = ri.getReference();
        if (ref instanceof RosPublisherReference pubRef) {
            Publisher pub = pubRef.getFrom();
            String originName = (pub != null && !pub.eIsProxy() && pub.getName() != null)
                    ? pub.getName()
                    : resolveCrossRefText(pubRef, RossystemPackage.Literals.ROS_PUBLISHER_REFERENCE__FROM);
            String spec = (pub != null && !pub.eIsProxy())
                    ? resolveSpecName(pub, RosPackage.Literals.PUBLISHER__MESSAGE, pub.getMessage())
                    : "";
            return new PortDescriptor(portId, RosModelTypes.PORT_PUB, name, originName, spec, true, pub);
        } else if (ref instanceof RosSubscriberReference subRef) {
            Subscriber sub = subRef.getFrom();
            String originName = (sub != null && !sub.eIsProxy() && sub.getName() != null)
                    ? sub.getName()
                    : resolveCrossRefText(subRef, RossystemPackage.Literals.ROS_SUBSCRIBER_REFERENCE__FROM);
            String spec = (sub != null && !sub.eIsProxy())
                    ? resolveSpecName(sub, RosPackage.Literals.SUBSCRIBER__MESSAGE, sub.getMessage())
                    : "";
            return new PortDescriptor(portId, RosModelTypes.PORT_SUB, name, originName, spec, true, sub);
        } else if (ref instanceof RosServiceServerReference ssRef) {
            ServiceServer ss = ssRef.getFrom();
            String originName = (ss != null && !ss.eIsProxy() && ss.getName() != null)
                    ? ss.getName()
                    : resolveCrossRefText(ssRef, RossystemPackage.Literals.ROS_SERVICE_SERVER_REFERENCE__FROM);
            String spec = (ss != null && !ss.eIsProxy())
                    ? resolveSpecName(ss, RosPackage.Literals.SERVICE_SERVER__SERVICE, ss.getService())
                    : "";
            return new PortDescriptor(portId, RosModelTypes.PORT_SS, name, originName, spec, true, ss);
        } else if (ref instanceof RosServiceClientReference scRef) {
            ServiceClient sc = scRef.getFrom();
            String originName = (sc != null && !sc.eIsProxy() && sc.getName() != null)
                    ? sc.getName()
                    : resolveCrossRefText(scRef, RossystemPackage.Literals.ROS_SERVICE_CLIENT_REFERENCE__FROM);
            String spec = (sc != null && !sc.eIsProxy())
                    ? resolveSpecName(sc, RosPackage.Literals.SERVICE_CLIENT__SERVICE, sc.getService())
                    : "";
            return new PortDescriptor(portId, RosModelTypes.PORT_SC, name, originName, spec, true, sc);
        } else if (ref instanceof RosActionServerReference asRef) {
            ActionServer as = asRef.getFrom();
            String originName = (as != null && !as.eIsProxy() && as.getName() != null)
                    ? as.getName()
                    : resolveCrossRefText(asRef, RossystemPackage.Literals.ROS_ACTION_SERVER_REFERENCE__FROM);
            String spec = (as != null && !as.eIsProxy())
                    ? resolveSpecName(as, RosPackage.Literals.ACTION_SERVER__ACTION, as.getAction())
                    : "";
            return new PortDescriptor(portId, RosModelTypes.PORT_AS, name, originName, spec, true, as);
        } else if (ref instanceof RosActionClientReference acRef) {
            ActionClient ac = acRef.getFrom();
            String originName = (ac != null && !ac.eIsProxy() && ac.getName() != null)
                    ? ac.getName()
                    : resolveCrossRefText(acRef, RossystemPackage.Literals.ROS_ACTION_CLIENT_REFERENCE__FROM);
            String spec = (ac != null && !ac.eIsProxy())
                    ? resolveSpecName(ac, RosPackage.Literals.ACTION_CLIENT__ACTION, ac.getAction())
                    : "";
            return new PortDescriptor(portId, RosModelTypes.PORT_AC, name, originName, spec, true, ac);
        }
        return null;
    }

    protected GNode createSubSystemElement(
            final system.System outerSystem,
            final SubSystem subSystem,
            final Map<RosInterface, String> interfaceToPortId,
            final Map<RosInterface, String> collapsedInterfaceToSubId) {
        String subId = getElementId(subSystem);
        system.System refSys = subSystem.getSystem();
        String sysName = (refSys != null && !refSys.eIsProxy() && refSys.getName() != null)
                ? refSys.getName()
                : resolveCrossRefText(subSystem, RossystemPackage.Literals.SUB_SYSTEM__SYSTEM);

        boolean collapsed = rosModelState.isSubSystemCollapsed(subId)
                || rosModelState.isSubSystemCollapsed(sysName);

        GNodeBuilder builder = new GNodeBuilder(RosModelTypes.SUBSYSTEM_NODE)
                .id(subId)
                .addArgument("subSystemName", sysName)
                .addArgument("collapsed", collapsed);

        builder.add(new GLabelBuilder(RosModelTypes.LABEL_NAME)
                .id(subId + "_label")
                .text("SubSystem: " + sysName)
                .build());

        if (refSys != null && !refSys.eIsProxy()) {
            // Members live in another resource: their EMF fragments ("//@components.0") would
            // collide with this file's ids, so they are scoped under the subsystem element.
            String previousScope = foreignIdScope;
            foreignIdScope = subId;
            try {
                if (!collapsed) {
                    builder.size(340.0, 220.0);
                    for (Component childComp : refSys.getComponents()) {
                        if (childComp instanceof RosNode childNode) {
                            builder.add(createRosNodeElement(childNode, interfaceToPortId));
                        }
                    }
                } else {
                    addCollapsedBoundaryPorts(
                            outerSystem, refSys, subId, sysName, builder,
                            interfaceToPortId, collapsedInterfaceToSubId);
                }
            } finally {
                foreignIdScope = previousScope;
            }
        } else {
            builder.size(collapsed ? 260.0 : 340.0, collapsed ? 84.0 : 220.0);
        }
        return builder.build();
    }

    /**
     * Promotes interfaces inside a collapsed subsystem that connect to nodes outside it onto the
     * collapsed subsystem card's West/East boundary so ELK keeps all external connections wired.
     */
    protected void addCollapsedBoundaryPorts(
            final system.System outerSystem,
            final system.System refSys,
            final String subId,
            final String sysName,
            final GNodeBuilder builder,
            final Map<RosInterface, String> interfaceToPortId,
            final Map<RosInterface, String> collapsedInterfaceToSubId) {
        Map<RosInterface, String> interfaceToOwnerName = new LinkedHashMap<>();
        collectSystemInterfaces(refSys, interfaceToOwnerName, new HashSet<>());
        for (RosInterface ri : interfaceToOwnerName.keySet()) {
            collapsedInterfaceToSubId.put(ri, subId);
        }

        Set<RosInterface> boundaryInterfaces = new LinkedHashSet<>();
        for (Connection conn : outerSystem.getConnections()) {
            if (conn instanceof RosSystemConnection sysConn) {
                RosInterface fromIf = sysConn.getFrom();
                RosInterface toIf = sysConn.getTo();
                boolean fromIn = fromIf != null && interfaceToOwnerName.containsKey(fromIf);
                boolean toIn = toIf != null && interfaceToOwnerName.containsKey(toIf);
                if (fromIn && !toIn) {
                    boundaryInterfaces.add(fromIf);
                } else if (toIn && !fromIn) {
                    boundaryInterfaces.add(toIf);
                }
            }
        }

        Map<String, Integer> nameCounts = new HashMap<>();
        for (RosInterface ri : boundaryInterfaces) {
            nameCounts.merge(nullToEmpty(ri.getName()), 1, Integer::sum);
        }

        List<PortDescriptor> targetPorts = new ArrayList<>();
        List<PortDescriptor> sourcePorts = new ArrayList<>();
        for (RosInterface ri : boundaryInterfaces) {
            PortDescriptor raw = createExplicitPortDescriptor(subId, ri);
            if (raw == null) {
                continue;
            }
            interfaceToPortId.put(ri, raw.portId);
            String displayName = nameCounts.getOrDefault(raw.name, 0) > 1
                    && !nullToEmpty(interfaceToOwnerName.get(ri)).isEmpty()
                    ? interfaceToOwnerName.get(ri) + "." + raw.name
                    : raw.name;
            PortDescriptor pd = displayName.equals(raw.name)
                    ? raw
                    : new PortDescriptor(raw.portId, raw.portType, displayName, raw.originName,
                            raw.specName, raw.isExplicit, raw.originElement);
            if (RosModelTypes.isTargetPort(pd.portType)) {
                targetPorts.add(pd);
            } else {
                sourcePorts.add(pd);
            }
        }

        builder.addArgument("boundaryPortCount", targetPorts.size() + sourcePorts.size());
        if (targetPorts.isEmpty() && sourcePorts.isEmpty()) {
            double titleWidth = CARD_MARGIN + ("SubSystem: " + sysName).length() * TITLE_CHAR_WIDTH + 40.0;
            double subWidth = Math.min(MAX_NODE_WIDTH, Math.ceil(Math.max(260.0, titleWidth) / 10.0) * 10.0);
            builder.size(subWidth, 84.0);
            return;
        }

        double titleMinWidth = CARD_MARGIN + ("SubSystem: " + sysName).length() * TITLE_CHAR_WIDTH + 40.0;
        double subWidth = computeCardWidth(260.0, titleMinWidth, targetPorts, sourcePorts);
        double subHeight = layoutAndAddPorts(
                builder, subId, subWidth, SUBSYSTEM_COLLAPSED_HEADER_HEIGHT, targetPorts, sourcePorts);
        builder.size(subWidth, subHeight);
    }

    private static void collectSystemInterfaces(
            final system.System sys,
            final Map<RosInterface, String> interfaceToOwnerName,
            final Set<system.System> visited) {
        if (sys == null || sys.eIsProxy() || !visited.add(sys)) {
            return;
        }
        for (Component comp : sys.getComponents()) {
            if (comp instanceof RosNode rn) {
                String nodeName = nullToEmpty(rn.getName());
                for (RosInterface ri : rn.getRosinterfaces()) {
                    interfaceToOwnerName.put(ri, nodeName);
                }
            } else if (comp instanceof SubSystem nested) {
                collectSystemInterfaces(nested.getSystem(), interfaceToOwnerName, visited);
            }
        }
    }

    protected GNode createProcessElement(final Process proc) {
        String procId = getElementId(proc);
        String procName = nullToEmpty(proc.getName());
        GNodeBuilder builder = new GNodeBuilder(RosModelTypes.PROCESS_NODE)
                .id(procId)
                .size(300.0, 140.0)
                .addArgument("processName", procName)
                .addArgument("threads", proc.getThreads())
                .addArgument("membersJson", serializeProcessMembers(proc));

        builder.add(new GLabelBuilder(RosModelTypes.LABEL_NAME)
                .id(procId + "_label")
                .text("Process: " + procName + " (" + proc.getThreads() + " threads)")
                .build());
        return builder.build();
    }

    /** Member nodes of a process (composable node container): [{id, name}]. */
    protected String serializeProcessMembers(final Process proc) {
        List<String> items = new ArrayList<>();
        for (Component c : proc.getComponents()) {
            if (c instanceof RosNode rn && !rn.eIsProxy()) {
                items.add("{\"id\":\"" + escapeJson(getElementId(rn)) + "\",\"name\":\"" + escapeJson(nullToEmpty(rn.getName())) + "\"}");
            }
        }
        return "[" + String.join(",", items) + "]";
    }

    protected Optional<GEdge> createConnectionEdge(
            final RosSystemConnection sysConn,
            final Map<RosInterface, String> interfaceToPortId,
            final Map<RosInterface, String> collapsedInterfaceToSubId) {
        RosInterface fromIf = sysConn.getFrom();
        RosInterface toIf = sysConn.getTo();
        if (fromIf == null || toIf == null) {
            return Optional.empty();
        }
        // Skip connections hidden inside a collapsed subsystem (internal or unpromoted).
        String fromCollapsedSub = collapsedInterfaceToSubId.get(fromIf);
        String toCollapsedSub = collapsedInterfaceToSubId.get(toIf);
        if ((fromCollapsedSub != null && (!interfaceToPortId.containsKey(fromIf) || fromCollapsedSub.equals(toCollapsedSub)))
                || (toCollapsedSub != null && !interfaceToPortId.containsKey(toIf))) {
            return Optional.empty();
        }
        String sourceId = interfaceToPortId.getOrDefault(fromIf, getElementId(fromIf));
        String targetId = interfaceToPortId.getOrDefault(toIf, getElementId(toIf));
        if (sourceId == null || targetId == null) {
            return Optional.empty();
        }

        String edgeId = getElementId(sysConn);
        String commKind = inferConnectionKind(fromIf);
        String labelText = fromIf.getName() != null ? fromIf.getName() : "";

        GEdgeBuilder edgeBuilder = new GEdgeBuilder(RosModelTypes.EDGE_CONNECTION)
                .id(edgeId)
                .sourceId(sourceId)
                .targetId(targetId)
                .routerKind("manhattan")
                .addArgument("connectionKind", commKind)
                .addArgument("fromInterfaceName", nullToEmpty(fromIf.getName()))
                .addArgument("toInterfaceName", nullToEmpty(toIf.getName()));

        if (!labelText.isEmpty()) {
            edgeBuilder.add(new GLabelBuilder(RosModelTypes.LABEL_TYPE)
                    .id(edgeId + "_label")
                    .text(labelText)
                    .edgePlacement(new GEdgePlacementBuilder()
                            .rotate(true)
                            .position(0.5)
                            .offset(10.0)
                            .side("top")
                            .build())
                    .build());
        }

        return Optional.of(edgeBuilder.build());
    }

    protected void fillPackageSetGraph(final List<Package> packages, final GGraph ggraph) {
        ggraph.getArgs().put("modelKind", "ros-package-set");
        for (Package pkg : packages) {
            String pkgId = getElementId(pkg);
            String pkgType = (pkg instanceof AmentPackage) ? "AmentPackage" : "CatkinPackage";
            GNodeBuilder pkgBuilder = new GNodeBuilder(RosModelTypes.PACKAGE_NODE)
                    .id(pkgId)
                    .size(320.0, 200.0)
                    .addArgument("packageName", nullToEmpty(pkg.getName()))
                    .addArgument("packageKind", pkgType)
                    .addArgument("fromGitRepo", nullToEmpty(pkg.getFromGitRepo()))
                    .addArgument("specsCount", pkg.getSpec().size())
                    .addArgument("artifactsCount", pkg.getArtifact().size())
                    .addArgument("specsJson", serializeSpecs(pkg));

            pkgBuilder.add(new GLabelBuilder(RosModelTypes.LABEL_NAME)
                    .id(pkgId + "_label")
                    .text(pkgType + ": " + nullToEmpty(pkg.getName()))
                    .build());

            for (Artifact artifact : pkg.getArtifact()) {
                Node node = artifact.getNode();
                if (node != null) {
                    String artNodeId = getElementId(node);
                    GNodeBuilder nodeBuilder = new GNodeBuilder(RosModelTypes.ROS_NODE)
                            .id(artNodeId)
                            .size(NODE_WIDTH, 160.0)
                            .addArgument("packageName", nullToEmpty(pkg.getName()))
                            .addArgument("artifactName", nullToEmpty(artifact.getName()))
                            .addArgument("artifactId", getElementId(artifact))
                            .addArgument("nodeName", nullToEmpty(node.getName()))
                            .addArgument("isLifecycle", node.isIsLifecycle())
                            .addArgument("publishersCount", node.getPublisher().size())
                            .addArgument("subscribersCount", node.getSubscriber().size())
                            .addArgument("serviceserversCount", node.getServiceserver().size())
                            .addArgument("serviceclientsCount", node.getServiceclient().size())
                            .addArgument("actionserversCount", node.getActionserver().size())
                            .addArgument("actionclientsCount", node.getActionclient().size())
                            .addArgument("parametersCount", node.getParameter().size())
                            .addArgument("interfacesJson", serializeRosNodeInterfaces(node))
                            .addArgument("parametersJson", serializeNodeParameters(node));
                    pkgBuilder.add(nodeBuilder.build());
                }
            }
            ggraph.getChildren().add(pkgBuilder.build());
        }
    }

    protected String serializeRosParameters(final RosNode rosNode, final Node originNode) {
        Map<String, String> entries = new LinkedHashMap<>();
        if (originNode != null && !originNode.eIsProxy()) {
            for (Parameter p : originNode.getParameter()) {
                entries.put(p.getName(), formatParameterValue(p.getValue()));
            }
        }
        for (RosParameter rp : rosNode.getRosparameters()) {
            entries.put(rp.getName(), formatParameterValue(rp.getValue()));
        }
        StringBuilder sb = new StringBuilder("{");
        boolean first = true;
        for (Map.Entry<String, String> entry : entries.entrySet()) {
            if (!first) {
                sb.append(",");
            }
            first = false;
            sb.append("\"").append(escapeJson(entry.getKey())).append("\":\"")
                    .append(escapeJson(entry.getValue())).append("\"");
        }
        sb.append("}");
        return sb.toString();
    }

    protected String serializeNodeParameters(final Node node) {
        List<String> items = new ArrayList<>();
        for (Parameter p : node.getParameter()) {
            ParameterType pt = p.getType();
            ParameterValue def = RosDslText.parameterTypeDefault(pt);
            items.add("{\"id\":\"" + escapeJson(getElementId(p))
                    + "\",\"name\":\"" + escapeJson(nullToEmpty(p.getName()))
                    + "\",\"type\":\"" + escapeJson(RosDslText.parameterTypeKeyword(pt))
                    + "\",\"typeClass\":\"" + escapeJson(pt != null ? pt.eClass().getName() : "ParameterAnyType")
                    + "\",\"default\":\"" + escapeJson(def != null ? formatParameterValue(def) : "")
                    + "\",\"ns\":\"" + escapeJson(RosDslText.renderNamespace(p.getNamespace()))
                    + "\",\"hasDefault\":" + (def != null)
                    + ",\"value\":\"" + escapeJson(formatParameterValue(p.getValue())) + "\"}");
        }
        return "[" + String.join(",", items) + "]";
    }

    protected String serializeRosNodeInterfaces(final Node node) {
        List<String> items = new ArrayList<>();
        for (InterfaceType iface : RosPackageSetEditor.allInterfaces(node)) {
            String kind = iface.eClass().getName();
            String spec = RosDslText.refText(rosModelState, iface, RosDslText.specFeature(iface));
            items.add(formatInterfaceJson(iface, kind, spec));
        }
        return "[" + String.join(",", items) + "]";
    }

    protected String formatInterfaceJson(final InterfaceType iface, final String kind, final String spec) {
        QualityOfService qos = iface.getQos();
        StringBuilder q = new StringBuilder("{");
        if (qos != null) {
            List<String> fields = new ArrayList<>();
            for (String[] f : RosPackageSetEditor.QOS_FIELDS) {
                addJsonField(fields, f[0], RosPackageSetEditor.qosValue(rosModelState, qos, f[0]));
            }
            q.append(String.join(",", fields));
        }
        q.append("}");
        List<String> states = new ArrayList<>();
        for (LifecycleState st : iface.getActiveStates()) {
            states.add("\"" + escapeJson(st.getLiteral()) + "\"");
        }
        return "{\"id\":\"" + escapeJson(getElementId(iface))
                + "\",\"kind\":\"" + escapeJson(kind)
                + "\",\"kindCode\":\"" + escapeJson(RosDslText.kindCode(iface))
                + "\",\"name\":\"" + escapeJson(nullToEmpty(iface.getName()))
                + "\",\"spec\":\"" + escapeJson(nullToEmpty(spec))
                + "\",\"qosProfile\":\"" + escapeJson(nullToEmpty(RosPackageSetEditor.qosValue(rosModelState, qos, "profile")))
                + "\",\"ns\":\"" + escapeJson(RosDslText.renderNamespace(iface.getNamespace()))
                + "\",\"qos\":" + q
                + ",\"activeStates\":[" + String.join(",", states) + "]}";
    }

    /** Serializes .ros message/service/action specs with their sections and fields. */
    protected String serializeSpecs(final ros.Package pkg) {
        List<String> specs = new ArrayList<>();
        for (SpecBase spec : pkg.getSpec()) {
            List<String> sections = new ArrayList<>();
            List<String> names = spec instanceof ServiceSpec ? List.of("request", "response")
                    : spec instanceof ActionSpec ? List.of("goal", "result", "feedback") : List.of("message");
            for (String section : names) {
                Object defObj = spec.eGet(spec.eClass().getEStructuralFeature(section));
                List<String> fields = new ArrayList<>();
                if (defObj instanceof MessageDefinition def) {
                    for (MessagePart part : def.getMessagePart()) {
                        fields.add("{\"id\":\"" + escapeJson(getElementId(part))
                                + "\",\"type\":\"" + escapeJson(RosDslText.messagePartTypeText(rosModelState, part.getType()))
                                + "\",\"name\":\"" + escapeJson(nullToEmpty(part.getData())) + "\"}");
                    }
                }
                sections.add("{\"name\":\"" + section + "\",\"fields\":[" + String.join(",", fields) + "]}");
            }
            specs.add("{\"id\":\"" + escapeJson(getElementId(spec))
                    + "\",\"name\":\"" + escapeJson(nullToEmpty(spec.getName()))
                    + "\",\"category\":\"" + RosDslText.specCategory(spec)
                    + "\",\"fullname\":\"" + escapeJson(RosDslText.specFullName(spec))
                    + "\",\"sections\":[" + String.join(",", sections) + "]}");
        }
        return "[" + String.join(",", specs) + "]";
    }

    private static void addJsonField(final List<String> fields, final String key, final String value) {
        if (value != null && !value.isBlank()) {
            fields.add("\"" + key + "\":\"" + escapeJson(value) + "\"");
        }
    }

    public static String formatParameterValue(final ParameterValue val) {
        if (val == null) {
            return "";
        }
        if (val instanceof ParameterString ps) {
            return nullToEmpty(ps.getValue());
        } else if (val instanceof ParameterInteger pi) {
            return String.valueOf(pi.getValue());
        } else if (val instanceof ParameterDouble pd) {
            return String.valueOf(pd.getValue());
        } else if (val instanceof ParameterBoolean pb) {
            return String.valueOf(pb.isValue());
        } else if (val instanceof ParameterAny pa) {
            return nullToEmpty(pa.getValue());
        } else if (val instanceof ParameterSequence seq) {
            List<String> items = new ArrayList<>();
            for (ParameterValue child : seq.getValue()) {
                items.add(formatParameterValue(child));
            }
            return "[" + String.join(", ", items) + "]";
        } else if (val instanceof ParameterStruct struct) {
            List<String> members = new ArrayList<>();
            for (ParameterStructMember m : struct.getValue()) {
                members.add(m.getName() + ": " + formatParameterValue(m.getValue()));
            }
            return "{" + String.join(", ", members) + "}";
        }
        return val.toString();
    }

    protected String inferConnectionKind(final RosInterface fromIf) {
        if (fromIf == null || fromIf.getReference() == null) {
            return "topic";
        }
        InterfaceReference ref = fromIf.getReference();
        if (ref instanceof RosServiceServerReference || ref instanceof RosServiceClientReference) {
            return "service";
        }
        if (ref instanceof RosActionServerReference || ref instanceof RosActionClientReference) {
            return "action";
        }
        return "topic";
    }

    /** Id prefix for elements of a referenced subsystem resource (see createSubSystemElement). */
    protected String foreignIdScope;

    /** Separator between a subsystem element id and a fragment inside the subsystem's resource. */
    public static final String SCOPE_SEPARATOR = "::";

    protected String getElementId(final EObject element) {
        String base = baseElementId(element);
        if (foreignIdScope != null && element != null && element.eResource() != null
                && element.eResource() != rosModelState.getSemanticResource()) {
            return foreignIdScope + SCOPE_SEPARATOR + base;
        }
        return base;
    }

    protected String baseElementId(final EObject element) {
        if (idGenerator != null) {
            String id = idGenerator.getOrCreateId(element);
            if (id != null && !id.isEmpty()) {
                return id;
            }
        }
        return EcoreUtil.getURI(element).fragment();
    }

    protected String resolveNodeFromString(final RosNode rosNode) {
        Node from = rosNode.getFrom();
        if (from != null && !from.eIsProxy()) {
            EObject artObj = from.eContainer();
            if (artObj instanceof Artifact art) {
                EObject pkgObj = art.eContainer();
                if (pkgObj instanceof Package pkg) {
                    return pkg.getName() + "." + art.getName() + "." + from.getName();
                }
            }
            if (from.getName() != null) {
                return from.getName();
            }
        }
        return resolveCrossRefText(rosNode, RossystemPackage.Literals.ROS_NODE__FROM);
    }

    protected String resolveSpecName(final EObject holder, final EReference feature, final SpecBase spec) {
        if (spec != null && !spec.eIsProxy()) {
            return nullToEmpty(spec.getFullname());
        }
        return resolveCrossRefText(holder, feature);
    }

    protected String resolveCrossRefText(final EObject holder, final EReference feature) {
        if (holder == null || feature == null) {
            return "";
        }
        List<INode> nodes = NodeModelUtils.findNodesForFeature(holder, feature);
        if (!nodes.isEmpty()) {
            String raw = NodeModelUtils.getTokenText(nodes.get(0)).trim();
            if (raw.length() >= 2 && ((raw.startsWith("\"") && raw.endsWith("\""))
                    || (raw.startsWith("'") && raw.endsWith("'")))) {
                return raw.substring(1, raw.length() - 1);
            }
            return raw;
        }
        return "";
    }

    protected static String nullToEmpty(final String s) {
        return s == null ? "" : s;
    }

    protected static String escapeJson(final String s) {
        if (s == null) {
            return "";
        }
        return s.replace("\\", "\\\\").replace("\"", "\\\"").replace("\n", "\\n").replace("\r", "\\r");
    }

    protected static final class PortDescriptor {
        final String portId;
        final String portType;
        final String name;
        final String originName;
        final String specName;
        final boolean isExplicit;
        final EObject originElement;

        PortDescriptor(
                final String portId,
                final String portType,
                final String name,
                final String originName,
                final String specName,
                final boolean isExplicit,
                final EObject originElement) {
            this.portId = portId;
            this.portType = portType;
            this.name = name != null ? name : "";
            this.originName = originName != null ? originName : "";
            this.specName = specName != null ? specName : "";
            this.isExplicit = isExplicit;
            this.originElement = originElement;
        }
    }
}
