Feature: Monitoring and Reporting
  As an admin,
  I want to monitor profits, generate financial reports, identify best-selling products, and display user statistics
  So that I can oversee the system's performance and user activity

  Scenario: Monitor profits and generate financial reports
    Given I am logged in as an admin
    When I navigate to the financial reports section
    Then I should see reports on profits and financial performance

  Scenario: Identify best-selling products
    Given I am logged in as an admin
    When I request to view best-selling products
    Then I should see a report of the best-selling products across all stores

  Scenario: Display statistics on registered users by city
    Given I am logged in as an admin
    When I navigate to the user statistics section
    Then I should see statistics on registered users by city (e.g., Nablus, Jenin)
