package com.example2.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.testng.annotations.Test;

import com.example.utils.ListOf;
import com.example.utils.SortedListOf;

public class ContactCreationTests extends TestBase{
@Test(dataProvider = "randomValidContactGenerator")
public void testContactCreationWithValidData(ContactData contact) throws Exception{
	
	// save old state
	ListOf<ContactData> oldList = appl.getContactHelper().getContacts();
	//System.out.println("oldList " + oldList.size());
	
	//actions
    appl.getContactHelper().createContact(contact);
    
    ListOf<ContactData> printedList = appl.getContactHelper().getPrintedContacts();
    //System.out.println("printedList " + printedList.size());
    SortedListOf<ContactData> printedSortedList = new SortedListOf<ContactData>(printedList);
    
    System.out.println("printedSortedList " + printedSortedList);
    System.out.println("printedSortedList " + printedSortedList.size());
    System.out.println("//--------------------");
    
    // save new state
    /*ListOf<ContactData> newList = appl.getContactHelper().getContacts();
    System.out.println("newList " + newList.size());
    SortedListOf<ContactData> newSortedList = new SortedListOf<ContactData>(newList);*/
    SortedListOf<ContactData> oldSortedList = new SortedListOf<ContactData>(oldList.withAdded(contact));
    
    System.out.println("oldSortedList " + oldSortedList);
    System.out.println("oldSortedList " + oldSortedList.size());
    System.out.println("//--------------------");
    // compare states
    
    //assertThat(newSortedList, equalTo(oldSortedList));
    assertThat(printedSortedList, equalTo(oldSortedList));
  }
  
}

