package de.fraunhofer.ipa.ros.plugin.spi;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.stream.Stream;

/**
 * Discovers, validates, topologically orders, and serves active {@link RosToolingPlugin}s.
 *
 * <p>Implements Rule 4: discovery stays passive until a plugin ID is explicitly enabled via
 * configuration or programmatic registration.
 */
public final class PluginRegistry {

    public static final String CORE_VERSION = "3.6.0";
    public static final String PROP_PLUGINS_DIR = "ros.plugins.dir";
    public static final String ENV_PLUGINS_DIR = "ROS_PLUGINS_DIR";
    public static final String PROP_PLUGINS_ENABLED = "ros.plugins.enabled";
    public static final String ENV_PLUGINS_ENABLED = "ROS_PLUGINS_ENABLED";

    public static final PluginRegistry INSTANCE = new PluginRegistry();

    public record RegisteredBlock(RosToolingPlugin plugin, BlockDescriptor descriptor) {
    }

    private final Map<String, RosToolingPlugin> programmaticPlugins = new LinkedHashMap<>();
    private final Map<String, RosToolingPlugin> jarPlugins = new LinkedHashMap<>();
    private final List<URLClassLoader> activeClassLoaders = new ArrayList<>();
    private final List<String> loadErrors = new ArrayList<>();
    private boolean initializedFromEnv = false;

    private List<RosToolingPlugin> orderedPlugins = List.of();
    private Map<String, RegisteredBlock> unqualifiedBlocks = Map.of();
    private Map<String, RegisteredBlock> qualifiedBlocks = Map.of();
    private Set<String> collidingBlockNames = Set.of();

    public PluginRegistry() {
    }

    public synchronized void ensureLoadedFromEnvironment() {
        if (initializedFromEnv) {
            return;
        }
        initializedFromEnv = true;
        List<Path> dirs = parsePaths(firstNonBlank(
                System.getProperty(PROP_PLUGINS_DIR),
                System.getenv(ENV_PLUGINS_DIR)));
        Set<String> enabled = parseIdSet(firstNonBlank(
                System.getProperty(PROP_PLUGINS_ENABLED),
                System.getenv(ENV_PLUGINS_ENABLED)));
        if (!enabled.isEmpty()) {
            loadFromPathsInternal(dirs, enabled);
        }
    }

    public synchronized void loadFromPaths(final List<Path> pluginPaths, final Set<String> enabledIds) {
        initializedFromEnv = true;
        loadFromPathsInternal(pluginPaths, enabledIds);
    }

    private void loadFromPathsInternal(final List<Path> pluginPaths, final Set<String> enabledIds) {
        closeJarClassLoaders();
        jarPlugins.clear();
        loadErrors.clear();

        if (enabledIds == null || enabledIds.isEmpty()) {
            rebuildState();
            return;
        }

        List<URL> jarUrls = new ArrayList<>();
        if (pluginPaths != null) {
            for (Path p : pluginPaths) {
                if (p == null || !Files.exists(p)) {
                    continue;
                }
                if (Files.isRegularFile(p) && p.toString().endsWith(".jar")) {
                    addJarUrl(p, jarUrls);
                } else if (Files.isDirectory(p)) {
                    try (Stream<Path> walk = Files.list(p)) {
                        walk.filter(f -> Files.isRegularFile(f) && f.toString().endsWith(".jar"))
                                .sorted()
                                .forEach(f -> addJarUrl(f, jarUrls));
                    } catch (IOException e) {
                        loadErrors.add("Failed to scan plugin directory '" + p + "': " + e.getMessage());
                    }
                }
            }
        }

        Map<String, RosToolingPlugin> discovered = new LinkedHashMap<>();
        // Also scan current context classloader and OSGi services, activating ONLY enabledIds.
        scanServiceLoader(PluginRegistry.class.getClassLoader(), discovered);
        scanOsgiServices(discovered);

        if (!jarUrls.isEmpty()) {
            URLClassLoader cl = new URLClassLoader(
                    jarUrls.toArray(new URL[0]),
                    PluginRegistry.class.getClassLoader());
            activeClassLoaders.add(cl);
            scanServiceLoader(cl, discovered);
        }

        for (String id : enabledIds) {
            if (programmaticPlugins.containsKey(id)) {
                continue;
            }
            RosToolingPlugin plugin = discovered.get(id);
            if (plugin == null) {
                loadErrors.add("Enabled plugin '" + id + "' was not found in configured plugin paths");
                continue;
            }
            if (!isVersionCompatible(CORE_VERSION, plugin.supportedCoreVersionRange())) {
                loadErrors.add("Plugin '" + id + "' requires core version "
                        + plugin.supportedCoreVersionRange() + " (current core is " + CORE_VERSION + ")");
                continue;
            }
            jarPlugins.put(id, plugin);
        }

        rebuildState();
    }

    private void scanServiceLoader(final ClassLoader cl, final Map<String, RosToolingPlugin> out) {
        try {
            ServiceLoader<RosToolingPlugin> loader = ServiceLoader.load(RosToolingPlugin.class, cl);
            for (RosToolingPlugin plugin : loader) {
                if (plugin != null && plugin.id() != null && !plugin.id().isBlank()) {
                    out.putIfAbsent(plugin.id(), plugin);
                }
            }
        } catch (Throwable t) {
            loadErrors.add("Failed to load RosToolingPlugin providers: " + t.getMessage());
        }
    }

    /**
     * Discovers {@link RosToolingPlugin} instances registered in the OSGi service registry when
     * running inside Eclipse/OSGi, without introducing a hard compile-time dependency on OSGi in
     * standalone/headless deployments.
     */
    private void scanOsgiServices(final Map<String, RosToolingPlugin> out) {
        try {
            Class<?> frameworkUtil = Class.forName("org.osgi.framework.FrameworkUtil");
            Object bundle = frameworkUtil.getMethod("getBundle", Class.class)
                    .invoke(null, PluginRegistry.class);
            if (bundle == null) {
                return;
            }
            Object bundleContext = bundle.getClass().getMethod("getBundleContext").invoke(bundle);
            if (bundleContext == null) {
                return;
            }
            Class<?> serviceRefClass = Class.forName("org.osgi.framework.ServiceReference");
            Object refsObj = bundleContext.getClass()
                    .getMethod("getServiceReferences", Class.class, String.class)
                    .invoke(bundleContext, RosToolingPlugin.class, null);
            if (!(refsObj instanceof Collection<?> refs)) {
                return;
            }
            var getService = bundleContext.getClass().getMethod("getService", serviceRefClass);
            for (Object ref : refs) {
                if (ref == null) {
                    continue;
                }
                Object service = getService.invoke(bundleContext, ref);
                if (service instanceof RosToolingPlugin plugin
                        && plugin.id() != null && !plugin.id().isBlank()) {
                    out.putIfAbsent(plugin.id(), plugin);
                }
            }
        } catch (ClassNotFoundException | NoClassDefFoundError ignored) {
            // Standalone non-OSGi environment: ignore cleanly.
        } catch (Throwable t) {
            loadErrors.add("Failed to query OSGi RosToolingPlugin services: " + t.getMessage());
        }
    }

    private void addJarUrl(final Path jar, final List<URL> jarUrls) {
        try {
            jarUrls.add(jar.toUri().toURL());
        } catch (MalformedURLException e) {
            loadErrors.add("Invalid plugin JAR path '" + jar + "': " + e.getMessage());
        }
    }

    public synchronized void register(final RosToolingPlugin plugin) {
        if (plugin == null || plugin.id() == null || plugin.id().isBlank()) {
            throw new IllegalArgumentException("Plugin and plugin id must not be blank");
        }
        if (!isVersionCompatible(CORE_VERSION, plugin.supportedCoreVersionRange())) {
            throw new IllegalStateException("Plugin '" + plugin.id() + "' requires core version "
                    + plugin.supportedCoreVersionRange() + " (current core is " + CORE_VERSION + ")");
        }
        programmaticPlugins.put(plugin.id(), plugin);
        rebuildState();
    }

    public synchronized void unregister(final String pluginId) {
        programmaticPlugins.remove(pluginId);
        jarPlugins.remove(pluginId);
        rebuildState();
    }

    public synchronized void clearRegistered() {
        programmaticPlugins.clear();
        jarPlugins.clear();
        loadErrors.clear();
        closeJarClassLoaders();
        initializedFromEnv = false;
        rebuildState();
    }

    public synchronized List<RosToolingPlugin> activePlugins() {
        ensureLoadedFromEnvironment();
        return orderedPlugins;
    }

    public synchronized List<String> loadErrors() {
        ensureLoadedFromEnvironment();
        return List.copyOf(loadErrors);
    }

    public synchronized RosToolingPlugin pluginById(final String id) {
        ensureLoadedFromEnvironment();
        for (RosToolingPlugin p : orderedPlugins) {
            if (p.id().equals(id)) {
                return p;
            }
        }
        return null;
    }

    public synchronized RegisteredBlock resolveBlock(final String rawName) {
        ensureLoadedFromEnvironment();
        if (rawName == null || rawName.isBlank()) {
            return null;
        }
        RegisteredBlock qualified = qualifiedBlocks.get(rawName);
        if (qualified != null) {
            return qualified;
        }
        if (collidingBlockNames.contains(rawName)) {
            return null;
        }
        return unqualifiedBlocks.get(rawName);
    }

    public synchronized BlockDescriptor blockDescriptor(final String rawName) {
        RegisteredBlock rb = resolveBlock(rawName);
        return rb != null ? rb.descriptor() : null;
    }

    public synchronized boolean isCollidingBlockName(final String rawName) {
        ensureLoadedFromEnvironment();
        return collidingBlockNames.contains(rawName);
    }

    public synchronized List<String> collisionOwners(final String rawName) {
        ensureLoadedFromEnvironment();
        if (rawName == null) {
            return List.of();
        }
        List<String> owners = new ArrayList<>();
        for (RosToolingPlugin p : orderedPlugins) {
            for (BlockDescriptor b : p.blocks()) {
                if (rawName.equals(b.name())) {
                    owners.add(p.id());
                }
            }
        }
        return owners;
    }

    public synchronized List<PluginToolDescriptor> activeTools() {
        ensureLoadedFromEnvironment();
        List<PluginToolDescriptor> result = new ArrayList<>();
        for (RosToolingPlugin plugin : orderedPlugins) {
            result.addAll(plugin.tools());
        }
        return Collections.unmodifiableList(result);
    }

    public synchronized PluginToolDescriptor findTool(final String toolName) {
        ensureLoadedFromEnvironment();
        for (RosToolingPlugin plugin : orderedPlugins) {
            for (PluginToolDescriptor tool : plugin.tools()) {
                if (tool.name().equals(toolName)) {
                    return tool;
                }
            }
        }
        return null;
    }

    public synchronized String pluginIdForTool(final String toolName) {
        ensureLoadedFromEnvironment();
        for (RosToolingPlugin plugin : orderedPlugins) {
            for (PluginToolDescriptor tool : plugin.tools()) {
                if (tool.name().equals(toolName)) {
                    return plugin.id();
                }
            }
        }
        return null;
    }

    private void rebuildState() {
        Map<String, RosToolingPlugin> combined = new LinkedHashMap<>(jarPlugins);
        combined.putAll(programmaticPlugins);

        for (RosToolingPlugin plugin : combined.values()) {
            for (String dep : plugin.dependencies()) {
                if (!combined.containsKey(dep)) {
                    loadErrors.add("Plugin '" + plugin.id() + "' declares dependency on inactive/missing plugin '" + dep + "'");
                }
            }
        }

        List<RosToolingPlugin> sorted = topologicalSort(combined.values());
        Map<String, RegisteredBlock> unqualified = new LinkedHashMap<>();
        Map<String, RegisteredBlock> qualified = new LinkedHashMap<>();
        Set<String> collisions = new LinkedHashSet<>();

        for (RosToolingPlugin plugin : sorted) {
            List<BlockDescriptor> blocks = plugin.blocks();
            if (blocks == null) {
                continue;
            }
            for (BlockDescriptor desc : blocks) {
                if (desc == null) {
                    continue;
                }
                RegisteredBlock rb = new RegisteredBlock(plugin, desc);
                qualified.put(plugin.id() + "." + desc.name(), rb);
                RegisteredBlock prev = unqualified.get(desc.name());
                if (prev != null && !prev.plugin().id().equals(plugin.id())) {
                    collisions.add(desc.name());
                } else {
                    unqualified.put(desc.name(), rb);
                }
            }
        }
        for (String collided : collisions) {
            unqualified.remove(collided);
        }

        this.orderedPlugins = Collections.unmodifiableList(sorted);
        this.unqualifiedBlocks = Collections.unmodifiableMap(unqualified);
        this.qualifiedBlocks = Collections.unmodifiableMap(qualified);
        this.collidingBlockNames = Collections.unmodifiableSet(collisions);
    }

    private List<RosToolingPlugin> topologicalSort(final Collection<RosToolingPlugin> plugins) {
        Map<String, RosToolingPlugin> byId = new LinkedHashMap<>();
        for (RosToolingPlugin p : plugins) {
            byId.put(p.id(), p);
        }
        Map<String, Integer> indegree = new LinkedHashMap<>();
        Map<String, List<String>> dependents = new LinkedHashMap<>();
        for (String id : byId.keySet()) {
            indegree.put(id, 0);
            dependents.put(id, new ArrayList<>());
        }
        for (RosToolingPlugin p : byId.values()) {
            for (String dep : p.dependencies()) {
                if (byId.containsKey(dep)) {
                    indegree.merge(p.id(), 1, Integer::sum);
                    dependents.get(dep).add(p.id());
                }
            }
        }
        List<String> ready = new ArrayList<>();
        for (Map.Entry<String, Integer> e : indegree.entrySet()) {
            if (e.getValue() == 0) {
                ready.add(e.getKey());
            }
        }
        ready.sort(Comparator.naturalOrder());
        Deque<String> queue = new ArrayDeque<>(ready);
        List<RosToolingPlugin> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            String next = queue.poll();
            result.add(byId.get(next));
            List<String> newlyReady = new ArrayList<>();
            for (String depOf : dependents.get(next)) {
                int rem = indegree.merge(depOf, -1, Integer::sum);
                if (rem == 0) {
                    newlyReady.add(depOf);
                }
            }
            newlyReady.sort(Comparator.naturalOrder());
            for (String nr : newlyReady) {
                queue.add(nr);
            }
        }
        if (result.size() < byId.size()) {
            loadErrors.add("Cyclic dependency detected among plugins");
            for (RosToolingPlugin p : byId.values()) {
                if (!result.contains(p)) {
                    result.add(p);
                }
            }
        }
        return result;
    }

    public static boolean isVersionCompatible(final String currentVersion, final String rangeSpec) {
        if (rangeSpec == null || rangeSpec.isBlank()) {
            return true;
        }
        String trimmed = rangeSpec.trim();
        char first = trimmed.charAt(0);
        char last = trimmed.charAt(trimmed.length() - 1);
        if ((first == '[' || first == '(') && (last == ']' || last == ')')) {
            String inner = trimmed.substring(1, trimmed.length() - 1);
            String[] parts = inner.split(",", -1);
            if (parts.length != 2) {
                return true;
            }
            String minStr = parts[0].trim();
            String maxStr = parts[1].trim();
            if (!minStr.isEmpty()) {
                int cmp = compareVersions(currentVersion, minStr);
                if (first == '[' ? cmp < 0 : cmp <= 0) {
                    return false;
                }
            }
            if (!maxStr.isEmpty()) {
                int cmp = compareVersions(currentVersion, maxStr);
                if (last == ']' ? cmp > 0 : cmp >= 0) {
                    return false;
                }
            }
            return true;
        }
        return compareVersions(currentVersion, trimmed) >= 0;
    }

    private static int compareVersions(final String a, final String b) {
        int[] va = parseVersionParts(a);
        int[] vb = parseVersionParts(b);
        for (int i = 0; i < 3; i++) {
            if (va[i] != vb[i]) {
                return Integer.compare(va[i], vb[i]);
            }
        }
        return 0;
    }

    private static int[] parseVersionParts(final String v) {
        String clean = v == null ? "0.0.0" : v.trim().split("-", 2)[0];
        String[] parts = clean.split("\\.");
        int[] nums = new int[3];
        for (int i = 0; i < Math.min(3, parts.length); i++) {
            try {
                nums[i] = Integer.parseInt(parts[i]);
            } catch (NumberFormatException ignored) {
                nums[i] = 0;
            }
        }
        return nums;
    }

    private void closeJarClassLoaders() {
        for (URLClassLoader cl : activeClassLoaders) {
            try {
                cl.close();
            } catch (IOException ignored) {
            }
        }
        activeClassLoaders.clear();
    }

    private static List<Path> parsePaths(final String raw) {
        if (raw == null || raw.isBlank()) {
            return List.of();
        }
        String sep = java.io.File.pathSeparator;
        List<Path> out = new ArrayList<>();
        for (String part : raw.split("[" + sep + ",]")) {
            String trimmed = part.trim();
            if (!trimmed.isEmpty()) {
                out.add(Paths.get(trimmed));
            }
        }
        return out;
    }

    private static Set<String> parseIdSet(final String raw) {
        if (raw == null || raw.isBlank()) {
            return Set.of();
        }
        Set<String> out = new LinkedHashSet<>();
        Arrays.stream(raw.split(","))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .forEach(out::add);
        return out;
    }

    private static String firstNonBlank(final String a, final String b) {
        if (a != null && !a.isBlank()) {
            return a;
        }
        if (b != null && !b.isBlank()) {
            return b;
        }
        return null;
    }
}
