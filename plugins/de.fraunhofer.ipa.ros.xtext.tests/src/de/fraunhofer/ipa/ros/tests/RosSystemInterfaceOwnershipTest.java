package de.fraunhofer.ipa.ros.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

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

import com.google.inject.Injector;

import de.fraunhofer.ipa.ros.plugin.spi.PluginRegistry;
import de.fraunhofer.ipa.ros2.Ros2StandaloneSetup;
import de.fraunhofer.ipa.rossystem.RosSystemStandaloneSetup;
import de.fraunhofer.ipa.rossystem.validation.RosSystemValidator;

/**
 * An interface of a system node has to be one the node's own package model defines. Without the
 * check, a reference to another node's interface resolves without any diagnostic.
 */
public class RosSystemInterfaceOwnershipTest {
    private static final String PKG = """
            probe_pkg:
              artifacts:
                talker:
                  node: talker
                  publishers:
                    chatter:
                      type: "std_msgs/msg/String"
                listener:
                  node: listener
                  publishers:
                    echo:
                      type: "std_msgs/msg/String"
            """;

    private Injector rosSystemInjector;

    @Before
    public void setUp() {
        PluginRegistry.INSTANCE.clearRegistered();
        new Ros2StandaloneSetup().createInjectorAndDoEMFRegistration();
        rosSystemInjector = new RosSystemStandaloneSetup().createInjectorAndDoEMFRegistration();
    }

    private Resource system(final String text) throws Exception {
        XtextResourceSet rs = rosSystemInjector.getInstance(XtextResourceSet.class);
        load(rs, "inmemory:/std_msgs.ros", """
                std_msgs:
                  msgs:
                    String
                      message
                        string data
                """);
        load(rs, "inmemory:/probe_pkg.ros2", PKG);
        Resource res = load(rs, "inmemory:/probe_sys.rossystem", text);
        EcoreUtil.resolveAll(rs);
        return res;
    }

    private static Resource load(final XtextResourceSet rs, final String uri, final String text) throws Exception {
        Resource res = rs.createResource(URI.createURI(uri));
        res.load(new ByteArrayInputStream(text.getBytes(StandardCharsets.UTF_8)), null);
        return res;
    }

    private List<Issue> errors(final Resource res) {
        return rosSystemInjector.getInstance(IResourceValidator.class)
                .validate(res, CheckMode.ALL, CancelIndicator.NullImpl).stream()
                .filter(i -> i.getSeverity() == Severity.ERROR).toList();
    }

    private static String sys(final String talkerInterface) {
        return """
                probe_sys:
                  nodes:
                    talker:
                      from: "probe_pkg.talker"
                      interfaces:
                        - "%s"
                    listener:
                      from: "probe_pkg.listener"
                """.formatted(talkerInterface);
    }

    @Test
    public void ownInterfaceIsAccepted() throws Exception {
        assertTrue(errors(system(sys("chatter_pub\": pub-> \"talker::chatter"))).toString(),
                errors(system(sys("chatter_pub\": pub-> \"talker::chatter"))).isEmpty());
    }

    @Test
    public void anotherNodesInterfaceIsAnError() throws Exception {
        List<Issue> errs = errors(system(sys("echo_pub\": pub-> \"listener::echo")));
        List<Issue> foreign = errs.stream()
                .filter(i -> RosSystemValidator.FOREIGN_INTERFACE.equals(i.getCode())).toList();
        assertEquals(errs.toString(), 1, foreign.size());
        assertTrue(foreign.get(0).getMessage(), foreign.get(0).getMessage().contains("node 'listener'"));
    }

    @Test
    public void omittedInterfacesAreStillAccepted() throws Exception {
        String text = """
                probe_sys:
                  nodes:
                    talker:
                      from: "probe_pkg.talker"
                """;
        assertTrue(errors(system(text)).toString(), errors(system(text)).isEmpty());
    }
}
