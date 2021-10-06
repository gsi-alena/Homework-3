package selenium_cucumber.selenium_cucumber.general;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class PageObject {
	private WebDriver driver;
	protected String urlpath = "";

	public PageObject() {
		 
		this.driver = Setup.getDriver();
		PageFactory.initElements(this.driver, this);
		// https://www.browserstack.com/guide/page-object-model-in-selenium
	}

	public void openURL() {
		String urll = System.getProperty("defaultURL");
		Setup.openUrl(System.getProperty("defaultURL").concat("/").concat(urlpath));
	}

	protected WebElement getWebElement(By by) {
		return this.driver.findElement(by);
	}

	protected List<WebElement> getWebElements(By by) {
		return this.driver.findElements(by);
	}

	protected void cliksOnButton(By by) {
		getWebElement(by).click();
		Setup.getWait().waitForLoading(10000);
		;
	}

	public String getCurrentUrl() {
		return this.driver.getCurrentUrl();
	}

	public String getPagePath() {
		return this.urlpath;
	}

}
