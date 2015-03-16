package com.example2.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import org.testng.annotations.Test;
import com.example.utils.ListOf;
import com.example.utils.SortedListOf;

	public class ContactCreationTests extends TestBase{
		@Test(dataProvider = "randomValidContactGenerator")
		public void testContactCreationWithValidData(ContactData contact) throws Exception{
	
			// save old state
			ListOf<ContactData> oldList = appl.getContactHelper().getContacts();
		
			//actions
			appl.getContactHelper().createContact(contact);
			ListOf<ContactData> printedList = appl.getContactHelper().getPrintedContacts();
			appl.getContactHelper().returnToMainPageFromPrintedPhones();
        
			// save new state
			SortedListOf<ContactData> printedSortedList = new SortedListOf<ContactData>(printedList);
			SortedListOf<ContactData> oldSortedList = new SortedListOf<ContactData>(oldList.withAdded(contact));
        
			// compare states
			assertThat(printedSortedList, equalTo(oldSortedList));
		}
  
}

