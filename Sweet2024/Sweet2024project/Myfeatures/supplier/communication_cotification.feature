Feature: Communication and Notification
  As a store owner or supplier
  I want to send and receive messages
  So that I can communicate effectively within the system

  Scenario: Send messages within the system
    Given I am logged in as a store owner or supplier
    When I send a message to "supplier@example.com" with the subject "Inquiry" and the body "Need more details"
    Then the message should be sent successfully

  Scenario: Receive messages within the system
    Given I am logged in as a store owner or supplier
    When I receive a message from "user@example.com" with the subject "Order Status"
    Then the message should be displayed in my inbox

  Scenario: Receive notifications via email for special requests
    Given I am logged in as a store owner or supplier
    When I receive a special request
    Then I should receive an email notification with the details of the request