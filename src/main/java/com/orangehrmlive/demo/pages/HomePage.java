package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;


public class HomePage extends Utility {

    private static final Logger log = LogManager.getLogger(HomePage.class.getName());

    @CacheLookup
    @FindBy(xpath = "//span[@class='oxd-userdropdown-tab']")
    WebElement userProfileImage;

    @CacheLookup
    @FindBy(id = "welcome")
    WebElement welcomeMessage;


    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Logout']")
    WebElement logoutButton;

    public boolean isUserProfileIsDisplayed() {
        Reporter.log("verify user profile image is displayed  " + userProfileImage);
        log.info("verify user profile image is displayed " + userProfileImage);
        return userProfileImage.isDisplayed();
    }

    public void clickOnUserProfileLogo() {
        clickOnElement(userProfileImage);
    }

    public String getWelcomeMessage() {
        Reporter.log("Getting welcome message");
        log.info("Getting welcome message");
        return getTextFromElement(welcomeMessage);
    }

    public void clickOnLogoutButton() {
        clickOnElement(logoutButton);
        Reporter.log("click on " + logoutButton);
        log.info("click on " + logoutButton);
    }
}
