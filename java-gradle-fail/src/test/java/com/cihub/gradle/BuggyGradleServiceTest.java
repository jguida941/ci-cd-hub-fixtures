package com.cihub.gradle;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BuggyGradleServiceTest {
    @Test
    void testCompute_WILL_FAIL() {
        BuggyGradleService svc = new BuggyGradleService();
        // This WILL fail because of the bug
        assertEquals(10, svc.compute(5));
    }
}
