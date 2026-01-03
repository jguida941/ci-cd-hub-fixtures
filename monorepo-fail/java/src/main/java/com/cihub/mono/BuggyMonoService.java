package com.cihub.mono;

public class BuggyMonoService {
    // BUG: returns wrong value
    public String getType() { return "wrong-type"; }
}
