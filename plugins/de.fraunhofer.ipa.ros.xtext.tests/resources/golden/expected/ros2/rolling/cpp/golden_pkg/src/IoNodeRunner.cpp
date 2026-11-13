#include <memory>
#include <thread>
#include "rclcpp/rclcpp.hpp"
#include "golden_pkg/IoNodeNode.hpp"

int main(int argc, char * argv[])
{
    rclcpp::init(argc, argv);
    auto node = std::make_shared<golden_pkg::IoNodeNode>();

    // Automated Executor Selection: SingleThreadedExecutor selected
    rclcpp::spin(node);

    rclcpp::shutdown();
    return 0;
}
