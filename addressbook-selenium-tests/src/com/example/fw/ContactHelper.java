package com.example.fw;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.example.tests.ContactData;
import com.example.utils.ListOf;

public class ContactHelper extends HelperBase{

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}
	
	private ListOf<ContactData> cachedContacts;
	
	public ListOf<ContactData> getContacts() {
		if (cachedContacts == null){
			rebuildCach();
		}
		return new ListOf<ContactData>(cachedContacts);
	}
	
		private void rebuildCach() {
			cachedContacts = new ListOf<ContactData>();
			
			manager.navigateTo().mainPage();
			List<WebElement> rows = driver.findElements(By.xpath("//table[@id='maintable']//tr[@name='entry']"));
						
			//System.out.println(rows.size());
			for (WebElement row : rows) {
			    String firstName = row.findElement(By.xpath(".//td[3]")).getText();
			    String lastName = row.findElement(By.xpath(".//td[2]")).getText();
			    String emailPrime = row.findElement(By.xpath(".//td[4]")).getText();
			    String homePhone = row.findElement(By.xpath(".//td[5]")).getText();
			    cachedContacts.add(new ContactData().withFirstName(firstName).withLastName(lastName)
			    				.withEmailPrime(emailPrime).withHomePhone(homePhone));
			}
	}			

	public ContactHelper createContact(ContactData contact) {
		manager.navigateTo().mainPage();
		gotoContactPage();
		filloutContactForm(contact);
	    submitContactCreation();
	    returnToMainPage();
	    rebuildCach();
	    return this;
	}
	
	public ContactHelper modifyContact(int index, ContactData contact) {
		initContactModification(index);
		filloutContactForm(contact);
		submitContactModification();
		returnToMainPage();
		rebuildCach();
		return this;
	}
	
	public ContactHelper deleteContact(int index) {
		initContactModification(index);
		submitContactDeletion();
		returnToMainPage();
		rebuildCach();
		return this;
	}
	
	//----------------------------------------------------------------------------------------
	
	public ContactHelper gotoContactPage() {
		click(By.linkText("add new"));
		return this;
	}

	public ContactHelper submitContactCreation() {
		click(By.name("submit"));
		cachedContacts = null;
		return this;
	}
	
	public ContactHelper returnToContactPage() {
		click(By.linkText("add next"));
		return this;
	}
	
	public ContactHelper returnToMainPage() {
		click(By.linkText("home page"));
		return this;
	}

	public ContactHelper filloutContactForm(ContactData contact){
		type(By.name("firstname"), contact.getFirstName());
		type(By.name("lastname"), contact.getLastName());
	    type(By.name("address"), contact.getAddressPrime());
	    type(By.name("home"), contact.getHomePhone());
	    type(By.name("mobile"), contact.getCellPhone());
	    type(By.name("work"), contact.getWorkPhone());
	    type(By.name("email"), contact.getEmailPrime());
	    type(By.name("email2"), contact.getEmailSecond());
	    selectByText(By.name("bday"), contact.getBirthDay());
	    selectByText(By.name("bmonth"), contact.getBirthMonth());
	    type(By.name("byear"), contact.getBirthYear());
	    type(By.name("address2"), contact.getAddressSec());
	    type(By.name("phone2"), contact.getPhoneAdd());
		return this;
	  }

	/*public ContactHelper deleteContact(int index) {
		editContactByIndex(index);
		click(By.cssSelector("#content input[value='Delete']"));
		return this;
	}*/

	/*private ContactHelper editContactByIndex(int index) {
		click(By.cssSelector("#maintable tr:nth-of-type(" + (index + 1) + ")" + " img[alt='Edit']"));
		return this;
	}*/

	/*public ContactHelper initContactModification(int index) {
		editContactByIndex(index);
	}*/
	
	public ContactHelper initContactModification(int index) {
		click(By.cssSelector("#maintable tr:nth-of-type(" + (index + 2) + ")" + " img[alt='Edit']"));
		return this;
	}
	
	public ContactHelper submitContactModification() {
		click(By.cssSelector("#content input[value='Update']"));
		cachedContacts = null;
		return this;
	}
	
	private void submitContactDeletion() {
		click(By.cssSelector("#content input[value='Delete']"));
		cachedContacts = null;
	}
	
}
