package LolaAutomation.XeroDemoCompanyTest.Tests;

import java.io.IOException;

import org.testng.annotations.Test;

import LolaAutomation.XeroDemoCompanyTest.Pages.LoginPage;


public class LoginPageTest extends BaseTest{


	@Test(description = "To test LoginValidUserData", groups={"login.pass"})
	public void LoginValidUserData() throws IOException{
		LoginPage loginPage = new LoginPage(driver);
		loginPage.inputEmailAddress("lolayan@outlook.com");
		loginPage.inputPassword("yhx7886708");
		loginPage.clickLogin();
	}

}
