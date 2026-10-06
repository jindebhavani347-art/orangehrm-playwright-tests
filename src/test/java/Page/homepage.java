package Page;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import util.ConfigReader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class homepage extends BasePage {

    public Locator name;
    public Locator prize;

    public homepage(Page page) {
        super(page);
        name = page.locator("xpath=//p[@class=\"chakra-text css-1t2wuip\"]");
        prize = page.locator("xpath=//p[@class=\"chakra-text css-1uo1lkf\"]");
    }

    List<String> productName =name.allInnerTexts();
    List<String> productprize =prize.allInnerTexts();

 public void print(int num){
     String name=productName.get(num);
     String prize=productprize.get(num);
     System.out.println(name + " " +prize);
 }
    @Override
    protected String getUrl() {
        ConfigReader.get("stockur.url");
        return null;
    }
}
