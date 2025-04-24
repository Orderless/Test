package com.nate.automation.deviceConfig;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserNode extends Node{

    private WebDriver BrowserDriver;

    public WebDriver getBrowserDriver() {
        return BrowserDriver;
    }
    public void setBrowserDriver(WebDriver browserDriver) {
        BrowserDriver = browserDriver;
    }

    public BrowserNode(WebDriver browserDriver, String hostURL, DesiredCapabilities desiredCapabilities) {
        super(hostURL, desiredCapabilities);
        setBrowserDriver(browserDriver);
    }

}
