package com.tests.logic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public interface NavigationHelper {
	void openMainPage();
	boolean onMainPage();
	void mainPage();
	void openLoginPage(String url);
	void gotoUserProfilePage();
	void openRelativeUrl(String url);
	void sleep(int time);
	WebElement waitElementVisible(By linkText);
	void submitLogIn();
	void waitPage(By xpath);
	String getLogUser();
}
