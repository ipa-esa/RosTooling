package de.fraunhofer.ipa.ros.linking;

import de.fraunhofer.ipa.ros.plugin.spi.PluginRegistry;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.diagnostics.DiagnosticMessage;
import org.eclipse.xtext.linking.impl.LinkingDiagnosticMessageProvider;
import ros.ExtensionBlock;
import ros.ExtensionRefValue;

/**
 * Suppresses unresolved cross-reference errors inside unknown {@code @<name>:} extension blocks
 * so models remain portable (producing only the unknown-block warning) when a plugin is inactive.
 */
public class RosLinkingDiagnosticMessageProvider extends LinkingDiagnosticMessageProvider {

    @Override
    public DiagnosticMessage getUnresolvedProxyMessage(final ILinkingDiagnosticContext context) {
        if (context != null && context.getContext() instanceof ExtensionRefValue refVal) {
            ExtensionBlock block = EcoreUtil2.getContainerOfType(refVal, ExtensionBlock.class);
            if (block != null && block.getName() != null) {
                if (PluginRegistry.INSTANCE.resolveBlock(block.getName()) == null
                        && !PluginRegistry.INSTANCE.isCollidingBlockName(block.getName())) {
                    return null;
                }
            }
        }
        return super.getUnresolvedProxyMessage(context);
    }
}
