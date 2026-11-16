#!/usr/bin/env bash
# Prints the shields.io endpoint JSON for one distribution's status badge.
#
#   badge-json.sh <distro> <result>
#
# <result> is a GitHub step outcome (success, failure, cancelled, skipped) or "missing" when the
# job left no result. Only success is green: a distribution that is allowed to fail (rolling) still
# shows red when it fails, and a cancelled run is grey rather than keeping an old green badge.
set -euo pipefail

distro=${1:?usage: badge-json.sh <distro> <result>}
result=${2:?usage: badge-json.sh <distro> <result>}

case "$result" in
  success)   message=passing;   color=brightgreen ;;
  cancelled) message=cancelled; color=lightgrey ;;
  failure)   message=failing;   color=red ;;
  *)         message=error;     color=red ;;   # skipped/missing: the job broke before building
esac

printf '{"schemaVersion":1,"label":"%s","message":"%s","color":"%s"}\n' "$distro" "$message" "$color"
