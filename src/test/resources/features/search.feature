
Feature: search 
 

  @tag1
  Scenario: search a message
    Given user logs into twistagram
    And user clicks on search page
    When user enters a message serach post 
    Then user should see the post
 