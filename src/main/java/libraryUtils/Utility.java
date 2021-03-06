package libraryUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.sun.jna.platform.FileUtils;

/**
 *  This class will have static common methods like Taking screenshots, page explicit waits,
 *  element visibility,title is present
 * */

public class Utility {

	public static WebDriver driver;
	public static String parentWindowHandle=null;
	public static String parent = null;
	public static List<String> windowHandlers;
	
	/**
	 * @param driver 
	 * 
	 * */

	public Utility(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;

	}
	public static void takeScreenshot(WebDriver driver, String photos) {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
	
		

	}

	/**
	 * wait for the page load
	 * */

	public static void pageLoad() {

		try{
			driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		}

		catch(Exception e) {
			Reporter.log("Page is not loaded in 10 secs");
			Assert.fail();
		}
	}

	/**
	 * verify the title
	 * */

	public static void verifyTitle(String eTitle) {
		try{WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.titleContains(eTitle));
		Reporter.log("Tile is matching"+eTitle, 1);
		}
		catch(Exception e) {

			Reporter.log("Tile is  not matching", 1);
			Assert.fail();
		}
	}

	/**
	 * wait for the frame 
	 * */

	public static void waitForTheFrame(WebElement ele) {
		try{WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(ele));
		Reporter.log("Frame found"+ele, 1);
		}
		catch(Exception e) {

			Reporter.log("Frame not found", 1);
			Assert.fail();
		}
	}
	
	/**
	 * verify the element visiblity
	 * */

	public static void verifyElementIsPresent(WebElement ele) {
		try{WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(ele));
		Reporter.log("Element is present", 1);
		}
		catch(Exception e) {

			Reporter.log("Element is not present", 1);
			Assert.fail();
		}
	}

	/**
	 * dismiss the popup
	 * */

	public static void dismissPopup() {
		try{WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.alertIsPresent());
		Reporter.log("Popup is present", 1);


		Alert alert = driver.switchTo().alert();
		alert.dismiss();
		}
		catch(Exception e) {
			Reporter.log("Popup is not present", 1);

		}
	}

	//switch to parent window
	public static String parentWindow() {
		return driver.getWindowHandle(); // get the current window handle

	}

	public static void windowHandle() {

		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
		}
	}

	public static void switchToOriginalwindow() {

		driver.close(); // close newly opened window when done with it
		driver.switchTo().window(parentWindow()); // switch back to the original window
	}

	public static int switchToNewWindow()
	{
		int counter = 0;
		try{
			if(parentWindowHandle == null)
				parentWindowHandle= driver.getWindowHandle();
			for(String winHandle : driver.getWindowHandles()){
				if(!windowHandlers.contains(winHandle)){
					System.out.println(winHandle);
					driver.switchTo().window(winHandle);
					driver.manage().window().maximize();
				}
				counter++;
			}

			if(counter > windowHandlers.size()){
				windowHandlers.add(driver.getWindowHandle());
				System.out.println("handler : "+driver.getWindowHandle().toString());
				//System.out.println("Title is :"+driver.getTitle().toString());
			}
		}catch(Exception e){
			System.out.println("Switch to new window."+e.getMessage());
			//logMessage("Switch to new window.","Exception occured. Exception : "+e.getMessage(), "fail");
		}
		return counter;
	}

//switch to frame
	   public static void switchToFrame(String ElementName, String xpath){
           
           int count = 1;
           List<WebElement> frames = driver.findElements(By.xpath("//iframe"));
           System.out.println("Total Frames : " + frames.size());

          
           for(WebElement frame : frames)
           {
        	   
        	  driver.switchTo().frame(frame);
           
           try {

           System.out.println(""+ElementName + " "+driver.findElement(By.xpath(xpath)).getTagName());
           System.out.println("Found the frame!!!");
           
           break; 
           
           }catch(Exception ex) {
           System.out.println("Element not Found in frame "+count++);
           }
           
           driver.switchTo().defaultContent();
           }

	   }
	   
	   /**
	    * 
	    * Get the value of Keys according to path set in configuration file config.properties
	    * */
         public static String getPropertyValue(String path, String key) throws Exception {
			
        	 String v="";
        	 
        	 Properties p = new Properties();
        	 p.load(new FileInputStream(path));
        	 v=p.getProperty(key);
        	 return v;
           
         
}

         /**
  	    * Select the value by visible text
  	    * */
         public static boolean selectDropDrownValue(WebElement element, String value)
         {
                try {

                      if (element != null) {
                             Select selectBox = new Select(element);
                             selectBox.selectByVisibleText(value);
                      }
                } catch (NoSuchElementException e) {
                      e.printStackTrace();
                      return false;
                } catch (Exception e) {
                      e.printStackTrace();
                      return false;
                }
                return true;

         }
         
         
}
