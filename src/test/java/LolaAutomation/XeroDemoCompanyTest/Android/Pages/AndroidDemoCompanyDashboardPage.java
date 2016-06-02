package LolaAutomation.XeroDemoCompanyTest.Android.Pages;

import io.appium.java_client.android.AndroidDriver;

import java.io.IOException;

import org.openqa.selenium.By;

public class AndroidDemoCompanyDashboardPage extends AndroidBasePage {

	public AndroidDemoCompanyDashboardPage(AndroidDriver driver) {
		super(driver);
		// constructor stub
	}

	/**
	 * BY ELEMENTS
	 */

	protected By BySearchTabTitleInvoices() throws IOException {
		//id="com.xero.touch:id/psts_tab_title"
		//text="INVOICES"
		By res = By.name("INVOICES");
		//By res = By.xpath("//*[@id='com.xero.touch:id/psts_tab_title'][@name='INVOICES']");
		return res;
	}


	/**
	 * METHODS
	 */
	public void clickTabTitleInvoices() throws IOException {
		Click(BySearchTabTitleInvoices());
	}



}
