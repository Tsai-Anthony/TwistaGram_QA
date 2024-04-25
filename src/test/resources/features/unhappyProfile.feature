Feature: profile feature

  @ui @happypath
  Scenario: [UnHappy] User enters their profile
    Given user logs into twistagram
    And user clicks on profile menu
    Then user clicks on edit profile
    And user may only enter name, username, or bio
      | name     | <name>     |
      | username | <username> |
      | bio      | <bio>      |
    And user clicks on save button
    Then user should see error message
    And user returns to the profile page to make another entry
    
    

    Examples: 
      | name   | username   | bio     |
      | myname |            | testing |
      |        | myusername | testing |
      |        |            | testing |