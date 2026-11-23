package de.fraunhofer.ipa.ros.plugin.spi;

import java.util.Collections;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import org.eclipse.emf.ecore.EClass;

/**
 * Declares an {@code @<name>:} extension block provided by a {@link RosToolingPlugin}.
 */
public final class BlockDescriptor {

    private final String name;
    private final EClass schemaClass;
    private final Set<HookLocation> allowedLocations;
    private final Map<String, MergeStrategy> fieldMergeRules;
    private final String description;

    public BlockDescriptor(
            final String name,
            final EClass schemaClass,
            final Set<HookLocation> allowedLocations) {
        this(name, schemaClass, allowedLocations, Map.of(), "");
    }

    public BlockDescriptor(
            final String name,
            final EClass schemaClass,
            final Set<HookLocation> allowedLocations,
            final Map<String, MergeStrategy> fieldMergeRules,
            final String description) {
        this.name = Objects.requireNonNull(name, "name").trim();
        if (this.name.isEmpty()) {
            throw new IllegalArgumentException("Block name must not be empty");
        }
        this.schemaClass = Objects.requireNonNull(schemaClass, "schemaClass");
        this.allowedLocations = allowedLocations == null || allowedLocations.isEmpty()
                ? Collections.emptySet()
                : Collections.unmodifiableSet(EnumSet.copyOf(allowedLocations));
        this.fieldMergeRules = fieldMergeRules == null
                ? Map.of()
                : Collections.unmodifiableMap(new LinkedHashMap<>(fieldMergeRules));
        this.description = description == null ? "" : description;
    }

    public String name() {
        return name;
    }

    public EClass schemaClass() {
        return schemaClass;
    }

    public Set<HookLocation> allowedLocations() {
        return allowedLocations;
    }

    public Map<String, MergeStrategy> fieldMergeRules() {
        return fieldMergeRules;
    }

    public String description() {
        return description;
    }
}
