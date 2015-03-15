package com.example2.tests;

public class ContactData implements Comparable<ContactData>{
	
	private String firstName;
	private String lastName;
	private String addressPrime;
	private String homePhone;
	private String cellPhone;
	private String workPhone;
	private String emailPrime;
	private String emailSecond;
	private String birthDay;
	private String birthMonth;
	private String birthYear;
	private String addressSec;
	private String phoneAdd;
	
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
				+ ", homePhone=" + homePhone + "]";
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
		if (homePhone == null) {
			if (other.homePhone != null)
				return false;
		} else if (!homePhone.equals(other.homePhone))
			return false;
		return true;
	}

	@Override
	public int compareTo(ContactData other) {
		String s = this.firstName+this.lastName+this.homePhone; 
		return s.toLowerCase().compareTo((other.firstName + other.lastName + other.homePhone).toLowerCase());
	}

	public ContactData withFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public ContactData withLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public ContactData withAddressPrime(String addressPrime) {
		this.addressPrime = addressPrime;
		return this;
	}

	public ContactData withAddressSec(String addressSec) {
		this.addressSec = addressSec;
		return this;
	}

	public ContactData withEmailPrime(String emailPrime) {
		this.emailPrime = emailPrime;	
		return this;
	}

	public ContactData withEmailSecond(String emailSecond) {
		this.emailSecond = emailSecond;		
		return this;
	}

	public ContactData withBirthDay(String birthDay) {
		this.birthDay = birthDay;		
		return this;
	}

	public ContactData withBirthMonth(String birthMonth) {
		this.birthMonth = birthMonth;		
		return this;
	}

	public ContactData withBirthYear(String birthYear) {
		this.birthYear = birthYear;	
		return this;
	}

	public ContactData withHomePhone(String homePhone) {
		this.homePhone = homePhone;	
		return this;
	}

	public ContactData withCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;	
		return this;
	}

	public ContactData withWorkPhone(String workPhone) {
		this.workPhone = workPhone;
		return this;
	}

	public ContactData withPhoneAdd(String phoneAdd) {
		this.phoneAdd = phoneAdd;	
		return this;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getAddressPrime() {
		return addressPrime;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public String getCellPhone() {
		return cellPhone;
	}

	public String getWorkPhone() {
		return workPhone;
	}

	public String getEmailPrime() {
		return emailPrime;
	}

	public String getEmailSecond() {
		return emailSecond;
	}

	public String getBirthDay() {
		return birthDay;
	}

	public String getBirthMonth() {
		return birthMonth;
	}

	public String getBirthYear() {
		return birthYear;
	}

	public String getAddressSec() {
		return addressSec;
	}

	public String getPhoneAdd() {
		return phoneAdd;
	}

}