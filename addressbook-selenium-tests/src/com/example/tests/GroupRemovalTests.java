package com.example.tests;

import org.testng.annotations.Test;

public class GroupRemovalTests extends TestBase{

@Test
	public void deleteSomeGroup(){
		appl.getNavigationHelper().openMainPage();
		appl.getNavigationHelper().gotoGroupPage();
		appl.getGroupHelper().deleteGroup(1);
		appl.getGroupHelper().returnToGroupsPage();
	}
}
