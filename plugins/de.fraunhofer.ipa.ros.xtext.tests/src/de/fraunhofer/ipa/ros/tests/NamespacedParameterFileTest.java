package de.fraunhofer.ipa.ros.tests;

import static org.junit.Assert.assertFalse;
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
 * A node with a parameter file (more than five parameters or a struct value) and a namespace: the
 * launch file loads the file the generator wrote, and the file's top key is the fully qualified
 * node name. Without a namespace the output is the plain {@code config/<name>.yaml} keyed by the
 * bare name.
 */
public class NamespacedParameterFileTest {

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
                        return NamespacedParameterFileTest.class.getClassLoader();
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

    private InMemoryFileSystemAccess generate(final String namespaceLine) throws Exception {
        XtextResourceSet rs = injector.getInstance(XtextResourceSet.class);
        load(rs, "inmemory:/ns_pkg.ros2", """
                ns_pkg:
                  artifacts:
                    worker:
                      node: worker
                      parameters:
                        p1:
                          type: Integer
                        p2:
                          type: Integer
                        p3:
                          type: Integer
                        p4:
                          type: Integer
                        p5:
                          type: Integer
                        p6:
                          type: Integer
                """);
        Resource sys = load(rs, "inmemory:/ns_sys.rossystem", """
                ns_sys:
                  nodes:
                    "node1":
                      from: "ns_pkg.worker"
                """ + namespaceLine + """
                      parameters:
                        - p1: "worker::p1"
                          value: 1
                        - p2: "worker::p2"
                          value: 2
                        - p3: "worker::p3"
                          value: 3
                        - p4: "worker::p4"
                          value: 4
                        - p5: "worker::p5"
                          value: 5
                        - p6: "worker::p6"
                          value: 6
                """);
        EcoreUtil.resolveAll(rs);
        assertTrue(sys.getErrors().toString(), sys.getErrors().isEmpty());
        InMemoryFileSystemAccess fsa = new InMemoryFileSystemAccess();
        injector.getInstance(RosSystemGenerator.class).generateSystemTargeted(sys, fsa, List.of());
        return fsa;
    }

    private static String file(final InMemoryFileSystemAccess fsa, final String suffix) {
        return fsa.getAllFiles().entrySet().stream().filter(e -> e.getKey().endsWith(suffix))
                .map(e -> e.getValue().toString()).collect(Collectors.joining("\n"));
    }

    private static boolean has(final InMemoryFileSystemAccess fsa, final String suffix) {
        return fsa.getAllFiles().keySet().stream().anyMatch(k -> k.endsWith(suffix));
    }

    @Test
    public void namespacedNodeLoadsTheFileTheGeneratorWroteAndKeysItByQualifiedName() throws Exception {
        InMemoryFileSystemAccess fsa = generate("      namespace: \"my_ns\"\n");
        assertTrue(fsa.getAllFiles().keySet().toString(), has(fsa, "config/my_ns_node1.yaml"));
        assertFalse(has(fsa, "config/node1.yaml"));
        assertTrue(file(fsa, ".launch.py"), file(fsa, ".launch.py").contains("'my_ns_node1.yaml'"));
        String yaml = file(fsa, "config/my_ns_node1.yaml");
        assertTrue(yaml, yaml.startsWith("/my_ns/node1:"));
        assertTrue(yaml, yaml.contains("ros__parameters:"));
    }

    @Test
    public void nodeWithoutNamespaceIsUnchanged() throws Exception {
        InMemoryFileSystemAccess fsa = generate("");
        assertTrue(fsa.getAllFiles().keySet().toString(), has(fsa, "config/node1.yaml"));
        assertTrue(file(fsa, ".launch.py"), file(fsa, ".launch.py").contains("'node1.yaml'"));
        assertTrue(file(fsa, "config/node1.yaml"), file(fsa, "config/node1.yaml").startsWith("node1:"));
    }
}
