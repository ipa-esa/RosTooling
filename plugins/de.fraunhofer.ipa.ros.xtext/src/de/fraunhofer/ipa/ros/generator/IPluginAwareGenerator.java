package de.fraunhofer.ipa.ros.generator;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.generator.IFileSystemAccess2;

/**
 * Shared internal contract implemented by core Xtext generators that execute active
 * {@code RosToolingPlugin} instances in Phase B.
 */
public interface IPluginAwareGenerator {

    class Outcome {
        public final Map<String, String> coreFiles = new LinkedHashMap<>();
        public final Map<String, String> pluginFiles = new LinkedHashMap<>();
        public final Set<String> deletedFiles = new LinkedHashSet<>();
        public final List<String> errors = new ArrayList<>();
        public final List<String> pluginConflictErrors = new ArrayList<>();
    }

    Outcome generateWithPlugins(
            Resource resource,
            IFileSystemAccess2 fsa,
            List<String> targetNodes,
            String languageChoice,
            String targetDistro,
            List<String> existingFiles);
}
