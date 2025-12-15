package com.cihub.fixtures;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests for Greeter class - some will FAIL due to bugs in the code.
 */
class GreeterTest {

    private Greeter greeter;

    @BeforeEach
    void setUp() {
        greeter = new Greeter();
    }

    @Test
    void testGreet() {
        assertEquals("Hello, World", greeter.greet("World"));
    }

    @Test
    void testGreetWithName() {
        assertEquals("Hello, Alice", greeter.greet("Alice"));
    }

    // This test WILL FAIL - subtract is buggy
    @Test
    void testSubtract() {
        assertEquals(3, greeter.subtract(5, 2));  // FAILS: returns 7
    }

    // This test WILL FAIL - subtract is buggy
    @Test
    void testSubtractNegativeResult() {
        assertEquals(-3, greeter.subtract(2, 5));  // FAILS: returns 7
    }

    // This test WILL FAIL - isPositive is buggy
    @Test
    void testIsPositiveZero() {
        assertFalse(greeter.isPositive(0));  // FAILS: returns true
    }

    @Test
    void testIsPositiveTrue() {
        assertTrue(greeter.isPositive(5));  // Passes by accident
    }

    @Test
    void testIsPositiveNegative() {
        assertFalse(greeter.isPositive(-5));  // This passes
    }

    // This test WILL FAIL - sum is buggy
    @Test
    void testSum() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        assertEquals(15, greeter.sum(numbers));  // FAILS: returns 5
    }

    @Test
    void testSumSingle() {
        List<Integer> numbers = Arrays.asList(5);
        assertEquals(5, greeter.sum(numbers));  // Passes by accident
    }

    // This test WILL FAIL - factorial is buggy
    @Test
    void testFactorialFive() {
        assertEquals(120, greeter.factorial(5));  // FAILS: returns 24
    }

    @Test
    void testFactorialZero() {
        assertEquals(1, greeter.factorial(0));  // This passes
    }

    @Test
    void testFactorialOne() {
        assertEquals(1, greeter.factorial(1));  // This passes
    }

    // This test WILL FAIL - isPrime is buggy for even numbers
    @Test
    void testIsPrimeFour() {
        assertFalse(greeter.isPrime(4));  // FAILS: returns true
    }

    // This test WILL FAIL
    @Test
    void testIsPrimeSix() {
        assertFalse(greeter.isPrime(6));  // FAILS: returns true
    }

    @Test
    void testIsPrimeTwo() {
        assertTrue(greeter.isPrime(2));  // This passes
    }

    @Test
    void testIsPrimeThree() {
        assertTrue(greeter.isPrime(3));  // This passes
    }

    @Test
    void testIsPrimeNine() {
        assertFalse(greeter.isPrime(9));  // This passes (9 = 3*3)
    }

    @Test
    void testComplexMethod() {
        // Just testing it runs
        int result = greeter.complexMethod(10);
        assertNotNull(result);
    }

    @Test
    void testUnsafeStringCompare() {
        // This demonstrates the bug - using == instead of .equals()
        String a = "hello";
        String b = "hello";
        // These might be the same object due to string interning
        assertTrue(greeter.unsafeStringCompare(a, b));
    }

    @Test
    void testUnsafeStringCompareDifferentObjects() {
        // This will likely fail because == compares references
        String a = new String("hello");
        String b = new String("hello");
        // This SHOULD be true (content is same) but returns false due to ==
        // We're testing that the bug exists:
        assertFalse(greeter.unsafeStringCompare(a, b));
    }

    @Test
    void testGetInternalArray() {
        String[] array = greeter.getInternalArray();
        assertNotNull(array);
        assertEquals(3, array.length);
    }

    @Test
    void testMissingBraces() {
        assertEquals(1, greeter.missingBraces(5));
        assertEquals(-1, greeter.missingBraces(-5));
    }

    @Test
    void testReassignParameter() {
        assertEquals(10, greeter.reassignParameter(5));
    }

    @Test
    void testUnnecessaryLocal() {
        assertEquals(8, greeter.unnecessaryLocal(3, 5));
    }
}
