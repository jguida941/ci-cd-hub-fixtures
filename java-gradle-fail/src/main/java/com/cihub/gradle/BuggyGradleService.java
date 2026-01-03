package com.cihub.gradle;

/** Service with intentional bugs for testing failure detection. */
public class BuggyGradleService {
    public String getBuildTool() {
        return "gradle";
    }
    
    // INTENTIONAL BUG: off-by-one
    public int compute(int x) {
        return x * 2 + 1;
    }
    
    // INTENTIONAL: No null check (for static analysis)
    public int length(String s) {
        return s.length();
    }
}
