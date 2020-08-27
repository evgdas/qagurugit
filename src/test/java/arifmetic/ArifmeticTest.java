package arifmetic;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.qameta.allure.Allure.parameter;
import static io.qameta.allure.Allure.step;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

@Owner("evgdas")
@Feature("Работа с Jenkins")
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class ArifmeticTest {
    static Logger logger = LoggerFactory.getLogger(ArifmeticTest.class);
    @Test
    @DisplayName("Проверка умножения")
    @Tag("multiple_test")
    public void checkMultiple() {
        String a = System.getProperty("valA", "0");
        String b = System.getProperty("valB", "0");
        int c=Integer.parseInt(a) * Integer.parseInt(b);
        logger.info("valA= "+a);
        logger.info("valB= "+b);
        logger.info("result= "+c);
        parameter("Множитель а", a);
        parameter("Множитель b", b);
        step("Проверка результатов операции", () -> {
           parameter("Результат c", c);
           assertThat(c,greaterThan(0));
        });
    }

    @Test
    @DisplayName("Проверка сложения")
    @Tag("plus_test")
    public void isRightPlus() {
        String a = System.getProperty("valA", "0");
        String b = System.getProperty("valB", "0");
        int c=Integer.parseInt(a) + Integer.parseInt(b);
        logger.info("valA= "+a);
        logger.info("valB= "+b);
        logger.info("result= "+c);
        parameter("Слагаемое а", a);
        parameter("Слагаемое b", b);
        step("Проверка результатов операции", () -> {
            parameter("Результат c", c);
            assertThat(c,greaterThan(0));
        });
    }

}