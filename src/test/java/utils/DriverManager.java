package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/win/chromedriver/chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void reset() {
        if (driver != null) {
            driver.quit();
            driver = null; 
        }
    }
}
