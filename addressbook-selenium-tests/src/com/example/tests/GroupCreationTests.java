package com.example.tests;

import java.util.Collections;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

	public class GroupCreationTests extends TestBase{

	  @Test
	  public void testNonEmptyGroupCreation() throws Exception {
		appl.getNavigationHelper().openMainPage();
		appl.getNavigationHelper().gotoGroupPage();
		
		// save old state
		List<GroupData> oldList = appl.getGroupHelper().getGroups();
				
		// actions
		appl.getGroupHelper().initGroupCreation();
	    GroupData group = new GroupData(); 
	    group.name = "group name1";
	    group.header = "header 1";
	    group.footer = "footer 1";
	    appl.getGroupHelper().fillGroupForm(group);
	    appl.getGroupHelper().submitGroupCreation();
	    appl.getGroupHelper().returnToGroupsPage();
	    
	    // save new state
	    List<GroupData> newList = appl.getGroupHelper().getGroups();
	    	    
	    // compare states	      
	    oldList.add(group);
	    Collections.sort(oldList);
	    assertEquals(newList.size(), oldList.size());
	  }
	  
	  @Test
	  public void testEmptyGroupCreation() throws Exception {
		appl.getNavigationHelper().openMainPage();
		appl.getNavigationHelper().gotoGroupPage();
		// save old state
		List<GroupData> oldList = appl.getGroupHelper().getGroups();
						
		// actions
		GroupData group = new GroupData("", "", "");
		appl.getGroupHelper().initGroupCreation();
		appl.getGroupHelper().fillGroupForm(group);
		appl.getGroupHelper().submitGroupCreation();
		appl.getGroupHelper().returnToGroupsPage();
		
		// save new state
	    List<GroupData> newList = appl.getGroupHelper().getGroups();
	    	    
	    // compare states	      
	    oldList.add(group);
	    Collections.sort(oldList);
	    assertEquals(newList.size(), oldList.size());
	  }
	  
	}


