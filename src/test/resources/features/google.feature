Feature: Navigate to Google

  Scenario: User navigates to Google homepage
    Given user opens a web browswer
    When the user navigates to "https://www.google.com/"
    Then the google homepage is displayed
