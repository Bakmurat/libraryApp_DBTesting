Feature: User is unable to log in with invalid credentials

	#The user is on the login page, and with the correct username and invalid password, the user is unable to log in. The error message is displayed.
  @db @B26G18-227 @B26G18-223 @B26G18-225 @LibraryCT
  Scenario: #99 TC003 User is unable to log in with invalid credentials
    Given user is on the loginPage
    When user enters invalid email address or password
    And student click sign in button
    Then verify the error message "Sorry, Wrong Email or Password"