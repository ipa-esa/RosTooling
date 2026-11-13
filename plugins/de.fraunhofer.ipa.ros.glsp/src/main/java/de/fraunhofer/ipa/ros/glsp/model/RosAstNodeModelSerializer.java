package de.fraunhofer.ipa.ros.glsp.model;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.XtextResource;
import ros.ActionClient;
import ros.ActionServer;
import ros.Artifact;
import ros.InterfaceType;
import ros.Node;
import ros.Package;
import ros.PackageSet;
import ros.Parameter;
import ros.ParameterBoolean;
import ros.ParameterDouble;
import ros.ParameterInteger;
import ros.ParameterSequence;
import ros.ParameterString;
import ros.ParameterStruct;
import ros.ParameterStructMember;
import ros.ParameterValue;
import ros.Publisher;
import ros.RosPackage;
import ros.ServiceClient;
import ros.ServiceServer;
import ros.Subscriber;
import system.Component;
import system.Connection;
import system.InterfaceReference;
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

/**
 * Node-model-guided AST serializer for Xtext RosTooling resources (.rossystem, .ros2, .ros1, .ros).
 * Applies surgical span edits via Xtext's ICompositeNode offsets so unaffected lines,
 * formatting, and inline/header '#' comments are 100% preserved.
 */
public final class RosAstNodeModelSerializer {

    private RosAstNodeModelSerializer() {}

    public static final class SpanEdit {
        public final int offset;
        public final int length;
        public final String replacement;

        public SpanEdit(final int offset, final int length, final String replacement) {
            this.offset = offset;
            this.length = length;
            this.replacement = replacement;
        }
    }

    /** Result of a surgical synchronization: the applied span edits in base-text coordinates. */
    public static final class TextChange {
        public final String baseText;
        public final String newText;
        /** Non-overlapping edits, ordered by offset, relative to {@link #baseText}. */
        public final List<SpanEdit> edits;

        TextChange(final String baseText, final String newText, final List<SpanEdit> edits) {
            this.baseText = baseText;
            this.newText = newText;
            this.edits = edits;
        }
    }

    /**
     * Synchronizes any in-memory Ecore AST mutations back into the XtextResource's
     * text and node model using surgical span replacements, then returns the updated text.
     */
    public static String synchronizeAndFormat(final RosModelState modelState) throws IOException {
        EObject rootModel = modelState.getSemanticModel();
        if (rootModel == null) {
            return "";
        }
        if (extractContext(modelState) == null) {
            return rootModel instanceof system.System sys ? serializeFullSystem(sys) : "";
        }
        return computeAndCommit(modelState).newText;
    }

    /**
     * Computes the surgical span edits for all pending AST mutations, applies them to the
     * resource (reparse) and returns them. Nothing is written to disk: the VS Code extension
     * applies the returned edits to the open document as an undoable WorkspaceEdit.
     */
    public static TextChange computeAndCommit(final RosModelState modelState) throws IOException {
        EObject rootModel = modelState.getSemanticModel();
        OptionalXtextContext ctx = rootModel == null ? null : extractContext(modelState);
        if (ctx == null) {
            modelState.clearTextEditState();
            return new TextChange("", "", List.of());
        }

        String originalText = ctx.originalText;
        List<SpanEdit> edits = new ArrayList<>();

        if (rootModel instanceof system.System sys) {
            collectSystemEdits(modelState, sys, originalText, ctx.rootNode, edits);
        } else if (modelState.isPackageModel()) {
            new RosPackageSetSerializer(modelState, originalText, edits)
                    .collect(rootModel, modelState.getPackageModelPackages(), ctx.rootNode);
        }

        if (edits.isEmpty()) {
            modelState.clearTextEditState();
            return new TextChange(originalText, originalText, List.of());
        }

        relocateInsertionsOutOfDeletions(originalText, edits);
        List<SpanEdit> applied = new ArrayList<>();
        String updatedText = applyEdits(originalText, edits, applied);
        ctx.xtextResource.reparse(updatedText);
        if (!ctx.xtextResource.getContents().isEmpty()) {
            modelState.setSemanticModel(ctx.xtextResource.getContents().get(0));
        }
        // Resolve all lazy-linking proxies now: resolving them later inside an EMF ChangeCommand
        // mutates lists while the ChangeRecorder consolidates (ConcurrentModificationException).
        if (ctx.xtextResource.getResourceSet() != null) {
            org.eclipse.emf.ecore.util.EcoreUtil.resolveAll(ctx.xtextResource.getResourceSet());
        } else {
            org.eclipse.emf.ecore.util.EcoreUtil.resolveAll(ctx.xtextResource);
        }
        modelState.clearTextEditState();
        // Same-offset insertions must keep their collection order (VS Code applies same-position
        // TextEdits in array order).
        applied.sort(Comparator.comparingInt((SpanEdit e) -> e.offset).thenComparingInt(edits::indexOf));
        return new TextChange(originalText, updatedText, applied);
    }

    public static void saveToFile(final RosModelState modelState, final Path filePath) throws IOException {
        String content = synchronizeAndFormat(modelState);
        Files.writeString(filePath, content, StandardCharsets.UTF_8);
    }

    private static final class OptionalXtextContext {
        final XtextResource xtextResource;
        final ICompositeNode rootNode;
        final String originalText;

        OptionalXtextContext(
                final XtextResource xtextResource,
                final ICompositeNode rootNode,
                final String originalText) {
            this.xtextResource = xtextResource;
            this.rootNode = rootNode;
            this.originalText = originalText;
        }
    }

    private static OptionalXtextContext extractContext(final RosModelState modelState) {
        if (modelState.getXtextResource().isEmpty()) {
            return null;
        }
        XtextResource xtextRes = modelState.getXtextResource().get();
        IParseResult parseResult = xtextRes.getParseResult();
        if (parseResult == null || parseResult.getRootNode() == null) {
            return null;
        }
        ICompositeNode rootNode = parseResult.getRootNode();
        String text = rootNode.getText();
        if (text == null || text.isEmpty()) {
            return null;
        }
        return new OptionalXtextContext(xtextRes, rootNode, text);
    }

    private static void collectSystemEdits(
            final RosModelState modelState,
            final system.System sys,
            final String text,
            final ICompositeNode rootNode,
            final List<SpanEdit> edits) {
        // 1. Collect deleted semantic elements whose ICompositeNode is still in rootNode
        Set<EObject> liveObjects = java.util.Collections.newSetFromMap(new IdentityHashMap<>());
        liveObjects.add(sys);
        sys.eAllContents().forEachRemaining(liveObjects::add);

        List<ICompositeNode> deletedNodes = new ArrayList<>();
        for (INode node : rootNode.getAsTreeIterable()) {
            if (node instanceof ICompositeNode compNode && node.hasDirectSemanticElement()) {
                EObject sem = node.getSemanticElement();
                if ((sem instanceof RosNode
                                || sem instanceof system.SubSystem
                                || sem instanceof system.Process
                                || sem instanceof RosInterface
                                || sem instanceof RosParameter
                                || sem instanceof RosSystemConnection)
                        && !liveObjects.contains(sem)) {
                    // Skip if an ancestor is already marked for deletion
                    boolean ancestorDeleted = false;
                    for (ICompositeNode prev : deletedNodes) {
                        if (node.getOffset() >= prev.getOffset()
                                && node.getEndOffset() <= prev.getEndOffset()) {
                            ancestorDeleted = true;
                            break;
                        }
                    }
                    if (!ancestorDeleted) {
                        deletedNodes.add(compNode);
                    }
                }
            }
        }

        for (ICompositeNode delNode : deletedNodes) {
            int[] lineSpan = computeElementLineDeletionSpan(text, delNode);
            edits.add(new SpanEdit(lineSpan[0], lineSpan[1] - lineSpan[0], ""));
        }
        if (!deletedNodes.isEmpty()) {
            removeEmptiedSystemSections(sys, text, edits);
        }

        // 2. Check System-level scalar properties
        checkFeatureTokenEdit(sys, RossystemPackage.Literals.SYSTEM__NAME, sys.getName(), false, text, edits);
        if (sys.getFromFile() != null) {
            checkFeatureTokenEdit(sys, RossystemPackage.Literals.SYSTEM__FROM_FILE, sys.getFromFile(), true, text, edits);
        }

        // 3a. Newly added SubSystems: one reference line each in the 'subSystems:' section
        List<system.SubSystem> newSubs = new ArrayList<>();
        ICompositeNode lastExistingSubComp = null;
        for (Component comp : sys.getComponents()) {
            if (comp instanceof system.SubSystem subSys) {
                ICompositeNode subComp = NodeModelUtils.findActualNodeFor(subSys);
                if (subComp == null) {
                    newSubs.add(subSys);
                } else {
                    lastExistingSubComp = subComp;
                }
            }
        }
        if (!newSubs.isEmpty()) {
            StringBuilder subLines = new StringBuilder();
            for (system.SubSystem s : newSubs) {
                String name = modelState.getRefTextHint(s);
                if (name == null && s.getSystem() != null && !s.getSystem().eIsProxy()) {
                    name = s.getSystem().getName();
                }
                if (name != null && !name.isBlank()) {
                    subLines.append("    ").append(name).append("\n");
                }
            }
            if (subLines.length() > 0) {
                if (lastExistingSubComp != null) {
                    int insertPos = findElementBlockEndOffset(text, lastExistingSubComp);
                    edits.add(new SpanEdit(insertPos, 0, "\n" + stripTrailingNewline(subLines.toString())));
                } else {
                    List<INode> anchor = NodeModelUtils.findNodesForFeature(sys, RossystemPackage.Literals.SYSTEM__FROM_FILE);
                    if (anchor.isEmpty()) {
                        anchor = NodeModelUtils.findNodesForFeature(sys, RossystemPackage.Literals.SYSTEM__NAME);
                    }
                    int pos = anchor.isEmpty() ? text.indexOf('\n') : findLineEndOffsetWithoutNewline(text, lastNonHiddenOffset(anchor.get(0)));
                    edits.add(new SpanEdit(Math.max(0, pos), 0, "\n  subSystems:\n" + stripTrailingNewline(subLines.toString())));
                }
            }
        }

        // 3b. Processes (composable node containers): new blocks + field-granular edits
        collectProcessEdits(modelState, sys, text, edits);

        // 3. Check existing RosNodes & collect newly added RosNodes
        List<RosNode> newNodes = new ArrayList<>();
        ICompositeNode lastExistingRosNodeComp = null;

        for (Component comp : sys.getComponents()) {
            if (comp instanceof RosNode rosNode) {
                ICompositeNode nodeComp = NodeModelUtils.findActualNodeFor(rosNode);
                if (nodeComp == null) {
                    newNodes.add(rosNode);
                } else {
                    lastExistingRosNodeComp = nodeComp;
                    collectExistingRosNodeEdits(rosNode, nodeComp, text, edits);
                }
            }
        }

        if (!newNodes.isEmpty()) {
            StringBuilder nodesBlock = new StringBuilder();
            for (RosNode rn : newNodes) {
                nodesBlock.append(serializeRosNode(rn, "    "));
            }
            if (lastExistingRosNodeComp != null) {
                int insertPos = findElementBlockEndOffset(text, lastExistingRosNodeComp);
                edits.add(new SpanEdit(insertPos, 0, "\n" + stripTrailingNewline(nodesBlock.toString())));
            } else {
                int sysEnd = findSystemNodesInsertionOffset(text, rootNode);
                String section = "\n  nodes:\n" + stripTrailingNewline(nodesBlock.toString());
                edits.add(new SpanEdit(sysEnd, 0, section));
            }
        }

        // 4. Check existing Connections & collect newly added Connections
        List<RosSystemConnection> newConns = new ArrayList<>();
        ICompositeNode lastExistingConnComp = null;

        for (Connection conn : sys.getConnections()) {
            if (conn instanceof RosSystemConnection sysConn) {
                ICompositeNode connComp = NodeModelUtils.findActualNodeFor(sysConn);
                if (connComp == null) {
                    newConns.add(sysConn);
                } else {
                    lastExistingConnComp = connComp;
                    if (sysConn.getFrom() != null) {
                        checkFeatureTokenEdit(
                                sysConn,
                                RossystemPackage.Literals.ROS_SYSTEM_CONNECTION__FROM,
                                sysConn.getFrom().getName(),
                                false,
                                text,
                                edits);
                    }
                    if (sysConn.getTo() != null) {
                        checkFeatureTokenEdit(
                                sysConn,
                                RossystemPackage.Literals.ROS_SYSTEM_CONNECTION__TO,
                                sysConn.getTo().getName(),
                                false,
                                text,
                                edits);
                    }
                }
            }
        }

        if (!newConns.isEmpty()) {
            StringBuilder connLines = new StringBuilder();
            for (RosSystemConnection sc : newConns) {
                String fromName = sc.getFrom() != null ? sc.getFrom().getName() : "";
                String toName = sc.getTo() != null ? sc.getTo().getName() : "";
                connLines.append("    - [ ").append(fromName).append(" , ").append(toName).append(" ]\n");
            }
            if (lastExistingConnComp != null) {
                int insertPos = findElementBlockEndOffset(text, lastExistingConnComp);
                edits.add(new SpanEdit(insertPos, 0, "\n" + stripTrailingNewline(connLines.toString())));
            } else {
                int insertPos = text.length();
                while (insertPos > 0 && (text.charAt(insertPos - 1) == '\n' || text.charAt(insertPos - 1) == '\r')) {
                    insertPos--;
                }
                String section = "\n  connections:\n" + stripTrailingNewline(connLines.toString());
                edits.add(new SpanEdit(insertPos, 0, section));
            }
        }
    }

    private static void collectExistingRosNodeEdits(
            final RosNode rosNode,
            final ICompositeNode nodeComp,
            final String text,
            final List<SpanEdit> edits) {
        checkFeatureTokenEdit(rosNode, RossystemPackage.Literals.ROS_NODE__NAME, rosNode.getName(), false, text, edits);
        if (rosNode.getNamespace() != null && !rosNode.getNamespace().isEmpty()) {
            List<INode> nsNodes = NodeModelUtils.findNodesForFeature(rosNode, RossystemPackage.Literals.ROS_NODE__NAMESPACE);
            if (!nsNodes.isEmpty()) {
                checkFeatureTokenEdit(rosNode, RossystemPackage.Literals.ROS_NODE__NAMESPACE, rosNode.getNamespace(), true, text, edits);
            } else {
                // Insert namespace: after from: line
                List<INode> fromNodes = NodeModelUtils.findNodesForFeature(rosNode, RossystemPackage.Literals.ROS_NODE__FROM);
                if (!fromNodes.isEmpty()) {
                    int lineEnd = findLineEndOffsetWithoutNewline(text, lastNonHiddenOffset(fromNodes.get(0)));
                    edits.add(new SpanEdit(lineEnd, 0, "\n      namespace: \"" + rosNode.getNamespace() + "\""));
                }
            }
        }

        // Check existing RosInterfaces & collect new RosInterfaces
        List<RosInterface> newInterfaces = new ArrayList<>();
        ICompositeNode lastExistingIfComp = null;
        for (RosInterface ri : rosNode.getRosinterfaces()) {
            ICompositeNode ifComp = NodeModelUtils.findActualNodeFor(ri);
            if (ifComp == null) {
                newInterfaces.add(ri);
            } else {
                lastExistingIfComp = ifComp;
                checkFeatureTokenEdit(ri, RossystemPackage.Literals.ROS_INTERFACE__NAME, ri.getName(), false, text, edits);
            }
        }

        if (!newInterfaces.isEmpty()) {
            StringBuilder ifBlock = new StringBuilder();
            for (RosInterface ri : newInterfaces) {
                ifBlock.append(serializeRosInterface(ri, "        "));
            }
            if (lastExistingIfComp != null) {
                int insertPos = findElementBlockEndOffset(text, lastExistingIfComp);
                edits.add(new SpanEdit(insertPos, 0, "\n" + stripTrailingNewline(ifBlock.toString())));
            } else {
                // Insert interfaces: block after namespace or from
                int anchorOffset = findAfterFromOrNamespaceOffset(rosNode, nodeComp, text);
                String section = "\n      interfaces:\n" + stripTrailingNewline(ifBlock.toString());
                edits.add(new SpanEdit(anchorOffset, 0, section));
            }
        }

        // Check existing RosParameters & collect new RosParameters
        List<RosParameter> newParams = new ArrayList<>();
        ICompositeNode lastExistingParamComp = null;
        for (RosParameter rp : rosNode.getRosparameters()) {
            ICompositeNode paramComp = NodeModelUtils.findActualNodeFor(rp);
            if (paramComp == null) {
                newParams.add(rp);
            } else {
                lastExistingParamComp = paramComp;
                checkFeatureTokenEdit(rp, RossystemPackage.Literals.ROS_PARAMETER__NAME, rp.getName(), false, text, edits);
                if (rp.getValue() != null) {
                    String formattedVal = formatDslParameterValue(rp.getValue());
                    checkFeatureRawSpanEdit(rp, RossystemPackage.Literals.ROS_PARAMETER__VALUE, formattedVal, text, edits);
                }
            }
        }

        if (!newParams.isEmpty()) {
            StringBuilder paramBlock = new StringBuilder();
            for (RosParameter rp : newParams) {
                paramBlock.append(serializeRosParameter(rp, rosNode, "        "));
            }
            if (lastExistingParamComp != null) {
                int insertPos = findElementBlockEndOffset(text, lastExistingParamComp);
                edits.add(new SpanEdit(insertPos, 0, "\n" + stripTrailingNewline(paramBlock.toString())));
            } else {
                int insertPos = findElementBlockEndOffset(text, nodeComp);
                String section = "\n      parameters:\n" + stripTrailingNewline(paramBlock.toString());
                edits.add(new SpanEdit(insertPos, 0, section));
            }
        }
    }

    private static int lineStartOf(final String text, final int offset) {
        int i = Math.min(Math.max(0, offset), text.length());
        while (i > 0 && text.charAt(i - 1) != '\n' && text.charAt(i - 1) != '\r') {
            i--;
        }
        return i;
    }

    private static int lineEndInclusiveOf(final String text, final int offset) {
        int i = findLineEndOffsetWithoutNewline(text, offset);
        if (i < text.length() && text.charAt(i) == '\r') i++;
        if (i < text.length() && text.charAt(i) == '\n') i++;
        return i;
    }

    private static String processMemberList(final system.Process proc) {
        List<String> names = new ArrayList<>();
        for (Component c : proc.getComponents()) {
            if (c instanceof RosNode rn && rn.getName() != null) {
                names.add(rn.getName());
            }
        }
        return String.join(" , ", names);
    }

    /**
     * Processes are edited like everything else: a renamed process or changed thread count replaces
     * one token, membership changes rewrite only the names between {@code [ ]} of {@code nodes:},
     * and new processes are inserted as blocks into the {@code processes:} section.
     */
    private static void collectProcessEdits(
            final RosModelState modelState, final system.System sys, final String text, final List<SpanEdit> edits) {
        List<system.Process> fresh = new ArrayList<>();
        ICompositeNode lastExisting = null;
        for (system.Process proc : sys.getProcesses()) {
            ICompositeNode comp = NodeModelUtils.findActualNodeFor(proc);
            if (comp == null) {
                fresh.add(proc);
                continue;
            }
            lastExisting = comp;
            checkFeatureTokenEdit(proc, RossystemPackage.Literals.PROCESS__NAME, proc.getName(), false, text, edits);
            int nameCol = firstNonHiddenOffset(comp) - lineStartOf(text, firstNonHiddenOffset(comp));
            String inner = " ".repeat(nameCol + 2);
            List<INode> nameNodes = NodeModelUtils.findNodesForFeature(proc, RossystemPackage.Literals.PROCESS__NAME);
            int headerEnd = findLineEndOffsetWithoutNewline(text,
                    nameNodes.isEmpty() ? firstNonHiddenOffset(comp) : lastNonHiddenOffset(nameNodes.get(0)));

            List<INode> threadNodes = NodeModelUtils.findNodesForFeature(proc, RossystemPackage.Literals.PROCESS__THREADS);
            String members = processMemberList(proc);
            List<INode> refNodes = NodeModelUtils.findNodesForFeature(proc, RossystemPackage.Literals.PROCESS__COMPONENTS);
            if (!refNodes.isEmpty()) {
                int s = firstNonHiddenOffset(refNodes.get(0));
                int e = lastNonHiddenOffset(refNodes.get(refNodes.size() - 1));
                List<String> current = new ArrayList<>();
                for (INode n : refNodes) {
                    current.add(RosDslText.unquote(NodeModelUtils.getTokenText(n).trim()));
                }
                if (members.isEmpty()) {
                    ILeafNode kw = RosPackageSetSerializer.findOwnKeywordLeaf(proc, comp, "nodes:", Integer.MAX_VALUE);
                    int ls = lineStartOf(text, kw != null ? kw.getOffset() : s);
                    if (threadNodes.isEmpty()) {
                        // A process block must not become empty: keep a threads line instead.
                        int le = findLineEndOffsetWithoutNewline(text, e);
                        edits.add(new SpanEdit(ls, le - ls, inner + "threads: " + Math.max(1, proc.getThreads())));
                    } else {
                        edits.add(new SpanEdit(ls, lineEndInclusiveOf(text, e) - ls, ""));
                    }
                } else if (!String.join(" , ", current).equals(members)) {
                    edits.add(new SpanEdit(s, e - s, members));
                }
            } else if (!members.isEmpty()) {
                edits.add(new SpanEdit(headerEnd, 0, "\n" + inner + "nodes: [ " + members + " ]"));
            }
            if (!threadNodes.isEmpty()) {
                if (proc.getThreads() > 0) {
                    checkFeatureRawSpanEdit(proc, RossystemPackage.Literals.PROCESS__THREADS,
                            String.valueOf(proc.getThreads()), text, edits);
                }
            } else if (proc.getThreads() > 0 && !(members.isEmpty() && !refNodes.isEmpty())) {
                int anchor = refNodes.isEmpty() ? headerEnd
                        : findLineEndOffsetWithoutNewline(text, lastNonHiddenOffset(refNodes.get(refNodes.size() - 1)));
                edits.add(new SpanEdit(anchor, 0, "\n" + inner + "threads: " + proc.getThreads()));
            }
        }
        if (fresh.isEmpty()) {
            return;
        }
        StringBuilder blocks = new StringBuilder();
        String indent = lastExisting != null
                ? " ".repeat(firstNonHiddenOffset(lastExisting) - lineStartOf(text, firstNonHiddenOffset(lastExisting)))
                : "    ";
        for (system.Process proc : fresh) {
            blocks.append(indent).append(proc.getName()).append(":\n");
            String members = processMemberList(proc);
            if (!members.isEmpty()) {
                blocks.append(indent).append("  nodes: [ ").append(members).append(" ]\n");
            }
            blocks.append(indent).append("  threads: ").append(Math.max(1, proc.getThreads())).append('\n');
        }
        if (lastExisting != null) {
            int pos = findElementBlockEndOffset(text, lastExisting);
            edits.add(new SpanEdit(pos, 0, "\n" + stripTrailingNewline(blocks.toString())));
            return;
        }
        // New 'processes:' section after the subsystems (or the system header).
        int anchor = -1;
        for (Component c : sys.getComponents()) {
            if (c instanceof system.SubSystem sub) {
                ICompositeNode subComp = NodeModelUtils.findActualNodeFor(sub);
                if (subComp != null) {
                    anchor = Math.max(anchor, findElementBlockEndOffset(text, subComp));
                }
            }
        }
        if (anchor < 0) {
            List<INode> header = NodeModelUtils.findNodesForFeature(sys, RossystemPackage.Literals.SYSTEM__FROM_FILE);
            if (header.isEmpty()) {
                header = NodeModelUtils.findNodesForFeature(sys, RossystemPackage.Literals.SYSTEM__NAME);
            }
            anchor = header.isEmpty() ? text.indexOf('\n') : findLineEndOffsetWithoutNewline(text, lastNonHiddenOffset(header.get(0)));
        }
        edits.add(new SpanEdit(Math.max(0, anchor), 0, "\n  processes:\n" + stripTrailingNewline(blocks.toString())));
    }

    /** Empty sections are not valid in the indentation grammar: drop their keyword line. */
    private static void removeEmptiedSystemSections(final system.System sys, final String text, final List<SpanEdit> edits) {
        ICompositeNode sysComp = NodeModelUtils.findActualNodeFor(sys);
        boolean hasSub = false;
        boolean hasNode = false;
        for (Component c : sys.getComponents()) {
            hasSub |= c instanceof system.SubSystem;
            hasNode |= c instanceof RosNode;
        }
        if (!hasSub) removeKeywordLine(sys, sysComp, "subSystems:", text, edits);
        if (!hasNode) removeKeywordLine(sys, sysComp, "nodes:", text, edits);
        if (sys.getConnections().isEmpty()) removeKeywordLine(sys, sysComp, "connections:", text, edits);
        if (sys.getProcesses().isEmpty()) removeKeywordLine(sys, sysComp, "processes:", text, edits);
        for (Component c : sys.getComponents()) {
            if (c instanceof RosNode rn) {
                ICompositeNode rnComp = NodeModelUtils.findActualNodeFor(rn);
                if (rnComp == null) continue;
                if (rn.getRosinterfaces().isEmpty()) removeKeywordLine(rn, rnComp, "interfaces:", text, edits);
                if (rn.getRosparameters().isEmpty()) removeKeywordLine(rn, rnComp, "parameters:", text, edits);
            }
        }
    }

    private static void removeKeywordLine(
            final EObject owner, final ICompositeNode ownerComp, final String keyword, final String text, final List<SpanEdit> edits) {
        ILeafNode kw = RosPackageSetSerializer.findOwnKeywordLeaf(owner, ownerComp, keyword, Integer.MAX_VALUE);
        if (kw == null) return;
        int start = kw.getOffset();
        while (start > 0 && text.charAt(start - 1) != '\n' && text.charAt(start - 1) != '\r') start--;
        int end = findLineEndOffsetWithoutNewline(text, kw.getEndOffset());
        if (end < text.length() && text.charAt(end) == '\r') end++;
        if (end < text.length() && text.charAt(end) == '\n') end++;
        for (SpanEdit e : edits) {
            if (e.offset == start && e.length == end - start) return;
        }
        edits.add(new SpanEdit(start, end - start, ""));
    }

    /**
     * An insertion anchored at the end of a block whose trailing lines are being deleted would
     * overlap that deletion (and the overlap guard in applyEdits would drop one of them).
     * Moving the insertion to the line end just before the deleted lines yields the same text.
     */
    static void relocateInsertionsOutOfDeletions(final String text, final List<SpanEdit> edits) {
        boolean moved = true;
        int guard = 0;
        while (moved && guard++ < 64) {
            moved = false;
            for (int i = 0; i < edits.size(); i++) {
                SpanEdit ins = edits.get(i);
                if (ins.length != 0) {
                    continue;
                }
                for (SpanEdit del : edits) {
                    boolean wholeLineDeletion = del.length > 0 && del.replacement.isEmpty()
                            && (del.offset == 0 || text.charAt(del.offset - 1) == '\n');
                    if (wholeLineDeletion && ins.offset > del.offset && ins.offset < del.offset + del.length) {
                        edits.set(i, new SpanEdit(Math.max(0, del.offset - 1), 0, ins.replacement));
                        moved = true;
                        break;
                    }
                }
            }
        }
    }

    static void checkFeatureTokenEdit(
            final EObject holder,
            final EStructuralFeature feature,
            final String newValue,
            final boolean preferQuotes,
            final String text,
            final List<SpanEdit> edits) {
        if (newValue == null) {
            return;
        }
        List<INode> nodes = NodeModelUtils.findNodesForFeature(holder, feature);
        if (nodes.isEmpty()) {
            return;
        }
        INode fNode = nodes.get(0);
        int start = firstNonHiddenOffset(fNode);
        int end = lastNonHiddenOffset(fNode);
        if (start < 0 || end < start || end > text.length()) {
            return;
        }
        String currentRaw = text.substring(start, end);
        boolean wasQuoted = currentRaw.length() >= 2
                && ((currentRaw.startsWith("\"") && currentRaw.endsWith("\""))
                        || (currentRaw.startsWith("'") && currentRaw.endsWith("'")));
        String currentUnquoted = wasQuoted ? currentRaw.substring(1, currentRaw.length() - 1) : currentRaw;
        if (currentUnquoted.equals(newValue)) {
            return;
        }
        boolean needsQuotes = wasQuoted || preferQuotes || newValue.contains("/") || newValue.contains("::") || newValue.contains(".");
        char quoteChar = wasQuoted && currentRaw.startsWith("'") ? '\'' : '"';
        String replacement = needsQuotes ? quoteChar + newValue + quoteChar : newValue;
        edits.add(new SpanEdit(start, end - start, replacement));
    }

    static void checkFeatureRawSpanEdit(
            final EObject holder,
            final EStructuralFeature feature,
            final String newRawLiteral,
            final String text,
            final List<SpanEdit> edits) {
        if (newRawLiteral == null) {
            return;
        }
        List<INode> nodes = NodeModelUtils.findNodesForFeature(holder, feature);
        if (nodes.isEmpty()) {
            return;
        }
        INode fNode = nodes.get(0);
        int start = firstNonHiddenOffset(fNode);
        int end = lastNonHiddenOffset(fNode);
        if (start < 0 || end < start || end > text.length()) {
            return;
        }
        String currentRaw = text.substring(start, end);
        if (!currentRaw.equals(newRawLiteral)) {
            edits.add(new SpanEdit(start, end - start, newRawLiteral));
        }
    }

    public static String serializeFullSystem(final system.System sys) {
        StringBuilder sb = new StringBuilder();
        sb.append(sys.getName()).append(":\n");
        if (sys.getFromFile() != null && !sys.getFromFile().isEmpty()) {
            sb.append("  fromFile: \"").append(sys.getFromFile()).append("\"\n");
        }
        List<RosNode> rosNodes = new ArrayList<>();
        for (Component c : sys.getComponents()) {
            if (c instanceof RosNode rn) {
                rosNodes.add(rn);
            }
        }
        if (!rosNodes.isEmpty()) {
            sb.append("  nodes:\n");
            for (RosNode rn : rosNodes) {
                sb.append(serializeRosNode(rn, "    "));
            }
        }
        if (!sys.getConnections().isEmpty()) {
            sb.append("  connections:\n");
            for (Connection conn : sys.getConnections()) {
                if (conn instanceof RosSystemConnection sc) {
                    String fromName = sc.getFrom() != null ? sc.getFrom().getName() : "";
                    String toName = sc.getTo() != null ? sc.getTo().getName() : "";
                    sb.append("    - [ ").append(fromName).append(" , ").append(toName).append(" ]\n");
                }
            }
        }
        return sb.toString();
    }

    public static String serializeRosNode(final RosNode rn, final String indent) {
        StringBuilder sb = new StringBuilder();
        sb.append(indent).append(rn.getName()).append(":\n");
        sb.append(indent).append("  from: \"").append(formatNodeFromCrossRef(rn)).append("\"\n");
        if (rn.getNamespace() != null && !rn.getNamespace().isEmpty()) {
            sb.append(indent).append("  namespace: \"").append(rn.getNamespace()).append("\"\n");
        }
        if (!rn.getRosinterfaces().isEmpty()) {
            sb.append(indent).append("  interfaces:\n");
            for (RosInterface ri : rn.getRosinterfaces()) {
                sb.append(serializeRosInterface(ri, indent + "    "));
            }
        }
        if (!rn.getRosparameters().isEmpty()) {
            sb.append(indent).append("  parameters:\n");
            for (RosParameter rp : rn.getRosparameters()) {
                sb.append(serializeRosParameter(rp, rn, indent + "    "));
            }
        }
        return sb.toString();
    }

    public static String serializeRosInterface(final RosInterface ri, final String indent) {
        String prefix = "pub->";
        String targetRef = "";
        InterfaceReference ref = ri.getReference();
        if (ref instanceof RosPublisherReference pubRef) {
            prefix = "pub->";
            targetRef = formatInterfaceTargetCrossRef(pubRef.getFrom());
        } else if (ref instanceof RosSubscriberReference subRef) {
            prefix = "sub->";
            targetRef = formatInterfaceTargetCrossRef(subRef.getFrom());
        } else if (ref instanceof RosServiceServerReference ssRef) {
            prefix = "ss->";
            targetRef = formatInterfaceTargetCrossRef(ssRef.getFrom());
        } else if (ref instanceof RosServiceClientReference scRef) {
            prefix = "sc->";
            targetRef = formatInterfaceTargetCrossRef(scRef.getFrom());
        } else if (ref instanceof RosActionServerReference asRef) {
            prefix = "as->";
            targetRef = formatInterfaceTargetCrossRef(asRef.getFrom());
        } else if (ref instanceof RosActionClientReference acRef) {
            prefix = "ac->";
            targetRef = formatInterfaceTargetCrossRef(acRef.getFrom());
        }
        return indent + "- " + ri.getName() + ": " + prefix + " \"" + targetRef + "\"\n";
    }

    public static String serializeRosParameter(
            final RosParameter rp,
            final RosNode ownerNode,
            final String indent) {
        String targetRef = "";
        Parameter fromParam = rp.getFrom();
        if (fromParam != null && !fromParam.eIsProxy()) {
            targetRef = formatInterfaceTargetCrossRef(fromParam);
        } else if (ownerNode != null && ownerNode.getFrom() != null && !ownerNode.getFrom().eIsProxy()) {
            Node originNode = ownerNode.getFrom();
            if (originNode.eContainer() instanceof Artifact art) {
                targetRef = art.getName() + "::" + rp.getName();
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(indent).append("- ").append(rp.getName()).append(": \"").append(targetRef).append("\"\n");
        sb.append(indent).append("  value: ").append(formatDslParameterValue(rp.getValue())).append("\n");
        return sb.toString();
    }

    public static String formatNodeFromCrossRef(final RosNode rn) {
        Node from = rn.getFrom();
        if (from != null && !from.eIsProxy()) {
            if (from.eContainer() instanceof Artifact art && art.eContainer() instanceof Package pkg) {
                return pkg.getName() + "." + from.getName();
            }
            return from.getName();
        }
        List<INode> nodes = NodeModelUtils.findNodesForFeature(rn, RossystemPackage.Literals.ROS_NODE__FROM);
        if (!nodes.isEmpty()) {
            String raw = NodeModelUtils.getTokenText(nodes.get(0)).trim();
            if (raw.length() >= 2 && raw.startsWith("\"") && raw.endsWith("\"")) {
                return raw.substring(1, raw.length() - 1);
            }
            return raw;
        }
        return "";
    }

    public static String formatInterfaceTargetCrossRef(final InterfaceType ifType) {
        if (ifType == null || ifType.eIsProxy()) {
            return "";
        }
        if (ifType.eContainer() instanceof Node node && node.eContainer() instanceof Artifact art) {
            return art.getName() + "::" + ifType.getName();
        }
        return ifType.getName();
    }

    public static String formatDslParameterValue(final ParameterValue val) {
        if (val == null) {
            return "\"\"";
        }
        if (val instanceof ParameterString ps) {
            return "\"" + (ps.getValue() != null ? ps.getValue() : "") + "\"";
        } else if (val instanceof ParameterInteger pi) {
            return String.valueOf(pi.getValue());
        } else if (val instanceof ParameterDouble pd) {
            return String.valueOf(pd.getValue());
        } else if (val instanceof ParameterBoolean pb) {
            return String.valueOf(pb.isValue());
        } else if (val instanceof ParameterSequence seq) {
            List<String> items = new ArrayList<>();
            for (ParameterValue child : seq.getValue()) {
                items.add(formatDslParameterValue(child));
            }
            return "[ " + String.join(" , ", items) + " ]";
        } else if (val instanceof ParameterStruct struct) {
            List<String> items = new ArrayList<>();
            for (ParameterStructMember m : struct.getValue()) {
                items.add(m.getName() + ": " + formatDslParameterValue(m.getValue()));
            }
            return "[ " + String.join(" , ", items) + " ]";
        }
        return "\"" + val.toString() + "\"";
    }

    static int firstNonHiddenOffset(final INode node) {
        for (ILeafNode leaf : node.getLeafNodes()) {
            if (!leaf.isHidden()) {
                return leaf.getOffset();
            }
        }
        return node.getOffset();
    }

    static int lastNonHiddenOffset(final INode node) {
        int end = -1;
        for (ILeafNode leaf : node.getLeafNodes()) {
            if (!leaf.isHidden() && leaf.getLength() > 0) {
                end = leaf.getEndOffset();
            }
        }
        return end >= 0 ? end : node.getEndOffset();
    }

    static int findElementBlockEndOffset(final String text, final ICompositeNode compNode) {
        int lastTokenEnd = lastNonHiddenOffset(compNode);
        return findLineEndOffsetWithoutNewline(text, lastTokenEnd);
    }

    private static int findAfterFromOrNamespaceOffset(
            final RosNode rosNode,
            final ICompositeNode nodeComp,
            final String text) {
        List<INode> nsNodes = NodeModelUtils.findNodesForFeature(rosNode, RossystemPackage.Literals.ROS_NODE__NAMESPACE);
        if (!nsNodes.isEmpty()) {
            return findLineEndOffsetWithoutNewline(text, lastNonHiddenOffset(nsNodes.get(0)));
        }
        List<INode> fromNodes = NodeModelUtils.findNodesForFeature(rosNode, RossystemPackage.Literals.ROS_NODE__FROM);
        if (!fromNodes.isEmpty()) {
            return findLineEndOffsetWithoutNewline(text, lastNonHiddenOffset(fromNodes.get(0)));
        }
        return findElementBlockEndOffset(text, nodeComp);
    }

    private static int findSystemNodesInsertionOffset(final String text, final ICompositeNode rootNode) {
        // Look for "  nodes:" keyword in text; if present, insert after that line
        int idx = text.indexOf("\n  nodes:");
        if (idx >= 0) {
            return findLineEndOffsetWithoutNewline(text, idx + 8);
        }
        // Otherwise insert after the system header line ("<system_name>:" or "  fromFile: ...")
        int firstNewline = text.indexOf('\n');
        return firstNewline >= 0 ? firstNewline : text.length();
    }

    static int findLineEndOffsetWithoutNewline(final String text, final int pos) {
        int i = Math.min(Math.max(0, pos), text.length());
        while (i < text.length() && text.charAt(i) != '\n' && text.charAt(i) != '\r') {
            i++;
        }
        return i;
    }

    static int[] computeElementLineDeletionSpan(final String text, final ICompositeNode compNode) {
        int start = firstNonHiddenOffset(compNode);
        int end = lastNonHiddenOffset(compNode);
        // Expand start backward to the beginning of its line
        while (start > 0 && text.charAt(start - 1) != '\n' && text.charAt(start - 1) != '\r') {
            start--;
        }
        // Expand end forward to the end of its line including newline
        while (end < text.length() && text.charAt(end) != '\n' && text.charAt(end) != '\r') {
            end++;
        }
        if (end < text.length() && text.charAt(end) == '\r') {
            end++;
        }
        if (end < text.length() && text.charAt(end) == '\n') {
            end++;
        }
        return new int[] {start, end};
    }

    private static String applyEdits(final String text, final List<SpanEdit> edits, final List<SpanEdit> appliedOut) {
        // Apply back-to-front. Among edits at the same offset the one added LAST is applied
        // first, so that in the final text same-offset insertions appear in the order they
        // were collected (e.g. a new 'namespace:' line before a new 'interfaces:' section).
        List<Integer> order = new ArrayList<>();
        for (int i = 0; i < edits.size(); i++) {
            order.add(i);
        }
        order.sort(Comparator.comparingInt((Integer i) -> edits.get(i).offset)
                .thenComparingInt(i -> i)
                .reversed());
        StringBuilder sb = new StringBuilder(text);
        int lastModifiedStart = Integer.MAX_VALUE;
        for (int idx : order) {
            SpanEdit edit = edits.get(idx);
            if (edit.offset + edit.length <= lastModifiedStart) {
                sb.replace(edit.offset, edit.offset + edit.length, edit.replacement);
                lastModifiedStart = edit.offset;
                appliedOut.add(edit);
            }
        }
        return sb.toString();
    }

    static String stripTrailingNewline(final String s) {
        int end = s.length();
        while (end > 0 && (s.charAt(end - 1) == '\n' || s.charAt(end - 1) == '\r')) {
            end--;
        }
        return s.substring(0, end);
    }
}
