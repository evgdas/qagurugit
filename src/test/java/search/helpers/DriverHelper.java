package search.helpers;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;

import static org.openqa.selenium.logging.LogType.BROWSER;

public class DriverHelper {

    public static void configureSelenide() {
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 6000;
        Configuration.headless = true;
        Configuration.browser = "chrome";
    }

    public static String getConsoleLogs() {
        return String.join("\n", Selenide.getWebDriverLogs(BROWSER));
    }
}