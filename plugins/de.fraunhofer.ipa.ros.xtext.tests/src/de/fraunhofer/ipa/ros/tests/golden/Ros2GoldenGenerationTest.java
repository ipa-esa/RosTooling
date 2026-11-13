package de.fraunhofer.ipa.ros.tests.golden;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.generator.InMemoryFileSystemAccess;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.junit.Test;

import com.google.inject.Injector;

import de.fraunhofer.ipa.ros.RosStandaloneSetup;
import de.fraunhofer.ipa.ros.tests.Ros2InjectorProvider;
import de.fraunhofer.ipa.ros2.distro.Ros2Distros;
import de.fraunhofer.ipa.ros2.generator.Ros2Generator;

/**
 * Expected-output ("golden") tests for the .ros2 wrapper generator.
 *
 * <p>For every supported ROS 2 distribution and every language the fixture package
 * {@code resources/golden/models/golden_pkg.ros2} is generated and compared byte for byte
 * with {@code resources/golden/expected/ros2/<distro>/<language>/}. The stored trees are
 * complete colcon packages: {@code tools/distro-matrix/build-golden.sh} builds them inside
 * the official {@code ros:<distro>} images, so the expectations are known to compile.
 *
 * <p>To accept intended template changes, run the tests with the environment variable
 * {@code ROSTOOLING_UPDATE_GOLDEN=1} and review the resulting diff before committing it.
 */
public class Ros2GoldenGenerationTest {

    private static final Path MODELS = Paths.get("resources", "golden", "models");
    private static final Path MESSAGES = Paths.get("resources", "basic_msgs");
    private static final Path EXPECTED = Paths.get("resources", "golden", "expected", "ros2");
    private static final String PACKAGE_MODEL = "golden_pkg.ros2";
    private static final List<String> LANGUAGES = List.of("cpp", "python");

    static List<String> distros() {
        return Ros2Distros.names();
    }

    @Test
    public void generatedPackagesMatchExpectedOutput() throws IOException {
        Injector injector = new Ros2InjectorProvider().getInjector();
        new RosStandaloneSetup().createInjectorAndDoEMFRegistration();
        Ros2Generator generator = injector.getInstance(Ros2Generator.class);

        List<String> mismatches = new ArrayList<>();
        for (String distro : distros()) {
            for (String language : LANGUAGES) {
                Resource model = loadFixture(injector);
                InMemoryFileSystemAccess fsa = new InMemoryFileSystemAccess();
                generator.generateTargeted(model, fsa, null, language, distro, List.of());
                Map<String, String> actual = GoldenFiles.textFiles(fsa);
                Path expectedRoot = EXPECTED.resolve(distro).resolve(language);
                if (GoldenFiles.updateRequested()) {
                    GoldenFiles.write(expectedRoot, actual);
                } else {
                    GoldenFiles.compare(expectedRoot, actual, distro + "/" + language, mismatches);
                }
            }
        }
        if (!mismatches.isEmpty()) {
            fail("Generated output differs from " + EXPECTED + " (" + mismatches.size() + " file(s)).\n"
                    + "If the change is intended, rerun with ROSTOOLING_UPDATE_GOLDEN=1 and review the diff.\n  "
                    + String.join("\n  ", mismatches));
        }
    }

    private Resource loadFixture(Injector injector) throws IOException {
        XtextResourceSet resourceSet = injector.getInstance(XtextResourceSet.class);
        for (Path spec : GoldenFiles.listFiles(MESSAGES, ".ros")) {
            resourceSet.getResource(URI.createFileURI(spec.toAbsolutePath().toString()), true);
        }
        for (Path spec : GoldenFiles.listFiles(MODELS, ".ros")) {
            resourceSet.getResource(URI.createFileURI(spec.toAbsolutePath().toString()), true);
        }
        Resource model = resourceSet.getResource(
                URI.createFileURI(MODELS.resolve(PACKAGE_MODEL).toAbsolutePath().toString()), true);
        EcoreUtil.resolveAll(resourceSet);

        IResourceValidator validator = injector.getInstance(IResourceValidator.class);
        List<Issue> errors = validator.validate(model, CheckMode.ALL, CancelIndicator.NullImpl).stream()
                .filter(issue -> issue.getSeverity() == Severity.ERROR)
                .collect(Collectors.toList());
        assertTrue("Fixture " + PACKAGE_MODEL + " has errors: " + errors, errors.isEmpty());
        return model;
    }
}
