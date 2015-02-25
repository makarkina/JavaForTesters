package com.example.tests;

import org.testng.annotations.Test;

public class ContactRemovalTests extends TestBase {
	
	@Test
	public void deleteSomeContact(){
		appl.getNavigationHelper().openMainPage();
		appl.getContactHelper().deleteContact(2);
		appl.getNavigationHelper().returnToMainPage();
	}

}
