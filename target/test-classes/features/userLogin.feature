Feature: User Login

  Scenario: Users can log in to the application with valid credentials
    Given opens the application through a browser
    When enters a valid username
    And enters a valid password
    And clicks the login button
    Then should be successfully logged in to the application

  Scenario: Users cannot log in to the application with invalid credentials
    Given opens the application through a browser
    When enters a invalid username
    And enters a invalid password
    And clicks the login button
    Then The user receives a notification that the username or password is incorrect
