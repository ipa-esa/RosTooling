package de.fraunhofer.ipa.ros.plugin.spi;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.CodeSource;
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
import java.util.Properties;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.stream.Stream;

/**
 * Discovers, validates, topologically orders, and serves active {@link RosToolingPlugin}s.
 *
 * <p>Implements Rule 4: passive listing reads only {@value #METADATA_ENTRY} from JARs without loading
 * plugin classes, and plugins activate only when explicitly enabled via configuration or programmatic
 * registration.
 */
public final class PluginRegistry {

    public static final String CORE_VERSION = "3.6.0";
    public static final String PROP_PLUGINS_DIR = "ros.plugins.dir";
    public static final String ENV_PLUGINS_DIR = "ROS_PLUGINS_DIR";
    public static final String PROP_PLUGINS_ENABLED = "ros.plugins.enabled";
    public static final String ENV_PLUGINS_ENABLED = "ROS_PLUGINS_ENABLED";
    public static final String METADATA_ENTRY = "META-INF/rostooling-plugin.properties";
    public static final int MAX_METADATA_BYTES = 16 * 1024;
    public static final int MAX_DOCUMENTATION_BYTES = 256 * 1024;

    public static final PluginRegistry INSTANCE = new PluginRegistry();

    public record RegisteredBlock(RosToolingPlugin plugin, BlockDescriptor descriptor) {
    }

    public record DiscoveredPlugin(
            String id,
            String version,
            String summary,
            String supportedCoreVersionRange,
            boolean compatible,
            boolean enabled,
            boolean active,
            String sourceJarPath,
            String loadError) {
    }

    private record JarScanResult(
            Path jarPath,
            boolean hasMetadataFile,
            String id,
            String version,
            String summary,
            String supportedCoreVersionRange,
            boolean compatible,
            String cachedDocMarkdown,
            String loadError) {
    }

    private final Map<String, RosToolingPlugin> programmaticPlugins = new LinkedHashMap<>();
    private final Map<String, RosToolingPlugin> jarPlugins = new LinkedHashMap<>();
    private final Map<String, Path> activePluginJarPaths = new LinkedHashMap<>();
    private final List<JarScanResult> lastJarScans = new ArrayList<>();
    private final Map<Path, String> jarActivationErrors = new LinkedHashMap<>();
    private final Map<String, String> inactiveDocumentationById = new LinkedHashMap<>();
    private Set<String> lastEnabledIds = Set.of();
    private final List<URLClassLoader> activeClassLoaders = new ArrayList<>();
    private final List<String> loadErrors = new ArrayList<>();
    private boolean initializedFromEnv = false;

    private List<RosToolingPlugin> orderedPlugins = List.of();
    private List<DiscoveredPlugin> discoveredPlugins = List.of();
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
        if (!dirs.isEmpty() || !enabled.isEmpty()) {
            loadFromPathsInternal(dirs, enabled);
        } else {
            rebuildState();
        }
    }

    public synchronized void loadFromPaths(final List<Path> pluginPaths, final Set<String> enabledIds) {
        initializedFromEnv = true;
        loadFromPathsInternal(pluginPaths, enabledIds);
    }

    private void loadFromPathsInternal(final List<Path> pluginPaths, final Set<String> enabledIds) {
        closeJarClassLoaders();
        jarPlugins.clear();
        activePluginJarPaths.clear();
        lastJarScans.clear();
        jarActivationErrors.clear();
        inactiveDocumentationById.clear();
        loadErrors.clear();

        Set<String> enabledSet = enabledIds == null ? Set.of() : Set.copyOf(enabledIds);
        lastEnabledIds = enabledSet;

        List<Path> jarPaths = collectJarPaths(pluginPaths);
        Map<Path, JarScanResult> scanByJar = new LinkedHashMap<>();
        Map<String, List<JarScanResult>> scansById = new LinkedHashMap<>();
        for (Path jar : jarPaths) {
            JarScanResult scan = scanJarMetadata(jar);
            lastJarScans.add(scan);
            scanByJar.put(jar, scan);
            if (!scan.id().isBlank()) {
                scansById.computeIfAbsent(scan.id(), ignored -> new ArrayList<>()).add(scan);
                if (!scan.cachedDocMarkdown().isEmpty()) {
                    inactiveDocumentationById.putIfAbsent(scan.id(), scan.cachedDocMarkdown());
                }
            }
            if (scan.hasMetadataFile() && !scan.loadError().isEmpty()) {
                loadErrors.add("Plugin JAR '" + jar + "': " + scan.loadError());
            }
        }

        if (enabledSet.isEmpty()) {
            rebuildState();
            return;
        }

        List<URL> jarUrls = new ArrayList<>();
        for (Path jar : jarPaths) {
            addJarUrl(jar, jarUrls);
        }

        Map<String, RosToolingPlugin> discovered = new LinkedHashMap<>();
        Map<String, Path> providerJarById = new LinkedHashMap<>();
        scanServiceLoader(PluginRegistry.class.getClassLoader(), discovered, providerJarById);
        scanOsgiServices(discovered);

        if (!jarUrls.isEmpty()) {
            URLClassLoader cl = new URLClassLoader(
                    jarUrls.toArray(new URL[0]),
                    PluginRegistry.class.getClassLoader());
            activeClassLoaders.add(cl);
            scanServiceLoader(cl, discovered, providerJarById);
        }

        for (String id : enabledSet) {
            if (programmaticPlugins.containsKey(id)) {
                continue;
            }
            RosToolingPlugin plugin = discovered.get(id);
            Path sourceJar = plugin != null ? providerJarById.get(id) : null;
            if (plugin == null) {
                List<JarScanResult> matchingScans = scansById.getOrDefault(id, List.of());
                if (!matchingScans.isEmpty()) {
                    JarScanResult scan = matchingScans.get(0);
                    String mismatch = !scan.loadError().isEmpty()
                            ? scan.loadError()
                            : "Enabled plugin '" + id + "' was not matched by ServiceLoader provider in '"
                                    + scan.jarPath() + "'";
                    jarActivationErrors.put(scan.jarPath(), mismatch);
                    loadErrors.add(mismatch);
                } else {
                    loadErrors.add("Enabled plugin '" + id + "' was not found in configured plugin paths");
                }
                continue;
            }
            if (sourceJar != null) {
                JarScanResult jarMeta = scanByJar.get(sourceJar);
                if (jarMeta != null && jarMeta.hasMetadataFile()) {
                    if (!jarMeta.loadError().isEmpty()) {
                        String err = "Cannot activate '" + id + "' from '" + sourceJar + "': " + jarMeta.loadError();
                        jarActivationErrors.put(sourceJar, jarMeta.loadError());
                        loadErrors.add(err);
                        continue;
                    }
                    String actualId = safeString(plugin.id());
                    String actualVersion = safeString(plugin.version());
                    if (!actualId.equals(jarMeta.id()) || !actualVersion.equals(jarMeta.version())) {
                        String err = "Plugin metadata mismatch in '" + sourceJar + "': metadata declares id='"
                                + jarMeta.id() + "', version='" + jarMeta.version()
                                + "' but class returned id='" + actualId + "', version='" + actualVersion + "'";
                        jarActivationErrors.put(sourceJar, err);
                        loadErrors.add(err);
                        continue;
                    }
                }
            }
            if (!isVersionCompatible(CORE_VERSION, plugin.supportedCoreVersionRange())) {
                String err = "Plugin '" + id + "' requires core version "
                        + plugin.supportedCoreVersionRange() + " (current core is " + CORE_VERSION + ")";
                loadErrors.add(err);
                if (sourceJar != null) {
                    jarActivationErrors.put(sourceJar, err);
                }
                continue;
            }
            jarPlugins.put(id, plugin);
            if (sourceJar != null) {
                activePluginJarPaths.put(id, sourceJar);
            }
        }

        rebuildState();
    }

    private List<Path> collectJarPaths(final List<Path> pluginPaths) {
        Set<Path> unique = new LinkedHashSet<>();
        if (pluginPaths == null) {
            return List.of();
        }
        for (Path p : pluginPaths) {
            if (p == null || !Files.exists(p)) {
                continue;
            }
            Path normalized = p.toAbsolutePath().normalize();
            if (Files.isRegularFile(normalized) && normalized.toString().endsWith(".jar")) {
                unique.add(normalized);
            } else if (Files.isDirectory(normalized)) {
                try (Stream<Path> walk = Files.list(normalized)) {
                    walk.filter(f -> Files.isRegularFile(f) && f.toString().endsWith(".jar"))
                            .map(f -> f.toAbsolutePath().normalize())
                            .sorted()
                            .forEach(unique::add);
                } catch (IOException e) {
                    loadErrors.add("Failed to scan plugin directory '" + p + "': " + e.getMessage());
                }
            }
        }
        return new ArrayList<>(unique);
    }

    private JarScanResult scanJarMetadata(final Path jar) {
        try (JarFile jf = new JarFile(jar.toFile())) {
            JarEntry metaEntry = jf.getJarEntry(METADATA_ENTRY);
            if (metaEntry == null) {
                return new JarScanResult(
                        jar, false, "", "", "", "", false, "",
                        "no plugin metadata; enable by id in settings");
            }
            byte[] metaBytes;
            try {
                metaBytes = readBoundedEntry(jf, metaEntry, MAX_METADATA_BYTES, "Plugin metadata");
            } catch (IOException e) {
                return new JarScanResult(jar, true, "", "", "", "", false, "", e.getMessage());
            }

            Properties props = new Properties();
            try (StringReader reader = new StringReader(new String(metaBytes, StandardCharsets.UTF_8))) {
                props.load(reader);
            } catch (IOException | IllegalArgumentException e) {
                return new JarScanResult(
                        jar, true, "", "", "", "", false, "",
                        "Invalid plugin metadata properties: " + e.getMessage());
            }

            String id = safeTrim(props.getProperty("id"));
            String version = safeTrim(props.getProperty("version"));
            String range = safeTrim(props.getProperty("supportedCoreVersionRange"));
            String summary = safeTrim(props.getProperty("summary"));
            String docPath = normalizeJarDocPath(props.getProperty("documentation"));

            List<String> missing = new ArrayList<>();
            if (id.isEmpty()) missing.add("id");
            if (version.isEmpty()) missing.add("version");
            if (range.isEmpty()) missing.add("supportedCoreVersionRange");
            if (summary.isEmpty()) missing.add("summary");
            if (!missing.isEmpty()) {
                return new JarScanResult(
                        jar, true, id, version, summary, range, false, "",
                        "Missing required metadata key(s): " + String.join(", ", missing));
            }

            String cachedDoc = "";
            String docError = "";
            if (props.getProperty("documentation") != null && !props.getProperty("documentation").isBlank()) {
                if (docPath == null) {
                    docError = "Invalid documentation entry path '" + props.getProperty("documentation") + "'";
                } else {
                    JarEntry docEntry = jf.getJarEntry(docPath);
                    if (docEntry == null) {
                        docError = "Documentation entry '" + docPath + "' not found in JAR";
                    } else {
                        try {
                            byte[] docBytes = readBoundedEntry(
                                    jf, docEntry, MAX_DOCUMENTATION_BYTES, "Plugin documentation");
                            cachedDoc = new String(docBytes, StandardCharsets.UTF_8);
                        } catch (IOException e) {
                            docError = e.getMessage();
                        }
                    }
                }
            }

            boolean compatible = isVersionCompatible(CORE_VERSION, range);
            return new JarScanResult(jar, true, id, version, summary, range, compatible, cachedDoc, docError);
        } catch (Throwable t) {
            return new JarScanResult(
                    jar, true, "", "", "", "", false, "",
                    "Failed to read plugin JAR: " + t.getMessage());
        }
    }

    private static byte[] readBoundedEntry(
            final JarFile jf, final JarEntry entry, final int maxBytes, final String label) throws IOException {
        long declaredSize = entry.getSize();
        if (declaredSize > maxBytes) {
            throw new IOException(label + " entry exceeds " + (maxBytes / 1024) + " KB limit (" + declaredSize + " bytes)");
        }
        try (InputStream is = jf.getInputStream(entry)) {
            if (is == null) {
                throw new IOException("Unable to open " + label + " entry '" + entry.getName() + "'");
            }
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            byte[] buf = new byte[4096];
            int total = 0;
            int n;
            while ((n = is.read(buf)) != -1) {
                total += n;
                if (total > maxBytes) {
                    throw new IOException(label + " entry exceeds " + (maxBytes / 1024) + " KB limit");
                }
                out.write(buf, 0, n);
            }
            return out.toByteArray();
        }
    }

    private static String normalizeJarDocPath(final String raw) {
        if (raw == null || raw.isBlank()) {
            return null;
        }
        String norm = raw.trim().replace('\\', '/');
        while (norm.startsWith("/")) {
            norm = norm.substring(1);
        }
        if (norm.isEmpty() || norm.contains("..")) {
            return null;
        }
        return norm;
    }

    private void scanServiceLoader(
            final ClassLoader cl,
            final Map<String, RosToolingPlugin> out,
            final Map<String, Path> providerJarOut) {
        try {
            ServiceLoader<RosToolingPlugin> loader = ServiceLoader.load(RosToolingPlugin.class, cl);
            for (RosToolingPlugin plugin : loader) {
                if (plugin != null && plugin.id() != null && !plugin.id().isBlank()) {
                    out.putIfAbsent(plugin.id(), plugin);
                    Path src = resolveSourceJar(plugin.getClass());
                    if (src != null) {
                        providerJarOut.putIfAbsent(plugin.id(), src);
                    }
                }
            }
        } catch (Throwable t) {
            loadErrors.add("Failed to load RosToolingPlugin providers: " + t.getMessage());
        }
    }

    private static Path resolveSourceJar(final Class<?> cls) {
        try {
            CodeSource cs = cls.getProtectionDomain() != null ? cls.getProtectionDomain().getCodeSource() : null;
            URL loc = cs != null ? cs.getLocation() : null;
            if (loc != null && "file".equalsIgnoreCase(loc.getProtocol())) {
                return Paths.get(loc.toURI()).toAbsolutePath().normalize();
            }
        } catch (Exception ignored) {
        }
        return null;
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
        activePluginJarPaths.clear();
        lastJarScans.clear();
        jarActivationErrors.clear();
        inactiveDocumentationById.clear();
        lastEnabledIds = Set.of();
        loadErrors.clear();
        closeJarClassLoaders();
        initializedFromEnv = false;
        rebuildState();
    }

    public synchronized List<RosToolingPlugin> activePlugins() {
        ensureLoadedFromEnvironment();
        return orderedPlugins;
    }

    public synchronized List<DiscoveredPlugin> discoveredPlugins() {
        ensureLoadedFromEnvironment();
        return discoveredPlugins;
    }

    public synchronized String documentationMarkdownFor(final String pluginId) {
        ensureLoadedFromEnvironment();
        if (pluginId == null || pluginId.isBlank()) {
            return "";
        }
        RosToolingPlugin active = pluginById(pluginId);
        if (active != null) {
            try {
                return safeString(active.documentationMarkdown());
            } catch (Throwable ignored) {
                return "";
            }
        }
        return inactiveDocumentationById.getOrDefault(pluginId, "");
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
        this.discoveredPlugins = rebuildDiscoveredPlugins(sorted);
    }

    private List<DiscoveredPlugin> rebuildDiscoveredPlugins(final List<RosToolingPlugin> activeSorted) {
        Map<String, RosToolingPlugin> activeById = new LinkedHashMap<>();
        for (RosToolingPlugin p : activeSorted) {
            activeById.put(p.id(), p);
        }

        List<DiscoveredPlugin> out = new ArrayList<>();
        Set<String> representedIds = new LinkedHashSet<>();

        for (JarScanResult scan : lastJarScans) {
            String jarStr = scan.jarPath().toString();
            String activationErr = jarActivationErrors.getOrDefault(scan.jarPath(), "");
            if (scan.hasMetadataFile()) {
                String id = scan.id();
                boolean isEnabled = !id.isEmpty() && lastEnabledIds.contains(id);
                RosToolingPlugin active = !id.isEmpty() ? activeById.get(id) : null;
                boolean isActive = active != null
                        && scan.jarPath().equals(activePluginJarPaths.get(id));
                String err = !activationErr.isEmpty() ? activationErr : scan.loadError();
                out.add(new DiscoveredPlugin(
                        id,
                        scan.version(),
                        scan.summary(),
                        scan.supportedCoreVersionRange(),
                        scan.compatible(),
                        isEnabled,
                        isActive,
                        jarStr,
                        err));
                if (!id.isEmpty()) {
                    representedIds.add(id);
                }
            } else {
                RosToolingPlugin activeFromJar = null;
                for (Map.Entry<String, Path> e : activePluginJarPaths.entrySet()) {
                    if (scan.jarPath().equals(e.getValue())) {
                        activeFromJar = activeById.get(e.getKey());
                        break;
                    }
                }
                if (activeFromJar != null) {
                    representedIds.add(activeFromJar.id());
                    out.add(new DiscoveredPlugin(
                            activeFromJar.id(),
                            safeString(activeFromJar.version()),
                            firstNonHeadingLine(activeFromJar.documentationMarkdown()),
                            safeString(activeFromJar.supportedCoreVersionRange()),
                            true,
                            true,
                            true,
                            jarStr,
                            ""));
                } else {
                    out.add(new DiscoveredPlugin(
                            "",
                            "",
                            "",
                            "",
                            false,
                            false,
                            false,
                            jarStr,
                            !activationErr.isEmpty() ? activationErr : scan.loadError()));
                }
            }
        }

        for (RosToolingPlugin active : activeSorted) {
            if (representedIds.contains(active.id())) {
                continue;
            }
            Path activeJar = activePluginJarPaths.get(active.id());
            String sourceStr = activeJar != null ? activeJar.toString() : "";
            out.add(new DiscoveredPlugin(
                    active.id(),
                    safeString(active.version()),
                    firstNonHeadingLine(active.documentationMarkdown()),
                    safeString(active.supportedCoreVersionRange()),
                    true,
                    true,
                    true,
                    sourceStr,
                    ""));
        }

        return Collections.unmodifiableList(out);
    }

    public static String firstNonHeadingLine(final String markdown) {
        if (markdown == null || markdown.isBlank()) {
            return "";
        }
        for (String line : markdown.split("\\R")) {
            String trimmed = line.trim();
            if (!trimmed.isEmpty() && !trimmed.startsWith("#")) {
                return trimmed;
            }
        }
        return "";
    }

    private static String safeTrim(final String s) {
        return s == null ? "" : s.trim();
    }

    private static String safeString(final String s) {
        return s == null ? "" : s;
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
