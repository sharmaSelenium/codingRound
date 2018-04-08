package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import libraryUtils.Utility;

/**
 * POM classes for declaration of Webelements, intialization and utilization of elements
 * present in flight page
 * */
public class FlightsPage extends Utility {

	public WebDriver driver;

	//intialize the driver by Page factory methods
	public FlightsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	//declaration of webelements //object repo
	@FindBy(linkText="Your trips")
	private WebElement lnkYourTrip;

	@FindBy(id="SignIn")
	private WebElement btnSignIn;

	@FindBy(xpath=".//*[@id='signInButton']")
	private WebElement btnSignInButton;

	@FindBy(xpath="//div[@id='errors1']/span")
	private WebElement txtErrors;

	@FindBy(id="OneWay")
	private WebElement radioOneway;

	@FindBy(id="FromTag")
	private WebElement txtArrival;

	@FindBy(xpath="//input[@id='ToTag']")
	private WebElement txtDestination;

	@FindBy(xpath="(//a[contains(text(),'Bangalore')])[1]")
	private WebElement lnkArrival;

	@FindBy(xpath="(//a[contains(text(),'Delhi')])[1]")
	private WebElement lnkDestination;

	@FindBy(id="SearchBtn")
	private WebElement btnSearch;


	@FindBy(id="DepartDate")
	private WebElement txtDepart;

	@FindBy(xpath="(//table[@class='calendar'])[1]/tbody/tr/td/a")
	private List<WebElement> tblCalendar1;
	
	@FindBy(xpath="(//a[text()='Show all'])[2]/following-sibling::strong")
	private WebElement TotalFLights;




	//methods
	//click to trip
	public void clickTripLink() {

		lnkYourTrip.click();
	}

	//click to SignIn
	public void clickSignIn() {

		btnSignIn.click();
	}

	//click to SignIn
	public void switchToSignInFrameAndClickButton() throws Exception {


		switchToFrame("Sign in frame", ".//*[@id='signInButton']");
		verifyElementIsPresent(btnSignInButton);

		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		r.keyRelease(KeyEvent.VK_ENTER);

		Reporter.log("Sign In butotn is clicked", 1);
		System.out.println("element is clicked");


	}

	//click to Oneway
	public void clickOneWayRadio() {

		radioOneway.click();
	}


	public void getErrorText() {

		String etext=txtErrors.getText();
		Assert.assertTrue(etext.contains("There were errors in your submission"), "Errors in submission");
		Reporter.log("No username and password is entered"+etext, 1);
		System.out.println(etext);
	}

	//set arrival
	public void setArrival(String arrival) {
		txtArrival.clear();
		txtArrival.sendKeys(arrival);
		verifyElementIsPresent(lnkArrival);

	}


	//set arrival
	public void setDestination(String destination) {
		txtDestination.clear();
		txtDestination.sendKeys(destination);

	}

	//click to search button
	public void clickSearchbutton()  {

		btnSearch.click();
	}

	//Select 15th date of calendar
	public void selectDateFromCalendar(String dateOfDeparture)  {
		txtDepart.click();
		for(WebElement date:tblCalendar1) {
			if(dateOfDeparture.equals(date.getText())) {
				verifyElementIsPresent(date);
				System.out.println("Date of departure"+dateOfDeparture);
				date.click();
				Reporter.log("date is selected"+dateOfDeparture, 1);
			}

		}

	}

	
	public void verifySearchResult() {
		
		verifyElementIsPresent(TotalFLights);
		System.out.println("No of flights present"+TotalFLights.getText());
		Reporter.log("No of flights present"+TotalFLights.getText(),1);
		
		
	}
}
