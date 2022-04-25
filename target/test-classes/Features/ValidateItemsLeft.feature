Feature: Validate the items left for each status

  Scenario: Verify the numbers of items displayed is same for all Todo views
    Given User is on Todos management screen to verify number of items value
    When User creates the Todos and hit the Enter button and change the 1st Todo to completed and Click on all views and compare the items left value
    Then items left value is based on the remaining Active Todos for all views
