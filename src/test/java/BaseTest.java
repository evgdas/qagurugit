import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {
    @BeforeEach
    public void initLogger() {
        Configuration.holdBrowserOpen = true;
        Configuration.startMaximized = true;
        Configuration.timeout = 6000;
        SelenideLogger.addListener("allure", new AllureSelenide()
                .savePageSource(true)
                .screenshots(true));
    }
}
