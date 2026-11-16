package de.fraunhofer.ipa.ros.tests.golden;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.generator.InMemoryFileSystemAccess;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;

import de.fraunhofer.ipa.ros.RosStandaloneSetup;
import de.fraunhofer.ipa.ros.tests.Ros2InjectorProvider;
import de.fraunhofer.ipa.rossystem.RosSystemRuntimeModule;
import de.fraunhofer.ipa.rossystem.RosSystemStandaloneSetup;
import de.fraunhofer.ipa.rossystem.generator.RosSystemGenerator;

/**
 * Expected-output ("golden") tests for the .rossystem generator (launch file, build files,
 * README, PlantUML).
 *
 * <p>Every {@code resources/golden/models/*.rossystem} fixture is generated from the
 * {@code golden_pkg} nodes and compared byte for byte with
 * {@code resources/golden/expected/rossystem/<system>/}. The rossystem generator takes no ROS 2
 * distribution, so there is one expected tree per fixture. {@code tools/distro-matrix/build-golden.sh}
 * builds these packages next to {@code golden_pkg} and runs {@code ros2 launch} on them.
 *
 * <p>To accept intended template changes, run the tests with the environment variable
 * {@code ROSTOOLING_UPDATE_GOLDEN=1} and review the resulting diff before committing it.
 */
public class RosSystemGoldenGenerationTest {

    private static final Path MODELS = Paths.get("resources", "golden", "models");
    private static final Path MESSAGES = Paths.get("resources", "basic_msgs");
    private static final Path EXPECTED = Paths.get("resources", "golden", "expected", "rossystem");

    /** A {@code LifecycleNode(...)} call up to its closing parenthesis (calls contain no nested parentheses besides remappings). */
    private static final Pattern LIFECYCLE_CALL = Pattern.compile("LifecycleNode\\((.*?)\\n  \\)", Pattern.DOTALL);

    private static Injector rosSystemInjector() {
        new Ros2InjectorProvider().getInjector();
        new RosStandaloneSetup().createInjectorAndDoEMFRegistration();
        return new RosSystemStandaloneSetup() {
            @Override
            public Injector createInjector() {
                // Same Tycho/OSGi class loader workaround as Ros2InjectorProvider.
                return Guice.createInjector(new RosSystemRuntimeModule() {
                    @Override
                    public ClassLoader bindClassLoaderToInstance() {
                        return RosSystemGoldenGenerationTest.class.getClassLoader();
                    }
                });
            }
        }.createInjectorAndDoEMFRegistration();
    }

    @Test
    public void generatedSystemsMatchExpectedOutput() throws IOException {
        Injector injector = rosSystemInjector();
        RosSystemGenerator generator = injector.getInstance(RosSystemGenerator.class);

        List<Path> fixtures = GoldenFiles.listFiles(MODELS, ".rossystem");
        assertFalse("no .rossystem fixtures in " + MODELS, fixtures.isEmpty());

        List<String> mismatches = new ArrayList<>();
        for (Path fixture : fixtures) {
            Resource model = loadFixture(injector, fixture);
            InMemoryFileSystemAccess fsa = new InMemoryFileSystemAccess();
            generator.generateSystemTargeted(model, fsa, List.of());
            Map<String, String> actual = GoldenFiles.textFiles(fsa);
            if (GoldenFiles.updateRequested()) {
                // Each fixture generates into its own <system>/ directory.
                for (String system : topLevelDirectories(actual)) {
                    GoldenFiles.write(EXPECTED.resolve(system), underDirectory(actual, system));
                }
            } else {
                for (String system : topLevelDirectories(actual)) {
                    GoldenFiles.compare(EXPECTED.resolve(system), underDirectory(actual, system),
                            fixture.getFileName().toString(), mismatches);
                }
            }
        }
        if (!mismatches.isEmpty()) {
            fail("Generated output differs from " + EXPECTED + " (" + mismatches.size() + " file(s)).\n"
                    + "If the change is intended, rerun with ROSTOOLING_UPDATE_GOLDEN=1 and review the diff.\n  "
                    + String.join("\n  ", mismatches));
        }
    }

    /**
     * launch_ros' {@code LifecycleNode.__init__(self, *, name, namespace, **kwargs)} has no default
     * for {@code namespace}; omitting it raises a TypeError when the launch file is loaded.
     */
    @Test
    public void lifecycleNodesAlwaysGetANamespace() throws IOException {
        Injector injector = rosSystemInjector();
        RosSystemGenerator generator = injector.getInstance(RosSystemGenerator.class);

        int lifecycleCalls = 0;
        for (Path fixture : GoldenFiles.listFiles(MODELS, ".rossystem")) {
            InMemoryFileSystemAccess fsa = new InMemoryFileSystemAccess();
            generator.generateSystemTargeted(loadFixture(injector, fixture), fsa, List.of());
            for (Map.Entry<String, String> file : GoldenFiles.textFiles(fsa).entrySet()) {
                if (!file.getKey().endsWith(".launch.py")) {
                    continue;
                }
                Matcher call = LIFECYCLE_CALL.matcher(file.getValue());
                while (call.find()) {
                    lifecycleCalls++;
                    assertTrue(file.getKey() + ": LifecycleNode without namespace=\n" + call.group(),
                            call.group(1).contains("namespace="));
                }
            }
        }
        assertTrue("fixtures contain no standalone lifecycle node", lifecycleCalls >= 2);
    }

    private Resource loadFixture(Injector injector, Path fixture) throws IOException {
        // One resource set per fixture: RosNode names are global in the rossystem scope.
        XtextResourceSet resourceSet = injector.getInstance(XtextResourceSet.class);
        for (Path spec : GoldenFiles.listFiles(MESSAGES, ".ros")) {
            resourceSet.getResource(URI.createFileURI(spec.toAbsolutePath().toString()), true);
        }
        for (Path spec : GoldenFiles.listFiles(MODELS, ".ros")) {
            resourceSet.getResource(URI.createFileURI(spec.toAbsolutePath().toString()), true);
        }
        for (Path spec : GoldenFiles.listFiles(MODELS, ".ros2")) {
            resourceSet.getResource(URI.createFileURI(spec.toAbsolutePath().toString()), true);
        }
        Resource model = resourceSet.getResource(URI.createFileURI(fixture.toAbsolutePath().toString()), true);
        EcoreUtil.resolveAll(resourceSet);

        assertTrue("Fixture " + fixture + " has syntax errors: " + model.getErrors(), model.getErrors().isEmpty());
        IResourceValidator validator = injector.getInstance(IResourceValidator.class);
        List<Issue> errors = validator.validate(model, CheckMode.ALL, CancelIndicator.NullImpl).stream()
                .filter(issue -> issue.getSeverity() == Severity.ERROR)
                .collect(Collectors.toList());
        assertTrue("Fixture " + fixture + " has errors: " + errors, errors.isEmpty());
        return model;
    }

    private static List<String> topLevelDirectories(Map<String, String> files) {
        return files.keySet().stream()
                .filter(p -> p.contains("/"))
                .map(p -> p.substring(0, p.indexOf('/')))
                .distinct().sorted().collect(Collectors.toList());
    }

    private static Map<String, String> underDirectory(Map<String, String> files, String dir) {
        Map<String, String> result = new TreeMap<>();
        files.forEach((path, content) -> {
            if (path.startsWith(dir + "/")) {
                result.put(path.substring(dir.length() + 1), content);
            }
        });
        return result;
    }
}
