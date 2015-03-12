package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.ListOf;
import com.example.utils.SortedListOf;

public class ContactModificationTests extends TestBase{

		@Test(dataProvider = "randomValidContactGenerator")
		public void modifySomeContact(ContactData contact){
					
			// save old state
			ListOf<ContactData> oldList = appl.getContactHelper().getContacts();
						
			Random rnd = new Random();
			int index = rnd.nextInt(oldList.size()-1);
						
			//actions
			appl.getContactHelper().modifyContact(index, contact);
						
			// save new state
			ListOf<ContactData> newList = appl.getContactHelper().getContacts();
			SortedListOf<ContactData> newSortedList = new SortedListOf<ContactData>(newList);
			SortedListOf<ContactData> oldSortedList = new SortedListOf<ContactData>(oldList.without(index).withAdded(contact));
			
		    // compare states	      
			assertThat(newSortedList, equalTo(oldSortedList));
		}
	
}
