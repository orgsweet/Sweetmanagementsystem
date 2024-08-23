Feature: User Account Management
  As a beneficiary user
  I want to manage my personal account
  So that I can personalize my experience on the platform

  Scenario: Sign up for a new account
    Given I am on the Sign Up page
    When I enter my details:
      | username     | email               | password     |
      | newuser      | newuser@example.com | password123  |
    And I click the "Sign Up" button
    Then my account should be created successfully

  Scenario: Sign in to the platform
    Given I am on the Sign In page
    When I enter my username as "existinguser" and password as "password123"
    And I click the "Sign In" button
    Then I should be signed in successfully

  Scenario: Update personal account details
    Given I am logged in as a beneficiary user
    When I update my email to "newemail@example.com"
    And I click the "Save" button
    Then my account details should be updated successfully

  Scenario: Post and share personal dessert creations
    Given I am logged in as a beneficiary user
    When I post a new dessert creation with the title "Delicious Cake" and description "This is my favorite cake"
    And I upload an image of the cake
    And I click the "Post" button
    Then my dessert creation should be shared successfully