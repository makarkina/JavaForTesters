package com.tests.logic;

public interface NavigationHelper {
	void openMainPage();
	boolean onMainPage();
	void mainPage();
	void openLoginPage(String url);
	void gotoUserProfilePage();
	void openRelativeUrl(String url);
}
