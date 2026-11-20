#pragma once

#include "demo_core/critic.hpp"
#include "demo_planners/align_critic_plugin_wrapper.hpp"

namespace demo_planners {

/** User-owned plugin logic (the generated stub, with the base's method implemented). */
class AlignCritic : public demo_core::Critic {
public:
  AlignCritic() = default;
  ~AlignCritic() override = default;

  std::string name() const override { return "AlignCritic"; }

protected:
  AlignCriticRosWrapper ros_wrapper_;
};

}  // namespace demo_planners
