# Changelog

All notable changes to the **RosTooling** model and generator plugins will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [3.6.0] - 2026-11-18

### Added
- **Passive Plugin Discovery Metadata & Read-Only Documentation Commands**:
  - Documented `META-INF/rostooling-plugin.properties` (`id`, `version`, `supportedCoreVersionRange`, `summary`, optional `documentation` Markdown path inside the JAR) and read-only scanning via `java.util.jar.JarFile` in `PluginRegistry` (capped at 16 KB metadata / 256 KB documentation, never unpacking or instantiating disabled plugin classes), verifying `id()`/`version()` against JAR metadata upon activation.
  - Added LSP commands `rostooling.listDiscoveredPlugins` and `rostooling.getPluginDocumentation` returning immutable discovered-plugin descriptors (including active classpath/OSGi providers) and Markdown documentation for active or inactive plugins without running plugin code.
- **Scoped Plugin File Read Extension Point (`GenerationContext.readOwnedFile`)**:
  - Added `GenerationContext.readOwnedFile(String)` returning `Optional<String>` for plugin-owned files inside `config/<plugin-folder>/`, `launch/<plugin-folder>/`, or `plugins/<plugin-folder>/` present in `existingFiles()`, resolved safely against the optional client-supplied `outputRoot` (package output folder for `.ros2`, system `src-gen` output folder for `.rossystem`), with `..`/absolute/symlink escape rejection and empty return on missing root or unreadable files.
- **Plugin Notice Extension Point (`GenerationContext.addNotice`)**:
  - Added `GenerationContext.addNotice(String)` and `GenerationContext.notices()` so active plugins can emit non-blocking, plugin-ID-prefixed informational notices alongside package and system generation results without altering core outputs when no plugins are active.
- **Generic Plugin SPI (`de.fraunhofer.ipa.ros.plugin.spi`)**:
  - Added `RosToolingPlugin`, `PluginRegistry` (passive JAR `ServiceLoader` and OSGi service discovery enabled only via configuration, dependency ordering, version range `CORE_VERSION = "3.6.0"`), sealed `GenerationContext`, `PackageGenerationContext`, `SystemGenerationContext`, and `PackageBuild`.
  - Supported both package-level (`generatePackage`) and system-level (`generateSystem`) generation phases backed by validated and XML/CMake-escaped structured `PackageBuild` contributions (`depend`, `find_package`, targets, `install`, `ament_add_gtest`, XML exports), plus external plugin registration claims (`claimExternalPluginRegistration`).
  - Added typed Ecore schema mapping, structured hover documentation, content assist, and type/instance block merging (`ExtensionBlockMerger`) for plugin blocks.
- **`@` Extension Blocks & LSP/GLSP Commands**:
  - Added generic `@<name>:` extension block syntax across `.ros`, `.ros2`, and `.rossystem` at `System`, `RosNode`, `Node`, `Plugin`, and `RosInterface` hook locations, resolving references to sibling interfaces and parameters (`pub->`, `sub->`, etc.).
  - Unknown `@` extension blocks degrade gracefully with validation warnings only so models remain portable when plugins are absent.
  - Added LSP commands (`rostooling.listPluginTools`, `rostooling.getExtensionBlock`, `rostooling.setExtensionBlock`, `rostooling.executePluginTool`, `rostooling.generatePluginOutputs`) exposing schema-derived typed tool metadata (`setToolName`) and generic block authoring.
  - Added GLSP `@` block editing, `PluginSlot.valueFormat` (`class` | `library`), and launch substitution parameter test coverage (`LaunchSubstitutionGenerationTest`).
- **Scoped Plugin Launch Includes & Namespaced System Folders**:
  - Added `SystemGenerationContext.addLaunchInclude(...)` rendering each plugin launch include inside its own isolated `GroupAction(actions=[IncludeLaunchDescription(...)], scoped=True)` with validated `LITERAL`, `SYSTEM_LAUNCH_ARG`, and `SUBSTITUTION` arguments.
  - Added namespaced plugin output folders (`config/<plugin-folder>/`, `launch/<plugin-folder>/`, `plugins/<plugin-folder>/`) and automatic recursive `data_files` installation in generated `setup.py` for pure-Python system packages (with a warning when a user-owned `setup.py` is preserved untouched).

### Changed
- **Ownership & Domain Logic Shield Enforcement**:
  - Reserved all core-owned and protected user logic paths in `coreOwnedPaths()` (paths only, never contents) across package and system generation, separated core in-memory deletions from `pluginDeletedFiles`, and restricted `GenerationContext.deleteStaleFile` at both package and system level strictly to `config/<plugin-folder>/`, `launch/<plugin-folder>/`, and `plugins/<plugin-folder>/`.

### Fixed
- **GLSP String Parameter Escaping**:
  - Escaped string parameter values per the Xtext `STRING` terminal in `RosAstNodeModelSerializer` while keeping unchanged literals byte-identical.

## [3.5.0] - 2026-11-16

### Added
- **ROS 2 Distribution Registry (`de.fraunhofer.ipa.ros2.distro`, new bundle)**:
  - Added `Ros2Distros` as the single list of supported distributions (Humble, Jazzy, Kilted, Lyrical, Rolling); each entry derives from its predecessor and overrides only what changed. `auto` resolves to `$ROS_DISTRO`, else the newest LTS; unknown names are rejected with the supported list.
  - Added `Ros2Distro` values (C++ standard, CMake minimum), variants (`ServiceQosArgument`, `RateImplementation`) and status, taken from the official `ros:<distro>` images.
  - Added `CppDialect`, `CMakeDialect` and `Ros2Target` as the only code that turns a distribution into generated code fragments.
- **Distribution-Aware `.ros2` Code Generation**:
  - The C++/Python wrapper, runner and build-file templates take a `Ros2Target` and get distribution-specific fragments from the dialects: service QoS (`rmw_qos_profile_services_default` on Humble, `rclcpp::ServicesQoS()` from Jazzy), loop rate (`Clock::sleep_until` on Humble, which has no `rclcpp::Rate(hz, clock)`), and `cmake_minimum_required` / `CMAKE_CXX_STANDARD`.
  - `Ros2GeneratorCommandService` resolves the requested distribution up front (`auto` by default), reports the one it used and returns the supported names for an unknown one. Added the LSP command `ros2.listDistros`.
- **Receiver-Driven Auto-Connect over GLSP (`RosAutoConnector`)**:
  - Added `requestRosAutoConnect` / `setRosAutoConnect`: candidate connections by compatibility (complementary kinds, equal resolved types), grouped by receiver port, ranked `remap` > `directed-remap` > `contract` > `fuzzy` > `type-unique` > `type-ambiguous`, with at most one preselection per receiver, an emitter fan-out summary, already-connected receivers, skipped items and an optional verdict for a proposed selection.
  - Added `applyRosAutoConnect { selected }`, which recomputes the candidates and applies them in one `ChangeCommand` (one undo step). A service/action client with more than one selected server gets none; a topic subscriber takes every selected publisher; stale ids are rejected.
  - Endpoints include interfaces declared inside subsystems (recursively); undeclared subsystem interfaces are reported as skipped.
- **Golden-File Tests and Distribution Build Matrix**:
  - Re-enabled `de.fraunhofer.ipa.ros.xtext.tests` in the parent build. Added `Ros2GoldenGenerationTest` (every distribution, C++ and Python), `RosSystemGoldenGenerationTest` and `Ros2DistrosTest` (registry consistency with the CI matrix, golden folders and README badges); `ROSTOOLING_UPDATE_GOLDEN=1` rewrites the expected files.
  - Added the `distro-matrix` workflow and `tools/distro-matrix/build-golden.sh`, which build the golden packages in `ros:<distro>` with deprecations as errors, start every executable and launch the system packages. One status badge per distribution is shown in the README.

### Changed
- **Generated Build Files**:
  - `target_link_libraries(... ${pkg_TARGETS})` replaces `ament_target_dependencies` (deprecated in Kilted, removed in Lyrical and Rolling); `setup.py` uses `extras_require` instead of `tests_require`.
  - Generated `.rossystem` system packages and `.ros2` packages from Kilted on require CMake 3.20 (CMake 4 rejects older minimums).
- **Default Target Distribution**:
  - Without `$ROS_DISTRO`, generation now targets the newest LTS (Jazzy) instead of Humble. Set `ROS_DISTRO=humble` or pass the distribution explicitly to keep Humble output.
- **GLSP Server Packaging**:
  - `de.fraunhofer.ipa.ros.glsp` is now a module of the parent reactor and is published to GitHub Packages with the other bundles. Dependencies Tycho injects into the reactor bundles are excluded, because signed p2 jars next to the Maven Central ones broke class loading.
  - The `de.fraunhofer.ipa.ros.xtext.tests` bundle is built and tested in CI but not published.

### Fixed
- **Lifecycle Nodes in ROS 2 Launch Files**:
  - `LaunchFileCompiler_ROS2` always passes `namespace=` to `LifecycleNode` (empty when the model sets none); launch files previously failed with a `TypeError` on every supported distribution.
- **Connections into Subsystems**:
  - Subsystem interfaces resolve by scoped port id or qualified path (`sub::[...::]node::iface`) without editing other files, and new connections are written with that qualified reference, so manual wiring into subsystems now works.
- **Phantom Interfaces in Saved Models**:
  - `RosAstNodeModelSerializer` writes an interface that is not yet in the file only when a connection uses it, so interfaces synthesized in memory by the rossystem scope provider and validator no longer leak into the file on unrelated edits.
- **Lifecycle Generation Test**:
  - Fixed `Ros2ParsingTest.testLifecycleCppCodeGeneration`, which looked for the lifecycle overrides in the runner instead of the node header.

## [3.4.0] - 2026-11-13

### Added
- **Eclipse GLSP 2.4 Diagram & Model Server (`de.fraunhofer.ipa.ros.glsp`)**:
  - Implemented `RosGlspModule`, `RosDiagramConfiguration`, and `RosXtextModelStorage` to load `.rossystem`, `.ros2`, `.ros1`, and `.ros` Xtext resources with companion models and optional `.layout` sidecars, plus empty-resource bootstrapping for new files.
  - Added `RosGModelFactory` and `RosLayoutEngine` for server-side ELK layered layout, orthogonal routing, pinned position persistence, composable `Process` containers, and collapsed subsystem boundary ports (`ToggleSubSystemOperationHandler`).
  - Added GLSP semantic operation and action handlers (`CreateRosNodeOperationHandler`, `CreateConnectionOperationHandler`, `ReconnectConnectionOperationHandler`, `DeleteRosElementOperationHandler`, `EditRosPropertyOperationHandler`, `RosPackageSetEditor`, `ChangeBoundsOperationHandler`, `IgnoreRoutingPointsOperationHandler`, `RequestRosIndexActionHandler`, `RequestRosTextEditsActionHandler`).
  - Added `RosCatalogueResolver` and `RosModelValidator` for catalogue resolution and live Xtext diagnostics.
- **Surgical Node-Model Serialization (`RosAstNodeModelSerializer`, `RosPackageSetSerializer`, `RosDslText`)**:
  - Implemented `INode`/`ICompositeNode`-guided span edits so unaffected lines, formatting, and `#` comments are preserved across `.rossystem`, `.ros2`, `.ros1`, and `.ros` files.
  - Added initial serialization and property edits for new models (`fromFile:`, `subSystems:`, `Package.name`, `Parameter` `value:`/`default:`, QoS blocks, `active_in:`, and `TopicSpec`/`ServiceSpec`/`ActionSpec`).

### Fixed
- **Pan & Drag Boundary Guard**:
  - Ignored zero/sub-pixel no-op `ChangeBoundsOperation` updates so canvas panning does not pin or move selected nodes unintentionally.

## [3.3.3] - 2026-11-09

### Added
- **Validation Before Code Generation**:
  - Implemented automatic Xtext validation checks in `Ros2GeneratorCommandService` and `RosSystemGeneratorCommandService` prior to code generation.
  - Returns detailed validation error messages and prevents emitting invalid launch or component files when model errors exist.
- **Package-Level Dependencies in Package.xml Generation**:
  - Emitted `<depend>` declarations for all names listed under a package's `dependencies:` block in `Ros2BuildArtifactsCompiler.xtend`.

### Fixed
- **Launch Generator Python Identifier Sanitization**:
  - Sanitized launch argument Python variable names (`pyIdentifier`) in `LaunchFileCompiler_ROS2.xtend` to replace non-identifier characters (such as `.` or `/` in nested parameters) with underscores, preventing `NameError` at launch time.
- **Python Component Process Graceful Shutdown**:
  - Ensured Python node runners exit cleanly upon receiving `SIGINT` / `KeyboardInterrupt` (`Ctrl+C`) without hanging executors.
- **RosSystem List Format Error Diagnostic Message**:
  - Clarified list format error message in `RosSystemValidator.xtend` to display `[ , , ]` format instead of `{ , , }`.
- **Undeclared Launch Substitution Variable Check**:
  - Added warning diagnostic when a parameter expression references `$(var X)` but `X` is not declared as a system-level parameter.

## [3.3.2] - 2026-11-06

### Added
- **ROS 2 Launch Substitution Parameters in .rossystem**:
  - Implemented launch substitution AST compilation in `LaunchFileCompiler_ROS2.xtend` and `GeneratorHelpers.xtend` for parameter expressions (e.g. `$(find-pkg-share ...)`, `$(var ...)`, `$(command ...)`).
  - Added Xtext validator checks in `RosSystemValidator.xtend` for launch substitution expressions verifying balanced parentheses and registered ROS 2 Jazzy substitution names.

### Fixed
- **Launch Generator String Parameter Wrapping**:
  - Wrapped string parameters with `ParameterValue(..., value_type=str)` in launch templates to prevent numbers, booleans, or YAML colons from being coerced into unexpected types.
- **Python Runner Parameter Forwarding**:
  - Forwarded parameters in `on_parameters_changed` callback to `super().on_parameters_changed(parameters)` in generated Python wrappers.

## [3.3.1] - 2026-11-03

### Added
- **Scoped Remapped Interface Resolution in `.rossystem`**:
  - Implemented custom scoping in `RosSystemScopeProvider` supporting double-colon qualified names (`<node>::<interface>` and `<subsystem>::<node>::<interface>`) to deterministically resolve connection endpoints when multiple nodes or subsystems declare identically named interfaces.
  - Added recursive subsystem scope resolution: traverses nested subsystem components and resolves EMF proxies (`EcoreUtil.resolve`) to accurately calculate global interface name collisions across root systems and subsystems.
  - Implemented automatic synthetic interface derivation in `RosSystemScopeProvider` and `RosSystemValidator`: automatically exposes synthetic `RosInterface` instances for publishers, subscribers, service servers, service clients, action servers, and action clients when a node references an underlying ROS component without an explicit `interfaces:` block.
  - Enhanced `RosSystemQNP` to provide fully qualified names for `RosInterface` elements (`<container>::<interface>`), enabling hyperlinking and Go-to-Definition (Ctrl + Click) navigation directly to remapped interface definitions across nodes and subsystems.

### Changed
- **Backwards-Compatible Interface Scoping**:
  - Maintained 100% backward compatibility for `.rossystem` models: short unqualified interface names (e.g. `- [filtered_image_pub, filtered_image_sub]`) remain fully valid and resolvable whenever the interface name is unique across the system hierarchy.
  - Standardized connection scoping syntax strictly on the double-colon format (`::`) to eliminate ambiguity and prevent parsing conflicts with dot notation.

### Fixed
- **Subsystem Connection Validation & Null Safety**:
  - Resolved subsystem proxy references in `RosSystemValidator.xtend` (`checkIfInterfaceInSystem`, `checkPortPatterns`, `MatchPortMsgs`) when validating connections traversing subsystem boundaries.
  - Added null, proxy, and reference checks across connection validation rules, preventing unhandled `NullPointerException`s during real-time validation of partially defined or proxy connections.
- **Maven Wrapper & Tycho Build Resolution**:
  - Added Maven Wrapper (`mvnw`) pinned to Maven 3.9.9, resolving Tycho 4.0.12 prerequisite errors (`requires Maven version 3.9.0`) on environments with older system Maven packages and ensuring deterministic builds locally and across CI.
  - Aligned GitHub Actions workflows (`build.yml` and `maven-publish.yml`) to invoke `./mvnw`.
  - Removed stale `xtextVersion` override in `de.fraunhofer.ipa.ros.feature/pom.xml` to correctly inherit 2.42.0 and eliminate p2 repository resolution failures.
  - Fixed Xtend source compilation errors in `RosSystemValidator.xtend`, `RosSystemScopeProvider.xtend`, and `RosSystemQNP.xtend` (reserved keyword conflicts in loops and missing imports).

## [3.3.0] - 2026-10-05

### Added
- **Composable Node Container & Component Launch Generation**:
  - Added support for launching ROS 2 nodes as composable components inside `ComposableNodeContainer` via `.rossystem` `processes:` definition.
  - Dynamically selects container executable: `component_container_mt` with `MultiThreadedExecutor` (when `proc.threads > 1`) or `component_container` with `SingleThreadedExecutor` (when `proc.threads <= 1`).
  - Emits container action hosting `launch_ros.descriptions.ComposableNode` instances with package, plugin (`<pkg>::<artCamel>Node`), node name, remappings, and parameters.
  - Preserves standalone execution: nodes not assigned to any process launch as standalone OS executables via `Node` or `LifecycleNode`.
  - Metamodel backwards compatibility: if `processes:` is omitted, all nodes launch as standalone executables as before.
  - Emits `<exec_depend>rclcpp_components</exec_depend>` in `package.xml` when component containers are modeled in the system.
- **C++ Component Architecture & Node Decoupling**:
  - Decoupled `«artCamel»Node` (which bridges ROS 2 communication wrappers to domain algorithms) from `Runner.cpp` into dedicated `include/<pkg>/«artCamel»Node.hpp` and `src/«artCamel»Node.cpp`.
  - Registered `«pkg»::«artCamel»Node` via `RCLCPP_COMPONENTS_REGISTER_NODE` in `Node.cpp`.
  - Added `«artCamel»Node.cpp` to `add_library(«artCamel»_component SHARED ...)` and registered nodes with `rclcpp_components_register_nodes`.
  - Refactored `Runner.cpp` into a lightweight executable entry point instantiating and spinning `«artCamel»Node`. This ensures both standalone executables and composable container nodes invoke the domain algorithm.
- **Action Client Timeout Configuration & Backward-Compatible Variadic Injection**:
  - Added optional timeout configuration to pure C++ core algorithms (`set_«name»_server_timeout()`, `get_«name»_server_timeout()`, and per-call `send_«name»_goal_async(..., timeout = std::nullopt)`).
  - Injected action client caller via variadic generic lambda `[this](const auto & goal, auto resp_cb, auto fb_cb, auto res_cb, auto ... timeout_opt)` in `Ros2CppRunnerCompiler.xtend`.
  - Ensures 100% backward compatibility: seamlessly converts to both legacy 2-argument (`goal_fn`, `cancel_fn`) and new timeout-enabled `GoalCaller` function signatures in protected `*Algorithm.hpp` files without compilation errors.
  - Added `cancel_all_«name»_goals_async()` method to action client wrappers and runners.
- **Package-Scoped File Persistence Checks**:
  - Scoped `alreadyExists` checks in `Ros2Generator.xtend` to only match files within the current package directory (`pkgName/include/pkgName/*Algorithm.hpp` and `pkgName/pkgName/*_logic.py`).
  - Moving algorithm or logic files to an external directory or another package no longer triggers false positive persistence matches; stubs are cleanly recreated within the package directory.
  - Scoped hybrid language detection patterns to only evaluate files within the active package path.
  - Scoped Eclipse handlers (`GenerationRos2CppHandler.java`, `GenerationRos2PythonHandler.java`) to collect files only from `src-gen/<pkgName>`.
- **Process Validation Rules in RosSystemValidator**:
  - Added `checkUniqueProcessAssignment`: reports an error if a node is assigned to multiple processes.
  - Added `checkProcessNodesRos2`: reports an error if a ROS 1 Catkin node is assigned to a component container process.
  - Added `checkProcessThreads`: reports an error if a process thread count is negative.
- **Targeted System Generation with Workspace Awareness**:
  - `RosSystemGeneratorCommandService.java` now accepts an `existingFiles` argument and forwards it to `RosSystemGenerator.generateSystemTargeted`.
  - Enables `.rossystem` code generation to inspect existing package structures in `src-gen/<pkg>` before generating or updating build files.
- **Dedicated Pure Python System Generation (`compile_package_xml_python`)**:
  - Added `compile_package_xml_python` in `PackageXmlCompiler.xtend` to emit a clean `<build_type>ament_python</build_type>` without CMake build tool dependencies.
- **Launch & Config Installation Injections**:
  - Injected `install(DIRECTORY launch ... OPTIONAL)` and `config/` installation directives into existing `CMakeLists.txt` for monolithic packages lacking them.
  - Injected `<exec_depend>launch</exec_depend>`, `<exec_depend>launch_ros</exec_depend>`, and `<exec_depend>ament_index_python</exec_depend>` into existing `package.xml` files when system launch files are added.

### Changed
- **Unconditional `OPTIONAL` Launch & Configuration Installation in CMake**:
  - Replaced configure-time `if(EXISTS "${CMAKE_CURRENT_SOURCE_DIR}/launch")` and `config` conditional wrappers with unconditional `install(DIRECTORY launch DESTINATION share/${PROJECT_NAME} OPTIONAL)` in `Ros2BuildArtifactsCompiler.xtend` and `CMakeListsCompiler.xtend`.
  - Eliminates the configure-time ordering hazard where initial CMake configure evaluated `if(EXISTS ...)` to `FALSE` before launch files were generated, preventing them from being installed.
  - With `OPTIONAL`, CMake always registers the install rules into `cmake_install.cmake` and `ament_cmake_symlink_install.cmake`; when launch files are generated later from `.rossystem`, running `colcon build` immediately installs/symlinks them without requiring CMake reconfiguration.
  - Added automated migration in `RosSystemGenerator.xtend` to upgrade legacy `if(EXISTS .../launch)` blocks in existing `CMakeLists.txt` files to unconditional `OPTIONAL` directives.
- **Executable Naming Alignment Across Build Systems (Approach A)**:
  - Standardized C++ generated filenames to CamelCase matching artifact names (`«artCamel»Wrapper.hpp`, `«artCamel»Algorithm.hpp`, `«artCamel»Runner.cpp`).
  - Aligned C++ executable targets to match the exact modeled artifact name `«node.artifactName»` in `add_executable`, `target_link_libraries`, `ament_target_dependencies`, and `install(TARGETS ...)` (replacing `«CamelCase»_node`).
  - In hybrid CMake packages (`ament_cmake_python`), installed Python runners into `lib/${PROJECT_NAME}` using CMake `RENAME «node.artifactName»` so that executable binaries match the modeled artifact name without a `.py` extension.
  - Aligned Python `setup.py` `console_scripts` entry points to `«node.artifactName» = «pkg».«node.name»_runner:main`.
  - Unified `.rossystem` launch file generation: Launch files reference canonical `executable="«artifact.name»"`, which resolves identically across pure C++, pure Python, and hybrid packages without naming mismatches.
- **Removal of `pyproject.toml` Generation**:
  - Completely removed `pyproject.toml` generation from `Ros2BuildArtifactsCompiler.xtend` and `Ros2Generator.xtend`. Pure Python packages strictly adhere to standard ROS 2 `setup.py` and `setup.cfg`.
- **CMake Baseline**:
  - Updated `CMakeListsCompiler.xtend` minimum version requirement from `3.5` to `3.8`.

### Fixed
- **Monolithic Package Support & Build Collision Prevention**:
  - Resolved build system conflicts in monolithic packages where multiple nodes and bringup launch files share a single package directory.
  - Prevented generation of rogue `CMakeLists.txt` or CMake build configurations in pure Python packages.
  - Prevented generation of rogue `setup.py`, `setup.cfg`, or `__init__.py` in pure C++ bringup packages.
  - Filtered self-referential execution dependencies in `PackageXmlCompiler.xtend` (packages no longer declare dependencies on themselves).
- **Deterministic File Pruning for Clean Build Transitions**:
  - Added deterministic file pruning (`fsa.deleteFile`) for obsolete Python setuptools files (`setup.py`, `setup.cfg`, `pyproject.toml`, and setuptools resource package marker `resource/<pkg>`) in CMake and hybrid packages.
  - Added deterministic file pruning (`fsa.deleteFile`) for obsolete `CMakeLists.txt` and `pyproject.toml` in pure Python packages.
  - Strictly preserved PlantUML architecture diagrams (`resource/<pkg>.puml`) from deletion across all build file cleanup routines.
- **Single-Language Node Enforcement & Duplicate Node Prevention**:
  - Enforced single-language implementation per node in `Ros2Generator.xtend`: regenerating a node in C++ automatically prunes it from `pythonNodes` and deletes opposite-language files (`_wrapper.py`, `_runner.py`, `_logic.py`); regenerating a node in Python prunes it from `cppNodes` and deletes opposite-language files (`Wrapper.hpp`, `Node.hpp`, `Algorithm.hpp`, `Wrapper.cpp`, `Node.cpp`, `Runner.cpp`).
- **Antlr Token Source Resilience**:
  - Updated `Ros2TokenSource.java` in both `ros2.xtext` and `ros2.xtext.ide` to use reflection-based fallback for resolving token rule constants (`RULE_WS`, `RULE_BEGIN`, `RULE_END`), preventing binary incompatibility crashes upon Antlr re-generation.


## [3.2.0] - 2026-09-30

### Added
- **Runtime Platform Services for Pure Core Logic**:
  - **Liveness Checking (`ok()`)**: Allows core algorithm execution loops to terminate gracefully on node interruption or shutdown (`rclcpp::ok()` / `rclpy.ok()`).
  - **Graceful Termination (`shutdown(reason)`)**: Enables domain logic to request process shutdown with optional reason logging (`rclcpp::shutdown()` / `rclpy.shutdown()`).
  - **Simulation-Synchronized Clock (`now()`, `now_seconds()`)**: Decoupled clock query returning standard `std::chrono::nanoseconds` or fractional seconds (`float`), respecting `/clock`, simulation pause, and bag replay without leaking ROS 2 time types into domain logic.
  - **Simulation-Synchronized Sleep (`sleep_for`)**: One-shot relative delays adhering to the simulation clock via `node->get_clock()->sleep_for(...)` and Python `Duration`.
  - **Simulation-Synchronized Rate (`Rate`, `RateFactory`, `create_rate`)**: Abstract `Rate` interface providing simulation-synchronized loop pacing with fallback implementations (`DefaultSteadyRate` in C++, `DefaultRate` in Python) for unit tests.
  - **Platform Logging Bridge**: Leveled logging (`log_debug`, `log_info`, `log_warn`, `log_error`) bridging pure algorithms directly to `RCLCPP_*` macros and Python node loggers.
  - **Timer Factory (`create_timer`)**: Pure delegate allowing core logic to schedule periodic callbacks driven by the node executor.
- **Action Client Feedback & Terminal State Forwarding**:
  - Asynchronous goal acceptance callback (`response_cb(bool accepted)`) notifying the algorithm whether a sent goal was accepted or rejected by the action server.
  - Pure `GoalStatus` enum (`UNKNOWN`, `SUCCEEDED`, `CANCELED`, `ABORTED`) forwarding action terminal states to the domain logic result callback without requiring `rclcpp_action` or `action_msgs` dependencies.
- **Dynamic Parameter Hooks & Validation**:
  - Parameter getters and setters (`get_param` / `get_parameter`, `set_parameter`).
  - `validate_parameter(name, proposed_value)` validation hook returning pure `ValidationResult::ok()` or `ValidationResult::reject(reason)` to inspect and reject invalid dynamic parameter updates.
  - `on_parameter_changed(name, value)` hook to trigger reactive updates in domain logic upon parameter reconfiguration.

### Changed
- **Artifact Naming Conventions**:
  - Standardized C++ generated filenames to CamelCase matching artifact names (`«artCamel»Wrapper.hpp`, `«artCamel»Algorithm.hpp`, `«artCamel»Node.cpp`).
  - Synchronized `CMakeLists.txt` executable targets and Python entrypoints with the artifact names.
- **Strict Mocking Enforcement**:
  - Calling unconfigured platform delegates (`ok`, `shutdown`, `now`, `sleep_for`) in standalone tests throws `std::logic_error` in C++ and raises `RuntimeError` in Python instead of silently defaulting, requiring test harnesses to explicitly mock the runtime platform.
- **LSP Command Refactoring**:
  - Renamed the advertised Language Server command to `ros2.generateWrappersServer` to prevent command collisions with IDE client commands.

### Fixed
- Fixed parameter default value extraction in `Ros2GeneratorHelpers.xtend`.
- Fixed loop generation syntax error when generating parameter handlers for nodes with zero parameters.
- Fixed lambda parameter syntax and missing semicolons in C++ runner generation.


