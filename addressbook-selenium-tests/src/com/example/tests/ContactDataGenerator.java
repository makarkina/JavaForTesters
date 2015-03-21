package com.example.tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.thoughtworks.xstream.XStream;

public class ContactDataGenerator {

	public static void main(String[] args) throws IOException {
		if (args.length < 3){
			System.out.println("Please, specify parameters: <amount of test data>, <file>, <format>");
			return;
		}
		
		int amount = Integer.parseInt(args[0]);
		File file = new File(args[1]);
		String format = args[2];
		
		if (file.exists()){
			System.out.println("File exists, please remove it manually: " + file);
			return;
		}
		
		List<ContactData> contacts = generateRandomContacts(amount);
		if ("csv".equals(format)){
			saveContactsToCsvFile(contacts, file);
			}
		else if ("xml".equals(format)){
			saveContactsToXmlFile(contacts, file);
			}
		else{
			System.out.println("Unknown format" + format);
			}
		}

	private static void saveContactsToXmlFile(List<ContactData> contacts, File file) throws IOException {
		XStream xstream = new XStream();
		xstream.alias("contact", ContactData.class);
		String xml = xstream.toXML(contacts);
		FileWriter writer = new FileWriter(file);
		writer.write(xml);
		writer.close();
	}
	
	private static void saveContactsToCsvFile(List<ContactData> contacts, File file) throws IOException {
		FileWriter writer = new FileWriter(file);
		for (ContactData contact : contacts){
			writer.write(contact.getFirstName() + "," + contact.getLastName() + "," + contact.getAddressPrime() + ","
						+ contact.getHomePhone() + "," + contact.getCellPhone() + "," + contact.getWorkPhone() + "," 
						+ contact.getBirthDay() + "," + contact.getBirthMonth() + "," + contact.getBirthYear() + "," 
						+ contact.getEmailPrime() + "," + contact.getEmailSecond() + "," + contact.getAddressSec() + "," 
						+ contact.getPhoneAdd() + ",!" + "\n");
		}
		writer.close();
	}
	
	public static List<ContactData> loadContactsFromXmlFile(File file) {
		XStream xstream = new XStream();
		xstream.alias("contact", ContactData.class);
		return (List<ContactData>) xstream.fromXML(file);
	}
			
	public static List<ContactData> loadContactsFromCsvFile(File file) throws IOException {
		List<ContactData> list = new ArrayList<ContactData>();
		FileReader reader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(reader);
		String line = bufferedReader.readLine();
		while (line != null){
			String[] part = line.split(",");
			ContactData contact = new ContactData()
			.withFirstName(part[0])
			.withLastName(part[1])
			.withAddressPrime(part[2])
			.withHomePhone(part[3])
			.withCellPhone(part[4])
			.withWorkPhone(part[5])
			.withBirthDay(part[6])
			.withBirthMonth(part[7])
			.withBirthYear(part[8])
			.withEmailPrime(part[9])
			.withEmailSecond(part[10])
			.withAddressSec(part[11])
			.withPhoneAdd(part[12]);
			
			line = bufferedReader.readLine();
			list.add(contact);
		}
	 	bufferedReader.close();
		return list;
	}

	public static List<ContactData> generateRandomContacts(int amount) {
		List<ContactData> list = new ArrayList<ContactData>();
		
		for (int i = 0; i < amount; i++){
			ContactData contact = new ContactData()
			.withFirstName(generateRandomStringName())
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
			
		    list.add(contact);
		}
		return list;
	}
	public static String generateRandomStringName(){
		Random rnd = new Random();
		if (rnd.nextInt(3) == 0){
			return "";
		}
		else {
			return "test" + rnd.nextInt();
		}
	}
	
	public static String generateRandomStringAddress(){
	Random rnd = new Random();
	if(rnd.nextInt(3) == 0){
		return "";
	}
	else {
		return "Address" + rnd.nextInt();
		}
	}
	
	public static String generateRandomStringEmail(){
	Random rnd = new Random();
	if(rnd.nextInt(10) == 0){
		return "";
	}
	else {
		return "email" + rnd.nextInt(10) + "@gmail.com";
		}
	}
	
	public static String generateRandomStringBirthDay(){
		Random rnd = new Random();
		String birhDay = Integer.toString(rnd.nextInt(30)+1);
		return birhDay;
	}
	
	public static String generateRandomStringMonth(){
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
	
	public static String generateRandomStringDigit(){
		Random rnd = new Random();
		String digit = Integer.toString(rnd.nextInt(9));
		return digit;
	}
	
	public static String generateRandomStringPhone(){
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
	public static String generateRandomStringYear(){
		String digit = generateRandomStringDigit();
		return "201"+ digit;
	
	}
	
}
