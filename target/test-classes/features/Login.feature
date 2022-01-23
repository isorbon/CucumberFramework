Feature: Login feature

  Background:
   # Given user is navigated to HRMS application

  @smoke @sprint2
  Scenario Outline: Valid admin login
#    Given user is navigated to HRMS application
    When user enters different "<username>" and "<password>"
    And user clicks on login button
    Then "<admin>" user is successfully logged in
    Examples:
      | username | password    | admin |
      | Admin    | Hum@nhrm123 | Admin |


  @regression
  Scenario: Valid ess login
#    Given user is navigated to HRMS application
    When user enters valid ess username and password
    And user clicks on login button
    Then admin user is successfully logged in
    # Then user close the browser

  @login
  Scenario Outline: Negative login test
    When user enters different "<username>" and "<password>" and verify the "<error>" for all the combinations
    Examples:
      | username  | password   | error                    |
      | Admin     | xyz        | Invalid credentials      |
      | cristiano | Hum@hrm123 | Invalid credentials      |
      |           | Hum@hrm123 | Username cannot be empty |
      | Admin     |            | Password cannot be empty |