package com.example.fw;

import java.util.ArrayList;
import java.util.List;

import com.example.tests.ContactData;
import com.example.tests.GroupData;
import com.example.utils.SortedListOf;

public class ApplicationModel {
	//private SortedListOf<ContactData> contacts;
	private List<ContactData> contacts;
	
	public List<ContactData> getContacts(){
		return contacts;		
	}
	
	public void setContacts(List<ContactData> contacts){
		this.contacts = new SortedListOf<ContactData>(contacts);		
	}

	public ApplicationModel addContact(ContactData contact) {
		contacts.add(contact);
		return this;
	}

	public ApplicationModel removeContact(int index) {
		contacts.remove(index);
		return this;
	}
	
}
