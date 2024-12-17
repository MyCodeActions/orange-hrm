package com.orangehrmlive.demo.steps;

import com.orangehrmlive.demo.pages.AddUserPage;
import com.orangehrmlive.demo.pages.AdminPage;
import com.orangehrmlive.demo.pages.LoginPage;
import com.orangehrmlive.demo.pages.ViewSystemUserPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.Map;

public class UsersSteps {

    AddUserPage addUserPage = new AddUserPage();
    ViewSystemUserPage viewSystemUsersPage = new ViewSystemUserPage();

    @Given("I log in to the OrangeHRM application")
    public void iLogInToTheOrangeHRMApplication() {
        new LoginPage().enterUserNameAndPasswordForLogin("Admin", "admin123");
        new LoginPage().clickOnLoginButton();
    }

    @When("I click on the {string} tab")
    public void iClickOnTheTab(String admin) {
        new AdminPage().clickOnAdminTab();
    }

    @Then("I should see the text {string}")
    public void iShouldSeeTheText2(String systemUserText) {
        Assert.assertEquals(new AdminPage().getSystemUserText(), systemUserText);
    }

    @When("I click on the {string} button1")
    public void iClickOnTheButton1(String arg0) {
        new AdminPage().clickOnAddButton();
    }

//    @Then("I should see the text {string}")
//    public void iShouldSeeTheAddText(String addUserText) {
//        Assert.assertEquals(new AdminPage().getAddUserText(), addUserText);
//    }


    @When("I add a user with details:")
    public void iAddAUserWithDetails(Map<String, String> userDetails) throws InterruptedException {
        addUserPage.selectUserRoleDropdown(userDetails.get("User Role"));
        addUserPage.enterEmployeeName(userDetails.get("Employee"));
        addUserPage.enterUserName(userDetails.get("Username"));
        addUserPage.selectStatusDropdown(userDetails.get("Status"));
        addUserPage.enterPassword(userDetails.get("Password"));
        addUserPage.enterConfirmPassword(userDetails.get("Confirm"));
        addUserPage.clickOnSaveButton();
    }

    @Then("I should see a success message {string}")
    public void iShouldSeeASuccessMessage(String successMessage) {
        Assert.assertEquals(addUserPage.getSuccessMessage(), successMessage);
    }

    @When("I search for a user with details:")
    public void iSearchForAUserWithDetails(Map<String, String> searchDetails) {
        viewSystemUsersPage.enterUsername(searchDetails.get("Username"));
        viewSystemUsersPage.selectUserRole(searchDetails.get("User Role"));
        viewSystemUsersPage.selectStatus(searchDetails.get("Status"));
        viewSystemUsersPage.clickSearchButton();
    }

    @Then("I should see the user in the result list")
    public void iShouldSeeTheUserInTheResultList() {
        Assert.assertTrue(viewSystemUsersPage.isUserInResultList(), "User is not found in the result list!");

    }

    @When("I select the user by checking the checkbox")
    public void iSelectTheUserByCheckingTheCheckbox() {
        viewSystemUsersPage.selectUserCheckbox();
    }

    @Then("a confirmation popup should appear")
    public void aConfirmationPopupShouldAppear() {
        Assert.assertTrue(viewSystemUsersPage.isDeletePopupDisplayed(), "Confirmation popup is not displayed!");
    }


    @Then("I should see the message {string}")
    public void iShouldSeeTheMessage(String button) {
      
    }


    @When("I confirm the popup by clicking {string}")
    public void iConfirmThePopupByClicking(String arg0) {
        
    }

    @And("the result should display the username {string}")
    public void theResultShouldDisplayTheUsername(String arg0) {
    }

    @When("I click on the {string} button")
    public void iClickOnTheButton(String btn) {
    }
}

