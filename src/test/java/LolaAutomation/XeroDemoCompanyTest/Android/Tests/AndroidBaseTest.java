/**
 * 
 */
package LolaAutomation.XeroDemoCompanyTest.Android.Tests;

import io.appium.java_client.android.AndroidDriver;

import java.io.IOException;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import LolaAutomation.XeroDemoCompanyTest.Driver.AndroidDriverHelper;
import LolaAutomation.XeroDemoCompanyTest.Utils.LogHelper;
import LolaAutomation.XeroDemoCompanyTest.Utils.PropertyLoader;

public class AndroidBaseTest {

	public AndroidDriverHelper adHelper;
	protected AndroidDriver driver;
	public ITestContext testContext;

	String browserName = PropertyLoader.loadProperty("browserName");
	String deviceName = PropertyLoader.loadAndroidProperty("deviceName");
	String platformVersion = PropertyLoader.loadProperty("platformVersion");
	String platformName = PropertyLoader.loadProperty("platformName");
	String appName = PropertyLoader.loadProperty("appName");
	String appPackage = PropertyLoader.loadProperty("appPackage");
	String appActivity = PropertyLoader.loadProperty("appActivity");

	// constructor of BaseTest
	public AndroidBaseTest() {
		// Read Log config from application.properties file
		String LogFlag = PropertyLoader.loadProperty("log").toUpperCase()
				.replaceAll("\\s", "");
		if (LogFlag.equalsIgnoreCase("ON")) {
			DOMConfigurator.configure("log4j.xml");
		}

	}

	@BeforeMethod
	public void setUp(final ITestContext testContext) throws IOException {

		// String name=testContext.getClass().getMethods().toString();
		LogHelper.startTestMethod("");

		this.adHelper = new AndroidDriverHelper();

		// Open app
		this.driver = adHelper
				.InitDriver(browserName, deviceName, platformVersion,
						platformName, appName, appPackage, appActivity);

		// Navigate to website url

	}

	@AfterMethod
	public void tearDown(final ITestContext testContext) {
		LogHelper.endTestMethod("");
		adHelper.DestroyDriver();
	}

	@BeforeSuite
	public void beforeSuite(final ITestContext testContext) {
		LogHelper.startTestSuite(testContext.getSuite().getName());
	}

	@AfterSuite
	public void afterSuite(final ITestContext testContext) {
		LogHelper.endTestSuite(testContext.getSuite().getName());
	}

	@BeforeTest
	public void beforeTest(final ITestContext testContext) {
		LogHelper.startTest(testContext.getName());
	}

	@AfterTest
	public void afterTest(final ITestContext testContext) {
		LogHelper.endTest(testContext.getName());
	}

	/*
	 * @BeforeGroups public void beforeGroups(ITestResult result) {
	 * LogHelper.startTestGroup(""); }
	 * 
	 * @AfterGroups public void afterGroups(ITestResult result) {
	 * LogHelper.endTestGroup(""); }
	 */
	@BeforeClass
	public void beforeClass(final ITestContext testContext) {
		LogHelper.startTestClass(testContext.getClass().getName());
	}

	@AfterClass
	public void afterClass(final ITestContext testContext) {
		LogHelper.endTestClass(testContext.getClass().getName());
	}

}
