package com.example.fw;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.example.tests.ContactDataGenerator;


public class ContactHelper extends HelperBase{
	
	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}
	
	public List<Contact> getContacts(File file, int cnt) throws IOException, InterruptedException {
		deleteExisitingFile(file);
		checkAllBoxes();
		saveContactListFile(cnt);
		List<Contact> list = ContactDataGenerator.loadContactsFromCsvFile(file);
		list.remove(0);
		return list;	
	}
	
	public ContactHelper createContact(Contact contact) {
		initContactCreation();
		fillOutContactForm(contact);
		confirmContactCreation();
		return this;
	}
	
	public ContactHelper deleteContact(int row, int rowAmount) {
		manager.getAutoItHelper().focus("TListView1")
		.winWaitAndActivate("AddressBook", "", 5000);
		for (int i = 0; i < rowAmount; i++){
			manager.getAutoItHelper().focus("TListView1")
			.winWaitAndActivate("AddressBook", "", 5000)
			.send("{DOWN}");
		
		if(i==row){
			System.out.println("i "+i);
			manager.getAutoItHelper()
 			.send("{SPACE}")
			.click("TRbButton2")
			.winWaitAndActivate("Confirm", "", 5000)
			.click("TButton2");
			break;
		}else{
			continue;
		}
	}
		return this;
		
	}
	
//--------------------------------------------------------------------------------------------------	
	public void deleteExisitingFile(File file) {
		if (file.exists()){
			file.delete();
			System.out.println(file.getName() + " is deleted!");
		}else{
			System.out.println("Delete operation is failed.");
		}
	}
	
	private void checkAllBoxes() {
		manager.getAutoItHelper().focus("TListView1")
		.winWaitAndActivate("AddressBook", "", 5000)
		.click("TRbButton6")
		.winWaitAndActivate("AddressBook", "", 5000)
		.click("TRbButton8");
	}

	private void saveContactListFile(int cnt) {
		if(cnt!=0){
			manager.getAutoItHelper()
			.winWaitAndActivate("Save CSV File", "", 5000)
			.send("Edit1", "{DELETE}");
		}else{
			manager.getAutoItHelper()
			.winWaitAndActivate("Save As", "", 5000)
			.send("Edit1", "{DELETE}");
		}
				
		manager.getAutoItHelper()
		.send("Edit1", "new.csv")
		.click("Button2");
		
		manager.getAutoItHelper()
		.winWaitAndActivate("Information", "", 8000)
		.click("OK")
		.winWaitAndActivate("AddressBook", "", 5000)
		.click("TRbButton6");
	}

	private ContactHelper initContactCreation() {
		manager.getAutoItHelper().winWaitAndActivate("AddressBook", "", 5000)
				.click("Add")
				.winWaitAndActivate("Add Contact", "", 5000);
		return this;
	}

	private ContactHelper fillOutContactForm(Contact contact) {
		manager.getAutoItHelper()
				.send("TDBEdit12", contact.getFirstName())
				.send("TDBEdit11", contact.getLastName())
				.winWaitAndActivate("Add Contact", "", 8000);
		return this;
	}
	
	private ContactHelper confirmContactCreation() {
		manager.getAutoItHelper().click("Save")
				.winWaitAndActivate("AddressBook", "", 5000);
		return this;
	}
	
	/*private ContactHelper initContactDelition(int delRow, int rowTotal) {
		manager.getAutoItHelper().focus("TListView1")
		.winWaitAndActivate("AddressBook", "", 5000);
		for (int i = 0; i < rowTotal; i++){
			manager.getAutoItHelper().focus("TListView1")
			.winWaitAndActivate("AddressBook", "", 5000)
			.send("{DOWN} {SPACE}");
		
		if(i==delRow){
			manager.getAutoItHelper()
			.click("TRbButton2");
			break;
		}else{
			continue;
		}
	}
		return this;
	}
	
	private ContactHelper confirmContactDelition() {
		manager.getAutoItHelper()
		.winWaitAndActivate("Confirm", "", 5000)
		.click("TRbButton2");
		return this;
	}*/
	
	/*public Contact getFirstContact() {
		manager.getAutoItHelper().focus("TListView1")
				.winWaitAndActivate("AddressBook", "", 5000)
				.send("{DOWN} {SPACE}")
				.click("Edit")
				.winWaitAndActivate("Update Contact", "", 5000);
		Contact contact = new Contact()
				.setFirstName(manager.getAutoItHelper().getText("TDBEdit12"))
				.setLastName(manager.getAutoItHelper().getText("TDBEdit11"));
		manager.getAutoItHelper().click("Cancel")
				.winWaitAndActivate("AddressBook", "", 5000);
		return contact;
	}*/

	/*public List<Contact> getContacts() {
		List<Contact> contacts = new ArrayList<Contact>();
		
		while (true) {
			manager.getAutoItHelper().focus("TListView1")
			.winWaitAndActivate("AddressBook", "", 5000)
			.send("{DOWN} {SPACE}");
			manager.getAutoItHelper().click("Edit")
			.winWaitAndActivate("Update Contact", "", 5000);
			
			if ((manager.getAutoItHelper().getText("TDBEdit11") == null)&&
				(manager.getAutoItHelper().getText("TDBEdit12") == null)) {
				break;
			}else{
					
				Contact cont = new Contact()
				.setFirstName(manager.getAutoItHelper().getText("TDBEdit12"))
				.setLastName(manager.getAutoItHelper().getText("TDBEdit11"));
			
				manager.getAutoItHelper().click("Cancel")
				.winWaitAndActivate("AddressBook", "", 5000);
				contacts.add(cont);
				System.out.println(contacts);
			}
		}
		return contacts;
		
	}*/
	
}

