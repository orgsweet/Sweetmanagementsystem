Feature: Role Selection
  As a user
  I want to select my role
  So that I can navigate to my appropriate dashboard

  Scenario: User selects Admin role
    Given the user is on the Role Selection page
    When the user clicks the "Admin" button
    Then the user should be redirected to the Admin Dashboard

  Scenario: User selects Store Owner role
    Given the user is on the Role Selection page
    When the user clicks the "Store Owner" button
    Then the user should be redirected to the Store Owner Dashboard

  Scenario: User selects Supplier role
    Given the user is on the Role Selection page
    When the user clicks the "Supplier" button
    Then the user should be redirected to the Supplier Dashboard

  Scenario: User selects Beneficiary User role
    Given the user is on the Role Selection page
    When the user clicks the "Beneficiary User" button
    Then the user should be redirected to the Beneficiary User Dashboard
