package de.fraunhofer.ipa.ros.plugin.spi;

/**
 * Conflict resolution and type-over-instance merge strategies for extension block fields and build entries.
 */
public enum MergeStrategy {
    /** Instance value replaces type value (default for scalar fields). */
    INSTANCE_OVERRIDES_TYPE,
    /** Type value wins over instance value. */
    TYPE_WINS,
    /** Deduplicated union of items (default for lists/sets in merged blocks). */
    UNION_SET,
    /** Append entries in order. */
    APPEND_LIST,
    /** Reject conflicting values with a validation/build error naming both contributors. */
    ERROR_ON_CONFLICT
}
