Feature: Student is able to log in and home page is functional

	#The student is able to log in and the page URL is as expected, with the correct student username and password, the student is able to log in. The home page is functional and correct modules are present.
  @db @B26G18-226 @B26G18-223 @B26G18-225 @LibraryCT
  Scenario: #99 TC002 Student is able to log in and home page is functional
    Given student is on the loginPage
    Then verify that the URL is "https://library2.cydeo.com/login.html"
    When student enters valid email address and password
    And student click sign in button
    Then verify that there are 2 models on the page