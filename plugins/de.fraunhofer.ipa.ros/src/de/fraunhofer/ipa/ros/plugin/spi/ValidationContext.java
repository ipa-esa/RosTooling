package de.fraunhofer.ipa.ros.plugin.spi;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import ros.ExtensionBlock;

/**
 * Validation context passed to {@link RosToolingPlugin#validate(ValidationContext)}.
 */
public final class ValidationContext {

    private final EObject target;
    private final ExtensionBlock block;
    private final EObject typedBlock;
    private final HookLocation location;
    private final Resource resource;
    private final Path workspaceDir;
    private final List<ValidationIssue> issues = new ArrayList<>();

    public ValidationContext(
            final EObject target,
            final ExtensionBlock block,
            final EObject typedBlock,
            final HookLocation location,
            final Resource resource,
            final Path workspaceDir) {
        this.target = target;
        this.block = block;
        this.typedBlock = typedBlock;
        this.location = location;
        this.resource = resource;
        this.workspaceDir = workspaceDir;
    }

    public EObject target() {
        return target;
    }

    public ExtensionBlock block() {
        return block;
    }

    public EObject typedBlock() {
        return typedBlock;
    }

    public HookLocation location() {
        return location;
    }

    public Resource resource() {
        return resource;
    }

    public ResourceSet resourceSet() {
        return resource != null ? resource.getResourceSet() : null;
    }

    public Path workspaceDir() {
        return workspaceDir;
    }

    public void error(final String message) {
        error(message, block, null, null);
    }

    public void error(final String message, final EObject source, final EStructuralFeature feature) {
        error(message, source, feature, null);
    }

    public void error(final String message, final EObject source, final EStructuralFeature feature, final String code) {
        issues.add(new ValidationIssue(ValidationIssue.Severity.ERROR, message, source != null ? source : block, feature, code));
    }

    public void warning(final String message) {
        warning(message, block, null, null);
    }

    public void warning(final String message, final EObject source, final EStructuralFeature feature) {
        warning(message, source, feature, null);
    }

    public void warning(final String message, final EObject source, final EStructuralFeature feature, final String code) {
        issues.add(new ValidationIssue(ValidationIssue.Severity.WARNING, message, source != null ? source : block, feature, code));
    }

    public void info(final String message) {
        info(message, block, null, null);
    }

    public void info(final String message, final EObject source, final EStructuralFeature feature, final String code) {
        issues.add(new ValidationIssue(ValidationIssue.Severity.INFO, message, source != null ? source : block, feature, code));
    }

    public List<ValidationIssue> issues() {
        return Collections.unmodifiableList(issues);
    }
}
