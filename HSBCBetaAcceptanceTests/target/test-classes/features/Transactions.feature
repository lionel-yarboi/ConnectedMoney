Feature: Display Transactions

  AS A: CM App user that has added my accounts
  I WANT: To be able to view my recent transactions when viewing the account details
  SO THAT: I can see how my money is spent

  Background:
    Given I am on login screen

  @QA
  Scenario Outline: Display transactions - current, savings and credit card
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
    When I select an account of type <Account>
    And I select a month with some transactions
    Then the merchant name and amount per transaction should be displayed

    Examples:
      | Account        |
      | BANK A/C       |
      | PERSONAL LN    |
      | CREDIT CARD    |

  @transactions
  Scenario Outline: Display transactions in chronology order
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
    When I select an account of type <Account>
    And I select a month with some transactions
    Then the transactions will be displayed in descending order of chronology

    Examples:
      | Account        |
      | LOY ISA PREM   |
#      | PERSONAL LN    |


   @CI
  Scenario: Display Pending transactions at the top
    Given I have previously accepted latest Terms and Conditions for user 'SAMEUSER'
    And I am on login screen
    When I login with valid credentials
      | Username | MemorableAnswer | Password |
      | SAMEUSER | sameuser        | sameuser |
    And I am on polling screen
    And Accounts have successfully been added
    And I am on you screen
    When I select an account of type BANK A/C
    And I select a month having pending transactions
    Then the pending transactions will be displayed over and above any other transactions

  @QA
  Scenario: No transactions
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
    When I select an account of type PERSONAL LN
    And I select a month with no transactions
    Then the 'No transactions' message should be displayed

  @CI
  Scenario Outline: Pagination
    And I have previously accepted latest Terms and Conditions for user 'SAMEUSER'
    And I am on login screen
    When I login with valid credentials
      | Username | MemorableAnswer | Password |
      | SAMEUSER | sameuser        | sameuser |
    And I set my passcode
    And I disable push notifications
    And I am on you screen
    When I select first account of type SMB account
    And I select a month with some transactions
    When I scroll to "<transaction>"
    Then I should see "<transaction>" with "<transaction_amount>"

    Examples:
    |transaction |transaction_amount|
    |Virgin Media|− £56.47          |

  @Manual
  Scenario: Verify Calendar panel shows 12 months of transactions
    And I select a month with some transactions
    Then the calendar picker should display 12 months of transactions
