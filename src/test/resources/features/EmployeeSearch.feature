Feature: US-12345 Employee search

  Background:
    When user is logged in with valid admin credentials
    #When user enters valid admin username and password
    #And user clicks on login button
    #Then admin user is successfully logged in
    When user navigates to employee list page

  @test @modify
  Scenario: Search employee by id
    When user enters valid employee id
    And user clicks on search button
    Then user see employee information is displayed
   # Then user close the browser

  @test2
  Scenario: Search employee by name
    When user enters valid employee name
    And user clicks on search button
    Then user see employee information is displayed

  @modify
  Scenario: Edit employee profile
    Given user clicks on any found of employee link
    When user clicks on edit button in employee profile
    And user enters details information
    Then user clicks on save button

