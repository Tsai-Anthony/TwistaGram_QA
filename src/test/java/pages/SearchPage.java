package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class searchPage {
	
// Local Variables
	private WebDriver driver;
	private String message = "search";
	
	
// Constructor
	public searchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//span[text()='Search']")
	private WebElement searchPage;
	
	@FindBy(xpath = "(//*[@name='search-type-radio'])[2]")
	private WebElement searpostsearch;
	
@FindBy(xpath="//*[@type='text']")
private WebElement searchpostpage;
	public  void clicksearchPage() {
		searchPage.click();
		
	}
	
	public void clicksearchpostsearch() {
		searpostsearch.click();
	}
	
	public void sendText() {
		searchpostpage.sendKeys(message);
		
		}
	
}

	
	