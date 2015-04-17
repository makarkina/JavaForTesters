package com.example.fw;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class ApplicationManager {
	
	private WebDriver driver;
	public String baseUrl;
		
	private Properties properties;
	private HibernateHelper hibernateHelper;
	private AccountHelper accountHelper;
	private MailHelper mailHelper;
	private JamesHelper jamesHelper;
	

	public ApplicationManager(Properties properties){
		this.properties = properties;
	}
			
	public void stop() {
		driver.quit();
	}
	
	public WebDriver getDriver() {
		
		String browser = properties.getProperty("browser");
		
		if (driver == null) {
			List<String> path = new ArrayList<String>();
			path.add("C:/Users/Anna/Downloads/IEDriverServer_Win32_2.45.0/IEDriverServer.exe");
			path.add("C:/Users/Anna/Downloads/chromedriver_win32/chromedriver_win32/chromedriver.exe");
			
			List<String> webDriver = new ArrayList<String>();
			webDriver.add("webdriver.ie.driver");
			webDriver.add("webdriver.chrome.driver");	
									
			if("firefox".equals(browser)){
				driver = new FirefoxDriver();
			}
			
			else if("ie".equals(browser)){
				System.setProperty(webDriver.get(0), path.get(0));
				driver = new InternetExplorerDriver();
			}
			
			else if("chrome".equals(browser)){
				System.setProperty(webDriver.get(1), path.get(1));
				driver = new ChromeDriver();
			}
			
			else{
				throw new Error("Unsupported browser" + browser);
			}
			
			baseUrl = properties.getProperty("baseUrl");
		    //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		    driver.get(baseUrl);
		}
		return driver;
	}

	public HibernateHelper getHibernateHelper() {
		if (hibernateHelper == null) {
			hibernateHelper = new HibernateHelper(this);
		}
		return hibernateHelper;
	}
	
	public AccountHelper getAccountHelper() {
		if (accountHelper == null) {
			accountHelper = new AccountHelper(this);
		}
		return accountHelper;
	}
	
	public MailHelper getMailHelper() {
		if (mailHelper == null) {
			mailHelper = new MailHelper(this);
		}
		return mailHelper;
	}
	
	public JamesHelper getJamesHelper() {
		if (jamesHelper == null) {
			jamesHelper = new JamesHelper(this);
		}
		return jamesHelper;
	}
	
	public String getProperty(String key){
		return properties.getProperty(key);
		
	}
	
}


