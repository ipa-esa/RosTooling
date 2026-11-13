#!/usr/bin/env python3
# -*- coding: utf-8 -*-

import sys
import rclpy
from rclpy.duration import Duration
from rclpy.executors import ExternalShutdownException, MultiThreadedExecutor, SingleThreadedExecutor
from golden_pkg.action_node_wrapper import action_nodeWrapper
from golden_pkg.action_node_logic import action_nodeLogic, GoalStatus


class action_nodeNode(action_nodeWrapper):
    """
    Concrete ROS 2 Node coupling the pure logic with the generated wrapper.
    """

    def __init__(self):
        super().__init__()
        self.logic = action_nodeLogic()

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

        # Inject service client callers

        # Inject action client callers
        self.logic.set_lookup_client_client(
            self._wrap_send_lookup_client_goal_async,
            self.cancel_lookup_client_goal_async
        )

    def _wrap_send_lookup_client_goal_async(self, goal, response_callback=None, feedback_callback=None, result_callback=None):
        future = self.send_lookup_client_goal_async(goal, feedback_callback=feedback_callback)
        if future is None:
            if response_callback:
                response_callback(False)
            return None
        if response_callback or result_callback:
            def _goal_response_cb(fut):
                goal_handle = fut.result()
                accepted = bool(goal_handle and goal_handle.accepted)
                if response_callback:
                    response_callback(accepted)
                if not accepted:
                    self.get_logger().warn("Goal rejected by action server 'lookup_client'")
                    return
                if result_callback and goal_handle:
                    res_fut = goal_handle.get_result_async()
                    def _on_result(rf):
                        status_map = {
                            4: GoalStatus.SUCCEEDED,
                            5: GoalStatus.CANCELED,
                            6: GoalStatus.ABORTED,
                        }
                        status = status_map.get(rf.result().status, GoalStatus.UNKNOWN)
                        result_callback(status, rf.result().result)
                    res_fut.add_done_callback(_on_result)
            future.add_done_callback(_goal_response_cb)
        return future


    def on_lookup_goal(self, goal_request):
        accept = self.logic.handle_goal_lookup(goal_request)
        from rclpy.action import GoalResponse
        return GoalResponse.ACCEPT if accept else GoalResponse.REJECT

    def on_lookup_cancel(self, goal_handle):
        accept = self.logic.handle_cancel_lookup()
        from rclpy.action import CancelResponse
        return CancelResponse.ACCEPT if accept else CancelResponse.REJECT

    def execute_lookup(self, goal_handle):
        from tf2_msgs.action import LookupTransform
        publish_fb = lambda fb: goal_handle.publish_feedback(fb)
        is_canceling = lambda: goal_handle.is_cancel_requested
        result = LookupTransform.Result()

        success = self.logic.execute_lookup(
            goal_handle.request,
            publish_fb,
            is_canceling,
            result
        )

        if goal_handle.is_cancel_requested:
            goal_handle.canceled()
        elif success:
            goal_handle.succeed()
        else:
            goal_handle.abort()
        return result

    
    # Helper function executed during logger injection
    def log(self, log_level: action_nodeLogic.LogLevel, msg: str) -> None:
        match log_level:
            case action_nodeLogic.LogLevel.DEBUG:
                self.get_logger().debug(msg)
            case action_nodeLogic.LogLevel.INFO:
                self.get_logger().info(msg)
            case action_nodeLogic.LogLevel.WARN:
                self.get_logger().warn(msg)
            case action_nodeLogic.LogLevel.ERROR:
                self.get_logger().error(msg)
    
    #Helper function to request parameter validation from logic

def main(args=None):
    rclpy.init(args=args)
    node = action_nodeNode()

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
