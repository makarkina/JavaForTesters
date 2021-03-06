package com.example.tests;

//import static com.example.tests.ContactDataGenerator.loadContactsFromCsvFile;
import static com.example.tests.ContactDataGenerator.loadContactsFromXmlFile;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.hamcrest.Matcher;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class ContactCreationTests extends TestBase {

	@DataProvider
	public Iterator<Object[]> contactsFromFile() throws IOException {
		return wrapContactsForDataProvider(
				loadContactsFromXmlFile(new File("contacts.xml"))).iterator();
	}

	@Test(dataProvider = "contactsFromFile")
	public void testContactCreationWithValidData(ContactData contact)
			throws Exception {
		
		appl.getContactHelper().createContact(contact);
		
		if (wantToCheck()){
			if("yes".equals(appl.getProperty("check.db"))){
				assertThat(appl.getModel().getContacts(), equalTo(appl.getHibernateHelper().listContacts()));
			}
			if("yes".equals(appl.getProperty("check.ui"))){
				assertThat(appl.getModel().getContacts(), equalTo(appl.getContactHelper().getUIContacts()));
			}
		}
			
	}

	

	
		
}


