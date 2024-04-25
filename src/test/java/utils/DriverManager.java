package utils;

import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

/**
 * This <DriverManager> class uses Selenium-Pie. Drivers are updated manually in
 * "drivers" folder under "resources" package.
 */
public class DriverManager {

	private static ThreadLocal<DriverManager> localDriverManager;

	private WebDriver driver;
	private String browser = ConfigReader.getTextValue(TestKeys.BROWSER_KEY);
	private boolean headless = ConfigReader.getBooleanValue("headless");
	private boolean isSet;
	private int waitTime = 5;

	private DriverManager() {
		// WARN: Nothing should be written here.
	}

	public static DriverManager getInstance() {
		if (localDriverManager == null)
			localDriverManager = new ThreadLocal<DriverManager>();
		if (localDriverManager.get() == null)
			localDriverManager.set(new DriverManager());
		return localDriverManager.get();
	}

	private void setupDriver() {
		if (System.getProperty(TestKeys.BROWSER_KEY) != null)
			browser = System.getProperty(TestKeys.BROWSER_KEY).toLowerCase();
		if (System.getProperty(TestKeys.HEADLESS_KEY) != null)
			headless = Boolean.valueOf(System.getProperty(TestKeys.HEADLESS_KEY).toLowerCase());
		isSet = true;
	}

	public void setupDriver(String browser) {
		this.browser = browser;
	}

	public void setupDriver(boolean headless) {
		this.headless = headless;
	}

	public void setupDriver(String browser, boolean headless) {
		this.browser = browser;
		this.headless = headless;
	}

	public WebDriver getDriver() {
		if (!isSet)
			setupDriver();
		if (driver == null)
			initDriver();
		return driver;
	}

	public static void reset() {
		if (localDriverManager.get().driver != null)
			localDriverManager.get().driver.quit();
		if (localDriverManager != null && localDriverManager.get() != null)
			localDriverManager.remove();
	}

	private void configDriver(WebDriver driver) {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(waitTime, TimeUnit.SECONDS);
	}

	private void initDriver() {
	    try {
	        switch (browser) {
	            case "chrome":
	                String chromePath = ConfigReader.getTextValue("chromedriverPath");
	                if (chromePath != null) {
	                    System.setProperty("webdriver.chrome.driver", chromePath);
	                    ChromeOptions options = new ChromeOptions();
	                    setChromeOptions(options);
	                    driver = new ChromeDriver(options);
	                } else {
	                    throw new IllegalStateException("Chrome driver path is not set.");
	                }
	                break;
	            case "firefox":
	                String firefoxPath = ConfigReader.getTextValue("geckodriverBinPath");
	                if (firefoxPath != null) {
	                    System.setProperty("webdriver.gecko.driver", firefoxPath);
	                    FirefoxOptions firefoxOptions = new FirefoxOptions();
	                    setFirefoxOptions(firefoxOptions);
	                    driver = new FirefoxDriver(firefoxOptions);
	                } else {
	                    throw new IllegalStateException("Firefox driver path is not set.");
	                }
	                break;
	            case "edge":
	                String edgePath = ConfigReader.getTextValue("edgedriverBinPath");
	                if (edgePath != null) {
	                    System.setProperty("webdriver.edge.driver", edgePath);
	                    EdgeOptions edgeOptions = new EdgeOptions();
	                    setEdgeOptions(edgeOptions);
	                    driver = new EdgeDriver(edgeOptions);
	                } else {
	                    throw new IllegalStateException("Edge driver path is not set.");
	                }
	                break;
	            default:
	                throw new RuntimeException("No such browser in the system.");
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        throw new RuntimeException("Failed to initialize the web driver: " + e.getMessage());
	    }
	    if (driver != null)
	        configDriver(driver);
	}


	/**
	 * Set specific conditions of <Chrome> for this application
	 */
	private void setChromeOptions(ChromeOptions chromeOptions) {
		if (headless)
			chromeOptions.addArguments("--headless");
	}

	/**
	 * Set specific conditions of <Edge> for this application
	 */
	private void setEdgeOptions(EdgeOptions edgeOptions) {
		// Create prefs
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("user_experience_metrics.personalization_data_consent_enabled", true); // Turn off personal prompt

		// Create args
		List<String> args = new ArrayList<String>();
		if (headless)
			args.add("--headless"); // Run headless mode

		Map<String, Object> desiredCapabilities = new HashMap<>();
		desiredCapabilities.put("prefs", prefs);
		desiredCapabilities.put("args", args);
		edgeOptions.setCapability("ms:edgeOptions", desiredCapabilities);
	}

	/**
	 * Set specific conditions of <Firefox> for this application
	 */
	private void setFirefoxOptions(FirefoxOptions firefoxOptions) {
		firefoxOptions.addPreference("geo.enabled", false); // Turn off geographical locator
		if (headless)
			firefoxOptions.addArguments("-headless");
	}

}