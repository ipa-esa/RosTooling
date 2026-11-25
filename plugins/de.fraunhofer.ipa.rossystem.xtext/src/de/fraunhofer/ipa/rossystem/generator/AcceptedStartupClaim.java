package de.fraunhofer.ipa.rossystem.generator;

import java.util.List;

/**
 * A plugin's {@code StartupClaim} that core accepted for the system being generated: the element,
 * the plugin that starts it, the launch argument core declares and that argument's default.
 * {@code innerArguments} is only filled for a claimed subsystem: the launch arguments of the
 * startup claims inside that subsystem, which core passes as {@code 'false'} when it includes the
 * subsystem natively.
 */
public record AcceptedStartupClaim(String element, String pluginId, String argument, boolean defaultClaimed,
        List<String> innerArguments) {

    public AcceptedStartupClaim {
        innerArguments = innerArguments == null ? List.of() : List.copyOf(innerArguments);
    }

    public AcceptedStartupClaim(String element, String pluginId, String argument, boolean defaultClaimed) {
        this(element, pluginId, argument, defaultClaimed, List.of());
    }

    public AcceptedStartupClaim withInnerArguments(List<String> arguments) {
        return new AcceptedStartupClaim(element, pluginId, argument, defaultClaimed, arguments);
    }
}
