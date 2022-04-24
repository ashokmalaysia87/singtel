Feature: Manage the Todos

  Scenario: User is able to create Todo and the Todos are listed as items
    Given User is on Todos management screen
    When User creates the Todos and hit the Enter button
    Then Created Todos are listed as items in the same screen
