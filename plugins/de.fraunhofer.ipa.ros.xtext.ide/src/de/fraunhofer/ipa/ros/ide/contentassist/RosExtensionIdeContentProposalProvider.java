package de.fraunhofer.ipa.ros.ide.contentassist;

import de.fraunhofer.ipa.ros.plugin.spi.BlockDescriptor;
import de.fraunhofer.ipa.ros.plugin.spi.ExtensionSchemaMapper;
import de.fraunhofer.ipa.ros.plugin.spi.HookLocation;
import de.fraunhofer.ipa.ros.plugin.spi.PluginRegistry;
import de.fraunhofer.ipa.ros.plugin.spi.RosToolingPlugin;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistEntry;
import org.eclipse.xtext.ide.editor.contentassist.IIdeContentProposalAcceptor;
import org.eclipse.xtext.ide.editor.contentassist.IdeContentProposalProvider;
import ros.Extensible;
import ros.ExtensionBlock;
import ros.ExtensionEntry;

/**
 * Provides schema-driven LSP content assist proposals for active {@code @<name>:} extension
 * blocks, field keys, enum/boolean values, and interface reference prefixes across core models.
 */
public class RosExtensionIdeContentProposalProvider extends IdeContentProposalProvider {

    public record ExtensionCompletionCandidate(
            String text,
            String label,
            String description,
            String kind) {
    }

    @Override
    protected void _createProposals(
            final Assignment assignment,
            final ContentAssistContext context,
            final IIdeContentProposalAcceptor acceptor) {
        String feature = assignment.getFeature();
        EObject model = context.getCurrentModel();
        if ("extensions".equals(feature)) {
            acceptCandidates(blockProposalsFor(model, true), context, acceptor);
        } else if ("name".equals(feature) && model instanceof ExtensionBlock) {
            acceptCandidates(blockProposalsFor(model.eContainer(), false), context, acceptor);
        } else if ("key".equals(feature) || "entries".equals(feature)) {
            acceptCandidates(entryKeyProposalsFor(model, true), context, acceptor);
        } else if ("value".equals(feature)) {
            acceptCandidates(entryValueProposalsFor(model), context, acceptor);
        } else if ("refKind".equals(feature)) {
            acceptCandidates(refKindProposalsFor(model), context, acceptor);
        }
        super._createProposals(assignment, context, acceptor);
    }

    @Override
    protected void _createProposals(
            final RuleCall ruleCall,
            final ContentAssistContext context,
            final IIdeContentProposalAcceptor acceptor) {
        AbstractRule rule = ruleCall.getRule();
        String ruleName = rule != null ? rule.getName() : "";
        EObject model = context.getCurrentModel();
        if ("ExtensionBlock".equals(ruleName)) {
            acceptCandidates(blockProposalsFor(model, true), context, acceptor);
        } else if ("ExtensionBlockName".equals(ruleName)) {
            EObject owner = model instanceof ExtensionBlock ? model.eContainer() : model;
            acceptCandidates(blockProposalsFor(owner, false), context, acceptor);
        } else if ("ExtensionEntry".equals(ruleName) || "ExtensionKey".equals(ruleName)) {
            acceptCandidates(entryKeyProposalsFor(model, "ExtensionEntry".equals(ruleName)), context, acceptor);
        } else if ("ExtensionScalarValue".equals(ruleName) || "ExtensionScalarLiteral".equals(ruleName)) {
            acceptCandidates(entryValueProposalsFor(model), context, acceptor);
        }
        super._createProposals(ruleCall, context, acceptor);
    }

    private void acceptCandidates(
            final List<ExtensionCompletionCandidate> candidates,
            final ContentAssistContext context,
            final IIdeContentProposalAcceptor acceptor) {
        for (ExtensionCompletionCandidate c : candidates) {
            ContentAssistEntry entry = getProposalCreator().createProposal(c.text(), context, e -> {
                e.setLabel(c.label());
                e.setDescription(c.description());
                e.setKind(c.kind());
            });
            if (entry != null) {
                acceptor.accept(entry, getProposalPriorities().getDefaultPriority(entry) + 50);
            }
        }
    }

    public static List<ExtensionCompletionCandidate> blockProposalsFor(
            final EObject owner,
            final boolean includeAtColon) {
        HookLocation loc = HookLocation.fromElement(owner);
        if (loc == null && owner instanceof Extensible) {
            loc = HookLocation.fromElement(owner);
        }
        List<ExtensionCompletionCandidate> out = new ArrayList<>();
        Set<String> seen = new LinkedHashSet<>();
        for (RosToolingPlugin plugin : PluginRegistry.INSTANCE.activePlugins()) {
            if (plugin.blocks() == null) {
                continue;
            }
            for (BlockDescriptor desc : plugin.blocks()) {
                if (desc == null) {
                    continue;
                }
                if (loc != null && !desc.allowedLocations().isEmpty() && !desc.allowedLocations().contains(loc)) {
                    continue;
                }
                String blockName = PluginRegistry.INSTANCE.isCollidingBlockName(desc.name())
                        ? plugin.id() + "." + desc.name()
                        : desc.name();
                if (!seen.add(blockName)) {
                    continue;
                }
                String insert = includeAtColon ? "@" + blockName + ":\n  " : blockName;
                String description = !desc.description().isBlank()
                        ? desc.description() + " (" + plugin.id() + ")"
                        : "Extension block from " + plugin.id();
                out.add(new ExtensionCompletionCandidate(
                        insert,
                        "@" + blockName,
                        description,
                        ContentAssistEntry.KIND_SNIPPET));
            }
        }
        return out;
    }

    public static List<ExtensionCompletionCandidate> entryKeyProposalsFor(
            final EObject model,
            final boolean includeColon) {
        ExtensionSchemaMapper.ResolvedSchemaContext ctx = ExtensionSchemaMapper.resolveSchemaContext(model);
        if (ctx == null || ctx.containerClass() == null) {
            return List.of();
        }
        EClass containerClass = ctx.containerClass();
        List<ExtensionCompletionCandidate> out = new ArrayList<>();
        for (EStructuralFeature feature : containerClass.getEAllStructuralFeatures()) {
            if (!feature.isChangeable()) {
                continue;
            }
            String insert = includeColon ? feature.getName() + ": " : feature.getName();
            String desc = ExtensionSchemaMapper.describeFeatureType(feature)
                    + (feature.isRequired() ? " (required)" : " (optional)");
            out.add(new ExtensionCompletionCandidate(
                    insert,
                    feature.getName(),
                    desc,
                    ContentAssistEntry.KIND_PROPERTY));
        }
        return out;
    }

    public static List<ExtensionCompletionCandidate> entryValueProposalsFor(final EObject model) {
        ExtensionSchemaMapper.ResolvedSchemaContext ctx = ExtensionSchemaMapper.resolveSchemaContext(model);
        if (ctx == null || ctx.feature() == null) {
            return List.of();
        }
        EStructuralFeature feature = ctx.feature();
        List<ExtensionCompletionCandidate> out = new ArrayList<>();
        if (feature instanceof EAttribute attr) {
            EDataType dt = attr.getEAttributeType();
            if (dt instanceof EEnum eEnum) {
                for (EEnumLiteral lit : eEnum.getELiterals()) {
                    out.add(new ExtensionCompletionCandidate(
                            lit.getLiteral(),
                            lit.getLiteral(),
                            "Enum literal of " + eEnum.getName(),
                            ContentAssistEntry.KIND_ENUM));
                }
            } else if (dt != null && (dt.getInstanceClass() == boolean.class
                    || dt.getInstanceClass() == Boolean.class
                    || "EBoolean".equals(dt.getName()))) {
                out.add(new ExtensionCompletionCandidate("true", "true", "boolean", ContentAssistEntry.KIND_VALUE));
                out.add(new ExtensionCompletionCandidate("false", "false", "boolean", ContentAssistEntry.KIND_VALUE));
            }
        }
        return out;
    }

    public static List<ExtensionCompletionCandidate> refKindProposalsFor(final EObject model) {
        ExtensionSchemaMapper.ResolvedSchemaContext ctx = ExtensionSchemaMapper.resolveSchemaContext(model);
        if (ctx == null || ctx.feature() == null) {
            return List.of();
        }
        List<ExtensionCompletionCandidate> out = new ArrayList<>();
        for (String prefix : ExtensionSchemaMapper.expectedRefPrefixes(ctx.feature())) {
            out.add(new ExtensionCompletionCandidate(
                    prefix,
                    prefix,
                    "ROS interface reference prefix",
                    ContentAssistEntry.KIND_REFERENCE));
        }
        return out;
    }
}
