package com.example.tests;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;
import com.example.fw.Contact;

public class TestContactDelition extends TestBase {
	
	private static int cnt = 0;
		
	@Test
	public void deleteContacts() throws IOException, InterruptedException{
		
		//saving old state
		List<Contact> oldList = appl.getContactHelper().getContacts(new File("new.csv"), cnt++);
		
		//action: deleting random contact
		Random rnd = new Random();
		int index = rnd.nextInt(oldList.size()-1);
		appl.getContactHelper().deleteContact(index,oldList.size());
		
		//saving new state
		List<Contact> newList = appl.getContactHelper().getContacts(new File("new.csv"), cnt++);
		Collections.sort(newList);
		
		//comparing states
		oldList.remove(index+1);
	    Collections.sort(oldList);
	    assertEquals(newList, oldList);
	}
}
