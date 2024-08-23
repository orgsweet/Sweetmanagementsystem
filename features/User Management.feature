Feature: User Management

# Use the existing step for admin login

Scenario: View All User Accounts
    Given the admin is successfully logged in
When I navigate to the user management section
Then I should see a list of all user accounts including store owners and raw material suppliers

Scenario: Add New User Account
    Given the admin is successfully logged in
When I choose to add a new user account
And provide the required details for the new user
Then the new user account should be created
And the user should receive a notification with account details

Scenario: Update Existing User Account
    Given I have a user with username "Fatima"
    When I select a user account to update
    And modify the user's details
    Then the changes should be saved
    And the user should be notified of the updates


Scenario: Deactivate User Account
    Given the admin is successfully logged in
When I choose to deactivate a user account
Then the user account should be deactivated
And the user should be notified of the deactivation