package com.example.tests;

public class ContactData implements Comparable<ContactData> {
	
	private String id;
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
		this.lastName = lastName;
		this.addressPrime = addressPrime;
		this.homePhone = homePhone;
		this.setCellPhone(cellPhone);
		this.setWorkPhone(workPhone);
		this.emailPrime = emailPrime;
		this.setEmailSecond(emailSecond);
		this.birthDay = birthDay;
		this.birthMonth = birthMonth;
		this.birthYear = birthYear;
		this.setAddressSec(addressSec);
		this.setPhoneAdd(phoneAdd);
	}

	@Override
	public String toString() {
		return "ContactData [firstName=" + firstName + ", lastName=" + lastName
				+ ", emailPrime=" + emailPrime + ", homePhone=" + homePhone
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		// result = prime * result
		// + ((firstName == null) ? 0 : firstName.hashCode());
		// result = prime * result
		// + ((lastName == null) ? 0 : lastName.hashCode());
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
		if (emailPrime == null) {
			if (other.emailPrime != null)
				return false;
		} else if (!emailPrime.equals(other.emailPrime))
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
		String s = this.firstName + this.lastName;
		return s.compareTo((other.firstName + other.lastName));
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
		this.setAddressSec(addressSec);
		return this;
	}

	public ContactData withEmailPrime(String emailPrime) {
		this.emailPrime = emailPrime;
		return this;
	}

	public ContactData withEmailSecond(String emailSecond) {
		this.setEmailSecond(emailSecond);
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
		this.setCellPhone(cellPhone);
		return this;
	}

	public ContactData withWorkPhone(String workPhone) {
		this.setWorkPhone(workPhone);
		return this;
	}

	public ContactData withPhoneAdd(String phoneAdd) {
		this.setPhoneAdd(phoneAdd);
		return this;
	}
	
	public String getId() {
		return id;
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

	public void setId(String id) {
		this.id = id;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setAddressPrime(String addressPrime) {
		this.addressPrime = addressPrime;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public void setEmailPrime(String emailPrime) {
		this.emailPrime = emailPrime;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

	public void setBirthMonth(String birthMonth) {
		this.birthMonth = birthMonth;
	}

	public void setBirthYear(String birthYear) {
		this.birthYear = birthYear;
	}

	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	public void setWorkPhone(String workPhone) {
		this.workPhone = workPhone;
	}

	public void setEmailSecond(String emailSecond) {
		this.emailSecond = emailSecond;
	}

	public void setAddressSec(String addressSec) {
		this.addressSec = addressSec;
	}

	public void setPhoneAdd(String phoneAdd) {
		this.phoneAdd = phoneAdd;
	}
	
}