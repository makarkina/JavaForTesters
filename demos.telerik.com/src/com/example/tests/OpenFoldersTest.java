package com.example.tests;

import org.testng.annotations.Test;

public class OpenFoldersTest extends TestBase {
  
  @Test
  public void test1() throws Exception {
    mail.openFolder("AJAX");
    mail.countMessages();
  }
  
  @Test
  public void test2() throws Exception {
    mail.openFolder("Announcements");
    mail.countMessages();
  }
  
  @Test
  public void test3() throws Exception {
    mail.openFolder("OpenAccess ORM");
    mail.countMessages();
  }
  
  @Test
  public void test4() throws Exception {
    mail.openFolder("Silverlight");
    mail.countMessages();
  }
  
  @Test
  public void test5() throws Exception {
    mail.openFolder("WinForms");
    mail.countMessages();
  }
  
  @Test
  public void test6() throws Exception {
    mail.openFolder("WPF");
    mail.countMessages();
  }
}
