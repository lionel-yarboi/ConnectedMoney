Feature: Account List

  As a: CM App User
  I Want: To be able to add my bank accounts
  So That: I can view all my account information

  Background:
    Given I am on login screen

  @accountList
  Scenario: Accounts Displayed
    And I login with valid credentials
      |Username           |MemorableAnswer|Password|
      |IB1120293731       |FooBar         |FooBar12|
#    And I tap include my bank button
#    And I tap "HSBC" bank
#    When I login with valid credentials
#      |Username           |MemorableAnswer|Password|
#      |IB1120293731       |FooBar         |FooBar12|
#    And I am on polling screen
#    And Accounts have successfully been added
#    And I am on you screen
    And I set my passcode
    And I disable push notifications
    And I am on you screen
    And I scroll to bottom of screen
    Then I should see LOY ISA PREM account with balance £1511.84
    And I should see MORTGAGE account with balance − £60,2671.69

    @CI
  Scenario: Failed account status displayed
    And I have previously accepted latest Terms and Conditions for user 'SAMEUSER'
    And I am on login screen
    When I login with valid credentials
      | Username | MemorableAnswer | Password |
      | SAMEUSER | sameuser        | sameuser |
    And I tap include my bank button
    And I tap "HSBC" bank
    And I enter with invalid credentials
      |Username        |MemorableAnswer|Password     |
      |33333333333     |FooBarWrong    |FooBar12Wrong|
    And I am on polling screen
    Then I should see "Not connected" card on youscreen

   @QA
  Scenario Outline: Should hide Mortgage accounts
     And I login with valid credentials
       |Username           |MemorableAnswer|Password|
       |IB1120293731       |FooBar         |FooBar12|
     And I tap include my bank button
     And I tap "HSBC" bank
     When I login with valid credentials
       |Username           |MemorableAnswer|Password|
       |IB1120293731       |FooBar         |FooBar12|
     And I am on polling screen
     And Accounts have successfully been added
     And I am on you screen
    Then "<Mortgage>" account should not be visible

     Examples:
     |Mortgage|
     |hello world|

