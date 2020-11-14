Feature: adding hotels to favorites

  Scenario: I want to add my favorites hotels to list of favorites
    Given I did the sorting of hotels
    When I added the first and the last hotels to my favorite list
    Then I check these hotels are in my favorite list