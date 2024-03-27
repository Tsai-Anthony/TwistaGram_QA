package cucumber.step_definitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pojos.loginPage;
import utils.AppTestUtils;



public class twistLoginSteps {
	WebDriver driver = new ChromeDriver();
	loginPage loginPage = new loginPage(driver);
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	
	
	
	@Given("User goes to Twistagram website")
	public void user_goes_to_twistagram_website() {
		//wait.until(ExpectedConditions.visibilityOf(loginPage.goToTwistaGram()));
		loginPage.goToTwistaGram();

	}

	@Given("User enters their email")
	public void user_enters_their_email() {
		loginPage.sendEmail();

	}

	@When("User clicks sign in with email")
	public void user_clicks_sign_in_with_email() {
		loginPage.clickSignInButton();

	}

	@Then("User should land on check your email screen")
	public void user_should_land_on_check_your_email_screen(){
		AppTestUtils.pause(5);
		
		loginPage.clickReturnLink();

		driver.close();
		driver.quit();

	}

}
