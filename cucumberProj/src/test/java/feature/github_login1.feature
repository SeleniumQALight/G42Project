Feature: github login

  @q
  Scenario: 111login without username and password
    Given user is on github homepage
    When user clicks on Sign in button
    Then user is displayed login screen

  @q
  Scenario: 2222ogin without username and password
    Given user is on github homepage
    When user clicks on Sign in button
    Then user is displayed login screen
