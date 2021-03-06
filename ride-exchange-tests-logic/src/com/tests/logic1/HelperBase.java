package com.tests.logic1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tests.logic.ApplicationManager;

public abstract class HelperBase {

	protected ApplicationManager manager;
	protected WebDriver driver;
	protected WebDriverWait wait;
	
	public boolean acceptNextAlert = true;
	
	public HelperBase(ApplicationManager1 manager){
		this.manager = manager;
		this.driver = manager.driver;
		wait = new WebDriverWait(driver, 10);
	}
	
	public boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }
	
	public boolean isAlertPresent() {
	    try {
	      driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	 }
	public String closeAlertAndGetItsText() {
	    try {
	      Alert alert = driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	      acceptNextAlert = true;
	    }
	  }

	protected void selectByText(By locator, String text) {
		if (text != null){
		new Select(driver.findElement(locator)).selectByVisibleText(text);
		}
	}

	protected void type(By locator, String text) {
		driver.findElement(locator).clear();
		driver.findElement(locator).sendKeys(text);
	}

	protected void click(By locator) {
		driver.findElement(locator).click();
	}

	public void FormEdition() {
		// TODO Auto-generated method stub
		
	}
}
