Feature: Account created page Validation
  Background:
    Given Navigate to home page
    Then Signup and login link should be displayed
    When user click on signUp and login link
    Then page should navigate to sign Up or log in page
    When enter signup_name and signup_email Address and click on Signup  button
    Then Page should navigate to sign up Page
    When Enter Account Information
    And click on create account Btn


@smoke1
    Scenario: Verify Account created page afters a new user account is created successfully.
      Then Page should navigate to account created page
      When click on continue button
      Then page should navigate to user HomePage
      When click on logout button
      Then page should navigate to sign Up or log in page

