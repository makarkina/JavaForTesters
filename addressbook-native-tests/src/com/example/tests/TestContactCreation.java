package com.example.tests;

import static com.example.tests.ContactDataGenerator.loadContactsFromCsvFile;
import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.example.fw.Contact;

public class TestContactCreation extends TestBase {
	
	private static int cnt = 0;
	
	@DataProvider
	public Iterator<Object[]> contactsFromFile() throws IOException {
		return wrapContactsForDataProvider(loadContactsFromCsvFile(new File("contacts.txt"))).iterator();
	}

	@Test(dataProvider = "contactsFromFile")
	public void ShouldCreateContactWithValidData(Contact contact) throws Exception {
		
		//saving old state
		List<Contact> oldList = appl.getContactHelper().getContacts(new File("new.csv"), cnt++);
		
		//action: creating contacts
		appl.getContactHelper().createContact(contact);
		
		//saving new state
		List<Contact> newList = appl.getContactHelper().getContacts(new File("new.csv"), cnt++);
		Collections.sort(newList);
		
		//comparing states
		oldList.add(contact);		
		Collections.sort(oldList);
	    assertEquals(newList, oldList);
	    
	}

}
