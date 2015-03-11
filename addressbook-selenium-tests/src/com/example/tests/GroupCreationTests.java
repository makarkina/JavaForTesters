package com.example.tests;

import static org.testng.Assert.assertEquals;
import java.util.Collections;
import java.util.List;
import org.testng.annotations.Test;

	public class GroupCreationTests extends TestBase{
	
	@Test(dataProvider = "randomValidGroupGenerator")
	  	public void testGroupCreationWithValidData(GroupData group) throws Exception {
		
		appl.navigateTo().mainPage();
		appl.navigateTo().groupsPage();
		
		// save old state
		List<GroupData> oldList = appl.getGroupHelper().getGroups();
		
		// actions
		appl.getGroupHelper().createGroup(group);
			    
	    // save new state
	    List<GroupData> newList = appl.getGroupHelper().getGroups();
	    	    
	    // compare states	      
	    oldList.add(group);
	    Collections.sort(oldList);
	    assertEquals(newList, oldList);
	  }
	  
	}


