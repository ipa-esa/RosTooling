package de.fraunhofer.ipa.ros.tests.golden;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
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
import org.junit.BeforeClass;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;

import de.fraunhofer.ipa.ros.RosStandaloneSetup;
import de.fraunhofer.ipa.ros.tests.Ros2InjectorProvider;
import de.fraunhofer.ipa.rossystem.RosSystemRuntimeModule;
import de.fraunhofer.ipa.rossystem.RosSystemStandaloneSetup;
import de.fraunhofer.ipa.rossystem.generator.RosSystemGenerator;

/**
 * Regression coverage for string parameter values that contain ROS 2 launch frontend
 * substitutions ({@code $(command ...)}, {@code $(find-pkg-share ...)}, {@code $(var ...)}).
 *
 * <p>Such values must be resolved at launch time: the generator emits them into the launch file
 * through {@code parse_substitution} and keeps them out of the per-node YAML, and the validator only
 * reports an INFO for them.
 */
public class LaunchSubstitutionGenerationTest {

    private static final Path FIXTURES = Paths.get("resources", "substitution");
    private static final Path MESSAGES = Paths.get("resources", "basic_msgs");

    private static final String COMMAND_VALUE =
            "$(command 'xacro $(find-pkg-share some_pkg)/urdf/x.urdf.xacro arg:=$(var arg)')";
    private static final String PATH_VALUE = "$(find-pkg-share some_pkg)/config/x.yaml";

    private static final String COMMAND_EMIT = "\"robot_description\": ParameterValue(parse_substitution(\""
            + COMMAND_VALUE + "\"), value_type=str)";
    private static final String PATH_EMIT = "\"config_file\": ParameterValue(parse_substitution(\""
            + PATH_VALUE + "\"), value_type=str)";

    private static Injector injector;
    private static Resource model;

    @BeforeClass
    public static void loadModel() throws IOException {
        new Ros2InjectorProvider().getInjector();
        new RosStandaloneSetup().createInjectorAndDoEMFRegistration();
        injector = new RosSystemStandaloneSetup() {
            @Override
            public Injector createInjector() {
                // Same Tycho/OSGi class loader workaround as Ros2InjectorProvider.
                return Guice.createInjector(new RosSystemRuntimeModule() {
                    @Override
                    public ClassLoader bindClassLoaderToInstance() {
                        return LaunchSubstitutionGenerationTest.class.getClassLoader();
                    }
                });
            }
        }.createInjectorAndDoEMFRegistration();

        XtextResourceSet resourceSet = injector.getInstance(XtextResourceSet.class);
        for (Path spec : GoldenFiles.listFiles(MESSAGES, ".ros")) {
            resourceSet.getResource(URI.createFileURI(spec.toAbsolutePath().toString()), true);
        }
        for (Path spec : GoldenFiles.listFiles(FIXTURES, ".ros2")) {
            resourceSet.getResource(URI.createFileURI(spec.toAbsolutePath().toString()), true);
        }
        Path fixture = FIXTURES.resolve("subst_system.rossystem");
        model = resourceSet.getResource(URI.createFileURI(fixture.toAbsolutePath().toString()), true);
        EcoreUtil.resolveAll(resourceSet);
        assertTrue("Fixture has syntax errors: " + model.getErrors(), model.getErrors().isEmpty());
    }

    @Test
    public void validatorReportsOnlySubstitutionInfos() {
        List<Issue> issues = injector.getInstance(IResourceValidator.class)
                .validate(model, CheckMode.ALL, CancelIndicator.NullImpl);
        List<Issue> nonInfo = issues.stream()
                .filter(issue -> issue.getSeverity() != Severity.INFO)
                .collect(Collectors.toList());
        assertTrue("Unexpected errors/warnings: " + nonInfo, nonInfo.isEmpty());

        List<Issue> substitutionInfos = issues.stream()
                .filter(issue -> issue.getMessage().contains("uses launch-time substitution"))
                .collect(Collectors.toList());
        // robot_description and config_file on each of the two nodes.
        assertEquals("substitution infos: " + issues, 4, substitutionInfos.size());
        assertEquals("only substitution infos expected: " + issues, substitutionInfos.size(), issues.size());
    }

    @Test
    public void launchFileResolvesSubstitutionsAtLaunchTime() {
        Map<String, String> files = generate();
        String launch = files.get("subst_system/launch/subst_system.launch.py");
        assertNotNull("no launch file in " + files.keySet(), launch);

        assertTrue(launch, launch.contains("from launch.frontend.parse_substitution import parse_substitution"));
        assertTrue(launch, launch.contains("from launch_ros.parameter_descriptions import ParameterValue"));
        // Once for the inline-parameter node and once next to the YAML of the YAML node.
        assertEquals(launch, 2, occurrences(launch, COMMAND_EMIT));
        assertEquals(launch, 2, occurrences(launch, PATH_EMIT));
        assertTrue(launch, launch.contains("parameters = [yaml_node_config, {" + COMMAND_EMIT + ","));
        // The substitution must not leak through a LaunchConfiguration or a DeclareLaunchArgument default.
        assertFalse(launch, launch.contains("LaunchConfiguration(\"robot_description\")"));
        assertFalse(launch, launch.contains("LaunchConfiguration(\"config_file\")"));
        assertFalse(launch, launch.contains("default_value=\"$("));
    }

    @Test
    public void yamlContainsNoSubstitutionValues() {
        Map<String, String> files = generate();
        String yaml = files.get("subst_system/config/yaml_node.yaml");
        assertNotNull("no YAML for yaml_node in " + files.keySet(), yaml);

        assertFalse(yaml, yaml.contains("$("));
        assertFalse(yaml, yaml.contains("robot_description"));
        assertFalse(yaml, yaml.contains("config_file"));
        assertTrue(yaml, yaml.contains("rate_hz: 20.0"));
        assertTrue(yaml, yaml.contains("frame_id: map"));
        // No generated YAML (also the one of the node whose parameters are all inline) carries a substitution.
        files.forEach((path, content) -> {
            if (path.endsWith(".yaml")) {
                assertFalse(path + ":\n" + content, content.contains("$("));
            }
        });
    }

    private static Map<String, String> generate() {
        InMemoryFileSystemAccess fsa = new InMemoryFileSystemAccess();
        injector.getInstance(RosSystemGenerator.class).generateSystemTargeted(model, fsa, List.of());
        return GoldenFiles.textFiles(fsa);
    }

    private static int occurrences(String text, String needle) {
        int count = 0;
        for (int i = text.indexOf(needle); i >= 0; i = text.indexOf(needle, i + needle.length())) {
            count++;
        }
        return count;
    }
}
