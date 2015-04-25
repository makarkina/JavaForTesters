package com.remout.tests;

import static org.junit.Assert.assertEquals;

import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WebDriverMobileTest {

	   private WebDriver driver;

	    @Before
	    public void setUp() throws Exception {
	        // Choose the browser, version, and platform to test
	    	DesiredCapabilities capabilities = DesiredCapabilities.iphone();
			capabilities.setCapability("deviceName","iPhone Simulator");
			capabilities.setCapability("device-orientation", "portrait");
	        // Create the connection to Sauce Labs to run the tests
	        this.driver = new RemoteWebDriver(
	                new URL("http://makarkina:a1d4cfc1-426c-4ec6-94e0-c5a262b4c95e@ondemand.saucelabs.com:80/wd/hub"),
	                capabilities);
	    }

	    @Test
	    public void webDriver() throws Exception {
	        // Make the browser get the page and check its title
	        driver.get("http://www.amazon.com/");
	        Thread.sleep(5000);
	        assertEquals("Amazon.com", driver.getTitle());
	    }

	    @After
	    public void tearDown() throws Exception {
	        driver.quit();
	    }

	}
