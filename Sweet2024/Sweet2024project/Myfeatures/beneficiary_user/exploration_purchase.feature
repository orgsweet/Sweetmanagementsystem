Feature: Exploration and Purchase
  As a beneficiary user
  I want to browse, search, filter, and purchase desserts
  So that I can find and buy the desserts I like

  Scenario: Browse dessert recipes
    Given I am on the Recipes page
    When I click the "Browse" button
    Then I should see a list of dessert recipes

  Scenario: Search for specific recipes
    Given I am on the Recipes page
    When I enter "Chocolate Cake" in the search bar
    And I click the "Search" button
    Then I should see recipes matching "Chocolate Cake"

  Scenario: Filter recipes based on dietary needs or food allergies
    Given I am on the Recipes page
    When I select "Gluten-Free" from the dietary needs filter
    And I click the "Apply Filters" button
    Then I should see recipes matching the "Gluten-Free" filter

  Scenario: Purchase desserts from store owners
    Given I am on the Store page
    When I select a dessert and click the "Add to Cart" button
    And I click the "Checkout" button and complete the purchase process
    Then I should purchase the dessert successfully