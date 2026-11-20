#!/usr/bin/env bash
# Compares how two commits treat existing models (design policy rule 6).
#
#   tools/compat/compare.sh BASE_COMMIT [UNITS_FILE]
#
# Snapshots BASE_COMMIT (in a temporary git worktree, cached under tools/compat/.snapshots/)
# and the current working tree, then diffs them. Exit 0 = no difference, 1 = differences.
# A unit whose model file changed between the runs shows up as a changed sha256 line, so a
# model edit is not mistaken for a generator change.
set -euo pipefail

here="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
repo="$(cd "$here/../.." && pwd)"
base="${1:?usage: compare.sh BASE_COMMIT [UNITS_FILE]}"
units="${2:-$here/units.template.txt}"
# Both runs read the models from this checkout, not from the base worktree.
export ROSTOOLING_REPO="${ROSTOOLING_REPO:-$repo}"
base_sha="$(git -C "$repo" rev-parse --verify "$base^{commit}")"
cache="$here/.snapshots"
base_out="$cache/$base_sha"
head_out="$cache/working-tree"

if [[ ! -f "$base_out/SUMMARY.txt" ]]; then
  worktree="$(mktemp -d)/rostooling-base"
  git -C "$repo" worktree add --detach "$worktree" "$base_sha" >/dev/null
  trap 'git -C "$repo" worktree remove --force "$worktree" >/dev/null 2>&1 || true' EXIT
  if [[ ! -f "$worktree/tools/compat/snapshot.sh" ]]; then
    echo "$base has no tools/compat/snapshot.sh; use a commit at or after step 0." >&2
    exit 2
  fi
  "$worktree/tools/compat/snapshot.sh" "$base_out" "$units"
fi

"$here/snapshot.sh" "$head_out" "$units"

if diff -r -u "$base_out" "$head_out" > "$cache/last-diff.txt"; then
  echo "No difference from ${base_sha:0:8}."
else
  echo "Differences from ${base_sha:0:8}: $(grep -cE '^(diff |Only in )' "$cache/last-diff.txt" || true) file(s); see $cache/last-diff.txt"
  exit 1
fi
