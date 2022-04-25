Feature: View all the Todos
 
  Scenario:	User is able to view the All Todos
    Given User is on Todos management screen to view all
    When User creates the Todos and hit the Enter button and change the 1st Todo to completed
    Then Completed Todos are listed as green tick items and others without a tick mar in the Todos list