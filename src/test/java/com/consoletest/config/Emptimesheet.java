package com.consoletest.config;

import aa_setup.baseclass;
import constants.constants;
import org.junit.Test;

import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class Emptimesheet extends baseclass {
    constants constants=new constants();
@Test
    public void timesheet(){
    pageObjectManager.getEmpTimesheet().navigateTo();
    pageObjectManager.getEmpTimesheet().dempdropdown("et");
    //System.out.println("BEFORE PAUSE");
    //pageObjectManager.getEmpTimesheet().pause();
    //System.out.println("AFTER PAUSE");
    assertThat(pageObjectManager.getEmpTimesheet().submit).isVisible();
    pageObjectManager.getEmpTimesheet().submit.click();
    assertThat(page).hasURL(Pattern.compile(".*/web/index.php/time/viewTimesheet/employeeId/.*"));
}

@Test
    public void emptyname(){
    pageObjectManager.getEmpTimesheet().navigateTo();
    pageObjectManager.getEmpTimesheet().submit.click();
    //pageObjectManager.getEmpTimesheet().pause();
    assertThat(pageObjectManager.getEmpTimesheet().errormesg).isVisible();
}




}
