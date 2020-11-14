Feature: checking the location of the car provider depending on the selected address

  Scenario Outline: I want the search to give only those car providers that are located at the specified address <address>
    Given I logged in as a booking user
    When I search for car providers by location <address>
    Then I get only those car providers that are located at the specified <address>
    Examples:
      | address |
      | "Los Angeles" |
      |"Лондон"         |
      | "Сан-Франциско" |

