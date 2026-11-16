cmake_minimum_required(VERSION 3.8)
project(golden_pkg)

set(CMAKE_CXX_STANDARD 17)
set(CMAKE_CXX_STANDARD_REQUIRED ON)

if(CMAKE_COMPILER_IS_GNUCXX OR CMAKE_CXX_COMPILER_ID MATCHES "Clang")
  add_compile_options(-Wall -Wextra -Wpedantic)
endif()

find_package(ament_cmake REQUIRED)
find_package(rclcpp REQUIRED)
find_package(rclcpp_components REQUIRED)
find_package(rclcpp_lifecycle REQUIRED)
find_package(rclcpp_action REQUIRED)
find_package(std_msgs REQUIRED)
find_package(tf2_msgs REQUIRED)
find_package(std_srvs REQUIRED)
find_package(sensor_msgs REQUIRED)
find_package(geometry_msgs REQUIRED)

# -----------------------------------------------------------------------------
# C++ Component Library: IoNode_component
# -----------------------------------------------------------------------------
add_library(IoNode_component SHARED
  src/IoNodeWrapper.cpp
  src/IoNodeNode.cpp
)
target_include_directories(IoNode_component PUBLIC
  $<BUILD_INTERFACE:${CMAKE_CURRENT_SOURCE_DIR}/include>
  $<INSTALL_INTERFACE:include>
)
target_link_libraries(IoNode_component PUBLIC
  ${rclcpp_TARGETS}
  ${rclcpp_components_TARGETS}
  ${std_msgs_TARGETS}
  ${sensor_msgs_TARGETS}
  ${geometry_msgs_TARGETS}
)
rclcpp_components_register_nodes(IoNode_component "golden_pkg::IoNodeNode")

# -----------------------------------------------------------------------------
# Standalone Executable: io_node
# -----------------------------------------------------------------------------
add_executable(io_node
  src/IoNodeRunner.cpp
)
target_link_libraries(io_node PRIVATE
  IoNode_component
)
# -----------------------------------------------------------------------------
# C++ Component Library: ServiceNode_component
# -----------------------------------------------------------------------------
add_library(ServiceNode_component SHARED
  src/ServiceNodeWrapper.cpp
  src/ServiceNodeNode.cpp
)
target_include_directories(ServiceNode_component PUBLIC
  $<BUILD_INTERFACE:${CMAKE_CURRENT_SOURCE_DIR}/include>
  $<INSTALL_INTERFACE:include>
)
target_link_libraries(ServiceNode_component PUBLIC
  ${rclcpp_TARGETS}
  ${rclcpp_components_TARGETS}
  ${rclcpp_lifecycle_TARGETS}
  ${std_msgs_TARGETS}
  ${std_srvs_TARGETS}
)
rclcpp_components_register_nodes(ServiceNode_component "golden_pkg::ServiceNodeNode")

# -----------------------------------------------------------------------------
# Standalone Executable: service_node
# -----------------------------------------------------------------------------
add_executable(service_node
  src/ServiceNodeRunner.cpp
)
target_link_libraries(service_node PRIVATE
  ServiceNode_component
)
# -----------------------------------------------------------------------------
# C++ Component Library: ActionNode_component
# -----------------------------------------------------------------------------
add_library(ActionNode_component SHARED
  src/ActionNodeWrapper.cpp
  src/ActionNodeNode.cpp
)
target_include_directories(ActionNode_component PUBLIC
  $<BUILD_INTERFACE:${CMAKE_CURRENT_SOURCE_DIR}/include>
  $<INSTALL_INTERFACE:include>
)
target_link_libraries(ActionNode_component PUBLIC
  ${rclcpp_TARGETS}
  ${rclcpp_components_TARGETS}
  ${rclcpp_action_TARGETS}
  ${tf2_msgs_TARGETS}
)
rclcpp_components_register_nodes(ActionNode_component "golden_pkg::ActionNodeNode")

# -----------------------------------------------------------------------------
# Standalone Executable: action_node
# -----------------------------------------------------------------------------
add_executable(action_node
  src/ActionNodeRunner.cpp
)
target_link_libraries(action_node PRIVATE
  ActionNode_component
)


# -----------------------------------------------------------------------------
# Installation Rules
# -----------------------------------------------------------------------------
install(TARGETS
  IoNode_component
  io_node
  ServiceNode_component
  service_node
  ActionNode_component
  action_node
  ARCHIVE DESTINATION lib
  LIBRARY DESTINATION lib
  RUNTIME DESTINATION lib/${PROJECT_NAME}
)

install(DIRECTORY include/
  DESTINATION include
)

install(DIRECTORY launch
  DESTINATION share/${PROJECT_NAME}
  OPTIONAL
)

install(DIRECTORY config
  DESTINATION share/${PROJECT_NAME}
  OPTIONAL
)

ament_package()
