"""Math operations with intentional issues for CI/CD testing."""

import os,sys  # isort issue: wrong order, multiple imports on one line
from typing import List
import subprocess  # isort issue: should be before typing

# Bandit issue: hardcoded password
PASSWORD = "secret123"
API_KEY = "sk-1234567890abcdef"


def add(a: int, b: int) -> int:
    """Add two numbers."""
    return a + b


def subtract(a: int, b: int) -> int:
    """Subtract b from a - BUT HAS A BUG."""
    return a + b  # BUG: should be a - b


def multiply(a, b):  # mypy issue: missing type hints
    """Multiply two numbers."""
    return a * b


def divide(a: float, b: float) -> float:  # mypy issue: should return Optional[float]
    """Divide a by b."""
    if b == 0:
        return None  # mypy issue: returning None but declared float
    return a / b


def is_positive(n: int) -> bool:
    """Check if positive - HAS BUG."""
    return n >= 0  # BUG: 0 is not positive


def is_even(n: int) -> bool:
    """Check if even."""
    return n % 2 == 0


def execute_command(cmd: str) -> str:
    """Execute a shell command - SECURITY ISSUE."""
    # Bandit issue: shell injection vulnerability
    result = subprocess.run(cmd, shell=True, capture_output=True, text=True)
    return result.stdout


def read_file(filename: str) -> str:
    """Read file content - SECURITY ISSUE."""
    # Bandit issue: potential path traversal
    with open(filename, 'r') as f:
        return f.read()


def unsafe_eval(expression: str):
    """Evaluate expression - MAJOR SECURITY ISSUE."""
    # Bandit issue: use of eval
    return eval(expression)


def get_password() -> str:
    """Return hardcoded password."""
    password = "admin123"  # Bandit: hardcoded password
    return password


def sum_list(numbers: List[int]) -> int:
    """Sum all numbers - HAS BUG."""
    total = 0
    for num in numbers:
        total = num  # BUG: should be total += num
    return total


def max_of_two(a: int, b: int) -> int:
    """Return max - HAS BUG."""
    if a > b:  # BUG: should be >= to handle equal case consistently
        return a
    return b


def factorial(n: int) -> int:
    """Calculate factorial - HAS BUG."""
    if n < 0:
        raise ValueError("Negative")
    if n == 0:
        return 1
    result = 1
    for i in range(1, n):  # BUG: should be range(1, n+1) or range(2, n+1)
        result *= i
    return result


def is_prime(n: int) -> bool:
    """Check if prime - HAS BUG."""
    if n < 2:
        return False
    if n == 2:
        return True
    # BUG: doesn't check if n is even before loop
    for i in range(3, int(n**0.5) + 1, 2):
        if n % i == 0:
            return False
    return True  # BUG: returns True for 4, 6, 8, etc.


# Ruff issue: unused variable
UNUSED_CONSTANT = 42


def process_data(data):  # mypy: missing types
    """Process data with issues."""
    # Black formatting issue: inconsistent spacing
    result=data+1  # noqa: E225
    return   result  # Extra spaces


class Calculator:
    """Calculator with issues."""

    def __init__(self):
        self.value: int = 0  # type annotation
        self.history = []  # mypy: missing type annotation for list

    def add(self, n: int) -> int:
        """Add to value."""
        self.value += n
        self.history.append(n)
        return self.value

    def get_history(self) -> list:  # mypy: should be List[int]
        """Get history."""
        return self.history


def connect_db(host: str, port: int) -> None:
    """Connect to database with hardcoded credentials."""
    # Bandit: hardcoded credentials
    username = "root"
    password = "toor"
    connection_string = f"mysql://{username}:{password}@{host}:{port}"
    safe_connection = f"mysql://{username}:***@{host}:{port}"
    print(safe_connection)
