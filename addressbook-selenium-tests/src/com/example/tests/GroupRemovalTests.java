package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class GroupRemovalTests extends TestBase{

@Test
	public void deleteSomeGroup(){
		appl.getNavigationHelper().openMainPage();
		appl.getNavigationHelper().gotoGroupPage();
		
		// save old state
		List<GroupData> oldList = appl.getGroupHelper().getGroups();
		
		// actions 
		appl.getGroupHelper().deleteGroup(0);
		appl.getGroupHelper().returnToGroupsPage();
		
		// save new state
	    List<GroupData> newList = appl.getGroupHelper().getGroups();
	    
	    // compare states
	    oldList.remove(0);
	    Collections.sort(oldList);
	    assertEquals(newList, oldList);
	}
}
