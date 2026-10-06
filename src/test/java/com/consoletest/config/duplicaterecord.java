package com.consoletest.config;

import aa_setup.baseclass;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.assertions.LocatorAssertions;
import constants.constants;
import org.junit.Test;
import util.ConfigReader;

import java.time.LocalDateTime;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.Assert.assertTrue;

public class duplicaterecord extends baseclass {
    constants constants=new constants();
    String lastName=constants.getuniquename();
    String empName= "test" +lastName ;


     @Test
    public void duplicate(){
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
         pageObjectManager.getPIMPage().click(pageObjectManager.getPIMPage().addbutton);
         pageObjectManager.getCreatepage().entry("test", lastName);
         String empIde = pageObjectManager.getPIMPage().eid.inputValue();
          System.out.println(empIde);
         pageObjectManager.getPIMPage().eid.fill(empId);
         Locator message = page.locator("xpath=//span[text()='Employee Id already exists']");
         constants.waits(message);
         assertThat(message).isVisible();

     }


}
