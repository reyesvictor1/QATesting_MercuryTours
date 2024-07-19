package com.mercurytours;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    WebsiteNavigation.class,
    UserRegistration.class,
	FlightFinder.class
})

public class TestingController {}