package com.tests.logic1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.tests.model.User;

public class UserDataGenerator {
	public static List<User> loadUsersFromCsvFile(File file) throws IOException {
		List<User> listUsers = new ArrayList<User>();
		FileReader reader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(reader);
		String line = bufferedReader.readLine();
		while(line != null) {
			String[] part = line.split(",");
			User users = new User();
			users.setUserName(part[0]);
			users.setPassword(part[1]);
			listUsers.add(users);
		line = bufferedReader.readLine();
		}
		reader.close();
		return listUsers;
	}

}
