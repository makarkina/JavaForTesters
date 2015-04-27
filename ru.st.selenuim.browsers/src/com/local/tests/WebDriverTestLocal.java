package com.local.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import org.testng.annotations.Test;

public class WebDriverTestLocal extends TestBase {
	    	
      @Test(dataProvider = "randomValidGroupGenerator")
  		public void testGroupCreationWithValidData(GroupData group) throws Exception {
	
    	app.navigateTo().mainPage();
    	app.navigateTo().groupsPage();
	
    	// save old state
    	List<GroupData> oldList = app.getGroupHelper().getGroups();
	
    	// actions
    	app.getGroupHelper().createGroup(group);
		    
    	// save new state
    	List<GroupData> newList = app.getGroupHelper().getGroups();
    	    
    	// compare states	      
    	oldList.add(group);
    	Collections.sort(oldList);
    	assertEquals(newList, oldList);
      }
 
}