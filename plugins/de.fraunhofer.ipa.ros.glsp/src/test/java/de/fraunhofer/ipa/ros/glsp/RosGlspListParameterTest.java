package de.fraunhofer.ipa.ros.glsp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

import de.fraunhofer.ipa.ros.glsp.handlers.EditRosPropertyOperationHandler;
import de.fraunhofer.ipa.ros.glsp.model.RosAstNodeModelSerializer;
import org.junit.jupiter.api.Test;
import ros.ParameterArrayType;
import ros.ParameterIntegerType;
import ros.ParameterSequence;
import ros.ParameterString;
import ros.ParameterStringType;
import ros.ParameterType;
import ros.ParameterValue;
import ros.RosFactory;

/** A list given as text becomes a list value when the parameter is declared as an array. */
class RosGlspListParameterTest {

    private static String write(final String raw, final ParameterType itemType) {
        ParameterArrayType array = RosFactory.eINSTANCE.createParameterArrayType();
        array.setType(itemType);
        ParameterValue value = EditRosPropertyOperationHandler.createTypedParameterValue(raw, null, array);
        return RosAstNodeModelSerializer.formatDslParameterValue(value);
    }

    @Test
    void stringArraysKeepTheirItems() {
        ParameterStringType text = RosFactory.eINSTANCE.createParameterStringType();
        assertEquals("[ \"my_trees/behavior_trees\" ]", write("[\"my_trees/behavior_trees\"]", text));
        assertEquals("[ \"a, b\" , \"c]\" , \"true\" , \"d\" ]", write("[\"a, b\", 'c]', true, d]", text));
        assertEquals("[ \"say \\\"hi\\\"\" ]", write("[\"say \\\"hi\\\"\"]", text));
    }

    @Test
    void itemsFollowTheDeclaredItemType() {
        ParameterIntegerType number = RosFactory.eINSTANCE.createParameterIntegerType();
        assertEquals("[ 1 , 2 ]", write("[1, 2]", number));
        ParameterArrayType inner = RosFactory.eINSTANCE.createParameterArrayType();
        inner.setType(RosFactory.eINSTANCE.createParameterIntegerType());
        assertEquals("[ [ 1 ] , [ 2 , 3 ] ]", write("[[1], [2, 3]]", inner));
    }

    @Test
    void textThatIsNoListStaysAString() {
        for (String raw : new String[] {"plain", "[]", "[a,]", "[a", "[\"a]"}) {
            ParameterArrayType array = RosFactory.eINSTANCE.createParameterArrayType();
            array.setType(RosFactory.eINSTANCE.createParameterStringType());
            assertInstanceOf(ParameterString.class,
                    EditRosPropertyOperationHandler.createTypedParameterValue(raw, null, array), raw);
        }
    }

    @Test
    void bracketsInAStringParameterStayText() {
        assertInstanceOf(ParameterString.class, EditRosPropertyOperationHandler.createTypedParameterValue(
                "[a]", null, RosFactory.eINSTANCE.createParameterStringType()));
        assertInstanceOf(ParameterSequence.class,
                EditRosPropertyOperationHandler.createTypedParameterValue("[a]", "array", null));
    }
}
