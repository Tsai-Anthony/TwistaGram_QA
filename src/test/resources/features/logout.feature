Feature: logout

  @ui @happy @test
  Scenario: Logout Twistagram 
    Given user logs into twistagram
    And user clicks on greycircle
    When user clicks logout
    And user clicks on sign out
    Then uder can logout 