package de.fraunhofer.ipa.rossystem.generator

import com.google.inject.Inject
import de.fraunhofer.ipa.ros.generator.IPluginAwareGenerator
import de.fraunhofer.ipa.ros.plugin.spi.PluginRegistry
import de.fraunhofer.ipa.ros.plugin.spi.SystemGenerationContext
import de.fraunhofer.ipa.ros2.distro.Ros2Distros
import de.fraunhofer.ipa.rossystem.scoping.RosSystemScopeProvider
import java.nio.file.Path
import java.util.ArrayList
import java.util.LinkedHashMap
import java.util.LinkedHashSet
import java.util.List
import java.util.Map
import java.util.Set
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import ros.Extensible
import ros.Node
import system.RosNode
import system.System

/**
 * Generates ROS 2 bringup packages, launch files, parameter YAML files, and PlantUML diagrams
 * from {@code .rossystem} models, executing active Phase B system-level plugins via
 * {@link SystemGenerationContext}.
 */
class RosSystemGenerator extends AbstractGenerator implements IPluginAwareGenerator {
    @Inject extension LaunchFileCompiler_ROS2
    @Inject extension YamlFileCompiler_ROS2
    @Inject extension SetupPyCompiler
    @Inject extension PackageXmlCompiler
    @Inject extension CMakeListsCompiler
    @Inject extension READMECompiler
    @Inject extension PlantUMLCompiler
    @Inject extension GeneratorHelpers
    @Inject extension Ros1BridgesYamlFileCompiler
    @Inject extension BridgesLaunchFileCompiler_ROS2

    static class SystemGenerationOutcome extends IPluginAwareGenerator.Outcome {
    }

    override void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
        val fsaName = fsa.class.simpleName
        if (fsaName == "URIBasedFileSystemAccess" || fsaName == "FileSystemAccessImpl") {
            println("[LSP SHIELD] Blocked automatic background generation on startup.")
            return
        }

        generateSystemTargeted(resource, fsa, null)
    }

    override IPluginAwareGenerator.Outcome generateWithPlugins(
        Resource resource,
        IFileSystemAccess2 fsa,
        List<String> targetNodes,
        String languageChoice,
        String targetDistro,
        List<String> existingFiles,
        Path outputRoot)
    {
        return generateSystemWithPlugins(resource, fsa, existingFiles, targetDistro, outputRoot)
    }

    def void generateSystemTargeted(Resource resource, IFileSystemAccess2 fsa, List<String> existingFiles) {
        generateSystemWithPlugins(resource, fsa, existingFiles, Ros2Distros.AUTO)
    }

    def SystemGenerationOutcome generateSystemWithPlugins(
        Resource resource,
        IFileSystemAccess2 fsa,
        List<String> existingFiles,
        String targetDistro)
    {
        return generateSystemWithPlugins(resource, fsa, existingFiles, targetDistro, null)
    }

    def SystemGenerationOutcome generateSystemWithPlugins(
        Resource resource,
        IFileSystemAccess2 fsa,
        List<String> existingFiles,
        String targetDistro,
        Path outputRoot)
    {
        val distro = Ros2Distros.resolve(targetDistro)
        val outcome = new SystemGenerationOutcome()
        val existingList = if (existingFiles !== null) existingFiles else new ArrayList<String>()
        val activePlugins = PluginRegistry.INSTANCE.activePlugins()
        outcome.notices.addAll(PluginRegistry.INSTANCE.notices())

        for (system : resource.allContents.toIterable.filter(System)) {
            var yaml_gen = false
            val pkgName = system.getName().toLowerCase
            val pkgPrefix = pkgName + "/"

            val hasCMake = existingList.contains(pkgName + "/CMakeLists.txt") || existingList.contains("CMakeLists.txt") || fsa.isFile(pkgName + "/CMakeLists.txt")
            val hasSetupPy = existingList.contains(pkgName + "/setup.py") || existingList.contains("setup.py") || fsa.isFile(pkgName + "/setup.py")
            val hasPkgXml = existingList.contains(pkgName + "/package.xml") || existingList.contains("package.xml") || fsa.isFile(pkgName + "/package.xml")

            val hasCppSrc = existingList.exists[f |
                (f.startsWith(pkgPrefix) || !f.contains("/")) &&
                (f.contains("Wrapper.cpp") || f.contains("Runner.cpp") || f.contains("Algorithm.hpp") || f.contains("/src/") || f.endsWith(".cpp") || f.endsWith(".hpp"))
            ]
            val hasPySrc = existingList.exists[f |
                (f.startsWith(pkgPrefix) || !f.contains("/")) &&
                (f.contains("_wrapper.py") || f.contains("_runner.py") || f.contains("_logic.py") || (f.endsWith(".py") && !f.endsWith(".launch.py")))
            ]

            val isPurePython = (hasPySrc || hasSetupPy) && !hasCppSrc && !hasCMake

            emitCoreFile(fsa, outcome, pkgName + "/README.md",
                compile_toREADME(system).toString().replace("\t", "  "))
            emitCoreFile(fsa, outcome, pkgName + "/resource/" + pkgName + ".puml",
                compile_plantuml(system))

            if (system.fromFile.isNullOrEmpty) {
                for (component : system.components) {
                    if (component instanceof RosNode && (component as RosNode).rosinterfaces.empty) {
                        RosSystemScopeProvider.ensureDefaultInterfacesSynthesized(component as RosNode, system)
                    }
                }
            }

            // Reserve all core-owned system paths (whether rendered, patched, or preserved on disk).
            val Set<String> coreOwnedPaths = new LinkedHashSet<String>()
            coreOwnedPaths.add(pkgName + "/README.md")
            coreOwnedPaths.add(pkgName + "/resource/" + pkgName + ".puml")
            coreOwnedPaths.add(pkgName + "/resource/" + pkgName)
            coreOwnedPaths.add(pkgName + "/" + pkgName + "/__init__.py")
            coreOwnedPaths.add(pkgName + "/CMakeLists.txt")
            coreOwnedPaths.add(pkgName + "/package.xml")
            coreOwnedPaths.add(pkgName + "/setup.py")
            coreOwnedPaths.add(pkgName + "/setup.cfg")
            coreOwnedPaths.add(pkgName + "/pyproject.toml")
            coreOwnedPaths.add(pkgName + "/launch/" + system.getName() + ".launch.py")
            coreOwnedPaths.add(pkgName + "/launch/" + system.getName() + "_bridges.launch.py")
            coreOwnedPaths.add(pkgName + "/config/ros1_bridges.yaml")

            val List<Extensible> rosNodesList = new ArrayList()
            val Map<Extensible, Node> rosNodeTypes = new LinkedHashMap()
            val Set<Node> resolvedNodeSet = new LinkedHashSet()
            val Set<ros.Package> resolvedPkgSet = new LinkedHashSet()

            for (component : system.components) {
                if (component instanceof RosNode) {
                    val rnode = component as RosNode
                    rosNodesList.add(rnode)
                    coreOwnedPaths.add(pkgName + "/config/" + rnode.getName() + ".yaml")
                    if (!rnode.namespace.nullOrEmpty) {
                        coreOwnedPaths.add(pkgName + "/config/" + parameterFileName(rnode))
                    }
                    if (rnode.from !== null && !rnode.from.eIsProxy) {
                        rosNodeTypes.put(rnode, rnode.from)
                        resolvedNodeSet.add(rnode.from)
                        val p = enclosingPackage(rnode.from)
                        if (p !== null) {
                            resolvedPkgSet.add(p)
                        }
                    }
                    for (pl : RosSystemScopeProvider.attachedPlugins(rnode)) {
                        if (pl !== null && !pl.eIsProxy) {
                            val p = enclosingPackage(pl)
                            if (p !== null) {
                                resolvedPkgSet.add(p)
                            }
                        }
                    }
                }
            }

            // Also reserve any top-level core files already present in existingList.
            for (existing : existingList) {
                val clean = if (existing.startsWith("src-gen/")) existing.substring("src-gen/".length) else existing
                val sub = if (clean.startsWith(pkgPrefix)) clean.substring(pkgPrefix.length) else clean
                if ((sub.startsWith("config/") && !sub.substring("config/".length).contains("/") && sub.endsWith(".yaml"))
                        || (sub.startsWith("launch/") && !sub.substring("launch/".length).contains("/") && sub.endsWith(".launch.py"))
                        || (sub.startsWith("resource/") && !sub.substring("resource/".length).contains("/"))) {
                    coreOwnedPaths.add(pkgPrefix + sub)
                }
            }

            val Set<String> declaredSystemLaunchArgs = new LinkedHashSet()
            if (system.parameter !== null) {
                for (p : system.parameter) {
                    if (p instanceof ros.Parameter && !isSubstitutionParameter(p as ros.Parameter)) {
                        declaredSystemLaunchArgs.add((p as ros.Parameter).name)
                    }
                }
            }
            for (lp : getUniqueLaunchParameters(system)) {
                declaredSystemLaunchArgs.add(lp.name)
            }

            // Phase B: Run system-level plugins before core renders final launch/setup files.
            val List<SystemGenerationContext> sysContexts = new ArrayList()
            val List<String> sysConflictErrors = new ArrayList()
            val Map<String, SystemGenerationContext.LaunchInclude> sharedIncludes = new LinkedHashMap()

            if (!activePlugins.empty) {
                val Map<String, String> allPluginOwnedFiles = new LinkedHashMap()
                val isFromFile = !system.fromFile.isNullOrEmpty
                val resolvedNodesList = new ArrayList(resolvedNodeSet)
                val resolvedPkgsList = new ArrayList(resolvedPkgSet)
                for (plugin : activePlugins) {
                    val ctx = new SystemGenerationContext(
                        plugin.id,
                        system.getName(),
                        system,
                        isFromFile,
                        rosNodesList,
                        rosNodeTypes,
                        resolvedNodesList,
                        resolvedPkgsList,
                        declaredSystemLaunchArgs,
                        resource,
                        distro,
                        outputRoot,
                        existingList,
                        coreOwnedPaths,
                        allPluginOwnedFiles,
                        sharedIncludes,
                        sysConflictErrors,
                        PluginRegistry.INSTANCE
                    )
                    plugin.generateSystem(ctx)
                    sysContexts.add(ctx)
                    outcome.notices.addAll(ctx.notices)
                }
            }

            outcome.pluginConflictErrors.addAll(sysConflictErrors)
            outcome.errors.addAll(sysConflictErrors)
            val noConflicts = sysConflictErrors.empty

            val List<SystemGenerationContext.LaunchInclude> effectiveIncludes = if (noConflicts && !sharedIncludes.empty) {
                new ArrayList(sharedIncludes.values)
            } else {
                List.of()
            }

            val Set<String> pluginInstallDirs = new LinkedHashSet()
            if (noConflicts) {
                for (ctx : sysContexts) {
                    val Set<String> ctxInstallFolders = new LinkedHashSet()
                    val pf = ctx.pluginFolder
                    for (writtenPath : ctx.writtenFiles.keySet) {
                        val sub = if (writtenPath.startsWith(pkgPrefix)) writtenPath.substring(pkgPrefix.length) else writtenPath
                        if (sub.startsWith("config/" + pf + "/")) {
                            ctxInstallFolders.add("config/" + pf)
                        } else if (sub.startsWith("launch/" + pf + "/")) {
                            ctxInstallFolders.add("launch/" + pf)
                        }
                    }
                    for (inc : effectiveIncludes) {
                        if (inc.pluginId == ctx.pluginId) {
                            ctxInstallFolders.add("launch/" + pf)
                        }
                    }
                    pluginInstallDirs.addAll(ctxInstallFolders)
                    if (isPurePython && hasSetupPy && !ctxInstallFolders.empty && system.fromFile.isNullOrEmpty) {
                        outcome.warnings.add(
                            "Plugin '" + ctx.pluginId + "' generated or included files in " + ctxInstallFolders
                            + " for pure-Python system '" + pkgName
                            + "', which will not be installed because user-owned '" + pkgName + "/setup.py' is preserved untouched.")
                    }
                }
            }

            if (system.fromFile.isNullOrEmpty) {
                emitCoreFile(fsa, outcome, pkgName + "/launch/" + system.getName() + ".launch.py",
                    compile_toROS2launch(system, effectiveIncludes).toString().replace("\t", "  "))
                for (component : system.components) {
                    if (component.eClass.name == "RosNode") {
                        val rnode = component as RosNode
                        if (!rnode.rosparameters.nullOrEmpty || (hasAutoSlotParameters(rnode) && generate_yaml(rnode))) {
                            yaml_gen = true
                            emitCoreFile(fsa, outcome,
                                pkgName + "/config/" + parameterFileName(rnode),
                                compile_toROS2yaml(rnode).toString().replace("\t", "  "))
                        }
                    }
                }

                if (isPurePython) {
                    // Pure Python package: Never emit CMakeLists.txt!
                    if (!hasSetupPy) {
                        emitCoreFile(fsa, outcome, pkgName + "/setup.py",
                            compile_setup_py(system, yaml_gen, new ArrayList(pluginInstallDirs)))
                        emitCoreFile(fsa, outcome, pkgName + "/resource/" + pkgName, "")
                        emitCoreFile(fsa, outcome, pkgName + "/" + pkgName + "/__init__.py", "")
                    }
                    if (!hasPkgXml) {
                        emitCoreFile(fsa, outcome, pkgName + "/package.xml", compile_package_xml_python(system))
                    }
                    fsa.deleteFile(pkgName + "/CMakeLists.txt")
                    fsa.deleteFile(pkgName + "/pyproject.toml")
                } else {
                    // CMake package (pure C++, hybrid, or standard bringup package)
                    var boolean cmakeWritten = false
                    if (fsa.isFile(pkgName + "/CMakeLists.txt")) {
                        try {
                            val existingChars = fsa.readTextFile(pkgName + "/CMakeLists.txt")
                            if (existingChars !== null) {
                                val cmakeContent = existingChars.toString
                                val hasLaunchInstall = cmakeContent.contains("install(DIRECTORY launch") || cmakeContent.contains("DIRECTORY launch")
                                val hasIfExistsLaunch = cmakeContent.contains("if(EXISTS \"${CMAKE_CURRENT_SOURCE_DIR}/launch\")")
                                val launchInstallSnippet = '''
install(DIRECTORY launch
  DESTINATION share/${PROJECT_NAME}
  OPTIONAL
)

install(DIRECTORY config
  DESTINATION share/${PROJECT_NAME}
  OPTIONAL
)'''
                                if (hasIfExistsLaunch) {
                                    val updatedCmake = cmakeContent.replaceAll("(?s)if\\(EXISTS\\s+\"\\$\\{CMAKE_CURRENT_SOURCE_DIR\\}/launch\"\\).*?endif\\(\\)(\\s*if\\(EXISTS\\s+\"\\$\\{CMAKE_CURRENT_SOURCE_DIR\\}/config\"\\).*?endif\\(\\))?", launchInstallSnippet)
                                    emitCoreFile(fsa, outcome, pkgName + "/CMakeLists.txt", updatedCmake)
                                    cmakeWritten = true
                                } else if (!hasLaunchInstall && cmakeContent.contains("ament_package()")) {
                                    val updatedCmake = cmakeContent.replace("ament_package()", launchInstallSnippet + "\n\nament_package()")
                                    emitCoreFile(fsa, outcome, pkgName + "/CMakeLists.txt", updatedCmake)
                                    cmakeWritten = true
                                } else {
                                    cmakeWritten = true
                                }
                            }
                        } catch (Exception e) {
                            // ignore
                        }
                    }

                    if (!cmakeWritten) {
                        emitCoreFile(fsa, outcome, pkgName + "/CMakeLists.txt", compile_CMakeLists_ROS2(system, yaml_gen))
                    }

                    // Ensure package.xml has launch dependencies
                    var boolean pkgXmlWritten = false
                    if (fsa.isFile(pkgName + "/package.xml")) {
                        try {
                            val existingChars = fsa.readTextFile(pkgName + "/package.xml")
                            if (existingChars !== null) {
                                val pkgXmlContent = existingChars.toString
                                if (!pkgXmlContent.contains("<exec_depend>launch</exec_depend>") && pkgXmlContent.contains("</package>")) {
                                    val launchDeps = '''
  <exec_depend>ament_index_python</exec_depend>
  <exec_depend>launch</exec_depend>
  <exec_depend>launch_ros</exec_depend>
</package>'''
                                    val updatedPkgXml = pkgXmlContent.replace("</package>", launchDeps)
                                    emitCoreFile(fsa, outcome, pkgName + "/package.xml", updatedPkgXml)
                                    pkgXmlWritten = true
                                } else {
                                    pkgXmlWritten = true
                                }
                            }
                        } catch (Exception e) {
                            // ignore
                        }
                    }

                    if (!pkgXmlWritten && !hasPkgXml) {
                        emitCoreFile(fsa, outcome, pkgName + "/package.xml", compile_package_xml_format3(system))
                    }

                    // Clean redundant Python build files (preserve .puml!)
                    fsa.deleteFile(pkgName + "/setup.py")
                    fsa.deleteFile(pkgName + "/setup.cfg")
                    fsa.deleteFile(pkgName + "/pyproject.toml")
                    fsa.deleteFile(pkgName + "/resource/" + pkgName)
                }
            }
            if (TopicBridgeGenerated(system) || ServiceFromBridgeGenerated(system) || ServiceToBridgeGenerated(system)) {
                emitCoreFile(fsa, outcome, pkgName + "/config/ros1_bridges.yaml",
                    compile_ROS1bridges_config(system))
                emitCoreFile(fsa, outcome, pkgName + "/launch/" + system.getName() + "_bridges.launch.py",
                    compile_toROS2launchbridges(system).toString().replace("\t", "  "))
            }

            if (noConflicts) {
                for (ctx : sysContexts) {
                    for (delPath : ctx.deletedFiles) {
                        if (!coreOwnedPaths.contains(delPath)) {
                            fsa.deleteFile(delPath)
                            outcome.pluginDeletedFiles.add(delPath)
                        }
                    }
                    for (entry : ctx.writtenFiles.entrySet) {
                        fsa.generateFile(entry.key, entry.value)
                        outcome.pluginFiles.put(entry.key, entry.value)
                    }
                }
            }
        }
        return outcome
    }

    private def void emitCoreFile(
        IFileSystemAccess2 fsa,
        SystemGenerationOutcome outcome,
        String relativePath,
        CharSequence content)
    {
        val text = if (content !== null) content.toString else ""
        fsa.generateFile(relativePath, text)
        outcome.coreFiles.put(relativePath, text)
    }

    private def ros.Package enclosingPackage(EObject obj) {
        var cur = obj
        while (cur !== null) {
            if (cur instanceof ros.Package) {
                return cur as ros.Package
            }
            cur = cur.eContainer
        }
        return null
    }
}
