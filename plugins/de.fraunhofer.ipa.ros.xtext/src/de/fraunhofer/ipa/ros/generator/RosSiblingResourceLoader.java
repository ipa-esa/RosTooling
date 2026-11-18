package de.fraunhofer.ipa.ros.generator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

/**
 * Loads sibling {@code .ros}, {@code .ros2}, and {@code .rossystem} model files from the directory
 * of a primary model resource into a {@link ResourceSet} when they are not yet present in memory,
 * preserving cross-file references even if background LSP indexing has not yet completed.
 */
public final class RosSiblingResourceLoader {

    private RosSiblingResourceLoader() {
    }

    public static void loadSiblingModelsFromDirectory(
            final ResourceSet rs,
            final URI primaryUri,
            final String fallbackModelPath) {
        if (rs == null) {
            return;
        }
        Path primaryPath = toNormalizedPath(primaryUri);
        if (primaryPath == null && fallbackModelPath != null && !fallbackModelPath.isBlank()) {
            primaryPath = Path.of(fallbackModelPath).toAbsolutePath().normalize();
        }
        if (primaryPath == null) {
            return;
        }
        Path dir = Files.isDirectory(primaryPath) ? primaryPath : primaryPath.getParent();
        if (dir == null || !Files.isDirectory(dir)) {
            return;
        }

        Set<Path> knownPaths = new HashSet<>();
        knownPaths.add(primaryPath);
        for (Resource existing : new ArrayList<>(rs.getResources())) {
            Path p = toNormalizedPath(existing.getURI());
            if (p != null) {
                knownPaths.add(p);
            }
        }

        List<Path> rosFiles = new ArrayList<>();
        List<Path> ros2Files = new ArrayList<>();
        List<Path> sysFiles = new ArrayList<>();
        try (var stream = Files.list(dir)) {
            for (Path entry : stream.toList()) {
                if (!Files.isRegularFile(entry)) {
                    continue;
                }
                Path norm = entry.toAbsolutePath().normalize();
                if (knownPaths.contains(norm)) {
                    continue;
                }
                String name = norm.getFileName().toString();
                if (name.endsWith(".ros")) {
                    rosFiles.add(norm);
                } else if (name.endsWith(".ros2")) {
                    ros2Files.add(norm);
                } else if (name.endsWith(".rossystem")) {
                    sysFiles.add(norm);
                }
            }
        } catch (IOException ignored) {
            return;
        }

        List<Path> ordered = new ArrayList<>(rosFiles.size() + ros2Files.size() + sysFiles.size());
        ordered.addAll(rosFiles);
        ordered.addAll(ros2Files);
        ordered.addAll(sysFiles);

        for (Path p : ordered) {
            try {
                URI siblingUri = URI.createURI(p.toUri().toString());
                if (rs.getResource(siblingUri, false) != null) {
                    continue;
                }
                Resource r = rs.createResource(siblingUri);
                if (r != null && !r.isLoaded()) {
                    r.load(Map.of());
                }
            } catch (Exception ignored) {
                // Best-effort sibling loading; invalid companion files still report via validation.
            }
        }
    }

    private static Path toNormalizedPath(final URI uri) {
        if (uri == null || !uri.isFile()) {
            return null;
        }
        String fileStr = uri.toFileString();
        if (fileStr == null || fileStr.isBlank()) {
            return null;
        }
        return Path.of(fileStr).toAbsolutePath().normalize();
    }
}
