package Page;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import java.util.regex.Pattern;

import com.microsoft.playwright.options.AriaRole;
import constants.constants;
import util.ConfigReader;

public class systemuser extends BasePage{
    constants constants=new constants();
    public Locator recordcount;
    public Locator dropdown;
    public Locator empnamev;
    public Locator serach;
    public Locator username;
    public systemuser(Page page) {
        super(page);
        recordcount =page.getByText(Pattern.compile("\\(\\d+\\) Records Found"));
        empnamev=page.getByPlaceholder("Type for hints...");
        dropdown=page.getByRole(AriaRole.OPTION);
       serach= page.getByRole(AriaRole.BUTTON , new Page.GetByRoleOptions().setName(" Search "));
       username=page.locator("xpath=//label[text()='Username']/ancestor::div[@class='oxd-input-group oxd-input-field-bottom-space']//input");

    }

  public void serachthroughempname(String empname){
    empnamev.fill(empname);
    constants.waits(dropdown);
      String[] sname=empname.trim().split("\\s+");
     String first =sname[0];
    page.getByRole(AriaRole.OPTION).filter(new Locator.FilterOptions().setHasText(first)).first().click();
  }

public String recordsintable(){

        String empname=page.locator("//div[@class='oxd-table-row oxd-table-row--with-border'][1]//div[@class='oxd-table-cell oxd-padding-cell'][4]").first().innerText();
return empname;
    }

    @Override
    protected String getUrl() {
        return ConfigReader.get("system_user.url");

    }
}
