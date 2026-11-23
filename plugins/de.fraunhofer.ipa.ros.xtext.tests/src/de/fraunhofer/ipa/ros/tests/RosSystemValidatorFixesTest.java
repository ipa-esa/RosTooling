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
 * A system without fromFile: validates without the fromFile check throwing, and two interfaces
 * of one node may not share a name, since connections refer to interfaces by name.
 */
public class RosSystemValidatorFixesTest {

    private static final String PKG = """
            probe_pkg:
              artifacts:
                talker:
                  node: talker
                  publishers:
                    chatter:
                      type: "std_msgs/msg/String"
                    status:
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

    private static String sys(final String fromFile, final String secondLabel) {
        return "probe_sys:\n" + fromFile + """
                  nodes:
                    talker:
                      from: "probe_pkg.talker"
                      interfaces:
                        - "chatter_pub": pub-> "talker::chatter"
                        - "%s": pub-> "talker::status"
                """.formatted(secondLabel);
    }

    @Test
    public void systemWithoutFromFileValidatesAndTheCheckDoesNotThrow() throws Exception {
        Resource res = system(sys("", "status_pub"));
        assertTrue(res.getErrors().toString(), res.getErrors().isEmpty());
        assertTrue(errors(res).toString(), errors(res).isEmpty());
        system.System sys = (system.System) res.getContents().get(0);
        // Threw a NullPointerException before, which Xtext logged and swallowed.
        rosSystemInjector.getInstance(RosSystemValidator.class).fromFileHelper(sys);
    }

    @Test
    public void fromFileWithoutPackageIsStillAnError() throws Exception {
        List<Issue> errs = errors(system(sys("  fromFile: \"probe.launch.py\"\n", "status_pub")));
        assertTrue(errs.toString(), errs.stream().anyMatch(i -> RosSystemValidator.FROM_FILE_PATH.equals(i.getCode())));
    }

    @Test
    public void interfaceNamesAreUniqueWithinANode() throws Exception {
        assertTrue(errors(system(sys("", "status_pub"))).isEmpty());
        List<Issue> errs = errors(system(sys("", "chatter_pub")));
        List<Issue> dups = errs.stream()
                .filter(i -> RosSystemValidator.DUPLICATE_INTERFACE_NAME.equals(i.getCode())).toList();
        assertEquals(errs.toString(), 1, dups.size());
        assertTrue(dups.get(0).getMessage(), dups.get(0).getMessage().contains("'chatter_pub' more than once"));
        assertEquals(Integer.valueOf(7), dups.get(0).getLineNumber());
    }
}
