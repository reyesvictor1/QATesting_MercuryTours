package com.mercurytours;

import java.util.List;

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
		if (!testingStarted) System.out.println("Testing started: FlightFinder class");
		testingStarted = true;

		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/newtours/index.php");
	}

	@Test
	public void testFlightFinder() {
		
		// click the flights link
		WebElement flightsLink = driver.findElement(By.linkText("Flights"));
		flightsLink.click();

		// trip type
		List<WebElement> tripTypes = driver.findElements(By.name("tripType"));
		for (WebElement tripType : tripTypes) {
			String value = tripType.getAttribute("value");
			if (value.equals("oneway")) tripType.click();
		}

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
		departureMonthSelect.selectByValue("September");

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
		arrivalMonthSelect.selectByValue("October");

		WebElement arrivalDay = driver.findElement(By.name("toDay"));
		Select arrivalDaySelect = new Select(arrivalDay);
		arrivalDaySelect.selectByValue("18");

		// service class
		List<WebElement> serviceClasses = driver.findElements(By.name("servClass"));
		for (WebElement serviceClass : serviceClasses) {
			String value = serviceClass.getAttribute("value");
			if (value.equals("Business")) serviceClass.click();
		}

		// airline
		WebElement airline = driver.findElement(By.name("airline"));
		Select airlineSelect = new Select(airline);
		airlineSelect.selectByValue("Unified Airlines");

		// press continue (findFlights)
		WebElement continueBtn = driver.findElement(By.name("findFlights"));
		continueBtn.click();

	}

	@After
	public void tearDown() {
		driver.quit();
	}
}
