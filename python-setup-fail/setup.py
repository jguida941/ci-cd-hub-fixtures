from setuptools import setup, find_packages

setup(
    name="buggylib",
    version="1.0.0",
    packages=find_packages(),
    python_requires=">=3.10",
    install_requires=[
        # VULNERABLE: old requests version for security testing
        "requests==2.25.0",
    ],
)
