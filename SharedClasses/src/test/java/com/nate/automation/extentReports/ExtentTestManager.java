package com.nate.automation.extentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import java.util.HashMap;
import java.util.Map;

public class ExtentTestManager {

    static Map<String, ExtentTest> extentTestMap = new HashMap<>();

    static ExtentReports extent = new ExtentReports();

    public static synchronized ExtentTest startTest(String testName, String description) {
        // Create a new test instance and add it to the extent report
        ExtentTest test = extent.createTest(testName, description);
        extentTestMap.put(testName, test);
        return test;
    }

    public static synchronized ExtentTest getTest() {
        // Retrieve the test instance from the map
        return extentTestMap.get(Thread.currentThread().getName());
    }

    public static synchronized void endTest() {
        // Flush the extent report to save the results
       // extent.endTest((ExtentTest)extentTestMap.get((int)(long)(Thread.currentThread().getId())));
        extent.flush();

    }
}
