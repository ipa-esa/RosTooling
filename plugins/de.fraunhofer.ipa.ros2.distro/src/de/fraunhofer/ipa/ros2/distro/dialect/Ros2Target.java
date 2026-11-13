package de.fraunhofer.ipa.ros2.distro.dialect;

import de.fraunhofer.ipa.ros2.distro.Ros2Distro;
import de.fraunhofer.ipa.ros2.distro.Ros2Distros;

/**
 * Generation context for one target distribution: the resolved {@link Ros2Distro} plus the
 * dialects that turn its variants into code. Created per generation request and passed to the
 * templates, which ask it for every distribution-dependent fragment.
 *
 * <p>Add a dialect class (e.g. for Python or launch files) when the first variant for that
 * language appears; keep switches on variants inside dialects only.
 */
public final class Ros2Target {

    private final Ros2Distro distro;
    private final CppDialect cpp;
    private final CMakeDialect cmake;

    private Ros2Target(Ros2Distro distro) {
        this.distro = distro;
        this.cpp = new CppDialect(distro);
        this.cmake = new CMakeDialect(distro);
    }

    public static Ros2Target of(Ros2Distro distro) {
        return new Ros2Target(distro);
    }

    /** See {@link Ros2Distros#resolve(String)}. */
    public static Ros2Target resolve(String requestedDistro) {
        return of(Ros2Distros.resolve(requestedDistro));
    }

    public Ros2Distro getDistro() {
        return distro;
    }

    public CppDialect getCpp() {
        return cpp;
    }

    public CMakeDialect getCmake() {
        return cmake;
    }
}
