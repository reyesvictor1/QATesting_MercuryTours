package com.mercurytours;

import static org.junit.Assert.assertEquals;

import java.time.Duration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebsiteNavigation {

	private WebDriver driver;
	private static boolean testingStarted = false;

	@Before
	public void setUp() {
		if (!testingStarted)
			System.out.println("Testing started: MainPage class");
		testingStarted = true;

		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/newtours/index.php");
	}

	@Test
	public void testMainPageTitle() {
		assertEquals(driver.getTitle(), "Welcome: Mercury Tours");
	}

	@Test
	public void testSignOnLink() {
		WebElement signOnLink = driver.findElement(By.linkText("SIGN-ON"));
		signOnLink.click();
		assertEquals(driver.getTitle(), "Sign-on: Mercury Tours");
	}

	@Test
	public void testRegisterLink() {
		WebElement registerLink = driver.findElement(By.linkText("REGISTER"));
		registerLink.click();
		assertEquals(driver.getTitle(), "Register: Mercury Tours");
	}

	@Test
	public void testSupportLink() {
		WebElement supportLink = driver.findElement(By.linkText("SUPPORT"));
		supportLink.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3)); // wait for 3 seconds
		assertEquals(driver.getTitle(), "Under Construction: Mercury Tours");
	}

	@Test
	public void testContactLink() {
		WebElement contactLink = driver.findElement(By.linkText("CONTACT"));
		contactLink.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3)); // wait for 3 seconds
		assertEquals(driver.getTitle(), "Under Construction: Mercury Tours");
	}

	@After
	public void tearDown() {
		driver.quit();
	}
}