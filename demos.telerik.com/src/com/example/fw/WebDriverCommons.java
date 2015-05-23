package com.example.fw;

import java.io.File;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class WebDriverCommons {

  private static final long TIMEOUT = 10;

  protected final Properties properties;

  public WebDriver driver;
  public String baseUrl;

  public WebDriverCommons(Properties properties) throws Exception {
    this.properties = properties;
    
    String browser = properties.getProperty("browser");
	
	if ("firefox".equals(browser)){
		driver = new FirefoxDriver();
		    			
	} else if ("chrome".equals(browser)) {
		driver = new ChromeDriver();
		
	} else if ("ie".equals(browser)) {
		driver = new InternetExplorerDriver();
	       	    		
	} else {
		throw new Error ("Unsupported browser: "+ browser);
	}
	
    baseUrl = properties.getProperty("baseUrl");
    
  }

  public static void sleep(int timeout) {
    try {
      Thread.sleep(timeout);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public void tryToClickTwice(By locator) {
    try {
      waitElementClickable(locator).click();
    } catch (StaleElementReferenceException e) {
      waitElementClickable(locator).click();
    }
  }
  
  public WebElement waitElementVisible(By locator) {
    return waitFor(ExpectedConditions.visibilityOfElementLocated(locator));
  }
  
  
  public boolean waitElementInvisible(By locator) {
    return waitFor(ExpectedConditions.invisibilityOfElementLocated(locator));
  }

  public WebElement waitElementClickable(By locator) {
    return waitFor(ExpectedConditions.elementToBeClickable(locator));
  }

  public WebElement waitOneOfElementsVisible(By locator1, By locator2) {
    return waitFor(visibilityOfAnyElementLocated(locator1, locator2));
  }

  public <Type> Type waitFor(ExpectedCondition<Type> expectedCondition) {
    return new WebDriverWait(driver, TIMEOUT).until(expectedCondition);
  }

  public ExpectedCondition<WebElement> visibilityOfAnyElementLocated(final By locator1, final By locator2) {
    return new ExpectedCondition<WebElement>() {
      public WebElement apply(WebDriver driver) {
        WebElement element1 = elementIfVisible(locator1);
        if (element1 != null) {
          return element1;
        }
        WebElement element2 = elementIfVisible(locator2);
        if (element2 != null) {
          return element2;
        }
        return null;
      }
    };
  }

  private WebElement elementIfVisible(By locator) {
    try {
      WebElement element = driver.findElement(locator);
      return element != null && element.isDisplayed() ? element : null;
    } catch (NoSuchElementException e) {
      return null;
    }
  }

  public boolean isElementPresent(By by) {
    try {
      waitElementVisible(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  public void takeScreenshot(String id) {
    File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    // copy this file to the screenshots dir and rename
    Reporter.log(id + ": " + "<a href=\"" + screenshot.getAbsolutePath() + "\">screenshot</a>");
  }

}
