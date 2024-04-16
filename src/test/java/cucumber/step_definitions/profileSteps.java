package cucumber.step_definitions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.ProfilePage;
import utils.DriverManager;

public class profileSteps {
	private WebDriver driver = DriverManager.getDriver();
	ProfilePage profilePage = new ProfilePage(driver);
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
	
	@Given("user clicks on profile menu")
	public void user_clicks_on_profile_menu() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Profile']")));
		profilePage.clickProfileButton();

	}

	@Then("user clicks on edit profile")
	public void user_clicks_on_edit_profile() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@type='button'])[1]")));
		profilePage.clickEditProfileButton();
	}
	@Then("user enters <name>, <username>, and <bio>")
	public void user_enters_name_username_and_bio(io.cucumber.datatable.DataTable dataTable) {
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@type='text'])[1]")));
		
		
		 Map<String, String> data = dataTable.asMap(String.class, String.class);
		profilePage.enterData(data.get("name"), data.get("username") , data.get("bio"));
	}

	@Then("user clicks on save button")
	public void user_clicks_on_save_button() {
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='save-button']")));
		profilePage.clickSave();

	}

	@Then("user should see updated profile")
	public void user_should_see_updated_profile() {
	//	assertEquals(profilePage., "hello");
	}

}
