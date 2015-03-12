package com.example.tests;

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
			 
    appl.getContactHelper().createContact(contact);
    
    // save new state
    ListOf<ContactData> newList = appl.getContactHelper().getContacts();
    SortedListOf<ContactData> newSortedList = new SortedListOf<ContactData>(newList);
    SortedListOf<ContactData> oldSortedList = new SortedListOf<ContactData>(oldList.withAdded(contact));
    
    // compare states      
    assertThat(newSortedList, equalTo(oldSortedList));
  }
  
}

