package com.tests.logic;

public interface ApplicationManager {
	UserHelper getUserHelper();
	NavigationHelper getNavigationHelper();
	RideHelper getRideHelper();
	void stop();
}
