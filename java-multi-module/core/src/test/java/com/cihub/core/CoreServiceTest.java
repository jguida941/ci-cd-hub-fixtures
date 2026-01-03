package com.cihub.core;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CoreServiceTest {
    @Test void testName() { assertEquals("core", new CoreService().getName()); }
    @Test void testAdd() { assertEquals(5, new CoreService().add(2, 3)); }
}
