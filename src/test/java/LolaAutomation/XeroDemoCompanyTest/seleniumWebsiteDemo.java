package LolaAutomation.XeroDemoCompanyTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class seleniumWebsiteDemo {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"drivers/chromedriver.exe");
		driver = new ChromeDriver();
		Login(driver);
		GoToDemoCompany(driver);

		Thread.sleep(14000);

		// Close the browser
		driver.quit();
	}

	public static void Login(WebDriver driver) {

		driver.get("https://login.xero.com/");
		driver.findElement(By.id("email")).sendKeys("lolayan@outlook.com");
		driver.findElement(By.id("password")).sendKeys("yhx7886708");
		driver.findElement(By.id("submitButton")).click();

	}

	public static void signUp(WebDriver driver) {

		driver.get("https://www.xero.com/nz/signup/");

		driver.findElement(By.xpath("//input[@name='FirstName']")).sendKeys(
				"Lola");
		driver.findElement(By.xpath("//input[@name='LastName']")).sendKeys(
				"Test");
		driver.findElement(By.xpath("//input[@name='EmailAddress']")).sendKeys(
				"LolaYan@test.com");
		driver.findElement(By.xpath("//input[@name='PhoneNumber']")).sendKeys(
				"021296439988");
		driver.findElement(By.xpath("//input[@name='TermsAccepted']")).click();
		driver.findElement(By.xpath("//button[.='Get started']")).click();

		// System.out.println("test");
	}

	public static void GoToDemoCompany(WebDriver driver) {

		// Try the Demo Company (NZ) 
		driver.findElement(By.xpath("//a[.=' Try the Demo Company (NZ) ']")).click();

	}
}
