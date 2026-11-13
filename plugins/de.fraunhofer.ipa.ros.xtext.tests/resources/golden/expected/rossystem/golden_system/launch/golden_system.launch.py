from launch import LaunchDescription
from launch_ros.actions import Node
from launch_ros.actions import LifecycleNode
from launch_ros.parameter_descriptions import ParameterValue
from launch.actions import IncludeLaunchDescription, DeclareLaunchArgument
from launch.launch_description_sources import PythonLaunchDescriptionSource
from launch.substitutions import LaunchConfiguration, PythonExpression, PathJoinSubstitution, TextSubstitution

def generate_launch_description():
  ld = LaunchDescription()

  # *** PARAMETERS ***
  rate_hz_arg = DeclareLaunchArgument(
    "rate_hz", default_value=TextSubstitution(text="20.0")
  )
  ld.add_action(rate_hz_arg)


  # *** ROS 2 standalone nodes ***
  service_node = LifecycleNode(
    package="golden_pkg",
    namespace="",
    executable="service_node",
    output='screen',
    name="service_node"
  )
  robot_monitor = LifecycleNode(
    package="golden_pkg",
    namespace="robot",
    executable="service_node",
    output='screen',
    name="monitor"
  )
  io_node = Node(
    package="golden_pkg",
    executable="io_node",
    output='screen',
    name="io_node",
    parameters=[{
    "rate_hz": LaunchConfiguration("rate_hz"),}]
  )
  robot_action_node = Node(
    package="golden_pkg",
    namespace="/robot",
    executable="action_node",
    output='screen',
    name="action_node"
  )

  # *** ROS 2 subsystems (include launch files)***

  # *** Add actions ***
  ld.add_action(service_node)
  ld.add_action(robot_monitor)
  ld.add_action(io_node)
  ld.add_action(robot_action_node)

  return ld
