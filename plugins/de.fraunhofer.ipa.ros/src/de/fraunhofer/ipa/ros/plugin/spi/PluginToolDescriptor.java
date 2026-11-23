package de.fraunhofer.ipa.ros.plugin.spi;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Describes an MCP/LSP tool contributed by a {@link RosToolingPlugin}.
 */
public final class PluginToolDescriptor {

    @FunctionalInterface
    public interface ToolHandler {
        ToolResult execute(ToolExecutionContext context);
    }

    private final String name;
    private final String description;
    private final Map<String, Object> inputSchema;
    private final ToolHandler handler;

    public PluginToolDescriptor(
            final String name,
            final String description,
            final Map<String, Object> inputSchema,
            final ToolHandler handler) {
        this.name = Objects.requireNonNull(name, "name").trim();
        this.description = Objects.requireNonNull(description, "description");
        this.inputSchema = inputSchema == null
                ? Map.of()
                : Collections.unmodifiableMap(new LinkedHashMap<>(inputSchema));
        this.handler = Objects.requireNonNull(handler, "handler");
    }

    public String name() {
        return name;
    }

    public String description() {
        return description;
    }

    public Map<String, Object> inputSchema() {
        return inputSchema;
    }

    public ToolHandler handler() {
        return handler;
    }
}
