package com.consoletest.config;

import Page.PageObjectManager;
import aa_setup.baseclass;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.WaitForSelectorState;
import constants.constants;
import org.junit.Test;
import util.ConfigReader;

import java.time.LocalDateTime;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.Assert.assertTrue;

public class createcontact extends baseclass {
    constants constants=new constants();

    @Test
    public void create(){
        //pageObjectManager.getLoginPage().navigateTo();
        //pageObjectManager.getLoginPage().login(ConfigReader.get("admin.username"),ConfigReader.get("admin.password"));
        pageObjectManager.getPIMPage().navigateTo();
        pageObjectManager.getPIMPage().click( pageObjectManager.getPIMPage().addbutton);
        assertTrue(page.url().contains("/pim/addEmployee"));
       pageObjectManager.getCreatepage().entry("t"+ LocalDateTime.now(),constants.getuniquename());
        pageObjectManager.getCreatepage().save.click();
       page.waitForURL("**/web/index.php/pim/viewPersonalDetails/**");
        assertTrue(page.url().contains("viewPersonalDetails"));
        }


}
