package LolaAutomation.XeroDemoCompanyTest.Pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import LolaAutomation.XeroDemoCompanyTest.Utils.PropertyLoader;

public class LoginPage extends BasePage {
	String url =  PropertyLoader.loadProperty("login.url");

	public LoginPage(WebDriver driver) {
		super(driver);
		//constructor stub
		NavURL(url);
	}

	/**
	 * BY ELEMENTS
	 */
	public By BySearchEmailAddress() throws IOException {
		// return getWebOjectLocator("lottoRegistrationUrl.emailAddress");
		By res = By.id("email");
		return res;
	}

	public By BySearchPassword() throws IOException {
		By res = By.id("password");
		return res;
	}

	public By BySearchSubmitLogin() throws IOException {
		By res = By.id("submitButton");
		return res;
	}

	/**
	 * METHODS
	 */
	public void inputEmailAddress(String email) throws IOException {
		//this.driver.findElement(BySearchEmailAddress()).sendKeys(email);
		SendKeys(BySearchEmailAddress(),email);
	}

	public void inputPassword(String password) throws IOException {
		//this.driver.findElement(BySearchPassword()).sendKeys(password);
		SendKeys(BySearchPassword(),password);
	}

	public void clickLogin() throws IOException {
		//this.driver.findElement(BySearchSubmitLogin()).click();
		Click(BySearchSubmitLogin());
	}

}
