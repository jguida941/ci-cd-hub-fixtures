package com.cihub.fixtures;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CalculatorTest {

    @Test
    void addsNumbers() {
        Calculator calc = new Calculator();
        assertEquals(5, calc.add(2, 3));
    }

    @Test
    void subtractsNumbers() {
        Calculator calc = new Calculator();
        assertEquals(1, calc.subtract(4, 3));
    }
}
