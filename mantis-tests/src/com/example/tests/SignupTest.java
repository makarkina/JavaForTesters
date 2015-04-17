package com.example.tests;

import static org.testng.Assert.*;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.example.fw.User;

public class SignupTest extends TestBase {
	
	public User user = new User().setLogin("testuser7").setPassword("1")
						.setEmail("testuser7@localhost.localdomain");
	
	@BeforeClass
	public void createMailUser(){
		if(! appl.getJamesHelper().doesUserExist(user.login)){
			appl.getJamesHelper().createUser(user.login, user.password);	
		}
	}
	
	@Test
	public void newUserShouldSignUp() {
		appl.getAccountHelper().signUp(user);
		assertTrue(appl.getAccountHelper().isLogged(user));
		
	}
	
	@AfterClass
	public void deleteMailUser(){
		if(appl.getJamesHelper().doesUserExist(user.login)){
			appl.getJamesHelper().deleteUser(user.login);
		}
	}
	
}
