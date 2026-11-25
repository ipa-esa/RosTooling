/**
 * Generic Service Provider Interface (SPI) for extending RosTooling without coupling core to any
 * plugin-specific domain concepts.
 *
 * <h2>Two-Tier Plugin Extension Model</h2>
 * <ul>
 *   <li><b>Tier 1 (Embedded {@code @<block>:} syntax):</b> Plugins declare {@link BlockDescriptor}s
 *       backed by their own {@link org.eclipse.emf.ecore.EClass} schemas and attach them to core
 *       metamodel hook locations ({@link HookLocation#SYSTEM}, {@link HookLocation#ROS_NODE},
 *       {@link HookLocation#NODE}, {@link HookLocation#PLUGIN},
 *       {@link HookLocation#ROS_INTERFACE}). Core parses, scopes interface references
 *       ({@code pub->}, {@code sub->}, {@code ss->}, {@code sc->}, {@code as->}, {@code ac->},
 *       {@code param->}), checks schemas, provides hover/completion and GLSP/MCP editing, and
 *       merges type/instance blocks automatically.</li>
 *   <li><b>Tier 2 (External Plugin Languages):</b> Plugins that need dedicated domain file formats
 *       (e.g., visual editors or separate textual DSLs) ship their own Xtext/EMF language in their
 *       plugin bundle, cross-reference core {@code .ros2} / {@code .rossystem} resources through the
 *       standard Xtext global index ({@code IResourceDescriptions}), and participate in validation,
 *       package/system generation ({@link PackageBuild}, {@link PackageGenerationContext},
 *       {@link SystemGenerationContext}), and dynamic MCP/LSP tooling by registering a
 *       {@link RosToolingPlugin} via {@link java.util.ServiceLoader} or as an OSGi service.</li>
 * </ul>
 *
 * <h2>The plugin interface</h2>
 * The types a plugin implements, constructs or receives form the plugin interface, versioned by
 * {@link PluginRegistry#PLUGIN_API_VERSION}: {@link RosToolingPlugin}, {@link StartupClaim}, {@link BlockDescriptor},
 * {@link LoaderDescriptor}, {@link PluginToolDescriptor}, {@link HookLocation},
 * {@link MergeStrategy}, {@link SchemaHints}, {@link GenerationContext},
 * {@link PackageGenerationContext}, {@link SystemGenerationContext}, {@link PackageBuild},
 * {@link ValidationContext}, {@link ValidationIssue}, {@link ToolExecutionContext},
 * {@link ToolResult} and {@link de.fraunhofer.ipa.ros.plugin.model.PluginBases}. A build test
 * keeps a snapshot of their public methods and fails when they change without a version bump.
 * {@link PluginRegistry}, {@link ExtensionSchemaMapper}, {@link ExtensionBlockMerger} and
 * {@link TrustedPluginsStore} are core's own and not part of it.
 *
 * <ul>
 *   <li><b>Named loaders:</b> a plugin base names its loader. {@code pluginlib} is built into
 *       core; any other id must be registered by exactly one enabled plugin through
 *       {@link RosToolingPlugin#loaders()}, which then receives the plugins of such bases in
 *       {@link PackageGenerationContext#loaderPlugins()} and generates their loading code.</li>
 *   <li><b>Startup claims:</b> a plugin that starts a node or subsystem of the system itself
 *       returns a {@link StartupClaim} for it from
 *       {@link RosToolingPlugin#startupClaims(SystemGenerationContext)}. Core keeps the element in
 *       the launch file behind the launch argument {@code <element>_in_<plugin label>} (default from
 *       the claim; {@code UnlessCondition} on the native start), declares that argument as a system
 *       launch argument for the plugin to forward, and lists the claim in the system README. When a
 *       claimed subsystem is started natively, core also passes {@code false} for the claims inside it. Core
 *       knows nothing about what the plugin does with the element.</li>
 *   <li><b>Schema hints:</b> labels, help text, field order and choice lists are Ecore annotations
 *       on the block's classes and features (see {@link SchemaHints}); they never change what
 *       validates.</li>
 * </ul>
 *
 * <h2>Design Rules &amp; Contracts</h2>
 * <ul>
 *   <li>Discovery stays passive until enabled via {@code -Dros.plugins.enabled} /
 *       {@code ROS_PLUGINS_ENABLED} or explicit programmatic registration.</li>
 *   <li><b>Passive JAR Metadata ({@code META-INF/rostooling-plugin.properties}):</b> External
 *       plugin JARs must bundle {@code META-INF/rostooling-plugin.properties} with required keys
 *       {@code id}, {@code version}, {@code summary} and {@code pluginApiVersionRange} (for example
 *       {@code [1.0.0,2.0.0)}, checked against {@link PluginRegistry#PLUGIN_API_VERSION}), plus an
 *       optional {@code supportedCoreVersionRange} for plugins that need a newer language feature
 *       and an optional {@code documentation} key naming a Markdown resource path inside the JAR.
 *       A JAR without the file, or whose ranges do not match, is not loaded.
 *       Core reads only those entries via {@link java.util.jar.JarFile} (capped at 16 KB for
 *       properties and 256 KB for documentation, never unpacked or loaded via classloaders) so
 *       IDEs can list plugins without running any plugin code. When an enabled plugin activates,
 *       its {@link RosToolingPlugin#id()} and {@link RosToolingPlugin#version()} must match the
 *       metadata file if present.</li>
 *   <li><b>Single distro source:</b> Core resolves {@link de.fraunhofer.ipa.ros2.distro.Ros2Distro}
 *       once and exposes it via {@link GenerationContext#ros2Distro()}. Plugins must never resolve a
 *       distribution independently.</li>
 *   <li><b>Core ownership &amp; launch isolation (Rules 3 and 7):</b> Phase A (core) and Phase B
 *       (plugins via {@link RosToolingPlugin#generatePackage(PackageGenerationContext)} and
 *       {@link RosToolingPlugin#generateSystem(SystemGenerationContext)}) reserve all core-owned
 *       paths — including skipped protected user logic files — in
 *       {@link GenerationContext#coreOwnedPaths()} (paths only, never contents). Plugins must never
 *       depend on the contents of core-generated files; system launch additions go solely through
 *       {@link SystemGenerationContext#addLaunchInclude(String, java.util.Map)} inside
 *       {@code launch/<plugin-folder>/}, while system plugins write only under
 *       {@code config/<plugin-folder>/}, {@code launch/<plugin-folder>/}, and
 *       {@code plugins/<plugin-folder>/}.</li>
 *   <li><b>Known limit (pure-Python system packages):</b> Core generates recursive
 *       {@code data_files} entries in {@code setup.py} for plugin {@code config/} and
 *       {@code launch/} subfolders when core creates {@code setup.py}; a pre-existing user-owned
 *       {@code setup.py} is preserved untouched.</li>
 * </ul>
 */
package de.fraunhofer.ipa.ros.plugin.spi;