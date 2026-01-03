package com.cihub.fixtures;

import java.util.ArrayList;
import java.util.List;

/**
 * Calculator class with various mathematical operations.
 * Designed for comprehensive testing including mutation testing.
 */
public class Calculator {

  private int value;
  private final List<Integer> history;

  /** Creates a new Calculator with value initialized to 0. */
  public Calculator() {
    this.value = 0;
    this.history = new ArrayList<>();
  }

  /**
   * Adds two integers.
   *
   * @param a first operand
   * @param b second operand
   * @return sum of a and b
   */
  public int add(int a, int b) {
    return a + b;
  }

  /**
   * Subtracts b from a.
   *
   * @param a first operand
   * @param b second operand
   * @return difference a - b
   */
  public int subtract(int a, int b) {
    return a - b;
  }

  /**
   * Multiplies two integers.
   *
   * @param a first operand
   * @param b second operand
   * @return product of a and b
   */
  public int multiply(int a, int b) {
    return a * b;
  }

  /**
   * Divides a by b.
   *
   * @param a dividend
   * @param b divisor
   * @return quotient or null if b is zero
   */
  public Integer divide(int a, int b) {
    if (b == 0) {
      return null;
    }
    return a / b;
  }

  /**
   * Checks if n is positive.
   *
   * @param n number to check
   * @return true if n greater than 0
   */
  public boolean isPositive(int n) {
    return n > 0;
  }

  /**
   * Checks if n is negative.
   *
   * @param n number to check
   * @return true if n less than 0
   */
  public boolean isNegative(int n) {
    return n < 0;
  }

  /**
   * Checks if n is even.
   *
   * @param n number to check
   * @return true if n is divisible by 2
   */
  public boolean isEven(int n) {
    return n % 2 == 0;
  }

  /**
   * Checks if n is odd.
   *
   * @param n number to check
   * @return true if n is not divisible by 2
   */
  public boolean isOdd(int n) {
    return n % 2 != 0;
  }

  /**
   * Returns absolute value of n.
   *
   * @param n number
   * @return absolute value
   */
  public int absoluteValue(int n) {
    if (n < 0) {
      return -n;
    }
    return n;
  }

  /**
   * Returns maximum of two integers.
   *
   * @param a first number
   * @param b second number
   * @return larger of a and b
   */
  public int max(int a, int b) {
    if (a >= b) {
      return a;
    }
    return b;
  }

  /**
   * Returns minimum of two integers.
   *
   * @param a first number
   * @param b second number
   * @return smaller of a and b
   */
  public int min(int a, int b) {
    if (a <= b) {
      return a;
    }
    return b;
  }

  /**
   * Clamps value to range [min, max].
   *
   * @param value number to clamp
   * @param min minimum bound
   * @param max maximum bound
   * @return clamped value
   */
  public int clamp(int value, int min, int max) {
    if (value < min) {
      return min;
    }
    if (value > max) {
      return max;
    }
    return value;
  }

  /**
   * Sums a list of integers.
   *
   * @param numbers list to sum
   * @return sum of all elements
   */
  public int sum(List<Integer> numbers) {
    int total = 0;
    for (int num : numbers) {
      total += num;
    }
    return total;
  }

  /**
   * Computes average of a list.
   *
   * @param numbers list to average
   * @return average or null if empty/null
   */
  public Double average(List<Integer> numbers) {
    if (numbers == null || numbers.isEmpty()) {
      return null;
    }
    return (double) sum(numbers) / numbers.size();
  }

  /**
   * Computes factorial of n.
   *
   * @param n non-negative integer
   * @return n factorial
   * @throws IllegalArgumentException if n is negative
   */
  public long factorial(int n) {
    if (n < 0) {
      throw new IllegalArgumentException("Factorial not defined for negative numbers");
    }
    if (n <= 1) {
      return 1;
    }
    long result = 1;
    for (int i = 2; i <= n; i++) {
      result *= i;
    }
    return result;
  }

  /**
   * Computes nth Fibonacci number.
   *
   * @param n index (0-based)
   * @return nth Fibonacci number
   * @throws IllegalArgumentException if n is negative
   */
  public int fibonacci(int n) {
    if (n < 0) {
      throw new IllegalArgumentException("Fibonacci not defined for negative indices");
    }
    if (n == 0) {
      return 0;
    }
    if (n == 1) {
      return 1;
    }
    int a = 0;
    int b = 1;
    for (int i = 2; i <= n; i++) {
      int temp = a + b;
      a = b;
      b = temp;
    }
    return b;
  }

  /**
   * Checks if n is prime.
   *
   * @param n number to check
   * @return true if n is prime
   */
  public boolean isPrime(int n) {
    if (n < 2) {
      return false;
    }
    if (n == 2) {
      return true;
    }
    if (n % 2 == 0) {
      return false;
    }
    for (int i = 3; i <= Math.sqrt(n); i += 2) {
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }

  /**
   * Computes greatest common divisor.
   *
   * @param a first number
   * @param b second number
   * @return GCD of a and b
   */
  public int gcd(int a, int b) {
    a = absoluteValue(a);
    b = absoluteValue(b);
    while (b != 0) {
      int temp = b;
      b = a % b;
      a = temp;
    }
    return a;
  }

  /**
   * Computes least common multiple.
   *
   * @param a first number
   * @param b second number
   * @return LCM of a and b
   */
  public int lcm(int a, int b) {
    if (a == 0 || b == 0) {
      return 0;
    }
    return absoluteValue(a * b) / gcd(a, b);
  }

  /**
   * Gets current value.
   *
   * @return current value
   */
  public int getValue() {
    return value;
  }

  /**
   * Sets current value and records in history.
   *
   * @param value new value
   */
  public void setValue(int value) {
    this.value = value;
    this.history.add(value);
  }

  /**
   * Adds n to current value.
   *
   * @param n amount to add
   * @return new value
   */
  public int addToValue(int n) {
    this.value += n;
    this.history.add(this.value);
    return this.value;
  }

  /**
   * Gets history of values.
   *
   * @return copy of history list
   */
  public List<Integer> getHistory() {
    return new ArrayList<>(history);
  }

  /** Resets value to 0 and clears history. */
  public void reset() {
    this.value = 0;
    this.history.clear();
  }
}
