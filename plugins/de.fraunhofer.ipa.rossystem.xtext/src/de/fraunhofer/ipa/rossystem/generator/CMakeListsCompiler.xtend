package de.fraunhofer.ipa.rossystem.generator

import com.google.inject.Inject
import system.System

class CMakeListsCompiler {

    @Inject extension GeneratorHelpers


//  def compile_CMakeLists_ROS1(RosSystem system, ComponentStack stack) '''«init_pkg()»
//cmake_minimum_required(VERSION 2.8.3)
//project(«IF stack===null»«system.name.toLowerCase»«ELSE»«system.name.toLowerCase»_«stack.name.toLowerCase»«ENDIF»)
//
//find_package(catkin REQUIRED)
//
//catkin_package()
//
//
//### INSTALL ###
//install(DIRECTORY launch
//  DESTINATION ${CATKIN_PACKAGE_SHARE_DESTINATION}
//)'''

    /**
     * Launch/config-only ament_cmake package. One CMake minimum for every supported distribution:
     * 3.20 is below the oldest shipped CMake (Humble, 3.22) and above the 3.10 floor that CMake 4
     * deprecates (Lyrical and newer), matching what ros2 pkg create emits on current distributions.
     */
    def compile_CMakeLists_ROS2(System system, boolean gen_yaml) '''«init_pkg()»
cmake_minimum_required(VERSION 3.20)
project(«system.name.toLowerCase»)

if(CMAKE_COMPILER_IS_GNUCXX OR CMAKE_CXX_COMPILER_ID MATCHES "Clang")
  add_compile_options(-Wall -Wextra -Wpedantic)
endif()

find_package(ament_cmake REQUIRED)

install(DIRECTORY launch
  DESTINATION share/${PROJECT_NAME}
  OPTIONAL
)

install(DIRECTORY config
  DESTINATION share/${PROJECT_NAME}
  OPTIONAL
)

ament_package()
'''



}
