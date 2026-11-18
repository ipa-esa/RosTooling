package de.fraunhofer.ipa.ros.plugin.spi;

import java.util.AbstractList;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.regex.Pattern;

/**
 * Structured in-memory build model for a ROS 2 package ({@code CMakeLists.txt} and
 * {@code package.xml}). Core populates the base model from the {@code .ros2} AST, plugins add
 * structured contributions in deterministic order, and core validates/escapes every value before
 * rendering once through the distro dialect.
 */
public final class PackageBuild {

    private static final Pattern IDENTIFIER_PATTERN =
            Pattern.compile("^[A-Za-z0-9_][A-Za-z0-9_.-]*$");
    private static final Pattern LINK_LIBRARY_PATTERN =
            Pattern.compile("^[A-Za-z0-9_][A-Za-z0-9_:.-]*$");
    private static final Pattern COMPILE_DEF_PATTERN =
            Pattern.compile("^(?:-D)?[A-Za-z_][A-Za-z0-9_]*(?:=[A-Za-z0-9_.:+/-]+)?$");
    private static final Pattern COMPONENT_REG_PATTERN =
            Pattern.compile("^[A-Za-z_][A-Za-z0-9_]*(?:::[A-Za-z_][A-Za-z0-9_]*)*$");
    private static final Pattern RELATIVE_BUILD_PATH_PATTERN =
            Pattern.compile("^(?:[A-Za-z0-9_./-]+|\\$\\{PROJECT_NAME\\}|\\$\\{CMAKE_CURRENT_SOURCE_DIR\\})+$");
    private static final Pattern INCLUDE_DIR_PATTERN =
            Pattern.compile("^(?:[A-Za-z0-9_./-]+|\\$\\{PROJECT_NAME\\}|\\$\\{CMAKE_CURRENT_SOURCE_DIR\\}"
                    + "|\\$<BUILD_INTERFACE:[A-Za-z0-9_./${}-]+>"
                    + "|\\$<INSTALL_INTERFACE:[A-Za-z0-9_./${}-]+>)+$");
    private static final Pattern XML_NAME_PATTERN =
            Pattern.compile("^[A-Za-z_][A-Za-z0-9_.:-]*$");

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

    /**
     * Escapes XML character data and attribute values so plugin-contributed text cannot inject tags
     * or attributes into {@code package.xml}.
     */
    public static String escapeXml(final String raw) {
        if (raw == null || raw.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder(raw.length() + 16);
        for (int i = 0; i < raw.length(); i++) {
            char c = raw.charAt(i);
            switch (c) {
                case '&' -> sb.append("&amp;");
                case '<' -> sb.append("&lt;");
                case '>' -> sb.append("&gt;");
                case '"' -> sb.append("&quot;");
                case '\'' -> sb.append("&apos;");
                default -> sb.append(c);
            }
        }
        return sb.toString();
    }

    public static boolean isValidIdentifier(final String value) {
        return value != null && IDENTIFIER_PATTERN.matcher(value).matches();
    }

    public static boolean isValidLinkLibrary(final String value) {
        return value != null && LINK_LIBRARY_PATTERN.matcher(value).matches();
    }

    public static boolean isValidCompileDefinition(final String value) {
        return value != null && COMPILE_DEF_PATTERN.matcher(value).matches();
    }

    public static boolean isValidComponentRegistration(final String value) {
        return value != null && COMPONENT_REG_PATTERN.matcher(value).matches();
    }

    public static boolean isValidRelativeBuildPath(final String value) {
        return value != null
                && !value.isBlank()
                && !value.startsWith("/")
                && !value.contains("..")
                && RELATIVE_BUILD_PATH_PATTERN.matcher(value).matches();
    }

    public static boolean isValidIncludeDir(final String value) {
        return value != null
                && !value.isBlank()
                && !value.startsWith("/")
                && !value.contains("..")
                && INCLUDE_DIR_PATTERN.matcher(value).matches();
    }

    public static boolean isValidXmlName(final String value) {
        return value != null && XML_NAME_PATTERN.matcher(value).matches();
    }

    public static boolean isValidXmlText(final String value) {
        if (value == null) {
            return false;
        }
        for (int i = 0; i < value.length(); i++) {
            int ch = value.charAt(i);
            if ((ch >= 0 && ch < 0x20) && ch != '\t' && ch != '\n' && ch != '\r') {
                return false;
            }
        }
        return true;
    }

    private final class ValidatingStringSet extends AbstractSet<String> {
        private final LinkedHashSet<String> delegate = new LinkedHashSet<>();
        private final String fieldName;
        private final Predicate<String> validator;
        private final String requirement;
        private final Supplier<String> fallbackOwner;

        ValidatingStringSet(
                final String fieldName,
                final Predicate<String> validator,
                final String requirement,
                final Supplier<String> fallbackOwner) {
            this.fieldName = fieldName;
            this.validator = validator;
            this.requirement = requirement;
            this.fallbackOwner = fallbackOwner;
        }

        @Override
        public boolean add(final String raw) {
            String owner = resolveOwner(fallbackOwner != null ? fallbackOwner.get() : null);
            if (raw == null || !validator.test(raw)) {
                recordInvalidValueError(owner, fieldName, raw, requirement);
                return false;
            }
            return delegate.add(raw);
        }

        @Override
        public boolean addAll(final Collection<? extends String> c) {
            boolean modified = false;
            if (c != null) {
                for (String item : c) {
                    if (add(item)) {
                        modified = true;
                    }
                }
            }
            return modified;
        }

        @Override
        public Iterator<String> iterator() {
            return delegate.iterator();
        }

        @Override
        public int size() {
            return delegate.size();
        }

        @Override
        public boolean contains(final Object o) {
            return delegate.contains(o);
        }
    }

    private final class ValidatingRuleSet<T> extends AbstractSet<T> {
        private final LinkedHashSet<T> delegate = new LinkedHashSet<>();
        private final Predicate<T> validator;

        ValidatingRuleSet(final Predicate<T> validator) {
            this.validator = validator;
        }

        @Override
        public boolean add(final T item) {
            if (item == null || !validator.test(item)) {
                return false;
            }
            return delegate.add(item);
        }

        @Override
        public Iterator<T> iterator() {
            return delegate.iterator();
        }

        @Override
        public int size() {
            return delegate.size();
        }

        @Override
        public boolean contains(final Object o) {
            return delegate.contains(o);
        }
    }

    private final class ValidatingRuleList<T> extends AbstractList<T> {
        private final ArrayList<T> delegate = new ArrayList<>();
        private final Predicate<T> validator;

        ValidatingRuleList(final Predicate<T> validator) {
            this.validator = validator;
        }

        @Override
        public boolean add(final T item) {
            if (item == null || !validator.test(item)) {
                return false;
            }
            return delegate.add(item);
        }

        @Override
        public void add(final int index, final T item) {
            if (item == null || !validator.test(item)) {
                return;
            }
            delegate.add(index, item);
        }

        @Override
        public T get(final int index) {
            return delegate.get(index);
        }

        @Override
        public int size() {
            return delegate.size();
        }
    }

    public static final class LibraryTarget {
        private final String name;
        private boolean shared;
        private String ownerPluginId;
        private final Set<String> sources;
        private final Set<String> publicIncludeDirs;
        private final Set<String> privateIncludeDirs;
        private final Set<String> publicLinkPackages;
        private final Set<String> privateLinkPackages;
        private final Set<String> publicLinkLibraries;
        private final Set<String> privateLinkLibraries;
        private final Set<String> compileDefinitions;
        private final Set<String> componentRegistrations;
        private final Set<PluginlibExport> pluginlibExports;
        private boolean install = true;

        private LibraryTarget(final PackageBuild build, final String name, final boolean shared, final String ownerPluginId) {
            this.name = Objects.requireNonNull(name, "name");
            this.shared = shared;
            this.ownerPluginId = ownerPluginId;
            Supplier<String> fallback = () -> this.ownerPluginId;
            this.sources = build.new ValidatingStringSet("LibraryTarget.sources",
                    PackageBuild::isValidRelativeBuildPath, "must be a safe relative build path without whitespace or '..'", fallback);
            this.publicIncludeDirs = build.new ValidatingStringSet("LibraryTarget.publicIncludeDirs",
                    PackageBuild::isValidIncludeDir, "must be a safe include path or generator expression", fallback);
            this.privateIncludeDirs = build.new ValidatingStringSet("LibraryTarget.privateIncludeDirs",
                    PackageBuild::isValidIncludeDir, "must be a safe include path or generator expression", fallback);
            this.publicLinkPackages = build.new ValidatingStringSet("LibraryTarget.publicLinkPackages",
                    PackageBuild::isValidIdentifier, "must be a valid package identifier", fallback);
            this.privateLinkPackages = build.new ValidatingStringSet("LibraryTarget.privateLinkPackages",
                    PackageBuild::isValidIdentifier, "must be a valid package identifier", fallback);
            this.publicLinkLibraries = build.new ValidatingStringSet("LibraryTarget.publicLinkLibraries",
                    PackageBuild::isValidLinkLibrary, "must be a valid CMake target or library name", fallback);
            this.privateLinkLibraries = build.new ValidatingStringSet("LibraryTarget.privateLinkLibraries",
                    PackageBuild::isValidLinkLibrary, "must be a valid CMake target or library name", fallback);
            this.compileDefinitions = build.new ValidatingStringSet("LibraryTarget.compileDefinitions",
                    PackageBuild::isValidCompileDefinition, "must be NAME or NAME=VALUE without whitespace or quotes", fallback);
            this.componentRegistrations = build.new ValidatingStringSet("LibraryTarget.componentRegistrations",
                    PackageBuild::isValidComponentRegistration, "must be a valid C++ qualified class name", fallback);
            this.pluginlibExports = build.new ValidatingRuleSet<>(exp ->
                    build.validatePluginlibExport(exp, resolveTargetOwner(build, this.ownerPluginId)));
        }

        private static String resolveTargetOwner(final PackageBuild build, final String targetOwner) {
            return build.resolveOwner(targetOwner);
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
    }

    public static final class ExecutableTarget {
        private final String name;
        private final String ownerPluginId;
        private final Set<String> sources;
        private final Set<String> privateLinkLibraries;
        private final Set<String> publicLinkLibraries;
        private final Set<String> linkPackages;
        private final Set<String> compileDefinitions;

        private ExecutableTarget(final PackageBuild build, final String name, final String ownerPluginId) {
            this.name = Objects.requireNonNull(name, "name");
            this.ownerPluginId = ownerPluginId;
            Supplier<String> fallback = () -> this.ownerPluginId;
            this.sources = build.new ValidatingStringSet("ExecutableTarget.sources",
                    PackageBuild::isValidRelativeBuildPath, "must be a safe relative build path without whitespace or '..'", fallback);
            this.privateLinkLibraries = build.new ValidatingStringSet("ExecutableTarget.privateLinkLibraries",
                    PackageBuild::isValidLinkLibrary, "must be a valid CMake target or library name", fallback);
            this.publicLinkLibraries = build.new ValidatingStringSet("ExecutableTarget.publicLinkLibraries",
                    PackageBuild::isValidLinkLibrary, "must be a valid CMake target or library name", fallback);
            this.linkPackages = build.new ValidatingStringSet("ExecutableTarget.linkPackages",
                    PackageBuild::isValidIdentifier, "must be a valid package identifier", fallback);
            this.compileDefinitions = build.new ValidatingStringSet("ExecutableTarget.compileDefinitions",
                    PackageBuild::isValidCompileDefinition, "must be NAME or NAME=VALUE without whitespace or quotes", fallback);
        }

        public String name() { return name; }
        public String ownerPluginId() { return ownerPluginId; }
        public Set<String> sources() { return sources; }
        public Set<String> privateLinkLibraries() { return privateLinkLibraries; }
        public Set<String> publicLinkLibraries() { return publicLinkLibraries; }
        public Set<String> linkPackages() { return linkPackages; }
        public Set<String> compileDefinitions() { return compileDefinitions; }
    }

    private final String packageName;
    private String currentPluginId = "core";
    private boolean purePython;
    private boolean hybrid;
    private String buildType = "ament_cmake";
    private String description = "";
    private boolean includeHeaderInstall;

    private final Set<String> buildtoolDepends;
    private final Set<String> depends;
    private final Set<String> execDepends;
    private final Set<String> testDepends;
    private final Set<XmlExportEntry> xmlExports;
    private final Set<String> findPackages;
    private final Map<String, LibraryTarget> libraries = new LinkedHashMap<>();
    private final Map<String, ExecutableTarget> executables = new LinkedHashMap<>();
    private final Set<String> installTargets;
    private final List<PythonProgramInstall> pythonPrograms;
    private final List<InstallDirectoryRule> installDirectories;
    private final List<InstallFilesRule> installFiles;
    private final List<TestTarget> tests;
    private final Set<PluginlibExport> pluginlibExports;

    private final Map<String, String> singleValues = new LinkedHashMap<>();
    private final Map<String, String> singleValueOwners = new LinkedHashMap<>();
    private final List<String> conflictErrors = new ArrayList<>();
    private final Map<String, String> sourceOwners = new LinkedHashMap<>();

    public PackageBuild(final String packageName) {
        this.packageName = Objects.requireNonNull(packageName, "packageName");
        Supplier<String> none = () -> null;
        this.buildtoolDepends = new ValidatingStringSet("buildtoolDepends",
                PackageBuild::isValidIdentifier, "must be a valid ROS package name", none);
        this.depends = new ValidatingStringSet("depends",
                PackageBuild::isValidIdentifier, "must be a valid ROS package name", none);
        this.execDepends = new ValidatingStringSet("execDepends",
                PackageBuild::isValidIdentifier, "must be a valid ROS package name", none);
        this.testDepends = new ValidatingStringSet("testDepends",
                PackageBuild::isValidIdentifier, "must be a valid ROS package name", none);
        this.findPackages = new ValidatingStringSet("findPackages",
                PackageBuild::isValidIdentifier, "must be a valid CMake package name", none);
        this.installTargets = new ValidatingStringSet("installTargets",
                PackageBuild::isValidIdentifier, "must be a valid CMake target name", none);
        this.xmlExports = new ValidatingRuleSet<>(e -> validateXmlExport(e, currentPluginId()));
        this.pluginlibExports = new ValidatingRuleSet<>(e -> validatePluginlibExport(e, currentPluginId()));
        this.pythonPrograms = new ValidatingRuleList<>(p -> validatePythonProgram(p, currentPluginId()));
        this.installDirectories = new ValidatingRuleList<>(d -> validateInstallDirectory(d, currentPluginId()));
        this.installFiles = new ValidatingRuleList<>(f -> validateInstallFiles(f, currentPluginId()));
        this.tests = new ValidatingRuleList<>(t -> validateTestTarget(t, currentPluginId()));
    }

    public String currentPluginId() {
        return currentPluginId != null && !currentPluginId.isBlank() ? currentPluginId : "core";
    }

    public void setCurrentPluginId(final String currentPluginId) {
        this.currentPluginId = currentPluginId != null && !currentPluginId.isBlank() ? currentPluginId : "core";
    }

    private String resolveOwner(final String fallbackOwner) {
        if (currentPluginId != null && !"core".equals(currentPluginId)) {
            return currentPluginId;
        }
        if (fallbackOwner != null && !fallbackOwner.isBlank()) {
            return fallbackOwner;
        }
        return currentPluginId();
    }

    private void recordInvalidValueError(
            final String pluginId,
            final String fieldName,
            final String value,
            final String reason) {
        String owner = (pluginId != null && !pluginId.isBlank()) ? pluginId : "core";
        String preview = value == null ? "null" : value.replace("\r", "\\r").replace("\n", "\\n");
        conflictErrors.add("Invalid PackageBuild value from plugin '" + owner + "' in '" + fieldName
                + "' (" + reason + "): '" + preview + "'");
    }

    private boolean validateXmlExport(final XmlExportEntry entry, final String owner) {
        if (entry == null) {
            return false;
        }
        if (!isValidXmlName(entry.tagName())) {
            recordInvalidValueError(owner, "xmlExports.tagName", entry.tagName(), "must be a valid XML element name");
            return false;
        }
        for (Map.Entry<String, String> attr : entry.attributes().entrySet()) {
            if (!isValidXmlName(attr.getKey())) {
                recordInvalidValueError(owner, "xmlExports.attributeName", attr.getKey(),
                        "must be a valid XML attribute name");
                return false;
            }
            if (!isValidXmlText(attr.getValue())) {
                recordInvalidValueError(owner, "xmlExports.attributeValue", attr.getValue(),
                        "contains disallowed XML control characters");
                return false;
            }
        }
        if (!isValidXmlText(entry.textContent())) {
            recordInvalidValueError(owner, "xmlExports.textContent", entry.textContent(),
                    "contains disallowed XML control characters");
            return false;
        }
        return true;
    }

    private boolean validatePluginlibExport(final PluginlibExport exp, final String owner) {
        if (exp == null) {
            return false;
        }
        if (!isValidIdentifier(exp.basePackage())) {
            recordInvalidValueError(owner, "pluginlibExports.basePackage", exp.basePackage(),
                    "must be a valid package identifier");
            return false;
        }
        if (!isValidRelativeBuildPath(exp.descriptionFile())) {
            recordInvalidValueError(owner, "pluginlibExports.descriptionFile", exp.descriptionFile(),
                    "must be a safe relative file path without whitespace or '..'");
            return false;
        }
        return true;
    }

    private boolean validatePythonProgram(final PythonProgramInstall prog, final String owner) {
        if (prog == null) {
            return false;
        }
        if (!isValidRelativeBuildPath(prog.source())) {
            recordInvalidValueError(owner, "pythonPrograms.source", prog.source(),
                    "must be a safe relative file path without whitespace or '..'");
            return false;
        }
        if (!isValidRelativeBuildPath(prog.destination())) {
            recordInvalidValueError(owner, "pythonPrograms.destination", prog.destination(),
                    "must be a safe relative destination path without whitespace or '..'");
            return false;
        }
        if (prog.rename() != null && !prog.rename().isEmpty() && !isValidIdentifier(prog.rename())) {
            recordInvalidValueError(owner, "pythonPrograms.rename", prog.rename(),
                    "must be a valid executable name identifier");
            return false;
        }
        return true;
    }

    private boolean validateInstallDirectory(final InstallDirectoryRule rule, final String owner) {
        if (rule == null) {
            return false;
        }
        if (!isValidRelativeBuildPath(rule.directory())) {
            recordInvalidValueError(owner, "installDirectories.directory", rule.directory(),
                    "must be a safe relative directory path without whitespace or '..'");
            return false;
        }
        if (!isValidRelativeBuildPath(rule.destination())) {
            recordInvalidValueError(owner, "installDirectories.destination", rule.destination(),
                    "must be a safe relative destination path without whitespace or '..'");
            return false;
        }
        return true;
    }

    private boolean validateInstallFiles(final InstallFilesRule rule, final String owner) {
        if (rule == null || rule.files() == null || rule.files().isEmpty()) {
            return false;
        }
        for (String f : rule.files()) {
            if (!isValidRelativeBuildPath(f)) {
                recordInvalidValueError(owner, "installFiles.files", f,
                        "must be a safe relative file path without whitespace or '..'");
                return false;
            }
        }
        if (!isValidRelativeBuildPath(rule.destination())) {
            recordInvalidValueError(owner, "installFiles.destination", rule.destination(),
                    "must be a safe relative destination path without whitespace or '..'");
            return false;
        }
        return true;
    }

    private boolean validateTestTarget(final TestTarget test, final String owner) {
        if (test == null) {
            return false;
        }
        if (!isValidIdentifier(test.name())) {
            recordInvalidValueError(owner, "tests.name", test.name(), "must be a valid CMake target identifier");
            return false;
        }
        if (test.kind() != null && !test.kind().isEmpty() && !isValidIdentifier(test.kind())) {
            recordInvalidValueError(owner, "tests.kind", test.kind(), "must be a valid test runner identifier");
            return false;
        }
        if (test.sources() != null) {
            for (String src : test.sources()) {
                if (!isValidRelativeBuildPath(src)) {
                    recordInvalidValueError(owner, "tests.sources", src,
                            "must be a safe relative file path without whitespace or '..'");
                    return false;
                }
            }
        }
        if (test.linkLibraries() != null) {
            for (String lib : test.linkLibraries()) {
                if (!isValidLinkLibrary(lib)) {
                    recordInvalidValueError(owner, "tests.linkLibraries", lib,
                            "must be a valid CMake target or library name");
                    return false;
                }
            }
        }
        if (test.linkPackages() != null) {
            for (String pkg : test.linkPackages()) {
                if (!isValidIdentifier(pkg)) {
                    recordInvalidValueError(owner, "tests.linkPackages", pkg, "must be a valid package identifier");
                    return false;
                }
            }
        }
        return true;
    }

    public String packageName() { return packageName; }
    public boolean isPurePython() { return purePython; }
    public void setPurePython(final boolean purePython) { this.purePython = purePython; }
    public boolean isHybrid() { return hybrid; }
    public void setHybrid(final boolean hybrid) { this.hybrid = hybrid; }
    public String buildType() { return buildType; }

    public void setBuildType(final String buildType) {
        if (!isValidIdentifier(buildType)) {
            recordInvalidValueError(currentPluginId(), "buildType", buildType, "must be a valid build type identifier");
            return;
        }
        this.buildType = buildType;
    }

    public String description() { return description; }

    public void setDescription(final String description) {
        if (description == null || !isValidXmlText(description)) {
            recordInvalidValueError(currentPluginId(), "description", description,
                    "contains disallowed XML control characters");
            return;
        }
        this.description = description;
    }

    public boolean isIncludeHeaderInstall() { return includeHeaderInstall; }
    public void setIncludeHeaderInstall(final boolean includeHeaderInstall) { this.includeHeaderInstall = includeHeaderInstall; }

    public Set<String> buildtoolDepends() { return buildtoolDepends; }
    public Set<String> depends() { return depends; }
    public Set<String> execDepends() { return execDepends; }
    public Set<String> testDepends() { return testDepends; }
    public Set<XmlExportEntry> xmlExports() { return xmlExports; }
    public Set<String> findPackages() { return findPackages; }
    public Map<String, LibraryTarget> libraries() { return Collections.unmodifiableMap(libraries); }
    public Map<String, ExecutableTarget> executables() { return Collections.unmodifiableMap(executables); }
    public Set<String> installTargets() { return installTargets; }
    public List<PythonProgramInstall> pythonPrograms() { return pythonPrograms; }
    public List<InstallDirectoryRule> installDirectories() { return installDirectories; }
    public List<InstallFilesRule> installFiles() { return installFiles; }
    public List<TestTarget> tests() { return tests; }
    public Set<PluginlibExport> pluginlibExports() { return pluginlibExports; }
    public List<String> conflictErrors() { return Collections.unmodifiableList(conflictErrors); }

    public void addBuildtoolDepend(final String pkg) {
        if (pkg != null) {
            buildtoolDepends.add(pkg.trim());
        }
    }

    public void addDepend(final String pkg) {
        if (pkg != null) {
            depends.add(pkg.trim());
        }
    }

    public void addExecDepend(final String pkg) {
        if (pkg != null) {
            execDepends.add(pkg.trim());
        }
    }

    public void addTestDepend(final String pkg) {
        if (pkg != null) {
            testDepends.add(pkg.trim());
        }
    }

    public void addFindPackage(final String pkg) {
        if (pkg != null) {
            findPackages.add(pkg.trim());
        }
    }

    public void addXmlExport(final XmlExportEntry entry) {
        if (entry != null) {
            xmlExports.add(entry);
        }
    }

    public void addPluginlibExport(final String basePackage, final String descriptionFile) {
        if (basePackage == null || descriptionFile == null) {
            return;
        }
        pluginlibExports.add(new PluginlibExport(basePackage.trim(), descriptionFile.trim()));
    }

    /**
     * Gets or creates a library target, recording a conflict error naming both plugins if an
     * existing target has a different linkage type ({@code SHARED} vs {@code STATIC}), or a
     * validation error naming the plugin if {@code name} is invalid.
     */
    public LibraryTarget getOrCreateLibrary(final String name, final boolean shared, final String pluginId) {
        String owner = resolveOwner(pluginId);
        if (!isValidIdentifier(name)) {
            recordInvalidValueError(owner, "LibraryTarget.name", name, "must be a valid CMake target identifier");
            return new LibraryTarget(this, "invalid_target", shared, owner);
        }
        LibraryTarget existing = libraries.get(name);
        if (existing == null) {
            LibraryTarget created = new LibraryTarget(this, name, shared, owner);
            libraries.put(name, created);
            if (created.install()) {
                installTargets.add(name);
            }
            return created;
        }
        if (existing.shared() != shared) {
            String firstOwner = existing.ownerPluginId() != null ? existing.ownerPluginId() : "core";
            conflictErrors.add("Plugin conflict between '" + firstOwner + "' and '" + owner
                    + "' on library target '" + name + "': conflicting library linkage (shared="
                    + existing.shared() + " vs shared=" + shared + ")");
        }
        return existing;
    }

    /**
     * Adds a source file to a library target while validating the path and tracking ownership.
     */
    public void addLibrarySource(final LibraryTarget lib, final String sourcePath, final String pluginId) {
        if (lib == null || sourcePath == null) {
            return;
        }
        String norm = sourcePath.trim();
        String owner = resolveOwner(pluginId);
        if (!isValidRelativeBuildPath(norm)) {
            recordInvalidValueError(owner, "LibraryTarget.sources", sourcePath,
                    "must be a safe relative build path without whitespace or '..'");
            return;
        }
        lib.sources().add(norm);
        sourceOwners.putIfAbsent(norm, owner);
    }

    public ExecutableTarget getOrCreateExecutable(final String name, final String pluginId) {
        String owner = resolveOwner(pluginId);
        if (!isValidIdentifier(name)) {
            recordInvalidValueError(owner, "ExecutableTarget.name", name, "must be a valid CMake target identifier");
            return new ExecutableTarget(this, "invalid_executable", owner);
        }
        return executables.computeIfAbsent(name, n -> {
            ExecutableTarget created = new ExecutableTarget(this, n, owner);
            installTargets.add(n);
            return created;
        });
    }

    public void addPythonProgram(final String source, final String destination, final String rename) {
        PythonProgramInstall rule = new PythonProgramInstall(source, destination, rename);
        if (!pythonPrograms.contains(rule)) {
            pythonPrograms.add(rule);
        }
    }

    public void addInstallDirectory(final String dir, final String destination, final boolean optional) {
        InstallDirectoryRule rule = new InstallDirectoryRule(dir, destination, optional);
        if (!installDirectories.contains(rule)) {
            installDirectories.add(rule);
        }
    }

    public void addInstallFiles(final List<String> files, final String destination) {
        if (files == null || files.isEmpty()) {
            return;
        }
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
        String owner = resolveOwner(pluginId);
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
