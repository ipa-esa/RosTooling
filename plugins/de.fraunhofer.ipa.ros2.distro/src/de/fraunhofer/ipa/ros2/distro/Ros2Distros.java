package de.fraunhofer.ipa.ros2.distro;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

/**
 * The supported ROS 2 distributions: the only place in the generators that names them.
 *
 * <p>To add a distribution: derive it from the newest entry, override only what changed, add it
 * to {@link #ALL} (oldest first) and point {@code ROLLING} at it. Then regenerate the golden files
 * and run {@code tools/distro-matrix/build-golden.sh <distro>}; see {@code tools/distro-matrix/README.md}.
 *
 * <p>Values are taken from the distribution itself (headers, {@code ros2 pkg create} templates in
 * the official {@code ros:<distro>} image), not from memory.
 */
public final class Ros2Distros {

    /** Requested distribution meaning "use {@code $ROS_DISTRO}, else {@link #defaultDistro()}". */
    public static final String AUTO = "auto";

    private static final Ros2Distro HUMBLE = Ros2Distro.builder("humble")
            .status(DistroStatus.LTS)
            .cxxStandard(17)
            .cmakeMinimumVersion("3.8")
            .serviceQosArgument(ServiceQosArgument.RMW_QOS_PROFILE)
            .rateImplementation(RateImplementation.CLOCK_SLEEP_UNTIL)
            .build();

    private static final Ros2Distro JAZZY = HUMBLE.derive("jazzy")
            // C++20 was the generator's choice for Jazzy and newer before this registry existed;
            // REP 2000 only requires C++17.
            .cxxStandard(20)
            .serviceQosArgument(ServiceQosArgument.RCLCPP_QOS)
            .rateImplementation(RateImplementation.RCLCPP_RATE_WITH_CLOCK)
            .build();

    private static final Ros2Distro KILTED = JAZZY.derive("kilted")
            .status(DistroStatus.NON_LTS)
            .cmakeMinimumVersion("3.20")
            .build();

    private static final Ros2Distro LYRICAL = KILTED.derive("lyrical")
            .status(DistroStatus.LTS)
            .build();

    private static final Ros2Distro ROLLING = LYRICAL.derive("rolling")
            .status(DistroStatus.ROLLING)
            .build();

    /** Oldest first. */
    private static final List<Ros2Distro> ALL = List.of(HUMBLE, JAZZY, KILTED, LYRICAL, ROLLING);

    private Ros2Distros() {
    }

    /** All supported distributions, oldest first, rolling last. */
    public static List<Ros2Distro> all() {
        return ALL;
    }

    /** Names of all supported distributions, oldest first. */
    public static List<String> names() {
        return ALL.stream().map(Ros2Distro::name).collect(Collectors.toList());
    }

    /** The newest LTS distribution. */
    public static Ros2Distro defaultDistro() {
        for (int i = ALL.size() - 1; i >= 0; i--) {
            if (ALL.get(i).status() == DistroStatus.LTS) {
                return ALL.get(i);
            }
        }
        throw new IllegalStateException("No LTS distribution registered");
    }

    /**
     * Looks a distribution up by name (case-insensitive).
     *
     * @throws UnknownDistroException listing the supported names
     */
    public static Ros2Distro get(String name) {
        String key = name == null ? "" : name.trim().toLowerCase(Locale.ROOT);
        for (Ros2Distro distro : ALL) {
            if (distro.name().equals(key)) {
                return distro;
            }
        }
        throw new UnknownDistroException("Unsupported ROS 2 distribution '" + name + "'. Supported: "
                + String.join(", ", names()) + " (or '" + AUTO + "').");
    }

    /** Resolves a requested distribution, reading {@code $ROS_DISTRO} for {@link #AUTO}. */
    public static Ros2Distro resolve(String requested) {
        return resolve(requested, System.getenv("ROS_DISTRO"));
    }

    /**
     * Resolves a requested distribution. {@code null}, empty and {@link #AUTO} select the
     * environment's distribution, or {@link #defaultDistro()} when none is set.
     *
     * @throws UnknownDistroException if the requested or environment distribution is unsupported
     */
    public static Ros2Distro resolve(String requested, String environmentDistro) {
        boolean auto = requested == null || requested.isBlank() || AUTO.equalsIgnoreCase(requested.trim());
        if (!auto) {
            return get(requested);
        }
        if (environmentDistro == null || environmentDistro.isBlank()) {
            return defaultDistro();
        }
        try {
            return get(environmentDistro);
        } catch (UnknownDistroException e) {
            throw new UnknownDistroException("ROS_DISTRO=" + environmentDistro
                    + " is not supported by the generator; pass the target distribution explicitly. "
                    + e.getMessage());
        }
    }
}
