package de.fraunhofer.ipa.ros.scoping;

import de.fraunhofer.ipa.ros.plugin.spi.PluginRegistry;
import de.fraunhofer.ipa.ros.plugin.spi.RosToolingPlugin;
import de.fraunhofer.ipa.ros.plugin.spi.ScopeContribution;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.SimpleScope;
import ros.ExtensionRefValue;
import ros.InterfaceHolder;
import ros.Plugin;

/**
 * Shared scoping helpers for {@link ExtensionRefValue#getTarget()} across {@code .ros},
 * {@code .ros1}, {@code .ros2}, and {@code .rossystem} models, plus plugin scope contributions.
 */
public final class ExtensionScopingHelper {

    private ExtensionScopingHelper() {
    }

    public static IScope scopeForExtensionRef(
            final EObject context,
            final EReference reference,
            final Collection<? extends InterfaceHolder> extraHolders) {
        ExtensionRefValue refVal = (context instanceof ExtensionRefValue r)
                ? r
                : EcoreUtil2.getContainerOfType(context, ExtensionRefValue.class);
        String refKind = refVal != null ? refVal.getRefKind() : null;

        List<EObject> candidates = new ArrayList<>();
        Set<EObject> seen = new LinkedHashSet<>();

        InterfaceHolder directHolder = EcoreUtil2.getContainerOfType(context, InterfaceHolder.class);
        if (directHolder != null) {
            collectHolderCandidates(directHolder, refKind, candidates, seen);
        }
        if (extraHolders != null) {
            for (InterfaceHolder h : extraHolders) {
                if (h != null && !h.eIsProxy()) {
                    collectHolderCandidates(h, refKind, candidates, seen);
                }
            }
        }

        List<IEObjectDescription> descriptions = new ArrayList<>();
        Set<QualifiedName> addedNames = new LinkedHashSet<>();
        for (EObject cand : candidates) {
            String name = readName(cand);
            if (name != null && !name.isBlank()) {
                QualifiedName shortQn = QualifiedName.create(name);
                if (addedNames.add(shortQn)) {
                    descriptions.add(EObjectDescription.create(shortQn, cand));
                }
                if (cand.eContainer() instanceof InterfaceHolder parentHolder) {
                    String parentName = parentHolder.getName();
                    if (parentName != null && !parentName.isBlank()) {
                        QualifiedName qualifiedQn = QualifiedName.create(parentName + "::" + name);
                        if (addedNames.add(qualifiedQn)) {
                            descriptions.add(EObjectDescription.create(qualifiedQn, cand));
                        }
                    }
                }
            }
        }

        List<ScopeContribution> pluginContributions = new ArrayList<>();
        for (RosToolingPlugin plugin : PluginRegistry.INSTANCE.activePlugins()) {
            plugin.contributeScope(context, reference, pluginContributions);
        }
        for (ScopeContribution contrib : pluginContributions) {
            if (contrib != null && contrib.name() != null && !contrib.name().isBlank() && contrib.target() != null) {
                QualifiedName qn = QualifiedName.create(contrib.name());
                if (addedNames.add(qn)) {
                    descriptions.add(EObjectDescription.create(qn, contrib.target()));
                }
            }
        }

        return new SimpleScope(descriptions);
    }

    public static void collectHolderCandidates(
            final InterfaceHolder holder,
            final String refKind,
            final List<EObject> out,
            final Set<EObject> seen) {
        if (holder == null || holder.eIsProxy()) {
            return;
        }
        if (refKind == null || "pub->".equals(refKind)) {
            addAllUnique(holder.getPublisher(), out, seen);
        }
        if (refKind == null || "sub->".equals(refKind)) {
            addAllUnique(holder.getSubscriber(), out, seen);
        }
        if (refKind == null || "ss->".equals(refKind)) {
            addAllUnique(holder.getServiceserver(), out, seen);
        }
        if (refKind == null || "sc->".equals(refKind)) {
            addAllUnique(holder.getServiceclient(), out, seen);
        }
        if (refKind == null || "as->".equals(refKind)) {
            addAllUnique(holder.getActionserver(), out, seen);
        }
        if (refKind == null || "ac->".equals(refKind)) {
            addAllUnique(holder.getActionclient(), out, seen);
        }
        if (refKind == null || "param->".equals(refKind)) {
            addAllUnique(holder.getParameter(), out, seen);
        }
    }

    private static void addAllUnique(
            final Collection<? extends EObject> items,
            final List<EObject> out,
            final Set<EObject> seen) {
        if (items == null) {
            return;
        }
        for (EObject item : items) {
            addIfNew(item, out, seen);
        }
    }

    private static void addIfNew(final EObject item, final List<EObject> out, final Set<EObject> seen) {
        if (item != null && seen.add(item)) {
            out.add(item);
        }
    }

    private static String readName(final EObject obj) {
        EStructuralFeature f = obj.eClass().getEStructuralFeature("name");
        if (f != null) {
            Object val = obj.eGet(f);
            return val != null ? String.valueOf(val) : null;
        }
        return null;
    }
}
