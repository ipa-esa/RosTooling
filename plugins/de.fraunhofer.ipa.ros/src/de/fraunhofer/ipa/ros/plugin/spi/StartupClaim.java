package de.fraunhofer.ipa.ros.plugin.spi;

import java.util.Objects;

/**
 * Declaration by a plugin that it starts one element of the system being generated itself: a node
 * instance ({@code nodes:}) or a subsystem ({@code subSystems:}), named by {@link #element()}.
 * Returned from {@link RosToolingPlugin#startupClaims(SystemGenerationContext)}.
 *
 * <p>Core keeps the element in the generated system launch file, but behind a switch: it declares
 * the launch argument {@link #argumentName(String)} and attaches
 * {@code UnlessCondition(LaunchConfiguration('<argument>'))} to the element's native start. With
 * the argument {@code true} core does not start the element, the claiming plugin does; with
 * {@code false} core starts it natively. The argument's default is {@link #defaultClaimed()},
 * except that the generic argument {@value #NATIVE_SWITCH_ARGUMENT} set to {@code true} makes it
 * {@code false}; an explicit {@code <argument>:=...} on the command line always wins. The argument
 * counts as a declared system launch argument for the claiming plugin (see
 * {@link SystemGenerationContext#startupClaimArgument(String)}), so the plugin can forward it to
 * its own launch include with {@link SystemGenerationContext.LaunchArgumentValue#systemLaunchArgument(String)}.
 * The generated system README lists every claimed element.
 *
 * <p>Every system launch file with at least one accepted claim declares
 * {@value #NATIVE_SWITCH_ARGUMENT} (default {@code false}): {@code true} starts every claimed
 * element natively, including those inside subsystems. When core includes a claimed subsystem
 * natively it passes {@code run_claimed_natively:=true} to that include, so the claims inside the
 * subsystem (declared by the subsystem's own launch file from its own model) start natively too;
 * nothing else about the subsystem is copied into the parent. Included launch files inherit the
 * launch configurations of the including one, so this holds at any nesting depth. A subsystem
 * included {@code fromFile} is outside core's control: the switch is still passed, but only launch
 * files that declare it honour it. A system parameter or launch argument named
 * {@value #NATIVE_SWITCH_ARGUMENT} is rejected in a system with claims.
 *
 * <p>Generation fails (the run reports the message as a plugin conflict error and produces no
 * claim output, like any other plugin conflict) if the element is unknown, is a node inside a
 * {@code processes:} entry (not supported), is claimed twice by the same plugin, is claimed by two
 * plugins (this includes two plugin ids whose sanitized last segment is equal), or if the argument
 * name is already declared in the system.
 *
 * @param element name of a node instance or subsystem of the system
 * @param defaultClaimed default of the launch argument: {@code true} means the plugin starts the
 *     element unless the user passes {@code <argument>:=false}
 */
public record StartupClaim(String element, boolean defaultClaimed) {

    /**
     * Name of the generic launch argument core declares in every system launch file that has an
     * accepted claim: {@code true} starts all claimed elements natively, also inside subsystems.
     */
    public static final String NATIVE_SWITCH_ARGUMENT = "run_claimed_natively";

    public StartupClaim {
        Objects.requireNonNull(element, "element");
    }

    /**
     * Name of the launch argument core declares for this claim: {@code <element>_in_<label>}, where
     * {@code <label>} is the last dot-separated segment of {@code pluginId}, with every character
     * outside {@code [A-Za-z0-9_]} replaced by {@code _} (and a leading {@code _} if it would
     * start with a digit). Plugin id {@code de.example.runner} and element {@code camera} give
     * {@code camera_in_runner}. The scheme is stable plugin API; plugins compute the name with
     * this method instead of spelling it out.
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
