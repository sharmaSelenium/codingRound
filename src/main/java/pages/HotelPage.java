package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import libraryUtils.Utility;

/**
 * POM classes for declaration of Webelements, intialization and utilization of elements
 * present in hotel page
 * */

public class HotelPage extends Utility {

	public WebDriver driver;

	//hotel page constructor
	public HotelPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);

	}


	//Webelements in Hotel Page

	@FindBy(linkText = "Hotels")
	private WebElement hotelLink;

	@FindBy(id = "Tags")
	private WebElement localityTextBox;

	@FindBy(id = "SearchHotelsButton")
	private WebElement searchButton;

	@FindBy(id = "travellersOnhome")
	private WebElement travellerSelection;
	
	@FindBy(xpath = "(//a[contains(text(),'Indiranagar, Bangalore')])[1]")
	private WebElement lnkHotel;
	
	@FindBy(xpath = "//a[contains(text(),'Show all')]")
	private WebElement lnkShowHotels;
	

	//Methods

	//click to trip
	public void clickHotelLink() {

		hotelLink.click();
	}


	//set hotel name
	public void setHotelName(String hotelName) {
		localityTextBox.clear();
		localityTextBox.sendKeys(hotelName);
		verifyElementIsPresent(lnkHotel);
		lnkHotel.click();
		

	}
	
	//select value from list box
	public void selectHotelFromList() {
		selectDropDrownValue(travellerSelection, "1 room, 2 adults");		
	}
	
	//click to trip
		public void clickHotelButton()  {

			searchButton.click();
			pageLoad();
			verifyElementIsPresent(lnkShowHotels);
			Reporter.log("Hotels are displayed", 1);
		}
}
