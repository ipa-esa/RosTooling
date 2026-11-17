package de.fraunhofer.ipa.ros2.generator

import com.google.inject.Inject
import ros.Artifact
import ros.Node
import ros.Package
import ros.PackageDependency
import ros.ExternalDependency
import ros.Plugin
import ros.PluginLoader
import java.util.List
import java.util.Set
import java.util.HashSet
import java.util.LinkedHashSet
import de.fraunhofer.ipa.ros2.distro.dialect.Ros2Target

class Ros2BuildArtifactsCompiler {

    @Inject extension Ros2GeneratorHelpers

    def Set<String> getAllDependencies(List<Node> nodes) {
        val set = new HashSet<String>()
        for (node : nodes) {
            set.addAll(node.dependencies)
        }
        return set
    }

    def Set<String> getPluginInterfaceDependencies(List<Plugin> plugins) {
        val set = new LinkedHashSet<String>()
        for (pl : plugins) {
            set.addAll(pl.dependencies)
        }
        return set
    }

    def Set<String> getAllPluginBasePackages(List<Plugin> plugins) {
        val set = new LinkedHashSet<String>()
        for (pl : plugins) {
            if (pl.loader == PluginLoader.PLUGINLIB) {
                val basePkg = basePackageName(pl.implements)
                if (!basePkg.empty) {
                    set.add(basePkg)
                }
            }
        }
        return set
    }

    /** Names listed under the package's `dependencies:` (package references or ExternalDependency "name"). */
    def Set<String> getPackageDependencies(Package pkg) {
        val set = new HashSet<String>()
        for (dep : pkg.dependency) {
            if (dep instanceof PackageDependency) {
                if (dep.package !== null && dep.package.name !== null) set.add(dep.package.name)
            } else if (dep instanceof ExternalDependency) {
                if (dep.name !== null && !dep.name.empty) set.add(dep.name)
            }
        }
        return set
    }

    def boolean hasAnyActions(List<Node> nodes) {
        for (node : nodes) {
            if (node.hasActions) return true
        }
        return false
    }

    def String compilePackageXml(Package pkg, List<Node> cppNodes, List<Node> pythonNodes) {
        val pkgLower = pkg.name.toLowerCase
        val allPlugins = getAllPlugins(pkg)
        val pluginlibPlugins = allPlugins.filter[loader == PluginLoader.PLUGINLIB].toList
        val hasPlugins = !allPlugins.empty
        val isHybrid = !cppNodes.empty && !pythonNodes.empty
        val isPurePython = cppNodes.empty && !hasPlugins && !pythonNodes.empty
        val isPluginsOnlyCpp = cppNodes.empty && pythonNodes.empty && hasPlugins
        val allNodes = new java.util.ArrayList<Node>()
        allNodes.addAll(cppNodes)
        allNodes.addAll(pythonNodes)
        val deps = getAllDependencies(allNodes)
        deps.addAll(getPackageDependencies(pkg))
        if (hasPlugins) {
            deps.addAll(getPluginInterfaceDependencies(allPlugins))
            if (!pluginlibPlugins.empty) {
                deps.add("pluginlib")
                for (bp : getAllPluginBasePackages(pluginlibPlugins)) {
                    if (bp != pkgLower) {
                        deps.add(bp)
                    }
                }
            }
        }
        val hasActions = hasAnyActions(allNodes) || allPlugins.exists[hasActions]
        val hasLifecycle = hasLifecycle(cppNodes)

        return '''
<?xml version="1.0"?>
<?xml-model href="http://download.ros.org/schema/package_format3.xsd" schematypens="http://www.w3.org/2001/XMLSchema"?>
<package format="3">
  <name>«pkgLower»</name>
  <version>0.0.1</version>
  <description>ROS 2 package «pkg.name» with generated node wrappers</description>
  <maintainer email="user@todo.todo">ROS Developer</maintainer>
  <license>Apache-2.0</license>

  «IF isHybrid»
  <buildtool_depend>ament_cmake</buildtool_depend>
  <buildtool_depend>ament_cmake_python</buildtool_depend>

  <depend>rclcpp</depend>
  <depend>rclcpp_components</depend>
  «IF hasLifecycle»<depend>rclcpp_lifecycle</depend>«ENDIF»
  «IF hasActions»<depend>rclcpp_action</depend>«ENDIF»
  <depend>rclpy</depend>
  «ELSEIF isPurePython»
  <buildtool_depend>ament_python</buildtool_depend>
  <depend>rclpy</depend>
  «ELSEIF isPluginsOnlyCpp»
  <buildtool_depend>ament_cmake</buildtool_depend>
  <depend>rclcpp</depend>
  «IF hasActions»<depend>rclcpp_action</depend>«ENDIF»
  «ELSE»
  <buildtool_depend>ament_cmake</buildtool_depend>
  <depend>rclcpp</depend>
  <depend>rclcpp_components</depend>
  «IF hasLifecycle»<depend>rclcpp_lifecycle</depend>«ENDIF»
  «IF hasActions»<depend>rclcpp_action</depend>«ENDIF»
  «ENDIF»

  «FOR dep : deps»
  <depend>«dep»</depend>
  «ENDFOR»

  <exec_depend>launch</exec_depend>
  <exec_depend>launch_ros</exec_depend>

  <test_depend>ament_lint_auto</test_depend>
  <test_depend>ament_lint_common</test_depend>

  <export>
    «IF isPurePython»
    <build_type>ament_python</build_type>
    «ELSE»
    <build_type>ament_cmake</build_type>
    «ENDIF»
  </export>
</package>
'''
    }

    /** rclcpp packages plus the node's interface packages, in a stable order, for linking. */
    def List<String> componentLinkPackages(Node node) {
        val pkgs = new LinkedHashSet<String>()
        pkgs.add("rclcpp")
        pkgs.add("rclcpp_components")
        if (node.isLifecycle) pkgs.add("rclcpp_lifecycle")
        if (node.hasActions) pkgs.add("rclcpp_action")
        pkgs.addAll(node.dependencies)
        return pkgs.toList
    }

    /** Link packages for a pluginlib shared library target built from an artifact. */
    def List<String> pluginlibLinkPackages(Artifact art, String ownPkgLower) {
        val pkgs = new LinkedHashSet<String>()
        pkgs.add("rclcpp")
        pkgs.add("pluginlib")
        val plibs = art.plugins.filter[loader == PluginLoader.PLUGINLIB].toList
        if (plibs.exists[hasActions]) pkgs.add("rclcpp_action")
        for (pl : plibs) {
            val basePkg = basePackageName(pl.implements)
            if (!basePkg.empty && basePkg != ownPkgLower) {
                pkgs.add(basePkg)
            }
            pkgs.addAll(pl.dependencies)
        }
        return pkgs.toList
    }

    def String compileCMakeLists(Package pkg, List<Node> cppNodes, List<Node> pythonNodes, Ros2Target target) {
        val pkgLower = pkg.name.toLowerCase
        val allPlugins = getAllPlugins(pkg)
        val pluginlibPlugins = allPlugins.filter[loader == PluginLoader.PLUGINLIB].toList
        val pluginBasePkgs = getAllPluginBasePackages(pluginlibPlugins)
        val hasPlugins = !allPlugins.empty
        val isHybrid = !cppNodes.empty && !pythonNodes.empty
        val allNodes = new java.util.ArrayList<Node>()
        allNodes.addAll(cppNodes)
        allNodes.addAll(pythonNodes)
        val Set<String> deps = if (hasPlugins) {
            val s = new LinkedHashSet<String>(getAllDependencies(allNodes))
            s.addAll(getPluginInterfaceDependencies(allPlugins))
            if (!pluginlibPlugins.empty) {
                s.add("pluginlib")
                for (bp : pluginBasePkgs) {
                    if (bp != pkgLower) {
                        s.add(bp)
                    }
                }
            }
            s
        } else {
            getAllDependencies(allNodes)
        }
        val hasActions = hasAnyActions(allNodes) || allPlugins.exists[hasActions]
        val hasLifecycle = hasLifecycle(cppNodes)
        val pluginLibTargets = new java.util.ArrayList<String>()
        for (art : pkg.artifact) {
            if (art.plugins.exists[loader == PluginLoader.PLUGINLIB]) {
                pluginLibTargets.add(pluginLibraryTargetName(art))
            }
        }

        return '''
«target.cmake.minimumRequired»
project(«pkgLower»)

«target.cmake.cxxStandard»
set(CMAKE_CXX_STANDARD_REQUIRED ON)

if(CMAKE_COMPILER_IS_GNUCXX OR CMAKE_CXX_COMPILER_ID MATCHES "Clang")
  add_compile_options(-Wall -Wextra -Wpedantic)
endif()

find_package(ament_cmake REQUIRED)
«IF isHybrid»
find_package(ament_cmake_python REQUIRED)
«ENDIF»
find_package(rclcpp REQUIRED)
«IF !cppNodes.empty || !hasPlugins»
find_package(rclcpp_components REQUIRED)
«ENDIF»
«IF hasLifecycle»
find_package(rclcpp_lifecycle REQUIRED)
«ENDIF»
«IF hasActions»
find_package(rclcpp_action REQUIRED)
«ENDIF»
«FOR dep : deps»
find_package(«dep» REQUIRED)
«ENDFOR»

«FOR node : cppNodes»
«val artCamel = toCamelCase(node.artifactName)»
# -----------------------------------------------------------------------------
# C++ Component Library: «artCamel»_component
# -----------------------------------------------------------------------------
add_library(«artCamel»_component SHARED
  src/«artCamel»Wrapper.cpp
  src/«artCamel»Node.cpp
)
target_include_directories(«artCamel»_component PUBLIC
  $<BUILD_INTERFACE:${CMAKE_CURRENT_SOURCE_DIR}/include>
  $<INSTALL_INTERFACE:include>
)
«target.cmake.linkPackages(artCamel + "_component", "PUBLIC", componentLinkPackages(node))»
rclcpp_components_register_nodes(«artCamel»_component "«pkgLower»::«artCamel»Node")

# -----------------------------------------------------------------------------
# Standalone Executable: «node.artifactName»
# -----------------------------------------------------------------------------
add_executable(«node.artifactName»
  src/«artCamel»Runner.cpp
)
target_link_libraries(«node.artifactName» PRIVATE
  «artCamel»_component
)
«ENDFOR»
«FOR art : pkg.artifact»
«val plibs = art.plugins.filter[loader == PluginLoader.PLUGINLIB].toList»
«val extPlugins = art.plugins.filter[loader == PluginLoader.EXTERNAL].toList»
«IF !plibs.empty»
«val libTarget = pluginLibraryTargetName(art)»

# -----------------------------------------------------------------------------
# Pluginlib Shared Library: «libTarget»
# -----------------------------------------------------------------------------
add_library(«libTarget» SHARED
  «FOR pl : plibs»
  src/«pluginSnakeName(pl)»_plugin.cpp
  «ENDFOR»
)
target_include_directories(«libTarget» PUBLIC
  $<BUILD_INTERFACE:${CMAKE_CURRENT_SOURCE_DIR}/include>
  $<INSTALL_INTERFACE:include>
)
«target.cmake.linkPackages(libTarget, "PUBLIC", pluginlibLinkPackages(art, pkgLower))»
«FOR bp : getAllPluginBasePackages(plibs).filter[it != pkgLower]»
if(DEFINED «bp»_INCLUDE_DIRS)
  target_include_directories(«libTarget» PUBLIC ${«bp»_INCLUDE_DIRS})
endif()
«ENDFOR»
«ELSEIF !extPlugins.empty»

# External plugins in '«art.name»': sources & registration supplied by active extension plugin
«ENDIF»
«ENDFOR»

«IF isHybrid»
# -----------------------------------------------------------------------------
# Python Package Installation (Hybrid ament_cmake_python)
# -----------------------------------------------------------------------------
ament_python_install_package(${PROJECT_NAME})

«FOR node : pythonNodes»
install(PROGRAMS
  «pkgLower»/«node.name»_runner.py
  DESTINATION lib/${PROJECT_NAME}
  RENAME «node.artifactName»
)
«ENDFOR»
«ENDIF»

# -----------------------------------------------------------------------------
# Installation Rules
# -----------------------------------------------------------------------------
«IF !cppNodes.empty || !pluginLibTargets.empty»
install(TARGETS
  «FOR node : cppNodes»
  «val artCamel = toCamelCase(node.artifactName)»
  «artCamel»_component
  «node.artifactName»
  «ENDFOR»
  «FOR libTarget : pluginLibTargets»
  «libTarget»
  «ENDFOR»
  ARCHIVE DESTINATION lib
  LIBRARY DESTINATION lib
  RUNTIME DESTINATION lib/${PROJECT_NAME}
)

install(DIRECTORY include/
  DESTINATION include
)
«ENDIF»

install(DIRECTORY launch
  DESTINATION share/${PROJECT_NAME}
  OPTIONAL
)

install(DIRECTORY config
  DESTINATION share/${PROJECT_NAME}
  OPTIONAL
)

«IF !pluginBasePkgs.empty»
«FOR basePkg : pluginBasePkgs»
pluginlib_export_plugin_description_file(«basePkg» plugins.xml)
«ENDFOR»

«ENDIF»
ament_package()
'''
    }

    def String compileSetupPy(Package pkg, List<Node> pythonNodes) '''
import os
from glob import glob
from setuptools import find_packages, setup

package_name = '«pkg.name.toLowerCase»'

setup(
    name=package_name,
    version='0.0.1',
    packages=find_packages(exclude=['test']),
    data_files=[
        ('share/ament_index/resource_index/packages', ['resource/' + package_name]),
        ('share/' + package_name, ['package.xml']),
        (os.path.join('share', package_name, 'launch'), glob(os.path.join('launch', '*.[pxy][yma]*'))),
        (os.path.join('share', package_name, 'config'), glob(os.path.join('config', '*.*'))),
    ],
    install_requires=['setuptools'],
    zip_safe=True,
    maintainer='ROS Developer',
    maintainer_email='user@todo.todo',
    description='ROS 2 package «pkg.name» with generated Python node wrappers',
    license='Apache-2.0',
    extras_require={
        'test': ['pytest'],
    },
    entry_points={
        'console_scripts': [
            «FOR node : pythonNodes»
            '«node.artifactName» = «pkg.name.toLowerCase».«node.name»_runner:main',
            «ENDFOR»
        ],
    },
)
'''

    def String compileSetupCfg(Package pkg) '''
[develop]
script_dir=$base/lib/«pkg.name.toLowerCase»
[install]
install_scripts=$base/lib/«pkg.name.toLowerCase»
'''

}

