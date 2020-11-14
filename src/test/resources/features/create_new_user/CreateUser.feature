Feature: creation of new user

  Scenario: I want to create a new booking user
    Given I go to booking.com
    When I create a new user
    Then I get confirmation email