#!/usr/bin/env bash
# Writes a compatibility snapshot of the RosTooling checkout this script lives in.
#
#   tools/compat/snapshot.sh OUT_DIR [UNITS_FILE]
#
# Builds the checkout with Maven/Tycho and runs CompatibilitySnapshotTest, which parses,
# validates and generates every model listed in UNITS_FILE (default: units.template.txt).
# @ROSTOOLING@, @EXTENSION@ and @STUDIO@ in the units file are replaced with
# ROSTOOLING_REPO (default: this checkout), ROSTOOLING_EXTENSION_REPO and
# ROSTOOLING_STUDIO_REPO; lines whose variable is unset are skipped. OUT_DIR is replaced.
set -euo pipefail

here="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
repo="$(cd "$here/../.." && pwd)"
out="${1:?usage: snapshot.sh OUT_DIR [UNITS_FILE]}"
units="${2:-$here/units.template.txt}"

mkdir -p "$(dirname "$out")"
out="$(cd "$(dirname "$out")" && pwd)/$(basename "$out")"
expanded="$(mktemp)"
trap 'rm -f "$expanded"' EXIT
declare -A roots=(
  [ROSTOOLING]="${ROSTOOLING_REPO:-$repo}"
  [EXTENSION]="${ROSTOOLING_EXTENSION_REPO:-}"
  [STUDIO]="${ROSTOOLING_STUDIO_REPO:-}"
)
while IFS= read -r line || [[ -n "$line" ]]; do
  skip=""
  for key in "${!roots[@]}"; do
    if [[ "$line" == *"@$key@"* ]]; then
      if [[ -z "${roots[$key]}" ]]; then skip=1; break; fi
      line="${line//@$key@/${roots[$key]}}"
    fi
  done
  if [[ -z "$skip" ]]; then printf '%s\n' "$line"; fi
done < "$units" > "$expanded"
units="$expanded"

ROSTOOLING_COMPAT_UNITS="$units" ROSTOOLING_COMPAT_OUT="$out" \
  "$repo/mvnw" -q -B clean verify -f "$repo/plugins/de.fraunhofer.ipa.ros.parent/pom.xml" \
    -Dtest=CompatibilitySnapshotTest -Dsurefire.failIfNoSpecifiedTests=false -DfailIfNoTests=false

if [[ ! -f "$out/SUMMARY.txt" ]]; then
  echo "Snapshot was not written; check the Maven output." >&2
  exit 1
fi
cat "$out/SUMMARY.txt"
