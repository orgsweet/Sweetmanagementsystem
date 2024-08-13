Feature: Communication and Feedback
  As a beneficiary user
  I want to communicate with store owners and provide feedback
  So that I can share my experiences and ask questions

  Scenario: Communicate directly with store owners and suppliers
    Given I am logged in as a beneficiary user
    When I send a message to "storeowner@example.com" with the subject "Product Inquiry" and the body "Can you provide more details on this product?"
    Then the message should be sent successfully

  Scenario: Provide feedback on purchased products and shared recipes
    Given I am logged in as a beneficiary user
    When I provide feedback on a purchased product with the rating "5 stars" and the comment "Excellent product"
    Then my feedback should be submitted successfully
