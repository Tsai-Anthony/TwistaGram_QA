package pages;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage {

	// Local Variables

	private WebDriver driver;

	// Constructor
	public ProfilePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Elements
	@FindBy(xpath = "//span[text()='Profile']")
	private WebElement profileButton;

	@FindBy(xpath = "(//*[@type='button'])[1]")
	private WebElement editProfileButton;

	@FindBy(xpath = "(//*[@type='text'])[1]")
	private WebElement nameTextField;

	@FindBy(xpath = "(//*[@type='text'])[2]")
	private WebElement usernameTextField;

	@FindBy(xpath = "//*[@rows='4']")
	private WebElement bioTextField;

	@FindBy(xpath = "//*[@id='save-button']")
	private WebElement saveButton;

	// Method

	public void clickProfileButton() {
		profileButton.click();
	}

	public void clickEditProfileButton() {
		editProfileButton.click();
	}

	public void clickSave() {
		saveButton.click();
	}

	public void enterData(String name, String username, String bio) {
		clearData(nameTextField);
		nameTextField.sendKeys(name);
		
		clearData(usernameTextField);

		usernameTextField.sendKeys(username);

		clearData(bioTextField);

		bioTextField.sendKeys(bio);

	}

	public void clearData(WebElement textfield) {
		String currentString = textfield.getAttribute("value");
		for (int i = 0; i < currentString.length(); i++) {
			textfield.sendKeys(Keys.BACK_SPACE);
		}
		
	}

}
