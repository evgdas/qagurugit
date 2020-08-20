import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.parameter;
import static io.qameta.allure.Allure.step;

public class YandexSearchTest {
    @Test
    @DisplayName("Поиск страницы selenide на Yandex.ru")
    public void searchSelenideInYandex() {
        parameter("Строка поиска","selenide");
        step("Открытие страницы yandex.ru", () -> {
            open("https://yandex.ru");
        });
        step("Поиск selenide в yandex", () -> {
            $("#text").val("selenide").pressEnter();});
        step("Проверка результатов поиска", () -> {
            $$(".serp-item").shouldHave(sizeGreaterThan(1));
            $("#search-result").shouldBe(visible).shouldHave(
                    text("Selenide: лаконичные и стабильные UI тесты на Java"),
                    text("selenide.org"));
        });
    }
}
