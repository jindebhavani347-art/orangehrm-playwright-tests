package com.consoletest.config;


import Page.LoginPage;
import aa_setup.baseclass;
import util.ConfigReader;
import org.junit.Test;
import static org.junit.Assert.*;
import aa_setup.baseclass;

public class logintest  extends baseclass {
 @Test
    public void login(){
     pageObjectManager.getLoginPage().navigateTo();
     pageObjectManager.getLoginPage().login(ConfigReader.get("admin.username"),ConfigReader.get("admin.password"));
     assertTrue(page.url().contains("dashboard"));
 }
}
