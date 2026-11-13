#pragma once

#include <chrono>
#include <memory>
#include <thread>
#include "rclcpp/rclcpp.hpp"
#include "rclcpp/rate.hpp"
#include "golden_pkg/IoNodeWrapper.hpp"
#include "golden_pkg/IoNodeAlgorithm.hpp"

namespace golden_pkg {

/**
 * @brief Rate on the node's ROS clock, built on rclcpp::Clock::sleep_until
 * (this distribution's rclcpp::Rate only supports the wall clock)
 */
class Ros2RateAdapter : public golden_pkg::Rate {
public:
    Ros2RateAdapter(double hz, rclcpp::Clock::SharedPtr clock)
    : clock_(clock),
      period_(rclcpp::Duration::from_seconds(1.0 / hz)),
      next_(clock->now() + period_)
    {}

    bool sleep() override {
        const rclcpp::Time now = clock_->now();
        if (next_ < now) {
            // Missed the deadline: realign to the period instead of catching up.
            next_ = now + period_;
            return false;
        }
        const bool slept = clock_->sleep_until(next_);
        next_ = next_ + period_;
        return slept;
    }

    void reset() override {
        next_ = clock_->now() + period_;
    }

private:
    rclcpp::Clock::SharedPtr clock_;
    rclcpp::Duration period_;
    rclcpp::Time next_;
};

/**
 * @brief Default Derived Implementation coupling the pure algorithm with the ROS 2 wrapper
 */
class IoNodeNode : public golden_pkg::IoNodeWrapper {
public:
    explicit IoNodeNode(const rclcpp::NodeOptions & options = rclcpp::NodeOptions())
    : IoNodeWrapper(options), algorithm_(std::make_shared<golden_pkg::IoNodeAlgorithm>())
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
                case golden_pkg::IoNodeAlgorithm::LogLevel::DEBUG:
                {
                    RCLCPP_DEBUG(this->get_logger(), "%s", msg.c_str());
                    break;
                };
                case golden_pkg::IoNodeAlgorithm::LogLevel::INFO:
                {
                    RCLCPP_INFO(this->get_logger(), "%s", msg.c_str());
                    break;
                };
                case golden_pkg::IoNodeAlgorithm::LogLevel::WARN:
                {
                    RCLCPP_WARN(this->get_logger(), "%s", msg.c_str());
                    break;
                };
                case golden_pkg::IoNodeAlgorithm::LogLevel::ERROR:
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
        algorithm_->set_parameter("rate_hz", this->get_param_rate_hz());
        algorithm_->set_parameter("max_count", this->get_param_max_count());
        algorithm_->set_parameter("enabled", this->get_param_enabled());
        algorithm_->set_parameter("frame_id", this->get_param_frame_id());

        // Inject publisher delegates
        algorithm_->set_status_out_publisher([this](const auto & msg) {
            this->publish_status_out(msg);
        });
        algorithm_->set_pose_out_publisher([this](const auto & msg) {
            this->publish_pose_out(msg);
        });

        // Inject service client callers

        // Inject action client callers
    }

protected:

    void on_scan_in_msg(
        const sensor_msgs::msg::LaserScan::SharedPtr msg) override
    {
        algorithm_->on_scan_in_received(*msg);
    }
    void on_cmd_in_msg(
        const geometry_msgs::msg::Twist::SharedPtr msg) override
    {
        algorithm_->on_cmd_in_received(*msg);
    }


    rcl_interfaces::msg::SetParametersResult on_parameters_changed(
        const std::vector<rclcpp::Parameter> & parameters) override
    {
        rcl_interfaces::msg::SetParametersResult result = 
            golden_pkg::IoNodeWrapper::on_parameters_changed(parameters);
        for (const auto & param : parameters) {
            golden_pkg::IoNodeAlgorithm::ParameterValue val = to_parameter_value(param);
            golden_pkg::ValidationResult validation = algorithm_->validate_parameter(param.get_name(), val);
            if (!validation.successful) {
                result.successful = false;
                result.reason = validation.reason.empty() ?
                    ("Validation failed for parameter '" + param.get_name() + "'") :
                    validation.reason;
                return result;
            }
        }
        return result;        
    }

private:
    std::shared_ptr<golden_pkg::IoNodeAlgorithm> algorithm_;
    golden_pkg::IoNodeAlgorithm::ParameterValue
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
