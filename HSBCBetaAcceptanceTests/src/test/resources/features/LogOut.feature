@settings @logout @CI
Feature: LogOut

  As a user
  I want to log out
  So I can go through onboarding flow

  Background:
   Given I have previously accepted latest Terms and Conditions for user 'IB1120293731'

  Scenario: Log Out
    And I am on login screen
    When I login with valid credentials
      | Username      | MemorableAnswer | Password |
      | IB1120293731  | FooBar          | FooBar12 |
    And I set my passcode
    And I disable push notifications
    And I am on you screen
    And I tap settings icon
    And I tap log off button
    Then I should see login screen
