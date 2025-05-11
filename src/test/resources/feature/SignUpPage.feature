@all
Feature: Login to your account
  Background:
    Given Navigate to home page
    When user click on signUp and login link
    Then page should navigate to sign Up page
@smoke
  Scenario: Valid User login
    When enter username as "qatester@abc.com"
    And enter password as "india"
    And click on login button
    Then page should navigate to user HomePage


@smoke
  Scenario Outline: Login feature test using valid and invalid credentials
    When enter username as "<username>"
    And enter password as "<password>"
    And click on login button
    Then page should navigate to user HomePage
    @ValidUser
    Examples:
      | username | password |
      |qatester@abc.com|india|

    @InvalidUser
    Examples:
      | username | password |
      |demo@abc.com|abc|

  @smoke @regression
  Scenario: Invalid User login
    When enter username and password from data table as Map
    #here username and password present within pipe | are map keys
    |username|password|
    | demo@abc.com | demo |
    And click on login button
    Then Error message should display.

  @regression
  Scenario: Valid User login
    When enter username and password from data table as List
      | qatester@abc.com | india |
    And click on login button
    Then page should navigate to user HomePage
