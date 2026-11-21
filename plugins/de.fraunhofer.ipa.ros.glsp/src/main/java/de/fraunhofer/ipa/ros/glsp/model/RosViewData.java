package de.fraunhofer.ipa.ros.glsp.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

import org.eclipse.emf.ecore.EObject;

import com.google.gson.Gson;

import de.fraunhofer.ipa.ros.plugin.model.PluginBases;
import de.fraunhofer.ipa.ros.plugin.spi.ExtensionSchemaMapper;
import de.fraunhofer.ipa.ros.plugin.spi.PluginRegistry;
import de.fraunhofer.ipa.ros.plugin.spi.RosToolingPlugin;
import ros.Artifact;
import ros.Extensible;
import ros.ExtensionBlock;
import ros.Node;
import ros.Package;
import ros.Plugin;
import ros.PluginBase;
import ros.PluginSlot;
import system.RosNode;
import system.SlotAttachment;

/**
 * The view data the GLSP server sends to its clients: one JSON object per element, in the GModel
 * argument {@link #ARG}, with a {@code version} field. It carries the plugin side of the model
 * (bases, slots, attached plugins, {@code @} blocks with their schema) and the GUI contributions
 * core derives for an element.
 *
 * <p>A contribution is {@code {kind, plugin, data}}. Core fills them in from the plugin registry;
 * plugins cannot set them. The only kind is {@code badge}: every element that holds a block of a
 * plugin, or whose base uses a loader a plugin registered, gets a badge naming that plugin.
 * Clients pick a renderer by {@code kind} and skip kinds they do not know.
 *
 * <p>Version 1 shapes (every object also has {@code version}, {@code kind}, {@code blocks} and
 * {@code contributions}):
 * <ul>
 * <li>{@code system}, {@code packageSet} (the root): {@code availableBlocks}, {@code loaders
 * [{id, plugin, summary}]} (the loaders plugins registered; {@code pluginlib} is core's)</li>
 * <li>{@code package}: {@code pluginBases [{id, name, ref, class, header, loader, contributions}]}</li>
 * <li>{@code node}: {@code artifact {id, name}}, {@code pluginSlots [{id, name, base, parameter, format,
 * multiple, default}]}</li>
 * <li>{@code plugin}: {@code artifact {id, name}}, {@code implements}, {@code loader}</li>
 * <li>{@code rosNode}: {@code slots [{slot, base, multiple, plugins}]}</li>
 * </ul>
 */
public final class RosViewData {

    /** Version of the view-data format. Raise it when a field changes meaning or is removed. */
    public static final int VERSION = 1;

    /** GModel argument holding the JSON view data of an element. */
    public static final String ARG = "viewData";

    /** The one contribution kind core produces. */
    public static final String BADGE = "badge";

    private static final Gson GSON = new Gson();

    private final Function<EObject, String> ids;

    public RosViewData(final Function<EObject, String> ids) {
        this.ids = ids;
    }

    public String root(final String kind, final Extensible holder) {
        Map<String, Object> out = base(kind, holder);
        out.put("availableBlocks", availableBlocks());
        out.put("loaders", loaders());
        return GSON.toJson(out);
    }

    public String forPackage(final Package pkg) {
        Map<String, Object> out = base("package", null);
        List<Map<String, Object>> bases = new ArrayList<>();
        for (PluginBase b : pkg.getPluginBases()) {
            Map<String, Object> item = new LinkedHashMap<>();
            item.put("id", ids.apply(b));
            item.put("name", nullToEmpty(b.getName()));
            item.put("ref", nullToEmpty(PluginBases.qualifiedName(b)));
            item.put("class", nullToEmpty(b.getClassName()));
            item.put("header", nullToEmpty(b.getHeader()));
            item.put("loader", nullToEmpty(b.getLoader()));
            item.put("contributions", badges(owners(null, b.getLoader())));
            bases.add(item);
        }
        out.put("pluginBases", bases);
        return GSON.toJson(out);
    }

    public String forNode(final Artifact artifact, final Node node) {
        Map<String, Object> out = base("node", node);
        out.put("artifact", artifactRef(artifact));
        List<Map<String, Object>> slots = new ArrayList<>();
        for (PluginSlot slot : node.getPluginSlots()) {
            Map<String, Object> item = new LinkedHashMap<>();
            item.put("id", ids.apply(slot));
            item.put("name", nullToEmpty(slot.getName()));
            item.put("base", RosDslText.refText(null, slot, ros.RosPackage.Literals.PLUGIN_SLOT__BASE));
            item.put("parameter", nullToEmpty(slot.getParameter()));
            item.put("format", slot.getValueFormat() != null ? slot.getValueFormat().getLiteral() : "class");
            item.put("multiple", slot.isMultiple());
            item.put("default", slot.getDefaultPlugin() == null ? ""
                    : RosDslText.refText(null, slot, ros.RosPackage.Literals.PLUGIN_SLOT__DEFAULT_PLUGIN));
            slots.add(item);
        }
        out.put("pluginSlots", slots);
        return GSON.toJson(out);
    }

    public String forPlugin(final Artifact artifact, final Plugin plugin) {
        String loader = PluginBases.loaderOf(plugin);
        Map<String, Object> out = base("plugin", plugin, loader);
        out.put("artifact", artifactRef(artifact));
        out.put("implements", RosDslText.refText(null, plugin, ros.RosPackage.Literals.PLUGIN__IMPLEMENTS));
        out.put("loader", nullToEmpty(loader));
        return GSON.toJson(out);
    }

    /** A system node: every slot of its host with the plugins attached to it in this system. */
    public String forRosNode(final RosNode rosNode, final Node host) {
        Map<String, Object> out = base("rosNode", rosNode);
        List<Map<String, Object>> slots = new ArrayList<>();
        if (host != null) {
            for (PluginSlot slot : host.getPluginSlots()) {
                List<String> refs = new ArrayList<>();
                for (SlotAttachment attachment : rosNode.getSlots()) {
                    if (attachment.getSlot() == slot) {
                        for (Plugin pl : attachment.getPlugins()) {
                            refs.add(nullToEmpty(PluginBases.qualifiedName(pl)));
                        }
                    }
                }
                Map<String, Object> item = new LinkedHashMap<>();
                item.put("slot", nullToEmpty(slot.getName()));
                item.put("base", slot.getBase() == null ? "" : nullToEmpty(PluginBases.qualifiedName(slot.getBase())));
                item.put("multiple", slot.isMultiple());
                item.put("plugins", refs);
                slots.add(item);
            }
        }
        out.put("slots", slots);
        return GSON.toJson(out);
    }

    private Map<String, Object> base(final String kind, final Extensible holder) {
        return base(kind, holder, null);
    }

    private Map<String, Object> base(final String kind, final Extensible holder, final String loader) {
        Map<String, Object> out = new LinkedHashMap<>();
        out.put("version", VERSION);
        out.put("kind", kind);
        out.put("blocks", blocks(holder));
        out.put("contributions", badges(owners(holder, loader)));
        return out;
    }

    private Map<String, Object> artifactRef(final Artifact artifact) {
        Map<String, Object> ref = new LinkedHashMap<>();
        ref.put("id", artifact == null ? "" : ids.apply(artifact));
        ref.put("name", artifact == null ? "" : nullToEmpty(artifact.getName()));
        return ref;
    }

    private static List<Map<String, Object>> blocks(final Extensible holder) {
        List<Map<String, Object>> out = new ArrayList<>();
        if (holder == null) {
            return out;
        }
        for (ExtensionBlock block : holder.getExtensions()) {
            PluginRegistry.RegisteredBlock rb = PluginRegistry.INSTANCE.resolveBlock(block.getName());
            Map<String, Object> item = new LinkedHashMap<>();
            item.put("name", nullToEmpty(block.getName()));
            item.put("plugin", rb == null ? "" : rb.plugin().id());
            item.put("entries", ExtensionSchemaMapper.blockToMap(block));
            if (rb != null) {
                item.put("schema", ExtensionSchemaMapper.schemaToJsonMap(rb.descriptor()));
            }
            out.add(item);
        }
        return out;
    }

    /** The plugins that added something to an element: its blocks' owners and its loader's owner. */
    private static Set<RosToolingPlugin> owners(final Extensible holder, final String loader) {
        Set<RosToolingPlugin> out = new LinkedHashSet<>();
        if (holder != null) {
            for (ExtensionBlock block : holder.getExtensions()) {
                PluginRegistry.RegisteredBlock rb = PluginRegistry.INSTANCE.resolveBlock(block.getName());
                if (rb != null) {
                    out.add(rb.plugin());
                }
            }
        }
        if (loader != null && !loader.isBlank()) {
            RosToolingPlugin owner = PluginRegistry.INSTANCE.loaderOwner(loader.trim());
            if (owner != null) {
                out.add(owner);
            }
        }
        return out;
    }

    private static List<Map<String, Object>> badges(final Set<RosToolingPlugin> plugins) {
        List<Map<String, Object>> out = new ArrayList<>();
        for (RosToolingPlugin p : plugins) {
            Map<String, Object> data = new LinkedHashMap<>();
            data.put("label", shortName(p.id()));
            data.put("title", p.id() + (p.version() == null || p.version().isBlank() ? "" : " " + p.version()));
            Map<String, Object> c = new LinkedHashMap<>();
            c.put("kind", BADGE);
            c.put("plugin", p.id());
            c.put("data", data);
            out.add(c);
        }
        return out;
    }

    /** Blocks the active plugins offer, so a client can add one: {@code [{name, plugin, ...schema}]}. */
    private static List<Map<String, Object>> availableBlocks() {
        List<Map<String, Object>> out = new ArrayList<>();
        for (RosToolingPlugin p : PluginRegistry.INSTANCE.activePlugins()) {
            for (var desc : p.blocks()) {
                Map<String, Object> item = new LinkedHashMap<>(ExtensionSchemaMapper.schemaToJsonMap(desc));
                item.put("plugin", p.id());
                out.add(item);
            }
        }
        return out;
    }

    /** Loaders registered by exactly one active plugin (a duplicate has no owner and is not offered). */
    private static List<Map<String, Object>> loaders() {
        List<Map<String, Object>> out = new ArrayList<>();
        for (var entry : PluginRegistry.INSTANCE.activeLoaders().entrySet()) {
            if (entry.getValue().size() != 1) {
                continue;
            }
            PluginRegistry.RegisteredLoader reg = entry.getValue().get(0);
            Map<String, Object> item = new LinkedHashMap<>();
            item.put("id", entry.getKey());
            item.put("plugin", reg.plugin().id());
            item.put("summary", reg.descriptor().summary() == null ? "" : reg.descriptor().summary());
            out.add(item);
        }
        return out;
    }

    /** {@code de.example.meta} becomes {@code meta}. */
    static String shortName(final String id) {
        if (id == null) {
            return "";
        }
        int dot = id.lastIndexOf('.');
        return dot >= 0 && dot < id.length() - 1 ? id.substring(dot + 1) : id;
    }

    private static String nullToEmpty(final String s) {
        return s == null ? "" : s;
    }
}
