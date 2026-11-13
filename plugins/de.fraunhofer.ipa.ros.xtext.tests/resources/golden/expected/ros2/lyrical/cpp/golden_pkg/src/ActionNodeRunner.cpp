#include <memory>
#include <thread>
#include "rclcpp/rclcpp.hpp"
#include "golden_pkg/ActionNodeNode.hpp"

int main(int argc, char * argv[])
{
    rclcpp::init(argc, argv);
    auto node = std::make_shared<golden_pkg::ActionNodeNode>();

    // Automated Executor Selection: MultiThreadedExecutor selected for concurrency
    rclcpp::executors::MultiThreadedExecutor executor(
        rclcpp::ExecutorOptions(),
        std::max(2u, std::thread::hardware_concurrency()));
    executor.add_node(node);
    executor.spin();

    rclcpp::shutdown();
    return 0;
}
