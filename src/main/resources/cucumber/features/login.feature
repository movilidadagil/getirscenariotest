Feature: Login functionality

  As a user of Getir
  In order to manage my basket
  I want to be able to log in to the system

  Scenario: Log in with valid credentials
    Given I am a user of Getir
    When I log in using valid credentials
    Then I should be logged in
