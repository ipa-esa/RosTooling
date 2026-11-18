package de.fraunhofer.ipa.ros.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.google.inject.Guice;
import com.google.inject.Injector;
import de.fraunhofer.ipa.ros.BasicsStandaloneSetup;
import de.fraunhofer.ipa.ros.RosStandaloneSetup;
import de.fraunhofer.ipa.ros.documentation.RosExtensionDocumentationProvider;
import de.fraunhofer.ipa.ros.ide.contentassist.RosExtensionIdeContentProposalProvider;
import de.fraunhofer.ipa.ros.linking.RosLinkingDiagnosticMessageProvider;
import de.fraunhofer.ipa.ros.plugin.spi.BlockDescriptor;
import de.fraunhofer.ipa.ros.plugin.spi.ExtensionBlockMerger;
import de.fraunhofer.ipa.ros.plugin.spi.ExtensionSchemaMapper;
import de.fraunhofer.ipa.ros.plugin.spi.GenerationContext;
import de.fraunhofer.ipa.ros.plugin.spi.HookLocation;
import de.fraunhofer.ipa.ros.plugin.spi.MergeStrategy;
import de.fraunhofer.ipa.ros.plugin.spi.PackageBuild;
import de.fraunhofer.ipa.ros.plugin.spi.PackageGenerationContext;
import de.fraunhofer.ipa.ros.plugin.spi.PluginRegistry;
import de.fraunhofer.ipa.ros.plugin.spi.PluginToolDescriptor;
import de.fraunhofer.ipa.ros.plugin.spi.RosToolingPlugin;
import de.fraunhofer.ipa.ros.plugin.spi.SystemGenerationContext;
import de.fraunhofer.ipa.ros.plugin.spi.ToolResult;
import de.fraunhofer.ipa.ros.plugin.spi.ValidationContext;
import de.fraunhofer.ipa.ros.validation.BasicsValidator;
import de.fraunhofer.ipa.ros2.Ros2RuntimeModule;
import de.fraunhofer.ipa.ros2.Ros2StandaloneSetup;
import de.fraunhofer.ipa.ros2.distro.Ros2Distro;
import de.fraunhofer.ipa.ros2.distro.Ros2Distros;
import de.fraunhofer.ipa.ros2.generator.Ros2Generator;
import de.fraunhofer.ipa.ros2.ide.Ros2GeneratorCommandService;
import de.fraunhofer.ipa.ros2.ide.Ros2IdeSetup;
import de.fraunhofer.ipa.ros2.ide.RosPluginCommandSupport;
import de.fraunhofer.ipa.rossystem.RosSystemRuntimeModule;
import de.fraunhofer.ipa.rossystem.RosSystemStandaloneSetup;
import de.fraunhofer.ipa.rossystem.generator.RosSystemGenerator;
import de.fraunhofer.ipa.rossystem.validation.RosSystemValidator;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;
import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceRegistration;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.lsp4j.ExecuteCommandParams;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider;
import org.eclipse.xtext.generator.InMemoryFileSystemAccess;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ros.AmentPackage;
import ros.ExtensionBlock;
import ros.Node;
import ros.Plugin;
import ros.PluginLoader;
import ros.RosPackage;
import system.RosNode;

/**
 * Phase 2 verification tests: custom plugin SPI registration, Ecore schema validation,
 * {@code toTypedObject}/{@code fromMap}/{@code blockToMap}/{@code renderBlockDsl}, hover and
 * completion, two-phase {@link PackageBuild} & {@link GenerationContext} generation, multi-plugin
 * merging and conflict detection, LSP commands, and unknown {@code @} block degradation.
 */
public class PluginArchitecturePhase2Test {

    private Injector ros2Injector;
    private Injector rosSystemInjector;
    private Injector ros2IdeInjector;

    @Before
    public void setUp() {
        PluginRegistry.INSTANCE.clearRegistered();
        BasicsStandaloneSetup.doSetup();
        RosStandaloneSetup.doSetup();
        ros2Injector = new Ros2StandaloneSetup() {
            @Override
            public Injector createInjector() {
                return Guice.createInjector(new Ros2RuntimeModule() {
                    @Override
                    public ClassLoader bindClassLoaderToInstance() {
                        return PluginArchitecturePhase2Test.class.getClassLoader();
                    }
                });
            }
        }.createInjectorAndDoEMFRegistration();
        rosSystemInjector = new RosSystemStandaloneSetup() {
            @Override
            public Injector createInjector() {
                return Guice.createInjector(new RosSystemRuntimeModule() {
                    @Override
                    public ClassLoader bindClassLoaderToInstance() {
                        return PluginArchitecturePhase2Test.class.getClassLoader();
                    }
                });
            }
        }.createInjectorAndDoEMFRegistration();
        ros2IdeInjector = new Ros2IdeSetup().createInjectorAndDoEMFRegistration();
    }

    @After
    public void tearDown() {
        PluginRegistry.INSTANCE.clearRegistered();
    }

    private static Resource loadFromString(
            final XtextResourceSet rs, final String uriStr, final String content) throws Exception {
        Resource res = rs.createResource(URI.createURI(uriStr));
        res.load(new ByteArrayInputStream(content.getBytes(StandardCharsets.UTF_8)), null);
        return res;
    }

    private List<Issue> validate(final Injector inj, final Resource res) {
        return inj.getInstance(IResourceValidator.class)
                .validate(res, CheckMode.ALL, CancelIndicator.NullImpl);
    }

    private static String stdMsgsSpec() {
        return """
                std_msgs:
                  msgs:
                    String
                      message
                        string data
                """;
    }

    /** Builds a self-contained dynamic Ecore schema representing a third-party plugin's block schema. */
    private static EClass createAuditSchema(final EPackage.Registry pkgHolder) {
        EcoreFactory ef = EcoreFactory.eINSTANCE;
        EPackage ePkg = ef.createEPackage();
        ePkg.setName("auditmeta");
        ePkg.setNsPrefix("auditmeta");
        ePkg.setNsURI("http://example.org/auditmeta");

        EEnum modeEnum = ef.createEEnum();
        modeEnum.setName("AuditMode");
        EEnumLiteral syncLit = ef.createEEnumLiteral();
        syncLit.setName("SYNC");
        syncLit.setLiteral("sync");
        syncLit.setValue(0);
        EEnumLiteral asyncLit = ef.createEEnumLiteral();
        asyncLit.setName("ASYNC");
        asyncLit.setLiteral("async");
        asyncLit.setValue(1);
        modeEnum.getELiterals().addAll(List.of(syncLit, asyncLit));
        ePkg.getEClassifiers().add(modeEnum);

        EClass nestedRuleClass = ef.createEClass();
        nestedRuleClass.setName("AuditRule");
        EAttribute ruleNameAttr = ef.createEAttribute();
        ruleNameAttr.setName("name");
        ruleNameAttr.setEType(EcorePackage.Literals.ESTRING);
        nestedRuleClass.getEStructuralFeatures().add(ruleNameAttr);
        EAttribute weightAttr = ef.createEAttribute();
        weightAttr.setName("weight");
        weightAttr.setEType(EcorePackage.Literals.EINT);
        nestedRuleClass.getEStructuralFeatures().add(weightAttr);
        ePkg.getEClassifiers().add(nestedRuleClass);

        EClass blockClass = ef.createEClass();
        blockClass.setName("AuditConfig");

        EAttribute channelAttr = ef.createEAttribute();
        channelAttr.setName("channel");
        channelAttr.setEType(EcorePackage.Literals.ESTRING);
        channelAttr.setLowerBound(1);
        blockClass.getEStructuralFeatures().add(channelAttr);

        EAttribute rateAttr = ef.createEAttribute();
        rateAttr.setName("rate_hz");
        rateAttr.setEType(EcorePackage.Literals.EINT);
        blockClass.getEStructuralFeatures().add(rateAttr);

        EAttribute enabledAttr = ef.createEAttribute();
        enabledAttr.setName("enabled");
        enabledAttr.setEType(EcorePackage.Literals.EBOOLEAN);
        enabledAttr.setDefaultValueLiteral("true");
        blockClass.getEStructuralFeatures().add(enabledAttr);

        EAttribute modeAttr = ef.createEAttribute();
        modeAttr.setName("mode");
        modeAttr.setEType(modeEnum);
        blockClass.getEStructuralFeatures().add(modeAttr);

        EAttribute tagsAttr = ef.createEAttribute();
        tagsAttr.setName("tags");
        tagsAttr.setEType(EcorePackage.Literals.ESTRING);
        tagsAttr.setUpperBound(-1);
        blockClass.getEStructuralFeatures().add(tagsAttr);

        EReference pubRef = ef.createEReference();
        pubRef.setName("out_port");
        pubRef.setEType(RosPackage.Literals.PUBLISHER);
        blockClass.getEStructuralFeatures().add(pubRef);

        EReference rulesRef = ef.createEReference();
        rulesRef.setName("rules");
        rulesRef.setContainment(true);
        rulesRef.setUpperBound(-1);
        rulesRef.setEType(nestedRuleClass);
        blockClass.getEStructuralFeatures().add(rulesRef);

        ePkg.getEClassifiers().add(blockClass);
        if (pkgHolder != null) {
            pkgHolder.put(ePkg.getNsURI(), ePkg);
        }
        return blockClass;
    }

    @Test
    public void unknownExtensionBlockDegradesGracefullyAndSuppressesInnerRefErrors() throws Exception {
        // No plugins registered: Rule 6 guarantees core parses & validates cleanly with warnings only.
        XtextResourceSet rs = ros2Injector.getInstance(XtextResourceSet.class);
        loadFromString(rs, "inmemory:/std_msgs.ros", stdMsgsSpec());
        Resource pkgRes = loadFromString(rs, "inmemory:/unknown_ext.ros2", """
                unknown_ext_pkg:
                  artifacts:
                    demo_bin:
                      node: demo_node
                      publishers:
                        status:
                          type: "std_msgs/msg/String"
                      @unloaded_ext:
                        channel: "diag"
                        out_port: pub->nonexistent_pub
                """);
        EcoreUtil.resolveAll(rs);

        List<Issue> issues = validate(ros2Injector, pkgRes);
        List<Issue> errors = issues.stream().filter(i -> i.getSeverity() == Severity.ERROR).toList();
        assertTrue("Unknown @ block should produce no errors (suppressed inner ref too): " + errors, errors.isEmpty());
        assertTrue("Expected UNKNOWN_EXTENSION_BLOCK warning",
                issues.stream().anyMatch(i -> i.getSeverity() == Severity.WARNING
                        && BasicsValidator.UNKNOWN_EXTENSION_BLOCK.equals(i.getCode())));

        // Verify RosLinkingDiagnosticMessageProvider directly treats unresolved ExtensionRefValue inside unknown blocks cleanly
        assertEquals(Severity.WARNING, issues.stream()
                .filter(i -> BasicsValidator.UNKNOWN_EXTENSION_BLOCK.equals(i.getCode()))
                .findFirst().orElseThrow().getSeverity());
    }

    @Test
    public void customPluginSchemaValidationTypedMappingHoverCompletionBuildAndLspTools() throws Exception {
        EClass schema = createAuditSchema(null);
        BlockDescriptor descriptor = new BlockDescriptor(
                "audit",
                schema,
                EnumSet.of(HookLocation.NODE, HookLocation.ROS_NODE, HookLocation.PLUGIN),
                Map.of("tags", MergeStrategy.UNION_SET),
                "External audit configuration block");

        RosToolingPlugin auditPlugin = new RosToolingPlugin() {
            @Override
            public String id() {
                return "de.example.audit";
            }

            @Override
            public String version() {
                return "1.2.0";
            }

            @Override
            public String documentationMarkdown() {
                return "# Audit Plugin\n\nProvides `@audit:` metadata.";
            }

            @Override
            public List<BlockDescriptor> blocks() {
                return List.of(descriptor);
            }

            @Override
            public void validate(final ValidationContext context) {
                Object typed = context.typedBlock();
                assertNotNull(typed);
                EObject obj = (EObject) typed;
                Object rateVal = obj.eGet(schema.getEStructuralFeature("rate_hz"));
                if (rateVal instanceof Integer r && r < 0) {
                    context.error("rate_hz must be non-negative", null, null, "audit.negative_rate");
                }
            }

            @Override
            public void generatePackage(final PackageGenerationContext context) {
                PackageBuild build = context.packageBuild();
                build.addDepend("diagnostic_updater");
                build.addFindPackage("diagnostic_updater");
                build.setSingleValue(id(), "audit_level", "strict", MergeStrategy.ERROR_ON_CONFLICT);

                PackageBuild.LibraryTarget extraLib = build.getOrCreateLibrary("audit_hooks", true, id());
                build.addLibrarySource(extraLib, "src/audit_hooks.cpp", id());
                extraLib.publicLinkPackages().add("diagnostic_updater");
                extraLib.compileDefinitions().add("AUDIT_ENABLED=1");
                build.addXmlExport(new PackageBuild.XmlExportEntry(
                        "audit_plugin", Map.of("schema", "config/audit.yaml"), ""));
                build.addInstallFiles(List.of("config/audit.yaml"), "share/${PROJECT_NAME}/config");
                build.addTestTarget(new PackageBuild.TestTarget(
                        "test_audit", "gtest", List.of("test/test_audit.cpp"), List.of("audit_hooks"), List.of()));

                for (var art : context.packageModel().getArtifact()) {
                    for (Plugin pl : art.getPlugins()) {
                        if (pl.getLoader() == PluginLoader.EXTERNAL) {
                            context.claimExternalPluginRegistration(pl);
                        }
                    }
                }
                context.writeFile("src/audit_hooks.cpp", "// generated by audit plugin\n");
                context.writeOnce("include/" + context.packageModel().getName().toLowerCase() + "/audit_user.hpp",
                        "// user owned once\n");
                context.writeFile("config/audit.yaml", "mode: strict\n");
                context.deleteStaleFile("config/" + context.pluginFolder() + "/stale_audit.yaml");
            }

            @Override
            public List<PluginToolDescriptor> tools() {
                return List.of(new PluginToolDescriptor(
                        "summarize_audit",
                        "Summarizes @audit blocks on a model",
                        Map.of("type", "object", "properties", Map.of()),
                        ctx -> ToolResult.ok(
                                "Scanned " + ctx.modelPath(),
                                Map.of("argEcho", String.valueOf(ctx.argString("tag"))))));
            }
        };

        PluginRegistry.INSTANCE.register(auditPlugin);

        // 1. Verify schema validation catches unknown key, wrong location, negative custom validation, bad ref
        XtextResourceSet rs = ros2Injector.getInstance(XtextResourceSet.class);
        loadFromString(rs, "inmemory:/std_msgs.ros", stdMsgsSpec());
        Resource invalidRes = loadFromString(rs, "inmemory:/invalid_audit.ros2", """
                invalid_audit:
                  artifacts:
                    app_bin:
                      node: app_node
                      publishers:
                        hb:
                          type: "std_msgs/msg/String"
                      subscribers:
                        cmd:
                          type: "std_msgs/msg/String"
                      @audit:
                        channel: "main"
                        rate_hz: -5
                        mode: bogus_mode
                        unknown_key: 123
                        out_port: sub->cmd
                """);
        EcoreUtil.resolveAll(rs);
        List<Issue> badIssues = validate(ros2Injector, invalidRes);
        assertTrue(badIssues.stream().anyMatch(i -> i.getMessage().contains("Unknown field 'unknown_key'")));
        assertTrue(badIssues.stream().anyMatch(i -> i.getMessage().contains("bogus_mode")));
        assertTrue(badIssues.stream().anyMatch(i -> i.getMessage().contains("out_port")));

        // 2. Custom validation error triggers when schema passes
        Resource customBadRes = loadFromString(rs, "inmemory:/custom_bad.ros2", """
                custom_bad:
                  artifacts:
                    app_bin:
                      node: app_node
                      @audit:
                        channel: "main"
                        rate_hz: -1
                """);
        EcoreUtil.resolveAll(rs);
        List<Issue> customIssues = validate(ros2Injector, customBadRes);
        assertTrue("Expected custom validation issue: " + customIssues,
                customIssues.stream().anyMatch(i -> "audit.negative_rate".equals(i.getCode())));

        // 3. Valid model with external plugin, list > 4 items, nested map, and pub-> ref
        String validRos2Text = """
                valid_audit:
                  artifacts:
                    app_bin:
                      node: app_node
                      publishers:
                        hb:
                          type: "std_msgs/msg/String"
                      @audit:
                        channel: "main"
                        rate_hz: 10
                        mode: async
                        tags: ["t1", "t2", "t3", "t4", "t5"]
                        out_port: pub->hb
                        rules:
                          r1:
                            weight: 3
                      plugins:
                        ExtAuditor:
                          loader: external
                """;
        Resource validRes = loadFromString(rs, "inmemory:/valid_audit.ros2", validRos2Text);
        EcoreUtil.resolveAll(rs);
        List<Issue> okErrors = validate(ros2Injector, validRes).stream()
                .filter(i -> i.getSeverity() == Severity.ERROR).toList();
        assertTrue("Expected zero validation errors on valid @audit model: " + okErrors, okErrors.isEmpty());

        AmentPackage pkg = (AmentPackage) validRes.getContents().get(0);
        Node node = pkg.getArtifact().get(0).getNode();
        ExtensionBlock block = node.getExtensions().get(0);

        // Verify typed object & map round-trip & bracket list DSL serialization (> 4 items!)
        EObject typed = ExtensionSchemaMapper.toTypedObject(block, descriptor);
        assertNotNull(typed);
        assertEquals("main", typed.eGet(schema.getEStructuralFeature("channel")));
        assertEquals("hb", ((Node) node).getPublisher().get(0).getName());
        assertEquals(pkg.getArtifact().get(0).getNode().getPublisher().get(0),
                typed.eGet(schema.getEStructuralFeature("out_port")));

        Map<String, Object> roundMap = ExtensionSchemaMapper.blockToMap(block);
        assertEquals("pub->hb", roundMap.get("out_port"));
        assertEquals(10L, roundMap.get("rate_hz"));
        assertEquals("main", roundMap.get("channel"));
        ExtensionBlock rebuilt = ExtensionSchemaMapper.fromMap("audit", roundMap, descriptor, rs);
        String renderedDsl = ExtensionSchemaMapper.renderBlockDsl(rebuilt, "  ");
        assertTrue("List > 4 items must still use valid [ ... ] syntax:\n" + renderedDsl,
                renderedDsl.contains("[\"t1\", \"t2\", \"t3\", \"t4\", \"t5\"]"));
        assertFalse("Rendered ref must never contain double arrow", renderedDsl.contains("pub->->"));

        // 4. Hover documentation & completion candidates
        IEObjectDocumentationProvider docProvider = ros2Injector.getInstance(IEObjectDocumentationProvider.class);
        assertTrue(docProvider instanceof RosExtensionDocumentationProvider);
        String blockDoc = docProvider.getDocumentation(block);
        assertTrue(blockDoc, blockDoc.contains("@audit") && blockDoc.contains("de.example.audit"));
        String entryDoc = docProvider.getDocumentation(block.getEntries().get(0));
        assertTrue(entryDoc, entryDoc.contains("channel") && entryDoc.contains("required"));

        assertFalse(RosExtensionIdeContentProposalProvider.blockProposalsFor(node, true).isEmpty());
        assertTrue(RosExtensionIdeContentProposalProvider.entryKeyProposalsFor(block, true).stream()
                .anyMatch(c -> c.label().equals("channel")));
        assertTrue(RosExtensionIdeContentProposalProvider.entryValueProposalsFor(block.getEntries().get(2)).stream()
                .anyMatch(c -> c.label().equals("async")));

        // 5. Two-phase code & build generation (including Domain Logic Shield on writeOnce)
        Ros2Generator gen = ros2Injector.getInstance(Ros2Generator.class);
        InMemoryFileSystemAccess fsa = new InMemoryFileSystemAccess();
        Ros2Generator.PluginGenerationOutcome outcome = gen.generateTargetedWithPlugins(
                validRes,
                fsa,
                null,
                "cpp",
                "jazzy",
                List.of("valid_audit/include/valid_audit/audit_user.hpp"));
        assertTrue("Expected zero generation errors: " + outcome.errors, outcome.errors.isEmpty());
        String cmake = fsa.getTextFiles().get("DEFAULT_OUTPUTvalid_audit/CMakeLists.txt").toString();
        String pkgXml = fsa.getTextFiles().get("DEFAULT_OUTPUTvalid_audit/package.xml").toString();
        assertTrue(cmake, cmake.contains("find_package(diagnostic_updater REQUIRED)"));
        assertTrue(cmake, cmake.contains("add_library(audit_hooks SHARED"));
        assertTrue(cmake, cmake.contains("AUDIT_ENABLED=1"));
        assertTrue(cmake, cmake.contains("ament_add_gtest(test_audit"));
        assertTrue(pkgXml, pkgXml.contains("<depend>diagnostic_updater</depend>"));
        assertTrue(pkgXml, pkgXml.contains("<audit_plugin schema=\"config/audit.yaml\"/>"));
        assertTrue(fsa.getTextFiles().containsKey("DEFAULT_OUTPUTvalid_audit/src/audit_hooks.cpp"));
        assertFalse("writeOnce must respect existing file via Domain Logic Shield",
                fsa.getTextFiles().containsKey("DEFAULT_OUTPUTvalid_audit/include/valid_audit/audit_user.hpp"));
        assertTrue(outcome.pluginDeletedFiles.contains("valid_audit/config/de_example_audit/stale_audit.yaml"));

        // 6. Test LSP command handlers (Ros2GeneratorCommandService & RosPluginCommandSupport)
        Ros2GeneratorCommandService cmdService = ros2IdeInjector.getInstance(Ros2GeneratorCommandService.class);
        List<String> advertised = cmdService.initialize();
        assertTrue(advertised.contains(Ros2GeneratorCommandService.LIST_PLUGIN_TOOLS));
        assertTrue(advertised.contains(Ros2GeneratorCommandService.SET_EXTENSION_BLOCK));

        @SuppressWarnings("unchecked")
        Map<String, Object> listResp = (Map<String, Object>) cmdService.execute(
                new ExecuteCommandParams(Ros2GeneratorCommandService.LIST_PLUGIN_TOOLS, List.of()),
                null,
                CancelIndicator.NullImpl);
        assertFalse(((List<?>) listResp.get("tools")).isEmpty());
        @SuppressWarnings("unchecked")
        List<Map<String, Object>> listedPlugins = (List<Map<String, Object>>) listResp.get("plugins");
        @SuppressWarnings("unchecked")
        List<Map<String, Object>> listedBlocks = (List<Map<String, Object>>) listedPlugins.get(0).get("blocks");
        assertEquals("de_example_audit__set_audit", listedBlocks.get(0).get("setToolName"));

        @SuppressWarnings("unchecked")
        Map<String, Object> toolResp = (Map<String, Object>) RosPluginCommandSupport.executePluginTool(
                Map.of("prefixedName", RosPluginCommandSupport.prefixedToolName("de.example.audit", "summarize_audit"),
                        "modelPath", "valid_audit.ros2",
                        "arguments", Map.of("tag", "hello")),
                null,
                ros2IdeInjector.getInstance(IResourceServiceProvider.Registry.class));
        assertEquals(Boolean.TRUE, toolResp.get("success"));

        Map<String, Object> setResp = RosPluginCommandSupport.setExtensionBlock(
                Map.of("fileUri", "inmemory:/set_test.ros2",
                        "modelText", """
                                set_pkg:
                                  artifacts:
                                    b:
                                      node: n
                                      publishers:
                                        hb:
                                          type: "std_msgs/msg/String"
                                """,
                        "blockName", "audit",
                        "targetKind", "Node",
                        "targetName", "n",
                        "entries", Map.of("channel", "fast", "rate_hz", 50, "out_port", "pub->hb")),
                null,
                ros2IdeInjector.getInstance(IResourceServiceProvider.Registry.class));
        String updated = String.valueOf(setResp.get("updatedText"));
        assertTrue("Expected @audit block spliced into text:\n" + updated, updated.contains("@audit:"));
        assertTrue(updated, updated.contains("channel: \"fast\""));

        Map<String, Object> getResp = RosPluginCommandSupport.getExtensionBlock(
                Map.of("fileUri", "inmemory:/set_test.ros2",
                        "modelText", updated,
                        "blockName", "audit",
                        "targetKind", "Node",
                        "targetName", "n"),
                null,
                ros2IdeInjector.getInstance(IResourceServiceProvider.Registry.class));
        assertEquals(Boolean.TRUE, getResp.get("found"));
        assertEquals("fast", ((Map<?, ?>) getResp.get("entries")).get("channel"));

        // 7. System inheritance merge test (RosNode overrides scalar, UNION_SET merges tags)
        XtextResourceSet sysRs = rosSystemInjector.getInstance(XtextResourceSet.class);
        loadFromString(sysRs, "inmemory:/std_msgs.ros", stdMsgsSpec());
        loadFromString(sysRs, "inmemory:/valid_audit.ros2", validRos2Text);
        Resource sysRes = loadFromString(sysRs, "inmemory:/audit_sys.rossystem", """
                audit_sys:
                  nodes:
                    inst:
                      from: "valid_audit.app_node"
                      @audit:
                        channel: "override_ch"
                        tags: ["t5", "t6"]
                """);
        EcoreUtil.resolveAll(sysRs);
        RosNode inst = (RosNode) ((system.System) sysRes.getContents().get(0)).getComponents().get(0);
        ExtensionBlock merged = ExtensionBlockMerger.merge(node, inst, "audit", descriptor);
        Map<String, Object> mergedMap = ExtensionSchemaMapper.blockToMap(merged);
        assertEquals("override_ch", mergedMap.get("channel"));
        assertEquals(List.of("t1", "t2", "t3", "t4", "t5", "t6"), mergedMap.get("tags"));
    }

    @Test
    public void multiPluginConflictsAndUnclaimedExternalPluginAreReportedClearly() throws Exception {
        EClass sharedSchema = createAuditSchema(null);
        BlockDescriptor conflictBlock = new BlockDescriptor(
                "shared_cfg",
                sharedSchema,
                EnumSet.of(HookLocation.NODE, HookLocation.ROS_NODE),
                Map.of("channel", MergeStrategy.ERROR_ON_CONFLICT),
                "Shared block with conflict rule");

        RosToolingPlugin pluginAlpha = new RosToolingPlugin() {
            @Override public String id() { return "de.example.alpha"; }
            @Override public List<BlockDescriptor> blocks() { return List.of(conflictBlock); }
            @Override public void validate(final ValidationContext context) {}
            @Override public void generatePackage(final PackageGenerationContext context) {
                PackageBuild pb = context.packageBuild();
                pb.addDepend("pkg_a");
                pb.getOrCreateLibrary("shared_lib", true, id());
                pb.setSingleValue(id(), "build_mode", "fast", MergeStrategy.ERROR_ON_CONFLICT);
                context.writeFile("src/collide.cpp", "// from alpha\n");
                for (var art : context.packageModel().getArtifact()) {
                    for (Plugin pl : art.getPlugins()) {
                        if ("ExtAlphaAndBeta".equals(pl.getName())) {
                            context.claimExternalPluginRegistration(pl);
                        }
                    }
                }
            }
        };

        RosToolingPlugin pluginBeta = new RosToolingPlugin() {
            @Override public String id() { return "de.example.beta"; }
            @Override public List<BlockDescriptor> blocks() { return List.of(); }
            @Override public void validate(final ValidationContext context) {}
            @Override public void generatePackage(final PackageGenerationContext context) {
                PackageBuild pb = context.packageBuild();
                pb.addDepend("pkg_a"); // overlapping dependency merges cleanly
                pb.getOrCreateLibrary("shared_lib", false, id()); // linkage conflict!
                pb.setSingleValue(id(), "build_mode", "safe", MergeStrategy.ERROR_ON_CONFLICT);
                context.writeFile("src/collide.cpp", "// from beta\n");
                for (var art : context.packageModel().getArtifact()) {
                    for (Plugin pl : art.getPlugins()) {
                        if ("ExtAlphaAndBeta".equals(pl.getName())) {
                            context.claimExternalPluginRegistration(pl);
                        }
                    }
                }
            }
        };

        PluginRegistry.INSTANCE.register(pluginAlpha);
        PluginRegistry.INSTANCE.register(pluginBeta);

        XtextResourceSet rs = ros2Injector.getInstance(XtextResourceSet.class);
        Resource res = loadFromString(rs, "inmemory:/conflict_pkg.ros2", """
                conflict_pkg:
                  artifacts:
                    art1:
                      node: host
                    art2:
                      plugins:
                        ExtAlphaAndBeta:
                          loader: external
                        ExtUnclaimed:
                          loader: external
                """);
        EcoreUtil.resolveAll(rs);

        Ros2Generator gen = ros2Injector.getInstance(Ros2Generator.class);
        InMemoryFileSystemAccess fsa = new InMemoryFileSystemAccess();
        Ros2Generator.PluginGenerationOutcome outcome =
                gen.generateTargetedWithPlugins(res, fsa, null, "cpp", "jazzy", List.of());

        assertTrue("Conflicting library linkage must name both plugins: " + outcome.errors,
                outcome.errors.stream().anyMatch(e ->
                        e.contains("de.example.alpha") && e.contains("de.example.beta") && e.contains("shared_lib")));
        assertTrue("Conflicting single value must name both plugins: " + outcome.errors,
                outcome.errors.stream().anyMatch(e ->
                        e.contains("de.example.alpha") && e.contains("de.example.beta") && e.contains("build_mode")));
        assertTrue("Conflicting file write must name both plugins: " + outcome.errors,
                outcome.errors.stream().anyMatch(e ->
                        e.contains("de.example.alpha") && e.contains("de.example.beta") && e.contains("collide.cpp")));
        assertTrue("Conflicting external claim must name both plugins: " + outcome.errors,
                outcome.errors.stream().anyMatch(e ->
                        e.contains("de.example.alpha") && e.contains("de.example.beta") && e.contains("ExtAlphaAndBeta")));
        assertTrue("Unclaimed external plugin must error: " + outcome.errors,
                outcome.errors.stream().anyMatch(e -> e.contains("ExtUnclaimed")));
        assertTrue("Plugin files must NOT be emitted when conflicts/unclaimed plugins exist: " + outcome.pluginFiles,
                outcome.pluginFiles.isEmpty());
        assertFalse("FSA must NOT receive plugin file on conflict",
                fsa.getTextFiles().keySet().stream().anyMatch(k -> k.endsWith("collide.cpp")));
        String conflictCmake = fsa.getTextFiles().get("DEFAULT_OUTPUTconflict_pkg/CMakeLists.txt").toString();
        assertFalse("CMakeLists.txt must NOT receive conflicting plugin build targets:\n" + conflictCmake,
                conflictCmake.contains("shared_lib"));

        // Also test ExtensionBlockMerger ERROR_ON_CONFLICT in .rossystem
        XtextResourceSet sysRs = rosSystemInjector.getInstance(XtextResourceSet.class);
        loadFromString(sysRs, "inmemory:/type_pkg.ros2", """
                type_pkg:
                  artifacts:
                    host_art:
                      node: host_type
                      @shared_cfg:
                        channel: "alpha_ch"
                """);
        Resource conflictSys = loadFromString(sysRs, "inmemory:/conflict_sys.rossystem", """
                conflict_sys:
                  nodes:
                    inst:
                      from: "type_pkg.host_type"
                      @shared_cfg:
                        channel: "beta_ch"
                """);
        EcoreUtil.resolveAll(sysRs);
        List<Issue> sysIssues = validate(rosSystemInjector, conflictSys);
        assertTrue("Expected EXTENSION_MERGE_CONFLICT error: " + sysIssues,
                sysIssues.stream().anyMatch(i -> RosSystemValidator.EXTENSION_MERGE_CONFLICT.equals(i.getCode())));

        // Also verify unclaimed external plugin suppresses plugin file emission even when a single plugin writes cleanly
        PluginRegistry.INSTANCE.clearRegistered();
        PluginRegistry.INSTANCE.register(new RosToolingPlugin() {
            @Override public String id() { return "de.example.writer"; }
            @Override public List<BlockDescriptor> blocks() { return List.of(); }
            @Override public void validate(final ValidationContext context) {}
            @Override public void generatePackage(final PackageGenerationContext context) {
                context.writeFile("src/should_not_exist.cpp", "// should be withheld\n");
            }
        });
        InMemoryFileSystemAccess unclaimedFsa = new InMemoryFileSystemAccess();
        Ros2Generator.PluginGenerationOutcome unclaimedOutcome =
                gen.generateTargetedWithPlugins(res, unclaimedFsa, null, "cpp", "jazzy", List.of());
        assertFalse("Expected error for unclaimed external plugin", unclaimedOutcome.errors.isEmpty());
        assertTrue("Plugin files must be withheld on unclaimed external plugin: " + unclaimedOutcome.pluginFiles,
                unclaimedOutcome.pluginFiles.isEmpty());
        assertFalse(unclaimedFsa.getTextFiles().keySet().stream().anyMatch(k -> k.endsWith("should_not_exist.cpp")));
    }

    @Test
    public void packageBuildRejectsInjectionAndEscapesXmlExports() throws Exception {
        XtextResourceSet rs = ros2Injector.getInstance(XtextResourceSet.class);
        Resource res = loadFromString(rs, "inmemory:/inject_pkg.ros2", """
                inject_pkg:
                  artifacts:
                    base_art:
                      node: base_node
                """);
        EcoreUtil.resolveAll(rs);

        List<java.util.function.Consumer<PackageBuild>> attacks = List.of(
                pb -> pb.addBuildtoolDepend("ament_cmake\nadd_custom_target(pwn)"),
                pb -> pb.addDepend("rclcpp )"),
                pb -> pb.addExecDepend("launch \"evil\""),
                pb -> pb.addTestDepend("gtest;evil"),
                pb -> pb.addFindPackage("pkg name"),
                pb -> pb.getOrCreateLibrary("bad lib\nevil", true, "de.example.inject"),
                pb -> {
                    PackageBuild.LibraryTarget lib = pb.getOrCreateLibrary("safe_lib", true, "de.example.inject");
                    pb.addLibrarySource(lib, "../escape.cpp", "de.example.inject");
                },
                pb -> pb.getOrCreateLibrary("safe_lib", true, "de.example.inject")
                        .sources().add("src/a.cpp\nadd_custom_target(pwn)"),
                pb -> pb.getOrCreateLibrary("safe_lib", true, "de.example.inject")
                        .publicIncludeDirs().add("include)\nevil("),
                pb -> pb.getOrCreateLibrary("safe_lib", true, "de.example.inject")
                        .privateIncludeDirs().add("/abs/path"),
                pb -> pb.getOrCreateLibrary("safe_lib", true, "de.example.inject")
                        .publicLinkPackages().add("bad pkg"),
                pb -> pb.getOrCreateLibrary("safe_lib", true, "de.example.inject")
                        .privateLinkPackages().add("bad\npkg"),
                pb -> pb.getOrCreateLibrary("safe_lib", true, "de.example.inject")
                        .publicLinkLibraries().add("lib\"evil\""),
                pb -> pb.getOrCreateLibrary("safe_lib", true, "de.example.inject")
                        .privateLinkLibraries().add("lib)evil("),
                pb -> pb.getOrCreateLibrary("safe_lib", true, "de.example.inject")
                        .compileDefinitions().add("FOO=1 BAR"),
                pb -> pb.getOrCreateLibrary("safe_lib", true, "de.example.inject")
                        .componentRegistrations().add("ns::Cls\")\nevil("),
                pb -> pb.getOrCreateExecutable("bad exec", "de.example.inject"),
                pb -> pb.getOrCreateExecutable("safe_exec", "de.example.inject")
                        .sources().add("src/main.cpp\n#evil"),
                pb -> pb.getOrCreateExecutable("safe_exec", "de.example.inject")
                        .linkPackages().add("pkg\nfind_package(pwn)"),
                pb -> pb.getOrCreateExecutable("safe_exec", "de.example.inject")
                        .publicLinkLibraries().add("lib evil"),
                pb -> pb.getOrCreateExecutable("safe_exec", "de.example.inject")
                        .privateLinkLibraries().add("lib)evil"),
                pb -> pb.getOrCreateExecutable("safe_exec", "de.example.inject")
                        .compileDefinitions().add("DEF=\"evil\""),
                pb -> pb.addInstallDirectory("../secrets", "share/${PROJECT_NAME}", true),
                pb -> pb.addInstallFiles(List.of("cfg/a.yaml\nevil"), "share/${PROJECT_NAME}/cfg"),
                pb -> pb.addPythonProgram("bin/run.py", "lib/${PROJECT_NAME}", "bad rename"),
                pb -> pb.addPluginlibExport("base pkg", "plugins.xml"),
                pb -> pb.addTestTarget(new PackageBuild.TestTarget(
                        "t_bad)", "gtest", List.of("test/a.cpp"), List.of(), List.of())),
                pb -> pb.addXmlExport(new PackageBuild.XmlExportEntry("bad<tag>", Map.of("k", "v"), "")),
                pb -> pb.addXmlExport(new PackageBuild.XmlExportEntry("good_tag", Map.of("bad attr", "v"), "")));

        Ros2Generator gen = ros2Injector.getInstance(Ros2Generator.class);
        for (int i = 0; i < attacks.size(); i++) {
            final int idx = i;
            PluginRegistry.INSTANCE.clearRegistered();
            PluginRegistry.INSTANCE.register(new RosToolingPlugin() {
                @Override public String id() { return "de.example.inject"; }
                @Override public List<BlockDescriptor> blocks() { return List.of(); }
                @Override public void validate(final ValidationContext context) {}
                @Override public void generatePackage(final PackageGenerationContext context) {
                    attacks.get(idx).accept(context.packageBuild());
                    context.writeFile("src/plugin_out.cpp", "// should be withheld\n");
                }
            });
            InMemoryFileSystemAccess fsa = new InMemoryFileSystemAccess();
            Ros2Generator.PluginGenerationOutcome outcome =
                    gen.generateTargetedWithPlugins(res, fsa, null, "cpp", "jazzy", List.of());
            assertFalse("Attack #" + idx + " must fail with error", outcome.errors.isEmpty());
            assertTrue("Attack #" + idx + " error must name the plugin: " + outcome.errors,
                    outcome.errors.stream().anyMatch(e -> e.contains("de.example.inject")));
            assertTrue("Attack #" + idx + " must withhold plugin files", outcome.pluginFiles.isEmpty());
        }

        // Verify valid XmlExportEntry XML-escapes attribute values & textContent and renders clean CMake target headers
        PluginRegistry.INSTANCE.clearRegistered();
        PluginRegistry.INSTANCE.register(new RosToolingPlugin() {
            @Override public String id() { return "de.example.xml_escape"; }
            @Override public List<BlockDescriptor> blocks() { return List.of(); }
            @Override public void validate(final ValidationContext context) {}
            @Override public void generatePackage(final PackageGenerationContext context) {
                PackageBuild pb = context.packageBuild();
                pb.addXmlExport(new PackageBuild.XmlExportEntry(
                        "safe_tag",
                        Map.of("expr", "a < b & \"c\" > 'd'"),
                        "text <tag> & \"q\""));
                PackageBuild.LibraryTarget lib = pb.getOrCreateLibrary("escaped_lib", true, id());
                lib.sources().add("src/escaped_lib.cpp");
                PackageBuild.ExecutableTarget exec = pb.getOrCreateExecutable("escaped_exec", id());
                exec.sources().add("src/escaped_exec.cpp");
            }
        });
        InMemoryFileSystemAccess okFsa = new InMemoryFileSystemAccess();
        Ros2Generator.PluginGenerationOutcome okOutcome =
                gen.generateTargetedWithPlugins(res, okFsa, null, "cpp", "jazzy", List.of());
        assertTrue("Expected zero errors: " + okOutcome.errors, okOutcome.errors.isEmpty());
        String pkgXml = okFsa.getTextFiles().get("DEFAULT_OUTPUTinject_pkg/package.xml").toString();
        String cmake = okFsa.getTextFiles().get("DEFAULT_OUTPUTinject_pkg/CMakeLists.txt").toString();
        assertTrue(pkgXml, pkgXml.contains(
                "<safe_tag expr=\"a &lt; b &amp; &quot;c&quot; &gt; &apos;d&apos;\">text &lt;tag&gt; &amp; &quot;q&quot;</safe_tag>"));
        assertTrue(cmake, cmake.contains("# Plugin Library Target: escaped_lib"));
        assertTrue(cmake, cmake.contains("# Plugin Executable Target: escaped_exec"));
    }

    @Test
    public void coreOwnedPathsProtectSkippedUserLogicFiles() throws Exception {
        XtextResourceSet rs = ros2Injector.getInstance(XtextResourceSet.class);
        Resource res = loadFromString(rs, "inmemory:/shield_pkg.ros2", """
                shield_pkg:
                  artifacts:
                    shield_cpp:
                      node: shield_cpp_node
                    shield_py:
                      node: shield_py_node
                    shield_plugin_art:
                      plugins:
                        ShieldPlugin:
                          loader: pluginlib
                """);
        EcoreUtil.resolveAll(rs);

        List<String> existingUserFiles = List.of(
                "shield_pkg/include/shield_pkg/ShieldCppAlgorithm.hpp",
                "shield_pkg/include/shield_pkg/shield_plugin_plugin.hpp",
                "shield_pkg/shield_pkg/shield_py_node_logic.py");

        List<String> observedCoreOwned = new ArrayList<>();
        Ros2Generator gen = ros2Injector.getInstance(Ros2Generator.class);

        for (int attempt = 0; attempt < 3; attempt++) {
            final int op = attempt;
            PluginRegistry.INSTANCE.clearRegistered();
            PluginRegistry.INSTANCE.register(new RosToolingPlugin() {
                @Override public String id() { return "de.example.shield_probe"; }
                @Override public List<BlockDescriptor> blocks() { return List.of(); }
                @Override public void validate(final ValidationContext context) {}
                @Override public void generatePackage(final PackageGenerationContext context) {
                    if (op == 0) {
                        observedCoreOwned.addAll(context.coreOwnedPaths());
                    }
                    String langTarget = op == 2
                            ? "shield_pkg/shield_py_node_logic.py"
                            : "include/shield_pkg/ShieldCppAlgorithm.hpp";
                    String pluginlibTarget = "include/shield_pkg/shield_plugin_plugin.hpp";
                    if (op == 0) {
                        context.writeFile(langTarget, "// overwritten\n");
                        context.writeFile(pluginlibTarget, "// overwritten plugin\n");
                    } else if (op == 1) {
                        assertFalse(context.writeOnce(langTarget, "// writeOnce\n"));
                        assertFalse(context.writeOnce(pluginlibTarget, "// writeOnce\n"));
                    } else {
                        context.deleteStaleFile(langTarget);
                        context.deleteStaleFile(pluginlibTarget);
                    }
                }
            });

            InMemoryFileSystemAccess fsa = new InMemoryFileSystemAccess();
            String lang = op == 2 ? "python" : "cpp";
            List<String> targets = op == 2
                    ? List.of("shield_py_node")
                    : List.of("shield_cpp_node", "ShieldPlugin");
            Ros2Generator.PluginGenerationOutcome outcome =
                    gen.generateTargetedWithPlugins(res, fsa, targets, lang, "jazzy", existingUserFiles);

            assertFalse("Attempt " + op + " must reject touching skipped user logic files", outcome.errors.isEmpty());
            assertTrue("Attempt " + op + " error must name plugin: " + outcome.errors,
                    outcome.errors.stream().anyMatch(e -> e.contains("de.example.shield_probe")));
            assertTrue("Attempt " + op + " must withhold plugin files", outcome.pluginFiles.isEmpty());
            assertTrue("Attempt " + op + " must not delete protected files", outcome.pluginDeletedFiles.isEmpty());
        }

        // Also verify no plugins active + language "both" preserves edited logic files and leaves coreDeletedFiles out of pluginDeletedFiles
        PluginRegistry.INSTANCE.clearRegistered();
        InMemoryFileSystemAccess bothFsa = new InMemoryFileSystemAccess();
        Ros2Generator.PluginGenerationOutcome bothOutcome =
                gen.generateTargetedWithPlugins(res, bothFsa, List.of("shield_cpp_node", "shield_py_node"), "both", "jazzy", existingUserFiles);
        assertTrue("No-plugin both run must have zero errors: " + bothOutcome.errors, bothOutcome.errors.isEmpty());
        assertTrue("pluginDeletedFiles must be empty with no plugins active", bothOutcome.pluginDeletedFiles.isEmpty());
        assertTrue("coreDeletedFiles must remain separated from pluginDeletedFiles",
                !bothOutcome.coreDeletedFiles.isEmpty());
        assertFalse("Skipped Algorithm.hpp must NOT be overwritten",
                bothFsa.getTextFiles().containsKey("DEFAULT_OUTPUTshield_pkg/include/shield_pkg/ShieldCppAlgorithm.hpp"));
        assertFalse("Skipped _logic.py must NOT be overwritten",
                bothFsa.getTextFiles().containsKey("DEFAULT_OUTPUTshield_pkg/shield_pkg/shield_py_node_logic.py"));
        assertTrue("Python wrapper must be present after 'both' run",
                bothFsa.getTextFiles().containsKey("DEFAULT_OUTPUTshield_pkg/shield_pkg/shield_py_node_wrapper.py"));
        assertTrue("Python runner must be present after 'both' run",
                bothFsa.getTextFiles().containsKey("DEFAULT_OUTPUTshield_pkg/shield_pkg/shield_py_node_runner.py"));

        assertTrue("coreOwnedPaths must include skipped Algorithm.hpp",
                observedCoreOwned.contains("shield_pkg/include/shield_pkg/ShieldCppAlgorithm.hpp"));
        assertTrue("coreOwnedPaths must include skipped _plugin.hpp",
                observedCoreOwned.contains("shield_pkg/include/shield_pkg/shield_plugin_plugin.hpp"));
        assertTrue("coreOwnedPaths must include skipped _logic.py",
                observedCoreOwned.contains("shield_pkg/shield_pkg/shield_py_node_logic.py"));
    }

    @Test
    public void overlappingPackageBuildEntriesMergeCleanly() throws Exception {
        XtextResourceSet rs = ros2Injector.getInstance(XtextResourceSet.class);
        Resource res = loadFromString(rs, "inmemory:/overlap_pkg.ros2", """
                overlap_pkg:
                  artifacts:
                    base_art:
                      node: base_node
                """);
        EcoreUtil.resolveAll(rs);

        PluginRegistry.INSTANCE.register(new RosToolingPlugin() {
            @Override public String id() { return "de.example.overlap_a"; }
            @Override public List<BlockDescriptor> blocks() { return List.of(); }
            @Override public void validate(final ValidationContext context) {}
            @Override public void generatePackage(final PackageGenerationContext context) {
                PackageBuild pb = context.packageBuild();
                pb.addDepend("std_msgs");
                pb.addFindPackage("std_msgs");
                PackageBuild.LibraryTarget lib = pb.getOrCreateLibrary("shared_hook", true, id());
                pb.addLibrarySource(lib, "src/hook_a.cpp", id());
                lib.compileDefinitions().add("SHARED_DEF=1");
                lib.compileDefinitions().add("DEF_A=1");
                pb.addInstallDirectory("cfg_a", "share/${PROJECT_NAME}/cfg_a", false);
                pb.addInstallFiles(List.of("res/a.yaml"), "share/${PROJECT_NAME}/res");
                pb.addTestTarget(new PackageBuild.TestTarget(
                        "test_a", "gtest", List.of("test/test_a.cpp"), List.of("shared_hook"), List.of()));
                pb.addXmlExport(new PackageBuild.XmlExportEntry("export_a", Map.of(), "first"));
                context.writeFile("src/hook_a.cpp", "// a\n");
            }
        });

        PluginRegistry.INSTANCE.register(new RosToolingPlugin() {
            @Override public String id() { return "de.example.overlap_b"; }
            @Override public List<BlockDescriptor> blocks() { return List.of(); }
            @Override public void validate(final ValidationContext context) {}
            @Override public void generatePackage(final PackageGenerationContext context) {
                PackageBuild pb = context.packageBuild();
                pb.addDepend("std_msgs");
                pb.addDepend("sensor_msgs");
                pb.addFindPackage("std_msgs");
                PackageBuild.LibraryTarget lib = pb.getOrCreateLibrary("shared_hook", true, id());
                pb.addLibrarySource(lib, "src/hook_a.cpp", id());
                pb.addLibrarySource(lib, "src/hook_b.cpp", id());
                lib.compileDefinitions().add("SHARED_DEF=1");
                lib.compileDefinitions().add("DEF_B=2");
                pb.addInstallDirectory("cfg_b", "share/${PROJECT_NAME}/cfg_b", false);
                pb.addInstallFiles(List.of("res/b.yaml"), "share/${PROJECT_NAME}/res");
                pb.addTestTarget(new PackageBuild.TestTarget(
                        "test_b", "gtest", List.of("test/test_b.cpp"), List.of("shared_hook"), List.of()));
                pb.addXmlExport(new PackageBuild.XmlExportEntry("export_b", Map.of(), "second"));
                context.writeFile("src/hook_b.cpp", "// b\n");
            }
        });

        Ros2Generator gen = ros2Injector.getInstance(Ros2Generator.class);
        InMemoryFileSystemAccess fsa = new InMemoryFileSystemAccess();
        Ros2Generator.PluginGenerationOutcome outcome =
                gen.generateTargetedWithPlugins(res, fsa, null, "cpp", "jazzy", List.of());

        assertTrue("Overlapping valid PackageBuild entries must merge cleanly: " + outcome.errors,
                outcome.errors.isEmpty());
        String cmake = fsa.getTextFiles().get("DEFAULT_OUTPUToverlap_pkg/CMakeLists.txt").toString();
        String pkgXml = fsa.getTextFiles().get("DEFAULT_OUTPUToverlap_pkg/package.xml").toString();

        assertEquals(1, countOccurrences(pkgXml, "<depend>std_msgs</depend>"));
        assertTrue(pkgXml, pkgXml.contains("<depend>sensor_msgs</depend>"));
        assertEquals(1, countOccurrences(cmake, "find_package(std_msgs REQUIRED)"));
        assertEquals(1, countOccurrences(cmake, "src/hook_a.cpp"));
        assertTrue(cmake, cmake.contains("src/hook_b.cpp"));
        assertEquals(1, countOccurrences(cmake, "SHARED_DEF=1"));
        assertTrue(cmake, cmake.contains("DEF_A=1") && cmake.contains("DEF_B=2"));
        assertTrue("installDirectories should append in plugin order",
                cmake.indexOf("cfg_a") < cmake.indexOf("cfg_b"));
        assertTrue("test targets should append in plugin order",
                cmake.indexOf("test_a") < cmake.indexOf("test_b"));
        assertTrue("xmlExports should append in plugin order",
                pkgXml.indexOf("<export_a>") < pkgXml.indexOf("<export_b>"));
    }

    private Resource loadSysProbeFixture(final BlockDescriptor sysProbeBlock) throws Exception {
        XtextResourceSet rs = rosSystemInjector.getInstance(XtextResourceSet.class);
        loadFromString(rs, "inmemory:/type_pkg.ros2", """
                type_pkg:
                  artifacts:
                    cam_art:
                      node: cam_node
                      @sys_probe:
                        mode: "default_type"
                        rate: 50
                """);
        Resource sysRes = loadFromString(rs, "inmemory:/sys_probe_demo.rossystem", """
                sys_probe_demo:
                  @sys_probe:
                    mode: "active"
                  parameters:
                    robot_ns:
                      type: String
                      value: "bot1"
                  nodes:
                    cam_inst:
                      from: "type_pkg.cam_node"
                      @sys_probe:
                        mode: "override"
                """);
        EcoreUtil.resolveAll(rs);
        return sysRes;
    }

    private RosToolingPlugin createSysAddonPlugin(final EClass sysProbeSchema, final BlockDescriptor sysProbeBlock) {
        return new RosToolingPlugin() {
            @Override public String id() { return "de.example.sys-addon"; }
            @Override public List<BlockDescriptor> blocks() { return List.of(sysProbeBlock); }
            @Override public void validate(final ValidationContext context) {}
            @Override public void generateSystem(final SystemGenerationContext context) {
                assertEquals("de_example_sys-addon", context.pluginFolder());
                assertEquals("sys_probe_demo", context.systemModel().eGet(
                        context.systemModel().eClass().getEStructuralFeature("name")));
                assertEquals(1, context.rosNodes().size());
                assertEquals(1, context.resolvedNodes().size());
                assertEquals(1, context.resolvedPackages().size());
                assertEquals("type_pkg", context.resolvedPackages().get(0).getName());

                EObject sysTyped = context.systemTypedBlock("sys_probe");
                assertNotNull(sysTyped);
                String sysMode = (String) sysTyped.eGet(sysProbeSchema.getEStructuralFeature("mode"));

                EObject nodeTyped = context.rosNodeTypedBlock(context.rosNodes().get(0), "sys_probe");
                assertNotNull(nodeTyped);
                String nodeMode = (String) nodeTyped.eGet(sysProbeSchema.getEStructuralFeature("mode"));
                int nodeRate = (Integer) nodeTyped.eGet(sysProbeSchema.getEStructuralFeature("rate"));
                assertEquals("override", nodeMode);
                assertEquals(50, nodeRate);

                context.writeFile("config/" + context.pluginFolder() + "/probe.yaml",
                        "sys_mode: " + sysMode + "\nnode_mode: " + nodeMode + "\nrate: " + nodeRate + "\n");
                context.writeFile("launch/" + context.pluginFolder() + "/addon.launch.py",
                        "# addon launch\n");
                context.writeFile("plugins/" + context.pluginFolder() + "/notes.txt",
                        "distro=" + context.rosDistro() + "\n");
                context.writeOnce("config/" + context.pluginFolder() + "/user_cfg.yaml", "initial: true\n");
                context.deleteStaleFile("config/" + context.pluginFolder() + "/obsolete.yaml");

                Map<String, SystemGenerationContext.LaunchArgumentValue> args = new LinkedHashMap<>();
                args.put("mode", SystemGenerationContext.LaunchArgumentValue.literal("a'b\"c"));
                args.put("ns", SystemGenerationContext.LaunchArgumentValue.systemLaunchArgument("robot_ns"));
                args.put("expr", SystemGenerationContext.LaunchArgumentValue.substitution("$(var robot_ns)/sub"));
                context.addLaunchInclude("launch/" + context.pluginFolder() + "/addon.launch.py", args);
            }
        };
    }

    private Resource loadSimpleSystemFixture() throws Exception {
        XtextResourceSet rs = rosSystemInjector.getInstance(XtextResourceSet.class);
        loadFromString(rs, "inmemory:/bad_sys_type.ros2", """
                bad_sys_type:
                  artifacts:
                    n_art:
                      node: n_node
                """);
        Resource sysRes = loadFromString(rs, "inmemory:/bad_sys.rossystem", """
                bad_sys:
                  parameters:
                    declared_ns:
                      type: String
                      value: "ok"
                  nodes:
                    inst:
                      from: "bad_sys_type.n_node"
                """);
        EcoreUtil.resolveAll(rs);
        return sysRes;
    }

    @Test
    public void systemLevelGenerationScopedFoldersAndPurePythonSupport() throws Exception {
        EClass sysProbeSchema = createSchemaClass("SysProbeBlock", Map.of(
                "mode", EcorePackage.Literals.ESTRING,
                "rate", EcorePackage.Literals.EINT));
        sysProbeSchema.getEStructuralFeature("mode").setLowerBound(1);
        BlockDescriptor sysProbeBlock = new BlockDescriptor(
                "sys_probe",
                sysProbeSchema,
                EnumSet.of(HookLocation.SYSTEM, HookLocation.ROS_NODE, HookLocation.NODE),
                Map.of("mode", MergeStrategy.INSTANCE_OVERRIDES_TYPE, "rate", MergeStrategy.INSTANCE_OVERRIDES_TYPE),
                "System probe block");

        PluginRegistry.INSTANCE.register(createSysAddonPlugin(sysProbeSchema, sysProbeBlock));
        Resource sysRes = loadSysProbeFixture(sysProbeBlock);
        RosSystemGenerator sysGen = rosSystemInjector.getInstance(RosSystemGenerator.class);

        // 1. Standard CMake bringup package + writeOnce shield + stale prune
        InMemoryFileSystemAccess cmakeFsa = new InMemoryFileSystemAccess();
        RosSystemGenerator.SystemGenerationOutcome cmakeOutcome = sysGen.generateSystemWithPlugins(
                sysRes,
                cmakeFsa,
                List.of("sys_probe_demo/config/de_example_sys-addon/user_cfg.yaml"),
                "jazzy");
        assertTrue("Expected zero system errors: " + cmakeOutcome.errors, cmakeOutcome.errors.isEmpty());
        assertFalse("writeOnce must skip existing user_cfg.yaml",
                cmakeFsa.getTextFiles().containsKey(
                        "DEFAULT_OUTPUTsys_probe_demo/config/de_example_sys-addon/user_cfg.yaml"));
        assertTrue(cmakeOutcome.pluginDeletedFiles.contains(
                "sys_probe_demo/config/de_example_sys-addon/obsolete.yaml"));
        String probeYaml = cmakeFsa.getTextFiles()
                .get("DEFAULT_OUTPUTsys_probe_demo/config/de_example_sys-addon/probe.yaml").toString();
        assertTrue(probeYaml, probeYaml.contains("sys_mode: active"));
        assertTrue(probeYaml, probeYaml.contains("node_mode: override"));
        assertTrue(probeYaml, probeYaml.contains("rate: 50"));

        // 2. Pure-Python bringup package: generated setup.py gets _recursive_data_files and no warning
        InMemoryFileSystemAccess pyFsa = new InMemoryFileSystemAccess();
        RosSystemGenerator.SystemGenerationOutcome pyOutcome = sysGen.generateSystemWithPlugins(
                sysRes,
                pyFsa,
                List.of("sys_probe_demo/py_helper.py"),
                "jazzy");
        assertTrue("Expected zero pure-Python system errors: " + pyOutcome.errors, pyOutcome.errors.isEmpty());
        assertTrue("Generated setup.py must not warn about skipped install", pyOutcome.warnings.isEmpty());
        String setupPy = pyFsa.getTextFiles().get("DEFAULT_OUTPUTsys_probe_demo/setup.py").toString();
        assertTrue(setupPy, setupPy.contains("def _recursive_data_files(base_dir):"));
        assertTrue(setupPy, setupPy.contains("_recursive_data_files('config/de_example_sys-addon')"));
        assertTrue(setupPy, setupPy.contains("_recursive_data_files('launch/de_example_sys-addon')"));
    }

    @Test
    public void systemLaunchIncludeRendersScopedGroupAction() throws Exception {
        EClass sysProbeSchema = createSchemaClass("SysProbeBlock", Map.of(
                "mode", EcorePackage.Literals.ESTRING,
                "rate", EcorePackage.Literals.EINT));
        sysProbeSchema.getEStructuralFeature("mode").setLowerBound(1);
        BlockDescriptor sysProbeBlock = new BlockDescriptor(
                "sys_probe",
                sysProbeSchema,
                EnumSet.of(HookLocation.SYSTEM, HookLocation.ROS_NODE, HookLocation.NODE),
                Map.of("mode", MergeStrategy.INSTANCE_OVERRIDES_TYPE, "rate", MergeStrategy.INSTANCE_OVERRIDES_TYPE),
                "System probe block");

        Resource sysRes = loadSysProbeFixture(sysProbeBlock);
        RosSystemGenerator sysGen = rosSystemInjector.getInstance(RosSystemGenerator.class);

        // Baseline without plugin includes must not import or emit GroupAction
        InMemoryFileSystemAccess noPluginFsa = new InMemoryFileSystemAccess();
        RosSystemGenerator.SystemGenerationOutcome noPluginOut = sysGen.generateSystemWithPlugins(
                sysRes, noPluginFsa, List.of(), "jazzy");
        assertTrue(noPluginOut.errors.isEmpty());
        String baselineLaunch = noPluginFsa.getTextFiles()
                .get("DEFAULT_OUTPUTsys_probe_demo/launch/sys_probe_demo.launch.py").toString();
        assertFalse("Baseline launch without plugin includes must not mention GroupAction:\n" + baselineLaunch,
                baselineLaunch.contains("GroupAction"));

        // With plugin include: rendered inside GroupAction(actions=[IncludeLaunchDescription(...)], scoped=True)
        PluginRegistry.INSTANCE.register(createSysAddonPlugin(sysProbeSchema, sysProbeBlock));
        InMemoryFileSystemAccess cmakeFsa = new InMemoryFileSystemAccess();
        RosSystemGenerator.SystemGenerationOutcome cmakeOutcome = sysGen.generateSystemWithPlugins(
                sysRes,
                cmakeFsa,
                List.of("sys_probe_demo/config/de_example_sys-addon/user_cfg.yaml"),
                "jazzy");
        assertTrue("Expected zero system errors: " + cmakeOutcome.errors, cmakeOutcome.errors.isEmpty());
        String launchPy = cmakeFsa.getTextFiles()
                .get("DEFAULT_OUTPUTsys_probe_demo/launch/sys_probe_demo.launch.py").toString();
        assertTrue(launchPy, launchPy.contains("from launch.actions import GroupAction, IncludeLaunchDescription, DeclareLaunchArgument"));
        assertTrue(launchPy, launchPy.contains("GroupAction("));
        assertTrue(launchPy, launchPy.contains("scoped=True"));
        assertTrue(launchPy, launchPy.contains("IncludeLaunchDescription("));
        assertTrue(launchPy, launchPy.contains("/launch/de_example_sys-addon/addon.launch.py"));
        assertTrue(launchPy, launchPy.contains("TextSubstitution(text=\"a'b\\\"c\")"));
        assertTrue(launchPy, launchPy.contains("LaunchConfiguration('robot_ns')"));
        assertTrue(launchPy, launchPy.contains("parse_substitution(\"$(var robot_ns)/sub\")"));
    }

    @Test
    public void purePythonUserOwnedSetupPyEmitsWarningAndKeepsInclude() throws Exception {
        EClass sysProbeSchema = createSchemaClass("SysProbeBlock", Map.of(
                "mode", EcorePackage.Literals.ESTRING,
                "rate", EcorePackage.Literals.EINT));
        sysProbeSchema.getEStructuralFeature("mode").setLowerBound(1);
        BlockDescriptor sysProbeBlock = new BlockDescriptor(
                "sys_probe",
                sysProbeSchema,
                EnumSet.of(HookLocation.SYSTEM, HookLocation.ROS_NODE, HookLocation.NODE),
                Map.of("mode", MergeStrategy.INSTANCE_OVERRIDES_TYPE, "rate", MergeStrategy.INSTANCE_OVERRIDES_TYPE),
                "System probe block");

        PluginRegistry.INSTANCE.register(createSysAddonPlugin(sysProbeSchema, sysProbeBlock));
        Resource sysRes = loadSysProbeFixture(sysProbeBlock);
        RosSystemGenerator sysGen = rosSystemInjector.getInstance(RosSystemGenerator.class);

        InMemoryFileSystemAccess userSetupFsa = new InMemoryFileSystemAccess();
        RosSystemGenerator.SystemGenerationOutcome userSetupOut = sysGen.generateSystemWithPlugins(
                sysRes,
                userSetupFsa,
                List.of("sys_probe_demo/py_helper.py", "sys_probe_demo/setup.py"),
                "jazzy");
        assertFalse("User-owned setup.py must never be overwritten",
                userSetupFsa.getTextFiles().containsKey("DEFAULT_OUTPUTsys_probe_demo/setup.py"));
        assertTrue("Must warn when user-owned setup.py prevents installing plugin config/launch folders: " + userSetupOut.warnings,
                userSetupOut.warnings.stream().anyMatch(w ->
                        w.contains("de.example.sys-addon")
                                && w.contains("config/de_example_sys-addon")
                                && w.contains("launch/de_example_sys-addon")));
        String userSetupLaunch = userSetupFsa.getTextFiles()
                .get("DEFAULT_OUTPUTsys_probe_demo/launch/sys_probe_demo.launch.py").toString();
        assertTrue("Launch file must still keep the plugin include when setup.py is user-owned",
                userSetupLaunch.contains("IncludeLaunchDescription("));
    }

    @Test
    public void systemLevelRejectsDisallowedPathsAndDuplicateIncludeAcrossPlugins() throws Exception {
        Resource sysRes = loadSimpleSystemFixture();
        RosSystemGenerator sysGen = rosSystemInjector.getInstance(RosSystemGenerator.class);

        List<String> forbiddenPaths = List.of(
                "launch/other.launch.py",
                "launch/bad_sys.launch.py",
                "config/inst.yaml",
                "CMakeLists.txt",
                "package.xml",
                "setup.py",
                "setup.cfg",
                "README.md",
                "resource/bad_sys.puml",
                "config/de_example_other/hack.yaml");

        for (String badPath : forbiddenPaths) {
            PluginRegistry.INSTANCE.clearRegistered();
            PluginRegistry.INSTANCE.register(new RosToolingPlugin() {
                @Override public String id() { return "de.example.bad_sys_writer"; }
                @Override public List<BlockDescriptor> blocks() { return List.of(); }
                @Override public void validate(final ValidationContext context) {}
                @Override public void generateSystem(final SystemGenerationContext context) {
                    context.writeFile(badPath, "evil");
                }
            });
            InMemoryFileSystemAccess fsa = new InMemoryFileSystemAccess();
            RosSystemGenerator.SystemGenerationOutcome out =
                    sysGen.generateSystemWithPlugins(sysRes, fsa, List.of(), "jazzy");
            assertFalse("Path must be rejected: " + badPath, out.errors.isEmpty());
            assertTrue("Error must name plugin for " + badPath + ": " + out.errors,
                    out.errors.stream().anyMatch(e -> e.contains("de.example.bad_sys_writer")));
            assertTrue("Plugin files must be withheld for " + badPath, out.pluginFiles.isEmpty());
        }

        // Duplicate include path across two plugins whose sanitized folders collide names both plugins
        PluginRegistry.INSTANCE.clearRegistered();
        PluginRegistry.INSTANCE.register(new RosToolingPlugin() {
            @Override public String id() { return "de.example.dup.inc"; }
            @Override public List<BlockDescriptor> blocks() { return List.of(); }
            @Override public void validate(final ValidationContext context) {}
            @Override public void generateSystem(final SystemGenerationContext context) {
                context.addLaunchInclude("launch/" + context.pluginFolder() + "/inc.launch.py", Map.of());
            }
        });
        PluginRegistry.INSTANCE.register(new RosToolingPlugin() {
            @Override public String id() { return "de.example.dup_inc"; }
            @Override public List<BlockDescriptor> blocks() { return List.of(); }
            @Override public void validate(final ValidationContext context) {}
            @Override public void generateSystem(final SystemGenerationContext context) {
                context.addLaunchInclude("launch/" + context.pluginFolder() + "/inc.launch.py", Map.of());
            }
        });
        InMemoryFileSystemAccess dupIncFsa = new InMemoryFileSystemAccess();
        RosSystemGenerator.SystemGenerationOutcome dupIncOut =
                sysGen.generateSystemWithPlugins(sysRes, dupIncFsa, List.of(), "jazzy");
        assertTrue("Duplicate launch include across plugins must name both: " + dupIncOut.errors,
                dupIncOut.errors.stream().anyMatch(e ->
                        e.contains("de.example.dup.inc") && e.contains("de.example.dup_inc") && e.contains("inc.launch.py")));
        assertFalse("Conflicted launch include must not be rendered",
                dupIncFsa.getTextFiles().get("DEFAULT_OUTPUTbad_sys/launch/bad_sys.launch.py")
                        .toString().contains("IncludeLaunchDescription("));
    }

    @Test
    public void twoPluginsCanPassNsWithDifferentValuesToOwnIncludes() throws Exception {
        Resource sysRes = loadSimpleSystemFixture();
        RosSystemGenerator sysGen = rosSystemInjector.getInstance(RosSystemGenerator.class);

        PluginRegistry.INSTANCE.register(new RosToolingPlugin() {
            @Override public String id() { return "de.example.sys_a"; }
            @Override public List<BlockDescriptor> blocks() { return List.of(); }
            @Override public void validate(final ValidationContext context) {}
            @Override public void generateSystem(final SystemGenerationContext context) {
                context.writeFile("launch/" + context.pluginFolder() + "/inc.launch.py", "# a");
                context.addLaunchInclude("launch/" + context.pluginFolder() + "/inc.launch.py",
                        Map.of("ns", SystemGenerationContext.LaunchArgumentValue.literal("ns_one")));
            }
        });
        PluginRegistry.INSTANCE.register(new RosToolingPlugin() {
            @Override public String id() { return "de.example.sys_b"; }
            @Override public List<BlockDescriptor> blocks() { return List.of(); }
            @Override public void validate(final ValidationContext context) {}
            @Override public void generateSystem(final SystemGenerationContext context) {
                context.writeFile("launch/" + context.pluginFolder() + "/inc.launch.py", "# b");
                context.addLaunchInclude("launch/" + context.pluginFolder() + "/inc.launch.py",
                        Map.of("ns", SystemGenerationContext.LaunchArgumentValue.literal("ns_two")));
            }
        });
        InMemoryFileSystemAccess independentFsa = new InMemoryFileSystemAccess();
        RosSystemGenerator.SystemGenerationOutcome independentOut =
                sysGen.generateSystemWithPlugins(sysRes, independentFsa, List.of(), "jazzy");
        assertTrue("Independent plugins passing 'ns' to own includes must succeed: " + independentOut.errors,
                independentOut.errors.isEmpty());
        String independentLaunch = independentFsa.getTextFiles()
                .get("DEFAULT_OUTPUTbad_sys/launch/bad_sys.launch.py").toString();
        assertEquals(2, countOccurrences(independentLaunch, "scoped=True"));
        assertTrue(independentLaunch, independentLaunch.contains("ns_one"));
        assertTrue(independentLaunch, independentLaunch.contains("ns_two"));
    }

    @Test
    public void duplicateLaunchArgumentNameOnOneIncludeIsRejected() throws Exception {
        Resource sysRes = loadSimpleSystemFixture();
        RosSystemGenerator sysGen = rosSystemInjector.getInstance(RosSystemGenerator.class);

        PluginRegistry.INSTANCE.register(new RosToolingPlugin() {
            @Override public String id() { return "de.example.dup_arg"; }
            @Override public List<BlockDescriptor> blocks() { return List.of(); }
            @Override public void validate(final ValidationContext context) {}
            @Override public void generateSystem(final SystemGenerationContext context) {
                context.writeFile("launch/" + context.pluginFolder() + "/inc.launch.py", "# dup arg");
                context.addLaunchInclude("launch/" + context.pluginFolder() + "/inc.launch.py", List.of(
                        new SystemGenerationContext.LaunchArgument("ns", SystemGenerationContext.LaunchArgumentValue.literal("a")),
                        new SystemGenerationContext.LaunchArgument("ns", SystemGenerationContext.LaunchArgumentValue.literal("b"))));
            }
        });
        InMemoryFileSystemAccess dupArgFsa = new InMemoryFileSystemAccess();
        RosSystemGenerator.SystemGenerationOutcome dupArgOut =
                sysGen.generateSystemWithPlugins(sysRes, dupArgFsa, List.of(), "jazzy");
        assertTrue("Duplicate arg on same include must error: " + dupArgOut.errors,
                dupArgOut.errors.stream().anyMatch(e -> e.contains("de.example.dup_arg") && e.contains("ns")));
        assertTrue("Plugin files must be withheld on duplicate launch arg", dupArgOut.pluginFiles.isEmpty());
    }

    @Test
    public void undeclaredSystemLaunchArgumentIsRejected() throws Exception {
        Resource sysRes = loadSimpleSystemFixture();
        RosSystemGenerator sysGen = rosSystemInjector.getInstance(RosSystemGenerator.class);

        PluginRegistry.INSTANCE.register(new RosToolingPlugin() {
            @Override public String id() { return "de.example.bad_sys_arg"; }
            @Override public List<BlockDescriptor> blocks() { return List.of(); }
            @Override public void validate(final ValidationContext context) {}
            @Override public void generateSystem(final SystemGenerationContext context) {
                context.writeFile("launch/" + context.pluginFolder() + "/inc.launch.py", "# bad sys arg");
                context.addLaunchInclude("launch/" + context.pluginFolder() + "/inc.launch.py",
                        Map.of("ns", SystemGenerationContext.LaunchArgumentValue.systemLaunchArgument("missing_launch_arg")));
            }
        });
        InMemoryFileSystemAccess badSysArgFsa = new InMemoryFileSystemAccess();
        RosSystemGenerator.SystemGenerationOutcome badSysArgOut =
                sysGen.generateSystemWithPlugins(sysRes, badSysArgFsa, List.of(), "jazzy");
        assertTrue("Undeclared SYSTEM_LAUNCH_ARG must fail naming plugin and arg: " + badSysArgOut.errors,
                badSysArgOut.errors.stream().anyMatch(e ->
                        e.contains("de.example.bad_sys_arg") && e.contains("missing_launch_arg")));
        assertTrue("Plugin files must be withheld on undeclared SYSTEM_LAUNCH_ARG", badSysArgOut.pluginFiles.isEmpty());
        String withheldLaunch = badSysArgFsa.getTextFiles()
                .get("DEFAULT_OUTPUTbad_sys/launch/bad_sys.launch.py").toString();
        assertFalse("Launch file must NOT include invalid plugin launches:\n" + withheldLaunch,
                withheldLaunch.contains("IncludeLaunchDescription("));
    }

    @Test
    public void systemLevelRunsOnFromFileSubSystemsAndAcrossAllDistros() throws Exception {
        XtextResourceSet rs = rosSystemInjector.getInstance(XtextResourceSet.class);
        loadFromString(rs, "inmemory:/distro_node.ros2", """
                distro_node_pkg:
                  artifacts:
                    cam_art:
                      node: cam_node
                """);
        Resource subRes = loadFromString(rs, "inmemory:/ur_sub.rossystem", """
                ur_sub:
                  fromFile: "ur_robot_driver/launch/ur_control.launch.py"
                """);
        Resource parentRes = loadFromString(rs, "inmemory:/parent_sys.rossystem", """
                parent_sys:
                  subSystems:
                    ur_sub
                  nodes:
                    cam:
                      from: "distro_node_pkg.cam_node"
                """);
        EcoreUtil.resolveAll(rs);

        List<String> visitedSystems = new ArrayList<>();
        List<String> pkgDistros = new ArrayList<>();
        List<String> sysDistros = new ArrayList<>();

        PluginRegistry.INSTANCE.register(new RosToolingPlugin() {
            @Override public String id() { return "de.example.distro_probe"; }
            @Override public List<BlockDescriptor> blocks() { return List.of(); }
            @Override public void validate(final ValidationContext context) {}
            @Override public void generatePackage(final PackageGenerationContext context) {
                Ros2Distro d = context.ros2Distro();
                assertNotNull(d);
                assertEquals(d.name(), context.rosDistro());
                pkgDistros.add(d.name() + ":" + d.cxxStandard() + ":" + d.cmakeMinimumVersion());
                context.writeFile("plugins/de.example.distro_probe/distro.txt", d.name());
            }
            @Override public void generateSystem(final SystemGenerationContext context) {
                Ros2Distro d = context.ros2Distro();
                assertNotNull(d);
                assertEquals(d.name(), context.rosDistro());
                String sName = String.valueOf(context.systemModel().eGet(
                        context.systemModel().eClass().getEStructuralFeature("name")));
                visitedSystems.add(sName);
                sysDistros.add(d.name());
                context.writeFile("plugins/" + context.pluginFolder() + "/sys_" + d.name() + ".txt", sName);
                if ("ur_sub".equals(sName)) {
                    assertTrue(context.rosNodes().isEmpty());
                    assertTrue(context.coreOwnedPaths().contains("ur_sub/README.md"));
                    assertTrue(context.coreOwnedPaths().contains("ur_sub/resource/ur_sub.puml"));
                }
            }
        });

        Ros2Generator pkgGen = ros2Injector.getInstance(Ros2Generator.class);
        RosSystemGenerator sysGen = rosSystemInjector.getInstance(RosSystemGenerator.class);
        Resource pkgRes = rs.getResource(URI.createURI("inmemory:/distro_node.ros2"), false);

        for (Ros2Distro expected : Ros2Distros.all()) {
            InMemoryFileSystemAccess pFsa = new InMemoryFileSystemAccess();
            Ros2Generator.PluginGenerationOutcome pOut =
                    pkgGen.generateTargetedWithPlugins(pkgRes, pFsa, null, "cpp", expected.name(), List.of());
            assertTrue("Package errors for " + expected.name() + ": " + pOut.errors, pOut.errors.isEmpty());

            InMemoryFileSystemAccess sFsa = new InMemoryFileSystemAccess();
            RosSystemGenerator.SystemGenerationOutcome sOut =
                    sysGen.generateSystemWithPlugins(parentRes, sFsa, List.of(), expected.name());
            assertTrue("System errors for " + expected.name() + ": " + sOut.errors, sOut.errors.isEmpty());

            InMemoryFileSystemAccess subFsa = new InMemoryFileSystemAccess();
            RosSystemGenerator.SystemGenerationOutcome subOut =
                    sysGen.generateSystemWithPlugins(subRes, subFsa, List.of(), expected.name());
            assertTrue("fromFile subSystem errors for " + expected.name() + ": " + subOut.errors,
                    subOut.errors.isEmpty());
            assertTrue("fromFile plugin file must still be written",
                    subOut.pluginFiles.containsKey("ur_sub/plugins/de_example_distro_probe/sys_" + expected.name() + ".txt"));
        }

        assertEquals(Ros2Distros.all().size(), pkgDistros.size());
        assertEquals(Ros2Distros.all().size() * 2, sysDistros.size());
        assertTrue(visitedSystems.contains("parent_sys"));
        assertTrue(visitedSystems.contains("ur_sub"));
        for (Ros2Distro expected : Ros2Distros.all()) {
            assertTrue(pkgDistros.contains(
                    expected.name() + ":" + expected.cxxStandard() + ":" + expected.cmakeMinimumVersion()));
            assertTrue(sysDistros.contains(expected.name()));
        }
    }

    @Test
    public void externalCompiledPluginJarAndOsgiServiceDiscoveryRespectOptIn() throws Exception {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        assertNotNull("JDK compiler must be available for standalone JAR test", compiler);

        Path tempRoot = Files.createTempDirectory("rostooling-ext-jar-");
        try {
            Path srcDir = tempRoot.resolve("src");
            Path clsDir = tempRoot.resolve("cls");
            Files.createDirectories(clsDir);
            Path srcFile = srcDir.resolve("de/example/compiled/CompiledExtPlugin.java");
            Files.createDirectories(srcFile.getParent());
            Files.writeString(srcFile, """
                    package de.example.compiled;
                    import de.fraunhofer.ipa.ros.plugin.spi.*;
                    import java.util.List;
                    public final class CompiledExtPlugin implements RosToolingPlugin {
                        @Override public String id() { return "de.example.compiled_ext"; }
                        @Override public List<BlockDescriptor> blocks() { return List.of(); }
                        @Override public void validate(ValidationContext context) {}
                        @Override public void generatePackage(PackageGenerationContext context) {
                            context.writeFile("plugins/de.example.compiled_ext/ok.txt", "jar:" + context.rosDistro());
                        }
                    }
                    """, StandardCharsets.UTF_8);

            String spiCp = resolveBundleOrClassLocation(RosToolingPlugin.class);
            String ecoreCp = resolveBundleOrClassLocation(EObject.class);
            String rosCp = resolveBundleOrClassLocation(ros.Package.class);
            String distroCp = resolveBundleOrClassLocation(Ros2Distro.class);
            Set<String> cpEntries = new LinkedHashSet<>();
            for (String p : List.of(spiCp, ecoreCp, rosCp, distroCp)) {
                if (p != null && !p.isBlank()) {
                    cpEntries.add(p);
                }
            }
            int rc = compiler.run(null, null, null,
                    "-cp", String.join(File.pathSeparator, cpEntries),
                    "-d", clsDir.toString(),
                    srcFile.toString());
            assertEquals("Compiling standalone external plugin JAR must succeed", 0, rc);

            Path jarPath = tempRoot.resolve("compiled-ext-plugin.jar");
            try (JarOutputStream jos = new JarOutputStream(Files.newOutputStream(jarPath))) {
                JarEntry clsEntry = new JarEntry("de/example/compiled/CompiledExtPlugin.class");
                jos.putNextEntry(clsEntry);
                jos.write(Files.readAllBytes(clsDir.resolve("de/example/compiled/CompiledExtPlugin.class")));
                jos.closeEntry();

                JarEntry svcEntry = new JarEntry("META-INF/services/de.fraunhofer.ipa.ros.plugin.spi.RosToolingPlugin");
                jos.putNextEntry(svcEntry);
                jos.write("de.example.compiled.CompiledExtPlugin\n".getBytes(StandardCharsets.UTF_8));
                jos.closeEntry();
            }

            // Rule 4: passive until explicitly enabled
            PluginRegistry.INSTANCE.loadFromPaths(List.of(jarPath), Set.of());
            assertTrue("Plugin must NOT activate unless explicitly enabled",
                    PluginRegistry.INSTANCE.activePlugins().isEmpty());

            PluginRegistry.INSTANCE.loadFromPaths(List.of(jarPath), Set.of("de.example.compiled_ext"));
            assertEquals(1, PluginRegistry.INSTANCE.activePlugins().size());
            assertEquals("de.example.compiled_ext", PluginRegistry.INSTANCE.activePlugins().get(0).id());

            XtextResourceSet rs = ros2Injector.getInstance(XtextResourceSet.class);
            Resource pkgRes = loadFromString(rs, "inmemory:/jar_pkg.ros2", """
                    jar_pkg:
                      artifacts:
                        a1:
                          node: n1
                    """);
            EcoreUtil.resolveAll(rs);
            Ros2Generator gen = ros2Injector.getInstance(Ros2Generator.class);
            InMemoryFileSystemAccess fsa = new InMemoryFileSystemAccess();
            Ros2Generator.PluginGenerationOutcome out =
                    gen.generateTargetedWithPlugins(pkgRes, fsa, null, "cpp", "jazzy", List.of());
            assertTrue("External JAR plugin generation errors: " + out.errors, out.errors.isEmpty());
            assertTrue(out.pluginFiles.containsKey("jar_pkg/plugins/de.example.compiled_ext/ok.txt"));

            // Also verify OSGi service discovery when running inside Equinox OSGi (Tycho Eclipse runtime)
            Bundle spiBundle = FrameworkUtil.getBundle(PluginRegistry.class);
            BundleContext bc = spiBundle != null ? spiBundle.getBundleContext() : null;
            if (bc != null) {
                RosToolingPlugin osgiPlugin = new RosToolingPlugin() {
                    @Override public String id() { return "de.example.osgi_ext"; }
                    @Override public List<BlockDescriptor> blocks() { return List.of(); }
                    @Override public void validate(final ValidationContext context) {}
                };
                ServiceRegistration<RosToolingPlugin> reg = bc.registerService(
                        RosToolingPlugin.class, osgiPlugin, null);
                try {
                    PluginRegistry.INSTANCE.loadFromPaths(List.of(), Set.of("de.example.osgi_ext"));
                    assertNotNull("OSGi-registered plugin must be discovered when enabled",
                            PluginRegistry.INSTANCE.pluginById("de.example.osgi_ext"));
                } finally {
                    reg.unregister();
                    PluginRegistry.INSTANCE.clearRegistered();
                }
            }
        } finally {
            PluginRegistry.INSTANCE.clearRegistered();
            try (var walk = Files.walk(tempRoot)) {
                walk.sorted(java.util.Comparator.reverseOrder()).forEach(p -> {
                    try {
                        Files.deleteIfExists(p);
                    } catch (Exception ignored) {
                    }
                });
            }
        }
    }

    @Test
    public void setExtensionBlockWithoutModelTextProducesByteIdenticalOutput() throws Exception {
        EClass schema = createAuditSchema(null);
        PluginRegistry.INSTANCE.register(new RosToolingPlugin() {
            @Override public String id() { return "de.example.audit"; }
            @Override public List<BlockDescriptor> blocks() {
                return List.of(new BlockDescriptor(
                        "audit",
                        schema,
                        EnumSet.of(HookLocation.NODE),
                        Map.of(),
                        "Audit block"));
            }
            @Override public void validate(final ValidationContext context) {}
        });

        String initialText = """
                byte_pkg:
                  artifacts:
                    b:
                      node: n
                """;
        Path tempDir = Files.createTempDirectory("rostooling-setblock-");
        try {
            Path pkgFile = tempDir.resolve("byte_pkg.ros2");
            Files.writeString(pkgFile, initialText, StandardCharsets.UTF_8);
            String fileUri = pkgFile.toUri().toString();
            var rspReg = ros2IdeInjector.getInstance(IResourceServiceProvider.Registry.class);
            Map<String, Object> entries = Map.of("channel", "fast", "rate_hz", 50);

            Map<String, Object> withText = RosPluginCommandSupport.setExtensionBlock(
                    Map.of("fileUri", fileUri,
                            "modelPath", pkgFile.toString(),
                            "modelText", initialText,
                            "blockName", "audit",
                            "targetKind", "Node",
                            "targetName", "n",
                            "entries", entries),
                    null,
                    rspReg);
            Map<String, Object> withoutText = RosPluginCommandSupport.setExtensionBlock(
                    Map.of("fileUri", fileUri,
                            "modelPath", pkgFile.toString(),
                            "blockName", "audit",
                            "targetKind", "Node",
                            "targetName", "n",
                            "entries", entries),
                    null,
                    rspReg);

            assertEquals(Boolean.TRUE, withText.get("success"));
            assertEquals(Boolean.TRUE, withoutText.get("success"));
            assertEquals("spliced updatedText without modelText must be byte-identical",
                    withText.get("updatedText"), withoutText.get("updatedText"));

            // Also verify updating an existing @audit block without modelText is byte-identical
            String existingBlockText = String.valueOf(withText.get("updatedText"));
            Files.writeString(pkgFile, existingBlockText, StandardCharsets.UTF_8);
            Map<String, Object> updateEntries = Map.of("channel", "slow", "rate_hz", 10);
            Map<String, Object> updateWithText = RosPluginCommandSupport.setExtensionBlock(
                    Map.of("fileUri", fileUri,
                            "modelPath", pkgFile.toString(),
                            "modelText", existingBlockText,
                            "blockName", "audit",
                            "targetKind", "Node",
                            "targetName", "n",
                            "entries", updateEntries),
                    null,
                    rspReg);
            Map<String, Object> updateWithoutText = RosPluginCommandSupport.setExtensionBlock(
                    Map.of("fileUri", fileUri,
                            "modelPath", pkgFile.toString(),
                            "blockName", "audit",
                            "targetKind", "Node",
                            "targetName", "n",
                            "entries", updateEntries),
                    null,
                    rspReg);
            assertEquals(Boolean.TRUE, updateWithText.get("success"));
            assertEquals(Boolean.TRUE, updateWithoutText.get("success"));
            assertEquals(updateWithText.get("updatedText"), updateWithoutText.get("updatedText"));
        } finally {
            try (var walk = Files.walk(tempDir)) {
                walk.sorted(java.util.Comparator.reverseOrder()).forEach(p -> {
                    try { Files.deleteIfExists(p); } catch (Exception ignored) {}
                });
            }
        }
    }

    @Test
    public void deleteStaleFileRejectsPathsOutsideNamespacedPluginFolders() throws Exception {
        XtextResourceSet rs = ros2Injector.getInstance(XtextResourceSet.class);
        Resource res = loadFromString(rs, "inmemory:/del_pkg.ros2", """
                del_pkg:
                  artifacts:
                    base_art:
                      node: base_node
                """);
        EcoreUtil.resolveAll(rs);

        Ros2Generator pkgGen = ros2Injector.getInstance(Ros2Generator.class);
        for (String disallowed : List.of("src/helpers.cpp", "config/other.yaml")) {
            PluginRegistry.INSTANCE.clearRegistered();
            PluginRegistry.INSTANCE.register(new RosToolingPlugin() {
                @Override public String id() { return "de.example.bad_deleter"; }
                @Override public List<BlockDescriptor> blocks() { return List.of(); }
                @Override public void validate(final ValidationContext context) {}
                @Override public void generatePackage(final PackageGenerationContext context) {
                    context.writeFile("plugins/" + context.pluginFolder() + "/keep.txt", "should be withheld\n");
                    context.deleteStaleFile(disallowed);
                }
            });

            InMemoryFileSystemAccess fsa = new InMemoryFileSystemAccess();
            String fsaKey = "DEFAULT_OUTPUTdel_pkg/" + disallowed;
            fsa.generateFile("del_pkg/" + disallowed, "USER_CONTENT_MUST_SURVIVE\n");

            Ros2Generator.PluginGenerationOutcome out = pkgGen.generateTargetedWithPlugins(
                    res, fsa, null, "cpp", "jazzy", List.of("del_pkg/" + disallowed));
            assertFalse("Disallowed deleteStaleFile path must fail: " + disallowed, out.errors.isEmpty());
            assertTrue("Error must name plugin and path (" + disallowed + "): " + out.errors,
                    out.errors.stream().anyMatch(e ->
                            e.contains("de.example.bad_deleter") && e.contains("del_pkg/" + disallowed)));
            assertTrue("Nothing may be added to pluginDeletedFiles: " + out.pluginDeletedFiles,
                    out.pluginDeletedFiles.isEmpty());
            assertTrue("Plugin files must be withheld on deleteStaleFile error", out.pluginFiles.isEmpty());
            assertEquals("Pre-existing user file must remain untouched",
                    "USER_CONTENT_MUST_SURVIVE\n",
                    fsa.getTextFiles().get(fsaKey).toString());
        }

        // System level also rejects deleteStaleFile outside config/<pf>/, launch/<pf>/, plugins/<pf>/
        Resource sysRes = loadSimpleSystemFixture();
        RosSystemGenerator sysGen = rosSystemInjector.getInstance(RosSystemGenerator.class);
        PluginRegistry.INSTANCE.clearRegistered();
        PluginRegistry.INSTANCE.register(new RosToolingPlugin() {
            @Override public String id() { return "de.example.bad_sys_deleter"; }
            @Override public List<BlockDescriptor> blocks() { return List.of(); }
            @Override public void validate(final ValidationContext context) {}
            @Override public void generateSystem(final SystemGenerationContext context) {
                context.deleteStaleFile("config/other.yaml");
            }
        });
        InMemoryFileSystemAccess sysFsa = new InMemoryFileSystemAccess();
        RosSystemGenerator.SystemGenerationOutcome sysOut =
                sysGen.generateSystemWithPlugins(sysRes, sysFsa, List.of("bad_sys/config/other.yaml"), "jazzy");
        assertTrue("System deleteStaleFile error must name plugin and path: " + sysOut.errors,
                sysOut.errors.stream().anyMatch(e ->
                        e.contains("de.example.bad_sys_deleter") && e.contains("bad_sys/config/other.yaml")));
        assertTrue(sysOut.pluginDeletedFiles.isEmpty());
    }

    @Test
    public void generationContextNoticesArePrefixedWithPluginIdAndNeverBlockOutput() throws Exception {
        XtextResourceSet pkgRs = ros2Injector.getInstance(XtextResourceSet.class);
        String pkgModel = """
                notice_pkg:
                  artifacts:
                    talker:
                      node: talker_node
                """;
        Resource pkgRes = loadFromString(pkgRs, "inmemory:/notice_pkg.ros2", pkgModel);
        EcoreUtil.resolveAll(pkgRs);

        Ros2Generator pkgGen = ros2Injector.getInstance(Ros2Generator.class);
        InMemoryFileSystemAccess baselinePkgFsa = new InMemoryFileSystemAccess();
        Ros2Generator.PluginGenerationOutcome baselinePkgOut =
                pkgGen.generateTargetedWithPlugins(pkgRes, baselinePkgFsa, null, "cpp", "jazzy", List.of());
        assertTrue(baselinePkgOut.errors.isEmpty());
        assertTrue(baselinePkgOut.notices.isEmpty());
        Map<String, String> baselinePkgFiles = new LinkedHashMap<>();
        baselinePkgFsa.getTextFiles().forEach((k, v) -> baselinePkgFiles.put(k, v.toString()));

        Resource sysBaselineRes = loadSimpleSystemFixture();
        RosSystemGenerator sysGen = rosSystemInjector.getInstance(RosSystemGenerator.class);
        InMemoryFileSystemAccess baselineSysFsa = new InMemoryFileSystemAccess();
        RosSystemGenerator.SystemGenerationOutcome baselineSysOut =
                sysGen.generateSystemWithPlugins(sysBaselineRes, baselineSysFsa, List.of(), "jazzy");
        assertTrue(baselineSysOut.errors.isEmpty());
        assertTrue(baselineSysOut.notices.isEmpty());
        Map<String, String> baselineSysFiles = new LinkedHashMap<>();
        baselineSysFsa.getTextFiles().forEach((k, v) -> baselineSysFiles.put(k, v.toString()));

        PluginRegistry.INSTANCE.clearRegistered();
        PluginRegistry.INSTANCE.register(new RosToolingPlugin() {
            @Override public String id() { return "de.example.notifier"; }
            @Override public List<BlockDescriptor> blocks() { return List.of(); }
            @Override public void validate(final ValidationContext context) {}

            @Override
            public void generatePackage(final PackageGenerationContext context) {
                context.addNotice(null);
                context.addNotice("   ");
                context.addNotice("TalkerLeaf: port goal_pose renamed to target_pose; update TalkerLeafLogic.hpp");
                context.addNotice("[de.example.notifier] already prefixed notice");
                assertEquals(2, context.notices().size());
                try {
                    context.notices().add("mut");
                    throw new AssertionError("context.notices() must be unmodifiable");
                } catch (UnsupportedOperationException expected) {
                    // expected
                }
            }

            @Override
            public void generateSystem(final SystemGenerationContext context) {
                context.addNotice("SystemLeaf: review launch wiring");
            }
        });

        InMemoryFileSystemAccess noticePkgFsa = new InMemoryFileSystemAccess();
        Ros2Generator.PluginGenerationOutcome noticePkgOut =
                pkgGen.generateTargetedWithPlugins(pkgRes, noticePkgFsa, null, "cpp", "jazzy", List.of());
        assertTrue("Notices must never create errors: " + noticePkgOut.errors, noticePkgOut.errors.isEmpty());
        assertEquals(List.of(
                "[de.example.notifier] TalkerLeaf: port goal_pose renamed to target_pose; update TalkerLeafLogic.hpp",
                "[de.example.notifier] already prefixed notice"),
                noticePkgOut.notices);
        Map<String, String> actualPkgFiles = new LinkedHashMap<>();
        noticePkgFsa.getTextFiles().forEach((k, v) -> actualPkgFiles.put(k, v.toString()));
        assertEquals("Package output without plugin-written files must remain byte-identical",
                baselinePkgFiles, actualPkgFiles);

        InMemoryFileSystemAccess noticeSysFsa = new InMemoryFileSystemAccess();
        RosSystemGenerator.SystemGenerationOutcome noticeSysOut =
                sysGen.generateSystemWithPlugins(sysBaselineRes, noticeSysFsa, List.of(), "jazzy");
        assertTrue("System notices must never create errors: " + noticeSysOut.errors, noticeSysOut.errors.isEmpty());
        assertEquals(List.of("[de.example.notifier] SystemLeaf: review launch wiring"), noticeSysOut.notices);
        Map<String, String> actualSysFiles = new LinkedHashMap<>();
        noticeSysFsa.getTextFiles().forEach((k, v) -> actualSysFiles.put(k, v.toString()));
        assertEquals("System output without plugin-written files must remain byte-identical",
                baselineSysFiles, actualSysFiles);

        // Verify LSP command result maps surface notices without blocking files
        Path tempDir = Files.createTempDirectory("rostooling-notice-cmd-");
        try {
            Path pkgFile = tempDir.resolve("notice_pkg.ros2");
            Files.writeString(pkgFile, pkgModel, StandardCharsets.UTF_8);
            Path sysFile = tempDir.resolve("notice_sys.rossystem");
            Files.writeString(sysFile, """
                    notice_sys:
                      parameters:
                        mode:
                          type: String
                          value: "ok"
                    """, StandardCharsets.UTF_8);
            var rspReg = ros2IdeInjector.getInstance(IResourceServiceProvider.Registry.class);
            Map<String, Object> pkgCmdOut = RosPluginCommandSupport.generatePluginOutputs(
                    Map.of("fileUri", pkgFile.toUri().toString(),
                            "modelPath", pkgFile.toString(),
                            "language", "cpp",
                            "distro", "jazzy"),
                    null,
                    rspReg,
                    CancelIndicator.NullImpl);
            assertEquals("pkgCmdOut=" + pkgCmdOut, Boolean.TRUE, pkgCmdOut.get("success"));
            assertFalse(((Map<?, ?>) pkgCmdOut.get("files")).isEmpty());
            assertEquals(List.of(
                    "[de.example.notifier] TalkerLeaf: port goal_pose renamed to target_pose; update TalkerLeafLogic.hpp",
                    "[de.example.notifier] already prefixed notice"),
                    pkgCmdOut.get("notices"));

            var sysRspReg = rosSystemInjector.getInstance(IResourceServiceProvider.Registry.class);
            Map<String, Object> sysCmdOut = RosPluginCommandSupport.generatePluginOutputs(
                    Map.of("fileUri", sysFile.toUri().toString(),
                            "modelPath", sysFile.toString(),
                            "distro", "jazzy"),
                    null,
                    sysRspReg,
                    CancelIndicator.NullImpl);
            assertEquals("sysCmdOut=" + sysCmdOut, Boolean.TRUE, sysCmdOut.get("success"));
            assertFalse(((Map<?, ?>) sysCmdOut.get("files")).isEmpty());
            assertEquals(List.of("[de.example.notifier] SystemLeaf: review launch wiring"), sysCmdOut.get("notices"));
        } finally {
            try (var walk = Files.walk(tempDir)) {
                walk.sorted(java.util.Comparator.reverseOrder()).forEach(p -> {
                    try { Files.deleteIfExists(p); } catch (Exception ignored) {}
                });
            }
        }
    }

    @Test
    public void readOwnedFileEnforcesNamespacedOwnershipExistingFilesAndOutputRootSafety() throws Exception {
        Path tempRoot = Files.createTempDirectory("rostooling-readowned-");
        Path pkgRoot = tempRoot.resolve("src-gen").resolve("read_pkg");
        Path sysRoot = tempRoot.resolve("sys-gen");
        Path outsideSecret = tempRoot.resolve("outside_secret.txt");
        Path unreadableFile = null;
        try {
            Files.writeString(outsideSecret, "TOP_SECRET\n", StandardCharsets.UTF_8);

            // Seed package-level owned file + unreadable file + symlink escaping pkgRoot
            String pf = GenerationContext.sanitizePluginFolder("de.example.reader");
            Path ownedPkgFile = pkgRoot.resolve("plugins").resolve(pf).resolve("state.txt");
            Files.createDirectories(ownedPkgFile.getParent());
            Files.writeString(ownedPkgFile, "prev_state=v1\n", StandardCharsets.UTF_8);

            unreadableFile = pkgRoot.resolve("plugins").resolve(pf).resolve("locked.txt");
            Files.writeString(unreadableFile, "locked_data\n", StandardCharsets.UTF_8);
            try {
                Files.setPosixFilePermissions(unreadableFile, PosixFilePermissions.fromString("---------"));
            } catch (UnsupportedOperationException ignored) {
                unreadableFile = null;
            }
            Path dirAsFile = pkgRoot.resolve("plugins").resolve(pf).resolve("subdir");
            Files.createDirectories(dirAsFile);

            Path symlinkEscape = pkgRoot.resolve("plugins").resolve(pf).resolve("escape.txt");
            Files.createSymbolicLink(symlinkEscape, outsideSecret);

            // Seed system-level owned file under sysRoot/bad_sys/config/<pf>/prev.yaml
            Path ownedSysFile = sysRoot.resolve("bad_sys").resolve("config").resolve(pf).resolve("prev.yaml");
            Files.createDirectories(ownedSysFile.getParent());
            Files.writeString(ownedSysFile, "mode: previous\n", StandardCharsets.UTF_8);

            XtextResourceSet rs = ros2Injector.getInstance(XtextResourceSet.class);
            String pkgModel = """
                    read_pkg:
                      artifacts:
                        base_art:
                          node: base_node
                    """;
            Resource pkgRes = loadFromString(rs, "inmemory:/read_pkg.ros2", pkgModel);
            EcoreUtil.resolveAll(rs);

            final List<String> existingPkg = List.of(
                    "read_pkg/plugins/" + pf + "/state.txt",
                    "read_pkg/plugins/" + pf + "/locked.txt",
                    "read_pkg/plugins/" + pf + "/subdir",
                    "read_pkg/plugins/" + pf + "/escape.txt",
                    "read_pkg/CMakeLists.txt",
                    "read_pkg/plugins/de_example_other/other.txt",
                    "read_pkg/src/custom.cpp");

            final Map<String, Optional<String>> pkgReads = new LinkedHashMap<>();
            PluginRegistry.INSTANCE.clearRegistered();
            PluginRegistry.INSTANCE.register(new RosToolingPlugin() {
                @Override public String id() { return "de.example.reader"; }
                @Override public List<BlockDescriptor> blocks() { return List.of(); }
                @Override public void validate(final ValidationContext context) {}

                @Override
                public void generatePackage(final PackageGenerationContext context) {
                    pkgReads.put("owned", context.readOwnedFile("plugins/" + pf + "/state.txt"));
                    pkgReads.put("absent_in_existing", context.readOwnedFile("plugins/" + pf + "/missing_in_list.txt"));
                    pkgReads.put("dir_as_file", context.readOwnedFile("plugins/" + pf + "/subdir"));
                    if (Files.exists(pkgRoot.resolve("plugins/" + pf + "/locked.txt"))
                            && !Files.isReadable(pkgRoot.resolve("plugins/" + pf + "/locked.txt"))) {
                        pkgReads.put("unreadable", context.readOwnedFile("plugins/" + pf + "/locked.txt"));
                    }
                    context.addNotice("state=" + pkgReads.get("owned").orElse("none"));
                }

                @Override
                public void generateSystem(final SystemGenerationContext context) {
                    Optional<String> prev = context.readOwnedFile("config/" + pf + "/prev.yaml");
                    context.addNotice("sys_prev=" + prev.orElse("none").trim());
                }
            });

            Ros2Generator pkgGen = ros2Injector.getInstance(Ros2Generator.class);
            // 1. With outputRoot supplied -> owned path reads cleanly, non-existing/unreadable return empty without error
            InMemoryFileSystemAccess fsaWithRoot = new InMemoryFileSystemAccess();
            Ros2Generator.PluginGenerationOutcome outWithRoot = pkgGen.generateTargetedWithPlugins(
                    pkgRes, fsaWithRoot, null, "cpp", "jazzy", existingPkg, pkgRoot);
            assertTrue("Expected zero errors on valid/empty reads: " + outWithRoot.errors, outWithRoot.errors.isEmpty());
            assertEquals(Optional.of("prev_state=v1\n"), pkgReads.get("owned"));
            assertEquals(Optional.empty(), pkgReads.get("absent_in_existing"));
            assertEquals(Optional.empty(), pkgReads.get("dir_as_file"));
            if (pkgReads.containsKey("unreadable")) {
                assertEquals(Optional.empty(), pkgReads.get("unreadable"));
            }
            assertEquals(List.of("[de.example.reader] state=prev_state=v1"), outWithRoot.notices);

            // 2. Without outputRoot (null) -> readOwnedFile returns empty without blocking output
            pkgReads.clear();
            InMemoryFileSystemAccess fsaNoRoot = new InMemoryFileSystemAccess();
            Ros2Generator.PluginGenerationOutcome outNoRoot = pkgGen.generateTargetedWithPlugins(
                    pkgRes, fsaNoRoot, null, "cpp", "jazzy", existingPkg);
            assertTrue("No outputRoot must not fail: " + outNoRoot.errors, outNoRoot.errors.isEmpty());
            assertEquals(Optional.empty(), pkgReads.get("owned"));
            assertFalse(fsaNoRoot.getTextFiles().isEmpty());

            // 3. System generation with outputRoot + RosPluginCommandSupport.generatePluginOutputs
            Resource sysRes = loadSimpleSystemFixture();
            RosSystemGenerator sysGen = rosSystemInjector.getInstance(RosSystemGenerator.class);
            InMemoryFileSystemAccess sysFsa = new InMemoryFileSystemAccess();
            RosSystemGenerator.SystemGenerationOutcome sysOut = sysGen.generateSystemWithPlugins(
                    sysRes, sysFsa, List.of("bad_sys/config/" + pf + "/prev.yaml"), "jazzy", sysRoot);
            assertTrue("System readOwnedFile errors: " + sysOut.errors, sysOut.errors.isEmpty());
            assertEquals(List.of("[de.example.reader] sys_prev=mode: previous"), sysOut.notices);

            Path pkgModelFile = tempRoot.resolve("read_pkg.ros2");
            Files.writeString(pkgModelFile, pkgModel, StandardCharsets.UTF_8);
            var rspReg = ros2IdeInjector.getInstance(IResourceServiceProvider.Registry.class);
            Map<String, Object> cmdOut = RosPluginCommandSupport.generatePluginOutputs(
                    Map.of("fileUri", pkgModelFile.toUri().toString(),
                            "modelPath", pkgModelFile.toString(),
                            "language", "cpp",
                            "distro", "jazzy",
                            "existingFiles", existingPkg,
                            "outputRoot", pkgRoot.toString()),
                    null,
                    rspReg,
                    CancelIndicator.NullImpl);
            assertEquals("cmdOut=" + cmdOut, Boolean.TRUE, cmdOut.get("success"));
            assertEquals(List.of("[de.example.reader] state=prev_state=v1"), cmdOut.get("notices"));

            // 4. Reject disallowed paths, recording errors and returning empty:
            //    core-owned, non-namespaced, foreign plugin folder, .., absolute path, symlink escape
            List<String> disallowedPaths = List.of(
                    "CMakeLists.txt",
                    "src/custom.cpp",
                    "plugins/de_example_other/other.txt",
                    "plugins/" + pf + "/../../outside_secret.txt",
                    "/etc/passwd",
                    "plugins/" + pf + "/escape.txt");
            for (String badPath : disallowedPaths) {
                PluginRegistry.INSTANCE.clearRegistered();
                final Optional<?>[] observed = new Optional<?>[1];
                PluginRegistry.INSTANCE.register(new RosToolingPlugin() {
                    @Override public String id() { return "de.example.reader"; }
                    @Override public List<BlockDescriptor> blocks() { return List.of(); }
                    @Override public void validate(final ValidationContext context) {}
                    @Override public void generatePackage(final PackageGenerationContext context) {
                        observed[0] = context.readOwnedFile(badPath);
                    }
                });
                InMemoryFileSystemAccess badFsa = new InMemoryFileSystemAccess();
                Ros2Generator.PluginGenerationOutcome badOut = pkgGen.generateTargetedWithPlugins(
                        pkgRes, badFsa, null, "cpp", "jazzy", existingPkg, pkgRoot);
                assertEquals("Disallowed path must return empty: " + badPath, Optional.empty(), observed[0]);
                assertFalse("Disallowed readOwnedFile path must record an error: " + badPath, badOut.errors.isEmpty());
                assertTrue("Error must name plugin for path '" + badPath + "': " + badOut.errors,
                        badOut.errors.stream().anyMatch(e -> e.contains("de.example.reader")));
            }
        } finally {
            if (unreadableFile != null && Files.exists(unreadableFile)) {
                try {
                    Files.setPosixFilePermissions(unreadableFile, PosixFilePermissions.fromString("rw-r--r--"));
                } catch (Exception ignored) {
                }
            }
            try (var walk = Files.walk(tempRoot)) {
                walk.sorted(java.util.Comparator.reverseOrder()).forEach(p -> {
                    try { Files.deleteIfExists(p); } catch (Exception ignored) {}
                });
            }
        }
    }

    private static String resolveBundleOrClassLocation(final Class<?> clazz) throws Exception {
        Bundle b = FrameworkUtil.getBundle(clazz);
        if (b != null) {
            String loc = b.getLocation();
            if (loc != null && loc.startsWith("reference:")) {
                loc = loc.substring("reference:".length());
            }
            if (loc != null && loc.startsWith("file:")) {
                return Path.of(java.net.URI.create(loc)).toString();
            }
        }
        var cs = clazz.getProtectionDomain() != null ? clazz.getProtectionDomain().getCodeSource() : null;
        if (cs != null && cs.getLocation() != null) {
            return Path.of(cs.getLocation().toURI()).toString();
        }
        return null;
    }

    private static EClass createSchemaClass(final String name, final Map<String, EDataType> attrs) {
        EcoreFactory ef = EcoreFactory.eINSTANCE;
        EPackage ePkg = ef.createEPackage();
        ePkg.setName(name.toLowerCase());
        ePkg.setNsPrefix(name.toLowerCase());
        ePkg.setNsURI("http://example.org/" + name.toLowerCase());
        EClass cls = ef.createEClass();
        cls.setName(name);
        for (Map.Entry<String, EDataType> entry : attrs.entrySet()) {
            EAttribute attr = ef.createEAttribute();
            attr.setName(entry.getKey());
            attr.setEType(entry.getValue());
            cls.getEStructuralFeatures().add(attr);
        }
        ePkg.getEClassifiers().add(cls);
        return cls;
    }

    private static int countOccurrences(final String text, final String token) {
        int count = 0;
        int idx = 0;
        while ((idx = text.indexOf(token, idx)) >= 0) {
            count++;
            idx += token.length();
        }
        return count;
    }
}
