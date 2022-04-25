Feature: Items left active Todos

  Scenario: Verify the numbers of items displayed is with the quantity of Active Todos only during the Active Todos view
    Given User is on Todos management screen to verify counter for Active Todos
    When User creates the Todos and hit the Enter button and change the 1st Todo to completed and Click on Active button
    Then items left is based on the remaining Active Todos All Active view
