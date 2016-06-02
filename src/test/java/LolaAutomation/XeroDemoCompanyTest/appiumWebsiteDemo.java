package LolaAutomation.XeroDemoCompanyTest;

import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class appiumWebsiteDemo {
	private static AndroidDriver driver;

	public static void main(String[] args) throws InterruptedException,
			MalformedURLException {

		File classpathRoot = new File(System.getProperty("user.dir"));
		File appDir = new File(classpathRoot, "/apps/");
		// File app = new File(appDir, "mylotto-cat1.apk");
		File app = new File(appDir, "XeroAccountingSoftware.apk");

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		capabilities.setCapability("deviceName", "d5b296cd");
		capabilities.setCapability("platformVersion", "23");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("app", app.getAbsolutePath());
		capabilities.setCapability("appPackage", "com.xero.touch");
		capabilities.setCapability("appActivity",
				"com.xero.touch.myxero.MyXeroActivity");

		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),
				capabilities);
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		Thread.sleep(1000);

		driver.findElement(By.name("LOG IN WITH YOUR XERO ACCOUNT")).click();

		driver.findElement(By.name("Email address")).sendKeys(Keys.SPACE);
		driver.findElement(By.name("Email address")).sendKeys(
				"lolayan@outlook.com");

		driver.findElement(By.name("Password")).click();
		driver.findElement(By.name("Password")).sendKeys("password123");

		Thread.sleep(5000);

		driver.findElement(By.name("CONTINUE")).click();

		Thread.sleep(2000);
		// driver.findElement(By.name("Skip")).click();

		Thread.sleep(2000);
		driver.findElement(By.name("INVOICES")).click();
		driver.findElement(By.name("Add invoice")).click();
		// driver.findElement(By.id("com.xero.touch:id/menu_add_invoice")).click();

		// Add items & quantities
		driver.findElement(By.name("Add items & quantities")).click();

		// Description or inventory item. Double tap to edit.
		driver.findElement(
				By.name("Description or inventory item. Double tap to edit."))
				.click();

		// BOOK: Fish out of Water: Finding Your Brand
		driver.findElement(
				By.name("BOOK: Fish out of Water: Finding Your Brand")).click();

		// Navigate up
		driver.findElement(By.name("Navigate up")).click();

		Thread.sleep(2000);
		// Who's it for?. Double tap to edit.
		String receiver = "LolaTest";
		driver.findElement(By.name("Who's it for?. Double tap to edit."))
				.click();
		driver.findElement(By.name("Who's it for?. Editing.")).sendKeys(
				receiver);
		// driver.findElement(By.name("Who's it for?. "+receiver+". Editing.")).sendKeys(Keys.ENTER);

		// Save
		driver.findElement(By.name("Save")).click();

		// Save
		// driver.findElement(By.id("com.xero.touch:id/menu_save")).click();

		// While the Selenium WebDriver spec has support for certain kinds of
		// mobile interaction, its parameters are not always easily mappable to
		// the functionality that the underlying device automation (like
		// UIAutomation in the case of iOS) provides

		JavascriptExecutor js = (JavascriptExecutor) driver;
		HashMap<String, Double> tapObject = new HashMap<String, Double>();
		tapObject.put("x", (double) 830); // in pixels from left
											// [792,87][936,231]
		tapObject.put("y", (double) 340); // in pixels from top
		js.executeScript("mobile: tap", tapObject);

		Thread.sleep(2000);
		driver.quit();
	}

	public static void Login(WebDriver driver) {

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
		driver.findElement(By.xpath("//a[.=' Try the Demo Company (NZ) ']"))
				.click();

	}
}
