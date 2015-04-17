package com.example.fw;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;

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
	    
		pause(3000);
		
		String msg = manager.getMailHelper().getNewMail(user.login, user.password);
		System.out.println("login " + user.login);
		System.out.println("msg " + msg);
		String confirmationLink = getConfirmationLink(msg);
		openAbsoluteUrl(confirmationLink);
		
		type(By.name("password"), user.password);
		type(By.name("password_confirm"), user.password);
		click(By.cssSelector("input.button"));
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

	public boolean isLogged(User user) {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}
