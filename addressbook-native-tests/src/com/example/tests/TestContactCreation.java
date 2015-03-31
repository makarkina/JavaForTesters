package com.example.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.fw.Contact;

public class TestContactCreation extends TestBase {
	
	@Test
	public void ShouldCreateContactWithValidData() {
		Contact contact = new Contact().setFirstName("tester").setLastName("tester");
		appl.getContactHelper().createContact(contact);
		Contact createdContact = appl.getContactHelper().getFirstContact();
		Assert.assertEquals(contact, createdContact);
	}

}
