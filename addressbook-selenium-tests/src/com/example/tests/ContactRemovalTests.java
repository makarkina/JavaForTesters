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
		
		/*for (int i = oldList.size() - 1; i >= 1; i--) {
			int index = i;
			appl.getContactHelper().deleteContact(index);
		}*/
		
		Random rnd = new Random(); 
		int index = rnd.nextInt(oldList.size()-1);
				  
		//actions 
		appl.getContactHelper().deleteContact(index);
		 
		// compare states 
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
