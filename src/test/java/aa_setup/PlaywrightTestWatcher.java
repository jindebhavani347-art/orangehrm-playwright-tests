package aa_setup;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

import java.nio.file.Paths;

public class PlaywrightTestWatcher extends TestWatcher {

    private final baseclass testInstance;

    public PlaywrightTestWatcher(baseclass testInstance) {
        this.testInstance = testInstance;
    }

        @Override
        protected void failed(Throwable e, Description d) {
            Page page = testInstance.page;
            try {
                if (page != null && !page.isClosed()) {
                    page.screenshot(new Page.ScreenshotOptions()
                            .setPath(Paths.get("./target/screenshot-" + d.getMethodName() + "-FAILED.png"))
                            .setFullPage(true));
                    System.out.println("FAILED: " + d.getMethodName() + " — screenshot saved");
                } else {
                    System.out.println("FAILED: " + d.getMethodName() + " — page/context already closed, skipping screenshot");
                }
            } catch (Exception ex) {
                System.out.println("Screenshot capture failed: " + ex.getMessage());
            }
        }

        @Override
        protected void finished(Description d) {
            BrowserContext context = testInstance.context;
            if (context != null) {
                context.close();
            }
        }
    }







