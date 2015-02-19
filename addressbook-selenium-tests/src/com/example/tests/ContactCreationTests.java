package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class ContactCreationTests {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://localhost/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testNonEmptyContact() throws Exception {
    openMainPage();
    gotoContactPage();
    ContactData contactInfo1 = new ContactData("Fname 1", "Lname 1", "Address 1", "111-2222", "333-4444", "555-6666", "email1@gmail.com", "email2@gamil.com", "1", "March", "1999", "Address 2", "777-8888");
	filloutContactForm(contactInfo1);
    submitContactCreation();
    driver.findElement(By.linkText("add next")).click();
  }
  
  @Test
  public void testEmptyContact() throws Exception {
    openMainPage();
    gotoContactPage();
    ContactData contactInfo2 = new ContactData("", "", "", "", "", "", "", "", "-", "-", "", "", "");
	filloutContactForm(contactInfo2);
    submitContactCreation();
    driver.findElement(By.linkText("add next")).click();
  }

private void submitContactCreation() {
	driver.findElement(By.name("submit")).click();
}

private void filloutContactForm(ContactData contact) {
	driver.findElement(By.name("firstname")).clear();
    driver.findElement(By.name("firstname")).sendKeys(contact.firstName);
    driver.findElement(By.name("lastname")).clear();
    driver.findElement(By.name("lastname")).sendKeys(contact.lastName);
    driver.findElement(By.name("address")).clear();
    driver.findElement(By.name("address")).sendKeys(contact.addressPrime);
    driver.findElement(By.name("home")).clear();
    driver.findElement(By.name("home")).sendKeys(contact.homePhone);
    driver.findElement(By.name("mobile")).clear();
    driver.findElement(By.name("mobile")).sendKeys(contact.cellPhone);
    driver.findElement(By.name("work")).clear();
    driver.findElement(By.name("work")).sendKeys(contact.workPhone);
    driver.findElement(By.name("email")).clear();
    driver.findElement(By.name("email")).sendKeys(contact.emailPrime);
    driver.findElement(By.name("email2")).clear();
    driver.findElement(By.name("email2")).sendKeys(contact.emailSecond);
    new Select(driver.findElement(By.name("bday"))).selectByVisibleText(contact.birthDay);
    new Select(driver.findElement(By.name("bmonth"))).selectByVisibleText(contact.birthMonth);
    driver.findElement(By.name("byear")).clear();
    driver.findElement(By.name("byear")).sendKeys(contact.birthYear);
    driver.findElement(By.name("address2")).clear();
    driver.findElement(By.name("address2")).sendKeys(contact.addressSec);
    driver.findElement(By.name("phone2")).clear();
    driver.findElement(By.name("phone2")).sendKeys(contact.phoneAdd);
}

private void gotoContactPage() {
	driver.findElement(By.linkText("add new")).click();
}

private void openMainPage() {
	driver.get(baseUrl + "/addressbookv4.1.4/");
}

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
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
}
