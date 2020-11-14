Feature: checking the location of the car depending on the selected address

  Scenario Outline: I want the search to give only those cars that are located at the specified address <address>
    Given I logged in
    When I search for a car by location <address>
    Then I get only those cars that are located at the specified <address>
    Examples:
      | address |
      | "Лос-Анджелес" |
      |"Лондон"         |
      | "Сан-Франциско" |

