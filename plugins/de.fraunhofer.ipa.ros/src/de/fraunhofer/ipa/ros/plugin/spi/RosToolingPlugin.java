package de.fraunhofer.ipa.ros.plugin.spi;

import java.util.List;

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
     * Optional core version range in Maven/OSGi interval notation, e.g. {@code "[3.6.0,4.0.0)"}, for a
     * plugin that needs a language feature added in a later core. Empty means any core. Whether the
     * plugin understands this interface is decided by {@code pluginApiVersionRange} in the JAR's
     * {@value PluginRegistry#METADATA_ENTRY}, checked against {@link PluginRegistry#PLUGIN_API_VERSION}.
     */
    default String supportedCoreVersionRange() {
        return "";
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
     * Plugin loaders this plugin provides. Plugins whose base names one of these loaders are routed
     * to this plugin's {@link #generatePackage(PackageGenerationContext)}.
     */
    default List<LoaderDescriptor> loaders() {
        return List.of();
    }

    /**
     * Semantic validation hook invoked after core generic schema validation succeeds.
     */
    void validate(ValidationContext context);

    /**
     * Code and build generation hook invoked during Phase B of {@code .ros2} package generation.
     * Defaults to a no-op so system-only plugins do not need to override it.
     */
    default void generatePackage(final PackageGenerationContext context) {
    }

    /**
     * Code and file generation hook invoked during Phase B of {@code .rossystem} system generation.
     * Defaults to a no-op so package-only plugins do not need to override it.
     */
    default void generateSystem(final SystemGenerationContext context) {
    }

    /**
     * Declares the elements of the system being generated (nodes and subsystems) that this plugin
     * starts itself. Called by core exactly once per system, before
     * {@link #generateSystem(SystemGenerationContext)}, so the claim arguments are already declared
     * when the plugin registers its launch include. It must derive the claims from
     * {@link SystemGenerationContext#systemModel()} only. See {@link StartupClaim}.
     *
     * <p>The launch argument of a claim is named {@code <system>.<element>_in_<label>}
     * ({@link StartupClaim#argumentName(String, String)}); this scheme is stable API. A claim whose
     * argument name is already declared in the system, or that two plugins make for one element
     * (including two plugin ids with the same sanitized last segment), is rejected: the generation
     * run fails with a plugin conflict error, like other plugin conflicts. A subsystem included
     * {@code fromFile} is outside core's control: core still passes
     * {@link StartupClaim#NATIVE_SWITCH_ARGUMENT}, but only launch files that declare it honour it.
     * Defaults to no claims.
     */
    default List<StartupClaim> startupClaims(final SystemGenerationContext context) {
        return List.of();
    }

    /**
     * MCP/LSP authoring tools dynamically exposed when this plugin is active.
     */
    default List<PluginToolDescriptor> tools() {
        return List.of();
    }
}
