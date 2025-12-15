"""Comprehensive tests for mathops module."""

import pytest
from hypothesis import given, strategies as st

from python_passing import mathops


class TestBasicArithmetic:
    """Tests for basic arithmetic operations."""

    def test_add_positive_numbers(self):
        assert mathops.add(2, 3) == 5

    def test_add_negative_numbers(self):
        assert mathops.add(-2, -3) == -5

    def test_add_mixed_numbers(self):
        assert mathops.add(-2, 5) == 3

    def test_add_zero(self):
        assert mathops.add(0, 5) == 5
        assert mathops.add(5, 0) == 5

    def test_subtract_positive(self):
        assert mathops.subtract(5, 2) == 3

    def test_subtract_negative_result(self):
        assert mathops.subtract(2, 5) == -3

    def test_subtract_zero(self):
        assert mathops.subtract(5, 0) == 5
        assert mathops.subtract(0, 5) == -5

    def test_multiply_positive(self):
        assert mathops.multiply(3, 4) == 12

    def test_multiply_negative(self):
        assert mathops.multiply(-3, 4) == -12
        assert mathops.multiply(-3, -4) == 12

    def test_multiply_zero(self):
        assert mathops.multiply(5, 0) == 0
        assert mathops.multiply(0, 5) == 0

    def test_divide_positive(self):
        assert mathops.divide(10, 2) == 5.0

    def test_divide_by_zero(self):
        assert mathops.divide(10, 0) is None

    def test_divide_negative(self):
        assert mathops.divide(-10, 2) == -5.0


class TestPredicates:
    """Tests for predicate functions."""

    def test_is_positive(self):
        assert mathops.is_positive(5) is True
        assert mathops.is_positive(1) is True

    def test_is_positive_false(self):
        assert mathops.is_positive(0) is False
        assert mathops.is_positive(-5) is False

    def test_is_negative(self):
        assert mathops.is_negative(-5) is True
        assert mathops.is_negative(-1) is True

    def test_is_negative_false(self):
        assert mathops.is_negative(0) is False
        assert mathops.is_negative(5) is False

    def test_is_even(self):
        assert mathops.is_even(0) is True
        assert mathops.is_even(2) is True
        assert mathops.is_even(100) is True
        assert mathops.is_even(-4) is True

    def test_is_even_false(self):
        assert mathops.is_even(1) is False
        assert mathops.is_even(3) is False
        assert mathops.is_even(-5) is False

    def test_is_odd(self):
        assert mathops.is_odd(1) is True
        assert mathops.is_odd(3) is True
        assert mathops.is_odd(-5) is True

    def test_is_odd_false(self):
        assert mathops.is_odd(0) is False
        assert mathops.is_odd(2) is False
        assert mathops.is_odd(-4) is False


class TestAbsoluteValue:
    """Tests for absolute value function."""

    def test_positive_unchanged(self):
        assert mathops.absolute_value(5) == 5

    def test_negative_becomes_positive(self):
        assert mathops.absolute_value(-5) == 5

    def test_zero(self):
        assert mathops.absolute_value(0) == 0


class TestMinMax:
    """Tests for min/max functions."""

    def test_max_first_larger(self):
        assert mathops.max_of_two(5, 3) == 5

    def test_max_second_larger(self):
        assert mathops.max_of_two(3, 5) == 5

    def test_max_equal(self):
        assert mathops.max_of_two(5, 5) == 5

    def test_max_negative(self):
        assert mathops.max_of_two(-3, -5) == -3

    def test_min_first_smaller(self):
        assert mathops.min_of_two(3, 5) == 3

    def test_min_second_smaller(self):
        assert mathops.min_of_two(5, 3) == 3

    def test_min_equal(self):
        assert mathops.min_of_two(5, 5) == 5

    def test_min_negative(self):
        assert mathops.min_of_two(-3, -5) == -5


class TestClamp:
    """Tests for clamp function."""

    def test_value_in_range(self):
        assert mathops.clamp(5, 0, 10) == 5

    def test_value_below_min(self):
        assert mathops.clamp(-5, 0, 10) == 0

    def test_value_above_max(self):
        assert mathops.clamp(15, 0, 10) == 10

    def test_value_at_min(self):
        assert mathops.clamp(0, 0, 10) == 0

    def test_value_at_max(self):
        assert mathops.clamp(10, 0, 10) == 10


class TestListOperations:
    """Tests for list operations."""

    def test_sum_list(self):
        assert mathops.sum_list([1, 2, 3, 4, 5]) == 15

    def test_sum_list_empty(self):
        assert mathops.sum_list([]) == 0

    def test_sum_list_single(self):
        assert mathops.sum_list([5]) == 5

    def test_sum_list_negative(self):
        assert mathops.sum_list([-1, -2, -3]) == -6

    def test_average(self):
        assert mathops.average([2, 4, 6]) == 4.0

    def test_average_empty(self):
        assert mathops.average([]) is None

    def test_average_single(self):
        assert mathops.average([5]) == 5.0


class TestFactorial:
    """Tests for factorial function."""

    def test_factorial_zero(self):
        assert mathops.factorial(0) == 1

    def test_factorial_one(self):
        assert mathops.factorial(1) == 1

    def test_factorial_small(self):
        assert mathops.factorial(5) == 120

    def test_factorial_larger(self):
        assert mathops.factorial(10) == 3628800

    def test_factorial_negative_raises(self):
        with pytest.raises(ValueError):
            mathops.factorial(-1)


class TestFibonacci:
    """Tests for Fibonacci function."""

    def test_fibonacci_zero(self):
        assert mathops.fibonacci(0) == 0

    def test_fibonacci_one(self):
        assert mathops.fibonacci(1) == 1

    def test_fibonacci_sequence(self):
        assert mathops.fibonacci(2) == 1
        assert mathops.fibonacci(3) == 2
        assert mathops.fibonacci(4) == 3
        assert mathops.fibonacci(5) == 5
        assert mathops.fibonacci(6) == 8
        assert mathops.fibonacci(10) == 55

    def test_fibonacci_negative_raises(self):
        with pytest.raises(ValueError):
            mathops.fibonacci(-1)


class TestIsPrime:
    """Tests for prime checking."""

    def test_primes(self):
        assert mathops.is_prime(2) is True
        assert mathops.is_prime(3) is True
        assert mathops.is_prime(5) is True
        assert mathops.is_prime(7) is True
        assert mathops.is_prime(11) is True
        assert mathops.is_prime(13) is True
        assert mathops.is_prime(97) is True

    def test_not_primes(self):
        assert mathops.is_prime(0) is False
        assert mathops.is_prime(1) is False
        assert mathops.is_prime(4) is False
        assert mathops.is_prime(6) is False
        assert mathops.is_prime(9) is False
        assert mathops.is_prime(100) is False

    def test_negative_not_prime(self):
        assert mathops.is_prime(-5) is False


class TestGcdLcm:
    """Tests for GCD and LCM functions."""

    def test_gcd_basic(self):
        assert mathops.gcd(12, 8) == 4
        assert mathops.gcd(8, 12) == 4

    def test_gcd_coprime(self):
        assert mathops.gcd(7, 11) == 1

    def test_gcd_one_divides_other(self):
        assert mathops.gcd(10, 5) == 5

    def test_gcd_negative(self):
        assert mathops.gcd(-12, 8) == 4
        assert mathops.gcd(12, -8) == 4

    def test_gcd_zero(self):
        assert mathops.gcd(5, 0) == 5
        assert mathops.gcd(0, 5) == 5

    def test_lcm_basic(self):
        assert mathops.lcm(4, 6) == 12

    def test_lcm_coprime(self):
        assert mathops.lcm(7, 11) == 77

    def test_lcm_one_divides_other(self):
        assert mathops.lcm(5, 10) == 10

    def test_lcm_zero(self):
        assert mathops.lcm(0, 5) == 0
        assert mathops.lcm(5, 0) == 0


# Hypothesis property-based tests
class TestPropertyBased:
    """Property-based tests using Hypothesis."""

    @given(st.integers(), st.integers())
    def test_add_commutative(self, a, b):
        assert mathops.add(a, b) == mathops.add(b, a)

    @given(st.integers(), st.integers())
    def test_multiply_commutative(self, a, b):
        assert mathops.multiply(a, b) == mathops.multiply(b, a)

    @given(st.integers())
    def test_add_zero_identity(self, a):
        assert mathops.add(a, 0) == a

    @given(st.integers())
    def test_multiply_one_identity(self, a):
        assert mathops.multiply(a, 1) == a

    @given(st.integers())
    def test_absolute_value_non_negative(self, n):
        assert mathops.absolute_value(n) >= 0

    @given(st.integers())
    def test_is_even_or_odd(self, n):
        assert mathops.is_even(n) != mathops.is_odd(n)

    @given(st.integers(min_value=-100, max_value=100))
    def test_max_ge_min(self, a):
        b = a + 1
        assert mathops.max_of_two(a, b) >= mathops.min_of_two(a, b)

    @given(st.integers(min_value=0, max_value=15))
    def test_factorial_non_negative(self, n):
        assert mathops.factorial(n) >= 1

    @given(st.integers(min_value=1, max_value=50), st.integers(min_value=1, max_value=50))
    def test_gcd_divides_both(self, a, b):
        g = mathops.gcd(a, b)
        assert a % g == 0
        assert b % g == 0
