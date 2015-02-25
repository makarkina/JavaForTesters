package com.example.tests;

import org.testng.annotations.Test;

	public class GroupCreationTests extends TestBase{

	  @Test
	  public void testNonEmptyGroupCreation() throws Exception {
		appl.getNavigationHelper().openMainPage();
		appl.getNavigationHelper().gotoGroupPage();
		appl.getGroupHelper().initGroupCreation();
	    GroupData group = new GroupData(); 
	    group.name = "group name1";
	    group.header = "header 1";
	    group.footer = "footer 1";
	    appl.getGroupHelper().fillGroupForm(group);
	    appl.getGroupHelper().submitGroupCreation();
	    appl.getGroupHelper().returnToGroupsPage();
	  }
	  
	  @Test
	  public void testEmptyGroupCreation() throws Exception {
		appl.getNavigationHelper().openMainPage();
		appl.getNavigationHelper().gotoGroupPage();
		appl.getGroupHelper().initGroupCreation();
		appl.getGroupHelper().fillGroupForm(new GroupData("", "", ""));
		appl.getGroupHelper().submitGroupCreation();
		appl.getGroupHelper().returnToGroupsPage();
	  }
	  
	}


