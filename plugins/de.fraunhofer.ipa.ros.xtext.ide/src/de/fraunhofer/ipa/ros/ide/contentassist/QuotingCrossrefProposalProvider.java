package de.fraunhofer.ipa.ros.ide.contentassist;

import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistEntry;
import org.eclipse.xtext.ide.editor.contentassist.IdeCrossrefProposalProvider;
import org.eclipse.xtext.resource.IEObjectDescription;

/**
 * Cross-reference proposals for references written as quoted strings
 * ({@code type: "pkg/msg/Name"}, {@code from: "pkg.node"}).
 *
 * <p>Xtext's default provider offers the bare qualified name, which neither matches a prefix that
 * starts with the opening quote (so nothing is offered once the cursor is inside the quotes) nor
 * parses as an {@code EString} when inserted. This provider matches against the text after the
 * quote, keeps the quote the user typed, and adds the closing quote when it is missing. For a
 * cursor in front of the value it offers the fully quoted name.
 */
public class QuotingCrossrefProposalProvider extends IdeCrossrefProposalProvider {

    @Override
    protected ContentAssistEntry createProposal(
            final IEObjectDescription candidate,
            final CrossReference crossReference,
            final ContentAssistContext context) {
        if (!isQuotedReference(crossReference)) {
            return super.createProposal(candidate, crossReference, context);
        }
        String name = getQualifiedNameConverter().toString(candidate.getName());
        String prefix = context.getPrefix() == null ? "" : context.getPrefix();
        char quote = '"';
        boolean opened = false;
        if (!prefix.isEmpty() && (prefix.charAt(0) == '"' || prefix.charAt(0) == '\'')) {
            quote = prefix.charAt(0);
            prefix = prefix.substring(1);
            opened = true;
        }
        if (!matches(name, prefix)) {
            return null;
        }
        boolean closed = opened && followedBy(context, quote);
        ContentAssistEntry entry = new ContentAssistEntry();
        entry.setProposal(opened ? name + (closed ? "" : String.valueOf(quote)) : quote + name + quote);
        entry.setPrefix(prefix);
        entry.setLabel(name);
        entry.setSource(candidate);
        entry.setKind(ContentAssistEntry.KIND_REFERENCE);
        if (candidate.getEClass() != null) {
            entry.setDescription(candidate.getEClass().getName());
        }
        return entry;
    }

    /** Case-insensitive prefix match on the whole name or on any segment after {@code . / :}. */
    static boolean matches(final String name, final String prefix) {
        if (prefix.isEmpty()) {
            return true;
        }
        String n = name.toLowerCase();
        String p = prefix.toLowerCase();
        if (n.startsWith(p)) {
            return true;
        }
        for (int i = 1; i < n.length(); i++) {
            char before = n.charAt(i - 1);
            if ((before == '.' || before == '/' || before == ':') && n.startsWith(p, i)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isQuotedReference(final CrossReference crossReference) {
        AbstractElement terminal = crossReference.getTerminal();
        return terminal instanceof RuleCall call
                && call.getRule() != null
                && "EString".equals(call.getRule().getName());
    }

    private static boolean followedBy(final ContentAssistContext context, final char quote) {
        try {
            String text = context.getRootNode().getText();
            int offset = context.getOffset();
            return offset >= 0 && offset < text.length() && text.charAt(offset) == quote;
        } catch (RuntimeException e) {
            return false;
        }
    }
}
