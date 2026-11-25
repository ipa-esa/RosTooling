package de.fraunhofer.ipa.rossystem.generator;

/**
 * A plugin's {@code StartupClaim} that core accepted for the system being generated: the element,
 * the plugin that starts it, the launch argument core declares and that argument's default.
 */
public record AcceptedStartupClaim(String element, String pluginId, String argument, boolean defaultClaimed) {
}
