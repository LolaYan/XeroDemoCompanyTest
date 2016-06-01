/**
 * 
 */
package LolaAutomation.XeroDemoCompanyTest.Tests;

import java.io.IOException;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import LolaAutomation.XeroDemoCompanyTest.Driver.WebDriverHelper;
import LolaAutomation.XeroDemoCompanyTest.Pages.LoginPage;
import LolaAutomation.XeroDemoCompanyTest.Utils.LogHelper;
import LolaAutomation.XeroDemoCompanyTest.Utils.PropertyLoader;

public class BaseTest {

	public WebDriverHelper wdHelper;
	protected WebDriver driver;
	public ITestContext testContext;


	String email = PropertyLoader.loadProperty("login.email");
	String password = PropertyLoader.loadProperty("login.password");
	
	// constructor of BaseTest
	public BaseTest() {
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

		this.wdHelper = new WebDriverHelper();

		// get browser type from application.properties file
		String browser = wdHelper.getBrowserType();

		// Open browser
		this.driver = wdHelper.InitDriver(browser);

		// Navigate to website url
		String siteurl = PropertyLoader.loadProperty("site.url");
		this.driver.navigate().to(siteurl);
		
		//login first
		String LoginFlag = PropertyLoader.loadProperty("EnableLogin").toUpperCase()
				.replaceAll("\\s", "");
		if (LoginFlag.equalsIgnoreCase("ON")) {
			login();
		}
	}

	@AfterMethod
	public void tearDown(final ITestContext testContext) {
		LogHelper.endTestMethod("");
		// wdHelper.DestroyDriver();
		this.driver.quit();
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

	
	public void login() throws IOException {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.inputEmailAddress(email);
		loginPage.inputPassword(password);
		loginPage.clickLogin();
	}
}
