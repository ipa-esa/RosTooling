package de.fraunhofer.ipa.ros2.distro;

/**
 * How the generated C++ node implements a rate that follows the node's (possibly simulated) clock.
 *
 * <ul>
 * <li>Humble's {@code rclcpp::Rate} is a wall-clock {@code GenericRate<system_clock>} without a
 * clock-aware constructor.</li>
 * <li>Iron and newer provide {@code rclcpp::Rate(double, rclcpp::Clock::SharedPtr)}.</li>
 * </ul>
 */
public enum RateImplementation {
    /** Generated adapter sleeping with {@code rclcpp::Clock::sleep_until}. */
    CLOCK_SLEEP_UNTIL,
    /** {@code rclcpp::Rate(hz, clock)}. */
    RCLCPP_RATE_WITH_CLOCK
}
