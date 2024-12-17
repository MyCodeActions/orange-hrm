@regression
Feature: User

  @smoke
  Scenario: Admin should add user successfully
    Given I log in to the OrangeHRM application
    When I click on the "Admin" tab
    Then I should see the text "System Users"
    When I click on the "Add" button
    Then I should see the text "Add User"
    When I add a user with details:
      | User Role | Admin       |
      | Employee  | Ananya Dash |
      | Username  | new.user    |
      | Status    | Disable     |
      | Password  | password123 |
      | Confirm   | password123 |
    Then I should see a success message "Successfully Saved"

  @sanity
  Scenario: Search the user created and verify it
    Given I log in to the OrangeHRM application
    When I click on the "Admin" tab
    Then I should see the text "System Users"
    When I search for a user with details:
      | Username  | new.user |
      | User Role | Admin    |
      | Status    | Disable  |
    Then I should see the user in the result list


  Scenario: Verify that admin should delete the user successfully
    Given I log in to the OrangeHRM application
    When I click on the "Admin" tab
    Then I should see the text "System Users"
    When I search for a user with details:
      | Username  | new.user |
      | User Role | Admin    |
      | Status    | Disable  |
    Then I should see the user in the result list
    When I select the user by checking the checkbox
    And I click on the "Delete" button
    Then a confirmation popup should appear
    When I confirm the popup by clicking "Ok"
    Then I should see a success message "Successfully Deleted"


  Scenario Outline: Search the user and verify the message record found
    Given I log in to the OrangeHRM application
    When I click on the "Admin" tab
    Then I should see the text "System Users"
    When I search for a user with details:
      | Username      | <username>     |
      | User Role     | <userRole>     |
      | Employee Name | <employeeName> |
      | Status        | <status>       |
    Then I should see the message "(1) Record Found"
    And the result should display the username "<username>"
    When I click on the "Reset" button
    Examples:
      | username     | userRole | employeeName  | status |
      | Admin        | Admin    | Paul Collings | Enable |
      | Cassidy.Hope | ESS      | Cassidy Hope  | Enable |
      | Nina.Patel   | ESS      | Nina Patel    | Enable |
      | Odis.Adalwin | Admin    | Odis Adalwin  | Enable |
