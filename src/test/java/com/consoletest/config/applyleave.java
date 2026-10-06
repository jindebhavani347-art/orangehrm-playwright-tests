package com.consoletest.config;

import aa_setup.baseclass;
import org.junit.Test;
import util.ConfigReader;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;


public class applyleave extends baseclass {
    @Test
    public void leave(){
        //pageObjectManager.getLoginPage().navigateTo();
        //pageObjectManager.getLoginPage().login(ConfigReader.get("admin.username"),ConfigReader.get("admin.password"));
        pageObjectManager.getLeavepage().navigateTo();
        pageObjectManager.getApplyLeave().navigateTo();
        pageObjectManager.getApplyLeave().empname("te");
        pageObjectManager.getApplyLeave(). leavetypebutton.click();
        pageObjectManager.getApplyLeave().leavedropdown("CAN - FMLA");
        assertThat(pageObjectManager.getApplyLeave().fromdate).isEditable();
        pageObjectManager.getApplyLeave().fromdate.fill("2026-09-09");
       pageObjectManager.getApplyLeave().todate.clear();
        pageObjectManager.getApplyLeave().todate.fill("2026-09-10");
      pageObjectManager.getApplyLeave().submit.click();
        pageObjectManager.getApplyLeave().popup();
    }


}
