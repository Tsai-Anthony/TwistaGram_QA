package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.assertTrue;

public class exSteps {

	@Given("I have a simple scenario")
	public void i_have_a_simple_scenario() {
	}

	@When("I run the smoke test")
	public void i_run_the_smoke_test() {
	}

	@Then("it should always pass")
	public void it_should_always_pass() {
		assertTrue("This test should always pass.", true);
	}
}
