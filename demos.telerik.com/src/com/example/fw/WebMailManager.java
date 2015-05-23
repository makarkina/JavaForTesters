package com.example.fw;

	import static org.junit.Assert.fail;

	import java.util.ArrayList;
	import java.util.List;
	import java.util.Properties;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.Select;

	public class WebMailManager extends WebDriverCommons {

	  private StringBuffer verificationErrors = new StringBuffer();
	  
	  public WebMailManager(Properties properties) throws Exception {
	    super(properties);
	  }

	  public void quit() {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }

	  public void openMainPage() {
	    driver.get(baseUrl);
	  }

	  public void logout() {
	    String current = loggedUser();
	    if (current == null) {
	      return;
	    }
	    waitElementVisible(By.className("wm_accountslist_logout"))
	      .findElement(By.tagName("a")).click();
	  }

	  private String loggedUser() {
	    WebElement element = waitOneOfElementsVisible(
	        By.className("wm_accountslist_email"),
	        By.id("login_form"));
	    if ("login_form".equals(element.getAttribute("id"))) {
	      return null;
	    } else {
	      return element.getText();
	    }
	  }

	  public void openSettings() {
	    waitElementVisible(By.className("wm_accountslist_settings"))
	      .findElement(By.tagName("a")).click();
	  }

	  public void selectLanguage(String language) {
	    new Select(waitElementVisible(By.xpath("//div[@id='content']/div[7]/div/div/div/form/table/tbody/tr[3]/td[2]/select")))
	      .selectByVisibleText(language);
	  }

	  public void selectTZ(String tz) {
	    new Select(waitElementVisible(By.xpath("//div[@id='content']/div[7]/div/div/div/form/table/tbody/tr[8]/td[2]/select")))
	      .selectByVisibleText(tz);
	  }

	  public void setTimeFormat24h() {
	    tryToClickTwice(By.id("def_TimeFormat_1"));
	  }

	  public void saveSettings() {
	    waitElementClickable(By.cssSelector("input.wm_button")).click();
	  }

	  public void gotoInbox() {
	    waitElementVisible(By.className("wm_accountslist_email"))
	      .findElement(By.tagName("a")).click();
	    waitElementVisible(By.cssSelector(".wm_accountslist_email a")).click();
	  }

	  // ---------------------------------
	  
	  
	  public void moveSomeMessageToTrash() {
	    WebElement inbox = driver.findElement(By.cssSelector("div.wm_message_list div.wm_inbox_lines"));
	    WebElement message = inbox.findElement(By.tagName("tr"));
	    WebElement trash = driver.findElement(By.id("layout_3pane")).findElement(By.id("5#@%Trash"));
	    new Actions(driver).moveToElement(message).clickAndHold()
	      .moveToElement(trash).release().perform();
	    sleep(3000);
	  }

	  /*public FolderAssistant openFolder(String folderName) throws Exception {
		    return new FolderAssistant(this).openFolder(folderName);
	  }*/
	    
	  public void openFolder(String folderName) {
		  List<WebElement> folders = driver.findElements(By.cssSelector("span.rtIn:nth-of-type(2)"));		
		  for (WebElement folder : folders) {
			  waitElementVisible(By.xpath("//span[contains(text(),'" + folderName + "')]"));
			  sleep(1000);
			  if (folder.getText().equals(folderName)) {
				  folder.click(); 		  
		      };
		  }
	  }

	  public void checkMail() {
	    waitElementVisible(By.cssSelector("div#layout_3pane div.wm_message_list .wm_toolbar_item")).click();
	    sleep(1000);
	  }
	  
	  public void openInbox() {
		waitElementVisible(By.xpath("//span[contains(text(),'Inbox')]")).click();
	    sleep(1000);
		
	}
	
	public int countMessages() {
		System.out.println("size "+getMessageElements().size());
	    return getMessageElements().size();
	}
	
	private List<WebElement> getMessageElements() {
		 List<WebElement> messageElements = new ArrayList<WebElement>();
		 List<WebElement> messages = driver.findElements(
			By.cssSelector("tr"));
		 	for (WebElement message : messages) {	
		 		waitElementVisible(By.cssSelector("td.rgGroupCol"));
			    if (message.getAttribute("id").startsWith("ctl00_ContentPlaceHolder2_RadGrid1_ctl00__")){
					messageElements.add(message);
				}		
			}
		    return messageElements;
		  }
	}
