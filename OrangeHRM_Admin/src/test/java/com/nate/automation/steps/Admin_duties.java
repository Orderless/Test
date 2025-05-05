package com.nate.automation.steps;

import com.nate.automation.deviceConfig.BrowserNode;
import com.nate.automation.deviceConfig.Node;
import com.nate.automation.pages.OrangeHRM_LoginPage;
import com.nate.automation.utilities.ElementFunctionality;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Admin_duties extends BaseTest{
    private OrangeHRM_LoginPage loginPage;
    private ElementFunctionality elementFunctionality;

    @Parameters({"URL","Device"})
    @BeforeClass(description = "Initializing Nodes")
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
                            loginPage = new OrangeHRM_LoginPage(testB, Devices);
                            elementFunctionality = new ElementFunctionality(testB, Devices);

                                try
                                {
                                    loginPage.enterUsername("Admin");
                                    loginPage.enterPassword("admin123");
                                    loginPage.clickLoginButton();
                                    Thread.sleep(5000);

                                    //elementFunctionality.captureScreenshot("Login");
                                    System.err.println("Login Successful");

                                    //Now loggin out
                                    loginPage.clickLogOut_dd();
                                    Thread.sleep(1000);
                                    loginPage.clickLogOut_btn();
                                    System.err.println("Logout Successful");

                                }catch (Exception e)
                                {
                                    Assert.fail();
                                    e.printStackTrace();
                                }
                        }
                        catch (Exception e)
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
                           // testB.quit();
                            //System.out.println("Browser Closed");

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
