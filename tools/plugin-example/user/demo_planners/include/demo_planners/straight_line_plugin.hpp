#pragma once

#include "demo_core/planner.hpp"
#include "demo_planners/straight_line_plugin_wrapper.hpp"

namespace demo_planners {

/** User-owned plugin logic (the generated stub, with the base's method implemented). */
class StraightLine : public demo_core::Planner {
public:
  StraightLine() = default;
  ~StraightLine() override = default;

  std::string name() const override { return "StraightLine"; }

protected:
  StraightLineRosWrapper ros_wrapper_;
};

}  // namespace demo_planners
