package com.example.tests;

import static org.testng.Assert.assertEquals;
import java.util.Collections;
import java.util.List;
import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase{
@Test(dataProvider = "randomValidContactGenerator")
  
public void testContactCreationWithValidData(ContactData contact) throws Exception{
	
	appl.getNavigationHelper().openMainPage();
	// save old state
	List<ContactData> oldList = appl.getContactHelper().getContacts();	
	//System.out.print("old list1 " + oldList);
	 
    appl.getContactHelper().gotoContactPage();
	appl.getContactHelper().filloutContactForm(contact);
    appl.getContactHelper().submitContactCreation();
    appl.getNavigationHelper().returnToMainPage();
    
    // save new state
    List<ContactData> newList = appl.getContactHelper().getContacts();
    Collections.sort(newList);
    
    // compare states      
    oldList.add(contact);
    Collections.sort(oldList);
    assertEquals(newList, oldList);
    
  }
  
}

