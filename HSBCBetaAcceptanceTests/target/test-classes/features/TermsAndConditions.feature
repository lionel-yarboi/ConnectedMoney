@termsAndConditions @onboarding @CI
Feature: Display Terms and Conditions only when required

  As a: CM App User
  I Want: To be able to log in and log out without having to accept terms and conditions every time I log in
  So That: I don't get asked to accept terms and conditions every time I want to log in to the app

  Background:
    Given I have successfully authenticated user:
      | Username | MemorableAnswer | Password |
      | SAMEUSER | sameuser        | sameuser |

  Scenario: Should not see Terms and Conditions if already accepted
    Given I have previously accepted latest Terms and Conditions for user 'SAMEUSER'
    And I am on login screen
    When I login with valid credentials
      | Username | MemorableAnswer | Password |
      | SAMEUSER | sameuser        | sameuser |
    Then I should not see Terms and Conditions

  Scenario: Accept Terms and Conditions
    Given I have not previously accepted Terms and Conditions
    And I am on login screen
    And I login with valid credentials
      | Username | MemorableAnswer | Password |
      | SAMEUSER | sameuser        | sameuser |
    When I accept Terms and Conditions
    Then the terms and conditions acceptance status for the user should be recorded

  Scenario: See new version of Terms and Conditions
    Given I have previously accepted latest Terms and Conditions for user 'SAMEUSER'
    And I am on login screen
    But a new version of Terms and Conditions is available now
    When I login with valid credentials
      | Username | MemorableAnswer | Password |
      | SAMEUSER | sameuser        | sameuser |
    Then I should see the latest Terms and Conditions

  Scenario: Updated Acceptance of Terms and Conditions recorded for user
    Given I have previously accepted latest Terms and Conditions for user 'SAMEUSER'
    And I am on login screen
    But a new version of Terms and Conditions is available now
    When I login with valid credentials
      | Username | MemorableAnswer | Password |
      | SAMEUSER | sameuser        | sameuser |
    And I accept Terms and Conditions
    Then the terms and conditions acceptance status for the user should be updated
