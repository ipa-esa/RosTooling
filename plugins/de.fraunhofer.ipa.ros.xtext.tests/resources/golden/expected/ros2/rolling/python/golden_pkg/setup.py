import os
from glob import glob
from setuptools import find_packages, setup

package_name = 'golden_pkg'

setup(
    name=package_name,
    version='0.0.1',
    packages=find_packages(exclude=['test']),
    data_files=[
        ('share/ament_index/resource_index/packages', ['resource/' + package_name]),
        ('share/' + package_name, ['package.xml']),
        (os.path.join('share', package_name, 'launch'), glob(os.path.join('launch', '*.[pxy][yma]*'))),
        (os.path.join('share', package_name, 'config'), glob(os.path.join('config', '*.*'))),
    ],
    install_requires=['setuptools'],
    zip_safe=True,
    maintainer='ROS Developer',
    maintainer_email='user@todo.todo',
    description='ROS 2 package golden_pkg with generated Python node wrappers',
    license='Apache-2.0',
    extras_require={
        'test': ['pytest'],
    },
    entry_points={
        'console_scripts': [
            'io_node = golden_pkg.io_node_runner:main',
            'service_node = golden_pkg.service_node_runner:main',
            'action_node = golden_pkg.action_node_runner:main',
        ],
    },
)
