package de.fraunhofer.ipa.ros.plugin.spi;

import java.util.List;
import java.util.Optional;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import ros.Plugin;
import ros.PluginSlot;

/**
 * Service Provider Interface implemented by third-party RosTooling plugins (loaded via Java
 * {@link java.util.ServiceLoader} or OSGi services).
 *
 * <p>Core RosTooling depends only on this generic contract and never encodes plugin-specific
 * semantics or concepts.
 */
public interface RosToolingPlugin {

    /**
     * Globally unique plugin identifier, e.g. {@code "de.example.my_plugin"}.
     */
    String id();

    /**
     * Semantic version of this plugin, e.g. {@code "1.0.0"}.
     */
    default String version() {
        return "1.0.0";
    }

    /**
     * Supported core SPI version range in Maven/OSGi interval notation, e.g. {@code "[3.6.0,4.0.0)"}.
     */
    default String supportedCoreVersionRange() {
        return "[3.6.0,4.0.0)";
    }

    /**
     * IDs of other {@link RosToolingPlugin}s that must run before this plugin.
     */
    default List<String> dependencies() {
        return List.of();
    }

    /**
     * Optional Markdown documentation describing this plugin's blocks, semantics, and MCP tools.
     */
    default String documentationMarkdown() {
        return "";
    }

    /**
     * {@code @<name>:} extension blocks owned by this plugin.
     */
    List<BlockDescriptor> blocks();

    /**
     * Optional custom scoping contributions for cross-references inside this plugin's blocks.
     */
    default void contributeScope(
            final EObject context,
            final EReference reference,
            final List<ScopeContribution> out) {
    }

    /**
     * Semantic validation hook invoked after core generic schema validation succeeds.
     */
    void validate(ValidationContext context);

    /**
     * Code and build generation hook invoked during Phase B of package generation.
     */
    void generate(GenerationContext context);

    /**
     * MCP/LSP authoring tools dynamically exposed when this plugin is active.
     */
    default List<PluginToolDescriptor> tools() {
        return List.of();
    }

    /**
     * Optional parameter value contribution when an {@code external}-loaded {@link Plugin} binds
     * to a host {@link PluginSlot} during system launch/parameter emission.
     */
    default Optional<String> slotParameterEntry(final Plugin plugin, final PluginSlot slot) {
        return Optional.empty();
    }
}
