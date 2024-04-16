Feature: loginTwist

  @smoke @ui
  Scenario: Logging into Twistagram
    Given User goes to Twistagram website
    And User enters their email
    When User clicks sign in with email
    Then User should land on check your email screen
