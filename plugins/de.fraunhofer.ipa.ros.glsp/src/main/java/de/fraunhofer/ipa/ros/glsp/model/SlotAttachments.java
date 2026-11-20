package de.fraunhofer.ipa.ros.glsp.model;

import java.util.List;

import de.fraunhofer.ipa.rossystem.scoping.RosSystemScopeProvider;
import ros.Node;
import ros.Plugin;
import ros.PluginSlot;
import system.RosNode;
import system.RossystemFactory;
import system.SlotAttachment;

/**
 * Plugin attachments of a system node. Edit requests that pass a flat plugin list are mapped
 * onto slots: each plugin goes to the first slot of the host node whose base it implements.
 */
public final class SlotAttachments {

    private SlotAttachments() {
    }

    /** All plugins attached to {@code rosNode}, in model order. */
    public static List<Plugin> plugins(final RosNode rosNode) {
        return RosSystemScopeProvider.attachedPlugins(rosNode);
    }

    /**
     * Attaches {@code plugin} to the slot of the host node whose base it implements.
     *
     * @return false if the plugin is already attached or no slot takes its base
     */
    public static boolean attach(final RosNode rosNode, final Plugin plugin) {
        if (rosNode == null || plugin == null || plugins(rosNode).contains(plugin)) {
            return false;
        }
        Node host = rosNode.getFrom();
        if (host == null || host.eIsProxy() || plugin.getImplements() == null) {
            return false;
        }
        PluginSlot slot = host.getPluginSlots().stream()
                .filter(s -> s.getBase() == plugin.getImplements())
                .findFirst()
                .orElse(null);
        if (slot == null) {
            return false;
        }
        SlotAttachment attachment = rosNode.getSlots().stream()
                .filter(a -> a.getSlot() == slot)
                .findFirst()
                .orElse(null);
        if (attachment == null) {
            attachment = RossystemFactory.eINSTANCE.createSlotAttachment();
            attachment.setSlot(slot);
            rosNode.getSlots().add(attachment);
        }
        attachment.getPlugins().add(plugin);
        return true;
    }

    /**
     * Sets the plugins attached to the host slot named {@code slotName} to exactly {@code plugins},
     * in order. An empty list removes the attachment. Plugins of the wrong base are kept, so that
     * validation reports them.
     *
     * @return false if the host node has no slot of that name
     */
    public static boolean set(final RosNode rosNode, final String slotName, final List<Plugin> plugins) {
        Node host = rosNode == null ? null : rosNode.getFrom();
        if (host == null || host.eIsProxy() || slotName == null) {
            return false;
        }
        PluginSlot slot = host.getPluginSlots().stream()
                .filter(s -> slotName.trim().equals(s.getName()))
                .findFirst()
                .orElse(null);
        if (slot == null) {
            return false;
        }
        SlotAttachment attachment = rosNode.getSlots().stream()
                .filter(a -> a.getSlot() == slot)
                .findFirst()
                .orElse(null);
        if (plugins.isEmpty()) {
            if (attachment != null) {
                rosNode.getSlots().remove(attachment);
            }
            return true;
        }
        if (attachment == null) {
            attachment = RossystemFactory.eINSTANCE.createSlotAttachment();
            attachment.setSlot(slot);
            rosNode.getSlots().add(attachment);
        }
        if (!attachment.getPlugins().equals(plugins)) {
            attachment.getPlugins().clear();
            attachment.getPlugins().addAll(plugins);
        }
        return true;
    }
}
