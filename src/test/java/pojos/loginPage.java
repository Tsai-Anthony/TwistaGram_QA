package pojos;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {
	
	
	// Local Variables
	private WebDriver driver;
	private String URL = "https://twistagram.re-boot.us/";
	private String email = "test@gmail.com";
	
	// Elements
	@FindBy(xpath ="//*[@id='email-input']")
	private WebElement emailBox;
	
	@FindBy(xpath = "//*[@id='sign-in-with-email-button']")
	private WebElement signInButton;
	
	@FindBy(xpath = "//h1")
	private WebElement checkEmailMessage;
	
	@FindBy(xpath = "//*[@class='site']")
	private WebElement returnLink;
	
	
	//Contructor
	public loginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	//Getter
	public String getEmail() {
		return email;
	}
	//Setter
//	public void setEmail() {
//		this.email = email;
//	}
	
	// Actions
	public void clickEmailBox() {
		emailBox.click();
	}
	public void clickSignInButton() {
		signInButton.click();
	}
	public void actualMessage() {
		checkEmailMessage.getText();
	}
	public void clickReturnLink() {
		returnLink.click();
	}
	public void sendEmail() {
		emailBox.sendKeys(this.email);
	}
	public void goToTwistaGram() {
		driver.get(URL);
	}
}
