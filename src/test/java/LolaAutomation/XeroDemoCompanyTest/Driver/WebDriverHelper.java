package LolaAutomation.XeroDemoCompanyTest.Driver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import LolaAutomation.XeroDemoCompanyTest.Utils.LogHelper;
import LolaAutomation.XeroDemoCompanyTest.Utils.PropertyLoader;

/**
 * @author Lola
 * @email lolayan@outlook.com
 * 
 *        Note: 
 *        define the initiation of driver; 
 *        define killing driver in WebDriverSupport; 
 *        define implicitlyWait and pageloadTimeout;
 * 
 */
public class WebDriverHelper {

	protected WebDriver driver;

	// constructor of class
	public WebDriverHelper() {
	}

	// initiate the webdriver
	public WebDriver InitDriver(String browser) {
		try {
			LogHelper.info(" > Opening Browser:" + browser);

			String browserType = browser.toUpperCase().replaceAll("\\s", "");

			// open browser
			switch (browser) {
			case "CHROME":
				System.setProperty("webdriver.chrome.driver",
						"drivers/chromedriver.exe");
				this.driver = new ChromeDriver();
				break;
			case "IE":
				System.setProperty("webdriver.ie.driver",
						"drivers/IEDriverServer.exe");
				this.driver = new InternetExplorerDriver();
				break;
			case "FIREFOX":
				this.driver = new FirefoxDriver();
				break;
			}

			// timeWaitInSeconds value should read from global properties file
			int timeWaitInSeconds = Integer.parseInt(PropertyLoader
								.loadProperty("implicitlyWebWait"));
						
			// global time wait setting
			driver.manage().timeouts()
					.pageLoadTimeout(timeWaitInSeconds, TimeUnit.SECONDS);
			driver.manage().timeouts()
					.implicitlyWait(timeWaitInSeconds, TimeUnit.SECONDS);
			driver.manage().window().maximize();

		} catch (Exception e) {
			LogHelper.error(" Fail to opening Browser:" + browser + " ! Error Msg: "
					+ e.getMessage());
		}
		return driver;
	}

	// quit driver
	public void DestroyDriver() {
		try {
			LogHelper.info(" Closing Browser.");
			this.driver.quit();
		} catch (Exception e) {
			LogHelper.error(" Fail to closing Browser! Error Msg: " + e.getMessage());
		}
	}
	
	public String getBrowserType() {
		String browser = null;
		try {
			LogHelper.info(" Get browser type from application.properties file " );
			String browserType = PropertyLoader.loadProperty("browser.name")
					.toUpperCase().replaceAll("\\s", "");
			LogHelper.info(" Get browser type:" +browserType);
			if (browserType.equals("IE")
					|| browserType.equals("INTERNETEXPLORER")) {
				browser = browserType;
			} else if (browserType.equals("FIREFOX")) {
				browser = browserType;
			} else {
				browser = browserType;
			}
		} catch (Exception e) {
			LogHelper.error(" Fail to get browser type from application.properties file " + " ! Error Msg: " + e.getMessage());
		}

		return browser;
	}

}
