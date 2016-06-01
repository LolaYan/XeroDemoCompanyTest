package LolaAutomation.XeroDemoCompanyTest.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import LolaAutomation.XeroDemoCompanyTest.Utils.LogHelper;
import LolaAutomation.XeroDemoCompanyTest.Utils.PropertyLoader;

/**
 * @author Lola
 * @email LolaYan@outlook.com
 * 
 *        Note: define the basic methods of BasePage, which will be extended by each test page objects.
 *        
 */
public class BasePage {

	protected WebDriver driver;
	int elementWaitInSeconds = Integer.parseInt(PropertyLoader
			.loadProperty("elementWait"));

	// put webdriver into constructor of BasePage
	public BasePage(WebDriver driver) {
		this.driver = driver;
	}

	// wait for element to be clickable
	public void WaitForElement(By by) {
		// timeoutInSeconds value should read from global contants file
		int timeoutInSeconds = elementWaitInSeconds;
		WebDriverWait wait = new WebDriverWait(this.driver, timeoutInSeconds);
		if (timeoutInSeconds > 0) {
			wait.until(ExpectedConditions.elementToBeClickable(by));
		}
	}

	// wait x seconds for element to be clickable
	public void WaitForElement(By by, int durationSeconds) {
		try {
			LogHelper.info(" Wait for " + durationSeconds
					+ " seconds before element " + by + " displayed");
			WebDriverWait wait = new WebDriverWait(this.driver, durationSeconds);
			if (durationSeconds > 0) {
				wait.until(ExpectedConditions.elementToBeClickable(by));
			}
		} catch (Exception e) {
			LogHelper.error(" * Fail to Wait for " + durationSeconds
					+ " seconds before element " + by + " displayed ! \r\n Error Msg:"
					+ e.getMessage());
		}
	}

	public void NavURL(String url) {
		try {
			LogHelper.info(" Navigating to URL: " + url);
			this.driver.get(url);
		} catch (Exception e) {
			LogHelper.error(" * Fail to Navigating to URL: " + url + " ! \r\n Error Msg:"
					+ e.getMessage());
		}

	}

	public void Click(By by) {
		try {
			LogHelper.info(" Click element: " + by);
			this.driver.findElement(by).click();
		} catch (Exception e) {
			LogHelper.error(" * Fail to click on element: " + by + " ! \r\n Error Msg:"
					+ e.getMessage() + " ! ");
		}
	}

	public void SendKeys(By by, String str) {
		try {
			LogHelper.info(" Input string: " + str + " into element:" + by);
			this.driver.findElement(by).sendKeys(str);
			;
		} catch (Exception e) {
			LogHelper.error(" * Fail to input string: " + str + " into element:"
					+ by + " ! \r\n Error Msg:" + e.getMessage() + " ! ");
		}

	}

	public void Submit(By by) {
		try {
			LogHelper.info(" Submit element: " + by);
			this.driver.findElement(by).submit();
		} catch (Exception e) {
			LogHelper.error(" * Fail to submit element: " + by + " ! \r\n Error Msg:" + e.getMessage()
					+ " ! ");
		}
	}

	public String GetCurrentURL() {
		String url = null;
		try {
			url = this.driver.getCurrentUrl();
			LogHelper.info(" Get current URL: "+ url);
		} catch (Exception e) {
			LogHelper.error(" * Fail to Get current URL.  ! " + "  \r\n Error Msg:"
					+ e.getMessage() + " ! ");
		}
		return url;
	}

	public String GetText(By by) {
		String text = null;
		try {
			LogHelper.info(" Get text of element: " + by);
			text = this.driver.findElement(by).getText();
		} catch (Exception e) {
			LogHelper.error(" * Fail to Get text of element:" + by  + " ! \r\n Error Msg:"
					+ e.getMessage() + " ! ");
		}
		return text;
	}

}
