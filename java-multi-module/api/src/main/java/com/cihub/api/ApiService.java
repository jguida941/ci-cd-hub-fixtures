package com.cihub.api;

import com.cihub.core.CoreService;

public class ApiService {
    private final CoreService core = new CoreService();
    
    public String getFullName() {
        return "api-" + core.getName();
    }
}
