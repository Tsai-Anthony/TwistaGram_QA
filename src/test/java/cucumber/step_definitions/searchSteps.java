package cucumber.step_definitions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SearchPage;
import pages.loginPage;
import utils.DriverManager;

public class searchSteps {
	private WebDriver driver = DriverManager.getInstance().getDriver();;
	loginPage loginPage = new loginPage(driver);
	SearchPage search = new SearchPage(driver);
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	@Given("user clicks on Search menu")
	public void user_clicks_on_search_menu() {		
		assertEquals(search.getExpectedSearchMenuName(), search.getActualSearchMenuName());
		search.clickOnSearchMenu();


	}

	@When("user clicks on post button")
	public void user_clicks_on_post_button() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[text()='Post'])[2]")));
		
		assertEquals(search.getExpectedPostButtonName(), search.getActualPostButtonName());
				
		search.clickOnPostButton();

	}

	@When("enters {string} in the search bar")
	public void enters_in_the_search_bar(String string) {
		assertEquals(search.getExpectedSearchURL(), driver.getCurrentUrl());;

		search.sendSearch(string);

	}

	@Then("user will see {string}")
	public void user_will_see(String string) {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='left-container']")));

		search.clickTargetPost();
		assertEquals(search.getVerifyURL(), driver.getCurrentUrl());
		}

	}


