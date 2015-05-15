package com.example.tests;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.example.fw.WebMailManager;

public class TestBase {

  protected WebMailManager mail;

  @BeforeTest
  @Parameters({"configFile"})
  public void setUp(@Optional String configFile) throws Exception {
    if (configFile == null) {
      configFile = System.getProperty("configFile", "config.properties");
    }
    Properties properties = new Properties();
    try {
      properties.load(new FileReader(new File(configFile)));
    	} catch (IOException e) {
    }
    	mail = new WebMailManager(properties);
    	mail.openMainPage();
  }
  
  
  @AfterTest
  public void tearDown() throws Exception {
	  	mail.quit();
  }

  
  
}
