package com.tests.logic1;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.tests.logic.UserHelper;
import com.tests.model.User;

public class UserHelper1 extends HelperBase implements UserHelper {
		
	public UserHelper1(ApplicationManager1 manager) {
		super(manager);
	}
	
	@Override
	public void logOut() {
		//manager.getNavigationHelper().sleep(10);
		click(By.cssSelector(".dropdown-toggle"));
		click(By.id("logout"));
		manager.getNavigationHelper().waitPage(By.xpath("//div[@id='login']"));
	  }
	
	@Override
	public void loginAs(User user) {
		type(By.id("login-username"), user.getUserName());
		type(By.id("login-password"), user.getPassword());
		click(By.id("btn-login"));
	}

	@Override
	public boolean isLoggedIn() {
		return driver.findElements(By.cssSelector(".nav.nav-list.bs-docs-sidenav")).size() > 0;
		
	}
	
	@Override
	  public boolean isLoggedInAs(User user) {
		return isLoggedIn()
	        && getLogUser().equals(user.getUserName());
	}
	
	@Override
	  public boolean isNotLoggedIn() {
	    return (driver.findElement(By.xpath("//div[@id='login']"))!= null);
	}

		
	private String getLogUser() {
	manager.getNavigationHelper().waitPage(By.cssSelector(".dropdown-toggle"));
		  String log = driver.findElement(By.cssSelector(".dropdown-toggle")).getText();
		  String[] list = log.split(",");
		  String logUser = list[1].trim();
		return logUser;
	}
	
	
	public List<User> getUser(File file) throws IOException, InterruptedException {
		deleteExisitingFile(file);
		List<User> list = UserDataGenerator.loadUsersFromCsvFile(file);
		return list;	
	}

	public void deleteExisitingFile(File file) {
		if (file.exists()){
			file.delete();
			System.out.println(file.getName() + " is deleted!");
		}else{
			System.out.println("Delete operation is failed.");
		}
	}

	//-----------------------------------------------------------------------------------------------
	
	@Override
	public void fillOutForm(User user) {
	manager.getNavigationHelper().waitElementVisible(By.linkText("Create Account"));
		click(By.linkText("Create Account"));
		type(By.id("reg-email"), user.getEmail());
		type(By.id("reg-phone"), user.getPhone());
		new Select(driver.findElement(By.id("reg-mobile-provider"))).selectByVisibleText("T-Mobile");
		type(By.id("reg-username"), user.getUserName());
		type(By.id("reg-password"), user.getPassword());
		type(By.id("reg-repeat-password"), user.getRepeatPassword());
		type(By.id("reg-bot-sum"), user.getBotSum());
	}
	
	@Override
	public void fillOutFormFailed(User user) {
	manager.getNavigationHelper().waitElementVisible(By.linkText("Create Account"));
		click(By.linkText("Create Account"));
		type(By.id("reg-email"), user.getEmail());
		type(By.id("reg-phone"), user.getPhone());
		//new Select(driver.findElement(By.id("reg-mobile-provider"))).selectByVisibleText("T-Mobile");
		type(By.id("reg-username"), user.getUserName());
		type(By.id("reg-password"), user.getPassword());
		type(By.id("reg-repeat-password"), user.getRepeatPassword());
		type(By.id("reg-bot-sum"), user.getBotSum());
	}
	
	@Override
	public void FormEdition () {
		User user = new User();
	    user.setEmail("i@mail.ru");
	    //user.setPhone("1112223333");
	    user.setPhone("111222333");
	    user.setPassword("Mimino66");
	    //user.setRepeatPassword("Mimino66");
	    user.setRepeatPassword("Mimino6");
	    user.setUserName("IVan");
	    
		List <WebElement> errors = driver.findElements(By.xpath("//span[@class='help-inline text-error']"));
		  for (WebElement error : errors) {
			  if (error.getText().equals("Please enter valid email.")){
				  type(By.id("reg-email"), user.getEmail());
		      } else if (error.getText().equals("Please enter valid phone.")) {
		    	  type(By.id("reg-phone"), user.getPhone());
		      }  else if (error.getText().equals("Please choose mobile provider.")) {
				  new Select(driver.findElement(By.id("reg-mobile-provider"))).selectByVisibleText("T-Mobile");
			  } else if (error.getText().equals("Username already in use.")) {
		    	  type(By.id("reg-username"), user.getUserName());
			  } else if (error.getText().equals("Passwords don't match.")) {
				  type(By.id("reg-password"), user.getPassword());
				  type(By.id("reg-repeat-password"), user.getRepeatPassword());
			  };
		  }
		manager.getNavigationHelper().sleep(1000);
	  }
	
	@Override
	public void FormEditionFailed () {
		User user = new User();
	    user.setEmail("anna@mail.ru");
	    user.setPhone("111222333");
	    user.setUserName("anna.makarkina");
	    user.setPassword("Mimino66");
	    user.setRepeatPassword("Mimino6");
	    	    
		List <WebElement> errors = driver.findElements(By.xpath("//span[@class='help-inline text-error']"));
		  for (WebElement error : errors) {
			  if (error.getText().equals("Please enter valid email.")){
				  type(By.id("reg-email"), user.getEmail());
		      } else if (error.getText().equals("Please enter valid phone.")) {
		    	  type(By.id("reg-phone"), user.getPhone());
		      }  else if (error.getText().equals("Please choose mobile provider.")) {
				  new Select(driver.findElement(By.id("reg-mobile-provider"))).selectByVisibleText("T-Mobile");
			  } else if (error.getText().equals("Username already in use.")) {
		    	  type(By.id("reg-username"), user.getUserName());
			  } else if (error.getText().equals("Passwords don't match.")) {
				  type(By.id("reg-password"), user.getPassword());
				  type(By.id("reg-repeat-password"), user.getRepeatPassword());
			  };
		  }
		  manager.getNavigationHelper().sleep(1000);
	}
	
	@Override
	public void	submitAccountCreation(){
		click(By.id("btn-register"));
		if (isElementPresent(By.xpath("//div[@class='alert alert-success']"))){
			click(By.linkText("Login"));
			manager.getNavigationHelper().waitPage(By.xpath("//div[@id='login']"));
			System.out.println("The successful registration");
			manager.getNavigationHelper().sleep(1000);
		} else {
			System.out.println("The incorrcet registration:");
			List <WebElement> errors = driver.findElements(By.xpath("//span[@class='help-inline text-error']"));
			  for (WebElement error : errors) {
				  System.out.println(error.getText());
			  }
		System.out.println("--------------------------------"); 
		}
	}
		
}

