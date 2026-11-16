package de.fraunhofer.ipa.ros.tests.golden;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.xtext.generator.InMemoryFileSystemAccess;

/** Stored-output helpers shared by the generator golden tests. */
final class GoldenFiles {

    private static final String OUTPUT_PREFIX = "DEFAULT_OUTPUT";

    private GoldenFiles() {
    }

    /** {@code ROSTOOLING_UPDATE_GOLDEN=1} (or {@code -Drostooling.updateGolden=true}) rewrites the stored files. */
    static boolean updateRequested() {
        return "1".equals(System.getenv("ROSTOOLING_UPDATE_GOLDEN"))
                || Boolean.getBoolean("rostooling.updateGolden");
    }

    static List<Path> listFiles(Path dir, String extension) throws IOException {
        try (Stream<Path> files = Files.list(dir)) {
            return files.filter(p -> p.toString().endsWith(extension)).sorted().collect(Collectors.toList());
        }
    }

    /** Generated text files keyed by their path relative to the output root. */
    static Map<String, String> textFiles(InMemoryFileSystemAccess fsa) {
        Map<String, String> files = new TreeMap<>();
        fsa.getTextFiles().forEach((key, content) -> {
            String path = key.startsWith(OUTPUT_PREFIX) ? key.substring(OUTPUT_PREFIX.length()) : key;
            files.put(path.replaceFirst("^/", ""), content.toString());
        });
        return files;
    }

    /** Replaces the tree under {@code root} with {@code files}. */
    static void write(Path root, Map<String, String> files) throws IOException {
        if (Files.exists(root)) {
            try (Stream<Path> walk = Files.walk(root)) {
                for (Path p : walk.sorted((a, b) -> b.compareTo(a)).collect(Collectors.toList())) {
                    Files.delete(p);
                }
            }
        }
        for (Map.Entry<String, String> file : files.entrySet()) {
            Path target = root.resolve(file.getKey());
            Files.createDirectories(target.getParent());
            Files.write(target, file.getValue().getBytes(StandardCharsets.UTF_8));
        }
    }

    /** Adds one line per new, changed or missing file under {@code root} to {@code mismatches}. */
    static void compare(Path root, Map<String, String> actual, String label, List<String> mismatches)
            throws IOException {
        Map<String, String> expected = new TreeMap<>();
        if (Files.exists(root)) {
            try (Stream<Path> walk = Files.walk(root)) {
                for (Path p : walk.filter(Files::isRegularFile).collect(Collectors.toList())) {
                    expected.put(root.relativize(p).toString().replace('\\', '/'),
                            new String(Files.readAllBytes(p), StandardCharsets.UTF_8));
                }
            }
        }
        for (Map.Entry<String, String> file : actual.entrySet()) {
            String want = expected.get(file.getKey());
            if (want == null) {
                mismatches.add(label + ": unexpected new file " + file.getKey());
            } else if (!want.equals(file.getValue())) {
                mismatches.add(label + ": content differs in " + file.getKey());
            }
        }
        for (String path : expected.keySet()) {
            if (!actual.containsKey(path)) {
                mismatches.add(label + ": file no longer generated " + path);
            }
        }
    }
}
