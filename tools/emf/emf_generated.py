#!/usr/bin/env python3
"""Regenerates the EMF model and edit code from the ecore/genmodel files and compares it with
what is checked in, so a metamodel change cannot silently drop a hand edit and nobody can hand-edit
generated code without it being noticed.

  tools/emf/emf_generated.py --check    # exit 1 if the checked-in code differs from the generator
  tools/emf/emf_generated.py --write    # replace the checked-in code by the generator's output

The comparison ignores whitespace (the checked-in code was formatted by the Eclipse formatter).
Members listed in tools/emf/hand-edits.txt are the only hand edits allowed; --write keeps them.
Needs a JDK and the Eclipse EMF bundles in ~/.m2/repository/p2/osgi/bundle (a Tycho build puts
them there). Plugins: de.fraunhofer.ipa.ros and de.fraunhofer.ipa.rossystem, with their .edit plugins.
"""
import argparse
import os
import re
import shutil
import subprocess
import sys
import tempfile
from pathlib import Path

HERE = Path(__file__).resolve().parent
PLUGINS = HERE.parent.parent / "plugins"
MODELS = ["de.fraunhofer.ipa.ros", "de.fraunhofer.ipa.rossystem"]
GENMODELS = ["de.fraunhofer.ipa.ros/model/ros.genmodel", "de.fraunhofer.ipa.rossystem/model/rossystem.genmodel"]
BUNDLES = ["org.eclipse.emf.common", "org.eclipse.emf.ecore", "org.eclipse.emf.ecore.xmi", "org.eclipse.emf.codegen",
           "org.eclipse.emf.codegen.ecore", "org.eclipse.emf.edit", "org.eclipse.equinox.common",
           "org.eclipse.core.runtime", "org.eclipse.osgi", "org.eclipse.core.jobs", "org.eclipse.jdt.core",
           "org.eclipse.jdt.core.compiler.batch", "org.eclipse.text", "org.eclipse.core.contenttype",
           "org.eclipse.equinox.preferences", "org.eclipse.equinox.registry", "org.osgi.service.prefs",
           "org.osgi.service.event", "org.eclipse.core.resources", "org.eclipse.core.filesystem",
           "org.eclipse.core.expressions", "org.eclipse.equinox.app", "org.eclipse.core.commands"]


def sort_key(path):
    return [int(p) if p.isdigit() else p for p in re.split(r"(\d+)", path.parent.name)]


def jars():
    root = Path.home() / ".m2/repository/p2/osgi/bundle"
    found = []
    for name in BUNDLES:
        versions = sorted((root / name).glob("*/*.jar"), key=sort_key) if (root / name).is_dir() else []
        if versions:
            found.append(versions[-1])
        elif name in ("org.eclipse.emf.ecore", "org.eclipse.emf.codegen.ecore", "org.eclipse.emf.common"):
            sys.exit("missing bundle %s under %s; run the Maven build once first" % (name, root))
    return found


def generate(out):
    classpath = jars()
    work = Path(tempfile.mkdtemp(prefix="emfgen-"))
    try:
        subprocess.run(["javac", "-nowarn", "-cp", os.pathsep.join(map(str, classpath)), "-d", str(work),
                        str(HERE / "EmfGen.java")], check=True, stderr=subprocess.DEVNULL)
        for plugin in MODELS:
            (out / plugin / "model").mkdir(parents=True)
            (out / (plugin + ".edit")).mkdir(parents=True)
            for f in (PLUGINS / plugin / "model").iterdir():
                if f.suffix in (".ecore", ".genmodel"):
                    shutil.copy(f, out / plugin / "model" / f.name)
        ecore = next(j for j in classpath if "emf.ecore-" in j.name and "xmi" not in j.name)
        codegen = next(j for j in classpath if "codegen.ecore" in j.name)
        result = subprocess.run(
            ["java", "-cp", os.pathsep.join([str(work)] + list(map(str, classpath))), "EmfGen", str(out),
             str(ecore), str(codegen)] + GENMODELS, capture_output=True, text=True)
        if result.returncode != 0 or "Exception" in result.stderr:
            sys.exit("generator failed:\n" + result.stdout[-2000:] + result.stderr[-2000:])
    finally:
        shutil.rmtree(work, ignore_errors=True)


def known_stale():
    """Classes left over from older metamodel versions, kept because other code still mentions them."""
    path = HERE / "known-stale.txt"
    return {l.strip() for l in path.read_text().splitlines() if l.strip() and not l.startswith("#")} \
        if path.exists() else set()


def hand_edits():
    edits = {}
    for line in (HERE / "hand-edits.txt").read_text().splitlines():
        line = line.strip()
        if line and not line.startswith("#"):
            path, method = line.split()
            edits.setdefault(path, []).append(method)
    return edits


def method_span(text, name):
    """(start, end) of a method and its Javadoc, or None."""
    m = re.search(r"\n[ \t]*(?:@Override\s*\n[ \t]*)?public [\w<>\[\], ?]+ %s\(\)[^{;]*\{" % re.escape(name), text)
    if not m:
        return None
    start = text.rfind("/**", 0, m.start())
    depth, i = 0, m.end() - 1
    while True:
        if text[i] == "{":
            depth += 1
        elif text[i] == "}":
            depth -= 1
            if depth == 0:
                return start, i + 1
        i += 1


def without_methods(text, names):
    for name in names:
        span = method_span(text, name)
        if span:
            text = text[:span[0]] + text[span[1]:]
    return text


def squeeze(text):
    return re.sub(r"\s+", "", text)


def compare(out):
    edits = hand_edits()
    differ, missing, stale = [], [], []
    for plugin in [p for m in MODELS for p in (m, m + ".edit")]:
        generated_root = out / plugin / "src"
        repo_root = PLUGINS / plugin / "src"
        generated = {p.relative_to(generated_root) for p in generated_root.rglob("*.java")}
        for rel in sorted(generated):
            key = "%s/src/%s" % (plugin, rel.as_posix())
            repo_file = repo_root / rel
            if not repo_file.exists():
                missing.append(key)
                continue
            names = edits.get(key, [])
            a = squeeze(without_methods(repo_file.read_text(), names))
            b = squeeze(without_methods((generated_root / rel).read_text(), names))
            if a != b:
                differ.append(key)
        for p in repo_root.rglob("*.java"):
            # Only the packages EMF writes: the plugin also holds hand-written code (de/...).
            if p.relative_to(repo_root).parts[0] in ("de", "META-INF"):
                continue
            if p.relative_to(repo_root) not in generated:
                stale.append("%s/src/%s" % (plugin, p.relative_to(repo_root).as_posix()))
    return differ, missing, sorted(set(stale) - known_stale())


def write(out, differ, missing, stale):
    edits = hand_edits()
    for key in differ + missing:
        plugin, rest = key.split("/src/", 1)
        source = out / plugin / "src" / rest
        target = PLUGINS / plugin / "src" / rest
        text = source.read_text()
        for name in edits.get(key, []):
            old = method_span(target.read_text(), name)
            new = method_span(text, name)
            if old and new:
                text = text[:new[0]] + target.read_text()[old[0]:old[1]] + text[new[1]:]
        target.parent.mkdir(parents=True, exist_ok=True)
        target.write_text(text)


def main():
    parser = argparse.ArgumentParser(description=__doc__, formatter_class=argparse.RawDescriptionHelpFormatter)
    mode = parser.add_mutually_exclusive_group(required=True)
    mode.add_argument("--check", action="store_true")
    mode.add_argument("--write", action="store_true")
    args = parser.parse_args()
    out = Path(tempfile.mkdtemp(prefix="emfout-"))
    try:
        generate(out)
        differ, missing, stale = compare(out)
        for label, items in (("differs from the generator", differ), ("not in the repo", missing),
                             ("a class the generator no longer writes (not in known-stale.txt)", stale)):
            for item in items:
                print("%s: %s" % (item, label))
        if args.write:
            write(out, differ, missing, stale)
            print("wrote %d, added %d; %d new leftover class(es) not removed (add them to known-stale.txt or "
                  "delete them by hand)" % (len(differ), len(missing), len(stale)))
            return 0
        if differ or missing or stale:
            print("\nGenerated EMF code is out of step with the models. Run tools/emf/emf_generated.py --write "
                  "(a hand edit belongs in the model or in tools/emf/hand-edits.txt).")
            return 1
        print("Generated EMF code matches the models.")
        return 0
    finally:
        shutil.rmtree(out, ignore_errors=True)


if __name__ == "__main__":
    sys.exit(main())
