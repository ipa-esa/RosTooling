package de.fraunhofer.ipa.ros2.generator

import com.google.inject.Inject
import de.fraunhofer.ipa.ros.plugin.spi.PackageBuild
import de.fraunhofer.ipa.ros2.distro.dialect.Ros2Target
import java.util.HashSet
import java.util.LinkedHashSet
import java.util.List
import java.util.Map
import java.util.Set
import ros.Artifact
import ros.Node
import ros.Package
import ros.PackageDependency
import ros.ExternalDependency
import ros.Plugin
import ros.PluginLoader

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

    /**
     * Populates a {@link PackageBuild} with core's baseline package dependencies, C++ component
     * libraries, standalone executables, pluginlib shared libraries, and export declarations so
     * active {@code RosToolingPlugin}s can inspect and extend it in Phase B.
     */
    def void populateCorePackageBuild(Package pkg, List<Node> cppNodes, List<Node> pythonNodes, PackageBuild build) {
        if (pkg === null || build === null) return
        val pkgLower = pkg.name.toLowerCase
        val allPlugins = getAllPlugins(pkg)
        val pluginlibPlugins = allPlugins.filter[loader == PluginLoader.PLUGINLIB].toList
        val hasPlugins = !allPlugins.empty
        val isHybrid = !cppNodes.empty && !pythonNodes.empty
        val isPurePython = cppNodes.empty && !hasPlugins && !pythonNodes.empty

        build.setHybrid(isHybrid)
        build.setPurePython(isPurePython)
        build.setBuildType(if (isPurePython) "ament_python" else "ament_cmake")
        build.setIncludeHeaderInstall(!cppNodes.empty || !pluginlibPlugins.empty)

        val allNodes = new java.util.ArrayList<Node>()
        allNodes.addAll(cppNodes)
        allNodes.addAll(pythonNodes)
        val hasActions = hasAnyActions(allNodes) || allPlugins.exists[hasActions]
        val hasLifecycle = hasLifecycle(cppNodes)

        if (isHybrid) {
            build.addBuildtoolDepend("ament_cmake")
            build.addBuildtoolDepend("ament_cmake_python")
            build.addFindPackage("ament_cmake")
            build.addFindPackage("ament_cmake_python")
            build.addDepend("rclcpp")
            build.addDepend("rclcpp_components")
            build.addFindPackage("rclcpp")
            build.addFindPackage("rclcpp_components")
            if (hasLifecycle) { build.addDepend("rclcpp_lifecycle"); build.addFindPackage("rclcpp_lifecycle") }
            if (hasActions) { build.addDepend("rclcpp_action"); build.addFindPackage("rclcpp_action") }
            build.addDepend("rclpy")
        } else if (isPurePython) {
            build.addBuildtoolDepend("ament_python")
            build.addDepend("rclpy")
        } else if (cppNodes.empty && pythonNodes.empty && hasPlugins) {
            build.addBuildtoolDepend("ament_cmake")
            build.addFindPackage("ament_cmake")
            build.addDepend("rclcpp")
            build.addFindPackage("rclcpp")
            if (hasActions) { build.addDepend("rclcpp_action"); build.addFindPackage("rclcpp_action") }
        } else {
            build.addBuildtoolDepend("ament_cmake")
            build.addFindPackage("ament_cmake")
            build.addDepend("rclcpp")
            build.addDepend("rclcpp_components")
            build.addFindPackage("rclcpp")
            build.addFindPackage("rclcpp_components")
            if (hasLifecycle) { build.addDepend("rclcpp_lifecycle"); build.addFindPackage("rclcpp_lifecycle") }
            if (hasActions) { build.addDepend("rclcpp_action"); build.addFindPackage("rclcpp_action") }
        }

        val explicitDeps = new LinkedHashSet<String>()
        explicitDeps.addAll(getAllDependencies(allNodes))
        explicitDeps.addAll(getPackageDependencies(pkg))
        if (hasPlugins) {
            explicitDeps.addAll(getPluginInterfaceDependencies(allPlugins))
            if (!pluginlibPlugins.empty) {
                explicitDeps.add("pluginlib")
                for (bp : getAllPluginBasePackages(pluginlibPlugins)) {
                    if (bp != pkgLower) explicitDeps.add(bp)
                }
            }
        }
        for (d : explicitDeps) {
            build.addDepend(d)
        }

        val cmakeDeps = if (hasPlugins) {
            val s = new LinkedHashSet<String>(getAllDependencies(allNodes))
            s.addAll(getPluginInterfaceDependencies(allPlugins))
            if (!pluginlibPlugins.empty) {
                s.add("pluginlib")
                for (bp : getAllPluginBasePackages(pluginlibPlugins)) {
                    if (bp != pkgLower) s.add(bp)
                }
            }
            s
        } else {
            getAllDependencies(allNodes)
        }
        for (d : cmakeDeps) {
            build.addFindPackage(d)
        }

        build.addExecDepend("launch")
        build.addExecDepend("launch_ros")
        build.addTestDepend("ament_lint_auto")
        build.addTestDepend("ament_lint_common")

        for (node : cppNodes) {
            val artCamel = toCamelCase(node.artifactName)
            val compLib = build.getOrCreateLibrary(artCamel + "_component", true, null)
            build.addLibrarySource(compLib, "src/" + artCamel + "Wrapper.cpp", null)
            build.addLibrarySource(compLib, "src/" + artCamel + "Node.cpp", null)
            compLib.publicIncludeDirs.add("$<BUILD_INTERFACE:${CMAKE_CURRENT_SOURCE_DIR}/include>")
            compLib.publicIncludeDirs.add("$<INSTALL_INTERFACE:include>")
            compLib.publicLinkPackages.addAll(componentLinkPackages(node))
            compLib.componentRegistrations.add(pkgLower + "::" + artCamel + "Node")

            val execTarget = build.getOrCreateExecutable(node.artifactName, null)
            execTarget.sources.add("src/" + artCamel + "Runner.cpp")
            execTarget.privateLinkLibraries.add(artCamel + "_component")
        }

        for (art : pkg.artifact) {
            val plibs = art.plugins.filter[loader == PluginLoader.PLUGINLIB].toList
            if (!plibs.empty) {
                val libTarget = pluginLibraryTargetName(art)
                val pluginLib = build.getOrCreateLibrary(libTarget, true, null)
                for (pl : plibs) {
                    build.addLibrarySource(pluginLib, "src/" + pluginSnakeName(pl) + "_plugin.cpp", null)
                }
                pluginLib.publicIncludeDirs.add("$<BUILD_INTERFACE:${CMAKE_CURRENT_SOURCE_DIR}/include>")
                pluginLib.publicIncludeDirs.add("$<INSTALL_INTERFACE:include>")
                pluginLib.publicLinkPackages.addAll(pluginlibLinkPackages(art, pkgLower))
                for (bp : getAllPluginBasePackages(plibs)) {
                    build.addPluginlibExport(bp, "plugins.xml")
                }
            }
        }
    }

    def String compilePackageXml(Package pkg, List<Node> cppNodes, List<Node> pythonNodes) {
        return compilePackageXml(pkg, cppNodes, pythonNodes, null)
    }

    def String compilePackageXml(Package pkg, List<Node> cppNodes, List<Node> pythonNodes, PackageBuild pluginBuild) {
        val pkgLower = pkg.name.toLowerCase
        val allPlugins = getAllPlugins(pkg)
        val pluginlibPlugins = allPlugins.filter[loader == PluginLoader.PLUGINLIB].toList
        val hasPlugins = !allPlugins.empty
        val isHybrid = !cppNodes.empty && !pythonNodes.empty
        val isPurePython = cppNodes.empty && !hasPlugins && !pythonNodes.empty && (pluginBuild === null || (pluginBuild.libraries.empty && pluginBuild.executables.empty))
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

        var baseline = if (pluginBuild !== null) {
            val b = new PackageBuild(pkgLower)
            populateCorePackageBuild(pkg, cppNodes, pythonNodes, b)
            b
        } else null

        val extraBuildtoolDeps = new LinkedHashSet<String>()
        val extraDepends = new LinkedHashSet<String>()
        val extraExecDeps = new LinkedHashSet<String>()
        val extraTestDeps = new LinkedHashSet<String>()
        val extraXmlExports = new LinkedHashSet<PackageBuild.XmlExportEntry>()
        if (pluginBuild !== null && baseline !== null) {
            for (d : pluginBuild.buildtoolDepends) { if (!baseline.buildtoolDepends.contains(d)) extraBuildtoolDeps.add(d) }
            for (d : pluginBuild.depends) { if (!baseline.depends.contains(d)) extraDepends.add(d) }
            for (d : pluginBuild.execDepends) { if (!baseline.execDepends.contains(d)) extraExecDeps.add(d) }
            for (d : pluginBuild.testDepends) { if (!baseline.testDepends.contains(d)) extraTestDeps.add(d) }
            for (e : pluginBuild.xmlExports) { if (!baseline.xmlExports.contains(e)) extraXmlExports.add(e) }
        }

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
  «FOR dep : extraBuildtoolDeps»
  <buildtool_depend>«dep»</buildtool_depend>
  «ENDFOR»

  «FOR dep : deps»
  <depend>«dep»</depend>
  «ENDFOR»
  «FOR dep : extraDepends»
  <depend>«dep»</depend>
  «ENDFOR»

  <exec_depend>launch</exec_depend>
  <exec_depend>launch_ros</exec_depend>
  «FOR dep : extraExecDeps»
  <exec_depend>«dep»</exec_depend>
  «ENDFOR»

  <test_depend>ament_lint_auto</test_depend>
  <test_depend>ament_lint_common</test_depend>
  «FOR dep : extraTestDeps»
  <test_depend>«dep»</test_depend>
  «ENDFOR»

  <export>
    «FOR exp : extraXmlExports»
    «renderXmlExport(exp)»
    «ENDFOR»
    «IF isPurePython»
    <build_type>ament_python</build_type>
    «ELSE»
    <build_type>ament_cmake</build_type>
    «ENDIF»
  </export>
</package>
'''
    }

    private def String renderXmlExport(PackageBuild.XmlExportEntry exp) {
        val sb = new StringBuilder("<").append(exp.tagName)
        for (Map.Entry<String, String> a : exp.attributes.entrySet) {
            sb.append(" ").append(a.key).append("=\"").append(PackageBuild.escapeXml(a.value)).append("\"")
        }
        if (exp.textContent.nullOrEmpty) {
            sb.append("/>")
        } else {
            sb.append(">").append(PackageBuild.escapeXml(exp.textContent)).append("</").append(exp.tagName).append(">")
        }
        return sb.toString
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
        return compileCMakeLists(pkg, cppNodes, pythonNodes, target, null)
    }

    def String compileCMakeLists(Package pkg, List<Node> cppNodes, List<Node> pythonNodes, Ros2Target target, PackageBuild pluginBuild) {
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

        val baseline = if (pluginBuild !== null) {
            val b = new PackageBuild(pkgLower)
            populateCorePackageBuild(pkg, cppNodes, pythonNodes, b)
            b
        } else null

        val extraFindPackages = new LinkedHashSet<String>()
        val extraLibraries = new java.util.ArrayList<PackageBuild.LibraryTarget>()
        val coreLibAugments = new java.util.ArrayList<PackageBuild.LibraryTarget>()
        val extraExecutables = new java.util.ArrayList<PackageBuild.ExecutableTarget>()
        val extraInstallTargets = new LinkedHashSet<String>()
        val extraPythonPrograms = new java.util.ArrayList<PackageBuild.PythonProgramInstall>()
        val extraInstallDirs = new java.util.ArrayList<PackageBuild.InstallDirectoryRule>()
        val extraInstallFiles = new java.util.ArrayList<PackageBuild.InstallFilesRule>()
        val extraPluginlibExports = new LinkedHashSet<PackageBuild.PluginlibExport>()
        val extraTests = new java.util.ArrayList<PackageBuild.TestTarget>()

        if (pluginBuild !== null && baseline !== null) {
            for (fp : pluginBuild.findPackages) {
                if (!baseline.findPackages.contains(fp)) extraFindPackages.add(fp)
            }
            for (exp : pluginBuild.pluginlibExports) {
                if (!baseline.pluginlibExports.contains(exp)) {
                    extraPluginlibExports.add(exp)
                    if (!baseline.findPackages.contains("pluginlib")) extraFindPackages.add("pluginlib")
                    if (exp.basePackage != pkgLower && !baseline.findPackages.contains(exp.basePackage)) {
                        extraFindPackages.add(exp.basePackage)
                    }
                }
            }
            for (lib : pluginBuild.libraries.values) {
                if (!baseline.libraries.containsKey(lib.name)) {
                    extraLibraries.add(lib)
                    if (lib.install) extraInstallTargets.add(lib.name)
                } else {
                    val baseLib = baseline.libraries.get(lib.name)
                    if (hasLibraryDelta(lib, baseLib)) {
                        coreLibAugments.add(lib)
                    }
                }
            }
            for (exec : pluginBuild.executables.values) {
                if (!baseline.executables.containsKey(exec.name)) {
                    extraExecutables.add(exec)
                    extraInstallTargets.add(exec.name)
                }
            }
            for (p : pluginBuild.pythonPrograms) {
                if (!baseline.pythonPrograms.contains(p)) extraPythonPrograms.add(p)
            }
            for (dir : pluginBuild.installDirectories) {
                if (!baseline.installDirectories.contains(dir)) extraInstallDirs.add(dir)
            }
            for (f : pluginBuild.installFiles) {
                if (!baseline.installFiles.contains(f)) extraInstallFiles.add(f)
            }
            for (t : pluginBuild.tests) {
                if (!baseline.tests.contains(t)) extraTests.add(t)
            }
        }
        val includeHeaderInstall = !cppNodes.empty || !pluginLibTargets.empty || (pluginBuild !== null && pluginBuild.isIncludeHeaderInstall)

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
«FOR dep : extraFindPackages»
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
«FOR lib : coreLibAugments»
«renderCoreLibraryAugment(lib, baseline.libraries.get(lib.name), target)»
«ENDFOR»
«FOR lib : extraLibraries»
«renderExtraLibrary(lib, target)»
«ENDFOR»
«FOR exec : extraExecutables»
«renderExtraExecutable(exec, target)»
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
«FOR pyProg : extraPythonPrograms»
install(PROGRAMS
  «pyProg.source»
  DESTINATION «pyProg.destination»
  «IF !pyProg.rename.nullOrEmpty»RENAME «pyProg.rename»«ENDIF»
)
«ENDFOR»

# -----------------------------------------------------------------------------
# Installation Rules
# -----------------------------------------------------------------------------
«IF !cppNodes.empty || !pluginLibTargets.empty || !extraInstallTargets.empty»
install(TARGETS
  «FOR node : cppNodes»
  «val artCamel = toCamelCase(node.artifactName)»
  «artCamel»_component
  «node.artifactName»
  «ENDFOR»
  «FOR libTarget : pluginLibTargets»
  «libTarget»
  «ENDFOR»
  «FOR t : extraInstallTargets»
  «t»
  «ENDFOR»
  ARCHIVE DESTINATION lib
  LIBRARY DESTINATION lib
  RUNTIME DESTINATION lib/${PROJECT_NAME}
)

«ENDIF»
«IF includeHeaderInstall»
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
«FOR rule : extraInstallDirs»

install(DIRECTORY «rule.directory»
  DESTINATION «rule.destination»
  «IF rule.optional»OPTIONAL«ENDIF»
)
«ENDFOR»
«FOR rule : extraInstallFiles»

install(FILES
  «FOR f : rule.files»
  «f»
  «ENDFOR»
  DESTINATION «rule.destination»
)
«ENDFOR»

«IF !pluginBasePkgs.empty || !extraPluginlibExports.empty»
«FOR basePkg : pluginBasePkgs»
pluginlib_export_plugin_description_file(«basePkg» plugins.xml)
«ENDFOR»
«FOR exp : extraPluginlibExports»
pluginlib_export_plugin_description_file(«exp.basePackage» «exp.descriptionFile»)
«ENDFOR»

«ENDIF»
«IF !extraTests.empty»
if(BUILD_TESTING)
  «FOR t : extraTests»
  «IF !t.sources.empty»
  ament_add_gtest(«t.name»
    «FOR src : t.sources»
    «src»
    «ENDFOR»
  )
  «IF !t.linkPackages.empty»
  «target.cmake.linkPackages(t.name, "PUBLIC", t.linkPackages)»
  «ENDIF»
  «IF !t.linkLibraries.empty»
  target_link_libraries(«t.name»
    «FOR lib : t.linkLibraries»
    «lib»
    «ENDFOR»
  )
  «ENDIF»
  «ENDIF»
  «ENDFOR»
endif()

«ENDIF»
ament_package()
'''
    }

    private def boolean hasLibraryDelta(PackageBuild.LibraryTarget current, PackageBuild.LibraryTarget base) {
        if (current === null || base === null) return false
        return current.sources.exists[!base.sources.contains(it)]
            || current.publicIncludeDirs.exists[!base.publicIncludeDirs.contains(it)]
            || current.privateIncludeDirs.exists[!base.privateIncludeDirs.contains(it)]
            || current.publicLinkPackages.exists[!base.publicLinkPackages.contains(it)]
            || current.privateLinkPackages.exists[!base.privateLinkPackages.contains(it)]
            || current.publicLinkLibraries.exists[!base.publicLinkLibraries.contains(it)]
            || current.privateLinkLibraries.exists[!base.privateLinkLibraries.contains(it)]
            || current.compileDefinitions.exists[!base.compileDefinitions.contains(it)]
            || current.componentRegistrations.exists[!base.componentRegistrations.contains(it)]
    }

    private def String renderCoreLibraryAugment(
        PackageBuild.LibraryTarget current,
        PackageBuild.LibraryTarget base,
        Ros2Target target
    ) {
        val extraSrcs = current.sources.filter[!base.sources.contains(it)].toList
        val extraPubInc = current.publicIncludeDirs.filter[!base.publicIncludeDirs.contains(it)].toList
        val extraPrivInc = current.privateIncludeDirs.filter[!base.privateIncludeDirs.contains(it)].toList
        val extraPubPkgs = current.publicLinkPackages.filter[!base.publicLinkPackages.contains(it)].toList
        val extraPrivPkgs = current.privateLinkPackages.filter[!base.privateLinkPackages.contains(it)].toList
        val extraPubLibs = current.publicLinkLibraries.filter[!base.publicLinkLibraries.contains(it)].toList
        val extraPrivLibs = current.privateLinkLibraries.filter[!base.privateLinkLibraries.contains(it)].toList
        val extraDefs = current.compileDefinitions.filter[!base.compileDefinitions.contains(it)].toList
        val extraRegs = current.componentRegistrations.filter[!base.componentRegistrations.contains(it)].toList
        return '''
«IF !extraSrcs.empty»
target_sources(«current.name» PRIVATE
  «FOR s : extraSrcs»
  «s»
  «ENDFOR»
)
«ENDIF»
«IF !extraPubInc.empty || !extraPrivInc.empty»
target_include_directories(«current.name»
  «IF !extraPubInc.empty»
  PUBLIC
    «FOR i : extraPubInc»
    «i»
    «ENDFOR»
  «ENDIF»
  «IF !extraPrivInc.empty»
  PRIVATE
    «FOR i : extraPrivInc»
    «i»
    «ENDFOR»
  «ENDIF»
)
«ENDIF»
«IF !extraPubPkgs.empty»
«target.cmake.linkPackages(current.name, "PUBLIC", extraPubPkgs)»
«ENDIF»
«IF !extraPrivPkgs.empty»
«target.cmake.linkPackages(current.name, "PRIVATE", extraPrivPkgs)»
«ENDIF»
«IF !extraPubLibs.empty»
target_link_libraries(«current.name» PUBLIC
  «FOR l : extraPubLibs»
  «l»
  «ENDFOR»
)
«ENDIF»
«IF !extraPrivLibs.empty»
target_link_libraries(«current.name» PRIVATE
  «FOR l : extraPrivLibs»
  «l»
  «ENDFOR»
)
«ENDIF»
«IF !extraDefs.empty»
target_compile_definitions(«current.name» PRIVATE
  «FOR d : extraDefs»
  «d»
  «ENDFOR»
)
«ENDIF»
«FOR r : extraRegs»
rclcpp_components_register_nodes(«current.name» "«r»")
«ENDFOR»
'''
    }

    private def String renderExtraLibrary(PackageBuild.LibraryTarget lib, Ros2Target target) '''

# -----------------------------------------------------------------------------
# Plugin Library Target: «lib.name»
# -----------------------------------------------------------------------------
add_library(«lib.name» «IF lib.shared»SHARED«ELSE»STATIC«ENDIF»
  «FOR src : lib.sources»
  «src»
  «ENDFOR»
)
«IF !lib.publicIncludeDirs.empty || !lib.privateIncludeDirs.empty»
target_include_directories(«lib.name»
  «IF !lib.publicIncludeDirs.empty»
  PUBLIC
    «FOR inc : lib.publicIncludeDirs»
    «inc»
    «ENDFOR»
  «ENDIF»
  «IF !lib.privateIncludeDirs.empty»
  PRIVATE
    «FOR inc : lib.privateIncludeDirs»
    «inc»
    «ENDFOR»
  «ENDIF»
)
«ENDIF»
«IF !lib.publicLinkPackages.empty»
«target.cmake.linkPackages(lib.name, "PUBLIC", lib.publicLinkPackages.toList)»
«ENDIF»
«IF !lib.privateLinkPackages.empty»
«target.cmake.linkPackages(lib.name, "PRIVATE", lib.privateLinkPackages.toList)»
«ENDIF»
«IF !lib.publicLinkLibraries.empty»
target_link_libraries(«lib.name» PUBLIC
  «FOR l : lib.publicLinkLibraries»
  «l»
  «ENDFOR»
)
«ENDIF»
«IF !lib.privateLinkLibraries.empty»
target_link_libraries(«lib.name» PRIVATE
  «FOR l : lib.privateLinkLibraries»
  «l»
  «ENDFOR»
)
«ENDIF»
«IF !lib.compileDefinitions.empty»
target_compile_definitions(«lib.name» PRIVATE
  «FOR d : lib.compileDefinitions»
  «d»
  «ENDFOR»
)
«ENDIF»
«FOR reg : lib.componentRegistrations»
rclcpp_components_register_nodes(«lib.name» "«reg»")
«ENDFOR»
'''

    private def String renderExtraExecutable(PackageBuild.ExecutableTarget exec, Ros2Target target) '''

# -----------------------------------------------------------------------------
# Plugin Executable Target: «exec.name»
# -----------------------------------------------------------------------------
add_executable(«exec.name»
  «FOR src : exec.sources»
  «src»
  «ENDFOR»
)
«IF !exec.linkPackages.empty»
«target.cmake.linkPackages(exec.name, "PRIVATE", exec.linkPackages.toList)»
«ENDIF»
«IF !exec.publicLinkLibraries.empty»
target_link_libraries(«exec.name» PUBLIC
  «FOR l : exec.publicLinkLibraries»
  «l»
  «ENDFOR»
)
«ENDIF»
«IF !exec.privateLinkLibraries.empty»
target_link_libraries(«exec.name» PRIVATE
  «FOR l : exec.privateLinkLibraries»
  «l»
  «ENDFOR»
)
«ENDIF»
«IF !exec.compileDefinitions.empty»
target_compile_definitions(«exec.name» PRIVATE
  «FOR d : exec.compileDefinitions»
  «d»
  «ENDFOR»
)
«ENDIF»
'''

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

