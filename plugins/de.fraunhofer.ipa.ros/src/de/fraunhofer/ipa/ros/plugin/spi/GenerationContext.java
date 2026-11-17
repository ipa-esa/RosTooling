package de.fraunhofer.ipa.ros.plugin.spi;

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
import ros.Plugin;

/**
 * Code generation context handed to each {@link RosToolingPlugin} during Phase B of package
 * generation. Enforces single-author file ownership (Rule 3), Domain Logic Shield via
 * {@link #writeOnce(String, String)} (Rule 7), and external plugin registration ownership.
 */
public final class GenerationContext {

    private final String pluginId;
    private final ros.Package packageModel;
    private final Resource resource;
    private final String rosDistro;
    private final List<String> existingFiles;
    private final Map<String, String> coreGeneratedFiles;
    private final Map<String, String> allPluginOwnedFiles;
    private final Map<String, String> pluginWrittenFiles = new LinkedHashMap<>();
    private final Set<String> pluginDeletedFiles = new LinkedHashSet<>();
    private final Map<Plugin, String> externalRegistrations;
    private final PackageBuild packageBuild;
    private final List<String> errors;
    private final PluginRegistry registry;

    public GenerationContext(
            final String pluginId,
            final ros.Package packageModel,
            final Resource resource,
            final String rosDistro,
            final List<String> existingFiles,
            final Map<String, String> coreGeneratedFiles,
            final Map<String, String> allPluginOwnedFiles,
            final Map<Plugin, String> externalRegistrations,
            final PackageBuild packageBuild,
            final List<String> errors,
            final PluginRegistry registry) {
        this.pluginId = Objects.requireNonNull(pluginId, "pluginId");
        this.packageModel = Objects.requireNonNull(packageModel, "packageModel");
        this.resource = resource;
        this.rosDistro = rosDistro != null ? rosDistro : "";
        this.existingFiles = existingFiles == null ? List.of() : Collections.unmodifiableList(existingFiles);
        this.coreGeneratedFiles = coreGeneratedFiles == null
                ? Map.of()
                : Collections.unmodifiableMap(coreGeneratedFiles);
        this.allPluginOwnedFiles = allPluginOwnedFiles;
        this.externalRegistrations = externalRegistrations;
        this.packageBuild = Objects.requireNonNull(packageBuild, "packageBuild");
        this.errors = errors;
        this.registry = registry;
    }

    public String pluginId() { return pluginId; }
    public ros.Package packageModel() { return packageModel; }
    public Resource resource() { return resource; }
    public String rosDistro() { return rosDistro; }
    public List<String> existingFiles() { return existingFiles; }
    public Map<String, String> coreGeneratedFiles() { return coreGeneratedFiles; }
    public PackageBuild packageBuild() { return packageBuild; }

    public EObject typedBlock(final ExtensionBlock block) {
        if (block == null) return null;
        BlockDescriptor desc = registry != null ? registry.blockDescriptor(block.getName()) : null;
        if (desc == null) return null;
        return ExtensionSchemaMapper.toTypedObject(block, desc);
    }

    public ExtensionBlock mergedBlock(final Extensible typeElement, final Extensible instanceElement, final String blockName) {
        BlockDescriptor desc = registry != null ? registry.blockDescriptor(blockName) : null;
        return ExtensionBlockMerger.merge(typeElement, instanceElement, blockName, desc);
    }

    /**
     * Writes (overwrites on regeneration) a file scoped under this package's generated directory.
     * Enforces Rule 3: rejects writes outside the package directory or to files already authored
     * by core or another plugin.
     */
    public void writeFile(final String relativePath, final String content) {
        String normalized = normalizePackageRelativePath(relativePath);
        if (coreGeneratedFiles.containsKey(normalized)) {
            errors.add("Plugin '" + pluginId + "' attempted to overwrite core-authored file '" + normalized + "'");
            return;
        }
        String previousOwner = allPluginOwnedFiles.get(normalized);
        if (previousOwner != null && !previousOwner.equals(pluginId)) {
            errors.add("Plugin conflict between '" + previousOwner + "' and '" + pluginId
                    + "' on generated file '" + normalized + "'");
            return;
        }
        allPluginOwnedFiles.put(normalized, pluginId);
        pluginWrittenFiles.put(normalized, content != null ? content : "");
        pluginDeletedFiles.remove(normalized);
    }

    /**
     * Domain Logic Shield (Rule 7): writes a protected user file only if it does not already
     * exist in {@link #existingFiles()}.
     */
    public boolean writeOnce(final String relativePath, final String content) {
        String normalized = normalizePackageRelativePath(relativePath);
        if (fileExists(normalized)) {
            return false;
        }
        writeFile(normalized, content);
        return true;
    }

    /**
     * Marks a stale plugin-generated file for deletion. Refuses to delete core files or files
     * owned by another plugin.
     */
    public void deleteStaleFile(final String relativePath) {
        String normalized = normalizePackageRelativePath(relativePath);
        if (coreGeneratedFiles.containsKey(normalized)) {
            errors.add("Plugin '" + pluginId + "' cannot delete core-authored file '" + normalized + "'");
            return;
        }
        String owner = allPluginOwnedFiles.get(normalized);
        if (owner != null && !owner.equals(pluginId)) {
            errors.add("Plugin '" + pluginId + "' cannot delete file owned by '" + owner + "': '" + normalized + "'");
            return;
        }
        pluginDeletedFiles.add(normalized);
    }

    /**
     * Claims responsibility for supplying registration code for a {@code loader: external}
     * {@link Plugin}. Raises a conflict error naming both plugins if already claimed by another plugin.
     */
    public void claimExternalPluginRegistration(final Plugin plugin) {
        if (plugin == null) return;
        String previousOwner = externalRegistrations.get(plugin);
        if (previousOwner != null && !previousOwner.equals(pluginId)) {
            errors.add("Plugin conflict between '" + previousOwner + "' and '" + pluginId
                    + "' on external registration for plugin '" + plugin.getName() + "'");
            return;
        }
        externalRegistrations.put(plugin, pluginId);
    }

    public boolean fileExists(final String relativePath) {
        String norm = normalizePackageRelativePath(relativePath);
        String pkgName = packageModel.getName().toLowerCase();
        String fileSuffix = norm.contains("/") ? norm.substring(pkgName.length()) : "/" + norm;
        for (String existing : existingFiles) {
            if (existing.equals(norm)
                    || existing.equals("src-gen/" + norm)
                    || (existing.startsWith(pkgName + "/") && existing.endsWith(fileSuffix))
                    || (existing.startsWith("src-gen/" + pkgName + "/") && existing.endsWith(fileSuffix))) {
                return true;
            }
        }
        return false;
    }

    private String normalizePackageRelativePath(final String relativePath) {
        if (relativePath == null || relativePath.isBlank()) {
            throw new IllegalArgumentException("Output path must not be blank");
        }
        String clean = relativePath.replace('\\', '/').trim();
        while (clean.startsWith("/")) {
            clean = clean.substring(1);
        }
        if (clean.contains("..")) {
            throw new IllegalArgumentException("Path traversal not allowed in plugin output: " + relativePath);
        }
        String pkgPrefix = packageModel.getName().toLowerCase() + "/";
        return clean.startsWith(pkgPrefix) ? clean : pkgPrefix + clean;
    }

    public Map<String, String> writtenFiles() {
        return Collections.unmodifiableMap(pluginWrittenFiles);
    }

    public Set<String> deletedFiles() {
        return Collections.unmodifiableSet(pluginDeletedFiles);
    }
}
