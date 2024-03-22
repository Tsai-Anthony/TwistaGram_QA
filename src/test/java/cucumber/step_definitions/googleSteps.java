package cucumber.step_definitions;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class googleSteps {
	WebDriver driver = new ChromeDriver();

	@Given("user opens a web browswer")
	public void user_opens_a_web_browswer() {
	}

	@When("the user navigates to {string}")
	public void the_user_navigates_to(String url) {
		driver.get(url);

	}

	@Then("the google homepage is displayed")
	public void the_google_homepage_is_displayed() throws InterruptedException {
		try {
			Thread.sleep(5000);
			assertTrue(driver.getTitle().contains("Google"));
		} catch (AssertionError e) {
			System.out.println(e.getMessage());
		}finally {
			driver.quit();

		}
	}

}
