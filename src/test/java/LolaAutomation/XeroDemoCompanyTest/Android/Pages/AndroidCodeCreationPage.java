package LolaAutomation.XeroDemoCompanyTest.Android.Pages;

import io.appium.java_client.android.AndroidDriver;

import java.io.IOException;

import org.openqa.selenium.By;

public class AndroidCodeCreationPage extends AndroidBasePage {

	public AndroidCodeCreationPage(AndroidDriver driver) {
		super(driver);
		// constructor stub
	}

	/**
	 * BY ELEMENTS
	 */
	protected By BySearchButtonNumber(String No) throws IOException {
		// content-desc
		String id = "com.xero.touch:id/btn_" + No;
		By res = By.id(id);
		return res;
	}

	protected By BySearchButtonBackspace() throws IOException {
		// content-desc
		By res = By.id("com.xero.touch:id/button_backspace");
		return res;
	}

	protected By BySearchButtonSkip() throws IOException {
		// text
		// By res = By.name("Skip");
		By res = By.id("com.xero.touch:id/button_forgot");
		return res;
	}

	/**
	 * METHODS
	 */
	public void clickButtonNumber(String No) throws IOException {
		Click(BySearchButtonNumber(No));
	}

	public void clickBackspace(String password) throws IOException {
		Click(BySearchButtonBackspace());
	}

	public void clickSkip() throws IOException {
		Click(BySearchButtonSkip());
	}

}
