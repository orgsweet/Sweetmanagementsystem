Feature: Store Owner and Supplier Management

Scenario: Add New Products
  Given I am logged in as a store owner or supplier
  When I add a new product with the following details:
    | name           | description    | price | quantity |
    | Chocolate Cake | Delicious cake | 10.00 | 50       |
  Then the new product should be added successfully


Scenario: Update Product Details
    Given I am logged in as a store owner or supplier
    And the following product exists:
      | name           | description    | price | quantity |
      | Chocolate Cake | Delicious cake | 10.00 | 50       |
    When I update the product "Chocolate Cake" with the new details:
      | description         | price | quantity |
      | Rich chocolate flavor | 12.00 | 60       |
    Then the product details should be updated successfully


Scenario: Remove Products
Given I am logged in as a store owner or supplier
And the following product exists:
| name | description | price | quantity |
| Chocolate Cake | Delicious cake | 10.00 | 50 |
When I remove the product "Chocolate Cake"
Then the product should be removed successfully

Scenario: Monitor Sales and Profits
Given I am logged in as a store owner or supplier
When I request to view my sales and profits
Then I should see the detailed sales and profit report

Scenario: Identify Best-Selling Products
Given I am logged in as a store owner or supplier
When I request to view my best-selling products
Then I should see the top-selling products report

Scenario: Apply Discount to a Product
Given the following product exists:
| name | description | price | quantity |
| Chocolate Cake | Delicious cake | 20.00 | 10 |
When I set a discount of 10% on the product "Chocolate Cake"
Then the product price should be updated to reflect the discount

Scenario: Process Orders
Given I am logged in as a store owner or supplier
When I receive a new order for "Chocolate Cake"
Then I should be able to process the order and update the status to "Processed"

Scenario: Track Order Status
Given I am logged in as a store owner or supplier
When I view the orders page
Then I should see the status of all orders

Scenario: Update Account Details
Given I am logged in as a store owner or supplier
When I navigate to the account management section
And I update my business information
Then my account details should be updated successfully