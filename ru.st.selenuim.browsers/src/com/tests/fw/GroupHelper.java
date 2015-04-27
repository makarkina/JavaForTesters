package com.tests.fw;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.local.tests.GroupData;

public class GroupHelper extends HelperBase{
	
	public GroupHelper(AppManager manager) {
		super(manager);
	}
	
	public List<GroupData> getGroups() {
		List<GroupData> groups = new ArrayList<GroupData>();
		manager.navigateTo().groupsPage();
		List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
		
		for (WebElement checkbox : checkboxes) {
			String title = checkbox.getAttribute("title");
			String name = title.substring("Select (".length(), title.length() - ")".length());
			groups.add(new GroupData().withName(name));
		}
		return groups;
	}

	public GroupHelper createGroup(GroupData group) throws InterruptedException {
		manager.navigateTo().groupsPage();
		waitGroupListPage();
		initGroupCreation();
		fillGroupForm(group);
		waitGroupCreationPage();
		submitGroupCreation();
		returnToGroupsPage();
    	return this;
	}
	
	//------------------------------------------------------------------------------------------
	
	public GroupHelper initGroupCreation() {
		manager.navigateTo().groupsPage();
		click(By.name("new"));
		return this;
	  }

	public GroupHelper submitGroupCreation() {
		click(By.name("submit"));
		return this;
	  }

	public GroupHelper fillGroupForm(GroupData group) {
		type(By.name("group_name"), group.getName());
		type(By.name("group_header"), group.getHeader());
		type(By.name("group_footer"), group.getFooter());
		return this;
	}
	
	public GroupHelper returnToGroupsPage() {
		click(By.linkText("group page"));
		return this;
	  }

	private void waitGroupListPage() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withMessage("Element was not found")
				.withTimeout(5, TimeUnit.SECONDS)
				.pollingEvery(1, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.presenceOfElementLocated(By
				.name("edit")));
	}
	
	private void waitGroupCreationPage() {
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
					.withMessage("Element was not found")
					.withTimeout(10, TimeUnit.SECONDS)
					.pollingEvery(1, TimeUnit.SECONDS);
			wait.until(ExpectedConditions.presenceOfElementLocated(By
					.name("submit")));
	}
	

}
