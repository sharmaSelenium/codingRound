package tests;


import org.testng.Reporter;
import org.testng.annotations.Test;

import libraryUtils.BaseTest;
import libraryUtils.Utility;
import pages.FlightsPage;

public class FlightBookingTest2 extends BaseTest {

	
	@Test
	public void testThatResultsAppearForAOneWayJourney() throws Exception {
		
	FlightsPage s = new FlightsPage(driver);
	
	Reporter.log("Step: 1 Verify the title of login page", 1);
	Utility.verifyTitle("Site for Booking Flights, Hotels, Packages, Trains & Local activities.");
	
	Reporter.log("Step: 2 Wait till the page is loaded", 1);
	Utility.pageLoad();
	
	Reporter.log("Step: 3 Click on one way radio box", 1);
	s.clickOneWayRadio();
	
	Reporter.log("Step: 4 Set Arrival text box to Bangalore", 1);
	String arrival=Utility.getPropertyValue(CONFIG_PATH, "Arrival");
	s.setArrival(arrival);
	
	Reporter.log("Step: 5 Set Destination text box to Delhi", 1);
	String destination=Utility.getPropertyValue(CONFIG_PATH, "Destination");
	s.setDestination(destination);
	s.clickSearchbutton();
	
	Reporter.log("Step: 6 Select the 15th date of Departure", 1);
	String departureDate=Utility.getPropertyValue(CONFIG_PATH, "DepartureDate");
	s.selectDateFromCalendar(departureDate);
	
	Reporter.log("Step: 6 Click on search button", 1);
	s.clickSearchbutton();
	
	Reporter.log("Step: 7 VErufy the result appears ", 1);
	s.verifySearchResult();
}
}
