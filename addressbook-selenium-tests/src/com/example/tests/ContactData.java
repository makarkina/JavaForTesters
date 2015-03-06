package com.example.tests;

public class ContactData implements Comparable<ContactData>{
	
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
	
	public ContactData() {
		
	}
	
	public ContactData(String firstName, String lastName, String addressPrime,
			String homePhone, String cellPhone, String workPhone,
			String emailPrime, String emailSecond, String birthDay,
			String birthMonth, String birthYear, String addressSec,
			String phoneAdd) {
		
		this.firstName = firstName;
		this.lastName  = lastName;
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

	@Override
	public String toString() {
		return "ContactData [firstName=" + firstName + ", lastName=" + lastName
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		//result = prime * result
		//+ ((firstName == null) ? 0 : firstName.hashCode());
		//result = prime * result
		//+ ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContactData other = (ContactData) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}

	@Override
	public int compareTo(ContactData other) {
		String s = this.firstName+this.lastName; 
		return s.toLowerCase().compareTo((other.firstName + other.lastName).toLowerCase());
	}

}