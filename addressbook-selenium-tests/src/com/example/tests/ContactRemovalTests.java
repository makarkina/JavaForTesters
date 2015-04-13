package com.example.tests;

import static com.example.tests.ContactDataGenerator.loadContactsFromXmlFile;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.example.utils.ListOf;
import com.example.utils.SortedListOf;

public class ContactRemovalTests extends TestBase {
	
	@DataProvider
	public Iterator<Object[]> contactsFromFile() throws IOException {
		return wrapContactsForDataProvider(
				loadContactsFromXmlFile(new File("contacts.xml"))).iterator();
	}

	@Test(dataProvider = "contactsFromFile")
	public void testContactDeletionWithValidData(ContactData contact)
			throws Exception {

		// save old state
		List<ContactData> oldList = appl.getModel().getContacts();
		System.out.println("old " + oldList.size());
		System.out.println("model  " + oldList);
		System.out.println("DB " + appl.getHibernateHelper().listContacts());
		System.out.println("GUI " + appl.getContactHelper().getUIContacts());
		/*for (int i = oldList.size() - 1; i >= 1; i--) {
			int index = i;
			appl.getContactHelper().deleteContact(index);
		}*/
		
		/*Random rnd = new Random(); 
		int index = rnd.nextInt(oldList.size()-1);
		//int index = 1;
		  
		//actions 
		appl.getContactHelper().deleteContact(index);
		 
		// save new state 
		//List<ContactData> newList = appl.getModel().getContacts(); 
		//System.out.println("new " + newList.size());
		//System.out.println("model  " + newList);
		
		 //SortedListOf<ContactData> oldSortedList = new
		 //SortedListOf<ContactData>(oldList.without(index));
		 
		// compare states 
		System.out.println(index);
		//SortedListOf<ContactData> newSortedList = new SortedListOf<ContactData>(newList);
		//System.out.println("newSortedList " + newSortedList);
		System.out.println("model1 " + appl.getModel().getContacts());
		System.out.println("DB1 " + appl.getHibernateHelper().listContacts());
		System.out.println("GUI1 " + appl.getContactHelper().getUIContacts());
		
		//assertThat(newList, equalTo(appl.getHibernateHelper().listContacts()));
		assertThat(appl.getModel().getContacts(), equalTo(appl.getHibernateHelper().listContacts()));
		assertThat(appl.getModel().getContacts(), equalTo(appl.getContactHelper().getUIContacts()));*/
		 
	}

}
