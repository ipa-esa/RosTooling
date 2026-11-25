package de.fraunhofer.ipa.ros.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.google.inject.Injector;
import de.fraunhofer.ipa.ros.RosStandaloneSetup;
import de.fraunhofer.ipa.ros2.ide.Ros2IdeSetup;
import de.fraunhofer.ipa.rossystem.ide.RosSystemIdeSetup;
import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;
import org.eclipse.emf.common.util.URI;
import org.eclipse.lsp4j.CompletionItem;
import org.eclipse.lsp4j.CompletionParams;
import org.eclipse.lsp4j.HoverParams;
import org.eclipse.lsp4j.Position;
import org.eclipse.lsp4j.TextDocumentIdentifier;
import org.eclipse.xtext.ide.server.Document;
import org.eclipse.xtext.ide.server.contentassist.ContentAssistService;
import org.eclipse.xtext.ide.server.hover.HoverService;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.CancelIndicator;
import org.junit.Test;

/**
 * Content assist and hover as the language server serves them, for the indentation-sensitive
 * .ros2 and .rossystem grammars. A "|" in the text marks the cursor.
 */
public class ContentAssistAndHoverTest {

    private static final String MSGS = """
            example_interfaces:
              msgs:
                Float64
                  message
                    float64 data
              srvs:
                AddTwoInts
                  request
                    int64 a
                    int64 b
                  response
                    int64 sum
            """;

    private static final String PKG = """
            demo_pkg:
              artifacts:
                server_art:
                  node: server
                  serviceservers:
                    add_two_ints:
                      type: 'example_interfaces/srv/AddTwoInts'
                  publishers:
                    out:
                      type: "example_interfaces/msg/Float64"
            """;

    private static final String SYSTEM = """
            demo_sys:
              nodes:
                server:
                  from: "demo_pkg.server"
                  interfaces:
                    - srv: ss-> "server_art::add_two_ints"
                    - pub: pub-> "server_art::out"
                client:
                  from: "demo_pkg.server"
                  interfaces:
                    - srv2: ss-> "server_art::add_two_ints"
              connections:
                - ["srv", "srv2"]
            """;

    private static final class Fixture {
        final Injector injector;
        final XtextResourceSet resourceSet;

        Fixture(final Injector injector) {
            this.injector = injector;
            this.resourceSet = injector.getInstance(XtextResourceSet.class);
        }

        XtextResource load(final String uri, final String text) throws Exception {
            XtextResource r = (XtextResource) resourceSet.createResource(URI.createURI(uri));
            r.load(new ByteArrayInputStream(text.getBytes(StandardCharsets.UTF_8)), null);
            return r;
        }
    }

    private Fixture workspace() throws Exception {
        new RosStandaloneSetup().createInjectorAndDoEMFRegistration();
        Ros2IdeSetup ros2 = new Ros2IdeSetup();
        Fixture f = new Fixture(ros2.createInjectorAndDoEMFRegistration());
        f.load("file:/ws/example_interfaces.ros", MSGS);
        f.load("file:/ws/demo_pkg.ros2", PKG);
        return f;
    }

    private List<String> complete(final Fixture f, final String uri, final String textWithCursor) throws Exception {
        int cursor = textWithCursor.indexOf('|');
        String text = textWithCursor.replace("|", "");
        XtextResource r = f.load(uri, text);
        Document doc = new Document(1, text);
        CompletionParams params = new CompletionParams(new TextDocumentIdentifier(uri), doc.getPosition(cursor));
        return f.injector.getInstance(ContentAssistService.class)
                .createCompletionList(doc, r, params, CancelIndicator.NullImpl).getItems().stream()
                .map(CompletionItem::getLabel).collect(Collectors.toList());
    }

    private String hover(final Fixture f, final String uri, final String text, final int line, final int column)
            throws Exception {
        XtextResource r = f.load(uri, text);
        HoverParams params = new HoverParams(new TextDocumentIdentifier(uri), new Position(line, column));
        return f.injector.getInstance(HoverService.class)
                .hover(new Document(1, text), r, params, CancelIndicator.NullImpl).getContents().getRight().getValue();
    }

    @Test
    public void typeCompletionInsideQuotesOffersWorkspaceInterfaces() throws Exception {
        Fixture f = workspace();
        String base = "demo2:\n  artifacts:\n    a:\n      node: n\n      publishers:\n        p:\n          type: ";
        List<String> inQuotes = complete(f, "file:/ws/a.ros2", base + "\"example_interfaces/m|\"\n");
        assertEquals(List.of("example_interfaces/msg/Float64"), inQuotes);
        List<String> partial = complete(f, "file:/ws/b.ros2", base + "'Float|'\n");
        assertTrue(partial.toString(), partial.contains("example_interfaces/msg/Float64"));
        List<String> beforeQuote = complete(f, "file:/ws/c.ros2", base + "|\n");
        assertTrue(beforeQuote.toString(), beforeQuote.contains("example_interfaces/msg/Float64"));
        assertFalse("services are not offered for a publisher", beforeQuote.contains("example_interfaces/srv/AddTwoInts"));
    }

    @Test
    public void typeCompletionKeepsExistingQuotesAndQuotesBareValues() throws Exception {
        Fixture f = workspace();
        String base = "demo2:\n  artifacts:\n    a:\n      node: n\n      serviceservers:\n        s:\n          type: ";
        assertEquals("closing quote already there: nothing is added",
                "example_interfaces/srv/AddTwoInts", proposal(f, "file:/ws/d.ros2", base + "\"example_interfaces/s|\"\n"));
        assertEquals("no quote typed yet: the value is quoted",
                "\"example_interfaces/srv/AddTwoInts\"", proposal(f, "file:/ws/d2.ros2", base + "|\n"));
    }

    private String proposal(final Fixture f, final String uri, final String textWithCursor) throws Exception {
        int cursor = textWithCursor.indexOf('|');
        String text = textWithCursor.replace("|", "");
        XtextResource r = f.load(uri, text);
        Document doc = new Document(1, text);
        CompletionParams params = new CompletionParams(new TextDocumentIdentifier(uri), doc.getPosition(cursor));
        CompletionItem item = f.injector.getInstance(ContentAssistService.class)
                .createCompletionList(doc, r, params, CancelIndicator.NullImpl).getItems().stream()
                .filter(i -> "example_interfaces/srv/AddTwoInts".equals(i.getLabel())).findFirst().orElse(null);
        assertNotNull(item);
        return item.getTextEdit().getLeft().getNewText();
    }

    @Test
    public void hoverOnInterfaceAndTypeDescribesTheMessage() throws Exception {
        Fixture f = workspace();
        // line 6: "          type: 'example_interfaces/srv/AddTwoInts'"
        String onType = hover(f, "file:/ws/h.ros2", PKG, 6, 25);
        assertTrue(onType, onType.contains("**Service** `example_interfaces/srv/AddTwoInts`"));
        assertTrue(onType, onType.contains("int64 a") && onType.contains("int64 sum"));
        // line 5: the interface name
        String onName = hover(f, "file:/ws/h2.ros2", PKG, 5, 10);
        assertTrue(onName, onName.contains("**Service Server** `add_two_ints`"));
        // line 3: the artifact
        String onArtifact = hover(f, "file:/ws/h3.ros2", PKG, 2, 6);
        assertTrue(onArtifact, onArtifact.contains("**Artifact** `server_art`") && onArtifact.contains("server"));
    }

    @Test
    public void systemCompletionAndHover() throws Exception {
        Fixture f = workspace();
        Fixture sys = new Fixture(new RosSystemIdeSetup().createInjectorAndDoEMFRegistration());
        // The system resource set needs the package models too.
        sys.load("file:/ws/example_interfaces.ros", MSGS);
        sys.load("file:/ws/demo_pkg.ros2", PKG);

        String from = SYSTEM.replace("\"demo_pkg.server\"", "\"demo_|\"");
        List<String> nodes = complete(sys, "file:/ws/s1.rossystem", from);
        assertTrue(nodes.toString(), nodes.contains("demo_pkg.server"));

        String onRef = SYSTEM.replaceFirst("server_art::add_two_ints", "server_art::|");
        List<String> ifaces = complete(sys, "file:/ws/s2.rossystem", onRef);
        assertTrue(ifaces.toString(), ifaces.contains("server_art::add_two_ints"));

        String conn = SYSTEM.replace("[\"srv\", \"srv2\"]", "[\"s|\", \"srv2\"]");
        List<String> ends = complete(sys, "file:/ws/s3.rossystem", conn);
        assertTrue(ends.toString(), ends.stream().anyMatch(l -> l.endsWith("srv") || l.equals("srv")));

        String h = hover(sys, "file:/ws/s4.rossystem", SYSTEM, 3, 14);
        assertTrue(h, h.contains("Node") && h.contains("server"));
        String hi = hover(sys, "file:/ws/s5.rossystem", SYSTEM, 5, 30);
        assertTrue(hi, hi.contains("Service Server") && hi.contains("example_interfaces/srv/AddTwoInts"));
    }
}
