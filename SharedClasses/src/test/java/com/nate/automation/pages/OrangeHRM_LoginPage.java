package com.nate.automation.pages;

import com.nate.automation.steps.BaseTest;
import com.nate.automation.utilities.ElementFunctionality;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHRM_LoginPage extends BaseTest {

    public WebDriver BrowserDriver;
    public ElementFunctionality verifyElement;
    public String Device;

    public OrangeHRM_LoginPage(WebDriver browserDriver, String device) {
        BrowserDriver = browserDriver;
        Device = device;
        verifyElement = new ElementFunctionality(browserDriver,device);
        PageFactory.initElements(browserDriver, this);
    }

    @FindBy(xpath = "//input[@placeholder='Username']")
    private WebElement usernameField;

    @FindBy(xpath = "//input[@placeholder='Password']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[normalize-space()='Login']")
    private WebElement loginButton;



    public void enterUsername(String username)
    {
        if (verifyElement.verifyElementValue(usernameField, "Username Field") == 1)
        {
            usernameField.sendKeys(username);
        }
        else
        {
            System.out.println("Username field not found");
        }
    }

    public void enterPassword(String password)
    {
        if (verifyElement.verifyElementValue(passwordField, "Password Field") == 1)
        {
            passwordField.sendKeys(password);
        }
        else
        {
            System.out.println("Password field not found");
        }
    }

    public void clickLoginButton()
    {
        if (verifyElement.verifyElementValue(loginButton, "Login Button") == 1)
        {
            loginButton.click();
        }
        else
        {
            System.out.println("Login button not found");
        }
    }

    public void loginToOrangeHRM(String username, String password)
    {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }
}
