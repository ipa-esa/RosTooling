package de.fraunhofer.ipa.ros.documentation;

import de.fraunhofer.ipa.ros.plugin.spi.BlockDescriptor;
import de.fraunhofer.ipa.ros.plugin.spi.ExtensionSchemaMapper;
import de.fraunhofer.ipa.ros.plugin.spi.HookLocation;
import de.fraunhofer.ipa.ros.plugin.spi.PluginRegistry;
import java.util.List;
import java.util.stream.Collectors;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.documentation.impl.MultiLineCommentDocumentationProvider;
import ros.ExtensionBlock;
import ros.ExtensionEntry;

/**
 * Provides hover documentation for {@code @<name>:} extension blocks and their schema fields
 * by consulting the active {@link BlockDescriptor} and {@link EClass} metadata in
 * {@link PluginRegistry}.
 */
public class RosExtensionDocumentationProvider extends MultiLineCommentDocumentationProvider {

    private static final String GENMODEL_SOURCE = "http://www.eclipse.org/emf/2002/GenModel";

    @Override
    public String getDocumentation(final EObject o) {
        if (o instanceof ExtensionBlock block) {
            return documentBlock(block);
        }
        if (o instanceof ExtensionEntry entry) {
            return documentEntry(entry);
        }
        return super.getDocumentation(o);
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
            List<EStructuralFeature> features = schema.getEAllStructuralFeatures().stream()
                    .filter(EStructuralFeature::isChangeable)
                    .toList();
            if (!features.isEmpty()) {
                sb.append("**Fields:**\n");
                for (EStructuralFeature f : features) {
                    sb.append("- `").append(f.getName()).append("`: ")
                            .append(ExtensionSchemaMapper.describeFeatureType(f));
                    if (f.isRequired()) {
                        sb.append(" *(required)*");
                    }
                    String featDoc = genModelDoc(f);
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
        sb.append("**").append(resolvedFeature.getName()).append("** (`@")
                .append(ctx.block().getName()).append("` — `")
                .append(ctx.registered().plugin().id()).append("`)\n\n");
        sb.append("**Type:** ").append(ExtensionSchemaMapper.describeFeatureType(resolvedFeature));
        sb.append(resolvedFeature.isRequired() ? " *(required)*" : " *(optional)*");
        if (resolvedFeature.getDefaultValueLiteral() != null
                && !resolvedFeature.getDefaultValueLiteral().isBlank()) {
            sb.append("\n\n**Default:** `").append(resolvedFeature.getDefaultValueLiteral()).append("`");
        }
        String doc = genModelDoc(resolvedFeature);
        if (!doc.isEmpty()) {
            sb.append("\n\n").append(doc);
        }
        return sb.toString().trim();
    }

    private static String genModelDoc(final EStructuralFeature feature) {
        if (feature == null) {
            return "";
        }
        EAnnotation ann = feature.getEAnnotation(GENMODEL_SOURCE);
        if (ann != null && ann.getDetails() != null) {
            String doc = ann.getDetails().get("documentation");
            if (doc != null && !doc.isBlank()) {
                return doc.trim();
            }
        }
        return "";
    }
}
