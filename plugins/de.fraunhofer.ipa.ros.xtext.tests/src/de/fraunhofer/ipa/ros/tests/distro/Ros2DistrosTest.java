package de.fraunhofer.ipa.ros.tests.distro;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

import de.fraunhofer.ipa.ros2.distro.DistroStatus;
import de.fraunhofer.ipa.ros2.distro.Ros2Distro;
import de.fraunhofer.ipa.ros2.distro.Ros2Distros;
import de.fraunhofer.ipa.ros2.distro.UnknownDistroException;

/** Rules that keep the distribution registry and the generators clean. */
public class Ros2DistrosTest {

    /** Generator sources that must ask the registry instead of naming distributions. */
    private static final List<Path> GENERATOR_SOURCES = List.of(
            Paths.get("..", "de.fraunhofer.ipa.ros2.xtext", "src", "de", "fraunhofer", "ipa", "ros2", "generator"),
            Paths.get("..", "de.fraunhofer.ipa.ros2.xtext.ide", "src"),
            Paths.get("..", "de.fraunhofer.ipa.rossystem.xtext", "src", "de", "fraunhofer", "ipa", "rossystem", "generator"),
            Paths.get("..", "de.fraunhofer.ipa.rossystem.xtext.ide", "src"));

    @Test
    public void namesAreUniqueLowerCaseAndRollingIsLast() {
        List<String> names = Ros2Distros.names();
        assertEquals(names.size(), new HashSet<>(names).size());
        for (String name : names) {
            assertTrue(name, name.matches("[a-z]+"));
        }
        Ros2Distro last = Ros2Distros.all().get(names.size() - 1);
        assertEquals(DistroStatus.ROLLING, last.status());
        assertEquals(1, Ros2Distros.all().stream().filter(d -> d.status() == DistroStatus.ROLLING).count());
    }

    @Test
    public void defaultIsNewestLts() {
        Ros2Distro def = Ros2Distros.defaultDistro();
        assertEquals(DistroStatus.LTS, def.status());
        List<Ros2Distro> all = Ros2Distros.all();
        for (Ros2Distro d : all.subList(all.indexOf(def) + 1, all.size())) {
            assertTrue(d + " is newer than the default but LTS", d.status() != DistroStatus.LTS);
        }
    }

    @Test
    public void resolveHandlesAutoAndEnvironment() {
        assertEquals("jazzy", Ros2Distros.resolve("JAZZY", "humble").name());
        assertEquals("humble", Ros2Distros.resolve("auto", "humble").name());
        assertEquals("kilted", Ros2Distros.resolve(null, "kilted").name());
        assertEquals(Ros2Distros.defaultDistro(), Ros2Distros.resolve("", null));
    }

    @Test
    public void unknownDistrosAreRejectedWithTheSupportedList() {
        for (String bad : List.of("iron", "jazy")) {
            try {
                Ros2Distros.get(bad);
                fail("accepted " + bad);
            } catch (UnknownDistroException e) {
                for (String name : Ros2Distros.names()) {
                    assertTrue(e.getMessage(), e.getMessage().contains(name));
                }
            }
        }
        try {
            Ros2Distros.resolve("auto", "iron");
            fail("accepted ROS_DISTRO=iron");
        } catch (UnknownDistroException e) {
            assertTrue(e.getMessage(), e.getMessage().contains("ROS_DISTRO=iron"));
        }
    }

    /**
     * A variant with the same value on every supported distribution is dead: inline the remaining
     * branch in its dialect and delete the enum (typically after the oldest distribution's EOL).
     */
    @Test
    public void everyVariantStillDistinguishesDistributions() {
        Map<String, Enum<?>> first = Ros2Distros.all().get(0).variants();
        List<String> constant = new ArrayList<>();
        for (String variant : first.keySet()) {
            Set<Enum<?>> values = Ros2Distros.all().stream()
                    .map(d -> d.variants().get(variant)).collect(Collectors.toSet());
            if (values.size() < 2) {
                constant.add(variant + "=" + values);
            }
        }
        assertTrue("Variants with one value on all distributions; inline them: " + constant, constant.isEmpty());
    }

    /** The CI build matrix and the stored golden output cover exactly the registered distributions. */
    @Test
    public void ciMatrixAndGoldenFilesMatchTheRegistry() throws IOException {
        String workflow = Files.readString(Paths.get("..", "..", ".github", "workflows", "distro-matrix.yml"));
        Matcher matrix = Pattern.compile("distro:\\s*\\[([^\\]]*)\\]").matcher(workflow);
        assertTrue("no distro matrix in distro-matrix.yml", matrix.find());
        List<String> ciDistros = Stream.of(matrix.group(1).split(","))
                .map(String::trim).filter(s -> !s.isEmpty()).collect(Collectors.toList());
        assertEquals("distro-matrix.yml matrix", Ros2Distros.names(), ciDistros);

        Path golden = Paths.get("resources", "golden", "expected", "ros2");
        try (Stream<Path> dirs = Files.list(golden)) {
            Set<String> goldenDistros = dirs.filter(Files::isDirectory)
                    .map(p -> p.getFileName().toString()).collect(Collectors.toSet());
            assertEquals("golden distributions in " + golden, new HashSet<>(Ros2Distros.names()), goldenDistros);
        }
    }

    /** Distribution names belong in Ros2Distros only; templates ask dialects for fragments. */
    @Test
    public void generatorsDoNotNameDistributions() throws IOException {
        Pattern literal = Pattern.compile("\"(" + String.join("|", Ros2Distros.names()) + ")\"",
                Pattern.CASE_INSENSITIVE);
        List<String> offenders = new ArrayList<>();
        for (Path root : GENERATOR_SOURCES) {
            assertTrue("missing " + root.toAbsolutePath(), Files.isDirectory(root));
            try (Stream<Path> files = Files.walk(root)) {
                for (Path file : files.filter(p -> p.toString().endsWith(".xtend") || p.toString().endsWith(".java"))
                        .collect(Collectors.toList())) {
                    List<String> lines = Files.readAllLines(file, StandardCharsets.UTF_8);
                    for (int i = 0; i < lines.size(); i++) {
                        Matcher m = literal.matcher(lines.get(i));
                        if (m.find()) {
                            offenders.add(file + ":" + (i + 1) + ": " + lines.get(i).trim());
                        }
                    }
                }
            }
        }
        assertTrue("Distribution names in generator code:\n" + String.join("\n", offenders), offenders.isEmpty());
    }
}
