package de.fraunhofer.ipa.ros2.distro;

/** Support status of a ROS 2 distribution; used to choose the default target. */
public enum DistroStatus {
    /** Long-term support release (five years). */
    LTS,
    /** Regular release (about 1.5 years). */
    NON_LTS,
    /** The continuously updated development distribution. */
    ROLLING
}
