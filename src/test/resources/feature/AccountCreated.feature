Feature: Account created page
  Background:
    When enter signup_name and signup_email Address and click on Signup  button
      |signup_name|signup_email|
      |123        |123@abcd.com |
    Then Page should navigate to sign up Page
    When Enter Account Information and click on create account Btn



    Scenario: Account created page validation
      Then Page should navigate to account created page