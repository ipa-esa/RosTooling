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
 * Shared sealed base context handed to {@link RosToolingPlugin} generators during Phase B of
 * package or system generation. Only core may instantiate {@link PackageGenerationContext} or
 * {@link SystemGenerationContext}.
 *
 * <p><b>Single distro source:</b> Core resolves the target {@link Ros2Distro} once (from explicit
 * arguments, settings, or {@code AUTO}) and passes it via {@link #ros2Distro()}. Plugins must use
 * that resolved distribution metadata and never resolve a distribution independently, ensuring
 * plugin outputs stay aligned with core outputs.
 *
 * <p><b>Single-author ownership (Rules 3 and 7):</b> Plugins receive {@link #coreOwnedPaths()} as
 * relative paths only — never the contents of core-generated launch files, YAML files, or build
 * files — and must never depend on the contents of core-generated files. Any attempt to overwrite
 * or delete a path in {@link #coreOwnedPaths()}, a user logic file protected by the Domain Logic
 * Shield, a path outside the plugin's allowed folder, or a path already owned by another plugin
 * records an error naming the offending plugin(s).
 */
public abstract sealed class GenerationContext permits PackageGenerationContext, SystemGenerationContext {

    private final String pluginId;
    private final String pluginFolder;
    private final String outputRootName;
    private final Resource resource;
    private final Ros2Distro ros2Distro;
    private final List<String> existingFiles;
    private final Set<String> coreOwnedPaths;
    private final Map<String, String> allPluginOwnedFiles;
    private final Map<String, String> pluginWrittenFiles = new LinkedHashMap<>();
    private final Set<String> pluginDeletedFiles = new LinkedHashSet<>();
    protected final List<String> errors;
    protected final PluginRegistry registry;

    protected GenerationContext(
            final String pluginId,
            final String outputRootName,
            final Resource resource,
            final Ros2Distro ros2Distro,
            final List<String> existingFiles,
            final Set<String> coreOwnedPaths,
            final Map<String, String> allPluginOwnedFiles,
            final List<String> errors,
            final PluginRegistry registry) {
        this.pluginId = Objects.requireNonNull(pluginId, "pluginId");
        this.pluginFolder = sanitizePluginFolder(pluginId);
        if (outputRootName == null || outputRootName.isBlank()) {
            throw new IllegalArgumentException("outputRootName must not be blank");
        }
        this.outputRootName = outputRootName.toLowerCase();
        this.resource = resource;
        this.ros2Distro = Objects.requireNonNull(ros2Distro, "ros2Distro");
        this.existingFiles = existingFiles == null ? List.of() : Collections.unmodifiableList(existingFiles);
        this.coreOwnedPaths = coreOwnedPaths == null
                ? Set.of()
                : Collections.unmodifiableSet(new LinkedHashSet<>(coreOwnedPaths));
        this.allPluginOwnedFiles = allPluginOwnedFiles != null ? allPluginOwnedFiles : new LinkedHashMap<>();
        this.errors = errors;
        this.registry = registry;
    }

    /**
     * Converts a plugin ID into a filesystem-safe directory segment for system-level outputs.
     */
    public static String sanitizePluginFolder(final String pluginId) {
        if (pluginId == null || pluginId.isBlank()) {
            return "plugin";
        }
        return pluginId.replaceAll("[^A-Za-z0-9_-]", "_");
    }

    public final String pluginId() {
        return pluginId;
    }

    /**
     * Sanitized subfolder name derived from {@link #pluginId()}.
     */
    public final String pluginFolder() {
        return pluginFolder;
    }

    protected final String outputRootName() {
        return outputRootName;
    }

    public final Resource resource() {
        return resource;
    }

    /**
     * Resolved immutable {@link Ros2Distro} metadata (data only) chosen by core for this generation
     * run. Plugins must use this value rather than resolving {@code $ROS_DISTRO} themselves.
     */
    public final Ros2Distro ros2Distro() {
        return ros2Distro;
    }

    /**
     * Plain lower-case distribution name (equivalent to {@code ros2Distro().name()}).
     */
    public final String rosDistro() {
        return ros2Distro.name();
    }

    public final List<String> existingFiles() {
        return existingFiles;
    }

    /**
     * Read-only set of all relative paths reserved by core for this package or system (including
     * protected user logic files that core preserved on disk). Contains paths only, never file
     * contents.
     */
    public final Set<String> coreOwnedPaths() {
        return coreOwnedPaths;
    }

    public final EObject typedBlock(final ExtensionBlock block) {
        if (block == null) {
            return null;
        }
        BlockDescriptor desc = registry != null ? registry.blockDescriptor(block.getName()) : null;
        if (desc == null) {
            return null;
        }
        return ExtensionSchemaMapper.toTypedObject(block, desc);
    }

    public final EObject typedBlock(final Extensible owner, final String blockName) {
        if (owner == null || blockName == null) {
            return null;
        }
        ExtensionBlock block = ExtensionBlockMerger.findBlock(owner, blockName);
        if (block == null) {
            return null;
        }
        return typedBlock(block);
    }

    public final ExtensionBlock mergedBlock(
            final Extensible typeElement,
            final Extensible instanceElement,
            final String blockName) {
        BlockDescriptor desc = registry != null ? registry.blockDescriptor(blockName) : null;
        return ExtensionBlockMerger.merge(typeElement, instanceElement, blockName, desc);
    }

    /**
     * Hook for subclasses to restrict allowed relative subpaths inside {@link #outputRootName()}.
     */
    protected boolean validatePluginRelativePath(final String subPath, final String operation) {
        return true;
    }

    /**
     * Writes (overwrites on regeneration) a file scoped under this package or system's output folder.
     * Rejects writes to core-owned paths, protected user files, disallowed folders, or files owned
     * by another plugin.
     */
    public final void writeFile(final String relativePath, final String content) {
        String normalized = normalizeAndValidatePath(relativePath, "write");
        if (normalized == null) {
            return;
        }
        String previousOwner = allPluginOwnedFiles.get(normalized);
        if (previousOwner != null && !previousOwner.equals(pluginId)) {
            recordError("Plugin conflict between '" + previousOwner + "' and '" + pluginId
                    + "' on generated file '" + normalized + "'");
            return;
        }
        allPluginOwnedFiles.put(normalized, pluginId);
        pluginWrittenFiles.put(normalized, content != null ? content : "");
        pluginDeletedFiles.remove(normalized);
    }

    /**
     * Domain Logic Shield (Rule 7): writes a protected user file only if it does not already
     * exist in {@link #existingFiles()} and is not reserved in {@link #coreOwnedPaths()}.
     */
    public final boolean writeOnce(final String relativePath, final String content) {
        String normalized = normalizeAndValidatePath(relativePath, "writeOnce");
        if (normalized == null) {
            return false;
        }
        if (fileExists(normalized)) {
            return false;
        }
        writeFile(normalized, content);
        return pluginWrittenFiles.containsKey(normalized);
    }

    /**
     * Marks a stale plugin-generated file for deletion. Refuses to delete core-owned files, files
     * outside the plugin's allowed folders, or files owned by another plugin.
     */
    public final void deleteStaleFile(final String relativePath) {
        String normalized = normalizeAndValidatePath(relativePath, "delete");
        if (normalized == null) {
            return;
        }
        String owner = allPluginOwnedFiles.get(normalized);
        if (owner != null && !owner.equals(pluginId)) {
            recordError("Plugin '" + pluginId + "' cannot delete file owned by '" + owner + "': '" + normalized + "'");
            return;
        }
        pluginDeletedFiles.add(normalized);
    }

    public final boolean fileExists(final String relativePath) {
        if (relativePath == null || relativePath.isBlank()) {
            return false;
        }
        String clean = relativePath.replace('\\', '/').trim();
        String pkgPrefix = outputRootName + "/";
        String norm = clean.startsWith(pkgPrefix) ? clean : pkgPrefix + clean;
        String subPath = norm.substring(pkgPrefix.length());
        for (String existing : existingFiles) {
            if (existing.equals(norm)
                    || existing.equals("src-gen/" + norm)
                    || existing.equals(subPath)) {
                return true;
            }
        }
        return false;
    }

    public final Map<String, String> writtenFiles() {
        return Collections.unmodifiableMap(pluginWrittenFiles);
    }

    public final Set<String> deletedFiles() {
        return Collections.unmodifiableSet(pluginDeletedFiles);
    }

    protected final void recordError(final String message) {
        if (errors != null) {
            errors.add(message);
        }
    }

    protected final String stripOutputRootPrefix(final String relativePath) {
        if (relativePath == null || relativePath.isBlank()) {
            return null;
        }
        String clean = relativePath.replace('\\', '/').trim();
        if (clean.startsWith("/") || clean.contains("..")) {
            return null;
        }
        String pkgPrefix = outputRootName + "/";
        return clean.startsWith(pkgPrefix) ? clean.substring(pkgPrefix.length()) : clean;
    }

    private String normalizeAndValidatePath(final String relativePath, final String operation) {
        if (relativePath == null || relativePath.isBlank()) {
            recordError("Plugin '" + pluginId + "' attempted to " + operation + " a blank output path");
            return null;
        }
        String clean = relativePath.replace('\\', '/').trim();
        if (clean.startsWith("/") || clean.contains("..")) {
            recordError("Plugin '" + pluginId + "' attempted invalid path during " + operation + ": '" + relativePath + "'");
            return null;
        }
        String pkgPrefix = outputRootName + "/";
        String normalized = clean.startsWith(pkgPrefix) ? clean : pkgPrefix + clean;
        if (coreOwnedPaths.contains(normalized)) {
            recordError("Plugin '" + pluginId + "' attempted to "
                    + ("delete".equals(operation) ? "delete" : "overwrite")
                    + " core-owned file '" + normalized + "'");
            return null;
        }
        String subPath = normalized.substring(pkgPrefix.length());
        if (subPath.isBlank()) {
            recordError("Plugin '" + pluginId + "' attempted invalid empty path during " + operation + ": '" + relativePath + "'");
            return null;
        }
        if (!validatePluginRelativePath(subPath, operation)) {
            return null;
        }
        return normalized;
    }
}
