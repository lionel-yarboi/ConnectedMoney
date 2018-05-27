@transactiondetails
Feature: Display Transaction details

  As a: CM user that has added at least one account
  I Want: To be able to see the transactions and associated details
  So That: I can view specific data for a transaction

  Background:
    Given I am on login screen

  Scenario: Display transaction details
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
    And I set my passcode
    And I disable push notifications
    And I am on you screen
    When I select an account of type LOY ISA PREM
    And I select a month with some transactions
    And I select the transaction 'Paypal' to view its detail
    Then the transaction details should display the following information
      | MerchantName | Amount     | Date                  | AccountType | Description           |
      | Paypal       | − £12.65   | Saturday 30 September | Paypal      | PayPal - - DR         |
