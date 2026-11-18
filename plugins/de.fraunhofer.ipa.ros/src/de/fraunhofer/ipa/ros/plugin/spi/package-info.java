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
 * <h2>Design Rules &amp; Contracts</h2>
 * <ul>
 *   <li>Discovery stays passive until enabled via {@code -Dros.plugins.enabled} /
 *       {@code ROS_PLUGINS_ENABLED} or explicit programmatic registration.</li>
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