package com.cihub.fixtures;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class GreeterTest {

    @Test
    void greets() {
        Greeter greeter = new Greeter();
        assertEquals("Hello, World", greeter.greet("World"));
    }

    @Test
    void failingTest() {
        Greeter greeter = new Greeter();
        // Intentional failure
        assertEquals("Hi, World", greeter.greet("World"));
    }
}
