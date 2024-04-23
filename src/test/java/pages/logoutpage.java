package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class logoutpage {
	
	private WebDriver driver;
	private String URL ="https://twistagram.re-boot.us/auth/signout";
	private String Logout = "Log Out";	
	private String goback ="Go Back";
	private String textline="Are you sure you want to sign out?";
	private String signoutbutton="Sign Out";
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
	@FindBy(xpath="//h6")
	private WebElement texttline;
	@FindBy(xpath="//*[@type='button'][1]")
	private WebElement gobback;
	public void clicklogoutpage() {
		logoutpage.click();
	
}
public void clicklogout() {
	logout.click();
}
public void clicksignout() {
	signout.click();
}
public String getLogoutText() {
	return logout.getText();
}
public String getExpectedLogoutText() {
	return Logout;
}
public String getLogoutURL() {
	return URL;		
}
public String getExpectedTextline() {
return textline;
}
public String getextratextline() {
	return texttline.getText();
}
public String getgobackText(){
	return goback;
}
	public String getextrabacktext() {
		return gobback.getText();
	}

public String getExpectedsignoutText() {
	return signoutbutton;
}
public String getthissignout() {
	return signout.getText();
}











}

// 