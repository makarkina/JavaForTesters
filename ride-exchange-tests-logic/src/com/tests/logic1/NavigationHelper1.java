package com.tests.logic1;

import org.openqa.selenium.By;

import com.tests.logic.NavigationHelper;

public class NavigationHelper1 extends HelperBase implements NavigationHelper {

		public NavigationHelper1(ApplicationManager1 manager) {
			super(manager);
		}

		@Override
		public void mainPage() {
			if (! onMainPage()){
			click(By.linkText("Home"));
			}
		}

		@Override
		public boolean onMainPage() {
			return driver.findElements(By.id("btn-login")).size() > 0;
		}

		@Override
		public void openMainPage() {
			driver.findElement(By.linkText("Welcome, anna.makarkina")).click();
		}
		
		@Override
		public void openLoginPage(String url) {
			driver.get(url);
		
		}
		
		@Override
		public void gotoUserProfilePage() {
		    openRelativeUrl("http://myridexch.com/profile.php");
		}

		
		@Override
		public void openRelativeUrl(String url) {
		    driver.get(url);
		}

		
}

