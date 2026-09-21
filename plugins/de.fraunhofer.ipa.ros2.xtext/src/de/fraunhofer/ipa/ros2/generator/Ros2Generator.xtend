package de.fraunhofer.ipa.ros2.generator

import com.google.inject.Inject
import java.util.ArrayList
import java.util.List
import java.util.regex.Pattern
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import ros.Node
import ros.Package

/**
 * Main code generator for ROS 2 package models (.ros2).
 * Deterministically generates C++, Python, or Hybrid ROS 2 node wrappers, runners,
 * algorithm stubs, and build configurations.
 */
class Ros2Generator extends AbstractGenerator {

    @Inject extension Ros2GeneratorHelpers
    @Inject extension Ros2CppWrapperCompiler
    @Inject extension Ros2CppRunnerCompiler
    @Inject extension Ros2PythonWrapperCompiler
    @Inject extension Ros2BuildArtifactsCompiler

    override void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
        val fsaName = fsa.class.simpleName
        if (fsaName == "URIBasedFileSystemAccess" || fsaName == "FileSystemAccessImpl") {
            println("[LSP SHIELD] Blocked automatic background generation on startup for .ros2.")
            return
        }

        // Default invocation: generate both C++ and Python for all nodes targeting host distro
        generateTargeted(resource, fsa, null, "both", "auto", null)
    }

    def void generateTargeted(
        Resource resource,
        IFileSystemAccess2 fsa,
        List<String> targetNodes,
        String languageChoice,
        String targetDistro,
        List<String> existingFiles)
    {
        val distro = if (targetDistro === null || targetDistro.empty || "auto".equalsIgnoreCase(targetDistro)) {
            val envDistro = System.getenv("ROS_DISTRO")
            if (envDistro !== null && !envDistro.empty) envDistro else "humble"
        } else {
            targetDistro.toLowerCase()
        }

        val existingList = if (existingFiles !== null) existingFiles else new ArrayList<String>()

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
                if (targetNodes === null || targetNodes.empty || targetNodes.contains(node.name)) {
                    nodesToGenerate.add(node)
                }
            }

            if (!nodesToGenerate.empty) {
                val lang = if (languageChoice === null || languageChoice.empty) "cpp" else languageChoice.toLowerCase()
                val genCpp = "cpp".equals(lang) || "both".equals(lang)
                val genPy = "python".equals(lang) || "both".equals(lang)

                // Track all C++ and Python nodes for build file configuration
                val cppNodes = new ArrayList<Node>()
                val pythonNodes = new ArrayList<Node>()

                // 1. Check existing files to preserve previously generated nodes of other languages (Hybrid support)
                val cppPattern = Pattern.compile(".*src/([A-Za-z0-9_]+)Wrapper\\.cpp")
                val pyPattern = Pattern.compile(".*([A-Za-z0-9_]+)/([A-Za-z0-9_]+)_wrapper\\.py")

                for (f : existingList) {
                    val mCpp = cppPattern.matcher(f)
                    if (mCpp.matches()) {
                        val nodeName = mCpp.group(1)
                        val existingNode = allPkgNodes.findFirst[name == nodeName]
                        if (existingNode !== null && !cppNodes.contains(existingNode)) {
                            cppNodes.add(existingNode)
                        }
                    }
                    val mPy = pyPattern.matcher(f)
                    if (mPy.matches()) {
                        val nodeName = mPy.group(2)
                        val existingNode = allPkgNodes.findFirst[toSnakeCase(name) == nodeName || name == nodeName]
                        if (existingNode !== null && !pythonNodes.contains(existingNode)) {
                            pythonNodes.add(existingNode)
                        }
                    }
                }

                // 2. Generate C++ Artifacts
                if (genCpp) {
                    for (node : nodesToGenerate) {
                        if (!cppNodes.contains(node)) {
                            cppNodes.add(node)
                        }

                        // Wrapper Header (Overwritten on generation)
                        fsa.generateFile(
                            pkgName + "/include/" + pkgName + "/" + toCamelCase(node.name) + "Wrapper.hpp",
                            compileHeader(pkg, node)
                        )

                        // Wrapper Source (Overwritten on generation)
                        fsa.generateFile(
                            pkgName + "/src/" + toCamelCase(node.name) + "Wrapper.cpp",
                            compileSource(pkg, node)
                        )

                        // Standalone Runner & Component Export (Overwritten on generation)
                        fsa.generateFile(
                            pkgName + "/src/" + toCamelCase(node.name) + "Runner.cpp",
                            compileCppRunner(pkg, node)
                        )

                        // Pure Algorithm Template (Protected: only if not already existing)
                        val algoHeaderPath = pkgName + "/include/" + pkgName + "/" + toCamelCase(node.name) + "Algorithm.hpp"
                        val alreadyExists = existingList.exists[contains(toCamelCase(node.name) + "Algorithm.hpp")]
                        if (!alreadyExists) {
                            fsa.generateFile(algoHeaderPath, compileCoreLogicStub(pkg, node))
                        }
                    }
                }

                // 3. Generate Python Artifacts
                if (genPy) {
                    for (node : nodesToGenerate) {
                        if (!pythonNodes.contains(node)) {
                            pythonNodes.add(node)
                        }

                        val snakeNode = toSnakeCase(node.name)

                        // __init__.py
                        fsa.generateFile(pkgName + "/" + pkgName + "/__init__.py", "")

                        // Resource marker
                        fsa.generateFile(pkgName + "/resource/" + pkgName, "")

                        // Python Wrapper (Overwritten on generation)
                        fsa.generateFile(
                            pkgName + "/" + pkgName + "/" + snakeNode + "_wrapper.py",
                            compileWrapper(pkg, node)
                        )

                        // Python Runner Entrypoint (Overwritten on generation)
                        fsa.generateFile(
                            pkgName + "/" + pkgName + "/" + snakeNode + "_runner.py",
                            compilePythonRunner(pkg, node)
                        )

                        // Pure Logic Template (Protected: only if not already existing)
                        val logicPath = pkgName + "/" + pkgName + "/" + snakeNode + "_logic.py"
                        val alreadyExists = existingList.exists[contains(snakeNode + "_logic.py")]
                        if (!alreadyExists) {
                            fsa.generateFile(logicPath, compileLogicStub(pkg, node))
                        }
                    }
                }

                // 4. Generate Build Files (Package.xml, CMakeLists.txt, setup.py / pyproject.toml)
                fsa.generateFile(
                    pkgName + "/package.xml",
                    compilePackageXml(pkg, cppNodes, pythonNodes, distro)
                )

                // If C++ is involved (pure C++ or hybrid), generate CMakeLists.txt
                if (!cppNodes.empty) {
                    fsa.generateFile(
                        pkgName + "/CMakeLists.txt",
                        compileCMakeLists(pkg, cppNodes, pythonNodes, distro)
                    )
                } else if (!pythonNodes.empty) {
                    // Pure Python package
                    val isJazzyOrRolling = "jazzy".equalsIgnoreCase(distro) || "rolling".equalsIgnoreCase(distro)
                    if (isJazzyOrRolling) {
                        fsa.generateFile(
                            pkgName + "/pyproject.toml",
                            compilePyprojectToml(pkg, pythonNodes)
                        )
                    }
                    fsa.generateFile(
                        pkgName + "/setup.py",
                        compileSetupPy(pkg, pythonNodes)
                    )
                    fsa.generateFile(
                        pkgName + "/setup.cfg",
                        compileSetupCfg(pkg)
                    )
                }
            }
        }
    }
}
