package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class DashboardPage extends Utility {

    private static final Logger log = LogManager.getLogger(HomePage.class.getName());

    @CacheLookup
    @FindBy(xpath = "//div[@class='oxd-topbar-header-title']//h6")
    WebElement dashboardTitle;

    @CacheLookup
    @FindBy(xpath = "//div[@class='oxd-brand-banner']//img")
    WebElement logo;

    @CacheLookup
    @FindBy(xpath = "//img[@class='oxd-userdropdown-img']")
    WebElement userProfile;

    @CacheLookup
    @FindBy(linkText = "Logout")
    WebElement logOut;

    public String getDashboardTitle() {
        Reporter.log("get the Dashboard page title " + dashboardTitle.toString());
        log.info("Getting dashboard page heading. ");
        return getTextFromElement(dashboardTitle);
    }

    public boolean verifyLogoDisplayed() {
        Reporter.log("Verify the logo is displayed " + logo.toString());
        log.info("Logo is displayed on home page.");
        return logo.isDisplayed();
    }

    public void clickOnUserProfileImage() {
        clickOnElement(userProfile);
        Reporter.log("Click on user profile image " + userProfile.toString());
        log.info("Click on user profile image");
    }

    public void mouseHoverOnLogOutLinkAndClick() {
        mouseHoverToElementAndClick(logOut);
        Reporter.log("Click on logout link " + logOut.toString());
        log.info("Click on log out link");
    }
}
