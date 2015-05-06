package com.tests;

import static com.tests.logic1.UserDataGenerator.loadUsersFromCsvFile;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tests.model.User;

public class LoginTests extends TestBase {
    
   	
  @BeforeMethod
	public void mayBeLogOut() {
		 if (app.getUserHelper().isLoggedIn()) {
			 app.getUserHelper().logOut();
		 } 
	  }
  
  @DataProvider
	public Iterator<Object[]> usersFromFile() throws IOException {
		return wrapUsersForDataProvider(loadUsersFromCsvFile(new File("users.txt"))).iterator();
	}

  @Test(dataProvider = "usersFromFile")
   	public void testLoginOK(User user) throws Exception {
		app.getUserHelper().loginAs(user);
		app.getUserHelper().submitLogIn();
        assertTrue(app.getUserHelper().isLoggedInAs(user));
  }
  
  @DataProvider
	public Iterator<Object[]> users1FromFile() throws IOException {
		return wrapUsersForDataProvider(loadUsersFromCsvFile(new File("users1.txt"))).iterator();
	}
	
  @Test(dataProvider = "users1FromFile")
  	public void testLoginFailed() throws Exception {
	  	User user = new User();
	  	app.getUserHelper().loginAs(user);
	  	assertTrue(app.getUserHelper().isNotLoggedIn());
  	}
  
    
}

