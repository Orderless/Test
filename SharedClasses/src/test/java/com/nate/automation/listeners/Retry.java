package com.nate.automation.listeners;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.nate.automation.extentReports.ExtentTestManager;
import com.nate.automation.steps.BaseTest;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer
{
    private int count = 0;
    private static int maxTry = 0;

    @Override
    public boolean retry(ITestResult result)
    {
        if(result.isSuccess())
        {
            if (count < maxTry)
            {
                count++;
                result.setStatus(result.FAILURE);
                return true;
            }
            return false;
        }else {
            result.setStatus(ITestResult.FAILURE);
        }
        return false;
    }

    public void extentReportFailOperations(ITestResult result)
    {
        Object testClass = result.getInstance();
        WebDriver driver = ((BaseTest) testClass).getDriver();
        String base64 = "data:image/png;base64," + ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);

        ExtentTestManager.getTest().fail("Test failed",
                MediaEntityBuilder.createScreenCaptureFromBase64String(base64).build());


    }
}
