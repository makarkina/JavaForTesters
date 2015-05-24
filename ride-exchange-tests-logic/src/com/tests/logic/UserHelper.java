package com.tests.logic;

import com.tests.model.User;

public interface UserHelper {
	
	//LogIn & LogOut
	void loginAs(User user);
	void logOut();
	boolean isLoggedIn();
	boolean isLoggedInAs(User user);
	boolean isNotLoggedIn();
	//void submitLogIn();
	
	//AccountCreation&Edition
	void submitAccountCreation();
	void fillOutForm(User user);
	void FormEdition();
	void fillOutFormFailed(User user);
	void FormEditionFailed();
	
}
