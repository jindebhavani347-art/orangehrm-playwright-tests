package Page;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class Upadatepage extends BasePage{
public Locator genderbuttonfemale;
public Locator savebutton;
    public Upadatepage(Page page) {
        super(page);
        genderbuttonfemale=page.getByText("Female");
        savebutton=page.locator("xpath=//p[text()=' * Required']/following-sibling::button");
    }

    public void genderselection(){
        genderbuttonfemale.click();
    }
public void setSavebutton(){
        savebutton.click();
}



    @Override
    protected String getUrl() {
        return null;
    }
}
