#!/usr/bin/env bash
# Build and smoke-test the stored golden packages of the .ros2 generator, and launch the
# stored .rossystem launch packages on top of them, inside the official ros:<distro> image.
#
#   tools/distro-matrix/build-golden.sh <distro> [language ...]
#
# language defaults to "cpp python". The packages come from
#   plugins/de.fraunhofer.ipa.ros.xtext.tests/resources/golden/expected/ros2/<distro>/<language>/
# and are built with deprecations treated as errors (C++ deprecated declarations and CMake
# deprecation messages), so an API that a distro deprecates fails here one release before
# it is removed. Each generated executable must then stay alive for a few seconds.
#
# Then the .rossystem packages from
#   plugins/de.fraunhofer.ipa.ros.xtext.tests/resources/golden/expected/rossystem/<system>/
# are built in the same workspace and `ros2 launch`ed: every node listed in LAUNCH_NODES
# below must appear in the graph, lifecycle nodes must answer `ros2 lifecycle get`, and the
# launch log must contain no Traceback and no dead process. Systems that load composable
# nodes need the C++ components and are launched for the cpp workspace only.
#
# Run inside CI with IN_CONTAINER=1 (the job already runs in ros:<distro>); locally the
# script starts the container itself.
set -euo pipefail

distro="${1:?usage: build-golden.sh <distro> [language ...]}"
shift
if [[ $# -gt 0 ]]; then languages=("$@"); else languages=(cpp python); fi

repo_root="$(cd "$(dirname "${BASH_SOURCE[0]}")/../.." && pwd)"
golden="plugins/de.fraunhofer.ipa.ros.xtext.tests/resources/golden/expected/ros2/${distro}"
systems="plugins/de.fraunhofer.ipa.ros.xtext.tests/resources/golden/expected/rossystem"

# Nodes each stored system must bring up (fully qualified), and which of them are lifecycle
# nodes. Keep in sync with resources/golden/models/*.rossystem.
declare -A LAUNCH_NODES=(
  [golden_system]="/service_node /robot/monitor /io_node /robot/action_node"
  [golden_composed]="/golden_container /service_node /robot/io_node"
)
declare -A LAUNCH_LIFECYCLE=(
  [golden_system]="/service_node /robot/monitor"
  [golden_composed]="/service_node"
)
declare -A LAUNCH_NEEDS_CPP=(
  [golden_composed]=1
)

if [[ ! -d "${repo_root}/${golden}" ]]; then
  echo "No golden output for distro '${distro}' at ${golden}" >&2
  exit 2
fi

if [[ "${IN_CONTAINER:-0}" != "1" ]]; then
  exec docker run --rm \
    -e IN_CONTAINER=1 \
    -v "${repo_root}:/rostooling:ro" \
    "ros:${distro}" \
    bash /rostooling/tools/distro-matrix/build-golden.sh "${distro}" "${languages[@]}"
fi

set +u
# shellcheck disable=SC1090
source "/opt/ros/${distro}/setup.bash"
set -u

# ros2 launch <system> <system>.launch.py, then check the graph while it runs. Every launch
# gets its own ROS domain and process group, so nodes of an earlier launch (several systems
# share node names) can neither satisfy nor disturb the checks.
launch_domain=40
smoke_launch() {
  local sys="$1" log="/tmp/launch_${1}_${lang}.log" ok=1 node
  echo "------------------- launch ${sys} (${distro} / ${lang}) -------------------"
  launch_domain=$((launch_domain + 1))
  export ROS_DOMAIN_ID=${launch_domain}
  ros2 daemon stop > /dev/null 2>&1 || true
  setsid ros2 launch "${sys}" "${sys}.launch.py" > "${log}" 2>&1 &
  local launch_pid=$!
  # Discovery takes a while (longer with Fast DDS in a container): poll the graph without the
  # daemon, whose cache can still hold participants of the previous launch.
  local nodes missing deadline=$((SECONDS + 40))
  while :; do
    sleep 2
    nodes="$(ros2 node list --no-daemon --spin-time 2 2> /dev/null | sort -u)"
    missing=""
    for node in ${LAUNCH_NODES[${sys}]}; do
      grep -qx -- "${node}" <<< "${nodes}" || missing+=" ${node}"
    done
    [[ -z "${missing}" || ${SECONDS} -ge ${deadline} ]] && break
  done
  echo "nodes: $(echo "${nodes}" | tr '\n' ' ')"
  for node in ${missing}; do
    echo "LAUNCH: node ${node} missing" >&2
    ok=0
  done
  for node in ${LAUNCH_LIFECYCLE[${sys}]}; do
    local state="" try
    for try in 1 2 3; do
      state="$(timeout 10 ros2 lifecycle get "${node}" 2> /dev/null)" || true
      grep -q "unconfigured" <<< "${state}" && break
      sleep 2
    done
    echo "lifecycle ${node}: ${state}"
    if ! grep -q "unconfigured" <<< "${state}"; then
      echo "LAUNCH: lifecycle node ${node} not reachable" >&2
      ok=0
    fi
  done
  # Errors while running, before the shutdown below adds its own messages.
  if grep -qE 'Traceback|process has died|TypeError|executable .* not found' "${log}"; then
    echo "LAUNCH: errors while running" >&2
    ok=0
  fi
  if ! kill -0 "${launch_pid}" 2> /dev/null; then
    echo "LAUNCH: ros2 launch exited early" >&2
    ok=0
  fi
  # Background jobs of a non-interactive shell ignore SIGINT, so stop launch with SIGTERM
  # (which it handles like Ctrl-C) and do not wait forever.
  kill -TERM "${launch_pid}" 2> /dev/null || true
  local waited=0
  while kill -0 "${launch_pid}" 2> /dev/null && [[ ${waited} -lt 30 ]]; do
    sleep 1
    waited=$((waited + 1))
  done
  if kill -0 "${launch_pid}" 2> /dev/null; then
    echo "LAUNCH: ros2 launch did not stop within 30 s" >&2
    ok=0
  fi
  kill -KILL -- "-${launch_pid}" 2> /dev/null || true
  wait "${launch_pid}" 2> /dev/null || true
  unset ROS_DOMAIN_ID
  if grep -q 'Traceback' "${log}"; then
    echo "LAUNCH: Traceback in launch log" >&2
    ok=0
  fi
  if [[ ${ok} -eq 1 ]]; then
    echo "LAUNCH OK: ${sys}"
    return 0
  fi
  echo "LAUNCH FAILED: ${sys} (${distro} / ${lang})" >&2
  cat "${log}" >&2
  return 1
}

status=0
for lang in "${languages[@]}"; do
  echo "=================== ${distro} / ${lang} ==================="
  ws="$(mktemp -d)"
  mkdir -p "${ws}/src"
  cp -r "${repo_root}/${golden}/${lang}/." "${ws}/src/"
  pushd "${ws}" > /dev/null

  if ! colcon build --event-handlers console_direct+ \
      --cmake-args -Werror=deprecated "-DCMAKE_CXX_FLAGS=-Werror=deprecated-declarations"; then
    echo "BUILD FAILED: ${distro} / ${lang}" >&2
    status=1
    popd > /dev/null
    continue
  fi

  set +u
  # shellcheck disable=SC1091
  source install/setup.bash
  set -u
  for pkg_dir in src/*/; do
    pkg="$(basename "${pkg_dir}")"
    for exe in $(ros2 pkg executables "${pkg}" | awk '{print $2}'); do
      timeout -s INT 4 ros2 run "${pkg}" "${exe}" > "/tmp/${exe}.log" 2>&1 && rc=0 || rc=$?
      # 124 = still running when the timeout fired; 130/-INT = clean shutdown on SIGINT.
      if [[ ${rc} -eq 124 || ${rc} -eq 130 || ${rc} -eq 0 ]] && ! grep -qE 'Traceback|terminate called|Segmentation fault' "/tmp/${exe}.log"; then
        echo "SMOKE OK: ${pkg}/${exe}"
      else
        echo "SMOKE FAILED (${rc}): ${pkg}/${exe}" >&2
        cat "/tmp/${exe}.log" >&2
        status=1
      fi
    done
  done

  # ---- .rossystem launch files on top of golden_pkg -------------------------------
  launch_systems=()
  for sys_dir in "${repo_root}/${systems}"/*/; do
    sys="$(basename "${sys_dir}")"
    if [[ -n "${LAUNCH_NEEDS_CPP[${sys}]:-}" && "${lang}" != "cpp" ]]; then
      continue
    fi
    cp -r "${sys_dir}" "src/${sys}"
    launch_systems+=("${sys}")
  done
  if [[ ${#launch_systems[@]} -gt 0 ]]; then
    if ! colcon build --event-handlers console_direct+ --packages-select "${launch_systems[@]}" \
        --cmake-args -Werror=deprecated; then
      echo "BUILD FAILED: ${distro} / ${lang} / ${launch_systems[*]}" >&2
      status=1
      popd > /dev/null
      continue
    fi
    set +u
    # shellcheck disable=SC1091
    source install/setup.bash
    set -u
  fi
  for sys in "${launch_systems[@]}"; do
    smoke_launch "${sys}" || status=1
  done
  popd > /dev/null
done

exit ${status}
