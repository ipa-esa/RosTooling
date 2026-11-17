package de.fraunhofer.ipa.ros.plugin.spi;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.eclipse.emf.ecore.util.EcoreUtil;
import ros.Extensible;
import ros.ExtensionBlock;
import ros.ExtensionEntry;
import ros.ExtensionListValue;
import ros.ExtensionValue;
import ros.RosFactory;

/**
 * Merges {@link ExtensionBlock} declarations from a type-level element (e.g. {@link ros.Node},
 * {@link ros.Plugin}) and a system instance-level element (e.g. {@code RosNode},
 * {@code RosInterface}) according to {@link BlockDescriptor#fieldMergeRules()}.
 */
public final class ExtensionBlockMerger {

    public record MergeResult(ExtensionBlock mergedBlock, List<String> conflictErrors) {
    }

    private ExtensionBlockMerger() {
    }

    public static ExtensionBlock findBlock(final Extensible holder, final String blockName) {
        if (holder == null || blockName == null) {
            return null;
        }
        for (ExtensionBlock block : holder.getExtensions()) {
            if (blockName.equals(block.getName())) {
                return block;
            }
        }
        return null;
    }

    public static ExtensionBlock merge(
            final Extensible typeElement,
            final Extensible instanceElement,
            final String blockName,
            final BlockDescriptor descriptor) {
        return mergeWithConflicts(typeElement, instanceElement, blockName, descriptor).mergedBlock();
    }

    public static MergeResult mergeWithConflicts(
            final Extensible typeElement,
            final Extensible instanceElement,
            final String blockName,
            final BlockDescriptor descriptor) {
        ExtensionBlock typeBlock = findBlock(typeElement, blockName);
        ExtensionBlock instanceBlock = findBlock(instanceElement, blockName);
        if (typeBlock == null && instanceBlock == null) {
            return new MergeResult(null, List.of());
        }
        if (typeBlock == null) {
            return new MergeResult(EcoreUtil.copy(instanceBlock), List.of());
        }
        if (instanceBlock == null) {
            return new MergeResult(EcoreUtil.copy(typeBlock), List.of());
        }

        ExtensionBlock merged = RosFactory.eINSTANCE.createExtensionBlock();
        merged.setName(blockName);
        List<String> conflicts = new ArrayList<>();

        Map<String, ExtensionEntry> typeEntries = new LinkedHashMap<>();
        for (ExtensionEntry entry : typeBlock.getEntries()) {
            typeEntries.put(entry.getKey(), entry);
        }
        Map<String, ExtensionEntry> instanceEntries = new LinkedHashMap<>();
        for (ExtensionEntry entry : instanceBlock.getEntries()) {
            instanceEntries.put(entry.getKey(), entry);
        }

        Map<String, MergeStrategy> rules = descriptor != null ? descriptor.fieldMergeRules() : Map.of();
        for (Map.Entry<String, ExtensionEntry> e : typeEntries.entrySet()) {
            String key = e.getKey();
            ExtensionEntry typeEntry = e.getValue();
            ExtensionEntry instEntry = instanceEntries.remove(key);
            if (instEntry == null) {
                merged.getEntries().add(EcoreUtil.copy(typeEntry));
                continue;
            }
            MergeStrategy strategy = rules.getOrDefault(key, MergeStrategy.INSTANCE_OVERRIDES_TYPE);
            merged.getEntries().add(mergeField(blockName, key, typeEntry, instEntry, strategy, conflicts));
        }

        for (ExtensionEntry remainingInst : instanceEntries.values()) {
            merged.getEntries().add(EcoreUtil.copy(remainingInst));
        }

        return new MergeResult(merged, conflicts);
    }

    private static ExtensionEntry mergeField(
            final String blockName,
            final String key,
            final ExtensionEntry typeEntry,
            final ExtensionEntry instEntry,
            final MergeStrategy strategy,
            final List<String> conflicts) {
        switch (strategy) {
            case TYPE_WINS:
                return EcoreUtil.copy(typeEntry);
            case ERROR_ON_CONFLICT:
                if (!EcoreUtil.equals(typeEntry.getValue(), instEntry.getValue())) {
                    conflicts.add("Conflicting values for '@" + blockName + "." + key
                            + "' between type declaration and system instance");
                }
                return EcoreUtil.copy(instEntry);
            case APPEND_LIST:
                if (typeEntry.getValue() instanceof ExtensionListValue typeList
                        && instEntry.getValue() instanceof ExtensionListValue instList) {
                    ExtensionEntry combined = RosFactory.eINSTANCE.createExtensionEntry();
                    combined.setKey(key);
                    ExtensionListValue listVal = RosFactory.eINSTANCE.createExtensionListValue();
                    for (ExtensionValue item : typeList.getItems()) {
                        listVal.getItems().add(EcoreUtil.copy(item));
                    }
                    for (ExtensionValue item : instList.getItems()) {
                        listVal.getItems().add(EcoreUtil.copy(item));
                    }
                    combined.setValue(listVal);
                    return combined;
                }
                return EcoreUtil.copy(instEntry);
            case UNION_SET:
                if (typeEntry.getValue() instanceof ExtensionListValue typeList
                        && instEntry.getValue() instanceof ExtensionListValue instList) {
                    ExtensionEntry union = RosFactory.eINSTANCE.createExtensionEntry();
                    union.setKey(key);
                    ExtensionListValue listVal = RosFactory.eINSTANCE.createExtensionListValue();
                    for (ExtensionValue item : typeList.getItems()) {
                        if (!containsStructurally(listVal.getItems(), item)) {
                            listVal.getItems().add(EcoreUtil.copy(item));
                        }
                    }
                    for (ExtensionValue item : instList.getItems()) {
                        if (!containsStructurally(listVal.getItems(), item)) {
                            listVal.getItems().add(EcoreUtil.copy(item));
                        }
                    }
                    union.setValue(listVal);
                    return union;
                }
                return EcoreUtil.copy(instEntry);
            case INSTANCE_OVERRIDES_TYPE:
            default:
                return EcoreUtil.copy(instEntry);
        }
    }

    private static boolean containsStructurally(final List<ExtensionValue> items, final ExtensionValue candidate) {
        for (ExtensionValue existing : items) {
            if (EcoreUtil.equals(existing, candidate)) {
                return true;
            }
        }
        return false;
    }
}
