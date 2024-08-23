Feature: Communication and Notification


Scenario: Send Messages Within the System
Given I am logged in as a store owner or supplier
When I send a message to "supplier@example.com" with the subject "Inquiry" and the body "Need more details"
Then the message should be sent successfully

Scenario: Receive Messages Within the System
Given I am logged in as a store owner or supplier
When I receive a message from "user@example.com" with the subject "Order Status"
Then the message should be displayed in my inbox

Scenario: Receive Email Notifications for Special Requests
Given I am logged in as a store owner or supplier
When I receive a special request
Then I should receive an email notification with the details of the request