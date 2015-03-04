package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase{
	
  @Test
  public void testNonEmptyContact() throws Exception {
	appl.getNavigationHelper().openMainPage();
	// save old state
	List<ContactData> oldList = appl.getContactHelper().getContacts();
	
	appl.getContactHelper().gotoContactPage();
	ContactData contact = new ContactData();
    contact.firstName = "Fname 1";
    contact.lastName = "Lname 1";
    contact.addressPrime = "Address 1";
    contact.homePhone = "111-2222";
    contact.cellPhone = "333-4444";
    contact.workPhone = "555-6666";
    contact.emailPrime = "email1@gmail.com";
    contact.emailSecond = "email2@gmail.com";
    contact.birthDay = "1";
    contact.birthMonth = "March";
    contact.birthYear = "1999";
    contact.addressSec = "Address 2";
    contact.phoneAdd = "777-8888";
    contact.firstAndLastName = contact.firstName + " " + contact.lastName;
    
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

  
  @Test
  public void testEmptyContact() throws Exception {
	appl.getNavigationHelper().openMainPage();
	// save old state
	List<ContactData> oldList = appl.getContactHelper().getContacts();
	
	//actions
	appl.getContactHelper().gotoContactPage();
	ContactData contact = new ContactData();
	contact.firstName = "";
    contact.lastName = "";
    contact.addressPrime = "";
    contact.homePhone = "";
    contact.cellPhone = "";
    contact.workPhone = "";
    contact.emailPrime = "";
    contact.emailSecond = "";
    contact.birthDay = "-";
    contact.birthMonth = "-";
    contact.birthYear = "";
    contact.addressSec = "";
    contact.phoneAdd = "";
    contact.firstAndLastName = contact.firstName + " " + contact.lastName;
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

