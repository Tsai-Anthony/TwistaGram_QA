package cucumber.step_definitions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.loginPage;
import utils.AppTestUtils;
import utils.DriverManager;



public class twistLoginSteps {
	private WebDriver driver = DriverManager.getInstance().getDriver();
	loginPage loginPage = new loginPage(driver);
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	
	
	
	@Given("User goes to Twistagram website")
	public void user_goes_to_twistagram_website() {	
		
		loginPage.goToTwistaGram();
		
		//assertEquals(loginPage.getURL(), driver.getCurrentUrl());
		//validate if we are on the correct URL

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
		
		//assertEquals(loginPage.getEmailMessage(), "Check your email");
		//validate check your email message screen display
		
//		loginPage.clickReturnLink();
		
		//assertEquals(loginPage.getReturnLink(), driver.getCurrentUrl());
		//validate if return link brings us back to twistagram


//		driver.close();
//		driver.quit();

	}

}
