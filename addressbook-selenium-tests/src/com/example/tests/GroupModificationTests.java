package com.example.tests;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import java.util.Collections;
import java.util.List;

public class GroupModificationTests extends TestBase {
	
	@Test
		public void modifySomeGroup() {
		
			appl.getNavigationHelper().openMainPage();
			appl.getNavigationHelper().gotoGroupPage();
			// save old state
			List<GroupData> oldList = appl.getGroupHelper().getGroups();
		
			// actions  
			appl.getGroupHelper().initGroupModification(0);
			GroupData group = new GroupData();
			group.name = "new name";
			appl.getGroupHelper().fillGroupForm(group);
			appl.getGroupHelper().submitGroupModification();
			appl.getGroupHelper().returnToGroupsPage();
						
			// save new state
			List<GroupData> newList = appl.getGroupHelper().getGroups();
					    	    
			// compare states	      
			oldList.remove(0);
			oldList.add(group);
			Collections.sort(oldList);
			assertEquals(newList, oldList);
		}
	}

