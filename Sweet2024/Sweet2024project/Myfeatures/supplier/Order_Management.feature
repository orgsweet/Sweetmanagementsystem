Feature: Order Management
  As a store owner or supplier
  I want to process and track orders
  So that I can manage my orders efficiently

  Scenario: Process orders
    Given I am logged in as a store owner or supplier
    When I receive a new order for "Chocolate Cake"
    Then I should be able to process the order and update the status to "Processed"

  Scenario: Track order status
    Given I am logged in as a store owner or supplier
    When I view the orders page
    Then I should see the status of all orders
