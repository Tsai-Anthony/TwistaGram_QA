Feature: profile feature

  @ui @happypath
  Scenario: [Happy] User enters their profile
    Given user logs into twistagram
    And user clicks on profile menu
    Then user clicks on edit profile
    And user enters <name>, <username>, and <bio>
      | name     | hello               |
      | username | loops               |
      | bio      | are not our friends |
    And user clicks on save button
    Then user should see updated profile
    

