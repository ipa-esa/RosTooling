package de.fraunhofer.ipa.rossystem.generator

import com.google.inject.Inject
import java.util.List
import system.System

class SetupPyCompiler {

    @Inject extension GeneratorHelpers

    def compile_setup_py(System system, boolean gen_yaml) {
        return compile_setup_py(system, gen_yaml, List.of())
    }

    def compile_setup_py(System system, boolean gen_yaml, List<String> pluginInstallDirs) '''«init_pkg()»
import os
from glob import glob
from setuptools import setup

PACKAGE_NAME = '«system.name.toLowerCase»'
«IF !pluginInstallDirs.empty»

def _recursive_data_files(base_dir):
    entries = []
    for root, _, files in os.walk(base_dir):
        if files:
            entries.append((os.path.join('share', PACKAGE_NAME, root), [os.path.join(root, f) for f in sorted(files)]))
    return entries
«ENDIF»

setup(
    name=PACKAGE_NAME,
    version='0.0.1',
    packages=[PACKAGE_NAME],
    data_files=[
        # Install marker file in the package index
        ('share/ament_index/resource_index/packages',
            ['resource/' + PACKAGE_NAME]),
        # Include our package.xml file
        (os.path.join('share', PACKAGE_NAME), ['package.xml']),
        # Include all launch files.
        (os.path.join('share', PACKAGE_NAME, 'launch'), glob(os.path.join('launch', '*.[pxy][yma]*'))),
        (os.path.join('share', PACKAGE_NAME, 'config'), glob(os.path.join('config', '*.*'))),
    ]«FOR dir : pluginInstallDirs» + _recursive_data_files('«dir»')«ENDFOR»,
    install_requires=['setuptools'],
    zip_safe=True
)'''
}
