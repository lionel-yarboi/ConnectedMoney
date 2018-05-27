@CI
Feature: Contact Us

  As a CM user who has logged into the app
  I want to be able to contact support directly through the app
  So that I can access help whenever I need.

  Background:
#    Given I have previously accepted latest Terms and Conditions for user 'SAMEUSER'
    And I am on login screen
    When I login with valid credentials
      | Username      | MemorableAnswer | Password |
      | IB1120293731  | FooBar          | FooBar12 |
#    And I tap include my bank button
#    And I tap "HSBC" bank
#    When I login with valid credentials
#      |Username           |MemorableAnswer|Password|
#      |IB1120293731       |FooBar         |FooBar12|
    And I set my passcode
    And I disable push notifications
    And I am on you screen
    And I tap settings icon
    When I tap contact us

  Scenario: Display Contact us option
    Then I should see contact us action sheet with Email and telephone options

  @contactUs
  Scenario: Select Cancel
    And I tap cancel
    Then I should not see contact us action sheet displayed
