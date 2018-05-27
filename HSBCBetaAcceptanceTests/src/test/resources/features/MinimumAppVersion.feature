@miniappversion @CI
Feature: Minimum App Version

  Scenario: New app version
    Given A new app version "5.9" is available
    Then I should see alert for new app version
