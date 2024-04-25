package cucumber.step_definitions;

import utils.DriverManager;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.loginPage;
import utils.AppTestUtils;

public class loginGoogleSteps {
	private WebDriver driver = DriverManager.getInstance().getDriver();
	loginPage loginPage = new loginPage(driver);
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	

	@Given("user logs into twistagram")
	public void user_logs_into_twistagram() {
		loginPage.goToTwistaGram();
		loginPage.clickGoogleButton();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("identifierId")));
		loginPage.sendGmail();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Next']")));
		loginPage.clickNext();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
		loginPage.sendPassword();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Next']")));
		loginPage.clickNext();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Continue']")));
		loginPage.clickContinue();

		
	}

	@Then("User is logged into Twistagram")
	public void user_is_logged_into_twistagram() {
		
		driver.close();
		driver.quit();


	}

}
