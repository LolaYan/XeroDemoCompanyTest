package LolaAutomation.XeroDemoCompanyTest.Android.Pages;

import io.appium.java_client.android.AndroidDriver;

import java.io.IOException;

import org.openqa.selenium.By;

public class AndroidDemoCompanyDashboardInvoicePage extends AndroidBasePage {

	public AndroidDemoCompanyDashboardInvoicePage(AndroidDriver driver) {
		super(driver);
		// constructor stub
	}

	/**
	 * BY ELEMENTS
	 */
	protected By BySearchButtonAddInvoices() throws IOException {
		// id="com.xero.touch:id/menu_add_invoice"
		// content-desc="Add invoice"
		By res = By.id("com.xero.touch:id/menu_add_invoice");
		return res;
	}

	/**
	 * METHODS
	 */
	public void clickTabTitleInvoices() throws IOException {
		Click(BySearchButtonAddInvoices());
	}

}
