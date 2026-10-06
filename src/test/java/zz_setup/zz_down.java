package zz_setup;
import aa_setup.aa_stup;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;
//import org.testng.annotations.Test;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import static aa_setup.aa_stup.browser;
import static aa_setup.aa_stup.playwright;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
public class zz_down {
    @AfterClass
    public static void teardownInstance() {
        System.out.println("=== [3/3] Closing Browser and Stopping Playwright ===");
        if (browser != null) browser.close();
        if (playwright != null) playwright.close();
        System.out.println("=== Instance Teardown Complete ===");
    }
}
