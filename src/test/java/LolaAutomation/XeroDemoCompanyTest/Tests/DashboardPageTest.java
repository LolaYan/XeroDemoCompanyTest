package LolaAutomation.XeroDemoCompanyTest.Tests;

import java.io.IOException;

import org.testng.annotations.Test;

import LolaAutomation.XeroDemoCompanyTest.Pages.DashboardPage;
import LolaAutomation.XeroDemoCompanyTest.Pages.LoginPage;


public class DashboardPageTest extends BaseTest{


	@Test(description = "To test Valid Dashboard Demo Company")
	public void ValidDashboardDemoCompany() throws IOException{
		DashboardPage dashboardPage = new DashboardPage(driver);
		dashboardPage.goToDemoCompany();
	}

}
