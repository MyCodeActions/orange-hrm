package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class AdminPage extends Utility {

    private static final Logger log = LogManager.getLogger(HomePage.class.getName());

    @CacheLookup
    @FindBy(xpath = "//h5")
    WebElement title;

    @CacheLookup
    @FindBy(xpath = "oxd-main-menu-item active")
    WebElement adminTab;

    @CacheLookup
    @FindBy(className = "oxd-text oxd-text--h6 orangehrm-main-title")
    WebElement addUserText;

    @CacheLookup
    @FindBy(tagName = "h5")
    WebElement systemUsersText;

    @CacheLookup
    @FindBy(xpath = "//li[@class='oxd-topbar-body-nav-tab --parent --visited']")
    WebElement userManagement;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Add']")
    WebElement btnAdd;

    @CacheLookup
    @FindBy(xpath = "//label[normalize-space()='Username']/parent::div/following-sibling::div//input")
    WebElement userName;

    @CacheLookup
    @FindBy(xpath = "//label[normalize-space()='User Role']/parent::div/following-sibling::div//div[@class='oxd-select-wrapper']")
    WebElement userRollDropDown;

    @CacheLookup
    @FindBy(xpath = "//label[normalize-space()='Status']/parent::div/following-sibling::div//div[@class='oxd-select-wrapper']")
    WebElement statusDropDown;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Search']")
    WebElement btnSearch;

    @CacheLookup
    @FindBy(xpath = "//div[@role='columnheader'or normalize-space()='Username'][2]/ancestor::div[@role='rowgroup']/following-sibling::div[@class='oxd-table-body']//div[@class='oxd-table-cell oxd-padding-cell'][2]")
    WebElement searchedUserInList;

    @CacheLookup
    @FindBy(xpath = "//div[@class='oxd-table-card-cell-checkbox']//i[@class='oxd-icon bi-check oxd-checkbox-input-icon']")
    WebElement cbForSearchResultItem;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Delete Selected']")
    WebElement btnDeleteInResultList;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Yes, Delete']")
    WebElement deletePopUpButtonYes;

    @CacheLookup
    @FindBy(xpath = "//label[normalize-space()='Employee Name']/parent::div/following-sibling::div//input")
    WebElement enterEmployeeName;


    public String getPageTitle() {
        Reporter.log("Get page title of : " + title.toString());
        log.info("Get page title of : " + title.toString());
        return getTextFromElement(title);
    }

    public void clickOnAdminTab() {
        clickOnElement(adminTab);
        Reporter.log("Clicking on admin tab");
        log.info("Clicking on admin tab");
    }

    public String getSystemUserText() {
        return getTextFromElement(systemUsersText);
    }

    public void clickOnAddButton() {
        clickOnElement(btnAdd);
        Reporter.log("click on add button" + btnAdd.toString());
        log.info("Click on add button");
    }

    public String getAddUserText() {
        return getTextFromElement(addUserText);
    }


    public void enterUserName(String uName) {
        sendTextToElement(userName, uName);
        Reporter.log("Enter user name : " + uName);
        log.info("Enter user name : " + uName);
    }

    public void selectUserRoleFromDropdown(String role) {
        mouseHoverToElementAndClick(userRollDropDown);
        typeKeysAndEnter(role.split("")[0]);
        Reporter.log("select user roll from drop down as " + role);
        log.info("select user roll from drop down as " + role);
    }

    public void selectStatusFromDropdown(String status) {
        mouseHoverToElementAndClick(statusDropDown);
        typeKeysAndEnter(status.split("")[0]);
        Reporter.log("select user status from drop down as " + status);
        log.info("select user status from drop down as " + status);
    }

    public void clickOnSearchButton() {
        clickOnElement(btnSearch);
        Reporter.log("Click on search button " + btnSearch.toString());
        log.info("Click on search button ");
    }

    public String getUsernameFromSearchResult() {
        Reporter.log("get user name from search result " + searchedUserInList.toString());
        log.info("get user name from search result");
        return getTextFromElement(searchedUserInList);
    }

    public void selectTheCheckboxOfUserNameResult() {
        clickOnElement(cbForSearchResultItem);
        Reporter.log("Click on search result item check box " + cbForSearchResultItem.toString());
        log.info("Click on search result item check box");
    }

    public void clickOnDeleteButtonInList() {
        clickOnElement(btnDeleteInResultList);
        Reporter.log("Click on search result item delete button " + btnDeleteInResultList.toString());
        log.info("Click on search result item delete button");
    }

    public void clickOnYesDeleteButtonOnPopUp() {
        clickOnElement(deletePopUpButtonYes);
        Reporter.log("Click on delete popup yes button " + deletePopUpButtonYes.toString());
        log.info("Click on delete popup yes button");
    }

    public void enterEmployeeName(String empName) throws InterruptedException {
        sendTextToElement(enterEmployeeName, empName);
        Thread.sleep(5000);
        selectAutoPopulateFirstEntryByArrowKeysAndEnter(enterEmployeeName);
        Reporter.log("Enter the Employee Name " + empName);
        log.info("Enter the employee Name  " + empName);
    }
}
