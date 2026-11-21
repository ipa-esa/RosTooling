package de.fraunhofer.ipa.ros.glsp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.google.inject.Guice;
import com.google.inject.Injector;
import de.fraunhofer.ipa.ros.glsp.actions.RequestRosAutoConnectAction;
import de.fraunhofer.ipa.ros.glsp.actions.SetRosAutoConnectAction;
import de.fraunhofer.ipa.ros.glsp.handlers.RequestRosAutoConnectActionHandler;
import de.fraunhofer.ipa.ros.glsp.model.RosAstNodeModelSerializer;
import de.fraunhofer.ipa.ros.glsp.model.RosModelState;
import de.fraunhofer.ipa.ros.glsp.model.RosViewData;
import de.fraunhofer.ipa.ros.glsp.operations.ApplyRosAutoConnectOperation;
import de.fraunhofer.ipa.ros.glsp.operations.EditRosPropertyOperation;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.eclipse.emf.common.command.Command;
import org.eclipse.glsp.graph.GModelElement;
import org.eclipse.glsp.graph.GModelRoot;
import org.eclipse.glsp.server.actions.Action;
import org.eclipse.glsp.server.di.ServerModule;
import org.eclipse.glsp.server.features.core.model.GModelFactory;
import org.eclipse.glsp.server.features.core.model.RequestModelAction;
import org.eclipse.glsp.server.features.core.model.SourceModelStorage;
import org.eclipse.glsp.server.operations.CreateNodeOperation;
import org.eclipse.glsp.server.operations.Operation;
import org.eclipse.glsp.server.operations.OperationHandler;
import org.eclipse.glsp.server.operations.OperationHandlerRegistry;
import org.eclipse.glsp.server.protocol.InitializeClientSessionParameters;
import org.eclipse.glsp.server.session.ClientSession;
import org.eclipse.glsp.server.session.ClientSessionManager;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import ros.AmentPackage;

/**
 * Phase 1 GLSP tests covering node-less plugin artifacts, {@code addPlugin} / {@code addPluginSlot},
 * host node plugin badges/ports in the diagram, and {@code RosAutoConnector} over plugin interfaces.
 */
class RosGlspPhase1PluginsTest {

    @TempDir
    Path tempDir;

    private static final class Session {
        Injector injector;
        SourceModelStorage storage;
        GModelFactory gModelFactory;
        RosModelState state;
        OperationHandlerRegistry registry;
    }

    private Session open(final Path file, final String sessionId) {
        Injector serverInjector = Guice.createInjector(
                new ServerModule().configureDiagramModule(new RosGlspModule()));
        ClientSessionManager sessionManager = serverInjector.getInstance(ClientSessionManager.class);
        ClientSession session = sessionManager.getOrCreateClientSession(
                new InitializeClientSessionParameters(sessionId, RosModelTypes.DIAGRAM_TYPE, Collections.emptyList()));
        Injector inj = session.getInjector();
        Session s = new Session();
        s.injector = inj;
        s.storage = inj.getInstance(SourceModelStorage.class);
        s.gModelFactory = inj.getInstance(GModelFactory.class);
        s.state = inj.getInstance(RosModelState.class);
        s.registry = inj.getInstance(OperationHandlerRegistry.class);
        Map<String, String> opts = new HashMap<>();
        opts.put("sourceUri", file.toUri().toString());
        s.storage.loadSourceModel(new RequestModelAction(opts));
        s.gModelFactory.createGModel();
        return s;
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    private static void exec(final Session s, final Operation op) {
        OperationHandler handler = s.registry.getOperationHandler(op).orElseThrow(
                () -> new AssertionError("No handler for " + op.getClass().getName()));
        Optional<Command> opt = handler.createCommand(op);
        Command cmd = opt.orElseThrow(
                () -> new AssertionError("Empty command for " + op.getClass().getName()));
        s.state.execute(cmd);
    }

    /** The element's view data; asserts the format version. */
    private static com.google.gson.JsonObject viewData(final GModelElement el) {
        Object raw = el.getArgs().get(RosViewData.ARG);
        assertNotNull(raw, "No view data on " + el.getId());
        com.google.gson.JsonObject obj = com.google.gson.JsonParser.parseString(String.valueOf(raw)).getAsJsonObject();
        assertEquals(RosViewData.VERSION, obj.get("version").getAsInt());
        return obj;
    }

    private static List<GModelElement> findNodesByName(final GModelElement el, final String type) {
        List<GModelElement> out = new java.util.ArrayList<>();
        if (type.equals(el.getType())) {
            out.add(el);
        }
        for (GModelElement child : el.getChildren()) {
            out.addAll(findNodesByName(child, type));
        }
        return out;
    }

    @Test
    void nodeLessPluginArtifactOpensEditsAndSerializesCleanly() throws Exception {
        Path rosFile = tempDir.resolve("std_msgs.ros");
        Files.writeString(rosFile, """
                std_msgs:
                  msgs:
                    String
                      message
                        string data
                """);

        Path pkgFile = tempDir.resolve("my_plugins.ros2");
        Files.writeString(pkgFile, """
                my_plugins:
                  pluginbases:
                    GlobalPlanner:
                      class: "my_plugins::GlobalPlanner"
                      header: "my_plugins/global_planner.hpp"
                      loader: pluginlib
                  artifacts:
                    planners_lib:
                      plugins:
                        StraightLine:
                          implements: my_plugins.GlobalPlanner
                          publishers:
                            path_out:
                              type: "std_msgs/msg/String"
                """);

        Session s = open(pkgFile, "phase1-pkg");
        s.gModelFactory.createGModel();
        GModelRoot root = s.state.getRoot();
        List<GModelElement> cards = findNodesByName(root, RosModelTypes.ROS_NODE);
        assertEquals(1, cards.size());
        assertEquals("plugin", viewData(cards.get(0)).get("kind").getAsString());
        assertEquals("my_plugins.GlobalPlanner", viewData(cards.get(0)).get("implements").getAsString());
        assertEquals("StraightLine", cards.get(0).getArgs().get("nodeName"));

        // Add a second plugin to the same library artifact via GLSP edit operation
        exec(s, new EditRosPropertyOperation("planners_lib", "addPlugin", "ThetaStar",
                "{\"implements\":\"my_plugins.GlobalPlanner\"}", null));
        String updated = RosAstNodeModelSerializer.computeAndCommit(s.state).newText;
        assertTrue(updated.contains("ThetaStar:"), "Expected ThetaStar plugin:\n" + updated);
        assertTrue(updated.contains("implements: my_plugins.GlobalPlanner"), updated);


        Files.writeString(pkgFile, updated);
        Session reopened = open(pkgFile, "phase1-pkg-2");
        AmentPackage pkg = (AmentPackage) reopened.state.getSemanticModel();
        assertEquals(2, pkg.getArtifact().get(0).getPlugins().size());

        // A new section on an existing plugin goes below its "implements:" line.
        exec(reopened, new EditRosPropertyOperation("StraightLine", "addInterface", "status", "std_msgs/msg/String", "sub"));
        String withSub = RosAstNodeModelSerializer.computeAndCommit(reopened.state).newText;
        assertTrue(withSub.contains("StraightLine:\n          implements: my_plugins.GlobalPlanner\n"), withSub);
        assertTrue(withSub.contains("subscribers:"), withSub);
        assertTrue(withSub.indexOf("subscribers:") > withSub.indexOf("implements: my_plugins.GlobalPlanner"), withSub);
    }

    @Test
    void addPluginSlotWithLibraryFormatSerializesAndExposesFormatInGModel() throws Exception {
        Path pkgFile = tempDir.resolve("host_slot.ros2");
        Files.writeString(pkgFile, """
                host_slot:
                  artifacts:
                    orch_bin:
                      node: orch_node
                      parameters:
                        rate:
                          type: Double
                """);

        Session s = open(pkgFile, "phase1-slot-format");
        exec(s, new EditRosPropertyOperation("orch_node", "addPluginSlot", "leaves",
                "{\"base\":\"custom_core.LeafBase\",\"parameter\":\"leaf_libraries\",\"format\":\"library\",\"multiple\":true}", null));

        String updated = RosAstNodeModelSerializer.computeAndCommit(s.state).newText;
        assertTrue(updated.contains("format: library"), "Expected format: library in .ros2:\n" + updated);
        assertTrue(updated.contains("base: custom_core.LeafBase"), updated);
        assertTrue(updated.contains("multiple: true"), updated);

        Files.writeString(pkgFile, updated);
        Session reopened = open(pkgFile, "phase1-slot-format-2");
        GModelElement card = findNodesByName(reopened.state.getRoot(), RosModelTypes.ROS_NODE).get(0);
        String slotsJson = viewData(card).get("pluginSlots").toString();
        assertTrue(slotsJson.contains("\"format\":\"library\""), "Expected format in pluginSlots: " + slotsJson);
        assertTrue(slotsJson.contains("\"multiple\":true"), slotsJson);

        // Editing an existing slot rewrites that slot only.
        exec(reopened, new EditRosPropertyOperation("orch_bin.leaves", "format", "class"));
        exec(reopened, new EditRosPropertyOperation("orch_bin.leaves", "parameter", "leaf_plugins"));
        String edited = RosAstNodeModelSerializer.computeAndCommit(reopened.state).newText;
        assertFalse(edited.contains("format: library"), edited);
        assertTrue(edited.contains("parameter: leaf_plugins"), edited);
        assertTrue(edited.contains("multiple: true"), edited);
        assertTrue(edited.contains("rate:\n          type: Double"), edited);
    }

    @Test
    void hostNodeWithPluginSlotsAndAutoConnectWorksEndToEnd() throws Exception {
        Path rosFile = tempDir.resolve("std_msgs.ros");
        Files.writeString(rosFile, """
                std_msgs:
                  msgs:
                    String
                      message
                        string data
                """);

        Path coreFile = tempDir.resolve("nav2_core.ros2");
        Files.writeString(coreFile, """
                nav2_core:
                  pluginbases:
                    GlobalPlanner:
                      class: "nav2_core::GlobalPlanner"
                      header: "nav2_core/global_planner.hpp"
                      loader: pluginlib
                """);

        Path hostFile = tempDir.resolve("host_pkg.ros2");
        Files.writeString(hostFile, """
                host_pkg:
                  artifacts:
                    host_bin:
                      node: host_node
                      pluginslots:
                        planner:
                          base: nav2_core.GlobalPlanner
                          parameter: active_plugin
                """);

        Path pluginFile = tempDir.resolve("plugin_pkg.ros2");
        Files.writeString(pluginFile, """
                plugin_pkg:
                  artifacts:
                    planner_lib:
                      plugins:
                        MyPlanner:
                          implements: nav2_core.GlobalPlanner
                          publishers:
                            plugin_debug:
                              type: "std_msgs/msg/String"
                """);

        Path consumerFile = tempDir.resolve("consumer_pkg.ros2");
        Files.writeString(consumerFile, """
                consumer_pkg:
                  artifacts:
                    consumer_bin:
                      node: consumer_node
                      subscribers:
                        plugin_debug:
                          type: "std_msgs/msg/String"
                """);

        Path sysFile = tempDir.resolve("robot.rossystem");
        Files.writeString(sysFile, """
                robot:
                  nodes:
                    host_inst:
                      from: "host_pkg.host_node"
                      slots:
                        planner: [plugin_pkg.MyPlanner]
                    consumer_inst:
                      from: "consumer_pkg.consumer_node"
                """);

        Session s = open(sysFile, "phase1-sys");
        s.gModelFactory.createGModel();
        GModelRoot gmodel = s.state.getRoot();
        List<GModelElement> nodes = findNodesByName(gmodel, RosModelTypes.ROS_NODE);
        GModelElement hostCard = nodes.stream()
                .filter(n -> "host_inst".equals(n.getArgs().get("nodeName")))
                .findFirst().orElseThrow();

        String hostSlots = viewData(hostCard).get("slots").toString();
        assertTrue(hostSlots.contains("\"plugins\":[\"plugin_pkg.MyPlanner\"]"), hostSlots);
        assertTrue(findNodesByName(hostCard, RosModelTypes.PORT_PUB).stream()
                .anyMatch(p -> "plugin_debug".equals(p.getArgs().get("interfaceName"))));

        // Auto-connect should propose host_inst::plugin_debug -> consumer_inst::plugin_debug
        RequestRosAutoConnectActionHandler acHandler =
                s.injector.getInstance(RequestRosAutoConnectActionHandler.class);
        List<Action> responses = acHandler.execute(new RequestRosAutoConnectAction());
        SetRosAutoConnectAction res = (SetRosAutoConnectAction) responses.get(0);
        assertFalse(res.getReceivers().isEmpty());
        String wantedId = res.getReceivers().get(0).candidates.get(0).id;
        assertEquals("host_inst::plugin_debug->consumer_inst::plugin_debug", wantedId);

        exec(s, new ApplyRosAutoConnectOperation(List.of(wantedId)));
        String saved = RosAstNodeModelSerializer.computeAndCommit(s.state).newText;
        assertTrue(saved.contains("planner: [plugin_pkg.MyPlanner]"), saved);
        assertTrue(saved.contains("host_inst::plugin_debug"), saved);
    }

    @Test
    void addPluginBaseAndEditItsFields() throws Exception {
        Path pkgFile = tempDir.resolve("my_core.ros2");
        Files.writeString(pkgFile, """
                my_core:
                  artifacts:
                    tool_bin:
                      node: tool_node
                """);

        Session s = open(pkgFile, "phase4-base");
        exec(s, new EditRosPropertyOperation("root", "addPluginBase", "Planner",
                "{\"class\":\"my_core::Planner\",\"header\":\"my_core/planner.hpp\"}", null));
        exec(s, new EditRosPropertyOperation("root", "addPluginBase", "Critic",
                "{\"class\":\"my_core::Critic\",\"loader\":\"other_loader\"}", null));
        exec(s, new EditRosPropertyOperation("Critic", "header", "my_core/critic.hpp"));
        exec(s, new EditRosPropertyOperation("my_core.Critic", "loader", "pluginlib"));
        String updated = RosAstNodeModelSerializer.computeAndCommit(s.state).newText;
        assertTrue(updated.contains("pluginbases:"), updated);
        assertTrue(updated.contains("Planner:\n      class: \"my_core::Planner\"\n      header: \"my_core/planner.hpp\"\n      loader: pluginlib"), updated);
        assertTrue(updated.contains("Critic:\n      class: \"my_core::Critic\"\n      header: \"my_core/critic.hpp\"\n      loader: pluginlib"), updated);
        assertTrue(updated.contains("tool_node"), updated);

        Files.writeString(pkgFile, updated);
        Session reopened = open(pkgFile, "phase4-base-2");
        AmentPackage pkg = (AmentPackage) reopened.state.getSemanticModel();
        assertEquals(2, pkg.getPluginBases().size());
        GModelElement pkgCard = findNodesByName(reopened.state.getRoot(), RosModelTypes.PACKAGE_NODE).get(0);
        String basesJson = viewData(pkgCard).get("pluginBases").toString();
        assertTrue(basesJson.contains("\"ref\":\"my_core.Planner\""), basesJson);
        assertTrue(basesJson.contains("\"loader\":\"pluginlib\""), basesJson);
    }

    @Test
    void slotEditSetsAndClearsTheAttachedPlugins() throws Exception {
        Files.writeString(tempDir.resolve("core.ros2"), """
                core:
                  pluginbases:
                    Critic:
                      class: "core::Critic"
                      header: "core/critic.hpp"
                      loader: pluginlib
                    Planner:
                      class: "core::Planner"
                      header: "core/planner.hpp"
                      loader: pluginlib
                  artifacts:
                    critics:
                      plugins:
                        Goal:
                          implements: core.Critic
                        Align:
                          implements: core.Critic
                    planners:
                      plugins:
                        Straight:
                          implements: core.Planner
                    host:
                      node: host
                      pluginslots:
                        planner:
                          base: core.Planner
                          parameter: planner_plugin
                        critics:
                          base: core.Critic
                          parameter: critic_plugins
                          multiple: true
                """);
        Path sysFile = tempDir.resolve("sys.rossystem");
        Files.writeString(sysFile, """
                sys:
                  nodes:
                    host_inst:
                      from: "core.host"
                      slots:
                        planner: [core.Straight]
                """);

        Session s = open(sysFile, "phase4-slots");
        GModelElement card = findNodesByName(s.state.getRoot(), RosModelTypes.ROS_NODE).get(0);
        String slotsJson = viewData(card).get("slots").toString();
        assertTrue(slotsJson.contains("{\"slot\":\"planner\",\"base\":\"core.Planner\",\"multiple\":false,\"plugins\":[\"core.Straight\"]}"), slotsJson);
        assertTrue(slotsJson.contains("{\"slot\":\"critics\",\"base\":\"core.Critic\",\"multiple\":true,\"plugins\":[]}"), slotsJson);

        exec(s, new EditRosPropertyOperation("host_inst", "slot", "critics", "core.Align, core.Goal", null));
        String updated = RosAstNodeModelSerializer.computeAndCommit(s.state).newText;
        assertTrue(updated.contains("planner: [core.Straight]"), updated);
        assertTrue(updated.contains("critics: [core.Align, core.Goal]"), updated);

        Files.writeString(sysFile, updated);
        Session reopened = open(sysFile, "phase4-slots-2");
        exec(reopened, new EditRosPropertyOperation("host_inst", "slot", "critics", "core.Goal", null));
        exec(reopened, new EditRosPropertyOperation("host_inst", "slot", "planner", "", null));
        String cleared = RosAstNodeModelSerializer.computeAndCommit(reopened.state).newText;
        assertTrue(cleared.contains("critics: [core.Goal]"), cleared);
        assertFalse(cleared.contains("planner: ["), cleared);
    }

    @Test
    void extensionBlockSetRemoveAndSerializeInGlsp() throws Exception {
        Path pkgFile = tempDir.resolve("ext_pkg.ros2");
        Files.writeString(pkgFile, """
                ext_pkg:
                  artifacts:
                    app_bin:
                      node: app_node
                """);

        Session s = open(pkgFile, "phase2-ext-pkg");
        exec(s, new EditRosPropertyOperation("app_node", "setExtensionBlock", "meta",
                "{\"mode\":\"fast\",\"retries\":3,\"tags\":[\"a\",\"b\"]}", null));
        String updated = RosAstNodeModelSerializer.computeAndCommit(s.state).newText;
        assertTrue(updated.contains("@meta:"), updated);
        assertTrue(updated.contains("retries: 3"), updated);

        Files.writeString(pkgFile, updated);
        Session reopened = open(pkgFile, "phase2-ext-pkg-2");
        GModelElement nodeCard = findNodesByName(reopened.state.getRoot(), RosModelTypes.ROS_NODE).get(0);
        String extsJson = viewData(nodeCard).get("blocks").toString();
        assertTrue(extsJson.contains("\"name\":\"meta\""), extsJson);
        assertEquals(0, viewData(nodeCard).getAsJsonArray("contributions").size(), "A block no plugin owns gets no badge");
        assertTrue(extsJson.contains("\"mode\":\"fast\""), extsJson);

        exec(reopened, new EditRosPropertyOperation("app_node", "removeExtensionBlock", "meta", "", null));
        String removed = RosAstNodeModelSerializer.computeAndCommit(reopened.state).newText;
        assertFalse(removed.contains("@meta:"), removed);
    }

    /** A neutral test plugin with a hinted block {@code probe} and a loader {@code probe_loader}. */
    private static de.fraunhofer.ipa.ros.plugin.spi.RosToolingPlugin probePlugin() {
        org.eclipse.emf.ecore.EcoreFactory ef = org.eclipse.emf.ecore.EcoreFactory.eINSTANCE;
        org.eclipse.emf.ecore.EPackage ePkg = ef.createEPackage();
        ePkg.setName("probeview");
        ePkg.setNsPrefix("probeview");
        ePkg.setNsURI("http://example.org/probeview");
        org.eclipse.emf.ecore.EClass cls = ef.createEClass();
        cls.setName("ProbeBlock");
        org.eclipse.emf.ecore.EAttribute mode = ef.createEAttribute();
        mode.setName("mode");
        mode.setEType(org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING);
        de.fraunhofer.ipa.ros.plugin.spi.SchemaHints.set(mode, de.fraunhofer.ipa.ros.plugin.spi.SchemaHints.LABEL, "Mode");
        de.fraunhofer.ipa.ros.plugin.spi.SchemaHints.set(mode, de.fraunhofer.ipa.ros.plugin.spi.SchemaHints.HELP, "How the probe runs.");
        de.fraunhofer.ipa.ros.plugin.spi.SchemaHints.set(mode, de.fraunhofer.ipa.ros.plugin.spi.SchemaHints.CHOICES, "fast, thorough");
        cls.getEStructuralFeatures().add(mode);
        ePkg.getEClassifiers().add(cls);
        de.fraunhofer.ipa.ros.plugin.spi.BlockDescriptor block = new de.fraunhofer.ipa.ros.plugin.spi.BlockDescriptor(
                "probe", cls, java.util.EnumSet.of(
                        de.fraunhofer.ipa.ros.plugin.spi.HookLocation.NODE,
                        de.fraunhofer.ipa.ros.plugin.spi.HookLocation.ROS_NODE));
        return new de.fraunhofer.ipa.ros.plugin.spi.RosToolingPlugin() {
            @Override public String id() { return "test.viewdata.probe"; }
            @Override public List<de.fraunhofer.ipa.ros.plugin.spi.BlockDescriptor> blocks() { return List.of(block); }
            @Override public List<de.fraunhofer.ipa.ros.plugin.spi.LoaderDescriptor> loaders() {
                return List.of(new de.fraunhofer.ipa.ros.plugin.spi.LoaderDescriptor("probe_loader", ""));
            }
            @Override public void validate(final de.fraunhofer.ipa.ros.plugin.spi.ValidationContext context) { }
        };
    }

    private static List<String> badgePlugins(final com.google.gson.JsonObject owner) {
        List<String> out = new java.util.ArrayList<>();
        for (com.google.gson.JsonElement c : owner.getAsJsonArray("contributions")) {
            com.google.gson.JsonObject o = c.getAsJsonObject();
            assertEquals(RosViewData.BADGE, o.get("kind").getAsString());
            out.add(o.get("plugin").getAsString());
        }
        return out;
    }

    @Test
    void viewDataBadgesWhatAPluginAddedAndCarriesBlockSchemas() throws Exception {
        de.fraunhofer.ipa.ros.plugin.spi.PluginRegistry.INSTANCE.clearRegistered();
        de.fraunhofer.ipa.ros.plugin.spi.PluginRegistry.INSTANCE.register(probePlugin());
        try {
            Path pkgFile = tempDir.resolve("probe_pkg.ros2");
            Files.writeString(pkgFile, """
                    probe_pkg:
                      pluginbases:
                        Probe:
                          class: "probe::Probe"
                          header: "probe/probe.hpp"
                          loader: probe_loader
                        Plain:
                          class: "probe::Plain"
                          header: "probe/plain.hpp"
                          loader: pluginlib
                      artifacts:
                        probes:
                          plugins:
                            Fast:
                              implements: probe_pkg.Probe
                        plain_lib:
                          plugins:
                            Simple:
                              implements: probe_pkg.Plain
                        app_bin:
                          node: app_node
                          pluginslots:
                            probes:
                              base: probe_pkg.Probe
                              parameter: probe_plugins
                              multiple: true
                    """);
            Session s = open(pkgFile, "viewdata-pkg");
            exec(s, new EditRosPropertyOperation("app_node", "setExtensionBlock", "probe", "{\"mode\":\"fast\"}", null));
            Files.writeString(pkgFile, RosAstNodeModelSerializer.computeAndCommit(s.state).newText);
            Session pkg = open(pkgFile, "viewdata-pkg-2");

            com.google.gson.JsonObject root = viewData(pkg.state.getRoot());
            assertEquals("packageSet", root.get("kind").getAsString());
            assertTrue(root.get("availableBlocks").toString().contains("\"name\":\"probe\""), root.toString());
            assertTrue(root.get("availableBlocks").toString().contains("\"plugin\":\"test.viewdata.probe\""), root.toString());
            assertTrue(root.get("loaders").toString().contains("{\"id\":\"probe_loader\",\"plugin\":\"test.viewdata.probe\""),
                    root.toString());

            com.google.gson.JsonObject pkgView = viewData(findNodesByName(pkg.state.getRoot(), RosModelTypes.PACKAGE_NODE).get(0));
            assertEquals("package", pkgView.get("kind").getAsString());
            com.google.gson.JsonArray bases = pkgView.getAsJsonArray("pluginBases");
            assertEquals(List.of("test.viewdata.probe"), badgePlugins(bases.get(0).getAsJsonObject()), "Base on a plugin's loader");
            assertEquals(List.of(), badgePlugins(bases.get(1).getAsJsonObject()), "pluginlib is core's");

            Map<String, com.google.gson.JsonObject> cards = new HashMap<>();
            for (GModelElement el : findNodesByName(pkg.state.getRoot(), RosModelTypes.ROS_NODE)) {
                cards.put(String.valueOf(el.getArgs().get("nodeName")), viewData(el));
            }
            assertEquals("plugin", cards.get("Fast").get("kind").getAsString());
            assertEquals("probes", cards.get("Fast").getAsJsonObject("artifact").get("name").getAsString());
            assertEquals("probe_loader", cards.get("Fast").get("loader").getAsString());
            assertEquals(List.of("test.viewdata.probe"), badgePlugins(cards.get("Fast")));
            assertEquals(List.of(), badgePlugins(cards.get("Simple")));

            com.google.gson.JsonObject node = cards.get("app_node");
            assertEquals("node", node.get("kind").getAsString());
            assertEquals(List.of("test.viewdata.probe"), badgePlugins(node), "Node holding the plugin's block");
            assertEquals("probe_plugins", node.getAsJsonArray("pluginSlots").get(0).getAsJsonObject().get("parameter").getAsString());
            com.google.gson.JsonObject block = node.getAsJsonArray("blocks").get(0).getAsJsonObject();
            assertEquals("probe", block.get("name").getAsString());
            assertEquals("test.viewdata.probe", block.get("plugin").getAsString());
            assertEquals("fast", block.getAsJsonObject("entries").get("mode").getAsString());
            com.google.gson.JsonObject modeSchema = block.getAsJsonObject("schema").getAsJsonObject("schema")
                    .getAsJsonObject("properties").getAsJsonObject("mode");
            assertEquals("Mode", modeSchema.get("title").getAsString());
            assertEquals("How the probe runs.", modeSchema.get("description").getAsString());
            assertTrue(modeSchema.get("x-choices").toString().contains("thorough"), modeSchema.toString());

            Path sysFile = tempDir.resolve("probe_sys.rossystem");
            Files.writeString(sysFile, """
                    probe_sys:
                      nodes:
                        app_inst:
                          from: "probe_pkg.app_node"
                          slots:
                            probes: [probe_pkg.Fast]
                    """);
            Session sys = open(sysFile, "viewdata-sys");
            exec(sys, new EditRosPropertyOperation("app_inst", "setExtensionBlock", "probe", "{\"mode\":\"thorough\"}", null));
            Files.writeString(sysFile, RosAstNodeModelSerializer.computeAndCommit(sys.state).newText);
            Session sys2 = open(sysFile, "viewdata-sys-2");
            assertEquals("system", viewData(sys2.state.getRoot()).get("kind").getAsString());
            com.google.gson.JsonObject host = viewData(findNodesByName(sys2.state.getRoot(), RosModelTypes.ROS_NODE).get(0));
            assertEquals("rosNode", host.get("kind").getAsString());
            assertEquals(List.of("test.viewdata.probe"), badgePlugins(host));
            assertTrue(host.get("slots").toString().contains(
                    "{\"slot\":\"probes\",\"base\":\"probe_pkg.Probe\",\"multiple\":true,\"plugins\":[\"probe_pkg.Fast\"]}"),
                    host.toString());
        } finally {
            de.fraunhofer.ipa.ros.plugin.spi.PluginRegistry.INSTANCE.clearRegistered();
        }
    }
}
