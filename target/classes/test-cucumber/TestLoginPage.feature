Feature: Test Login Page
  Background: TestLoginPage - Navigate To Login Page
    Given I navigate to the homepage
    And I am on the Home Page
    When I click the Sign In button
    Then I am on the Login Page

  Scenario: TestLoginPage - As a user I want to go to the create account page and create an account with valid data
    Given I input the new email in the create account form on the Login page
    And I click the Create Account button on the Login Page
    Then I am on the Create account Page
    And I input the random data of customer in Create Account form
    And I click the Register button
    Then I am on the My Account Page

  Scenario: TestLoginPage - As A User I Want To Create An Account Which Has Already Been Registered
    Given I input the new email in the create account form on the Login page
    And I click the Create Account button on the Login Page
    Then I am on the Create account Page
    And I input the random data of customer in Create Account form
    And I click the Register button
    Then I am on the My Account Page
    And I click the Sign out button
    Then I am on the Login Page
    When I input the registered email in the create account form on the Login page
    And I click the Create Account button on the Login Page
    Then I can see the Message for email already registered appeared

  Scenario: TestLoginPage - As A User I Want To Create An Account Without Entered Email
    Given I leave blank e-mail in the create form on the Login Page
    And I click the Create Account button on the Login Page
    Then I receive a Create Account error message on the Login Page

  Scenario: TestLoginPage - As A User I Want To Login With NonRegister Account
    Given I input an invalid email and password on the Login Page
    And I click the Sign In button on the Login page
    Then I receive a Login error message on the Login page

  Scenario: TestLoginPage - As A User I Want To Login With Registered Account Then LogOut
    Given I input the new email in the create account form on the Login page
    And I click the Create Account button on the Login Page
    Then I am on the Create account Page
    And I input the random data of customer in Create Account form
    And I click the Register button
    Then I am on the My Account Page
    And I click the Sign out button
    Then I am on the Login Page
    When I input a valid email and password on the Login Page
    And I click the Sign In button on the Login page
    Then I am on the My Account Page
    When I click the Sign out button
    Then I am on the Login Page