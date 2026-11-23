# Compatibility snapshots

Design policy rule 6: a `.ros`, `.ros1`, `.ros2` or `.rossystem` model that uses only syntax on
`main` must parse, validate and generate identically before and after each change. These scripts
check that against real models, not just the golden fixtures.

| File | Role |
|---|---|
| `units.template.txt` | The models to check, one unit per line: `name\|subject-dir\|library-dirs`. Library directories are loaded for linking only. |
| `snapshot.sh OUT_DIR [UNITS]` | Builds this checkout and runs `CompatibilitySnapshotTest`, which writes per model file: its SHA-256, its validation issues, and its generated output (`.ros2`: C++ and Python in separate runs, newest LTS distro; `.rossystem`). Generator exceptions are recorded, not fatal. |
| `compare.sh BASE [UNITS]` | Snapshots `BASE` in a temporary worktree (cached in `.snapshots/`) and the working tree, then diffs them. Exit 1 on any difference; the diff is in `.snapshots/last-diff.txt`. |

Models outside this repository are found through environment variables; units whose variable is
unset are skipped:

```bash
export ROSTOOLING_EXTENSION_REPO=/path/to/RosTooling_Extension
export ROSTOOLING_STUDIO_REPO=/path/to/ipa-rostooling-studio
tools/compat/compare.sh <base-commit>
```

Both runs read the models from the current checkout, so only core changes show up. If a model
file itself changed, its `sha256` line changes too.
