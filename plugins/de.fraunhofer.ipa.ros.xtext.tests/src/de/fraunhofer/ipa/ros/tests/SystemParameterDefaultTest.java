package de.fraunhofer.ipa.ros.tests;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.generator.InMemoryFileSystemAccess;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.junit.Before;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;

import de.fraunhofer.ipa.ros.plugin.spi.PluginRegistry;
import de.fraunhofer.ipa.ros2.Ros2StandaloneSetup;
import de.fraunhofer.ipa.rossystem.RosSystemRuntimeModule;
import de.fraunhofer.ipa.rossystem.RosSystemStandaloneSetup;
import de.fraunhofer.ipa.rossystem.generator.RosSystemGenerator;

/**
 * A system-level parameter that states only a {@code default:} starts with that default in the
 * launch file and in the README's launch command. The generator read only {@code value:}, so such
 * a parameter was declared as a launch argument with an empty default.
 */
public class SystemParameterDefaultTest {

    private Injector injector;

    @Before
    public void setUp() {
        PluginRegistry.INSTANCE.clearRegistered();
        new Ros2StandaloneSetup().createInjectorAndDoEMFRegistration();
        injector = new RosSystemStandaloneSetup() {
            @Override
            public Injector createInjector() {
                // Same Tycho/OSGi class loader workaround as the compatibility snapshot.
                return Guice.createInjector(new RosSystemRuntimeModule() {
                    @Override
                    public ClassLoader bindClassLoaderToInstance() {
                        return SystemParameterDefaultTest.class.getClassLoader();
                    }
                });
            }
        }.createInjectorAndDoEMFRegistration();
    }

    private Resource load(final XtextResourceSet rs, final String uri, final String text) throws Exception {
        Resource res = rs.createResource(URI.createURI(uri));
        res.load(new ByteArrayInputStream(text.getBytes(StandardCharsets.UTF_8)), null);
        return res;
    }

    @Test
    public void defaultIsTheStartingValueUnlessValueIsGiven() throws Exception {
        XtextResourceSet rs = injector.getInstance(XtextResourceSet.class);
        load(rs, "inmemory:/launch_pkg.ros2", """
                launch_pkg:
                  artifacts:
                    worker:
                      node: worker
                """);
        Resource sys = load(rs, "inmemory:/launch_sys.rossystem", """
                launch_sys:
                  nodes:
                    worker_inst:
                      from: "launch_pkg.worker"
                  parameters:
                    "with_default":
                      type: Double
                      default: 2.0
                    "with_value":
                      type: Double
                      value: 3.0
                    "both":
                      type: Integer
                      default: 4
                      value: 5
                    "text_default":
                      type: String
                      default: "joint_trajectory"
                    "bare":
                      type: String
                """);
        EcoreUtil.resolveAll(rs);
        assertTrue(sys.getErrors().toString(), sys.getErrors().isEmpty());

        InMemoryFileSystemAccess fsa = new InMemoryFileSystemAccess();
        injector.getInstance(RosSystemGenerator.class).generateSystemTargeted(sys, fsa, List.of());
        String launch = fsa.getAllFiles().entrySet().stream()
                .filter(e -> e.getKey().endsWith(".launch.py"))
                .map(e -> e.getValue().toString()).collect(Collectors.joining("\n"));

        assertTrue(launch, launch.contains("\"with_default\", default_value=TextSubstitution(text=\"2.0\")"));
        assertTrue(launch, launch.contains("\"with_value\", default_value=TextSubstitution(text=\"3.0\")"));
        assertTrue("value: wins over default:", launch.contains("\"both\", default_value=TextSubstitution(text=\"5\")"));
        assertTrue(launch, launch.contains("\"text_default\", default_value=TextSubstitution(text=\"joint_trajectory\")"));
        assertTrue("no default and no value stays empty",
                launch.contains("\"bare\", default_value=TextSubstitution(text=\"\")"));
    }
}
