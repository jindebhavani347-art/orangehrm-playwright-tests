package Page;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import constants.constants;
import util.ConfigReader;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import static org.junit.Assert.assertTrue;

public class PIMPage extends BasePage {
    public Locator addbutton;
    constants constants = new constants();
    public Locator ename;
    public Locator eid;
    public Locator dropdown;
    public Locator searchbutton;
    public Locator emfirst;
    public String emlastname;
    public Locator  deletbuttoninlist;
    public Locator editbutton;
    public Locator row;
    public Locator empid;
    public Locator emnames;
    public Locator emidfiled;
    String empId = page.url().substring(page.url().lastIndexOf("/") + 1);

    public PIMPage(Page page) {
        super(page);
        addbutton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add"));
        ename = page.getByPlaceholder("Type for hints...").first();
        eid = page.locator("//div[@class='oxd-input-group__label-wrapper']/following-sibling::div/input[@class='oxd-input oxd-input--active']");
        dropdown = page.locator("//*[@role='option']/span");
        searchbutton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("search"));

        editbutton = page.getByTestId("oxd-icon bi-pencil-fill");
          deletbuttoninlist= page.locator("xpath= //button[text()=' Yes, Delete ']");
        empid=page.locator("xpath=//div[@class='oxd-input-group__label-wrapper']/following-sibling::div/input[@class='oxd-input oxd-input--active']");
    }


    @Override
    protected String getUrl() {
        return ConfigReader.get("PIM.url");

    }

    public void click(Locator locator) {
        locator.click();


    }

    public void PIMPage(String empname) {
        ename.fill(empname);
    }

    public void PIMPage(String ename, String eid) {
        this.ename.fill(ename);
        this.eid.fill(eid);
    }

    public void search(String value) {
        dropdown.filter(new Locator.FilterOptions().setHasText(value)).click();
    }


    public void searchlist(String firstName, String lastName) {
        row = page.locator(".oxd-table-row")
                .filter(new Locator.FilterOptions().setHasText(firstName))
                .filter(new Locator.FilterOptions().setHasText(lastName));
        row.locator("i.bi-pencil-fill").click();
    }


    public void searchlistwithid(String id) {
        row = page.locator("xpath=//div[@class='oxd-table-row oxd-table-row--with-border oxd-table-row--clickable']")
                .filter(new Locator.FilterOptions().setHasText(id));
        System.out.println("Rows found: " + row.count());   // add this
        constants.waits(row);
        row.locator("i.bi-pencil-fill").click();
    }

    public void deleteemp(String id, String firstName) {
        row = page.locator("xpath=//div[@class='oxd-table-row oxd-table-row--with-border oxd-table-row--clickable']")
                .filter(new Locator.FilterOptions().setHasText(id))
                .filter(new Locator.FilterOptions().setHasText(firstName));

        System.out.println("Rows found: " + row.count());   // add this
        constants.waits(row);
       row.locator("xpath=//button[@class='oxd-icon-button oxd-table-cell-action-space']/child::i[@class='oxd-icon bi-trash']").click();
        deletbuttoninlist.click();
    }


    public int onlyelemetseacrh(String id) {
        row = page.locator("xpath=//div[@class='oxd-table-row oxd-table-row--with-border oxd-table-row--clickable']")
                .filter(new Locator.FilterOptions().setHasText(id));
        int rowcount=row.count();
        System.out.println("Rows found: " + rowcount);   // add this
        constants.waits(row);
        return rowcount;
    }

}