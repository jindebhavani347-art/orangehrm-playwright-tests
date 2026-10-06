package aa_setup;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;
//import org.testng.annotations.Test;
public class aa_stup {
    public static Playwright playwright;
    public static Browser browser;

    @BeforeClass
    public static void setupInstance() {
        System.out.println("=== [1/3] AA_SetupIT: Booting Playwright & Launching Browser ===");

        playwright = Playwright.create();
        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(false)
        );

        System.out.println("=== Instance Ready for Integration Tests ===");
    }

}
