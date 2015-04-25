package com.tests.fw;

import java.util.Properties;
import org.openqa.selenium.WebDriver;

public class AppManager {
	
	public WebDriver driver;
	public String version;
	public String platform;
	public Properties properties;
	
	public AppManager(Properties properties) {
		this.properties = properties;
		
	}

	public String getBaseUrl(String baseUrl) {
		return properties.getProperty("baseUrl");
	}
		
	public String getWebBrowser(String webBrowser) {
		return properties.getProperty("browser");
	}

	public String getWebBrowserVersion(String webBrowserVersion) {
		return properties.getProperty("version");
	}

	public String getPlatform(String platformForTests) {
		System.out.println("platform " + properties.getProperty("platform"));
		return properties.getProperty("platform");
	}
	
	public String getWebPageTitle(String page) {
		System.out.println("title " + driver.getTitle());
		return driver.getTitle();
	}
	
	public void stop() {
		driver.quit();
	}
	
}
