package com.example.tests;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase{
	
  @Test
  public void testNonEmptyContact() throws Exception {
	appl.getNavigationHelper().openMainPage();
	appl.getContactHelper().gotoContactPage();
	
	
	ContactData contactInfo1 = new ContactData();
    contactInfo1.firstName = "Fname 1";
    contactInfo1.lastName = "Lname 1";
    contactInfo1.addressPrime = "Address 1";
    contactInfo1.homePhone = "111-2222";
    contactInfo1.cellPhone = "333-4444";
    contactInfo1.workPhone = "555-6666";
    contactInfo1.emailPrime = "email1@gmail.com";
    contactInfo1.emailSecond = "email2@gmail.com";
    contactInfo1.birthDay = "1";
    contactInfo1.birthMonth = "March";
    contactInfo1.birthYear = "1999";
    contactInfo1.addressSec = "Address 2";
    contactInfo1.phoneAdd = "777-8888";
    
    appl.getContactHelper().filloutContactForm(appl, this, contactInfo1);
    appl.getContactHelper().submitContactCreation();
    appl.getContactHelper().returnToContactPage();
    
  }

  @Test
  public void testEmptyContact() throws Exception {
	
	appl.getNavigationHelper().openMainPage();
	appl.getContactHelper().gotoContactPage();
    
	ContactData contactInfo2 = new ContactData("", "", "", "", "", "", "", "", "-", "-", "", "", "");
	appl.getContactHelper().filloutContactForm(appl, this, contactInfo2);
    appl.getContactHelper().submitContactCreation();
    appl.getContactHelper().returnToContactPage();
  }
}

