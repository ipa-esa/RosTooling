package de.fraunhofer.ipa.ros.plugin.spi;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * Editing hints for a block schema, kept as Ecore annotations with source {@value #SOURCE} on the
 * block's classes and features, so the block's EPackage stays its only schema. Core uses them for
 * content assist, hover, the GUI and the MCP tools. Hints never change what validates: a value
 * outside {@value #CHOICES} is still accepted if the schema type accepts it.
 *
 * <p>In an {@code .ecore} file:
 *
 * <pre>{@code
 * <eStructuralFeatures xsi:type="ecore:EAttribute" name="mode" eType="ecore:EDataType ...EString">
 *   <eAnnotations source="https://rostooling.ipa.fraunhofer.de/schema-hints">
 *     <details key="label" value="Mode"/>
 *     <details key="help" value="How the probe runs."/>
 *     <details key="order" value="1"/>
 *     <details key="choices" value="once, always"/>
 *   </eAnnotations>
 * </eStructuralFeatures>
 * }</pre>
 */
public final class SchemaHints {

    /** Annotation source of the hints. */
    public static final String SOURCE = "https://rostooling.ipa.fraunhofer.de/schema-hints";
    /** Short display name of a class or feature. */
    public static final String LABEL = "label";
    /** One or two sentences of help text. */
    public static final String HELP = "help";
    /** Integer position of a feature among its class's features; lower comes first. */
    public static final String ORDER = "order";
    /** Comma-separated values offered for a feature. */
    public static final String CHOICES = "choices";

    private static final String GENMODEL_SOURCE = "http://www.eclipse.org/emf/2002/GenModel";

    private SchemaHints() {
    }

    /** The hint {@code key} of {@code element}, or {@code null}. */
    public static String get(final EModelElement element, final String key) {
        if (element == null) {
            return null;
        }
        String value = EcoreUtil.getAnnotation(element, SOURCE, key);
        return value == null || value.isBlank() ? null : value.trim();
    }

    /** Sets the hint {@code key} of {@code element}, for plugins that build their schema in code. */
    public static void set(final EModelElement element, final String key, final String value) {
        EcoreUtil.setAnnotation(element, SOURCE, key, value);
    }

    /** The label hint, or the element's name. */
    public static String label(final ENamedElement element) {
        String label = get(element, LABEL);
        return label != null ? label : element == null ? "" : element.getName();
    }

    /** The help hint, or the GenModel documentation, or an empty string. */
    public static String help(final EModelElement element) {
        String help = get(element, HELP);
        if (help != null) {
            return help;
        }
        EAnnotation genModel = element == null ? null : element.getEAnnotation(GENMODEL_SOURCE);
        String doc = genModel == null ? null : genModel.getDetails().get("documentation");
        return doc == null ? "" : doc.trim();
    }

    /** The order hint, or {@link Integer#MAX_VALUE} if missing or not an integer. */
    public static int order(final EStructuralFeature feature) {
        String order = get(feature, ORDER);
        if (order == null) {
            return Integer.MAX_VALUE;
        }
        try {
            return Integer.parseInt(order);
        } catch (NumberFormatException e) {
            return Integer.MAX_VALUE;
        }
    }

    /**
     * The changeable features of {@code eClass} sorted by order hint; features without one keep
     * their declaration order after those with one.
     */
    public static List<EStructuralFeature> orderedFeatures(final EClass eClass) {
        List<EStructuralFeature> features = new ArrayList<>();
        if (eClass == null) {
            return features;
        }
        for (EStructuralFeature feature : eClass.getEAllStructuralFeatures()) {
            if (feature.isChangeable()) {
                features.add(feature);
            }
        }
        features.sort(Comparator.comparingInt(SchemaHints::order));
        return features;
    }

    /** The choices hint, or the literals of an enum-typed attribute, or an empty list. */
    public static List<String> choices(final EStructuralFeature feature) {
        List<String> out = new ArrayList<>();
        String choices = get(feature, CHOICES);
        if (choices != null) {
            for (String choice : choices.split(",")) {
                if (!choice.isBlank()) {
                    out.add(choice.trim());
                }
            }
            return out;
        }
        if (feature instanceof EAttribute attr && attr.getEAttributeType() instanceof EEnum eEnum) {
            for (EEnumLiteral literal : eEnum.getELiterals()) {
                out.add(literal.getLiteral());
            }
        }
        return out;
    }
}
