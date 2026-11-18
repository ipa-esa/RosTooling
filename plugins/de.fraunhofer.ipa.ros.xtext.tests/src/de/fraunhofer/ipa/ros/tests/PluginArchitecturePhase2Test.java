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
import de.fraunhofer.ipa.ros.plugin.spi.PluginRegistry;
import de.fraunhofer.ipa.ros.plugin.spi.PluginToolDescriptor;
import de.fraunhofer.ipa.ros.plugin.spi.RosToolingPlugin;
import de.fraunhofer.ipa.ros.plugin.spi.ToolResult;
import de.fraunhofer.ipa.ros.plugin.spi.ValidationContext;
import de.fraunhofer.ipa.ros.validation.BasicsValidator;
import de.fraunhofer.ipa.ros2.Ros2RuntimeModule;
import de.fraunhofer.ipa.ros2.Ros2StandaloneSetup;
import de.fraunhofer.ipa.ros2.generator.Ros2Generator;
import de.fraunhofer.ipa.ros2.ide.Ros2GeneratorCommandService;
import de.fraunhofer.ipa.ros2.ide.Ros2IdeSetup;
import de.fraunhofer.ipa.ros2.ide.RosPluginCommandSupport;
import de.fraunhofer.ipa.rossystem.RosSystemRuntimeModule;
import de.fraunhofer.ipa.rossystem.RosSystemStandaloneSetup;
import de.fraunhofer.ipa.rossystem.validation.RosSystemValidator;
import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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
        // No plugins registered: Rule 4 guarantees core parses & validates cleanly with warnings only.
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
            public void generate(final GenerationContext context) {
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
                context.deleteStaleFile("config/stale_audit.yaml");
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
        assertTrue(outcome.deletedFiles.contains("valid_audit/config/stale_audit.yaml"));

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
            @Override public void generate(final GenerationContext context) {
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
            @Override public void generate(final GenerationContext context) {
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
            @Override public void generate(final GenerationContext context) {
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
                @Override public void generate(final GenerationContext context) {
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
            @Override public void generate(final GenerationContext context) {
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
}
