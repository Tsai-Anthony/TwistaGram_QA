package cucumber.step_definitions;

import utils.DriverManager;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.loginPage;
import utils.AppTestUtils;

public class loginGoogleSteps {
	private WebDriver driver = DriverManager.getDriver();
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
		loginPage.clickNext();
		AppTestUtils.pause(2);
		loginPage.sendPassword();
		AppTestUtils.pause(5);
		loginPage.clickNext();
		AppTestUtils.pause(5);
		loginPage.clickContinue();

		
	}

	@Then("User is logged into Twistagram")
	public void user_is_logged_into_twistagram() {
		
//		driver.close();
//		driver.quit();

	}

}
