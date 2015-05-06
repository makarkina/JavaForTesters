package com.tests.logic1;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.tests.logic.UserHelper;
import com.tests.model.User;

public class UserHelper1 extends HelperBase implements UserHelper {

	public UserHelper1(ApplicationManager1 manager) {
		super(manager);
	}
	
	@Override
	public void logOut() {
		click(By.cssSelector(".dropdown-toggle"));
		click(By.id("logout"));
	    waitPage(By.xpath("//div[@id='login']"));
	  }
	
	@Override
	public void submitLogIn() {
		waitPage(By.xpath("//font[contains(text(),'BY CONTINUING TO USE')]"));
		click(By.xpath("//font[contains(text(),'BY CONTINUING TO USE')]"));
	}
	
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
		waitPage(By.cssSelector(".dropdown-toggle"));
		  String log = driver.findElement(By.cssSelector(".dropdown-toggle")).getText();
		  String[] list = log.split(",");
		  String logUser = list[1].trim();
		return logUser;
	}
	
	
	public void waitPage(By locator) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withMessage("Element was not found")
				.withTimeout(20, TimeUnit.SECONDS)
				.pollingEvery(1, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
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

}

