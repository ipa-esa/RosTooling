#!/usr/bin/env bash
# Builds and runs the plugin example: a plugin base package, a plugin package, a host node with
# a single and a multiple slot, and a system that attaches plugins to both slots.
#
#   tools/plugin-example/run.sh [WORKSPACE]      (default: tools/plugin-example/.work)
#
# 1. Generates the models in models/ with this checkout (PluginExampleGenerationTest).
# 2. Adds the hand-written base package (base/) and the user-owned plugin files (user/), which
#    replace the generated stubs: the stubs do not implement the base's methods.
# 3. Builds the workspace with colcon and checks, from the node's log, that
#    - the host alone loads its slot default, and
#    - the system launch loads the plugins attached under slots:.
# Needs a sourced-able ROS 2 installation (ROS_DISTRO, default jazzy) with pluginlib.
set -euo pipefail

here="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
repo="$(cd "$here/../.." && pwd)"
ws="${1:-$here/.work}"
distro="${ROS_DISTRO:-jazzy}"

rm -rf "$ws"
mkdir -p "$ws/src"
ws="$(cd "$ws" && pwd)"

ROSTOOLING_EXAMPLE_MODELS="$here/models" ROSTOOLING_EXAMPLE_OUT="$ws/src" ROSTOOLING_EXAMPLE_DISTRO="$distro" \
  "$repo/mvnw" -q -B clean verify -f "$repo/plugins/de.fraunhofer.ipa.ros.parent/pom.xml" \
    -Dtest=PluginExampleGenerationTest -Dsurefire.failIfNoSpecifiedTests=false -DfailIfNoTests=false
cp -r "$here/base/." "$ws/src/"
cp -r "$here/user/." "$ws/src/"

set +u
# shellcheck disable=SC1090
source "/opt/ros/$distro/setup.bash"
set -u
cd "$ws"
colcon build --event-handlers console_direct- > build.log 2>&1 || { tail -40 build.log; echo "colcon build failed; see $ws/build.log" >&2; exit 1; }
set +u
# shellcheck disable=SC1091
source install/setup.bash
set -u

check() {
  local log="$1" expected="$2"
  if grep -q -- "$expected" "$log"; then
    echo "ok: $expected"
  else
    echo "MISSING in $log: $expected" >&2
    cat "$log" >&2
    exit 1
  fi
}

timeout 5 ros2 run demo_planner_server planner_server > host.log 2>&1 || true
check host.log "Slot 'planner': loaded plugin 'demo_planners::StraightLine'"

timeout 8 ros2 launch demo_system demo_system.launch.py > system.log 2>&1 || true
check system.log "Slot 'planner': loaded plugin 'demo_planners::Smooth'"
check system.log "Slot 'critics': loaded plugin 'demo_planners::AlignCritic'"
check system.log "Slot 'critics': loaded plugin 'demo_planners::GoalCritic'"
echo "Plugin example passed."
