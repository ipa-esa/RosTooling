#pragma once

#include <iostream>
#include <memory>
#include <string>
#include <vector>
#include <optional>
#include <functional>
#include <chrono>
#include <thread>
#include <stdexcept>

// Interface message/service/action headers for pure data structs
#include "std_msgs/msg/string.hpp"
#include "std_srvs/srv/trigger.hpp"
#include "std_srvs/srv/set_bool.hpp"

namespace golden_pkg {

/**
 * @brief Pure C++ validation result (no rcl_interfaces dependencies)
 */
struct ValidationResult {
    bool successful{true};
    std::string reason{""};
    static ValidationResult ok() {
        return {true, ""};
    }
    static ValidationResult reject(const std::string & reason) {
        return {false, reason};
    }
};

/**
 * @brief Pure C++ action goal terminal status (no rclcpp_action or action_msgs dependencies)
 */
enum class GoalStatus {
    UNKNOWN = 0,
    SUCCEEDED = 1,
    CANCELED = 2,
    ABORTED = 3
};

/**
 * @brief Abstract Rate interface with zero ROS 2 dependencies
 */
class Rate {
public:
    virtual ~Rate() = default;
    virtual bool sleep() = 0;
    virtual void reset() = 0;
};

using RatePtr = std::shared_ptr<Rate>;
using RateFactory = std::function<RatePtr(double hz)>;

/**
 * @brief Default fallback rate using standard C++ steady_clock (used in unit tests / standalone)
 */
class DefaultSteadyRate : public Rate {
public:
    explicit DefaultSteadyRate(double hz)
    : period_(std::chrono::duration_cast<std::chrono::nanoseconds>(
          std::chrono::duration<double>(1.0 / hz))),
      last_time_(std::chrono::steady_clock::now())
    {}

    bool sleep() override {
        auto now = std::chrono::steady_clock::now();
        auto next = last_time_ + period_;
        if (now < next) {
            std::this_thread::sleep_for(next - now);
        }
        last_time_ = std::chrono::steady_clock::now();
        return true;
    }

    void reset() override {
        last_time_ = std::chrono::steady_clock::now();
    }

private:
    std::chrono::nanoseconds period_;
    std::chrono::steady_clock::time_point last_time_;
};

/**
 * @brief Pure Core Logic class for 'service_node' (Artifact: 'service_node').
 * Contains ZERO ROS 2 runtime node / executor dependencies!
 * Implement your business logic, algorithms, and signal handling here.
 * This file is generated once and will NEVER be overwritten.
 */
class ServiceNodeAlgorithm {
public:
    ServiceNodeAlgorithm() = default;
    virtual ~ServiceNodeAlgorithm() = default;

    // ==========================================
    // LIFECYCLE TRANSITION HOOKS (Pure C++ / Zero ROS 2 dependencies)
    // ==========================================
    virtual bool on_configure() {
        return true;
    }

    virtual bool on_activate() {
        return true;
    }

    virtual bool on_deactivate() {
        return true;
    }

    virtual bool on_cleanup() {
        return true;
    }

    virtual bool on_shutdown() {
        return true;
    }

    virtual bool on_error() {
        return true;
    }

    // ==========================================
    // 1. INBOUND SUBSCRIBER MESSAGE HANDLERS
    // ==========================================
    // ==========================================
    // 2. INBOUND SERVICE REQUEST HANDLERS
    // ==========================================
    /**
     * @brief Handler for service 'reset'
     * @return true if successfully processed, false to indicate failure
     */
    virtual bool handle_reset(
        const std_srvs::srv::Trigger::Request & req,
        std_srvs::srv::Trigger::Response & res)
    {
        (void)req;
        (void)res;
        // TODO: Process request fields and populate response fields
        return true;
    }

    // ==========================================
    // 3. INBOUND ACTION SERVER HANDLERS
    // ==========================================
    // ==========================================
    // 4. OUTBOUND PUBLISHER METHODS
    // ==========================================
    using heartbeatPubFn = std::function<void(const std_msgs::msg::String &)>;
    void set_heartbeat_publisher(heartbeatPubFn fn) { publish_heartbeat_fn_ = fn; }
    void publish_heartbeat(const std_msgs::msg::String & msg) {
        if (publish_heartbeat_fn_) publish_heartbeat_fn_(msg);
    }

    // ==========================================
    // 5. OUTBOUND SERVICE CLIENT CALLERS
    // ==========================================
    using enable_clientSyncCaller = std::function<std::optional<std_srvs::srv::SetBool::Response>(const std_srvs::srv::SetBool::Request &, const std::chrono::nanoseconds &)>;
    using enable_clientAsyncCaller = std::function<void(const std_srvs::srv::SetBool::Request &, std::function<void(const std_srvs::srv::SetBool::Response &)>)>;

    void set_enable_client_client(enable_clientSyncCaller sync_fn, enable_clientAsyncCaller async_fn) {
        call_enable_client_sync_fn_ = sync_fn;
        call_enable_client_async_fn_ = async_fn;
    }

    std::optional<std_srvs::srv::SetBool::Response> call_enable_client_sync(
        const std_srvs::srv::SetBool::Request & req,
        const std::chrono::milliseconds & timeout) // Can be changed to any other duration form.
    {
        if (call_enable_client_sync_fn_) return call_enable_client_sync_fn_(req, timeout);
        return std::nullopt;
    }

    void call_enable_client_async(
        const std_srvs::srv::SetBool::Request & req,
        std::function<void(const std_srvs::srv::SetBool::Response &)> cb)
    {
        if (call_enable_client_async_fn_) call_enable_client_async_fn_(req, cb);
    }

    // ==========================================
    // 6. OUTBOUND ACTION CLIENT CALLERS
    // ==========================================
    // ==========================================
    // 7. TIMER FACTORY INTERFACE
    // ==========================================
    using TimerHandle = std::shared_ptr<void>;
    using TimerFactory = std::function<TimerHandle(std::chrono::nanoseconds, std::function<void()>)>;

    /**
     * @brief Injects the platform/ROS timer creation factory.
     */
    void set_timer_factory(TimerFactory factory) {
        timer_factory_ = factory;
    }

    /**
     * @brief Spawns a periodic timer driven by the node executor (respects simulation time /clock).
     * @tparam Rep Duration representation
     * @tparam Period Duration ratio
     * @param period Timer interval duration (e.g. std::chrono::milliseconds(100))
     * @param callback Callback executed on every tick
     * @return TimerHandle RAII handle keeping the timer alive
     */
    template <typename Rep, typename Period>
    TimerHandle create_timer(std::chrono::duration<Rep, Period> period, std::function<void()> callback) {
        if (timer_factory_) {
            return timer_factory_(std::chrono::duration_cast<std::chrono::nanoseconds>(period), callback);
        }
        return nullptr;
    }

    /**
     * @brief Spawns a periodic timer specified in fractional seconds (e.g. 0.5 for 500ms).
     * @param period_seconds Timer interval in seconds
     * @param callback Callback executed on every tick
     * @return TimerHandle RAII handle keeping the timer alive
     */
    TimerHandle create_timer(double period_seconds, std::function<void()> callback) {
        if (timer_factory_) {
            auto nanos = std::chrono::duration_cast<std::chrono::nanoseconds>(
                std::chrono::duration<double>(period_seconds)
            );
            return timer_factory_(nanos, callback);
        }
        return nullptr;
    }

    // ==========================================
    // 8. RATE FACTORY INTERFACE
    // ==========================================
    /**
     * @brief Injects the platform/ROS rate creation factory.
     */
    void set_rate_factory(RateFactory factory) {
        rate_factory_ = factory;
    }

    /**
     * @brief Creates a rate object. In ROS 2, respects simulation clock (/clock).
     * In unit tests / standalone, falls back to steady wall clock.
     * @param frequency_hz Desired execution frequency in Hertz
     * @return RatePtr RAII handle providing sleep() and reset()
     */
    RatePtr create_rate(double frequency_hz) {
        if (rate_factory_) {
            return rate_factory_(frequency_hz);
        }
        return std::make_shared<DefaultSteadyRate>(frequency_hz);
    }

    // ==========================================
    // 9. LOGGER FACTORY INTERFACE
    // ==========================================
    enum class LogLevel {
        DEBUG,
        INFO,
        WARN,
        ERROR
    };
     
    using LogFunction = std::function<void(LogLevel level, const std::string & message)>;

    /**
     *@brief Injects the ROS/platform logger macro.
     */
    void set_logger(LogFunction logger_func) {
        logger_ = logger_func;
    }

    /**
    * @brief Logs a debug level message via platform logger
    * @param message the std::string to be logged
    */
    void log_debug(const std::string & message) {
        logger_(LogLevel::DEBUG, message);
    }
    /**
    * @brief Logs an info level message via platform logger
    * @param message the std::string to be logged
    */
    void log_info(const std::string & message) {
        logger_(LogLevel::INFO, message);
    }
    /**
    * @brief Logs a warn level message via platform logger
    * @param message the std::string to be logged
    */
    void log_warn(const std::string & message) {
        logger_(LogLevel::WARN, message);
    }
    /**
    * @brief Logs an error level message via platform logger
    * @param message the std::string to be logged
    */
    void log_error(const std::string & message) {
        logger_(LogLevel::ERROR, message);
    }
    
    // ==========================================
    // 9. PARAMETER HOOKS
    // ==========================================
    
    using ParameterValue = std::variant<
    std::monostate,
    bool,
    int64_t,
    double,
    std::string,
    std::vector<uint8_t>,
    std::vector<bool>,
    std::vector<int64_t>,
    std::vector<double>,
    std::vector<std::string>
    >;
    
    /**
     * @brief Parameter setter used by the runner
     * @param name Name of the parameter
     * @param value Value of the paramter
     */
    void set_parameter(const std::string & name, const ParameterValue & value) {
        parameters_[name] = value;
    }

    /**
     * @brief  Parameter getter based on parameter name
     * @param name Name of the parameter
     * @param default_val Default value to return in paramter nonexistant
     * @return Parameter value or default value
     */
    template<typename T>
    T get_param(const std::string & name, const T & default_val) const {
        auto it = parameters_.find(name);
        if (it != parameters_.cend()) {
            if (auto val_ptr = std::get_if<T>(&it->second))
            return *val_ptr;
        }
        return default_val;
    }

    /**
     * @brief Validation Hook to inspect proposed parameter values and reject invalid ones.
     * @param name Name of parameter being validated
     * @param proposed_value The new value requested
     * @return ValidationResult::ok() to accept, or ValidationResult::reject("reason") to reject
     */
    virtual ValidationResult validate_parameter(const std::string & name, const ParameterValue & proposed_value) {
        (void)name;
        (void)proposed_value;
        return ValidationResult::ok();
    }
    
    /**
    * @brief Method to carry out reactive changes based on parameter changes
    * @param name Name of changed parameter
    * @param value Value of the changed parameter
    */
    virtual void on_parameter_changed(const std::string & name, const ParameterValue & value) {
        (void)name;
        (void)value;
    }

    // ==========================================
    // 10. RUNTIME & PLATFORM SERVICES (ok, shutdown, now, sleep_for)
    // ==========================================
    using OkHandler = std::function<bool()>;
    using ShutdownHandler = std::function<void(const std::string &)>;
    using ClockHandler = std::function<std::chrono::nanoseconds()>;
    using SleepHandler = std::function<bool(std::chrono::nanoseconds)>;

    /**
     * @brief Injects the runtime liveness check handler.
     */
    void set_ok_handler(OkHandler handler) {
        ok_handler_ = std::move(handler);
    }

    /**
     * @brief Check if the runtime platform is still healthy/running.
     * @throws std::logic_error if no mock or runner has injected the predicate.
     */
    bool ok() const {
        if (!ok_handler_) {
            throw std::logic_error(
                "Liveness predicate not injected. In unit tests, configure a mock via set_ok_handler()."
            );
        }
        return ok_handler_();
    }

    /**
     * @brief Injects the runtime shutdown handler.
     */
    void set_shutdown_handler(ShutdownHandler handler) {
        shutdown_handler_ = std::move(handler);
    }

    /**
     * @brief Request graceful shutdown of the node/system.
     * @param reason Optional human-readable reason for shutdown.
     * @throws std::logic_error if no mock or runner has injected the handler.
     */
    void shutdown(const std::string & reason = "") {
        if (!shutdown_handler_) {
            throw std::logic_error(
                "Shutdown handler not injected. In unit tests, configure a mock via set_shutdown_handler()."
            );
        }
        shutdown_handler_(reason);
    }

    /**
     * @brief Injects the simulation-aware clock query handler.
     */
    void set_clock_handler(ClockHandler handler) {
        clock_handler_ = std::move(handler);
    }

    /**
     * @brief Current time respecting simulation clock (/clock).
     * @return Nanoseconds since epoch.
     * @throws std::logic_error if no mock or runner has injected the handler.
     */
    std::chrono::nanoseconds now() const {
        if (!clock_handler_) {
            throw std::logic_error(
                "Clock handler not injected. In unit tests, configure a mock via set_clock_handler()."
            );
        }
        return clock_handler_();
    }

    /**
     * @brief Current time in fractional seconds respecting simulation clock.
     */
    double now_seconds() const {
        return std::chrono::duration<double>(now()).count();
    }

    /**
     * @brief Injects the simulation-aware sleep handler.
     */
    void set_sleep_handler(SleepHandler handler) {
        sleep_handler_ = std::move(handler);
    }

    /**
     * @brief Sleep for a duration respecting simulation clock (/clock).
     * @param duration Duration to sleep (e.g. std::chrono::milliseconds(500))
     * @return true if full duration slept, false if interrupted/shutdown.
     * @throws std::logic_error if no mock or runner has injected the handler.
     */
    bool sleep_for(std::chrono::nanoseconds duration) {
        if (!sleep_handler_) {
            throw std::logic_error(
                "Sleep handler not injected. In unit tests, configure a mock via set_sleep_handler()."
            );
        }
        return sleep_handler_(duration);
    }

    /**
     * @brief Sleep for a duration in seconds respecting simulation clock.
     * @param seconds Duration in seconds (e.g. 0.5)
     * @return true if full duration slept, false if interrupted/shutdown.
     */
    bool sleep_for_seconds(double seconds) {
        return sleep_for(std::chrono::duration_cast<std::chrono::nanoseconds>(
            std::chrono::duration<double>(seconds)));
    }
        
private:
    TimerFactory timer_factory_;
    RateFactory rate_factory_;
    LogFunction logger_;
    OkHandler ok_handler_;
    ShutdownHandler shutdown_handler_;
    ClockHandler clock_handler_;
    SleepHandler sleep_handler_;
    std::unordered_map<std::string, ParameterValue> parameters_;
    heartbeatPubFn publish_heartbeat_fn_;
    enable_clientSyncCaller call_enable_client_sync_fn_;
    enable_clientAsyncCaller call_enable_client_async_fn_;
};

} // namespace golden_pkg
