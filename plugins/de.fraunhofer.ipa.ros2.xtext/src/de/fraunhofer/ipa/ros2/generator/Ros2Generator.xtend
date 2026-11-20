package de.fraunhofer.ipa.ros2.generator

import com.google.inject.Inject
import de.fraunhofer.ipa.ros.generator.IPluginAwareGenerator
import de.fraunhofer.ipa.ros.plugin.spi.PackageBuild
import de.fraunhofer.ipa.ros.plugin.spi.PackageGenerationContext
import de.fraunhofer.ipa.ros.plugin.spi.PluginRegistry
import de.fraunhofer.ipa.ros2.distro.Ros2Distros
import de.fraunhofer.ipa.ros2.distro.dialect.Ros2Target
import java.nio.file.Path
import java.util.ArrayList
import java.util.IdentityHashMap
import java.util.LinkedHashMap
import java.util.LinkedHashSet
import java.util.List
import java.util.Map
import java.util.Set
import java.util.regex.Pattern
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import ros.Node
import ros.Package
import ros.Plugin
import de.fraunhofer.ipa.ros.plugin.model.PluginBases

/**
 * Main code generator for ROS 2 package models (.ros2).
 * Deterministically generates C++, Python, or Hybrid ROS 2 node wrappers, runners,
 * algorithm stubs, and build configurations, followed by active Phase B plugin generators.
 */
class Ros2Generator extends AbstractGenerator implements IPluginAwareGenerator {

    @Inject extension Ros2GeneratorHelpers
    @Inject extension Ros2CppWrapperCompiler
    @Inject extension Ros2CppRunnerCompiler
    @Inject extension Ros2PythonWrapperCompiler
    @Inject extension Ros2BuildArtifactsCompiler

    static class PluginGenerationOutcome extends IPluginAwareGenerator.Outcome {
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
        return generateTargetedWithPlugins(resource, fsa, targetNodes, languageChoice, targetDistro, existingFiles, outputRoot)
    }

    override void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
        val fsaName = fsa.class.simpleName
        if (fsaName == "URIBasedFileSystemAccess" || fsaName == "FileSystemAccessImpl") {
            println("[LSP SHIELD] Blocked automatic background generation on startup for .ros2.")
            return
        }

        // Default invocation: generate both C++ and Python for all nodes targeting the host distro
        generateTargeted(resource, fsa, null, "both", Ros2Distros.AUTO, null)
    }

    /**
     * @param targetDistro a name from {@link Ros2Distros}, or {@code "auto"}/{@code null} for
     *        {@code $ROS_DISTRO} falling back to the newest LTS
     * @throws de.fraunhofer.ipa.ros2.distro.UnknownDistroException for unsupported distributions
     */
    def void generateTargeted(
        Resource resource,
        IFileSystemAccess2 fsa,
        List<String> targetNodes,
        String languageChoice,
        String targetDistro,
        List<String> existingFiles)
    {
        generateTargetedWithPlugins(resource, fsa, targetNodes, languageChoice, targetDistro, existingFiles)
    }

    def PluginGenerationOutcome generateTargetedWithPlugins(
        Resource resource,
        IFileSystemAccess2 fsa,
        List<String> targetNodes,
        String languageChoice,
        String targetDistro,
        List<String> existingFiles)
    {
        return generateTargetedWithPlugins(resource, fsa, targetNodes, languageChoice, targetDistro, existingFiles, null)
    }

    def PluginGenerationOutcome generateTargetedWithPlugins(
        Resource resource,
        IFileSystemAccess2 fsa,
        List<String> targetNodes,
        String languageChoice,
        String targetDistro,
        List<String> existingFiles,
        Path outputRoot)
    {
        val target = Ros2Target.resolve(targetDistro)
        val outcome = new PluginGenerationOutcome()
        val existingList = if (existingFiles !== null) existingFiles else new ArrayList<String>()
        val activePlugins = PluginRegistry.INSTANCE.activePlugins()
        outcome.notices.addAll(PluginRegistry.INSTANCE.notices())

        for (pkg : resource.allContents.toIterable.filter(Package)) {
            val pkgName = pkg.name.toLowerCase
            val allPkgNodes = new ArrayList<Node>()
            for (art : pkg.artifact) {
                if (art.node !== null) {
                    allPkgNodes.add(art.node)
                }
            }

            // Determine which nodes from this resource should be generated
            val nodesToGenerate = new ArrayList<Node>()
            for (node : allPkgNodes) {
                if (targetNodes === null || targetNodes.empty ||
                    targetNodes.contains(node.artifactName) ||
                    targetNodes.contains(toCamelCase(node.artifactName)) ||
                    targetNodes.contains(node.name) ||
                    targetNodes.contains(toCamelCase(node.name))) {
                    nodesToGenerate.add(node)
                }
            }

            val allPlugins = getAllPlugins(pkg)
            val pluginlibPlugins = allPlugins.filter[PluginBases.isPluginlib(it)].toList
            val extPlugins = allPlugins.filter[!PluginBases.isPluginlib(it)].toList
            val generatePlugins = !allPlugins.empty && (targetNodes === null || targetNodes.empty ||
                pkg.artifact.exists[art | art.plugins.exists[pl |
                    targetNodes.contains(art.name) || targetNodes.contains(pl.name) || targetNodes.contains(pluginClassName(pl))
                ]])

            if (!nodesToGenerate.empty || generatePlugins) {
                val lang = if (languageChoice === null || languageChoice.empty) "cpp" else languageChoice.toLowerCase()
                val genCpp = "cpp".equals(lang) || "both".equals(lang)
                val genPy = "python".equals(lang) || "both".equals(lang)

                val cppNodes = new ArrayList<Node>()
                val pythonNodes = new ArrayList<Node>()
                val coreGeneratedFiles = new LinkedHashMap<String, String>()

                // 1. Check existing files to preserve previously generated nodes of other languages (Hybrid support)
                val cppPattern = Pattern.compile(".*src/([A-Za-z0-9_]+)Wrapper\\.cpp")
                val pyPattern = Pattern.compile(".*([A-Za-z0-9_]+)/([A-Za-z0-9_]+)_wrapper\\.py")

                for (f : existingList) {
                    val belongsToPackage = f.startsWith(pkgName + "/") || f.startsWith("src-gen/" + pkgName + "/") || !f.contains("/")
                    if (belongsToPackage) {
                        val mCpp = cppPattern.matcher(f)
                        if (mCpp.matches()) {
                            val matchedName = mCpp.group(1)
                            val existingNode = allPkgNodes.findFirst[
                                toCamelCase(artifactName) == matchedName ||
                                artifactName == matchedName ||
                                toCamelCase(name) == matchedName ||
                                name == matchedName
                            ]
                            if (existingNode !== null && !cppNodes.contains(existingNode)) {
                                cppNodes.add(existingNode)
                            }
                        }
                        val mPy = pyPattern.matcher(f)
                        if (mPy.matches()) {
                            val matchedName = mPy.group(2)
                            val existingNode = allPkgNodes.findFirst[
                                toSnakeCase(artifactName) == matchedName ||
                                toSnakeCase(name) == matchedName ||
                                name == matchedName
                            ]
                            if (existingNode !== null && !pythonNodes.contains(existingNode)) {
                                pythonNodes.add(existingNode)
                            }
                        }
                    }
                }

                // 2. Phase A: Generate C++ Artifacts
                if (genCpp) {
                    for (node : nodesToGenerate) {
                        if (!cppNodes.contains(node)) {
                            cppNodes.add(node)
                        }

                        pythonNodes.removeIf[it == node || it.name == node.name || it.artifactName == node.artifactName]
                        deleteCoreFile(fsa, outcome, pkgName + "/" + pkgName + "/" + toSnakeCase(node.name) + "_wrapper.py")
                        deleteCoreFile(fsa, outcome, pkgName + "/" + pkgName + "/" + toSnakeCase(node.name) + "_runner.py")
                        deleteCoreFile(fsa, outcome, pkgName + "/" + pkgName + "/" + toSnakeCase(node.name) + "_logic.py")

                        val artCamel = toCamelCase(node.artifactName)

                        emitCoreFile(fsa, outcome, coreGeneratedFiles,
                            pkgName + "/include/" + pkgName + "/" + artCamel + "Wrapper.hpp",
                            compileHeader(pkg, node, artCamel))
                        emitCoreFile(fsa, outcome, coreGeneratedFiles,
                            pkgName + "/src/" + artCamel + "Wrapper.cpp",
                            compileSource(pkg, node, artCamel, target))
                        emitCoreFile(fsa, outcome, coreGeneratedFiles,
                            pkgName + "/include/" + pkgName + "/" + artCamel + "Node.hpp",
                            compileCppNodeHeader(pkg, node, artCamel, target))
                        emitCoreFile(fsa, outcome, coreGeneratedFiles,
                            pkgName + "/src/" + artCamel + "Node.cpp",
                            compileCppNodeSource(pkg, node, artCamel))
                        emitCoreFile(fsa, outcome, coreGeneratedFiles,
                            pkgName + "/src/" + artCamel + "Runner.cpp",
                            compileCppRunner(pkg, node, artCamel))

                        val algoHeaderPath = pkgName + "/include/" + pkgName + "/" + artCamel + "Algorithm.hpp"
                        val alreadyExists = existingList.exists[
                            it == algoHeaderPath ||
                            (it.startsWith(pkgName + "/") && it.endsWith("/" + artCamel + "Algorithm.hpp")) ||
                            (it.startsWith("src-gen/" + pkgName + "/") && it.endsWith("/" + artCamel + "Algorithm.hpp"))
                        ]
                        if (!alreadyExists) {
                            emitCoreFile(fsa, outcome, coreGeneratedFiles, algoHeaderPath, compileCoreLogicStub(pkg, node, artCamel))
                        }
                    }
                }

                // 2b. Generate C++ pluginlib Artifacts (external plugins intentionally emit no class/interface code in Phase A)
                if (generatePlugins && !pluginlibPlugins.empty) {
                    for (art : pkg.artifact) {
                        for (pl : art.plugins.filter[PluginBases.isPluginlib(it)]) {
                            val matchTarget = targetNodes === null || targetNodes.empty ||
                                targetNodes.contains(art.name) ||
                                targetNodes.contains(pl.name) ||
                                targetNodes.contains(pluginClassName(pl))
                            if (matchTarget) {
                                val snakePlugin = pluginSnakeName(pl)
                                val wrapperPath = pkgName + "/include/" + pkgName + "/" + snakePlugin + "_plugin_wrapper.hpp"
                                val userPath = pkgName + "/include/" + pkgName + "/" + snakePlugin + "_plugin.hpp"
                                val cppPath = pkgName + "/src/" + snakePlugin + "_plugin.cpp"

                                emitCoreFile(fsa, outcome, coreGeneratedFiles, wrapperPath, compilePluginWrapperHpp(pkg, art, pl, target))
                                emitCoreFile(fsa, outcome, coreGeneratedFiles, cppPath, compilePluginCpp(pkg, art, pl))

                                val userHeaderExists = existingList.exists[
                                    it == userPath ||
                                    (it.startsWith(pkgName + "/") && it.endsWith("/" + snakePlugin + "_plugin.hpp")) ||
                                    (it.startsWith("src-gen/" + pkgName + "/") && it.endsWith("/" + snakePlugin + "_plugin.hpp"))
                                ]
                                if (!userHeaderExists) {
                                    emitCoreFile(fsa, outcome, coreGeneratedFiles, userPath, compilePluginUserHpp(pkg, art, pl))
                                }
                            }
                        }
                    }
                    emitCoreFile(fsa, outcome, coreGeneratedFiles, pkgName + "/plugins.xml", compilePluginsXml(pkg))
                }

                // 3. Generate Python Artifacts
                if (genPy) {
                    emitCoreFile(fsa, outcome, coreGeneratedFiles, pkgName + "/" + pkgName + "/__init__.py", "")

                    for (node : nodesToGenerate) {
                        if (!pythonNodes.contains(node)) {
                            pythonNodes.add(node)
                        }

                        cppNodes.removeIf[it == node || it.name == node.name || it.artifactName == node.artifactName]
                        val artCamel = toCamelCase(node.artifactName)
                        deleteCoreFile(fsa, outcome, pkgName + "/include/" + pkgName + "/" + artCamel + "Wrapper.hpp")
                        deleteCoreFile(fsa, outcome, pkgName + "/include/" + pkgName + "/" + artCamel + "Node.hpp")
                        deleteCoreFile(fsa, outcome, pkgName + "/include/" + pkgName + "/" + artCamel + "Algorithm.hpp")
                        deleteCoreFile(fsa, outcome, pkgName + "/src/" + artCamel + "Wrapper.cpp")
                        deleteCoreFile(fsa, outcome, pkgName + "/src/" + artCamel + "Node.cpp")
                        deleteCoreFile(fsa, outcome, pkgName + "/src/" + artCamel + "Runner.cpp")

                        val snakeNode = toSnakeCase(node.name)

                        emitCoreFile(fsa, outcome, coreGeneratedFiles,
                            pkgName + "/" + pkgName + "/" + snakeNode + "_wrapper.py",
                            compileWrapper(pkg, node))
                        emitCoreFile(fsa, outcome, coreGeneratedFiles,
                            pkgName + "/" + pkgName + "/" + snakeNode + "_runner.py",
                            compilePythonRunner(pkg, node))

                        val logicPath = pkgName + "/" + pkgName + "/" + snakeNode + "_logic.py"
                        val alreadyExists = existingList.exists[
                            it == logicPath ||
                            (it.startsWith(pkgName + "/") && it.endsWith("/" + snakeNode + "_logic.py")) ||
                            (it.startsWith("src-gen/" + pkgName + "/") && it.endsWith("/" + snakeNode + "_logic.py"))
                        ]
                        if (!alreadyExists) {
                            emitCoreFile(fsa, outcome, coreGeneratedFiles, logicPath, compileLogicStub(pkg, node))
                        }
                    }
                }

                // Reserve EVERY core-owned path (whether written, deleted, or skipped because it exists on disk,
                // including protected Algorithm.hpp / _logic.py / _plugin.hpp user logic files).
                val Set<String> coreOwnedPaths = new LinkedHashSet<String>()
                coreOwnedPaths.addAll(coreGeneratedFiles.keySet)
                for (node : allPkgNodes) {
                    val artCamel = toCamelCase(node.artifactName)
                    val snakeNode = toSnakeCase(node.name)
                    coreOwnedPaths.add(pkgName + "/include/" + pkgName + "/" + artCamel + "Wrapper.hpp")
                    coreOwnedPaths.add(pkgName + "/include/" + pkgName + "/" + artCamel + "Node.hpp")
                    coreOwnedPaths.add(pkgName + "/include/" + pkgName + "/" + artCamel + "Algorithm.hpp")
                    coreOwnedPaths.add(pkgName + "/src/" + artCamel + "Wrapper.cpp")
                    coreOwnedPaths.add(pkgName + "/src/" + artCamel + "Node.cpp")
                    coreOwnedPaths.add(pkgName + "/src/" + artCamel + "Runner.cpp")
                    coreOwnedPaths.add(pkgName + "/" + pkgName + "/__init__.py")
                    coreOwnedPaths.add(pkgName + "/" + pkgName + "/" + snakeNode + "_wrapper.py")
                    coreOwnedPaths.add(pkgName + "/" + pkgName + "/" + snakeNode + "_runner.py")
                    coreOwnedPaths.add(pkgName + "/" + pkgName + "/" + snakeNode + "_logic.py")
                }
                for (pl : pluginlibPlugins) {
                    val snakePlugin = pluginSnakeName(pl)
                    coreOwnedPaths.add(pkgName + "/include/" + pkgName + "/" + snakePlugin + "_plugin_wrapper.hpp")
                    coreOwnedPaths.add(pkgName + "/include/" + pkgName + "/" + snakePlugin + "_plugin.hpp")
                    coreOwnedPaths.add(pkgName + "/src/" + snakePlugin + "_plugin.cpp")
                }
                if (!pluginlibPlugins.empty) {
                    coreOwnedPaths.add(pkgName + "/plugins.xml")
                }
                coreOwnedPaths.add(pkgName + "/package.xml")
                coreOwnedPaths.add(pkgName + "/CMakeLists.txt")
                coreOwnedPaths.add(pkgName + "/setup.py")
                coreOwnedPaths.add(pkgName + "/setup.cfg")
                coreOwnedPaths.add(pkgName + "/pyproject.toml")
                coreOwnedPaths.add(pkgName + "/resource/" + pkgName)

                // 3b. Phase B: Execute active RosToolingPlugin generators and collect PackageBuild contributions
                var PackageBuild pluginBuild = null
                if (!activePlugins.empty) {
                    pluginBuild = new PackageBuild(pkgName)
                    pluginBuild.setCurrentPluginId("core")
                    populateCorePackageBuild(pkg, cppNodes, pythonNodes, pluginBuild)

                    val Map<String, String> allPluginOwnedFiles = new LinkedHashMap()
                    val Map<Plugin, String> externalRegistrations = new IdentityHashMap()
                    val List<PackageGenerationContext> contexts = new ArrayList()

                    for (plugin : activePlugins) {
                        pluginBuild.setCurrentPluginId(plugin.id)
                        val ctx = new PackageGenerationContext(
                            plugin.id,
                            pkg,
                            resource,
                            target.distro,
                            outputRoot,
                            existingList,
                            coreOwnedPaths,
                            allPluginOwnedFiles,
                            externalRegistrations,
                            pluginBuild,
                            outcome.pluginConflictErrors,
                            PluginRegistry.INSTANCE
                        )
                        plugin.generatePackage(ctx)
                        contexts.add(ctx)
                        outcome.notices.addAll(ctx.notices)
                    }
                    pluginBuild.setCurrentPluginId("core")

                    for (ep : extPlugins) {
                        val art = ep.eContainer as ros.Artifact
                        val matchesTarget = targetNodes === null || targetNodes.empty ||
                            targetNodes.contains(art?.name) ||
                            targetNodes.contains(ep.name) ||
                            targetNodes.contains(pluginClassName(ep))
                        if (matchesTarget && !externalRegistrations.containsKey(ep)) {
                            outcome.errors.add("External plugin '" + ep.name + "' (loader: external) in package '" + pkg.name + "' is not claimed by any active RosToolingPlugin.")
                        }
                    }

                    outcome.pluginConflictErrors.addAll(pluginBuild.conflictErrors)
                    outcome.errors.addAll(outcome.pluginConflictErrors)

                    if (outcome.errors.empty) {
                        for (ctx : contexts) {
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
                } else if (generatePlugins && !extPlugins.empty) {
                    for (ep : extPlugins) {
                        outcome.errors.add("External plugin '" + ep.name + "' (loader: external) in package '" + pkg.name + "' is not claimed by any active RosToolingPlugin.")
                    }
                }

                // 4. Single-author rendering of Build Files (package.xml, CMakeLists.txt, setup.py)
                val effectiveBuild = if (outcome.errors.empty) pluginBuild else null
                emitCoreFile(fsa, outcome, coreGeneratedFiles,
                    pkgName + "/package.xml",
                    compilePackageXml(pkg, cppNodes, pythonNodes, effectiveBuild))

                val needsCMake = !cppNodes.empty || !allPlugins.empty
                    || (effectiveBuild !== null && (!effectiveBuild.libraries.empty || !effectiveBuild.executables.empty))
                if (needsCMake) {
                    emitCoreFile(fsa, outcome, coreGeneratedFiles,
                        pkgName + "/CMakeLists.txt",
                        compileCMakeLists(pkg, cppNodes, pythonNodes, target, effectiveBuild))
                    deleteCoreFile(fsa, outcome, pkgName + "/setup.py")
                    deleteCoreFile(fsa, outcome, pkgName + "/setup.cfg")
                    deleteCoreFile(fsa, outcome, pkgName + "/pyproject.toml")
                    deleteCoreFile(fsa, outcome, pkgName + "/resource/" + pkgName)
                } else if (!pythonNodes.empty) {
                    emitCoreFile(fsa, outcome, coreGeneratedFiles, pkgName + "/resource/" + pkgName, "")
                    emitCoreFile(fsa, outcome, coreGeneratedFiles, pkgName + "/setup.py", compileSetupPy(pkg, pythonNodes))
                    emitCoreFile(fsa, outcome, coreGeneratedFiles, pkgName + "/setup.cfg", compileSetupCfg(pkg))
                    deleteCoreFile(fsa, outcome, pkgName + "/CMakeLists.txt")
                    deleteCoreFile(fsa, outcome, pkgName + "/pyproject.toml")
                }
            }
        }
        return outcome
    }

    private def void emitCoreFile(
        IFileSystemAccess2 fsa,
        PluginGenerationOutcome outcome,
        Map<String, String> coreGeneratedFiles,
        String relativePath,
        String content)
    {
        coreGeneratedFiles.put(relativePath, content)
        outcome.coreFiles.put(relativePath, content)
        fsa.generateFile(relativePath, content)
    }

    private def void deleteCoreFile(IFileSystemAccess2 fsa, PluginGenerationOutcome outcome, String relativePath) {
        fsa.deleteFile(relativePath)
        outcome.coreDeletedFiles.add(relativePath)
    }
}
