Feature: github login

  @q @q1
  Scenario: 51 login without username and password
    Given user is on github homepage
    When user clicks on Sign in button
    Then user is displayed login screen
