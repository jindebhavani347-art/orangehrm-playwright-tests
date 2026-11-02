package com.consoletest.config;

import Page.PageObjectManager;
import aa_setup.baseclass;
import com.microsoft.playwright.Locator;
import org.junit.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.Assert.assertEquals;

public class Systemuser extends baseclass {


    @Test
    public void countofrecords() {
        pageObjectManager.getsystemuser().navigateTo();
    String recordcounts= pageObjectManager.getsystemuser().recordcount.innerText();
     assertThat(pageObjectManager.getsystemuser().recordcount).containsText("Records Found");
    }

@Test
    public void searchbyname(){
        pageObjectManager.getsystemuser().navigateTo();
    String emp = pageObjectManager.getsystemuser().recordsintable();
        pageObjectManager.getsystemuser().serachthroughempname(emp);
        pageObjectManager.getsystemuser().serach.click();
        assertThat(pageObjectManager.getsystemuser().recordcount).containsText("Records Found");
}
@Test
    public void negitivesearch(){
        pageObjectManager.getsystemuser().navigateTo();
        pageObjectManager.getsystemuser().username.fill("e");
        pageObjectManager.getsystemuser().serach.click();
        assertThat(page.locator("xpath=//span[@class='oxd-text oxd-text--span']/parent::div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']")).isVisible();

}

}