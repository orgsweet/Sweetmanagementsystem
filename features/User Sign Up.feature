Feature: User Sign Up

  Scenario: Successful sign-up
    Given I am on the sign-up page
    When I enter a valid username "Lama"
    And I enter a valid email "Lama@gmail.com"
    And I enter a valid role "Admin"
    And I enter a valid password "lama21"
    And I confirm the password "lama21"
    And I click the sign-up button
    Then I should see Account created successfully



  Scenario: Sign-up with invalid Email
    Given I am on the sign-up page
    When I enter a valid username "Lama"
    # entered invalid email
    And I enter a valid email "Lama@gmail.com"
    And I enter a valid role "Admin"
    And I enter a valid password "lama21"
    And I confirm the password "lama21"
    And I click the sign-up button
    Then I should see Account created successfully




  Scenario: Sign-up with invalid password

    Given I am on the sign-up page
    When I enter a valid username "Lama"
    And I enter a valid email "Lama@gmail.com"
    And I enter a valid role "Admin"
    #user enter invalid password
    And I enter a valid password "lama11"
    And I confirm the password "lama11"
    And I click the sign-up button
    Then I should see Account created successfully


 Scenario: Passwords do not match
    Given I am on the sign-up page
    When I enter a valid username "Fatima"
    And I enter a valid email "Fatima@gmail.com"
    And I enter a valid role "raw material provider"
    And I enter a valid password "Fatima21"
    And I confirm the password "Fatima2"
    And I click the sign-up button
    Then I should see "Passwords do not match"


  Scenario: Sign-up with already used email
    Given I am on the sign-up page
    When I enter a valid username "Fatima"
    #I enter an email that is already used but i make the same script to reduce function
    And I enter a valid email "Fatima1.com"
    And I enter a valid role "user"
    And I enter a valid password "Fatima21"
    And I confirm the password "Fatima"
    And I click the sign-up button
    Then I should see Email address is already in use "the Email already used please change it "



  Scenario: Sign-up with already used pass
    Given I am on the sign-up page
    When I enter a valid username "Fatima"
    #I enter an email that is already used but i make the same script to reduce function
    And I enter a valid email "Fatima1.com"
    And I enter a valid role "user"
    And I enter a repated pass password "123F"
    And I confirm the password "123F"
    And I click the sign-up button
    Then I should see invalid pass address is already in use

  Scenario: Passwords do not match
    Given I am on the sign-up page
    When I enter a valid username "Fatima"
    And I enter a valid email "Fatima@gmail.com"
    And I enter a valid role "raw material provider"
    And I enter a valid password "Fatima21"
    #confirmation worng but i name it like this to reduce  functions
    And I confirm the password "Fatima211"
    And I click the sign-up button
    Then I should see Passwords do not match "passworde do not match please make sure to confirm corectly"



  Scenario: Sign-up with invalid role
    Given I am on the sign-up page
    When I enter a valid username "Fatima"
    And I enter a valid email "Fatimaa@gmail.com"
    # when user enter wrong role  but i name it like this to reduce  functions
    And I enter a valid role "chif"
    And I enter a valid password "Fatima21"
    And I confirm the password "Fatima"
    And I click the sign-up button
    Then I should see Invalid role "Please only these roles are avilable  Admin/user/raw material provider/store owner dashboard"

