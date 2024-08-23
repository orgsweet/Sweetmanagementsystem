Feature: Admin Management

Scenario: Manage User Feedback
    Given the admin is successfully logged in
    When I navigate to the user feedback section
    Then I should be able to view, review, and respond to user feedback

Scenario: Monitor Profits and Generate Financial Reports
    Given the admin is successfully logged in
    When I navigate to the financial reports section
    Then I should see reports on profits and financial performance

Scenario: View best-selling products across all stores
    Given the admin is successfully logged in
    When I navigate to the content management
    Then I should be able to edit, view, or delete recipes and posts
    When I request to view the best-selling products
    Then I should see a report of the best-selling products across all stores

Scenario: View user statistics by city
    Given the admin is successfully logged in
    When I navigate to the user statistics area
    Then I should see statistics on registered users by city
