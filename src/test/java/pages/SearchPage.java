package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	private WebDriver driver;
	
	private String searchURL = "https://twistagram.re-boot.us/search";
	private String SearchMenu = "Search";
	private String PostButton = "Post";
	private String postveryURL = "https://twistagram.re-boot.us/post/cluk9r1pq0000rgehkhthhneu";

	@FindBy(xpath = "//span[text() ='Search']")
	private WebElement searchMenuButton;

	@FindBy(xpath = "(//span[text()='Post'])[2]")
	private WebElement postButton;
	
	@FindBy(xpath = "//*[@type='text']")
	private WebElement searchBar;
	
	@FindBy(xpath = "//*[@id='left-container']")
	private WebElement targetPost;
	
	@FindBy(xpath = "//*[@id='text-content']")
	private WebElement verifyPost;
	
	// constructor
	public SearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	// method
	public void clickOnSearchMenu() {
		searchMenuButton.click();
	}
	
	public void clickOnPostButton() {
		postButton.click();
	}
	public void sendSearch(String string) {
		searchBar.sendKeys(string);
	}
	public void clickTargetPost() {
		targetPost.click();
	}
	
	public String getExpectedSearchURL() {
		return searchURL;
	}
	public String getExpectedSearchMenuName() {
		return SearchMenu;
	}
	public String getActualSearchMenuName() {
		return searchMenuButton.getText();
	}
	public String getExpectedPostButtonName() {
		return PostButton;
	}
	public String getActualPostButtonName() {
		return postButton.getText();
	}
	public String getVerifyPost() {
		return verifyPost.getText();
	}
	public String getVerifyURL() {
		return postveryURL;
	}
	

}