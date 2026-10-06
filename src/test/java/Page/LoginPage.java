package Page;
import util.ConfigReader;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LoginPage  extends BasePage{

    private final Locator userName;
    private final Locator password;
    private final Locator loginButton;
    private final Locator errorMessage;

    public LoginPage(Page page) {
        super(page);
        userName = page.locator("input[name=\"username\"]");
        password = page.locator("input[name=\"password\"]");
        loginButton = page.locator("button[type=\"submit\"]");
        errorMessage = page.locator(".oxd-alert-content-text");
    }

    @Override
    protected String getUrl() {
        return ConfigReader.get("base.url");

    }

    public void login(String user_Id, String Password) {
            userName.fill(user_Id);
            password.fill(Password);
            loginButton.click();//this are coming from config class
    }

    public String getErrorMessage() {
        return null;
    }
}