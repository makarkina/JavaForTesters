package com.remout.tests;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.local.tests.GroupData;
import com.tests.fw.AppManager;

public class WebDriverTestRemout {

	private AppManager app;
    		
    	@BeforeMethod
    	public void setUp() throws Exception {
    	Properties properties = new Properties();
    	String configFile = System.getProperty("configFile",
				"applicationIE.properties");
    	properties.load(new FileReader(new File(configFile)));
    	app = new AppManager(properties);
    	}
    	
    	
    	@Test(dataProvider = "randomValidGroupGenerator")
  		public void testGroupCreationWithValidData(GroupData group) throws Exception {
	
    	app.navigateTo().mainPage();
    	app.navigateTo().groupsPage();
	
    	// save old state
    	List<GroupData> oldList = app.getGroupHelper().getGroups();
	
    	// actions
    	app.getGroupHelper().createGroup(group);
		    
    	// save new state
    	List<GroupData> newList = app.getGroupHelper().getGroups();
    	    
    	// compare states	      
    	oldList.add(group);
    	Collections.sort(oldList);
    	assertEquals(newList, oldList);
    	}
 
	    @AfterMethod
	    public void tearDown() throws Exception {
	        app.stop();
	    }
	    
	    @DataProvider
		public Iterator<Object[]> randomValidGroupGenerator(){
			List<Object[]> list = new ArrayList<Object[]>();
			
			for (int i = 0; i < 2; i++){
				GroupData group = new GroupData()
				.withName(generateRandomString())
				.withHeader(generateRandomString())
				.withFooter(generateRandomString());
				list.add(new Object[]{group});
			}
			return list.iterator();
		}

		public String generateRandomString(){
			Random rnd = new Random();
			if (rnd.nextInt(3) == 0){
				return "";
			}
			else {
				return "test" + rnd.nextInt();
			}
		}

	}