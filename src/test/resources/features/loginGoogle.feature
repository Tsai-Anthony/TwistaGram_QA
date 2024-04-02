@tag
Feature: loginGoogle

  @tag1
  Scenario: Login Twistagram with Google
    Given User goes to Twistagram website
		And User clicks on login with google button
		When User enters their email and password
		Then User is logged into Twistagram