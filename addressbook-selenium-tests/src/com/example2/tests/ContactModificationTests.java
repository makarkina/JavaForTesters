package com.example2.tests;

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
			ListOf<ContactData> printedList = appl.getContactHelper().getPrintedContacts();
		    appl.getContactHelper().returnToMainPageFromPrintedPhones();
						
			// save new state
		    SortedListOf<ContactData> printedSortedList = new SortedListOf<ContactData>(printedList);
			SortedListOf<ContactData> oldSortedList = new SortedListOf<ContactData>(oldList.without(index).withAdded(contact));
			
		    // compare states	      
			assertThat(printedSortedList, equalTo(oldSortedList));
		}
	
}
