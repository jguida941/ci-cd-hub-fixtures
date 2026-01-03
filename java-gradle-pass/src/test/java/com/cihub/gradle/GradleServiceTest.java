package com.cihub.gradle;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GradleServiceTest {
    @Test
    void testBuildTool() {
        GradleService svc = new GradleService();
        assertEquals("gradle", svc.getBuildTool());
    }
    
    @Test
    void testCompute() {
        GradleService svc = new GradleService();
        assertEquals(10, svc.compute(5));
    }
}
