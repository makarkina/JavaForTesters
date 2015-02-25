package com.example.tests;
import org.testng.annotations.Test;

public class GroupModificationTests extends TestBase {
	
	@Test
		public void modifySomeGroup() {
		
			appl.getNavigationHelper().openMainPage();
			appl.getNavigationHelper().gotoGroupPage();
			appl.getGroupHelper().initGroupModification(1);
			GroupData group = new GroupData();
			group.name = "new name";
			appl.getGroupHelper().fillGroupForm(group);
			appl.getGroupHelper().submitGroupModification();
			appl.getGroupHelper().returnToGroupsPage();
		}
	}

