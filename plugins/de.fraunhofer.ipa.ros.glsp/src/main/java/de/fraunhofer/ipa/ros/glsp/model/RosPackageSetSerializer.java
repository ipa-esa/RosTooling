package de.fraunhofer.ipa.ros.glsp.model;

import de.fraunhofer.ipa.ros.glsp.handlers.RosPackageSetEditor;
import de.fraunhofer.ipa.ros.glsp.model.RosAstNodeModelSerializer.SpanEdit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import primitives.MessagePart;
import primitives.PrimitivesPackage;
import ros.ActionSpec;
import ros.Artifact;
import ros.InterfaceType;
import ros.LifecycleState;
import ros.MessageDefinition;
import ros.Node;
import ros.Package;
import ros.PackageSet;
import ros.Parameter;
import ros.QualityOfService;
import ros.RosPackage;
import ros.ServiceSpec;
import ros.SpecBase;
import ros.TopicSpec;

/**
 * Surgical span-edit collector for {@code PackageSet} models (.ros2 / .ros1 / .ros).
 *
 * <p>Only three kinds of text change are ever produced:
 * <ol>
 *   <li>token replacements on existing lines (names, references, values),</li>
 *   <li>whole-line deletions for elements removed from the AST,</li>
 *   <li>insertions of freshly rendered blocks for elements that have no node model yet,
 *       and re-rendering of the small sub-blocks explicitly marked dirty (qos, active_in,
 *       parameter type/default, message field type).</li>
 * </ol>
 * Every other byte of the original text, including all {@code #} comments, is preserved.
 */
final class RosPackageSetSerializer {

    private static final String[] NODE_SECTIONS = {
        "publishers:", "subscribers:", "serviceservers:", "serviceclients:", "actionservers:", "actionclients:",
        "parameters:"
    };

    private final RosModelState state;
    private final String text;
    private final List<SpanEdit> edits;
    private final Set<Integer> deletedLineStarts = new HashSet<>();

    RosPackageSetSerializer(final RosModelState state, final String text, final List<SpanEdit> edits) {
        this.state = state;
        this.text = text;
        this.edits = edits;
    }

    void collect(final EObject rootModel, final List<Package> packages, final ICompositeNode rootNode) {
        Set<EObject> live = Collections.newSetFromMap(new IdentityHashMap<>());
        live.add(rootModel);
        rootModel.eAllContents().forEachRemaining(live::add);

        collectDeletions(rootNode, live);

        for (Package pkg : packages) {
            ICompositeNode pkgComp = NodeModelUtils.findActualNodeFor(pkg);
            if (pkgComp == null) {
                continue; // Creating whole packages is not supported from the forms.
            }
            visitPackage(pkg, pkgComp);
        }
    }

    // ---------------------------------------------------------------------------------------
    // Deletions
    // ---------------------------------------------------------------------------------------

    private void collectDeletions(final ICompositeNode rootNode, final Set<EObject> live) {
        List<int[]> spans = new ArrayList<>();
        for (INode node : rootNode.getAsTreeIterable()) {
            if (!(node instanceof ICompositeNode comp) || !comp.hasDirectSemanticElement()) {
                continue;
            }
            EObject sem = comp.getSemanticElement();
            if (!isDeletable(sem) || live.contains(sem)) {
                continue;
            }
            int start = RosAstNodeModelSerializer.firstNonHiddenOffset(comp);
            boolean nested = false;
            for (int[] s : spans) {
                if (start >= s[0] && start < s[1]) {
                    nested = true;
                    break;
                }
            }
            if (nested) {
                continue;
            }
            int[] span = RosAstNodeModelSerializer.computeElementLineDeletionSpan(text, comp);
            spans.add(span);
            addLineDeletion(span[0], span[1]);
            removeEmptiedSectionKeyword(comp, sem, live);
        }
    }

    private static boolean isDeletable(final EObject sem) {
        return sem instanceof Package
                || sem instanceof Artifact
                || sem instanceof InterfaceType
                || sem instanceof Parameter
                || sem instanceof SpecBase
                || sem instanceof MessagePart;
    }

    /** When the last element of a section is deleted, the section keyword line must go too. */
    private void removeEmptiedSectionKeyword(final ICompositeNode deletedComp, final EObject deleted, final Set<EObject> live) {
        String keyword = RosDslText.sectionKeyword(deleted);
        if (keyword == null) {
            return;
        }
        ICompositeNode ownerComp = deletedComp.getParent();
        while (ownerComp != null && !(ownerComp.hasDirectSemanticElement() && live.contains(ownerComp.getSemanticElement()))) {
            ownerComp = ownerComp.getParent();
        }
        if (ownerComp == null) {
            return;
        }
        EObject owner = ownerComp.getSemanticElement();
        boolean empty;
        if (owner instanceof Node node) {
            empty = RosPackageSetEditor.listFor(node, deleted).isEmpty();
        } else if (owner instanceof Package pkg && deleted instanceof Artifact) {
            empty = pkg.getArtifact().isEmpty();
        } else if (owner instanceof Package pkg && deleted instanceof SpecBase) {
            empty = pkg.getSpec().stream().noneMatch(s -> s.eClass() == deleted.eClass());
        } else {
            return;
        }
        if (!empty) {
            return;
        }
        ILeafNode kw = findOwnKeywordLeaf(owner, NodeModelUtils.findActualNodeFor(owner), keyword, deletedComp.getOffset());
        if (kw != null) {
            int ls = lineStart(kw.getOffset());
            addLineDeletion(ls, lineEndInclusive(kw.getEndOffset()));
        }
    }

    private void addLineDeletion(final int start, final int end) {
        if (deletedLineStarts.add(start)) {
            edits.add(new SpanEdit(start, end - start, ""));
        }
    }

    // ---------------------------------------------------------------------------------------
    // Packages / artifacts / nodes
    // ---------------------------------------------------------------------------------------

    private void visitPackage(final Package pkg, final ICompositeNode pkgComp) {
        RosAstNodeModelSerializer.checkFeatureTokenEdit(pkg, RosPackage.Literals.PACKAGE__NAME, pkg.getName(), false, text, edits);
        int pkgCol = column(RosAstNodeModelSerializer.firstNonHiddenOffset(pkgComp));
        int headerEnd = featureLineEnd(pkg, RosPackage.Literals.PACKAGE__NAME, pkgComp);

        List<INode> gitNodes = NodeModelUtils.findNodesForFeature(pkg, RosPackage.Literals.PACKAGE__FROM_GIT_REPO);
        String repo = pkg.getFromGitRepo();
        if (!gitNodes.isEmpty()) {
            if (state.isDirty(pkg, "fromGitRepo") && (repo == null || repo.isBlank())) {
                ILeafNode kw = findOwnKeywordLeaf(pkg, pkgComp, "fromGitRepo:", Integer.MAX_VALUE);
                if (kw != null) {
                    addLineDeletion(lineStart(kw.getOffset()), lineEndInclusive(kw.getEndOffset()));
                }
            } else if (repo != null) {
                RosAstNodeModelSerializer.checkFeatureTokenEdit(
                        pkg, RosPackage.Literals.PACKAGE__FROM_GIT_REPO, repo, true, text, edits);
            }
        } else if (repo != null && !repo.isBlank()) {
            edits.add(new SpanEdit(headerEnd, 0, "\n" + spaces(pkgCol + 2) + "fromGitRepo: " + RosDslText.quote(repo)));
        }
        int afterHeader = gitNodes.isEmpty()
                ? headerEnd
                : RosAstNodeModelSerializer.findLineEndOffsetWithoutNewline(
                        text, RosAstNodeModelSerializer.lastNonHiddenOffset(gitNodes.get(gitNodes.size() - 1)));

        // Artifacts (.ros2 / .ros1)
        List<Artifact> newArtifacts = new ArrayList<>();
        ICompositeNode lastArtifact = null;
        for (Artifact art : pkg.getArtifact()) {
            ICompositeNode artComp = NodeModelUtils.findActualNodeFor(art);
            if (artComp == null) {
                newArtifacts.add(art);
            } else {
                lastArtifact = artComp;
                visitArtifact(art);
            }
        }
        if (!newArtifacts.isEmpty()) {
            insertSectionElements(pkg, pkgComp, "artifacts:", lastArtifact, pkgCol + 2, afterHeader, indent -> {
                StringBuilder sb = new StringBuilder();
                for (Artifact a : newArtifacts) {
                    sb.append(renderArtifact(a, indent));
                }
                return sb.toString();
            });
        }

        // Specs (.ros)
        for (Class<? extends SpecBase> specClass : List.of(TopicSpec.class, ServiceSpec.class, ActionSpec.class)) {
            List<SpecBase> newSpecs = new ArrayList<>();
            ICompositeNode lastSpec = null;
            for (SpecBase spec : pkg.getSpec()) {
                if (!specClass.isInstance(spec)) {
                    continue;
                }
                ICompositeNode specComp = NodeModelUtils.findActualNodeFor(spec);
                if (specComp == null) {
                    newSpecs.add(spec);
                } else {
                    lastSpec = specComp;
                    visitSpec(spec, specComp);
                }
            }
            if (!newSpecs.isEmpty()) {
                String kw = RosDslText.sectionKeyword(newSpecs.get(0));
                int anchor = lastLiveChildEnd(pkg.getSpec(), afterHeader);
                insertSectionElements(pkg, pkgComp, kw, lastSpec, pkgCol + 2, anchor, indent -> {
                    StringBuilder sb = new StringBuilder();
                    for (SpecBase s : newSpecs) {
                        sb.append(renderSpec(s, indent));
                    }
                    return sb.toString();
                });
            }
        }
    }

    private void visitArtifact(final Artifact art) {
        RosAstNodeModelSerializer.checkFeatureTokenEdit(art, RosPackage.Literals.ARTIFACT__NAME, art.getName(), false, text, edits);
        Node node = art.getNode();
        ICompositeNode nodeComp = node == null ? null : NodeModelUtils.findActualNodeFor(node);
        if (nodeComp == null) {
            return;
        }
        RosAstNodeModelSerializer.checkFeatureTokenEdit(node, RosPackage.Literals.NODE__NAME, node.getName(), false, text, edits);
        int nodeCol = column(RosAstNodeModelSerializer.firstNonHiddenOffset(nodeComp));
        int nameLineEnd = featureLineEnd(node, RosPackage.Literals.NODE__NAME, nodeComp);

        if (state.isDirty(node, "isLifecycle")) {
            List<INode> lcNodes = NodeModelUtils.findNodesForFeature(node, RosPackage.Literals.NODE__IS_LIFECYCLE);
            if (!lcNodes.isEmpty()) {
                if (!node.isIsLifecycle()) {
                    ILeafNode kw = findOwnKeywordLeaf(node, nodeComp, "lifecycle:", Integer.MAX_VALUE);
                    if (kw != null) {
                        addLineDeletion(lineStart(kw.getOffset()), lineEndInclusive(kw.getEndOffset()));
                    }
                } else {
                    RosAstNodeModelSerializer.checkFeatureRawSpanEdit(
                            node, RosPackage.Literals.NODE__IS_LIFECYCLE, "true", text, edits);
                }
            } else if (node.isIsLifecycle()) {
                edits.add(new SpanEdit(nameLineEnd, 0, "\n" + spaces(nodeCol) + "lifecycle: true"));
            }
        }

        List<EObject> liveItems = new ArrayList<>(RosPackageSetEditor.allInterfaces(node));
        liveItems.addAll(node.getParameter());
        int nodeEnd = lastLiveChildEnd(liveItems, nameLineEnd);
        for (String section : NODE_SECTIONS) {
            List<InterfaceType> items = itemsOfSection(node, section);
            List<InterfaceType> fresh = new ArrayList<>();
            ICompositeNode lastExisting = null;
            for (InterfaceType item : items) {
                ICompositeNode comp = NodeModelUtils.findActualNodeFor(item);
                if (comp == null) {
                    fresh.add(item);
                } else {
                    lastExisting = comp;
                    if (item instanceof Parameter p) {
                        visitParameter(p, comp);
                    } else {
                        visitInterface(item, comp);
                    }
                }
            }
            if (!fresh.isEmpty()) {
                insertSectionElements(node, nodeComp, section, lastExisting, nodeCol, nodeEnd, indent -> {
                    StringBuilder sb = new StringBuilder();
                    for (InterfaceType i : fresh) {
                        sb.append(i instanceof Parameter p ? renderParameter(p, indent) : renderInterface(i, indent));
                    }
                    return sb.toString();
                });
            }
        }
    }

    private static List<InterfaceType> itemsOfSection(final Node node, final String section) {
        List<InterfaceType> out = new ArrayList<>();
        switch (section) {
            case "publishers:": out.addAll(node.getPublisher()); break;
            case "subscribers:": out.addAll(node.getSubscriber()); break;
            case "serviceservers:": out.addAll(node.getServiceserver()); break;
            case "serviceclients:": out.addAll(node.getServiceclient()); break;
            case "actionservers:": out.addAll(node.getActionserver()); break;
            case "actionclients:": out.addAll(node.getActionclient()); break;
            default: out.addAll(node.getParameter()); break;
        }
        return out;
    }

    // ---------------------------------------------------------------------------------------
    // Interfaces & parameters
    // ---------------------------------------------------------------------------------------

    private void visitInterface(final InterfaceType iface, final ICompositeNode comp) {
        RosAstNodeModelSerializer.checkFeatureTokenEdit(
                iface, RosPackage.Literals.INTERFACE_TYPE__NAME, iface.getName(), false, text, edits);
        EReference specRef = RosDslText.specFeature(iface);
        if (state.isDirty(iface, "type") && specRef != null) {
            RosAstNodeModelSerializer.checkFeatureTokenEdit(
                    iface, specRef, RosDslText.refText(state, iface, specRef), true, text, edits);
        }
        // Grammar order inside an interface is: type, ns, active_in, qos. Edits at the same
        // offset keep the order in which they were added, so ns, then active_in, then qos.
        if (state.isDirty(iface, "namespace") && specRef != null) {
            List<INode> typeNodes = NodeModelUtils.findNodesForFeature(iface, specRef);
            int anchor = typeNodes.isEmpty() ? RosAstNodeModelSerializer.findElementBlockEndOffset(text, comp)
                    : RosAstNodeModelSerializer.findLineEndOffsetWithoutNewline(
                            text, RosAstNodeModelSerializer.lastNonHiddenOffset(typeNodes.get(typeNodes.size() - 1)));
            emitNamespace(iface, comp, anchor);
        }
        if (state.isDirty(iface, "activeStates")) {
            emitActiveStates(iface, comp, specRef);
        }
        if (state.isDirty(iface, "qos")) {
            emitQos(iface, comp);
        }
    }

    private void emitActiveStates(final InterfaceType iface, final ICompositeNode comp, final EReference specRef) {
        ILeafNode kw = findOwnKeywordLeaf(iface, comp, "active_in:", Integer.MAX_VALUE);
        String line = renderActiveStates(iface);
        if (kw != null) {
            int ls = lineStart(kw.getOffset());
            if (line == null) {
                addLineDeletion(ls, lineEndInclusive(kw.getEndOffset()));
                return;
            }
            // Replace only the state list between '[' and ']' (comments after ']' survive).
            List<INode> stateNodes = NodeModelUtils.findNodesForFeature(iface, RosPackage.Literals.INTERFACE_TYPE__ACTIVE_STATES);
            if (!stateNodes.isEmpty()) {
                int s0 = RosAstNodeModelSerializer.firstNonHiddenOffset(stateNodes.get(0));
                int s1 = RosAstNodeModelSerializer.lastNonHiddenOffset(stateNodes.get(stateNodes.size() - 1));
                List<String> names = new ArrayList<>();
                for (LifecycleState st : iface.getActiveStates()) {
                    names.add(st.getLiteral());
                }
                String inner = String.join(" , ", names);
                if (s0 >= 0 && s1 >= s0 && !text.substring(s0, s1).equals(inner)) {
                    edits.add(new SpanEdit(s0, s1 - s0, inner));
                }
            }
            return;
        }
        if (line == null) {
            return;
        }
        List<INode> anchorNodes = NodeModelUtils.findNodesForFeature(iface, RosPackage.Literals.INTERFACE_TYPE__NAMESPACE);
        if (anchorNodes.isEmpty() && specRef != null) {
            anchorNodes = NodeModelUtils.findNodesForFeature(iface, specRef);
        }
        int anchor = anchorNodes.isEmpty()
                ? RosAstNodeModelSerializer.findElementBlockEndOffset(text, comp)
                : RosAstNodeModelSerializer.findLineEndOffsetWithoutNewline(
                        text, RosAstNodeModelSerializer.lastNonHiddenOffset(anchorNodes.get(anchorNodes.size() - 1)));
        int col = column(RosAstNodeModelSerializer.firstNonHiddenOffset(comp)) + 2;
        edits.add(new SpanEdit(anchor, 0, "\n" + spaces(col) + line));
    }

    /**
     * QoS edits are field-granular, exactly like every other edit: a changed value replaces only
     * its value token, a cleared field deletes only its own line, a new field inserts one line.
     * Only a brand-new block (no qos: in the text yet) or removing the last field touches the
     * whole block.
     */
    private void emitQos(final InterfaceType iface, final ICompositeNode comp) {
        QualityOfService q = iface.getQos();
        ILeafNode kw = findOwnKeywordLeaf(iface, comp, "qos:", Integer.MAX_VALUE);
        int ifaceCol = column(RosAstNodeModelSerializer.firstNonHiddenOffset(comp));
        if (kw == null) {
            String block = renderQos(q, spaces(ifaceCol + 2));
            if (block != null) {
                int pos = RosAstNodeModelSerializer.findElementBlockEndOffset(text, comp);
                edits.add(new SpanEdit(pos, 0, "\n" + block));
            }
            return;
        }
        int blockEnd = kw.getEndOffset();
        EStructuralFeature qosFeature = iface.eClass().getEStructuralFeature("qos");
        for (INode n : NodeModelUtils.findNodesForFeature(iface, qosFeature)) {
            blockEnd = Math.max(blockEnd, RosAstNodeModelSerializer.lastNonHiddenOffset(n));
        }
        if (RosPackageSetEditor.isEmpty(state, q)) {
            addLineDeletion(lineStart(kw.getOffset()), lineEndInclusive(blockEnd));
            return;
        }
        ICompositeNode qComp = NodeModelUtils.findActualNodeFor(q);
        if (qComp == null) {
            // The QoS object was replaced in memory: re-render the block body below 'qos:'.
            String block = renderQos(q, spaces(column(kw.getOffset())));
            int ls = lineStart(kw.getOffset());
            int le = RosAstNodeModelSerializer.findLineEndOffsetWithoutNewline(text, blockEnd);
            if (!text.substring(ls, le).equals(block)) {
                edits.add(new SpanEdit(ls, le - ls, block));
            }
            return;
        }
        String fieldIndent = null;
        int lastFieldLineEnd = RosAstNodeModelSerializer.findLineEndOffsetWithoutNewline(text, kw.getEndOffset());
        List<String[]> missing = new ArrayList<>();
        for (String[] f : RosPackageSetEditor.QOS_FIELDS) {
            EStructuralFeature feature = q.eClass().getEStructuralFeature(f[1]);
            List<INode> valueNodes = NodeModelUtils.findNodesForFeature(q, feature);
            String wanted = RosPackageSetEditor.qosValue(state, q, f[0]);
            if (!valueNodes.isEmpty()) {
                INode vn = valueNodes.get(0);
                int vs = RosAstNodeModelSerializer.firstNonHiddenOffset(vn);
                int ve = RosAstNodeModelSerializer.lastNonHiddenOffset(vn);
                if (fieldIndent == null) {
                    fieldIndent = text.substring(lineStart(vs), indentEnd(lineStart(vs)));
                }
                lastFieldLineEnd = Math.max(lastFieldLineEnd, RosAstNodeModelSerializer.findLineEndOffsetWithoutNewline(text, ve));
                if (wanted == null) {
                    addLineDeletion(lineStart(vs), lineEndInclusive(ve));
                } else {
                    String literal = qosLiteral(f[0], wanted);
                    if (!text.substring(vs, ve).equals(literal)) {
                        edits.add(new SpanEdit(vs, ve - vs, literal));
                    }
                }
            } else if (wanted != null) {
                missing.add(new String[] {f[0], wanted});
            }
        }
        if (!missing.isEmpty()) {
            String ind = fieldIndent != null ? fieldIndent : spaces(column(kw.getOffset()) + 2);
            StringBuilder sb = new StringBuilder();
            for (String[] m : missing) {
                sb.append("\n").append(ind).append(m[0]).append(": ").append(qosLiteral(m[0], m[1]));
            }
            edits.add(new SpanEdit(lastFieldLineEnd, 0, sb.toString()));
        }
    }

    private static String qosLiteral(final String key, final String value) {
        String v = value.trim();
        boolean durationLike = "lease_duration".equals(key) || "lifespan".equals(key) || "deadline".equals(key);
        return durationLike && !"infinite".equals(v) ? RosDslText.quote(RosDslText.unquote(v)) : v;
    }

    private int indentEnd(final int lineStartOffset) {
        int i = lineStartOffset;
        while (i < text.length() && (text.charAt(i) == ' ' || text.charAt(i) == '\t')) i++;
        return i;
    }

    private void visitParameter(final Parameter param, final ICompositeNode comp) {
        RosAstNodeModelSerializer.checkFeatureTokenEdit(
                param, RosPackage.Literals.INTERFACE_TYPE__NAME, param.getName(), false, text, edits);
        if (param.getValue() != null) {
            List<INode> valNodes = NodeModelUtils.findNodesForFeature(param, RosPackage.Literals.PARAMETER__VALUE);
            String renderedVal = RosAstNodeModelSerializer.formatDslParameterValue(param.getValue());
            if (!valNodes.isEmpty()) {
                RosAstNodeModelSerializer.checkFeatureRawSpanEdit(
                        param, RosPackage.Literals.PARAMETER__VALUE, renderedVal, text, edits);
            } else {
                List<INode> nsNodes = NodeModelUtils.findNodesForFeature(param, RosPackage.Literals.INTERFACE_TYPE__NAMESPACE);
                List<INode> typeNodes = NodeModelUtils.findNodesForFeature(param, RosPackage.Literals.PARAMETER__TYPE);
                List<INode> anchorNodes = !nsNodes.isEmpty() ? nsNodes : typeNodes;
                int anchor = anchorNodes.isEmpty()
                        ? RosAstNodeModelSerializer.findElementBlockEndOffset(text, comp)
                        : RosAstNodeModelSerializer.findLineEndOffsetWithoutNewline(
                                text, RosAstNodeModelSerializer.lastNonHiddenOffset(anchorNodes.get(anchorNodes.size() - 1)));
                ILeafNode typeKw = findOwnKeywordLeaf(param, comp, "type:", Integer.MAX_VALUE);
                int col = typeKw != null
                        ? column(typeKw.getOffset())
                        : column(RosAstNodeModelSerializer.firstNonHiddenOffset(comp)) + 2;
                edits.add(new SpanEdit(anchor, 0, "\n" + spaces(col) + "value: " + renderedVal));
            }
        }
        if (state.isDirty(param, "type")) {
            emitParameterType(param, comp);
        }
        if (state.isDirty(param, "namespace")) {
            // Grammar order inside a parameter: type (incl. default), ns, value, qos.
            List<INode> typeNodes = NodeModelUtils.findNodesForFeature(param, RosPackage.Literals.PARAMETER__TYPE);
            int anchor = typeNodes.isEmpty() ? RosAstNodeModelSerializer.findElementBlockEndOffset(text, comp)
                    : RosAstNodeModelSerializer.findLineEndOffsetWithoutNewline(
                            text, RosAstNodeModelSerializer.lastNonHiddenOffset(typeNodes.get(typeNodes.size() - 1)));
            emitNamespace(param, comp, anchor);
        }
    }

    /**
     * {@code ns:} is edited like every other field: the namespace expression is replaced in place,
     * a cleared namespace removes only its line, a new one inserts one line after {@code type:}.
     */
    private void emitNamespace(final InterfaceType holder, final ICompositeNode comp, final int insertAnchor) {
        String wanted = holder.getNamespace() == null ? null : RosDslText.renderNamespace(holder.getNamespace());
        List<INode> nsNodes = NodeModelUtils.findNodesForFeature(holder, RosPackage.Literals.INTERFACE_TYPE__NAMESPACE);
        if (!nsNodes.isEmpty()) {
            int s = RosAstNodeModelSerializer.firstNonHiddenOffset(nsNodes.get(0));
            int e = RosAstNodeModelSerializer.lastNonHiddenOffset(nsNodes.get(nsNodes.size() - 1));
            if (wanted == null) {
                ILeafNode kw = findOwnKeywordLeaf(holder, comp, "ns:", Integer.MAX_VALUE);
                addLineDeletion(lineStart(kw != null ? kw.getOffset() : s), lineEndInclusive(e));
            } else if (s >= 0 && e >= s && !text.substring(s, e).equals(wanted)) {
                edits.add(new SpanEdit(s, e - s, wanted));
            }
            return;
        }
        if (wanted == null) {
            return;
        }
        ILeafNode typeKw = findOwnKeywordLeaf(holder, comp, "type:", Integer.MAX_VALUE);
        int col = typeKw != null ? column(typeKw.getOffset()) : column(RosAstNodeModelSerializer.firstNonHiddenOffset(comp)) + 2;
        edits.add(new SpanEdit(insertAnchor, 0, "\n" + spaces(col) + "ns: " + wanted));
    }

    private void emitParameterType(final Parameter param, final ICompositeNode comp) {
        List<INode> typeNodes = NodeModelUtils.findNodesForFeature(param, RosPackage.Literals.PARAMETER__TYPE);
        ILeafNode typeKw = findOwnKeywordLeaf(param, comp, "type:", Integer.MAX_VALUE);
        if (typeNodes.isEmpty() || typeKw == null) {
            return;
        }
        int start = RosAstNodeModelSerializer.firstNonHiddenOffset(typeNodes.get(0));
        int end = RosAstNodeModelSerializer.lastNonHiddenOffset(typeNodes.get(typeNodes.size() - 1));
        if (start < 0 || end < start) {
            return;
        }
        // Locate the old type keyword and (optional) 'default:' value inside the old type span.
        ILeafNode oldKeyword = null;
        ILeafNode defaultKw = null;
        int defStart = -1;
        int defEnd = -1;
        for (INode tn : typeNodes) {
            for (ILeafNode leaf : tn.getLeafNodes()) {
                if (leaf.isHidden() || leaf.getLength() == 0) continue;
                if (oldKeyword == null) {
                    oldKeyword = leaf;
                } else if (defaultKw == null && "default:".equals(leaf.getText())) {
                    defaultKw = leaf;
                } else if (defaultKw != null) {
                    if (defStart < 0) defStart = leaf.getOffset();
                    defEnd = leaf.getEndOffset();
                }
            }
        }
        String newKeyword = RosDslText.parameterTypeKeyword(param.getType());
        boolean simpleOld = oldKeyword != null && List.of("String", "Integer", "Double", "Boolean", "Base64", "Any")
                .contains(oldKeyword.getText());
        boolean simpleNew = !(param.getType() instanceof ros.ParameterArrayType)
                && List.of("String", "Integer", "Double", "Boolean", "Base64", "Any").contains(newKeyword);
        if (!simpleOld || !simpleNew) {
            // Structured types (Array/List/Struct): re-render the type expression itself.
            String rendered = RosDslText.renderParameterType(param.getType(), spaces(column(typeKw.getOffset())));
            if (rendered != null && !text.substring(start, end).equals(rendered)) {
                edits.add(new SpanEdit(start, end - start, rendered));
            }
            return;
        }
        if (!oldKeyword.getText().equals(newKeyword)) {
            edits.add(new SpanEdit(oldKeyword.getOffset(), oldKeyword.getLength(), newKeyword));
        }
        ros.ParameterValue def = RosDslText.parameterTypeDefault(param.getType());
        String newDefault = def == null ? null : RosAstNodeModelSerializer.formatDslParameterValue(def);
        if (defaultKw != null && defStart >= 0) {
            if (newDefault == null) {
                boolean ownLine = lineStart(defaultKw.getOffset()) > lineStart(oldKeyword.getOffset());
                if (ownLine) {
                    addLineDeletion(lineStart(defaultKw.getOffset()), lineEndInclusive(defEnd));
                } else {
                    edits.add(new SpanEdit(oldKeyword.getEndOffset(), defEnd - oldKeyword.getEndOffset(), ""));
                }
            } else if (!text.substring(defStart, defEnd).equals(newDefault)) {
                edits.add(new SpanEdit(defStart, defEnd - defStart, newDefault));
            }
        } else if (newDefault != null) {
            int pos = RosAstNodeModelSerializer.findLineEndOffsetWithoutNewline(text, oldKeyword.getEndOffset());
            edits.add(new SpanEdit(pos, 0, "\n" + spaces(column(typeKw.getOffset())) + "default: " + newDefault));
        }
    }

    // ---------------------------------------------------------------------------------------
    // Specs & message fields
    // ---------------------------------------------------------------------------------------

    private void visitSpec(final SpecBase spec, final ICompositeNode specComp) {
        RosAstNodeModelSerializer.checkFeatureTokenEdit(spec, RosPackage.Literals.SPEC_BASE__NAME, spec.getName(), false, text, edits);
        int specCol = column(RosAstNodeModelSerializer.firstNonHiddenOffset(specComp));
        int specEnd = RosAstNodeModelSerializer.findElementBlockEndOffset(text, specComp);
        for (String section : sectionsOf(spec)) {
            Object defObj = spec.eGet(spec.eClass().getEStructuralFeature(section));
            if (!(defObj instanceof MessageDefinition def)) {
                continue;
            }
            List<MessagePart> fresh = new ArrayList<>();
            ICompositeNode lastExisting = null;
            for (MessagePart part : def.getMessagePart()) {
                ICompositeNode partComp = NodeModelUtils.findActualNodeFor(part);
                if (partComp == null) {
                    fresh.add(part);
                } else {
                    lastExisting = partComp;
                    RosAstNodeModelSerializer.checkFeatureTokenEdit(
                            part, PrimitivesPackage.Literals.MESSAGE_PART__DATA, part.getData(), false, text, edits);
                    if (state.isDirty(part, "type")) {
                        List<INode> typeNodes = NodeModelUtils.findNodesForFeature(part, PrimitivesPackage.Literals.MESSAGE_PART__TYPE);
                        if (!typeNodes.isEmpty()) {
                            int s = RosAstNodeModelSerializer.firstNonHiddenOffset(typeNodes.get(0));
                            int e = RosAstNodeModelSerializer.lastNonHiddenOffset(typeNodes.get(typeNodes.size() - 1));
                            String t = RosDslText.messagePartTypeText(state, part.getType());
                            if (s >= 0 && e >= s && !text.substring(s, e).equals(t)) {
                                edits.add(new SpanEdit(s, e - s, t));
                            }
                        }
                    }
                }
            }
            if (!fresh.isEmpty()) {
                insertSectionElements(spec, specComp, section, lastExisting, specCol + 2, specEnd, indent -> {
                    StringBuilder sb = new StringBuilder();
                    for (MessagePart p : fresh) {
                        sb.append(indent).append(RosDslText.messagePartTypeText(state, p.getType()))
                                .append(' ').append(p.getData()).append('\n');
                    }
                    return sb.toString();
                });
            }
        }
    }

    private static List<String> sectionsOf(final SpecBase spec) {
        if (spec instanceof ServiceSpec) return List.of("request", "response");
        if (spec instanceof ActionSpec) return List.of("goal", "result", "feedback");
        return List.of("message");
    }

    // ---------------------------------------------------------------------------------------
    // Rendering of new elements
    // ---------------------------------------------------------------------------------------

    /** Renders a newly created package / package-set model (empty source file) in canonical DSL syntax. */
    static String renderFullModel(final RosModelState state, final List<Package> packages) {
        if (packages == null || packages.isEmpty()) {
            return "";
        }
        RosPackageSetSerializer helper = new RosPackageSetSerializer(state, "", List.of());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < packages.size(); i++) {
            if (i > 0) {
                sb.append('\n');
            }
            sb.append(helper.renderPackage(packages.get(i)));
        }
        return sb.toString();
    }

    private String renderPackage(final Package pkg) {
        StringBuilder sb = new StringBuilder();
        sb.append(pkg.getName()).append(":\n");
        if (pkg.getFromGitRepo() != null && !pkg.getFromGitRepo().isBlank()) {
            sb.append("  fromGitRepo: ").append(RosDslText.quote(pkg.getFromGitRepo())).append('\n');
        }
        if (!pkg.getArtifact().isEmpty()) {
            sb.append("  artifacts:\n");
            for (Artifact art : pkg.getArtifact()) {
                sb.append(renderArtifact(art, "    "));
            }
        }
        for (Class<? extends SpecBase> specClass : List.of(TopicSpec.class, ServiceSpec.class, ActionSpec.class)) {
            List<SpecBase> matching = pkg.getSpec().stream().filter(specClass::isInstance).toList();
            if (!matching.isEmpty()) {
                sb.append("  ").append(RosDslText.sectionKeyword(matching.get(0))).append('\n');
                for (SpecBase spec : matching) {
                    sb.append(renderSpec(spec, "    "));
                }
            }
        }
        return sb.toString();
    }

    private String renderArtifact(final Artifact art, final String indent) {
        StringBuilder sb = new StringBuilder();
        sb.append(indent).append(art.getName()).append(":\n");
        Node node = art.getNode();
        if (node == null) {
            return sb.toString();
        }
        String inner = indent + "  ";
        sb.append(inner).append("node: ").append(node.getName()).append('\n');
        if (node.isIsLifecycle()) {
            sb.append(inner).append("lifecycle: true\n");
        }
        for (String section : NODE_SECTIONS) {
            List<InterfaceType> items = itemsOfSection(node, section);
            if (items.isEmpty()) {
                continue;
            }
            sb.append(inner).append(section).append('\n');
            for (InterfaceType i : items) {
                sb.append(i instanceof Parameter p ? renderParameter(p, inner + "  ") : renderInterface(i, inner + "  "));
            }
        }
        return sb.toString();
    }

    private String renderInterface(final InterfaceType iface, final String indent) {
        StringBuilder sb = new StringBuilder();
        String inner = indent + "  ";
        sb.append(indent).append(iface.getName()).append(":\n");
        EReference specRef = RosDslText.specFeature(iface);
        sb.append(inner).append("type: ").append(RosDslText.quote(RosDslText.refText(state, iface, specRef))).append('\n');
        if (iface.getNamespace() != null) {
            sb.append(inner).append("ns: ").append(RosDslText.renderNamespace(iface.getNamespace())).append('\n');
        }
        String active = renderActiveStates(iface);
        if (active != null) {
            sb.append(inner).append(active).append('\n');
        }
        String qos = renderQos(iface.getQos(), inner);
        if (qos != null) {
            sb.append(qos).append('\n');
        }
        return sb.toString();
    }

    private String renderParameter(final Parameter param, final String indent) {
        String inner = indent + "  ";
        String type = RosDslText.renderParameterType(param.getType(), inner);
        StringBuilder sb = new StringBuilder();
        sb.append(indent).append(param.getName()).append(":\n");
        sb.append(inner).append("type: ").append(type == null ? "String" : type).append('\n');
        if (param.getNamespace() != null) {
            sb.append(inner).append("ns: ").append(RosDslText.renderNamespace(param.getNamespace())).append('\n');
        }
        if (param.getValue() != null) {
            sb.append(inner).append("value: ")
                    .append(RosAstNodeModelSerializer.formatDslParameterValue(param.getValue())).append('\n');
        }
        return sb.toString();
    }

    private String renderSpec(final SpecBase spec, final String indent) {
        StringBuilder sb = new StringBuilder();
        sb.append(indent).append(spec.getName()).append('\n');
        for (String section : sectionsOf(spec)) {
            sb.append(indent).append("  ").append(section).append('\n');
            Object defObj = spec.eGet(spec.eClass().getEStructuralFeature(section));
            if (defObj instanceof MessageDefinition def) {
                for (MessagePart p : def.getMessagePart()) {
                    sb.append(indent).append("    ").append(RosDslText.messagePartTypeText(state, p.getType()))
                            .append(' ').append(p.getData()).append('\n');
                }
            }
        }
        return sb.toString();
    }

    private static String renderActiveStates(final InterfaceType iface) {
        if (iface.getActiveStates().isEmpty()) {
            return null;
        }
        List<String> names = new ArrayList<>();
        for (LifecycleState st : iface.getActiveStates()) {
            names.add(st.getLiteral());
        }
        return "active_in: [ " + String.join(" , ", names) + " ]";
    }

    /** Renders a {@code qos:} block (no trailing newline) or null when there is nothing to emit. */
    private String renderQos(final QualityOfService q, final String indent) {
        if (RosPackageSetEditor.isEmpty(state, q)) {
            return null;
        }
        String in = indent + "  ";
        StringBuilder sb = new StringBuilder(indent).append("qos:");
        for (String[] field : RosPackageSetEditor.QOS_FIELDS) {
            String value = RosPackageSetEditor.qosValue(state, q, field[0]);
            appendQos(sb, in, field[0], value, "lease_duration".equals(field[0])
                    || "lifespan".equals(field[0]) || "deadline".equals(field[0]));
        }
        return sb.toString();
    }

    private static void appendQos(final StringBuilder sb, final String indent, final String key, final String value, final boolean durationLike) {
        if (value == null || value.isBlank()) {
            return;
        }
        String v = value.trim();
        if (durationLike && !"infinite".equals(v)) {
            v = RosDslText.quote(RosDslText.unquote(v));
        }
        sb.append('\n').append(indent).append(key).append(": ").append(v);
    }

    // ---------------------------------------------------------------------------------------
    // Insertion + node-model helpers
    // ---------------------------------------------------------------------------------------

    /**
     * Inserts rendered elements into a section. Placement preference: after the last existing
     * sibling; else right below an existing (kept) section keyword; else a new section is
     * appended at {@code fallbackAnchor} with the keyword at column {@code keywordColumn}.
     */
    private void insertSectionElements(
            final EObject owner,
            final ICompositeNode ownerComp,
            final String keyword,
            final ICompositeNode lastExistingSibling,
            final int keywordColumn,
            final int fallbackAnchor,
            final Function<String, String> render) {
        if (lastExistingSibling != null) {
            String indent = spaces(column(RosAstNodeModelSerializer.firstNonHiddenOffset(lastExistingSibling)));
            int pos = RosAstNodeModelSerializer.findElementBlockEndOffset(text, lastExistingSibling);
            edits.add(new SpanEdit(pos, 0, "\n" + RosAstNodeModelSerializer.stripTrailingNewline(render.apply(indent))));
            return;
        }
        ILeafNode kw = findOwnKeywordLeaf(owner, ownerComp, keyword, Integer.MAX_VALUE);
        if (kw != null && !deletedLineStarts.contains(lineStart(kw.getOffset()))) {
            String indent = spaces(column(kw.getOffset()) + 2);
            int pos = RosAstNodeModelSerializer.findLineEndOffsetWithoutNewline(text, kw.getEndOffset());
            edits.add(new SpanEdit(pos, 0, "\n" + RosAstNodeModelSerializer.stripTrailingNewline(render.apply(indent))));
            return;
        }
        String kwIndent = spaces(keywordColumn);
        edits.add(new SpanEdit(fallbackAnchor, 0, "\n" + kwIndent + keyword + "\n"
                + RosAstNodeModelSerializer.stripTrailingNewline(render.apply(kwIndent + "  "))));
    }

    /**
     * Finds the last keyword leaf with the given text that belongs to {@code owner} itself
     * (not to a nested child element such as a message field named "message") and starts
     * before {@code beforeOffset}.
     */
    static ILeafNode findOwnKeywordLeaf(final EObject owner, final ICompositeNode ownerComp, final String keyword, final int beforeOffset) {
        if (ownerComp == null) {
            return null;
        }
        ILeafNode found = null;
        for (ILeafNode leaf : ownerComp.getLeafNodes()) {
            if (leaf.isHidden() || leaf.getOffset() >= beforeOffset) {
                continue;
            }
            if (keyword.equals(leaf.getText())
                    && leaf.getGrammarElement() instanceof Keyword
                    && NodeModelUtils.findActualSemanticObjectFor(leaf) == owner) {
                found = leaf;
            }
        }
        return found;
    }

    /**
     * End of the last line of the last child that still exists in the AST and in the text.
     * Used as anchor for new sections so insertions never land inside a block being deleted.
     */
    private int lastLiveChildEnd(final List<? extends EObject> children, final int floor) {
        int end = floor;
        for (EObject child : children) {
            ICompositeNode comp = NodeModelUtils.findActualNodeFor(child);
            if (comp != null) {
                end = Math.max(end, RosAstNodeModelSerializer.findElementBlockEndOffset(text, comp));
            }
        }
        return end;
    }

    private int featureLineEnd(final EObject holder, final EStructuralFeature feature, final ICompositeNode fallback) {
        List<INode> nodes = NodeModelUtils.findNodesForFeature(holder, feature);
        int offset = nodes.isEmpty()
                ? RosAstNodeModelSerializer.firstNonHiddenOffset(fallback)
                : RosAstNodeModelSerializer.lastNonHiddenOffset(nodes.get(0));
        return RosAstNodeModelSerializer.findLineEndOffsetWithoutNewline(text, offset);
    }

    private int column(final int offset) {
        return offset - lineStart(offset);
    }

    private int lineStart(final int offset) {
        int i = Math.min(Math.max(0, offset), text.length());
        while (i > 0 && text.charAt(i - 1) != '\n' && text.charAt(i - 1) != '\r') {
            i--;
        }
        return i;
    }

    private int lineEndInclusive(final int offset) {
        int i = RosAstNodeModelSerializer.findLineEndOffsetWithoutNewline(text, offset);
        if (i < text.length() && text.charAt(i) == '\r') i++;
        if (i < text.length() && text.charAt(i) == '\n') i++;
        return i;
    }

    private static String spaces(final int n) {
        return " ".repeat(Math.max(0, n));
    }
}
