"""Library with intentional bugs."""

def divide(a: int, b: int) -> float:
    # BUG: No zero check
    return a / b

def greet(name):  # Missing type hints (for mypy)
    return f"Hi {name}"  # Inconsistent with passing version
