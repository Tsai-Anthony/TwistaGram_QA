package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PostPage {
	
// Local Variables
	private WebDriver driver;
	private String message = "Delete this message";
	
// Constructor
	public PostPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
// Elements
	@FindBy(xpath = "//span[text()='Post']")
	private WebElement postPage;
	
	@FindBy(xpath = "//*[@placeholder='What is happening?!']")
	private WebElement textField;
	
	@FindBy(xpath = "//*[@id='post-button']")
	private WebElement postButton;
	
	@FindBy(xpath = "(//*[@data-testid = 'MoreHorizIcon'])[2]")
	private WebElement recentPostButton;
	
	@FindBy(xpath = "//span[text()='Delete']")
	private WebElement deleteButton;
	
	@FindBy (xpath = "//div[@role='dialog']//button[2]")
	private WebElement confirmDelete;
	
	
// Methods
	public void clickPostPage() {
		postPage.click();
	}
	public void sendText() {
		textField.sendKeys(message);
	}
	public void clickPostButton() {
		postButton.click();
	}
	public void click3dotButton() {
		recentPostButton.click();
	}
	public void clickDeleteButton() {
		deleteButton.click();
	}
	public void clickConfirmDeleteButton() {
		confirmDelete.click();
	}
}
