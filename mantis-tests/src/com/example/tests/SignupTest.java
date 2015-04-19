package com.example.tests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.*;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.example.fw.AccountHelper;
import com.example.fw.JamesHelper;
import com.example.fw.User;

public class SignupTest extends TestBase {
	
	public User user = new User().setLogin("testuser1").setPassword("123")
							.setEmail("testuser1@localhost.localdomain");
	private JamesHelper james;
	private AccountHelper accHelper;
	
	
	@BeforeClass
	public void createMailUser(){
		james = appl.getJamesHelper();
		accHelper = appl.getAccountHelper();
		if(! james.doesUserExist(user.login)){
			james.createUser(user.login, user.password);	
		}
	}
	
	@Test
	public void newUserShouldSignUp() {
		accHelper.signUp(user);
		accHelper.login(user);
		assertThat(accHelper.loggedUser(), equalTo(user.login));
	}
	
	//@Test
	public void existUserShouldNotSignUp() {
		try {
			accHelper.signUp(user);
		} catch (Exception e) {
			System.out.println("Message" + e.getMessage());
			assertThat(e.getMessage(), containsString("That username is already being used."));
			return;
		}
		fail("Exception expected");
	}
	
	@AfterClass
	public void deleteMailUser(){
		if(james.doesUserExist(user.login)){
			james.deleteUser(user.login);
		}
	}
	
}
