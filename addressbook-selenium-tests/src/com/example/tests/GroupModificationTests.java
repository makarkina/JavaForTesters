package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import java.util.Random;
import org.testng.annotations.Test;
import com.example.utils.SortedListOf;

public class GroupModificationTests extends TestBase {
	
	@Test(dataProvider = "randomValidGroupGenerator")
	public void modifySomeGroup(GroupData group) {
					
			// save old state
			SortedListOf<GroupData> oldList = appl.getGroupHelper().getGroups();
			
			Random rnd = new Random();
			int index = rnd.nextInt(oldList.size()-1);
			
			// actions  
			appl.getGroupHelper().modifyGroup(index, group);
			
			// save new state
			SortedListOf<GroupData> newList = appl.getGroupHelper().getGroups();
		    	    
		    // compare states
			assertThat(newList, equalTo(oldList.without(index).withAdded(group)));
		}
	}