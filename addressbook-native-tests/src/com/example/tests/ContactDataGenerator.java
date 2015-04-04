package com.example.tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.example.fw.Contact;

	public class ContactDataGenerator {

		public static void main(String[] args) throws IOException {
			if (args.length < 3){
				System.out.println("Please, specify parameters: <amount of data>, <file>, <format>");
				return;
			}
					
			int amount = Integer.parseInt(args[0]);
			File file = new File(args[1]);
			String format = args[2];
			
			if (file.exists()){
				System.out.println("File exists " + file);
				return;
			}
			
			List<Contact> contacts = GenerateContacts(amount);
			if ("csv".equals(format)){
				saveContactsToCsvFile(contacts, file);
			}else{
				System.out.println("Unknown format" + format);
				return;
			}
		}

		private static void saveContactsToCsvFile(List<Contact> contacts, File file) throws IOException {
			FileWriter writer = new FileWriter(file);
			for (Contact contact : contacts){
				writer.write(contact.getFirstName() + "," + contact.getLastName() + "," + "\n");
			}
			writer.close();
			
		}
		
		public static List<Contact> loadContactsFromCsvFile(File file) throws IOException {
			List<Contact> list = new ArrayList<Contact>();
			FileReader reader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(reader);
			String line = bufferedReader.readLine();
			while(line != null) {
				String[] part = line.split(",");
				Contact contacts = new Contact()
				.withFirstName(part[0])
				.withLastName(part[1]);
			list.add(contacts);
			line = bufferedReader.readLine();
			}
			reader.close();
			return list;
		}

		private static List<Contact> GenerateContacts(int amount) {
			List<Contact> list = new ArrayList<Contact>();
			for (int i = 0; i < amount; i++){
				Contact contacts = new Contact()
				.withFirstName(getStrFirstName("First", i))
				.withLastName(getStrLastName("Last", i));
			list.add(contacts);
			}
			return list;
		}

		private static String getStrLastName(String lName, int num) {
			String strLastName = lName + num;
			return strLastName;
		}

		private static String getStrFirstName(String fName, int num) {
			String strFirstName = fName + num;
			return strFirstName;
		}
		
	}
