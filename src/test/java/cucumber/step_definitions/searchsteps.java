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
import pages.loginPage;
import pages.searchPage;

public class searchsteps {
	private WebDriver driver = DriverManager.getDriver();
	loginPage loginPage = new loginPage(driver);
	searchPage searchPage =new searchPage(driver);
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));



@Given("user clicks on search page")
public void user_clicks_on_search_page() {
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Search']")));
	searchPage.clicksearchPage();
}

@When("user enters a message serach post")
public void user_enters_a_message_serach_post() {

	//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@name='search-type-radio'])[2]")));
	//searchPage.clicksearchpostsearch();
	searchPage.sendText();
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@type='text']")));
	
} 

@Then("user should see the post")
public void user_should_see_the_post() {
	
}
}
