@onboarding @permissions @CI
Feature: Permissions screen

  As a CM user that has logged into the app
  I want to be able to enable notifications
  So I can receive notifications when not using the app

  As a CM user that has logged into the app
  I want to be able to set a passcode and enable touch ID
  So I can securely login to the app

  Background:
    Given I have previously accepted latest Terms and Conditions for user 'SAMEUSER'
    And I am on login screen
    When I login with valid credentials
      | Username | MemorableAnswer | Password |
      | SAMEUSER | sameuser        | sameuser |
    And I tap include my bank button
    And I tap "HSBC" bank
    And I login with valid credentials
      | Username | MemorableAnswer | Password |
      | SAMEUSER | sameuser        | sameuser |
    And I am on polling screen

  Scenario: Setup passcode
    When I set my passcode
    Then I should see green tick displayed on polling screen passcode card
    When I close and reopen app
    Then I should see passcode screen
    When I enter my passcode
    Then I should see polling screen

  Scenario: Incorrect passcode
    And I set my passcode
    When I enter incorrect passcode
    Then I should see error message "Passcodes did not match. Try again."

  Scenario: Enable notifications
    When I enable push notifications
    And I accept iOS notifications alert
    Then I should see green tick displayed on notifications button
