package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ConfigReader;

public class loginPage {
	
	
	// Local Variables
	private WebDriver driver;
	private String URL = "https://twistagram.re-boot.us/auth/signin?callbackUrl=https%3A%2F%2Ftwistagram.re-boot.us";
	private String email = ConfigReader.getValue("config", "email");
	private String returnURL = "https://twistagram.re-boot.us/auth/signin?callbackUrl=https%3A%2F%2Ftwistagram.re-boot.us%2Fauth%2Fsignin%3FcallbackUrl%3Dhttps%253A%252F%252Ftwistagram.re-boot.us";
	
	// Elements
	@FindBy(xpath ="//*[@id='email-input']")
	private WebElement emailBox;
	
	@FindBy(xpath = "//*[@id='sign-in-with-email-button']")
	private WebElement signInButton;
	
	@FindBy(xpath = "//h1")
	private WebElement checkEmailMessage;
	
	@FindBy(xpath = "//*[@class='site']")
	private WebElement returnLink;
	
	@FindBy(xpath = "//*[@id='google-login']/button")
	private WebElement googleButton;
	
	@FindBy(xpath = "//*[@id='identifierId']")
	private WebElement googleEmail;
	
	
	//Contructor
	public loginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	//Getter
	public String getEmail() {
		return email;
	}
	public String getURL() {
		return URL;
	}

	public String getEmailMessage() {
		return checkEmailMessage.getText();
	}
	
	public String getReturnLink() {
		return returnURL;
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
	public void clickGoogleButton() {
		googleButton.click();
	}
	
	public void sendGmail() {
		googleEmail.sendKeys(this.email); 
		//email from using util/ cofig reader
	}
	
}

