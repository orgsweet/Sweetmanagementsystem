Feature: Role Management

Scenario: Select Admin Role
Given the user is on the Role Selection page
When the user clicks the "Admin" button
Then the user should be redirected to the Admin Dashboard

Scenario: Select Store Owner Role
Given the user is on the Role Selection page
When the user clicks the "Store Owner" button
Then the user should be redirected to the Store Owner Dashboard

Scenario: Select Supplier Role
Given the user is on the Role Selection page
When the user clicks the "Supplier" button
Then the user should be redirected to the Supplier Dashboard

Scenario: Select Beneficiary User Role
Given the user is on the Role Selection page
When the user clicks the "Beneficiary User" button
Then the user should be redirected to the Beneficiary User Dashboard