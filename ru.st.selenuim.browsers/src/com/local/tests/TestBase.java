package com.local.tests;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.tests.fw.AppManager;

public class TestBase {

	static protected AppManager app;
				
	@BeforeTest
    public void setUp() throws Exception {
    	Properties properties = new Properties();
    	String configFile = System.getProperty("configFile",
				"applicationFireFox.properties");
    	properties.load(new FileReader(new File(configFile)));
    	app = new AppManager(properties);
	}	
    		
	@AfterTest
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