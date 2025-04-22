package com.nate.automation.deviceConfig;

import org.openqa.selenium.remote.DesiredCapabilities;

public class NodeCapability {
    private DesiredCapabilities desiredCapabilities;

    public NodeCapability()
    {
        desiredCapabilities = new DesiredCapabilities();
    }

    public DesiredCapabilities BrowserNodeCapabilities(String Browser)
    {
        switch (Browser)
        {
            case "chrome":
            {
                desiredCapabilities.setCapability("browserName", "chrome");
                desiredCapabilities.setCapability("platformName", "Windows 10");
                desiredCapabilities.setCapability("browserVersion", "latest");
                break;
            }
            case "firefox":
            {
                desiredCapabilities.setCapability("browserName", "firefox");
                desiredCapabilities.setCapability("platformName", "Windows 10");
                desiredCapabilities.setCapability("browserVersion", "latest");
                break;
            }
            case "edge":
            {
                desiredCapabilities.setCapability("browserName", "MicrosoftEdge");
                desiredCapabilities.setCapability("platformName", "Windows 10");
                desiredCapabilities.setCapability("browserVersion", "latest");
                break;
            }
            case "ie":
            {
                desiredCapabilities.setCapability("browserName", "internet explorer");
                desiredCapabilities.setCapability("platformName", "Windows 10");
                desiredCapabilities.setCapability("browserVersion", "latest");
                break;
            }
            case "opera":
            {
                desiredCapabilities.setCapability("browserName", "opera");
                desiredCapabilities.setCapability("platformName", "Windows 10");
                desiredCapabilities.setCapability("browserVersion", "latest");
                break;
            }
            case "safari":
            {
                desiredCapabilities.setCapability("browserName", "safari");
                desiredCapabilities.setCapability("platformName", "macOS 10.15");
                desiredCapabilities.setCapability("browserVersion", "latest");
                break;
            }

        }

        return null;
    }
}
