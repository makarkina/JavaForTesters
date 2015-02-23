package com.example.fw;

import org.openqa.selenium.By;
import com.example.tests.ContactData;
import com.example.tests.TestBase;

public class ContactHelper extends HelperBase{

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}

	public void gotoContactPage() {
		click(By.linkText("add new"));
	}

	public void submitContactCreation() {
		click(By.name("submit"));
	}
	
	public void returnToContactPage() {
		click(By.linkText("add next"));
	}

	public void filloutContactForm(ContactData contact){
		type(By.name("firstname"), contact.firstName);
		type(By.name("lastname"), contact.lastName);
	    type(By.name("address"), contact.addressPrime);
	    type(By.name("home"), contact.homePhone);
	    type(By.name("mobile"), contact.cellPhone);
	    type(By.name("work"), contact.workPhone);
	    type(By.name("email"), contact.emailPrime);
	    type(By.name("email2"), contact.emailSecond);
	    selectByText(By.name("bday"), contact.birthDay);
	    selectByText(By.name("bmonth"), contact.birthMonth);
	    type(By.name("byear"), contact.birthYear);
	    type(By.name("address2"), contact.addressSec);
	    type(By.name("phone2"), contact.phoneAdd);
	  }

	

}
