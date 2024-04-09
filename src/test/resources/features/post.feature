@tag
Feature: post

  @tag1
  Scenario: Post a message
    Given user logs into twistagram
    And user clicks on post page
    When user enters a message in the text field
    Then user can click post button



