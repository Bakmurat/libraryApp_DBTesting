Feature: Librarian is able to log in and home page is functional
	#Librarian is able to log in and the page title is as expected, with the correct librarian username and password, the librarian is able to log in. The home page is functional and correct modules are present.
  @db @B26G18-222 @B26G18-223 @B26G18-225 @LibraryCT
  Scenario: #99 TC001. Log in page is functional and librarian is able to log in
    Given librarian is on the loginPage
    Then verify that the title is "Login - Library"
    When librarian enters valid email address and password
    And librarian click sign in button
    Then verify that there are 3 models on the page