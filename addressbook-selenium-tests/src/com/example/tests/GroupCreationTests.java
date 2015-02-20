package com.example.tests;

import org.testng.annotations.Test;

	public class GroupCreationTests extends TestBase{

	  @Test
	  public void testNonEmptyGroupCreation() throws Exception {
		openMainPage();
	    gotoGroupPage();
	    initGroupCreation();
	    GroupData group = new GroupData(); 
	    group.name = "group name1";
	    group.header = "header 1";
	    group.footer = "footer 1";
		fillGroupForm(group);
	    submitGroupCreation();
	    returnToGroupsPage();
	  }
	  
	  @Test
	  public void testEmptyGroupCreation() throws Exception {
		openMainPage();
	    gotoGroupPage();
	    initGroupCreation();
	    fillGroupForm(new GroupData("", "", ""));
	    submitGroupCreation();
	    returnToGroupsPage();
	  }
	  
	}


