@login
Feature: As a user I should be able to login with valid credentials
  @help_desk_login
  Scenario: login as help desk user
    When user is on the login page
    And user enter login and password credentials
    And user clicks on sign in button
    Then user successfully redirected on dashboard page