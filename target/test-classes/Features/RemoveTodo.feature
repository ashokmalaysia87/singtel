Feature: Remove the Todos
 
  Scenario:	User is able to Remove the Completed Todos 
    Given User is on Todos management screen to Remove the Todos
    When User creates the Todos and Change the status of Todos to completed and Clear the Completed Todos
    Then Completed and clear Todos are removed from the list