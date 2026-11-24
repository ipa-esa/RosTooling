package de.fraunhofer.ipa.ros.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.junit.Before;
import org.junit.Test;

import com.google.inject.Injector;

import de.fraunhofer.ipa.ros.plugin.spi.PluginRegistry;
import de.fraunhofer.ipa.ros2.Ros2StandaloneSetup;
import de.fraunhofer.ipa.rossystem.RosSystemStandaloneSetup;
import ros.AmentPackage;
import ros.Parameter;
import ros.ParameterBase64;
import ros.ParameterBase64Type;
import system.RosNode;
import system.RosParameter;

/**
 * A Base64 parameter takes a binary literal ("0b01000001"), as the editor hint says. The value used to
 * be typed as XML Base64Binary, which accepts base64 text only, so every literal was rejected with
 * "Invalid base64Binary value".
 */
public class Base64ParameterTest {

    private Injector rosSystemInjector;

    @Before
    public void setUp() {
        PluginRegistry.INSTANCE.clearRegistered();
        new Ros2StandaloneSetup().createInjectorAndDoEMFRegistration();
        rosSystemInjector = new RosSystemStandaloneSetup().createInjectorAndDoEMFRegistration();
    }

    private Resource load(final XtextResourceSet rs, final String uri, final String text) throws Exception {
        Resource res = rs.createResource(URI.createURI(uri));
        res.load(new ByteArrayInputStream(text.getBytes(StandardCharsets.UTF_8)), null);
        return res;
    }

    @Test
    public void binaryLiteralIsAcceptedAsDefaultAndAsSystemValue() throws Exception {
        XtextResourceSet rs = rosSystemInjector.getInstance(XtextResourceSet.class);
        Resource pkg = load(rs, "inmemory:/params_example.ros2", """
                params_example:
                  artifacts:
                    holder:
                      node: holder
                      parameters:
                        base64_test:
                          type: Base64
                          default: 0b01000001
                        other:
                          type: Base64
                """);
        Resource sys = load(rs, "inmemory:/sys.rossystem", """
                sys:
                  nodes:
                    holder_inst:
                      from: "params_example.holder"
                      parameters:
                        - base64_test: "holder::base64_test"
                          value: 0B0100
                """);
        EcoreUtil.resolveAll(rs);
        assertTrue(pkg.getErrors().toString(), pkg.getErrors().isEmpty());
        assertTrue(sys.getErrors().toString(), sys.getErrors().isEmpty());

        Parameter declared = ((AmentPackage) pkg.getContents().get(0)).getArtifact().get(0).getNode()
                .getParameter().get(0);
        ParameterBase64 dflt = ((ParameterBase64Type) declared.getType()).getDefault();
        assertEquals("0b01000001", dflt.getValue());

        RosNode node = (RosNode) ((system.System) sys.getContents().get(0)).getComponents().get(0);
        RosParameter set = node.getRosparameters().get(0);
        assertEquals("0B0100", ((ParameterBase64) set.getValue()).getValue());
    }

    @Test
    public void textThatIsNotABinaryLiteralStillFails() throws Exception {
        XtextResourceSet rs = rosSystemInjector.getInstance(XtextResourceSet.class);
        Resource pkg = load(rs, "inmemory:/bad.ros2", """
                bad_pkg:
                  artifacts:
                    holder:
                      node: holder
                      parameters:
                        p:
                          type: Base64
                          default: 0b0102
                """);
        assertTrue("a digit other than 0 and 1 is not a binary literal", !pkg.getErrors().isEmpty());
    }
}
