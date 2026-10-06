package aa_setup;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page;
import org.junit.*;
import org.junit.Before;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;
import Page.PageObjectManager;
import util.ConfigReader;

import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;

public class baseclass extends aa_stup {

    protected BrowserContext context;
    protected  Page page;

    protected PageObjectManager pageObjectManager;

    @Rule
    public PlaywrightTestWatcher testWatcher = new PlaywrightTestWatcher(this);


    @Before
    public void setupTest() {
        if (browser == null) {
            setupInstance();
        }
        context = browser.newContext();
        page = context.newPage();
        pageObjectManager = new PageObjectManager(page);
    }
    @Before
    public void login(){
        pageObjectManager.getLoginPage().navigateTo();
        pageObjectManager.getLoginPage().login(ConfigReader.get("admin.username"), ConfigReader.get("admin.password"));
    }
}