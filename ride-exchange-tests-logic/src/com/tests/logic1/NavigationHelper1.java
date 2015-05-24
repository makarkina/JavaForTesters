package com.tests.logic1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tests.logic.NavigationHelper;

public class NavigationHelper1 extends HelperBase implements NavigationHelper {
	
		private static final long TIMEOUT = 25;

		public NavigationHelper1(ApplicationManager1 manager) {
			super(manager);
		}

		@Override
		public void mainPage() {
			if (! onMainPage()){
			click(By.linkText("Home"));
			}
		}

		@Override
		public boolean onMainPage() {
			return driver.findElements(By.id("btn-login")).size() > 0;
		}

		@Override
		public void openMainPage() {
			driver.findElement(By.linkText("Welcome, anna.makarkina")).click();
		}
		
		@Override
		public void openLoginPage(String url) {
			driver.get(url);
		}
		
		@Override
		public void gotoUserProfilePage() {
		    openRelativeUrl("http://myridexch.com/profile.php");
		}
		
						
		@Override
		public void openRelativeUrl(String url) {
		    driver.get(url);
		}

		@Override
		public void submitLogIn() {
			/*sleep(20);
			waitPage(By.xpath("//b[contains(text(),'BY CONTINUING TO USE')]"));
			sleep(20);
			click(By.xpath("//b[contains(text(),'BY CONTINUING TO USE')]"));*/
			sleep(10);
			waitPage(By.xpath("//div[2]/div[1]//b"));
			sleep(20);
			click(By.xpath("//div[2]/div[1]//b"));
		}
		
		@Override
		public String getLogUser() {
			//waitPage(By.cssSelector(".dropdown-toggle"));
			waitPage(By.xpath("//div[1]/div/div/div/ul/li/a"));
			  //String log = driver.findElement(By.cssSelector(".dropdown-toggle")).getText();
			  String log = driver.findElement(By.xpath("//div[1]/div/div/div/ul/li/a")).getText();
			  String[] list = log.split(",");
			  String logUser = list[1].trim();
			return logUser;
		}
		
		@Override
		public void sleep(int timeout) {
		    try {
		      Thread.sleep(timeout);
		    } catch (InterruptedException e) {
		      e.printStackTrace();
		    }
		  }
		
		public void waitPage(By locator) {
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withMessage("Element was not found")
				.withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS);
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		}
		
		public boolean isElementPresent(By by) {
		    try {
		      waitElementVisible(by);
		      	return true;
		    } catch (NoSuchElementException e) {
		    	return false;
		    }
		    catch (TimeoutException e) {
		    	return false;
		    }
		}
		
		public WebElement waitElementVisible(By locator) {
		        return waitFor(ExpectedConditions.visibilityOfElementLocated(locator));
		}
		    
		public <Type> Type waitFor(ExpectedCondition<Type> expectedCondition) {
		        return new WebDriverWait(driver, TIMEOUT).until(expectedCondition);
		}
}

