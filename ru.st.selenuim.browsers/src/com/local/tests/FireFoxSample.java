package com.local.tests;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class FireFoxSample  {
	
	//private WebDriver driver;
    
    @Test
    public void webDriver() throws Exception {
        // Make the browser get the page and check its title
    	FirefoxDriver driver = new FirefoxDriver();
    	driver.get("http://www.amazon.com/");
    	Thread.sleep(5000);
        assertEquals("Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more", driver.getTitle());
        driver.quit();
    }

    

}
