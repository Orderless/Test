package com.nate.automation.listeners;

import com.aventstack.extentreports.Status;
import com.nate.automation.extentReports.ExtentTestManager;
import com.nate.automation.steps.BaseTest;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener extends BaseTest implements ITestListener
{

    private Object testClass;

    private static String getTestMethodName(ITestResult iTestResult)
    {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }


    @Override
    public void onTestStart(ITestResult result)
    {
        System.out.println("Test started: " + getTestMethodName(result));

        Object testClass = result.getInstance();
        testClass = result.getInstance();
        String thisDevice = ((BaseTest) testClass).Devices;

        if(thisDevice != null)
        {
            ExtentTestManager.startTest(result.getMethod().getDescription()+ "on"+ thisDevice,"");
        }else {
            ExtentTestManager.getTest().log(Status.SKIP,"No Device Found" + thisDevice);
        }
    }

    @Override
    public void onTestSuccess(ITestResult result)
    {
        System.out.println("Test passed: " + getTestMethodName(result));
        ExtentTestManager.getTest().log(Status.PASS, "Test passed: " + getTestMethodName(result));
    }

    @Override
    public void onTestFailure(ITestResult result)
    {
        System.out.println("Test failed: " + getTestMethodName(result));
        ExtentTestManager.getTest().log(Status.FAIL, "Test failed: " + getTestMethodName(result));

        Object testClass = result.getInstance();
        WebDriver driver = ((BaseTest) testClass).getDriver();

        String base64Screenshot = "data:image/png;base64," + ((TakesScreenshot)driver) .getScreenshotAs(OutputType.BASE64);
        ExtentTestManager.getTest().log(Status.FAIL,"Test failed");
    }

    @Override
    public void onTestSkipped(ITestResult result)
    {
        System.out.println("Test skipped: " + getTestMethodName(result));
        ExtentTestManager.getTest().log(Status.SKIP, "Test skipped: " + getTestMethodName(result));
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result)
    {
        System.out.println("Test failed but within success percentage: " + getTestMethodName(result));
        ExtentTestManager.getTest().log(Status.WARNING, "Test failed but within success percentage: " + getTestMethodName(result));
    }



}
