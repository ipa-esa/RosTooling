package de.fraunhofer.ipa.ros.plugin.spi;

import java.util.Objects;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * Validation diagnostic reported by core schema checks or a {@link RosToolingPlugin}.
 */
public final class ValidationIssue {

    public enum Severity {
        ERROR,
        WARNING,
        INFO
    }

    private final Severity severity;
    private final String message;
    private final EObject source;
    private final EStructuralFeature feature;
    private final String code;

    public ValidationIssue(
            final Severity severity,
            final String message,
            final EObject source,
            final EStructuralFeature feature,
            final String code) {
        this.severity = Objects.requireNonNull(severity, "severity");
        this.message = Objects.requireNonNull(message, "message");
        this.source = source;
        this.feature = feature;
        this.code = code;
    }

    public Severity severity() {
        return severity;
    }

    public String message() {
        return message;
    }

    public EObject source() {
        return source;
    }

    public EStructuralFeature feature() {
        return feature;
    }

    public String code() {
        return code;
    }
}
