#pragma once

#include "demo_core/planner.hpp"
#include "demo_planners/smooth_plugin_wrapper.hpp"

namespace demo_planners {

/** User-owned plugin logic (the generated stub, with the base's method implemented). */
class Smooth : public demo_core::Planner {
public:
  Smooth() = default;
  ~Smooth() override = default;

  std::string name() const override { return "Smooth"; }

protected:
  SmoothRosWrapper ros_wrapper_;
};

}  // namespace demo_planners
