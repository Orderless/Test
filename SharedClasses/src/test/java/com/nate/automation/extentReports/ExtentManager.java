package com.nate.automation.extentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ExtentManager
{
    static Map extentTestMap = new HashMap<>();

    private static ExtentReports extent;

    public synchronized static ExtentReports getReport()
    {
        if (extent == null)
        {
            String workDir = System.getProperty("user.dir");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
            Date date = new Date();
            String fileName = "ExtentReport_" + sdf.format(date) + ".html";
            String filepath;
            String opersys = System.getProperty("os.name").toLowerCase();

            if(opersys.contains("win"))
            {
                extent.attachReporter(new ExtentSparkReporter(workDir + "\\ExtentReport\\" + fileName));
            }
            else if(opersys.contains("mac"))
            {
                extent.attachReporter(new ExtentSparkReporter(workDir + "/ExtentReport/" + fileName));
            }


        }
        return extent;
    }
}
