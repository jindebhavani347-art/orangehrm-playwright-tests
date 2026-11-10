package com.consoletest.config;

import aa_setup.baseclass;
import com.microsoft.playwright.options.LoadState;
import constants.constants;
import org.junit.Test;
import testdata.*;
import java.util.List;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class viewdirectry extends baseclass {
    constants constants = new constants();


    @Test
    public void view() {
        pageObjectManager.getviewDirectry().navigateTo();
        String noofrecords = pageObjectManager.getviewDirectry().countofrecords.innerText();
        System.out.println(noofrecords);
        assertThat(pageObjectManager.getviewDirectry().countofrecords).isVisible();
    }

    @Test
    public void namesofrecords() {
        pageObjectManager.getviewDirectry().navigateTo();
        page.waitForLoadState(LoadState.NETWORKIDLE);
        //pageObjectManager.getviewDirectry().pause();
        pageObjectManager.getviewDirectry().noofname.first().waitFor();
        List<String> names = pageObjectManager.getviewDirectry().noofname.allInnerTexts();
        int previuscount = 0;
        int currentcount = names.size();
        while (currentcount > previuscount) {
            previuscount=currentcount;
            page.evaluate("window.scrollTo(0,document.body.scrollHeight);");
            System.out.println("Currently loaded count: " + currentcount);
            System.out.println("Total names found: " + names.size());
            for (String n : names) {
                System.out.println(n);
            }
        }
    }

    @Test
    public void searchemp(){
     pageObjectManager.getviewDirectry().navigateTo();
     pageObjectManager.getviewDirectry().entername(data.name);
        pageObjectManager.getviewDirectry().Search.click();
        constants.waits(pageObjectManager.getviewDirectry().searchrecordcount);
        assertThat(pageObjectManager.getviewDirectry().searchrecordcount).hasText("(1) Record Found");
    }



}