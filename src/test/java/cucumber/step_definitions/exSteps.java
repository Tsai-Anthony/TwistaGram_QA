package cucumber.step_definitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class exSteps {
WebDriver driver = new ChromeDriver();

	@Given("I have a simple scenario")
	public void i_have_a_simple_scenario() {
	driver.get("https://github.com/");
	}

	@When("I run the smoke test")
	public void i_run_the_smoke_test() {
		driver.close();
	}

	@Then("it should always pass")
	public void it_should_always_pass() {
		driver.quit();
	}
}
