package Page;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import util.ConfigReader;

public class Createcontactpage extends BasePage{

public Locator Firstname;
    public Locator Lastname;
    public Locator save;
    public Locator emid;
    public Createcontactpage(Page page) {
        super(page);
        Firstname=page.getByPlaceholder("First Name");
        Lastname= page.getByPlaceholder("Last Name");
        save=page.getByRole(AriaRole.BUTTON,new Page.GetByRoleOptions().setName("save"));
        emid  =page.getByTestId("oxd-input oxd-input--active");
    }


    public void entry(String firstname,String lastname ){
        Firstname.fill(firstname);
        Lastname.fill(lastname);

    }

    @Override
    protected String getUrl() {
        ConfigReader.get("create.url");
        return null;
    }
}
