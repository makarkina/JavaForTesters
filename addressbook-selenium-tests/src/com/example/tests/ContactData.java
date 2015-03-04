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
	public String firstAndLastName;

	public ContactData() {
		
	}
	
	public ContactData(String firstName, String lastName, String addressPrime,
			String homePhone, String cellPhone, String workPhone,
			String emailPrime, String emailSecond, String birthDay,
			String birthMonth, String birthYear, String addressSec,
			String phoneAdd, String firstAndLastName) {
		
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
		this.firstAndLastName = firstAndLastName;
	}

	@Override
	public String toString() {
		return "ContactData [idName=" + firstAndLastName + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		//result = prime * result + ((idName == null) ? 0 : idName.hashCode());
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
		if (firstAndLastName == null) {
			if (other.firstAndLastName != null)
				return false;
		} else if (!firstAndLastName.equals(other.firstAndLastName))
			return false;
		return true;
	}

	@Override
	public int compareTo(ContactData other) {
		return this.firstAndLastName.toLowerCase().compareTo(other.firstAndLastName.toLowerCase());
	}
	
	
	
}