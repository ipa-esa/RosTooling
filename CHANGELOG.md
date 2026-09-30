# Changelog

All notable changes to the **RosTooling** model and generator plugins will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

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
