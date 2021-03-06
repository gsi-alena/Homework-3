package selenium_cucumber.selenium_cucumber.general;

import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.util.HashMap;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.remote.DesiredCapabilities;

public final class Setup {
	private static WebDriver driver;
	private static HashMap<String, Object> store = new HashMap();
	private static JavascriptExecutor jsExecutor;
	private static Actions actions;
	private static WaitingObject waitingObject;

	private static String defaultURL = "https://webgoheavy-testing.gsoftinnovation.net/admin";

	 @Before
	public void InitSetup() {
		String browser = System.getProperty("browser");
		System.setProperty("webdriver.chrome.driver", "D://Documents//QA-Automation//Google//chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		driver = new ChromeDriver(options);
		initObject();
	}

	private static void initObject() {
		waitingObject = new WaitingObject(driver);
		actions = new Actions(driver);
		System.setProperty("defaultURL", defaultURL);
	}

	public static WebDriver getDriver() {
		return driver;
	}

	/**
	 *
	 * @param key
	 * @return
	 */
	public static Object getValueStore(String key) {
		return store.get(key);
	}

	/**
	 *
	 * @return Return an instance of wait.
	 */
	public static WaitingObject getWait() {
		return waitingObject;
	}

	/**
	 *
	 * @param key
	 * @param value
	 */
	public static void setKeyValueStore(String key, Object value) {
		store.put(key, value);
	}

	/**
	 * Open new url
	 * 
	 * @param url
	 */
	public static void openUrl(String url) {
		driver.get(url);
		waitingObject.waitForLoading(3600);

	}

	@After
	public void close() {
		driver.close();
	}
}
