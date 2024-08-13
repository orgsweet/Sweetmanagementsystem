Feature: Content Management
As an admin,
I want to manage the content shared on the system and user feedback
So that I can ensure the content is accurate and relevant

Scenario: Manage content shared on the system
Given I am logged in as an admin
When I navigate to the content management section
Then I should be able to view, edit, or delete recipes and posts

Scenario: Manage user feedback
Given I am logged in as an admin
When I navigate to the user feedback section
Then I should be able to view, review, and respond to user feedback