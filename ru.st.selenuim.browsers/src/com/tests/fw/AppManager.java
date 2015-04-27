package com.tests.fw;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AppManager {
	
	public WebDriver driver;
	public Properties properties;
	private NavigationHelper navigationHelper;
	private GroupHelper groupHelper;
	
	public AppManager(Properties properties) throws MalformedURLException {
		this.properties = properties;
		
		DesiredCapabilities capabilities;
    	String browser = getWebBrowser();
    	String version = getWebBrowserVersion();
    	String platform = getPlatform();
    	
        	if ("firefox".equals(browser)){
    			capabilities = DesiredCapabilities.firefox();
    			capabilities.setCapability("version", version);
    			capabilities.setCapability("platform", platform);
    			    			
    		} else if ("chrome".equals(browser)) {
    			capabilities = DesiredCapabilities.chrome();
    			capabilities.setCapability("version", version);
    			capabilities.setCapability("platform", platform);
    			
    		} else if ("ie".equals(browser)) {
    			capabilities = DesiredCapabilities.internetExplorer();
    			capabilities.setCapability("version", version);
    			capabilities.setCapability("platform", platform);
    			
    		       	    		
    		} else {
    			throw new Error ("Unsupported browser: "+ browser);
    		}
        	
			this.driver = new RemoteWebDriver(
	                new URL("http://makarkina:a1d4cfc1-426c-4ec6-94e0-c5a262b4c95e@ondemand.saucelabs.com:80/wd/hub"),
	                capabilities);
			driver.get(properties.getProperty("baseUrl"));
           	}

		
		//String browser = properties.getProperty("browser");
    	
    	/*if ("firefox".equals(browser)){
    		driver = new FirefoxDriver();
			    			
		} else if ("chrome".equals(browser)) {
			driver = new ChromeDriver();
			
		} else if ("ie".equals(browser)) {
			driver = new InternetExplorerDriver();
    	    		
		} else {
			throw new Error ("Unsupported browser: "+ browser);
		}
    	//driver.get(properties.getProperty("baseUrl"));
	}*/
	
	public NavigationHelper navigateTo() 
	{
		if (navigationHelper == null) {
			navigationHelper = new NavigationHelper(this);
		}
		return navigationHelper;
	}
		
	public GroupHelper getGroupHelper() 
	{
		if (groupHelper == null) {
			groupHelper = new GroupHelper(this);
		}
		return groupHelper;
	}
	
	public String getBaseUrl() {
		return properties.getProperty("baseUrl");
	}
		
	public String getWebBrowser() {
		return properties.getProperty("browser");
	}

	public String getWebBrowserVersion() {
		return properties.getProperty("version");
	}

	public String getPlatform() {
		return properties.getProperty("platform");
	}
	
	public String getWebPageTitle() {
		System.out.println("title " + driver.getTitle());
		return driver.getTitle();
	}
	
	public void stop() {
		driver.quit();
	}
	
}
