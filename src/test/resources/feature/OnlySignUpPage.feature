Feature: New user Creation
  Background:
    Given Navigate to home page
    Then Signup and login link should be displayed
    When user click on signUp and login link
    Then page should navigate to sign Up or log in page



    @smoke1
    Scenario: verify Enter Account Information page appears after valid username and email-Id entered for new user sign up
      When enter signup_name and signup_email Address and click on Signup  button
      Then Page should navigate to sign up Page
      When Enter Account Information
      And click on create account Btn
      Then Page should navigate to account created page
