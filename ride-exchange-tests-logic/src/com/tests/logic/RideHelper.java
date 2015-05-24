package com.tests.logic;

import com.tests.model.Ride;

public interface RideHelper {
	
	void loginAs(Ride ride);
	void fillOutRideForm(Ride ride);
	void submitRideCreation();
	//void getRideInfo();
	long getTimeInfo();
	
}
