package de.fraunhofer.ipa.ros.plugin.spi;

import de.fraunhofer.ipa.ros2.distro.Ros2Distro;
import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import org.eclipse.emf.ecore.resource.Resource;
import ros.Plugin;

/**
 * Package-level code and build generation context handed to
 * {@link RosToolingPlugin#generatePackage(PackageGenerationContext)} during Phase B of
 * {@code .ros2} package generation.
 */
public final class PackageGenerationContext extends GenerationContext {

    private final ros.Package packageModel;
    private final PackageBuild packageBuild;
    private final Map<Plugin, String> externalRegistrations;

    public PackageGenerationContext(
            final String pluginId,
            final ros.Package packageModel,
            final Resource resource,
            final Ros2Distro ros2Distro,
            final List<String> existingFiles,
            final Set<String> coreOwnedPaths,
            final Map<String, String> allPluginOwnedFiles,
            final Map<Plugin, String> externalRegistrations,
            final PackageBuild packageBuild,
            final List<String> errors,
            final PluginRegistry registry) {
        this(
                pluginId,
                packageModel,
                resource,
                ros2Distro,
                null,
                existingFiles,
                coreOwnedPaths,
                allPluginOwnedFiles,
                externalRegistrations,
                packageBuild,
                errors,
                registry);
    }

    public PackageGenerationContext(
            final String pluginId,
            final ros.Package packageModel,
            final Resource resource,
            final Ros2Distro ros2Distro,
            final Path outputRoot,
            final List<String> existingFiles,
            final Set<String> coreOwnedPaths,
            final Map<String, String> allPluginOwnedFiles,
            final Map<Plugin, String> externalRegistrations,
            final PackageBuild packageBuild,
            final List<String> errors,
            final PluginRegistry registry) {
        super(
                pluginId,
                Objects.requireNonNull(packageModel, "packageModel").getName(),
                resource,
                ros2Distro,
                outputRoot,
                existingFiles,
                coreOwnedPaths,
                allPluginOwnedFiles,
                errors,
                registry);
        this.packageModel = packageModel;
        this.packageBuild = Objects.requireNonNull(packageBuild, "packageBuild");
        this.externalRegistrations = externalRegistrations != null
                ? externalRegistrations
                : new LinkedHashMap<>();
    }

    public ros.Package packageModel() {
        return packageModel;
    }

    public PackageBuild packageBuild() {
        return packageBuild;
    }

    /**
     * Claims responsibility for supplying registration code for a {@code loader: external}
     * {@link Plugin}. Raises a conflict error naming both plugins if already claimed by another
     * plugin.
     */
    public void claimExternalPluginRegistration(final Plugin plugin) {
        if (plugin == null) {
            return;
        }
        String previousOwner = externalRegistrations.get(plugin);
        if (previousOwner != null && !previousOwner.equals(pluginId())) {
            recordError("Plugin conflict between '" + previousOwner + "' and '" + pluginId()
                    + "' on external registration for plugin '" + plugin.getName() + "'");
            return;
        }
        externalRegistrations.put(plugin, pluginId());
    }
}
