package com.mercurytours;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UserRegistration {

	private WebDriver driver;
	private static boolean testingStarted = false;

	@Before
	public void setUp() {
		if (!testingStarted) System.out.println("Testing started: UserRegistration class");
		testingStarted = true;
		
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/newtours/index.php");
	}

	@Test
	public void testUserRegistration() {
		WebElement registerLink = driver.findElement(By.linkText("REGISTER"));
		registerLink.click();

		WebElement firstNameInput = driver.findElement(By.name("firstName"));
		WebElement lastNameInput = driver.findElement(By.name("lastName"));
		WebElement phoneInput = driver.findElement(By.name("phone"));
		WebElement emailInput = driver.findElement(By.name("email"));
		WebElement addressInput = driver.findElement(By.name("address1"));
		WebElement cityInput = driver.findElement(By.name("city"));
		WebElement stateInput = driver.findElement(By.name("state"));
		WebElement postalCodeInput = driver.findElement(By.name("postalCode"));
		WebElement countrySelect = driver.findElement(By.name("country"));
		WebElement userNameInput = driver.findElement(By.name("userName"));
		WebElement passwordInput = driver.findElement(By.name("password"));
		WebElement confirmPasswordInput = driver.findElement(By.name("confirmPassword"));
		WebElement submitBtn = driver.findElement(By.name("submit"));

		String firstName = "Victor";
		String lastName = "Reyes";
		String userName = "reyesvictor1";
		String password = "12345";

		firstNameInput.sendKeys(firstName);
		lastNameInput.sendKeys(lastName);
		phoneInput.sendKeys("0123456789");
		emailInput.sendKeys("reyesvictor1");
		addressInput.sendKeys("Fake Street");
		cityInput.sendKeys("Aguascalientes City");
		stateInput.sendKeys("Aguascalientes");
		postalCodeInput.sendKeys("20270");
		countrySelect.sendKeys("MEXICO");
		userNameInput.sendKeys("fake.email@gmail.com");
		passwordInput.sendKeys(password);
		confirmPasswordInput.sendKeys("12345");
		submitBtn.click();

		WebElement registerText =  driver.findElement(By.xpath("//p[contains(string(),'Dear')]"));	
		String registerFullName = "Dear " + firstName + " " + lastName + ",";

		assertEquals(driver.getTitle(), "Register: Mercury Tours");
		assertEquals(registerText.getText(), registerFullName);

		WebElement signInLink = driver.findElement(By.linkText("sign-in"));
		signInLink.click();

		// TODO: close ad if visible
		
//		WebElement signOnUserName = driver.findElement(By.name("userName"));
//		WebElement signOnPassword = driver.findElement(By.name("password"));
//		WebElement signOnSubmit = driver.findElement(By.name("submit"));
//		signOnUserName.sendKeys(userName);
//		signOnPassword.sendKeys(password);
//		signOnSubmit.click();
//
//		WebElement loginText = driver.findElement(By.xpath("//h3[contains(string(),'Login Successfully')]"));
//		boolean isLoginTextVisible = loginText.isDisplayed();
//		assertTrue(isLoginTextVisible);
	}

	@After
	public void tearDown() {
//		driver.quit();
	}
}
