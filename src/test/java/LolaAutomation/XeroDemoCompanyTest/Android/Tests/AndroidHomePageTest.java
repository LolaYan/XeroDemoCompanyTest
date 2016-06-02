package LolaAutomation.XeroDemoCompanyTest.Android.Tests;

import java.io.IOException;

import org.testng.annotations.Test;

import LolaAutomation.XeroDemoCompanyTest.Android.Pages.AndroidHomePage;


public class AndroidHomePageTest extends AndroidBaseTest{


	@Test(description = "To test xero homepage")
	public void ValidDashboardDemoCompany() throws IOException{
		AndroidHomePage androidHomePage = new AndroidHomePage(driver);
		androidHomePage.goToLogin();
	}

}
