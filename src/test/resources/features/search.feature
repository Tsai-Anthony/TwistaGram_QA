Feature: search

  @ui @happy @test
  Scenario: Search on Twistagram 
    Given user logs into twistagram
  	And user clicks on Search menu
  	When user clicks on post button
  	And enters "search this" in the search bar
  	Then user will see "search this post👾"