package com.remout.tests;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.Method;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class WebDriverTestNG {

		private WebDriver driver;

	    @Parameters({"username", "key", "os", "browser", "browserVersion"})
	    @BeforeMethod
	    public void setUp(@Optional("makarkina") String username,
	                      @Optional("a1d4cfc1-426c-4ec6-94e0-c5a262b4c95e") String key,
	                      @Optional("VISTA") String os,
	                      @Optional("chrome") String browser,
	                      @Optional("39.0") String browserVersion,
	                      Method method) throws Exception {

	        // Choose the browser, version, and platform to test
	        DesiredCapabilities capabilities = new DesiredCapabilities();
	        capabilities.setBrowserName(browser);
	        capabilities.setCapability("version", browserVersion);
	        capabilities.setCapability("platform", Platform.valueOf(os));
	        capabilities.setCapability("name", method.getName());
	        // Create the connection to Sauce Labs to run the tests
	        this.driver = new RemoteWebDriver(
	                new URL("http://" + username + ":" + key + "@ondemand.saucelabs.com:80/wd/hub"),
	                capabilities);
	    }

	    @Test
	    public void webDriver() throws Exception {
	        // Make the browser get the page and check its title
	        driver.get("http://www.amazon.com/");
	        assertEquals("Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more", driver.getTitle());
	    }

	    @AfterMethod
	    public void tearDown() throws Exception {
	        driver.quit();
	    }

	}