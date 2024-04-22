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
import pages.logoutpage;

public class logoutsteps {
	private WebDriver driver = DriverManager.getDriver();
	loginPage loginPage = new loginPage(driver);
	logoutpage logou=new logoutpage (driver);
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
	

@Given("user clicks on greycircle")
public void user_clicks_on_greycircle() {
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@data-testid='MoreHorizIcon'][1]")));
	logou.clicklogoutpage();
}
@When("user clicks logout")
public void user_clicks_logout() {
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='log-out-button']"))); 
	logou.clicklogout();
}
@When("user clicks on sign out")
public void user_clicks_on_sign_out() {
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@type='button'][2]")));   
	logou.clicksignout();
}

@Then("uder can logout")
public void uder_can_logout() {
 
}

}