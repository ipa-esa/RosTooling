#!/usr/bin/env python3
# -*- coding: utf-8 -*-

"""
Pure Python Core Logic class for 'action_node'.
ZERO ROS 2 runtime dependencies!
Edit this file to implement your core algorithms, data processing, and business logic.
This file is created only once and will NEVER be overwritten by the generator.
"""

import time
from typing import Optional, Callable, Any
from enum import Enum
# ROS 2 Interfaces imports
from tf2_msgs.action import LookupTransform
from tf2_msgs.action import LookupTransform

class ValidationResult:
    """
    Struct to provide result after validating a parameter update
    """
    def __init__(self, successfull: bool = True, reason: str = ""):
        self.successfull = successfull
        self.reason = reason
    
    @classmethod
    def ok(cls):
        return cls(True)
    
    @classmethod
    def reject(cls, reason: str):
        return cls(False, reason)

class GoalStatus(Enum):
    """Action goal terminal execution status."""
    UNKNOWN = 0
    SUCCEEDED = 1
    CANCELED = 2
    ABORTED = 3

class DefaultRate:
    """Default rate limiter using time.monotonic and time.sleep (used in unit tests / standalone)."""
    def __init__(self, frequency: float):
        self.period = 1.0 / frequency
        self.last_time = time.monotonic()

    def sleep(self) -> bool:
        elapsed = time.monotonic() - self.last_time
        remaining = self.period - elapsed
        if remaining > 0:
            time.sleep(remaining)
        self.last_time = time.monotonic()
        return True

    def reset(self) -> None:
        self.last_time = time.monotonic()

class action_nodeLogic:
    """
    Pure business logic for action_node.
    """

    def __init__(self):
        self._timer_factory: Optional[Callable[[float, Callable[[], None]], Any]] = None
        self._rate_factory: Optional[Callable[[float], Any]] = None
        self._logger: Optional[Callable[[self.LogLevel, str], None]] = None
        self._ok_handler: Optional[Callable[[], bool]] = None
        self._shutdown_handler: Optional[Callable[[str], None]] = None
        self._clock_handler: Optional[Callable[[], float]] = None
        self._sleep_handler: Optional[Callable[[float], bool]] = None
        self.parameters_ = {}
        self._send_lookup_client_goal_fn: Optional[Callable] = None
        self._cancel_lookup_client_goal_fn: Optional[Callable] = None


    # ==========================================
    # 1. INBOUND SUBSCRIBER MESSAGE HANDLERS
    # ==========================================
    # ==========================================
    # 2. INBOUND SERVICE REQUEST HANDLERS
    # ==========================================
    # ==========================================
    # 3. INBOUND ACTION SERVER HANDLERS
    # ==========================================
    def handle_goal_lookup(self, goal) -> bool:
        """
        Decide whether to accept or reject a goal request for action 'lookup'.
        Return True to accept and execute, False to reject.
        """
        return True

    def handle_cancel_lookup(self) -> bool:
        """
        Decide whether to accept or reject a cancellation request for action 'lookup'.
        Return True to accept cancellation, False to reject.
        """
        return True

    def execute_lookup(self, goal, publish_feedback: Callable[[Any], None], is_canceling: Callable[[], bool], result) -> bool:
        """
        Execute the accepted goal for action 'lookup'.
        publish_feedback: callable to stream feedback
        is_canceling: callable returning bool if cancel was requested
        result: result object to populate
        Return True if goal succeeded, False if aborted.
        """
        return True

    # ==========================================
    # 4. OUTBOUND PUBLISHER METHODS
    # ==========================================
    # ==========================================
    # 5. OUTBOUND SERVICE CLIENT CALLERS
    # ==========================================
    # ==========================================
    # 6. OUTBOUND ACTION CLIENT CALLERS
    # ==========================================
    def set_lookup_client_client(self, goal_fn: Callable, cancel_fn: Callable) -> None:
        self._send_lookup_client_goal_fn = goal_fn
        self._cancel_lookup_client_goal_fn = cancel_fn

    def send_lookup_client_goal_async(self, goal, response_callback: Optional[Callable[[bool], None]] = None, feedback_callback: Optional[Callable] = None, result_callback: Optional[Callable[[GoalStatus, Any], None]] = None):
        """Asynchronously send goal to action server 'lookup_client'."""
        if self._send_lookup_client_goal_fn:
            return self._send_lookup_client_goal_fn(goal, response_callback, feedback_callback, result_callback)
        return None

    def cancel_lookup_client_goal_async(self, goal_handle=None):
        """Cancel active goal for action client 'lookup_client'."""
        if self._cancel_lookup_client_goal_fn:
            return self._cancel_lookup_client_goal_fn(goal_handle)
        return None

    # ==========================================
    # 7. TIMER FACTORY INTERFACE
    # ==========================================
    def set_timer_factory(self, factory: Callable[[float, Callable[[], None]], Any]) -> None:
        """Inject the platform/ROS timer creation factory."""
        self._timer_factory = factory

    def create_timer(self, period_sec: float, callback: Callable[[], None]) -> Any:
        """
        Spawn a periodic timer driven by the node executor (respects simulation time /clock).

        :param period_sec: Timer interval in seconds (float)
        :param callback: Zero-argument callable executed on every tick
        :return: Platform timer handle keeping the timer active
        """
        if self._timer_factory:
            return self._timer_factory(period_sec, callback)
        return None

    # ==========================================
    # 8. RATE FACTORY INTERFACE
    # ==========================================
    def set_rate_factory(self, factory: Callable[[float], Any]) -> None:
        """Inject the platform/ROS rate creation factory."""
        self._rate_factory = factory

    def create_rate(self, frequency_hz: float) -> Any:
        """
        Spawn a rate limiter respecting simulation clock.
        In unit tests, falls back to time.sleep.

        :param frequency_hz: Rate frequency in Hz
        :return: Rate object with a sleep() method
        """
        if self._rate_factory:
            return self._rate_factory(frequency_hz)
        return DefaultRate(frequency_hz)

    # ==========================================
    # 9. LOGGER FACTORY INTERFACE
    # ==========================================
    class LogLevel(Enum):
        DEBUG = 0
        INFO = 1
        WARN = 2
        ERROR = 3
    
    def set_logger(self, func: Callable[[LogLevel, str], Any]) -> None:
        """Inject the platform/ROS logger method"""
        self._logger = func
    
    def log_debug(self, message: str):
        """
        Logs a debug level message via the platform logger

        :param message: String message to be logged
        """
        self._logger(self.LogLevel.DEBUG, message)

    def log_info(self, message: str):
        """
        Logs a info level message via the platform logger

        :param message: String message to be logged
        """
        self._logger(self.LogLevel.INFO, message)
    
    def log_warn(self, message: str):
        """
        Logs a warn level message via the platform logger

        :param message: String message to be logged
        """
        self._logger(self.LogLevel.WARN, message)

    def log_error(self, message: str):
        """
        Logs a error level message via the platform logger

        :param message: String message to be logged
        """
        self._logger(self.LogLevel.ERROR, message)
    # ==========================================
    # 9. PARAMETER HOOKS
    # ==========================================
    def set_parameter(self, name: str, value: Any) -> None:
        """
        Parameter setter used by the runner
        :param name: String name of the parameter
        :param value: Value of the parameter
        """
        self.parameters_[name] = value
    
    def get_parameter(self, name: str) -> Any:
        """
        Parameter getter based on parameter name
        :param name: String name of the parameter
        :return: Parameter value or None if nonexistant
        """
        if name not in self.parameters_.keys():
            return None
        return self.parameters_.get(name)
    
    def validate_parameter(self, name: str, proposed_value: Any) -> ValidationResult:
        """
        Validation hook to instpect proposed parameter values and reject invalid ones
        :param name: String name of the parameter
        :param proposed_value: The new value proposed
        :return: ValidationResult.ok() to accept or ValidationResult.reject("reason") to reject
        """
        # Override or change to validate any incoming parameter changes
        return ValidationResult.ok()
    
    def on_parameter_changed(self, name: str, value: Any):
        """
        Method to carry out reactive changes based on parameter updates
        :param name: Name of the changed parameter
        :param value: New value of the paramtere.
        """
        # Override or change to change code behaviour based on param changes
        pass

    # ==========================================
    # 10. RUNTIME & PLATFORM SERVICES (ok, shutdown, now, sleep_for)
    # ==========================================
    def set_ok_handler(self, handler: Callable[[], bool]) -> None:
        """Inject the runtime liveness check handler."""
        self._ok_handler = handler

    def ok(self) -> bool:
        """
        Check if the runtime environment is active.
        Raises RuntimeError if no runner or mock platform was injected.
        """
        if self._ok_handler is None:
            raise RuntimeError(
                "Liveness predicate not injected. In unit tests, configure a mock via set_ok_handler()."
            )
        return self._ok_handler()

    def set_shutdown_handler(self, handler: Callable[[str], None]) -> None:
        """Inject the runtime shutdown handler."""
        self._shutdown_handler = handler

    def shutdown(self, reason: str = "") -> None:
        """
        Request graceful shutdown of the node/system.
        Raises RuntimeError if no runner or mock platform was injected.
        """
        if self._shutdown_handler is None:
            raise RuntimeError(
                "Shutdown handler not injected. In unit tests, configure a mock via set_shutdown_handler()."
            )
        self._shutdown_handler(reason)

    def set_clock_handler(self, handler: Callable[[], float]) -> None:
        """Inject the runtime clock handler returning current time in seconds."""
        self._clock_handler = handler

    def now(self) -> float:
        """
        Get current time in seconds (respects simulation time /clock).
        Raises RuntimeError if no runner or mock platform was injected.
        """
        if self._clock_handler is None:
            raise RuntimeError(
                "Clock handler not injected. In unit tests, configure a mock via set_clock_handler()."
            )
        return self._clock_handler()

    def now_nanoseconds(self) -> int:
        """Get current time in nanoseconds."""
        return int(self.now() * 1e9)

    def set_sleep_handler(self, handler: Callable[[float], bool]) -> None:
        """Inject the runtime sleep handler (accepts duration in seconds)."""
        self._sleep_handler = handler

    def sleep_for(self, seconds: float) -> bool:
        """
        Sleep for a duration in seconds respecting simulation clock (/clock).
        Returns True if full duration slept, False if interrupted/shutdown.
        Raises RuntimeError if no runner or mock platform was injected.
        """
        if self._sleep_handler is None:
            raise RuntimeError(
                "Sleep handler not injected. In unit tests, configure a mock via set_sleep_handler()."
            )
        return self._sleep_handler(seconds)
