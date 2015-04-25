package com.remout.tests;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.util.Properties;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.tests.fw.AppManager;

public class WebDriverTestJUnit {
	
	private WebDriver driver;
	private AppManager app;
    private String webBrowser;
	private String webBrowserVersion;
	private String platformForTests;
	private String baseUrl;
		
    @Before
    public void setUp() throws Exception {
    	Properties properties = new Properties();
    	properties.load(new FileReader(new File("application.properties")));
    	app = new AppManager(properties);
    	    	
    	// Choose the browser, version, and platform to test
    	DesiredCapabilities capabilities;
    	String browser = app.getWebBrowser(webBrowser);
    	System.out.println("browser " + browser);
    	String version = app.getWebBrowserVersion(webBrowserVersion);
    	System.out.println("version " + version);
    	String platform = app.getPlatform(platformForTests);
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
           	}
    		
    @Test
    public void webDriver() throws Exception {
        // Make the browser get the page and check its title
    	driver.get(app.getBaseUrl(baseUrl));
        Thread.sleep(5000);
        assertEquals
        		("Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more", driver.getTitle());
    }

    @After
    public void tearDown() throws Exception {
    	Thread.sleep(2000);
    	driver.quit();
    }

  }
