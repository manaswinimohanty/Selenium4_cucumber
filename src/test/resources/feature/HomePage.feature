Feature: HomePage Functionality
  @smoke
  Scenario: User should successfully navigate to login page
    Given Navigate to home page
    Then Signup and login link should be displayed
    When user click on signUp and login link
    Then page should navigate to sign Up page
