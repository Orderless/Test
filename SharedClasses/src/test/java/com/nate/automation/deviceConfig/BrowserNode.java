package com.nate.automation.deviceConfig;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserNode extends Node{

    private WebDriver browserDriver;

    public WebDriver getBrowserDriver() {
        return browserDriver;
    }
    public void setBrowserDriver(WebDriver browserDriver) {
        this.browserDriver = browserDriver;
    }

    public BrowserNode(WebDriver browserDriver, String hostURL, DesiredCapabilities desiredCapabilities) {
        super(hostURL, desiredCapabilities);
        this.browserDriver = browserDriver;
    }

}
