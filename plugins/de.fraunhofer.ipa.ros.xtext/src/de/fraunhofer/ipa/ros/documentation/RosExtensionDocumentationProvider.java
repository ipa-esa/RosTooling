package de.fraunhofer.ipa.ros.documentation;

import de.fraunhofer.ipa.ros.plugin.model.PluginBases;
import de.fraunhofer.ipa.ros.plugin.spi.BlockDescriptor;
import de.fraunhofer.ipa.ros.plugin.spi.ExtensionSchemaMapper;
import de.fraunhofer.ipa.ros.plugin.spi.HookLocation;
import de.fraunhofer.ipa.ros.plugin.spi.PluginRegistry;
import de.fraunhofer.ipa.ros.plugin.spi.SchemaHints;
import java.util.List;
import java.util.stream.Collectors;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.documentation.impl.MultiLineCommentDocumentationProvider;
import ros.ExtensionBlock;
import ros.ExtensionEntry;
import ros.PluginBase;

/**
 * Provides hover documentation for {@code @<name>:} extension blocks and their schema fields
 * by consulting the active {@link BlockDescriptor} and {@link EClass} metadata in
 * {@link PluginRegistry}.
 */
public class RosExtensionDocumentationProvider extends MultiLineCommentDocumentationProvider {

    @Override
    public String getDocumentation(final EObject o) {
        if (o instanceof ExtensionBlock block) {
            return documentBlock(block);
        }
        if (o instanceof ExtensionEntry entry) {
            return documentEntry(entry);
        }
        if (o instanceof PluginBase base) {
            String loaderDoc = documentLoader(base);
            String own = super.getDocumentation(o);
            if (loaderDoc == null) {
                return own;
            }
            return own == null || own.isBlank() ? loaderDoc : own + "\n\n" + loaderDoc;
        }
        String own = super.getDocumentation(o);
        String described = ModelElementDescriber.describe(o);
        if (described == null) {
            return own;
        }
        return own == null || own.isBlank() ? described : own + "\n\n" + described;
    }

    /** The loader of a plugin base: built into core, or registered by a plugin. */
    private String documentLoader(final PluginBase base) {
        String loader = base.getLoader() == null ? null : base.getLoader().trim();
        if (loader == null || loader.isEmpty()) {
            return null;
        }
        if (PluginBases.PLUGINLIB.equals(loader)) {
            return "**Loader:** `pluginlib`, built into core: the host loads plugins with `pluginlib::ClassLoader`.";
        }
        List<PluginRegistry.RegisteredLoader> owners = PluginRegistry.INSTANCE.loaderRegistrations(loader);
        if (owners.size() != 1) {
            return null;
        }
        PluginRegistry.RegisteredLoader owner = owners.get(0);
        String summary = owner.descriptor().summary();
        return "**Loader:** `" + loader + "`, from plugin `" + owner.plugin().id() + "`"
                + (summary.isEmpty() ? "." : ": " + summary);
    }

    private String documentBlock(final ExtensionBlock block) {
        String name = block.getName();
        if (name == null || name.isBlank()) {
            return super.getDocumentation(block);
        }
        PluginRegistry.RegisteredBlock registered = PluginRegistry.INSTANCE.resolveBlock(name);
        if (registered == null) {
            return "**@" + name + "** — Unknown extension block (no active plugin registered).";
        }
        BlockDescriptor desc = registered.descriptor();
        StringBuilder sb = new StringBuilder();
        sb.append("**@").append(desc.name()).append("**");
        sb.append(" — plugin `").append(registered.plugin().id())
                .append("` (v").append(registered.plugin().version()).append(")\n\n");
        if (!desc.description().isBlank()) {
            sb.append(desc.description()).append("\n\n");
        }
        if (!desc.allowedLocations().isEmpty()) {
            String locs = desc.allowedLocations().stream()
                    .map(HookLocation::label)
                    .collect(Collectors.joining(", "));
            sb.append("**Allowed on:** ").append(locs).append("\n\n");
        }
        EClass schema = desc.schemaClass();
        if (schema != null) {
            String schemaHelp = SchemaHints.get(schema, SchemaHints.HELP);
            if (schemaHelp != null && !schemaHelp.equals(desc.description())) {
                sb.append(schemaHelp).append("\n\n");
            }
            List<EStructuralFeature> features = SchemaHints.orderedFeatures(schema);
            if (!features.isEmpty()) {
                sb.append("**Fields:**\n");
                for (EStructuralFeature f : features) {
                    sb.append("- `").append(f.getName()).append("`");
                    String label = SchemaHints.get(f, SchemaHints.LABEL);
                    if (label != null) {
                        sb.append(" (").append(label).append(")");
                    }
                    sb.append(": ").append(ExtensionSchemaMapper.describeFeatureType(f));
                    if (f.isRequired()) {
                        sb.append(" *(required)*");
                    }
                    String featDoc = SchemaHints.help(f);
                    if (!featDoc.isEmpty()) {
                        sb.append(" — ").append(featDoc);
                    }
                    sb.append("\n");
                }
            }
        }
        return sb.toString().trim();
    }

    private String documentEntry(final ExtensionEntry entry) {
        ExtensionSchemaMapper.ResolvedSchemaContext ctx = ExtensionSchemaMapper.resolveSchemaContext(entry);
        if (ctx == null || ctx.registered() == null || ctx.feature() == null) {
            return super.getDocumentation(entry);
        }
        EStructuralFeature resolvedFeature = ctx.feature();
        StringBuilder sb = new StringBuilder();
        sb.append("**").append(SchemaHints.label(resolvedFeature)).append("** (`@")
                .append(ctx.block().getName()).append("` — `")
                .append(ctx.registered().plugin().id()).append("`)\n\n");
        sb.append("**Type:** ").append(ExtensionSchemaMapper.describeFeatureType(resolvedFeature));
        sb.append(resolvedFeature.isRequired() ? " *(required)*" : " *(optional)*");
        if (resolvedFeature.getDefaultValueLiteral() != null
                && !resolvedFeature.getDefaultValueLiteral().isBlank()) {
            sb.append("\n\n**Default:** `").append(resolvedFeature.getDefaultValueLiteral()).append("`");
        }
        String doc = SchemaHints.help(resolvedFeature);
        if (!doc.isEmpty()) {
            sb.append("\n\n").append(doc);
        }
        if (SchemaHints.get(resolvedFeature, SchemaHints.CHOICES) != null) {
            sb.append("\n\n**Suggested values:** ").append(String.join(", ",
                    SchemaHints.choices(resolvedFeature).stream().map(c -> "`" + c + "`").toList()));
        }
        return sb.toString().trim();
    }
}
