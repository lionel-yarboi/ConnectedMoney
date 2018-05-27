@accountdetail @QA
Feature: Account Detail

  As a user with at least one institution
  I want to see all account details
  So I can view specific information about an account

  Background:
    Given I am on login screen
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
    And I set my passcode
    And I disable push notifications
    And I am on you screen

  Scenario Outline: Account summary displayed
    When I tap "<account>" in account list
    Then I should see "<account>" name displayed
    And I should see "<accountBalance>" balance displayed
    And I should see account information "<account>", "<accountType>", "<accountNumber>", "<availableBalance>" and "<interestRate>" displayed

    Examples:
    |account      |accountBalance   |accountType    |accountNumber|availableBalance  |interestRate|
    |PREMIER SAVE |£100.00          |savings        |xxxx6140     |£100.00           |0.1%        |
