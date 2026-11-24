package de.fraunhofer.ipa.ros.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
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

import de.fraunhofer.ipa.ros.RosStandaloneSetup;
import de.fraunhofer.ipa.ros.plugin.spi.PluginRegistry;
import de.fraunhofer.ipa.ros2.Ros2StandaloneSetup;
import de.fraunhofer.ipa.rossystem.RosSystemStandaloneSetup;
import ros.AmentPackage;
import ros.ExternalDependency;
import ros.PackageDependency;

/**
 * "dependencies: [name]" names packages of the workspace or the catalogue. The index used to hold no
 * name for a package, so every such reference failed with "Couldn't resolve reference to Package".
 */
public class PackageDependencyTest {

    private Injector injector;

    @Before
    public void setUp() {
        PluginRegistry.INSTANCE.clearRegistered();
        new RosStandaloneSetup().createInjectorAndDoEMFRegistration();
        new Ros2StandaloneSetup().createInjectorAndDoEMFRegistration();
        injector = new RosSystemStandaloneSetup().createInjectorAndDoEMFRegistration();
    }

    private static Resource load(final XtextResourceSet rs, final String uri, final String text) throws Exception {
        Resource res = rs.createResource(URI.createURI(uri));
        res.load(new ByteArrayInputStream(text.getBytes(StandardCharsets.UTF_8)), null);
        return res;
    }

    private static final String CATALOGUE = """
            std_msgs:
              msgs:
                String
                  message
                    string data
            sensor_msgs:
              msgs:
                Range
                  message
                    float32 range
            """;

    private static final String BASE = """
            base_pkg:
              artifacts:
                base_node:
                  node: base_node
            """;

    @Test
    public void packagesOfTheWorkspaceAndTheCatalogueResolve() throws Exception {
        XtextResourceSet rs = injector.getInstance(XtextResourceSet.class);
        load(rs, "inmemory:/catalogue.ros", CATALOGUE);
        load(rs, "inmemory:/base_pkg.ros2", BASE);
        Resource dep = load(rs, "inmemory:/dep_pkg.ros2", """
                dep_pkg:
                  artifacts:
                    talker:
                      node: talker
                  dependencies: [std_msgs, sensor_msgs, base_pkg]
                """);
        EcoreUtil.resolveAll(rs);
        assertTrue(dep.getErrors().toString(), dep.getErrors().isEmpty());

        AmentPackage pkg = (AmentPackage) dep.getContents().get(0);
        assertEquals(3, pkg.getDependency().size());
        assertEquals("std_msgs", ((PackageDependency) pkg.getDependency().get(0)).getPackage().getName());
        assertEquals("sensor_msgs", ((PackageDependency) pkg.getDependency().get(1)).getPackage().getName());
        assertEquals("base_pkg", ((PackageDependency) pkg.getDependency().get(2)).getPackage().getName());
        assertFalse(((PackageDependency) pkg.getDependency().get(2)).getPackage().eIsProxy());
    }

    @Test
    public void aNameWithoutAModelStaysAnErrorAndExternalDependencyStillWorks() throws Exception {
        XtextResourceSet rs = injector.getInstance(XtextResourceSet.class);
        Resource dep = load(rs, "inmemory:/dep_pkg.ros2", """
                dep_pkg:
                  artifacts:
                    talker:
                      node: talker
                  dependencies: [rclcpp, ExternalDependency rclcpp]
                """);
        EcoreUtil.resolveAll(rs);
        assertEquals(dep.getErrors().toString(), 1, dep.getErrors().size());
        assertTrue(dep.getErrors().get(0).getMessage().contains("rclcpp"));
        AmentPackage pkg = (AmentPackage) dep.getContents().get(0);
        assertTrue(pkg.getDependency().get(1) instanceof ExternalDependency);
    }
}
