package com.cihub.api;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ApiServiceTest {
    @Test void testFullName() {
        assertEquals("api-core", new ApiService().getFullName());
    }
}
