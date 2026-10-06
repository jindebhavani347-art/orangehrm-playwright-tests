package Page;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import constants.constants;
import util.ConfigReader;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class addLeaveEntitlement extends BasePage{

    public Locator empnamfield;
    public Locator leavetypedropdown;
    public Locator leaveperiod;
    public Locator Entitlement;
    public Locator Savebutton;
    public Locator conformationpopup;
    constants constants=new constants();

    public addLeaveEntitlement(Page page) {
        super(page);
        empnamfield= page.locator("xpath=//div[@class='oxd-autocomplete-text-input--before']/following-sibling::input");
        leavetypedropdown=page.locator("xpath=//div[@class='oxd-select-text--after']").first();
        leaveperiod= page.locator("(//i[contains(@class, 'oxd-select-text--arrow')])[2]");
        Entitlement =page.locator("xpath=//label[text()='Entitlement']/parent::div/following-sibling::div//input");
        Savebutton=page.getByText(" Save ");
        conformationpopup=page.getByText(" Confirm ");
    }

public void empname(String emp){

        Locator namefield=page.locator("xpath=//div[@class='oxd-autocomplete-text-input--before']/following-sibling::input[@placeholder='Type for hints...']");
       assertThat(namefield).isEnabled();
        namefield.fill(emp);
        constants.waits(page.locator("xpath=//div[@role='option']"));
    page.locator("xpath=//div[@role='option']").filter(new Locator.FilterOptions().setHasText(emp)).first().click();
}
public void setLeavetypedropdown(String leavetype){
    leavetypedropdown.click();
    constants.waits(page.locator("xpath=//div[@role='option']/span[text()='"+ leavetype + "']"));
   page.locator("xpath=//div[@role='option']/span[text()='CAN - Personal']").filter(new Locator.FilterOptions().setHasText(leavetype)).click();

}

public void setLeaveperiod(String leavedate){
        leaveperiod.click();
    constants.waits(page.locator("xpath=//div[@role='option']/span[text()='" + leavedate + "']"));
        page.locator("xpath=//div[@role='option']/span[text()='" + leavedate + "']").filter(new Locator.FilterOptions().setHasText(leavedate)).click();
}

public void Entitlementdays(int days){
    Entitlement.fill(Integer.toString(days));
}
public void savebutton(){
    Savebutton.click();
}

public void conformationpopup(){
    constants.waits(conformationpopup);
    conformationpopup.click();
}
    @Override
    protected String getUrl() {
        return ConfigReader.get("leave.entitlement.url");
    }
}
