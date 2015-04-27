package com.local.tests;

import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;
public class IntenetExplorerSample {

	@Test
	public void SimpleRun(){
		InternetExplorerDriver driver = new InternetExplorerDriver();
		driver.get("http://myridexch.com/login.php");
		driver.quit();
	}
}
