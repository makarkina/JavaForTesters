package com.tests.logic1;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.opera.core.systems.OperaProfile;
import com.tests.logic.ApplicationManager;
import com.tests.logic.NavigationHelper;
import com.tests.logic.RideHelper;
import com.tests.logic.UserHelper;

public class ApplicationManager1 implements ApplicationManager {

	public WebDriver driver; 
	public String baseUrl;
	public Properties properties;
	private NavigationHelper navigationHelper;
	private UserHelper userHelper;
	private RideHelper rideHelper;
	
	public ApplicationManager1(Properties properties) throws Exception {
		this.properties = properties;
		
		String browser = properties.getProperty("browser");
    	    	
        	if ("firefox".equals(browser)){
        		driver = new FirefoxDriver();
    			    			
    		} else if ("chrome".equals(browser)) {
    			driver = new ChromeDriver();
    			
    		} else if ("opera".equals(browser)) {
    			/*DesiredCapabilities capabilities = new DesiredCapabilities();
    			capabilities.setCapability("opera.binary", "C:/Users/Anna/Downloads/operadriver_win64/operadriver.exe");*/
    			driver = new OperaDriver();
    			
    		} else if ("ie".equals(browser)) {
    			driver = new InternetExplorerDriver();
    		       	    		
    		} else {
    			throw new Error ("Unsupported browser: "+ browser);
    		}
        	
        	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        	navigationHelper = new NavigationHelper1(this);
        	userHelper = new UserHelper1(this);
        	rideHelper = new RideHelper1(this);
    }
			
		@Override
		 public NavigationHelper getNavigationHelper() {
		    return navigationHelper;
		 }
		
		@Override
		public UserHelper getUserHelper() {
			return userHelper;
		}
		
		@Override
		public RideHelper getRideHelper() {
			return rideHelper;
		}
	
		@Override
		public void stop() {
			if (driver != null) {
			      driver.quit();
			}
		}
}
