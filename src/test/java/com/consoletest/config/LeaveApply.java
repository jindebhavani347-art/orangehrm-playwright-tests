package com.consoletest.config;

import aa_setup.baseclass;
import com.microsoft.playwright.Locator;
import constants.constants;
import org.junit.Assert;
import org.junit.Test;
import util.ConfigReader;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LeaveApply extends baseclass {
    constants constants = new constants();
    @Test
    public  void leaveapplyentitelment(){
        pageObjectManager.getLoginPage().navigateTo();
        pageObjectManager.getLoginPage().login(ConfigReader.get("admin.username"),ConfigReader.get("admin.password"));
        pageObjectManager.getLeavepage().navigateTo();
        pageObjectManager.getLeavepage().clickentitlementdropdown();
        pageObjectManager.getLeavepage().entitelmentdropdown("Add Entitlements");
        page.waitForURL("**/web/index.php/leave/addLeaveEntitlement");
        assertTrue(page.url().contains("/web/index.php/leave/addLeaveEntitlement"));
        pageObjectManager.getaddLeaveEntitlement().empname("test");
        pageObjectManager.getaddLeaveEntitlement().setLeavetypedropdown("CAN - Personal");
        pageObjectManager.getaddLeaveEntitlement().setLeaveperiod("2020-01-01 - 2020-31-12");
        pageObjectManager.getaddLeaveEntitlement().Entitlementdays(1);
       pageObjectManager.getaddLeaveEntitlement().savebutton();
       pageObjectManager.getaddLeaveEntitlement().conformationpopup();
       page.waitForURL("**/web/index.php/leave/viewLeaveEntitlements?empNumber**");
       String records=page.locator("xpath=//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']/span").innerText();
      assertThat(page.locator("xpath=//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']/span")).hasText(records);
    }



    @Test
    public void negleavepage(){

          //  pageObjectManager.getLoginPage().navigateTo();
           // pageObjectManager.getLoginPage().login(ConfigReader.get("admin.username"),ConfigReader.get("admin.password"));
            pageObjectManager.getLeavepage().navigateTo();
            pageObjectManager.getLeavepage().clickentitlementdropdown();
            pageObjectManager.getLeavepage().entitelmentdropdown("Add Entitlements");
            page.waitForURL("**/web/index.php/leave/addLeaveEntitlement");
            assertTrue(page.url().contains("/web/index.php/leave/addLeaveEntitlement"));
            pageObjectManager.getaddLeaveEntitlement().empname("Charles");
            pageObjectManager.getaddLeaveEntitlement().savebutton();
            Locator errormessage=page.locator("//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']/parent::div[@class='oxd-input-group oxd-input-field-bottom-space']").first();
        assertThat(errormessage).isVisible();
    }
}
