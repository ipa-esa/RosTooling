package de.fraunhofer.ipa.ros2.distro;

/** Thrown when a requested ROS 2 distribution is not in {@link Ros2Distros}. */
public class UnknownDistroException extends IllegalArgumentException {

    private static final long serialVersionUID = 1L;

    public UnknownDistroException(String message) {
        super(message);
    }
}
