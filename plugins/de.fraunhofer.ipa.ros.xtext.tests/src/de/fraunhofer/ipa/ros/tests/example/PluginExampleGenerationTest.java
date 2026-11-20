package de.fraunhofer.ipa.ros.tests.example;

import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeTrue;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.generator.InMemoryFileSystemAccess;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.Issue;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;

import de.fraunhofer.ipa.ros.RosStandaloneSetup;
import de.fraunhofer.ipa.ros.plugin.spi.PluginRegistry;
import de.fraunhofer.ipa.ros.tests.Ros2InjectorProvider;
import de.fraunhofer.ipa.ros2.generator.Ros2Generator;
import de.fraunhofer.ipa.rossystem.RosSystemRuntimeModule;
import de.fraunhofer.ipa.rossystem.RosSystemStandaloneSetup;
import de.fraunhofer.ipa.rossystem.generator.RosSystemGenerator;

/**
 * Generates the plugin example in {@code tools/plugin-example} into a colcon workspace. Run through
 * {@code tools/plugin-example/run.sh}; skipped in normal builds. {@code ROSTOOLING_EXAMPLE_MODELS}
 * is the models directory, {@code ROSTOOLING_EXAMPLE_OUT} the workspace {@code src} directory, and
 * {@code ROSTOOLING_EXAMPLE_DISTRO} the ROS 2 distribution (default jazzy). Every model must
 * validate without errors.
 */
public class PluginExampleGenerationTest {

    @Test
    public void generateExample() throws IOException {
        String models = System.getenv("ROSTOOLING_EXAMPLE_MODELS");
        String out = System.getenv("ROSTOOLING_EXAMPLE_OUT");
        assumeTrue("plugin example not requested", models != null && out != null);
        String distro = System.getenv().getOrDefault("ROSTOOLING_EXAMPLE_DISTRO", "jazzy");

        PluginRegistry.INSTANCE.clearRegistered();
        Injector ros2Injector = new Ros2InjectorProvider().getInjector();
        new RosStandaloneSetup().createInjectorAndDoEMFRegistration();
        Injector systemInjector = new RosSystemStandaloneSetup() {
            @Override
            public Injector createInjector() {
                return Guice.createInjector(new RosSystemRuntimeModule() {
                    @Override
                    public ClassLoader bindClassLoaderToInstance() {
                        return PluginExampleGenerationTest.class.getClassLoader();
                    }
                });
            }
        }.createInjectorAndDoEMFRegistration();

        XtextResourceSet resourceSet = systemInjector.getInstance(XtextResourceSet.class);
        List<Resource> resources = new ArrayList<>();
        try (Stream<Path> walk = Files.walk(Paths.get(models))) {
            for (Path file : walk.filter(Files::isRegularFile).sorted().collect(Collectors.toList())) {
                resources.add(resourceSet.getResource(URI.createFileURI(file.toAbsolutePath().toString()), true));
            }
        }
        EcoreUtil.resolveAll(resourceSet);

        List<String> errors = new ArrayList<>();
        for (Resource resource : resources) {
            XtextResource xtext = (XtextResource) resource;
            for (Issue issue : xtext.getResourceServiceProvider().getResourceValidator()
                    .validate(xtext, CheckMode.ALL, CancelIndicator.NullImpl)) {
                if (issue.getSeverity() == Severity.ERROR) {
                    errors.add(resource.getURI().lastSegment() + ": " + issue);
                }
            }
        }
        assertTrue("Example models have errors: " + errors, errors.isEmpty());

        Ros2Generator ros2Generator = ros2Injector.getInstance(Ros2Generator.class);
        RosSystemGenerator systemGenerator = systemInjector.getInstance(RosSystemGenerator.class);
        for (Resource resource : resources) {
            InMemoryFileSystemAccess fsa = new InMemoryFileSystemAccess();
            String name = resource.getURI().lastSegment();
            if (name.endsWith(".ros2")) {
                ros2Generator.generateTargeted(resource, fsa, null, "cpp", distro, List.of());
            } else if (name.endsWith(".rossystem")) {
                systemGenerator.generateSystemTargeted(resource, fsa, List.of());
            }
            for (var file : fsa.getTextFiles().entrySet()) {
                Path target = Paths.get(out).resolve(file.getKey().replaceFirst("^DEFAULT_OUTPUT/?", ""));
                Files.createDirectories(target.getParent());
                Files.write(target, file.getValue().toString().getBytes(StandardCharsets.UTF_8));
            }
        }
    }
}
