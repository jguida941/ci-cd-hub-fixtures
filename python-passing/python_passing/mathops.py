"""Math operations module with various testable functions."""

from typing import List, Optional


def add(a: int, b: int) -> int:
    """Add two numbers."""
    return a + b


def subtract(a: int, b: int) -> int:
    """Subtract b from a."""
    return a - b


def multiply(a: int, b: int) -> int:
    """Multiply two numbers."""
    return a * b


def divide(a: float, b: float) -> Optional[float]:
    """Divide a by b, returns None if b is zero."""
    if b == 0:
        return None
    return a / b


def is_positive(n: int) -> bool:
    """Check if a number is positive."""
    return n > 0


def is_negative(n: int) -> bool:
    """Check if a number is negative."""
    return n < 0


def is_even(n: int) -> bool:
    """Check if a number is even."""
    return n % 2 == 0


def is_odd(n: int) -> bool:
    """Check if a number is odd."""
    return n % 2 != 0


def absolute_value(n: int) -> int:
    """Return the absolute value of n."""
    if n < 0:
        return -n
    return n


def max_of_two(a: int, b: int) -> int:
    """Return the maximum of two numbers."""
    if a >= b:
        return a
    return b


def min_of_two(a: int, b: int) -> int:
    """Return the minimum of two numbers."""
    if a <= b:
        return a
    return b


def clamp(value: int, min_val: int, max_val: int) -> int:
    """Clamp value between min_val and max_val."""
    if value < min_val:
        return min_val
    if value > max_val:
        return max_val
    return value


def sum_list(numbers: List[int]) -> int:
    """Sum all numbers in a list."""
    total = 0
    for num in numbers:
        total += num
    return total


def average(numbers: List[int]) -> Optional[float]:
    """Calculate average of a list, returns None if empty."""
    if len(numbers) == 0:
        return None
    return sum_list(numbers) / len(numbers)


def factorial(n: int) -> int:
    """Calculate factorial of n (n must be >= 0)."""
    if n < 0:
        raise ValueError("Factorial not defined for negative numbers")
    if n <= 1:
        return 1
    result = 1
    for i in range(2, n + 1):
        result *= i
    return result


def fibonacci(n: int) -> int:
    """Return the nth Fibonacci number (0-indexed)."""
    if n < 0:
        raise ValueError("Fibonacci not defined for negative indices")
    if n == 0:
        return 0
    if n == 1:
        return 1
    a, b = 0, 1
    for _ in range(2, n + 1):
        a, b = b, a + b
    return b


def is_prime(n: int) -> bool:
    """Check if n is a prime number."""
    if n < 2:
        return False
    if n == 2:
        return True
    if n % 2 == 0:
        return False
    for i in range(3, int(n**0.5) + 1, 2):
        if n % i == 0:
            return False
    return True


def gcd(a: int, b: int) -> int:
    """Calculate greatest common divisor using Euclidean algorithm."""
    a = absolute_value(a)
    b = absolute_value(b)
    while b != 0:
        a, b = b, a % b
    return a


def lcm(a: int, b: int) -> int:
    """Calculate least common multiple."""
    if a == 0 or b == 0:
        return 0
    return absolute_value(a * b) // gcd(a, b)
