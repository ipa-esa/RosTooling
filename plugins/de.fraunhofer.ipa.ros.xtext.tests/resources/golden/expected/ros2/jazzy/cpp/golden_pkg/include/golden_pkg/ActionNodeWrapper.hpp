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
#include "rclcpp_action/rclcpp_action.hpp"

// ROS 2 Interface Message / Service / Action headers
#include "tf2_msgs/action/lookup_transform.hpp"
#include "tf2_msgs/action/lookup_transform.hpp"

namespace golden_pkg {

/**
 * @brief Generated ROS 2 Node wrapper for 'action_node' (Artifact: 'action_node').
 * DO NOT DIRECTLY EDIT THIS FILE - it will be overwritten on generation.
 * Domain logic should inherit from this class or implement the pure virtual callbacks.
 */
class ActionNodeWrapper : public rclcpp::Node {
public:
    explicit ActionNodeWrapper(const rclcpp::NodeOptions & options = rclcpp::NodeOptions());
    virtual ~ActionNodeWrapper() = default;


    // ==========================================
    // SUBSCRIBER CACHED DATA ACCESSORS
    // ==========================================
protected:
    // ==========================================
    // INCOMING INTERFACE HOOKS (Implemented by Core Logic)
    // ==========================================

    using LookupTransform = tf2_msgs::action::LookupTransform;
    using GoalHandleLookupTransform = rclcpp_action::ServerGoalHandle<LookupTransform>;

    /**
     * @brief Goal callback hook for Action 'lookup' (Defaults to ACCEPT_AND_EXECUTE)
     */
    virtual rclcpp_action::GoalResponse on_lookup_goal(
        const rclcpp_action::GoalUUID & uuid,
        std::shared_ptr<const LookupTransform::Goal> goal)
    {
        (void)uuid;
        (void)goal;
        return rclcpp_action::GoalResponse::ACCEPT_AND_EXECUTE;
    }

    /**
     * @brief Cancel callback hook for Action 'lookup' (Defaults to ACCEPT)
     */
    virtual rclcpp_action::CancelResponse on_lookup_cancel(
        const std::shared_ptr<GoalHandleLookupTransform> goal_handle)
    {
        (void)goal_handle;
        return rclcpp_action::CancelResponse::ACCEPT;
    }

    /**
     * @brief Execute callback for Action 'lookup' - Pure virtual (Domain execution logic)
     */
    virtual void execute_lookup(
        const std::shared_ptr<GoalHandleLookupTransform> goal_handle) {
        	(void)goal_handle;
        	RCLCPP_ERROR(this->get_logger(), "The abstract method execute_lookup needs to be overriden!");
        };

    // ==========================================
    // OUTGOING INTERFACE METHODS (Invoked by Core Logic)
    // ==========================================

    using LookupTransformClient = tf2_msgs::action::LookupTransform;
    using ClientGoalHandleLookupTransform = rclcpp_action::ClientGoalHandle<LookupTransformClient>;

    /**
     * @brief Asynchronously send goal to Action 'lookup_client'
     */
    std::shared_future<ClientGoalHandleLookupTransform::SharedPtr> send_lookup_client_goal_async(
        const LookupTransformClient::Goal & goal,
        std::function<void(ClientGoalHandleLookupTransform::SharedPtr)> goal_response_cb = nullptr,
        std::function<void(ClientGoalHandleLookupTransform::SharedPtr, const std::shared_ptr<const LookupTransformClient::Feedback>)> feedback_cb = nullptr,
        std::function<void(const ClientGoalHandleLookupTransform::WrappedResult &)> result_cb = nullptr,
        std::chrono::nanoseconds timeout = std::chrono::seconds(10));

    /**
     * @brief Cancel active goal for Action 'lookup_client'
     */
    void cancel_lookup_client_goal_async(
        std::shared_ptr<ClientGoalHandleLookupTransform> goal_handle);

    /**
     * @brief Cancel all active goals for Action 'lookup_client'
     */
    void cancel_all_lookup_client_goals_async();

    /**
     * @brief Wait for action server 'lookup_client' to be available
     */
    bool wait_for_lookup_client_server(
        std::chrono::nanoseconds timeout = std::chrono::nanoseconds(-1));

    /**
     * @brief Check if action server 'lookup_client' is ready
     */
    bool is_lookup_client_server_ready() const;

    /**
     * @brief Publish feedback for Action server 'lookup'
     */
    void publish_lookup_feedback(
        std::shared_ptr<GoalHandleLookupTransform> goal_handle,
        std::shared_ptr<LookupTransform::Feedback> feedback);

    // ==========================================
    // PARAMETER ACCESSORS
    // ==========================================


private:
    rclcpp::CallbackGroup::SharedPtr client_cb_group_;
    OnSetParametersCallbackHandle::SharedPtr param_cb_handle_;

    // ROS 2 interface handles
    rclcpp_action::Server<tf2_msgs::action::LookupTransform>::SharedPtr action_server_lookup_;
    rclcpp_action::Client<tf2_msgs::action::LookupTransform>::SharedPtr action_client_lookup_client_;

    // Internal parameter values
};

} // namespace golden_pkg
