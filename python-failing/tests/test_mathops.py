"""Tests for mathops module - some will FAIL due to bugs in the code."""

import pytest
from hypothesis import HealthCheck, given, settings, strategies as st

from python_failing import mathops


class TestBasicArithmetic:
    """Tests for basic arithmetic operations."""

    def test_add(self):
        assert mathops.add(2, 3) == 5

    def test_subtract(self):
        # This test WILL FAIL because subtract has a bug
        assert mathops.subtract(5, 2) == 3  # FAILS: returns 7

    def test_subtract_negative(self):
        # This test WILL FAIL
        assert mathops.subtract(2, 5) == -3  # FAILS: returns 7

    def test_multiply(self):
        assert mathops.multiply(3, 4) == 12

    def test_divide(self):
        assert mathops.divide(10, 2) == 5.0

    def test_divide_by_zero(self):
        assert mathops.divide(10, 0) is None


class TestPredicates:
    """Tests for predicate functions."""

    def test_is_positive_true(self):
        assert mathops.is_positive(5) is True

    def test_is_positive_zero(self):
        # This test WILL FAIL because is_positive has a bug
        assert mathops.is_positive(0) is False  # FAILS: returns True

    def test_is_positive_negative(self):
        assert mathops.is_positive(-5) is False

    def test_is_even(self):
        assert mathops.is_even(4) is True
        assert mathops.is_even(3) is False


class TestListOperations:
    """Tests for list operations."""

    def test_sum_list(self):
        # This test WILL FAIL because sum_list has a bug
        assert mathops.sum_list([1, 2, 3, 4, 5]) == 15  # FAILS: returns 5

    def test_sum_list_single(self):
        assert mathops.sum_list([5]) == 5  # This passes by accident


class TestMinMax:
    """Tests for min/max functions."""

    def test_max_first_larger(self):
        assert mathops.max_of_two(5, 3) == 5

    def test_max_second_larger(self):
        assert mathops.max_of_two(3, 5) == 5


class TestFactorial:
    """Tests for factorial function."""

    def test_factorial_zero(self):
        assert mathops.factorial(0) == 1

    def test_factorial_five(self):
        # This test WILL FAIL because factorial has a bug
        assert mathops.factorial(5) == 120  # FAILS: returns 24


class TestIsPrime:
    """Tests for prime checking."""

    def test_is_prime_2(self):
        assert mathops.is_prime(2) is True

    def test_is_prime_4(self):
        # This test WILL FAIL because is_prime has a bug
        assert mathops.is_prime(4) is False  # FAILS: returns True

    def test_is_prime_6(self):
        # This test WILL FAIL
        assert mathops.is_prime(6) is False  # FAILS: returns True


class TestCalculator:
    """Tests for Calculator class."""

    def test_calculator_add(self):
        calc = mathops.Calculator()
        assert calc.add(5) == 5
        assert calc.add(3) == 8

    def test_calculator_history(self):
        calc = mathops.Calculator()
        calc.add(5)
        calc.add(3)
        assert calc.get_history() == [5, 3]


# Property-based tests using Hypothesis
# Note: Using settings to suppress health check for mutation testing compatibility
class TestPropertyBased:
    """Property-based tests."""

    @settings(suppress_health_check=[HealthCheck.differing_executors])
    @given(st.integers(), st.integers())
    def test_add_commutative(self, a, b):
        assert mathops.add(a, b) == mathops.add(b, a)

    @settings(suppress_health_check=[HealthCheck.differing_executors])
    @given(st.integers(), st.integers())
    def test_subtract_anticommutative(self, a, b):
        # This property test WILL FAIL due to the bug
        # For correct subtract: a - b = -(b - a)
        # But buggy subtract returns a + b, so this fails
        if a != b:  # Skip when equal to avoid 0 = -0
            assert mathops.subtract(a, b) == -mathops.subtract(b, a)
