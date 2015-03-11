package com.example.fw;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.example.tests.GroupData;

public class GroupHelper extends HelperBase{
	
	public GroupHelper(ApplicationManager manager) {
		super(manager);
	}
	
	private List<GroupData> cachedGroups;
	
	public List<GroupData> getGroups() {
	if (cachedGroups == null){
		rebuildCache();
	}
		return new ArrayList<GroupData>(cachedGroups);
	
	}

	public void rebuildCache() {
		cachedGroups = new ArrayList<GroupData>();
		List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
		for (WebElement checkbox : checkboxes) {
			GroupData group = new GroupData();
			String title = checkbox.getAttribute("title");
			group.name = title.substring("Select (".length(), title.length() - ")".length());
			cachedGroups.add(group);
		}
	}

	public void initGroupCreation() {
		click(By.name("new"));
	  }

	public void submitGroupCreation() {
		click(By.name("submit"));
		cachedGroups = null;
	  }

	public void fillGroupForm(GroupData group) {
		type(By.name("group_name"), group.name);
		type(By.name("group_header"), group.header);
		type(By.name("group_footer"), group.footer);
	}
	
	public void returnToGroupsPage() {
		click(By.linkText("group page"));
	  }

	public void selectGroupByIndex(int index) {
		click(By.xpath("//input[@name='selected[]'][" + (index+1) + "]"));
	}
	
	public void submitGroupDeletion() {
		click(By.name("delete"));
		cachedGroups = null;
	}

	public void initGroupModification(int index) {
		selectGroupByIndex(index);
		click(By.name("edit"));
	}

	public void submitGroupModification() {
		click(By.name("update"));
		cachedGroups = null;
	}
	
}
