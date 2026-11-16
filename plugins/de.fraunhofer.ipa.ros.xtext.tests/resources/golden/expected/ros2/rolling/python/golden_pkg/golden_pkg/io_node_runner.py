#!/usr/bin/env python3
# -*- coding: utf-8 -*-

import sys
import rclpy
from rclpy.duration import Duration
from rclpy.executors import ExternalShutdownException, MultiThreadedExecutor, SingleThreadedExecutor
from rcl_interfaces.msg import SetParametersResult
from typing import List
from golden_pkg.io_node_wrapper import io_nodeWrapper
from golden_pkg.io_node_logic import io_nodeLogic, GoalStatus


class io_nodeNode(io_nodeWrapper):
    """
    Concrete ROS 2 Node coupling the pure logic with the generated wrapper.
    """

    def __init__(self):
        super().__init__()
        self.logic = io_nodeLogic()

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
        self.logic.set_parameter("rate_hz", self.get_param_rate_hz())
        self.logic.set_parameter("max_count", self.get_param_max_count())
        self.logic.set_parameter("enabled", self.get_param_enabled())
        self.logic.set_parameter("frame_id", self.get_param_frame_id())

        # Inject publisher delegates
        self.logic.set_status_out_publisher(self.publish_status_out)
        self.logic.set_pose_out_publisher(self.publish_pose_out)

        # Inject service client callers

        # Inject action client callers


    def on_scan_in_msg(self, msg) -> None:
        self.logic.on_scan_in_received(msg)

    def on_cmd_in_msg(self, msg) -> None:
        self.logic.on_cmd_in_received(msg)

    
    # Helper function executed during logger injection
    def log(self, log_level: io_nodeLogic.LogLevel, msg: str) -> None:
        match log_level:
            case io_nodeLogic.LogLevel.DEBUG:
                self.get_logger().debug(msg)
            case io_nodeLogic.LogLevel.INFO:
                self.get_logger().info(msg)
            case io_nodeLogic.LogLevel.WARN:
                self.get_logger().warn(msg)
            case io_nodeLogic.LogLevel.ERROR:
                self.get_logger().error(msg)
    
    #Helper function to request parameter validation from logic
    def on_parameters_changed(self, parameters: List[rclpy.Parameter]) -> SetParametersResult:
        result = super().on_parameters_changed(parameters)
        for param in parameters:
            val = param.get_parameter_value()
            validation = self.logic.validate_parameter(param.name, val)
            if not validation.successfull:
                result.successful = False
                result.reason = validation.reason if len(validation.reason) > 0 else f"Validation failed for parameter '{param.name}'"
                return result
        
        return result

def main(args=None):
    rclpy.init(args=args)
    node = io_nodeNode()

    # Automated Executor Selection: SingleThreadedExecutor selected
    try:
        rclpy.spin(node)
    except (KeyboardInterrupt, ExternalShutdownException):
        pass
    finally:
        node.destroy_node()
        # Ctrl+C or the logic's shutdown handler may already have shut the context down.
        if rclpy.ok():
            rclpy.shutdown()


if __name__ == '__main__':
    main()
