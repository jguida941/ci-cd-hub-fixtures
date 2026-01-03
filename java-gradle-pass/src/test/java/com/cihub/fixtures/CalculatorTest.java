package com.cihub.fixtures;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorTest {

  private Calculator calc;

  @BeforeEach
  void setUp() {
    calc = new Calculator();
  }

  // Basic arithmetic tests
  @Test
  void testAddPositive() {
    assertEquals(5, calc.add(2, 3));
  }

  @Test
  void testAddNegative() {
    assertEquals(-5, calc.add(-2, -3));
  }

  @Test
  void testAddMixed() {
    assertEquals(3, calc.add(-2, 5));
  }

  @Test
  void testAddZero() {
    assertEquals(5, calc.add(5, 0));
    assertEquals(5, calc.add(0, 5));
  }

  @Test
  void testSubtractPositive() {
    assertEquals(3, calc.subtract(5, 2));
  }

  @Test
  void testSubtractNegativeResult() {
    assertEquals(-3, calc.subtract(2, 5));
  }

  @Test
  void testSubtractZero() {
    assertEquals(5, calc.subtract(5, 0));
    assertEquals(-5, calc.subtract(0, 5));
  }

  @Test
  void testMultiplyPositive() {
    assertEquals(12, calc.multiply(3, 4));
  }

  @Test
  void testMultiplyNegative() {
    assertEquals(-12, calc.multiply(-3, 4));
    assertEquals(12, calc.multiply(-3, -4));
  }

  @Test
  void testMultiplyZero() {
    assertEquals(0, calc.multiply(5, 0));
    assertEquals(0, calc.multiply(0, 5));
  }

  @Test
  void testDividePositive() {
    assertEquals(5, calc.divide(10, 2));
  }

  @Test
  void testDivideByZero() {
    assertNull(calc.divide(10, 0));
  }

  @Test
  void testDivideNegative() {
    assertEquals(-5, calc.divide(-10, 2));
  }

  // Predicate tests
  @Test
  void testIsPositiveTrue() {
    assertTrue(calc.isPositive(5));
    assertTrue(calc.isPositive(1));
  }

  @Test
  void testIsPositiveFalse() {
    assertFalse(calc.isPositive(0));
    assertFalse(calc.isPositive(-5));
  }

  @Test
  void testIsNegativeTrue() {
    assertTrue(calc.isNegative(-5));
    assertTrue(calc.isNegative(-1));
  }

  @Test
  void testIsNegativeFalse() {
    assertFalse(calc.isNegative(0));
    assertFalse(calc.isNegative(5));
  }

  @Test
  void testIsEvenTrue() {
    assertTrue(calc.isEven(0));
    assertTrue(calc.isEven(2));
    assertTrue(calc.isEven(100));
    assertTrue(calc.isEven(-4));
  }

  @Test
  void testIsEvenFalse() {
    assertFalse(calc.isEven(1));
    assertFalse(calc.isEven(3));
    assertFalse(calc.isEven(-5));
  }

  @Test
  void testIsOddTrue() {
    assertTrue(calc.isOdd(1));
    assertTrue(calc.isOdd(3));
    assertTrue(calc.isOdd(-5));
  }

  @Test
  void testIsOddFalse() {
    assertFalse(calc.isOdd(0));
    assertFalse(calc.isOdd(2));
    assertFalse(calc.isOdd(-4));
  }

  // Absolute value tests
  @Test
  void testAbsoluteValuePositive() {
    assertEquals(5, calc.absoluteValue(5));
  }

  @Test
  void testAbsoluteValueNegative() {
    assertEquals(5, calc.absoluteValue(-5));
  }

  @Test
  void testAbsoluteValueZero() {
    assertEquals(0, calc.absoluteValue(0));
  }

  // Min/Max tests
  @Test
  void testMaxFirstLarger() {
    assertEquals(5, calc.max(5, 3));
  }

  @Test
  void testMaxSecondLarger() {
    assertEquals(5, calc.max(3, 5));
  }

  @Test
  void testMaxEqual() {
    assertEquals(5, calc.max(5, 5));
  }

  @Test
  void testMaxNegative() {
    assertEquals(-3, calc.max(-3, -5));
  }

  @Test
  void testMinFirstSmaller() {
    assertEquals(3, calc.min(3, 5));
  }

  @Test
  void testMinSecondSmaller() {
    assertEquals(3, calc.min(5, 3));
  }

  @Test
  void testMinEqual() {
    assertEquals(5, calc.min(5, 5));
  }

  @Test
  void testMinNegative() {
    assertEquals(-5, calc.min(-3, -5));
  }

  // Clamp tests
  @Test
  void testClampInRange() {
    assertEquals(5, calc.clamp(5, 0, 10));
  }

  @Test
  void testClampBelowMin() {
    assertEquals(0, calc.clamp(-5, 0, 10));
  }

  @Test
  void testClampAboveMax() {
    assertEquals(10, calc.clamp(15, 0, 10));
  }

  @Test
  void testClampAtMin() {
    assertEquals(0, calc.clamp(0, 0, 10));
  }

  @Test
  void testClampAtMax() {
    assertEquals(10, calc.clamp(10, 0, 10));
  }

  // List operations tests
  @Test
  void testSum() {
    assertEquals(15, calc.sum(Arrays.asList(1, 2, 3, 4, 5)));
  }

  @Test
  void testSumEmpty() {
    assertEquals(0, calc.sum(Collections.emptyList()));
  }

  @Test
  void testSumSingle() {
    assertEquals(5, calc.sum(Collections.singletonList(5)));
  }

  @Test
  void testSumNegative() {
    assertEquals(-6, calc.sum(Arrays.asList(-1, -2, -3)));
  }

  @Test
  void testAverage() {
    assertEquals(4.0, calc.average(Arrays.asList(2, 4, 6)));
  }

  @Test
  void testAverageEmpty() {
    assertNull(calc.average(Collections.emptyList()));
  }

  @Test
  void testAverageNull() {
    assertNull(calc.average(null));
  }

  @Test
  void testAverageSingle() {
    assertEquals(5.0, calc.average(Collections.singletonList(5)));
  }

  // Factorial tests
  @Test
  void testFactorialZero() {
    assertEquals(1, calc.factorial(0));
  }

  @Test
  void testFactorialOne() {
    assertEquals(1, calc.factorial(1));
  }

  @Test
  void testFactorialSmall() {
    assertEquals(120, calc.factorial(5));
  }

  @Test
  void testFactorialLarger() {
    assertEquals(3628800, calc.factorial(10));
  }

  @Test
  void testFactorialNegativeThrows() {
    assertThrows(IllegalArgumentException.class, () -> calc.factorial(-1));
  }

  // Fibonacci tests
  @Test
  void testFibonacciZero() {
    assertEquals(0, calc.fibonacci(0));
  }

  @Test
  void testFibonacciOne() {
    assertEquals(1, calc.fibonacci(1));
  }

  @Test
  void testFibonacciSequence() {
    assertEquals(1, calc.fibonacci(2));
    assertEquals(2, calc.fibonacci(3));
    assertEquals(3, calc.fibonacci(4));
    assertEquals(5, calc.fibonacci(5));
    assertEquals(8, calc.fibonacci(6));
    assertEquals(55, calc.fibonacci(10));
  }

  @Test
  void testFibonacciNegativeThrows() {
    assertThrows(IllegalArgumentException.class, () -> calc.fibonacci(-1));
  }

  // Prime tests
  @Test
  void testIsPrimeTrue() {
    assertTrue(calc.isPrime(2));
    assertTrue(calc.isPrime(3));
    assertTrue(calc.isPrime(5));
    assertTrue(calc.isPrime(7));
    assertTrue(calc.isPrime(11));
    assertTrue(calc.isPrime(13));
    assertTrue(calc.isPrime(97));
  }

  @Test
  void testIsPrimeFalse() {
    assertFalse(calc.isPrime(0));
    assertFalse(calc.isPrime(1));
    assertFalse(calc.isPrime(4));
    assertFalse(calc.isPrime(6));
    assertFalse(calc.isPrime(9));
    assertFalse(calc.isPrime(100));
  }

  @Test
  void testIsPrimeNegative() {
    assertFalse(calc.isPrime(-5));
  }

  // GCD/LCM tests
  @Test
  void testGcdBasic() {
    assertEquals(4, calc.gcd(12, 8));
    assertEquals(4, calc.gcd(8, 12));
  }

  @Test
  void testGcdCoprime() {
    assertEquals(1, calc.gcd(7, 11));
  }

  @Test
  void testGcdOneDividesOther() {
    assertEquals(5, calc.gcd(10, 5));
  }

  @Test
  void testGcdNegative() {
    assertEquals(4, calc.gcd(-12, 8));
    assertEquals(4, calc.gcd(12, -8));
  }

  @Test
  void testGcdZero() {
    assertEquals(5, calc.gcd(5, 0));
    assertEquals(5, calc.gcd(0, 5));
  }

  @Test
  void testLcmBasic() {
    assertEquals(12, calc.lcm(4, 6));
  }

  @Test
  void testLcmCoprime() {
    assertEquals(77, calc.lcm(7, 11));
  }

  @Test
  void testLcmOneDividesOther() {
    assertEquals(10, calc.lcm(5, 10));
  }

  @Test
  void testLcmZero() {
    assertEquals(0, calc.lcm(0, 5));
    assertEquals(0, calc.lcm(5, 0));
  }

  // Stateful operations tests
  @Test
  void testGetSetValue() {
    assertEquals(0, calc.getValue());
    calc.setValue(10);
    assertEquals(10, calc.getValue());
  }

  @Test
  void testAddToValue() {
    assertEquals(5, calc.addToValue(5));
    assertEquals(8, calc.addToValue(3));
    assertEquals(8, calc.getValue());
  }

  @Test
  void testGetHistory() {
    calc.setValue(10);
    calc.addToValue(5);
    calc.addToValue(3);
    List<Integer> history = calc.getHistory();
    assertEquals(Arrays.asList(10, 15, 18), history);
  }

  @Test
  void testReset() {
    calc.setValue(10);
    calc.addToValue(5);
    calc.reset();
    assertEquals(0, calc.getValue());
    assertTrue(calc.getHistory().isEmpty());
  }
}
