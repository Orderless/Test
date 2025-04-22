package com.nate.automation.steps;

import com.nate.automation.deviceConfig.BrowserNode;
import com.nate.automation.deviceConfig.Node;
import com.nate.automation.deviceConfig.SetUpHash;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

import java.util.HashMap;
import java.util.Map;

public class BaseTest {

    public String url;
    public WebDriver wait;
    public  String Devices;
    public WebDriver testB;
    public HashMap<String, Node> SeleniumNodes;
    public SetUpHash setUpHash;

    public WebDriver getDriver() {

        WebDriver web = null;

        for (Map.Entry<String, Node>currentNode: SeleniumNodes.entrySet())
        {
            if(currentNode.getKey().equals(Devices))
            {
                if(currentNode.getValue() instanceof BrowserNode)
                {
                    web = returnWebDriver();
                }
            }
        }

        return web;
    }

    public WebDriver returnWebDriver()
    {
        return testB;
    }

    @BeforeClass(description = "Initializing Nodes")
    public void setUp()
    {
        SeleniumNodes = new HashMap<>();
        setUpHash = new SetUpHash(SeleniumNodes);

        try
        {
            setUpHash.SetUpBrowser();
        }
        catch (Exception e)
        {
            Assert.fail();
            e.printStackTrace();
        }

    }

}
