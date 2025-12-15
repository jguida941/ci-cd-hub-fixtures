package com.cihub.fixtures;

import java.io.*;  // PMD: Avoid star imports
import java.util.List;
import java.util.ArrayList;  // Checkstyle: Import order issue
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Greeter class with intentional bugs and code quality issues.
 * Designed to trigger failures in various static analysis tools.
 */
public class Greeter {

    // SpotBugs: Hardcoded password
    private static final String DB_PASSWORD = "admin123";
    private static final String API_KEY = "sk-secret-key-12345";

    // PMD: Unused field
    private String unusedField = "never used";

    public String greet(String name) {
        return "Hello, " + name;
    }

    // BUG: subtract is implemented as add
    public int subtract(int a, int b) {
        return a + b;  // BUG: should be a - b
    }

    // BUG: isPositive returns true for zero
    public boolean isPositive(int n) {
        return n >= 0;  // BUG: 0 is not positive
    }

    // SpotBugs: Null pointer dereference possible
    public int getLength(String str) {
        return str.length();  // No null check
    }

    // SpotBugs: Resource leak - stream not closed
    public String readFile(String filename) throws IOException {
        FileInputStream fis = new FileInputStream(filename);  // Resource leak
        BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
        return reader.readLine();  // Reader never closed
    }

    // SpotBugs: SQL Injection vulnerability
    public void unsafeQuery(Connection conn, String userInput) throws SQLException {
        String query = "SELECT * FROM users WHERE name = '" + userInput + "'";  // SQL Injection!
        conn.createStatement().execute(query);
    }

    // PMD: Method too long, too many statements
    public int complexMethod(int input) {
        int result = 0;
        result = result + 1;
        result = result + 2;
        result = result + 3;
        result = result + 4;
        result = result + 5;
        result = result + 6;
        result = result + 7;
        result = result + 8;
        result = result + 9;
        result = result + 10;
        result = result + input;
        result = result * 2;
        result = result - 5;
        result = result / 2;
        return result;
    }

    // BUG: sum doesn't accumulate, just assigns
    public int sum(List<Integer> numbers) {
        int total = 0;
        for (int num : numbers) {
            total = num;  // BUG: should be total += num
        }
        return total;
    }

    // BUG: factorial doesn't multiply all numbers
    public long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Negative");
        }
        if (n == 0) {
            return 1;
        }
        long result = 1;
        for (int i = 1; i < n; i++) {  // BUG: should be i <= n
            result *= i;
        }
        return result;
    }

    // BUG: isPrime doesn't check even numbers correctly
    public boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2) return true;
        // BUG: Missing check for n % 2 == 0
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) return false;
        }
        return true;  // BUG: Returns true for 4, 6, 8, etc.
    }

    // SpotBugs: Empty catch block
    public void silentException() {
        try {
            int x = 1 / 0;
        } catch (Exception e) {
            // SpotBugs: Empty catch block - bad practice
        }
    }

    // PMD: Avoid using + in loops for strings
    public String concatenateInLoop(String[] items) {
        String result = "";
        for (String item : items) {
            result = result + item;  // PMD: Use StringBuilder instead
        }
        return result;
    }

    // SpotBugs: Comparison of String objects using == or !=
    public boolean unsafeStringCompare(String a, String b) {
        return a == b;  // SpotBugs: Should use .equals()
    }

    // PMD: Avoid instantiating Boolean objects
    public Boolean getBooleanObject(boolean value) {
        return new Boolean(value);  // PMD: Use Boolean.valueOf()
    }

    // Checkstyle: Line too long, magic numbers
    public int calculateSomething(int x) { int result = x * 42 + 17 * 3 - 99 / 3 + 123456789; return result * 2 + 55 - 33 + x * x * x; }

    // SpotBugs: Synchronization on boxed primitive
    private Integer counter = 0;
    public void incrementCounter() {
        synchronized(counter) {  // SpotBugs: Bad synchronization
            counter++;
        }
    }

    // PMD: Unnecessary local before return
    public int unnecessaryLocal(int a, int b) {
        int sum = a + b;
        return sum;
    }

    // SpotBugs: Exposed internal representation
    private String[] internalArray = {"a", "b", "c"};
    public String[] getInternalArray() {
        return internalArray;  // SpotBugs: Exposes internal representation
    }

    // Checkstyle: Missing braces
    public int missingBraces(int x) {
        if (x > 0)
            return 1;
        else
            return -1;
    }

    // PMD: Avoid reassigning parameters
    public int reassignParameter(int value) {
        value = value * 2;  // PMD: Don't reassign parameters
        return value;
    }

    // SpotBugs: Inefficient use of keySet iterator
    public void inefficientMapIteration(java.util.Map<String, Integer> map) {
        for (String key : map.keySet()) {
            Integer value = map.get(key);  // SpotBugs: Use entrySet() instead
            System.out.println(key + "=" + value);
        }
    }

    // Database connection with hardcoded credentials
    public Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/db";
        String user = "root";
        String password = "password123";  // SpotBugs: Hardcoded password
        return DriverManager.getConnection(url, user, password);
    }
}
