package com.nate.automation.utilities;

import com.nate.automation.listeners.TestListener;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class ElementFunctionality extends TestListener {

    private WebDriverWait wait;
    public String Device;
    private WebDriver BrowserDriver;
    public ElementFunctionality(WebDriver BrowserDriver,String Device)
    {
        this.BrowserDriver = BrowserDriver;
        this.Device = Device;
        wait = new WebDriverWait(BrowserDriver, Duration.ofSeconds(5));
    }

    public void verifyBrowserElement(WebElement element,String Name)
    {
        try {

            wait.until(ExpectedConditions.visibilityOf(element));
            assertTrue(element.getSize().getWidth()>0);

        }catch (TimeoutException t)
        {
            System.out.println("Element not found: " + Devices);
        }
    }
    public int verifyElementValue(WebElement element,String Name)
    {
        int result = 0;
        try
        {
            wait.until(ExpectedConditions.visibilityOf(element));
            assertTrue(element.getSize().getWidth()>0);

            result = 1;

        }catch (Exception e)
        {
            result = 0;
        }
        return result;
    }
}
