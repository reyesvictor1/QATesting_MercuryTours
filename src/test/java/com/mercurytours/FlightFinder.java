package com.mercurytours;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.chrome.ChromeDriver;

public class FlightFinder {

	private WebDriver driver;
	private static boolean testingStarted = false;

	@Before
	public void setUp() {
		if (!testingStarted)
			System.out.println("Testing started: FlightFinder class");
		testingStarted = true;

		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/newtours/index.php");
	}

	@Test
	public void testFlightFinder() {

		// starting test in home page
		assertEquals(driver.getTitle().trim(), "Welcome: Mercury Tours");

		// click the flights link
		WebElement flightsLink = driver.findElement(By.linkText("Flights"));
		flightsLink.click();
		assertEquals(driver.getTitle().trim(), "Find a Flight: Mercury Tours:");

		// trip type
		WebElement tripType = driver.findElement(By.cssSelector("[name='tripType'][value='oneway']"));
		tripType.click();

		// passengers
		WebElement passengers = driver.findElement(By.name("passCount"));
		Select passengersSelect = new Select(passengers);
		passengersSelect.selectByValue("2");

		// departure location
		WebElement departureLocation = driver.findElement(By.name("fromPort"));
		Select departureLocationSelect = new Select(departureLocation);
		departureLocationSelect.selectByValue("Frankfurt");

		// departure date
		WebElement departureMonth = driver.findElement(By.name("fromMonth"));
		Select departureMonthSelect = new Select(departureMonth);
		departureMonthSelect.selectByVisibleText("September");

		WebElement departureDay = driver.findElement(By.name("fromDay"));
		Select departureDaySelect = new Select(departureDay);
		departureDaySelect.selectByValue("23");

		// arrival location
		WebElement arrivalLocation = driver.findElement(By.name("toPort"));
		Select arrivalLocationSelect = new Select(arrivalLocation);
		arrivalLocationSelect.selectByValue("Seattle");

		// arrival date
		WebElement arrivalMonth = driver.findElement(By.name("toMonth"));
		Select arrivalMonthSelect = new Select(arrivalMonth);
		arrivalMonthSelect.selectByVisibleText("October");

		WebElement arrivalDay = driver.findElement(By.name("toDay"));
		Select arrivalDaySelect = new Select(arrivalDay);
		arrivalDaySelect.selectByValue("18");

		// service class
		WebElement serviceClass = driver.findElement(By.cssSelector("[name='servClass'][value='Business']"));
		serviceClass.click();

		// airline
		WebElement airline = driver.findElement(By.name("airline"));
		Select airlineSelect = new Select(airline);
		airlineSelect.selectByVisibleText("Unified Airlines");

		// press continue (findFlights)
		WebElement continueBtn = driver.findElement(By.name("findFlights"));
		continueBtn.click();

		// check flights results
		driver.findElement(By.xpath("//*[contains(string(),'No Seats Avaialble')]")); // there is a typo: should be "Available"

		// go back to home page		
		WebElement homeLink = driver.findElement(By.cssSelector("a[href='index.php'] > img")); // find the anchor which has an image nested inside
		homeLink.click();
		assertEquals(driver.getTitle().trim(), "Welcome: Mercury Tours");

	}

	@After
	public void tearDown() {
		driver.quit();
	}
}
