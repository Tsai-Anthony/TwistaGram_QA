package cucumber.step_definitions;

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
import pages.PostPage;
import pages.loginPage;

public class postSteps {
	private WebDriver driver = DriverManager.getDriver();
	loginPage loginPage = new loginPage(driver);
	PostPage PostPage = new PostPage(driver);
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	
	
	@Given("user clicks on post page")
	public void user_clicks_on_post_page() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Post']")));
		PostPage.clickPostPage();

	}

	@When("user enters a message in the text field")
	public void user_enters_a_message_in_the_text_field() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@placeholder='What is happening?!']")));
		PostPage.sendText();

	}

	@Then("user can click post button")
	public void user_can_click_post_button() {
		PostPage.clickPostButton();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@data-testid = 'MoreHorizIcon'])[2]")));
		PostPage.click3dotButton();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Delete']")));
		PostPage.clickDeleteButton();		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='dialog']//button[2]")));
		///AppTestUtils.pause(5);
		PostPage.clickConfirmDeleteButton();
		
	}

}
