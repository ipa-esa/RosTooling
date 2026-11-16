package de.fraunhofer.ipa.ros2.distro.dialect;

import de.fraunhofer.ipa.ros2.distro.Ros2Distro;

/** rclcpp code fragments whose syntax depends on the target distribution. */
public class CppDialect {

    private final Ros2Distro distro;

    public CppDialect(Ros2Distro distro) {
        this.distro = distro;
    }

    /** QoS argument for {@code create_service} and {@code create_client}. */
    public String serviceQos() {
        return switch (distro.serviceQosArgument()) {
            case RMW_QOS_PROFILE -> "rmw_qos_profile_services_default";
            case RCLCPP_QOS -> "rclcpp::ServicesQoS()";
        };
    }

    /**
     * Class {@code Ros2RateAdapter}, implementing {@code rateBaseClass} (the algorithm-side
     * {@code Rate} interface with {@code bool sleep()} and {@code void reset()}) on the node's clock,
     * so rates follow simulated time. Constructor: {@code (double hz, rclcpp::Clock::SharedPtr clock)}.
     */
    public String rateAdapter(String rateBaseClass) {
        return switch (distro.rateImplementation()) {
            case RCLCPP_RATE_WITH_CLOCK -> """
                    /**
                     * @brief Adapter wrapping rclcpp::Rate with the node's ROS clock
                     */
                    class Ros2RateAdapter : public %s {
                    public:
                        Ros2RateAdapter(double hz, rclcpp::Clock::SharedPtr clock)
                        : rate_(hz, clock)
                        {}

                        bool sleep() override {
                            return rate_.sleep();
                        }

                        void reset() override {
                            rate_.reset();
                        }

                    private:
                        rclcpp::Rate rate_;
                    };""".formatted(rateBaseClass);
            case CLOCK_SLEEP_UNTIL -> """
                    /**
                     * @brief Rate on the node's ROS clock, built on rclcpp::Clock::sleep_until
                     * (this distribution's rclcpp::Rate only supports the wall clock)
                     */
                    class Ros2RateAdapter : public %s {
                    public:
                        Ros2RateAdapter(double hz, rclcpp::Clock::SharedPtr clock)
                        : clock_(clock),
                          period_(rclcpp::Duration::from_seconds(1.0 / hz)),
                          next_(clock->now() + period_)
                        {}

                        bool sleep() override {
                            const rclcpp::Time now = clock_->now();
                            if (next_ < now) {
                                // Missed the deadline: realign to the period instead of catching up.
                                next_ = now + period_;
                                return false;
                            }
                            const bool slept = clock_->sleep_until(next_);
                            next_ = next_ + period_;
                            return slept;
                        }

                        void reset() override {
                            next_ = clock_->now() + period_;
                        }

                    private:
                        rclcpp::Clock::SharedPtr clock_;
                        rclcpp::Duration period_;
                        rclcpp::Time next_;
                    };""".formatted(rateBaseClass);
        };
    }
}
