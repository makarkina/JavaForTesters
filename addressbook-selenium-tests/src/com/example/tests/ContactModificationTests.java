package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase{

		@Test
		public void modifySomeContact(){
			appl.getNavigationHelper().openMainPage();
						
			// save old state
			List<ContactData> oldList = appl.getContactHelper().getContacts();
			
			//actions
			appl.getContactHelper().initContactModification(1);
			ContactData contact = new ContactData();
			//contact.addressPrime = "new Address 1";
			//contact.homePhone = "new phone";
			contact.firstName = "New First Name";
		    contact.lastName = "New Last Name";
			contact.firstAndLastName = contact.firstName + " " + contact.lastName;
			appl.getContactHelper().filloutContactForm(contact);
			appl.getContactHelper().submitContactModification();
			appl.getNavigationHelper().returnToMainPage();
			
			// save new state
		    List<ContactData> newList = appl.getContactHelper().getContacts();
		    Collections.sort(newList);
		    	    
		    // compare states	      
		    oldList.remove(1);
		    oldList.add(contact);
		    Collections.sort(oldList);
		    assertEquals(newList, oldList);
		}

	
}
