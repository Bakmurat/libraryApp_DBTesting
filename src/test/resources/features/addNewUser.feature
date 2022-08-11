Feature: Librarian should be able to add new user.

	#Scenario: Librarian should be able to add a new user
  @wip @db @B26G18-230 @B26G18-223 @B26G18-225 @LibraryCT
  Scenario: #99 AC2 TC001 As a librarian, I should be able to add a new user
  As a librarian, I should be able to add a new user

    Given the "librarian" on the home page
    When librarian click Users module
    And librarian click "+Add User" button
    When librarian enter full name, password, email and address
    And librarian click save changes
    Then verify a new user is created