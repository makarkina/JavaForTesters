package com.example.tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.example.fw.ApplicationManager;

public class TestBase {

	static protected ApplicationManager appl;
	
	@BeforeTest
	public void setUp() throws Exception {
	    appl = new ApplicationManager();
	    
	  }
	
	@AfterTest
	public void tearDown() throws Exception {
		appl.stop();
	
	  }
		
	@DataProvider
	public Iterator<Object[]> randomValidGroupGenerator(){
		List<Object[]> list = new ArrayList<Object[]>();
		
		for (int i = 0; i < 5; i++){
			GroupData group = new GroupData();
			group.name = generateRandomString();
		    group.header = generateRandomString();
		    group.footer = generateRandomString();
		    list.add(new Object[]{group});
		}
		return list.iterator();
	}

	public String generateRandomString(){
		Random rnd = new Random();
		if (rnd.nextInt(3) == 0){
			return "";
		}
		else {
			return "test" + rnd.nextInt();
		}
	}

	@DataProvider
	public Iterator<Object[]> randomValidContactGenerator(){
		List<Object[]> list = new ArrayList<Object[]>();
		
		for (int i = 0; i < 1; i++){
			ContactData contact = new ContactData();
			contact.firstName = generateRandomStringName();
			contact.lastName = generateRandomStringName();
			contact.addressPrime = generateRandomStringAddress();
			contact.addressSec = generateRandomStringAddress();
		    contact.emailPrime = generateRandomStringEmail();
		    contact.emailSecond = generateRandomStringEmail();
		    contact.birthDay = generateRandomStringBirthDay();
		    contact.birthMonth = generateRandomStringMonth();
		    contact.birthYear = generateRandomStringYear();
		    contact.homePhone = generateRandomStringPhone();
		    contact.cellPhone = generateRandomStringPhone();
		    contact.workPhone = generateRandomStringPhone();
		    contact.phoneAdd = generateRandomStringPhone();
		    
		    list.add(new Object[]{contact});
		}
		return list.iterator();
	}

	public String generateRandomStringName(){
		Random rnd = new Random();
		if (rnd.nextInt(3) == 0){
			return "";
		}
		else {
			return "test" + rnd.nextInt();
		}
	}
	
	public String generateRandomStringAddress(){
	Random rnd = new Random();
	if(rnd.nextInt(3) == 0){
		return "";
	}
	else {
		return "Adress" + rnd.nextInt();
		}
	}
	
	public String generateRandomStringEmail(){
	Random rnd = new Random();
	if(rnd.nextInt(10) == 0){
		return "";
	}
	else {
		return "email" + rnd.nextInt(10) + "@gmail.com";
		}
	}
	
	public String generateRandomStringBirthDay(){
		Random rnd = new Random();
		String birhDay = Integer.toString(rnd.nextInt(30)+1);
		return birhDay;
	}
	
	public String generateRandomStringMonth(){
		List<String> listMonths = new ArrayList<String>();
			listMonths.add("January");
			listMonths.add("February");
			listMonths.add("March");
			listMonths.add("April");
			listMonths.add("May");
			listMonths.add("June");
			listMonths.add("July");
			listMonths.add("August");
			listMonths.add("September");
			listMonths.add("October");
			listMonths.add("November");
			listMonths.add("December");
		Random rnd = new Random();
		String month = listMonths.get(rnd.nextInt(11));
		return month;	
	}
	
	public String generateRandomStringDigit(){
		Random rnd = new Random();
		String digit = Integer.toString(rnd.nextInt(9));
		return digit;
	}
	
	public String generateRandomStringPhone(){
		List<String> listDigit = new ArrayList<String>();
		for(int i=0; i < 5; i++){
		String n = generateRandomStringDigit();
		listDigit.add(n); 
		
	}
		if (Integer.parseInt(listDigit.get(0)) == 0){
			return "";
		}
		else {
			return listDigit.get(0)+listDigit.get(1)+"-"+listDigit.get(2)+listDigit.get(3)+listDigit.get(4);
		}
		
	}
	public String generateRandomStringYear(){
		String digit = generateRandomStringDigit();
		return "201"+ digit;
	
	}
}
