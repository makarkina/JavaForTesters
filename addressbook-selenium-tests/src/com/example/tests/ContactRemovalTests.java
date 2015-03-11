package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class ContactRemovalTests extends TestBase {
	
	@Test
	public void deleteSomeContact(){
		appl.getNavigationHelper().openMainPage();
		// save old state
		List<ContactData> oldList = appl.getContactHelper().getContacts();
		
		Random rnd = new Random();
		int index = rnd.nextInt(oldList.size()-1);
		
		//actions
		appl.getContactHelper().editContactByIndex(index);
		appl.getContactHelper().submitContactDeletion();
		appl.getNavigationHelper().returnToMainPage();
		appl.getContactHelper().rebuildCache();
		
		// save new state
	    List<ContactData> newList = appl.getContactHelper().getContacts();
	    Collections.sort(newList);
	    
	    // compare states	      
	    oldList.remove(index);
	    Collections.sort(oldList);
	    assertEquals(newList, oldList);
	}

}
