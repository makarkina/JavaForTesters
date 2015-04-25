package com.local.tests;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.tests.fw.AppManager;

public class WebDriverTestLocal {

	private AppManager app;
    private String webBrowser;
	private WebDriver driver;
	private String baseUrl;

    @BeforeTest
    public void setUp() throws Exception {
    	Properties properties = new Properties();
    	properties.load(new FileReader(new File("application.properties")));
    	app = new AppManager(properties);
    	
    	String browser = app.getWebBrowser(webBrowser);
    	
    	if ("firefox".equals(browser)){
    		driver = new FirefoxDriver();
			    			
		} else if ("chrome".equals(browser)) {
			driver = new ChromeDriver();
			
		} else if ("ie".equals(browser)) {
			driver = new InternetExplorerDriver();
    	    		
		} else {
			throw new Error ("Unsupported browser: "+ browser);
		}
    }	
    	
    @Test
    public void webDriver() throws Exception {
        // Make the browser get the page and check its title
    	driver.get(app.getBaseUrl(baseUrl));
        Thread.sleep(2000);
        assertEquals("Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more", 
        		driver.getTitle());
    }
   

	@AfterTest
    public void tearDown() throws Exception {
        driver.quit();
    }

}