Feature: User Management
  As an admin,
  I want to manage user accounts
  So that I can handle user registrations and updates effectively

  Scenario: Admin views all user accounts
    Given I am logged in as an admin
    When I navigate to the user management section
    Then I should see a list of all user accounts including store owners and raw material suppliers

  Scenario: Admin adds a new user account
    Given I am logged in as an admin
    When I choose to add a new user account
    And provide the required details for the new user
    Then the new user account should be created
    And the user should receive a notification with account details

 Scenario: Admin updates an existing user account
  Given I am logged in as an admin
  When I select a user account to update
  And modify the user's details
  Then the changes should be saved
  And the user should be notified of the updates

  Scenario: Admin deactivates a user account
    Given I am logged in as an admin
    When I choose to deactivate a user account
    Then the user account should be deactivated
    And the user should be notified of the deactivation