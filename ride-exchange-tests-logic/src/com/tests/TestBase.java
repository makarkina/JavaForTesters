package com.tests;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;

import com.tests.logic.ApplicationManager;
import com.tests.logic1.ApplicationManager1;
import com.tests.model.Ride;
import com.tests.model.User;

public class TestBase {

	static protected ApplicationManager app;
						
	//@BeforeTest
    public void setUp() throws Exception {
    	Properties properties = new Properties();
    	String configFile = System.getProperty("configFile",
				"applicationChrome.properties");
    	properties.load(new FileReader(new File(configFile)));
    	app = new ApplicationManager1(properties);
    	app.getNavigationHelper().openLoginPage(properties.getProperty("baseUrl"));
   	}	
	
	    		
	//@AfterSuite
    public void tearDown() throws Exception {
        app.stop();
    }
	
	public static List<Object[]> wrapUsersForDataProvider(List<User> users) {
		List<Object[]> list = new ArrayList<Object[]>();
		for (User user : users){
			list.add(new Object[]{user});
		}
		return list;
		
	}
	
	public static List<Object[]> wrapRidesForDataProvider(List<Ride> rides) {
		List<Object[]> list1 = new ArrayList<Object[]>();
		for (Ride ride : rides){
			list1.add(new Object[]{ride});
		}
		return list1;
		
	}
}