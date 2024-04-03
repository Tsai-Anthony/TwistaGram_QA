package pojos;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverManager {
	
	    private static WebDriver driver;
	    

	    public static WebDriver getDriver() {
	        if (driver == null) {
	            driver = new ChromeDriver();
	            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	            driver.manage().window().maximize();
	        }
	        return driver;
	    }

	    public static void closeDriver() {
	        if (driver != null) {
	            driver.quit();
	            driver = null;
	        }
	    }
	

}
