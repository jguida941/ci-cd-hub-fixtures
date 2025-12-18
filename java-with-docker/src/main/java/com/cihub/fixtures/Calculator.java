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

    public Calculator() {
        this.value = 0;
        this.history = new ArrayList<>();
    }

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public Integer divide(int a, int b) {
        if (b == 0) {
            return null;
        }
        return a / b;
    }

    public boolean isPositive(int n) {
        return n > 0;
    }

    public boolean isNegative(int n) {
        return n < 0;
    }

    public boolean isEven(int n) {
        return n % 2 == 0;
    }

    public boolean isOdd(int n) {
        return n % 2 != 0;
    }

    public int absoluteValue(int n) {
        if (n < 0) {
            return -n;
        }
        return n;
    }

    public int max(int a, int b) {
        if (a >= b) {
            return a;
        }
        return b;
    }

    public int min(int a, int b) {
        if (a <= b) {
            return a;
        }
        return b;
    }

    public int clamp(int value, int min, int max) {
        if (value < min) {
            return min;
        }
        if (value > max) {
            return max;
        }
        return value;
    }

    public int sum(List<Integer> numbers) {
        int total = 0;
        for (int num : numbers) {
            total += num;
        }
        return total;
    }

    public Double average(List<Integer> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return null;
        }
        return (double) sum(numbers) / numbers.size();
    }

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

    public int lcm(int a, int b) {
        if (a == 0 || b == 0) {
            return 0;
        }
        return absoluteValue(a * b) / gcd(a, b);
    }

    // Stateful operations
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
        this.history.add(value);
    }

    public int addToValue(int n) {
        this.value += n;
        this.history.add(this.value);
        return this.value;
    }

    public List<Integer> getHistory() {
        return new ArrayList<>(history);
    }

    public void reset() {
        this.value = 0;
        this.history.clear();
    }
}
