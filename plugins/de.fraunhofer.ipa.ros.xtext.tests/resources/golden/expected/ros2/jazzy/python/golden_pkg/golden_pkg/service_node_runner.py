#!/usr/bin/env python3
# -*- coding: utf-8 -*-

import sys
import rclpy
from rclpy.lifecycle import State, TransitionCallbackReturn
from rclpy.duration import Duration
from rclpy.executors import ExternalShutdownException, MultiThreadedExecutor, SingleThreadedExecutor
from golden_pkg.service_node_wrapper import service_nodeWrapper
from golden_pkg.service_node_logic import service_nodeLogic, GoalStatus


class service_nodeNode(service_nodeWrapper):
    """
    Concrete ROS 2 Node coupling the pure logic with the generated wrapper.
    """

    def __init__(self):
        super().__init__()
        self.logic = service_nodeLogic()

        # Inject simulation-synchronized timer factory
        self.logic.set_timer_factory(lambda period_sec, callback: self.create_timer(period_sec, callback))

        # Inject simulation-synchronized rate factory using Node's clock
        self.logic.set_rate_factory(lambda hz: self.create_rate(hz))
        
        # Inject ROS2 rclpy logger
        self.logic.set_logger(lambda log_level, msg: self.log(log_level, msg))

        # Inject runtime liveness check
        self.logic.set_ok_handler(lambda: rclpy.ok())

        # Inject runtime shutdown handler
        def _on_shutdown(reason: str = "") -> None:
            if reason:
                self.get_logger().info(f"Shutdown requested by logic: {reason}")
            rclpy.shutdown()
        self.logic.set_shutdown_handler(_on_shutdown)

        # Inject simulation-synchronized clock
        self.logic.set_clock_handler(lambda: self.get_clock().now().nanoseconds / 1e9)

        # Inject simulation-synchronized sleep
        self.logic.set_sleep_handler(lambda sec: self.get_clock().sleep_for(Duration(seconds=sec)))
        
        # Inject parameters via setter

        # Inject publisher delegates
        self.logic.set_heartbeat_publisher(self.publish_heartbeat)

        # Inject service client callers
        self.logic.set_enable_client_client(
            self.call_enable_client_sync,
            self.call_enable_client_async
        )

        # Inject action client callers

    # ==========================================
    # LIFECYCLE TRANSITION CALLBACK OVERRIDES
    # ==========================================
    def on_configure(self, state: State) -> TransitionCallbackReturn:
        super_ret = super().on_configure(state)
        if super_ret != TransitionCallbackReturn.SUCCESS:
            return super_ret
        return TransitionCallbackReturn.SUCCESS if self.logic.on_configure() else TransitionCallbackReturn.FAILURE

    def on_activate(self, state: State) -> TransitionCallbackReturn:
        super_ret = super().on_activate(state)
        if super_ret != TransitionCallbackReturn.SUCCESS:
            return super_ret
        return TransitionCallbackReturn.SUCCESS if self.logic.on_activate() else TransitionCallbackReturn.FAILURE

    def on_deactivate(self, state: State) -> TransitionCallbackReturn:
        super_ret = super().on_deactivate(state)
        if super_ret != TransitionCallbackReturn.SUCCESS:
            return super_ret
        return TransitionCallbackReturn.SUCCESS if self.logic.on_deactivate() else TransitionCallbackReturn.FAILURE

    def on_cleanup(self, state: State) -> TransitionCallbackReturn:
        super_ret = super().on_cleanup(state)
        if super_ret != TransitionCallbackReturn.SUCCESS:
            return super_ret
        return TransitionCallbackReturn.SUCCESS if self.logic.on_cleanup() else TransitionCallbackReturn.FAILURE

    def on_shutdown(self, state: State) -> TransitionCallbackReturn:
        super_ret = super().on_shutdown(state)
        if super_ret != TransitionCallbackReturn.SUCCESS:
            return super_ret
        return TransitionCallbackReturn.SUCCESS if self.logic.on_shutdown() else TransitionCallbackReturn.FAILURE

    def on_error(self, state: State) -> TransitionCallbackReturn:
        super_ret = super().on_error(state)
        if super_ret != TransitionCallbackReturn.SUCCESS:
            return super_ret
        return TransitionCallbackReturn.SUCCESS if self.logic.on_error() else TransitionCallbackReturn.FAILURE

    def handle_reset(self, request, response):
        ret = self.logic.handle_reset(request, response)
        if ret is not None and isinstance(ret, type(response)):
            return ret
        return response

    
    # Helper function executed during logger injection
    def log(self, log_level: service_nodeLogic.LogLevel, msg: str) -> None:
        match log_level:
            case service_nodeLogic.LogLevel.DEBUG:
                self.get_logger().debug(msg)
            case service_nodeLogic.LogLevel.INFO:
                self.get_logger().info(msg)
            case service_nodeLogic.LogLevel.WARN:
                self.get_logger().warn(msg)
            case service_nodeLogic.LogLevel.ERROR:
                self.get_logger().error(msg)
    
    #Helper function to request parameter validation from logic

def main(args=None):
    rclpy.init(args=args)
    node = service_nodeNode()

    # Automated Executor Selection: MultiThreadedExecutor selected
    executor = MultiThreadedExecutor()
    executor.add_node(node)
    try:
        executor.spin()
    except (KeyboardInterrupt, ExternalShutdownException):
        pass
    finally:
        node.destroy_node()
        # Ctrl+C or the logic's shutdown handler may already have shut the context down.
        if rclpy.ok():
            rclpy.shutdown()


if __name__ == '__main__':
    main()
