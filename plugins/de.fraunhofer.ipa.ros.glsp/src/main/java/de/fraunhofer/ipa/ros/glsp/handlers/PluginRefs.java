package de.fraunhofer.ipa.ros.glsp.handlers;

import java.util.Collections;
import java.util.Iterator;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

import de.fraunhofer.ipa.ros.plugin.model.PluginBases;
import ros.Plugin;
import ros.PluginBase;
import ros.RosFactory;

/**
 * Resolves plugin base and plugin references written as text ({@code package.Name}) by edit
 * requests. A target that is not loaded becomes an uncontained placeholder named after the text,
 * so the text serializer writes the reference as given and the next parse links it.
 */
final class PluginRefs {

    private PluginRefs() {
    }

    static PluginBase base(final EObject context, final String text) {
        String name = clean(text);
        if (name == null) {
            return null;
        }
        for (Iterator<Notifier> it = contents(context); it.hasNext();) {
            if (it.next() instanceof PluginBase base && matches(name, PluginBases.qualifiedName(base), base.getName())) {
                return base;
            }
        }
        PluginBase placeholder = RosFactory.eINSTANCE.createPluginBase();
        placeholder.setName(name);
        return placeholder;
    }

    static Plugin plugin(final EObject context, final String text) {
        String name = clean(text);
        if (name == null) {
            return null;
        }
        for (Iterator<Notifier> it = contents(context); it.hasNext();) {
            if (it.next() instanceof Plugin plugin && matches(name, PluginBases.qualifiedName(plugin), plugin.getName())) {
                return plugin;
            }
        }
        Plugin placeholder = RosFactory.eINSTANCE.createPlugin();
        placeholder.setName(name);
        return placeholder;
    }

    private static boolean matches(final String name, final String qualified, final String simple) {
        return name.equals(qualified) || (!name.contains(".") && name.equals(simple));
    }

    @SuppressWarnings("unchecked")
    private static Iterator<Notifier> contents(final EObject context) {
        Resource resource = context != null ? context.eResource() : null;
        if (resource == null) {
            return Collections.emptyIterator();
        }
        ResourceSet rs = resource.getResourceSet();
        return rs != null ? rs.getAllContents() : (Iterator<Notifier>) (Iterator<?>) resource.getAllContents();
    }

    private static String clean(final String text) {
        if (text == null) {
            return null;
        }
        String t = text.trim();
        if (t.length() >= 2 && t.startsWith("\"") && t.endsWith("\"")) {
            t = t.substring(1, t.length() - 1).trim();
        }
        return t.isEmpty() ? null : t;
    }
}
