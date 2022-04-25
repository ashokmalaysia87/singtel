
Feature: View Completed Todos
 
  Scenario:	User is able to view the Completed Todos
    Given User is on Todos management screen to view completed
    When User creates the Todos and hit the Enter button and change the status of Todos to completed and Click on Completed button
    Then Completed Todos are listed as green tick items in the Todos list