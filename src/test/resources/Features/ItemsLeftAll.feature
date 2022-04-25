Feature: Items left all Todos

  Scenario: Verify the numbers of items displayed is with the quantity of Active Todos only during the All Todos view
    Given User is on Todos management screen to verify counter for all Todos
    When User creates the Todos and hit the Enter button and change the 1st Todo to completed and Click on All button to verify counter to verify counter
    Then items left is based on the remaining Active Todos for All Todos view
