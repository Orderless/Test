package com.nate.automation.steps;

import com.nate.automation.deviceConfig.BrowserNode;
import com.nate.automation.deviceConfig.Node;
import com.nate.automation.pages.OrangeHRM_LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Admin_duties extends BaseTest{
    private OrangeHRM_LoginPage loginPage;

    public void setUp(String URL,String device) {
        try
        {
            setUpHash.SetUpBrowser();

            System.out.println("Initializing Nodes");
            url =URL;
            Devices = device;

            for (Map.Entry<String, Node> currentNode : SeleniumNodes.entrySet()) {
                if (currentNode.getKey().equals(Devices))
                {
                    if(currentNode.getValue() instanceof BrowserNode)
                    {
                         try
                        {
                          WebDriverManager.edgedriver().setup();
                          testB = new EdgeDriver();
                          testB.get(URL);
                          testB.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                          testB.manage().window().maximize();

                        }catch (Exception e)
                      {
                          Assert.fail();
                          e.printStackTrace();
                      }

                    }
                }
            }


        }catch (Exception e){
            Assert.fail();
            e.printStackTrace();
        }
    }

    @Test(description = "Admin Duties")
    public void AdminDuties() throws Exception
    {
        loginPage = new OrangeHRM_LoginPage(testB, Devices);

        try
        {
            for(Map.Entry<String, Node> currentNode : SeleniumNodes.entrySet())
            {
                if(currentNode.getKey().equals(Devices))
                {
                    if(currentNode.getValue() instanceof BrowserNode)
                    {

                        try
                        {
                            loginPage.enterUsername("Admin");
                            loginPage.enterPassword("admin123");
                            loginPage.clickLoginButton();

                        }catch (Exception e)
                        {
                            Assert.fail();
                            e.printStackTrace();
                        }
                    }
                }
            }

        }catch (Exception e)
        {
            Assert.fail();
            e.printStackTrace();
        }

    }


    @AfterTest(description = "Closing Browser")
    public void closeBrowser()
    {
        try
        {
            for(Map.Entry<String, Node> currentNode : SeleniumNodes.entrySet())
            {
                if(currentNode.getKey().equals(Devices))
                {
                    if(currentNode.getValue() instanceof BrowserNode)
                    {
                        try
                        {
                            testB.quit();

                        }catch (Exception e)
                        {
                            Assert.fail();
                            e.printStackTrace();
                        }
                    }
                }
            }

        }catch (Exception e)
        {
            Assert.fail();
            e.printStackTrace();
        }
    }

}
