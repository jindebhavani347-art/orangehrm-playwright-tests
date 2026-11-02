package Page;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import constants.constants;
import util.ConfigReader;

public class EmpTimesheet extends BasePage{
    public Locator empname;
    public Locator submit;
    public Locator errormesg;
    constants constants=new constants();
    public EmpTimesheet(Page page) {
        super(page);
        empname=page.getByPlaceholder("Type for hints...");
        submit=page.locator(".oxd-form-actions")
                .getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("View"));
        errormesg = page.locator(".oxd-text.oxd-text--span.oxd-input-field-error-message.oxd-input-group__message");
    }

    public void pause() {
        page.pause();
    }
public void dempdropdown(String str){
        empname.fill(str);
        Locator Dropdown =page.getByRole(AriaRole.OPTION);
    constants.waits(Dropdown);
    Dropdown.filter(new Locator.FilterOptions().setHasText(str)).first().click();

}


    @Override
    protected String getUrl() {
        return ConfigReader.get("emplytimesheet");
    }
}
