package de.fraunhofer.ipa.ros.plugin.spi;

import de.fraunhofer.ipa.ros2.distro.Ros2Distro;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import ros.Extensible;
import ros.ExtensionBlock;

/**
 * System-level code generation context handed to
 * {@link RosToolingPlugin#generateSystem(SystemGenerationContext)} during Phase B of
 * {@code .rossystem} generation.
 *
 * <p><b>Metamodel typing:</b> {@link #systemModel()} (a {@code system.System}) and elements of
 * {@link #rosNodes()} ({@code system.RosNode} instances) are typed as {@link Extensible} so core's
 * SPI bundle remains independent of {@code de.fraunhofer.ipa.rossystem}. Plugins needing raw
 * system-metamodel fields (such as {@code System.getConnections()} or
 * {@code RosNode.getRosparameters()}) depend on {@code de.fraunhofer.ipa.rossystem} and cast;
 * {@link #resolvedNodes()} and {@link #resolvedPackages()} remain directly typed as core {@code ros}
 * model objects.
 *
 * <p><b>Output folders and launch files:</b> System-level plugins may write or delete files only
 * inside three namespaced folders under the system package:
 * {@code config/<plugin-folder>/} (installed), {@code launch/<plugin-folder>/} (installed), and
 * {@code plugins/<plugin-folder>/} (not installed). Launch files stay core-authored; plugins add
 * their own launch files via {@link #addLaunchInclude(String, Map)} rather than inspecting or
 * modifying core launch files. Note that when core generates a pure-Python bringup package and a
 * user-owned {@code setup.py} already exists on disk, core preserves that user {@code setup.py}
 * without modifying its {@code data_files}.
 */
public final class SystemGenerationContext extends GenerationContext {

    public enum LaunchArgumentKind {
        LITERAL,
        SYSTEM_LAUNCH_ARG,
        SUBSTITUTION
    }

    public record LaunchArgumentValue(LaunchArgumentKind kind, String value) {
        public LaunchArgumentValue {
            Objects.requireNonNull(kind, "kind");
            Objects.requireNonNull(value, "value");
        }

        public static LaunchArgumentValue literal(final String text) {
            return new LaunchArgumentValue(LaunchArgumentKind.LITERAL, text);
        }

        public static LaunchArgumentValue systemLaunchArgument(final String argName) {
            return new LaunchArgumentValue(LaunchArgumentKind.SYSTEM_LAUNCH_ARG, argName);
        }

        public static LaunchArgumentValue substitution(final String expr) {
            return new LaunchArgumentValue(LaunchArgumentKind.SUBSTITUTION, expr);
        }
    }

    public record LaunchArgument(String name, LaunchArgumentValue value) {
        public LaunchArgument {
            Objects.requireNonNull(name, "name");
            Objects.requireNonNull(value, "value");
        }
    }

    public record LaunchInclude(
            String pluginId,
            String launchFileRelativePath,
            Map<String, LaunchArgumentValue> launchArguments) {
    }

    private final Extensible systemModel;
    private final List<Extensible> rosNodes;
    private final Map<Extensible, ros.Node> rosNodeTypes;
    private final List<ros.Node> resolvedNodes;
    private final List<ros.Package> resolvedPackages;
    private final boolean fromFileSystem;
    private final Set<String> declaredSystemLaunchArgs;
    private final Map<String, LaunchInclude> sharedLaunchIncludes;

    public SystemGenerationContext(
            final String pluginId,
            final String systemName,
            final Extensible systemModel,
            final boolean fromFileSystem,
            final List<Extensible> rosNodes,
            final Map<Extensible, ros.Node> rosNodeTypes,
            final List<ros.Node> resolvedNodes,
            final List<ros.Package> resolvedPackages,
            final Set<String> declaredSystemLaunchArgs,
            final Resource resource,
            final Ros2Distro ros2Distro,
            final List<String> existingFiles,
            final Set<String> coreOwnedPaths,
            final Map<String, String> allPluginOwnedFiles,
            final Map<String, LaunchInclude> sharedLaunchIncludes,
            final List<String> errors,
            final PluginRegistry registry) {
        super(
                pluginId,
                systemName,
                resource,
                ros2Distro,
                existingFiles,
                coreOwnedPaths,
                allPluginOwnedFiles,
                errors,
                registry);
        this.systemModel = Objects.requireNonNull(systemModel, "systemModel");
        this.fromFileSystem = fromFileSystem;
        this.rosNodes = rosNodes == null ? List.of() : Collections.unmodifiableList(rosNodes);
        this.rosNodeTypes = rosNodeTypes == null ? Map.of() : Collections.unmodifiableMap(rosNodeTypes);
        this.resolvedNodes = resolvedNodes == null ? List.of() : Collections.unmodifiableList(resolvedNodes);
        this.resolvedPackages = resolvedPackages == null ? List.of() : Collections.unmodifiableList(resolvedPackages);
        this.declaredSystemLaunchArgs = declaredSystemLaunchArgs == null
                ? Set.of()
                : Collections.unmodifiableSet(new LinkedHashSet<>(declaredSystemLaunchArgs));
        this.sharedLaunchIncludes = sharedLaunchIncludes != null ? sharedLaunchIncludes : new LinkedHashMap<>();
    }

    /**
     * Target {@code system.System} model object typed as {@link Extensible}. Plugins needing raw
     * system-metamodel members depend on {@code de.fraunhofer.ipa.rossystem} and cast to
     * {@code system.System}.
     */
    public Extensible systemModel() {
        return systemModel;
    }

    /**
     * Unmodifiable list of {@code system.RosNode} component instances in {@link #systemModel()},
     * typed as {@link Extensible}. Plugins needing raw {@code RosNode} fields depend on
     * {@code de.fraunhofer.ipa.rossystem} and cast to {@code system.RosNode}.
     */
    public List<Extensible> rosNodes() {
        return rosNodes;
    }

    /**
     * Deduplicated read-only list of underlying {@link ros.Node} definitions referenced by nodes in
     * this system.
     */
    public List<ros.Node> resolvedNodes() {
        return resolvedNodes;
    }

    /**
     * Deduplicated read-only list of enclosing {@link ros.Package} definitions for the nodes and
     * attached plugins in this system.
     */
    public List<ros.Package> resolvedPackages() {
        return resolvedPackages;
    }

    /**
     * Returns the typed Ecore schema object for {@code @<blockName>:} on {@link #systemModel()}, or
     * {@code null} if absent or unknown.
     */
    public EObject systemTypedBlock(final String blockName) {
        return typedBlock(systemModel, blockName);
    }

    /**
     * Returns the merged typed Ecore schema object for {@code @<blockName>:} on a
     * {@code system.RosNode} instance merged over its underlying {@code ros.Node} type, or
     * {@code null} if neither carries that block. Records any {@link MergeStrategy#ERROR_ON_CONFLICT}
     * failure naming the block.
     */
    public EObject rosNodeTypedBlock(final Extensible rosNodeInstance, final String blockName) {
        if (rosNodeInstance == null || blockName == null) {
            return null;
        }
        Extensible typeNode = rosNodeTypes.get(rosNodeInstance);
        BlockDescriptor desc = registry != null ? registry.blockDescriptor(blockName) : null;
        ExtensionBlockMerger.MergeResult mergeResult = ExtensionBlockMerger.mergeWithConflicts(
                typeNode, rosNodeInstance, blockName, desc);
        for (String conflict : mergeResult.conflictErrors()) {
            recordError(conflict);
        }
        ExtensionBlock merged = mergeResult.mergedBlock();
        if (merged == null) {
            return null;
        }
        return desc != null ? ExtensionSchemaMapper.toTypedObject(merged, desc) : null;
    }

    /**
     * Unmodifiable view of the launch argument names declared by core in the generated system
     * launch file (for use with {@link LaunchArgumentKind#SYSTEM_LAUNCH_ARG}).
     */
    public Set<String> declaredSystemLaunchArguments() {
        return declaredSystemLaunchArgs;
    }

    /**
     * Registers a plugin-authored launch file inside {@code launch/<plugin-folder>/} to be
     * included from core's generated system launch file inside a scoped {@code GroupAction}.
     */
    public void addLaunchInclude(final String relativeLaunchPath) {
        addLaunchInclude(relativeLaunchPath, List.of());
    }

    /**
     * Registers a plugin-authored launch file inside {@code launch/<plugin-folder>/} with launch
     * arguments ({@link LaunchArgumentKind#LITERAL}, {@link LaunchArgumentKind#SYSTEM_LAUNCH_ARG},
     * or {@link LaunchArgumentKind#SUBSTITUTION}) to be included inside its own scoped
     * {@code GroupAction}. Duplicate include paths fail naming the offending plugin(s).
     */
    public void addLaunchInclude(
            final String relativeLaunchPath,
            final Map<String, LaunchArgumentValue> launchArguments) {
        List<LaunchArgument> argList = launchArguments == null
                ? List.of()
                : launchArguments.entrySet().stream()
                        .map(e -> new LaunchArgument(e.getKey(), e.getValue()))
                        .toList();
        addLaunchInclude(relativeLaunchPath, argList);
    }

    /**
     * List-based overload of {@link #addLaunchInclude(String, Map)} that preserves argument order
     * and detects duplicate argument names passed to the same include.
     */
    public void addLaunchInclude(
            final String relativeLaunchPath,
            final List<LaunchArgument> launchArguments) {
        if (fromFileSystem) {
            recordError("Plugin '" + pluginId() + "' cannot register launch include '" + relativeLaunchPath
                    + "' on fromFile system '" + outputRootName() + "' (core generates no launch file)");
            return;
        }
        String subPath = stripOutputRootPrefix(relativeLaunchPath);
        if (subPath == null || subPath.isBlank()) {
            recordError("Plugin '" + pluginId() + "' provided invalid launch include path: '"
                    + relativeLaunchPath + "'");
            return;
        }
        LaunchInclude existing = sharedLaunchIncludes.get(subPath);
        if (existing != null) {
            if (!existing.pluginId().equals(pluginId())) {
                recordError("Plugin conflict between '" + existing.pluginId() + "' and '" + pluginId()
                        + "' on launch include '" + subPath + "'");
            } else {
                recordError("Duplicate launch include from plugin '" + pluginId() + "': '" + subPath + "'");
            }
            return;
        }
        String requiredPrefix = "launch/" + pluginFolder() + "/";
        if (!subPath.startsWith(requiredPrefix)
                || subPath.length() <= requiredPrefix.length()
                || !subPath.endsWith(".launch.py")
                || !PackageBuild.isValidRelativeBuildPath(subPath)) {
            recordError("Plugin '" + pluginId() + "' launch include '" + subPath
                    + "' must reside inside '" + requiredPrefix + "' and end with '.launch.py'");
            return;
        }

        Map<String, LaunchArgumentValue> safeArgs = new LinkedHashMap<>();
        if (launchArguments != null) {
            for (LaunchArgument arg : launchArguments) {
                if (arg == null) {
                    continue;
                }
                String argName = arg.name();
                LaunchArgumentValue argVal = arg.value();
                if (!PackageBuild.isValidIdentifier(argName)) {
                    recordError("Plugin '" + pluginId() + "' provided invalid launch argument name '"
                            + argName + "' on include '" + subPath + "'");
                    return;
                }
                if (safeArgs.containsKey(argName)) {
                    recordError("Plugin '" + pluginId() + "' passed duplicate launch argument '"
                            + argName + "' on include '" + subPath + "'");
                    return;
                }
                if (argVal == null || argVal.value() == null) {
                    recordError("Plugin '" + pluginId() + "' provided null value for launch argument '"
                            + argName + "'");
                    return;
                }
                switch (argVal.kind()) {
                    case SYSTEM_LAUNCH_ARG -> {
                        if (!PackageBuild.isValidIdentifier(argVal.value())) {
                            recordError("Plugin '" + pluginId() + "' provided invalid system launch argument name '"
                                    + argVal.value() + "' for argument '" + argName + "'");
                            return;
                        }
                        if (!declaredSystemLaunchArgs.contains(argVal.value())) {
                            recordError("Plugin '" + pluginId() + "' referenced undeclared system launch argument '"
                                    + argVal.value() + "' for argument '" + argName + "' on include '" + subPath + "'");
                            return;
                        }
                    }
                    case SUBSTITUTION -> {
                        if (!argVal.value().contains("$(")
                                || argVal.value().contains("\n")
                                || argVal.value().contains("\r")) {
                            recordError("Plugin '" + pluginId() + "' provided invalid substitution expression for argument '"
                                    + argName + "': '" + argVal.value() + "'");
                            return;
                        }
                    }
                    case LITERAL -> {
                        // Validated non-null; escaped identically to core strings during Python rendering.
                    }
                }
                safeArgs.put(argName, argVal);
            }
        }

        sharedLaunchIncludes.put(subPath, new LaunchInclude(pluginId(), subPath, Collections.unmodifiableMap(safeArgs)));
    }

    @Override
    protected boolean validatePluginRelativePath(final String subPath, final String operation) {
        String pf = pluginFolder();
        String configPrefix = "config/" + pf + "/";
        String launchPrefix = "launch/" + pf + "/";
        String pluginsPrefix = "plugins/" + pf + "/";
        boolean allowedPrefix = (subPath.startsWith(configPrefix) && subPath.length() > configPrefix.length())
                || (subPath.startsWith(launchPrefix) && subPath.length() > launchPrefix.length())
                || (subPath.startsWith(pluginsPrefix) && subPath.length() > pluginsPrefix.length());
        if (!allowedPrefix || !PackageBuild.isValidRelativeBuildPath(subPath)) {
            recordError("Plugin '" + pluginId() + "' cannot " + operation + " '" + outputRootName() + "/" + subPath
                    + "': system-level plugins may only write under config/" + pf + "/, launch/" + pf
                    + "/, or plugins/" + pf + "/");
            return false;
        }
        return true;
    }
}
