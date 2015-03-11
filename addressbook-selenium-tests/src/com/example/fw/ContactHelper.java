package com.example.fw;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.example.tests.ContactData;

public class ContactHelper extends HelperBase{

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}
	
	private List<ContactData> cachedContacts;
	
	public List<ContactData> getContacts() {
	if (cachedContacts == null){
		rebuildCache();
		}
		return new ArrayList<ContactData>(cachedContacts);
	}

	public void rebuildCache() {
		cachedContacts = new ArrayList<ContactData>();
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='maintable']//tr"));
		rows.remove(0);
		rows.remove(rows.size()-1);
		for (WebElement row : rows) {
		    ContactData contact = new ContactData();
		    contact.firstName = row.findElement(By.xpath(".//td[3]")).getText();
		    contact.lastName = row.findElement(By.xpath(".//td[2]")).getText();
		    cachedContacts.add(contact);
		}
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
	
	public void gotoContactPage() {
		click(By.linkText("add new"));
	}

	public void returnToContactPage() {
		click(By.linkText("add next"));
	}

	public void initContactModification(int index) {
		editContactByIndex(index);
	}
	
	public void editContactByIndex(int index) {
		click(By.cssSelector("#maintable tr:nth-of-type(" + (index + 2) + ")" + " img[alt='Edit']"));
	}
	
	public void submitContactCreation() {
		click(By.name("submit"));
		cachedContacts = null;
	}

	public void submitContactModification() {
		click(By.cssSelector("#content input[value='Update']"));
		cachedContacts = null;
	}
	
	public void submitContactDeletion() {
		click(By.cssSelector("#content input[value='Delete']"));
		cachedContacts = null;
	}
	
}
