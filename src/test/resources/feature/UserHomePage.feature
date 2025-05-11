Feature: Login Page feature Test
  Background:
    Given Navigate to home page
    When user click on signUp and login link
    Then page should navigate to sign Up page
    When enter username as "qatester@abc.com"
    And enter password as "india"
    And click on login button
    Then page should navigate to user HomePage

    @smoke @regression
    Scenario: Verify user Logged out after clicking logout link
      When click on logout button
      Then page should navigate to sign Up page


