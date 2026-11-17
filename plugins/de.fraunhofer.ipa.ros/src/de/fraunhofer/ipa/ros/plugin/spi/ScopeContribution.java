package de.fraunhofer.ipa.ros.plugin.spi;

import java.util.Objects;
import org.eclipse.emf.ecore.EObject;

/**
 * A named target contributed by a plugin to Xtext cross-reference scoping inside extension blocks.
 */
public record ScopeContribution(String name, EObject target) {

    public ScopeContribution {
        Objects.requireNonNull(name, "name");
        Objects.requireNonNull(target, "target");
    }
}
