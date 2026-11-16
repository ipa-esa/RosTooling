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
#include "rclcpp_lifecycle/lifecycle_node.hpp"

// ROS 2 Interface Message / Service / Action headers
#include "std_msgs/msg/string.hpp"
#include "std_srvs/srv/trigger.hpp"
#include "std_srvs/srv/set_bool.hpp"

namespace golden_pkg {

/**
 * @brief Generated ROS 2 Node wrapper for 'service_node' (Artifact: 'service_node').
 * DO NOT DIRECTLY EDIT THIS FILE - it will be overwritten on generation.
 * Domain logic should inherit from this class or implement the pure virtual callbacks.
 */
class ServiceNodeWrapper : public rclcpp_lifecycle::LifecycleNode {
public:
    explicit ServiceNodeWrapper(const rclcpp::NodeOptions & options = rclcpp::NodeOptions());
    virtual ~ServiceNodeWrapper() = default;

    using CallbackReturn = rclcpp_lifecycle::node_interfaces::LifecycleNodeInterface::CallbackReturn;

    // ==========================================
    // LIFECYCLE TRANSITION CALLBACKS
    // ==========================================
    virtual CallbackReturn on_configure(const rclcpp_lifecycle::State & state);
    virtual CallbackReturn on_activate(const rclcpp_lifecycle::State & state);
    virtual CallbackReturn on_deactivate(const rclcpp_lifecycle::State & state);
    virtual CallbackReturn on_cleanup(const rclcpp_lifecycle::State & state);
    virtual CallbackReturn on_shutdown(const rclcpp_lifecycle::State & state);
    virtual CallbackReturn on_error(const rclcpp_lifecycle::State & state);

    // ==========================================
    // SUBSCRIBER CACHED DATA ACCESSORS
    // ==========================================
protected:
    // ==========================================
    // INCOMING INTERFACE HOOKS (Implemented by Core Logic)
    // ==========================================

    /**
     * @brief Inbound service handler hook for service 'reset'
     */
    virtual void handle_reset(
        const std::shared_ptr<std_srvs::srv::Trigger::Request> request,
        std::shared_ptr<std_srvs::srv::Trigger::Response> response) {
        	(void)request;
        	(void)response;
        	RCLCPP_ERROR(this->get_logger(), "The abstract method handle_reset needs to be overriden!");
        };

    // ==========================================
    // OUTGOING INTERFACE METHODS (Invoked by Core Logic)
    // ==========================================

    /**
     * @brief Publish message to topic 'heartbeat'
     */
    void publish_heartbeat(const std_msgs::msg::String & msg);

    using SetBool = std_srvs::srv::SetBool;

    /**
     * @brief Check if service 'enable_client' is available
     */
    bool is_enable_client_ready(std::chrono::nanoseconds timeout = std::chrono::nanoseconds(1000));

    /**
     * @brief Asynchronous call to service 'enable_client' returning a SharedFuture
     */
    rclcpp::Client<SetBool>::SharedFuture call_enable_client_async(
        std::shared_ptr<SetBool::Request> request);

    /**
     * @brief Asynchronous call to service 'enable_client' with completion callback
     */
    void call_enable_client_async(
        std::shared_ptr<SetBool::Request> request,
        std::function<void(rclcpp::Client<SetBool>::SharedFuture)> callback);

    /**
     * @brief Thread-safe Synchronous call to service 'enable_client' with timeout
     */
    std::optional<SetBool::Response> call_enable_client_sync(
        const SetBool::Request & request,
        std::chrono::nanoseconds timeout = std::chrono::seconds(5));

    // ==========================================
    // PARAMETER ACCESSORS
    // ==========================================


private:
    rclcpp::CallbackGroup::SharedPtr client_cb_group_;
    OnSetParametersCallbackHandle::SharedPtr param_cb_handle_;

    // ROS 2 interface handles
    rclcpp_lifecycle::LifecyclePublisher<std_msgs::msg::String>::SharedPtr pub_heartbeat_;
    rclcpp::Service<std_srvs::srv::Trigger>::SharedPtr srv_reset_;
    rclcpp::Client<std_srvs::srv::SetBool>::SharedPtr client_enable_client_;

    // Internal parameter values
};

} // namespace golden_pkg
