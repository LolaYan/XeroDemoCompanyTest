package LolaAutomation.XeroDemoCompanyTest.Android.Pages;

import io.appium.java_client.android.AndroidDriver;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class AndroidLoginPage extends AndroidBasePage {

	public AndroidLoginPage(AndroidDriver driver) {
		super(driver);
		//constructor stub
	}

	/**
	 * BY ELEMENTS
	 */
	protected By BySearchEmailInput() throws IOException {
		//content-desc
		By res = By.name("Email address");
		return res;
	}

	protected By BySearchPasswordInput() throws IOException {
		//content-desc
		By res = By.name("Password");
		return res;
	}
	
	protected By BySearchLoginButton() throws IOException {
		//text
		By res = By.name("CONTINUE");
		return res;
	}
	
	/**
	 * METHODS
	 */
	public void inputEmailAddress(String email) throws IOException {
		this.driver.findElement(BySearchEmailInput()).sendKeys(Keys.SPACE);
		//Click(BySearchEmailInput());
		SendKeys(BySearchEmailInput(),email);
	}

	public void inputPassword(String password) throws IOException {
		this.driver.findElement(BySearchPasswordInput()).sendKeys(Keys.SPACE);
		SendKeys(BySearchPasswordInput(),password);
	}

	public void clickLogin() throws IOException {
		Click(BySearchLoginButton());
	}

	
}
