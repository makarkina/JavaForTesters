package com.example.fw;

public class ContactHelper extends HelperBase{
	

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}

	public void createContact(Contact contact) {
		initContactCreation();
		fillOutContactForm(contact);
		confirmContactCreation();
	}

	private void initContactCreation() {
		manager.getAutoItHelper().winWaitAndActivate("AddressBook portable", "", 5000)
				.click("Add")
				.winWaitAndActivate("Add contact", "", 5000);
	}

	private void fillOutContactForm(Contact contact) {
		manager.getAutoItHelper()
				.send("TDBEdit12", contact.getFirstName())
				.send("TDBEdit11", contact.getLastName());
	}
	
	private void confirmContactCreation() {
		manager.getAutoItHelper().click("Save")
				.winWaitAndActivate("AddressBook portable", "", 5000);
	}

	public Contact getFirstContact() {
		manager.getAutoItHelper().focus("TListView1")
				.winWaitAndActivate("AddressBook portable", "", 5000)
				.send("{DOWN} {SPACE}")
				.click("Edit")
				.winWaitAndActivate("Update contact", "", 5000);
		Contact contact = new Contact()
				.setFirstName(manager.getAutoItHelper().getText("TDBEdit12"))
				.setLastName(manager.getAutoItHelper().getText("TDBEdit11"));
		manager.getAutoItHelper().click("Cancel")
				.winWaitAndActivate("AddressBook portable", "", 5000);
		return contact;
	}

}
