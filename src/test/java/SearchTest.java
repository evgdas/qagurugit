import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.parameter;
import static io.qameta.allure.Allure.step;

@Owner("evgdas")
@Feature("Работа с git")
public class SearchTest extends BaseTest {
    @Test
    @DisplayName("Поиск страницы selenide на Google.com")
    public void searchSelenideInGoogle() {
        parameter("Строка поиска","selenide");
        
        step("Открытие страницы google.com", () -> {
            open("https://google.com");
        });
        step("Поиск selenide в google", () -> {
            $(By.name("q")).val("selenide").pressEnter();});
        step("Проверка результатов поиска", () -> {
            $$("#res .g").shouldHave(sizeGreaterThan(1));
            $("#res .g").shouldBe(visible).shouldHave(
                    text("Selenide: лаконичные и стабильные UI тесты на Java"),
                    text("selenide.org"));
        });
    }

}
