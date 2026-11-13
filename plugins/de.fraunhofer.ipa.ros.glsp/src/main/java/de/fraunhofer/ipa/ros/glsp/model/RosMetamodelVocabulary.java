package de.fraunhofer.ipa.ros.glsp.model;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.EcoreUtil2;
import primitives.AbstractType;
import primitives.PrimitivesPackage;
import ros.InterfaceType;
import ros.LifecycleState;
import ros.Namespace;
import ros.Parameter;
import ros.ParameterType;
import ros.RosPackage;

/**
 * The value sets the editors offer (lifecycle states, parameter types, message field types,
 * namespace kinds, interface kinds, QoS keywords), derived from the Ecore metamodel - the ground
 * truth - and spelled the way the grammar writes them. QoS values are plain {@code EString}s in
 * Ecore, so their allowed alternatives come from the Ros2 grammar's {@code QualityOfService} rule.
 * Every set is filtered to what the server can actually create, so clients never offer a value the
 * operation handlers would reject. Sent to clients as GGraph root argument {@code metamodelJson}.
 */
public final class RosMetamodelVocabulary {

    private static volatile String cachedJson;

    private RosMetamodelVocabulary() {}

    public static String json() {
        String json = cachedJson;
        if (json == null) {
            synchronized (RosMetamodelVocabulary.class) {
                if (cachedJson == null) {
                    cachedJson = new Gson().toJson(build());
                }
                json = cachedJson;
            }
        }
        return json;
    }

    static JsonObject build() {
        JsonObject out = new JsonObject();

        JsonArray lifecycle = new JsonArray();
        for (LifecycleState st : LifecycleState.VALUES) {
            lifecycle.add(st.getLiteral());
        }
        out.add("lifecycleStates", lifecycle);

        JsonArray paramTypes = new JsonArray();
        for (EClass ec : concreteSubclasses(RosPackage.eINSTANCE, RosPackage.Literals.PARAMETER_TYPE)) {
            String keyword = RosDslText.parameterTypeKeyword((ParameterType) EcoreUtil.create(ec));
            if (!keyword.isEmpty() && RosDslText.createParameterType(keyword, null) != null) {
                paramTypes.add(keyword);
            }
        }
        out.add("parameterTypes", paramTypes);

        JsonArray fieldTypes = new JsonArray();
        for (EClass ec : concreteSubclasses(PrimitivesPackage.eINSTANCE, PrimitivesPackage.Literals.ABSTRACT_TYPE)) {
            String text = RosDslText.messagePartTypeText(null, (AbstractType) EcoreUtil.create(ec));
            if (!text.isEmpty() && !text.contains("'")) {
                fieldTypes.add(text);
            }
        }
        out.add("messageFieldTypes", fieldTypes);

        JsonArray nsKinds = new JsonArray();
        for (EClass ec : concreteSubclasses(RosPackage.eINSTANCE, RosPackage.Literals.NAMESPACE)) {
            String kind = RosDslText.renderNamespace((Namespace) EcoreUtil.create(ec));
            if (RosDslText.createNamespace(kind, null) != null) {
                nsKinds.add(kind);
            }
        }
        out.add("namespaceKinds", nsKinds);

        JsonArray ifaceKinds = new JsonArray();
        for (EClass ec : concreteSubclasses(RosPackage.eINSTANCE, RosPackage.Literals.INTERFACE_TYPE)) {
            EObject probe = EcoreUtil.create(ec);
            if (!(probe instanceof Parameter)) {
                String code = RosDslText.kindCode(probe);
                if (!code.isEmpty() && RosDslText.createInterface(code) != null) {
                    ifaceKinds.add(code);
                }
            }
        }
        out.add("interfaceKinds", ifaceKinds);

        out.add("qos", qosKeywords());
        return out;
    }

    private static Set<EClass> concreteSubclasses(final EPackage pkg, final EClass base) {
        Set<EClass> result = new LinkedHashSet<>();
        for (EClassifier c : pkg.getEClassifiers()) {
            if (c instanceof EClass ec && !ec.isAbstract() && !ec.isInterface() && base.isSuperTypeOf(ec) && ec != base) {
                result.add(ec);
            }
        }
        return result;
    }

    /**
     * QoS keys from the Ros2 grammar's QualityOfService rule with their keyword alternatives and
     * whether free text is allowed, e.g. {@code "reliability": {"values": ["best_effort",
     * "reliable"], "freeText": false}}, {@code "deadline": {"values": ["infinite"], "freeText": true}}.
     */
    private static JsonObject qosKeywords() {
        JsonObject qos = new JsonObject();
        try {
            RosXtextModelStorage.ensureXtextInitialized();
            IResourceServiceProvider rsp = IResourceServiceProvider.Registry.INSTANCE
                    .getResourceServiceProvider(URI.createURI("vocabulary.ros2"));
            Grammar grammar = rsp == null ? null : rsp.get(IGrammarAccess.class).getGrammar();
            ParserRule rule = grammar == null ? null
                    : (ParserRule) GrammarUtil.findRuleForName(grammar, "QualityOfService");
            if (rule == null) {
                return qos;
            }
            for (Assignment assignment : EcoreUtil2.getAllContentsOfType(rule.getAlternatives(), Assignment.class)) {
                Keyword keyLabel = precedingKeyword(assignment);
                if (keyLabel == null) {
                    continue;
                }
                String key = keyLabel.getValue().replace(":", "").trim();
                JsonArray values = new JsonArray();
                List<Keyword> keywords = EcoreUtil2.getAllContentsOfType(assignment.getTerminal(), Keyword.class);
                if (assignment.getTerminal() instanceof Keyword k) {
                    keywords = List.of(k);
                }
                for (Keyword k : keywords) {
                    values.add(k.getValue());
                }
                // A rule call (EString, Integer0, ...) in the terminal means free text is allowed.
                boolean freeText = !(assignment.getTerminal() instanceof Keyword)
                        && !EcoreUtil2.getAllContentsOfType(assignment.getTerminal(), org.eclipse.xtext.RuleCall.class).isEmpty()
                        || assignment.getTerminal() instanceof org.eclipse.xtext.RuleCall;
                JsonObject field = new JsonObject();
                field.add("values", values);
                field.addProperty("freeText", freeText);
                qos.add(key, field);
            }
        } catch (RuntimeException e) {
            // Vocabulary is a convenience for editors; never fail model loading because of it.
        }
        return qos;
    }

    private static Keyword precedingKeyword(final Assignment assignment) {
        EObject container = assignment.eContainer();
        if (container instanceof org.eclipse.xtext.Group group) {
            int idx = group.getElements().indexOf(assignment);
            for (int i = idx - 1; i >= 0; i--) {
                AbstractElement el = group.getElements().get(i);
                if (el instanceof Keyword k) {
                    return k;
                }
            }
        }
        return null;
    }
}
