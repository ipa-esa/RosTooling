#!/usr/bin/env bash
# Build and smoke-test the stored golden packages of the .ros2 generator inside the
# official ros:<distro> Docker image.
#
#   tools/distro-matrix/build-golden.sh <distro> [language ...]
#
# language defaults to "cpp python". The packages come from
#   plugins/de.fraunhofer.ipa.ros.xtext.tests/resources/golden/expected/ros2/<distro>/<language>/
# and are built with deprecations treated as errors (C++ deprecated declarations and CMake
# deprecation messages), so an API that a distro deprecates fails here one release before
# it is removed. Each generated executable must then stay alive for a few seconds.
#
# Run inside CI with IN_CONTAINER=1 (the job already runs in ros:<distro>); locally the
# script starts the container itself.
set -euo pipefail

distro="${1:?usage: build-golden.sh <distro> [language ...]}"
shift
if [[ $# -gt 0 ]]; then languages=("$@"); else languages=(cpp python); fi

repo_root="$(cd "$(dirname "${BASH_SOURCE[0]}")/../.." && pwd)"
golden="plugins/de.fraunhofer.ipa.ros.xtext.tests/resources/golden/expected/ros2/${distro}"

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
  popd > /dev/null
done

exit ${status}
