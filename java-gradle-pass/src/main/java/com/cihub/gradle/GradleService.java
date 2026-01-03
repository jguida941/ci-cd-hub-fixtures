package com.cihub.gradle;

/** Service to test Gradle build detection. */
public class GradleService {
    public String getBuildTool() {
        return "gradle";
    }
    
    public int compute(int x) {
        return x * 2;
    }
}
