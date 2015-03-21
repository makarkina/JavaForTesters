package com.example.tests;

//import static com.example.tests.ContactDataGenerator.loadContactsFromCsvFile;
import static com.example.tests.ContactDataGenerator.loadContactsFromXmlFile;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.example.utils.ListOf;
import com.example.utils.SortedListOf;

public class ContactCreationTests extends TestBase{
	
	@DataProvider
	public Iterator<Object[]> contactsFromFile() throws IOException{
		return wrapContactsForDataProvider(loadContactsFromXmlFile(new File("contacts.xml"))).iterator();
	}
	
	@Test(dataProvider = "contactsFromFile")
	public void testContactCreationWithValidData(ContactData contact) throws Exception{
	
		// save old state
		
		ListOf<ContactData> oldList = appl.getContactHelper().getContacts();
		
		//actions
		appl.getContactHelper().createContact(contact);
    
		// save new state
		ListOf<ContactData> newList = appl.getContactHelper().getContacts();
		SortedListOf<ContactData> newSortedList = new SortedListOf<ContactData>(newList);
		SortedListOf<ContactData> oldSortedList = new SortedListOf<ContactData>(oldList.withAdded(contact));
    
		// compare states      
		assertThat(newSortedList, equalTo(oldSortedList));
  }
  
}

