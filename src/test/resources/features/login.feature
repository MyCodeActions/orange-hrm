@regression
Feature: Login Functionality

  @smoke
  Scenario: Verify user should login successfully
    Given I enter username "Admin"
    And I enter password "admin123"
    When I click on the "Login" button
    Then I should see the "Welcome" message

  @sanity
  Scenario: Verify that the logo displays on the home page
    Given I log in to the application
    Then I should see the OrangeHRM logo on the home page


  Scenario: Verify user should log out successfully
    Given I log in to the application
    When I click on the user profile logo
    And I mouse hover on "Logout" and click
    Then I should see the text "LOGIN Panel"


  Scenario Outline: Verify error message with invalid credentials
    Given I enter username "<username>"
    And I enter password "<password>"
    When I click on the "Login" button
    Then I should see the error message "<errorMessage>"
    Examples:
      | username          | password | errorMessage        |
      |                   |          | Required            |
      | test123@gmail.com |          | Required            |
      |                   | test123  | Required            |
      | test123@gmail.com | test123  | Invalid credentials |
