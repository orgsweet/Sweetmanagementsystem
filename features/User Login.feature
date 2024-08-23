Feature: User Login

  Scenario: Successful login with valid credentials
    Given the user is on the login page
    When the user enters valid username "rama" and password "rama20"
    And the user clicks the login button
    Then the user should be redirected to the dashboard

  Scenario: Unsuccessful login with invalid credentials
    Given the user is on the login page
    When the user enters an invalid username "lma" or password "lama21"
    And the user clicks the login button
    Then the user should see an error message indicating "invalid username or password"

  Scenario: Unsuccessful login with missing credentials
    Given the user is on the login page
    When the user leaves the username or password field empty
    And the user clicks the login button
    Then the user should see an error message indicating "All fields are required"
