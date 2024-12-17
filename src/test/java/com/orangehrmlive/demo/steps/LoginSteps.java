package com.orangehrmlive.demo.steps;

import com.orangehrmlive.demo.pages.HomePage;
import com.orangehrmlive.demo.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class LoginSteps {

    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();

    @Given("I enter username {string}")
    public void iEnterUsername(String username) {
        loginPage.enterUsername(username);
    }

    @Given("I enter password {string}")
    public void iEnterPassword(String password) {
        loginPage.enterPassword(password);
    }

    @When("I click on the login {string} button")
    public void iClickOnTheButton(String button) {
        if (button.equalsIgnoreCase("Login")) {
            loginPage.clickOnLoginButton();
        }
    }

    @Then("I should see the {string} message")
    public void iShouldSeeTheMessage(String message) {
        String actualMessage = homePage.getWelcomeMessage();
        Assert.assertTrue(actualMessage.contains(message), "Expected message not found!");
    }

    @Given("I log in to the application")
    public void iLogInToTheApplication() {
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickOnLoginButton();
    }

    @Then("I should see the OrangeHRM logo on the home page")
    public void iShouldSeeTheOrangeHRMLogoOnTheHomePage() {
        Assert.assertTrue(homePage.isUserProfileIsDisplayed(), "Logo is not displayed on the home page!");
    }

    @When("I click on the user profile logo")
    public void iClickOnTheUserProfileLogo() {
        homePage.clickOnUserProfileLogo();
    }

    @When("I mouse hover on {string} and click")
    public void iMouseHoverOnAndClick(String option) {
        if (option.equalsIgnoreCase("Logout")) {
            homePage.clickOnLogoutButton();
        }
    }

    @Then("I should see the login text {string}")
    public void iShouldSeeTheText1(String text) {
        String actualText = loginPage.getLoginPanelText();
        Assert.assertEquals(actualText, text, "Text does not match!");
    }

    @Then("I should see the error message {string}")
    public void iShouldSeeTheErrorMessage(String errorMessage) {
        String actualErrorMessage = loginPage.getErrorMessage();
        Assert.assertEquals(actualErrorMessage, errorMessage, "Error message does not match!");
    }
}
