package Page;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import util.ConfigReader;

import java.time.LocalDateTime;

public class leavepage extends BasePage {
    public Locator Entitlementsbutton;
 public Locator applyleave;
    public leavepage(Page page) {
        super(page);
        Entitlementsbutton=page.locator("xpath=//span[normalize-space()='Entitlements']");
        applyleave=page.getByText("Assign Leave");
    }

    public void clickentitlementdropdown(){
        Entitlementsbutton.click();
    }

    public void entitelmentdropdown(String input){
        page.locator("//ul[@class='oxd-dropdown-menu']//a[@role='menuitem']").filter(new Locator.FilterOptions().setHasText(input)).click();

    }


    @Override
    protected String getUrl() {
        return ConfigReader.get("leave.url");
    }

}
