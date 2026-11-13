package de.fraunhofer.ipa.ros2.distro;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Everything the generators need to know about one ROS 2 distribution.
 *
 * <p>Instances are immutable and are only created in {@link Ros2Distros}. A new distribution
 * is derived from its predecessor with {@link #derive(String)} and overrides only what changed.
 *
 * <p>Three kinds of entries:
 * <ul>
 * <li><b>values</b> that templates interpolate directly ({@link #cxxStandard()},
 * {@link #cmakeMinimumVersion()});</li>
 * <li><b>variants</b>: enums naming alternative syntaxes for the same thing
 * ({@link #serviceQosArgument()}, {@link #rateImplementation()}). Only dialect classes in
 * {@code de.fraunhofer.ipa.ros2.distro.dialect} switch on them, with exhaustive switches, so
 * adding an enum constant breaks compilation everywhere it must be handled;</li>
 * <li><b>metadata</b> ({@link #status()}).</li>
 * </ul>
 * When adding a variant, also list it in {@link #variants()} so the registry tests can check it.
 */
public final class Ros2Distro {

    private final String name;
    private final DistroStatus status;
    private final int cxxStandard;
    private final String cmakeMinimumVersion;
    private final ServiceQosArgument serviceQosArgument;
    private final RateImplementation rateImplementation;

    private Ros2Distro(Builder b) {
        this.name = requireText(b.name, "name");
        this.status = Objects.requireNonNull(b.status, "status of " + b.name);
        this.cxxStandard = b.cxxStandard;
        this.cmakeMinimumVersion = requireText(b.cmakeMinimumVersion, "cmakeMinimumVersion of " + b.name);
        this.serviceQosArgument = Objects.requireNonNull(b.serviceQosArgument, "serviceQosArgument of " + b.name);
        this.rateImplementation = Objects.requireNonNull(b.rateImplementation, "rateImplementation of " + b.name);
        if (cxxStandard < 17) {
            throw new IllegalArgumentException("cxxStandard of " + name + " must be at least 17");
        }
    }

    /** Starts the oldest distribution; every field must be set. */
    static Builder builder(String name) {
        Builder b = new Builder();
        b.name = name;
        return b;
    }

    /** Starts a distribution that inherits every entry of this one. */
    Builder derive(String newName) {
        Builder b = new Builder();
        b.name = newName;
        b.status = status;
        b.cxxStandard = cxxStandard;
        b.cmakeMinimumVersion = cmakeMinimumVersion;
        b.serviceQosArgument = serviceQosArgument;
        b.rateImplementation = rateImplementation;
        return b;
    }

    /** Lower-case distribution name, e.g. {@code jazzy}. */
    public String name() {
        return name;
    }

    public DistroStatus status() {
        return status;
    }

    /** Value for {@code CMAKE_CXX_STANDARD} in generated packages. */
    public int cxxStandard() {
        return cxxStandard;
    }

    /** Value for {@code cmake_minimum_required(VERSION ...)}; mirrors {@code ros2 pkg create}. */
    public String cmakeMinimumVersion() {
        return cmakeMinimumVersion;
    }

    public ServiceQosArgument serviceQosArgument() {
        return serviceQosArgument;
    }

    public RateImplementation rateImplementation() {
        return rateImplementation;
    }

    /** All variant entries by name, for registry checks and diagnostics. */
    public Map<String, Enum<?>> variants() {
        Map<String, Enum<?>> variants = new LinkedHashMap<>();
        variants.put("serviceQosArgument", serviceQosArgument);
        variants.put("rateImplementation", rateImplementation);
        return variants;
    }

    @Override
    public String toString() {
        return name;
    }

    private static String requireText(String value, String what) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(what + " must be set");
        }
        return value;
    }

    /** Builder used by {@link Ros2Distros}. */
    static final class Builder {
        private String name;
        private DistroStatus status;
        private int cxxStandard;
        private String cmakeMinimumVersion;
        private ServiceQosArgument serviceQosArgument;
        private RateImplementation rateImplementation;

        Builder status(DistroStatus value) {
            this.status = value;
            return this;
        }

        Builder cxxStandard(int value) {
            this.cxxStandard = value;
            return this;
        }

        Builder cmakeMinimumVersion(String value) {
            this.cmakeMinimumVersion = value;
            return this;
        }

        Builder serviceQosArgument(ServiceQosArgument value) {
            this.serviceQosArgument = value;
            return this;
        }

        Builder rateImplementation(RateImplementation value) {
            this.rateImplementation = value;
            return this;
        }

        Ros2Distro build() {
            return new Ros2Distro(this);
        }
    }
}
