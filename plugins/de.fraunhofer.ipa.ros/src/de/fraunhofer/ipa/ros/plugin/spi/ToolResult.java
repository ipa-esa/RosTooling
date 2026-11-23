package de.fraunhofer.ipa.ros.plugin.spi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Structured outcome returned from a {@link PluginToolDescriptor}.
 * If {@link #updatedText()} is non-null, the LSP/MCP host updates the target model file accordingly.
 */
public final class ToolResult {

    private final boolean success;
    private final String message;
    private final String updatedText;
    private final Map<String, Object> data;
    private final List<String> errors;

    private ToolResult(
            final boolean success,
            final String message,
            final String updatedText,
            final Map<String, Object> data,
            final List<String> errors) {
        this.success = success;
        this.message = message == null ? "" : message;
        this.updatedText = updatedText;
        this.data = data == null ? Map.of() : Collections.unmodifiableMap(new LinkedHashMap<>(data));
        this.errors = errors == null ? List.of() : Collections.unmodifiableList(new ArrayList<>(errors));
    }

    public static ToolResult ok(final String message, final String updatedText, final Map<String, Object> data) {
        return new ToolResult(true, message, updatedText, data, List.of());
    }

    public static ToolResult ok(final String message, final Map<String, Object> data) {
        return new ToolResult(true, message, null, data, List.of());
    }

    public static ToolResult fail(final String errorMessage) {
        return new ToolResult(false, errorMessage, null, Map.of(), List.of(errorMessage));
    }

    public boolean success() {
        return success;
    }

    public String message() {
        return message;
    }

    public String updatedText() {
        return updatedText;
    }

    public Map<String, Object> data() {
        return data;
    }

    public List<String> errors() {
        return errors;
    }
}
