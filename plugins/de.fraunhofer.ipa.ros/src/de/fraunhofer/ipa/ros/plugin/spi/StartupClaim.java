package de.fraunhofer.ipa.ros.plugin.spi;

import java.util.Objects;

/**
 * Declaration by a plugin that it starts one element of the system being generated itself: a node
 * instance ({@code nodes:}) or a subsystem ({@code subSystems:}), named by {@link #element()}.
 * Returned from {@link RosToolingPlugin#startupClaims(SystemGenerationContext)}.
 *
 * <p>Core keeps the element in the generated system launch file, but behind a switch: it declares
 * the launch argument {@link #argumentName(String)} with {@link #defaultClaimed()} as its default
 * and attaches {@code UnlessCondition(LaunchConfiguration('<argument>'))} to the element's native
 * start. With the argument {@code true} core does not start the element, the claiming plugin does;
 * with {@code false} core starts it natively. The argument counts as a declared system launch
 * argument for the claiming plugin (see {@link SystemGenerationContext#startupClaimArgument(String)}),
 * so the plugin can forward it to its own launch include with
 * {@link SystemGenerationContext.LaunchArgumentValue#systemLaunchArgument(String)}. The generated
 * system README lists every claimed element.
 *
 * <p>When core includes a claimed subsystem natively ({@code <argument>:=false}), it also turns
 * off the startup claims inside that subsystem: it passes {@code 'false'} for each launch argument
 * the subsystem's own launch file declares for its claims. To find them core calls
 * {@link RosToolingPlugin#startupClaims(SystemGenerationContext)} of every enabled plugin with a
 * context for the subsystem's system, so switching a subsystem to native starts its claimed parts
 * natively too.
 *
 * <p>Generation fails if the element is unknown, is a node inside a {@code processes:} entry (not
 * supported), is claimed twice by the same plugin, or is claimed by two plugins.
 *
 * @param element name of a node instance or subsystem of the system
 * @param defaultClaimed default of the launch argument: {@code true} means the plugin starts the
 *     element unless the user passes {@code <argument>:=false}
 */
public record StartupClaim(String element, boolean defaultClaimed) {

    public StartupClaim {
        Objects.requireNonNull(element, "element");
    }

    /**
     * Name of the launch argument core declares for this claim: {@code <element>_in_<label>}, where
     * {@code <label>} is the last dot-separated segment of {@code pluginId}, with every character
     * outside {@code [A-Za-z0-9_]} replaced by {@code _} (and a leading {@code _} if it would
     * start with a digit). Plugin id {@code de.example.runner} and element {@code camera} give
     * {@code camera_in_runner}.
     */
    public String argumentName(final String pluginId) {
        Objects.requireNonNull(pluginId, "pluginId");
        String label = pluginId.substring(pluginId.lastIndexOf('.') + 1).replaceAll("[^A-Za-z0-9_]", "_");
        if (label.isEmpty() || Character.isDigit(label.charAt(0))) {
            label = "_" + label;
        }
        return element + "_in_" + label;
    }
}
