package com.tests.model;

public class User {
	private String userName;
	private String password;
	private String repeatPassword;
	private String email;
	private String phone;
	private String mobileProvider;
	private String role;
	private String botSum;
	
	public User() {
		
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMobileProvider() {
		return mobileProvider;
	}

	public void setMobileProvider(String mobileProvider) {
		this.mobileProvider = mobileProvider;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getRepeatPassword() {
		return repeatPassword;
	}

	public void setRepeatPassword(String repeatPassword) {
		this.repeatPassword = repeatPassword;
	}

	public String getBotSum() {
		return botSum;
	}

	public void setBotSum(String botSum) {
		this.botSum = botSum;
	}
	
	
}