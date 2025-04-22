package com.nate.automation.deviceConfig;

import org.openqa.selenium.remote.DesiredCapabilities;
public class Node {

    private DesiredCapabilities desiredCapabilities;
    private String hostURL;

    public DesiredCapabilities getDesiredCapabilities() {
        return desiredCapabilities;
    }
    public void setDesiredCapabilities(DesiredCapabilities desiredCapabilities) {
        this.desiredCapabilities = desiredCapabilities;
    }
    public String getHostURL() {
        return hostURL;
    }
    public void setHostURL(String hostURL) {
        this.hostURL = hostURL;
    }

    public Node(String hostURL, DesiredCapabilities desiredCapabilities) {

        this.hostURL = hostURL;
        this.desiredCapabilities = desiredCapabilities;
    }
}
