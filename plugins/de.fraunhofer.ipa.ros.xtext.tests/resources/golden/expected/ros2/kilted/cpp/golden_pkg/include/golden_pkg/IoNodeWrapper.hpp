#pragma once

#include <chrono>
#include <functional>
#include <future>
#include <memory>
#include <mutex>
#include <optional>
#include <string>
#include <vector>

#include "rclcpp/rclcpp.hpp"

// ROS 2 Interface Message / Service / Action headers
#include "std_msgs/msg/string.hpp"
#include "geometry_msgs/msg/pose_stamped.hpp"
#include "sensor_msgs/msg/laser_scan.hpp"
#include "geometry_msgs/msg/twist.hpp"

namespace golden_pkg {

/**
 * @brief Generated ROS 2 Node wrapper for 'io_node' (Artifact: 'io_node').
 * DO NOT DIRECTLY EDIT THIS FILE - it will be overwritten on generation.
 * Domain logic should inherit from this class or implement the pure virtual callbacks.
 */
class IoNodeWrapper : public rclcpp::Node {
public:
    explicit IoNodeWrapper(const rclcpp::NodeOptions & options = rclcpp::NodeOptions());
    virtual ~IoNodeWrapper() = default;


    // ==========================================
    // SUBSCRIBER CACHED DATA ACCESSORS
    // ==========================================
    /**
     * @brief Get the latest cached message received on topic 'scan_in'
     */
    std::optional<sensor_msgs::msg::LaserScan> get_latest_scan_in_msg() const {
        std::lock_guard<std::mutex> lock(sub_scan_in_mutex_);
        return latest_sub_scan_in_msg_;
    }

    /**
     * @brief Check if a new unread message has arrived on topic 'scan_in'
     */
    bool has_new_scan_in_msg() const {
        std::lock_guard<std::mutex> lock(sub_scan_in_mutex_);
        return has_new_sub_scan_in_msg_;
    }

    /**
     * @brief Retrieve and clear the new message flag for topic 'scan_in'
     */
    std::optional<sensor_msgs::msg::LaserScan> take_latest_scan_in_msg() {
        std::lock_guard<std::mutex> lock(sub_scan_in_mutex_);
        has_new_sub_scan_in_msg_ = false;
        return latest_sub_scan_in_msg_;
    }

    /**
     * @brief Get the latest cached message received on topic 'cmd_in'
     */
    std::optional<geometry_msgs::msg::Twist> get_latest_cmd_in_msg() const {
        std::lock_guard<std::mutex> lock(sub_cmd_in_mutex_);
        return latest_sub_cmd_in_msg_;
    }

    /**
     * @brief Check if a new unread message has arrived on topic 'cmd_in'
     */
    bool has_new_cmd_in_msg() const {
        std::lock_guard<std::mutex> lock(sub_cmd_in_mutex_);
        return has_new_sub_cmd_in_msg_;
    }

    /**
     * @brief Retrieve and clear the new message flag for topic 'cmd_in'
     */
    std::optional<geometry_msgs::msg::Twist> take_latest_cmd_in_msg() {
        std::lock_guard<std::mutex> lock(sub_cmd_in_mutex_);
        has_new_sub_cmd_in_msg_ = false;
        return latest_sub_cmd_in_msg_;
    }

protected:
    // ==========================================
    // INCOMING INTERFACE HOOKS (Implemented by Core Logic)
    // ==========================================

    /**
     * @brief Inbound subscriber callback hook for topic 'scan_in'
     */
    virtual void on_scan_in_msg(
        const sensor_msgs::msg::LaserScan::SharedPtr msg) {
        	(void)msg;
        	RCLCPP_ERROR(this->get_logger(), "The abstract method on_scan_in needs to be overriden!");
        };

    /**
     * @brief Inbound subscriber callback hook for topic 'cmd_in'
     */
    virtual void on_cmd_in_msg(
        const geometry_msgs::msg::Twist::SharedPtr msg) {
        	(void)msg;
        	RCLCPP_ERROR(this->get_logger(), "The abstract method on_cmd_in needs to be overriden!");
        };

    /**
     * @brief Dynamic parameter validation callback hook
     */
    virtual rcl_interfaces::msg::SetParametersResult on_parameters_changed(
        const std::vector<rclcpp::Parameter> & parameters)
    {
        rcl_interfaces::msg::SetParametersResult result;
        result.successful = true;
        (void)parameters;
        return result;
    }
    // ==========================================
    // OUTGOING INTERFACE METHODS (Invoked by Core Logic)
    // ==========================================

    /**
     * @brief Publish message to topic 'status_out'
     */
    void publish_status_out(const std_msgs::msg::String & msg);

    /**
     * @brief Publish message to topic 'pose_out'
     */
    void publish_pose_out(const geometry_msgs::msg::PoseStamped & msg);

    // ==========================================
    // PARAMETER ACCESSORS
    // ==========================================

    double get_param_rate_hz() const { return param_rate_hz_; }
    int64_t get_param_max_count() const { return param_max_count_; }
    bool get_param_enabled() const { return param_enabled_; }
    std::string get_param_frame_id() const { return param_frame_id_; }

private:
    rclcpp::CallbackGroup::SharedPtr client_cb_group_;
    OnSetParametersCallbackHandle::SharedPtr param_cb_handle_;

    // ROS 2 interface handles
    rclcpp::Publisher<std_msgs::msg::String>::SharedPtr pub_status_out_;
    rclcpp::Publisher<geometry_msgs::msg::PoseStamped>::SharedPtr pub_pose_out_;
    rclcpp::Subscription<sensor_msgs::msg::LaserScan>::SharedPtr sub_scan_in_;
    mutable std::mutex sub_scan_in_mutex_;
    std::optional<sensor_msgs::msg::LaserScan> latest_sub_scan_in_msg_;
    bool has_new_sub_scan_in_msg_{false};
    rclcpp::Subscription<geometry_msgs::msg::Twist>::SharedPtr sub_cmd_in_;
    mutable std::mutex sub_cmd_in_mutex_;
    std::optional<geometry_msgs::msg::Twist> latest_sub_cmd_in_msg_;
    bool has_new_sub_cmd_in_msg_{false};

    // Internal parameter values
    double param_rate_hz_{10.0};
    int64_t param_max_count_{5};
    bool param_enabled_{true};
    std::string param_frame_id_{"base_link"};
    rcl_interfaces::msg::SetParametersResult internal_on_set_parameters(
        const std::vector<rclcpp::Parameter> & parameters);
};

} // namespace golden_pkg
