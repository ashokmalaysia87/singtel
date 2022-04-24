package Stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TodoCreate {

	@Given("User is on Todos management screen")
	public void user_is_on_todos_management_screen() {
	   System.out.println("on Todo screen");
	}

	@When("User creates the Todos and hit the Enter button")
	public void user_creates_the_todos_and_hit_the_enter_button() {
		System.out.println("on Todo screen");
	}

	@Then("Created Todos are listed as items in the same screen")
	public void created_todos_are_listed_as_items_in_the_same_screen() {
		System.out.println("on Todo screen");
	}
}
