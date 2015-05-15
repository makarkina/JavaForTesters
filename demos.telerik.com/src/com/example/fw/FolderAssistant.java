package com.example.fw;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class FolderAssistant extends WebDriverCommons {

  private WebDriverCommons manager;

  public FolderAssistant(WebDriverCommons webMailManager) throws Exception {
    super(webMailManager.properties);
    this.manager = webMailManager;
  }

    
  /*public FolderAssistant openFolder(String folderName) throws InterruptedException {
	  System.out.println("folderName "+folderName);
	  Thread.sleep(30);
  	List<WebElement> folders = driver.findElements(
  			By.cssSelector("span.rtIn:nth-of-type(2)"));
  	Thread.sleep(20);
  		System.out.println(folders);
  		for (WebElement folder : folders) {
    	System.out.println(folder.getText());
    	//waitElementVisible(folder);
    	Thread.sleep(20);
  			if (folder.getText().equals(folderName)) {
  				folder.click(); 
  			return this;
  			};
  		}
  	
  	 throw new NoSuchElementException("No folder with name starting with " + folderName);
		
  }*/
 
  public int countMessages() {
    return getMessageElements().size();
  }

  private List<WebElement> getMessageElements() {
    return driver.findElements(
        By.cssSelector("div#layout_3pane div.wm_inbox_lines > table > tbody > tr"));
  }

  public MessageObject openMessageByIndex(int i) throws Exception {
    getMessageElements().get(i).findElements(By.tagName("td")).get(5).click();
    MessageObject messageObject = new MessageObject(manager);
    PageFactory.initElements(
        new AjaxElementLocatorFactory(driver, 30),
        messageObject);
    return messageObject;
  }

}
