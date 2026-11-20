package de.fraunhofer.ipa.ros.plugin.spi;

import de.fraunhofer.ipa.ros.plugin.model.PluginBases;
import de.fraunhofer.ipa.ros2.distro.Ros2Distro;
import java.nio.file.Path;
import java.util.ArrayList;
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

    public PackageGenerationContext(
            final String pluginId,
            final ros.Package packageModel,
            final Resource resource,
            final Ros2Distro ros2Distro,
            final List<String> existingFiles,
            final Set<String> coreOwnedPaths,
            final Map<String, String> allPluginOwnedFiles,
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
    }

    public ros.Package packageModel() {
        return packageModel;
    }

    public PackageBuild packageBuild() {
        return packageBuild;
    }

    /**
     * The plugins of this package whose base names a loader registered by this plugin through
     * {@link RosToolingPlugin#loaders()}. Core builds their library; this plugin generates their
     * loading or registration code.
     */
    public List<Plugin> loaderPlugins() {
        List<Plugin> out = new ArrayList<>();
        if (registry == null) {
            return out;
        }
        for (ros.Artifact artifact : packageModel.getArtifact()) {
            for (Plugin plugin : artifact.getPlugins()) {
                String loader = PluginBases.loaderOf(plugin);
                RosToolingPlugin owner = loader == null ? null : registry.loaderOwner(loader);
                if (owner != null && owner.id().equals(pluginId())) {
                    out.add(plugin);
                }
            }
        }
        return out;
    }
}
