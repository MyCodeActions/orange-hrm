package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class ViewSystemUserPage extends Utility {

    private static final Logger log = LogManager.getLogger(HomePage.class.getName());

    @CacheLookup
    @FindBy(id = "searchSystemUser_userName")
    WebElement usernameField;

    @CacheLookup
    @FindBy(id = "searchSystemUser_userType")
    WebElement userRoleDropdown;

    @CacheLookup
    @FindBy(id = "searchSystemUser_status")
    WebElement statusDropdown;

    @CacheLookup
    @FindBy(id = "searchBtn")
    WebElement searchButton;

    @FindBy(xpath = "//input[@name='chkSelectRow[]']")
    WebElement userCheckbox;

    @FindBy(id = "dialogDeleteBtn")
    WebElement confirmDeleteButton;

    @CacheLookup
    @FindBy(xpath = "//p[@class='oxd-text oxd-text--p oxd-text--toast-message oxd-toast-content-text']")
    WebElement successfullyDeletedMessage;

    public void enterUsername(String username) {
        sendTextToElement(usernameField, username);
        Reporter.log("enter user name");
        log.info("enter user name");
    }

    public void selectUserRole(String role) {
        selectByVisibleTextFromDropDown(userRoleDropdown, role);
        Reporter.log("Selecting role from dropdown");
        log.info("Selecting role from dropdown");
    }

    public void selectStatus(String status) {
        selectByVisibleTextFromDropDown(statusDropdown, status);
        Reporter.log("Selecting status from dropdown");
        log.info("Selecting status from dropdown");
    }

    public void clickSearchButton() {
        clickOnElement(searchButton);
        Reporter.log("Clicking on search button");
        log.info("Clicking on search button");
    }

    public boolean isUserInResultList() {
        return userCheckbox.isDisplayed();
    }

    public void selectUserCheckbox() {
        clickOnElement(userCheckbox);
        Reporter.log("Clicking on check box");
        log.info("Clicking on check box");
    }

    public boolean isDeletePopupDisplayed() {
        return confirmDeleteButton.isDisplayed();
    }

    public void confirmPopup() {
        clickOnElement(confirmDeleteButton);
    }


    public String getSuccessDeleteMessage() {
        Reporter.log("get success message : " + successfullyDeletedMessage);
        log.info("get success message :" + successfullyDeletedMessage);
        return getTextFromElement(successfullyDeletedMessage);
    }
}
