# Supporting ROS 2 distributions in the code generators

The `.ros2` generator emits code for one target distribution per run. Everything that differs
between distributions lives in the plugin `plugins/de.fraunhofer.ipa.ros2.distro`:

| Piece | Where | Role |
|---|---|---|
| `Ros2Distros` | `de.fraunhofer.ipa.ros2.distro` | The only list of supported distributions. Each entry derives from its predecessor and overrides only what changed. |
| `Ros2Distro` | same | One distribution: values (C++ standard, CMake minimum), variants (enums such as `ServiceQosArgument`, `RateImplementation`), status. |
| Dialects (`CppDialect`, `CMakeDialect`) | `...distro.dialect` | Turn a distribution into code fragments. The only code that switches on variants, with exhaustive `switch` expressions. |
| `Ros2Target` | `...distro.dialect` | Per-request context (distribution + dialects) passed into the Xtend templates. |

Templates never name a distribution; `Ros2DistrosTest.generatorsDoNotNameDistributions` fails if
one does. The LSP command `ros2.listDistros` (MCP tool `list_ros2_distros`) publishes the registry
to the extension and to agents.

## Rules

1. **Prefer one form that works on every supported distribution.** Introduce a variant only when
   no such form exists. Example: `target_link_libraries(... ${pkg_TARGETS})` works from Humble on,
   so it replaced `ament_target_dependencies` everywhere instead of becoming a variant.
2. **Name variants after the API decision, never after a release** (`ServiceQosArgument`, not
   `HumbleMode`), so later distributions simply inherit them.
3. **Take values from the distribution itself**: headers in `/opt/ros/<distro>/include`, the
   `ros2 pkg create` templates (`ros2pkg/resource`), `ros:<distro>` images. Not from memory.
4. **Variants that no longer distinguish anything are deleted.** `everyVariantStillDistinguishesDistributions`
   fails when all supported distributions share one value (typically after an EOL).

## Adding a distribution

1. In `Ros2Distros`, add `NEXT = <newest>.derive("next")...build()`, append it to `ALL`, and derive
   `ROLLING` from it.
2. Regenerate the golden files:
   `ROSTOOLING_UPDATE_GOLDEN=1 ./mvnw -o install -f plugins/de.fraunhofer.ipa.ros.parent/pom.xml`
   (or `-rf :de.fraunhofer.ipa.ros.xtext.tests` after a full build).
3. Build them in the official image: `tools/distro-matrix/build-golden.sh next`.
   Deprecations are errors here, so the failures name exactly what changed.
4. For each failure: change a value, flip a variant, or add a variant (enum constant + dialect
   `case`; the compiler lists every switch that must handle it). Repeat 2–3 until green.
5. Review the golden diff between the previous distribution and the new one, add the distribution to
   the CI matrix (`.github/workflows/distro-matrix.yml`), commit.

Retiring a distribution: remove it from `ALL`, delete its golden directory, then inline the
variants the registry test reports.

## Running the checks

```bash
# all golden packages of one distribution, both languages
tools/distro-matrix/build-golden.sh humble
# one language
tools/distro-matrix/build-golden.sh lyrical cpp
```

The script mounts the repository read-only into `ros:<distro>`, runs `colcon build` with
`-Werror=deprecated` (CMake) and `-Werror=deprecated-declarations` (C++), then starts every
generated executable and checks it is still running after a few seconds.
