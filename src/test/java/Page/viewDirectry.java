package Page;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import constants.constants;
import util.ConfigReader;

import java.util.regex.Pattern;

public class viewDirectry extends BasePage{
    constants constants=new constants();
    public Locator countofrecords;
    public Locator searchrecordcount;
    public Locator noofname;
    public Locator Empname;
    public Locator Search;
    public viewDirectry(Page page) {
        super(page);
        countofrecords=page.locator(".oxd-text--span").getByText(Pattern.compile(".*Records Found.*"));
      noofname=page.locator("xpath=//p[@class='oxd-text oxd-text--p orangehrm-directory-card-header --break-words']");
Empname=page.getByPlaceholder("Type for hints...").first();
  Search=page.getByText(" Search ");
  searchrecordcount=page.locator("xpath=//span[@class='oxd-text oxd-text--span']");
    }

public void pause(){
        page.pause();
}

public void entername(String empname){
    Empname.fill(empname);
 page.getByRole(AriaRole.OPTION).filter(new Locator.FilterOptions().setHasText(empname)).first().click();

}

    @Override
    protected String getUrl() {
        return ConfigReader.get("viewdirectry");
    }
}
