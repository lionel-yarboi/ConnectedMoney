@integration @QA
Feature: Failed Login

  As a user
  I want to see a list of institutions
  So I can select my bank

  Scenario Outline: Failed login
    Given I am on login screen
    And I login with valid credentials
      |Username           |MemorableAnswer|Password|
      |IB1120293731       |FooBar         |FooBar12|
    And I set my passcode
    And I disable push notifications
    And I am on you screen
    But I should see "<account>" name displayed
    And I scroll to bottom of screen
    And I tap to add institution
    When I tap "HSBC" bank
    And I enter with invalid credentials
      |Username        |MemorableAnswer|Password     |
      |33333333333     |FooBarWrong    |FooBar12Wrong|
    Then I should see failed polling card with message "Not connected"
    When I tap failed polling card
    Then I should see failed bank login institution screen

    Examples:
      | account     |
      | BANK A/C    |
