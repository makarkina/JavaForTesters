package com.tests.fw;

import org.openqa.selenium.By;

public class NavigationHelper extends HelperBase {

		public NavigationHelper(AppManager manager) {
			super(manager);
		}

		public void mainPage() {
			if (! onMainPage()){
			click(By.linkText("home"));
			}
		}

		private boolean onMainPage() {
			return driver.findElements(By.id("maintable")).size() > 0;
		}

		public void groupsPage() {
			if (! onGroupsPage()){
			click(By.linkText("groups"));
			}
		}

		private boolean onGroupsPage() {
			if(driver.getCurrentUrl().contains("/group.php")
			&& driver.findElements(By.name("new")).size() > 0) {
				return true;
			}
			else{
				return false;
			}
			
		}

		public void returnToMainPage() {
			click(By.linkText("home page"));
		}
}

