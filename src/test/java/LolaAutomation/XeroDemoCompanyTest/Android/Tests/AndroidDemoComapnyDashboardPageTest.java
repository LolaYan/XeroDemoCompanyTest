package LolaAutomation.XeroDemoCompanyTest.Android.Tests;

import java.io.IOException;

import org.testng.annotations.Test;

import LolaAutomation.XeroDemoCompanyTest.Android.Pages.AndroidCodeCreationPage;
import LolaAutomation.XeroDemoCompanyTest.Android.Pages.AndroidDemoCompanyDashboardPage;
import LolaAutomation.XeroDemoCompanyTest.Android.Pages.AndroidHomePage;
import LolaAutomation.XeroDemoCompanyTest.Android.Pages.AndroidLoginPage;
import LolaAutomation.XeroDemoCompanyTest.Utils.PropertyLoader;


public class AndroidDemoComapnyDashboardPageTest extends AndroidBaseTest{

	String email = PropertyLoader.loadProperty("login.email");
	String password = PropertyLoader.loadProperty("login.password");

	@Test(description = "To test xero homepage")
	public void ValidDashboardDemoCompany() throws IOException{
		AndroidHomePage androidHomePage = new AndroidHomePage(driver);
		androidHomePage.goToLogin();
		
		AndroidLoginPage androidLoginPage= new AndroidLoginPage(driver);
		androidLoginPage.inputEmailAddress(email);
		androidLoginPage.inputPassword(password);
		androidLoginPage.clickLogin();
		
		AndroidCodeCreationPage androidCodeCreationPage =new AndroidCodeCreationPage(driver);
		androidCodeCreationPage.clickSkip();
		
		AndroidDemoCompanyDashboardPage androidDemoCompanyDashboardPage =new AndroidDemoCompanyDashboardPage(driver);
		androidDemoCompanyDashboardPage.clickTabTitleInvoices();
		
	}

}
