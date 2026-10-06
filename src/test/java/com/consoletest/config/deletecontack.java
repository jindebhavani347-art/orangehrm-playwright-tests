package com.consoletest.config;

import aa_setup.baseclass;
import constants.constants;
import org.junit.Test;
import util.ConfigReader;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class deletecontack extends baseclass {
    constants constants = new constants();
    String lastName = constants.date();
    String empName = "test " + lastName;

    @Test
            public void delete() {
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
        pageObjectManager.getPIMPage().PIMPage(empName,empId);
        constants.waits(pageObjectManager.getPIMPage().searchbutton);
        pageObjectManager.getPIMPage().click(pageObjectManager.getPIMPage().searchbutton);
        page.evaluate("window.scrollBy(0,400)");
        int rowcount =pageObjectManager.getPIMPage().onlyelemetseacrh(empId);
       assertEquals(0,rowcount);
    }


}
