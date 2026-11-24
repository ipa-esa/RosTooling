package de.fraunhofer.ipa.ros.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
import org.junit.Before;
import org.junit.Test;

import com.google.inject.Injector;

import de.fraunhofer.ipa.ros.RosStandaloneSetup;
import primitives.AbstractType;
import primitives.MessagePart;
import primitives.SizedArray;
import primitives.int32Array;
import ros.ArrayTopicSpecMsgRef;
import ros.PackageSet;
import ros.TopicSpec;
import ros.TopicSpecMsgRef;

/**
 * "T[N]" and "T[<=N]" in a message field type, for every kind of element type. The lexer reads
 * "int32[]" and "[]" as keywords, and every digit as DIGIT or DECINT before INT, so these tests
 * pin down that sizes and the element types still parse and that the unbounded forms are untouched.
 */
public class SizedArrayTest {

    private static final String MODEL = """
            demo_msgs:
              msgs:
                Base
                  message
                    int32 x
                Fields
                  message
                    float64[9] covariance
                    int32[<=5] ids
                    string[3] names
                    bool[2] flags
                    byte[<=16] raw
                    char[4] letters
                    time[2] stamps
                    duration[<=3] spans
                    Header[2] headers
                    'demo_msgs/msg/Base'[3] triple
                    'demo_msgs/msg/Base'[<=10] some
                    uint8[100] big
                    int16[1] single
                    int32[] unbounded
                    'demo_msgs/msg/Base'[] list
                    int32 plain
            """;

    private Injector injector;

    @Before
    public void setUp() {
        injector = new RosStandaloneSetup().createInjectorAndDoEMFRegistration();
    }

    private Resource load(final String text) throws Exception {
        XtextResourceSet rs = injector.getInstance(XtextResourceSet.class);
        Resource res = rs.createResource(URI.createURI("inmemory:/demo.ros"));
        res.load(new ByteArrayInputStream(text.getBytes(StandardCharsets.UTF_8)), null);
        EcoreUtil.resolveAll(rs);
        return res;
    }

    private static List<MessagePart> parts(final Resource res) {
        PackageSet set = (PackageSet) res.getContents().get(0);
        TopicSpec fields = (TopicSpec) set.getPackage().get(0).getSpec().get(1);
        return new ArrayList<>(fields.getMessage().getMessagePart());
    }

    private static SizedArray sized(final MessagePart part) {
        assertTrue(part.getData() + " should be a sized array, was " + part.getType(),
                part.getType() instanceof SizedArray);
        return (SizedArray) part.getType();
    }

    @Test
    public void everyFieldParsesWithoutErrors() throws Exception {
        Resource res = load(MODEL);
        assertTrue(res.getErrors().toString(), res.getErrors().isEmpty());
        assertEquals(16, parts(res).size());
    }

    @Test
    public void fixedSizeKeepsSizeAndElementType() throws Exception {
        List<MessagePart> parts = parts(load(MODEL));
        SizedArray covariance = sized(parts.get(0));
        assertEquals("covariance", parts.get(0).getData());
        assertEquals(9, covariance.getSize());
        assertFalse(covariance.isBounded());
        assertTrue(covariance.getElement() instanceof primitives.float64);

        assertEquals(100, sized(parts.get(11)).getSize());
        assertEquals(1, sized(parts.get(12)).getSize());
    }

    @Test
    public void boundedSetsTheFlag() throws Exception {
        List<MessagePart> parts = parts(load(MODEL));
        SizedArray ids = sized(parts.get(1));
        assertEquals(5, ids.getSize());
        assertTrue(ids.isBounded());
        assertTrue(ids.getElement() instanceof primitives.int32);
        assertTrue(sized(parts.get(4)).isBounded());
        assertEquals(16, sized(parts.get(4)).getSize());
    }

    @Test
    public void anyNonArrayTypeCanBeTheElement() throws Exception {
        List<MessagePart> parts = parts(load(MODEL));
        assertTrue(sized(parts.get(2)).getElement() instanceof primitives.string);
        assertTrue(sized(parts.get(3)).getElement() instanceof primitives.bool);
        assertTrue(sized(parts.get(4)).getElement() instanceof primitives.Byte);
        assertTrue(sized(parts.get(5)).getElement() instanceof primitives.char0);
        assertTrue(sized(parts.get(6)).getElement() instanceof primitives.time);
        assertTrue(sized(parts.get(7)).getElement() instanceof primitives.duration);
        assertTrue(sized(parts.get(8)).getElement() instanceof primitives.Header);
        AbstractType ref = sized(parts.get(9)).getElement();
        assertTrue(ref instanceof TopicSpecMsgRef);
        assertEquals("Base", ((TopicSpecMsgRef) ref).getReference().getName());
        assertTrue(sized(parts.get(10)).getElement() instanceof TopicSpecMsgRef);
    }

    @Test
    public void unboundedFormsAreUnchanged() throws Exception {
        List<MessagePart> parts = parts(load(MODEL));
        assertTrue(parts.get(13).getType() instanceof int32Array);
        assertTrue(parts.get(14).getType() instanceof ArrayTopicSpecMsgRef);
        assertTrue(parts.get(15).getType() instanceof primitives.int32);
    }

    @Test
    public void sizeCanBeSeparatedByWhitespace() throws Exception {
        Resource res = load("""
                demo_msgs:
                  msgs:
                    Spaced
                      message
                        float32 [ 4 ] a
                        float32 [ <= 4 ] b
                """);
        assertTrue(res.getErrors().toString(), res.getErrors().isEmpty());
    }

    @Test
    public void nestedArraysAreNotSyntax() throws Exception {
        Resource res = load("""
                demo_msgs:
                  msgs:
                    Nested
                      message
                        int32[3][4] m
                """);
        assertFalse("nested arrays are not valid in ROS interfaces", res.getErrors().isEmpty());
    }

    @Test
    public void sizeNeedsADigit() throws Exception {
        assertFalse(load("""
                demo_msgs:
                  msgs:
                    Bad
                      message
                        int32[x] m
                """).getErrors().isEmpty());
        assertFalse(load("""
                demo_msgs:
                  msgs:
                    Bad
                      message
                        int32[<=] m
                """).getErrors().isEmpty());
    }

    private List<Issue> validate(final Resource res) {
        return injector.getInstance(IResourceValidator.class).validate(res, CheckMode.ALL, CancelIndicator.NullImpl);
    }

    @Test
    public void validSizesHaveNoIssues() throws Exception {
        List<Issue> issues = validate(load(MODEL));
        assertTrue(issues.toString(), issues.isEmpty());
    }

    @Test
    public void sizeZeroAndNegativeSizesAreErrors() throws Exception {
        List<Issue> issues = validate(load("""
                demo_msgs:
                  msgs:
                    Zero
                      message
                        int32[0] none
                        float64[<=0] nothing
                        int8[-1] negative
                """));
        long errors = issues.stream().filter(i -> "invalidArraySize".equals(i.getCode())).count();
        assertEquals(issues.toString(), 3, errors);
    }
}
