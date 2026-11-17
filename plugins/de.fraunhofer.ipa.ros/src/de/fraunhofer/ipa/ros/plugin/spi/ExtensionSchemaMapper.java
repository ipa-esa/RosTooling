package de.fraunhofer.ipa.ros.plugin.spi;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import ros.ExtensionBlock;
import ros.ExtensionEntry;
import ros.ExtensionListValue;
import ros.ExtensionMapValue;
import ros.ExtensionRefValue;
import ros.ExtensionScalarValue;
import ros.ExtensionValue;
import ros.RosFactory;
import ros.RosPackage;

/**
 * Bidirectional mapper and generic structural validator between untyped AST
 * {@link ExtensionBlock} trees and plugin-supplied {@link EClass} schemas.
 */
public final class ExtensionSchemaMapper {

    private static final Set<String> KNOWN_REF_PREFIXES = Set.of(
            "ac", "sc", "as", "ss", "pub", "sub", "param", "ref");

    /**
     * Schema resolution result for an AST node inside an {@link ExtensionBlock}.
     */
    public record ResolvedSchemaContext(
            ExtensionBlock block,
            PluginRegistry.RegisteredBlock registered,
            EClass containerClass,
            EStructuralFeature feature) {
    }

    private ExtensionSchemaMapper() {
    }

    /**
     * Resolves the schema {@link EClass} and active {@link EStructuralFeature} for an
     * {@link ExtensionBlock}, {@link ExtensionEntry}, or nested value AST element.
     */
    public static ResolvedSchemaContext resolveSchemaContext(final EObject element) {
        if (element == null) {
            return null;
        }
        List<ExtensionEntry> path = new ArrayList<>();
        EObject cursor = element;
        ExtensionBlock rootBlock = null;
        while (cursor != null) {
            if (cursor instanceof ExtensionEntry e) {
                path.add(e);
            } else if (cursor instanceof ExtensionBlock b) {
                rootBlock = b;
                break;
            }
            cursor = cursor.eContainer();
        }
        if (rootBlock == null || rootBlock.getName() == null) {
            return null;
        }
        PluginRegistry.RegisteredBlock registered = PluginRegistry.INSTANCE.resolveBlock(rootBlock.getName());
        if (registered == null || registered.descriptor().schemaClass() == null) {
            return new ResolvedSchemaContext(rootBlock, registered, null, null);
        }
        java.util.Collections.reverse(path);
        EClass currentClass = registered.descriptor().schemaClass();
        EStructuralFeature resolvedFeature = null;
        for (int i = 0; i < path.size(); i++) {
            if (currentClass == null) {
                return new ResolvedSchemaContext(rootBlock, registered, null, null);
            }
            ExtensionEntry step = path.get(i);
            EStructuralFeature feat = step.getKey() != null ? currentClass.getEStructuralFeature(step.getKey()) : null;
            if (feat == null) {
                return new ResolvedSchemaContext(rootBlock, registered, currentClass, null);
            }
            resolvedFeature = feat;
            if (feat instanceof EReference ref && ref.isContainment()) {
                if (i == path.size() - 1) {
                    // Caller might be inside step's ExtensionMapValue looking for child keys
                    if (element instanceof ExtensionMapValue
                            || element.eContainer() instanceof ExtensionMapValue) {
                        currentClass = ref.getEReferenceType();
                    }
                    break;
                }
                if (ref.isMany() && step.getValue() instanceof ExtensionMapValue
                        && i + 1 < path.size()
                        && path.get(i + 1).eContainer() == step.getValue()) {
                    // Keyed map wrapper over named containment items: advance past map key step
                    i++;
                }
                currentClass = ref.getEReferenceType();
                resolvedFeature = null;
            } else {
                break;
            }
        }
        return new ResolvedSchemaContext(rootBlock, registered, currentClass, resolvedFeature);
    }

    /**
     * Returns valid {@code kind->} reference prefixes accepted by a schema {@link EStructuralFeature},
     * or an empty list if the feature is not a non-containment reference.
     */
    public static List<String> expectedRefPrefixes(final EStructuralFeature feature) {
        if (!(feature instanceof EReference ref) || ref.isContainment() || ref.getEReferenceType() == null) {
            return List.of();
        }
        String typeName = ref.getEReferenceType().getName();
        if ("Publisher".equals(typeName) || "RosPublisherReference".equals(typeName)) {
            return List.of("pub->");
        }
        if ("Subscriber".equals(typeName) || "RosSubscriberReference".equals(typeName)) {
            return List.of("sub->");
        }
        if ("ServiceServer".equals(typeName) || "RosServiceServerReference".equals(typeName)) {
            return List.of("ss->");
        }
        if ("ServiceClient".equals(typeName) || "RosServiceClientReference".equals(typeName)) {
            return List.of("sc->");
        }
        if ("ActionServer".equals(typeName) || "RosActionServerReference".equals(typeName)) {
            return List.of("as->");
        }
        if ("ActionClient".equals(typeName) || "RosActionClientReference".equals(typeName)) {
            return List.of("ac->");
        }
        if ("Parameter".equals(typeName) || "RosParameter".equals(typeName)) {
            return List.of("param->");
        }
        return List.of("pub->", "sub->", "ss->", "sc->", "as->", "ac->", "param->");
    }

    /**
     * Describes an {@link EStructuralFeature} type in human-readable form for hover and completion.
     */
    public static String describeFeatureType(final EStructuralFeature feature) {
        if (feature == null) {
            return "any";
        }
        String base;
        if (feature instanceof EAttribute attr) {
            EDataType dt = attr.getEAttributeType();
            if (dt instanceof EEnum eEnum) {
                List<String> lits = new ArrayList<>();
                for (EEnumLiteral lit : eEnum.getELiterals()) {
                    lits.add(lit.getLiteral());
                }
                base = "enum(" + String.join(" | ", lits) + ")";
            } else {
                base = dt != null ? dt.getName() : "string";
            }
        } else if (feature instanceof EReference ref) {
            String target = ref.getEReferenceType() != null ? ref.getEReferenceType().getName() : "Object";
            base = ref.isContainment() ? "object(" + target + ")" : "ref->" + target;
        } else {
            base = "any";
        }
        return feature.isMany() ? "list<" + base + ">" : base;
    }

    /**
     * Validates an {@link ExtensionBlock} against a plugin's {@link BlockDescriptor} and host
     * {@link HookLocation}.
     */
    public static List<ValidationIssue> validateBlock(
            final ExtensionBlock block,
            final BlockDescriptor descriptor,
            final EObject owner) {
        List<ValidationIssue> issues = new ArrayList<>();
        if (block == null || descriptor == null) {
            return issues;
        }
        HookLocation location = HookLocation.fromElement(owner);
        if (!descriptor.allowedLocations().isEmpty()
                && (location == null || !descriptor.allowedLocations().contains(location))) {
            issues.add(new ValidationIssue(
                    ValidationIssue.Severity.ERROR,
                    "Extension block '@" + block.getName() + "' is not allowed on "
                            + (location != null ? location.name() : owner.eClass().getName())
                            + " (allowed: " + descriptor.allowedLocations() + ")",
                    block,
                    RosPackage.Literals.EXTENSION_BLOCK__NAME,
                    "extension.invalid_location"));
        }
        validateEntriesAgainstClass(block.getEntries(), descriptor.schemaClass(), block, "@" + block.getName(), Set.of(), issues);
        return issues;
    }

    private static void validateEntriesAgainstClass(
            final List<ExtensionEntry> entries,
            final EClass schemaClass,
            final EObject containerNode,
            final String pathPrefix,
            final Set<String> preSatisfiedFields,
            final List<ValidationIssue> issues) {
        if (schemaClass == null) {
            return;
        }
        Map<String, Integer> seenCounts = new HashMap<>();
        for (String pre : preSatisfiedFields) {
            seenCounts.put(pre, 1);
        }
        for (ExtensionEntry entry : entries) {
            String key = entry.getKey();
            EStructuralFeature feature = schemaClass.getEStructuralFeature(key);
            if (feature == null) {
                issues.add(new ValidationIssue(
                        ValidationIssue.Severity.ERROR,
                        "Unknown field '" + key + "' in " + pathPrefix + " (allowed: " + allowedFeatureNames(schemaClass) + ")",
                        entry,
                        RosPackage.Literals.EXTENSION_ENTRY__KEY,
                        "extension.unknown_field"));
                continue;
            }
            int count = seenCounts.merge(key, 1, Integer::sum);
            if (!feature.isMany() && count > 1) {
                issues.add(new ValidationIssue(
                        ValidationIssue.Severity.ERROR,
                        "Duplicate single-valued field '" + key + "' in " + pathPrefix,
                        entry,
                        RosPackage.Literals.EXTENSION_ENTRY__KEY,
                        "extension.duplicate_field"));
                continue;
            }
            validateFeatureValue(feature, entry.getValue(), entry, pathPrefix + "." + key, issues);
        }

        for (EStructuralFeature feature : schemaClass.getEAllStructuralFeatures()) {
            if (feature.isRequired() && !seenCounts.containsKey(feature.getName())) {
                issues.add(new ValidationIssue(
                        ValidationIssue.Severity.ERROR,
                        "Missing required field '" + feature.getName() + "' in " + pathPrefix,
                        containerNode,
                        null,
                        "extension.missing_required"));
            }
        }
    }

    private static void validateFeatureValue(
            final EStructuralFeature feature,
            final ExtensionValue value,
            final EObject entryNode,
            final String fieldPath,
            final List<ValidationIssue> issues) {
        if (value == null) {
            issues.add(new ValidationIssue(
                    ValidationIssue.Severity.ERROR,
                    "Missing value for '" + feature.getName() + "' in " + fieldPath,
                    entryNode,
                    RosPackage.Literals.EXTENSION_ENTRY__VALUE,
                    "extension.missing_value"));
            return;
        }

        if (feature.isMany()) {
            if (value instanceof ExtensionListValue listVal) {
                int idx = 0;
                for (ExtensionValue item : listVal.getItems()) {
                    validateSingleValue(feature, item, entryNode, fieldPath + "[" + idx + "]", issues);
                    idx++;
                }
            } else if (value instanceof ExtensionMapValue keyedMap
                    && isNamedContainmentMany(feature)
                    && isKeyedMapOfObjects(keyedMap)) {
                EClass childClass = ((EReference) feature).getEReferenceType();
                Set<String> preSatisfied = Set.of("name");
                for (ExtensionEntry childEntry : keyedMap.getEntries()) {
                    ExtensionMapValue itemMap = (ExtensionMapValue) childEntry.getValue();
                    validateEntriesAgainstClass(
                            itemMap.getEntries(),
                            childClass,
                            itemMap,
                            fieldPath + "." + childEntry.getKey(),
                            preSatisfied,
                            issues);
                }
            } else {
                // Also tolerate single element matching the expected element type (e.g., repeated entries).
                validateSingleValue(feature, value, entryNode, fieldPath, issues);
            }
        } else {
            if (value instanceof ExtensionListValue) {
                issues.add(new ValidationIssue(
                        ValidationIssue.Severity.ERROR,
                        "Field '" + feature.getName() + "' does not accept a list value",
                        value,
                        null,
                        "extension.unexpected_list"));
                return;
            }
            validateSingleValue(feature, value, entryNode, fieldPath, issues);
        }
    }

    private static void validateSingleValue(
            final EStructuralFeature feature,
            final ExtensionValue value,
            final EObject ownerEntry,
            final String fieldPath,
            final List<ValidationIssue> issues) {
        if (feature instanceof EAttribute attr) {
            if (!(value instanceof ExtensionScalarValue scalar)) {
                issues.add(new ValidationIssue(
                        ValidationIssue.Severity.ERROR,
                        "Field '" + feature.getName() + "' expects a scalar value of type " + attr.getEAttributeType().getName(),
                        value != null ? value : ownerEntry,
                        null,
                        "extension.type_mismatch"));
                return;
            }
            validateScalarType(attr.getEAttributeType(), scalar, issues);
        } else if (feature instanceof EReference ref) {
            if (ref.isContainment()) {
                if (!(value instanceof ExtensionMapValue mapVal)) {
                    issues.add(new ValidationIssue(
                            ValidationIssue.Severity.ERROR,
                            "Field '" + feature.getName() + "' expects an object/map of type " + ref.getEReferenceType().getName(),
                            value != null ? value : ownerEntry,
                            null,
                            "extension.expected_map"));
                    return;
                }
                validateEntriesAgainstClass(mapVal.getEntries(), ref.getEReferenceType(), mapVal, fieldPath, Set.of(), issues);
            } else {
                if (!(value instanceof ExtensionRefValue refVal)) {
                    issues.add(new ValidationIssue(
                            ValidationIssue.Severity.ERROR,
                            "Field '" + feature.getName() + "' expects an interface reference (e.g. 'ac->name', 'sc->name', 'sub->name')",
                            value != null ? value : ownerEntry,
                            null,
                            "extension.expected_ref"));
                    return;
                }
                EObject target = refVal.getTarget();
                if (target != null && !target.eIsProxy() && !ref.getEReferenceType().isInstance(target)) {
                    issues.add(new ValidationIssue(
                            ValidationIssue.Severity.ERROR,
                            "Reference target for '" + feature.getName() + "' must be " + ref.getEReferenceType().getName()
                                    + " (found " + target.eClass().getName() + ")",
                            refVal,
                            RosPackage.Literals.EXTENSION_REF_VALUE__TARGET,
                            "extension.invalid_ref_type"));
                }
            }
        }
    }

    private static void validateScalarType(
            final EDataType dataType,
            final ExtensionScalarValue scalar,
            final List<ValidationIssue> issues) {
        String raw = scalar.getValue();
        if (raw == null) {
            return;
        }
        if (dataType instanceof EEnum eEnum) {
            if (findEnumLiteral(eEnum, raw) == null) {
                List<String> allowed = new ArrayList<>();
                for (EEnumLiteral lit : eEnum.getELiterals()) {
                    allowed.add(lit.getLiteral());
                }
                issues.add(new ValidationIssue(
                        ValidationIssue.Severity.ERROR,
                        "Invalid enum value '" + raw + "' for " + eEnum.getName() + " (allowed: " + allowed + ")",
                        scalar,
                        RosPackage.Literals.EXTENSION_SCALAR_VALUE__VALUE,
                        "extension.invalid_enum"));
            }
            return;
        }
        String typeName = dataType.getName();
        Class<?> instanceClass = dataType.getInstanceClass();
        if (instanceClass == boolean.class || instanceClass == Boolean.class || "EBoolean".equals(typeName)) {
            if (!"true".equalsIgnoreCase(raw) && !"false".equalsIgnoreCase(raw)) {
                issues.add(new ValidationIssue(
                        ValidationIssue.Severity.ERROR,
                        "Expected boolean ('true' or 'false'), got '" + raw + "'",
                        scalar,
                        RosPackage.Literals.EXTENSION_SCALAR_VALUE__VALUE,
                        "extension.invalid_boolean"));
            }
        } else if (instanceClass == int.class || instanceClass == Integer.class
                || instanceClass == long.class || instanceClass == Long.class
                || instanceClass == short.class || instanceClass == Short.class) {
            try {
                Long.parseLong(raw);
            } catch (NumberFormatException e) {
                issues.add(new ValidationIssue(
                        ValidationIssue.Severity.ERROR,
                        "Expected integer number, got '" + raw + "'",
                        scalar,
                        RosPackage.Literals.EXTENSION_SCALAR_VALUE__VALUE,
                        "extension.invalid_int"));
            }
        } else if (instanceClass == double.class || instanceClass == Double.class
                || instanceClass == float.class || instanceClass == Float.class) {
            try {
                Double.parseDouble(raw);
            } catch (NumberFormatException e) {
                issues.add(new ValidationIssue(
                        ValidationIssue.Severity.ERROR,
                        "Expected floating-point number, got '" + raw + "'",
                        scalar,
                        RosPackage.Literals.EXTENSION_SCALAR_VALUE__VALUE,
                        "extension.invalid_number"));
            }
        }
    }

    /**
     * Converts an untyped {@link ExtensionBlock} into a typed instance of {@link BlockDescriptor#schemaClass()}.
     */
    public static EObject toTypedObject(final ExtensionBlock block, final BlockDescriptor descriptor) {
        if (block == null || descriptor == null || descriptor.schemaClass() == null) {
            return null;
        }
        return entriesToTypedObject(block.getEntries(), descriptor.schemaClass());
    }

    private static EObject entriesToTypedObject(final List<ExtensionEntry> entries, final EClass eClass) {
        EObject instance = eClass.getEPackage().getEFactoryInstance().create(eClass);
        for (ExtensionEntry entry : entries) {
            EStructuralFeature feature = eClass.getEStructuralFeature(entry.getKey());
            if (feature == null || !feature.isChangeable()) {
                continue;
            }
            ExtensionValue value = entry.getValue();
            if (value == null) {
                continue;
            }
            if (feature.isMany()) {
                @SuppressWarnings("unchecked")
                EList<Object> targetList = (EList<Object>) instance.eGet(feature);
                if (value instanceof ExtensionListValue listVal) {
                    for (ExtensionValue item : listVal.getItems()) {
                        Object converted = convertSingleValue(feature, item);
                        if (converted != null) {
                            targetList.add(converted);
                        }
                    }
                } else if (value instanceof ExtensionMapValue keyedMap
                        && isNamedContainmentMany(feature)
                        && isKeyedMapOfObjects(keyedMap)) {
                    EReference ref = (EReference) feature;
                    EAttribute nameAttr = findNameAttribute(ref.getEReferenceType());
                    for (ExtensionEntry childEntry : keyedMap.getEntries()) {
                        EObject childObj = entriesToTypedObject(
                                ((ExtensionMapValue) childEntry.getValue()).getEntries(),
                                ref.getEReferenceType());
                        if (nameAttr != null && (childObj.eGet(nameAttr) == null || !childObj.eIsSet(nameAttr))) {
                            childObj.eSet(nameAttr, childEntry.getKey());
                        }
                        targetList.add(childObj);
                    }
                } else {
                    Object converted = convertSingleValue(feature, value);
                    if (converted != null) {
                        targetList.add(converted);
                    }
                }
            } else {
                Object converted = convertSingleValue(feature, value);
                if (converted != null) {
                    instance.eSet(feature, converted);
                }
            }
        }
        return instance;
    }

    private static Object convertSingleValue(final EStructuralFeature feature, final ExtensionValue value) {
        if (feature instanceof EAttribute attr) {
            if (!(value instanceof ExtensionScalarValue scalar) || scalar.getValue() == null) {
                return null;
            }
            EDataType dataType = attr.getEAttributeType();
            if (dataType instanceof EEnum eEnum) {
                EEnumLiteral lit = findEnumLiteral(eEnum, scalar.getValue());
                return lit != null ? lit.getInstance() : null;
            }
            try {
                return EcoreUtil.createFromString(dataType, scalar.getValue());
            } catch (RuntimeException e) {
                return null;
            }
        }
        if (feature instanceof EReference ref) {
            if (ref.isContainment()) {
                if (value instanceof ExtensionMapValue mapVal) {
                    return entriesToTypedObject(mapVal.getEntries(), ref.getEReferenceType());
                }
                return null;
            }
            if (value instanceof ExtensionRefValue refVal) {
                EObject target = refVal.getTarget();
                if (target != null && !target.eIsProxy() && ref.getEReferenceType().isInstance(target)) {
                    return target;
                }
            }
        }
        return null;
    }

    /**
     * Converts a plain JSON/Java map into an AST {@link ExtensionBlock}.
     */
    @SuppressWarnings("unchecked")
    public static ExtensionBlock fromMap(
            final String blockName,
            final Map<String, Object> map,
            final BlockDescriptor descriptor,
            final ResourceSet resourceSet) {
        ExtensionBlock block = RosFactory.eINSTANCE.createExtensionBlock();
        block.setName(blockName);
        if (map == null || map.isEmpty()) {
            return block;
        }
        EClass schemaClass = descriptor != null ? descriptor.schemaClass() : null;
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (entry.getValue() == null) {
                continue;
            }
            EStructuralFeature feature = schemaClass != null ? schemaClass.getEStructuralFeature(entry.getKey()) : null;
            ExtensionEntry extEntry = RosFactory.eINSTANCE.createExtensionEntry();
            extEntry.setKey(entry.getKey());
            extEntry.setValue(objectToExtensionValue(entry.getValue(), feature));
            block.getEntries().add(extEntry);
        }
        return block;
    }

    @SuppressWarnings("unchecked")
    private static ExtensionValue objectToExtensionValue(final Object rawValue, final EStructuralFeature feature) {
        if (rawValue instanceof Collection<?> coll) {
            ExtensionListValue listVal = RosFactory.eINSTANCE.createExtensionListValue();
            for (Object item : coll) {
                if (item != null) {
                    listVal.getItems().add(objectToExtensionValue(item, feature));
                }
            }
            return listVal;
        }
        if (rawValue instanceof Map<?, ?> rawMap) {
            if (rawMap.containsKey("refKind") && rawMap.containsKey("rawTarget")) {
                ExtensionRefValue refVal = RosFactory.eINSTANCE.createExtensionRefValue();
                String rk = String.valueOf(rawMap.get("refKind")).trim();
                refVal.setRefKind(rk.endsWith("->") ? rk : rk + "->");
                refVal.setRawTarget(String.valueOf(rawMap.get("rawTarget")));
                return refVal;
            }
            ExtensionMapValue mapVal = RosFactory.eINSTANCE.createExtensionMapValue();
            EClass nestedClass = (feature instanceof EReference ref && ref.isContainment())
                    ? ref.getEReferenceType()
                    : null;
            boolean keyedMapOfNamedItems = isNamedContainmentMany(feature) && allMapValues(rawMap);
            for (Map.Entry<?, ?> e : rawMap.entrySet()) {
                if (e.getValue() == null) {
                    continue;
                }
                String k = String.valueOf(e.getKey());
                ExtensionEntry child = RosFactory.eINSTANCE.createExtensionEntry();
                child.setKey(k);
                if (keyedMapOfNamedItems) {
                    child.setValue(mapToExtensionMap((Map<?, ?>) e.getValue(), nestedClass));
                } else {
                    EStructuralFeature childFeature = nestedClass != null ? nestedClass.getEStructuralFeature(k) : null;
                    child.setValue(objectToExtensionValue(e.getValue(), childFeature));
                }
                mapVal.getEntries().add(child);
            }
            return mapVal;
        }

        if (rawValue instanceof String strVal) {
            boolean expectRef = (feature instanceof EReference ref && !ref.isContainment());
            int arrow = strVal.indexOf("->");
            if (arrow > 0 && arrow < strVal.length() - 2) {
                String prefix = strVal.substring(0, arrow).trim();
                String targetName = strVal.substring(arrow + 2).trim();
                if (expectRef || (feature == null && KNOWN_REF_PREFIXES.contains(prefix))) {
                    ExtensionRefValue refVal = RosFactory.eINSTANCE.createExtensionRefValue();
                    refVal.setRefKind(prefix + "->");
                    refVal.setRawTarget(targetName);
                    return refVal;
                }
            }
        }

        ExtensionScalarValue scalar = RosFactory.eINSTANCE.createExtensionScalarValue();
        scalar.setValue(String.valueOf(rawValue));
        if (rawValue instanceof Boolean) {
            scalar.setRawKind("boolean");
        } else if (rawValue instanceof Integer || rawValue instanceof Long || rawValue instanceof Short) {
            scalar.setRawKind("int");
        } else if (rawValue instanceof Number) {
            scalar.setRawKind("double");
        } else if (feature instanceof EAttribute attr && attr.getEAttributeType() instanceof EEnum) {
            scalar.setRawKind("id");
        } else {
            scalar.setRawKind("string");
        }
        return scalar;
    }

    /**
     * Converts an {@link ExtensionBlock} to a JSON-friendly ordered map.
     */
    public static Map<String, Object> blockToMap(final ExtensionBlock block) {
        Map<String, Object> result = new LinkedHashMap<>();
        if (block == null) {
            return result;
        }
        for (ExtensionEntry entry : block.getEntries()) {
            Object val = extensionValueToObject(entry.getValue());
            Object existing = result.get(entry.getKey());
            if (existing instanceof List<?> existingList) {
                @SuppressWarnings("unchecked")
                List<Object> mutable = (List<Object>) existingList;
                mutable.add(val);
            } else if (existing != null) {
                List<Object> combined = new ArrayList<>();
                combined.add(existing);
                combined.add(val);
                result.put(entry.getKey(), combined);
            } else {
                result.put(entry.getKey(), val);
            }
        }
        return result;
    }

    private static Object extensionValueToObject(final ExtensionValue value) {
        if (value instanceof ExtensionScalarValue scalar) {
            String raw = scalar.getValue();
            if (raw == null) {
                return null;
            }
            String kind = scalar.getRawKind();
            if ("boolean".equals(kind)) {
                return Boolean.parseBoolean(raw);
            }
            if ("int".equals(kind)) {
                try {
                    return Long.parseLong(raw);
                } catch (NumberFormatException ignored) {
                    return raw;
                }
            }
            if ("double".equals(kind)) {
                try {
                    return Double.parseDouble(raw);
                } catch (NumberFormatException ignored) {
                    return raw;
                }
            }
            return raw;
        }
        if (value instanceof ExtensionListValue listVal) {
            List<Object> items = new ArrayList<>();
            for (ExtensionValue item : listVal.getItems()) {
                items.add(extensionValueToObject(item));
            }
            return items;
        }
        if (value instanceof ExtensionMapValue mapVal) {
            Map<String, Object> nested = new LinkedHashMap<>();
            for (ExtensionEntry e : mapVal.getEntries()) {
                nested.put(e.getKey(), extensionValueToObject(e.getValue()));
            }
            return nested;
        }
        if (value instanceof ExtensionRefValue refVal) {
            return formatRefValue(refVal);
        }
        return null;
    }

    /**
     * Generates a JSON-Schema dictionary for a {@link BlockDescriptor}.
     */
    public static Map<String, Object> schemaToJsonMap(final BlockDescriptor descriptor) {
        Map<String, Object> root = new LinkedHashMap<>();
        if (descriptor == null) {
            return root;
        }
        root.put("name", descriptor.name());
        root.put("description", descriptor.description());
        List<String> locations = new ArrayList<>();
        for (HookLocation loc : descriptor.allowedLocations()) {
            locations.add(loc.name());
        }
        root.put("allowedLocations", locations);
        root.put("schema", eClassToJsonSchema(descriptor.schemaClass()));
        return root;
    }

    private static Map<String, Object> eClassToJsonSchema(final EClass eClass) {
        Map<String, Object> schema = new LinkedHashMap<>();
        schema.put("type", "object");
        if (eClass == null) {
            schema.put("properties", Map.of());
            return schema;
        }
        Map<String, Object> properties = new LinkedHashMap<>();
        List<String> required = new ArrayList<>();
        for (EStructuralFeature feature : eClass.getEAllStructuralFeatures()) {
            if (!feature.isChangeable()) {
                continue;
            }
            if (feature.isRequired()) {
                required.add(feature.getName());
            }
            Map<String, Object> itemSchema = singleFeatureSchema(feature);
            if (feature.isMany()) {
                Map<String, Object> arraySchema = new LinkedHashMap<>();
                arraySchema.put("type", "array");
                arraySchema.put("items", itemSchema);
                if (isNamedContainmentMany(feature)) {
                    arraySchema.put("description", "Array of items (or object map keyed by 'name')");
                }
                properties.put(feature.getName(), arraySchema);
            } else {
                properties.put(feature.getName(), itemSchema);
            }
        }
        schema.put("properties", properties);
        if (!required.isEmpty()) {
            schema.put("required", required);
        }
        return schema;
    }

    private static Map<String, Object> singleFeatureSchema(final EStructuralFeature feature) {
        Map<String, Object> prop = new LinkedHashMap<>();
        if (feature instanceof EAttribute attr) {
            EDataType dt = attr.getEAttributeType();
            if (dt instanceof EEnum eEnum) {
                prop.put("type", "string");
                List<String> enumValues = new ArrayList<>();
                for (EEnumLiteral lit : eEnum.getELiterals()) {
                    enumValues.add(lit.getLiteral());
                }
                prop.put("enum", enumValues);
            } else {
                Class<?> cls = dt.getInstanceClass();
                if (cls == boolean.class || cls == Boolean.class || "EBoolean".equals(dt.getName())) {
                    prop.put("type", "boolean");
                } else if (cls == int.class || cls == Integer.class || cls == long.class || cls == Long.class) {
                    prop.put("type", "integer");
                } else if (cls == double.class || cls == Double.class || cls == float.class || cls == Float.class) {
                    prop.put("type", "number");
                } else {
                    prop.put("type", "string");
                }
            }
        } else if (feature instanceof EReference ref) {
            if (ref.isContainment()) {
                return eClassToJsonSchema(ref.getEReferenceType());
            } else {
                prop.put("type", "string");
                prop.put("format", "ros-interface-ref");
                prop.put("targetType", ref.getEReferenceType().getName());
            }
        }
        return prop;
    }

    /**
     * Renders an {@link ExtensionBlock} to canonical RosTooling DSL text.
     */
    public static String renderBlockDsl(final ExtensionBlock block, final String baseIndent) {
        if (block == null) {
            return "";
        }
        String indent = baseIndent != null ? baseIndent : "";
        StringBuilder sb = new StringBuilder();
        sb.append(indent).append("@").append(block.getName()).append(":\n");
        for (ExtensionEntry entry : block.getEntries()) {
            renderEntryDsl(sb, entry, indent + "  ");
        }
        return sb.toString();
    }

    private static void renderEntryDsl(final StringBuilder sb, final ExtensionEntry entry, final String indent) {
        sb.append(indent).append(entry.getKey()).append(": ");
        ExtensionValue val = entry.getValue();
        if (val instanceof ExtensionListValue listVal) {
            sb.append(renderInlineValue(listVal)).append("\n");
        } else if (val instanceof ExtensionMapValue mapVal) {
            if (canRenderBraceMap(mapVal) && mapVal.getEntries().size() <= 3) {
                sb.append(renderBraceMap(mapVal)).append("\n");
            } else {
                sb.append("\n");
                for (ExtensionEntry nested : mapVal.getEntries()) {
                    renderEntryDsl(sb, nested, indent + "  ");
                }
            }
        } else {
            sb.append(renderInlineValue(val)).append("\n");
        }
    }

    private static boolean canRenderBraceMap(final ExtensionMapValue mapVal) {
        for (ExtensionEntry e : mapVal.getEntries()) {
            ExtensionValue v = e.getValue();
            if (v instanceof ExtensionMapValue || v instanceof ExtensionListValue) {
                return false;
            }
        }
        return !mapVal.getEntries().isEmpty();
    }

    private static String renderBraceMap(final ExtensionMapValue mapVal) {
        StringBuilder sb = new StringBuilder("{ ");
        for (int i = 0; i < mapVal.getEntries().size(); i++) {
            if (i > 0) {
                sb.append(", ");
            }
            ExtensionEntry e = mapVal.getEntries().get(i);
            sb.append(e.getKey()).append(": ").append(renderInlineValue(e.getValue()));
        }
        sb.append(" }");
        return sb.toString();
    }

    private static String renderInlineValue(final ExtensionValue val) {
        if (val instanceof ExtensionRefValue refVal) {
            return formatRefValue(refVal);
        }
        if (val instanceof ExtensionScalarValue scalar) {
            String raw = scalar.getValue() != null ? scalar.getValue() : "";
            String kind = scalar.getRawKind();
            if ("boolean".equals(kind) || "int".equals(kind) || "double".equals(kind)) {
                return raw;
            }
            if ("id".equals(kind) && isBareId(raw)) {
                return raw;
            }
            return "\"" + raw.replace("\\", "\\\\").replace("\"", "\\\"") + "\"";
        }
        if (val instanceof ExtensionMapValue mapVal) {
            return renderBraceMap(mapVal);
        }
        if (val instanceof ExtensionListValue listVal) {
            StringBuilder listSb = new StringBuilder("[");
            for (int i = 0; i < listVal.getItems().size(); i++) {
                if (i > 0) {
                    listSb.append(", ");
                }
                listSb.append(renderInlineValue(listVal.getItems().get(i)));
            }
            listSb.append("]");
            return listSb.toString();
        }
        return "\"\"";
    }

    private static String formatRefValue(final ExtensionRefValue refVal) {
        String target = refTargetText(refVal);
        String rk = refVal.getRefKind();
        if (rk == null || rk.isBlank()) {
            return target;
        }
        return (rk.endsWith("->") ? rk : rk + "->") + target;
    }

    private static String refTargetText(final ExtensionRefValue refVal) {
        if (refVal.getTarget() != null && !refVal.getTarget().eIsProxy()) {
            EStructuralFeature nameFeat = refVal.getTarget().eClass().getEStructuralFeature("name");
            if (nameFeat != null) {
                Object name = refVal.getTarget().eGet(nameFeat);
                if (name != null) {
                    return String.valueOf(name);
                }
            }
        }
        return refVal.getRawTarget() != null ? refVal.getRawTarget() : "";
    }

    private static boolean isBareId(final String s) {
        if (s == null || s.isEmpty()) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!(Character.isLetterOrDigit(c) || c == '_')) {
                return false;
            }
        }
        return true;
    }

    private static EEnumLiteral findEnumLiteral(final EEnum eEnum, final String raw) {
        EEnumLiteral byLiteral = eEnum.getEEnumLiteralByLiteral(raw);
        if (byLiteral != null) {
            return byLiteral;
        }
        return eEnum.getEEnumLiteral(raw);
    }

    private static List<String> allowedFeatureNames(final EClass schemaClass) {
        Set<String> names = new LinkedHashSet<>();
        for (EStructuralFeature f : schemaClass.getEAllStructuralFeatures()) {
            if (f.isChangeable()) {
                names.add(f.getName());
            }
        }
        return new ArrayList<>(names);
    }

    private static EAttribute findNameAttribute(final EClass eClass) {
        if (eClass == null) {
            return null;
        }
        EStructuralFeature f = eClass.getEStructuralFeature("name");
        if (f instanceof EAttribute attr && attr.isChangeable() && !attr.isMany()) {
            return attr;
        }
        return null;
    }

    private static boolean isNamedContainmentMany(final EStructuralFeature feature) {
        return feature instanceof EReference ref
                && ref.isMany()
                && ref.isContainment()
                && findNameAttribute(ref.getEReferenceType()) != null;
    }

    private static boolean isKeyedMapOfObjects(final ExtensionMapValue mapVal) {
        if (mapVal == null) {
            return false;
        }
        if (mapVal.getEntries().isEmpty()) {
            return true;
        }
        for (ExtensionEntry entry : mapVal.getEntries()) {
            if (!(entry.getValue() instanceof ExtensionMapValue)) {
                return false;
            }
        }
        return true;
    }

    private static boolean allMapValues(final Map<?, ?> rawMap) {
        for (Object val : rawMap.values()) {
            if (val != null && !(val instanceof Map<?, ?>)) {
                return false;
            }
        }
        return true;
    }

    private static ExtensionMapValue mapToExtensionMap(final Map<?, ?> rawMap, final EClass schemaClass) {
        ExtensionMapValue mapVal = RosFactory.eINSTANCE.createExtensionMapValue();
        for (Map.Entry<?, ?> e : rawMap.entrySet()) {
            if (e.getValue() == null) {
                continue;
            }
            String k = String.valueOf(e.getKey());
            EStructuralFeature childFeature = schemaClass != null ? schemaClass.getEStructuralFeature(k) : null;
            ExtensionEntry child = RosFactory.eINSTANCE.createExtensionEntry();
            child.setKey(k);
            child.setValue(objectToExtensionValue(e.getValue(), childFeature));
            mapVal.getEntries().add(child);
        }
        return mapVal;
    }
}
