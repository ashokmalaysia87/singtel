Feature: View the Todos that are active
 
  Scenario:	User is able to view the Active Todos
    Given User is on Todos management screen to view active
    When User creates the Todos and hit the Enter button and change the 1st Todo to completed and Click on Active button
    Then Active Todos are only listed in Todos list