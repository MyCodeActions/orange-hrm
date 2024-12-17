package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class LoginPage extends Utility {

    private static final Logger log = LogManager.getLogger(HomePage.class.getName());

    @CacheLookup
    @FindBy(xpath = "//input[@name='username']")
    WebElement userName;

    @CacheLookup
    @FindBy(xpath = "//input[@name='password']")
    WebElement password;

    @CacheLookup
    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginButton;

    @CacheLookup
    @FindBy(id = "logInPanelHeading")
    WebElement loginPanelText;

    @CacheLookup
    @FindBy(id = "spanMessage")
    WebElement errorMessage;



    public void enterUsername(String uName) {
        sendTextToElement(userName, uName);
        Reporter.log("enter user name :" + uName);
        log.info("enter user name" + uName);
    }

    public void enterPassword(String pass) {
        sendTextToElement(password, pass);
        Reporter.log("enter password" + pass);
        log.info("enter password" + pass);
    }

    public void clickOnLoginButton() {
        clickOnElement(loginButton);
        Reporter.log("click on " + loginButton);
        log.info("click on " + loginButton);
    }

    public String getErrorMessage() {
        return getTextFromElement(errorMessage);
    }

    public String getLoginPanelText() {
        return getTextFromElement(loginPanelText);
    }

    public void enterUserNameAndPasswordForLogin(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickOnLoginButton();
    }
}
