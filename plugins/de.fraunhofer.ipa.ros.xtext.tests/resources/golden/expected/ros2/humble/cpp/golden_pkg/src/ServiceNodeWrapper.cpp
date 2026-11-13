#include "golden_pkg/ServiceNodeWrapper.hpp"

namespace golden_pkg {

ServiceNodeWrapper::ServiceNodeWrapper(const rclcpp::NodeOptions & options)
: rclcpp_lifecycle::LifecycleNode("service_node", options)
{
    client_cb_group_ = this->create_callback_group(rclcpp::CallbackGroupType::Reentrant);

    // ----------------------------------------------------
    // 1. Parameter Declarations (with and without defaults)
    // ----------------------------------------------------
    // ----------------------------------------------------
    // 2. Publishers Initialization
    // ----------------------------------------------------
    pub_heartbeat_ = this->create_publisher<std_msgs::msg::String>(
        "heartbeat", rclcpp::SystemDefaultsQoS());

    // ----------------------------------------------------
    // 3. Subscribers Initialization
    // ----------------------------------------------------

    // ----------------------------------------------------
    // 4. Service Servers Initialization
    // ----------------------------------------------------
    srv_reset_ = this->create_service<std_srvs::srv::Trigger>(
        "reset",
        [this](const std::shared_ptr<std_srvs::srv::Trigger::Request> req,
               std::shared_ptr<std_srvs::srv::Trigger::Response> res) {
            this->handle_reset(req, res);
        },
        rmw_qos_profile_services_default,
        client_cb_group_);

    // ----------------------------------------------------
    // 5. Service Clients Initialization
    // ----------------------------------------------------
    client_enable_client_ = this->create_client<std_srvs::srv::SetBool>(
        "enable_client", rmw_qos_profile_services_default, client_cb_group_);

    // ----------------------------------------------------
    // 6. Action Servers Initialization
    // ----------------------------------------------------

    // ----------------------------------------------------
    // 7. Action Clients Initialization
    // ----------------------------------------------------
}

// Outgoing Publisher implementations
void ServiceNodeWrapper::publish_heartbeat(const std_msgs::msg::String & msg) {
    if (pub_heartbeat_) {
        pub_heartbeat_->publish(msg);
    }
}

// Outgoing Service Client implementations
bool ServiceNodeWrapper::is_enable_client_ready(std::chrono::nanoseconds timeout) {
    return client_enable_client_->wait_for_service(timeout);
}

rclcpp::Client<ServiceNodeWrapper::SetBool>::SharedFuture 
ServiceNodeWrapper::call_enable_client_async(std::shared_ptr<SetBool::Request> request) {
    return client_enable_client_->async_send_request(request).future.share();
}

void ServiceNodeWrapper::call_enable_client_async(
    std::shared_ptr<SetBool::Request> request,
    std::function<void(rclcpp::Client<SetBool>::SharedFuture)> callback)
{
    if (!is_enable_client_ready(std::chrono::seconds(10))) {
        RCLCPP_ERROR(this->get_logger(), "Service 'enable_client' not available after waiting");
        return;
    }
    client_enable_client_->async_send_request(request, std::move(callback));
}

std::optional<ServiceNodeWrapper::SetBool::Response> 
ServiceNodeWrapper::call_enable_client_sync(
    const SetBool::Request & request,
    std::chrono::nanoseconds timeout)
{
    if (!is_enable_client_ready(timeout)) {
        RCLCPP_ERROR(this->get_logger(), "Service 'enable_client' is not available for sync call.");
        return std::nullopt;
    }
    auto req = std::make_shared<SetBool::Request>(request);
    auto future = client_enable_client_->async_send_request(req);
    if (future.wait_for(timeout) == std::future_status::ready) {
        return *future.get();
    }
    RCLCPP_ERROR(this->get_logger(), "Sync call to service 'enable_client' timed out.");
    return std::nullopt;
}

// Outgoing Action Client implementations

// Action Server Feedback helper

// Dynamic parameter update handling

ServiceNodeWrapper::CallbackReturn ServiceNodeWrapper::on_configure(const rclcpp_lifecycle::State & state)
{
    (void)state;
    RCLCPP_INFO(this->get_logger(), "Configuring node '%s'", this->get_name());
    return CallbackReturn::SUCCESS;
}

ServiceNodeWrapper::CallbackReturn ServiceNodeWrapper::on_activate(const rclcpp_lifecycle::State & state)
{
    (void)state;
    RCLCPP_INFO(this->get_logger(), "Activating node '%s'", this->get_name());
    if (pub_heartbeat_) {
        pub_heartbeat_->on_activate();
    }
    return CallbackReturn::SUCCESS;
}

ServiceNodeWrapper::CallbackReturn ServiceNodeWrapper::on_deactivate(const rclcpp_lifecycle::State & state)
{
    (void)state;
    RCLCPP_INFO(this->get_logger(), "Deactivating node '%s'", this->get_name());
    if (pub_heartbeat_) {
        pub_heartbeat_->on_deactivate();
    }
    return CallbackReturn::SUCCESS;
}

ServiceNodeWrapper::CallbackReturn ServiceNodeWrapper::on_cleanup(const rclcpp_lifecycle::State & state)
{
    (void)state;
    RCLCPP_INFO(this->get_logger(), "Cleaning up node '%s'", this->get_name());
    return CallbackReturn::SUCCESS;
}

ServiceNodeWrapper::CallbackReturn ServiceNodeWrapper::on_shutdown(const rclcpp_lifecycle::State & state)
{
    (void)state;
    RCLCPP_INFO(this->get_logger(), "Shutting down node '%s'", this->get_name());
    return CallbackReturn::SUCCESS;
}

ServiceNodeWrapper::CallbackReturn ServiceNodeWrapper::on_error(const rclcpp_lifecycle::State & state)
{
    (void)state;
    RCLCPP_ERROR(this->get_logger(), "Error in lifecycle node '%s'", this->get_name());
    return CallbackReturn::SUCCESS;
}

} // namespace golden_pkg
