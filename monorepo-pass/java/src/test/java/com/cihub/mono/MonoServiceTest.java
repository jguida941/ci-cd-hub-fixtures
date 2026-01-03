package com.cihub.mono;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MonoServiceTest {
    @Test void testType() {
        assertEquals("monorepo-java", new MonoService().getType());
    }
}
