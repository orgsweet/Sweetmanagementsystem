Feature: Beneficiary User Management


Scenario: Update Personal Account Details
    Given the beneficiary user is successfully logged in
When I update my email to "newemail@example.com"
And I click the "Save" button
Then my account details should be updated successfully

Scenario: Post and Share Personal Dessert Creations
    Given the beneficiary user is successfully logged in
When I post a new dessert creation with the title "Delicious Cake" and description "This is my favorite cake"
And I upload an image of the cake
And I click the "Post" button
Then my dessert creation should be shared successfully