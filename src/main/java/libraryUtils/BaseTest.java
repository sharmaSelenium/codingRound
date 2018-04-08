package libraryUtils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.sun.javafx.PlatformUtil;

/**
 *  This abstract class will user all annotations of TestNG to set the path of drivers,open the 
 *  application and maximize the window, clearing the cookies and close the the application
 * */
public abstract class BaseTest implements IConstants {

	public WebDriver driver;
	
	
	//set the drivers
	//param: window,mac
	@BeforeSuite(alwaysRun=true)
	public void setDriverPath() {
		
		        if (PlatformUtil.isMac()) {
		            System.setProperty(CHROME_KEY, CHROME_KEY_LINUX_VALUE);
		        }
		        if (PlatformUtil.isWindows()) {
		        	System.out.println("In windows");
		            System.setProperty(CHROME_KEY, CHROME_KEY_WINDOW_VALUE);
		        }
		        if (PlatformUtil.isLinux()) {
		            System.setProperty(CHROME_KEY, CHROME_KEY_MAC_VALUE);
		        }
		    


	}
	
	
	//open the application
	//maximize the window
	//clear the cookies
	//open the URL
	@BeforeMethod(alwaysRun=true)
	public void openApp() {
		driver=new ChromeDriver();
		//implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//clear the cookies
		driver.manage().deleteAllCookies();
		
		//maximize the window
		driver.manage().window().maximize();
		
		//get the URL
		driver.get("https://www.cleartrip.com/"); 
		
	}
	
	@AfterMethod(alwaysRun=true)
	//close the application
	public void closeApp()
	{
	driver.quit();	
		
	}
}
