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
		
		List<ContactData> oldList = appl.getModel().getContacts();
		//System.out.println("old " + oldList.size());
		System.out.println("model  " + oldList);
		System.out.println("DB " + appl.getHibernateHelper().listContacts());
		System.out.println("GUI " + appl.getContactHelper().getUIContacts());

		appl.getContactHelper().createContact(contact);
		
		System.out.println("model1 " + appl.getModel().getContacts());
		System.out.println("DB1 " + appl.getHibernateHelper().listContacts());
		System.out.println("GUI1 " + appl.getContactHelper().getUIContacts());
					
		assertThat(appl.getModel().getContacts(), equalTo(appl.getHibernateHelper().listContacts()));
		assertThat(appl.getModel().getContacts(), equalTo(appl.getContactHelper().getUIContacts()));
	}

	

	
		
}


