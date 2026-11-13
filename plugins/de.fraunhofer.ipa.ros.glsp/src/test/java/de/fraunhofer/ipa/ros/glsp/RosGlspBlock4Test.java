package de.fraunhofer.ipa.ros.glsp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.google.inject.Guice;
import com.google.inject.Injector;
import de.fraunhofer.ipa.ros.glsp.model.RosModelState;
import de.fraunhofer.ipa.ros.glsp.operations.EditRosPropertyOperation;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.eclipse.emf.common.command.Command;
import org.eclipse.glsp.graph.GModelElement;
import org.eclipse.glsp.graph.GModelRoot;
import org.eclipse.glsp.server.actions.SaveModelAction;
import org.eclipse.glsp.server.di.ServerModule;
import org.eclipse.glsp.server.features.core.model.GModelFactory;
import org.eclipse.glsp.server.features.core.model.RequestModelAction;
import org.eclipse.glsp.server.features.core.model.SourceModelStorage;
import org.eclipse.glsp.server.operations.DeleteOperation;
import org.eclipse.glsp.server.operations.Operation;
import org.eclipse.glsp.server.operations.OperationHandler;
import org.eclipse.glsp.server.operations.OperationHandlerRegistry;
import org.eclipse.glsp.server.protocol.InitializeClientSessionParameters;
import org.eclipse.glsp.server.session.ClientSession;
import org.eclipse.glsp.server.session.ClientSessionManager;
import org.eclipse.xtext.resource.XtextResource;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

/**
 * Verification Gate for Block 4 (server side): the .ros2 / .ros React forms only ever dispatch
 * {@code editRosProperty} / {@code deleteElement}. These tests prove that structural edits
 * (add/remove interfaces, parameters, artifacts, specs and fields; QoS, active_in, lifecycle,
 * parameter types) are applied by the Java server and written back with surgical span edits:
 * the result parses without syntax errors and every untouched line and comment survives.
 */
class RosGlspBlock4Test {

    @TempDir
    Path tempDir;

    private static final class Session {
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
        java.util.Optional<Command> cmdOpt = handler.createCommand(op);
        Command cmd = cmdOpt.orElseThrow(
                () -> new AssertionError("Empty command for " + op.getClass().getName() + " from " + handler.getClass().getName()));
        s.state.execute(cmd);
    }

    private static void edit(final Session s, final String id, final String prop, final String key,
            final String value, final String valueType) {
        exec(s, new EditRosPropertyOperation(id, prop, key, value, valueType));
    }

    private static String save(final Session s, final Path file) throws Exception {
        s.storage.saveSourceModel(new SaveModelAction());
        XtextResource res = s.state.getXtextResource().orElseThrow();
        String text = Files.readString(file);
        assertFalse(res.getParseResult().hasSyntaxErrors(),
                "Saved text must parse without syntax errors:\n" + text + "\nErrors: "
                        + res.getParseResult().getSyntaxErrors());
        return text;
    }

    private static Path writeMsgs(final Path dir) throws Exception {
        Path msgs = dir.resolve("nav_msgs.ros");
        Files.writeString(msgs, String.join("\n",
                "nav_msgs:",
                "  msgs:",
                "    LaserScan",
                "      message",
                "        float32[] ranges",
                "    Twist",
                "      message",
                "        float64 linear_x",
                ""));
        return msgs;
    }

    @Test
    void ros2StructuralEditsAreSurgical() throws Exception {
        writeMsgs(tempDir);
        Path ros2 = tempDir.resolve("nav_pkg.ros2");
        Files.writeString(ros2, String.join("\n",
                "# nav package header comment",
                "nav_pkg:",
                "  artifacts:",
                "    lidar_driver:",
                "      node: lidar_node",
                "      publishers:",
                "        scan: # inline publisher comment",
                "          type: \"nav_msgs/msg/LaserScan\"",
                "          qos: # qos comment",
                "            profile: sensor_qos # keep profile comment",
                "            depth: 5 # depth comment",
                "      subscribers:",
                "        twist_in:",
                "          type: \"nav_msgs/msg/Twist\"",
                "      parameters:",
                "        frame_id:",
                "          type: String",
                "          default: \"laser\" # keep me",
                "        timeout:",
                "          type: Integer",
                "          default: 3 # timeout comment",
                "    # planner section comment",
                "    local_planner:",
                "      node: planner_node",
                "      publishers:",
                "        cmd_vel:",
                "          type: \"nav_msgs/msg/Twist\"",
                ""));

        Session s = open(ros2, "block4-ros2");

        // Add a subscriber + QoS + parameter to lidar_driver
        edit(s, "lidar_driver", "addInterface", "scan_raw", "nav_msgs/msg/LaserScan", "sub");
        edit(s, "lidar_driver.scan_raw", "qos", "profile", "sensor_qos", null);
        edit(s, "lidar_driver.scan_raw", "qos", "depth", "5", null);
        edit(s, "lidar_driver", "addParameter", "rate", "10.0", "Double");
        // Lifecycle + active_in on an existing interface
        edit(s, "lidar_driver", "isLifecycle", null, "true", null);
        edit(s, "lidar_driver.scan", "activeStates", null, "Active, Inactive", null);
        // QoS on an existing interface, retype + rename an existing one
        edit(s, "lidar_driver.scan", "qos", "reliability", "reliable", null);
        edit(s, "lidar_driver.scan", "qos", "profile", "default_qos", null);
        edit(s, "lidar_driver.scan", "qos", "depth", "", null);
        edit(s, "lidar_driver.timeout", "type", null, "Double", null);
        edit(s, "lidar_driver.scan", "name", null, "scan_out", null);
        // Change an existing parameter's default (comment on that line is part of the edited span)
        edit(s, "lidar_driver.frame_id", "default", null, "base_laser", null);
        // Delete the only subscriber -> its 'subscribers:' section header must disappear too
        exec(s, new DeleteOperation(List.of("lidar_driver.twist_in")));
        // Add a brand-new artifact and duplicate local_planner
        edit(s, "nav_pkg", "addArtifact", "odom_node", null, null);
        edit(s, "odom_node", "addInterface", "odom", "nav_msgs/msg/Twist", "pub");
        edit(s, "nav_pkg", "duplicateArtifact", "local_planner", "local_planner_b", null);
        // Change interface kind of cmd_vel (pub -> sub)
        edit(s, "local_planner.cmd_vel", "kind", null, "sub", null);

        String text = save(s, ros2);

        assertTrue(text.startsWith("# nav package header comment\nnav_pkg:"), text);
        assertTrue(text.contains("scan_out: # inline publisher comment"), "rename must keep inline comment:\n" + text);
        assertTrue(text.contains("# planner section comment"), text);
        assertTrue(text.contains("lifecycle: true"), text);
        assertTrue(text.contains("active_in: [ Active , Inactive ]"), text);
        assertTrue(text.contains("reliability: reliable"), text);
        assertTrue(text.contains("scan_raw:"), text);
        assertTrue(text.contains("profile: sensor_qos"), text);
        assertTrue(text.contains("depth: 5"), text);
        assertTrue(text.contains("rate:"), text);
        assertTrue(text.contains("default: 10.0"), text);
        assertTrue(text.contains("default: \"base_laser\" # keep me"), text);
        // Field-granular QoS: comments inside the qos block survive edits of neighbouring fields.
        assertTrue(text.contains("qos: # qos comment"), text);
        assertTrue(text.contains("profile: default_qos # keep profile comment"), text);
        assertFalse(text.contains("depth comment"), "cleared field removes only its own line:\n" + text);
        assertTrue(text.contains("            reliability: reliable"), text);
        // Parameter retype: keyword token + default token edited in place.
        assertTrue(text.contains("          type: Double\n          default: 3.0 # timeout comment"), text);
        assertFalse(text.contains("twist_in"), text);
        assertTrue(text.contains("odom_node:\n      node: odom_node"), text);
        assertTrue(text.contains("local_planner_b:"), text);

        // Section bookkeeping: the deleted subscriber's header is gone; the new subscriber got one.
        long subsHeaders = text.lines().filter(l -> l.trim().equals("subscribers:")).count();
        // lidar(scan_raw) + local_planner(cmd_vel, retyped pub->sub). The copy was taken before the
        // kind change, so local_planner_b keeps cmd_vel as a publisher.
        assertEquals(2, subsHeaders, text);
        assertTrue(text.contains("local_planner_b:\n      node: local_planner_b\n      publishers:\n        cmd_vel:"), text);

        // Model round-trip after reparse
        assertTrue(s.state.getSemanticModel() instanceof ros.AmentPackage, ".ros2 root is an AmentPackage");
        ros.Package pkg = (ros.Package) s.state.getSemanticModel();
        assertEquals(4, pkg.getArtifact().size());
        ros.Node lidar = pkg.getArtifact().get(0).getNode();
        assertTrue(lidar.isIsLifecycle());
        assertEquals(1, lidar.getPublisher().size());
        assertEquals(1, lidar.getSubscriber().size());
        assertNotNull(lidar.getSubscriber().get(0).getMessage());
        assertFalse(lidar.getSubscriber().get(0).getMessage().eIsProxy(), "Spec reference must link after save");
        assertEquals(3, lidar.getParameter().size());

        // GGraph exposes ids, qos and activeStates for the React forms
        s.gModelFactory.createGModel();
        GModelRoot root = s.state.getRoot();
        GModelElement pkgNode = root.getChildren().get(0);
        GModelElement lidarNode = pkgNode.getChildren().stream()
                .filter(c -> "lidar_node".equals(((org.eclipse.glsp.graph.GArgumentable) c).getArgs().get("nodeName")))
                .findFirst().orElseThrow();
        String ifaces = String.valueOf(((org.eclipse.glsp.graph.GArgumentable) lidarNode).getArgs().get("interfacesJson"));
        assertTrue(ifaces.contains("\"id\":\"//@artifact.0/@node/@publisher.0\""), ifaces);
        assertTrue(ifaces.contains("\"activeStates\":[\"Active\",\"Inactive\"]"), ifaces);
        assertTrue(ifaces.contains("\"depth\":\"5\""), ifaces);
    }

    @Test
    void rosSpecEditsAreSurgical() throws Exception {
        Path ros = tempDir.resolve("inspection_msgs.ros");
        Files.writeString(ros, String.join("\n",
                "# message definitions",
                "inspection_msgs:",
                "  msgs:",
                "    DefectReport",
                "      message",
                "        string target_id # id comment",
                "        uint8 severity",
                "    SafetyStatus",
                "      message",
                "        bool estop_active",
                "  actions:",
                "    Inspect",
                "      goal",
                "        string mission_id",
                "      result",
                "        bool ok",
                "      feedback",
                "        float32 percent",
                ""));

        Session s = open(ros, "block4-ros");

        edit(s, "DefectReport", "addField", "confidence", "float64", "message");
        edit(s, "DefectReport", "addField", "pose", "'geometry_msgs/msg/Pose'", "message");
        edit(s, "DefectReport.severity", "type", null, "uint16", null);
        edit(s, "SafetyStatus.estop_active", "name", null, "estop", null);
        edit(s, "inspection_msgs", "addSpec", "Trigger", "srv", null);
        edit(s, "Trigger", "addField", "point_id", "string", "request");
        edit(s, "Trigger", "addField", "success", "bool", "response");
        edit(s, "SafetyStatus", "addField", "reports", "DefectReport[]", "message");
        exec(s, new DeleteOperation(List.of("Inspect")));

        String text = save(s, ros);

        assertTrue(text.startsWith("# message definitions\n"), text);
        assertTrue(text.contains("string target_id # id comment"), text);
        assertTrue(text.contains("uint16 severity"), text);
        assertTrue(text.contains("float64 confidence"), text);
        assertTrue(text.contains("'geometry_msgs/msg/Pose' pose"), text);
        assertTrue(text.contains("bool estop\n"), text);
        assertTrue(text.contains("  srvs:\n    Trigger\n      request\n        string point_id\n      response\n        bool success"), text);
        assertTrue(text.contains("'inspection_msgs/msg/DefectReport'[] reports"), text);
        assertFalse(text.contains("Inspect"), text);
        assertFalse(text.contains("actions:"), "emptied 'actions:' section header must be removed:\n" + text);

        s.gModelFactory.createGModel();
        GModelRoot root = s.state.getRoot();
        String specs = String.valueOf(((org.eclipse.glsp.graph.GArgumentable) root.getChildren().get(0)).getArgs().get("specsJson"));
        assertTrue(specs.contains("\"name\":\"Trigger\",\"category\":\"srv\""), specs);
        assertTrue(specs.contains("\"type\":\"float64\",\"name\":\"confidence\""), specs);
    }
    @Test
    void rossystemSubsystemsAndEmptiedSectionsStayParseable() throws Exception {
        writeMsgs(tempDir);
        Files.writeString(tempDir.resolve("nav_pkg.ros2"), String.join("\n",
                "nav_pkg:",
                "  artifacts:",
                "    lidar_driver:",
                "      node: lidar_node",
                "      publishers:",
                "        scan:",
                "          type: \"nav_msgs/msg/LaserScan\"",
                "    local_planner:",
                "      node: planner_node",
                "      subscribers:",
                "        scan_in:",
                "          type: \"nav_msgs/msg/LaserScan\"",
                ""));
        Path sysFile = tempDir.resolve("nav_system.rossystem");
        Files.writeString(sysFile, String.join("\n",
                "# system header",
                "nav_system:",
                "  processes:",
                "    main_proc:",
                "      nodes: [ lidar ]",
                "      threads: 2",
                "  nodes:",
                "    lidar:",
                "      from: \"nav_pkg.lidar_node\"",
                "      interfaces:",
                "        - scan: pub-> \"lidar_driver::scan\"",
                "    planner: # planner comment",
                "      from: \"nav_pkg.planner_node\"",
                "      interfaces:",
                "        - scan_in: sub-> \"local_planner::scan_in\"",
                "  connections:",
                "    - [ scan , scan_in ]",
                ""));

        Session s = open(sysFile, "block4-sys");
        Map<String, String> subArgs = new HashMap<>();
        subArgs.put("system", "nav_sensors");
        exec(s, new org.eclipse.glsp.server.operations.CreateNodeOperation(RosModelTypes.SUBSYSTEM_NODE, null, null, subArgs));
        exec(s, new DeleteOperation(List.of("//@connections.0")));
        exec(s, new DeleteOperation(List.of("//@processes.0")));
        exec(s, new DeleteOperation(List.of("planner.scan_in")));
        Map<String, String> nodeArgs = new HashMap<>();
        nodeArgs.put("nodeName", "lidar_b");
        nodeArgs.put("from", "nav_pkg.lidar_node");
        exec(s, new org.eclipse.glsp.server.operations.CreateNodeOperation(RosModelTypes.ROS_NODE, null, null, nodeArgs));

        String text = save(s, sysFile);
        assertTrue(text.startsWith("# system header\nnav_system:\n  subSystems:\n    nav_sensors\n"), text);
        assertFalse(text.contains("connections:"), text);
        assertFalse(text.contains("processes:"), text);
        assertFalse(text.contains("scan_in"), text);
        assertTrue(text.contains("planner: # planner comment\n      from: \"nav_pkg.planner_node\"\n    lidar_b:"), text);
    }
    @Test
    void textEditsReproduceServerTextWithoutWritingTheFile() throws Exception {
        writeMsgs(tempDir);
        Path ros2 = tempDir.resolve("edits_pkg.ros2");
        String original = String.join("\n",
                "edits_pkg: # pkg comment",
                "  artifacts:",
                "    a_node:",
                "      node: a_node",
                "      publishers:",
                "        out: # out comment",
                "          type: \"nav_msgs/msg/Twist\"",
                "");
        Files.writeString(ros2, original);
        Session s = open(ros2, "block4-edits");
        edit(s, "a_node", "isLifecycle", null, "true", null);
        edit(s, "a_node", "addInterface", "in", "nav_msgs/msg/LaserScan", "sub");
        edit(s, "a_node", "addParameter", "rate", "5.0", "Double");
        edit(s, "a_node.out", "qos", "profile", "sensor_qos", null);
        edit(s, "a_node.out", "activeStates", null, "Active", null);

        var change = de.fraunhofer.ipa.ros.glsp.model.RosAstNodeModelSerializer.computeAndCommit(s.state);
        assertEquals(original, Files.readString(ros2), "computeAndCommit must not write the file");
        assertEquals(original, change.baseText);
        StringBuilder rebuilt = new StringBuilder();
        int cursor = 0;
        for (var e : change.edits) {
            assertTrue(e.offset >= cursor, "edits must be ordered and non-overlapping");
            rebuilt.append(original, cursor, e.offset).append(e.replacement);
            cursor = e.offset + e.length;
        }
        rebuilt.append(original.substring(cursor));
        assertEquals(change.newText, rebuilt.toString());
        assertTrue(change.newText.contains("edits_pkg: # pkg comment"), change.newText);
        assertTrue(change.newText.contains("out: # out comment\n          type: \"nav_msgs/msg/Twist\"\n          active_in: [ Active ]\n          qos:\n            profile: sensor_qos"), change.newText);
        assertFalse(s.state.getXtextResource().orElseThrow().getParseResult().hasSyntaxErrors(), change.newText);
    }
    private Path writeNavPkg() throws Exception {
        writeMsgs(tempDir);
        Path p = tempDir.resolve("nav_pkg.ros2");
        Files.writeString(p, String.join("\n",
                "nav_pkg:",
                "  artifacts:",
                "    lidar_driver:",
                "      node: lidar_node",
                "      publishers:",
                "        scan:",
                "          type: \"nav_msgs/msg/LaserScan\"",
                "    local_planner:",
                "      node: planner_node",
                "      subscribers:",
                "        scan_in:",
                "          type: \"nav_msgs/msg/LaserScan\"",
                ""));
        return p;
    }

    @Test
    void processesAreCreatedAndEditedSurgically() throws Exception {
        writeNavPkg();
        Path sysFile = tempDir.resolve("proc_system.rossystem");
        Files.writeString(sysFile, String.join("\n",
                "# process system",
                "proc_system:",
                "  processes:",
                "    main_proc: # composable container",
                "      nodes: [ lidar ]",
                "      threads: 2 # keep threads comment",
                "  nodes:",
                "    lidar:",
                "      from: \"nav_pkg.lidar_node\"",
                "    planner:",
                "      from: \"nav_pkg.planner_node\"",
                ""));
        Session s = open(sysFile, "block4-proc");
        Map<String, String> args = new HashMap<>();
        args.put("processName", "planning_container");
        args.put("threads", "3");
        args.put("nodes", "planner");
        exec(s, new org.eclipse.glsp.server.operations.CreateNodeOperation(RosModelTypes.PROCESS_NODE, null, null, args));
        edit(s, "//@processes.0", "threads", null, "4", null);
        edit(s, "//@processes.0", "addNode", null, "planner", null);
        edit(s, "lidar", "name", null, "lidar_main", null);

        String text = save(s, sysFile);
        assertTrue(text.contains("    main_proc: # composable container\n      nodes: [ lidar_main , planner ]\n      threads: 4 # keep threads comment"), text);
        assertTrue(text.contains("    planning_container:\n      nodes: [ planner ]\n      threads: 3\n  nodes:"), text);
        assertTrue(text.contains("    lidar_main:\n      from: \"nav_pkg.lidar_node\""), text);
        system.System sys = s.state.getRosSystem().orElseThrow();
        assertEquals(2, sys.getProcesses().size());
        assertEquals(2, sys.getProcesses().get(0).getComponents().size(), "members must link after save");

        // Removing the last member keeps a valid (non-empty) block; deleting a process drops it.
        edit(s, "//@processes.1", "removeNode", null, "planner", null);
        exec(s, new DeleteOperation(List.of("//@processes.0")));
        text = save(s, sysFile);
        assertFalse(text.contains("main_proc"), text);
        assertTrue(text.contains("    planning_container:\n      threads: 3\n"), text);
    }

    @Test
    void newProcessSectionIsCreatedWhenAbsent() throws Exception {
        writeNavPkg();
        Path sysFile = tempDir.resolve("noproc_system.rossystem");
        Files.writeString(sysFile, String.join("\n",
                "noproc_system:",
                "  nodes:",
                "    lidar:",
                "      from: \"nav_pkg.lidar_node\"",
                ""));
        Session s = open(sysFile, "block4-noproc");
        Map<String, String> args = new HashMap<>();
        args.put("processName", "container_1");
        args.put("nodes", "lidar");
        exec(s, new org.eclipse.glsp.server.operations.CreateNodeOperation(RosModelTypes.PROCESS_NODE, null, null, args));
        String text = save(s, sysFile);
        assertTrue(text.startsWith("noproc_system:\n  processes:\n    container_1:\n      nodes: [ lidar ]\n      threads: 1\n  nodes:"), text);
    }

    @Test
    void interfaceAndParameterNamespacesAreEditedInPlace() throws Exception {
        writeMsgs(tempDir);
        Path ros2 = tempDir.resolve("ns_pkg.ros2");
        Files.writeString(ros2, String.join("\n",
                "ns_pkg:",
                "  artifacts:",
                "    a_node:",
                "      node: a_node",
                "      publishers:",
                "        out:",
                "          type: \"nav_msgs/msg/Twist\"",
                "      subscribers:",
                "        inp:",
                "          type: \"nav_msgs/msg/Twist\"",
                "          ns: GlobalNamespace # ns comment",
                "      parameters:",
                "        rate:",
                "          type: Double",
                "          default: 1.0",
                "          ns: PrivateNamespace",
                ""));
        Session s = open(ros2, "block4-ns");
        edit(s, "a_node.out", "namespace", null, "RelativeNamespace", null);
        edit(s, "a_node.inp", "namespace", null, "PrivateNamespace", null);
        edit(s, "a_node.rate", "namespace", null, "", null);
        String text = save(s, ros2);
        assertTrue(text.contains("        out:\n          type: \"nav_msgs/msg/Twist\"\n          ns: RelativeNamespace\n"), text);
        assertTrue(text.contains("          ns: PrivateNamespace # ns comment"), text);
        assertTrue(text.contains("          default: 1.0\n"), text);
        assertFalse(text.contains("ns: PrivateNamespace\n"), "parameter ns line removed:\n" + text);

        // Changing the kind keeps the namespace.
        edit(s, "a_node.inp", "kind", null, "pub", null);
        text = save(s, ros2);
        assertTrue(text.contains("        inp:\n          type: \"nav_msgs/msg/Twist\"\n          ns: PrivateNamespace"), text);
        ros.Node node = ((ros.Package) s.state.getSemanticModel()).getArtifact().get(0).getNode();
        assertTrue(node.getPublisher().stream().anyMatch(p -> "inp".equals(p.getName()) && p.getNamespace() instanceof ros.PrivateNamespace));
    }
    @Test
    void editorVocabularyIsDerivedFromTheEcoreMetamodel() throws Exception {
        writeMsgs(tempDir);
        Session s = open(tempDir.resolve("nav_msgs.ros"), "block4-vocab");
        s.gModelFactory.createGModel();
        Object raw = ((org.eclipse.glsp.graph.GArgumentable) s.state.getRoot()).getArgs().get("metamodelJson");
        com.google.gson.JsonObject vocab = com.google.gson.JsonParser.parseString(String.valueOf(raw)).getAsJsonObject();
        java.util.function.Function<String, List<String>> list = k -> {
            List<String> out = new java.util.ArrayList<>();
            vocab.getAsJsonArray(k).forEach(e -> out.add(e.getAsString()));
            return out;
        };
        // Ecore enum LifecycleState
        assertEquals(List.of("Unconfigured", "Inactive", "Active", "Finalized"), list.apply("lifecycleStates"));
        // Ecore ParameterType subclasses the server can create
        assertTrue(list.apply("parameterTypes").containsAll(List.of("String", "Integer", "Double", "Boolean", "Base64", "Array")),
                String.valueOf(list.apply("parameterTypes")));
        assertFalse(list.apply("parameterTypes").contains("Struct"), "Struct cannot be created empty");
        // PrimitivesTypes.ecore AbstractType subclasses, spelled as in Basics.xtext
        assertTrue(list.apply("messageFieldTypes").containsAll(List.of("int32", "float64", "string", "bool[]", "char", "byte[]", "Header")),
                String.valueOf(list.apply("messageFieldTypes")));
        // Ecore Namespace hierarchy
        assertEquals(java.util.Set.of("GlobalNamespace", "RelativeNamespace", "PrivateNamespace"),
                new java.util.HashSet<>(list.apply("namespaceKinds")));
        // Ecore InterfaceType subclasses (minus Parameter)
        assertEquals(java.util.Set.of("pub", "sub", "ss", "sc", "as", "ac"), new java.util.HashSet<>(list.apply("interfaceKinds")));
        // QoS keyword alternatives from the Ros2 grammar
        com.google.gson.JsonObject qos = vocab.getAsJsonObject("qos");
        assertTrue(qos.toString().contains("\"reliability\":{\"values\":[\"best_effort\",\"reliable\"],\"freeText\":false}"), qos.toString());
        assertTrue(qos.toString().contains("\"profile\":{\"values\":[\"default_qos\",\"services_qos\",\"sensor_qos\",\"parameter_qos\"],\"freeText\":false}"), qos.toString());
        assertTrue(qos.toString().contains("\"depth\":{\"values\":[],\"freeText\":true}"), qos.toString());
        assertTrue(qos.toString().contains("\"deadline\":{\"values\":[\"infinite\"],\"freeText\":true}"), qos.toString());
    }
}
