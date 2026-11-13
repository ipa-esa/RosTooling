package de.fraunhofer.ipa.ros.glsp.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.glsp.graph.GPoint;
import org.eclipse.glsp.server.emf.EMFModelStateImpl;
import org.eclipse.xtext.resource.XtextResource;
import ros.PackageSet;

/**
 * Extended EMFModelState for RosTooling models (.rossystem, .ros2, .ros1, .ros).
 * Holds the primary semantic model EObject, its XtextResource, and optional pinned positions.
 */
public class RosModelState extends EMFModelStateImpl {

    private URI sourceUri;
    private Resource semanticResource;
    private EObject semanticModel;
    private final Map<String, GPoint> pinnedPositions = new HashMap<>();
    private final Set<String> collapsedSubSystems = new HashSet<>();

    /**
     * DSL reference text for elements created or retargeted in memory (e.g. a Publisher's
     * {@code type:} spec or a message field's custom type) whose cross-reference cannot be
     * resolved yet. Consumed by {@link RosAstNodeModelSerializer}; cleared after every save.
     */
    private final Map<EObject, String> refTextHints = new IdentityHashMap<>();

    /**
     * Structural features of existing (already parsed) elements that were edited in memory and
     * must be re-emitted by the serializer (QoS blocks, active_in lists, parameter types, ...).
     * Cleared after every save.
     */
    private final Map<EObject, Set<String>> dirtyFeatures = new IdentityHashMap<>();

    public void setRefTextHint(final EObject holder, final String text) {
        if (holder == null) {
            return;
        }
        if (text == null) {
            refTextHints.remove(holder);
        } else {
            refTextHints.put(holder, text);
        }
    }

    public String getRefTextHint(final EObject holder) {
        return holder == null ? null : refTextHints.get(holder);
    }

    public void markDirty(final EObject element, final String featureKey) {
        if (element != null && featureKey != null) {
            dirtyFeatures.computeIfAbsent(element, k -> new HashSet<>()).add(featureKey);
        }
    }

    public void clearDirty(final EObject element, final String featureKey) {
        Set<String> keys = element == null ? null : dirtyFeatures.get(element);
        if (keys != null) {
            keys.remove(featureKey);
        }
    }

    public boolean isDirty(final EObject element, final String featureKey) {
        Set<String> keys = element == null ? null : dirtyFeatures.get(element);
        return keys != null && keys.contains(featureKey);
    }

    /** Drops all transient text-edit bookkeeping (called once the source text has been rewritten). */
    public void clearTextEditState() {
        refTextHints.clear();
        dirtyFeatures.clear();
    }

    public URI getSourceUri() {
        return sourceUri;
    }

    public void setSourceUri(final URI sourceUri) {
        this.sourceUri = sourceUri;
    }

    public Resource getSemanticResource() {
        return semanticResource;
    }

    public void setSemanticResource(final Resource semanticResource) {
        this.semanticResource = semanticResource;
    }

    public Optional<XtextResource> getXtextResource() {
        if (semanticResource instanceof XtextResource xtextRes) {
            return Optional.of(xtextRes);
        }
        return Optional.empty();
    }

    public EObject getSemanticModel() {
        return semanticModel;
    }

    public void setSemanticModel(final EObject semanticModel) {
        this.semanticModel = semanticModel;
    }

    public Optional<system.System> getRosSystem() {
        if (semanticModel instanceof system.System sys) {
            return Optional.of(sys);
        }
        return Optional.empty();
    }

    /**
     * True for .ros (root {@code PackageSet}) and .ros2/.ros1 (root {@code AmentPackage} /
     * {@code Package}) models, i.e. everything edited through the React forms.
     */
    public boolean isPackageModel() {
        return semanticModel instanceof PackageSet || semanticModel instanceof ros.Package;
    }

    /** The packages of a package model: all packages of a PackageSet, or the single root package. */
    public java.util.List<ros.Package> getPackageModelPackages() {
        if (semanticModel instanceof PackageSet pkgSet) {
            return pkgSet.getPackage();
        }
        if (semanticModel instanceof ros.Package pkg) {
            return java.util.List.of(pkg);
        }
        return java.util.List.of();
    }

    public Optional<PackageSet> getPackageSet() {
        if (semanticModel instanceof PackageSet pkgSet) {
            return Optional.of(pkgSet);
        }
        return Optional.empty();
    }

    public Map<String, GPoint> getPinnedPositions() {
        return Collections.unmodifiableMap(pinnedPositions);
    }

    public void setPinnedPosition(final String elementId, final GPoint position) {
        if (elementId != null && position != null) {
            pinnedPositions.put(elementId, position);
        }
    }

    public void clearPinnedPositions() {
        pinnedPositions.clear();
    }

    public boolean isSubSystemCollapsed(final String subSystemId) {
        return collapsedSubSystems.contains(subSystemId);
    }

    public void setSubSystemCollapsed(final String subSystemId, final boolean collapsed) {
        if (collapsed) {
            collapsedSubSystems.add(subSystemId);
        } else {
            collapsedSubSystems.remove(subSystemId);
        }
    }

    public void toggleSubSystemCollapsed(final String subSystemId) {
        if (collapsedSubSystems.contains(subSystemId)) {
            collapsedSubSystems.remove(subSystemId);
        } else {
            collapsedSubSystems.add(subSystemId);
        }
    }
}
