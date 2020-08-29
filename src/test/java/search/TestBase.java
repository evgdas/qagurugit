package search;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;

import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;
import static search.helpers.AttachmentsHelper.*;
import static search.helpers.DriverHelper.*;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class TestBase {
    @BeforeAll
    public static void beforeAll() {
        configureSelenide();
        SelenideLogger.addListener("allure", new AllureSelenide()
                .savePageSource(true)
                .screenshots(true));
    }

    @AfterEach
    public void afterEach() {
        String sessionId = getSessionId();

        attachScreenshot("Last screenshot");
        attachPageSource();
        attachAsText("Browser console logs", getConsoleLogs());
        closeWebDriver();

        attachVideo(sessionId); // in browserstack video url generates after driver close
    }
}
