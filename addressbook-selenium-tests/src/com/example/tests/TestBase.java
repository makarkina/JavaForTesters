package com.example.tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.example.fw.ApplicationManager;

public class TestBase {

	static protected ApplicationManager appl;
	
	@BeforeTest
	public void setUp() throws Exception {
	    appl = new ApplicationManager();
	    
	  }
	
	@AfterTest
	public void tearDown() throws Exception {
		appl.stop();
	    
	  }

}
