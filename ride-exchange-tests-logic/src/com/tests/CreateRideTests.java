package com.tests;

import static com.tests.logic1.RideDataGenerator.loadCreateRideFromCsvFile;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tests.logic1.ApplicationManager1;
import com.tests.model.Ride;

public class CreateRideTests extends TestBase{
	
	//@BeforeMethod
	public void mayBeLogOut() {
		 if (app.getUserHelper().isLoggedIn()) {
			 app.getUserHelper().logOut();
		 } 
	}
	
	/*@DataProvider
	public Iterator<Object[]> rideCreationFromFile() throws IOException {
		return wrapRidesForDataProvider(loadCreateRideFromCsvFile(new File("rideCreation.txt"))).iterator();
	}
    
	@Test(dataProvider = "rideCreationFromFile")
	  public void testRideCreation(Ride ride) throws Exception {
		/*Ride ride = new User();
	    user.setUserName("anna.makarkina@mail.ru");
	    user.setPassword("Mimino66");*/
		//app.getRideHelper().loginAs(ride);
		//app.getNavigationHelper().submitLogIn();
		//assertTrue(app.getUserHelper().isLoggedInAs(user));
		/*Ride ride = new Ride();
		ride.setPickup("250 Knotter Drive, Cheshire, CT, United States");
		ride.setZipCode("06410");
		ride.setDestination("301 Peck Lane, Cheshire, CT, United States");*/
		/*app.getRideHelper().fillOutRideForm(ride);
		//app.getRideHelper().submitRideCreation();
		//app.getRideHelper().getTimeInfo();
		//app.getRideHelper().getDateDiff();
		
	  }*/
	
	//@Test
	public void testRide3Creation() throws Exception {
	   	Properties properties = new Properties();
    	String configFile = System.getProperty("configFile",
				"applicationFireFox.properties");
    	properties.load(new FileReader(new File(configFile)));
    	app = new ApplicationManager1(properties);
    	app.getNavigationHelper().openLoginPage(properties.getProperty("baseUrl"));
    	
    	Ride ride = new Ride();
	    ride.user.setUserName("makarkina2669@gmail.com");
	    ride.user.setPassword("Ganna2669");
	    app.getRideHelper().loginAs(ride);
		app.getNavigationHelper().submitLogIn();
		
		ride.setPickup("28 Warren Street, Cheshire, CT, United States");
		ride.setZipCode("06410");
		ride.setDestination("5th Avenue, NY, United States");
	    app.getRideHelper().fillOutRideForm(ride);
		app.getRideHelper().submitRideCreation();
		app.getRideHelper().getTimeInfo();
		//app.getUserHelper().logOut();
		app.stop();
	}	
	
	@Test
		public void testRide2Creation() throws Exception {
		   	Properties properties = new Properties();
	    	String configFile = System.getProperty("configFile",
					"applicationIE.properties");
	    	properties.load(new FileReader(new File(configFile)));
	    	app = new ApplicationManager1(properties);
	    	app.getNavigationHelper().openLoginPage(properties.getProperty("baseUrl"));
	    	
	    	Ride ride = new Ride();
		    ride.user.setUserName("ganna.makarkina@yahoo.com");
		    ride.user.setPassword("Welcome1");
		    app.getRideHelper().loginAs(ride);
			app.getNavigationHelper().submitLogIn();
			
			ride.setPickup("275 Highland Avenue, Cheshire, CT, United States");
			ride.setZipCode("06410");
			ride.setDestination("45 Murphy Road, Prospect, CT, United States");
		    app.getRideHelper().fillOutRideForm(ride);
			app.getRideHelper().submitRideCreation();
			app.getRideHelper().getTimeInfo();
			//app.getUserHelper().logOut();
			app.stop();
		}	
	
	//@Test
	public void testRide1Creation() throws Exception {
		   	Properties properties = new Properties();
	    	String configFile = System.getProperty("configFile",
					"applicationChrome.properties");
	    	properties.load(new FileReader(new File(configFile)));
	    	app = new ApplicationManager1(properties);
	    	app.getNavigationHelper().openLoginPage(properties.getProperty("baseUrl"));
	    	
	    	Ride ride = new Ride();
		    ride.user.setUserName("anna.makarkina@mail.ru");
		    ride.user.setPassword("Mimino66");
		    app.getRideHelper().loginAs(ride);
			app.getNavigationHelper().submitLogIn();
			
			ride.setPickup("250 Knotter Drive, Cheshire, CT, United States");
			ride.setZipCode("06410");
			ride.setDestination("301 Peck Lane, Cheshire, CT, United States");
		    app.getRideHelper().fillOutRideForm(ride);
			app.getRideHelper().submitRideCreation();
			app.getRideHelper().getTimeInfo();
			//app.getUserHelper().logOut();
			app.stop();
					
	   	}	
	
}
