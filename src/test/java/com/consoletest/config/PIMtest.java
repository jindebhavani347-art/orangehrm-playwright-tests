package com.consoletest.config;

import Page.PageObjectManager;
import aa_setup.baseclass;
import org.junit.Test;
import util.ConfigReader;

import static org.junit.Assert.assertTrue;

public class PIMtest extends baseclass {

    @Test
            public void pimtest() {
        pageObjectManager.getLoginPage().navigateTo();
        pageObjectManager.getLoginPage().login(ConfigReader.get("admin.username"), ConfigReader.get("admin.password"));
        pageObjectManager.getPIMPage().navigateTo();
        pageObjectManager.getPIMPage().click(pageObjectManager.getPIMPage().addbutton);
        assertTrue(page.url().contains("addEmployee"));

    }
}


