package com.example.tests;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.example.fw.ApplicationManager;

public class TestBase {

	static protected ApplicationManager appl;
	
	@BeforeTest
	public void setUp() throws Exception {
		String configFile = System.getProperty("configFile", "application.properties");
		//String configFile = System.getProperty("application.properties");
		Properties properties = new Properties();
		properties.load(new FileReader(new File(configFile)));
	    appl = new ApplicationManager(properties);
	    appl.start();
	  }
	
	//@AfterTest
	public void tearDown() throws Exception {
		appl.stop();
	
	  }

}
