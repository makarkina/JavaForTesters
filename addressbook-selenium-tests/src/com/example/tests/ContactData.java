package com.example.tests;

public class ContactData {
	
	public String firstName;
	public String lastName;
	public String addressPrime;
	public String homePhone;
	public String cellPhone;
	public String workPhone;
	public String emailPrime;
	public String emailSecond;
	public String birthDay;
	public String birthMonth;
	public String birthYear;
	public String addressSec;
	public String phoneAdd;

	public ContactData(String firstName, String lastName, String addressPrime,
			String homePhone, String cellPhone, String workPhone,
			String emailPrime, String emailSecond, String birthDay,
			String birthMonth, String birthYear, String addressSec,
			String phoneAdd) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.addressPrime = addressPrime;
		this.homePhone = homePhone;
		this.cellPhone = cellPhone;
		this.workPhone = workPhone;
		this.emailPrime = emailPrime;
		this.emailSecond = emailSecond;
		this.birthDay = birthDay;
		this.birthMonth = birthMonth;
		this.birthYear = birthYear;
		this.addressSec = addressSec;
		this.phoneAdd = phoneAdd;
	}
}