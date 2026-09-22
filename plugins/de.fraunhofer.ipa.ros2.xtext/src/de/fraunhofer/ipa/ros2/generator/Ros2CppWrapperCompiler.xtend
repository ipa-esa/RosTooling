package de.fraunhofer.ipa.ros2.generator

import com.google.inject.Inject
import ros.Node
import ros.Package

class Ros2CppWrapperCompiler {

    @Inject extension Ros2GeneratorHelpers

    def String compileHeader(Package pkg, Node node) {
        compileHeader(pkg, node, toCamelCase(node.artifactName))
    }

    def String compileHeader(Package pkg, Node node, String artCamel) '''
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
«IF node.hasActions»
#include "rclcpp_action/rclcpp_action.hpp"
«ENDIF»

// ROS 2 Interface Message / Service / Action headers
«FOR pub : node.publisher»
#include "«pub.message.specPackage»/msg/«toSnakeCase(pub.message.specName)».hpp"
«ENDFOR»
«FOR sub : node.subscriber»
#include "«sub.message.specPackage»/msg/«toSnakeCase(sub.message.specName)».hpp"
«ENDFOR»
«FOR srv : node.serviceserver»
#include "«srv.service.specPackage»/srv/«toSnakeCase(srv.service.specName)».hpp"
«ENDFOR»
«FOR client : node.serviceclient»
#include "«client.service.specPackage»/srv/«toSnakeCase(client.service.specName)».hpp"
«ENDFOR»
«FOR act : node.actionserver»
#include "«act.action.specPackage»/action/«toSnakeCase(act.action.specName)».hpp"
«ENDFOR»
«FOR actClient : node.actionclient»
#include "«actClient.action.specPackage»/action/«toSnakeCase(actClient.action.specName)».hpp"
«ENDFOR»

namespace «pkg.name.toLowerCase» {

/**
 * @brief Generated ROS 2 Node wrapper for '«node.name»' (Artifact: '«node.artifactName»').
 * DO NOT DIRECTLY EDIT THIS FILE - it will be overwritten on generation.
 * Domain logic should inherit from this class or implement the pure virtual callbacks.
 */
class «artCamel»Wrapper : public rclcpp::Node {
public:
    explicit «artCamel»Wrapper(const rclcpp::NodeOptions & options = rclcpp::NodeOptions());
    virtual ~«artCamel»Wrapper() = default;

    // ==========================================
    // SUBSCRIBER CACHED DATA ACCESSORS
    // ==========================================
    «FOR sub : node.subscriber»
    /**
     * @brief Get the latest cached message received on topic '«sub.name»'
     */
    std::optional<«sub.message.specPackage»::msg::«sub.message.specName»> get_latest_«sanitizeName(sub.name)»_msg() const {
        std::lock_guard<std::mutex> lock(sub_«sanitizeName(sub.name)»_mutex_);
        return latest_sub_«sanitizeName(sub.name)»_msg_;
    }

    /**
     * @brief Check if a new unread message has arrived on topic '«sub.name»'
     */
    bool has_new_«sanitizeName(sub.name)»_msg() const {
        std::lock_guard<std::mutex> lock(sub_«sanitizeName(sub.name)»_mutex_);
        return has_new_sub_«sanitizeName(sub.name)»_msg_;
    }

    /**
     * @brief Retrieve and clear the new message flag for topic '«sub.name»'
     */
    std::optional<«sub.message.specPackage»::msg::«sub.message.specName»> take_latest_«sanitizeName(sub.name)»_msg() {
        std::lock_guard<std::mutex> lock(sub_«sanitizeName(sub.name)»_mutex_);
        has_new_sub_«sanitizeName(sub.name)»_msg_ = false;
        return latest_sub_«sanitizeName(sub.name)»_msg_;
    }

    «ENDFOR»
protected:
    // ==========================================
    // INCOMING INTERFACE HOOKS (Implemented by Core Logic)
    // ==========================================

    «FOR sub : node.subscriber»
    /**
     * @brief Inbound subscriber callback hook for topic '«sub.name»'
     */
    virtual void on_«sanitizeName(sub.name)»_msg(
        const «sub.message.specPackage»::msg::«sub.message.specName»::SharedPtr msg) {
        	(void)msg;
        	RCLCPP_ERROR(this->get_logger(), "The abstract method on_«sanitizeName(sub.name)» needs to be overriden!");
        };

    «ENDFOR»
    «FOR srv : node.serviceserver»
    /**
     * @brief Inbound service handler hook for service '«srv.name»'
     */
    virtual void handle_«sanitizeName(srv.name)»(
        const std::shared_ptr<«srv.service.specPackage»::srv::«srv.service.specName»::Request> request,
        std::shared_ptr<«srv.service.specPackage»::srv::«srv.service.specName»::Response> response) {
        	(void)request;
        	(void)response;
        	RCLCPP_ERROR(this->get_logger(), "The abstract method handle_«sanitizeName(srv.name)» needs to be overriden!");
        };

    «ENDFOR»
    «FOR act : node.actionserver»
    using «act.action.specName» = «act.action.specPackage»::action::«act.action.specName»;
    using GoalHandle«act.action.specName» = rclcpp_action::ServerGoalHandle<«act.action.specName»>;

    /**
     * @brief Goal callback hook for Action '«act.name»' (Defaults to ACCEPT_AND_EXECUTE)
     */
    virtual rclcpp_action::GoalResponse on_«sanitizeName(act.name)»_goal(
        const rclcpp_action::GoalUUID & uuid,
        std::shared_ptr<const «act.action.specName»::Goal> goal)
    {
        (void)uuid;
        (void)goal;
        return rclcpp_action::GoalResponse::ACCEPT_AND_EXECUTE;
    }

    /**
     * @brief Cancel callback hook for Action '«act.name»' (Defaults to ACCEPT)
     */
    virtual rclcpp_action::CancelResponse on_«sanitizeName(act.name)»_cancel(
        const std::shared_ptr<GoalHandle«act.action.specName»> goal_handle)
    {
        (void)goal_handle;
        return rclcpp_action::CancelResponse::ACCEPT;
    }

    /**
     * @brief Execute callback for Action '«act.name»' - Pure virtual (Domain execution logic)
     */
    virtual void execute_«sanitizeName(act.name)»(
        const std::shared_ptr<GoalHandle«act.action.specName»> goal_handle) {
        	(void)goal_handle;
        	RCLCPP_ERROR(this->get_logger(), "The abstract method execute_«sanitizeName(act.name)» needs to be overriden!");        	
        };

    «ENDFOR»
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

    «FOR pub : node.publisher»
    /**
     * @brief Publish message to topic '«pub.name»'
     */
    void publish_«sanitizeName(pub.name)»(const «pub.message.specPackage»::msg::«pub.message.specName» & msg);

    «ENDFOR»
    «FOR client : node.serviceclient»
    using «client.service.specName» = «client.service.specPackage»::srv::«client.service.specName»;

    /**
     * @brief Check if service '«client.name»' is available
     */
    bool is_«sanitizeName(client.name)»_ready(std::chrono::nanoseconds timeout = std::chrono::nanoseconds(1000));

    /**
     * @brief Asynchronous call to service '«client.name»' returning a SharedFuture
     */
    rclcpp::Client<«client.service.specName»>::SharedFuture call_«sanitizeName(client.name)»_async(
        std::shared_ptr<«client.service.specName»::Request> request);

    /**
     * @brief Asynchronous call to service '«client.name»' with completion callback
     */
    void call_«sanitizeName(client.name)»_async(
        std::shared_ptr<«client.service.specName»::Request> request,
        std::function<void(rclcpp::Client<«client.service.specName»>::SharedFuture)> callback);

    /**
     * @brief Thread-safe Synchronous call to service '«client.name»' with timeout
     */
    std::optional<«client.service.specName»::Response> call_«sanitizeName(client.name)»_sync(
        const «client.service.specName»::Request & request,
        std::chrono::nanoseconds timeout = std::chrono::nanoseconds(5000));

    «ENDFOR»
    «FOR actClient : node.actionclient»
    using «actClient.action.specName»Client = «actClient.action.specPackage»::action::«actClient.action.specName»;
    using ClientGoalHandle«actClient.action.specName» = rclcpp_action::ClientGoalHandle<«actClient.action.specName»Client>;

    /**
     * @brief Asynchronously send goal to Action '«actClient.name»'
     */
    std::shared_future<ClientGoalHandle«actClient.action.specName»::SharedPtr> send_«sanitizeName(actClient.name)»_goal_async(
        const «actClient.action.specName»Client::Goal & goal,
        std::function<void(ClientGoalHandle«actClient.action.specName»::SharedPtr, const std::shared_ptr<const «actClient.action.specName»Client::Feedback>)> feedback_cb = nullptr,
        std::function<void(const ClientGoalHandle«actClient.action.specName»::WrappedResult &)> result_cb = nullptr);

    /**
     * @brief Cancel active goal for Action '«actClient.name»'
     */
    void cancel_«sanitizeName(actClient.name)»_goal_async(
        std::shared_ptr<ClientGoalHandle«actClient.action.specName»> goal_handle);

    «ENDFOR»
    «FOR act : node.actionserver»
    /**
     * @brief Publish feedback for Action server '«act.name»'
     */
    void publish_«sanitizeName(act.name)»_feedback(
        std::shared_ptr<GoalHandle«act.action.specName»> goal_handle,
        std::shared_ptr<«act.action.specName»::Feedback> feedback);

    «ENDFOR»
    // ==========================================
    // PARAMETER ACCESSORS
    // ==========================================

    «FOR param : node.parameter»
    «val cppType = getCppType(param.type)»
    «val defaultVal = getParamDefaultValueCpp(param)»
    «IF defaultVal !== null»
    «cppType» get_param_«sanitizeName(param.name)»() const { return param_«sanitizeName(param.name)»_; }
    «ELSE»
    std::optional<«cppType»> get_param_«sanitizeName(param.name)»() const { return param_«sanitizeName(param.name)»_; }
    bool has_param_«sanitizeName(param.name)»() const { return param_«sanitizeName(param.name)»_.has_value(); }
    «ENDIF»
    «ENDFOR»

private:
    rclcpp::CallbackGroup::SharedPtr client_cb_group_;
    OnSetParametersCallbackHandle::SharedPtr param_cb_handle_;

    // ROS 2 interface handles
    «FOR pub : node.publisher»
    rclcpp::Publisher<«pub.message.specPackage»::msg::«pub.message.specName»>::SharedPtr pub_«sanitizeName(pub.name)»_;
    «ENDFOR»
    «FOR sub : node.subscriber»
    rclcpp::Subscription<«sub.message.specPackage»::msg::«sub.message.specName»>::SharedPtr sub_«sanitizeName(sub.name)»_;
    mutable std::mutex sub_«sanitizeName(sub.name)»_mutex_;
    std::optional<«sub.message.specPackage»::msg::«sub.message.specName»> latest_sub_«sanitizeName(sub.name)»_msg_;
    bool has_new_sub_«sanitizeName(sub.name)»_msg_{false};
    «ENDFOR»
    «FOR srv : node.serviceserver»
    rclcpp::Service<«srv.service.specPackage»::srv::«srv.service.specName»>::SharedPtr srv_«sanitizeName(srv.name)»_;
    «ENDFOR»
    «FOR client : node.serviceclient»
    rclcpp::Client<«client.service.specPackage»::srv::«client.service.specName»>::SharedPtr client_«sanitizeName(client.name)»_;
    «ENDFOR»
    «FOR act : node.actionserver»
    rclcpp_action::Server<«act.action.specPackage»::action::«act.action.specName»>::SharedPtr action_server_«sanitizeName(act.name)»_;
    «ENDFOR»
    «FOR actClient : node.actionclient»
    rclcpp_action::Client<«actClient.action.specPackage»::action::«actClient.action.specName»>::SharedPtr action_client_«sanitizeName(actClient.name)»_;
    «ENDFOR»

    // Internal parameter values
    «FOR param : node.parameter»
    «val cppType = getCppType(param.type)»
    «val defaultVal = getParamDefaultValueCpp(param)»
    «IF defaultVal !== null»
    «cppType» param_«sanitizeName(param.name)»_{«defaultVal»};
    «ELSE»
    std::optional<«cppType»> param_«sanitizeName(param.name)»_;
    «ENDIF»
    «ENDFOR»

    rcl_interfaces::msg::SetParametersResult internal_on_set_parameters(
        const std::vector<rclcpp::Parameter> & parameters);
};

} // namespace «pkg.name.toLowerCase»
'''

    def String compileSource(Package pkg, Node node) {
        compileSource(pkg, node, toCamelCase(node.artifactName))
    }

    def String compileSource(Package pkg, Node node, String artCamel) '''
#include "«pkg.name.toLowerCase»/«artCamel»Wrapper.hpp"

namespace «pkg.name.toLowerCase» {

«artCamel»Wrapper::«artCamel»Wrapper(const rclcpp::NodeOptions & options)
: rclcpp::Node("«node.name»", options)
{
    client_cb_group_ = this->create_callback_group(rclcpp::CallbackGroupType::Reentrant);

    // ----------------------------------------------------
    // 1. Parameter Declarations (with and without defaults)
    // ----------------------------------------------------
    «FOR param : node.parameter»
    «val cppType = getCppType(param.type)»
    «val defaultVal = getParamDefaultValueCpp(param)»
    {
        rcl_interfaces::msg::ParameterDescriptor desc;
        desc.description = "Parameter '«param.name»' modelled in RosTooling";
        desc.read_only = false;
        «IF defaultVal !== null»
        this->declare_parameter<«cppType»>("«param.name»", «defaultVal», desc);
        this->get_parameter("«param.name»", param_«sanitizeName(param.name)»_);
        «ELSE»
        // Typed declaration without default value (supplied via launch file / .rossystem at runtime)
        this->declare_parameter<«cppType»>("«param.name»", desc);
        «cppType» loaded_val;
        if (this->get_parameter("«param.name»", loaded_val)) {
            param_«sanitizeName(param.name)»_ = loaded_val;
        } else {
            RCLCPP_WARN(this->get_logger(), "Parameter '«param.name»' not provided at startup; remains uninitialized.");
        }
        «ENDIF»
    }
    «ENDFOR»

    param_cb_handle_ = this->add_on_set_parameters_callback(
        std::bind(&«artCamel»Wrapper::internal_on_set_parameters, this, std::placeholders::_1));

    // ----------------------------------------------------
    // 2. Publishers Initialization
    // ----------------------------------------------------
    «FOR pub : node.publisher»
    pub_«sanitizeName(pub.name)»_ = this->create_publisher<«pub.message.specPackage»::msg::«pub.message.specName»>(
        "«pub.name»", «getQosCpp(pub.qos)»);
    «ENDFOR»

    // ----------------------------------------------------
    // 3. Subscribers Initialization
    // ----------------------------------------------------
    «FOR sub : node.subscriber»
    sub_«sanitizeName(sub.name)»_ = this->create_subscription<«sub.message.specPackage»::msg::«sub.message.specName»>(
        "«sub.name»", «getQosCpp(sub.qos)»,
        [this](const «sub.message.specPackage»::msg::«sub.message.specName»::SharedPtr msg) {
            {
                std::lock_guard<std::mutex> lock(sub_«sanitizeName(sub.name)»_mutex_);
                latest_sub_«sanitizeName(sub.name)»_msg_ = *msg;
                has_new_sub_«sanitizeName(sub.name)»_msg_ = true;
            }
            this->on_«sanitizeName(sub.name)»_msg(msg);
        });
    «ENDFOR»

    // ----------------------------------------------------
    // 4. Service Servers Initialization
    // ----------------------------------------------------
    «FOR srv : node.serviceserver»
    srv_«sanitizeName(srv.name)»_ = this->create_service<«srv.service.specPackage»::srv::«srv.service.specName»>(
        "«srv.name»",
        [this](const std::shared_ptr<«srv.service.specPackage»::srv::«srv.service.specName»::Request> req,
               std::shared_ptr<«srv.service.specPackage»::srv::«srv.service.specName»::Response> res) {
            this->handle_«sanitizeName(srv.name)»(req, res);
        },
        rmw_qos_profile_services_default,
        client_cb_group_);
    «ENDFOR»

    // ----------------------------------------------------
    // 5. Service Clients Initialization
    // ----------------------------------------------------
    «FOR client : node.serviceclient»
    client_«sanitizeName(client.name)»_ = this->create_client<«client.service.specPackage»::srv::«client.service.specName»>(
        "«client.name»", rmw_qos_profile_services_default, client_cb_group_);
    «ENDFOR»

    // ----------------------------------------------------
    // 6. Action Servers Initialization
    // ----------------------------------------------------
    «FOR act : node.actionserver»
    action_server_«sanitizeName(act.name)»_ = rclcpp_action::create_server<«act.action.specName»>(
        this,
        "«act.name»",
        std::bind(&«artCamel»Wrapper::on_«sanitizeName(act.name)»_goal, this, std::placeholders::_1, std::placeholders::_2),
        std::bind(&«artCamel»Wrapper::on_«sanitizeName(act.name)»_cancel, this, std::placeholders::_1),
        [this](const std::shared_ptr<GoalHandle«act.action.specName»> handle) {
            std::thread([this, handle]() {
                this->execute_«sanitizeName(act.name)»(handle);
            }).detach();
        });
    «ENDFOR»

    // ----------------------------------------------------
    // 7. Action Clients Initialization
    // ----------------------------------------------------
    «FOR actClient : node.actionclient»
    action_client_«sanitizeName(actClient.name)»_ = rclcpp_action::create_client<«actClient.action.specName»Client>(
        this, "«actClient.name»");
    «ENDFOR»
}

// Outgoing Publisher implementations
«FOR pub : node.publisher»
void «artCamel»Wrapper::publish_«sanitizeName(pub.name)»(const «pub.message.specPackage»::msg::«pub.message.specName» & msg) {
    if (pub_«sanitizeName(pub.name)»_) {
        pub_«sanitizeName(pub.name)»_->publish(msg);
    }
}
«ENDFOR»

// Outgoing Service Client implementations
«FOR client : node.serviceclient»
bool «artCamel»Wrapper::is_«sanitizeName(client.name)»_ready(std::chrono::nanoseconds timeout) {
    return client_«sanitizeName(client.name)»_->wait_for_service(timeout);
}

rclcpp::Client<«artCamel»Wrapper::«client.service.specName»>::SharedFuture 
«artCamel»Wrapper::call_«sanitizeName(client.name)»_async(std::shared_ptr<«client.service.specName»::Request> request) {
    return client_«sanitizeName(client.name)»_->async_send_request(request);
}

void «artCamel»Wrapper::call_«sanitizeName(client.name)»_async(
    std::shared_ptr<«client.service.specName»::Request> request,
    std::function<void(rclcpp::Client<«client.service.specName»>::SharedFuture)> callback)
{
    client_«sanitizeName(client.name)»_->async_send_request(request, std::move(callback));
}

std::optional<«artCamel»Wrapper::«client.service.specName»::Response> 
«artCamel»Wrapper::call_«sanitizeName(client.name)»_sync(
    const «client.service.specName»::Request & request,
    std::chrono::nanoseconds timeout)
{
    if (!is_«sanitizeName(client.name)»_ready(std::chrono::nanoseconds(500))) {
        RCLCPP_ERROR(this->get_logger(), "Service '«client.name»' is not available for sync call.");
        return std::nullopt;
    }
    auto req = std::make_shared<«client.service.specName»::Request>(request);
    auto future = client_«sanitizeName(client.name)»_->async_send_request(req);
    if (future.wait_for(timeout) == std::future_status::ready) {
        return *future.get();
    }
    RCLCPP_ERROR(this->get_logger(), "Sync call to service '«client.name»' timed out.");
    return std::nullopt;
}
«ENDFOR»

// Outgoing Action Client implementations
«FOR actClient : node.actionclient»
std::shared_future<«artCamel»Wrapper::ClientGoalHandle«actClient.action.specName»::SharedPtr> 
«artCamel»Wrapper::send_«sanitizeName(actClient.name)»_goal_async(
    const «actClient.action.specName»Client::Goal & goal,
    std::function<void(ClientGoalHandle«actClient.action.specName»::SharedPtr, const std::shared_ptr<const «actClient.action.specName»Client::Feedback>)> feedback_cb,
    std::function<void(const ClientGoalHandle«actClient.action.specName»::WrappedResult &)> result_cb)
{
    auto send_goal_options = rclcpp_action::Client<«actClient.action.specName»Client>::SendGoalOptions();
    if (feedback_cb) send_goal_options.feedback_callback = feedback_cb;
    if (result_cb) send_goal_options.result_callback = result_cb;
    return action_client_«sanitizeName(actClient.name)»_->async_send_goal(goal, send_goal_options);
}

void «artCamel»Wrapper::cancel_«sanitizeName(actClient.name)»_goal_async(
    std::shared_ptr<ClientGoalHandle«actClient.action.specName»> goal_handle)
{
    if (action_client_«sanitizeName(actClient.name)»_ && goal_handle) {
        action_client_«sanitizeName(actClient.name)»_->async_cancel_goal(goal_handle);
    }
}
«ENDFOR»

// Action Server Feedback helper
«FOR act : node.actionserver»
void «artCamel»Wrapper::publish_«sanitizeName(act.name)»_feedback(
    std::shared_ptr<GoalHandle«act.action.specName»> goal_handle,
    std::shared_ptr<«act.action.specName»::Feedback> feedback)
{
    if (goal_handle && feedback) {
        goal_handle->publish_feedback(feedback);
    }
}
«ENDFOR»

// Dynamic parameter update handling
rcl_interfaces::msg::SetParametersResult «artCamel»Wrapper::internal_on_set_parameters(
    const std::vector<rclcpp::Parameter> & parameters)
{
    auto validation_res = this->on_parameters_changed(parameters);
    if (!validation_res.successful) {
        return validation_res;
    }
    for (const auto & param : parameters) {
        «FOR param : node.parameter»
        «val cppType = getCppType(param.type)»
        if (param.get_name() == "«param.name»") {
            param_«sanitizeName(param.name)»_ = param.get_value<«cppType»>();
            RCLCPP_INFO(this->get_logger(), "Parameter '«param.name»' dynamically updated.");
        }
        «ENDFOR»
    }
    rcl_interfaces::msg::SetParametersResult res;
    res.successful = true;
    return res;
}

} // namespace «pkg.name.toLowerCase»
'''

    def String compileCoreLogicStub(Package pkg, Node node) {
        compileCoreLogicStub(pkg, node, toCamelCase(node.artifactName))
    }

    def String compileCoreLogicStub(Package pkg, Node node, String artCamel) '''
#pragma once

#include <iostream>
#include <memory>
#include <string>
#include <vector>
#include <optional>
#include <functional>
#include <chrono>

// Interface message/service/action headers for pure data structs
«FOR pub : node.publisher»
#include "«pub.message.specPackage»/msg/«toSnakeCase(pub.message.specName)».hpp"
«ENDFOR»
«FOR sub : node.subscriber»
#include "«sub.message.specPackage»/msg/«toSnakeCase(sub.message.specName)».hpp"
«ENDFOR»
«FOR srv : node.serviceserver»
#include "«srv.service.specPackage»/srv/«toSnakeCase(srv.service.specName)».hpp"
«ENDFOR»
«FOR client : node.serviceclient»
#include "«client.service.specPackage»/srv/«toSnakeCase(client.service.specName)».hpp"
«ENDFOR»
«FOR act : node.actionserver»
#include "«act.action.specPackage»/action/«toSnakeCase(act.action.specName)».hpp"
«ENDFOR»
«FOR actClient : node.actionclient»
#include "«actClient.action.specPackage»/action/«toSnakeCase(actClient.action.specName)».hpp"
«ENDFOR»

namespace «pkg.name.toLowerCase» {

/**
 * @brief Pure Core Logic class for '«node.name»' (Artifact: '«node.artifactName»').
 * Contains ZERO ROS 2 runtime node / executor dependencies!
 * Implement your business logic, algorithms, and signal handling here.
 * This file is generated once and will NEVER be overwritten.
 */
class «artCamel»Algorithm {
public:
    «artCamel»Algorithm() = default;
    virtual ~«artCamel»Algorithm() = default;

    // ==========================================
    // 1. INBOUND SUBSCRIBER MESSAGE HANDLERS
    // ==========================================
    «FOR sub : node.subscriber»
    /**
     * @brief Callback invoked when a new message is received on topic '«sub.name»'
     */
    virtual void on_«sanitizeName(sub.name)»_received(const «sub.message.specPackage»::msg::«sub.message.specName» & msg) {
        (void)msg;
        // TODO: Process incoming message data
    }

    «ENDFOR»
    // ==========================================
    // 2. INBOUND SERVICE REQUEST HANDLERS
    // ==========================================
    «FOR srv : node.serviceserver»
    /**
     * @brief Handler for service '«srv.name»'
     * @return true if successfully processed, false to indicate failure
     */
    virtual bool handle_«sanitizeName(srv.name)»(
        const «srv.service.specPackage»::srv::«srv.service.specName»::Request & req,
        «srv.service.specPackage»::srv::«srv.service.specName»::Response & res)
    {
        (void)req;
        (void)res;
        // TODO: Process request fields and populate response fields
        return true;
    }

    «ENDFOR»
    // ==========================================
    // 3. INBOUND ACTION SERVER HANDLERS
    // ==========================================
    «FOR act : node.actionserver»
    using «act.action.specName»Goal = «act.action.specPackage»::action::«act.action.specName»::Goal;
    using «act.action.specName»Feedback = «act.action.specPackage»::action::«act.action.specName»::Feedback;
    using «act.action.specName»Result = «act.action.specPackage»::action::«act.action.specName»::Result;

    /**
     * @brief Decides whether to accept or reject a goal request for action '«act.name»'
     * @return true to accept and execute, false to reject
     */
    virtual bool handle_goal_«sanitizeName(act.name)»(const «act.action.specName»Goal & goal) {
        (void)goal;
        return true; // Default: accept all valid goals
    }

    /**
     * @brief Decides whether to accept or reject a cancellation request for action '«act.name»'
     * @return true to accept cancellation, false to reject
     */
    virtual bool handle_cancel_«sanitizeName(act.name)»() {
        return true; // Default: accept cancellation
    }

    /**
     * @brief Executes the accepted goal for action '«act.name»'
     * @param goal The accepted goal parameters
     * @param publish_feedback Stream intermediate progress updates
     * @param is_canceling Check if the action client requested cancellation
     * @param result Output result to populate
     * @return true if goal succeeded, false if aborted
     */
    virtual bool execute_«sanitizeName(act.name)»(
        const «act.action.specName»Goal & goal,
        std::function<void(const «act.action.specName»Feedback &)> publish_feedback,
        std::function<bool()> is_canceling,
        «act.action.specName»Result & result)
    {
        (void)goal;
        (void)publish_feedback;
        (void)is_canceling;
        (void)result;
        // TODO: Implement long-running execution logic
        return true;
    }

    «ENDFOR»
    // ==========================================
    // 4. OUTBOUND PUBLISHER METHODS
    // ==========================================
    «FOR pub : node.publisher»
    using «pub.name»PubFn = std::function<void(const «pub.message.specPackage»::msg::«pub.message.specName» &)>;
    void set_«sanitizeName(pub.name)»_publisher(«pub.name»PubFn fn) { publish_«sanitizeName(pub.name)»_fn_ = fn; }
    void publish_«sanitizeName(pub.name)»(const «pub.message.specPackage»::msg::«pub.message.specName» & msg) {
        if (publish_«sanitizeName(pub.name)»_fn_) publish_«sanitizeName(pub.name)»_fn_(msg);
    }

    «ENDFOR»
    // ==========================================
    // 5. OUTBOUND SERVICE CLIENT CALLERS
    // ==========================================
    «FOR client : node.serviceclient»
    using «client.name»SyncCaller = std::function<std::optional<«client.service.specPackage»::srv::«client.service.specName»::Response>(const «client.service.specPackage»::srv::«client.service.specName»::Request &)>;
    using «client.name»AsyncCaller = std::function<void(const «client.service.specPackage»::srv::«client.service.specName»::Request &, std::function<void(const «client.service.specPackage»::srv::«client.service.specName»::Response &)>)>;

    void set_«sanitizeName(client.name)»_client(«client.name»SyncCaller sync_fn, «client.name»AsyncCaller async_fn) {
        call_«sanitizeName(client.name)»_sync_fn_ = sync_fn;
        call_«sanitizeName(client.name)»_async_fn_ = async_fn;
    }

    std::optional<«client.service.specPackage»::srv::«client.service.specName»::Response> call_«sanitizeName(client.name)»_sync(
        const «client.service.specPackage»::srv::«client.service.specName»::Request & req)
    {
        if (call_«sanitizeName(client.name)»_sync_fn_) return call_«sanitizeName(client.name)»_sync_fn_(req);
        return std::nullopt;
    }

    void call_«sanitizeName(client.name)»_async(
        const «client.service.specPackage»::srv::«client.service.specName»::Request & req,
        std::function<void(const «client.service.specPackage»::srv::«client.service.specName»::Response &)> cb)
    {
        if (call_«sanitizeName(client.name)»_async_fn_) call_«sanitizeName(client.name)»_async_fn_(req, cb);
    }

    «ENDFOR»
    // ==========================================
    // 6. OUTBOUND ACTION CLIENT CALLERS
    // ==========================================
    «FOR actClient : node.actionclient»
    using «actClient.name»GoalCaller = std::function<void(
        const «actClient.action.specPackage»::action::«actClient.action.specName»::Goal &,
        std::function<void(const «actClient.action.specPackage»::action::«actClient.action.specName»::Feedback &)>,
        std::function<void(const «actClient.action.specPackage»::action::«actClient.action.specName»::Result &)>)>;
    using «actClient.name»CancelCaller = std::function<void()>;

    void set_«sanitizeName(actClient.name)»_client(«actClient.name»GoalCaller goal_fn, «actClient.name»CancelCaller cancel_fn) {
        send_«sanitizeName(actClient.name)»_goal_fn_ = goal_fn;
        cancel_«sanitizeName(actClient.name)»_goal_fn_ = cancel_fn;
    }

    void send_«sanitizeName(actClient.name)»_goal_async(
        const «actClient.action.specPackage»::action::«actClient.action.specName»::Goal & goal,
        std::function<void(const «actClient.action.specPackage»::action::«actClient.action.specName»::Feedback &)> feedback_cb = nullptr,
        std::function<void(const «actClient.action.specPackage»::action::«actClient.action.specName»::Result &)> result_cb = nullptr)
    {
        if (send_«sanitizeName(actClient.name)»_goal_fn_) send_«sanitizeName(actClient.name)»_goal_fn_(goal, feedback_cb, result_cb);
    }

    void cancel_«sanitizeName(actClient.name)»_goal_async() {
        if (cancel_«sanitizeName(actClient.name)»_goal_fn_) cancel_«sanitizeName(actClient.name)»_goal_fn_();
    }

    «ENDFOR»
    // ==========================================
    // 7. TIMER FACTORY INTERFACE
    // ==========================================
    using TimerHandle = std::shared_ptr<void>;
    using TimerFactory = std::function<TimerHandle(std::chrono::nanoseconds, std::function<void()>)>;

    /**
     * @brief Injects the platform/ROS timer creation factory.
     */
    void set_timer_factory(TimerFactory factory) {
        timer_factory_ = factory;
    }

    /**
     * @brief Spawns a periodic timer driven by the node executor (respects simulation time /clock).
     * @tparam Rep Duration representation
     * @tparam Period Duration ratio
     * @param period Timer interval duration (e.g. std::chrono::milliseconds(100))
     * @param callback Callback executed on every tick
     * @return TimerHandle RAII handle keeping the timer alive
     */
    template <typename Rep, typename Period>
    TimerHandle create_timer(std::chrono::duration<Rep, Period> period, std::function<void()> callback) {
        if (timer_factory_) {
            return timer_factory_(std::chrono::duration_cast<std::chrono::nanoseconds>(period), callback);
        }
        return nullptr;
    }

    /**
     * @brief Spawns a periodic timer specified in fractional seconds (e.g. 0.5 for 500ms).
     * @param period_seconds Timer interval in seconds
     * @param callback Callback executed on every tick
     * @return TimerHandle RAII handle keeping the timer alive
     */
    TimerHandle create_timer(double period_seconds, std::function<void()> callback) {
        if (timer_factory_) {
            auto nanos = std::chrono::duration_cast<std::chrono::nanoseconds>(
                std::chrono::duration<double>(period_seconds)
            );
            return timer_factory_(nanos, callback);
        }
        return nullptr;
    }
    // ==========================================
    // 8. LOGGER FACTORY INTERFACE
    // ==========================================
    enum class LogLevel {
        DEBUG,
        INFO,
        WARN,
        ERROR
    };
     
    using LogFunction = std::function<void(LogLevel level, const std::string & message)>;

    /**
     *@brief Injects the ROS/platform logger macro.
     */
    void set_logger(LogFunction logger_func) {
        logger_ = logger_func;
    }

    /**
    * @brief Logs a debug level message via platform logger
    * @param message the std::string to be logged
    */
    void log_debug(const std::string & message) {
        logger_(LogLevel::DEBUG, message);
    }
    /**
    * @brief Logs an info level message via platform logger
    * @param message the std::string to be logged
    */
    void log_info(const std::string & message) {
        logger_(LogLevel::INFO, message);
    }
    /**
    * @brief Logs a warn level message via platform logger
    * @param message the std::string to be logged
    */
    void log_warn(const std::string & message) {
        logger_(LogLevel::WARN, message);
    }
    /**
    * @brief Logs an error level message via platform logger
    * @param message the std::string to be logged
    */
    void log_error(const std::string & message) {
        logger_(LogLevel::ERROR, message);
    }
    
private:
    TimerFactory timer_factory_;
    LogFunction logger_;
    «FOR pub : node.publisher»
    «pub.name»PubFn publish_«sanitizeName(pub.name)»_fn_;
    «ENDFOR»
    «FOR client : node.serviceclient»
    «client.name»SyncCaller call_«sanitizeName(client.name)»_sync_fn_;
    «client.name»AsyncCaller call_«sanitizeName(client.name)»_async_fn_;
    «ENDFOR»
    «FOR actClient : node.actionclient»
    «actClient.name»GoalCaller send_«sanitizeName(actClient.name)»_goal_fn_;
    «actClient.name»CancelCaller cancel_«sanitizeName(actClient.name)»_goal_fn_;
    «ENDFOR»
};

} // namespace «pkg.name.toLowerCase»
'''

}
