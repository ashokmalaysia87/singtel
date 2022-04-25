Feature: Items left completed Todos

  Scenario: Verify the numbers of items displayed is with the quantity of Active Todos only during the Completed Todos view
    Given User is on Todos management screen to verify counter for completed Todos
    When User creates the Todos and hit the Enter button and change the 1st Todo to completed and Click on Completed button
    Then items left is based on the remaining Active Todos Completed Todos view
