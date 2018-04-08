package tests;


import org.testng.Reporter;
import org.testng.annotations.Test;

import libraryUtils.BaseTest;
import libraryUtils.Utility;
import pages.HotelPage;

public class HotelBookingTest2 extends BaseTest {


	@Test
	public void shouldBeAbleToSearchForHotels() throws Exception {

		HotelPage h = new HotelPage(driver);
		Reporter.log("Step: 1 Open the cleartrip page", 1);

		Reporter.log("Step: 2 Verify cleartrip page is opened", 1);

		Utility.verifyTitle("Site for Booking Flights, Hotels, Packages, Trains & Local activities.");	
		Utility.pageLoad();

		Reporter.log("Step: 3 Click on hotel link and wait for the page to load", 1);

		h.clickHotelLink();
		Utility.pageLoad();

		Reporter.log("Step: 4 Enter hotel name to where textbox", 1);
		String hotelName=Utility.getPropertyValue(CONFIG_PATH, "Hotel_Name");
		h.setHotelName(hotelName);	
		
		Reporter.log("Step: 5 Select 1 rooms and 2 adults value from list box", 1);
		h.selectHotelFromList();
		
		Reporter.log("Step:6 Click on search hotel", 1);
		h.clickHotelButton();

	}
}
