package com.local.tests;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ChromeSample {
	
	@Test
	public void SimpleRun() throws InterruptedException{
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.amazon.com/");
    	Thread.sleep(5000);
    	System.out.println("title" + driver.getTitle());
        assertEquals("Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more", driver.getTitle());
        driver.quit();
	}

}
