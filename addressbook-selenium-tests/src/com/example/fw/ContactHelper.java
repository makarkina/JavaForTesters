package com.example.fw;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.ContactData;
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

	public void deleteContact(int index) {
		editContactByIndex(index);
		click(By.cssSelector("#content input[value='Delete']"));
	}

	private void editContactByIndex(int index) {
		click(By.cssSelector("#maintable tr:nth-of-type(" + (index + 1) + ")" + " img[alt='Edit']"));
	}

	public void initContactModification(int index) {
		editContactByIndex(index);
		
	}

	public void submitContactModification() {
		click(By.cssSelector("#content input[value='Update']"));
		
	}

	public List<ContactData> getContacts() {
		List<ContactData> contacts = new ArrayList<ContactData>();
		List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
		
		for (WebElement checkbox : checkboxes) {
			ContactData contact = new ContactData();
			String ident = checkbox.getAttribute("alt");
			contact.firstAndLastName = ident.substring("Select (".length(), ident.length() - ")".length());
			contacts.add(contact);
		}
		return contacts;
	}
	
}
