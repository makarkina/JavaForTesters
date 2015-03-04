package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class ContactRemovalTests extends TestBase {
	
	@Test
	public void deleteSomeContact(){
		appl.getNavigationHelper().openMainPage();
		// save old state
		List<ContactData> oldList = appl.getContactHelper().getContacts();
		
		//actions
		appl.getContactHelper().deleteContact(1);
		appl.getNavigationHelper().returnToMainPage();
		
		// save new state
	    List<ContactData> newList = appl.getContactHelper().getContacts();
	    Collections.sort(newList);
	    	    
	    // compare states	      
	    oldList.remove(1);
	    Collections.sort(oldList);
	    assertEquals(newList, oldList);
	}

}
