package de.fraunhofer.ipa.ros.plugin.spi;

import java.util.Objects;

/**
 * A plugin loader registered by a {@link RosToolingPlugin}. A plugin base names its loader with
 * {@code loader: <id>}; core builds the library of every plugin of such a base and hands those
 * plugins to the registering plugin through {@link PackageGenerationContext#loaderPlugins()}, which
 * generates their loading or registration code. {@value de.fraunhofer.ipa.ros.plugin.model.PluginBases#PLUGINLIB}
 * is built into core and cannot be registered.
 */
public final class LoaderDescriptor {

    private final String id;
    private final String summary;

    public LoaderDescriptor(final String id, final String summary) {
        this.id = Objects.requireNonNull(id, "id").trim();
        if (this.id.isEmpty()) {
            throw new IllegalArgumentException("Loader id must not be empty");
        }
        this.summary = summary == null ? "" : summary.trim();
    }

    /** The id a plugin base names in {@code loader:}, for example {@code gz}. */
    public String id() {
        return id;
    }

    /** One line saying what the loader loads, shown in hover and plugin listings. */
    public String summary() {
        return summary;
    }
}
