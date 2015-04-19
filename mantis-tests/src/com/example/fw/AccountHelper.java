package com.example.fw;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AccountHelper extends WebDriverHelperBase {

	private String url;

	public AccountHelper(ApplicationManager applicationManager) {
		super(applicationManager);
	}

	public void signUp(User user) {
		url = "mantisbt-1.2.19/signup_page.php";
		openUrl(url);
		click(By.cssSelector("span.bracket-link"));
		type(By.name("username"), user.login);
		type(By.name("email"), user.email);
		click(By.cssSelector("input.button"));
		
		WebElement errorMessage = findElement(By.cssSelector("table.width50 tbody tr td p"));
		if (errorMessage != null){
			throw new RuntimeException(errorMessage.getText());
		}
	    
		for (int i = 0; i < 3; i++) {
			pause(2000);
			String msg = manager.getMailHelper().getNewMail(user.login, user.password);
			if (! (msg == null)){
				System.out.println("login " + user.login);
				System.out.println("msg " + msg);
				String confirmationLink = getConfirmationLink(msg);
				openAbsoluteUrl(confirmationLink);
				//pause(3000);
				type(By.name("password"), user.password);
				//pause(3000);
				type(By.name("password_confirm"), user.password);
				//pause(3000);
				click(By.cssSelector("input.button"));
				break;
			}
		}
	}
	
	public String getConfirmationLink(String textMail){
		Pattern regex = Pattern.compile("http\\S*");
		Matcher matcher = regex.matcher(textMail);
		if (matcher.find()){
			return matcher.group();
		}
		else{
			return "";
		}
		
	}
	
	public void login(User user) {
			pause(3000);
			url = "/";
			openUrl(url);
			pause(2000);
			type(By.name("username"), user.login);
			type(By.name("password"), user.password);
			click(By.cssSelector("input.button"));
	}


	public String loggedUser() {
		WebElement element = findElement(By.cssSelector("td.login-info-left span"));
		System.out.println(element.getText());
		return element.getText();
	}
	

}
