Feature: Product Management
  As a store owner or supplier
  I want to manage my products
  So that I can efficiently handle my inventory and sales
Scenario: Add new products
  Given I am logged in as a store owner or supplier
  When I add a new product with the following details:
    | name           | description    | price | quantity |
    | Chocolate Cake | Delicious cake | 10.00 | 50       |
  Then the new product should be added successfully


  Scenario: Update product details
    Given I am logged in as a store owner or supplier
    And the following product exists:
      | name           | description      | price | quantity |
      | Chocolate Cake | Delicious cake   | 10.00 | 50       |
    When I update the product "Chocolate Cake" with the new details:
      | description         | price | quantity |
      | Rich chocolate flavor | 12.00 | 60       |
    Then the product details should be updated successfully

  Scenario: Remove products
    Given I am logged in as a store owner or supplier
    And the following product exists:
      | name           | description      | price | quantity |
      | Chocolate Cake | Delicious cake   | 10.00 | 50       |
    When I remove the product "Chocolate Cake"
    Then the product should be removed successfully

  Scenario: Monitor sales and profits
    Given I am logged in as a store owner or supplier
    When I request to view my sales and profits
    Then I should see the detailed sales and profit report

  Scenario: Identify best-selling products
    Given I am logged in as a store owner or supplier
    When I request to view my best-selling products
    Then I should see the top-selling products report

  Scenario: Apply discount to a product
    Given the following product exists:
      | name           | description      | price | quantity |
      | Chocolate Cake | Delicious cake   | 20.00 | 10       |
    When I set a discount of 10% on the product "Chocolate Cake"
    Then the product price should be updated to reflect the discount
