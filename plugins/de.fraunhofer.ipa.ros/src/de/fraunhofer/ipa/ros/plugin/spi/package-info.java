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
 *       build/code generation ({@link PackageBuild}, {@link GenerationContext}), and dynamic MCP/LSP
 *       tooling by registering a {@link RosToolingPlugin} via {@link java.util.ServiceLoader} or as
 *       an OSGi service.</li>
 * </ul>
 *
 * <h2>Design Rules</h2>
 * <ul>
 *   <li>Discovery stays passive until enabled via {@code -Dros.plugins.enabled} /
 *       {@code ROS_PLUGINS_ENABLED} or explicit programmatic registration.</li>
 *   <li>Phase A (core code generation) and Phase B (plugin generation via {@link GenerationContext})
 *       preserve single-author ownership of {@code CMakeLists.txt}, {@code package.xml}, and every
 *       generated file, while respecting the Domain Logic Shield via
 *       {@link GenerationContext#writeOnce(String, String)}.</li>
 * </ul>
 */
package de.fraunhofer.ipa.ros.plugin.spi;
