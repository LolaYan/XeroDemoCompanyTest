package LolaAutomation.XeroDemoCompanyTest.Pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import LolaAutomation.XeroDemoCompanyTest.Utils.PropertyLoader;

public class DashboardPage extends BasePage {
	String url =  PropertyLoader.loadProperty("dashboard.url");

	public DashboardPage(WebDriver driver) {
		super(driver);
		//constructor stub
		NavURL(url);
	}

	/**
	 * BY ELEMENTS
	 */
	protected By BySearchDemoCompany() throws IOException {
		By res = By.xpath("//a[.=' Try the Demo Company (NZ) ']");
		return res;
	}

	/**
	 * METHODS
	 */
	public void goToDemoCompany() throws IOException {
		Click(BySearchDemoCompany());
	}

	
}
