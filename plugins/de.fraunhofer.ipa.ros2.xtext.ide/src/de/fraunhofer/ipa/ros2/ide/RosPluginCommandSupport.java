package de.fraunhofer.ipa.ros2.ide;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import de.fraunhofer.ipa.ros.generator.IPluginAwareGenerator;
import de.fraunhofer.ipa.ros.plugin.spi.BlockDescriptor;
import de.fraunhofer.ipa.ros.plugin.spi.ExtensionBlockMerger;
import de.fraunhofer.ipa.ros.plugin.spi.ExtensionSchemaMapper;
import de.fraunhofer.ipa.ros.plugin.spi.HookLocation;
import de.fraunhofer.ipa.ros.plugin.spi.PluginRegistry;
import de.fraunhofer.ipa.ros.plugin.spi.PluginToolDescriptor;
import de.fraunhofer.ipa.ros.plugin.spi.RosToolingPlugin;
import de.fraunhofer.ipa.ros.plugin.spi.ToolExecutionContext;
import de.fraunhofer.ipa.ros.plugin.spi.ToolResult;
import de.fraunhofer.ipa.ros.plugin.spi.ValidationIssue;
import de.fraunhofer.ipa.ros2.distro.Ros2Distro;
import de.fraunhofer.ipa.ros2.distro.Ros2Distros;
import de.fraunhofer.ipa.ros2.distro.UnknownDistroException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.generator.IGenerator2;
import org.eclipse.xtext.generator.InMemoryFileSystemAccess;
import org.eclipse.xtext.ide.server.ILanguageServerAccess;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.resource.impl.ChunkedResourceDescriptions;
import org.eclipse.xtext.resource.impl.ProjectDescription;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.workspace.ProjectConfigAdapter;
import ros.Artifact;
import ros.Extensible;
import ros.ExtensionBlock;
import ros.Node;
import ros.Plugin;

/**
 * Shared command execution helpers for Phase 2 plugin discovery, tool invocation,
 * {@code @<block>:} inspection/editing, and two-phase plugin output generation.
 */
public final class RosPluginCommandSupport {

    private RosPluginCommandSupport() {
    }

    public static String prefixedToolName(final String pluginId, final String toolName) {
        String safePrefix = pluginId == null
                ? "plugin"
                : pluginId.replaceAll("[^A-Za-z0-9_-]", "_");
        String safeTool = toolName == null
                ? "tool"
                : toolName.replaceAll("[^A-Za-z0-9_-]", "_");
        return safePrefix + "__" + safeTool;
    }

    public static Map<String, Object> listPluginTools() {
        PluginRegistry.INSTANCE.ensureLoadedFromEnvironment();
        List<Map<String, Object>> pluginsOut = new ArrayList<>();
        List<Map<String, Object>> toolsOut = new ArrayList<>();

        for (RosToolingPlugin plugin : PluginRegistry.INSTANCE.activePlugins()) {
            Map<String, Object> pMap = new LinkedHashMap<>();
            pMap.put("id", plugin.id());
            pMap.put("version", plugin.version());
            pMap.put("coreVersionRange", plugin.supportedCoreVersionRange());
            pMap.put("dependencies", plugin.dependencies());
            pMap.put("documentationMarkdown", plugin.documentationMarkdown() != null ? plugin.documentationMarkdown() : "");

            List<Map<String, Object>> blockList = new ArrayList<>();
            if (plugin.blocks() != null) {
                for (BlockDescriptor desc : plugin.blocks()) {
                    if (desc != null) {
                        Map<String, Object> bMap = new LinkedHashMap<>(ExtensionSchemaMapper.schemaToJsonMap(desc));
                        bMap.put("setToolName", prefixedToolName(plugin.id(), "set_" + desc.name()));
                        blockList.add(bMap);
                    }
                }
            }
            pMap.put("blocks", blockList);
            pluginsOut.add(pMap);

            if (plugin.tools() != null) {
                for (PluginToolDescriptor tool : plugin.tools()) {
                    if (tool == null) {
                        continue;
                    }
                    Map<String, Object> tMap = new LinkedHashMap<>();
                    tMap.put("pluginId", plugin.id());
                    tMap.put("name", tool.name());
                    tMap.put("prefixedName", prefixedToolName(plugin.id(), tool.name()));
                    tMap.put("description", tool.description());
                    tMap.put("inputSchema", tool.inputSchema());
                    toolsOut.add(tMap);
                }
            }
        }

        Map<String, Object> out = new LinkedHashMap<>();
        out.put("plugins", pluginsOut);
        out.put("tools", toolsOut);
        out.put("loadErrors", PluginRegistry.INSTANCE.loadErrors());
        return out;
    }

    public static List<Map<String, Object>> listDiscoveredPlugins() {
        try {
            PluginRegistry.INSTANCE.ensureLoadedFromEnvironment();
            List<Map<String, Object>> out = new ArrayList<>();
            for (PluginRegistry.DiscoveredPlugin dp : PluginRegistry.INSTANCE.discoveredPlugins()) {
                Map<String, Object> entry = new LinkedHashMap<>();
                entry.put("id", dp.id());
                entry.put("version", dp.version());
                entry.put("summary", dp.summary());
                entry.put("supportedCoreVersionRange", dp.supportedCoreVersionRange());
                entry.put("compatible", dp.compatible());
                entry.put("enabled", dp.enabled());
                entry.put("active", dp.active());
                entry.put("sourceJarPath", dp.sourceJarPath());
                entry.put("loadError", dp.loadError());
                out.add(entry);
            }
            return out;
        } catch (Throwable ignored) {
            return List.of();
        }
    }

    public static Map<String, Object> getPluginDocumentation(final String pluginId) {
        String id = pluginId == null ? "" : pluginId;
        String md = "";
        try {
            md = PluginRegistry.INSTANCE.documentationMarkdownFor(id);
        } catch (Throwable ignored) {
            md = "";
        }
        Map<String, Object> out = new LinkedHashMap<>();
        out.put("id", id);
        out.put("documentationMarkdown", md != null ? md : "");
        return out;
    }

    public static Map<String, Object> executePluginTool(
            final Map<String, Object> req,
            final ILanguageServerAccess access,
            final IResourceServiceProvider.Registry rspRegistry) {
        PluginRegistry.INSTANCE.ensureLoadedFromEnvironment();
        String pluginId = stringField(req, "pluginId");
        String toolName = stringField(req, "toolName");
        String prefixedName = stringField(req, "prefixedName");
        if (toolName == null || toolName.isBlank()) {
            toolName = prefixedName;
        }

        PluginToolDescriptor matchedTool = findTool(pluginId, toolName, prefixedName);
        if (matchedTool == null) {
            return Map.of("success", false, "error", "Unknown or inactive plugin tool: "
                    + (prefixedName != null ? prefixedName : toolName));
        }

        String fileUri = firstNonBlank(stringField(req, "fileUri"), stringField(req, "modelUri"));
        String modelPath = stringField(req, "modelPath");
        if (modelPath == null && fileUri != null && fileUri.startsWith("file:")) {
            try {
                modelPath = Path.of(java.net.URI.create(fileUri)).toString();
            } catch (Exception ignored) {
            }
        }
        String modelText = stringField(req, "modelText");
        Map<String, Object> toolArgs = mapField(req, "arguments");
        final String finalModelPath = modelPath;
        final String finalModelText = modelText;

        if (fileUri != null && !fileUri.isBlank() && access != null && (finalModelText == null || finalModelText.isBlank())) {
            try {
                return access.doRead(fileUri, (context) -> {
                    Resource res = context.getResource();
                    EcoreUtil.resolveAll(res);
                    String txt = extractResourceText(res, finalModelPath);
                    ToolExecutionContext execCtx = new ToolExecutionContext(res, finalModelPath, txt, toolArgs);
                    ToolResult result = matchedTool.handler().execute(execCtx);
                    return formatToolResult(result, fileUri);
                }).get();
            } catch (Exception e) {
                return Map.of("success", false, "error", "Tool execution failed: " + e.getMessage());
            }
        }

        Resource standaloneRes = null;
        if ((fileUri != null && !fileUri.isBlank()) || (finalModelText != null && !finalModelText.isBlank())) {
            try {
                standaloneRes = loadStandaloneResource(fileUri, finalModelPath, finalModelText, rspRegistry);
            } catch (Exception e) {
                return Map.of("success", false, "error", "Failed to load model: " + e.getMessage());
            }
        }
        String txt = finalModelText != null ? finalModelText : extractResourceText(standaloneRes, finalModelPath);
        ToolExecutionContext execCtx = new ToolExecutionContext(standaloneRes, finalModelPath, txt, toolArgs);
        ToolResult result = matchedTool.handler().execute(execCtx);
        return formatToolResult(result, fileUri);
    }

    public static Map<String, Object> getExtensionBlock(
            final Map<String, Object> req,
            final ILanguageServerAccess access,
            final IResourceServiceProvider.Registry rspRegistry) {
        PluginRegistry.INSTANCE.ensureLoadedFromEnvironment();
        String blockName = normalizeBlockName(stringField(req, "blockName"));
        if (blockName == null || blockName.isBlank()) {
            return Map.of("success", false, "error", "blockName is required");
        }
        String targetKind = stringField(req, "targetKind");
        String targetName = stringField(req, "targetName");
        String artifactName = stringField(req, "artifactName");
        boolean merged = Boolean.TRUE.equals(req.get("merged"));
        String fileUri = firstNonBlank(stringField(req, "fileUri"), stringField(req, "modelUri"));
        String modelPath = stringField(req, "modelPath");
        String modelText = stringField(req, "modelText");

        Function<Resource, Map<String, Object>> inspector = (res) -> {
            EcoreUtil.resolveAll(res);
            Extensible target = findTargetExtensible(res, targetKind, targetName, artifactName);
            if (target == null) {
                return Map.of("success", false, "error", "Target element not found (" + targetKind + ":" + targetName + ")");
            }
            BlockDescriptor desc = PluginRegistry.INSTANCE.blockDescriptor(blockName);
            List<String> mergeConflicts = new ArrayList<>();
            ExtensionBlock block;
            if (merged) {
                Extensible typeHolder = resolveTypeOrigin(target);
                ExtensionBlockMerger.MergeResult mergeRes = ExtensionBlockMerger.mergeWithConflicts(
                        typeHolder, target, blockName, desc);
                block = mergeRes.mergedBlock();
                mergeConflicts.addAll(mergeRes.conflictErrors());
            } else {
                block = ExtensionBlockMerger.findBlock(target, blockName);
            }
            Map<String, Object> entries = block != null
                    ? ExtensionSchemaMapper.blockToMap(block)
                    : Map.of();
            List<Map<String, Object>> issues = new ArrayList<>();
            if (block != null && desc != null && !merged) {
                for (ValidationIssue vi : ExtensionSchemaMapper.validateBlock(block, desc, target)) {
                    Map<String, Object> im = new LinkedHashMap<>();
                    im.put("severity", vi.severity().name());
                    im.put("message", vi.message());
                    im.put("code", vi.code());
                    issues.add(im);
                }
            }
            Map<String, Object> result = new LinkedHashMap<>();
            result.put("success", true);
            result.put("found", block != null);
            result.put("blockName", blockName);
            result.put("targetKind", hookKindName(target));
            result.put("targetName", readName(target));
            result.put("entries", entries);
            result.put("schema", desc != null ? ExtensionSchemaMapper.schemaToJsonMap(desc) : Map.of());
            result.put("validationIssues", issues);
            result.put("mergeConflicts", mergeConflicts);
            return result;
        };

        return withResource(fileUri, modelPath, modelText, access, rspRegistry, inspector);
    }

    public static Map<String, Object> setExtensionBlock(
            final Map<String, Object> req,
            final ILanguageServerAccess access,
            final IResourceServiceProvider.Registry rspRegistry) {
        PluginRegistry.INSTANCE.ensureLoadedFromEnvironment();
        String blockName = normalizeBlockName(stringField(req, "blockName"));
        if (blockName == null || blockName.isBlank()) {
            return Map.of("success", false, "error", "blockName is required");
        }
        String targetKind = stringField(req, "targetKind");
        String targetName = stringField(req, "targetName");
        String artifactName = stringField(req, "artifactName");
        boolean remove = Boolean.TRUE.equals(req.get("remove"));
        Map<String, Object> entries = mapField(req, "entries");
        String fileUri = firstNonBlank(stringField(req, "fileUri"), stringField(req, "modelUri"));
        String modelPath = stringField(req, "modelPath");
        String modelText = stringField(req, "modelText");

        Function<Resource, Map<String, Object>> mutator = (res) -> {
            EcoreUtil.resolveAll(res);
            String currentText = modelText != null ? modelText : extractResourceText(res, modelPath);
            if (currentText == null) {
                return Map.of("success", false, "error", "Could not read source text for target resource");
            }
            Extensible target = findTargetExtensible(res, targetKind, targetName, artifactName);
            if (target == null) {
                return Map.of("success", false, "error", "Target element not found (" + targetKind + ":" + targetName + ")");
            }
            BlockDescriptor desc = PluginRegistry.INSTANCE.blockDescriptor(blockName);
            if (desc != null && !remove) {
                HookLocation loc = HookLocation.fromElement(target);
                if (!desc.allowedLocations().isEmpty() && (loc == null || !desc.allowedLocations().contains(loc))) {
                    return Map.of("success", false, "error",
                            "Extension block '@" + blockName + "' is not allowed on "
                                    + (loc != null ? loc.label() : target.eClass().getName()));
                }
            }

            ExtensionBlock existing = ExtensionBlockMerger.findBlock(target, blockName);
            String dslBlock = "";
            String updatedText;
            if (remove) {
                if (existing == null) {
                    return Map.of("success", true, "updatedText", currentText, "dslBlock", "",
                            "errors", List.of(), "warnings", List.of());
                }
                ICompositeNode oldComp = NodeModelUtils.findActualNodeFor(existing);
                if (oldComp == null) {
                    return Map.of("success", false, "error", "Cannot locate AST span for @" + blockName);
                }
                int[] span = computeLineDeletionSpan(currentText, oldComp);
                updatedText = currentText.substring(0, span[0]) + currentText.substring(span[1]);
            } else {
                ExtensionBlock newBlock = ExtensionSchemaMapper.fromMap(
                        blockName, entries, desc, res.getResourceSet());
                String indent = determineBlockIndent(currentText, target, existing);
                dslBlock = stripTrailingNewline(ExtensionSchemaMapper.renderBlockDsl(newBlock, indent));

                if (existing != null && NodeModelUtils.findActualNodeFor(existing) != null) {
                    ICompositeNode oldComp = NodeModelUtils.findActualNodeFor(existing);
                    int start = lineStartOf(currentText, firstNonHiddenOffset(oldComp));
                    int end = findLineEndOffsetWithoutNewline(currentText, lastNonHiddenOffset(oldComp));
                    updatedText = currentText.substring(0, start) + dslBlock + currentText.substring(end);
                } else {
                    int insertPos = findExtensionInsertOffset(currentText, target);
                    updatedText = currentText.substring(0, insertPos) + "\n" + dslBlock + currentText.substring(insertPos);
                }
            }

            // Re-parse and validate the updated text in an isolated ResourceSet so all diagnostics reflect the edit.
            List<String> errors = new ArrayList<>();
            List<String> warnings = new ArrayList<>();
            validateUpdatedText(res, updatedText, rspRegistry, errors, warnings);

            Map<String, Object> result = new LinkedHashMap<>();
            result.put("success", errors.isEmpty());
            result.put("updatedText", updatedText);
            result.put("dslBlock", dslBlock);
            result.put("errors", errors);
            result.put("warnings", warnings);
            if (!errors.isEmpty()) {
                result.put("error", String.join("; ", errors));
            }
            return result;
        };

        return withResource(fileUri, modelPath, modelText, access, rspRegistry, mutator);
    }

    public static Map<String, Object> generatePluginOutputs(
            final Map<String, Object> req,
            final ILanguageServerAccess access,
            final IResourceServiceProvider.Registry rspRegistry,
            final CancelIndicator cancelIndicator) {
        PluginRegistry.INSTANCE.ensureLoadedFromEnvironment();
        String fileUri = firstNonBlank(stringField(req, "fileUri"), stringField(req, "modelUri"));
        if (fileUri == null || fileUri.isBlank()) {
            return Map.of("error", "fileUri is required");
        }
        String modelPath = stringField(req, "modelPath");
        String modelText = stringField(req, "modelText");
        List<String> targetNodes = stringListField(req, "targetNodes");
        String language = firstNonBlank(stringField(req, "language"), "both");
        String distroArg = firstNonBlank(stringField(req, "distro"), Ros2Distros.AUTO);
        List<String> existingFiles = stringListField(req, "existingFiles");
        String outputRootStr = stringField(req, "outputRoot");
        final Path outputRoot;
        try {
            outputRoot = (outputRootStr != null && !outputRootStr.isBlank()) ? Path.of(outputRootStr.trim()) : null;
        } catch (Exception e) {
            return Map.of("error", "Invalid outputRoot path: " + e.getMessage());
        }

        final Ros2Distro resolvedDistro;
        try {
            resolvedDistro = Ros2Distros.resolve(distroArg);
        } catch (UnknownDistroException e) {
            return Map.of("error", e.getMessage());
        }

        Function<Resource, Map<String, Object>> generatorFn = (res) -> {
            EcoreUtil.resolveAll(res);
            URI uri = res.getURI();
            IResourceServiceProvider rsp = rspRegistry.getResourceServiceProvider(uri);
            if (rsp == null) {
                return Map.of("error", "No resource service provider registered for " + uri);
            }
            IResourceValidator validator = rsp.getResourceValidator();
            if (validator != null) {
                List<Issue> issues = validator.validate(
                        res, CheckMode.ALL, cancelIndicator != null ? cancelIndicator : CancelIndicator.NullImpl);
                List<Issue> errors = issues.stream()
                        .filter(i -> i.getSeverity() == Severity.ERROR)
                        .toList();
                if (!errors.isEmpty()) {
                    String errMsg = errors.stream()
                            .map(i -> "Line " + i.getLineNumber() + ": " + i.getMessage())
                            .collect(Collectors.joining("; "));
                    return Map.of("error", "Cannot generate code: model has validation errors: " + errMsg);
                }
            }

            IGenerator2 gen = rsp.get(IGenerator2.class);
            if (!(gen instanceof IPluginAwareGenerator pluginGen)) {
                return Map.of("error", "Plugin-aware generation is only supported for .ros2 and .rossystem resources");
            }

            InMemoryFileSystemAccess fsa = new InMemoryFileSystemAccess();
            IPluginAwareGenerator.Outcome outcome = pluginGen.generateWithPlugins(
                    res, fsa, targetNodes, language, resolvedDistro.name(), existingFiles, outputRoot);

            boolean hasErrors = !outcome.errors.isEmpty();
            Map<String, String> allFiles = hasErrors
                    ? Map.of()
                    : fsa.getAllFiles().entrySet().stream()
                            .collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().toString()));

            Map<String, Object> out = new LinkedHashMap<>();
            out.put("success", !hasErrors);
            out.put("files", allFiles);
            out.put("coreFiles", hasErrors ? Map.of() : outcome.coreFiles);
            out.put("pluginFiles", hasErrors ? Map.of() : outcome.pluginFiles);
            out.put("prunedFiles", hasErrors ? List.of() : new ArrayList<>(outcome.pluginDeletedFiles));
            out.put("errors", outcome.errors);
            out.put("conflictErrors", outcome.pluginConflictErrors);
            out.put("warnings", hasErrors ? List.of() : outcome.warnings);
            out.put("notices", outcome.notices);
            out.put("distro", resolvedDistro.name());
            out.put("count", allFiles.size());
            if (hasErrors) {
                out.put("error", String.join("; ", outcome.errors));
            }
            return out;
        };

        return withResource(fileUri, modelPath, modelText, access, rspRegistry, generatorFn);
    }

    private static Map<String, Object> withResource(
            final String fileUri,
            final String modelPath,
            final String modelText,
            final ILanguageServerAccess access,
            final IResourceServiceProvider.Registry rspRegistry,
            final Function<Resource, Map<String, Object>> fn) {
        if (fileUri != null && !fileUri.isBlank() && access != null && (modelText == null || modelText.isBlank())) {
            try {
                return access.doRead(fileUri, (context) -> fn.apply(context.getResource())).get();
            } catch (Exception e) {
                return Map.of("success", false, "error", "Failed to read resource '" + fileUri + "': " + e.getMessage());
            }
        }
        try {
            Resource res = loadStandaloneResource(fileUri, modelPath, modelText, rspRegistry);
            return fn.apply(res);
        } catch (Exception e) {
            return Map.of("success", false, "error", "Failed to load model: " + e.getMessage());
        }
    }

    private static Resource loadStandaloneResource(
            final String fileUri,
            final String modelPath,
            final String modelText,
            final IResourceServiceProvider.Registry rspRegistry) throws IOException {
        URI uri;
        if (fileUri != null && !fileUri.isBlank()) {
            uri = URI.createURI(fileUri);
        } else if (modelPath != null && !modelPath.isBlank()) {
            uri = URI.createFileURI(modelPath);
        } else {
            uri = URI.createURI("inmemory:/model.ros2");
        }
        IResourceServiceProvider rsp = rspRegistry.getResourceServiceProvider(uri);
        XtextResourceSet rs = rsp != null ? rsp.get(XtextResourceSet.class) : new XtextResourceSet();
        Resource res = rs.createResource(uri);
        String text = modelText;
        if ((text == null || text.isBlank()) && uri.isFile()) {
            text = Files.readString(Path.of(uri.toFileString()), StandardCharsets.UTF_8);
        } else if ((text == null || text.isBlank()) && modelPath != null && !modelPath.isBlank()) {
            text = Files.readString(Path.of(modelPath), StandardCharsets.UTF_8);
        }
        if (text != null) {
            res.load(new ByteArrayInputStream(text.getBytes(StandardCharsets.UTF_8)), Map.of());
        } else {
            res.load(Map.of());
        }
        EcoreUtil.resolveAll(rs);
        return res;
    }

    private static void validateUpdatedText(
            final Resource originalResource,
            final String updatedText,
            final IResourceServiceProvider.Registry rspRegistry,
            final List<String> errors,
            final List<String> warnings) {
        try {
            URI uri = originalResource.getURI();
            IResourceServiceProvider rsp = rspRegistry.getResourceServiceProvider(uri);
            if (rsp == null) {
                return;
            }
            XtextResourceSet checkRs = rsp.get(XtextResourceSet.class);
            ResourceSet origRs = originalResource.getResourceSet();
            if (origRs != null) {
                checkRs.getLoadOptions().putAll(origRs.getLoadOptions());
                ProjectDescription origProj = ProjectDescription.findInEmfObject(origRs);
                if (origProj != null && ProjectDescription.findInEmfObject(checkRs) == null) {
                    ProjectDescription projCopy = new ProjectDescription();
                    projCopy.setName(origProj.getName());
                    projCopy.setDependencies(new ArrayList<>(origProj.getDependencies()));
                    projCopy.attachToEmfObject(checkRs);
                }
                ProjectConfigAdapter origCfg = ProjectConfigAdapter.findInEmfObject(origRs);
                if (origCfg != null && ProjectConfigAdapter.findInEmfObject(checkRs) == null) {
                    ProjectConfigAdapter.install(checkRs, origCfg.getProjectConfig());
                }
                ChunkedResourceDescriptions origIndex = ChunkedResourceDescriptions.findInEmfObject(origRs);
                if (origIndex != null && ChunkedResourceDescriptions.findInEmfObject(checkRs) == null) {
                    origIndex.createShallowCopyWith(checkRs);
                }
                for (Resource sibling : new ArrayList<>(origRs.getResources())) {
                    if (sibling == originalResource || sibling.getURI() == null) {
                        continue;
                    }
                    String siblingText = extractResourceText(sibling, null);
                    if (siblingText != null) {
                        Resource copy = checkRs.createResource(sibling.getURI());
                        copy.load(new ByteArrayInputStream(siblingText.getBytes(StandardCharsets.UTF_8)), Map.of());
                    }
                }
            }
            Resource updatedRes = checkRs.createResource(uri);
            updatedRes.load(new ByteArrayInputStream(updatedText.getBytes(StandardCharsets.UTF_8)), Map.of());
            EcoreUtil.resolveAll(checkRs);

            IResourceValidator validator = rsp.getResourceValidator();
            if (validator != null) {
                for (Issue issue : validator.validate(updatedRes, CheckMode.ALL, CancelIndicator.NullImpl)) {
                    String formatted = "Line " + issue.getLineNumber() + ": " + issue.getMessage();
                    if (issue.getSeverity() == Severity.ERROR) {
                        errors.add(formatted);
                    } else if (issue.getSeverity() == Severity.WARNING) {
                        warnings.add(formatted);
                    }
                }
            }
        } catch (Exception e) {
            errors.add("Validation failed: " + e.getMessage());
        }
    }

    private static PluginToolDescriptor findTool(
            final String pluginId,
            final String toolName,
            final String prefixedName) {
        for (RosToolingPlugin plugin : PluginRegistry.INSTANCE.activePlugins()) {
            if (plugin.tools() == null) {
                continue;
            }
            if (pluginId != null && !pluginId.isBlank() && !pluginId.equals(plugin.id())) {
                continue;
            }
            for (PluginToolDescriptor tool : plugin.tools()) {
                if (tool == null) {
                    continue;
                }
                if ((prefixedName != null && prefixedName.equals(prefixedToolName(plugin.id(), tool.name())))
                        || (toolName != null && (toolName.equals(tool.name())
                        || toolName.equals(prefixedToolName(plugin.id(), tool.name()))))) {
                    return tool;
                }
            }
        }
        return null;
    }

    private static Extensible findTargetExtensible(
            final Resource resource,
            final String targetKind,
            final String targetName,
            final String artifactName) {
        if (resource == null || resource.getContents().isEmpty()) {
            return null;
        }
        String kindNorm = targetKind != null ? targetKind.trim().toLowerCase() : "";
        List<Extensible> all = new ArrayList<>();
        var it = resource.getAllContents();
        while (it.hasNext()) {
            EObject obj = it.next();
            if (obj instanceof Extensible ext) {
                all.add(ext);
            }
        }
        for (Extensible ext : all) {
            String ek = hookKindName(ext).toLowerCase();
            if (!kindNorm.isEmpty() && !kindNorm.equals(ek)) {
                continue;
            }
            if (targetName == null || targetName.isBlank()) {
                return ext;
            }
            String name = readName(ext);
            if ("rosinterface".equals(ek) && targetName.contains("::")) {
                String ownerName = readName(ext.eContainer());
                if ((ownerName + "::" + name).equals(targetName)) {
                    return ext;
                }
            }
            if (targetName.equals(name)) {
                if (artifactName != null && !artifactName.isBlank() && ext.eContainer() instanceof Artifact art) {
                    if (!artifactName.equals(art.getName())) {
                        continue;
                    }
                }
                return ext;
            }
        }
        return null;
    }

    private static Extensible resolveTypeOrigin(final Extensible target) {
        EStructuralFeature fromFeat = target.eClass().getEStructuralFeature("from");
        if (fromFeat != null) {
            Object val = target.eGet(fromFeat);
            if (val instanceof Extensible ext) {
                if (ext.eIsProxy()) {
                    EObject resolved = EcoreUtil.resolve(ext, target);
                    return resolved instanceof Extensible r ? r : null;
                }
                return ext;
            }
        }
        return null;
    }

    private static String hookKindName(final EObject obj) {
        HookLocation loc = HookLocation.fromElement(obj);
        return loc != null ? loc.label() : obj.eClass().getName();
    }

    private static String readName(final EObject obj) {
        if (obj == null) {
            return "";
        }
        EStructuralFeature feat = obj.eClass().getEStructuralFeature("name");
        Object v = feat != null ? obj.eGet(feat) : null;
        return v != null ? String.valueOf(v) : "";
    }

    private static String normalizeBlockName(final String raw) {
        if (raw == null) {
            return null;
        }
        String t = raw.trim();
        if (t.startsWith("@")) {
            t = t.substring(1);
        }
        if (t.endsWith(":")) {
            t = t.substring(0, t.length() - 1);
        }
        return t.trim();
    }

    private static String determineBlockIndent(
            final String text,
            final Extensible target,
            final ExtensionBlock existing) {
        if (existing != null && NodeModelUtils.findActualNodeFor(existing) != null) {
            int offset = firstNonHiddenOffset(NodeModelUtils.findActualNodeFor(existing));
            return " ".repeat(Math.max(0, offset - lineStartOf(text, offset)));
        }
        ICompositeNode comp = NodeModelUtils.findActualNodeFor(target);
        if (comp == null) {
            return "  ";
        }
        int offset = firstNonHiddenOffset(comp);
        int col = Math.max(0, offset - lineStartOf(text, offset));
        if (target instanceof Node) {
            // Ros2.xtext Node fields/sections share the 'node:' line's column.
            return " ".repeat(col);
        }
        return " ".repeat(col + 2);
    }

    private static int findExtensionInsertOffset(final String text, final Extensible target) {
        List<ExtensionBlock> existingBlocks = target.getExtensions();
        for (int i = existingBlocks.size() - 1; i >= 0; i--) {
            ICompositeNode bc = NodeModelUtils.findActualNodeFor(existingBlocks.get(i));
            if (bc != null) {
                return findLineEndOffsetWithoutNewline(text, lastNonHiddenOffset(bc));
            }
        }
        ICompositeNode comp = NodeModelUtils.findActualNodeFor(target);
        if (comp == null) {
            return text.length();
        }
        if (target instanceof ros.InterfaceHolder holder && !holder.getExtensions().isEmpty()) {
            // Covered above
        }
        return findLineEndOffsetWithoutNewline(text, lastNonHiddenOffset(comp));
    }

    private static int firstNonHiddenOffset(final org.eclipse.xtext.nodemodel.INode node) {
        for (ILeafNode leaf : node.getLeafNodes()) {
            if (!leaf.isHidden()) {
                return leaf.getOffset();
            }
        }
        return node.getOffset();
    }

    private static int lastNonHiddenOffset(final org.eclipse.xtext.nodemodel.INode node) {
        int end = -1;
        for (ILeafNode leaf : node.getLeafNodes()) {
            if (!leaf.isHidden() && leaf.getLength() > 0) {
                end = leaf.getEndOffset();
            }
        }
        return end >= 0 ? end : node.getEndOffset();
    }

    private static int lineStartOf(final String text, final int offset) {
        int i = Math.min(Math.max(0, offset), text.length());
        while (i > 0 && text.charAt(i - 1) != '\n' && text.charAt(i - 1) != '\r') {
            i--;
        }
        return i;
    }

    private static int findLineEndOffsetWithoutNewline(final String text, final int offset) {
        int i = Math.min(Math.max(0, offset), text.length());
        while (i < text.length() && text.charAt(i) != '\n' && text.charAt(i) != '\r') {
            i++;
        }
        return i;
    }

    private static int[] computeLineDeletionSpan(final String text, final ICompositeNode comp) {
        int start = lineStartOf(text, firstNonHiddenOffset(comp));
        int end = findLineEndOffsetWithoutNewline(text, lastNonHiddenOffset(comp));
        if (end < text.length() && text.charAt(end) == '\r') {
            end++;
        }
        if (end < text.length() && text.charAt(end) == '\n') {
            end++;
        } else if (start > 0 && text.charAt(start - 1) == '\n') {
            start--;
        }
        return new int[] { start, end };
    }

    private static String stripTrailingNewline(final String s) {
        if (s == null) {
            return "";
        }
        int end = s.length();
        while (end > 0 && (s.charAt(end - 1) == '\n' || s.charAt(end - 1) == '\r')) {
            end--;
        }
        return s.substring(0, end);
    }

    private static String extractResourceText(final Resource res, final String fallbackPath) {
        if (res instanceof XtextResource xr && xr.getParseResult() != null && xr.getParseResult().getRootNode() != null) {
            return xr.getParseResult().getRootNode().getText();
        }
        if (fallbackPath != null && !fallbackPath.isBlank()) {
            try {
                return Files.readString(Path.of(fallbackPath), StandardCharsets.UTF_8);
            } catch (IOException ignored) {
            }
        }
        return null;
    }

    private static Map<String, Object> formatToolResult(final ToolResult res, final String fileUri) {
        Map<String, Object> out = new LinkedHashMap<>();
        out.put("success", res.success());
        out.put("message", res.message());
        out.put("updatedText", res.updatedText());
        out.put("data", res.data());
        out.put("errors", res.errors());
        if (fileUri != null) {
            out.put("fileUri", fileUri);
        }
        return out;
    }

    public static Map<String, Object> toJavaMap(final Object arg) {
        if (arg == null) {
            return Map.of();
        }
        Object converted = toJavaValue(arg);
        if (converted instanceof Map<?, ?> m) {
            Map<String, Object> out = new LinkedHashMap<>();
            for (Map.Entry<?, ?> e : m.entrySet()) {
                out.put(String.valueOf(e.getKey()), e.getValue());
            }
            return out;
        }
        return Map.of();
    }

    private static Object toJavaValue(final Object arg) {
        if (arg == null || arg instanceof JsonNull) {
            return null;
        }
        if (arg instanceof JsonObject obj) {
            Map<String, Object> map = new LinkedHashMap<>();
            for (Map.Entry<String, JsonElement> e : obj.entrySet()) {
                map.put(e.getKey(), toJavaValue(e.getValue()));
            }
            return map;
        }
        if (arg instanceof JsonArray arr) {
            List<Object> list = new ArrayList<>();
            for (JsonElement el : arr) {
                list.add(toJavaValue(el));
            }
            return list;
        }
        if (arg instanceof JsonPrimitive prim) {
            if (prim.isBoolean()) {
                return prim.getAsBoolean();
            }
            if (prim.isNumber()) {
                String raw = prim.getAsString();
                if (!raw.contains(".") && !raw.contains("e") && !raw.contains("E")) {
                    try {
                        long lv = Long.parseLong(raw);
                        if (lv >= Integer.MIN_VALUE && lv <= Integer.MAX_VALUE) {
                            return (int) lv;
                        }
                        return lv;
                    } catch (NumberFormatException ignored) {
                    }
                }
                return prim.getAsDouble();
            }
            return prim.getAsString();
        }
        if (arg instanceof Map<?, ?> m) {
            Map<String, Object> map = new LinkedHashMap<>();
            for (Map.Entry<?, ?> e : m.entrySet()) {
                map.put(String.valueOf(e.getKey()), toJavaValue(e.getValue()));
            }
            return map;
        }
        if (arg instanceof List<?> l) {
            List<Object> list = new ArrayList<>();
            for (Object item : l) {
                list.add(toJavaValue(item));
            }
            return list;
        }
        return arg;
    }

    private static String stringField(final Map<String, Object> map, final String key) {
        Object val = map.get(key);
        return val != null ? String.valueOf(val) : null;
    }

    @SuppressWarnings("unchecked")
    private static Map<String, Object> mapField(final Map<String, Object> map, final String key) {
        Object val = map.get(key);
        if (val instanceof Map<?, ?> m) {
            Map<String, Object> out = new LinkedHashMap<>();
            for (Map.Entry<?, ?> e : m.entrySet()) {
                out.put(String.valueOf(e.getKey()), e.getValue());
            }
            return out;
        }
        return Map.of();
    }

    private static List<String> stringListField(final Map<String, Object> map, final String key) {
        Object val = map.get(key);
        List<String> out = new ArrayList<>();
        if (val instanceof List<?> list) {
            for (Object item : list) {
                if (item != null) {
                    out.add(String.valueOf(item));
                }
            }
        }
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
