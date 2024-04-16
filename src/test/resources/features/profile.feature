Feature: profile feature

  @ui
  Scenario: User enters their profile
    Given user logs into twistagram
    And user clicks on profile menu
    Then user clicks on edit profile
    And user enters <name>, <username>, and <bio>
      | name     | hello               |
      | username | loops               |
      | bio      | are not our friends |
    And user clicks on save button
    Then user should see updated profile
  #Scenario Outline: Title of your scenario outline
    #Given I want to write a step with <name>
    #When I check for the <value> in step
    #Then I verify the <status> in step
#
    #Examples: 
      #| name  | value | status  |
      #| name1 |     5 | success |
      #| name2 |     7 | Fail    |
