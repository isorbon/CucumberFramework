Feature: Employee feature

  Scenario: Search employee by ID
    Given user opens browser and navigated to HRMS
    And user is logged in as an admin
    And user is on employee list page
    When user enters valid employee id
    And user clicks on search button
    Then user see employee in the employee table