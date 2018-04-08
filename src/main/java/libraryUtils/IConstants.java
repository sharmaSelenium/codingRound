package libraryUtils;
/**
 * Interface by default variables are constant and final. Only those values will be kept 
 * which are not going to be changed like Chromedriver keys and values, folder values
 * */
public interface IConstants {

	String CHROME_KEY="webdriver.chrome.driver";
	String CHROME_KEY_WINDOW_VALUE="./drivers/chromedriver.exe";

	String CHROME_KEY_LINUX_VALUE="./drivers/chromedriver_linux";
	

	String CHROME_KEY_MAC_VALUE="";
	
	String PHOTO_PATH="./photos";
	String CONFIG_PATH="./config.properties";
	
}
