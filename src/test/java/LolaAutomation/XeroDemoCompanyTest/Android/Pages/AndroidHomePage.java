package LolaAutomation.XeroDemoCompanyTest.Android.Pages;

import io.appium.java_client.android.AndroidDriver;

import java.io.IOException;

import org.openqa.selenium.By;

public class AndroidHomePage extends AndroidBasePage {

	public AndroidHomePage(AndroidDriver driver) {
		super(driver);
		//constructor stub
	}

	/**
	 * BY ELEMENTS
	 */
	protected By BySearchLoginText() throws IOException {
		By res = By.name("LOG IN WITH YOUR XERO ACCOUNT");
		return res;
	}

	/**
	 * METHODS
	 */
	public void goToLogin() throws IOException {
		Click(BySearchLoginText());
	}

	
}
