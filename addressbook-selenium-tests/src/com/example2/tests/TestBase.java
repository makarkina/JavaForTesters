package com.example2.tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.example2.fw.ApplicationManager;

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
	public Iterator<Object[]> randomValidContactGenerator(){
		List<Object[]> list = new ArrayList<Object[]>();
		
		for (int i = 0; i < 2; i++){
			ContactData contact = new ContactData()
			.withFirstName(generateRandomStringFirstName())
			.withLastName(generateRandomStringName())
			.withAddressPrime(generateRandomStringAddress())
			.withAddressSec(generateRandomStringAddress())
			.withEmailPrime(generateRandomStringEmail())
			.withEmailSecond(generateRandomStringEmail())
			.withBirthDay(generateRandomStringBirthDay())
			.withBirthMonth(generateRandomStringMonth())
			.withBirthYear(generateRandomStringYear())
			.withHomePhone(generateRandomStringPhone())
			.withCellPhone(generateRandomStringPhone())
			.withWorkPhone(generateRandomStringPhone())
			.withPhoneAdd(generateRandomStringPhone());
			
		    list.add(new Object[]{contact});
		}
		return list.iterator();
	}
	
	public String generateRandomStringFirstName(){
		Random rnd = new Random();
		if (rnd.nextInt(3) == 0){
			return "";
		}
		else {
			return "first" + rnd.nextInt();
		}
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
