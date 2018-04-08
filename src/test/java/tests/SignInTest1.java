package tests;


import org.testng.Reporter;
import org.testng.annotations.Test;

import libraryUtils.BaseTest;
import libraryUtils.Utility;
import pages.FlightsPage;

public class SignInTest1 extends BaseTest {

	
	@Test
	public void shouldThrowAnErrorIfSignInDetailsAreMissing() throws Exception {
		
	FlightsPage s = new FlightsPage(driver);
	
	Reporter.log("Step: 1 Verify the title of login page", 1);
	Utility.verifyTitle("Site for Booking Flights, Hotels, Packages, Trains & Local activities.");
	
	Reporter.log("Step: 2 Wait till the page is loaded", 1);
	Utility.pageLoad();
	
	Reporter.log("Step: 3 Click on trip link", 1);
	s.clickTripLink();
	
	Reporter.log("Step: 4 Click on Sign in button", 1);
	s.clickSignIn();
	
	Reporter.log("Step: 5 switch to the new frame and click the button", 1);
	
	s.switchToSignInFrameAndClickButton();
	
	Reporter.log("Step: 6: Verify the errors", 1);
	s.getErrorText();
	
	
	
}
}
