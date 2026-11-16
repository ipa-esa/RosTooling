#include "golden_pkg/IoNodeWrapper.hpp"

namespace golden_pkg {

IoNodeWrapper::IoNodeWrapper(const rclcpp::NodeOptions & options)
: rclcpp::Node("io_node", options)
{
    client_cb_group_ = this->create_callback_group(rclcpp::CallbackGroupType::Reentrant);

    // ----------------------------------------------------
    // 1. Parameter Declarations (with and without defaults)
    // ----------------------------------------------------
    {
        rcl_interfaces::msg::ParameterDescriptor desc;
        desc.description = "Parameter 'rate_hz' modelled in RosTooling";
        desc.read_only = false;
        this->declare_parameter<double>("rate_hz", 10.0, desc);
        this->get_parameter("rate_hz", param_rate_hz_);
    }
    {
        rcl_interfaces::msg::ParameterDescriptor desc;
        desc.description = "Parameter 'max_count' modelled in RosTooling";
        desc.read_only = false;
        this->declare_parameter<int64_t>("max_count", 5, desc);
        this->get_parameter("max_count", param_max_count_);
    }
    {
        rcl_interfaces::msg::ParameterDescriptor desc;
        desc.description = "Parameter 'enabled' modelled in RosTooling";
        desc.read_only = false;
        this->declare_parameter<bool>("enabled", true, desc);
        this->get_parameter("enabled", param_enabled_);
    }
    {
        rcl_interfaces::msg::ParameterDescriptor desc;
        desc.description = "Parameter 'frame_id' modelled in RosTooling";
        desc.read_only = false;
        this->declare_parameter<std::string>("frame_id", "base_link", desc);
        this->get_parameter("frame_id", param_frame_id_);
    }
    param_cb_handle_ = this->add_on_set_parameters_callback(
        std::bind(&IoNodeWrapper::internal_on_set_parameters, this, std::placeholders::_1));
    // ----------------------------------------------------
    // 2. Publishers Initialization
    // ----------------------------------------------------
    pub_status_out_ = this->create_publisher<std_msgs::msg::String>(
        "status_out", rclcpp::SystemDefaultsQoS());
    pub_pose_out_ = this->create_publisher<geometry_msgs::msg::PoseStamped>(
        "pose_out", rclcpp::QoS(5).best_effort().transient_local());

    // ----------------------------------------------------
    // 3. Subscribers Initialization
    // ----------------------------------------------------
    sub_scan_in_ = this->create_subscription<sensor_msgs::msg::LaserScan>(
        "scan_in", rclcpp::SensorDataQoS(),
        [this](const sensor_msgs::msg::LaserScan::SharedPtr msg) {
            {
                std::lock_guard<std::mutex> lock(sub_scan_in_mutex_);
                latest_sub_scan_in_msg_ = *msg;
                has_new_sub_scan_in_msg_ = true;
            }
            this->on_scan_in_msg(msg);
        });
    sub_cmd_in_ = this->create_subscription<geometry_msgs::msg::Twist>(
        "cmd_in", rclcpp::SystemDefaultsQoS(),
        [this](const geometry_msgs::msg::Twist::SharedPtr msg) {
            {
                std::lock_guard<std::mutex> lock(sub_cmd_in_mutex_);
                latest_sub_cmd_in_msg_ = *msg;
                has_new_sub_cmd_in_msg_ = true;
            }
            this->on_cmd_in_msg(msg);
        });

    // ----------------------------------------------------
    // 4. Service Servers Initialization
    // ----------------------------------------------------

    // ----------------------------------------------------
    // 5. Service Clients Initialization
    // ----------------------------------------------------

    // ----------------------------------------------------
    // 6. Action Servers Initialization
    // ----------------------------------------------------

    // ----------------------------------------------------
    // 7. Action Clients Initialization
    // ----------------------------------------------------
}

// Outgoing Publisher implementations
void IoNodeWrapper::publish_status_out(const std_msgs::msg::String & msg) {
    if (pub_status_out_) {
        pub_status_out_->publish(msg);
    }
}
void IoNodeWrapper::publish_pose_out(const geometry_msgs::msg::PoseStamped & msg) {
    if (pub_pose_out_) {
        pub_pose_out_->publish(msg);
    }
}

// Outgoing Service Client implementations

// Outgoing Action Client implementations

// Action Server Feedback helper

// Dynamic parameter update handling
rcl_interfaces::msg::SetParametersResult IoNodeWrapper::internal_on_set_parameters(
    const std::vector<rclcpp::Parameter> & parameters)
{
    auto validation_res = this->on_parameters_changed(parameters);
    if (!validation_res.successful) {
        return validation_res;
    }
    for (const auto & param : parameters) {
        if (param.get_name() == "rate_hz") {
            param_rate_hz_ = param.get_value<double>();
            RCLCPP_INFO(this->get_logger(), "Parameter 'rate_hz' dynamically updated.");
        }
        if (param.get_name() == "max_count") {
            param_max_count_ = param.get_value<int64_t>();
            RCLCPP_INFO(this->get_logger(), "Parameter 'max_count' dynamically updated.");
        }
        if (param.get_name() == "enabled") {
            param_enabled_ = param.get_value<bool>();
            RCLCPP_INFO(this->get_logger(), "Parameter 'enabled' dynamically updated.");
        }
        if (param.get_name() == "frame_id") {
            param_frame_id_ = param.get_value<std::string>();
            RCLCPP_INFO(this->get_logger(), "Parameter 'frame_id' dynamically updated.");
        }
    }
    rcl_interfaces::msg::SetParametersResult res;
    res.successful = true;
    return res;
}


} // namespace golden_pkg
