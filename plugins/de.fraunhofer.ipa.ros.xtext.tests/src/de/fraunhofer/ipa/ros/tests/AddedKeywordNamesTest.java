package de.fraunhofer.ipa.ros.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
import org.junit.Before;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;

import de.fraunhofer.ipa.ros.plugin.spi.PluginRegistry;
import de.fraunhofer.ipa.ros2.Ros2RuntimeModule;
import de.fraunhofer.ipa.ros2.Ros2StandaloneSetup;
import de.fraunhofer.ipa.rossystem.RosSystemRuntimeModule;
import de.fraunhofer.ipa.rossystem.RosSystemStandaloneSetup;
import ros.AmentPackage;
import ros.Node;
import system.RosNode;
import system.RosParameter;

/**
 * Design policy rule 6: keywords added after main (such as {@code format:} or {@code slots:})
 * must not stop existing models from using those words as names.
 */
public class AddedKeywordNamesTest {

    private static final List<String> ADDED = List.of("lifecycle", "active_in", "plugins", "implements",
            "pluginslots", "pluginbases", "base", "parameter", "format", "multiple", "class", "header", "loader",
            "slots");

    private Injector ros2Injector;
    private Injector rosSystemInjector;

    @Before
    public void setUp() {
        PluginRegistry.INSTANCE.clearRegistered();
        ros2Injector = new Ros2StandaloneSetup() {
            @Override
            public Injector createInjector() {
                return Guice.createInjector(new Ros2RuntimeModule() {
                    @Override
                    public ClassLoader bindClassLoaderToInstance() {
                        return AddedKeywordNamesTest.class.getClassLoader();
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
                        return AddedKeywordNamesTest.class.getClassLoader();
                    }
                });
            }
        }.createInjectorAndDoEMFRegistration();
    }

    @Test
    public void ros2NamesMayBeAddedKeywords() throws Exception {
        StringBuilder params = new StringBuilder();
        for (String name : ADDED) {
            params.append("        ").append(name).append(":\n          type: String\n");
        }
        String model = "format:\n"
                + "  artifacts:\n"
                + "    header:\n"
                + "      node: header\n"
                + "      publishers:\n"
                + "        base:\n"
                + "          type: \"std_msgs/msg/String\"\n"
                + "      parameters:\n"
                + params;
        XtextResourceSet rs = ros2Injector.getInstance(XtextResourceSet.class);
        load(rs, "inmemory:/std_msgs.ros", "std_msgs:\n  msgs:\n    String\n      message\n        string data\n");
        Resource res = load(rs, "inmemory:/added.ros2", model);
        EcoreUtil.resolveAll(rs);

        assertNoErrors(validate(ros2Injector, res));
        AmentPackage pkg = (AmentPackage) res.getContents().get(0);
        assertEquals("format", pkg.getName());
        assertEquals("header", pkg.getArtifact().get(0).getName());
        Node node = pkg.getArtifact().get(0).getNode();
        assertEquals("base", node.getPublisher().get(0).getName());
        assertEquals(ADDED, node.getParameter().stream().map(p -> p.getName()).collect(Collectors.toList()));
    }

    @Test
    public void rossystemNamesMayBeAddedKeywords() throws Exception {
        XtextResourceSet rs = rosSystemInjector.getInstance(XtextResourceSet.class);
        load(rs, "inmemory:/pkg.ros2", """
                pkg:
                  artifacts:
                    talker:
                      node: talker
                      parameters:
                        format:
                          type: String
                """);
        Resource res = load(rs, "inmemory:/sys.rossystem", """
                slots:
                  nodes:
                    plugins:
                      from: "pkg.talker"
                      parameters:
                        - format: "talker::format"
                          value: "jpeg"
                """);
        EcoreUtil.resolveAll(rs);

        assertNoErrors(validate(rosSystemInjector, res));
        system.System sys = (system.System) res.getContents().get(0);
        assertEquals("slots", sys.getName());
        RosNode node = (RosNode) sys.getComponents().get(0);
        assertEquals("plugins", node.getName());
        RosParameter param = node.getRosparameters().get(0);
        assertEquals("format", param.getName());
    }

    private static Resource load(final XtextResourceSet rs, final String uri, final String content) throws Exception {
        Resource res = rs.createResource(URI.createURI(uri));
        res.load(new ByteArrayInputStream(content.getBytes(StandardCharsets.UTF_8)), null);
        return res;
    }

    private static List<Issue> validate(final Injector injector, final Resource res) {
        return injector.getInstance(IResourceValidator.class).validate(res, CheckMode.ALL, CancelIndicator.NullImpl);
    }

    private static void assertNoErrors(final List<Issue> issues) {
        List<Issue> errors = issues.stream().filter(i -> i.getSeverity() == Severity.ERROR).toList();
        assertTrue("Unexpected errors: " + errors, errors.isEmpty());
    }
}
