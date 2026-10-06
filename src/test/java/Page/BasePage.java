package Page;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
public abstract class BasePage {
    protected Page page;

    public BasePage(Page page) {
        this.page = page;
    }
    protected abstract String getUrl();

    public void navigateTo() {
    page.navigate(getUrl());
    page.waitForLoadState(LoadState.NETWORKIDLE);
    }


}