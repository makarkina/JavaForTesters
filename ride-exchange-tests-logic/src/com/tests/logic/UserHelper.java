package com.tests.logic;

import com.tests.model.User;

public interface UserHelper {
	
	void loginAs(User user);
	void logOut();
	boolean isLoggedIn();
	boolean isLoggedInAs(User user);
	boolean isNotLoggedIn();
	void submitLogIn();
	
			
}
