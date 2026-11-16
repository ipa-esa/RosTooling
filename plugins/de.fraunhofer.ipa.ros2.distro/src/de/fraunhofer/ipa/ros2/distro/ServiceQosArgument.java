package de.fraunhofer.ipa.ros2.distro;

/**
 * How {@code rclcpp::Node::create_service} / {@code create_client} take their QoS argument.
 *
 * <ul>
 * <li>Humble only has the {@code const rmw_qos_profile_t &} overload.</li>
 * <li>Iron added the {@code const rclcpp::QoS &} overload; Jazzy deprecates the
 * {@code rmw_qos_profile_t} one ({@code rclcpp/node.hpp}).</li>
 * </ul>
 */
public enum ServiceQosArgument {
    /** {@code rmw_qos_profile_services_default}. */
    RMW_QOS_PROFILE,
    /** {@code rclcpp::ServicesQoS()}. */
    RCLCPP_QOS
}
