package com.example2.tests;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.ListOf;
import com.example.utils.SortedListOf;

public class ContactRemovalTests extends TestBase {
	
	@Test
	public void deleteSomeContact(){
		
		// save old state
		ListOf<ContactData> oldList = appl.getContactHelper().getContacts();
				
		Random rnd = new Random();
		int index = rnd.nextInt(oldList.size()-1);
		
		//actions
		appl.getContactHelper().deleteContact(index);
		ListOf<ContactData> printedList = appl.getContactHelper().getPrintedContacts();
	    appl.getContactHelper().returnToMainPageFromPrintedPhones();
	    
		// save new state
		SortedListOf<ContactData> printedSortedList = new SortedListOf<ContactData>(printedList);
		SortedListOf<ContactData> oldSortedList = new SortedListOf<ContactData>(oldList.without(index));
		
	    // compare states	
		System.out.println(index);
		assertThat(printedSortedList, equalTo(oldSortedList));
	}
}

