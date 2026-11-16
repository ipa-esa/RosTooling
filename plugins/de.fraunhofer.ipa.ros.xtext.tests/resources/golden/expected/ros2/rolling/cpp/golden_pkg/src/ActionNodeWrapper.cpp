#include "golden_pkg/ActionNodeWrapper.hpp"

namespace golden_pkg {

ActionNodeWrapper::ActionNodeWrapper(const rclcpp::NodeOptions & options)
: rclcpp::Node("action_node", options)
{
    client_cb_group_ = this->create_callback_group(rclcpp::CallbackGroupType::Reentrant);

    // ----------------------------------------------------
    // 1. Parameter Declarations (with and without defaults)
    // ----------------------------------------------------
    // ----------------------------------------------------
    // 2. Publishers Initialization
    // ----------------------------------------------------

    // ----------------------------------------------------
    // 3. Subscribers Initialization
    // ----------------------------------------------------

    // ----------------------------------------------------
    // 4. Service Servers Initialization
    // ----------------------------------------------------

    // ----------------------------------------------------
    // 5. Service Clients Initialization
    // ----------------------------------------------------

    // ----------------------------------------------------
    // 6. Action Servers Initialization
    // ----------------------------------------------------
    action_server_lookup_ = rclcpp_action::create_server<LookupTransform>(
        this,
        "lookup",
        std::bind(&ActionNodeWrapper::on_lookup_goal, this, std::placeholders::_1, std::placeholders::_2),
        std::bind(&ActionNodeWrapper::on_lookup_cancel, this, std::placeholders::_1),
        [this](const std::shared_ptr<GoalHandleLookupTransform> handle) {
            std::thread([this, handle]() {
                this->execute_lookup(handle);
            }).detach();
        });

    // ----------------------------------------------------
    // 7. Action Clients Initialization
    // ----------------------------------------------------
    action_client_lookup_client_ = rclcpp_action::create_client<LookupTransformClient>(
        this, "lookup_client");
}

// Outgoing Publisher implementations

// Outgoing Service Client implementations

// Outgoing Action Client implementations
std::shared_future<ActionNodeWrapper::ClientGoalHandleLookupTransform::SharedPtr> 
ActionNodeWrapper::send_lookup_client_goal_async(
    const LookupTransformClient::Goal & goal,
    std::function<void(ClientGoalHandleLookupTransform::SharedPtr)> goal_response_cb,
    std::function<void(ClientGoalHandleLookupTransform::SharedPtr, const std::shared_ptr<const LookupTransformClient::Feedback>)> feedback_cb,
    std::function<void(const ClientGoalHandleLookupTransform::WrappedResult &)> result_cb,
    std::chrono::nanoseconds timeout)
{
    if (!action_client_lookup_client_->wait_for_action_server(timeout)) {
        RCLCPP_ERROR(this->get_logger(), "Action server 'lookup_client' not available after waiting");
        if (goal_response_cb) {
            goal_response_cb(nullptr);
        }
        return {};
    }
    auto send_goal_options = rclcpp_action::Client<LookupTransformClient>::SendGoalOptions();
    if (goal_response_cb) send_goal_options.goal_response_callback = goal_response_cb;
    if (feedback_cb) send_goal_options.feedback_callback = feedback_cb;
    if (result_cb) send_goal_options.result_callback = result_cb;
    return action_client_lookup_client_->async_send_goal(goal, send_goal_options);
}

void ActionNodeWrapper::cancel_lookup_client_goal_async(
    std::shared_ptr<ClientGoalHandleLookupTransform> goal_handle)
{
    if (action_client_lookup_client_ && goal_handle) {
        action_client_lookup_client_->async_cancel_goal(goal_handle);
    }
}

void ActionNodeWrapper::cancel_all_lookup_client_goals_async()
{
    if (action_client_lookup_client_) {
        action_client_lookup_client_->async_cancel_all_goals();
    }
}

bool ActionNodeWrapper::wait_for_lookup_client_server(
    std::chrono::nanoseconds timeout)
{
    if (!action_client_lookup_client_) return false;
    return action_client_lookup_client_->wait_for_action_server(timeout);
}

bool ActionNodeWrapper::is_lookup_client_server_ready() const
{
    if (!action_client_lookup_client_) return false;
    return action_client_lookup_client_->action_server_is_ready();
}

// Action Server Feedback helper
void ActionNodeWrapper::publish_lookup_feedback(
    std::shared_ptr<GoalHandleLookupTransform> goal_handle,
    std::shared_ptr<LookupTransform::Feedback> feedback)
{
    if (goal_handle && feedback) {
        goal_handle->publish_feedback(feedback);
    }
}

// Dynamic parameter update handling


} // namespace golden_pkg
