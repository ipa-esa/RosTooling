package de.fraunhofer.ipa.ros.plugin.model;

import ros.Plugin;
import ros.PluginBase;
import ros.PluginSlot;
import ros.PluginSlotValueFormat;

/**
 * Facts about a plugin that come from the base it implements. The loader lives on the base:
 * {@code pluginlib} is built into core; any other id is provided by a language plugin, and core
 * then builds the library without generating loader code for it.
 */
public final class PluginBases {

    /** The loader id built into core. */
    public static final String PLUGINLIB = "pluginlib";

    private PluginBases() {
    }

    /** The base {@code plugin} implements, or {@code null} if it is missing or unresolved. */
    public static PluginBase baseOf(Plugin plugin) {
        if (plugin == null) {
            return null;
        }
        PluginBase base = plugin.getImplements();
        return base == null || base.eIsProxy() ? null : base;
    }

    /** The loader id of the base {@code plugin} implements, or {@code null}. */
    public static String loaderOf(Plugin plugin) {
        PluginBase base = baseOf(plugin);
        return base == null ? null : trimToNull(base.getLoader());
    }

    /** Whether core generates pluginlib registration for {@code plugin}. */
    public static boolean isPluginlib(Plugin plugin) {
        return PLUGINLIB.equals(loaderOf(plugin));
    }

    /** Whether plugins of {@code base} are loaded with pluginlib; false if it is missing or unresolved. */
    public static boolean isPluginlib(PluginBase base) {
        return base != null && !base.eIsProxy() && PLUGINLIB.equals(trimToNull(base.getLoader()));
    }

    /** The C++ class of the base {@code plugin} implements, for example {@code nav2_core::GlobalPlanner}, or {@code null}. */
    public static String baseClassOf(Plugin plugin) {
        PluginBase base = baseOf(plugin);
        return base == null ? null : trimToNull(base.getClassName());
    }

    /** The header of the base {@code plugin} implements, for example {@code nav2_core/global_planner.hpp}, or {@code null}. */
    public static String baseHeaderOf(Plugin plugin) {
        PluginBase base = baseOf(plugin);
        return base == null ? null : trimToNull(base.getHeader());
    }

    /** The package that declares the base {@code plugin} implements, or {@code null}. */
    public static String basePackageOf(Plugin plugin) {
        return packageOf(baseOf(plugin));
    }

    /** The package that declares {@code base}, or {@code null}. */
    public static String packageOf(PluginBase base) {
        if (base == null || base.eIsProxy() || !(base.eContainer() instanceof ros.Package)) {
            return null;
        }
        return trimToNull(((ros.Package) base.eContainer()).getName());
    }

    /**
     * The value that names {@code plugin} in the parameter of {@code slot}: the owning artifact
     * (the library) for {@code format: library}, otherwise {@code package::Name}, the class name
     * the generated {@code plugins.xml} registers.
     */
    public static String slotValue(Plugin plugin, PluginSlot slot) {
        if (slot != null && slot.getValueFormat() == PluginSlotValueFormat.LIBRARY) {
            if (plugin.eContainer() instanceof ros.Artifact art && art.getName() != null && !art.getName().isEmpty()) {
                return art.getName();
            }
            return plugin.getName();
        }
        Object artifact = plugin.eContainer();
        Object pkg = artifact instanceof ros.Artifact a ? a.eContainer() : null;
        String pkgName = pkg instanceof ros.Package p && p.getName() != null ? p.getName().toLowerCase() : null;
        return pkgName != null && !pkgName.isEmpty() ? pkgName + "::" + plugin.getName() : plugin.getName();
    }

    /** {@code package.Name} of {@code base}, as references to it are written. */
    public static String qualifiedName(PluginBase base) {
        if (base == null) {
            return null;
        }
        return base.eContainer() instanceof ros.Package pkg ? pkg.getName() + "." + base.getName() : base.getName();
    }

    /** {@code package.Name} of {@code plugin}, as references to it are written. */
    public static String qualifiedName(Plugin plugin) {
        if (plugin == null) {
            return null;
        }
        Object artifact = plugin.eContainer();
        Object pkg = artifact instanceof ros.Artifact a ? a.eContainer() : null;
        return pkg instanceof ros.Package p ? p.getName() + "." + plugin.getName() : plugin.getName();
    }

    private static String trimToNull(String value) {
        if (value == null) {
            return null;
        }
        String trimmed = value.trim();
        return trimmed.isEmpty() ? null : trimmed;
    }
}
