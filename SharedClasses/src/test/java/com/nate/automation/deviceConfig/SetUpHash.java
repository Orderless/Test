package com.nate.automation.deviceConfig;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;

public class SetUpHash {

    private HashMap<String, Node> SeleniumNodes;
    private NodeCapability nodeCapability = new NodeCapability();

    private WebDriver chromeDriver,
            firefoxDriver,
            edgeDriver,
            ieDriver,
            operaDriver,
            safariDriver;

    public HashMap<String,Node> getSeleniumNodes() {
        return SeleniumNodes;
    }

    public void setSeleniumNodes(HashMap<String, Node> seleniumNodes) {
        SeleniumNodes = seleniumNodes;
    }
    public SetUpHash(HashMap<String,Node> seleniumNodes)
    {
        setSeleniumNodes(seleniumNodes);
    }

    public void SetUpBrowser()
    {
        DesiredCapabilities Chrome = nodeCapability.BrowserNodeCapabilities("chrome");
        DesiredCapabilities Firefox = nodeCapability.BrowserNodeCapabilities("firefox");
        DesiredCapabilities Edge = nodeCapability.BrowserNodeCapabilities("edge");
        DesiredCapabilities IE = nodeCapability.BrowserNodeCapabilities("ie");
        DesiredCapabilities Opera = nodeCapability.BrowserNodeCapabilities("opera");
        DesiredCapabilities Safari = nodeCapability.BrowserNodeCapabilities("safari");

        BrowserNode chrome = new BrowserNode(chromeDriver,"http://localhost:4444/wd/hub", Chrome);
        BrowserNode firefox = new BrowserNode(firefoxDriver,"http://localhost:4444/wd/hub", Firefox);
        BrowserNode edge = new BrowserNode(edgeDriver,"http://localhost:4444/wd/hub", Edge);
        BrowserNode ie = new BrowserNode(ieDriver,"http://localhost:4444/wd/hub", IE);
        BrowserNode opera = new BrowserNode(operaDriver,"http://localhost:4444/wd/hub", Opera);
        BrowserNode safari = new BrowserNode(safariDriver,"http://localhost:4444/wd/hub", Safari);

        SeleniumNodes.put("chrome", chrome);
        SeleniumNodes.put("firefox", firefox);
        SeleniumNodes.put("edge", edge);
        SeleniumNodes.put("ie", ie);
        SeleniumNodes.put("opera", opera);
        SeleniumNodes.put("safari", safari);

    }

}
