package com.example.tests;
import static org.testng.Assert.assertEquals;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class GroupModificationTests extends TestBase {
	
	@Test(dataProvider = "randomValidGroupGenerator")
		public void modifySomeGroup(GroupData group) {
					
			// save old state
			List<GroupData> oldList = appl.getGroupHelper().getGroups();
			
			Random rnd = new Random();
			int index = rnd.nextInt(oldList.size()-1);
			
			// actions  
			appl.getGroupHelper().modifyGroup(index, group);
			
			// save new state
		    List<GroupData> newList = appl.getGroupHelper().getGroups();
		    	    
		    // compare states	      
		    oldList.remove(index);
		    oldList.add(group);
		    Collections.sort(oldList);
		    assertEquals(newList, oldList);
		}
	}