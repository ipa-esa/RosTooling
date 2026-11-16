package de.fraunhofer.ipa.ros2.distro.dialect;

import java.util.Collection;

import de.fraunhofer.ipa.ros2.distro.Ros2Distro;

/** CMake fragments for generated ament_cmake packages. */
public class CMakeDialect {

    private final Ros2Distro distro;

    public CMakeDialect(Ros2Distro distro) {
        this.distro = distro;
    }

    /** {@code cmake_minimum_required(...)} line. */
    public String minimumRequired() {
        return "cmake_minimum_required(VERSION " + distro.cmakeMinimumVersion() + ")";
    }

    /** {@code set(CMAKE_CXX_STANDARD ...)} line. */
    public String cxxStandard() {
        return "set(CMAKE_CXX_STANDARD " + distro.cxxStandard() + ")";
    }

    /**
     * Links {@code target} against ROS packages found with {@code find_package}.
     *
     * <p>Uses {@code target_link_libraries} with each package's exported {@code <pkg>_TARGETS}.
     * That works from Humble on and replaces {@code ament_target_dependencies}, which Kilted
     * deprecates and Lyrical removes. Only packages that export CMake targets (rclcpp*, interface
     * packages) may be passed here.
     *
     * @param visibility {@code PUBLIC}, {@code PRIVATE} or {@code INTERFACE}
     */
    public String linkPackages(String target, String visibility, Collection<String> packages) {
        StringBuilder sb = new StringBuilder();
        sb.append("target_link_libraries(").append(target).append(' ').append(visibility).append('\n');
        for (String pkg : packages) {
            sb.append("  ${").append(pkg).append("_TARGETS}\n");
        }
        sb.append(')');
        return sb.toString();
    }
}
