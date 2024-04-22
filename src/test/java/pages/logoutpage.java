package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class logoutpage {
	
	private WebDriver driver;
	
	public logoutpage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//*[@data-testid='MoreHorizIcon'][1]")
	private WebElement logoutpage;
	@FindBy(xpath="//*[@id='log-out-button']")
	private WebElement logout;
	@FindBy(xpath="//*[@type='button'][2]")
	private WebElement signout;
	public void clicklogoutpage() {
		logoutpage.click();
	
}
public void clicklogout() {
	logout.click();
}
public void clicksignout() {
	signout.click();
}
}
		
	
// 