package com.example.tests;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.example.fw.ApplicationManager;

public class Sample {

	public static void main(String[] args) throws FileNotFoundException,
			IOException {

		Properties properties = new Properties();
		properties.load(new FileReader("application.properties"));
		ApplicationManager appl = new ApplicationManager(properties);
		System.out.println(appl.getHibernateHelper().listGroups());
	}

}
