package com.cihub.mono;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BuggyMonoServiceTest {
    @Test void testType_WILL_FAIL() {
        assertEquals("monorepo-java", new BuggyMonoService().getType());
    }
}
