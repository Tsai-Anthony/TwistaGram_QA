package cucumber.step_definitions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.AppTestUtils;
import utils.DriverManager;

import pages.loginPage;
import pages.LogoutPage;

public class logoutSteps {
	private WebDriver driver = DriverManager.getDriver();
	loginPage loginPage = new loginPage(driver);
	LogoutPage logout = new LogoutPage(driver);
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	@Given("user clicks on greycircle")
	public void user_clicks_on_greycircle() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@data-testid='MoreHorizIcon'][1]")));
		logout.clicklogoutpage();
	}

	@When("user clicks logout")
	public void user_clicks_logout() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='log-out-button']")));
		assertEquals(logout.getExpectedLogoutText(), logout.getLogoutText());
		logout.clicklogout();
	}

	@When("user clicks on sign out")
	public void user_clicks_on_sign_out() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@type='button'][2]")));
		assertEquals(logout.getExpectedLogoutURL(), driver.getCurrentUrl() );
		assertEquals(logout.getExpectedGoBackText(), logout.getActualGoBackText());
		assertEquals(logout.getExpectedTextline(), logout.getActualTextLine());
		assertEquals(logout.getExpectedsignoutText(), logout.getActualSignOutTex());
		logout.clicksignout();
	}

	@Then("uder can logout")
	public void uder_can_logout() {

	}

}