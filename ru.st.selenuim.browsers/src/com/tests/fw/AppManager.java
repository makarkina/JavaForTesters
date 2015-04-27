package com.tests.fw;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class AppManager {
	
	public WebDriver driver;
	public Properties properties;
	private NavigationHelper navigationHelper;
	private GroupHelper groupHelper;
	
	public AppManager(Properties properties) {
		this.properties = properties;
		
		String browser = properties.getProperty("browser");
    	
    	if ("firefox".equals(browser)){
    		driver = new FirefoxDriver();
			    			
		} else if ("chrome".equals(browser)) {
			driver = new ChromeDriver();
			
		} else if ("ie".equals(browser)) {
			driver = new InternetExplorerDriver();
    	    		
		} else {
			throw new Error ("Unsupported browser: "+ browser);
		}
    	driver.get(properties.getProperty("baseUrl"));
	}
	
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
