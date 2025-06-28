Feature: LoginFeature
  This feature deals with the login functionality of the applications

  Scenario: Login with correct username and password
    Given I click login in Home page
    And I enter the following for Login
      | username | password      |
      | admin    | password |
    And I click login button
    Then I should see the userform page