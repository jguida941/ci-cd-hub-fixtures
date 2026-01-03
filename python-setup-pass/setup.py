from setuptools import setup, find_packages

setup(
    name="mysetuplib",
    version="1.0.0",
    packages=find_packages(),
    python_requires=">=3.10",
    install_requires=[],
    extras_require={
        "test": ["pytest>=7.0", "pytest-cov"],
    },
)
