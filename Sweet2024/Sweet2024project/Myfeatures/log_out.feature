Feature: Log Out (All Users)
  As any user,
  I want to log out of the system
  So that I can securely end my session

  Scenario: Log out of the system
    Given I am logged in
    When I click the "Log Out" button
    Then I should be logged out of the system
    And I should be redirected to the login page
