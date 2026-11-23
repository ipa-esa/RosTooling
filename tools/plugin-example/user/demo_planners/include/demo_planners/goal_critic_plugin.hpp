#pragma once

#include "demo_core/critic.hpp"
#include "demo_planners/goal_critic_plugin_wrapper.hpp"

namespace demo_planners {

/** User-owned plugin logic (the generated stub, with the base's method implemented). */
class GoalCritic : public demo_core::Critic {
public:
  GoalCritic() = default;
  ~GoalCritic() override = default;

  std::string name() const override { return "GoalCritic"; }

protected:
  GoalCriticRosWrapper ros_wrapper_;
};

}  // namespace demo_planners
