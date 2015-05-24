package com.tests.model;

public class Ride {
	
	/*private String userName;
	private String password;*/
	public User user;
	private String pickup;
	private String zipCode;
	private String destination;
	private String price;
	private String passengers;
	
	public Ride () {
		user = new User();
	}
			
	public String getPickup() {
		return pickup;
	}

	public void setPickup(String pickup) {
		this.pickup = pickup;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getPassengers() {
		return passengers;
	}

	public void setPassengers(String passengers) {
		this.passengers = passengers;
	}

	
	/*public String getUserName() {
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
	}*/

	/*public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}*/
	
}
