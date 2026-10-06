package com.consoletest.config;

import aa_setup.baseclass;
import constants.constants;
import org.junit.Test;
import util.ConfigReader;


import java.time.LocalDateTime;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.Assert.assertTrue;

public class Update extends baseclass {
    constants constants=new constants();

@Test
    public void updateemp() throws InterruptedException {
    String lastName = constants.date();
    String empName = "test " + lastName;
    pageObjectManager.getLoginPage().navigateTo();
    pageObjectManager.getLoginPage().login(ConfigReader.get("admin.username"), ConfigReader.get("admin.password"));
    pageObjectManager.getPIMPage().navigateTo();
    pageObjectManager.getPIMPage().click( pageObjectManager.getPIMPage().addbutton);
    //pageObjectManager.getCreatepage().entry("test","constants.date()");
    pageObjectManager.getCreatepage().entry("test",lastName);
    //pageObjectManager.getCreatepage().emid.fill(constants.date());
    pageObjectManager.getCreatepage().save.click();
    page.waitForURL("**/web/index.php/pim/viewPersonalDetails/**");
    assertTrue(page.url().contains("viewPersonalDetails"));
    pageObjectManager.getPIMPage().navigateTo();
   pageObjectManager.getPIMPage().PIMPage(empName);
    constants.waits(pageObjectManager.getPIMPage().dropdown.first());
    pageObjectManager.getPIMPage().search(empName);
   pageObjectManager.getPIMPage().click(pageObjectManager.getPIMPage().searchbutton);
   page.evaluate("window.scrollBy(0,400)");
   pageObjectManager.getPIMPage().searchlist("test",lastName);
    assertTrue(page.url().contains("pim/viewPersonalDetails/empNumber"));
    pageObjectManager.getUpadatepage().genderselection();
    pageObjectManager.getUpadatepage().setSavebutton();
  constants.waits(pageObjectManager.getUpadatepage().genderbuttonfemale);
    assertThat(pageObjectManager.getUpadatepage().genderbuttonfemale).isChecked();


}





}
