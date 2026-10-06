package Page;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import constants.constants;
import util.ConfigReader;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ApplyLeave extends BasePage{
    constants constants=new constants();
public Locator empname;
public Locator empdropdown;
public Locator leavetypebutton;
public Locator leavetypedropdown;
public Locator fromdate;
public Locator todate;
public Locator durationbutton;
public Locator submit;

    public ApplyLeave(Page page) {
        super(page);
              empname= page.getByPlaceholder("Type for hints...");
            empdropdown=  page.getByRole(AriaRole.OPTION);
            leavetypebutton=page.locator("xpath=//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow']");
            leavetypedropdown=page.getByRole(AriaRole.OPTION);
        fromdate = page.getByPlaceholder("yyyy-dd-mm").first();
        todate   = page.getByPlaceholder("yyyy-dd-mm").nth(1);
            durationbutton= page.locator("xpath=//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow']/parent::div[@class='oxd-select-text--after']").nth(2);
            submit= page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Assign"));
    }

        public void empname(String name){
            empname.fill(name);
            constants.waits(empdropdown);
            page.getByRole(AriaRole.OPTION).filter(new Locator.FilterOptions().setHasText(name)).first().click();

        }
    public void leavedropdown(String leave){
        page.locator("xpath=//div[@role='option']").filter(new Locator.FilterOptions().setHasText(leave)).click();
    }

public void durationdropdown(String duration){
    constants.waits(page.getByRole(AriaRole.LISTBOX));
    page.getByRole(AriaRole.OPTION).filter(new Locator.FilterOptions().setHasText(duration)).click();

}

 public void popup(){
        page.onDialog(dialog -> {
            dialog.accept();
        });

 }
    @Override
    protected String getUrl() {
        return ConfigReader.get("applyleave");
    }
}
