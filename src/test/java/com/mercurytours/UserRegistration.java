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

public class UserRegistration {
	
	private WebDriver driver;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/newtours/index.php");
	}
	
	@Test
	public void testSignOnLink() {
		WebElement signOnLink = driver.findElement(By.linkText("SIGN-ON"));
		signOnLink.click();
		assertEquals(driver.getTitle(), "Sign-on: Mercury Tours");
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
}
