package com.example.tests;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.example.fw.ApplicationManager;
import com.example.fw.Contact;

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
	
	public static List<Object[]> wrapContactsForDataProvider(List<Contact> contacts) {
		List<Object[]> list = new ArrayList<Object[]>();
		for (Contact contact : contacts){
			list.add(new Object[]{contact});
		}
		return list;
		
	}
	
}
