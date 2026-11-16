from launch import LaunchDescription
from launch_ros.actions import ComposableNodeContainer
from launch_ros.descriptions import ComposableNode
from launch_ros.parameter_descriptions import ParameterValue
from launch.actions import IncludeLaunchDescription, DeclareLaunchArgument
from launch.launch_description_sources import PythonLaunchDescriptionSource
from launch.substitutions import LaunchConfiguration, PythonExpression, PathJoinSubstitution, TextSubstitution

def generate_launch_description():
  ld = LaunchDescription()

  # *** PARAMETERS ***

  # *** ROS 2 component containers ***
  container_golden_container = ComposableNodeContainer(
    name="golden_container",
    namespace="",
    package="rclcpp_components",
    executable="component_container",
    composable_node_descriptions=[
      ComposableNode(
        package="golden_pkg",
        plugin="golden_pkg::ServiceNodeNode",
        name="service_node"
      ),
            ComposableNode(
        package="golden_pkg",
        plugin="golden_pkg::IoNodeNode",
        name="io_node",
        namespace="robot"
      )
    ],
    output='screen'
  )

  # *** ROS 2 standalone nodes ***

  # *** ROS 2 subsystems (include launch files)***

  # *** Add actions ***
  ld.add_action(container_golden_container)

  return ld
