package com.example.tests;

public class WebDriverProperties {
	private String browserName;
	private String webDriver;
	private String path;

	public WebDriverProperties() {

	}

	public WebDriverProperties(String browserName, String webDriver, String path) {
		this.browserName = browserName;
		this.webDriver = webDriver;
		this.path = path;
	}

	public String getBrowserName() {
		return browserName;
	}

	public String getWebDriver() {
		return webDriver;
	}

	public String getPath() {
		return path;
	}
}