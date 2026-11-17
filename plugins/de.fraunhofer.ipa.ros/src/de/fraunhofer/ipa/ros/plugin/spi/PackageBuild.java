package de.fraunhofer.ipa.ros.plugin.spi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * Structured in-memory build model for a ROS 2 package ({@code CMakeLists.txt} and
 * {@code package.xml}). Core populates the base model from the {@code .ros2} AST, plugins add
 * structured contributions in deterministic order, and core renders once through the distro
 * dialect.
 */
public final class PackageBuild {

    public record XmlExportEntry(String tagName, Map<String, String> attributes, String textContent) {
        public XmlExportEntry {
            Objects.requireNonNull(tagName, "tagName");
            attributes = attributes == null ? Map.of() : Collections.unmodifiableMap(new LinkedHashMap<>(attributes));
            textContent = textContent == null ? "" : textContent;
        }
    }

    public record PluginlibExport(String basePackage, String descriptionFile) {
        public PluginlibExport {
            Objects.requireNonNull(basePackage, "basePackage");
            Objects.requireNonNull(descriptionFile, "descriptionFile");
        }
    }

    public record PythonProgramInstall(String source, String destination, String rename) {}

    public record InstallDirectoryRule(String directory, String destination, boolean optional) {}

    public record InstallFilesRule(List<String> files, String destination) {}

    public record TestTarget(String name, String kind, List<String> sources, List<String> linkLibraries, List<String> linkPackages) {}

    public static final class LibraryTarget {
        private final String name;
        private boolean shared;
        private String ownerPluginId;
        private final Set<String> sources = new LinkedHashSet<>();
        private final Set<String> publicIncludeDirs = new LinkedHashSet<>();
        private final Set<String> privateIncludeDirs = new LinkedHashSet<>();
        private final Set<String> publicLinkPackages = new LinkedHashSet<>();
        private final Set<String> privateLinkPackages = new LinkedHashSet<>();
        private final Set<String> publicLinkLibraries = new LinkedHashSet<>();
        private final Set<String> privateLinkLibraries = new LinkedHashSet<>();
        private final Set<String> compileDefinitions = new LinkedHashSet<>();
        private final Set<String> componentRegistrations = new LinkedHashSet<>();
        private final Set<PluginlibExport> pluginlibExports = new LinkedHashSet<>();
        private boolean install = true;
        private String bannerComment;

        public LibraryTarget(final String name, final boolean shared, final String ownerPluginId) {
            this.name = Objects.requireNonNull(name, "name");
            this.shared = shared;
            this.ownerPluginId = ownerPluginId;
        }

        public String name() { return name; }
        public boolean shared() { return shared; }
        public String ownerPluginId() { return ownerPluginId; }
        public Set<String> sources() { return sources; }
        public Set<String> publicIncludeDirs() { return publicIncludeDirs; }
        public Set<String> privateIncludeDirs() { return privateIncludeDirs; }
        public Set<String> publicLinkPackages() { return publicLinkPackages; }
        public Set<String> privateLinkPackages() { return privateLinkPackages; }
        public Set<String> publicLinkLibraries() { return publicLinkLibraries; }
        public Set<String> privateLinkLibraries() { return privateLinkLibraries; }
        public Set<String> compileDefinitions() { return compileDefinitions; }
        public Set<String> componentRegistrations() { return componentRegistrations; }
        public Set<PluginlibExport> pluginlibExports() { return pluginlibExports; }
        public boolean install() { return install; }
        public void setInstall(final boolean install) { this.install = install; }
        public String bannerComment() { return bannerComment; }
        public void setBannerComment(final String bannerComment) { this.bannerComment = bannerComment; }
    }

    public static final class ExecutableTarget {
        private final String name;
        private final String ownerPluginId;
        private final Set<String> sources = new LinkedHashSet<>();
        private final Set<String> privateLinkLibraries = new LinkedHashSet<>();
        private final Set<String> publicLinkLibraries = new LinkedHashSet<>();
        private final Set<String> linkPackages = new LinkedHashSet<>();
        private final Set<String> compileDefinitions = new LinkedHashSet<>();
        private String bannerComment;

        public ExecutableTarget(final String name, final String ownerPluginId) {
            this.name = Objects.requireNonNull(name, "name");
            this.ownerPluginId = ownerPluginId;
        }

        public String name() { return name; }
        public String ownerPluginId() { return ownerPluginId; }
        public Set<String> sources() { return sources; }
        public Set<String> privateLinkLibraries() { return privateLinkLibraries; }
        public Set<String> publicLinkLibraries() { return publicLinkLibraries; }
        public Set<String> linkPackages() { return linkPackages; }
        public Set<String> compileDefinitions() { return compileDefinitions; }
        public String bannerComment() { return bannerComment; }
        public void setBannerComment(final String bannerComment) { this.bannerComment = bannerComment; }
    }

    private final String packageName;
    private boolean purePython;
    private boolean hybrid;
    private String buildType = "ament_cmake";
    private String description = "";
    private boolean includeHeaderInstall;

    private final Set<String> buildtoolDepends = new LinkedHashSet<>();
    private final Set<String> depends = new LinkedHashSet<>();
    private final Set<String> execDepends = new LinkedHashSet<>();
    private final Set<String> testDepends = new LinkedHashSet<>();
    private final Set<XmlExportEntry> xmlExports = new LinkedHashSet<>();
    private final Set<String> findPackages = new LinkedHashSet<>();
    private final Map<String, LibraryTarget> libraries = new LinkedHashMap<>();
    private final Map<String, ExecutableTarget> executables = new LinkedHashMap<>();
    private final Set<String> installTargets = new LinkedHashSet<>();
    private final List<PythonProgramInstall> pythonPrograms = new ArrayList<>();
    private final List<InstallDirectoryRule> installDirectories = new ArrayList<>();
    private final List<InstallFilesRule> installFiles = new ArrayList<>();
    private final List<TestTarget> tests = new ArrayList<>();
    private final Set<PluginlibExport> pluginlibExports = new LinkedHashSet<>();

    private final Map<String, String> singleValues = new LinkedHashMap<>();
    private final Map<String, String> singleValueOwners = new LinkedHashMap<>();
    private final List<String> conflictErrors = new ArrayList<>();
    private final Map<String, String> sourceOwners = new LinkedHashMap<>();

    public PackageBuild(final String packageName) {
        this.packageName = Objects.requireNonNull(packageName, "packageName");
    }

    public String packageName() { return packageName; }
    public boolean isPurePython() { return purePython; }
    public void setPurePython(final boolean purePython) { this.purePython = purePython; }
    public boolean isHybrid() { return hybrid; }
    public void setHybrid(final boolean hybrid) { this.hybrid = hybrid; }
    public String buildType() { return buildType; }
    public void setBuildType(final String buildType) { this.buildType = buildType; }
    public String description() { return description; }
    public void setDescription(final String description) { this.description = description; }
    public boolean isIncludeHeaderInstall() { return includeHeaderInstall; }
    public void setIncludeHeaderInstall(final boolean includeHeaderInstall) { this.includeHeaderInstall = includeHeaderInstall; }

    public Set<String> buildtoolDepends() { return buildtoolDepends; }
    public Set<String> depends() { return depends; }
    public Set<String> execDepends() { return execDepends; }
    public Set<String> testDepends() { return testDepends; }
    public Set<XmlExportEntry> xmlExports() { return xmlExports; }
    public Set<String> findPackages() { return findPackages; }
    public Map<String, LibraryTarget> libraries() { return libraries; }
    public Map<String, ExecutableTarget> executables() { return executables; }
    public Set<String> installTargets() { return installTargets; }
    public List<PythonProgramInstall> pythonPrograms() { return pythonPrograms; }
    public List<InstallDirectoryRule> installDirectories() { return installDirectories; }
    public List<InstallFilesRule> installFiles() { return installFiles; }
    public List<TestTarget> tests() { return tests; }
    public Set<PluginlibExport> pluginlibExports() { return pluginlibExports; }
    public List<String> conflictErrors() { return Collections.unmodifiableList(conflictErrors); }

    public void addBuildtoolDepend(final String pkg) {
        if (pkg != null && !pkg.isBlank()) buildtoolDepends.add(pkg.trim());
    }

    public void addDepend(final String pkg) {
        if (pkg != null && !pkg.isBlank()) depends.add(pkg.trim());
    }

    public void addExecDepend(final String pkg) {
        if (pkg != null && !pkg.isBlank()) execDepends.add(pkg.trim());
    }

    public void addTestDepend(final String pkg) {
        if (pkg != null && !pkg.isBlank()) testDepends.add(pkg.trim());
    }

    public void addFindPackage(final String pkg) {
        if (pkg != null && !pkg.isBlank()) findPackages.add(pkg.trim());
    }

    public void addXmlExport(final XmlExportEntry entry) {
        if (entry != null) xmlExports.add(entry);
    }

    public void addPluginlibExport(final String basePackage, final String descriptionFile) {
        if (basePackage != null && !basePackage.isBlank() && descriptionFile != null && !descriptionFile.isBlank()) {
            pluginlibExports.add(new PluginlibExport(basePackage.trim(), descriptionFile.trim()));
        }
    }

    /**
     * Gets or creates a library target, recording a conflict error naming both plugins if an
     * existing target has a different linkage type ({@code SHARED} vs {@code STATIC}).
     */
    public LibraryTarget getOrCreateLibrary(final String name, final boolean shared, final String pluginId) {
        LibraryTarget existing = libraries.get(name);
        if (existing == null) {
            LibraryTarget created = new LibraryTarget(name, shared, pluginId);
            libraries.put(name, created);
            if (created.install()) {
                installTargets.add(name);
            }
            return created;
        }
        if (existing.shared() != shared) {
            String firstOwner = existing.ownerPluginId() != null ? existing.ownerPluginId() : "core";
            String secondOwner = pluginId != null ? pluginId : "core";
            conflictErrors.add("Plugin conflict between '" + firstOwner + "' and '" + secondOwner
                    + "' on library target '" + name + "': conflicting library linkage (shared="
                    + existing.shared() + " vs shared=" + shared + ")");
        }
        return existing;
    }

    /**
     * Adds a source file to a library target while checking single-owner conflict semantics if two
     * different plugins attempt to register the same file under conflicting targets, or merges cleanly.
     */
    public void addLibrarySource(final LibraryTarget lib, final String sourcePath, final String pluginId) {
        if (lib == null || sourcePath == null || sourcePath.isBlank()) {
            return;
        }
        String norm = sourcePath.trim();
        lib.sources().add(norm);
        sourceOwners.putIfAbsent(norm, pluginId != null ? pluginId : "core");
    }

    public ExecutableTarget getOrCreateExecutable(final String name, final String pluginId) {
        return executables.computeIfAbsent(name, n -> {
            ExecutableTarget created = new ExecutableTarget(n, pluginId);
            installTargets.add(n);
            return created;
        });
    }

    public void addInstallDirectory(final String dir, final String destination, final boolean optional) {
        InstallDirectoryRule rule = new InstallDirectoryRule(dir, destination, optional);
        if (!installDirectories.contains(rule)) {
            installDirectories.add(rule);
        }
    }

    public void addInstallFiles(final List<String> files, final String destination) {
        if (files == null || files.isEmpty()) return;
        InstallFilesRule rule = new InstallFilesRule(List.copyOf(files), destination);
        if (!installFiles.contains(rule)) {
            installFiles.add(rule);
        }
    }

    public void addTestTarget(final TestTarget test) {
        if (test != null && tests.stream().noneMatch(t -> t.name().equals(test.name()))) {
            tests.add(test);
        }
    }

    /**
     * Sets a single-valued build configuration property using the declared merge strategy.
     * Reports a conflict naming both plugins when {@link MergeStrategy#ERROR_ON_CONFLICT} is used
     * and two plugins provide different values.
     */
    public void setSingleValue(
            final String pluginId,
            final String key,
            final String value,
            final MergeStrategy strategy) {
        String owner = pluginId != null ? pluginId : "core";
        String prev = singleValues.get(key);
        String prevOwner = singleValueOwners.get(key);
        if (prev == null) {
            singleValues.put(key, value);
            singleValueOwners.put(key, owner);
            return;
        }
        if (Objects.equals(prev, value)) {
            return;
        }
        MergeStrategy effective = strategy != null ? strategy : MergeStrategy.ERROR_ON_CONFLICT;
        switch (effective) {
            case INSTANCE_OVERRIDES_TYPE -> {
                singleValues.put(key, value);
                singleValueOwners.put(key, owner);
            }
            case TYPE_WINS -> {
                // keep previous value
            }
            default -> conflictErrors.add("Plugin conflict between '" + prevOwner + "' and '" + owner
                    + "' on build property '" + key + "': '" + prev + "' vs '" + value + "'");
        }
    }

    public String getSingleValue(final String key) {
        return singleValues.get(key);
    }

    public String getSingleValue(final String key, final String fallback) {
        return singleValues.getOrDefault(key, fallback);
    }
}
