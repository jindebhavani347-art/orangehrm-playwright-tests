package constants;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.WaitForSelectorState;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;



public class constants {

    public String lname;

    public String getuniquename() {

        this.lname = String.valueOf(LocalTime.now());

        return lname;
    }

    public void waits(Locator locator) {
        locator.waitFor(new Locator.WaitForOptions()
                .setState(WaitForSelectorState.VISIBLE)
                .setTimeout(3000));
    }


    public static String date() {
        DateTimeFormatter formate = DateTimeFormatter.ofPattern("hhmmssSS");
        String time=LocalTime.now().format(formate);


        return time;
    }
}