Feature: User Logout

  Scenario: Users can log out to the application
    Given user opens the application through a browser
    When user enters a valid username
    And user enters a valid password
    And user clicks the login button
    And user clicks the burger icon
    And user clicks the logout button
    Then user will be redirect to login page
