Feature: Account Management (Store Owners & Suppliers)
As a store owner or supplier,
I want to manage my account details and update business information
So that I can keep my information current and accurate

Scenario: Update account details
Given I am logged in as a store owner or supplier
When I navigate to the account management section
And I update my business information
Then my account details should be updated successfully