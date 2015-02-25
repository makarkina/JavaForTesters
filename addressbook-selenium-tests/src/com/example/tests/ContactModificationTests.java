package com.example.tests;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase{

		@Test
		public void modifySomeContact(){
			appl.getNavigationHelper().openMainPage();
			appl.getContactHelper().initContactModification(2);
			
			ContactData contactInfo1 = new ContactData();
			contactInfo1.addressPrime = "new Address 1";
			contactInfo1.homePhone = "new phone";
			appl.getContactHelper().filloutContactForm(contactInfo1);
			
			appl.getContactHelper().submitContactModification();
			appl.getNavigationHelper().returnToMainPage();
			
			
		}

	
}
