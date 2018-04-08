package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import libraryUtils.Utility;

/**
 * POM classes for declaration of Webelements, intialization and utilization
 * */
public class SignInPage extends Utility {

	public WebDriver driver;
	//declaration of webelements //object repo
	@FindBy(linkText="Your trips")
	private WebElement lnkYourTrip;

	@FindBy(id="SignIn")
	private WebElement btnSignIn;

	@FindBy(xpath=".//*[@id='signInButton']")
	private WebElement btnSignInButton;
	


	//intialize the driver by Page factory methods
	public SignInPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

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
	public void switchToSignInFrame() {
		
		switchToFrame("Sign in frame", ".//*[@id='signInButton']");
		//driver.switchTo().frame(btnSignInButton);

	}
	
	//click to SignIn
		public void clickSignInButton() throws AWTException, InterruptedException {
			verifyElementIsPresent(btnSignInButton);
			
			//btnSignInButton.click();
			
		//	String Script = "javascript:document.getElementById('signInButton').click();";
			
			//JavascriptExecutor js = (JavascriptExecutor)driver;
			//js.executeScript(Script);
			
			//btnSignInButton.sendKeys(Keys.ENTER);
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_ENTER);
			Thread.sleep(1000);
			r.keyRelease(KeyEvent.VK_ENTER);
			
			System.out.println(btnSignInButton.getText());
			System.out.println("element is clicked");
			
		}
}
