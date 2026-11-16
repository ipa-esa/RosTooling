#pragma once

#include <chrono>
#include <memory>
#include <thread>
#include "rclcpp/rclcpp.hpp"
#include "rclcpp/rate.hpp"
#include "golden_pkg/ActionNodeWrapper.hpp"
#include "golden_pkg/ActionNodeAlgorithm.hpp"

namespace golden_pkg {

/**
 * @brief Adapter wrapping rclcpp::Rate with the node's ROS clock
 */
class Ros2RateAdapter : public golden_pkg::Rate {
public:
    Ros2RateAdapter(double hz, rclcpp::Clock::SharedPtr clock)
    : rate_(hz, clock)
    {}

    bool sleep() override {
        return rate_.sleep();
    }

    void reset() override {
        rate_.reset();
    }

private:
    rclcpp::Rate rate_;
};

/**
 * @brief Default Derived Implementation coupling the pure algorithm with the ROS 2 wrapper
 */
class ActionNodeNode : public golden_pkg::ActionNodeWrapper {
public:
    explicit ActionNodeNode(const rclcpp::NodeOptions & options = rclcpp::NodeOptions())
    : ActionNodeWrapper(options), algorithm_(std::make_shared<golden_pkg::ActionNodeAlgorithm>())
    {
        // Inject simulation-synchronized timer factory
        algorithm_->set_timer_factory([this](auto period, auto callback) -> std::shared_ptr<void> {
            return this->create_wall_timer(period, callback);
        });

        // Inject simulation-synchronized rate factory using the Node's clock
        algorithm_->set_rate_factory([this](double hz) -> std::shared_ptr<golden_pkg::Rate> {
            return std::make_shared<Ros2RateAdapter>(hz, this->get_clock());
        });
        
        // Inject the ROS2 logger
        algorithm_->set_logger([this](auto log_level, const std::string & msg) {
            switch (log_level) {
                case golden_pkg::ActionNodeAlgorithm::LogLevel::DEBUG:
                {
                    RCLCPP_DEBUG(this->get_logger(), "%s", msg.c_str());
                    break;
                };
                case golden_pkg::ActionNodeAlgorithm::LogLevel::INFO:
                {
                    RCLCPP_INFO(this->get_logger(), "%s", msg.c_str());
                    break;
                };
                case golden_pkg::ActionNodeAlgorithm::LogLevel::WARN:
                {
                    RCLCPP_WARN(this->get_logger(), "%s", msg.c_str());
                    break;
                };
                case golden_pkg::ActionNodeAlgorithm::LogLevel::ERROR:
                {
                    RCLCPP_ERROR(this->get_logger(), "%s", msg.c_str());
                    break;
                };
            }
        });

        // Inject runtime liveness check
        algorithm_->set_ok_handler([]() {
            return rclcpp::ok();
        });

        // Inject runtime shutdown handler
        algorithm_->set_shutdown_handler([this](const std::string & reason) {
            if (!reason.empty()) {
                RCLCPP_INFO(this->get_logger(), "Shutdown requested by algorithm: %s", reason.c_str());
            }
            rclcpp::shutdown();
        });

        // Inject simulation-synchronized clock
        algorithm_->set_clock_handler([this]() -> std::chrono::nanoseconds {
            return std::chrono::nanoseconds(this->now().nanoseconds());
        });

        // Inject simulation-synchronized sleep
        algorithm_->set_sleep_handler([this](std::chrono::nanoseconds duration) -> bool {
            return this->get_clock()->sleep_for(rclcpp::Duration(duration));
        });
        
        // Inject params via setter

        // Inject publisher delegates

        // Inject service client callers

        // Inject action client callers
        algorithm_->set_lookup_client_client(
            [this](const auto & goal, auto resp_cb, auto fb_cb, auto res_cb, auto ... timeout_opt) {
                std::chrono::nanoseconds timeout = std::chrono::seconds(10);
                if constexpr (sizeof...(timeout_opt) > 0) {
                    timeout = std::chrono::duration_cast<std::chrono::nanoseconds>(
                        std::get<0>(std::forward_as_tuple(timeout_opt...)));
                }
                auto resp_adapter = [resp_cb](auto goal_handle) {
                    if (resp_cb) resp_cb(goal_handle != nullptr);
                };
                auto fb_adapter = [fb_cb](auto, auto fb_ptr) {
                    if (fb_cb && fb_ptr) fb_cb(*fb_ptr);
                };
                auto res_adapter = [res_cb](const auto & wrapped_result) {
                    if (!res_cb) return;
                    golden_pkg::GoalStatus status = golden_pkg::GoalStatus::UNKNOWN;
                    switch (wrapped_result.code) {
                        case rclcpp_action::ResultCode::SUCCEEDED:
                            status = golden_pkg::GoalStatus::SUCCEEDED;
                            break;
                        case rclcpp_action::ResultCode::ABORTED:
                            status = golden_pkg::GoalStatus::ABORTED;
                            break;
                        case rclcpp_action::ResultCode::CANCELED:
                            status = golden_pkg::GoalStatus::CANCELED;
                            break;
                        default:
                            status = golden_pkg::GoalStatus::UNKNOWN;
                            break;
                    }
                    using ResultT = std::decay_t<decltype(*wrapped_result.result)>;
                    if (wrapped_result.result) {
                        res_cb(status, *wrapped_result.result);
                    } else {
                        ResultT empty_result{};
                        res_cb(status, empty_result);
                    }
                };
                this->send_lookup_client_goal_async(goal, resp_adapter, fb_adapter, res_adapter, timeout);
            },
            [this]() {
                this->cancel_all_lookup_client_goals_async();
            }
        );
    }

protected:



    rclcpp_action::GoalResponse on_lookup_goal(
        const rclcpp_action::GoalUUID & uuid,
        std::shared_ptr<const LookupTransform::Goal> goal) override
    {
        (void)uuid;
        bool accept = algorithm_->handle_goal_lookup(*goal);
        return accept ? rclcpp_action::GoalResponse::ACCEPT_AND_EXECUTE
                      : rclcpp_action::GoalResponse::REJECT;
    }

    rclcpp_action::CancelResponse on_lookup_cancel(
        const std::shared_ptr<GoalHandleLookupTransform> goal_handle) override
    {
        (void)goal_handle;
        bool accept = algorithm_->handle_cancel_lookup();
        return accept ? rclcpp_action::CancelResponse::ACCEPT
                      : rclcpp_action::CancelResponse::REJECT;
    }

    void execute_lookup(
        const std::shared_ptr<GoalHandleLookupTransform> goal_handle) override
    {
        auto publish_fb = [goal_handle](const LookupTransform::Feedback & fb) {
            goal_handle->publish_feedback(std::make_shared<LookupTransform::Feedback>(fb));
        };
        auto is_canceling = [goal_handle]() {
            return goal_handle->is_canceling();
        };
        LookupTransform::Result result;
        bool success = algorithm_->execute_lookup(
            *goal_handle->get_goal(),
            publish_fb,
            is_canceling,
            result);
        auto res_ptr = std::make_shared<LookupTransform::Result>(result);
        if (goal_handle->is_canceling()) {
            goal_handle->canceled(res_ptr);
        } else if (success) {
            goal_handle->succeed(res_ptr);
        } else {
            goal_handle->abort(res_ptr);
        }
    }

private:
    std::shared_ptr<golden_pkg::ActionNodeAlgorithm> algorithm_;
    golden_pkg::ActionNodeAlgorithm::ParameterValue
        to_parameter_value(const rclcpp::Parameter & param)
    {
        switch (param.get_type()) {
            case rclcpp::ParameterType::PARAMETER_BOOL:
                return param.as_bool();
                case rclcpp::ParameterType::PARAMETER_INTEGER:
                return param.as_int();
            case rclcpp::ParameterType::PARAMETER_DOUBLE:
                return param.as_double();
            case rclcpp::ParameterType::PARAMETER_STRING:
                return param.as_string();
            case rclcpp::ParameterType::PARAMETER_BYTE_ARRAY:
                return param.as_byte_array();
            case rclcpp::ParameterType::PARAMETER_BOOL_ARRAY:
                return param.as_bool_array();
            case rclcpp::ParameterType::PARAMETER_INTEGER_ARRAY:
                return param.as_integer_array();
            case rclcpp::ParameterType::PARAMETER_DOUBLE_ARRAY:
                return param.as_double_array();
            case rclcpp::ParameterType::PARAMETER_STRING_ARRAY:
                return param.as_string_array();
            case rclcpp::ParameterType::PARAMETER_NOT_SET:
            default:
                return std::monostate{}; // or default fallback
        }        
    }
};

} // namespace golden_pkg
