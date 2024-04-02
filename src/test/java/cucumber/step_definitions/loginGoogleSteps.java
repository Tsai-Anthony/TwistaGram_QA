package cucumber.step_definitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pojos.*;
import utils.AppTestUtils;

public class loginGoogleSteps {
	WebDriver driver = new ChromeDriver();
	loginPage loginPage = new loginPage(driver);
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	@Given("User clicks on login with google button")
	public void user_clicks_on_login_with_google_button() {
		loginPage.goToTwistaGram();
		loginPage.clickGoogleButton();

	}

	@When("User enters their email and password")
	public void user_enters_their_email_and_password() {
		AppTestUtils.pause(5);
		loginPage.sendGmail();
		AppTestUtils.pause(5);

		
	}

	@Then("User is logged into Twistagram")
	public void user_is_logged_into_twistagram() {
		
		driver.close();
		driver.quit();

	}

}
