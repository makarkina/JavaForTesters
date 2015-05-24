package com.tests.logic1;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.tests.logic.RideHelper;
import com.tests.model.Ride;

public class RideHelper1 extends HelperBase implements RideHelper{
	
	private long diff;

	public RideHelper1(ApplicationManager1 manager) {
		super(manager);
	}

	@Override
	public void fillOutRideForm(Ride ride) {
		click(By.linkText("Get A Ride"));
		manager.getNavigationHelper().sleep(10);
		//Checking if a ride was created or expired
		if (isElementPresent(By.id("cancel_ride"))){
			click(By.id("cancel_ride"));
			manager.getNavigationHelper().sleep(10);
			manager.getNavigationHelper().waitElementVisible(By.id("confirm_ride"));
			click(By.id("confirm_ride"));
			manager.getNavigationHelper().sleep(10);
			manager.getNavigationHelper().waitPage(By.id("ride_details"));
		} else if (isElementPresent(By.id("confirm_ride"))){
			click(By.id("confirm_ride"));
			manager.getNavigationHelper().waitPage(By.id("ride_details"));
		}
		
		//Creating a new ride
			manager.getNavigationHelper().waitElementVisible(By.cssSelector("input#postal_code"));
			WebElement input = driver.findElement(By.cssSelector("input#postal_code"));
			((JavascriptExecutor) driver).executeScript(
	                "arguments[0].removeAttribute('readonly','readonly')",input);
	    	type(By.id("pickup"), ride.getPickup());
	    	manager.getNavigationHelper().sleep(10);
			type(By.id("postal_code"), ride.getZipCode());
			manager.getNavigationHelper().sleep(10);
			type(By.id("destination"), ride.getDestination());
		new Select(driver.findElement(By.id("price"))).selectByVisibleText("$ 10.00");
		new Select(driver.findElement(By.id("num_of_pass"))).selectByVisibleText("2");			
	}
	
	@Override
	public void	submitRideCreation(){
		click(By.id("ride_details"));
		manager.getNavigationHelper().waitElementVisible(By.id("cancel_ride"));
		manager.getNavigationHelper().sleep(10);
	}
	
	@Override
	public long getTimeInfo() {
		List <Date> timeForRide = new ArrayList <Date>();
		List <WebElement> ridesInfo = driver.findElements(By.xpath("//tbody//td[2]/label"));
			int i = 1;
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		for (WebElement rideInfo : ridesInfo) {
			manager.getNavigationHelper().waitElementVisible(By.xpath("//tbody/tr["+i+"]/td[2]/label"));
			String info = driver.findElement(By.xpath("//tbody/tr["+i+"]/td[2]/label")).getText();
			System.out.println(info);
			if(info.contains(":")){
				try {
					Date time = dateFormat.parse(info);
					timeForRide.add(time);
					System.out.println("time " + time);
					System.out.println("timeForRide " + timeForRide.add(time));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
			i++;
		}
		
		System.out.println("size " + timeForRide.size());
		System.out.println(timeForRide.get(2));
		System.out.println(timeForRide.get(0));
		diff = getDateDiff(timeForRide.get(2), timeForRide.get(0));
		
		System.out.println("diff " + diff);
		System.out.println("//----------------------");
		return diff;
	}
	
	public static long getDateDiff(Date date1, Date date2) {
	    long diffInMillies = date2.getTime() - date1.getTime();
	    return diffInMillies/1000;
	}
		
	public void loginAs(Ride ride) {
		type(By.id("login-username"), ride.user.getUserName());
		type(By.id("login-password"), ride.user.getPassword());
		click(By.id("btn-login"));
	}
	
}

