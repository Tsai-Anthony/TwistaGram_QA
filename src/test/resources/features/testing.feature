Feature: smoke test.test??

  @smoke
  Scenario: A simple passing test
    Given I have a simple scenario
    When I run the smoke test
    Then it should always pass
