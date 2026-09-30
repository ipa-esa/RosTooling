package de.fraunhofer.ipa.ros.tests

import com.google.inject.Inject
import java.nio.file.Files
import java.nio.file.Paths
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.util.ParseHelper
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import ros.AmentPackage

import org.eclipse.xtext.testing.validation.ValidationTestHelper
import de.fraunhofer.ipa.ros2.validation.Ros2Validator
import ros.LifecycleState
import ros.RosPackage

@RunWith(XtextRunner)
@InjectWith(Ros2InjectorProvider)
class Ros2ParsingTest {
    @Inject
    ParseHelper<AmentPackage> parseHelper

    @Inject
    ValidationTestHelper validationTester

    String RESOURCES_BASE_DIR = 'resources/rosnodes'

    @Test
    def void loadModel() {
        val fileContent = new String(Files.readAllBytes(Paths.get(RESOURCES_BASE_DIR, 'test.ros2')))
        val result = parseHelper.parse(fileContent)
        Assert.assertNotNull(result)
        val errors = result.eResource.errors
        Assert.assertTrue('''Unexpected errors: «errors.join(", ")»''', errors.isEmpty)
    }

    @Test
    def void parseDomainmodel() {
        val fileContent = new String(Files.readAllBytes(Paths.get(RESOURCES_BASE_DIR, 'test.ros2')))
        val model = parseHelper.parse(fileContent)

        val artifacts = model.artifact
        Assert.assertEquals("image_filter", model.artifact.get(0).name)
        Assert.assertEquals("consumer", model.artifact.get(1).name)

        //From artifact image_filter
        val node_name = artifacts.get(0).node.name
        Assert.assertEquals("image_filter", node_name)
        val publishers = artifacts.get(0).node.publisher
        Assert.assertEquals("image_out", publishers.get(0).name)
        Assert.assertEquals("description_out", publishers.get(1).name)
    }

    @Test
    def void loadLifecycleModel() {
        val fileContent = new String(Files.readAllBytes(Paths.get(RESOURCES_BASE_DIR, 'lifecycle_test.ros2')))
        val model = parseHelper.parse(fileContent)
        Assert.assertNotNull(model)
        val errors = model.eResource.errors
        Assert.assertTrue('''Unexpected errors: «errors.join(", ")»''', errors.isEmpty)

        val node = model.artifact.get(0).node
        Assert.assertTrue(node.isIsLifecycle)
        Assert.assertEquals(2, node.publisher.size)

        val pub1 = node.publisher.get(0)
        Assert.assertEquals("image_out", pub1.name)
        Assert.assertEquals(1, pub1.activeStates.size)
        Assert.assertTrue(pub1.activeStates.contains(LifecycleState.ACTIVE))

        val pub2 = node.publisher.get(1)
        Assert.assertEquals("status_out", pub2.name)
        Assert.assertEquals(2, pub2.activeStates.size)
        Assert.assertTrue(pub2.activeStates.contains(LifecycleState.ACTIVE))
        Assert.assertTrue(pub2.activeStates.contains(LifecycleState.INACTIVE))
        val issues = validationTester.validate(model)
        val lifecycleIssues = issues.filter[
            code == Ros2Validator.ACTIVE_IN_NON_LIFECYCLE || code == Ros2Validator.DUPLICATE_LIFECYCLE_STATE
        ]
        Assert.assertTrue('''Unexpected lifecycle issues: «lifecycleIssues.join(", ")»''', lifecycleIssues.isEmpty)
    }

    @Test
    def void testActiveInOnNonLifecycleNodeValidation() {
        val modelStr = '''
            test_pkg:
              artifacts:
                art:
                  node: my_node
                  publishers:
                    pub:
                      type: "std_msgs/msg/String"
                      active_in: [Active]
        '''
        val model = parseHelper.parse(modelStr)
        Assert.assertNotNull(model)
        validationTester.assertError(model, RosPackage.Literals.INTERFACE_TYPE, Ros2Validator.ACTIVE_IN_NON_LIFECYCLE)
    }

    @Test
    def void testDuplicateActiveStateWarning() {
        val modelStr = '''
            test_pkg:
              artifacts:
                art:
                  node: my_node
                  lifecycle: true
                  publishers:
                    pub:
                      type: "std_msgs/msg/String"
                      active_in: [Active, Active]
        '''
        val model = parseHelper.parse(modelStr)
        Assert.assertNotNull(model)
        validationTester.assertWarning(model, RosPackage.Literals.INTERFACE_TYPE, Ros2Validator.DUPLICATE_LIFECYCLE_STATE)
    }

}
