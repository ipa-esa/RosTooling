#pragma once

#include <string>

namespace demo_core {

/** Plugin base, written by hand: RosTooling models plugin bases but does not generate them. */
class Critic {
public:
  virtual ~Critic() = default;
  virtual std::string name() const = 0;
};

}  // namespace demo_core
