#pragma once

#include <chrono>
#include <memory>
#include <thread>
#include "rclcpp/rclcpp.hpp"
#include "rclcpp/rate.hpp"
#include "golden_pkg/ServiceNodeWrapper.hpp"
#include "golden_pkg/ServiceNodeAlgorithm.hpp"

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
class ServiceNodeNode : public golden_pkg::ServiceNodeWrapper {
public:
    explicit ServiceNodeNode(const rclcpp::NodeOptions & options = rclcpp::NodeOptions())
    : ServiceNodeWrapper(options), algorithm_(std::make_shared<golden_pkg::ServiceNodeAlgorithm>())
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
                case golden_pkg::ServiceNodeAlgorithm::LogLevel::DEBUG:
                {
                    RCLCPP_DEBUG(this->get_logger(), "%s", msg.c_str());
                    break;
                };
                case golden_pkg::ServiceNodeAlgorithm::LogLevel::INFO:
                {
                    RCLCPP_INFO(this->get_logger(), "%s", msg.c_str());
                    break;
                };
                case golden_pkg::ServiceNodeAlgorithm::LogLevel::WARN:
                {
                    RCLCPP_WARN(this->get_logger(), "%s", msg.c_str());
                    break;
                };
                case golden_pkg::ServiceNodeAlgorithm::LogLevel::ERROR:
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
        algorithm_->set_heartbeat_publisher([this](const auto & msg) {
            this->publish_heartbeat(msg);
        });

        // Inject service client callers
        algorithm_->set_enable_client_client(
            [this](const auto & req, const auto & timeout) {
                return this->call_enable_client_sync(req, timeout);
            },
            [this](const auto & req, auto cb) {
                auto req_ptr = std::make_shared<SetBool::Request>(req);
                this->call_enable_client_async(req_ptr, [cb](auto future) {
                    if (cb) cb(*future.get());
                });
            }
        );

        // Inject action client callers
    }

protected:
    using CallbackReturn = golden_pkg::ServiceNodeWrapper::CallbackReturn;

    CallbackReturn on_configure(const rclcpp_lifecycle::State & state) override {
        (void)state;
        if (golden_pkg::ServiceNodeWrapper::on_configure(state) != CallbackReturn::SUCCESS) {
            return CallbackReturn::FAILURE;
        }
        return algorithm_->on_configure() ? CallbackReturn::SUCCESS : CallbackReturn::FAILURE;
    }

    CallbackReturn on_activate(const rclcpp_lifecycle::State & state) override {
        (void)state;
        if (golden_pkg::ServiceNodeWrapper::on_activate(state) != CallbackReturn::SUCCESS) {
            return CallbackReturn::FAILURE;
        }
        return algorithm_->on_activate() ? CallbackReturn::SUCCESS : CallbackReturn::FAILURE;
    }

    CallbackReturn on_deactivate(const rclcpp_lifecycle::State & state) override {
        (void)state;
        if (golden_pkg::ServiceNodeWrapper::on_deactivate(state) != CallbackReturn::SUCCESS) {
            return CallbackReturn::FAILURE;
        }
        return algorithm_->on_deactivate() ? CallbackReturn::SUCCESS : CallbackReturn::FAILURE;
    }

    CallbackReturn on_cleanup(const rclcpp_lifecycle::State & state) override {
        (void)state;
        if (golden_pkg::ServiceNodeWrapper::on_cleanup(state) != CallbackReturn::SUCCESS) {
            return CallbackReturn::FAILURE;
        }
        return algorithm_->on_cleanup() ? CallbackReturn::SUCCESS : CallbackReturn::FAILURE;
    }

    CallbackReturn on_shutdown(const rclcpp_lifecycle::State & state) override {
        (void)state;
        if (golden_pkg::ServiceNodeWrapper::on_shutdown(state) != CallbackReturn::SUCCESS) {
            return CallbackReturn::FAILURE;
        }
        return algorithm_->on_shutdown() ? CallbackReturn::SUCCESS : CallbackReturn::FAILURE;
    }

    CallbackReturn on_error(const rclcpp_lifecycle::State & state) override {
        (void)state;
        return algorithm_->on_error() ? CallbackReturn::SUCCESS : CallbackReturn::FAILURE;
    }


    void handle_reset(
        const std::shared_ptr<std_srvs::srv::Trigger::Request> req,
        std::shared_ptr<std_srvs::srv::Trigger::Response> res) override
    {
        algorithm_->handle_reset(*req, *res);
    }


private:
    std::shared_ptr<golden_pkg::ServiceNodeAlgorithm> algorithm_;
    golden_pkg::ServiceNodeAlgorithm::ParameterValue
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
