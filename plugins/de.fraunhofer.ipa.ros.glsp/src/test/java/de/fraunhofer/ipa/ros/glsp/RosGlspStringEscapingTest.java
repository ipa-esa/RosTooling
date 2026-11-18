package de.fraunhofer.ipa.ros.glsp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.google.inject.Guice;
import com.google.inject.Injector;
import de.fraunhofer.ipa.ros.glsp.model.RosAstNodeModelSerializer;
import de.fraunhofer.ipa.ros.glsp.model.RosModelState;
import de.fraunhofer.ipa.ros.glsp.operations.EditRosPropertyOperation;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.eclipse.emf.common.command.Command;
import org.eclipse.glsp.server.di.ServerModule;
import org.eclipse.glsp.server.features.core.model.GModelFactory;
import org.eclipse.glsp.server.features.core.model.RequestModelAction;
import org.eclipse.glsp.server.features.core.model.SourceModelStorage;
import org.eclipse.glsp.server.operations.Operation;
import org.eclipse.glsp.server.operations.OperationHandler;
import org.eclipse.glsp.server.operations.OperationHandlerRegistry;
import org.eclipse.glsp.server.protocol.InitializeClientSessionParameters;
import org.eclipse.glsp.server.session.ClientSession;
import org.eclipse.glsp.server.session.ClientSessionManager;
import org.eclipse.xtext.resource.XtextResource;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import ros.ParameterString;
import system.RosNode;
import system.RosParameter;

/**
 * String parameter values written back by the GLSP serializer must be valid Xtext {@code STRING}
 * literals: launch substitutions such as {@code $(command "xacro ...")} contain double quotes and
 * backslashes. Unchanged values must stay byte-identical, whatever quote style the user chose.
 */
class RosGlspStringEscapingTest {

    private static final String SINGLE_QUOTED_LITERAL =
            "'$(command \"xacro $(find-pkg-share some_pkg)/urdf/x.urdf.xacro\")'";
    private static final String ESCAPED_LITERAL =
            "\"$(command \\\"xacro $(find-pkg-share some_pkg)/urdf/y.urdf.xacro arg:=$(var arg)\\\")\"";
    private static final String PATH_LITERAL = "\"$(find-pkg-share some_pkg)/config/x.yaml\"";

    @TempDir
    Path tempDir;

    private RosModelState state;
    private OperationHandlerRegistry registry;

    private void open(final Path file) {
        Injector serverInjector = Guice.createInjector(
                new ServerModule().configureDiagramModule(new RosGlspModule()));
        ClientSession session = serverInjector.getInstance(ClientSessionManager.class).getOrCreateClientSession(
                new InitializeClientSessionParameters("escaping", RosModelTypes.DIAGRAM_TYPE, Collections.emptyList()));
        Injector inj = session.getInjector();
        state = inj.getInstance(RosModelState.class);
        registry = inj.getInstance(OperationHandlerRegistry.class);
        Map<String, String> opts = new HashMap<>();
        opts.put("sourceUri", file.toUri().toString());
        inj.getInstance(SourceModelStorage.class).loadSourceModel(new RequestModelAction(opts));
        inj.getInstance(GModelFactory.class).createGModel();
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    private void exec(final Operation op) {
        OperationHandler handler = registry.getOperationHandler(op).orElseThrow();
        Command cmd = ((java.util.Optional<Command>) handler.createCommand(op)).orElseThrow(
                () -> new AssertionError("Empty command for " + op.getClass().getSimpleName()));
        state.execute(cmd);
    }

    private RosAstNodeModelSerializer.TextChange commit() throws Exception {
        RosAstNodeModelSerializer.TextChange change = RosAstNodeModelSerializer.computeAndCommit(state);
        XtextResource res = state.getXtextResource().orElseThrow();
        assertFalse(res.getParseResult().hasSyntaxErrors(),
                change.newText + "\n" + res.getParseResult().getSyntaxErrors());
        return change;
    }

    private String parameterValue(final String node, final String param) {
        for (var c : state.getRosSystem().orElseThrow().getComponents()) {
            if (c instanceof RosNode rn && node.equals(rn.getName())) {
                for (RosParameter rp : rn.getRosparameters()) {
                    if (param.equals(rp.getName())) {
                        return ((ParameterString) rp.getValue()).getValue();
                    }
                }
            }
        }
        throw new AssertionError("no parameter " + node + "." + param);
    }

    private Path writeModels() throws Exception {
        Files.writeString(tempDir.resolve("desc_pkg.ros2"), String.join("\n",
                "desc_pkg:",
                "  artifacts:",
                "    describer:",
                "      node: describer",
                "      parameters:",
                "        robot_description:",
                "          type: String",
                "        config_file:",
                "          type: String",
                "        extra_args:",
                "          type: String",
                ""));
        Path sysFile = tempDir.resolve("subst_system.rossystem");
        Files.writeString(sysFile, String.join("\n",
                "subst_system:",
                "  nodes:",
                "    single_node:",
                "      from: \"desc_pkg.describer\"",
                "      parameters:",
                "        - robot_description: \"describer::robot_description\"",
                "          value: " + SINGLE_QUOTED_LITERAL,
                "        - config_file: \"describer::config_file\"",
                "          value: " + PATH_LITERAL,
                "    double_node:",
                "      from: \"desc_pkg.describer\"",
                "      parameters:",
                "        - robot_description: \"describer::robot_description\"",
                "          value: " + ESCAPED_LITERAL,
                ""));
        return sysFile;
    }

    @Test
    void unchangedSubstitutionValuesProduceNoEdits() throws Exception {
        Path sysFile = writeModels();
        String original = Files.readString(sysFile);
        open(sysFile);
        assertEquals("$(command \"xacro $(find-pkg-share some_pkg)/urdf/x.urdf.xacro\")",
                parameterValue("single_node", "robot_description"));
        assertEquals("$(command \"xacro $(find-pkg-share some_pkg)/urdf/y.urdf.xacro arg:=$(var arg)\")",
                parameterValue("double_node", "robot_description"));

        RosAstNodeModelSerializer.TextChange noop = commit();
        assertTrue(noop.edits.isEmpty(), "unexpected edits: " + noop.newText);
        assertEquals(original, noop.newText);

        // An unrelated edit leaves the parameter literals byte-identical.
        exec(new EditRosPropertyOperation("double_node", "namespace", null, "robot", null));
        String text = commit().newText;
        assertTrue(text.contains("      namespace: "), text);
        assertTrue(text.contains("          value: " + SINGLE_QUOTED_LITERAL + "\n"), text);
        assertTrue(text.contains("          value: " + ESCAPED_LITERAL + "\n"), text);
        assertTrue(text.contains("          value: " + PATH_LITERAL + "\n"), text);
    }

    @Test
    void addedAndEditedValuesAreEscapedAndRoundTrip() throws Exception {
        Path sysFile = writeModels();
        open(sysFile);

        String added = "$(command \"xacro $(find-pkg-share some_pkg)/urdf/z.urdf.xacro\") C:\\tmp";
        String edited = "$(command \"xacro\" 'quoted arg')";
        String editedDouble = "$(command 'xacro $(find-pkg-share some_pkg)/urdf/x.urdf.xacro arg:=$(var arg)')";
        exec(new EditRosPropertyOperation("single_node", "parameter", "extra_args", added, null));
        exec(new EditRosPropertyOperation("single_node", "parameter", "robot_description", edited, null));
        exec(new EditRosPropertyOperation("double_node", "parameter", "robot_description", editedDouble, null));

        String text = commit().newText;
        assertTrue(text.contains(
                "value: \"$(command \\\"xacro $(find-pkg-share some_pkg)/urdf/z.urdf.xacro\\\") C:\\\\tmp\""), text);
        // An edited literal keeps the quote character the user chose.
        assertTrue(text.contains("value: '$(command \"xacro\" \\'quoted arg\\')'"), text);
        assertTrue(text.contains("value: \"" + editedDouble + "\""), text);
        assertTrue(text.contains("value: " + PATH_LITERAL + "\n"), text);

        // Reload from the written text: the values survive the round trip unchanged.
        Files.writeString(sysFile, text);
        open(sysFile);
        assertEquals(added, parameterValue("single_node", "extra_args"));
        assertEquals(edited, parameterValue("single_node", "robot_description"));
        assertEquals(editedDouble, parameterValue("double_node", "robot_description"));
        assertEquals("$(find-pkg-share some_pkg)/config/x.yaml", parameterValue("single_node", "config_file"));
        assertTrue(commit().edits.isEmpty(), "reloaded text is not stable");
    }

    @Test
    void quoteDslStringEscapesPerXtextStringTerminal() {
        assertEquals("\"a\\\"b\\\\c\\nd'e\"", RosAstNodeModelSerializer.quoteDslString("a\"b\\c\nd'e", '"'));
        assertEquals("'a\"b\\'c'", RosAstNodeModelSerializer.quoteDslString("a\"b'c", '\''));
        assertEquals("\"\"", RosAstNodeModelSerializer.quoteDslString(null, '"'));
    }
}
