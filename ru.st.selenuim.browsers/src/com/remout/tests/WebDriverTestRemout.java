package com.remout.tests;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.local.tests.GroupData;
import com.tests.fw.AppManager;

public class WebDriverTestRemout {

	private WebDriver driver;
	private AppManager app;
    		
    	@BeforeMethod
    	public void setUp() throws Exception {
    	Properties properties = new Properties();
    	String configFile = System.getProperty("configFile",
				"applicationChrome.properties");
    	properties.load(new FileReader(new File(configFile)));
    	app = new AppManager(properties);
    	    	
    	// Choose the browser, version, and platform to test
    	DesiredCapabilities capabilities;
    	String browser = app.getWebBrowser();
    	String version = app.getWebBrowserVersion();
    	String platform = app.getPlatform();
        	if ("firefox".equals(browser)){
    			capabilities = DesiredCapabilities.firefox();
    			capabilities.setCapability("version", version);
    			capabilities.setCapability("platform", platform);
    			    			
    		} else if ("chrome".equals(browser)) {
    			capabilities = DesiredCapabilities.chrome();
    			capabilities.setCapability("version", version);
    			capabilities.setCapability("platform", platform);
    			
    		} else if ("ie".equals(browser)) {
    			capabilities = DesiredCapabilities.internetExplorer();
    			capabilities.setCapability("version", version);
    			capabilities.setCapability("platform", platform);
    			
    		       	    		
    		} else {
    			throw new Error ("Unsupported browser: "+ browser);
    		}
        	
			this.driver = new RemoteWebDriver(
	                new URL("http://makarkina:a1d4cfc1-426c-4ec6-94e0-c5a262b4c95e@ondemand.saucelabs.com:80/wd/hub"),
	                capabilities);
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
	        driver.quit();
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