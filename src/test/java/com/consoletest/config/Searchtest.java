package com.consoletest.config;

import aa_setup.baseclass;
import com.microsoft.playwright.Locator;
import util.ConfigReader;
import constants.constants;
import aa_setup.baseclass;
import constants.constants;
import org.junit.Test;
import util.ConfigReader;

import java.awt.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Searchtest extends baseclass {
    constants constants = new constants();
    String lastName = constants.date();
    String empName = "test " + lastName;


    @Test
            public void searchwithid() {
       // String empId = page.url().substring(page.url().lastIndexOf("/") + 1);
        pageObjectManager.getLoginPage().navigateTo();
        pageObjectManager.getLoginPage().login(ConfigReader.get("admin.username"), ConfigReader.get("admin.password"));
        pageObjectManager.getPIMPage().navigateTo();
        pageObjectManager.getPIMPage().click(pageObjectManager.getPIMPage().addbutton);
        pageObjectManager.getCreatepage().entry("test", lastName);
        String empId = page.locator("xpath=//div[@class='oxd-input-group__label-wrapper']/following-sibling::div/input[@class='oxd-input oxd-input--active']").inputValue();
        System.out.println("Captured empId: " + empId);
        pageObjectManager.getCreatepage().save.click();
        page.waitForURL("**/web/index.php/pim/viewPersonalDetails/empNumber/**");
        assertTrue(page.url().contains("/viewPersonalDetails/empNumber/"));
        pageObjectManager.getPIMPage().navigateTo();
             pageObjectManager.getPIMPage().eid.fill(empId);
        constants.waits(pageObjectManager.getPIMPage().searchbutton);
        pageObjectManager.getPIMPage().click(pageObjectManager.getPIMPage().searchbutton);
        page.evaluate("window.scrollBy(0,400)");
       pageObjectManager.getPIMPage().searchlistwithid(empId);
        assertTrue(page.url().contains("/viewPersonalDetails/empNumber"));
    }


}
