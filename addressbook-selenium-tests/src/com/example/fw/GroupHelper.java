package com.example.fw;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.example.tests.GroupData;
import com.example.utils.SortedListOf;


public class GroupHelper extends HelperBase{
	
	public GroupHelper(ApplicationManager manager) {
		super(manager);
	}
	private SortedListOf<GroupData> cachedGroups;
	
	public SortedListOf<GroupData> getGroups() {
		if (cachedGroups == null){
			rebuildCach();
		}
		return cachedGroups;
	}
	
	private void rebuildCach() {
			cachedGroups = new SortedListOf<GroupData>();
			
			manager.navigateTo().groupsPage();
			List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
			for (WebElement checkbox : checkboxes) {
				String title = checkbox.getAttribute("title");
				String name = title.substring("Select (".length(), title.length() - ")".length());
				cachedGroups.add(new GroupData().withName(name));
		}
	}
	
	public GroupHelper createGroup(GroupData group) {
		manager.navigateTo().groupsPage();
		waitPage();
		initGroupCreation();
		fillGroupForm(group);
		submitGroupCreation();
    	returnToGroupsPage();
    	rebuildCach();
    	return this;
	}
		
	public GroupHelper modifyGroup(int index, GroupData group) {
		initGroupModification(index);
		fillGroupForm(group);
		submitGroupModification();
		returnToGroupsPage();
		rebuildCach();
		return this;
	}
	
	public GroupHelper deleteGroup(int index) {
		selectGroupByIndex(index);
		submitGroupDeletion();
		returnToGroupsPage();
		rebuildCach();
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
		cachedGroups = null;
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

	public GroupHelper initGroupModification(int index) {
		selectGroupByIndex(index);
		click(By.name("edit"));
		return this;
	}
	
	public GroupHelper selectGroupByIndex(int index) {
		click(By.xpath("//input[@name='selected[]'][" + (index+1) + "]"));
		return this;
	}

	public GroupHelper submitGroupModification() {
		click(By.name("update"));
		cachedGroups = null;
		return this;
	}

	public GroupHelper submitGroupDeletion() {
		click(By.name("delete"));
		cachedGroups = null;
		return this;
	}

	private void waitPage() {
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
					.withMessage("Element was not found").withTimeout(20, TimeUnit.SECONDS)
					.pollingEvery(1, TimeUnit.SECONDS);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.name("delete")));
		}
		
	}


