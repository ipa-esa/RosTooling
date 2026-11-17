package de.fraunhofer.ipa.ros.plugin.spi;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

/**
 * Execution context passed to {@link PluginToolDescriptor.ToolHandler#execute(ToolExecutionContext)}.
 */
public final class ToolExecutionContext {

    private final Resource resource;
    private final String modelPath;
    private final String modelText;
    private final Map<String, Object> arguments;

    public ToolExecutionContext(
            final Resource resource,
            final String modelPath,
            final String modelText,
            final Map<String, Object> arguments) {
        this.resource = resource;
        this.modelPath = modelPath;
        this.modelText = modelText;
        this.arguments = arguments == null
                ? Map.of()
                : Collections.unmodifiableMap(new LinkedHashMap<>(arguments));
    }

    public Resource resource() {
        return resource;
    }

    public ResourceSet resourceSet() {
        return resource != null ? resource.getResourceSet() : null;
    }

    public String modelPath() {
        return modelPath;
    }

    public String modelText() {
        return modelText;
    }

    public Map<String, Object> arguments() {
        return arguments;
    }

    public String argString(final String key) {
        Object val = arguments.get(key);
        return val == null ? null : String.valueOf(val);
    }

    public Object arg(final String key) {
        return arguments.get(key);
    }
}
