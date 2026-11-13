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
#include "tf2_msgs/action/lookup_transform.hpp"
#include "tf2_msgs/action/lookup_transform.hpp"

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
 * @brief Pure Core Logic class for 'action_node' (Artifact: 'action_node').
 * Contains ZERO ROS 2 runtime node / executor dependencies!
 * Implement your business logic, algorithms, and signal handling here.
 * This file is generated once and will NEVER be overwritten.
 */
class ActionNodeAlgorithm {
public:
    ActionNodeAlgorithm() = default;
    virtual ~ActionNodeAlgorithm() = default;


    // ==========================================
    // 1. INBOUND SUBSCRIBER MESSAGE HANDLERS
    // ==========================================
    // ==========================================
    // 2. INBOUND SERVICE REQUEST HANDLERS
    // ==========================================
    // ==========================================
    // 3. INBOUND ACTION SERVER HANDLERS
    // ==========================================
    using LookupTransformGoal = tf2_msgs::action::LookupTransform::Goal;
    using LookupTransformFeedback = tf2_msgs::action::LookupTransform::Feedback;
    using LookupTransformResult = tf2_msgs::action::LookupTransform::Result;

    /**
     * @brief Decides whether to accept or reject a goal request for action 'lookup'
     * @return true to accept and execute, false to reject
     */
    virtual bool handle_goal_lookup(const LookupTransformGoal & goal) {
        (void)goal;
        return true; // Default: accept all valid goals
    }

    /**
     * @brief Decides whether to accept or reject a cancellation request for action 'lookup'
     * @return true to accept cancellation, false to reject
     */
    virtual bool handle_cancel_lookup() {
        return true; // Default: accept cancellation
    }

    /**
     * @brief Executes the accepted goal for action 'lookup'
     * @param goal The accepted goal parameters
     * @param publish_feedback Stream intermediate progress updates
     * @param is_canceling Check if the action client requested cancellation
     * @param result Output result to populate
     * @return true if goal succeeded, false if aborted
     */
    virtual bool execute_lookup(
        const LookupTransformGoal & goal,
        std::function<void(const LookupTransformFeedback &)> publish_feedback,
        std::function<bool()> is_canceling,
        LookupTransformResult & result)
    {
        (void)goal;
        (void)publish_feedback;
        (void)is_canceling;
        (void)result;
        // TODO: Implement long-running execution logic
        return true;
    }

    // ==========================================
    // 4. OUTBOUND PUBLISHER METHODS
    // ==========================================
    // ==========================================
    // 5. OUTBOUND SERVICE CLIENT CALLERS
    // ==========================================
    // ==========================================
    // 6. OUTBOUND ACTION CLIENT CALLERS
    // ==========================================
    using lookup_clientGoalCaller = std::function<void(
        const tf2_msgs::action::LookupTransform::Goal &,
        std::function<void(bool)>,
        std::function<void(const tf2_msgs::action::LookupTransform::Feedback &)>,
        std::function<void(GoalStatus, const tf2_msgs::action::LookupTransform::Result &)>,
        std::chrono::nanoseconds)>;
    using lookup_clientCancelCaller = std::function<void()>;
    using lookup_clientWaitServerCaller = std::function<bool(std::chrono::nanoseconds)>;
    using lookup_clientIsServerReadyCaller = std::function<bool()>;

    void set_lookup_client_client(
        lookup_clientGoalCaller goal_fn,
        lookup_clientCancelCaller cancel_fn,
        lookup_clientWaitServerCaller wait_server_fn = nullptr,
        lookup_clientIsServerReadyCaller is_ready_fn = nullptr)
    {
        send_lookup_client_goal_fn_ = goal_fn;
        cancel_lookup_client_goal_fn_ = cancel_fn;
        wait_lookup_client_server_fn_ = wait_server_fn;
        is_lookup_client_server_ready_fn_ = is_ready_fn;
    }

    void set_lookup_client_server_timeout(std::chrono::nanoseconds timeout) {
        lookup_client_server_timeout_ = timeout;
    }

    template <typename Rep, typename Period>
    void set_lookup_client_server_timeout(std::chrono::duration<Rep, Period> timeout) {
        lookup_client_server_timeout_ = std::chrono::duration_cast<std::chrono::nanoseconds>(timeout);
    }

    std::chrono::nanoseconds get_lookup_client_server_timeout() const {
        return lookup_client_server_timeout_;
    }

    void send_lookup_client_goal_async(
        const tf2_msgs::action::LookupTransform::Goal & goal,
        std::function<void(bool)> response_cb = nullptr,
        std::function<void(const tf2_msgs::action::LookupTransform::Feedback &)> feedback_cb = nullptr,
        std::function<void(GoalStatus, const tf2_msgs::action::LookupTransform::Result &)> result_cb = nullptr,
        std::optional<std::chrono::nanoseconds> timeout = std::nullopt)
    {
        auto effective_timeout = timeout.value_or(lookup_client_server_timeout_);
        if (send_lookup_client_goal_fn_) {
            send_lookup_client_goal_fn_(goal, response_cb, feedback_cb, result_cb, effective_timeout);
        }
    }

    void cancel_lookup_client_goal_async() {
        if (cancel_lookup_client_goal_fn_) cancel_lookup_client_goal_fn_();
    }

    bool wait_for_lookup_client_server(std::chrono::nanoseconds timeout = std::chrono::seconds(5)) {
        if (wait_lookup_client_server_fn_) return wait_lookup_client_server_fn_(timeout);
        return false;
    }

    bool is_lookup_client_server_ready() const {
        if (is_lookup_client_server_ready_fn_) return is_lookup_client_server_ready_fn_();
        return false;
    }

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
    lookup_clientGoalCaller send_lookup_client_goal_fn_;
    lookup_clientCancelCaller cancel_lookup_client_goal_fn_;
    lookup_clientWaitServerCaller wait_lookup_client_server_fn_;
    lookup_clientIsServerReadyCaller is_lookup_client_server_ready_fn_;
    std::chrono::nanoseconds lookup_client_server_timeout_{std::chrono::seconds(10)};
};

} // namespace golden_pkg
