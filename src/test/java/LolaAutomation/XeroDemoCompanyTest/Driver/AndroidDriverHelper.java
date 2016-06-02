package LolaAutomation.XeroDemoCompanyTest.Driver;

import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import LolaAutomation.XeroDemoCompanyTest.Utils.LogHelper;
import LolaAutomation.XeroDemoCompanyTest.Utils.PropertyLoader;

/**
 * @author Lola
 * @email lolayan@outlook.com
 * 
 *        Note: define the initiation of android driver; define killing android
 *        driver; define implicitlyWait and pageloadTimeout;
 * 
 */
public class AndroidDriverHelper {

	protected AndroidDriver driver;

	// constructor of class
	public AndroidDriverHelper() {
	}

	// initiate the android driver
	public AndroidDriver InitDriver(String browserName, String deviceName,
			String platformVersion, String platformName, String appName,
			String appPackage, String appActivity) {
		try {
			LogHelper.info(" > Building appium session.");

			File classpathRoot = new File(System.getProperty("user.dir"));
			File appDir = new File(classpathRoot, "/apps/");
			File app = new File(appDir, appName);

			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities
					.setCapability(CapabilityType.BROWSER_NAME, browserName);
			capabilities.setCapability("deviceName", deviceName);
			capabilities.setCapability("platformVersion", platformVersion);
			capabilities.setCapability("platformName", platformName);
			capabilities.setCapability("app", app.getAbsolutePath());
			capabilities.setCapability("appPackage", appPackage);
			capabilities.setCapability("appActivity", appActivity);

			String appiumUrl = PropertyLoader.loadAndroidProperty("appium.url");
			driver = new AndroidDriver(new URL(appiumUrl), capabilities);

			// timeWaitInSeconds value should read from global properties file
			int timeWaitInSeconds = Integer.parseInt(PropertyLoader
					.loadAndroidProperty("implicitlyWebWait"));
			driver.manage().timeouts().implicitlyWait(timeWaitInSeconds, TimeUnit.SECONDS);
			Thread.sleep(10000);

		} catch (Exception e) {
			LogHelper.error(" Fail to create the appium session ! Error Msg: "
					+ e.getMessage());
		}
		return driver;
	}

	// quit driver
	public void DestroyDriver() {
		try {
			LogHelper.info(" Close appium android driver.");
			this.driver.quit();
		} catch (Exception e) {
			LogHelper.error(" Fail to closing appium android driver! Error Msg: "
					+ e.getMessage());
		}
	}

}
